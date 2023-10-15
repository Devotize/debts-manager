package library.images.cache

import androidx.compose.ui.graphics.ImageBitmap

object LocalImageHolder {

    private val imageCaches = PlatformImageCache()

    fun putImage(key: String, model: ImageBitmap) {
        imageCaches.putImage(key, model)
    }

    fun findImage(key: String): ImageBitmap? =
        imageCaches.findImage(key)

}

interface ImageCacheInteractor {

    fun putImage(key: String, model: ImageBitmap)

    fun findImage(key: String): ImageBitmap?

}

expect class PlatformImageCache() : ImageCacheInteractor