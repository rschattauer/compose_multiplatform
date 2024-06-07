package ext

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalLayoutDirection

@Composable
fun PaddingValues.withoutSystemBarsInsets(): PaddingValues = this - WindowInsets.systemBars.asPaddingValues()

@Composable
operator fun PaddingValues.minus(other: PaddingValues): PaddingValues {
    val layoutDirection = LocalLayoutDirection.current
    return PaddingValues(
        start = calculateStartPadding(layoutDirection) - other.calculateStartPadding(layoutDirection),
        end = calculateEndPadding(layoutDirection) - other.calculateEndPadding(layoutDirection),
        top = calculateTopPadding() - other.calculateTopPadding(),
        bottom = calculateBottomPadding() - other.calculateBottomPadding(),
    )
}
