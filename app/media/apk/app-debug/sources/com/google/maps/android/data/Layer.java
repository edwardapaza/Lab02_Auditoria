package com.google.maps.android.data;

import com.google.android.gms.maps.GoogleMap;
import com.google.maps.android.data.geojson.GeoJsonLineStringStyle;
import com.google.maps.android.data.geojson.GeoJsonPointStyle;
import com.google.maps.android.data.geojson.GeoJsonPolygonStyle;
import com.google.maps.android.data.geojson.GeoJsonRenderer;
import com.google.maps.android.data.kml.KmlContainer;
import com.google.maps.android.data.kml.KmlGroundOverlay;
import com.google.maps.android.data.kml.KmlRenderer;
/* loaded from: classes.dex */
public abstract class Layer {
    private Renderer mRenderer;

    /* loaded from: classes.dex */
    public interface OnFeatureClickListener {
        void onFeatureClick(Feature feature);
    }

    public abstract void addLayerToMap();

    /* JADX INFO: Access modifiers changed from: protected */
    public void addKMLToMap() {
        Renderer renderer = this.mRenderer;
        if (renderer instanceof KmlRenderer) {
            ((KmlRenderer) renderer).addLayerToMap();
            return;
        }
        throw new UnsupportedOperationException("Stored renderer is not a KmlRenderer");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void addGeoJsonToMap() {
        Renderer renderer = this.mRenderer;
        if (renderer instanceof GeoJsonRenderer) {
            ((GeoJsonRenderer) renderer).addLayerToMap();
            return;
        }
        throw new UnsupportedOperationException("Stored renderer is not a GeoJsonRenderer");
    }

    public void removeLayerFromMap() {
        Renderer renderer = this.mRenderer;
        if (renderer instanceof GeoJsonRenderer) {
            ((GeoJsonRenderer) renderer).removeLayerFromMap();
        } else if (renderer instanceof KmlRenderer) {
            ((KmlRenderer) renderer).removeLayerFromMap();
        }
    }

    public void setOnFeatureClickListener(OnFeatureClickListener listener) {
        this.mRenderer.setOnFeatureClickListener(listener);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void storeRenderer(Renderer renderer) {
        this.mRenderer = renderer;
    }

    public Iterable<? extends Feature> getFeatures() {
        return this.mRenderer.getFeatures();
    }

    public Feature getFeature(Object mapObject) {
        return this.mRenderer.getFeature(mapObject);
    }

    public Feature getContainerFeature(Object mapObject) {
        return this.mRenderer.getContainerFeature(mapObject);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean hasFeatures() {
        return this.mRenderer.hasFeatures();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean hasContainers() {
        Renderer renderer = this.mRenderer;
        if (renderer instanceof KmlRenderer) {
            return ((KmlRenderer) renderer).hasNestedContainers();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Iterable<KmlContainer> getContainers() {
        Renderer renderer = this.mRenderer;
        if (renderer instanceof KmlRenderer) {
            return ((KmlRenderer) renderer).getNestedContainers();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Iterable<KmlGroundOverlay> getGroundOverlays() {
        Renderer renderer = this.mRenderer;
        if (renderer instanceof KmlRenderer) {
            return ((KmlRenderer) renderer).getGroundOverlays();
        }
        return null;
    }

    public GoogleMap getMap() {
        return this.mRenderer.getMap();
    }

    public void setMap(GoogleMap map) {
        this.mRenderer.setMap(map);
    }

    public boolean isLayerOnMap() {
        return this.mRenderer.isLayerOnMap();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void addFeature(Feature feature) {
        this.mRenderer.addFeature(feature);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void removeFeature(Feature feature) {
        this.mRenderer.removeFeature(feature);
    }

    public GeoJsonPointStyle getDefaultPointStyle() {
        return this.mRenderer.getDefaultPointStyle();
    }

    public GeoJsonLineStringStyle getDefaultLineStringStyle() {
        return this.mRenderer.getDefaultLineStringStyle();
    }

    public GeoJsonPolygonStyle getDefaultPolygonStyle() {
        return this.mRenderer.getDefaultPolygonStyle();
    }
}
