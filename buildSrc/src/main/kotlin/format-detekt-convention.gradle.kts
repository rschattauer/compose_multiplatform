import dev.schattauer.compose.libs
import io.gitlab.arturbosch.detekt.Detekt
import io.gitlab.arturbosch.detekt.DetektCreateBaselineTask

plugins {
    id("io.gitlab.arturbosch.detekt")
}

detekt {
    source.setFrom(
        "src/main/kotlin",
        "src/test/kotlin",
        "src/commonMain/kotlin",
        "src/commonTest/kotlin",
        "src/androidMain/kotlin",
        "src/androidTest/kotlin",
        "src/iosMain/kotlin",
        "src/iosTest/kotlin",
    )
    buildUponDefaultConfig = true
    config.setFrom(rootProject.files("config/quality/detekt/detekt-config.yml"))
}

tasks.withType<Detekt>().configureEach {
    reports {
        html.required.set(true)
        xml.required.set(true)
        txt.required.set(false)
        sarif.required.set(false)
        md.required.set(false)
    }
    jvmTarget = JavaVersion.VERSION_17.toString()
}

tasks.withType<DetektCreateBaselineTask>().configureEach {
    jvmTarget = JavaVersion.VERSION_17.toString()
}

dependencies {
    detektPlugins(libs.compose.detekt.rules)
}
