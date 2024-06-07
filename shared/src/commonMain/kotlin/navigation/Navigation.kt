package navigation

import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navOptions
import screen.detail.DetailScreen
import screen.detail.DetailViewModel.Companion.DETAIL_TICK_ARGUMENT_KEY
import screen.onboarding.OnboardingScreen
import screen.overview.OverviewScreen

@Composable
fun Navigation(
    navHostController: NavHostController,
    modifier: Modifier = Modifier,
) {
    NavHost(
        navController = navHostController,
        startDestination = Route.Onboarding.route,
        enterTransition = { fadeIn() },
        exitTransition = { fadeOut() },
        popEnterTransition = { fadeIn() },
        popExitTransition = { fadeOut() },
        modifier = modifier.fillMaxSize(),
    ) {
        composable(
            route = Route.Detail.route,
            arguments = listOf(
                navArgument(DETAIL_TICK_ARGUMENT_KEY) { type = NavType.IntType },
            ),
        ) {
            val initialTick = checkNotNull(it.arguments?.getInt(DETAIL_TICK_ARGUMENT_KEY))
            DetailScreen(initialTick = initialTick, onBackClick = { navHostController.popBackStack() })
        }
        composable(route = Route.Onboarding.route) {
            OnboardingScreen(
                onOnboardingComplete = {
                    navHostController.navigate(
                        route = Route.Overview.route,
                        navOptions = navOptions {
                            launchSingleTop = true
                            popUpTo(Route.Onboarding.route) { inclusive = true }
                        },
                    )
                },
            )
        }
        composable(route = Route.Overview.route) {
            OverviewScreen(navHostController = navHostController)
        }
    }
}
