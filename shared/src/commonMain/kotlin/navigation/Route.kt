package navigation

import screen.detail.DetailViewModel.Companion.DETAIL_TICK_ARGUMENT_KEY

sealed class Route(val route: String) {
    data object Detail : Route(route = "/detail/{$DETAIL_TICK_ARGUMENT_KEY}") {
        fun navigationRoute(tick: Int) = route.replace("{$DETAIL_TICK_ARGUMENT_KEY}", tick.toString())
    }

    data object Home : Route(route = "/home")
    data object Map : Route(route = "/map")
    data object Onboarding : Route(route = "/onboarding")
    data object Overview : Route(route = "/overview")
    data object Video : Route(route = "/video")
}
