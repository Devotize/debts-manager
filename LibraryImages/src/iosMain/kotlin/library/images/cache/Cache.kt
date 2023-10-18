package library.images.cache

import androidx.compose.ui.graphics.ImageBitmap
import platform.Foundation.NSCache
import kotlin.native.concurrent.ThreadLocal

actual class PlatformInMemoryCache : ImageCacheInteractor {

    private val nsCache: NSCache = NSCache().apply {
        countLimit = 100u
        totalCostLimit = (1024u * 1024u * 100u).toULong()// 100 MB
    }

    override fun putImage(key: String, model: ImageBitmap) {
        nsCache.setObject(model, key)
    }

    override fun findImage(key: String): ImageBitmap? =
        nsCache.objectForKey(key) as? ImageBitmap

}

actual class PlatformDiskCache : ImageCacheInteractor {

    override fun putImage(key: String, model: ImageBitmap) {
        TODO("Not yet implemented")
    }

    override fun findImage(key: String): ImageBitmap? {
        TODO("Not yet implemented")
    }

    @ThreadLocal
    actual companion object {
        private var instance: PlatformDiskCache? = null
        actual fun createInstance(): PlatformDiskCache {
            if (instance != null) error("Instance of PlatformDiskCache already created")
            return PlatformDiskCache().also {
                instance = it
            }
        }
    }


}