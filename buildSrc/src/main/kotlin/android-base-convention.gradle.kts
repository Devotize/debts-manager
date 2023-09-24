/*
 * Copyright 2021 IceRock MAG Inc. Use of this source code is governed by the Apache 2.0 license.
 */

import com.android.build.gradle.LibraryExtension

// https://github.com/gradle/gradle/issues/15383
val catalogs = extensions.getByType<VersionCatalogsExtension>()

plugins {
    id("org.jetbrains.dokka")
    id("com.android.library")
    id("com.github.ben-manes.versions")
}

configure<LibraryExtension> {
    val libs = catalogs.named("libs")
    compileSdk =
        libs.findVersion("targetSdk").get().requiredVersion.toInt()

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    defaultConfig {
        minSdk = libs.findVersion("minSdk").get().requiredVersion.toInt()
        targetSdk = libs.findVersion("targetSdk").get().requiredVersion.toInt()
    }
    buildTypes {
        register("qa")
        register("gp")
        register("rc")
    }
    sourceSets.configureEach {
        manifest.srcFile("src/$name/AndroidManifest.xml")
        res.srcDirs("src/$name/res")
        java.srcDir("src/$name/kotlin")
    }
}
