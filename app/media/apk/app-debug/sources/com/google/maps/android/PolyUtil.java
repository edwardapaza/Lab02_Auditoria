package com.google.maps.android;

import com.google.android.gms.maps.model.LatLng;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
/* loaded from: classes.dex */
public class PolyUtil {
    public static final double DEFAULT_TOLERANCE = 0.1d;

    private PolyUtil() {
    }

    private static double tanLatGC(double lat1, double lat2, double lng2, double lng3) {
        return ((Math.tan(lat1) * Math.sin(lng2 - lng3)) + (Math.tan(lat2) * Math.sin(lng3))) / Math.sin(lng2);
    }

    private static double mercatorLatRhumb(double lat1, double lat2, double lng2, double lng3) {
        return ((MathUtil.mercator(lat1) * (lng2 - lng3)) + (MathUtil.mercator(lat2) * lng3)) / lng2;
    }

    private static boolean intersects(double lat1, double lat2, double lng2, double lat3, double lng3, boolean geodesic) {
        if ((lng3 < 0.0d || lng3 < lng2) && ((lng3 >= 0.0d || lng3 >= lng2) && lat3 > -1.5707963267948966d && lat1 > -1.5707963267948966d && lat2 > -1.5707963267948966d && lat1 < 1.5707963267948966d && lat2 < 1.5707963267948966d && lng2 > -3.141592653589793d)) {
            double linearLat = (((lng2 - lng3) * lat1) + (lat2 * lng3)) / lng2;
            if (lat1 < 0.0d || lat2 < 0.0d || lat3 >= linearLat) {
                if ((lat1 > 0.0d || lat2 > 0.0d || lat3 < linearLat) && lat3 < 1.5707963267948966d) {
                    return geodesic ? Math.tan(lat3) >= tanLatGC(lat1, lat2, lng2, lng3) : MathUtil.mercator(lat3) >= mercatorLatRhumb(lat1, lat2, lng2, lng3);
                }
                return true;
            }
            return false;
        }
        return false;
    }

    public static boolean containsLocation(LatLng point, List<LatLng> polygon, boolean geodesic) {
        return containsLocation(point.latitude, point.longitude, polygon, geodesic);
    }

    public static boolean containsLocation(double latitude, double longitude, List<LatLng> polygon, boolean geodesic) {
        int size = polygon.size();
        if (size == 0) {
            return false;
        }
        double lat3 = Math.toRadians(latitude);
        double lng3 = Math.toRadians(longitude);
        LatLng prev = polygon.get(size - 1);
        double lat1 = Math.toRadians(prev.latitude);
        double lng1 = Math.toRadians(prev.longitude);
        double lat12 = lat1;
        double lng12 = lng1;
        int nIntersect = 0;
        for (LatLng point2 : polygon) {
            double dLng3 = MathUtil.wrap(lng3 - lng12, -3.141592653589793d, 3.141592653589793d);
            if (lat3 == lat12 && dLng3 == 0.0d) {
                return true;
            }
            double lat2 = Math.toRadians(point2.latitude);
            double lng2 = Math.toRadians(point2.longitude);
            LatLng prev2 = prev;
            if (intersects(lat12, lat2, MathUtil.wrap(lng2 - lng12, -3.141592653589793d, 3.141592653589793d), lat3, dLng3, geodesic)) {
                nIntersect++;
            }
            lat12 = lat2;
            lng12 = lng2;
            prev = prev2;
        }
        return (nIntersect & 1) != 0;
    }

    public static boolean isLocationOnEdge(LatLng point, List<LatLng> polygon, boolean geodesic, double tolerance) {
        return isLocationOnEdgeOrPath(point, polygon, true, geodesic, tolerance);
    }

    public static boolean isLocationOnEdge(LatLng point, List<LatLng> polygon, boolean geodesic) {
        return isLocationOnEdge(point, polygon, geodesic, 0.1d);
    }

    public static boolean isLocationOnPath(LatLng point, List<LatLng> polyline, boolean geodesic, double tolerance) {
        return isLocationOnEdgeOrPath(point, polyline, false, geodesic, tolerance);
    }

    public static boolean isLocationOnPath(LatLng point, List<LatLng> polyline, boolean geodesic) {
        return isLocationOnPath(point, polyline, geodesic, 0.1d);
    }

