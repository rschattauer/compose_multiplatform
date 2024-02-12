plugins {
    kotlin("multiplatform")
    id("com.android.library")
    id("kotlin-parcelize")
    id("format-detekt-convention")
    id("format-ktlint-convention")
    alias(libs.plugins.jetbrainsCompose)
}

kotlin {
    applyDefaultHierarchyTemplate()

    androidTarget()
    jvm("desktop")
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64(),
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "shared"
            isStatic = true
        }
    }

    sourceSets {
        androidMain.dependencies {
            implementation(libs.androidx.compose.ui.tooling.preview)
            implementation(libs.mapbox.maps.android)
            implementation(libs.mapbox.maps.compose)
            implementation(libs.koin.android)
        }
        commonMain.dependencies {
            implementation(libs.androidx.datastore.preferences.core)
            implementation(compose.animation)
            implementation(compose.foundation)
            implementation(compose.material3)
            implementation(compose.runtime)
            implementation(compose.ui)
            implementation(compose.components.resources)
            implementation(compose.components.uiToolingPreview)
            api(libs.koin)
            api(libs.koin.compose)
            api(libs.kotlin.immutability)
            api(libs.compose.precompose)
            api(libs.compose.precompose.koin)
            api(libs.compose.precompose.viewmodel)
            api(libs.touchlab.kermit)
        }
        iosMain.dependencies {
            // Workaround for now, see https://github.com/cashapp/sqldelight/issues/4357#issuecomment-1839905700
            implementation(libs.touchlab.stately.common)
        }
        val desktopMain by getting
        desktopMain.dependencies {
            implementation(compose.desktop.common)
        }
        all {
            languageSettings.optIn("androidx.compose.foundation.ExperimentalFoundationApi")
            languageSettings.optIn("androidx.compose.material3.ExperimentalMaterial3Api")
            languageSettings.optIn("kotlinx.cinterop.ExperimentalForeignApi")
            languageSettings.optIn("org.jetbrains.compose.resources.ExperimentalResourceApi")
        }
    }
}

android {
    namespace = "dev.schattauer.compose.shared"
    compileSdk = libs.versions.android.compileSdk.get().toInt()

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    dependencies {
        debugImplementation(libs.androidx.compose.ui.tooling)
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.9"
    }
}
