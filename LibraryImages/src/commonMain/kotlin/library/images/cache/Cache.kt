package library.images.cache

import androidx.compose.ui.graphics.ImageBitmap

object LocalImageHolder {

    private val inMemoryCache = PlatformInMemoryCache()

    fun putImage(key: String, model: ImageBitmap) {
        inMemoryCache.putImage(key, model)
    }

    fun findImage(key: String): ImageBitmap? =
        inMemoryCache.findImage(key)

}

interface ImageCacheInteractor {

    fun putImage(key: String, model: ImageBitmap)

    fun findImage(key: String): ImageBitmap?

}

expect class PlatformInMemoryCache() : ImageCacheInteractor

expect class PlatformDiskCache private constructor() : ImageCacheInteractor {

    companion object {
        fun createInstance(): PlatformDiskCache
    }

}