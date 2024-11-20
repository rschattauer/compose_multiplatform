import Foundation
import SwiftUI
import shared
@_spi(Experimental) import MapboxMaps

struct BridgeSwiftUIMap: View {
    
    @ObservedObject var observable: SwiftBridgeMapObservable
    @Environment(\.colorScheme) var colorScheme
    @State var viewport = Viewport.camera(center: .init(latitude: 48.2082, longitude: 16.3719), zoom: 14, bearing: 0, pitch: 0)

    var body: some View {
        Map(viewport: $viewport) {
            ForEvery(observable.polygons, id: \.self) { polygon in
                let ringCoords = polygon.latLngs.map { latLng in
                    CLLocationCoordinate2D(latitude: latLng.latitude, longitude: latLng.longitude)
                }
                let ring = Ring(coordinates: ringCoords)
                let poly = MapboxMaps.Polygon(outerRing: ring)
                PolygonAnnotation(polygon: poly)
            }
        }
        .ornamentOptions(
            OrnamentOptions(
                logo: LogoViewOptions(
                    margins: CGPoint(
                        x: CGFloat(8.0),
                        y: CGFloat(observable.contentPadding.calculateBottomPadding())
                    )
                ),
                attributionButton: AttributionButtonOptions(
                    margins: CGPoint(
                        x: CGFloat(8.0),
                        y: CGFloat(observable.contentPadding.calculateBottomPadding())
                    )
                )
            )
        )
        .mapStyle(.standard(lightPreset: colorScheme == .light ? .day : .dusk))
        .ignoresSafeArea()
    }
}

struct PolygonWrapper: Hashable {
    let polygon: shared.Polygon

    func hash(into hasher: inout Hasher) {
        hasher.combine(polygon.latLngs)
    }

    static func == (lhs: PolygonWrapper, rhs: PolygonWrapper) -> Bool {
        return lhs.polygon.latLngs == rhs.polygon.latLngs
    }
}
