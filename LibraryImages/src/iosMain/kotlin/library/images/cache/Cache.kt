package library.images.cache

import androidx.compose.ui.graphics.ImageBitmap
import library.images.cache.internal.DiskCache
import library.images.model.PlatformBitmap
import platform.Foundation.NSCache
import kotlin.native.concurrent.ThreadLocal

actual class PlatformInMemoryCache : ImageCacheInteractor {

    private val nsCache: NSCache = NSCache().apply {
        countLimit = 100u
        totalCostLimit = (1024u * 1024u * 10u).toULong()// 10 MB
    }

    override fun putImageBytes(key: String, model: ByteArray) {
        nsCache.setObject(PlatformBitmap.fromDecode(model).asImageBitmap(), key)
    }

    override fun findImage(key: String): ImageBitmap? =
        nsCache.objectForKey(key) as? ImageBitmap

}

actual class PlatformDiskCache : ImageCacheInteractor {

    private val diskLruCache = DiskCache()

    override fun putImageBytes(key: String, model: ByteArray) {
        diskLruCache.put(key, model)
    }

    override fun findImage(key: String): ImageBitmap? {
        return diskLruCache.get(key)?.let { PlatformBitmap.fromDecode(it).asImageBitmap() }
    }

    @ThreadLocal
    actual companion object {
        private var instance: PlatformDiskCache? = null
        actual fun getInstance(): PlatformDiskCache {
            if (instance != null) error("Instance of PlatformDiskCache already created")
            return PlatformDiskCache().also {
                instance = it
            }
        }
    }


}