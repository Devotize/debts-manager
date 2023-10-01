package com.shared.navigation

import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.runtime.Composable
import com.shared.ui.scenes.HomeScene
import com.shared.ui.scenes.SettingsScene
import moe.tlaster.precompose.navigation.NavHost
import moe.tlaster.precompose.navigation.Navigator
import moe.tlaster.precompose.navigation.transition.NavTransition

@Composable
internal fun AppNavigation(navigator: Navigator) {
    NavHost(
        navigator = navigator,
        initialRoute = AppScenes.Home.route
    ) {
        scene(AppScenes.Home.route) {
            HomeScene {
                navigator.navigate(AppScenes.Settings.route)
            }
        }
        scene(
            AppScenes.Settings.route,
            navTransition = NavTransition(
                createTransition = slideInHorizontally(initialOffsetX = { it }),
                destroyTransition = slideOutHorizontally(targetOffsetX = { 0 }),
                pauseTransition = scaleOut(targetScale = 0.9f),
                resumeTransition = scaleIn(initialScale = 0.9f),
                exitTargetContentZIndex = 1f,
            )
        ) {
            SettingsScene(
                onClick = {
                    navigator.navigate(AppScenes.Home.route)
                }
            )
        }
    }
}