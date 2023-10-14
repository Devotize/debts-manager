@Suppress("DSL_SCOPE_VIOLATION") // https://youtrack.jetbrains.com/issue/KTIJ-19369
plugins {
    `multiplatform-library-convention`
    alias(libs.plugins.kotlinx.serialization)
    id("org.jetbrains.compose")
}

android {
    namespace = "library.images"
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                implementation(libs.kotlinx.coroutines.core)
                api(libs.precompose.core)
                implementation(compose.runtime)
                implementation(compose.foundation)
                implementation(compose.material)
                implementation(compose.ui)
                implementation(compose.animation)
                implementation(libs.imageLoader)
                implementation(libs.ktor.logging)
                implementation(libs.ktor.encoding)
                implementation(libs.ktor.contentNegotiation)
                implementation(libs.ktor.serializationJson)
                implementation(libs.napier)
            }
        }
        androidMain {
            dependencies {
                implementation(libs.ktor.okhttp)
            }
        }
    }
}