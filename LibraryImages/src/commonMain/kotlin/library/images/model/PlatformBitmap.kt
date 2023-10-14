package library.images.model

import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.painter.BitmapPainter


expect class PlatformBitmap private constructor() : PlatformBitmapApi {

    companion object {
        fun fromDecode(byteArray: ByteArray): PlatformBitmap
    }

}

internal interface PlatformBitmapApi {

    fun asImageBitmap(): ImageBitmap

}

internal fun ImageBitmap.toPainter() =
    BitmapPainter(this, filterQuality = DrawScope.DefaultFilterQuality)