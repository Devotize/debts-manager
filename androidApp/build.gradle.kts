plugins {
    id("com.android.application")
    kotlin("android")
    id("org.jetbrains.compose")
}

android {
    namespace = BuildConstants.applicationID
    compileSdk = libs.versions.compileSdk.get().toInt()

    sourceSets["main"].manifest.srcFile("src/main/AndroidManifest.xml")

    defaultConfig {
        applicationId = BuildConstants.applicationID
        minSdk = libs.versions.minSdk.get().toInt()
        targetSdk = libs.versions.targetSdk.get().toInt()
        versionCode = libs.versions.versionCode.get().toInt()
        versionName = libs.versions.versionName.get()
    }
    buildFeatures {
        compose = true
        buildConfig = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.composeCompiler.get()
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    kotlin {
        jvmToolchain(17)
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}

dependencies {
    implementation(project(":shared"))

    api(compose.runtime)
    api(compose.foundation)
    api(compose.material)
    api(compose.ui)
    api(compose.animation)
    implementation(libs.androidx.compose.uiTooling)
    implementation(libs.androidx.compose.activity)
}