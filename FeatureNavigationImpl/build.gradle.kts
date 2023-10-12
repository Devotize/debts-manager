@Suppress("DSL_SCOPE_VIOLATION") // https://youtrack.jetbrains.com/issue/KTIJ-19369
plugins {
    `multiplatform-library-convention`
    alias(libs.plugins.kotlinx.serialization)
    id("org.jetbrains.compose")
}

android {
    namespace = "feature.navigation.impl"
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                implementation(libs.kotlinx.coroutines.core)
                implementation(projects.utils)
                implementation(projects.featureNavigationApi)
                implementation(libs.precompose.core)
                implementation(compose.material)
            }
        }
    }
}