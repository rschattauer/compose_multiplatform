package navigation

sealed class Route(val route: String) {
    data object Detail : Route(route = "/detail")
    data object Home : Route(route = "/home")
    data object Map : Route(route = "/map")
    data object Onboarding : Route(route = "/onboarding")
    data object Overview : Route(route = "/overview")
    data object Video : Route(route = "/video")
}
