package library.images.cache

import androidx.compose.ui.graphics.ImageBitmap
import platform.Foundation.NSCache

actual class PlatformImageCache : ImageCacheInteractor {

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