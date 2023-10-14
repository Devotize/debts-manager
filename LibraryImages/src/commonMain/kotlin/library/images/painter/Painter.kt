package library.images.painter

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.painter.Painter
import com.seiko.imageloader.rememberImagePainter
import library.images.model.ImageState
import library.images.model.toPainter
import library.images.remote.ImageLoader

@Composable
fun rememberPainter(url: String): Painter {

    val imageLoader = ImageLoader() //TODO make use of CompositionLocal
    val state by remember(url) { imageLoader.loadImage(url) }.collectAsState(ImageState.InProcess)
    return rememberImageStatePainter(state)
}


@Composable
private fun rememberImageStatePainter(state: ImageState): Painter =
    when (state) {
        is ImageState.InProcess -> remember {
            StubPainter
        }

        is ImageState.Error -> remember {
            StubPainter
        }

        is ImageState.Success -> remember {
            state.model.toPainter()
        }
    }

object StubPainter : Painter() {
    override val intrinsicSize get() = Size.Unspecified
    override fun DrawScope.onDraw() = Unit
}

@Composable
private fun test() = rememberImagePainter("") //TODO remove