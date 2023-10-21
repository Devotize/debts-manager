package library.images.cache

import androidx.compose.ui.graphics.ImageBitmap

object LocalImageHolder {

    private val inMemoryCache = PlatformInMemoryCache()
    private val diskCache: PlatformDiskCache by lazy { PlatformDiskCache.getInstance() }

    fun putImage(key: String, model: ImageBitmap) {
//        inMemoryCache.putImage(key, model)
        diskCache.putImage(key.hashCode().toString(), model)//TODO change hash code to unique str
    }

    fun findImage(key: String): ImageBitmap? =
        inMemoryCache.findImage(key) ?: diskCache.findImage(
            key.hashCode().toString()
        )//TODO change hash code to unique str

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