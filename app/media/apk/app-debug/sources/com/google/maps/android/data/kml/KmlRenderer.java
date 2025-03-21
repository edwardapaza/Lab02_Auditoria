package com.google.maps.android.data.kml;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.GroundOverlay;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.gms.maps.model.Marker;
import com.google.maps.android.collections.GroundOverlayManager;
import com.google.maps.android.collections.MarkerManager;
import com.google.maps.android.collections.PolygonManager;
import com.google.maps.android.collections.PolylineManager;
import com.google.maps.android.data.Feature;
import com.google.maps.android.data.Geometry;
import com.google.maps.android.data.MultiGeometry;
import com.google.maps.android.data.Renderer;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
/* loaded from: classes.dex */
public class KmlRenderer extends Renderer {
    private static final String LOG_TAG = "KmlRenderer";
    private ArrayList<KmlContainer> mContainers;
    private boolean mGroundOverlayImagesDownloaded;
    private final Set<String> mGroundOverlayUrls;
    private boolean mMarkerIconsDownloaded;

    /* JADX INFO: Access modifiers changed from: package-private */
    public KmlRenderer(GoogleMap map, Context context, MarkerManager markerManager, PolygonManager polygonManager, PolylineManager polylineManager, GroundOverlayManager groundOverlayManager, Renderer.ImagesCache imagesCache) {
        super(map, context, markerManager, polygonManager, polylineManager, groundOverlayManager, imagesCache);
        this.mGroundOverlayUrls = new HashSet();
        this.mMarkerIconsDownloaded = false;
        this.mGroundOverlayImagesDownloaded = false;
    }

    private void removePlacemarks(HashMap<? extends Feature, Object> placemarks) {
        removeFeatures(placemarks);
    }

    static boolean getContainerVisibility(KmlContainer kmlContainer, boolean isParentContainerVisible) {
        boolean isChildContainerVisible = true;
        if (kmlContainer.hasProperty("visibility")) {
            String placemarkVisibility = kmlContainer.getProperty("visibility");
            if (Integer.parseInt(placemarkVisibility) == 0) {
                isChildContainerVisible = false;
            }
        }
        return isParentContainerVisible && isChildContainerVisible;
    }

    private void removeContainers(Iterable<KmlContainer> containers) {
        for (KmlContainer container : containers) {
            removePlacemarks(container.getPlacemarksHashMap());
            removeGroundOverlays(container.getGroundOverlayHashMap());
            removeContainers(container.getContainers());
        }
    }

