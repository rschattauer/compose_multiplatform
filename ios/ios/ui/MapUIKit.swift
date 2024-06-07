import Foundation
import UIKit
import shared
import MapboxMaps

func mapWithUIKitViewFactory() -> MapWithUIKitViewFactory {
    return MapUIKitViewContainer()
}

class MapUIKitViewContainer: UIView, MapWithUIKitViewFactory {

    private var mapView: MapView!
    private var polygonAnnotationManager: PolygonAnnotationManager!
    var view: UIView {
        return self
    }

    init() {
        super.init(frame: CGRect.zero)
        setupMapView()
    }

    required init?(coder aDecoder: NSCoder) {
        fatalError("init(coder:) has not been implemented")
    }

    func setContentPadding(contentPadding: Foundation_layoutPaddingValues) {
        mapView.ornaments.options.scaleBar.margins.y = CGFloat(contentPadding.calculateTopPadding()) - mapView.safeAreaInsets.top
        mapView.ornaments.options.logo.margins.y = CGFloat(contentPadding.calculateBottomPadding()) - mapView.safeAreaInsets.bottom
        mapView.ornaments.options.attributionButton.margins.y = CGFloat(contentPadding.calculateBottomPadding()) - mapView.safeAreaInsets.bottom
    }

    func setPolygons(polygons: [shared.Polygon]) {
        print("set polygons: \(polygons)")

        let renderPolygons = polygons.map({ polygon in
            let ringCoords = polygon.latLngs.map { latLng in
                CLLocationCoordinate2D(latitude: latLng.latitude, longitude: latLng.longitude)
            }
            let ring = Ring(coordinates: ringCoords)
            let poly = MapboxMaps.Polygon(outerRing: ring)
            return PolygonAnnotation(polygon: poly)
        })
        polygonAnnotationManager.annotations = renderPolygons
    }

    private func setupMapView() {
        mapView = MapView(frame: bounds)
        mapView.autoresizingMask = [.flexibleWidth, .flexibleHeight]
        addSubview(mapView)
        polygonAnnotationManager = mapView.annotations.makePolygonAnnotationManager()
        setCamera()
    }

    func setCamera() {
        let cameraOptions = CameraOptions(
            center: LocationCoordinate2D(latitude: 48.2082, longitude: 16.3719),
            zoom: 14,
            bearing: 0,
            pitch: 0
        )
        mapView.mapboxMap.setCamera(to: cameraOptions)
    }
}
