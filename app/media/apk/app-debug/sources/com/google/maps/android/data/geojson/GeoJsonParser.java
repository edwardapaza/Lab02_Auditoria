package com.google.maps.android.data.geojson;

import android.util.Log;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.maps.android.data.Geometry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class GeoJsonParser {
    private static final String BOUNDING_BOX = "bbox";
    private static final String FEATURE = "Feature";
    private static final String FEATURE_COLLECTION = "FeatureCollection";
    private static final String FEATURE_COLLECTION_ARRAY = "features";
    private static final String FEATURE_GEOMETRY = "geometry";
    private static final String FEATURE_ID = "id";
    private static final String GEOMETRY_COLLECTION = "GeometryCollection";
    private static final String GEOMETRY_COLLECTION_ARRAY = "geometries";
    private static final String GEOMETRY_COORDINATES_ARRAY = "coordinates";
    private static final String LINESTRING = "LineString";
    private static final String LOG_TAG = "GeoJsonParser";
    private static final String MULTILINESTRING = "MultiLineString";
    private static final String MULTIPOINT = "MultiPoint";
    private static final String MULTIPOLYGON = "MultiPolygon";
    private static final String POINT = "Point";
    private static final String POLYGON = "Polygon";
    private static final String PROPERTIES = "properties";
    private final JSONObject mGeoJsonFile;
    private final ArrayList<GeoJsonFeature> mGeoJsonFeatures = new ArrayList<>();
    private LatLngBounds mBoundingBox = null;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class LatLngAlt {
        public final Double altitude;
        public final LatLng latLng;

        LatLngAlt(LatLng latLng, Double altitude) {
            this.latLng = latLng;
            this.altitude = altitude;
        }
    }

    public GeoJsonParser(JSONObject geoJsonFile) {
        this.mGeoJsonFile = geoJsonFile;
        parseGeoJson();
    }

    private static boolean isGeometry(String type) {
        return type.matches("Point|MultiPoint|LineString|MultiLineString|Polygon|MultiPolygon|GeometryCollection");
    }

    private static GeoJsonFeature parseFeature(JSONObject geoJsonFeature) {
        LatLngBounds boundingBox = null;
        Geometry geometry = null;
        HashMap<String, String> properties = new HashMap<>();
        try {
            String id = geoJsonFeature.has(FEATURE_ID) ? geoJsonFeature.getString(FEATURE_ID) : null;
            if (geoJsonFeature.has(BOUNDING_BOX)) {
                boundingBox = parseBoundingBox(geoJsonFeature.getJSONArray(BOUNDING_BOX));
            }
            if (geoJsonFeature.has(FEATURE_GEOMETRY) && !geoJsonFeature.isNull(FEATURE_GEOMETRY)) {
                geometry = parseGeometry(geoJsonFeature.getJSONObject(FEATURE_GEOMETRY));
            }
            if (geoJsonFeature.has(PROPERTIES) && !geoJsonFeature.isNull(PROPERTIES)) {
                properties = parseProperties(geoJsonFeature.getJSONObject(PROPERTIES));
            }
            return new GeoJsonFeature(geometry, id, properties, boundingBox);
        } catch (JSONException e) {
            Log.w(LOG_TAG, "Feature could not be successfully parsed " + geoJsonFeature.toString());
            return null;
        }
    }

    private static LatLngBounds parseBoundingBox(JSONArray coordinates) throws JSONException {
        LatLng southWestCorner = new LatLng(coordinates.getDouble(1), coordinates.getDouble(0));
        LatLng northEastCorner = new LatLng(coordinates.getDouble(3), coordinates.getDouble(2));
        return new LatLngBounds(southWestCorner, northEastCorner);
    }

    public static Geometry parseGeometry(JSONObject geoJsonGeometry) {
        JSONArray geometryArray;
        try {
            String geometryType = geoJsonGeometry.getString("type");
            if (geometryType.equals(GEOMETRY_COLLECTION)) {
                geometryArray = geoJsonGeometry.getJSONArray(GEOMETRY_COLLECTION_ARRAY);
            } else if (!isGeometry(geometryType)) {
                return null;
            } else {
                geometryArray = geoJsonGeometry.getJSONArray(GEOMETRY_COORDINATES_ARRAY);
            }
            return createGeometry(geometryType, geometryArray);
        } catch (JSONException e) {
            return null;
        }
    }

    private static GeoJsonFeature parseGeometryToFeature(JSONObject geoJsonGeometry) {
        Geometry geometry = parseGeometry(geoJsonGeometry);
        if (geometry != null) {
            return new GeoJsonFeature(geometry, null, new HashMap(), null);
        }
        Log.w(LOG_TAG, "Geometry could not be parsed");
        return null;
    }

    private static HashMap<String, String> parseProperties(JSONObject properties) throws JSONException {
        HashMap<String, String> propertiesMap = new HashMap<>();
        Iterator propertyKeys = properties.keys();
        while (propertyKeys.hasNext()) {
            String key = propertyKeys.next();
            propertiesMap.put(key, properties.isNull(key) ? null : properties.getString(key));
        }
        return propertiesMap;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private static Geometry createGeometry(String geometryType, JSONArray geometryArray) throws JSONException {
        char c;
        switch (geometryType.hashCode()) {
            case -2116761119:
                if (geometryType.equals(MULTIPOLYGON)) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            case -1065891849:
                if (geometryType.equals(MULTIPOINT)) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case -627102946:
                if (geometryType.equals(MULTILINESTRING)) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case 77292912:
                if (geometryType.equals(POINT)) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case 1267133722:
                if (geometryType.equals("Polygon")) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case 1806700869:
                if (geometryType.equals(LINESTRING)) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case 1950410960:
                if (geometryType.equals(GEOMETRY_COLLECTION)) {
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
                return createPoint(geometryArray);
            case 1:
                return createMultiPoint(geometryArray);
            case 2:
                return createLineString(geometryArray);
            case 3:
                return createMultiLineString(geometryArray);
            case 4:
                return createPolygon(geometryArray);
            case 5:
                return createMultiPolygon(geometryArray);
            case 6:
                return createGeometryCollection(geometryArray);
            default:
                return null;
        }
    }

    private static GeoJsonPoint createPoint(JSONArray coordinates) throws JSONException {
        LatLngAlt latLngAlt = parseCoordinate(coordinates);
        return new GeoJsonPoint(latLngAlt.latLng, latLngAlt.altitude);
    }

    private static GeoJsonMultiPoint createMultiPoint(JSONArray coordinates) throws JSONException {
        ArrayList<GeoJsonPoint> geoJsonPoints = new ArrayList<>();
        for (int i = 0; i < coordinates.length(); i++) {
            geoJsonPoints.add(createPoint(coordinates.getJSONArray(i)));
        }
        return new GeoJsonMultiPoint(geoJsonPoints);
    }

    private static GeoJsonLineString createLineString(JSONArray coordinates) throws JSONException {
        ArrayList<LatLngAlt> latLngAlts = parseCoordinatesArray(coordinates);
        ArrayList<LatLng> latLngs = new ArrayList<>();
        ArrayList<Double> altitudes = new ArrayList<>();
        Iterator<LatLngAlt> it = latLngAlts.iterator();
        while (it.hasNext()) {
            LatLngAlt latLngAlt = it.next();
            latLngs.add(latLngAlt.latLng);
            if (latLngAlt.altitude != null) {
                altitudes.add(latLngAlt.altitude);
            }
        }
        return new GeoJsonLineString(latLngs, altitudes);
    }

    private static GeoJsonMultiLineString createMultiLineString(JSONArray coordinates) throws JSONException {
        ArrayList<GeoJsonLineString> geoJsonLineStrings = new ArrayList<>();
        for (int i = 0; i < coordinates.length(); i++) {
            geoJsonLineStrings.add(createLineString(coordinates.getJSONArray(i)));
        }
        return new GeoJsonMultiLineString(geoJsonLineStrings);
    }

    private static GeoJsonPolygon createPolygon(JSONArray coordinates) throws JSONException {
        return new GeoJsonPolygon(parseCoordinatesArrays(coordinates));
    }

    private static GeoJsonMultiPolygon createMultiPolygon(JSONArray coordinates) throws JSONException {
        ArrayList<GeoJsonPolygon> geoJsonPolygons = new ArrayList<>();
        for (int i = 0; i < coordinates.length(); i++) {
            geoJsonPolygons.add(createPolygon(coordinates.getJSONArray(i)));
        }
        return new GeoJsonMultiPolygon(geoJsonPolygons);
    }

    private static GeoJsonGeometryCollection createGeometryCollection(JSONArray geometries) throws JSONException {
        ArrayList<Geometry> geometryCollectionElements = new ArrayList<>();
        for (int i = 0; i < geometries.length(); i++) {
            JSONObject geometryElement = geometries.getJSONObject(i);
            Geometry geometry = parseGeometry(geometryElement);
            if (geometry != null) {
                geometryCollectionElements.add(geometry);
            }
        }
        return new GeoJsonGeometryCollection(geometryCollectionElements);
    }

    private static LatLngAlt parseCoordinate(JSONArray coordinates) throws JSONException {
        LatLng latLng = new LatLng(coordinates.getDouble(1), coordinates.getDouble(0));
        Double altitude = coordinates.length() < 3 ? null : Double.valueOf(coordinates.getDouble(2));
        return new LatLngAlt(latLng, altitude);
    }

    private static ArrayList<LatLngAlt> parseCoordinatesArray(JSONArray coordinates) throws JSONException {
        ArrayList<LatLngAlt> coordinatesArray = new ArrayList<>();
        for (int i = 0; i < coordinates.length(); i++) {
            coordinatesArray.add(parseCoordinate(coordinates.getJSONArray(i)));
        }
        return coordinatesArray;
    }

    private static ArrayList<ArrayList<LatLng>> parseCoordinatesArrays(JSONArray coordinates) throws JSONException {
        ArrayList<ArrayList<LatLng>> coordinatesArray = new ArrayList<>();
        for (int i = 0; i < coordinates.length(); i++) {
            ArrayList<LatLngAlt> latLngAlts = parseCoordinatesArray(coordinates.getJSONArray(i));
            ArrayList<LatLng> latLngs = new ArrayList<>();
            Iterator<LatLngAlt> it = latLngAlts.iterator();
            while (it.hasNext()) {
                LatLngAlt latLngAlt = it.next();
                latLngs.add(latLngAlt.latLng);
            }
            coordinatesArray.add(latLngs);
        }
        return coordinatesArray;
    }

    private void parseGeoJson() {
        try {
            String type = this.mGeoJsonFile.getString("type");
            if (type.equals(FEATURE)) {
                GeoJsonFeature feature = parseFeature(this.mGeoJsonFile);
                if (feature != null) {
                    this.mGeoJsonFeatures.add(feature);
                }
            } else if (type.equals(FEATURE_COLLECTION)) {
                this.mGeoJsonFeatures.addAll(parseFeatureCollection(this.mGeoJsonFile));
            } else if (isGeometry(type)) {
                GeoJsonFeature feature2 = parseGeometryToFeature(this.mGeoJsonFile);
                if (feature2 != null) {
                    this.mGeoJsonFeatures.add(feature2);
                }
            } else {
                Log.w(LOG_TAG, "GeoJSON file could not be parsed.");
            }
        } catch (JSONException e) {
            Log.w(LOG_TAG, "GeoJSON file could not be parsed.");
        }
    }

    private ArrayList<GeoJsonFeature> parseFeatureCollection(JSONObject geoJsonFeatureCollection) {
        ArrayList<GeoJsonFeature> features = new ArrayList<>();
        try {
            JSONArray geoJsonFeatures = geoJsonFeatureCollection.getJSONArray(FEATURE_COLLECTION_ARRAY);
            if (geoJsonFeatureCollection.has(BOUNDING_BOX)) {
                this.mBoundingBox = parseBoundingBox(geoJsonFeatureCollection.getJSONArray(BOUNDING_BOX));
            }
            for (int i = 0; i < geoJsonFeatures.length(); i++) {
                try {
                    JSONObject feature = geoJsonFeatures.getJSONObject(i);
                    if (feature.getString("type").equals(FEATURE)) {
                        GeoJsonFeature parsedFeature = parseFeature(feature);
                        if (parsedFeature == null) {
                            Log.w(LOG_TAG, "Index of Feature in Feature Collection that could not be created: " + i);
                        } else {
                            features.add(parsedFeature);
                        }
                    }
                } catch (JSONException e) {
                    Log.w(LOG_TAG, "Index of Feature in Feature Collection that could not be created: " + i);
                }
            }
            return features;
        } catch (JSONException e2) {
            Log.w(LOG_TAG, "Feature Collection could not be created.");
            return features;
        }
    }

    public ArrayList<GeoJsonFeature> getFeatures() {
        return this.mGeoJsonFeatures;
    }

    public LatLngBounds getBoundingBox() {
        return this.mBoundingBox;
    }
}
