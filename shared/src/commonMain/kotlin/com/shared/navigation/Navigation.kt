package com.shared.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.shared.ui.scenes.HomeScene
import com.shared.ui.scenes.SettingsScene
import com.shared.ui.scenes.TestScene
import feature.navigation.api.router.AppScene
import feature.navigation.api.router.Router
import moe.tlaster.precompose.navigation.NavHost
import moe.tlaster.precompose.navigation.Navigator

@Composable
internal fun AppNavigation(navigator: Navigator, router: Router) {
    val initialRoute = remember { router.currentScene.value }
    NavHost(
        navigator = navigator,
        initialRoute = initialRoute.route,
    ) {
        scene(AppScene.Home.route) {
            HomeScene()
        }
        scene(AppScene.Settings.route) {
            SettingsScene()
        }
        scene(AppScene.Test.route) {
            TestScene()
        }
    }
}