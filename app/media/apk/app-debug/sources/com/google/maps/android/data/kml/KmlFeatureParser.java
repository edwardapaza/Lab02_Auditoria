package com.google.maps.android.data.kml;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.maps.android.data.Geometry;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class KmlFeatureParser {
    private static final int ALTITUDE_INDEX = 2;
    private static final String BOUNDARY_REGEX = "outerBoundaryIs|innerBoundaryIs";
    private static final String COMPASS_REGEX = "north|south|east|west";
    private static final String EXTENDED_DATA = "ExtendedData";
    private static final String GEOMETRY_REGEX = "Point|LineString|Polygon|MultiGeometry|Track|MultiTrack";
    private static final int LATITUDE_INDEX = 1;
    private static final String LAT_LNG_ALT_SEPARATOR = ",";
    private static final int LONGITUDE_INDEX = 0;
    private static final String PROPERTY_REGEX = "name|description|drawOrder|visibility|open|address|phoneNumber";
    private static final String STYLE_TAG = "Style";
    private static final String STYLE_URL_TAG = "styleUrl";

    KmlFeatureParser() {
    }

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

    /* JADX INFO: Access modifiers changed from: package-private */
    public static KmlPlacemark createPlacemark(XmlPullParser parser) throws IOException, XmlPullParserException {
        String styleId = null;
        KmlStyle inlineStyle = null;
        HashMap<String, String> properties = new HashMap<>();
        Geometry geometry = null;
        int eventType = parser.getEventType();
        while (true) {
            if (eventType != 3 || !parser.getName().equals("Placemark")) {
                if (eventType == 2) {
                    if (parser.getName().equals(STYLE_URL_TAG)) {
                        styleId = parser.nextText();
                    } else if (parser.getName().matches(GEOMETRY_REGEX)) {
                        geometry = createGeometry(parser, parser.getName());
                    } else if (parser.getName().matches(PROPERTY_REGEX)) {
                        properties.put(parser.getName(), parser.nextText());
                    } else if (parser.getName().equals(EXTENDED_DATA)) {
                        properties.putAll(setExtendedDataProperties(parser));
                    } else if (parser.getName().equals(STYLE_TAG)) {
                        inlineStyle = KmlStyleParser.createStyle(parser);
                    }
                }
                eventType = parser.next();
            } else {
                return new KmlPlacemark(geometry, styleId, inlineStyle, properties);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static KmlGroundOverlay createGroundOverlay(XmlPullParser parser) throws IOException, XmlPullParserException {
        float drawOrder = 0.0f;
        float rotation = 0.0f;
        int visibility = 1;
        String imageUrl = null;
        HashMap<String, String> properties = new HashMap<>();
        HashMap<String, Double> compassPoints = new HashMap<>();
        int eventType = parser.getEventType();
        while (true) {
            if (eventType != 3 || !parser.getName().equals("GroundOverlay")) {
                if (eventType == 2) {
                    if (parser.getName().equals("Icon")) {
                        imageUrl = getImageUrl(parser);
                    } else if (parser.getName().equals("drawOrder")) {
                        drawOrder = Float.parseFloat(parser.nextText());
                    } else if (parser.getName().equals("visibility")) {
                        visibility = Integer.parseInt(parser.nextText());
                    } else if (parser.getName().equals(EXTENDED_DATA)) {
                        properties.putAll(setExtendedDataProperties(parser));
                    } else if (parser.getName().equals("rotation")) {
                        rotation = getRotation(parser);
                    } else if (parser.getName().matches(PROPERTY_REGEX) || parser.getName().equals("color")) {
                        properties.put(parser.getName(), parser.nextText());
                    } else if (parser.getName().matches(COMPASS_REGEX)) {
                        compassPoints.put(parser.getName(), Double.valueOf(Double.parseDouble(parser.nextText())));
                    }
                }
                eventType = parser.next();
            } else {
                LatLngBounds latLonBox = createLatLngBounds(compassPoints.get("north"), compassPoints.get("south"), compassPoints.get("east"), compassPoints.get("west"));
                return new KmlGroundOverlay(imageUrl, latLonBox, drawOrder, visibility, properties, rotation);
            }
        }
    }

    private static float getRotation(XmlPullParser parser) throws IOException, XmlPullParserException {
        return -Float.parseFloat(parser.nextText());
    }

    private static String getImageUrl(XmlPullParser parser) throws IOException, XmlPullParserException {
        int eventType = parser.getEventType();
        while (true) {
            if (eventType != 3 || !parser.getName().equals("Icon")) {
                if (eventType == 2 && parser.getName().equals("href")) {
                    return parser.nextText();
                }
                eventType = parser.next();
            } else {
                return null;
            }
        }
    }

    private static Geometry createGeometry(XmlPullParser parser, String geometryType) throws IOException, XmlPullParserException {
        int eventType = parser.getEventType();
        while (true) {
            if (eventType != 3 || !parser.getName().equals(geometryType)) {
                if (eventType == 2) {
                    if (parser.getName().equals("Point")) {
                        return createPoint(parser);
                    }
                    if (parser.getName().equals("LineString")) {
                        return createLineString(parser);
                    }
                    if (parser.getName().equals("Track")) {
                        return createTrack(parser);
                    }
                    if (parser.getName().equals(KmlPolygon.GEOMETRY_TYPE)) {
                        return createPolygon(parser);
                    }
                    if (parser.getName().equals("MultiGeometry")) {
                        return createMultiGeometry(parser);
                    }
                    if (parser.getName().equals("MultiTrack")) {
                        return createMultiTrack(parser);
                    }
                }
                eventType = parser.next();
            } else {
                return null;
            }
        }
    }

    private static HashMap<String, String> setExtendedDataProperties(XmlPullParser parser) throws XmlPullParserException, IOException {
        HashMap<String, String> properties = new HashMap<>();
        String propertyKey = null;
        int eventType = parser.getEventType();
        while (true) {
            if (eventType != 3 || !parser.getName().equals(EXTENDED_DATA)) {
                if (eventType == 2) {
                    if (parser.getName().equals("Data")) {
                        propertyKey = parser.getAttributeValue(null, "name");
                    } else if (parser.getName().equals("value") && propertyKey != null) {
                        properties.put(propertyKey, parser.nextText());
                        propertyKey = null;
                    }
                }
                eventType = parser.next();
            } else {
                return properties;
            }
        }
    }

    private static KmlPoint createPoint(XmlPullParser parser) throws XmlPullParserException, IOException {
        LatLngAlt latLngAlt = null;
        int eventType = parser.getEventType();
        while (true) {
            if (eventType != 3 || !parser.getName().equals("Point")) {
                if (eventType == 2 && parser.getName().equals("coordinates")) {
                    latLngAlt = convertToLatLngAlt(parser.nextText());
                }
                eventType = parser.next();
            } else {
                return new KmlPoint(latLngAlt.latLng, latLngAlt.altitude);
            }
        }
    }

    private static KmlLineString createLineString(XmlPullParser parser) throws XmlPullParserException, IOException {
        ArrayList<LatLng> coordinates = new ArrayList<>();
        ArrayList<Double> altitudes = new ArrayList<>();
        int eventType = parser.getEventType();
        while (true) {
            if (eventType != 3 || !parser.getName().equals("LineString")) {
                if (eventType == 2 && parser.getName().equals("coordinates")) {
                    List<LatLngAlt> latLngAlts = convertToLatLngAltArray(parser.nextText());
                    for (LatLngAlt latLngAlt : latLngAlts) {
                        coordinates.add(latLngAlt.latLng);
                        if (latLngAlt.altitude != null) {
                            altitudes.add(latLngAlt.altitude);
                        }
                    }
                }
                eventType = parser.next();
            } else {
                return new KmlLineString(coordinates, altitudes);
            }
        }
    }

    private static KmlTrack createTrack(XmlPullParser parser) throws XmlPullParserException, IOException {
        DateFormat iso8601 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.getDefault());
        iso8601.setTimeZone(TimeZone.getTimeZone("UTC"));
        ArrayList<LatLng> latLngs = new ArrayList<>();
        ArrayList<Double> altitudes = new ArrayList<>();
        ArrayList<Long> timestamps = new ArrayList<>();
        HashMap<String, String> properties = new HashMap<>();
        int eventType = parser.getEventType();
        while (true) {
            if (eventType != 3 || !parser.getName().equals("Track")) {
                if (eventType == 2) {
                    if (parser.getName().equals("coord")) {
                        String coordinateString = parser.nextText();
                        LatLngAlt latLngAlt = convertToLatLngAlt(coordinateString, " ");
                        latLngs.add(latLngAlt.latLng);
                        if (latLngAlt.altitude != null) {
                            altitudes.add(latLngAlt.altitude);
                        }
                    } else if (parser.getName().equals("when")) {
                        try {
                            String dateString = parser.nextText();
                            Date date = iso8601.parse(dateString);
                            long millis = date.getTime();
                            timestamps.add(Long.valueOf(millis));
                        } catch (ParseException e) {
                            throw new XmlPullParserException("Invalid date", parser, e);
                        }
                    } else if (parser.getName().equals(EXTENDED_DATA)) {
                        properties.putAll(setExtendedDataProperties(parser));
                    }
                }
                eventType = parser.next();
            } else {
                return new KmlTrack(latLngs, altitudes, timestamps, properties);
            }
        }
    }

    private static KmlPolygon createPolygon(XmlPullParser parser) throws XmlPullParserException, IOException {
        boolean isOuterBoundary = false;
        List<LatLng> outerBoundary = new ArrayList<>();
        List<List<LatLng>> innerBoundaries = new ArrayList<>();
        int eventType = parser.getEventType();
        while (true) {
            if (eventType != 3 || !parser.getName().equals(KmlPolygon.GEOMETRY_TYPE)) {
                if (eventType == 2) {
                    if (parser.getName().matches(BOUNDARY_REGEX)) {
                        isOuterBoundary = parser.getName().equals("outerBoundaryIs");
                    } else if (parser.getName().equals("coordinates")) {
                        if (isOuterBoundary) {
                            outerBoundary = convertToLatLngArray(parser.nextText());
                        } else {
                            innerBoundaries.add(convertToLatLngArray(parser.nextText()));
                        }
                    }
                }
                eventType = parser.next();
            } else {
                return new KmlPolygon(outerBoundary, innerBoundaries);
            }
        }
    }

    private static KmlMultiGeometry createMultiGeometry(XmlPullParser parser) throws XmlPullParserException, IOException {
        ArrayList<Geometry> geometries = new ArrayList<>();
        int eventType = parser.next();
        while (true) {
            if (eventType != 3 || !parser.getName().equals("MultiGeometry")) {
                if (eventType == 2 && parser.getName().matches(GEOMETRY_REGEX)) {
                    geometries.add(createGeometry(parser, parser.getName()));
                }
                eventType = parser.next();
            } else {
                return new KmlMultiGeometry(geometries);
            }
        }
    }

    private static KmlMultiTrack createMultiTrack(XmlPullParser parser) throws XmlPullParserException, IOException {
        ArrayList<KmlTrack> tracks = new ArrayList<>();
        int eventType = parser.next();
        while (true) {
            if (eventType != 3 || !parser.getName().equals("MultiTrack")) {
                if (eventType == 2 && parser.getName().matches("Track")) {
                    tracks.add(createTrack(parser));
                }
                eventType = parser.next();
            } else {
                return new KmlMultiTrack(tracks);
            }
        }
    }

    private static ArrayList<LatLng> convertToLatLngArray(String coordinatesString) {
        ArrayList<LatLngAlt> latLngAltsArray = convertToLatLngAltArray(coordinatesString);
        ArrayList<LatLng> coordinatesArray = new ArrayList<>();
        Iterator<LatLngAlt> it = latLngAltsArray.iterator();
        while (it.hasNext()) {
            LatLngAlt latLngAlt = it.next();
            coordinatesArray.add(latLngAlt.latLng);
        }
        return coordinatesArray;
    }

    private static ArrayList<LatLngAlt> convertToLatLngAltArray(String coordinatesString) {
        ArrayList<LatLngAlt> latLngAltsArray = new ArrayList<>();
        String[] coordinates = coordinatesString.trim().split("(\\s+)");
        for (String coordinate : coordinates) {
            latLngAltsArray.add(convertToLatLngAlt(coordinate));
        }
        return latLngAltsArray;
    }

    private static LatLngAlt convertToLatLngAlt(String coordinateString) {
        return convertToLatLngAlt(coordinateString, LAT_LNG_ALT_SEPARATOR);
    }

    private static LatLngAlt convertToLatLngAlt(String coordinateString, String separator) {
        String[] coordinate = coordinateString.split(separator);
        double lat = Double.parseDouble(coordinate[1]);
        double lon = Double.parseDouble(coordinate[0]);
        Double alt = coordinate.length > 2 ? Double.valueOf(Double.parseDouble(coordinate[2])) : null;
        LatLng latLng = new LatLng(lat, lon);
        return new LatLngAlt(latLng, alt);
    }

    private static LatLngBounds createLatLngBounds(Double north, Double south, Double east, Double west) {
        LatLng southWest = new LatLng(south.doubleValue(), west.doubleValue());
        LatLng northEast = new LatLng(north.doubleValue(), east.doubleValue());
        return new LatLngBounds(southWest, northEast);
    }
}
