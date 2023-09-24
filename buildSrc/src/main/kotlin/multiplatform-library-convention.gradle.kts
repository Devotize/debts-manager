import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi

/*
* Copyright 2021 IceRock MAG Inc. Use of this source code is governed by the Apache 2.0 license.
*/

plugins {
    id("android-base-convention")
    kotlin("multiplatform")
    id("org.jetbrains.dokka")
}

@OptIn(ExperimentalKotlinGradlePluginApi::class)
kotlin {
    jvmToolchain(17)
    targetHierarchy.default()
    /*
        Source sets structure
        common
         ├─ android
         ├─ ios
             ├─ iosX64
             ├─ iosArm64
             ├─ iosSimulatorArm64
         */
    androidTarget()
    iosX64()
    iosArm64()
    iosSimulatorArm64()
}