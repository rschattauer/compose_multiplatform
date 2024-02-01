package ui.theme.color

import androidx.compose.material3.ColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import ui.theme.App

@Stable
data class AppColors internal constructor(
    val ripple: Color,
    val splash: Color,
    val materialColors: ColorScheme,
)

@Composable
fun appColors(
    isInDarkMode: Boolean = App.isInDarkMode,
): AppColors = remember(isInDarkMode) {
    if (isInDarkMode) darkColorScheme() else lightColorScheme()
}
