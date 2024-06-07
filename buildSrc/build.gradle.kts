plugins {
    `kotlin-dsl`
}

dependencies {
    implementation(libs.gradle.plugin.kotlinMultiplatform)
    implementation(libs.gradle.plugin.androidApplication)
    implementation(libs.gradle.plugin.androidLibrary)
    implementation(libs.gradle.plugin.detekt)
    implementation(libs.gradle.plugin.ktlint)
    // The following is to enable version catalogs (with a workaround) within convention plugins
    // see: https://github.com/gradle/gradle/issues/15383
    implementation(files(libs.javaClass.superclass.protectionDomain.codeSource.location))
}
