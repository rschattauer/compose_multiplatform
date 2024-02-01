package ui.theme.typography

import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import ui.theme.typography.FontFamilies.adventPro

@Immutable
data class AppTypographies(
    val headline: TextStyle,
    val subline: TextStyle,
    val body: TextStyle,
    val copy: TextStyle,
    val material: Typography,
)

@Composable
fun appTypographies(): AppTypographies {
    val adventPro = adventPro()
    val materialTypography = Typography()
    return AppTypographies(
        headline = TextStyle(
            fontFamily = adventPro,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Normal,
            fontSize = 22.sp,
            lineHeight = 24.sp,
        ),
        subline = TextStyle(
            fontFamily = adventPro,
            fontWeight = FontWeight.Light,
            fontStyle = FontStyle.Normal,
            fontSize = 16.sp,
            lineHeight = 18.sp,
        ),
        body = TextStyle(
            fontFamily = adventPro,
            fontWeight = FontWeight.Medium,
            fontStyle = FontStyle.Normal,
            fontSize = 12.sp,
            lineHeight = 14.sp,
        ),
        copy = TextStyle(
            fontFamily = adventPro,
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Normal,
            fontSize = 10.sp,
            lineHeight = 12.sp,
        ),
        material = Typography(
            displayLarge = materialTypography.displayLarge.copy(fontFamily = adventPro),
            displayMedium = materialTypography.displayMedium.copy(fontFamily = adventPro),
            displaySmall = materialTypography.displaySmall.copy(fontFamily = adventPro),
            headlineLarge = materialTypography.headlineLarge.copy(fontFamily = adventPro),
            headlineMedium = materialTypography.headlineMedium.copy(fontFamily = adventPro),
            headlineSmall = materialTypography.headlineSmall.copy(fontFamily = adventPro),
            titleLarge = materialTypography.titleLarge.copy(fontFamily = adventPro),
            titleMedium = materialTypography.titleMedium.copy(fontFamily = adventPro),
            titleSmall = materialTypography.titleSmall.copy(fontFamily = adventPro),
            bodyLarge = materialTypography.bodyLarge.copy(fontFamily = adventPro),
            bodyMedium = materialTypography.bodyMedium.copy(fontFamily = adventPro),
            bodySmall = materialTypography.bodySmall.copy(fontFamily = adventPro),
            labelLarge = materialTypography.labelLarge.copy(fontFamily = adventPro),
            labelMedium = materialTypography.labelMedium.copy(fontFamily = adventPro),
            labelSmall = materialTypography.labelSmall.copy(fontFamily = adventPro),
        ),
    )
}
