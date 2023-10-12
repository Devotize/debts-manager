@Suppress("DSL_SCOPE_VIOLATION") // https://youtrack.jetbrains.com/issue/KTIJ-19369
plugins {
    `multiplatform-library-convention`
    alias(libs.plugins.kotlinx.serialization)
}

android {
    namespace = "com.di"
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                implementation(libs.kotlinx.coroutines.core)
                implementation(libs.koin.core)
                implementation(projects.featureNavigationImpl)
                implementation(projects.featureSettingsImpl)
                implementation(projects.featurePreferencesImpl)
                implementation(projects.featureHomeImpl)
            }
        }
    }
}