package screen.overview

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.compose.LifecycleEventEffect
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import composemultiplatform.shared.generated.resources.Res
import composemultiplatform.shared.generated.resources.home
import composemultiplatform.shared.generated.resources.home_resume_message
import composemultiplatform.shared.generated.resources.map
import composemultiplatform.shared.generated.resources.video
import kotlinx.coroutines.launch
import navigation.Route
import org.jetbrains.compose.resources.stringResource
import screen.home.HomeScreen
import screen.map.MapScreen
import screen.video.VideoScreen
import ui.composition.LocalSnackbarHostState
import ui.icon.Icons
import ui.icon.icons.Home
import ui.icon.icons.Map
import ui.icon.icons.Movie
import kotlin.random.Random.Default.nextInt

@Composable
fun OverviewScreen(
    navHostController: NavHostController,
    modifier: Modifier = Modifier,
) {
    val tabNavHostController = rememberNavController()
    val snackbarHostState = remember { SnackbarHostState() }
    CompositionLocalProvider(LocalSnackbarHostState provides snackbarHostState) {
        Scaffold(
            snackbarHost = {
                SnackbarHost(hostState = snackbarHostState)
            },
            bottomBar = {
                NavigationBar(Modifier) {
                    val homeText = stringResource(Res.string.home)
                    NavigationBarItem(
                        selected = false,
                        onClick = {
                            tabNavHostController.navigate(Route.Home.route, navOptions { launchSingleTop = true })
                        },
                        icon = { Icon(imageVector = Icons.Home, contentDescription = null) },
                        label = { Text(text = homeText) },
                        modifier = Modifier.semantics { contentDescription = homeText },
                    )
                    val mapText = stringResource(Res.string.map)
                    NavigationBarItem(
                        selected = false,
                        onClick = {
                            tabNavHostController.navigate(
                                Route.Map.route,
                                navOptions { launchSingleTop = true },
                            )
                        },
                        icon = { Icon(imageVector = Icons.Map, contentDescription = null) },
                        label = { Text(text = mapText) },
                        modifier = Modifier.semantics { contentDescription = mapText },
                    )
                    val videoText = stringResource(Res.string.video)
                    NavigationBarItem(
                        selected = false,
                        onClick = {
                            tabNavHostController.navigate(Route.Video.route, navOptions { launchSingleTop = true })
                        },
                        icon = { Icon(imageVector = Icons.Movie, contentDescription = null) },
                        label = { Text(text = videoText) },
                        modifier = Modifier.semantics { contentDescription = videoText },
                    )
                }
            },
            content = { contentPadding ->
                TabNavigation(
                    navHostController = navHostController,
                    tabNavHostController = tabNavHostController,
                    contentPadding = contentPadding,
                )
            },
            modifier = modifier.fillMaxSize(),
        )
    }
}

@Composable
private fun TabNavigation(
    navHostController: NavHostController,
    tabNavHostController: NavHostController,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(all = 0.dp),
) {
    NavHost(
        navController = tabNavHostController,
        startDestination = Route.Home.route,
        modifier = modifier.fillMaxSize(),
    ) {
        composable(route = Route.Home.route) {
            val snackbarHostState = LocalSnackbarHostState.current
            val scope = rememberCoroutineScope()
            val onStartMessage = stringResource(Res.string.home_resume_message)
            LifecycleEventEffect(event = Lifecycle.Event.ON_START) {
                scope.launch {
                    snackbarHostState.showSnackbar(message = onStartMessage)
                }
            }
            HomeScreen(
                contentPadding = contentPadding,
                onClick = { navHostController.navigate(Route.Detail.navigationRoute(tick = nextInt(100))) },
            )
        }
        composable(route = Route.Map.route) {
            MapScreen(contentPadding = contentPadding)
        }
        composable(route = Route.Video.route) {
            VideoScreen(contentPadding = contentPadding)
        }
    }
}
