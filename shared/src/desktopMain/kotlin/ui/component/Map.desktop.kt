package ui.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import kotlinx.collections.immutable.ImmutableList
import model.coordinate.Polygon

@Composable
actual fun ManualBridgeMap(
    modifier: Modifier,
    contentPadding: PaddingValues,
    polygons: ImmutableList<Polygon>,
) {
    Column(modifier = modifier.fillMaxSize().padding(contentPadding)) {
        Text(text = "Please implement somewhat of a jvm map implementation. I was focusing on Android/iOS here.")
        polygons.forEach { polygon -> Text(text = "Polygon: ${polygon.latLngs}") }
    }
}

@Composable
actual fun SwiftBridgeMap(
    modifier: Modifier,
    contentPadding: PaddingValues,
    polygons: ImmutableList<Polygon>,
) = ManualBridgeMap(
    modifier = modifier,
    contentPadding = contentPadding,
    polygons = polygons,
)
