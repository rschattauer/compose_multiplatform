import SwiftUI
import shared

@main
struct iOSApp: SwiftUI.App {

    init() {
        KoinKt.doInitKoin()
        ViewFactoryKt.setViewFactory(mapViewFactory: mapViewFactory)
    }

	var body: some Scene {
		WindowGroup {
			ContentView()
		}
	}
}
