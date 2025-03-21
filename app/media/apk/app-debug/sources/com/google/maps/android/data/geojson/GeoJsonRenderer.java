package com.google.maps.android.data.geojson;

import com.google.android.gms.maps.GoogleMap;
import com.google.maps.android.collections.GroundOverlayManager;
import com.google.maps.android.collections.MarkerManager;
import com.google.maps.android.collections.PolygonManager;
import com.google.maps.android.collections.PolylineManager;
import com.google.maps.android.data.Feature;
import com.google.maps.android.data.Renderer;
import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;
/* loaded from: classes.dex */
public class GeoJsonRenderer extends Renderer implements Observer {
    private static final Object FEATURE_NOT_ON_MAP = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    public GeoJsonRenderer(GoogleMap map, HashMap<GeoJsonFeature, Object> features, MarkerManager markerManager, PolygonManager polygonManager, PolylineManager polylineManager, GroundOverlayManager groundOverlayManager) {
        super(map, features, markerManager, polygonManager, polylineManager, groundOverlayManager);
    }

    @Override // com.google.maps.android.data.Renderer
    public void setMap(GoogleMap map) {
        super.setMap(map);
        for (Feature feature : super.getFeatures()) {
            redrawFeatureToMap((GeoJsonFeature) feature, map);
        }
    }

    public void addLayerToMap() {
        if (!isLayerOnMap()) {
            setLayerVisibility(true);
            for (Feature feature : super.getFeatures()) {
                addFeature((GeoJsonFeature) feature);
            }
        }
    }

    public void addFeature(GeoJsonFeature feature) {
        super.addFeature((Feature) feature);
        if (isLayerOnMap()) {
            feature.addObserver(this);
        }
    }

    public void removeLayerFromMap() {
        if (isLayerOnMap()) {
            for (Feature feature : super.getFeatures()) {
                removeFromMap(super.getAllFeatures().get(feature));
                feature.deleteObserver(this);
            }
            setLayerVisibility(false);
        }
    }

    public void removeFeature(GeoJsonFeature feature) {
        super.removeFeature((Feature) feature);
        if (super.getFeatures().contains(feature)) {
            feature.deleteObserver(this);
        }
    }

    private void redrawFeatureToMap(GeoJsonFeature feature) {
        redrawFeatureToMap(feature, getMap());
    }

    private void redrawFeatureToMap(GeoJsonFeature feature, GoogleMap map) {
        removeFromMap(getAllFeatures().get(feature));
        putFeatures(feature, FEATURE_NOT_ON_MAP);
        if (map != null && feature.hasGeometry()) {
            putFeatures(feature, addGeoJsonFeatureToMap(feature, feature.getGeometry()));
        }
    }

    @Override // java.util.Observer
    public void update(Observable observable, Object data) {
        if (observable instanceof GeoJsonFeature) {
            GeoJsonFeature feature = (GeoJsonFeature) observable;
            Object obj = getAllFeatures().get(feature);
            Object obj2 = FEATURE_NOT_ON_MAP;
            boolean featureIsOnMap = obj != obj2;
            if (featureIsOnMap && feature.hasGeometry()) {
                redrawFeatureToMap(feature);
            } else if (featureIsOnMap && !feature.hasGeometry()) {
                removeFromMap(getAllFeatures().get(feature));
                putFeatures(feature, obj2);
            } else if (!featureIsOnMap && feature.hasGeometry()) {
                addFeature(feature);
            }
        }
    }
}
