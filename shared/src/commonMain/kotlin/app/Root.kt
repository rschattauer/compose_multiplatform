package app

import androidx.compose.foundation.background
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import navigation.Navigation
import org.koin.compose.KoinContext
import ui.theme.App
import ui.theme.AppTheme

@Composable
fun Root(modifier: Modifier = Modifier) {
    KoinContext {
        val navHostController = rememberNavController()
        AppTheme {
            Navigation(
                navHostController = navHostController,
                modifier = modifier.background(color = App.colors.materialColors.background),
            )
        }
    }
}
