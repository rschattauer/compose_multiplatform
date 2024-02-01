package screen.overview

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp
import composemultiplatform.shared.generated.resources.Res
import moe.tlaster.precompose.navigation.NavHost
import moe.tlaster.precompose.navigation.NavOptions
import moe.tlaster.precompose.navigation.Navigator
import moe.tlaster.precompose.navigation.rememberNavigator
import navigation.NavigationTransition
import navigation.Route
import org.jetbrains.compose.resources.stringResource
import screen.home.HomeScreen
import screen.map.MapScreen
import screen.video.VideoScreen
import ui.icon.Icons
import ui.icon.icons.Home
import ui.icon.icons.Map
import ui.icon.icons.Movie

@Composable
fun OverviewScreen(
    navigator: Navigator,
    modifier: Modifier = Modifier,
) {
    val tabNavigator = rememberNavigator()
    Scaffold(
        bottomBar = {
            NavigationBar(Modifier) {
                val homeText = stringResource(Res.string.home)
                NavigationBarItem(
                    selected = false,
                    onClick = { tabNavigator.navigate(Route.Home.route, NavOptions(launchSingleTop = true)) },
                    icon = { Icon(imageVector = Icons.Home, contentDescription = null) },
                    label = { Text(text = homeText) },
                    modifier = Modifier.semantics { contentDescription = homeText },
                )
                val mapText = stringResource(Res.string.map)
                NavigationBarItem(
                    selected = false,
                    onClick = { tabNavigator.navigate(Route.Map.route, NavOptions(launchSingleTop = true)) },
                    icon = { Icon(imageVector = Icons.Map, contentDescription = null) },
                    label = { Text(text = mapText) },
                    modifier = Modifier.semantics { contentDescription = mapText },
                )
                val videoText = stringResource(Res.string.video)
                NavigationBarItem(
                    selected = false,
                    onClick = { tabNavigator.navigate(Route.Video.route, NavOptions(launchSingleTop = true)) },
                    icon = { Icon(imageVector = Icons.Movie, contentDescription = null) },
                    label = { Text(text = videoText) },
                    modifier = Modifier.semantics { contentDescription = videoText },
                )
            }
        },
        content = { contentPadding ->
            TabNavigation(
                navigator = navigator,
                tabNavigator = tabNavigator,
                contentPadding = contentPadding,
            )
        },
        modifier = modifier.fillMaxSize(),
    )
}

@Composable
private fun TabNavigation(
    navigator: Navigator,
    tabNavigator: Navigator,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(all = 0.dp),
) {
    NavHost(
        navigator = tabNavigator,
        navTransition = NavigationTransition.default,
        initialRoute = Route.Home.route,
        modifier = modifier.fillMaxSize(),
    ) {
        scene(
            route = Route.Home.route,
            navTransition = NavigationTransition.sheet,
        ) {
            HomeScreen(contentPadding = contentPadding, onClick = { navigator.navigate(Route.Detail.route) })
        }
        scene(
            route = Route.Map.route,
            navTransition = NavigationTransition.sheet,
        ) {
            MapScreen(contentPadding = contentPadding)
        }
        scene(route = Route.Video.route) {
            VideoScreen(contentPadding = contentPadding)
        }
    }
}
