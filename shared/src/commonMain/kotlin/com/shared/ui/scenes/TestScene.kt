package com.shared.ui.scenes

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.shared.theme.XLargePadding
import com.shared.utils.rememberKoin
import feature.navigation.api.router.Router

@Composable
fun TestScene(router: Router = rememberKoin()) {
    Column(modifier = Modifier.fillMaxSize()) {
        Text(
            modifier = Modifier.padding(XLargePadding)
                .clickable { router.goBack() },
            text = "Go back",
        )

        Text(
            modifier = Modifier.padding(XLargePadding),
            text = "This is test scene"
        )
    }
}