package ui.component

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import com.mapbox.geojson.Point
import com.mapbox.maps.MapboxExperimental
import com.mapbox.maps.extension.compose.DefaultSettingsProvider.defaultAttributionSettings
import com.mapbox.maps.extension.compose.DefaultSettingsProvider.defaultCompassSettings
import com.mapbox.maps.extension.compose.DefaultSettingsProvider.defaultLogoSettings
import com.mapbox.maps.extension.compose.DefaultSettingsProvider.defaultScaleBarSettings
import com.mapbox.maps.extension.compose.MapboxMap
import com.mapbox.maps.extension.compose.animation.viewport.MapViewportState
import com.mapbox.maps.extension.compose.annotation.generated.PolygonAnnotation
import kotlinx.collections.immutable.ImmutableList
import model.coordinate.LatLng
import model.coordinate.Polygon

@OptIn(MapboxExperimental::class)
@Composable
actual fun Map(
    modifier: Modifier,
    contentPadding: PaddingValues,
    polygons: ImmutableList<Polygon>,
) = with(LocalDensity.current) {
    val context = LocalContext.current
    val vienna = LatLng(48.2082, 16.3719)
    val logoSettings = remember(contentPadding) {
        defaultLogoSettings(context).toBuilder().apply {
            setMarginTop(marginTop + contentPadding.calculateTopPadding().toPx())
            setMarginBottom(marginBottom + contentPadding.calculateBottomPadding().toPx())
            setMarginLeft(marginLeft)
            setMarginRight(marginRight)
        }.build()
    }

    val scaleBarSettings = remember(contentPadding) {
        defaultScaleBarSettings(context).toBuilder().apply {
            setMarginTop(marginTop + contentPadding.calculateTopPadding().toPx())
            setMarginBottom(marginBottom + contentPadding.calculateBottomPadding().toPx())
            setMarginLeft(marginLeft)
            setMarginRight(marginRight)
        }.build()
    }
    val attributionSettings = remember(contentPadding) {
        defaultAttributionSettings(context).toBuilder().apply {
            setMarginTop(marginTop + contentPadding.calculateTopPadding().toPx())
            setMarginBottom(marginBottom + contentPadding.calculateBottomPadding().toPx())
            setMarginLeft(marginLeft)
            setMarginRight(marginRight)
        }.build()
    }
    val compassSettings = remember(contentPadding) {
        defaultCompassSettings(context).toBuilder().apply {
            setMarginTop(marginTop + contentPadding.calculateTopPadding().toPx())
            setMarginBottom(marginBottom + contentPadding.calculateBottomPadding().toPx())
            setMarginLeft(marginLeft)
            setMarginRight(marginRight)
        }.build()
    }
    MapboxMap(
        modifier = Modifier.fillMaxSize(),
        mapViewportState = MapViewportState().apply {
            setCameraOptions {
                zoom(15.0)
                center(Point.fromLngLat(vienna.longitude, vienna.latitude))
                pitch(0.0)
                bearing(0.0)
            }
        },
        logoSettings = logoSettings,
        scaleBarSettings = scaleBarSettings,
        attributionSettings = attributionSettings,
        compassSettings = compassSettings,
    ) {
        polygons.forEach { polygon ->
            PolygonAnnotation(
                points = listOf(polygon.latLngs.map { Point.fromLngLat(it.longitude, it.latitude) }),
            )
        }
    }
}
