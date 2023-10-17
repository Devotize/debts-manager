package feature.navigation.api.bottom_sheet.scenes

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp
import library.images.painter.rememberRemotePainter

@Composable
fun TestBottomSheet() {
    Column(modifier = Modifier.fillMaxSize()) {
        Text("This is bottom sheet")

        val painter: Painter =
            rememberRemotePainter("https://i.pinimg.com/564x/4d/65/11/4d6511b40c4856231bc38dcc51363557.jpg")
        Image(
            modifier = Modifier.wrapContentHeight().fillMaxWidth().padding(24.dp),
            painter = painter,
            contentDescription = null,
        )

    }
}