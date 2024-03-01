import androidx.compose.runtime.ExperimentalComposeApi
import androidx.compose.ui.platform.AccessibilityDebugLogger
import androidx.compose.ui.platform.AccessibilitySyncOptions
import androidx.compose.ui.window.ComposeUIViewController
import app.Root
import platform.UIKit.UIViewController

@OptIn(ExperimentalComposeApi::class)
fun mainViewController(): UIViewController = ComposeUIViewController(
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
    Root()
}
