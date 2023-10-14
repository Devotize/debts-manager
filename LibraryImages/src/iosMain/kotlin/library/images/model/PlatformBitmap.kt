package library.images.model

import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asComposeImageBitmap
import org.jetbrains.skia.Bitmap
import org.jetbrains.skia.Image


actual class PlatformBitmap private actual constructor() : PlatformBitmapApi {

    private lateinit var bitmap: Bitmap

    override fun asImageBitmap(): ImageBitmap = bitmap.asComposeImageBitmap()

    actual companion object {
        actual fun fromDecode(byteArray: ByteArray): PlatformBitmap =
            PlatformBitmap().apply {
                val image = Image.makeFromEncoded(byteArray)
                bitmap = Bitmap.makeFromImage(image)
            }

    }

}