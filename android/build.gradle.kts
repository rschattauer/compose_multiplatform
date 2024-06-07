plugins {
    kotlin("android")
    id("com.android.application")
    id("format-detekt-convention")
    id("format-ktlint-convention")
    alias(libs.plugins.jetbrainsCompose)
    alias(libs.plugins.jetbrainsComposeCompiler)
}

android {
    namespace = "dev.schattauer.compose"
    compileSdk = libs.versions.android.compileSdk.get().toInt()

    defaultConfig {
        minSdk = libs.versions.android.minSdk.get().toInt()
        targetSdk = libs.versions.android.targetSdk.get().toInt()
        versionCode = 1
        versionName = "1.0"

        buildFeatures.buildConfig = true
        buildConfigField(
            "String",
            "MAPBOX_PUBLIC_TOKEN",
            "\"${providers.gradleProperty("mapboxPublicToken").get()}\"",
        )
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_17.toString()
    }
    dependencies {
        implementation(project(":shared"))
        implementation(libs.androidx.activity.compose)
        implementation(libs.androidx.core.splashscreen)
        implementation(libs.koin.android)
        implementation(libs.mapbox.maps.android)
    }
}