    public void addLayerToMap() {
        setLayerVisibility(true);
        this.mContainers = getContainerList();
        putStyles();
        assignStyleMap(getStyleMaps(), getStylesRenderer());
        addGroundOverlays(getGroundOverlayMap(), this.mContainers);
        addContainerGroupToMap(this.mContainers, true);
        addPlacemarksToMap(getAllFeatures());
        if (!this.mGroundOverlayImagesDownloaded) {
            downloadGroundOverlays();
        }
        if (!this.mMarkerIconsDownloaded) {
            downloadMarkerIcons();
        }
        checkClearBitmapCache();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void storeKmlData(HashMap<String, KmlStyle> styles, HashMap<String, String> styleMaps, HashMap<KmlPlacemark, Object> features, ArrayList<KmlContainer> folders, HashMap<KmlGroundOverlay, GroundOverlay> groundOverlays) {
        storeData(styles, styleMaps, features, folders, groundOverlays);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void storeKmzData(HashMap<String, KmlStyle> styles, HashMap<String, String> styleMaps, HashMap<KmlPlacemark, Object> features, ArrayList<KmlContainer> folders, HashMap<KmlGroundOverlay, GroundOverlay> groundOverlays, HashMap<String, Bitmap> images) {
        storeData(styles, styleMaps, features, folders, groundOverlays);
        for (Map.Entry<String, Bitmap> entry : images.entrySet()) {
            cacheBitmap(entry.getKey(), entry.getValue());
        }
    }

    @Override // com.google.maps.android.data.Renderer
    public void setMap(GoogleMap map) {
        removeLayerFromMap();
        super.setMap(map);
        addLayerToMap();
    }

    boolean hasKmlPlacemarks() {
        return hasFeatures();
    }

    Iterable<? extends Feature> getKmlPlacemarks() {
        return getFeatures();
    }

    public boolean hasNestedContainers() {
        return this.mContainers.size() > 0;
    }

    public Iterable<KmlContainer> getNestedContainers() {
        return this.mContainers;
    }

    public Iterable<KmlGroundOverlay> getGroundOverlays() {
        return getGroundOverlayMap().keySet();
    }

    public void removeLayerFromMap() {
        removePlacemarks(getAllFeatures());
        removeGroundOverlays(getGroundOverlayMap());
        if (hasNestedContainers()) {
            removeContainers(getNestedContainers());
        }
        setLayerVisibility(false);
        clearStylesRenderer();
    }

    private void addPlacemarksToMap(HashMap<? extends Feature, Object> placemarks) {
        for (Feature kmlPlacemark : placemarks.keySet()) {
            addFeature(kmlPlacemark);
        }
    }

    private void addContainerGroupToMap(Iterable<KmlContainer> kmlContainers, boolean containerVisibility) {
        for (KmlContainer container : kmlContainers) {
            boolean isContainerVisible = getContainerVisibility(container, containerVisibility);
            if (container.getStyles() != null) {
                putStyles(container.getStyles());
            }
            if (container.getStyleMap() != null) {
                super.assignStyleMap(container.getStyleMap(), getStylesRenderer());
            }
            addContainerObjectToMap(container, isContainerVisible);
            if (container.hasContainers()) {
                addContainerGroupToMap(container.getContainers(), isContainerVisible);
            }
        }
    }

    private void addContainerObjectToMap(KmlContainer kmlContainer, boolean isContainerVisible) {
        for (Feature placemark : kmlContainer.getPlacemarks()) {
            boolean isPlacemarkVisible = getPlacemarkVisibility(placemark);
            boolean isObjectVisible = isContainerVisible && isPlacemarkVisible;
            if (placemark.getGeometry() != null) {
                String placemarkId = placemark.getId();
                Geometry geometry = placemark.getGeometry();
                KmlStyle style = getPlacemarkStyle(placemarkId);
                KmlStyle inlineStyle = ((KmlPlacemark) placemark).getInlineStyle();
                Object mapObject = addKmlPlacemarkToMap((KmlPlacemark) placemark, geometry, style, inlineStyle, isObjectVisible);
                kmlContainer.setPlacemark((KmlPlacemark) placemark, mapObject);
                putContainerFeature(mapObject, placemark);
            }
        }
    }

    private void downloadMarkerIcons() {
        this.mMarkerIconsDownloaded = true;
        Iterator<String> iterator = getMarkerIconUrls().iterator();
        while (iterator.hasNext()) {
            String markerIconUrl = iterator.next();
            new MarkerIconImageDownload(markerIconUrl).execute(new String[0]);
            iterator.remove();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addIconToMarkers(String iconUrl, HashMap<KmlPlacemark, Object> placemarks) {
        for (Feature placemark : placemarks.keySet()) {
            KmlStyle urlStyle = getStylesRenderer().get(placemark.getId());
            KmlStyle inlineStyle = ((KmlPlacemark) placemark).getInlineStyle();
            Geometry geometry = placemark.getGeometry();
            Object object = placemarks.get(placemark);
            addIconToGeometry(iconUrl, urlStyle, inlineStyle, geometry, object);
        }
    }

    private void addIconToGeometry(String iconUrl, KmlStyle urlStyle, KmlStyle inlineStyle, Geometry geometry, Object object) {
        if (geometry == null) {
            return;
        }
        if ("Point".equals(geometry.getGeometryType())) {
            addIconToMarker(iconUrl, urlStyle, inlineStyle, (Marker) object);
        } else if ("MultiGeometry".equals(geometry.getGeometryType())) {
            addIconToMultiGeometry(iconUrl, urlStyle, inlineStyle, (MultiGeometry) geometry, (List) object);
        }
    }

    private void addIconToMultiGeometry(String iconUrl, KmlStyle urlStyle, KmlStyle inlineStyle, MultiGeometry multiGeometry, List<Object> objects) {
        Iterator<Geometry> geometries = multiGeometry.getGeometryObject().iterator();
        Iterator<Object> objItr = objects.iterator();
        while (geometries.hasNext() && objItr.hasNext()) {
            Geometry geometry = geometries.next();
            Object object = objItr.next();
            addIconToGeometry(iconUrl, urlStyle, inlineStyle, geometry, object);
        }
    }

    private void addIconToMarker(String iconUrl, KmlStyle urlStyle, KmlStyle inlineStyle, Marker marker) {
        boolean isPlacemarkStyleIcon = true;
        boolean isInlineStyleIcon = inlineStyle != null && iconUrl.equals(inlineStyle.getIconUrl());
        isPlacemarkStyleIcon = (urlStyle == null || !iconUrl.equals(urlStyle.getIconUrl())) ? false : false;
        if (isInlineStyleIcon) {
            scaleBitmap(inlineStyle, marker);
        } else if (isPlacemarkStyleIcon) {
            scaleBitmap(urlStyle, marker);
        }
    }

    private void scaleBitmap(KmlStyle style, Marker marker) {
        double bitmapScale = style.getIconScale();
        String bitmapUrl = style.getIconUrl();
        BitmapDescriptor scaledBitmap = getCachedMarkerImage(bitmapUrl, bitmapScale);
        marker.setIcon(scaledBitmap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addContainerGroupIconsToMarkers(String iconUrl, Iterable<KmlContainer> kmlContainers) {
        for (KmlContainer container : kmlContainers) {
            addIconToMarkers(iconUrl, container.getPlacemarksHashMap());
            if (container.hasContainers()) {
                addContainerGroupIconsToMarkers(iconUrl, container.getContainers());
            }
        }
    }

    private void addGroundOverlays(HashMap<KmlGroundOverlay, GroundOverlay> groundOverlays, Iterable<KmlContainer> kmlContainers) {
        addGroundOverlays(groundOverlays);
        for (KmlContainer container : kmlContainers) {
            addGroundOverlays(container.getGroundOverlayHashMap(), container.getContainers());
        }
    }

    private void addGroundOverlays(HashMap<KmlGroundOverlay, GroundOverlay> groundOverlays) {
        for (KmlGroundOverlay groundOverlay : groundOverlays.keySet()) {
            String groundOverlayUrl = groundOverlay.getImageUrl();
            if (groundOverlayUrl != null && groundOverlay.getLatLngBox() != null) {
                if (getCachedGroundOverlayImage(groundOverlayUrl) != null) {
                    addGroundOverlayToMap(groundOverlayUrl, groundOverlays, true);
                } else {
                    this.mGroundOverlayUrls.add(groundOverlayUrl);
                }
            }
        }
    }

    private void downloadGroundOverlays() {
        this.mGroundOverlayImagesDownloaded = true;
        Iterator<String> iterator = this.mGroundOverlayUrls.iterator();
        while (iterator.hasNext()) {
            String groundOverlayUrl = iterator.next();
            new GroundOverlayImageDownload(groundOverlayUrl).execute(new String[0]);
            iterator.remove();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addGroundOverlayToMap(String groundOverlayUrl, HashMap<KmlGroundOverlay, GroundOverlay> groundOverlays, boolean containerVisibility) {
        BitmapDescriptor groundOverlayBitmap = getCachedGroundOverlayImage(groundOverlayUrl);
        for (KmlGroundOverlay kmlGroundOverlay : groundOverlays.keySet()) {
            if (kmlGroundOverlay.getImageUrl().equals(groundOverlayUrl)) {
                GroundOverlayOptions groundOverlayOptions = kmlGroundOverlay.getGroundOverlayOptions().image(groundOverlayBitmap);
                GroundOverlay mapGroundOverlay = attachGroundOverlay(groundOverlayOptions);
                if (!containerVisibility) {
                    mapGroundOverlay.setVisible(false);
                }
                groundOverlays.put(kmlGroundOverlay, mapGroundOverlay);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addGroundOverlayInContainerGroups(String groundOverlayUrl, Iterable<KmlContainer> kmlContainers, boolean containerVisibility) {
        for (KmlContainer container : kmlContainers) {
            boolean isContainerVisible = getContainerVisibility(container, containerVisibility);
            addGroundOverlayToMap(groundOverlayUrl, container.getGroundOverlayHashMap(), isContainerVisible);
            if (container.hasContainers()) {
                addGroundOverlayInContainerGroups(groundOverlayUrl, container.getContainers(), isContainerVisible);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class MarkerIconImageDownload extends AsyncTask<String, Void, Bitmap> {
        private final String mIconUrl;

        public MarkerIconImageDownload(String iconUrl) {
            this.mIconUrl = iconUrl;
            KmlRenderer.this.downloadStarted();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public Bitmap doInBackground(String... params) {
            try {
                return KmlRenderer.this.getBitmapFromUrl(this.mIconUrl);
            } catch (MalformedURLException e) {
                return BitmapFactory.decodeFile(this.mIconUrl);
            } catch (IOException e2) {
                e2.printStackTrace();
                return null;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(Bitmap bitmap) {
            if (bitmap != null) {
                KmlRenderer.this.cacheBitmap(this.mIconUrl, bitmap);
                if (KmlRenderer.this.isLayerOnMap()) {
                    KmlRenderer kmlRenderer = KmlRenderer.this;
                    kmlRenderer.addIconToMarkers(this.mIconUrl, kmlRenderer.getAllFeatures());
                    KmlRenderer kmlRenderer2 = KmlRenderer.this;
                    kmlRenderer2.addContainerGroupIconsToMarkers(this.mIconUrl, kmlRenderer2.mContainers);
                }
            } else {
                Log.e(KmlRenderer.LOG_TAG, "Image at this URL could not be found " + this.mIconUrl);
            }
            KmlRenderer.this.downloadFinished();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class GroundOverlayImageDownload extends AsyncTask<String, Void, Bitmap> {
        private final String mGroundOverlayUrl;

        public GroundOverlayImageDownload(String groundOverlayUrl) {
            this.mGroundOverlayUrl = groundOverlayUrl;
            KmlRenderer.this.downloadStarted();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public Bitmap doInBackground(String... params) {
            try {
                return KmlRenderer.this.getBitmapFromUrl(this.mGroundOverlayUrl);
            } catch (MalformedURLException e) {
                return BitmapFactory.decodeFile(this.mGroundOverlayUrl);
            } catch (IOException e2) {
                Log.e(KmlRenderer.LOG_TAG, "Image [" + this.mGroundOverlayUrl + "] download issue", e2);
                return null;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(Bitmap bitmap) {
            if (bitmap != null) {
                KmlRenderer.this.cacheBitmap(this.mGroundOverlayUrl, bitmap);
                if (KmlRenderer.this.isLayerOnMap()) {
                    KmlRenderer kmlRenderer = KmlRenderer.this;
                    kmlRenderer.addGroundOverlayToMap(this.mGroundOverlayUrl, kmlRenderer.getGroundOverlayMap(), true);
                    KmlRenderer kmlRenderer2 = KmlRenderer.this;
                    kmlRenderer2.addGroundOverlayInContainerGroups(this.mGroundOverlayUrl, kmlRenderer2.mContainers, true);
                }
            } else {
                Log.e(KmlRenderer.LOG_TAG, "Image at this URL could not be found " + this.mGroundOverlayUrl);
            }
            KmlRenderer.this.downloadFinished();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bitmap getBitmapFromUrl(String url) throws IOException {
        return BitmapFactory.decodeStream(openConnectionCheckRedirects(new URL(url).openConnection()));
    }

    private InputStream openConnectionCheckRedirects(URLConnection c) throws IOException {
        InputStream in;
        boolean redir;
        HttpURLConnection http;
        int stat;
        int redirects = 0;
        do {
            if (c instanceof HttpURLConnection) {
                ((HttpURLConnection) c).setInstanceFollowRedirects(false);
            }
            in = c.getInputStream();
            redir = false;
            if ((c instanceof HttpURLConnection) && (stat = (http = (HttpURLConnection) c).getResponseCode()) >= 300 && stat <= 307 && stat != 306 && stat != 304) {
                URL base = http.getURL();
                String loc = http.getHeaderField("Location");
                URL target = null;
                if (loc != null) {
                    target = new URL(base, loc);
                }
                http.disconnect();
                if (target == null || ((!target.getProtocol().equals("http") && !target.getProtocol().equals("https")) || redirects >= 5)) {
                    throw new SecurityException("illegal URL redirect");
                }
                redir = true;
                c = target.openConnection();
                redirects++;
                continue;
            }
        } while (redir);
        return in;
    }
}
