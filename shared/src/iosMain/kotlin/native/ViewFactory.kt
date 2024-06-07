package native

import androidx.compose.foundation.layout.PaddingValues
import kotlinx.collections.immutable.ImmutableList
import kotlinx.coroutines.flow.StateFlow
import model.coordinate.Polygon
import ui.component.MapWithSwiftUIViewFactory
import ui.component.MapWithUIKitViewFactory

fun setViewFactories(
    mapWithUIKitViewFactory: () -> MapWithUIKitViewFactory,
    mapWithSwiftUIViewFactory: (
        polygonsState: StateFlow<ImmutableList<Polygon>>,
        contentPaddingState: StateFlow<PaddingValues>,
    ) -> MapWithSwiftUIViewFactory,
) {
    ui.component.mapWithUIKitViewFactory = mapWithUIKitViewFactory
    ui.component.mapWithSwiftUIViewFactory = mapWithSwiftUIViewFactory
}
