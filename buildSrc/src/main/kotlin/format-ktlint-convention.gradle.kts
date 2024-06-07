import org.jlleitschuh.gradle.ktlint.reporter.ReporterType

plugins {
    id("org.jlleitschuh.gradle.ktlint")
}

ktlint {
    version.set("1.0.1")
    android.set(false)
    relative.set(true)
    outputColorName.set("RED")

    reporters {
        reporter(ReporterType.PLAIN)
        reporter(ReporterType.CHECKSTYLE)
        reporter(ReporterType.JSON)
    }

    filter {
        exclude("**/build/**")
        include("**/kotlin/**")
    }
}