    private static boolean isLocationOnEdgeOrPath(LatLng point, List<LatLng> poly, boolean closed, boolean geodesic, double toleranceEarth) {
        int idx = locationIndexOnEdgeOrPath(point, poly, closed, geodesic, toleranceEarth);
        return idx >= 0;
    }

    public static int locationIndexOnPath(LatLng point, List<LatLng> poly, boolean geodesic, double tolerance) {
        return locationIndexOnEdgeOrPath(point, poly, false, geodesic, tolerance);
    }

    public static int locationIndexOnPath(LatLng point, List<LatLng> polyline, boolean geodesic) {
        return locationIndexOnPath(point, polyline, geodesic, 0.1d);
    }

    public static int locationIndexOnEdgeOrPath(LatLng point, List<LatLng> poly, boolean closed, boolean geodesic, double toleranceEarth) {
        int size = poly.size();
        if (size == 0) {
            return -1;
        }
        double tolerance = toleranceEarth / 6371009.0d;
        double havTolerance = MathUtil.hav(tolerance);
        double lat3 = Math.toRadians(point.latitude);
        double lng3 = Math.toRadians(point.longitude);
        LatLng prev = poly.get(closed ? size - 1 : 0);
        double lat1 = Math.toRadians(prev.latitude);
        double lng1 = Math.toRadians(prev.longitude);
        if (geodesic) {
            double lat12 = lat1;
            double lng12 = lng1;
            int idx = 0;
            for (LatLng point2 : poly) {
                double lat2 = Math.toRadians(point2.latitude);
                double lng2 = Math.toRadians(point2.longitude);
                LatLng prev2 = prev;
                if (isOnSegmentGC(lat12, lng12, lat2, lng2, lat3, lng3, havTolerance)) {
                    return Math.max(0, idx - 1);
                }
                lat12 = lat2;
                lng12 = lng2;
                idx++;
                prev = prev2;
            }
            return -1;
        }
        double minAcceptable = lat3 - tolerance;
        double maxAcceptable = lat3 + tolerance;
        double y1 = MathUtil.mercator(lat1);
        double y3 = MathUtil.mercator(lat3);
        double[] xTry = new double[3];
        double lng13 = lng1;
        int idx2 = 0;
        double y12 = y1;
        for (LatLng point22 : poly) {
            double lat22 = Math.toRadians(point22.latitude);
            double y2 = MathUtil.mercator(lat22);
            double lng22 = Math.toRadians(point22.longitude);
            if (Math.max(lat1, lat22) >= minAcceptable && Math.min(lat1, lat22) <= maxAcceptable) {
                double x2 = MathUtil.wrap(lng22 - lng13, -3.141592653589793d, 3.141592653589793d);
                double x3Base = MathUtil.wrap(lng3 - lng13, -3.141592653589793d, 3.141592653589793d);
                xTry[0] = x3Base;
                xTry[1] = x3Base + 6.283185307179586d;
                xTry[2] = x3Base - 6.283185307179586d;
                int length = xTry.length;
                int i = 0;
                while (i < length) {
                    double x3 = xTry[i];
                    double dy = y2 - y12;
                    double len2 = (x2 * x2) + (dy * dy);
                    double t = len2 > 0.0d ? MathUtil.clamp(((x3 * x2) + ((y3 - y12) * dy)) / len2, 0.0d, 1.0d) : 0.0d;
                    double xClosest = t * x2;
                    double yClosest = y12 + (t * dy);
                    double latClosest = MathUtil.inverseMercator(yClosest);
                    int i2 = length;
                    int i3 = i;
                    double lat23 = lat22;
                    LatLng point23 = point22;
                    double[] xTry2 = xTry;
                    double havDist = MathUtil.havDistance(lat3, latClosest, x3 - xClosest);
                    if (havDist >= havTolerance) {
                        i = i3 + 1;
                        length = i2;
                        lat22 = lat23;
                        xTry = xTry2;
                        point22 = point23;
                    } else {
                        return Math.max(0, idx2 - 1);
                    }
                }
                continue;
            }
            lat1 = lat22;
            lng13 = lng22;
            y12 = y2;
            idx2++;
            xTry = xTry;
        }
        return -1;
    }

