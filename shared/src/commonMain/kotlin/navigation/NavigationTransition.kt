package navigation

import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.slideOutVertically
import moe.tlaster.precompose.navigation.transition.NavTransition
import kotlin.math.roundToInt

data object NavigationTransition {
    val default: NavTransition = NavTransition()
    val side: NavTransition = NavTransition(
        createTransition = slideInHorizontally { it },
        destroyTransition = slideOutHorizontally { it },
        pauseTransition = slideOutHorizontally { (-it * 0.05f).roundToInt() },
        resumeTransition = slideInHorizontally { (-it * 0.95f).roundToInt() },
    )
    val sheet: NavTransition = NavTransition(
        createTransition = slideInVertically { it },
        destroyTransition = slideOutVertically { it },
        pauseTransition = slideOutVertically { (-it * 0.05f).roundToInt() },
        resumeTransition = slideInVertically { (-it * 0.95f).roundToInt() },
    )
}
