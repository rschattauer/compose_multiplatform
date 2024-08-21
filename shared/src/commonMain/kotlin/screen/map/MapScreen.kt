package screen.map

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.dp
import composemultiplatform.shared.generated.resources.Res
import composemultiplatform.shared.generated.resources.map
import dev.chrisbanes.haze.HazeState
import dev.chrisbanes.haze.haze
import dev.chrisbanes.haze.hazeChild
import dev.chrisbanes.haze.materials.HazeMaterials
import kotlinx.collections.immutable.persistentListOf
import kotlinx.coroutines.delay
import model.coordinate.LatLng
import model.coordinate.Polygon
import org.jetbrains.compose.resources.stringResource
import ui.component.Map

@Composable
fun MapScreen(
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp),
) {
    var polygons by remember { mutableStateOf(persistentListOf<Polygon>()) }
    val hazeState = remember { HazeState() }
    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.Transparent),
                title = {
                    Text(stringResource(Res.string.map))
                },
                modifier = Modifier.hazeChild(
                    state = hazeState,
                    style = HazeMaterials.ultraThin(containerColor = Color.White),
                ),
            )
        },
        content = { paddingValues ->
            Box(modifier = Modifier.haze(state = hazeState)) {
                Map(
                    modifier = modifier.fillMaxSize(),
                    contentPadding = paddingValues + contentPadding,
                    polygons = polygons,
                )
            }
        },
        modifier = Modifier,
    )
    LaunchedEffect(Unit) {
        delay(5_000)
        polygons = persistentListOf(
            Polygon(
                latLngs = listOf(
                    LatLng(48.213232, 16.367753),
                    LatLng(48.212718, 16.365004),
                    LatLng(48.211173, 16.366636),
                    LatLng(48.213461, 16.374366),
                ),
            ),
        )
        delay(5_000)
        polygons = persistentListOf(
            Polygon(
                latLngs = listOf(
                    LatLng(48.208085, 16.366379),
                    LatLng(48.206197, 16.362170),
                    LatLng(48.205225, 16.367495),
                ),
            ),
            Polygon(
                latLngs = listOf(
                    LatLng(48.211002, 16.382525),
                    LatLng(48.212489, 16.374366),
                    LatLng(48.208199, 16.373507),
                    LatLng(48.202422, 16.381495),
                    LatLng(48.208428, 16.379348),
                ),
            ),
        )
    }
}

@Composable
operator fun PaddingValues.plus(other: PaddingValues): PaddingValues {
    val layoutDirection = LocalLayoutDirection.current
    return PaddingValues(
        start = calculateStartPadding(layoutDirection) + other.calculateStartPadding(layoutDirection),
        end = calculateEndPadding(layoutDirection) + other.calculateEndPadding(layoutDirection),
        top = calculateTopPadding() + other.calculateTopPadding(),
        bottom = calculateBottomPadding() + other.calculateBottomPadding(),
    )
}
