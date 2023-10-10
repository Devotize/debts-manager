package feature.navigation.api.router

import kotlinx.coroutines.flow.StateFlow
import moe.tlaster.precompose.navigation.NavOptions

interface Router {

    val currentScene: StateFlow<AppScene>

    fun navigateTo(scene: AppScene, navOptions: NavOptions? = null)

}