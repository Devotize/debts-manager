package com.shared.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.shared.theme.CustomAppTheme

@Composable
fun AppCompose() = ContentScreen()


@Composable
private fun ContentScreen() {
    CustomAppTheme {
        Box(
            modifier = Modifier
                .background(MaterialTheme.colors.background)
                .fillMaxSize()
        ) {
            Text("Hello from shared compose multiplatofrm")
        }

    }

}