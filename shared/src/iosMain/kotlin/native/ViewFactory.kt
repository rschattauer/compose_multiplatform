package native

import ui.component.MapViewFactory

fun setViewFactory(mapViewFactory: () -> MapViewFactory) {
    ui.component.mapViewFactory = mapViewFactory
}
