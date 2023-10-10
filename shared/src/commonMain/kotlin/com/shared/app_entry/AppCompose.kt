package com.shared.app_entry

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.shared.navigation.AppNavigation
import com.shared.theme.CustomAppTheme
import com.shared.ui.components.BottomBar
import feature.navigation.api.router.NavigatorInitializer
import feature.navigation.api.router.Router
import moe.tlaster.precompose.navigation.rememberNavigator
import utils.getSingle

@Composable
fun AppCompose() = Content()


@Composable
private fun Content() {
    val navigator = rememberNavigator()
    val navigatorInitializer: NavigatorInitializer by lazy { getSingle() }
    navigatorInitializer.setNavigation(navigator)
    val router: Router by lazy { getSingle() }
    val currentScene by router.currentScene.collectAsState()
    CustomAppTheme {
        val scaffoldState = rememberScaffoldState()
        Scaffold(
            modifier = Modifier
                .background(MaterialTheme.colors.background)
                .fillMaxSize(),
            scaffoldState = scaffoldState,
            drawerGesturesEnabled = false,
            content = {
                Column(modifier = Modifier.fillMaxWidth()) {
                    Box(modifier = Modifier.weight(1f)) {
                        AppNavigation(navigator, router)
                    }
                    if (currentScene.hasBottomBar) {
                        BottomBar(router)
                    }
                }


            }
        )
    }

}