import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ExperimentalComposeApi
import androidx.compose.ui.platform.AccessibilityDebugLogger
import androidx.compose.ui.platform.AccessibilitySyncOptions
import androidx.compose.ui.window.ComposeUIViewController
import app.Root
import co.touchlab.compose.swift.bridge.LocalSharedFactory
import co.touchlab.compose.swift.bridge.SharedFactory
import platform.UIKit.UIViewController

@OptIn(ExperimentalComposeApi::class)
fun MainViewController(
    sharedFactory: SharedFactory,
): UIViewController = ComposeUIViewController(
    configure = {
        // on simulator I could only make it work with always, but it's a little broken
        // accessibilitySyncOptions = AccessibilitySyncOptions.Always(
        accessibilitySyncOptions = AccessibilitySyncOptions.WhenRequiredByAccessibilityServices(
            debugLogger = object : AccessibilityDebugLogger {
                override fun log(message: Any?) {
                    if (message == null) {
                        println()
                    } else {
                        println("[a11y]: $message")
                    }
                }
            },
        )
    },
) {
    CompositionLocalProvider(
        LocalSharedFactory provides sharedFactory,
    ) {
        Root()
    }
}
