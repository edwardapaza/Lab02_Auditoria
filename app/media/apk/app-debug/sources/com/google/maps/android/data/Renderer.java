package com.google.maps.android.data;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.GroundOverlay;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polygon;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.maps.android.R;
import com.google.maps.android.collections.GroundOverlayManager;
import com.google.maps.android.collections.MarkerManager;
import com.google.maps.android.collections.PolygonManager;
import com.google.maps.android.collections.PolylineManager;
import com.google.maps.android.data.Layer;
import com.google.maps.android.data.geojson.BiMultiMap;
import com.google.maps.android.data.geojson.GeoJsonFeature;
import com.google.maps.android.data.geojson.GeoJsonGeometryCollection;
import com.google.maps.android.data.geojson.GeoJsonLineString;
import com.google.maps.android.data.geojson.GeoJsonLineStringStyle;
import com.google.maps.android.data.geojson.GeoJsonMultiLineString;
import com.google.maps.android.data.geojson.GeoJsonMultiPoint;
import com.google.maps.android.data.geojson.GeoJsonMultiPolygon;
import com.google.maps.android.data.geojson.GeoJsonPoint;
import com.google.maps.android.data.geojson.GeoJsonPointStyle;
import com.google.maps.android.data.geojson.GeoJsonPolygon;
import com.google.maps.android.data.geojson.GeoJsonPolygonStyle;
import com.google.maps.android.data.kml.KmlContainer;
import com.google.maps.android.data.kml.KmlGroundOverlay;
import com.google.maps.android.data.kml.KmlMultiGeometry;
import com.google.maps.android.data.kml.KmlPlacemark;
import com.google.maps.android.data.kml.KmlPoint;
import com.google.maps.android.data.kml.KmlPolygon;
import com.google.maps.android.data.kml.KmlStyle;
import com.google.maps.android.data.kml.KmlUtil;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
/* loaded from: classes.dex */
public class Renderer {
    private static final int MARKER_ICON_SIZE = 32;
    private final BiMultiMap<Feature> mContainerFeatures;
    private ArrayList<KmlContainer> mContainers;
    private Context mContext;
    private final GeoJsonLineStringStyle mDefaultLineStringStyle;
    private final GeoJsonPointStyle mDefaultPointStyle;
    private final GeoJsonPolygonStyle mDefaultPolygonStyle;
    private final BiMultiMap<Feature> mFeatures;
    private HashMap<KmlGroundOverlay, GroundOverlay> mGroundOverlayMap;
    private final GroundOverlayManager.Collection mGroundOverlays;
    private ImagesCache mImagesCache;
    private boolean mLayerOnMap;
    private GoogleMap mMap;
    private final Set<String> mMarkerIconUrls;
    private final MarkerManager.Collection mMarkers;
    private int mNumActiveDownloads;
    private final PolygonManager.Collection mPolygons;
    private final PolylineManager.Collection mPolylines;
    private HashMap<String, String> mStyleMaps;
    private HashMap<String, KmlStyle> mStyles;
    private HashMap<String, KmlStyle> mStylesRenderer;
    private static final Object FEATURE_NOT_ON_MAP = null;
    private static final DecimalFormat sScaleFormat = new DecimalFormat("#.####");

    /* loaded from: classes.dex */
    public static final class ImagesCache {
        final Map<String, Map<String, BitmapDescriptor>> markerImagesCache = new HashMap();
        final Map<String, BitmapDescriptor> groundOverlayImagesCache = new HashMap();
        final Map<String, Bitmap> bitmapCache = new HashMap();
    }

    public Renderer(GoogleMap map, Context context, MarkerManager markerManager, PolygonManager polygonManager, PolylineManager polylineManager, GroundOverlayManager groundOverlayManager, ImagesCache imagesCache) {
        this(map, new HashSet(), null, null, null, new BiMultiMap(), markerManager, polygonManager, polylineManager, groundOverlayManager);
        this.mContext = context;
        this.mStylesRenderer = new HashMap<>();
        this.mImagesCache = imagesCache == null ? new ImagesCache() : imagesCache;
    }

    public Renderer(GoogleMap map, HashMap<? extends Feature, Object> features, MarkerManager markerManager, PolygonManager polygonManager, PolylineManager polylineManager, GroundOverlayManager groundOverlayManager) {
        this(map, null, new GeoJsonPointStyle(), new GeoJsonLineStringStyle(), new GeoJsonPolygonStyle(), null, markerManager, polygonManager, polylineManager, groundOverlayManager);
        this.mFeatures.putAll(features);
        this.mImagesCache = null;
    }

