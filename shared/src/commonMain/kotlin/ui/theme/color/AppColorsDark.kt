package ui.theme.color

import androidx.compose.material3.darkColorScheme

internal fun darkColorScheme(): AppColors = AppColors(
    ripple = AppColorPalette.green,
    splash = AppColorPalette.green,
    materialColors = darkColorScheme(
        primary = AppColorPalette.blue,
        error = AppColorPalette.red,
    ),
)
