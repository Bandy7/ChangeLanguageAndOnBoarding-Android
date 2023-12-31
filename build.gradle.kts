// Top-level build file where you can add configuration options common to all sub-projects/modules.

buildscript {
    dependencies {
        classpath ("com.android.tools.build:gradle:8.1.0")
        classpath ("org.jetbrains.kotlin:kotlin-gradle-plugin:1.7.0")
        classpath ("com.google.dagger:hilt-android-gradle-plugin:2.46.1")
    }
}

plugins {
    id("com.android.application") version "7.3.0" apply false
    id("org.jetbrains.kotlin.android") version "1.7.20" apply false
    id("com.android.library") version "7.3.0" apply false
}