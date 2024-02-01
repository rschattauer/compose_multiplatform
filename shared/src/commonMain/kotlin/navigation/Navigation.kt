package navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import moe.tlaster.precompose.navigation.NavHost
import moe.tlaster.precompose.navigation.NavOptions
import moe.tlaster.precompose.navigation.Navigator
import moe.tlaster.precompose.navigation.PopUpTo
import screen.detail.DetailScreen
import screen.onboarding.OnboardingScreen
import screen.overview.OverviewScreen

@Composable
fun Navigation(
    navigator: Navigator,
    modifier: Modifier = Modifier,
) {
    NavHost(
        navigator = navigator,
        navTransition = NavigationTransition.default,
        initialRoute = Route.Onboarding.route,
        modifier = modifier.fillMaxSize(),
    ) {
        scene(
            route = Route.Detail.route,
            navTransition = NavigationTransition.side,
        ) {
            DetailScreen(onBackClick = { navigator.goBack() })
        }
        scene(route = Route.Onboarding.route) {
            OnboardingScreen(
                onOnboardingCompleted = {
                    navigator.navigate(
                        route = Route.Overview.route,
                        options = NavOptions(launchSingleTop = true, popUpTo = PopUpTo.First(inclusive = true)),
                    )
                },
            )
        }
        scene(route = Route.Overview.route) {
            OverviewScreen(navigator = navigator)
        }
    }
}
