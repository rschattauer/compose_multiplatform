import Foundation
import SwiftUI
import shared
@_spi(Experimental) import MapboxMaps

func mapWithSwiftUIViewFactory(
    polygonsState: SkieSwiftStateFlow<[shared.Polygon]>,
    contentPaddingState: SkieSwiftStateFlow<Foundation_layoutPaddingValues>
) -> MapWithSwiftUIViewFactory {
    return MapSwiftUIViewContainer(
        polygonsState: polygonsState,
        contentPaddingState: contentPaddingState
    )
}

class MapSwiftUIViewContainer: MapWithSwiftUIViewFactory {
    
    var viewController: UIViewController
    
    init(polygonsState: SkieSwiftStateFlow<[shared.Polygon]>, contentPaddingState: SkieSwiftStateFlow<Foundation_layoutPaddingValues>) {
        self.viewController = UIHostingController(rootView: SwiftUIMap(polygonsState: polygonsState, contentPaddingState: contentPaddingState))
    }
}

struct SwiftUIMap: View {

    var polygonsState: SkieSwiftStateFlow<[shared.Polygon]>
    var contentPaddingState: SkieSwiftStateFlow<Foundation_layoutPaddingValues>
    
    init(
        polygonsState: SkieSwiftStateFlow<[shared.Polygon]>,
         contentPaddingState: SkieSwiftStateFlow<Foundation_layoutPaddingValues>
    ) {
        self.polygonsState = polygonsState
        self.contentPaddingState = contentPaddingState
    }
    
    @Environment(\.colorScheme) var colorScheme
    @State var polygons: Polygons?
    @State var contentPadding: Foundation_layoutPaddingValues?
    @State var viewport = Viewport.camera(center: .init(latitude: 48.2082, longitude: 16.3719), zoom: 14, bearing: 0, pitch: 0)

    var body: some View {
        Map(viewport: $viewport) {
            ForEvery($polygons.wrappedValue?.polygons ?? [], id: \.self) { polygon in
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
                logo: LogoViewOptions(margins: CGPoint(x: CGFloat(8.0), y: CGFloat($contentPadding.wrappedValue?.calculateBottomPadding() ?? 0.0))),
                attributionButton: AttributionButtonOptions(margins: CGPoint(x: CGFloat(8.0), y: CGFloat($contentPadding.wrappedValue?.calculateBottomPadding() ?? 0.0)))
            )
        )
        .mapStyle(.standard(lightPreset: colorScheme == .light ? .day : .dusk))
        .ignoresSafeArea()
        .task {
            for await polygons in polygonsState {
                let polygons = polygons.map { polygon in
                    Polygon(latLngs: polygon.latLngs.map { latLng in
                        PolygonLatLng(latitude: latLng.latitude, longitude: latLng.longitude)
                    })
                }
                self.polygons = Polygons(polygons: polygons)
            }
        }
        .task {
            for await contentPadding in contentPaddingState {
                self.contentPadding = contentPadding
            }
        }
    }
}

struct PolygonLatLng: Hashable {
    let latitude: Double
    let longitude: Double
}

struct Polygon: Hashable {
    
    let latLngs: [PolygonLatLng]
    
    static func == (lhs: Polygon, rhs: Polygon) -> Bool {
        return lhs.latLngs == rhs.latLngs
    }
    
    func hash(into hasher: inout Hasher) {
        hasher.combine(latLngs)
    }
}

struct Polygons: Hashable {
    
    let polygons: [Polygon]
    
    static func == (lhs: Polygons, rhs: Polygons) -> Bool {
        return lhs.polygons == rhs.polygons
    }
    
    func hash(into hasher: inout Hasher) {
        hasher.combine(polygons)
    }
}
