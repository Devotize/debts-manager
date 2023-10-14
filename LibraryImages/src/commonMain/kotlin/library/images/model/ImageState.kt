package library.images.model

import androidx.compose.ui.graphics.ImageBitmap

sealed interface ImageState {

    data object InProcess : ImageState

    data class Success(val model: ImageBitmap) : ImageState

    data class Error(val message: String) : ImageState

}

