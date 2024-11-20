package ui.component

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.dp
import com.mapbox.geojson.Point
import com.mapbox.maps.MapboxExperimental
import com.mapbox.maps.dsl.cameraOptions
import com.mapbox.maps.extension.compose.MapboxMap
import com.mapbox.maps.extension.compose.animation.viewport.rememberMapViewportState
import com.mapbox.maps.extension.compose.annotation.generated.PolygonAnnotation
import kotlinx.collections.immutable.ImmutableList
import model.coordinate.LatLng
import model.coordinate.Polygon

@OptIn(MapboxExperimental::class)
@Composable
actual fun ManualBridgeMap(
    modifier: Modifier,
    contentPadding: PaddingValues,
    polygons: ImmutableList<Polygon>,
) {
    val vienna = LatLng(48.2082, 16.3719)
    val systemPaddingValues = PaddingValues(
        top = contentPadding.calculateTopPadding(),
        bottom = contentPadding.calculateBottomPadding(),
    )
    val mapViewportState = rememberMapViewportState {
        flyTo(
            cameraOptions {
                zoom(15.0)
                center(Point.fromLngLat(vienna.longitude, vienna.latitude))
                pitch(0.0)
                bearing(0.0)
            },
        )
    }
    MapboxMap(
        modifier = Modifier.fillMaxSize(),
        mapViewportState = mapViewportState,
        attribution = { Attribution(contentPadding = PaddingValues(92.dp, 4.dp, 4.dp, 4.dp) + systemPaddingValues) },
        logo = { Logo(contentPadding = PaddingValues(4.dp) + systemPaddingValues) },
        scaleBar = { ScaleBar(contentPadding = PaddingValues(4.dp) + systemPaddingValues) },
        compass = { Compass(contentPadding = PaddingValues(4.dp) + systemPaddingValues) },
    ) {
        polygons.forEach { polygon ->
            PolygonAnnotation(
                points = listOf(polygon.latLngs.map { Point.fromLngLat(it.longitude, it.latitude) }),
            )
        }
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

@Composable
private operator fun PaddingValues.plus(other: PaddingValues): PaddingValues {
    val layoutDirection = LocalLayoutDirection.current
    return PaddingValues(
        start = calculateStartPadding(layoutDirection) + other.calculateStartPadding(layoutDirection),
        end = calculateEndPadding(layoutDirection) + other.calculateEndPadding(layoutDirection),
        top = calculateTopPadding() + other.calculateTopPadding(),
        bottom = calculateBottomPadding() + other.calculateBottomPadding(),
    )
}
