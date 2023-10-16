package library.images

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf
import library.images.remote.ImageLoader

val LocalImageLoader = createImageLocalProvidable()

class ImageLoaderProvidable internal constructor(private val delegate: ProvidableCompositionLocal<ImageLoader>) {

    val current: ImageLoader
        @Composable
        @ReadOnlyComposable
        get() = delegate.current

}

private fun createImageLocalProvidable() =
    ImageLoaderProvidable(
        delegate = staticCompositionLocalOf {
            ImageLoader()
        }
    )