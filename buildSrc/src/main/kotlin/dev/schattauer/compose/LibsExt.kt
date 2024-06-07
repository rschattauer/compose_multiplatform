package dev.schattauer.compose

import org.gradle.accessors.dm.LibrariesForLibs
import org.gradle.api.Project

// Used to enable version catalogs with a workaround for convention plugins for now
// see: https://github.com/gradle/gradle/issues/15383
internal val Project.libs get() = project.extensions.getByName("libs") as LibrariesForLibs
