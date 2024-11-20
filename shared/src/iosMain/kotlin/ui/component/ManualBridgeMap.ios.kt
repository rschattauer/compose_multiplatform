package ui.component

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.UIKitInteropInteractionMode
import androidx.compose.ui.viewinterop.UIKitInteropProperties
import androidx.compose.ui.viewinterop.UIKitView
import androidx.compose.ui.viewinterop.UIKitViewController
import kotlinx.collections.immutable.ImmutableList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import model.coordinate.Polygon
import platform.UIKit.UIView
import platform.UIKit.UIViewController

@Composable
actual fun ManualBridgeMap(modifier: Modifier, contentPadding: PaddingValues, polygons: ImmutableList<Polygon>) {
    when {
        // Show iOS map using touchlabs swift bridge
        true -> SwiftBridgeMap(modifier, contentPadding, polygons)
        // Show iOS map using manual bridge with UIKit
        false -> MapWithUIKit(contentPadding, polygons, modifier)
        // Show iOS map using manual bridge with SwiftUI
        false -> MapWithSwiftUI(contentPadding, polygons, modifier)
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
private fun MapWithUIKit(
    contentPadding: PaddingValues,
    polygons: ImmutableList<Polygon>,
    modifier: Modifier = Modifier,
) {
    val factory = remember { mapWithUIKitViewFactory() }
    UIKitView(
        factory = { factory.view },
        update = {
            factory.setContentPadding(contentPadding = contentPadding)
            factory.setPolygons(polygons = polygons)
        },
        properties = UIKitInteropProperties(
            interactionMode = UIKitInteropInteractionMode.NonCooperative,
            isNativeAccessibilityEnabled = true,
        ),
        modifier = modifier,
    )
}

internal lateinit var mapWithUIKitViewFactory: () -> MapWithUIKitViewFactory

interface MapWithUIKitViewFactory {
    val view: UIView
    fun setContentPadding(contentPadding: PaddingValues)
    fun setPolygons(polygons: ImmutableList<Polygon>)
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
private fun MapWithSwiftUI(
    contentPadding: PaddingValues,
    polygons: ImmutableList<Polygon>,
    modifier: Modifier = Modifier,
) {
    val polygonsState = remember { MutableStateFlow(polygons) }
    val contentPaddingState = remember { MutableStateFlow(contentPadding) }
    val factory = remember { mapWithSwiftUIViewFactory(polygonsState.asStateFlow(), contentPaddingState.asStateFlow()) }
    UIKitViewController(
        factory = { factory.viewController },
        update = {
            polygonsState.update { polygons }
            contentPaddingState.update { contentPadding }
        },
        properties = UIKitInteropProperties(
            interactionMode = UIKitInteropInteractionMode.NonCooperative,
            isNativeAccessibilityEnabled = true,
        ),
        modifier = modifier,
    )
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun MapCustomInterop(
    modifier: Modifier,
    factory: () -> UIViewController,
) {
    UIKitViewController(
        factory = factory,
        properties = UIKitInteropProperties(
            interactionMode = UIKitInteropInteractionMode.NonCooperative,
            isNativeAccessibilityEnabled = true,
        ),
        modifier = modifier,
    )
}

internal lateinit var mapWithSwiftUIViewFactory: (
    polygonsState: StateFlow<ImmutableList<Polygon>>,
    contentPaddingState: StateFlow<PaddingValues>,
) -> MapWithSwiftUIViewFactory

interface MapWithSwiftUIViewFactory {
    val viewController: UIViewController
}
