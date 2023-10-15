package feature.navigation.impl.router

import feature.navigation.api.router.AppScene
import feature.navigation.api.router.NavigatorInitializer
import feature.navigation.api.router.Router
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import moe.tlaster.precompose.navigation.NavOptions
import moe.tlaster.precompose.navigation.Navigator

class RouterImpl : Router, NavigatorInitializer {

    override val currentScene: MutableStateFlow<AppScene> = MutableStateFlow(AppScene.Home)

    private lateinit var navigator: Navigator

    private val navigationScope = CoroutineScope(SupervisorJob() + Dispatchers.Default)

    init {
        currentScene.onEach {
            println("xertz: currentScene: $it")
        }.launchIn(navigationScope)
    }

    override fun navigateTo(scene: AppScene, navOptions: NavOptions?) {
        currentScene.value = scene
        navigator.navigate(scene.route, navOptions)
    }

    override fun setNavigation(navigator: Navigator) {
        this.navigator = navigator
        listenToNavigator(navigator)
    }

    private fun listenToNavigator(navigator: Navigator) {
        navigator.currentEntry.filterNotNull().onEach { navEntry ->
            currentScene.value = AppScene.entries.first { it.route == navEntry.route.route }
        }.launchIn(navigationScope)
    }

    override fun goBack() {
        navigator.goBack()
    }

}