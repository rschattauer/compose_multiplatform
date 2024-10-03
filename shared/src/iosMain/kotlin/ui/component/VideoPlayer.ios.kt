package ui.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.viewinterop.UIKitInteropProperties
import androidx.compose.ui.viewinterop.UIKitView
import platform.AVFoundation.AVLayerVideoGravityResize
import platform.AVFoundation.AVLayerVideoGravityResizeAspect
import platform.AVFoundation.AVLayerVideoGravityResizeAspectFill
import platform.AVFoundation.AVPlayer
import platform.AVFoundation.AVPlayerItem
import platform.AVFoundation.AVURLAsset
import platform.AVFoundation.play
import platform.AVFoundation.replaceCurrentItemWithPlayerItem
import platform.AVKit.AVPlayerViewController
import platform.CoreGraphics.CGRectMake
import platform.Foundation.NSURL

@Composable
actual fun VideoPlayer(
    url: String,
    modifier: Modifier,
) = with(LocalDensity.current) {
    val player = remember { AVPlayer() }
    val controller = remember {
        AVPlayerViewController(null, null).apply {
            this.player = player
            this.videoGravity = AVLayerVideoGravityResizeAspect
            this.showsPlaybackControls = true
        }
    }
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier,
    ) {
        UIKitView(
            factory = { controller.view },
            properties = UIKitInteropProperties(isInteractive = true, isNativeAccessibilityEnabled = true),
            modifier = Modifier
                .fillMaxSize()
                .onGloballyPositioned { coordinates ->
                    val size = coordinates.size
                    val frame = CGRectMake(
                        x = 0.0,
                        y = 0.0,
                        width = size.width.toDp().value.toDouble(),
                        height = size.height.toDp().value.toDouble(),
                    )
                    controller.view.setFrame(frame)
                },
        )
    }
    LaunchedEffect(url) {
        val asset = AVURLAsset(NSURL(string = url), null)
        val playerItem = AVPlayerItem(asset = asset)
        player.replaceCurrentItemWithPlayerItem(item = playerItem)
        player.play()
    }
    DisposableEffect(url) {
        onDispose {
            player.replaceCurrentItemWithPlayerItem(null)
        }
    }
}
