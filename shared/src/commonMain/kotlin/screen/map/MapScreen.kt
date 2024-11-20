package screen.map

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.collections.immutable.persistentListOf
import kotlinx.coroutines.delay
import model.coordinate.LatLng
import model.coordinate.Polygon
import ui.component.ManualBridgeMap

@Composable
fun MapScreen(
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp),
) {
    var polygons by remember { mutableStateOf(persistentListOf<Polygon>()) }
    ManualBridgeMap(
        modifier = modifier.fillMaxSize(),
        contentPadding = contentPadding,
        polygons = polygons,
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
