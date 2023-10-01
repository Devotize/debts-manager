package com.shared.app_entry

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.shared.navigation.AppNavigation
import com.shared.theme.CustomAppTheme
import moe.tlaster.precompose.navigation.rememberNavigator

@Composable
fun AppCompose() = Content()


@Composable
private fun Content() {
    val navigator = rememberNavigator()
    CustomAppTheme {
        val scaffoldState = rememberScaffoldState()
        Scaffold(
            modifier = Modifier
                .background(MaterialTheme.colors.background)
                .fillMaxSize(),
            scaffoldState = scaffoldState,
            drawerGesturesEnabled = false,
            content = {
                AppNavigation(navigator)
            }
        )
    }

}