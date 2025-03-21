package com.google.maps.android.data.kml;

import com.google.maps.android.data.Geometry;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class KmlMultiTrack extends KmlMultiGeometry {
    public KmlMultiTrack(ArrayList<KmlTrack> tracks) {
        super(createGeometries(tracks));
    }

    private static ArrayList<Geometry> createGeometries(ArrayList<KmlTrack> tracks) {
        ArrayList<Geometry> geometries = new ArrayList<>();
        if (tracks == null) {
            throw new IllegalArgumentException("Tracks cannot be null");
        }
        Iterator<KmlTrack> it = tracks.iterator();
        while (it.hasNext()) {
            KmlTrack track = it.next();
            geometries.add(track);
        }
        return geometries;
    }
}
