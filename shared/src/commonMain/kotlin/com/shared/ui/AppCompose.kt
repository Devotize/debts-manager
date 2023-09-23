package com.shared.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.shared.theme.CustomAppTheme

@Composable
fun AppCompose() = ContentScreen()


@Composable
private fun ContentScreen() {
    CustomAppTheme {
        val scaffoldState = rememberScaffoldState()
        Scaffold(
            modifier = Modifier
                .background(MaterialTheme.colors.background)
                .fillMaxSize(),
            scaffoldState = scaffoldState,
            drawerGesturesEnabled = false,
            content = {
                Box {
                    Text("Hello from shared compose multiplatofrm")
                }
            }
        )
    }

}