    private Renderer(GoogleMap map, Set<String> markerIconUrls, GeoJsonPointStyle defaultPointStyle, GeoJsonLineStringStyle defaultLineStringStyle, GeoJsonPolygonStyle defaultPolygonStyle, BiMultiMap<Feature> containerFeatures, MarkerManager markerManager, PolygonManager polygonManager, PolylineManager polylineManager, GroundOverlayManager groundOverlayManager) {
        this.mFeatures = new BiMultiMap<>();
        this.mNumActiveDownloads = 0;
        this.mMap = map;
        this.mLayerOnMap = false;
        this.mMarkerIconUrls = markerIconUrls;
        this.mDefaultPointStyle = defaultPointStyle;
        this.mDefaultLineStringStyle = defaultLineStringStyle;
        this.mDefaultPolygonStyle = defaultPolygonStyle;
        this.mContainerFeatures = containerFeatures;
        if (map != null) {
            this.mMarkers = (markerManager == null ? new MarkerManager(map) : markerManager).newCollection();
            this.mPolygons = (polygonManager == null ? new PolygonManager(map) : polygonManager).newCollection();
            this.mPolylines = (polylineManager == null ? new PolylineManager(map) : polylineManager).newCollection();
            this.mGroundOverlays = (groundOverlayManager == null ? new GroundOverlayManager(map) : groundOverlayManager).newCollection();
            return;
        }
        this.mMarkers = null;
        this.mPolygons = null;
        this.mPolylines = null;
        this.mGroundOverlays = null;
    }

