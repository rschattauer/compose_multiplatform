package ui.theme.typography

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import composemultiplatform.shared.generated.resources.Res
import composemultiplatform.shared.generated.resources.advent_pro_bold
import composemultiplatform.shared.generated.resources.advent_pro_light
import composemultiplatform.shared.generated.resources.advent_pro_medium
import composemultiplatform.shared.generated.resources.advent_pro_regular
import org.jetbrains.compose.resources.Font

object FontFamilies {
    @Composable
    fun adventPro() = FontFamily(
        Font(
            resource = Res.font.advent_pro_bold,
            weight = FontWeight.Bold,
            style = FontStyle.Normal,
        ),
        Font(
            resource = Res.font.advent_pro_light,
            weight = FontWeight.Light,
            style = FontStyle.Normal,
        ),
        Font(
            resource = Res.font.advent_pro_medium,
            weight = FontWeight.Medium,
            style = FontStyle.Normal,
        ),
        Font(
            resource = Res.font.advent_pro_regular,
            weight = FontWeight.Normal,
            style = FontStyle.Normal,
        ),
    )
}
