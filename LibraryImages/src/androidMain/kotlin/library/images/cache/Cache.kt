package library.images.cache

import android.content.Context
import android.os.Environment
import android.os.Environment.isExternalStorageRemovable
import android.util.LruCache
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asAndroidBitmap
import com.jakewharton.disklrucache.DiskLruCache
import library.images.initializer.pergamon
import java.io.File

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
        actual fun createInstance(): PlatformDiskCache {
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
        val editor = diskLruCache.edit(key)
    }

    override fun findImage(key: String): ImageBitmap? {
        TODO("Not yet implemented")
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

}