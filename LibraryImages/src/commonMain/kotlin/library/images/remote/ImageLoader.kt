package library.images.remote

import io.ktor.client.request.get
import io.ktor.client.statement.readBytes
import io.ktor.http.Url
import io.ktor.utils.io.errors.IOException
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext
import library.images.model.ImageState
import library.images.model.PlatformBitmap
import library.images.utils.logXertz

class ImageLoader {

    private val loaderScope = CoroutineScope(SupervisorJob() + Dispatchers.IO)

    fun loadImage(url: String): Flow<ImageState> = flow {
        emit(ImageState.InProcess)
        emit(fetchImageFromRemote(url))
    }

    private suspend fun fetchImageFromRemote(link: String): ImageState {
        logXertz("fetchImageFromRemote called")
        val url = Url(link)
        return try {
            withContext(loaderScope.coroutineContext) {
                val byteArray = httpClient.get(url).readBytes()
                ImageState.Success(PlatformBitmap.fromDecode(byteArray).asImageBitmap())
            }
        } catch (e: IOException) {
            ImageState.Error(e.cause?.message ?: e.message.toString())
        }

    }

}