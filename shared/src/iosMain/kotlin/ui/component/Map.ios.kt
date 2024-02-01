package ui.component

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.interop.UIKitView
import kotlinx.collections.immutable.ImmutableList
import model.coordinate.Polygon
import platform.UIKit.UIView

@Composable
actual fun Map(modifier: Modifier, contentPadding: PaddingValues, polygons: ImmutableList<Polygon>) {
    val factory = remember { mapViewFactory() }
    UIKitView(
        factory = { factory.view },
        modifier = modifier,
    )
    LaunchedEffect(contentPadding) {
        factory.setContentPadding(contentPadding = contentPadding)
    }
    LaunchedEffect(polygons) {
        factory.setPolygons(polygons = polygons)
    }
}

private lateinit var mapViewFactory: () -> MapViewFactory
fun setFactory(factory: () -> MapViewFactory) {
    mapViewFactory = factory
}

interface MapViewFactory {

    val view: UIView
    fun setContentPadding(contentPadding: PaddingValues)
    fun setPolygons(polygons: ImmutableList<Polygon>)
}
