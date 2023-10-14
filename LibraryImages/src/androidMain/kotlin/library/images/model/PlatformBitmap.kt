package library.images.model

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap


actual class PlatformBitmap private actual constructor() : PlatformBitmapApi {

    private lateinit var bitmap: Bitmap

    override fun asImageBitmap(): ImageBitmap = bitmap.asImageBitmap()

    actual companion object {
        actual fun fromDecode(byteArray: ByteArray): PlatformBitmap =
            PlatformBitmap().apply {
                bitmap = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.size)
            }

    }

}