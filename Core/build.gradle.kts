@Suppress("DSL_SCOPE_VIOLATION") // https://youtrack.jetbrains.com/issue/KTIJ-19369
plugins {
    `multiplatform-library-convention`
    alias(libs.plugins.kotlinx.serialization)
}

android {
    namespace = "core"
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                implementation(libs.kotlinx.coroutines.core)
                implementation(libs.koin.core)
            }
        }
    }
}