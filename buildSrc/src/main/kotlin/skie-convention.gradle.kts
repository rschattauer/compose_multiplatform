import com.google.devtools.ksp.gradle.KspTaskNative
import dev.schattauer.compose.libs
import gradle.kotlin.dsl.accessors._e1a9f51e13babe21edfd0d144bc5df07.kotlin
import gradle.kotlin.dsl.accessors._e1a9f51e13babe21edfd0d144bc5df07.sourceSets
import org.gradle.internal.extensions.stdlib.capitalized
import org.gradle.kotlin.dsl.invoke
import org.jetbrains.kotlin.gradle.plugin.SubpluginOption
import org.jetbrains.kotlin.gradle.tasks.KotlinCompilationTask
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("multiplatform")
    id("com.google.devtools.ksp")
    id("co.touchlab.skie")
}

kotlin {
    applyDefaultHierarchyTemplate()

    androidTarget()
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64(),
    )
    sourceSets {
        commonMain.dependencies {
            implementation(libs.touchlab.swift.bridge.compose)
        }
    }
}

dependencies {
    val composeSwiftBridgeKsp = "co.touchlab.compose:compose-swift-bridge-ksp:0.1.0"
    "kspCommonMainMetadata"(composeSwiftBridgeKsp)
    "kspIosSimulatorArm64"(composeSwiftBridgeKsp)
    "kspIosArm64"(composeSwiftBridgeKsp)
    "kspIosX64"(composeSwiftBridgeKsp)
    "kspAndroid"(composeSwiftBridgeKsp)
    skieSubPlugin(libs.touchlab.swift.bridge.compose.skie)
}

ksp {
    arg("compose-swift-bridge.defaultFactoryName", project.name.capitalized())
}

tasks.withType<KspTaskNative>().configureEach {
    options.add(SubpluginOption("apoption", "compose-swift-bridge.targetName=$target"))
}

// support for generating ksp code in commonCode
// see https://github.com/google/ksp/issues/567
tasks.withType<KotlinCompilationTask<*>>().configureEach {
    if (name != "kspCommonMainKotlinMetadata") {
        dependsOn("kspCommonMainKotlinMetadata")
    }
}

kotlin.sourceSets.commonMain {
    kotlin.srcDir("build/generated/ksp/metadata/commonMain/kotlin")
}
