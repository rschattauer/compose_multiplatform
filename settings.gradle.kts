rootProject.name = "ComposeMultiplatform"
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

pluginManagement {
    repositories {
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
        google()
        gradlePluginPortal()
        mavenCentral()
    }
}

dependencyResolutionManagement {
    repositories {
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
        google()
        mavenCentral()
        // Mapbox Maven repository
        maven(url = "https://api.mapbox.com/downloads/v2/releases/maven") {
            val mapboxSecretToken: String by settings
            credentials.username = "mapbox"
            credentials.password = mapboxSecretToken
            authentication.create<BasicAuthentication>("basic")
            content {
                includeGroupByRegex("com\\.mapbox\\..*")
            }
        }
    }
}

include(":android")
include(":desktop")
include(":shared")
