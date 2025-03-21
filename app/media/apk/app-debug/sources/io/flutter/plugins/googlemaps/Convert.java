package io.flutter.plugins.googlemaps;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Tile;
import com.google.firebase.messaging.Constants;
import com.google.maps.android.clustering.Cluster;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
/* loaded from: classes2.dex */
class Convert {
    Convert() {
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x001e, code lost:
        if (r2.equals("defaultMarker") != false) goto L5;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static com.google.android.gms.maps.model.BitmapDescriptor toBitmapDescriptor(java.lang.Object r7) {
        /*
            java.util.List r0 = toList(r7)
            r1 = 0
            java.lang.Object r2 = r0.get(r1)
            java.lang.String r2 = toString(r2)
            int r3 = r2.hashCode()
            r4 = 3
            r5 = 2
            r6 = 1
            switch(r3) {
                case -458749035: goto L35;
                case 52960614: goto L2b;
                case 54063841: goto L21;
                case 784458203: goto L18;
                default: goto L17;
            }
        L17:
            goto L3f
        L18:
            java.lang.String r3 = "defaultMarker"
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L17
            goto L40
        L21:
            java.lang.String r1 = "fromBytes"
            boolean r1 = r2.equals(r1)
            if (r1 == 0) goto L17
            r1 = 3
            goto L40
        L2b:
            java.lang.String r1 = "fromAsset"
            boolean r1 = r2.equals(r1)
            if (r1 == 0) goto L17
            r1 = 1
            goto L40
        L35:
            java.lang.String r1 = "fromAssetImage"
            boolean r1 = r2.equals(r1)
            if (r1 == 0) goto L17
            r1 = 2
            goto L40
        L3f:
            r1 = -1
        L40:
            switch(r1) {
                case 0: goto Lce;
                case 1: goto L9c;
                case 2: goto L67;
                case 3: goto L62;
                default: goto L43;
            }
        L43:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Cannot interpret "
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.StringBuilder r2 = r2.append(r7)
            java.lang.String r3 = " as BitmapDescriptor"
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        L62:
            com.google.android.gms.maps.model.BitmapDescriptor r1 = getBitmapFromBytes(r0)
            return r1
        L67:
            int r1 = r0.size()
            if (r1 != r4) goto L7f
        L6e:
            java.lang.Object r1 = r0.get(r6)
            java.lang.String r1 = toString(r1)
            java.lang.String r1 = io.flutter.view.FlutterMain.getLookupKeyForAsset(r1)
            com.google.android.gms.maps.model.BitmapDescriptor r1 = com.google.android.gms.maps.model.BitmapDescriptorFactory.fromAsset(r1)
            return r1
        L7f:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "'fromAssetImage' Expected exactly 3 arguments, got: "
            java.lang.StringBuilder r2 = r2.append(r3)
            int r3 = r0.size()
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        L9c:
            int r1 = r0.size()
            if (r1 != r5) goto Lb4
        La3:
            java.lang.Object r1 = r0.get(r6)
            java.lang.String r1 = toString(r1)
            java.lang.String r1 = io.flutter.view.FlutterMain.getLookupKeyForAsset(r1)
            com.google.android.gms.maps.model.BitmapDescriptor r1 = com.google.android.gms.maps.model.BitmapDescriptorFactory.fromAsset(r1)
            return r1
        Lb4:
            java.lang.Object r1 = r0.get(r6)
            java.lang.String r1 = toString(r1)
            java.lang.Object r2 = r0.get(r5)
            java.lang.String r2 = toString(r2)
            java.lang.String r1 = io.flutter.view.FlutterMain.getLookupKeyForAsset(r1, r2)
            com.google.android.gms.maps.model.BitmapDescriptor r1 = com.google.android.gms.maps.model.BitmapDescriptorFactory.fromAsset(r1)
            return r1
        Lce:
            int r1 = r0.size()
            if (r1 != r6) goto Ld9
            com.google.android.gms.maps.model.BitmapDescriptor r1 = com.google.android.gms.maps.model.BitmapDescriptorFactory.defaultMarker()
            return r1
        Ld9:
            java.lang.Object r1 = r0.get(r6)
            float r1 = toFloat(r1)
            com.google.android.gms.maps.model.BitmapDescriptor r1 = com.google.android.gms.maps.model.BitmapDescriptorFactory.defaultMarker(r1)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flutter.plugins.googlemaps.Convert.toBitmapDescriptor(java.lang.Object):com.google.android.gms.maps.model.BitmapDescriptor");
    }

    private static BitmapDescriptor getBitmapFromBytes(List<?> data) {
        if (data.size() == 2) {
            try {
                Bitmap bitmap = toBitmap(data.get(1));
                return BitmapDescriptorFactory.fromBitmap(bitmap);
            } catch (Exception e) {
                throw new IllegalArgumentException("Unable to interpret bytes as a valid image.", e);
            }
        }
        throw new IllegalArgumentException("fromBytes should have exactly one argument, interpretTileOverlayOptions the bytes. Got: " + data.size());
    }

    private static boolean toBoolean(Object o) {
        return ((Boolean) o).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static CameraPosition toCameraPosition(Object o) {
        Map<?, ?> data = toMap(o);
        CameraPosition.Builder builder = CameraPosition.builder();
        builder.bearing(toFloat(data.get("bearing")));
        builder.target(toLatLng(data.get("target")));
        builder.tilt(toFloat(data.get("tilt")));
        builder.zoom(toFloat(data.get("zoom")));
        return builder.build();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0027, code lost:
        if (r2.equals("newCameraPosition") != false) goto L6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.google.android.gms.maps.CameraUpdate toCameraUpdate(java.lang.Object r6, float r7) {
        /*
            Method dump skipped, instructions count: 362
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flutter.plugins.googlemaps.Convert.toCameraUpdate(java.lang.Object, float):com.google.android.gms.maps.CameraUpdate");
    }

    private static double toDouble(Object o) {
        return ((Number) o).doubleValue();
    }

    private static float toFloat(Object o) {
        return ((Number) o).floatValue();
    }

    private static Float toFloatWrapper(Object o) {
        if (o == null) {
            return null;
        }
        return Float.valueOf(toFloat(o));
    }

    private static int toInt(Object o) {
        return ((Number) o).intValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object cameraPositionToJson(CameraPosition position) {
        if (position == null) {
            return null;
        }
        Map<String, Object> data = new HashMap<>();
        data.put("bearing", Float.valueOf(position.bearing));
        data.put("target", latLngToJson(position.target));
        data.put("tilt", Float.valueOf(position.tilt));
        data.put("zoom", Float.valueOf(position.zoom));
        return data;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object latLngBoundsToJson(LatLngBounds latLngBounds) {
        Map<String, Object> arguments = new HashMap<>(2);
        arguments.put("southwest", latLngToJson(latLngBounds.southwest));
        arguments.put("northeast", latLngToJson(latLngBounds.northeast));
        return arguments;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object markerIdToJson(String markerId) {
        if (markerId == null) {
            return null;
        }
        Map<String, Object> data = new HashMap<>(1);
        data.put("markerId", markerId);
        return data;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object polygonIdToJson(String polygonId) {
        if (polygonId == null) {
            return null;
        }
        Map<String, Object> data = new HashMap<>(1);
        data.put("polygonId", polygonId);
        return data;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object polylineIdToJson(String polylineId) {
        if (polylineId == null) {
            return null;
        }
        Map<String, Object> data = new HashMap<>(1);
        data.put("polylineId", polylineId);
        return data;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object circleIdToJson(String circleId) {
        if (circleId == null) {
            return null;
        }
        Map<String, Object> data = new HashMap<>(1);
        data.put("circleId", circleId);
        return data;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Map<String, Object> tileOverlayArgumentsToJson(String tileOverlayId, int x, int y, int zoom) {
        if (tileOverlayId == null) {
            return null;
        }
        Map<String, Object> data = new HashMap<>(4);
        data.put("tileOverlayId", tileOverlayId);
        data.put("x", Integer.valueOf(x));
        data.put("y", Integer.valueOf(y));
        data.put("zoom", Integer.valueOf(zoom));
        return data;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object latLngToJson(LatLng latLng) {
        return Arrays.asList(Double.valueOf(latLng.latitude), Double.valueOf(latLng.longitude));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object clustersToJson(String clusterManagerId, Set<? extends Cluster<MarkerBuilder>> clusters) {
        List<Object> data = new ArrayList<>(clusters.size());
        for (Cluster<MarkerBuilder> cluster : clusters) {
            data.add(clusterToJson(clusterManagerId, cluster));
        }
        return data;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object clusterToJson(String clusterManagerId, Cluster<MarkerBuilder> cluster) {
        int clusterSize = cluster.getSize();
        LatLngBounds.Builder latLngBoundsBuilder = LatLngBounds.builder();
        String[] markerIds = new String[clusterSize];
        MarkerBuilder[] markerBuilders = (MarkerBuilder[]) cluster.getItems().toArray(new MarkerBuilder[clusterSize]);
        for (int i = 0; i < clusterSize; i++) {
            MarkerBuilder markerBuilder = markerBuilders[i];
            latLngBoundsBuilder.include(markerBuilder.getPosition());
            markerIds[i] = markerBuilder.markerId();
        }
        Object position = latLngToJson(cluster.getPosition());
        Object bounds = latLngBoundsToJson(latLngBoundsBuilder.build());
        Map<String, Object> data = new HashMap<>(4);
        data.put("clusterManagerId", clusterManagerId);
        data.put("position", position);
        data.put("bounds", bounds);
        data.put("markerIds", Arrays.asList(markerIds));
        return data;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static LatLng toLatLng(Object o) {
        List<?> data = toList(o);
        return new LatLng(toDouble(data.get(0)), toDouble(data.get(1)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Point toPoint(Object o) {
        Object x = toMap(o).get("x");
        Object y = toMap(o).get("y");
        return new Point(((Integer) x).intValue(), ((Integer) y).intValue());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Map<String, Integer> pointToJson(Point point) {
        Map<String, Integer> data = new HashMap<>(2);
        data.put("x", Integer.valueOf(point.x));
        data.put("y", Integer.valueOf(point.y));
        return data;
    }

    private static LatLngBounds toLatLngBounds(Object o) {
        if (o == null) {
            return null;
        }
        List<?> data = toList(o);
        return new LatLngBounds(toLatLng(data.get(0)), toLatLng(data.get(1)));
    }

    private static List<?> toList(Object o) {
        return (List) o;
    }

    private static Map<?, ?> toMap(Object o) {
        return (Map) o;
    }

    private static Map<String, Object> toObjectMap(Object o) {
        Map<String, Object> hashMap = new HashMap<>();
        Map<?, ?> map = (Map) o;
        for (Object key : map.keySet()) {
            Object object = map.get(key);
            if (object != null) {
                hashMap.put((String) key, object);
            }
        }
        return hashMap;
    }

    private static float toFractionalPixels(Object o, float density) {
        return toFloat(o) * density;
    }

    private static int toPixels(Object o, float density) {
        return (int) toFractionalPixels(o, density);
    }

    private static Bitmap toBitmap(Object o) {
        byte[] bmpData = (byte[]) o;
        Bitmap bitmap = BitmapFactory.decodeByteArray(bmpData, 0, bmpData.length);
        if (bitmap == null) {
            throw new IllegalArgumentException("Unable to decode bytes as a valid bitmap.");
        }
        return bitmap;
    }

    private static Point toPoint(Object o, float density) {
        List<?> data = toList(o);
        return new Point(toPixels(data.get(0), density), toPixels(data.get(1), density));
    }

    private static String toString(Object o) {
        return (String) o;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void interpretGoogleMapOptions(Object o, GoogleMapOptionsSink sink) {
        Map<?, ?> data = toMap(o);
        Object cameraTargetBounds = data.get("cameraTargetBounds");
        if (cameraTargetBounds != null) {
            List<?> targetData = toList(cameraTargetBounds);
            sink.setCameraTargetBounds(toLatLngBounds(targetData.get(0)));
        }
        Object compassEnabled = data.get("compassEnabled");
        if (compassEnabled != null) {
            sink.setCompassEnabled(toBoolean(compassEnabled));
        }
        Object mapToolbarEnabled = data.get("mapToolbarEnabled");
        if (mapToolbarEnabled != null) {
            sink.setMapToolbarEnabled(toBoolean(mapToolbarEnabled));
        }
        Object mapType = data.get("mapType");
        if (mapType != null) {
            sink.setMapType(toInt(mapType));
        }
        Object minMaxZoomPreference = data.get("minMaxZoomPreference");
        if (minMaxZoomPreference != null) {
            List<?> zoomPreferenceData = toList(minMaxZoomPreference);
            sink.setMinMaxZoomPreference(toFloatWrapper(zoomPreferenceData.get(0)), toFloatWrapper(zoomPreferenceData.get(1)));
        }
        Object padding = data.get("padding");
        if (padding != null) {
            List<?> paddingData = toList(padding);
            sink.setPadding(toFloat(paddingData.get(0)), toFloat(paddingData.get(1)), toFloat(paddingData.get(2)), toFloat(paddingData.get(3)));
        }
        Object rotateGesturesEnabled = data.get("rotateGesturesEnabled");
        if (rotateGesturesEnabled != null) {
            sink.setRotateGesturesEnabled(toBoolean(rotateGesturesEnabled));
        }
        Object scrollGesturesEnabled = data.get("scrollGesturesEnabled");
        if (scrollGesturesEnabled != null) {
            sink.setScrollGesturesEnabled(toBoolean(scrollGesturesEnabled));
        }
        Object tiltGesturesEnabled = data.get("tiltGesturesEnabled");
        if (tiltGesturesEnabled != null) {
            sink.setTiltGesturesEnabled(toBoolean(tiltGesturesEnabled));
        }
        Object trackCameraPosition = data.get("trackCameraPosition");
        if (trackCameraPosition != null) {
            sink.setTrackCameraPosition(toBoolean(trackCameraPosition));
        }
        Object zoomGesturesEnabled = data.get("zoomGesturesEnabled");
        if (zoomGesturesEnabled != null) {
            sink.setZoomGesturesEnabled(toBoolean(zoomGesturesEnabled));
        }
        Object liteModeEnabled = data.get("liteModeEnabled");
        if (liteModeEnabled != null) {
            sink.setLiteModeEnabled(toBoolean(liteModeEnabled));
        }
        Object myLocationEnabled = data.get("myLocationEnabled");
        if (myLocationEnabled != null) {
            sink.setMyLocationEnabled(toBoolean(myLocationEnabled));
        }
        Object zoomControlsEnabled = data.get("zoomControlsEnabled");
        if (zoomControlsEnabled != null) {
            sink.setZoomControlsEnabled(toBoolean(zoomControlsEnabled));
        }
        Object myLocationButtonEnabled = data.get("myLocationButtonEnabled");
        if (myLocationButtonEnabled != null) {
            sink.setMyLocationButtonEnabled(toBoolean(myLocationButtonEnabled));
        }
        Object indoorEnabled = data.get("indoorEnabled");
        if (indoorEnabled != null) {
            sink.setIndoorEnabled(toBoolean(indoorEnabled));
        }
        Object trafficEnabled = data.get("trafficEnabled");
        if (trafficEnabled != null) {
            sink.setTrafficEnabled(toBoolean(trafficEnabled));
        }
        Object buildingsEnabled = data.get("buildingsEnabled");
        if (buildingsEnabled != null) {
            sink.setBuildingsEnabled(toBoolean(buildingsEnabled));
        }
        Object style = data.get("style");
        if (style != null) {
            sink.setMapStyle(toString(style));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void interpretMarkerOptions(Object o, MarkerOptionsSink sink) {
        Map<?, ?> data = toMap(o);
        Object alpha = data.get("alpha");
        if (alpha != null) {
            sink.setAlpha(toFloat(alpha));
        }
        Object anchor = data.get("anchor");
        if (anchor != null) {
            List<?> anchorData = toList(anchor);
            sink.setAnchor(toFloat(anchorData.get(0)), toFloat(anchorData.get(1)));
        }
        Object consumeTapEvents = data.get("consumeTapEvents");
        if (consumeTapEvents != null) {
            sink.setConsumeTapEvents(toBoolean(consumeTapEvents));
        }
        Object draggable = data.get("draggable");
        if (draggable != null) {
            sink.setDraggable(toBoolean(draggable));
        }
        Object flat = data.get("flat");
        if (flat != null) {
            sink.setFlat(toBoolean(flat));
        }
        Object icon = data.get("icon");
        if (icon != null) {
            sink.setIcon(toBitmapDescriptor(icon));
        }
        Object infoWindow = data.get("infoWindow");
        if (infoWindow != null) {
            interpretInfoWindowOptions(sink, toObjectMap(infoWindow));
        }
        Object position = data.get("position");
        if (position != null) {
            sink.setPosition(toLatLng(position));
        }
        Object rotation = data.get("rotation");
        if (rotation != null) {
            sink.setRotation(toFloat(rotation));
        }
        Object visible = data.get("visible");
        if (visible != null) {
            sink.setVisible(toBoolean(visible));
        }
        Object zIndex = data.get("zIndex");
        if (zIndex != null) {
            sink.setZIndex(toFloat(zIndex));
        }
    }

    private static void interpretInfoWindowOptions(MarkerOptionsSink sink, Map<String, Object> infoWindow) {
        String title = (String) infoWindow.get("title");
        String snippet = (String) infoWindow.get("snippet");
        if (title != null) {
            sink.setInfoWindowText(title, snippet);
        }
        Object infoWindowAnchor = infoWindow.get("anchor");
        if (infoWindowAnchor != null) {
            List<?> anchorData = toList(infoWindowAnchor);
            sink.setInfoWindowAnchor(toFloat(anchorData.get(0)), toFloat(anchorData.get(1)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String interpretPolygonOptions(Object o, PolygonOptionsSink sink) {
        Map<?, ?> data = toMap(o);
        Object consumeTapEvents = data.get("consumeTapEvents");
        if (consumeTapEvents != null) {
            sink.setConsumeTapEvents(toBoolean(consumeTapEvents));
        }
        Object geodesic = data.get("geodesic");
        if (geodesic != null) {
            sink.setGeodesic(toBoolean(geodesic));
        }
        Object visible = data.get("visible");
        if (visible != null) {
            sink.setVisible(toBoolean(visible));
        }
        Object fillColor = data.get("fillColor");
        if (fillColor != null) {
            sink.setFillColor(toInt(fillColor));
        }
        Object strokeColor = data.get("strokeColor");
        if (strokeColor != null) {
            sink.setStrokeColor(toInt(strokeColor));
        }
        Object strokeWidth = data.get("strokeWidth");
        if (strokeWidth != null) {
            sink.setStrokeWidth(toInt(strokeWidth));
        }
        Object zIndex = data.get("zIndex");
        if (zIndex != null) {
            sink.setZIndex(toFloat(zIndex));
        }
        Object points = data.get("points");
        if (points != null) {
            sink.setPoints(toPoints(points));
        }
        Object holes = data.get("holes");
        if (holes != null) {
            sink.setHoles(toHoles(holes));
        }
        String polygonId = (String) data.get("polygonId");
        if (polygonId == null) {
            throw new IllegalArgumentException("polygonId was null");
        }
        return polygonId;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String interpretPolylineOptions(Object o, PolylineOptionsSink sink) {
        Map<?, ?> data = toMap(o);
        Object consumeTapEvents = data.get("consumeTapEvents");
        if (consumeTapEvents != null) {
            sink.setConsumeTapEvents(toBoolean(consumeTapEvents));
        }
        Object color = data.get("color");
        if (color != null) {
            sink.setColor(toInt(color));
        }
        Object endCap = data.get("endCap");
        if (endCap != null) {
            sink.setEndCap(toCap(endCap));
        }
        Object geodesic = data.get("geodesic");
        if (geodesic != null) {
            sink.setGeodesic(toBoolean(geodesic));
        }
        Object jointType = data.get("jointType");
        if (jointType != null) {
            sink.setJointType(toInt(jointType));
        }
        Object startCap = data.get("startCap");
        if (startCap != null) {
            sink.setStartCap(toCap(startCap));
        }
        Object visible = data.get("visible");
        if (visible != null) {
            sink.setVisible(toBoolean(visible));
        }
        Object width = data.get("width");
        if (width != null) {
            sink.setWidth(toInt(width));
        }
        Object zIndex = data.get("zIndex");
        if (zIndex != null) {
            sink.setZIndex(toFloat(zIndex));
        }
        Object points = data.get("points");
        if (points != null) {
            sink.setPoints(toPoints(points));
        }
        Object pattern = data.get("pattern");
        if (pattern != null) {
            sink.setPattern(toPattern(pattern));
        }
        String polylineId = (String) data.get("polylineId");
        if (polylineId == null) {
            throw new IllegalArgumentException("polylineId was null");
        }
        return polylineId;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String interpretCircleOptions(Object o, CircleOptionsSink sink) {
        Map<?, ?> data = toMap(o);
        Object consumeTapEvents = data.get("consumeTapEvents");
        if (consumeTapEvents != null) {
            sink.setConsumeTapEvents(toBoolean(consumeTapEvents));
        }
        Object fillColor = data.get("fillColor");
        if (fillColor != null) {
            sink.setFillColor(toInt(fillColor));
        }
        Object strokeColor = data.get("strokeColor");
        if (strokeColor != null) {
            sink.setStrokeColor(toInt(strokeColor));
        }
        Object visible = data.get("visible");
        if (visible != null) {
            sink.setVisible(toBoolean(visible));
        }
        Object strokeWidth = data.get("strokeWidth");
        if (strokeWidth != null) {
            sink.setStrokeWidth(toInt(strokeWidth));
        }
        Object zIndex = data.get("zIndex");
        if (zIndex != null) {
            sink.setZIndex(toFloat(zIndex));
        }
        Object center = data.get("center");
        if (center != null) {
            sink.setCenter(toLatLng(center));
        }
        Object radius = data.get("radius");
        if (radius != null) {
            sink.setRadius(toDouble(radius));
        }
        String circleId = (String) data.get("circleId");
        if (circleId == null) {
            throw new IllegalArgumentException("circleId was null");
        }
        return circleId;
    }

    static List<LatLng> toPoints(Object o) {
        List<?> data = toList(o);
        List<LatLng> points = new ArrayList<>(data.size());
        for (Object rawPoint : data) {
            List<?> point = toList(rawPoint);
            points.add(new LatLng(toDouble(point.get(0)), toDouble(point.get(1))));
        }
        return points;
    }

    private static List<List<LatLng>> toHoles(Object o) {
        List<?> data = toList(o);
        List<List<LatLng>> holes = new ArrayList<>(data.size());
        for (Object rawHole : data) {
            holes.add(toPoints(rawHole));
        }
        return holes;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0054, code lost:
        if (r6.equals("dot") != false) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static java.util.List<com.google.android.gms.maps.model.PatternItem> toPattern(java.lang.Object r10) {
        /*
            java.util.List r0 = toList(r10)
            boolean r1 = r0.isEmpty()
            if (r1 == 0) goto Lc
            r1 = 0
            return r1
        Lc:
            java.util.ArrayList r1 = new java.util.ArrayList
            int r2 = r0.size()
            r1.<init>(r2)
            java.util.Iterator r2 = r0.iterator()
        L19:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto La7
            java.lang.Object r3 = r2.next()
            java.util.List r4 = toList(r3)
            r5 = 0
            java.lang.Object r6 = r4.get(r5)
            java.lang.String r6 = toString(r6)
            r7 = -1
            int r8 = r6.hashCode()
            r9 = 1
            switch(r8) {
                case 99657: goto L4e;
                case 102102: goto L44;
                case 3075986: goto L3a;
                default: goto L39;
            }
        L39:
            goto L57
        L3a:
            java.lang.String r5 = "dash"
            boolean r5 = r6.equals(r5)
            if (r5 == 0) goto L39
            r5 = 1
            goto L58
        L44:
            java.lang.String r5 = "gap"
            boolean r5 = r6.equals(r5)
            if (r5 == 0) goto L39
            r5 = 2
            goto L58
        L4e:
            java.lang.String r8 = "dot"
            boolean r6 = r6.equals(r8)
            if (r6 == 0) goto L39
            goto L58
        L57:
            r5 = -1
        L58:
            switch(r5) {
                case 0: goto L9c;
                case 1: goto L8b;
                case 2: goto L7a;
                default: goto L5b;
            }
        L5b:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "Cannot interpret "
            java.lang.StringBuilder r5 = r5.append(r6)
            java.lang.StringBuilder r5 = r5.append(r1)
            java.lang.String r6 = " as PatternItem"
            java.lang.StringBuilder r5 = r5.append(r6)
            java.lang.String r5 = r5.toString()
            r2.<init>(r5)
            throw r2
        L7a:
            com.google.android.gms.maps.model.Gap r5 = new com.google.android.gms.maps.model.Gap
            java.lang.Object r6 = r4.get(r9)
            float r6 = toFloat(r6)
            r5.<init>(r6)
            r1.add(r5)
            goto La5
        L8b:
            com.google.android.gms.maps.model.Dash r5 = new com.google.android.gms.maps.model.Dash
            java.lang.Object r6 = r4.get(r9)
            float r6 = toFloat(r6)
            r5.<init>(r6)
            r1.add(r5)
            goto La5
        L9c:
            com.google.android.gms.maps.model.Dot r5 = new com.google.android.gms.maps.model.Dot
            r5.<init>()
            r1.add(r5)
        La5:
            goto L19
        La7:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flutter.plugins.googlemaps.Convert.toPattern(java.lang.Object):java.util.List");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0031, code lost:
        if (r2.equals("buttCap") != false) goto L6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static com.google.android.gms.maps.model.Cap toCap(java.lang.Object r6) {
        /*
            java.util.List r0 = toList(r6)
            r1 = 0
            java.lang.Object r2 = r0.get(r1)
            java.lang.String r2 = toString(r2)
            int r3 = r2.hashCode()
            r4 = 1
            r5 = 2
            switch(r3) {
                case -179356: goto L34;
                case 241309887: goto L2b;
                case 1314340213: goto L21;
                case 1611528865: goto L17;
                default: goto L16;
            }
        L16:
            goto L3e
        L17:
            java.lang.String r1 = "customCap"
            boolean r1 = r2.equals(r1)
            if (r1 == 0) goto L16
            r1 = 3
            goto L3f
        L21:
            java.lang.String r1 = "squareCap"
            boolean r1 = r2.equals(r1)
            if (r1 == 0) goto L16
            r1 = 2
            goto L3f
        L2b:
            java.lang.String r3 = "buttCap"
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L16
            goto L3f
        L34:
            java.lang.String r1 = "roundCap"
            boolean r1 = r2.equals(r1)
            if (r1 == 0) goto L16
            r1 = 1
            goto L3f
        L3e:
            r1 = -1
        L3f:
            switch(r1) {
                case 0: goto L97;
                case 1: goto L91;
                case 2: goto L8b;
                case 3: goto L61;
                default: goto L42;
            }
        L42:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Cannot interpret "
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.StringBuilder r2 = r2.append(r6)
            java.lang.String r3 = " as Cap"
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        L61:
            int r1 = r0.size()
            if (r1 != r5) goto L75
            com.google.android.gms.maps.model.CustomCap r1 = new com.google.android.gms.maps.model.CustomCap
            java.lang.Object r2 = r0.get(r4)
            com.google.android.gms.maps.model.BitmapDescriptor r2 = toBitmapDescriptor(r2)
            r1.<init>(r2)
            return r1
        L75:
            com.google.android.gms.maps.model.CustomCap r1 = new com.google.android.gms.maps.model.CustomCap
            java.lang.Object r2 = r0.get(r4)
            com.google.android.gms.maps.model.BitmapDescriptor r2 = toBitmapDescriptor(r2)
            java.lang.Object r3 = r0.get(r5)
            float r3 = toFloat(r3)
            r1.<init>(r2, r3)
            return r1
        L8b:
            com.google.android.gms.maps.model.SquareCap r1 = new com.google.android.gms.maps.model.SquareCap
            r1.<init>()
            return r1
        L91:
            com.google.android.gms.maps.model.RoundCap r1 = new com.google.android.gms.maps.model.RoundCap
            r1.<init>()
            return r1
        L97:
            com.google.android.gms.maps.model.ButtCap r1 = new com.google.android.gms.maps.model.ButtCap
            r1.<init>()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flutter.plugins.googlemaps.Convert.toCap(java.lang.Object):com.google.android.gms.maps.model.Cap");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String interpretTileOverlayOptions(Map<String, ?> data, TileOverlaySink sink) {
        Object fadeIn = data.get("fadeIn");
        if (fadeIn != null) {
            sink.setFadeIn(toBoolean(fadeIn));
        }
        Object transparency = data.get("transparency");
        if (transparency != null) {
            sink.setTransparency(toFloat(transparency));
        }
        Object zIndex = data.get("zIndex");
        if (zIndex != null) {
            sink.setZIndex(toFloat(zIndex));
        }
        Object visible = data.get("visible");
        if (visible != null) {
            sink.setVisible(toBoolean(visible));
        }
        String tileOverlayId = (String) data.get("tileOverlayId");
        if (tileOverlayId == null) {
            throw new IllegalArgumentException("tileOverlayId was null");
        }
        return tileOverlayId;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Tile interpretTile(Map<String, ?> data) {
        int width = toInt(data.get("width"));
        int height = toInt(data.get("height"));
        byte[] dataArray = null;
        if (data.get(Constants.ScionAnalytics.MessageType.DATA_MESSAGE) != null) {
            dataArray = (byte[]) data.get(Constants.ScionAnalytics.MessageType.DATA_MESSAGE);
        }
        return new Tile(width, height, dataArray);
    }
}
