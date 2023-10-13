package feature.navigation.api.router

enum class AppScene(val route: String, val hasBottomBar: Boolean) {
    Home("/home", true),
    Settings("/settings", true),
    Test("/test", false)
}