@file:Suppress("UnstableApiUsage")

rootProject.name = "debts-manager"

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
        mavenCentral()
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.PREFER_PROJECT)
    repositories {
        google()
        mavenCentral()
        maven("https://jitpack.io")
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    }
}


fun includeFeatureModules(name: String) {
    include(":Feature${name}Api")
    include(":Feature${name}Impl")
}

include(":androidApp")
include(":shared")
include(":Utils")
include(":DI")
include(":Core")
includeFeatureModules("Navigation")
includeFeatureModules("Settings")
includeFeatureModules("Preferences")
includeFeatureModules("Home")