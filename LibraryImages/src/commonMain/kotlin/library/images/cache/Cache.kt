package library.images.cache

import androidx.compose.ui.graphics.ImageBitmap

object LocalImageHolder {

    private val inMemoryCache = PlatformInMemoryCache()
    private val diskCache: PlatformDiskCache by lazy { PlatformDiskCache.getInstance() }

    fun putImageBytes(key: String, model: ByteArray) {
        inMemoryCache.putImageBytes(key, model)
        diskCache.putImageBytes(key, model)
    }

    fun findImage(key: String): ImageBitmap? =
        inMemoryCache.findImage(key) ?: diskCache.findImage(key)

}

interface ImageCacheInteractor {

    fun putImageBytes(key: String, model: ByteArray)

    fun findImage(key: String): ImageBitmap?

}

expect class PlatformInMemoryCache() : ImageCacheInteractor

expect class PlatformDiskCache private constructor() : ImageCacheInteractor {

    companion object {
        fun getInstance(): PlatformDiskCache
    }

}