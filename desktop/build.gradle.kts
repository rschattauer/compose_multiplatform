plugins {
    kotlin("multiplatform")
    id("format-detekt-convention")
    id("format-ktlint-convention")
    alias(libs.plugins.jetbrainsCompose)
    alias(libs.plugins.jetbrainsComposeCompiler)
}

kotlin {
    jvm()
    sourceSets {
        jvmMain.dependencies {
            implementation(project(":shared"))

            implementation(compose.desktop.currentOs)
        }
    }
}

compose.desktop {
    application {
        mainClass = "dev.schattauer.compose.MainWindowKt"
    }
}
