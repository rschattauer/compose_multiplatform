package ui.theme.color

import androidx.compose.material3.lightColorScheme

internal fun lightColorScheme(): AppColors = AppColors(
    ripple = AppColorPalette.blue,
    splash = AppColorPalette.blue,
    materialColors = lightColorScheme(
        primary = AppColorPalette.green,
        error = AppColorPalette.red,
    ),
)
