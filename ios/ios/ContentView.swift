import UIKit
import SwiftUI
import shared

struct ComposeView: UIViewControllerRepresentable {
    func makeUIViewController(context: Context) -> UIViewController {
        return MainViewController(sharedFactory: SwiftUISharedFactory())
    }

    func updateUIViewController(_ uiViewController: UIViewController, context: Context) {}
}

struct ContentView: View {
    var body: some View {
        ComposeView().ignoresSafeArea(.all)
    }
}
