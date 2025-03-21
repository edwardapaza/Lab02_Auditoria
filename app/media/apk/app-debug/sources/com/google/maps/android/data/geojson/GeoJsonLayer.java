package com.google.maps.android.data.geojson;

import android.content.Context;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.maps.android.collections.GroundOverlayManager;
import com.google.maps.android.collections.MarkerManager;
import com.google.maps.android.collections.PolygonManager;
import com.google.maps.android.collections.PolylineManager;
import com.google.maps.android.data.Feature;
import com.google.maps.android.data.Layer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class GeoJsonLayer extends Layer {
    private LatLngBounds mBoundingBox;

    /* loaded from: classes.dex */
    public interface GeoJsonOnFeatureClickListener extends Layer.OnFeatureClickListener {
    }

    public GeoJsonLayer(GoogleMap map, JSONObject geoJsonFile, MarkerManager markerManager, PolygonManager polygonManager, PolylineManager polylineManager, GroundOverlayManager groundOverlayManager) {
        if (geoJsonFile != null) {
            this.mBoundingBox = null;
            GeoJsonParser parser = new GeoJsonParser(geoJsonFile);
            this.mBoundingBox = parser.getBoundingBox();
            HashMap<GeoJsonFeature, Object> geoJsonFeatures = new HashMap<>();
            Iterator<GeoJsonFeature> it = parser.getFeatures().iterator();
            while (it.hasNext()) {
                GeoJsonFeature feature = it.next();
                geoJsonFeatures.put(feature, null);
            }
            GeoJsonRenderer mRenderer = new GeoJsonRenderer(map, geoJsonFeatures, markerManager, polygonManager, polylineManager, groundOverlayManager);
            storeRenderer(mRenderer);
            return;
        }
        throw new IllegalArgumentException("GeoJSON file cannot be null");
    }

    public GeoJsonLayer(GoogleMap map, int resourceId, Context context, MarkerManager markerManager, PolygonManager polygonManager, PolylineManager polylineManager, GroundOverlayManager groundOverlayManager) throws IOException, JSONException {
        this(map, createJsonFileObject(context.getResources().openRawResource(resourceId)), markerManager, polygonManager, polylineManager, groundOverlayManager);
    }

    public GeoJsonLayer(GoogleMap map, JSONObject geoJsonFile) {
        this(map, geoJsonFile, null, null, null, null);
    }

    public GeoJsonLayer(GoogleMap map, int resourceId, Context context) throws IOException, JSONException {
        this(map, createJsonFileObject(context.getResources().openRawResource(resourceId)), null, null, null, null);
    }

    private static JSONObject createJsonFileObject(InputStream stream) throws IOException, JSONException {
        StringBuilder result = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
        while (true) {
            String line = reader.readLine();
            if (line != null) {
                result.append(line);
            } else {
                reader.close();
                return new JSONObject(result.toString());
            }
        }
    }

    @Override // com.google.maps.android.data.Layer
    public void addLayerToMap() {
        super.addGeoJsonToMap();
    }

    @Override // com.google.maps.android.data.Layer
    public Iterable<GeoJsonFeature> getFeatures() {
        return super.getFeatures();
    }

    public void addFeature(GeoJsonFeature feature) {
        if (feature == null) {
            throw new IllegalArgumentException("Feature cannot be null");
        }
        super.addFeature((Feature) feature);
    }

    public void removeFeature(GeoJsonFeature feature) {
        if (feature == null) {
            throw new IllegalArgumentException("Feature cannot be null");
        }
        super.removeFeature((Feature) feature);
    }

    public LatLngBounds getBoundingBox() {
        return this.mBoundingBox;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Collection{");
        sb.append("\n Bounding box=").append(this.mBoundingBox);
        sb.append("\n}\n");
        return sb.toString();
    }
}