    private static double sinDeltaBearing(double lat1, double lng1, double lat2, double lng2, double lat3, double lng3) {
        double sinLat1 = Math.sin(lat1);
        double cosLat2 = Math.cos(lat2);
        double cosLat3 = Math.cos(lat3);
        double lat31 = lat3 - lat1;
        double lng31 = lng3 - lng1;
        double lat21 = lat2 - lat1;
        double lng21 = lng2 - lng1;
        double a = Math.sin(lng31) * cosLat3;
        double c = Math.sin(lng21) * cosLat2;
        double b = Math.sin(lat31) + (sinLat1 * 2.0d * cosLat3 * MathUtil.hav(lng31));
        double d = Math.sin(lat21) + (2.0d * sinLat1 * cosLat2 * MathUtil.hav(lng21));
        double denom = ((a * a) + (b * b)) * ((c * c) + (d * d));
        if (denom <= 0.0d) {
            return 1.0d;
        }
        return ((a * d) - (b * c)) / Math.sqrt(denom);
    }

    private static boolean isOnSegmentGC(double lat1, double lng1, double lat2, double lng2, double lat3, double lng3, double havTolerance) {
        double havDist13 = MathUtil.havDistance(lat1, lat3, lng1 - lng3);
        if (havDist13 <= havTolerance) {
            return true;
        }
        double havDist23 = MathUtil.havDistance(lat2, lat3, lng2 - lng3);
        if (havDist23 <= havTolerance) {
            return true;
        }
        double sinBearing = sinDeltaBearing(lat1, lng1, lat2, lng2, lat3, lng3);
        double sinDist13 = MathUtil.sinFromHav(havDist13);
        double havCrossTrack = MathUtil.havFromSin(sinDist13 * sinBearing);
        if (havCrossTrack > havTolerance) {
            return false;
        }
        double havDist12 = MathUtil.havDistance(lat1, lat2, lng1 - lng2);
        double term = havDist12 + ((1.0d - (havDist12 * 2.0d)) * havCrossTrack);
        if (havDist13 <= term && havDist23 <= term) {
            if (havDist12 < 0.74d) {
                return true;
            }
            double cosCrossTrack = 1.0d - (2.0d * havCrossTrack);
            double havAlongTrack13 = (havDist13 - havCrossTrack) / cosCrossTrack;
            double havAlongTrack23 = (havDist23 - havCrossTrack) / cosCrossTrack;
            double sinSumAlongTrack = MathUtil.sinSumFromHav(havAlongTrack13, havAlongTrack23);
            return sinSumAlongTrack > 0.0d;
        }
        return false;
    }

    public static List<LatLng> simplify(List<LatLng> poly, double tolerance) {
        int n;
        int n2 = poly.size();
        if (n2 >= 1) {
            if (tolerance > 0.0d) {
                boolean closedPolygon = isClosedPolygon(poly);
                LatLng lastPoint = null;
                if (closedPolygon) {
                    LatLng lastPoint2 = poly.get(poly.size() - 1);
                    lastPoint = lastPoint2;
                    poly.remove(poly.size() - 1);
                    poly.add(new LatLng(lastPoint.latitude + 1.0E-11d, lastPoint.longitude + 1.0E-11d));
                }
                int maxIdx = 0;
                Stack<int[]> stack = new Stack<>();
                double[] dists = new double[n2];
                char c = 0;
                dists[0] = 1.0d;
                dists[n2 - 1] = 1.0d;
                if (n2 > 2) {
                    int[] stackVal = {0, n2 - 1};
                    stack.push(stackVal);
                    while (stack.size() > 0) {
                        int[] current = stack.pop();
                        double maxDist = 0.0d;
                        int idx = current[c] + 1;
                        while (idx < current[1]) {
                            double dist = distanceToLine(poly.get(idx), poly.get(current[c]), poly.get(current[1]));
                            if (dist > maxDist) {
                                maxDist = dist;
                                maxIdx = idx;
                            }
                            idx++;
                            c = 0;
                        }
                        if (maxDist <= tolerance) {
                            n = n2;
                        } else {
                            dists[maxIdx] = maxDist;
                            int[] stackValCurMax = {current[0], maxIdx};
                            stack.push(stackValCurMax);
                            n = n2;
                            int[] stackValMaxCur = {maxIdx, current[1]};
                            stack.push(stackValMaxCur);
                        }
                        n2 = n;
                        c = 0;
                    }
                }
                if (closedPolygon) {
                    poly.remove(poly.size() - 1);
                    poly.add(lastPoint);
                }
                int idx2 = 0;
                ArrayList<LatLng> simplifiedLine = new ArrayList<>();
                for (LatLng l : poly) {
                    if (dists[idx2] != 0.0d) {
                        simplifiedLine.add(l);
                    }
                    idx2++;
                }
                return simplifiedLine;
            }
            throw new IllegalArgumentException("Tolerance must be greater than zero");
        }
        throw new IllegalArgumentException("Polyline must have at least 1 point");
    }

