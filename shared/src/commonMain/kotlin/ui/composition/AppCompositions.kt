@file:Suppress("CompositionLocalAllowlist")

package ui.composition

import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.staticCompositionLocalOf
import ui.theme.color.AppColors
import ui.theme.typography.AppTypographies

internal val LocalAppColors = staticCompositionLocalOf<AppColors> {
    error("${AppColors::class.simpleName} needs to be set")
}
internal val LocalAppTypographies = staticCompositionLocalOf<AppTypographies> {
    error("${AppTypographies::class.simpleName} needs to be set")
}
internal val LocalAppIsInDarkMode = staticCompositionLocalOf<Boolean> {
    error("${Boolean::class.simpleName} for dark mode needs to be set")
}
internal val LocalSnackbarHostState = staticCompositionLocalOf<SnackbarHostState> {
    error("SnackbarHostState needs to be set")
}
