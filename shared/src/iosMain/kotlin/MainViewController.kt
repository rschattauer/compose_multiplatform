import androidx.compose.ui.window.ComposeUIViewController
import app.Root
import platform.UIKit.UIViewController

fun mainViewController(): UIViewController = ComposeUIViewController {
    Root()
}
