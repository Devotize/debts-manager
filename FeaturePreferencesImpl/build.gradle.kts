@Suppress("DSL_SCOPE_VIOLATION") // https://youtrack.jetbrains.com/issue/KTIJ-19369
plugins {
    `multiplatform-library-convention`
    alias(libs.plugins.kotlinx.serialization)
}

android {
    namespace = "feature.preferences.impl"
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                implementation(libs.koin.core)
                implementation(libs.kotlinx.coroutines.core)
                implementation(libs.russhwolf.multiplatformSettings.coroutines)
            }
        }
        androidMain {
            dependencies {
                implementation(libs.russhwolf.multiplatformSettings.coroutines)
                implementation(libs.russhwolf.multiplatformSettings.datastore)
                implementation(libs.androidx.datastore.core)
                implementation(libs.androidx.datastore.preferencesCore)
            }
        }
    }
}