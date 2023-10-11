@Suppress("DSL_SCOPE_VIOLATION") // https://youtrack.jetbrains.com/issue/KTIJ-19369
plugins {
    `multiplatform-library-convention`
    alias(libs.plugins.kotlinx.serialization)
}

android {
    namespace = "feature.preferences.api"
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                api(libs.russhwolf.multiplatformSettings.coroutines)
                implementation(libs.kotlinx.coroutines.core)
            }
        }
    }
}