package dev.schattauer.compose

import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.WindowState
import androidx.compose.ui.window.singleWindowApplication
import app.Root
import di.initModules
import org.koin.core.context.startKoin

fun main() = singleWindowApplication(
    title = "Compose Multiplatform Demo",
    state = WindowState(size = DpSize(width = 360.dp, height = 800.dp)),
) {
    startKoin {
        initModules()
    }
    Root()
}