    public static boolean isClosedPolygon(List<LatLng> poly) {
        LatLng firstPoint = poly.get(0);
        LatLng lastPoint = poly.get(poly.size() - 1);
        return firstPoint.equals(lastPoint);
    }

    public static double distanceToLine(LatLng p, LatLng start, LatLng end) {
        if (start.equals(end)) {
            return SphericalUtil.computeDistanceBetween(end, p);
        }
        double s0lat = Math.toRadians(p.latitude);
        double s0lng = Math.toRadians(p.longitude);
        double s1lat = Math.toRadians(start.latitude);
        double s1lng = Math.toRadians(start.longitude);
        double s2lat = Math.toRadians(end.latitude);
        double s2lng = Math.toRadians(end.longitude);
        double lonCorrection = Math.cos(s1lat);
        double s2s1lat = s2lat - s1lat;
        double s2s1lng = (s2lng - s1lng) * lonCorrection;
        double u = (((s0lat - s1lat) * s2s1lat) + (((s0lng - s1lng) * lonCorrection) * s2s1lng)) / ((s2s1lat * s2s1lat) + (s2s1lng * s2s1lng));
        if (u <= 0.0d) {
            return SphericalUtil.computeDistanceBetween(p, start);
        }
        if (u >= 1.0d) {
            return SphericalUtil.computeDistanceBetween(p, end);
        }
        LatLng su = new LatLng(start.latitude + ((end.latitude - start.latitude) * u), start.longitude + ((end.longitude - start.longitude) * u));
        return SphericalUtil.computeDistanceBetween(p, su);
    }

    public static List<LatLng> decode(String encodedPath) {
        int index;
        int shift;
        String str = encodedPath;
        List<LatLng> path = new ArrayList<>();
        int b = 0;
        int lat = 0;
        int lng = 0;
        for (int len = encodedPath.length(); b < len; len = len) {
            int result = 1;
            int shift2 = 0;
            while (true) {
                index = b + 1;
                int b2 = (str.charAt(b) - 63) - 1;
                result += b2 << shift2;
                shift2 += 5;
                if (b2 < 31) {
                    break;
                }
                str = encodedPath;
                b = index;
            }
            int lat2 = ((result & 1) != 0 ? ~(result >> 1) : result >> 1) + lat;
            int result2 = 1;
            int shift3 = 0;
            while (true) {
                shift = index + 1;
                int b3 = (str.charAt(index) - 63) - 1;
                result2 += b3 << shift3;
                shift3 += 5;
                if (b3 < 31) {
                    break;
                }
                str = encodedPath;
                index = shift;
            }
            lng += (result2 & 1) != 0 ? ~(result2 >> 1) : result2 >> 1;
            path.add(new LatLng(lat2 * 1.0E-5d, lng * 1.0E-5d));
            str = encodedPath;
            b = shift;
            lat = lat2;
        }
        return path;
    }

    public static String encode(List<LatLng> path) {
        long lastLat = 0;
        long lastLng = 0;
        StringBuffer result = new StringBuffer();
        for (LatLng point : path) {
            long lat = Math.round(point.latitude * 100000.0d);
            long lng = Math.round(point.longitude * 100000.0d);
            long dLat = lat - lastLat;
            long dLng = lng - lastLng;
            encode(dLat, result);
            encode(dLng, result);
            lastLat = lat;
            lastLng = lng;
        }
        return result.toString();
    }

    private static void encode(long v, StringBuffer result) {
        long j = v << 1;
        if (v < 0) {
            j = ~j;
        }
        long v2 = j;
        while (v2 >= 32) {
            result.append(Character.toChars((int) ((32 | (31 & v2)) + 63)));
            v2 >>= 5;
        }
        result.append(Character.toChars((int) (63 + v2)));
    }
}
