import SwiftUI
import shared

@main
struct iOSApp: SwiftUI.App {

    init() {
        KoinKt.doInitKoin()
        ViewFactoryKt.setViewFactories(
            mapWithUIKitViewFactory: mapWithUIKitViewFactory,
            mapWithSwiftUIViewFactory: mapWithSwiftUIViewFactory
        )
    }

	var body: some Scene {
		WindowGroup {
			ContentView()
		}
	}
}
