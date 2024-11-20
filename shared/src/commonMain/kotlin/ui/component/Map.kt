package ui.component

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import co.touchlab.compose.swift.bridge.ExpectSwiftView
import co.touchlab.compose.swift.bridge.ExpectSwiftViewCustomInteropComposable
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf
import model.coordinate.Polygon

@Composable
expect fun ManualBridgeMap(
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(all = 0.dp),
    polygons: ImmutableList<Polygon> = persistentListOf(),
)

@ExpectSwiftView
@ExpectSwiftViewCustomInteropComposable("ui.component.MapCustomInterop")
@Composable
expect fun SwiftBridgeMap(
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(all = 0.dp),
    polygons: ImmutableList<Polygon> = persistentListOf(),
)
