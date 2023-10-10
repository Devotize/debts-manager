package feature.navigation.api.router

import moe.tlaster.precompose.navigation.Navigator

interface NavigatorInitializer {
    fun setNavigation(navigator: Navigator)
}