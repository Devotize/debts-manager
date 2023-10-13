@Suppress("DSL_SCOPE_VIOLATION") // https://youtrack.jetbrains.com/issue/KTIJ-19369
plugins {
    `multiplatform-library-convention`
    alias(libs.plugins.kotlinx.serialization)
}

android {
    namespace = "feature.settings.impl"
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                implementation(libs.kotlinx.coroutines.core)
                implementation(libs.koin.core)
                implementation(projects.featureSettingsApi)
                implementation(projects.featurePreferencesApi)
                implementation(libs.russhwolf.multiplatformSettings.coroutines)
                implementation(projects.featureNavigationApi)
            }
        }
    }
}