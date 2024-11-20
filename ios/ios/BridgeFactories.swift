import UIKit
import SwiftUI
import shared

class SwiftUISharedFactory : SharedFactory {
    func createSwiftBridgeMap(observable: shared.SwiftBridgeMapObservable) -> AnyView {
        return AnyView(BridgeSwiftUIMap(observable: observable))
    }
}
