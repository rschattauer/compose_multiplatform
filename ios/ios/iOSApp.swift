import SwiftUI
import shared

@main
struct iOSApp: SwiftUI.App {

    init() {
        KoinKt.doInitKoin()
        Map_iosKt.setFactory(factory: mapViewFactory)
    }

	var body: some Scene {
		WindowGroup {
			ContentView()
		}
	}
}
