package app

import androidx.compose.foundation.background
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import moe.tlaster.precompose.PreComposeApp
import moe.tlaster.precompose.navigation.rememberNavigator
import navigation.Navigation
import org.koin.compose.KoinContext
import ui.theme.App
import ui.theme.AppTheme

@Composable
fun Root(modifier: Modifier = Modifier) {
    PreComposeApp {
        KoinContext {
            val navigator = rememberNavigator()
            AppTheme {
                Navigation(
                    navigator = navigator,
                    modifier = modifier.background(color = App.colors.materialColors.background),
                )
            }
        }
    }
}
