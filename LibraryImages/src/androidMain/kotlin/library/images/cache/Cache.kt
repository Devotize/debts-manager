package library.images.cache

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Environment
import android.os.Environment.isExternalStorageRemovable
import android.util.LruCache
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asAndroidBitmap
import androidx.compose.ui.graphics.asImageBitmap
import com.jakewharton.disklrucache.DiskLruCache
import io.github.aakira.napier.Napier
import library.images.initializer.LOG_TAG
import library.images.initializer.pergamon
import java.io.File
import java.io.InputStream
import java.nio.ByteBuffer

actual class PlatformInMemoryCache : ImageCacheInteractor {

    private val lruCache: LruCache<String, ImageBitmap>

    init {
        val maxMemory = (Runtime.getRuntime().maxMemory() / 1024).toInt() //stored in kilobytes
        val cacheSize = maxMemory / 8
        lruCache = object : LruCache<String, ImageBitmap>(cacheSize) {
            override fun sizeOf(key: String?, value: ImageBitmap): Int {
                // The cache size will be measured in kilobytes rather than
                // number of items.
                return value.asAndroidBitmap().byteCount
            }
        }
    }

    override fun putImage(key: String, model: ImageBitmap) {
        lruCache.put(key, model)
    }

    override fun findImage(key: String): ImageBitmap? =
        lruCache.get(key)

}

actual class PlatformDiskCache : ImageCacheInteractor {

    actual companion object {
        private const val DISK_CACHE_SIZE = 1024 * 1024 * 100 // 100MB
        private const val DISK_CACHE_SUBDIR = "thumbnails"

        private var instance: PlatformDiskCache? = null
        actual fun getInstance(): PlatformDiskCache {
            if (instance != null) error("Instance of PlatformDiskCache already created")
            return PlatformDiskCache().also {
                instance = it
            }
        }
    }

    private val diskLruCache: DiskLruCache

    init {
        val cacheDir = getDiskCacheDir(pergamon.appContext)
        diskLruCache = DiskLruCache.open(
            cacheDir,
            1,
            1,
            DISK_CACHE_SIZE.toLong()
        ) //TODO full research how lru cache works
    }


    override fun putImage(key: String, model: ImageBitmap) {
        try {
            val editor = diskLruCache.edit(key)
            val byteArray = model.asAndroidBitmap().toByteArray()
            val outputStream = editor.newOutputStream(0)
            outputStream.write(byteArray)
            outputStream.close()
            editor.commit()
            Napier.i(tag = LOG_TAG) { "Successfully put image with key: $key to disk cache" }
        } catch (e: Exception) {
            Napier.e(tag = LOG_TAG) { "Caught error while trying to put image to disk cache, reason: ${e.localizedMessage}" }
        }

    }

    override fun findImage(key: String): ImageBitmap? {
        val result = try {
            val editor = diskLruCache.edit(key)
            val baseOs: InputStream? = editor.newInputStream(0)
            baseOs?.toComposeBitmap().also {
                if (it != null) {
                    Napier.i(tag = LOG_TAG) { "Successfully extracted image with key: $key from disk cache" }
                } else {
                    Napier.i(tag = LOG_TAG) { "Image with key: $key not found in disk cache" }
                }
            }
        } catch (e: Exception) {
            Napier.e(tag = LOG_TAG) { "Caught error while trying to extract image from disk cache, reason: ${e.localizedMessage}" }
            null
        }
        return result
    }

    // Creates a unique subdirectory of the designated app cache directory. Tries to use external
    // but if not mounted, falls back on internal storage.
    private fun getDiskCacheDir(context: Context): File {
        // Check if media is mounted or storage is built-in, if so, try and use external cache dir
        // otherwise use internal cache dir
        val cachePath =
            if (Environment.MEDIA_MOUNTED == Environment.getExternalStorageState()
                || !isExternalStorageRemovable()
            ) {
                context.externalCacheDir?.path
            } else {
                context.cacheDir.path
            }

        return File(cachePath + File.separator + DISK_CACHE_SUBDIR)
    }

    private fun Bitmap.toByteArray(): ByteArray {
        val byteSize = rowBytes * height
        val byteBuffer = ByteBuffer.allocate(byteSize)
        copyPixelsToBuffer(byteBuffer)
        return byteBuffer.array()
    }

    private fun InputStream.toComposeBitmap(): ImageBitmap =
        BitmapFactory.decodeStream(this).asImageBitmap()
}