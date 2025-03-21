package com.google.maps.android.data.kml;

import com.google.android.gms.maps.model.GroundOverlay;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public class KmlContainer {
    private String mContainerId;
    private final ArrayList<KmlContainer> mContainers;
    private final HashMap<KmlGroundOverlay, GroundOverlay> mGroundOverlays;
    private final HashMap<KmlPlacemark, Object> mPlacemarks;
    private final HashMap<String, String> mProperties;
    private final HashMap<String, String> mStyleMap;
    private HashMap<String, KmlStyle> mStyles;

    /* JADX INFO: Access modifiers changed from: package-private */
    public KmlContainer(HashMap<String, String> properties, HashMap<String, KmlStyle> styles, HashMap<KmlPlacemark, Object> placemarks, HashMap<String, String> styleMaps, ArrayList<KmlContainer> containers, HashMap<KmlGroundOverlay, GroundOverlay> groundOverlay, String Id) {
        this.mProperties = properties;
        this.mPlacemarks = placemarks;
        this.mStyles = styles;
        this.mStyleMap = styleMaps;
        this.mContainers = containers;
        this.mGroundOverlays = groundOverlay;
        this.mContainerId = Id;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public HashMap<String, KmlStyle> getStyles() {
        return this.mStyles;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setPlacemark(KmlPlacemark placemarks, Object object) {
        this.mPlacemarks.put(placemarks, object);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public HashMap<String, String> getStyleMap() {
        return this.mStyleMap;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public HashMap<KmlGroundOverlay, GroundOverlay> getGroundOverlayHashMap() {
        return this.mGroundOverlays;
    }

    public String getContainerId() {
        return this.mContainerId;
    }

    public KmlStyle getStyle(String styleID) {
        return this.mStyles.get(styleID);
    }

    public String getStyleIdFromMap(String styleID) {
        return this.mStyleMap.get(styleID);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public HashMap<KmlPlacemark, Object> getPlacemarksHashMap() {
        return this.mPlacemarks;
    }

    public String getProperty(String propertyName) {
        return this.mProperties.get(propertyName);
    }

    public boolean hasProperties() {
        return this.mProperties.size() > 0;
    }

    public boolean hasProperty(String keyValue) {
        return this.mProperties.containsKey(keyValue);
    }

    public boolean hasContainers() {
        return this.mContainers.size() > 0;
    }

    public Iterable<KmlContainer> getContainers() {
        return this.mContainers;
    }

    public Iterable<String> getProperties() {
        return this.mProperties.keySet();
    }

    public Iterable<KmlPlacemark> getPlacemarks() {
        return this.mPlacemarks.keySet();
    }

    public boolean hasPlacemarks() {
        return this.mPlacemarks.size() > 0;
    }

    public Iterable<KmlGroundOverlay> getGroundOverlays() {
        return this.mGroundOverlays.keySet();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Container").append("{");
        sb.append("\n properties=").append(this.mProperties);
        sb.append(",\n placemarks=").append(this.mPlacemarks);
        sb.append(",\n containers=").append(this.mContainers);
        sb.append(",\n ground overlays=").append(this.mGroundOverlays);
        sb.append(",\n style maps=").append(this.mStyleMap);
        sb.append(",\n styles=").append(this.mStyles);
        sb.append("\n}\n");
        return sb.toString();
    }
}
