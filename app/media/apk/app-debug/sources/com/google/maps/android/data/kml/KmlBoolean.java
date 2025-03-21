package com.google.maps.android.data.kml;
/* loaded from: classes.dex */
public class KmlBoolean {
    public static boolean parseBoolean(String text) {
        return "1".equals(text) || "true".equals(text);
    }
}
