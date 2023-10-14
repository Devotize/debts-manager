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
import library.images.painter.rememberPainter

@Composable
fun TestBottomSheet2() {
    Column(modifier = Modifier.fillMaxSize()) {
        Text("This is bottom sheet 2")

        val painter: Painter =
            rememberPainter("https://i.pinimg.com/564x/4b/b4/a3/4bb4a3a2f19824cc9e42f344845b225d.jpg")
        Image(
            modifier = Modifier.wrapContentHeight().fillMaxWidth().padding(24.dp),
            painter = painter,
            contentDescription = null,
        )

    }
}