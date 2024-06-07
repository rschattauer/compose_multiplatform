@file:Suppress("MatchingDeclarationName")

package ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import ui.composition.LocalAppColors
import ui.composition.LocalAppIsInDarkMode
import ui.composition.LocalAppTypographies
import ui.theme.color.AppColors
import ui.theme.color.appColors
import ui.theme.typography.AppTypographies
import ui.theme.typography.appTypographies

object App {
    val colors: AppColors
        @Composable
        @ReadOnlyComposable
        get() = LocalAppColors.current

    val typographies: AppTypographies
        @Composable
        @ReadOnlyComposable
        get() = LocalAppTypographies.current

    val isInDarkMode: Boolean
        @Composable
        @ReadOnlyComposable
        get() = LocalAppIsInDarkMode.current
}

@Composable
fun AppTheme(
    isInDarkMode: Boolean = isSystemInDarkTheme(),
    colors: AppColors = appColors(isInDarkMode = isInDarkMode),
    typographies: AppTypographies = appTypographies(),
    content: @Composable () -> Unit,
) {
    CompositionLocalProvider(
        LocalAppColors provides colors,
        LocalAppTypographies provides typographies,
        LocalAppIsInDarkMode provides isInDarkMode,
    ) {
        MaterialTheme(
            colorScheme = colors.materialColors,
            typography = typographies.material,
            content = content,
        )
    }
}
