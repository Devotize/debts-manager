package library.images.remote

import io.ktor.client.request.get
import io.ktor.client.statement.readBytes
import io.ktor.http.Url
import io.ktor.utils.io.errors.IOException
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import library.images.cache.LocalImageHolder
import library.images.model.ImageState
import library.images.model.PlatformBitmap

class ImageLoader {

    private val loaderScope = CoroutineScope(SupervisorJob() + Dispatchers.IO)

    fun loadImage(url: String): Flow<ImageState> = flow {
        emit(ImageState.InProcess)
        emit(getImage(url))
    }.flowOn(Dispatchers.IO)


    private suspend fun getImage(url: String): ImageState {
        val cacheImage = LocalImageHolder.findImage(url)
        return if (cacheImage != null) {
            ImageState.Success(cacheImage)
        } else {
            fetchImageFromRemote(url).also {
                if (it is ImageState.Success) {
                    LocalImageHolder.putImage(url, it.model)
                }
            }
        }
    }

    private suspend fun fetchImageFromRemote(link: String): ImageState {
        val url = Url(link)
        return try {
                delay(2000) //TODO for testing purposes
                val byteArray = httpClient.get(url).readBytes()
                ImageState.Success(PlatformBitmap.fromDecode(byteArray).asImageBitmap())
        } catch (e: IOException) {
            ImageState.Error(e.cause?.message ?: e.message.toString())
        }

    }

}