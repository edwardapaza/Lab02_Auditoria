package io.flutter.plugins.googlemaps;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.os.Bundle;
import android.os.Process;
import android.util.Log;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.MotionEventCompat;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMapOptions;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.Polygon;
import com.google.android.gms.maps.model.Polyline;
import com.google.maps.android.clustering.ClusterManager;
import com.google.maps.android.collections.MarkerManager;
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.platform.PlatformView;
import io.flutter.plugins.googlemaps.ClusterManagersController;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.text.Typography;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class GoogleMapController implements DefaultLifecycleObserver, ActivityPluginBinding.OnSaveInstanceStateListener, GoogleMapOptionsSink, MethodChannel.MethodCallHandler, OnMapReadyCallback, GoogleMapListener, ClusterManager.OnClusterItemClickListener<MarkerBuilder>, ClusterManagersController.OnClusterItemRendered<MarkerBuilder>, PlatformView {
    private static final String TAG = "GoogleMapController";
    private final CirclesController circlesController;
    private final ClusterManagersController clusterManagersController;
    private final Context context;
    final float density;
    private GoogleMap googleMap;
    private final int id;
    private List<Object> initialCircles;
    private List<Object> initialClusterManagers;
    private String initialMapStyle;
    private List<Object> initialMarkers;
    List<Float> initialPadding;
    private List<Object> initialPolygons;
    private List<Object> initialPolylines;
    private List<Map<String, ?>> initialTileOverlays;
    private String lastStyleError;
    private final LifecycleProvider lifecycleProvider;
    private MethodChannel.Result mapReadyResult;
    private MapView mapView;
    private MarkerManager.Collection markerCollection;
    private MarkerManager markerManager;
    private final MarkersController markersController;
    private final MethodChannel methodChannel;
    private final GoogleMapOptions options;
    private final PolygonsController polygonsController;
    private final PolylinesController polylinesController;
    private final TileOverlaysController tileOverlaysController;
    private boolean trackCameraPosition = false;
    private boolean myLocationEnabled = false;
    private boolean myLocationButtonEnabled = false;
    private boolean zoomControlsEnabled = true;
    private boolean indoorEnabled = true;
    private boolean trafficEnabled = false;
    private boolean buildingsEnabled = true;
    private boolean disposed = false;

    @Override // io.flutter.plugin.platform.PlatformView
    public /* synthetic */ void onFlutterViewAttached(View view) {
        PlatformView.CC.$default$onFlutterViewAttached(this, view);
    }

    @Override // io.flutter.plugin.platform.PlatformView
    public /* synthetic */ void onFlutterViewDetached() {
        PlatformView.CC.$default$onFlutterViewDetached(this);
    }

    @Override // io.flutter.plugin.platform.PlatformView
    public /* synthetic */ void onInputConnectionLocked() {
        PlatformView.CC.$default$onInputConnectionLocked(this);
    }

    @Override // io.flutter.plugin.platform.PlatformView
    public /* synthetic */ void onInputConnectionUnlocked() {
        PlatformView.CC.$default$onInputConnectionUnlocked(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public GoogleMapController(int id, Context context, BinaryMessenger binaryMessenger, LifecycleProvider lifecycleProvider, GoogleMapOptions options) {
        this.id = id;
        this.context = context;
        this.options = options;
        this.mapView = new MapView(context, options);
        float f = context.getResources().getDisplayMetrics().density;
        this.density = f;
        MethodChannel methodChannel = new MethodChannel(binaryMessenger, "plugins.flutter.dev/google_maps_android_" + id);
        this.methodChannel = methodChannel;
        methodChannel.setMethodCallHandler(this);
        this.lifecycleProvider = lifecycleProvider;
        ClusterManagersController clusterManagersController = new ClusterManagersController(methodChannel, context);
        this.clusterManagersController = clusterManagersController;
        this.markersController = new MarkersController(methodChannel, clusterManagersController);
        this.polygonsController = new PolygonsController(methodChannel, f);
        this.polylinesController = new PolylinesController(methodChannel, f);
        this.circlesController = new CirclesController(methodChannel, f);
        this.tileOverlaysController = new TileOverlaysController(methodChannel);
    }

    GoogleMapController(int id, Context context, MethodChannel methodChannel, LifecycleProvider lifecycleProvider, GoogleMapOptions options, ClusterManagersController clusterManagersController, MarkersController markersController, PolygonsController polygonsController, PolylinesController polylinesController, CirclesController circlesController, TileOverlaysController tileOverlaysController) {
        this.id = id;
        this.context = context;
        this.methodChannel = methodChannel;
        this.options = options;
        this.mapView = new MapView(context, options);
        this.density = context.getResources().getDisplayMetrics().density;
        this.lifecycleProvider = lifecycleProvider;
        this.clusterManagersController = clusterManagersController;
        this.markersController = markersController;
        this.polygonsController = polygonsController;
        this.polylinesController = polylinesController;
        this.circlesController = circlesController;
        this.tileOverlaysController = tileOverlaysController;
    }

    @Override // io.flutter.plugin.platform.PlatformView
    public View getView() {
        return this.mapView;
    }

    void setView(MapView view) {
        this.mapView = view;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void init() {
        this.lifecycleProvider.getLifecycle().addObserver(this);
        this.mapView.getMapAsync(this);
    }

    private void moveCamera(CameraUpdate cameraUpdate) {
        this.googleMap.moveCamera(cameraUpdate);
    }

    private void animateCamera(CameraUpdate cameraUpdate) {
        this.googleMap.animateCamera(cameraUpdate);
    }

    private CameraPosition getCameraPosition() {
        if (this.trackCameraPosition) {
            return this.googleMap.getCameraPosition();
        }
        return null;
    }

    @Override // com.google.android.gms.maps.OnMapReadyCallback
    public void onMapReady(GoogleMap googleMap) {
        this.googleMap = googleMap;
        googleMap.setIndoorEnabled(this.indoorEnabled);
        this.googleMap.setTrafficEnabled(this.trafficEnabled);
        this.googleMap.setBuildingsEnabled(this.buildingsEnabled);
        installInvalidator();
        MethodChannel.Result result = this.mapReadyResult;
        if (result != null) {
            result.success(null);
            this.mapReadyResult = null;
        }
        setGoogleMapListener(this);
        MarkerManager markerManager = new MarkerManager(googleMap);
        this.markerManager = markerManager;
        this.markerCollection = markerManager.newCollection();
        updateMyLocationSettings();
        this.markersController.setCollection(this.markerCollection);
        this.clusterManagersController.init(googleMap, this.markerManager);
        this.polygonsController.setGoogleMap(googleMap);
        this.polylinesController.setGoogleMap(googleMap);
        this.circlesController.setGoogleMap(googleMap);
        this.tileOverlaysController.setGoogleMap(googleMap);
        setMarkerCollectionListener(this);
        setClusterItemClickListener(this);
        setClusterItemRenderedListener(this);
        updateInitialClusterManagers();
        updateInitialMarkers();
        updateInitialPolygons();
        updateInitialPolylines();
        updateInitialCircles();
        updateInitialTileOverlays();
        List<Float> list = this.initialPadding;
        if (list != null && list.size() == 4) {
            setPadding(this.initialPadding.get(0).floatValue(), this.initialPadding.get(1).floatValue(), this.initialPadding.get(2).floatValue(), this.initialPadding.get(3).floatValue());
        }
        String str = this.initialMapStyle;
        if (str != null) {
            updateMapStyle(str);
            this.initialMapStyle = null;
        }
    }

    private static TextureView findTextureView(ViewGroup group) {
        TextureView r;
        int n = group.getChildCount();
        for (int i = 0; i < n; i++) {
            View view = group.getChildAt(i);
            if (view instanceof TextureView) {
                return (TextureView) view;
            }
            if ((view instanceof ViewGroup) && (r = findTextureView((ViewGroup) view)) != null) {
                return r;
            }
        }
        return null;
    }

    private void installInvalidator() {
        MapView mapView = this.mapView;
        if (mapView == null) {
            return;
        }
        TextureView textureView = findTextureView(mapView);
        if (textureView == null) {
            Log.i(TAG, "No TextureView found. Likely using the LEGACY renderer.");
            return;
        }
        Log.i(TAG, "Installing custom TextureView driven invalidator.");
        final TextureView.SurfaceTextureListener internalListener = textureView.getSurfaceTextureListener();
        final MapView mapView2 = this.mapView;
        textureView.setSurfaceTextureListener(new TextureView.SurfaceTextureListener() { // from class: io.flutter.plugins.googlemaps.GoogleMapController.1
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture surface, int width, int height) {
                TextureView.SurfaceTextureListener surfaceTextureListener = internalListener;
                if (surfaceTextureListener != null) {
                    surfaceTextureListener.onSurfaceTextureAvailable(surface, width, height);
                }
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surface) {
                TextureView.SurfaceTextureListener surfaceTextureListener = internalListener;
                if (surfaceTextureListener != null) {
                    return surfaceTextureListener.onSurfaceTextureDestroyed(surface);
                }
                return true;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture surface, int width, int height) {
                TextureView.SurfaceTextureListener surfaceTextureListener = internalListener;
                if (surfaceTextureListener != null) {
                    surfaceTextureListener.onSurfaceTextureSizeChanged(surface, width, height);
                }
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture surface) {
                TextureView.SurfaceTextureListener surfaceTextureListener = internalListener;
                if (surfaceTextureListener != null) {
                    surfaceTextureListener.onSurfaceTextureUpdated(surface);
                }
                mapView2.invalidate();
            }
        });
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // io.flutter.plugin.common.MethodChannel.MethodCallHandler
    public void onMethodCall(MethodCall call, final MethodChannel.Result result) {
        char c;
        String str = call.method;
        switch (str.hashCode()) {
            case -2068530537:
                if (str.equals("map#getVisibleRegion")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case -1753225255:
                if (str.equals("map#isScrollGesturesEnabled")) {
                    c = 23;
                    break;
                }
                c = 65535;
                break;
            case -1675017333:
                if (str.equals("map#isRotateGesturesEnabled")) {
                    c = 25;
                    break;
                }
                c = 65535;
                break;
            case -1389285936:
                if (str.equals("map#update")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case -1366519597:
                if (str.equals("map#getScreenCoordinate")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case -1264573565:
                if (str.equals("camera#animate")) {
                    c = 7;
                    break;
                }
                c = 65535;
                break;
            case -1255039905:
                if (str.equals("markers#isInfoWindowShown")) {
                    c = 11;
                    break;
                }
                c = 65535;
                break;
            case -1253612063:
                if (str.equals("map#getTileOverlayInfo")) {
                    c = Typography.quote;
                    break;
                }
                c = 65535;
                break;
            case -1102318061:
                if (str.equals("polygons#update")) {
                    c = 14;
                    break;
                }
                c = 65535;
                break;
            case -689870081:
                if (str.equals("clusterManager#getClusters")) {
                    c = '\r';
                    break;
                }
                c = 65535;
                break;
            case -596474455:
                if (str.equals("map#isTiltGesturesEnabled")) {
                    c = 24;
                    break;
                }
                c = 65535;
                break;
            case -577075523:
                if (str.equals("map#isMyLocationButtonEnabled")) {
                    c = 26;
                    break;
                }
                c = 65535;
                break;
            case -508357782:
                if (str.equals("markers#hideInfoWindow")) {
                    c = '\n';
                    break;
                }
                c = 65535;
                break;
            case -451921790:
                if (str.equals("map#getZoomLevel")) {
                    c = 29;
                    break;
                }
                c = 65535;
                break;
            case -191840212:
                if (str.equals("clusterManagers#update")) {
                    c = '\f';
                    break;
                }
                c = 65535;
                break;
            case -149616666:
                if (str.equals("map#getStyleError")) {
                    c = 31;
                    break;
                }
                c = 65535;
                break;
            case 262112323:
                if (str.equals("map#getMinMaxZoomLevels")) {
                    c = 19;
                    break;
                }
                c = 65535;
                break;
            case 282895827:
                if (str.equals("map#isZoomGesturesEnabled")) {
                    c = 20;
                    break;
                }
                c = 65535;
                break;
            case 295004975:
                if (str.equals("map#waitForMap")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case 390939153:
                if (str.equals("map#isMapToolbarEnabled")) {
                    c = 18;
                    break;
                }
                c = 65535;
                break;
            case 434031410:
                if (str.equals("map#takeSnapshot")) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            case 622947733:
                if (str.equals("map#getLatLng")) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case 643972249:
                if (str.equals("polylines#update")) {
                    c = 15;
                    break;
                }
                c = 65535;
                break;
            case 712945078:
                if (str.equals("map#setStyle")) {
                    c = 30;
                    break;
                }
                c = 65535;
                break;
            case 972868051:
                if (str.equals("map#isBuildingsEnabled")) {
                    c = 28;
                    break;
                }
                c = 65535;
                break;
            case 1098288608:
                if (str.equals("map#isCompassEnabled")) {
                    c = 17;
                    break;
                }
                c = 65535;
                break;
            case 1172199911:
                if (str.equals("map#isZoomControlsEnabled")) {
                    c = 22;
                    break;
                }
                c = 65535;
                break;
            case 1322988819:
                if (str.equals("markers#update")) {
                    c = '\b';
                    break;
                }
                c = 65535;
                break;
            case 1546082965:
                if (str.equals("map#isTrafficEnabled")) {
                    c = 27;
                    break;
                }
                c = 65535;
                break;
            case 1564959387:
                if (str.equals("tileOverlays#update")) {
                    c = ' ';
                    break;
                }
                c = 65535;
                break;
            case 1708609913:
                if (str.equals("tileOverlays#clearTileCache")) {
                    c = '!';
                    break;
                }
                c = 65535;
                break;
            case 1873569705:
                if (str.equals("circles#update")) {
                    c = 16;
                    break;
                }
                c = 65535;
                break;
            case 1915657375:
                if (str.equals("map#isLiteModeEnabled")) {
                    c = 21;
                    break;
                }
                c = 65535;
                break;
            case 1953391461:
                if (str.equals("markers#showInfoWindow")) {
                    c = '\t';
                    break;
                }
                c = 65535;
                break;
            case 2003557999:
                if (str.equals("camera#move")) {
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
                if (this.googleMap != null) {
                    result.success(null);
                    return;
                } else {
                    this.mapReadyResult = result;
                    return;
                }
            case 1:
                Convert.interpretGoogleMapOptions(call.argument("options"), this);
                result.success(Convert.cameraPositionToJson(getCameraPosition()));
                return;
            case 2:
                GoogleMap googleMap = this.googleMap;
                if (googleMap != null) {
                    LatLngBounds latLngBounds = googleMap.getProjection().getVisibleRegion().latLngBounds;
                    result.success(Convert.latLngBoundsToJson(latLngBounds));
                    return;
                }
                result.error("GoogleMap uninitialized", "getVisibleRegion called prior to map initialization", null);
                return;
            case 3:
                if (this.googleMap != null) {
                    LatLng latLng = Convert.toLatLng(call.arguments);
                    Point screenLocation = this.googleMap.getProjection().toScreenLocation(latLng);
                    result.success(Convert.pointToJson(screenLocation));
                    return;
                }
                result.error("GoogleMap uninitialized", "getScreenCoordinate called prior to map initialization", null);
                return;
            case 4:
                if (this.googleMap != null) {
                    Point point = Convert.toPoint(call.arguments);
                    LatLng latLng2 = this.googleMap.getProjection().fromScreenLocation(point);
                    result.success(Convert.latLngToJson(latLng2));
                    return;
                }
                result.error("GoogleMap uninitialized", "getLatLng called prior to map initialization", null);
                return;
            case 5:
                GoogleMap googleMap2 = this.googleMap;
                if (googleMap2 != null) {
                    googleMap2.snapshot(new GoogleMap.SnapshotReadyCallback() { // from class: io.flutter.plugins.googlemaps.GoogleMapController.2
                        @Override // com.google.android.gms.maps.GoogleMap.SnapshotReadyCallback
                        public void onSnapshotReady(Bitmap bitmap) {
                            ByteArrayOutputStream stream = new ByteArrayOutputStream();
                            bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
                            byte[] byteArray = stream.toByteArray();
                            bitmap.recycle();
                            result.success(byteArray);
                        }
                    });
                    return;
                } else {
                    result.error("GoogleMap uninitialized", "takeSnapshot", null);
                    return;
                }
            case 6:
                CameraUpdate cameraUpdate = Convert.toCameraUpdate(call.argument("cameraUpdate"), this.density);
                moveCamera(cameraUpdate);
                result.success(null);
                return;
            case 7:
                CameraUpdate cameraUpdate2 = Convert.toCameraUpdate(call.argument("cameraUpdate"), this.density);
                animateCamera(cameraUpdate2);
                result.success(null);
                return;
            case '\b':
                List<Object> markersToAdd = (List) call.argument("markersToAdd");
                this.markersController.addMarkers(markersToAdd);
                List<Object> markersToChange = (List) call.argument("markersToChange");
                this.markersController.changeMarkers(markersToChange);
                List<Object> markerIdsToRemove = (List) call.argument("markerIdsToRemove");
                this.markersController.removeMarkers(markerIdsToRemove);
                result.success(null);
                return;
            case '\t':
                Object markerId = call.argument("markerId");
                this.markersController.showMarkerInfoWindow((String) markerId, result);
                return;
            case '\n':
                Object markerId2 = call.argument("markerId");
                this.markersController.hideMarkerInfoWindow((String) markerId2, result);
                return;
            case 11:
                Object markerId3 = call.argument("markerId");
                this.markersController.isInfoWindowShown((String) markerId3, result);
                return;
            case '\f':
                List<Object> clusterManagersToAdd = (List) call.argument("clusterManagersToAdd");
                if (clusterManagersToAdd != null) {
                    this.clusterManagersController.addClusterManagers(clusterManagersToAdd);
                }
                List<Object> clusterManagerIdsToRemove = (List) call.argument("clusterManagerIdsToRemove");
                if (clusterManagerIdsToRemove != null) {
                    this.clusterManagersController.removeClusterManagers(clusterManagerIdsToRemove);
                }
                result.success(null);
                return;
            case '\r':
                Object clusterManagerId = call.argument("clusterManagerId");
                this.clusterManagersController.getClustersWithClusterManagerId((String) clusterManagerId, result);
                return;
            case 14:
                List<Object> polygonsToAdd = (List) call.argument("polygonsToAdd");
                this.polygonsController.addPolygons(polygonsToAdd);
                List<Object> polygonsToChange = (List) call.argument("polygonsToChange");
                this.polygonsController.changePolygons(polygonsToChange);
                List<Object> polygonIdsToRemove = (List) call.argument("polygonIdsToRemove");
                this.polygonsController.removePolygons(polygonIdsToRemove);
                result.success(null);
                return;
            case 15:
                List<Object> polylinesToAdd = (List) call.argument("polylinesToAdd");
                this.polylinesController.addPolylines(polylinesToAdd);
                List<Object> polylinesToChange = (List) call.argument("polylinesToChange");
                this.polylinesController.changePolylines(polylinesToChange);
                List<Object> polylineIdsToRemove = (List) call.argument("polylineIdsToRemove");
                this.polylinesController.removePolylines(polylineIdsToRemove);
                result.success(null);
                return;
            case 16:
                List<Object> circlesToAdd = (List) call.argument("circlesToAdd");
                this.circlesController.addCircles(circlesToAdd);
                List<Object> circlesToChange = (List) call.argument("circlesToChange");
                this.circlesController.changeCircles(circlesToChange);
                List<Object> circleIdsToRemove = (List) call.argument("circleIdsToRemove");
                this.circlesController.removeCircles(circleIdsToRemove);
                result.success(null);
                return;
            case 17:
                result.success(Boolean.valueOf(this.googleMap.getUiSettings().isCompassEnabled()));
                return;
            case 18:
                result.success(Boolean.valueOf(this.googleMap.getUiSettings().isMapToolbarEnabled()));
                return;
            case 19:
                List<Float> zoomLevels = new ArrayList<>(2);
                zoomLevels.add(Float.valueOf(this.googleMap.getMinZoomLevel()));
                zoomLevels.add(Float.valueOf(this.googleMap.getMaxZoomLevel()));
                result.success(zoomLevels);
                return;
            case 20:
                result.success(Boolean.valueOf(this.googleMap.getUiSettings().isZoomGesturesEnabled()));
                return;
            case 21:
                result.success(this.options.getLiteMode());
                return;
            case 22:
                result.success(Boolean.valueOf(this.googleMap.getUiSettings().isZoomControlsEnabled()));
                return;
            case 23:
                result.success(Boolean.valueOf(this.googleMap.getUiSettings().isScrollGesturesEnabled()));
                return;
            case 24:
                result.success(Boolean.valueOf(this.googleMap.getUiSettings().isTiltGesturesEnabled()));
                return;
            case 25:
                result.success(Boolean.valueOf(this.googleMap.getUiSettings().isRotateGesturesEnabled()));
                return;
            case 26:
                result.success(Boolean.valueOf(this.googleMap.getUiSettings().isMyLocationButtonEnabled()));
                return;
            case 27:
                result.success(Boolean.valueOf(this.googleMap.isTrafficEnabled()));
                return;
            case MotionEventCompat.AXIS_RELATIVE_Y /* 28 */:
                result.success(Boolean.valueOf(this.googleMap.isBuildingsEnabled()));
                return;
            case 29:
                result.success(Float.valueOf(this.googleMap.getCameraPosition().zoom));
                return;
            case 30:
                Object arg = call.arguments;
                String style = arg instanceof String ? (String) arg : null;
                boolean mapStyleSet = updateMapStyle(style);
                ArrayList<Object> mapStyleResult = new ArrayList<>(2);
                mapStyleResult.add(Boolean.valueOf(mapStyleSet));
                if (!mapStyleSet) {
                    mapStyleResult.add(this.lastStyleError);
                }
                result.success(mapStyleResult);
                return;
            case 31:
                result.success(this.lastStyleError);
                return;
            case ' ':
                List<Map<String, ?>> tileOverlaysToAdd = (List) call.argument("tileOverlaysToAdd");
                this.tileOverlaysController.addTileOverlays(tileOverlaysToAdd);
                List<Map<String, ?>> tileOverlaysToChange = (List) call.argument("tileOverlaysToChange");
                this.tileOverlaysController.changeTileOverlays(tileOverlaysToChange);
                List<String> tileOverlaysToRemove = (List) call.argument("tileOverlayIdsToRemove");
                this.tileOverlaysController.removeTileOverlays(tileOverlaysToRemove);
                result.success(null);
                return;
            case '!':
                String tileOverlayId = (String) call.argument("tileOverlayId");
                this.tileOverlaysController.clearTileCache(tileOverlayId);
                result.success(null);
                return;
            case MotionEventCompat.AXIS_GENERIC_3 /* 34 */:
                String tileOverlayId2 = (String) call.argument("tileOverlayId");
                result.success(this.tileOverlaysController.getTileOverlayInfo(tileOverlayId2));
                return;
            default:
                result.notImplemented();
                return;
        }
    }

    @Override // com.google.android.gms.maps.GoogleMap.OnMapClickListener
    public void onMapClick(LatLng latLng) {
        Map<String, Object> arguments = new HashMap<>(2);
        arguments.put("position", Convert.latLngToJson(latLng));
        this.methodChannel.invokeMethod("map#onTap", arguments);
    }

    @Override // com.google.android.gms.maps.GoogleMap.OnMapLongClickListener
    public void onMapLongClick(LatLng latLng) {
        Map<String, Object> arguments = new HashMap<>(2);
        arguments.put("position", Convert.latLngToJson(latLng));
        this.methodChannel.invokeMethod("map#onLongPress", arguments);
    }

    @Override // com.google.android.gms.maps.GoogleMap.OnCameraMoveStartedListener
    public void onCameraMoveStarted(int reason) {
        Map<String, Object> arguments = new HashMap<>(2);
        boolean isGesture = reason == 1;
        arguments.put("isGesture", Boolean.valueOf(isGesture));
        this.methodChannel.invokeMethod("camera#onMoveStarted", arguments);
    }

    @Override // com.google.android.gms.maps.GoogleMap.OnInfoWindowClickListener
    public void onInfoWindowClick(Marker marker) {
        this.markersController.onInfoWindowTap(marker.getId());
    }

    @Override // com.google.android.gms.maps.GoogleMap.OnCameraMoveListener
    public void onCameraMove() {
        if (!this.trackCameraPosition) {
            return;
        }
        Map<String, Object> arguments = new HashMap<>(2);
        arguments.put("position", Convert.cameraPositionToJson(this.googleMap.getCameraPosition()));
        this.methodChannel.invokeMethod("camera#onMove", arguments);
    }

    @Override // com.google.android.gms.maps.GoogleMap.OnCameraIdleListener
    public void onCameraIdle() {
        this.clusterManagersController.onCameraIdle();
        this.methodChannel.invokeMethod("camera#onIdle", Collections.singletonMap("map", Integer.valueOf(this.id)));
    }

    @Override // com.google.android.gms.maps.GoogleMap.OnMarkerClickListener
    public boolean onMarkerClick(Marker marker) {
        return this.markersController.onMapsMarkerTap(marker.getId());
    }

    @Override // com.google.android.gms.maps.GoogleMap.OnMarkerDragListener
    public void onMarkerDragStart(Marker marker) {
        this.markersController.onMarkerDragStart(marker.getId(), marker.getPosition());
    }

    @Override // com.google.android.gms.maps.GoogleMap.OnMarkerDragListener
    public void onMarkerDrag(Marker marker) {
        this.markersController.onMarkerDrag(marker.getId(), marker.getPosition());
    }

    @Override // com.google.android.gms.maps.GoogleMap.OnMarkerDragListener
    public void onMarkerDragEnd(Marker marker) {
        this.markersController.onMarkerDragEnd(marker.getId(), marker.getPosition());
    }

    @Override // com.google.android.gms.maps.GoogleMap.OnPolygonClickListener
    public void onPolygonClick(Polygon polygon) {
        this.polygonsController.onPolygonTap(polygon.getId());
    }

    @Override // com.google.android.gms.maps.GoogleMap.OnPolylineClickListener
    public void onPolylineClick(Polyline polyline) {
        this.polylinesController.onPolylineTap(polyline.getId());
    }

    @Override // com.google.android.gms.maps.GoogleMap.OnCircleClickListener
    public void onCircleClick(Circle circle) {
        this.circlesController.onCircleTap(circle.getId());
    }

    @Override // io.flutter.plugin.platform.PlatformView
    public void dispose() {
        if (this.disposed) {
            return;
        }
        this.disposed = true;
        this.methodChannel.setMethodCallHandler(null);
        setGoogleMapListener(null);
        setMarkerCollectionListener(null);
        setClusterItemClickListener(null);
        setClusterItemRenderedListener(null);
        destroyMapViewIfNecessary();
        Lifecycle lifecycle = this.lifecycleProvider.getLifecycle();
        if (lifecycle != null) {
            lifecycle.removeObserver(this);
        }
    }

    private void setGoogleMapListener(GoogleMapListener listener) {
        GoogleMap googleMap = this.googleMap;
        if (googleMap == null) {
            Log.v(TAG, "Controller was disposed before GoogleMap was ready.");
            return;
        }
        googleMap.setOnCameraMoveStartedListener(listener);
        this.googleMap.setOnCameraMoveListener(listener);
        this.googleMap.setOnCameraIdleListener(listener);
        this.googleMap.setOnPolygonClickListener(listener);
        this.googleMap.setOnPolylineClickListener(listener);
        this.googleMap.setOnCircleClickListener(listener);
        this.googleMap.setOnMapClickListener(listener);
        this.googleMap.setOnMapLongClickListener(listener);
    }

    public void setMarkerCollectionListener(GoogleMapListener listener) {
        if (this.googleMap == null) {
            Log.v(TAG, "Controller was disposed before GoogleMap was ready.");
            return;
        }
        this.markerCollection.setOnMarkerClickListener(listener);
        this.markerCollection.setOnMarkerDragListener(listener);
        this.markerCollection.setOnInfoWindowClickListener(listener);
    }

    public void setClusterItemClickListener(ClusterManager.OnClusterItemClickListener<MarkerBuilder> listener) {
        if (this.googleMap == null) {
            Log.v(TAG, "Controller was disposed before GoogleMap was ready.");
        } else {
            this.clusterManagersController.setClusterItemClickListener(listener);
        }
    }

    public void setClusterItemRenderedListener(ClusterManagersController.OnClusterItemRendered<MarkerBuilder> listener) {
        if (this.googleMap == null) {
            Log.v(TAG, "Controller was disposed before GoogleMap was ready.");
        } else {
            this.clusterManagersController.setClusterItemRenderedListener(listener);
        }
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public void onCreate(LifecycleOwner owner) {
        if (this.disposed) {
            return;
        }
        this.mapView.onCreate(null);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public void onStart(LifecycleOwner owner) {
        if (this.disposed) {
            return;
        }
        this.mapView.onStart();
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public void onResume(LifecycleOwner owner) {
        if (this.disposed) {
            return;
        }
        this.mapView.onResume();
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public void onPause(LifecycleOwner owner) {
        if (this.disposed) {
            return;
        }
        this.mapView.onResume();
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public void onStop(LifecycleOwner owner) {
        if (this.disposed) {
            return;
        }
        this.mapView.onStop();
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public void onDestroy(LifecycleOwner owner) {
        owner.getLifecycle().removeObserver(this);
        if (this.disposed) {
            return;
        }
        destroyMapViewIfNecessary();
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding.OnSaveInstanceStateListener
    public void onRestoreInstanceState(Bundle bundle) {
        if (this.disposed) {
            return;
        }
        this.mapView.onCreate(bundle);
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding.OnSaveInstanceStateListener
    public void onSaveInstanceState(Bundle bundle) {
        if (this.disposed) {
            return;
        }
        this.mapView.onSaveInstanceState(bundle);
    }

    @Override // io.flutter.plugins.googlemaps.GoogleMapOptionsSink
    public void setCameraTargetBounds(LatLngBounds bounds) {
        this.googleMap.setLatLngBoundsForCameraTarget(bounds);
    }

    @Override // io.flutter.plugins.googlemaps.GoogleMapOptionsSink
    public void setCompassEnabled(boolean compassEnabled) {
        this.googleMap.getUiSettings().setCompassEnabled(compassEnabled);
    }

    @Override // io.flutter.plugins.googlemaps.GoogleMapOptionsSink
    public void setMapToolbarEnabled(boolean mapToolbarEnabled) {
        this.googleMap.getUiSettings().setMapToolbarEnabled(mapToolbarEnabled);
    }

    @Override // io.flutter.plugins.googlemaps.GoogleMapOptionsSink
    public void setMapType(int mapType) {
        this.googleMap.setMapType(mapType);
    }

    @Override // io.flutter.plugins.googlemaps.GoogleMapOptionsSink
    public void setTrackCameraPosition(boolean trackCameraPosition) {
        this.trackCameraPosition = trackCameraPosition;
    }

    @Override // io.flutter.plugins.googlemaps.GoogleMapOptionsSink
    public void setRotateGesturesEnabled(boolean rotateGesturesEnabled) {
        this.googleMap.getUiSettings().setRotateGesturesEnabled(rotateGesturesEnabled);
    }

    @Override // io.flutter.plugins.googlemaps.GoogleMapOptionsSink
    public void setScrollGesturesEnabled(boolean scrollGesturesEnabled) {
        this.googleMap.getUiSettings().setScrollGesturesEnabled(scrollGesturesEnabled);
    }

    @Override // io.flutter.plugins.googlemaps.GoogleMapOptionsSink
    public void setTiltGesturesEnabled(boolean tiltGesturesEnabled) {
        this.googleMap.getUiSettings().setTiltGesturesEnabled(tiltGesturesEnabled);
    }

    @Override // io.flutter.plugins.googlemaps.GoogleMapOptionsSink
    public void setMinMaxZoomPreference(Float min, Float max) {
        this.googleMap.resetMinMaxZoomPreference();
        if (min != null) {
            this.googleMap.setMinZoomPreference(min.floatValue());
        }
        if (max != null) {
            this.googleMap.setMaxZoomPreference(max.floatValue());
        }
    }

    @Override // io.flutter.plugins.googlemaps.GoogleMapOptionsSink
    public void setPadding(float top, float left, float bottom, float right) {
        GoogleMap googleMap = this.googleMap;
        if (googleMap != null) {
            float f = this.density;
            googleMap.setPadding((int) (left * f), (int) (top * f), (int) (right * f), (int) (f * bottom));
            return;
        }
        setInitialPadding(top, left, bottom, right);
    }

    void setInitialPadding(float top, float left, float bottom, float right) {
        List<Float> list = this.initialPadding;
        if (list == null) {
            this.initialPadding = new ArrayList();
        } else {
            list.clear();
        }
        this.initialPadding.add(Float.valueOf(top));
        this.initialPadding.add(Float.valueOf(left));
        this.initialPadding.add(Float.valueOf(bottom));
        this.initialPadding.add(Float.valueOf(right));
    }

    @Override // io.flutter.plugins.googlemaps.GoogleMapOptionsSink
    public void setZoomGesturesEnabled(boolean zoomGesturesEnabled) {
        this.googleMap.getUiSettings().setZoomGesturesEnabled(zoomGesturesEnabled);
    }

    @Override // io.flutter.plugins.googlemaps.GoogleMapOptionsSink
    public void setLiteModeEnabled(boolean liteModeEnabled) {
        this.options.liteMode(liteModeEnabled);
    }

    @Override // io.flutter.plugins.googlemaps.GoogleMapOptionsSink
    public void setMyLocationEnabled(boolean myLocationEnabled) {
        if (this.myLocationEnabled == myLocationEnabled) {
            return;
        }
        this.myLocationEnabled = myLocationEnabled;
        if (this.googleMap != null) {
            updateMyLocationSettings();
        }
    }

    @Override // io.flutter.plugins.googlemaps.GoogleMapOptionsSink
    public void setMyLocationButtonEnabled(boolean myLocationButtonEnabled) {
        if (this.myLocationButtonEnabled == myLocationButtonEnabled) {
            return;
        }
        this.myLocationButtonEnabled = myLocationButtonEnabled;
        if (this.googleMap != null) {
            updateMyLocationSettings();
        }
    }

    @Override // io.flutter.plugins.googlemaps.GoogleMapOptionsSink
    public void setZoomControlsEnabled(boolean zoomControlsEnabled) {
        if (this.zoomControlsEnabled == zoomControlsEnabled) {
            return;
        }
        this.zoomControlsEnabled = zoomControlsEnabled;
        GoogleMap googleMap = this.googleMap;
        if (googleMap != null) {
            googleMap.getUiSettings().setZoomControlsEnabled(zoomControlsEnabled);
        }
    }

    @Override // io.flutter.plugins.googlemaps.GoogleMapOptionsSink
    public void setInitialMarkers(Object initialMarkers) {
        ArrayList<?> markers = (ArrayList) initialMarkers;
        this.initialMarkers = markers != null ? new ArrayList(markers) : null;
        if (this.googleMap != null) {
            updateInitialMarkers();
        }
    }

    private void updateInitialMarkers() {
        this.markersController.addMarkers(this.initialMarkers);
    }

    @Override // io.flutter.plugins.googlemaps.GoogleMapOptionsSink
    public void setInitialClusterManagers(Object initialClusterManagers) {
        ArrayList<?> clusterManagers = (ArrayList) initialClusterManagers;
        this.initialClusterManagers = clusterManagers != null ? new ArrayList(clusterManagers) : null;
        if (this.googleMap != null) {
            updateInitialClusterManagers();
        }
    }

    private void updateInitialClusterManagers() {
        List<Object> list = this.initialClusterManagers;
        if (list != null) {
            this.clusterManagersController.addClusterManagers(list);
        }
    }

    @Override // io.flutter.plugins.googlemaps.GoogleMapOptionsSink
    public void setInitialPolygons(Object initialPolygons) {
        ArrayList<?> polygons = (ArrayList) initialPolygons;
        this.initialPolygons = polygons != null ? new ArrayList(polygons) : null;
        if (this.googleMap != null) {
            updateInitialPolygons();
        }
    }

    private void updateInitialPolygons() {
        this.polygonsController.addPolygons(this.initialPolygons);
    }

    @Override // io.flutter.plugins.googlemaps.GoogleMapOptionsSink
    public void setInitialPolylines(Object initialPolylines) {
        ArrayList<?> polylines = (ArrayList) initialPolylines;
        this.initialPolylines = polylines != null ? new ArrayList(polylines) : null;
        if (this.googleMap != null) {
            updateInitialPolylines();
        }
    }

    private void updateInitialPolylines() {
        this.polylinesController.addPolylines(this.initialPolylines);
    }

    @Override // io.flutter.plugins.googlemaps.GoogleMapOptionsSink
    public void setInitialCircles(Object initialCircles) {
        ArrayList<?> circles = (ArrayList) initialCircles;
        this.initialCircles = circles != null ? new ArrayList(circles) : null;
        if (this.googleMap != null) {
            updateInitialCircles();
        }
    }

    private void updateInitialCircles() {
        this.circlesController.addCircles(this.initialCircles);
    }

    @Override // io.flutter.plugins.googlemaps.GoogleMapOptionsSink
    public void setInitialTileOverlays(List<Map<String, ?>> initialTileOverlays) {
        this.initialTileOverlays = initialTileOverlays;
        if (this.googleMap != null) {
            updateInitialTileOverlays();
        }
    }

    private void updateInitialTileOverlays() {
        this.tileOverlaysController.addTileOverlays(this.initialTileOverlays);
    }

    private void updateMyLocationSettings() {
        if (hasLocationPermission()) {
            this.googleMap.setMyLocationEnabled(this.myLocationEnabled);
            this.googleMap.getUiSettings().setMyLocationButtonEnabled(this.myLocationButtonEnabled);
            return;
        }
        Log.e(TAG, "Cannot enable MyLocation layer as location permissions are not granted");
    }

    private boolean hasLocationPermission() {
        return checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0 || checkSelfPermission("android.permission.ACCESS_COARSE_LOCATION") == 0;
    }

    private int checkSelfPermission(String permission) {
        if (permission == null) {
            throw new IllegalArgumentException("permission is null");
        }
        return this.context.checkPermission(permission, Process.myPid(), Process.myUid());
    }

    private void destroyMapViewIfNecessary() {
        MapView mapView = this.mapView;
        if (mapView == null) {
            return;
        }
        mapView.onDestroy();
        this.mapView = null;
    }

    @Override // io.flutter.plugins.googlemaps.GoogleMapOptionsSink
    public void setIndoorEnabled(boolean indoorEnabled) {
        this.indoorEnabled = indoorEnabled;
    }

    @Override // io.flutter.plugins.googlemaps.GoogleMapOptionsSink
    public void setTrafficEnabled(boolean trafficEnabled) {
        this.trafficEnabled = trafficEnabled;
        GoogleMap googleMap = this.googleMap;
        if (googleMap == null) {
            return;
        }
        googleMap.setTrafficEnabled(trafficEnabled);
    }

    @Override // io.flutter.plugins.googlemaps.GoogleMapOptionsSink
    public void setBuildingsEnabled(boolean buildingsEnabled) {
        this.buildingsEnabled = buildingsEnabled;
    }

    @Override // io.flutter.plugins.googlemaps.ClusterManagersController.OnClusterItemRendered
    public void onClusterItemRendered(MarkerBuilder markerBuilder, Marker marker) {
        this.markersController.onClusterItemRendered(markerBuilder, marker);
    }

    @Override // com.google.maps.android.clustering.ClusterManager.OnClusterItemClickListener
    public boolean onClusterItemClick(MarkerBuilder item) {
        return this.markersController.onMarkerTap(item.markerId());
    }

    @Override // io.flutter.plugins.googlemaps.GoogleMapOptionsSink
    public void setMapStyle(String style) {
        if (this.googleMap == null) {
            this.initialMapStyle = style;
        } else {
            updateMapStyle(style);
        }
    }

    private boolean updateMapStyle(String style) {
        MapStyleOptions mapStyleOptions = (style == null || style.isEmpty()) ? null : new MapStyleOptions(style);
        boolean set = ((GoogleMap) Objects.requireNonNull(this.googleMap)).setMapStyle(mapStyleOptions);
        this.lastStyleError = set ? null : "Unable to set the map style. Please check console logs for errors.";
        return set;
    }
}
