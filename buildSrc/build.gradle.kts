plugins {
    `kotlin-dsl`
}

dependencies {
    implementation(libs.kotlinGradlePlugin)
    implementation(libs.androidBuildToolsPlugin)
    implementation(libs.dokkaPlugin)
    implementation(libs.versionsPlugin)
}
kotlin {
    jvmToolchain(17)
    sourceSets.configureEach {
        languageSettings.optIn("kotlin.RequiresOptIn")
    }
}