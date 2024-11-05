buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:8.1.1") // Downgraded AGP version
        classpath(libs.kotlin.gradle.plugin) // Compatible Kotlin version
        classpath(libs.androidx.navigation.safe.args.gradle.plugin)
    }
}

// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
}