package preview

import androidx.compose.runtime.Composable
import screen.home.HomeScreen
import ui.theme.AppTheme

@Composable
@androidx.compose.ui.tooling.preview.Preview
private fun HomeScreenPreview() {
    AppTheme {
        HomeScreen()
    }
}
