package library.images.cache

import androidx.compose.ui.graphics.ImageBitmap

object LocalImageHolder {

    private val inMemoryCache = PlatformInMemoryCache()
    private val diskCache: PlatformDiskCache by lazy { PlatformDiskCache.getInstance() }

    fun putImage(key: String, model: ImageBitmap) {
        inMemoryCache.putImage(key, model)
        diskCache.putImage(key, model)
    }

    fun findImage(key: String): ImageBitmap? =
        inMemoryCache.findImage(key) ?: diskCache.findImage(key)

}

interface ImageCacheInteractor {

    fun putImage(key: String, model: ImageBitmap)

    fun findImage(key: String): ImageBitmap?

}

expect class PlatformInMemoryCache() : ImageCacheInteractor

expect class PlatformDiskCache private constructor() : ImageCacheInteractor {

    companion object {
        fun getInstance(): PlatformDiskCache
    }

}