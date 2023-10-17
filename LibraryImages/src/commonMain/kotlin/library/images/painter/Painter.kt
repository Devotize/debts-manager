package library.images.painter

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.painter.Painter
import library.images.LocalImageLoader
import library.images.model.ImageState
import library.images.model.toPainter
import library.images.remote.ImageLoader

@Composable
fun rememberRemotePainter(
    url: String,
    placeholderPainter: (@Composable () -> Painter)? = null,
    errorPainter: (@Composable () -> Painter)? = null,
    imageLoader: ImageLoader = LocalImageLoader.current
): Painter {
    val state by remember(url) { imageLoader.loadImage(url) }.collectAsState(ImageState.InProcess)
    return rememberImageStatePainter(state, placeholderPainter, errorPainter)
}

@Composable
private fun rememberImageStatePainter(
    state: ImageState,
    placeholderPainter: (@Composable () -> Painter)?,
    errorPainter: (@Composable () -> Painter)?
): Painter =
    when (state) {
        is ImageState.InProcess -> placeholderPainter?.invoke() ?: StubPainter
        is ImageState.Error -> errorPainter?.invoke() ?: StubPainter
        is ImageState.Success -> remember {
            state.model.toPainter()
        }
    }

object StubPainter : Painter() {
    override val intrinsicSize get() = Size.Unspecified
    override fun DrawScope.onDraw() = Unit
}