    public boolean isLayerOnMap() {
        return this.mLayerOnMap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setLayerVisibility(boolean layerOnMap) {
        this.mLayerOnMap = layerOnMap;
    }

    public GoogleMap getMap() {
        return this.mMap;
    }

    public void setMap(GoogleMap map) {
        this.mMap = map;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void putContainerFeature(Object mapObject, Feature placemark) {
        this.mContainerFeatures.put((BiMultiMap<Feature>) placemark, mapObject);
    }

    public Set<Feature> getFeatures() {
        return this.mFeatures.keySet();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Feature getFeature(Object mapObject) {
        return this.mFeatures.getKey(mapObject);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Feature getContainerFeature(Object mapObject) {
        BiMultiMap<Feature> biMultiMap = this.mContainerFeatures;
        if (biMultiMap != null) {
            return biMultiMap.getKey(mapObject);
        }
        return null;
    }

    public Collection<Object> getValues() {
        return this.mFeatures.values();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public HashMap<? extends Feature, Object> getAllFeatures() {
        return this.mFeatures;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Set<String> getMarkerIconUrls() {
        return this.mMarkerIconUrls;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public HashMap<String, KmlStyle> getStylesRenderer() {
        return this.mStylesRenderer;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public HashMap<String, String> getStyleMaps() {
        return this.mStyleMaps;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public BitmapDescriptor getCachedMarkerImage(String url, double scale) {
        Bitmap bitmap;
        String scaleString = sScaleFormat.format(scale);
        Map<String, BitmapDescriptor> bitmaps = this.mImagesCache.markerImagesCache.get(url);
        BitmapDescriptor bitmapDescriptor = null;
        if (bitmaps != null) {
            BitmapDescriptor bitmapDescriptor2 = bitmaps.get(scaleString);
            bitmapDescriptor = bitmapDescriptor2;
        }
        if (bitmapDescriptor == null && (bitmap = this.mImagesCache.bitmapCache.get(url)) != null) {
            BitmapDescriptor bitmapDescriptor3 = scaleIcon(bitmap, scale);
            putMarkerImagesCache(url, scaleString, bitmapDescriptor3);
            return bitmapDescriptor3;
        }
        return bitmapDescriptor;
    }

    private BitmapDescriptor scaleIcon(Bitmap unscaledBitmap, double scale) {
        int width;
        int height;
        float density = this.mContext.getResources().getDisplayMetrics().density;
        int minSize = (int) (32.0f * density * scale);
        int unscaledWidth = unscaledBitmap.getWidth();
        int unscaledHeight = unscaledBitmap.getHeight();
        if (unscaledWidth < unscaledHeight) {
            width = minSize;
            height = (int) ((minSize * unscaledHeight) / unscaledWidth);
        } else if (unscaledWidth > unscaledHeight) {
            width = (int) ((minSize * unscaledWidth) / unscaledHeight);
            height = minSize;
        } else {
            width = minSize;
            height = minSize;
        }
        Bitmap scaledBitmap = Bitmap.createScaledBitmap(unscaledBitmap, width, height, false);
        return BitmapDescriptorFactory.fromBitmap(scaledBitmap);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public BitmapDescriptor getCachedGroundOverlayImage(String url) {
        Bitmap bitmap;
        BitmapDescriptor bitmapDescriptor = this.mImagesCache.groundOverlayImagesCache.get(url);
        if (bitmapDescriptor == null && (bitmap = this.mImagesCache.bitmapCache.get(url)) != null) {
            BitmapDescriptor bitmapDescriptor2 = BitmapDescriptorFactory.fromBitmap(bitmap);
            this.mImagesCache.groundOverlayImagesCache.put(url, bitmapDescriptor2);
            return bitmapDescriptor2;
        }
        return bitmapDescriptor;
    }

    public HashMap<KmlGroundOverlay, GroundOverlay> getGroundOverlayMap() {
        return this.mGroundOverlayMap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ArrayList<KmlContainer> getContainerList() {
        return this.mContainers;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public KmlStyle getPlacemarkStyle(String styleId) {
        KmlStyle style = this.mStylesRenderer.get(null);
        if (this.mStylesRenderer.get(styleId) != null) {
            KmlStyle style2 = this.mStylesRenderer.get(styleId);
            return style2;
        }
        return style;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public GeoJsonPointStyle getDefaultPointStyle() {
        return this.mDefaultPointStyle;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public GeoJsonLineStringStyle getDefaultLineStringStyle() {
        return this.mDefaultLineStringStyle;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public GeoJsonPolygonStyle getDefaultPolygonStyle() {
        return this.mDefaultPolygonStyle;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void putFeatures(Feature feature, Object object) {
        this.mFeatures.put((BiMultiMap<Feature>) feature, object);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void putStyles() {
        this.mStylesRenderer.putAll(this.mStyles);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void putStyles(HashMap<String, KmlStyle> styles) {
        this.mStylesRenderer.putAll(styles);
    }

    private void putMarkerImagesCache(String url, String scale, BitmapDescriptor bitmapDescriptor) {
        Map<String, BitmapDescriptor> bitmaps = this.mImagesCache.markerImagesCache.get(url);
        if (bitmaps == null) {
            bitmaps = new HashMap();
            this.mImagesCache.markerImagesCache.put(url, bitmaps);
        }
        bitmaps.put(scale, bitmapDescriptor);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cacheBitmap(String url, Bitmap bitmap) {
        this.mImagesCache.bitmapCache.put(url, bitmap);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void downloadStarted() {
        this.mNumActiveDownloads++;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void downloadFinished() {
        this.mNumActiveDownloads--;
        checkClearBitmapCache();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void checkClearBitmapCache() {
        ImagesCache imagesCache;
        if (this.mNumActiveDownloads == 0 && (imagesCache = this.mImagesCache) != null && !imagesCache.bitmapCache.isEmpty()) {
            this.mImagesCache.bitmapCache.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean hasFeatures() {
        return this.mFeatures.size() > 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void removeFeatures(HashMap<? extends Feature, Object> features) {
        removeFeatures(features.values());
    }

    private void removeFeatures(Collection features) {
        for (Object mapObject : features) {
            if (mapObject instanceof Collection) {
                removeFeatures((Collection) mapObject);
            } else if (mapObject instanceof Marker) {
                this.mMarkers.remove((Marker) mapObject);
            } else if (mapObject instanceof Polyline) {
                this.mPolylines.remove((Polyline) mapObject);
            } else if (mapObject instanceof Polygon) {
                this.mPolygons.remove((Polygon) mapObject);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void removeGroundOverlays(HashMap<KmlGroundOverlay, GroundOverlay> groundOverlays) {
        for (GroundOverlay groundOverlay : groundOverlays.values()) {
            if (groundOverlay != null) {
                this.mGroundOverlays.remove(groundOverlay);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void removeFeature(Feature feature) {
        if (this.mFeatures.containsKey(feature)) {
            removeFromMap(this.mFeatures.remove(feature));
        }
    }

    private void setFeatureDefaultStyles(GeoJsonFeature feature) {
        if (feature.getPointStyle() == null) {
            feature.setPointStyle(this.mDefaultPointStyle);
        }
        if (feature.getLineStringStyle() == null) {
            feature.setLineStringStyle(this.mDefaultLineStringStyle);
        }
        if (feature.getPolygonStyle() == null) {
            feature.setPolygonStyle(this.mDefaultPolygonStyle);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void clearStylesRenderer() {
        this.mStylesRenderer.clear();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void storeData(HashMap<String, KmlStyle> styles, HashMap<String, String> styleMaps, HashMap<KmlPlacemark, Object> features, ArrayList<KmlContainer> folders, HashMap<KmlGroundOverlay, GroundOverlay> groundOverlays) {
        this.mStyles = styles;
        this.mStyleMaps = styleMaps;
        this.mFeatures.putAll(features);
        this.mContainers = folders;
        this.mGroundOverlayMap = groundOverlays;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void addFeature(Feature feature) {
        Object mapObject = FEATURE_NOT_ON_MAP;
        if (feature instanceof GeoJsonFeature) {
            setFeatureDefaultStyles((GeoJsonFeature) feature);
        }
        if (this.mLayerOnMap) {
            if (this.mFeatures.containsKey(feature)) {
                removeFromMap(this.mFeatures.get(feature));
            }
            if (feature.hasGeometry()) {
                if (feature instanceof KmlPlacemark) {
                    boolean isPlacemarkVisible = getPlacemarkVisibility(feature);
                    String placemarkId = feature.getId();
                    Geometry geometry = feature.getGeometry();
                    KmlStyle style = getPlacemarkStyle(placemarkId);
                    KmlStyle inlineStyle = ((KmlPlacemark) feature).getInlineStyle();
                    mapObject = addKmlPlacemarkToMap((KmlPlacemark) feature, geometry, style, inlineStyle, isPlacemarkVisible);
                } else {
                    mapObject = addGeoJsonFeatureToMap(feature, feature.getGeometry());
                }
            }
        }
        this.mFeatures.put((BiMultiMap<Feature>) feature, mapObject);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void removeFromMap(Object mapObject) {
        if (mapObject instanceof Marker) {
            this.mMarkers.remove((Marker) mapObject);
        } else if (mapObject instanceof Polyline) {
            this.mPolylines.remove((Polyline) mapObject);
        } else if (mapObject instanceof Polygon) {
            this.mPolygons.remove((Polygon) mapObject);
        } else if (mapObject instanceof GroundOverlay) {
            this.mGroundOverlays.remove((GroundOverlay) mapObject);
        } else if (mapObject instanceof ArrayList) {
            Iterator it = ((ArrayList) mapObject).iterator();
            while (it.hasNext()) {
                Object mapObjectElement = it.next();
                removeFromMap(mapObjectElement);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public Object addGeoJsonFeatureToMap(Feature feature, Geometry geometry) {
        char c;
        String geometryType = geometry.getGeometryType();
        switch (geometryType.hashCode()) {
            case -2116761119:
                if (geometryType.equals("MultiPolygon")) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            case -1065891849:
                if (geometryType.equals("MultiPoint")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case -627102946:
                if (geometryType.equals("MultiLineString")) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case 77292912:
                if (geometryType.equals("Point")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case 1267133722:
                if (geometryType.equals(KmlPolygon.GEOMETRY_TYPE)) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case 1806700869:
                if (geometryType.equals("LineString")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case 1950410960:
                if (geometryType.equals("GeometryCollection")) {
                    c = 6;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        switch (c) {
            case 0:
                MarkerOptions markerOptions = null;
                if (feature instanceof GeoJsonFeature) {
                    markerOptions = ((GeoJsonFeature) feature).getMarkerOptions();
                } else if (feature instanceof KmlPlacemark) {
                    markerOptions = ((KmlPlacemark) feature).getMarkerOptions();
                }
                return addPointToMap(markerOptions, (GeoJsonPoint) geometry);
            case 1:
                PolylineOptions polylineOptions = null;
                if (feature instanceof GeoJsonFeature) {
                    polylineOptions = ((GeoJsonFeature) feature).getPolylineOptions();
                } else if (feature instanceof KmlPlacemark) {
                    polylineOptions = ((KmlPlacemark) feature).getPolylineOptions();
                }
                return addLineStringToMap(polylineOptions, (GeoJsonLineString) geometry);
            case 2:
                PolygonOptions polygonOptions = null;
                if (feature instanceof GeoJsonFeature) {
                    polygonOptions = ((GeoJsonFeature) feature).getPolygonOptions();
                } else if (feature instanceof KmlPlacemark) {
                    polygonOptions = ((KmlPlacemark) feature).getPolygonOptions();
                }
                return addPolygonToMap(polygonOptions, (DataPolygon) geometry);
            case 3:
                return addMultiPointToMap(((GeoJsonFeature) feature).getPointStyle(), (GeoJsonMultiPoint) geometry);
            case 4:
                return addMultiLineStringToMap(((GeoJsonFeature) feature).getLineStringStyle(), (GeoJsonMultiLineString) geometry);
            case 5:
                return addMultiPolygonToMap(((GeoJsonFeature) feature).getPolygonStyle(), (GeoJsonMultiPolygon) geometry);
            case 6:
                return addGeometryCollectionToMap((GeoJsonFeature) feature, ((GeoJsonGeometryCollection) geometry).getGeometries());
            default:
                return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Object addKmlPlacemarkToMap(KmlPlacemark placemark, Geometry geometry, KmlStyle style, KmlStyle inlineStyle, boolean isVisible) {
        String geometryType = geometry.getGeometryType();
        boolean hasDrawOrder = placemark.hasProperty("drawOrder");
        float drawOrder = 0.0f;
        if (hasDrawOrder) {
            try {
                drawOrder = Float.parseFloat(placemark.getProperty("drawOrder"));
            } catch (NumberFormatException e) {
                hasDrawOrder = false;
            }
        }
        char c = 65535;
        switch (geometryType.hashCode()) {
            case 77292912:
                if (geometryType.equals("Point")) {
                    c = 0;
                    break;
                }
                break;
            case 89139371:
                if (geometryType.equals("MultiGeometry")) {
                    c = 3;
                    break;
                }
                break;
            case 1267133722:
                if (geometryType.equals(KmlPolygon.GEOMETRY_TYPE)) {
                    c = 2;
                    break;
                }
                break;
            case 1806700869:
                if (geometryType.equals("LineString")) {
                    c = 1;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                MarkerOptions markerOptions = style.getMarkerOptions();
                if (inlineStyle != null) {
                    setInlinePointStyle(markerOptions, inlineStyle, style);
                } else if (style.getIconUrl() != null) {
                    addMarkerIcons(style.getIconUrl(), style.getIconScale(), markerOptions);
                }
                Marker marker = addPointToMap(markerOptions, (KmlPoint) geometry);
                marker.setVisible(isVisible);
                setMarkerInfoWindow(style, marker, placemark);
                if (hasDrawOrder) {
                    marker.setZIndex(drawOrder);
                }
                return marker;
            case 1:
                PolylineOptions polylineOptions = style.getPolylineOptions();
                if (inlineStyle != null) {
                    setInlineLineStringStyle(polylineOptions, inlineStyle);
                } else if (style.isLineRandomColorMode()) {
                    polylineOptions.color(KmlStyle.computeRandomColor(polylineOptions.getColor()));
                }
                Polyline polyline = addLineStringToMap(polylineOptions, (LineString) geometry);
                polyline.setVisible(isVisible);
                if (hasDrawOrder) {
                    polyline.setZIndex(drawOrder);
                }
                return polyline;
            case 2:
                PolygonOptions polygonOptions = style.getPolygonOptions();
                if (inlineStyle != null) {
                    setInlinePolygonStyle(polygonOptions, inlineStyle);
                } else if (style.isPolyRandomColorMode()) {
                    polygonOptions.fillColor(KmlStyle.computeRandomColor(polygonOptions.getFillColor()));
                }
                Polygon polygon = addPolygonToMap(polygonOptions, (DataPolygon) geometry);
                polygon.setVisible(isVisible);
                if (hasDrawOrder) {
                    polygon.setZIndex(drawOrder);
                }
                return polygon;
            case 3:
                return addMultiGeometryToMap(placemark, (KmlMultiGeometry) geometry, style, inlineStyle, isVisible);
            default:
                return null;
        }
    }

    private Marker addPointToMap(MarkerOptions markerOptions, Point point) {
        markerOptions.position(point.getGeometryObject());
        return this.mMarkers.addMarker(markerOptions);
    }

    private void setInlinePointStyle(MarkerOptions markerOptions, KmlStyle inlineStyle, KmlStyle defaultStyle) {
        double scale;
        MarkerOptions inlineMarkerOptions = inlineStyle.getMarkerOptions();
        if (inlineStyle.isStyleSet("heading")) {
            markerOptions.rotation(inlineMarkerOptions.getRotation());
        }
        if (inlineStyle.isStyleSet("hotSpot")) {
            markerOptions.anchor(inlineMarkerOptions.getAnchorU(), inlineMarkerOptions.getAnchorV());
        }
        if (inlineStyle.isStyleSet("markerColor")) {
            markerOptions.icon(inlineMarkerOptions.getIcon());
        }
        if (inlineStyle.isStyleSet("iconScale")) {
            scale = inlineStyle.getIconScale();
        } else if (defaultStyle.isStyleSet("iconScale")) {
            scale = defaultStyle.getIconScale();
        } else {
            scale = 1.0d;
        }
        if (inlineStyle.isStyleSet("iconUrl")) {
            addMarkerIcons(inlineStyle.getIconUrl(), scale, markerOptions);
        } else if (defaultStyle.getIconUrl() != null) {
            addMarkerIcons(defaultStyle.getIconUrl(), scale, markerOptions);
        }
    }

    private Polyline addLineStringToMap(PolylineOptions polylineOptions, LineString lineString) {
        polylineOptions.addAll(lineString.getGeometryObject());
        Polyline addedPolyline = this.mPolylines.addPolyline(polylineOptions);
        addedPolyline.setClickable(polylineOptions.isClickable());
        return addedPolyline;
    }

    private void setInlineLineStringStyle(PolylineOptions polylineOptions, KmlStyle inlineStyle) {
        PolylineOptions inlinePolylineOptions = inlineStyle.getPolylineOptions();
        if (inlineStyle.isStyleSet("outlineColor")) {
            polylineOptions.color(inlinePolylineOptions.getColor());
        }
        if (inlineStyle.isStyleSet("width")) {
            polylineOptions.width(inlinePolylineOptions.getWidth());
        }
        if (inlineStyle.isLineRandomColorMode()) {
            polylineOptions.color(KmlStyle.computeRandomColor(inlinePolylineOptions.getColor()));
        }
    }

    private Polygon addPolygonToMap(PolygonOptions polygonOptions, DataPolygon polygon) {
        polygonOptions.addAll(polygon.getOuterBoundaryCoordinates());
        List<List<LatLng>> innerBoundaries = polygon.getInnerBoundaryCoordinates();
        for (List<LatLng> innerBoundary : innerBoundaries) {
            polygonOptions.addHole(innerBoundary);
        }
        Polygon addedPolygon = this.mPolygons.addPolygon(polygonOptions);
        addedPolygon.setClickable(polygonOptions.isClickable());
        return addedPolygon;
    }

    private void setInlinePolygonStyle(PolygonOptions polygonOptions, KmlStyle inlineStyle) {
        PolygonOptions inlinePolygonOptions = inlineStyle.getPolygonOptions();
        if (inlineStyle.hasFill() && inlineStyle.isStyleSet("fillColor")) {
            polygonOptions.fillColor(inlinePolygonOptions.getFillColor());
        }
        if (inlineStyle.hasOutline()) {
            if (inlineStyle.isStyleSet("outlineColor")) {
                polygonOptions.strokeColor(inlinePolygonOptions.getStrokeColor());
            }
            if (inlineStyle.isStyleSet("width")) {
                polygonOptions.strokeWidth(inlinePolygonOptions.getStrokeWidth());
            }
        }
        if (inlineStyle.isPolyRandomColorMode()) {
            polygonOptions.fillColor(KmlStyle.computeRandomColor(inlinePolygonOptions.getFillColor()));
        }
    }

    private ArrayList<Object> addGeometryCollectionToMap(GeoJsonFeature feature, List<Geometry> geoJsonGeometries) {
        ArrayList<Object> geometries = new ArrayList<>();
        for (Geometry geometry : geoJsonGeometries) {
            geometries.add(addGeoJsonFeatureToMap(feature, geometry));
        }
        return geometries;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static boolean getPlacemarkVisibility(Feature feature) {
        if (!feature.hasProperty("visibility")) {
            return true;
        }
        String placemarkVisibility = feature.getProperty("visibility");
        if (Integer.parseInt(placemarkVisibility) != 0) {
            return true;
        }
        return false;
    }

    public void assignStyleMap(HashMap<String, String> styleMap, HashMap<String, KmlStyle> styles) {
        for (String styleMapKey : styleMap.keySet()) {
            String styleMapValue = styleMap.get(styleMapKey);
            if (styles.containsKey(styleMapValue)) {
                styles.put(styleMapKey, styles.get(styleMapValue));
            }
        }
    }

    private ArrayList<Object> addMultiGeometryToMap(KmlPlacemark placemark, KmlMultiGeometry multiGeometry, KmlStyle urlStyle, KmlStyle inlineStyle, boolean isContainerVisible) {
        ArrayList<Object> mapObjects = new ArrayList<>();
        ArrayList<Geometry> kmlObjects = multiGeometry.getGeometryObject();
        Iterator<Geometry> it = kmlObjects.iterator();
        while (it.hasNext()) {
            Geometry kmlGeometry = it.next();
            mapObjects.add(addKmlPlacemarkToMap(placemark, kmlGeometry, urlStyle, inlineStyle, isContainerVisible));
        }
        return mapObjects;
    }

    private ArrayList<Marker> addMultiPointToMap(GeoJsonPointStyle pointStyle, GeoJsonMultiPoint multiPoint) {
        ArrayList<Marker> markers = new ArrayList<>();
        for (GeoJsonPoint geoJsonPoint : multiPoint.getPoints()) {
            markers.add(addPointToMap(pointStyle.toMarkerOptions(), geoJsonPoint));
        }
        return markers;
    }

    private ArrayList<Polyline> addMultiLineStringToMap(GeoJsonLineStringStyle lineStringStyle, GeoJsonMultiLineString multiLineString) {
        ArrayList<Polyline> polylines = new ArrayList<>();
        for (GeoJsonLineString geoJsonLineString : multiLineString.getLineStrings()) {
            polylines.add(addLineStringToMap(lineStringStyle.toPolylineOptions(), geoJsonLineString));
        }
        return polylines;
    }

    private ArrayList<Polygon> addMultiPolygonToMap(GeoJsonPolygonStyle polygonStyle, GeoJsonMultiPolygon multiPolygon) {
        ArrayList<Polygon> polygons = new ArrayList<>();
        for (GeoJsonPolygon geoJsonPolygon : multiPolygon.getPolygons()) {
            polygons.add(addPolygonToMap(polygonStyle.toPolygonOptions(), geoJsonPolygon));
        }
        return polygons;
    }

    private void addMarkerIcons(String styleUrl, double scale, MarkerOptions markerOptions) {
        BitmapDescriptor bitmap = getCachedMarkerImage(styleUrl, scale);
        if (bitmap != null) {
            markerOptions.icon(bitmap);
        } else {
            this.mMarkerIconUrls.add(styleUrl);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public GroundOverlay attachGroundOverlay(GroundOverlayOptions groundOverlayOptions) {
        return this.mGroundOverlays.addGroundOverlay(groundOverlayOptions);
    }

    private void setMarkerInfoWindow(KmlStyle style, Marker marker, KmlPlacemark placemark) {
        boolean hasName = placemark.hasProperty("name");
        boolean hasDescription = placemark.hasProperty("description");
        boolean hasBalloonOptions = style.hasBalloonStyle();
        boolean hasBalloonText = style.getBalloonOptions().containsKey("text");
        if (hasBalloonOptions && hasBalloonText) {
            marker.setTitle(KmlUtil.substituteProperties(style.getBalloonOptions().get("text"), placemark));
            createInfoWindow();
        } else if (hasBalloonOptions && hasName) {
            marker.setTitle(placemark.getProperty("name"));
            createInfoWindow();
        } else if (hasName && hasDescription) {
            marker.setTitle(placemark.getProperty("name"));
            marker.setSnippet(placemark.getProperty("description"));
            createInfoWindow();
        } else if (hasDescription) {
            marker.setTitle(placemark.getProperty("description"));
            createInfoWindow();
        } else if (hasName) {
            marker.setTitle(placemark.getProperty("name"));
            createInfoWindow();
        }
    }

    private void createInfoWindow() {
        this.mMarkers.setInfoWindowAdapter(new GoogleMap.InfoWindowAdapter() { // from class: com.google.maps.android.data.Renderer.1
            @Override // com.google.android.gms.maps.GoogleMap.InfoWindowAdapter
            public View getInfoWindow(Marker arg0) {
                return null;
            }

            @Override // com.google.android.gms.maps.GoogleMap.InfoWindowAdapter
            public View getInfoContents(Marker arg0) {
                View view = LayoutInflater.from(Renderer.this.mContext).inflate(R.layout.amu_info_window, (ViewGroup) null);
                TextView infoWindowText = (TextView) view.findViewById(R.id.window);
                if (arg0.getSnippet() != null) {
                    infoWindowText.setText(Html.fromHtml(arg0.getTitle() + "<br>" + arg0.getSnippet()));
                } else {
                    infoWindowText.setText(Html.fromHtml(arg0.getTitle()));
                }
                return view;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setOnFeatureClickListener(final Layer.OnFeatureClickListener listener) {
        this.mPolygons.setOnPolygonClickListener(new GoogleMap.OnPolygonClickListener() { // from class: com.google.maps.android.data.Renderer$$ExternalSyntheticLambda0
            @Override // com.google.android.gms.maps.GoogleMap.OnPolygonClickListener
            public final void onPolygonClick(Polygon polygon) {
                Renderer.this.m123x2cc520ac(listener, polygon);
            }
        });
        this.mMarkers.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() { // from class: com.google.maps.android.data.Renderer$$ExternalSyntheticLambda1
            @Override // com.google.android.gms.maps.GoogleMap.OnMarkerClickListener
            public final boolean onMarkerClick(Marker marker) {
                return Renderer.this.m124xf5c617ed(listener, marker);
            }
        });
        this.mPolylines.setOnPolylineClickListener(new GoogleMap.OnPolylineClickListener() { // from class: com.google.maps.android.data.Renderer$$ExternalSyntheticLambda2
            @Override // com.google.android.gms.maps.GoogleMap.OnPolylineClickListener
            public final void onPolylineClick(Polyline polyline) {
                Renderer.this.m125xbec70f2e(listener, polyline);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$setOnFeatureClickListener$0$com-google-maps-android-data-Renderer  reason: not valid java name */
    public /* synthetic */ void m123x2cc520ac(Layer.OnFeatureClickListener listener, Polygon polygon) {
        if (getFeature(polygon) != null) {
            listener.onFeatureClick(getFeature(polygon));
        } else if (getContainerFeature(polygon) != null) {
            listener.onFeatureClick(getContainerFeature(polygon));
        } else {
            listener.onFeatureClick(getFeature(multiObjectHandler(polygon)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$setOnFeatureClickListener$1$com-google-maps-android-data-Renderer  reason: not valid java name */
    public /* synthetic */ boolean m124xf5c617ed(Layer.OnFeatureClickListener listener, Marker marker) {
        if (getFeature(marker) != null) {
            listener.onFeatureClick(getFeature(marker));
            return false;
        } else if (getContainerFeature(marker) != null) {
            listener.onFeatureClick(getContainerFeature(marker));
            return false;
        } else {
            listener.onFeatureClick(getFeature(multiObjectHandler(marker)));
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$setOnFeatureClickListener$2$com-google-maps-android-data-Renderer  reason: not valid java name */
    public /* synthetic */ void m125xbec70f2e(Layer.OnFeatureClickListener listener, Polyline polyline) {
        if (getFeature(polyline) != null) {
            listener.onFeatureClick(getFeature(polyline));
        } else if (getContainerFeature(polyline) != null) {
            listener.onFeatureClick(getContainerFeature(polyline));
        } else {
            listener.onFeatureClick(getFeature(multiObjectHandler(polyline)));
        }
    }

    private ArrayList<?> multiObjectHandler(Object mapObject) {
        for (Object value : getValues()) {
            Class c = value.getClass();
            if (c.getSimpleName().equals("ArrayList")) {
                ArrayList<?> mapObjects = (ArrayList) value;
                if (mapObjects.contains(mapObject)) {
                    return mapObjects;
                }
            }
        }
        return null;
    }
}
