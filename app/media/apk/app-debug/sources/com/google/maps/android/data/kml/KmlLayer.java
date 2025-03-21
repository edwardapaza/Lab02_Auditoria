package com.google.maps.android.data.kml;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import com.google.android.gms.maps.GoogleMap;
import com.google.maps.android.collections.GroundOverlayManager;
import com.google.maps.android.collections.MarkerManager;
import com.google.maps.android.collections.PolygonManager;
import com.google.maps.android.collections.PolylineManager;
import com.google.maps.android.data.Layer;
import com.google.maps.android.data.Renderer;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;
/* loaded from: classes.dex */
public class KmlLayer extends Layer {
    public KmlLayer(GoogleMap map, int resourceId, Context context) throws XmlPullParserException, IOException {
        this(map, context.getResources().openRawResource(resourceId), context, new MarkerManager(map), new PolygonManager(map), new PolylineManager(map), new GroundOverlayManager(map), (Renderer.ImagesCache) null);
    }

    public KmlLayer(GoogleMap map, InputStream stream, Context context) throws XmlPullParserException, IOException {
        this(map, stream, context, new MarkerManager(map), new PolygonManager(map), new PolylineManager(map), new GroundOverlayManager(map), (Renderer.ImagesCache) null);
    }

    public KmlLayer(GoogleMap map, int resourceId, Context context, MarkerManager markerManager, PolygonManager polygonManager, PolylineManager polylineManager, GroundOverlayManager groundOverlayManager, Renderer.ImagesCache cache) throws XmlPullParserException, IOException {
        this(map, context.getResources().openRawResource(resourceId), context, markerManager, polygonManager, polylineManager, groundOverlayManager, cache);
    }

    public KmlLayer(GoogleMap map, InputStream stream, Context context, MarkerManager markerManager, PolygonManager polygonManager, PolylineManager polylineManager, GroundOverlayManager groundOverlayManager, Renderer.ImagesCache cache) throws XmlPullParserException, IOException {
        if (stream == null) {
            throw new IllegalArgumentException("KML InputStream cannot be null");
        }
        KmlRenderer renderer = new KmlRenderer(map, context, markerManager, polygonManager, polylineManager, groundOverlayManager, cache);
        BufferedInputStream bis = new BufferedInputStream(stream);
        bis.mark(1024);
        ZipInputStream zip = new ZipInputStream(bis);
        KmlParser parser = null;
        try {
            ZipEntry entry = zip.getNextEntry();
            if (entry != null) {
                HashMap<String, Bitmap> images = new HashMap<>();
                for (ZipEntry entry2 = entry; entry2 != null; entry2 = zip.getNextEntry()) {
                    if (parser == null && entry2.getName().toLowerCase().endsWith(".kml")) {
                        parser = parseKml(zip);
                    } else {
                        Bitmap bitmap = BitmapFactory.decodeStream(zip);
                        if (bitmap != null) {
                            images.put(entry2.getName(), bitmap);
                        } else {
                            Log.w("KmlLayer", "Unsupported KMZ contents file type: " + entry2.getName());
                        }
                    }
                }
                if (parser == null) {
                    throw new IllegalArgumentException("KML not found in InputStream");
                }
                renderer.storeKmzData(parser.getStyles(), parser.getStyleMaps(), parser.getPlacemarks(), parser.getContainers(), parser.getGroundOverlays(), images);
            } else {
                bis.reset();
                KmlParser parser2 = parseKml(bis);
                renderer.storeKmlData(parser2.getStyles(), parser2.getStyleMaps(), parser2.getPlacemarks(), parser2.getContainers(), parser2.getGroundOverlays());
            }
            try {
                storeRenderer(renderer);
                stream.close();
                bis.close();
                zip.close();
            } catch (Throwable th) {
                th = th;
                stream.close();
                bis.close();
                zip.close();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private static KmlParser parseKml(InputStream stream) throws XmlPullParserException, IOException {
        XmlPullParser xmlPullParser = createXmlParser(stream);
        KmlParser parser = new KmlParser(xmlPullParser);
        parser.parseKml();
        return parser;
    }

    private static XmlPullParser createXmlParser(InputStream stream) throws XmlPullParserException {
        XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
        factory.setNamespaceAware(true);
        XmlPullParser parser = factory.newPullParser();
        parser.setInput(stream, null);
        return parser;
    }

    @Override // com.google.maps.android.data.Layer
    public void addLayerToMap() {
        super.addKMLToMap();
    }

    public boolean hasPlacemarks() {
        return hasFeatures();
    }

    public Iterable<KmlPlacemark> getPlacemarks() {
        return getFeatures();
    }

    @Override // com.google.maps.android.data.Layer
    public boolean hasContainers() {
        return super.hasContainers();
    }

    @Override // com.google.maps.android.data.Layer
    public Iterable<KmlContainer> getContainers() {
        return super.getContainers();
    }

    @Override // com.google.maps.android.data.Layer
    public Iterable<KmlGroundOverlay> getGroundOverlays() {
        return super.getGroundOverlays();
    }
}
