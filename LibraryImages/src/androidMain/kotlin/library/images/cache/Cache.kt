package library.images.cache

import android.util.LruCache
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asAndroidBitmap

actual class PlatformImageCache : ImageCacheInteractor {

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