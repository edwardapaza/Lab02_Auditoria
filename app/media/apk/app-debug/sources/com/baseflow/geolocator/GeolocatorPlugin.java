package com.baseflow.geolocator;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.baseflow.geolocator.GeolocatorLocationService;
import com.baseflow.geolocator.location.GeolocationManager;
import com.baseflow.geolocator.location.LocationAccuracyManager;
import com.baseflow.geolocator.permission.PermissionManager;
import io.flutter.Log;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.activity.ActivityAware;
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
/* loaded from: classes2.dex */
public class GeolocatorPlugin implements FlutterPlugin, ActivityAware {
    private static final String TAG = "FlutterGeolocator";
    private GeolocatorLocationService foregroundLocationService;
    private LocationServiceHandlerImpl locationServiceHandler;
    private MethodCallHandlerImpl methodCallHandler;
    private ActivityPluginBinding pluginBinding;
    private StreamHandlerImpl streamHandler;
    private final ServiceConnection serviceConnection = new ServiceConnection() { // from class: com.baseflow.geolocator.GeolocatorPlugin.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.d(GeolocatorPlugin.TAG, "Geolocator foreground service connected");
            if (service instanceof GeolocatorLocationService.LocalBinder) {
                GeolocatorPlugin.this.initialize(((GeolocatorLocationService.LocalBinder) service).getLocationService());
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName name) {
            Log.d(GeolocatorPlugin.TAG, "Geolocator foreground service disconnected");
            if (GeolocatorPlugin.this.foregroundLocationService != null) {
                GeolocatorPlugin.this.foregroundLocationService.setActivity(null);
                GeolocatorPlugin.this.foregroundLocationService = null;
            }
        }
    };
    private final PermissionManager permissionManager = PermissionManager.getInstance();
    private final GeolocationManager geolocationManager = GeolocationManager.getInstance();
    private final LocationAccuracyManager locationAccuracyManager = LocationAccuracyManager.getInstance();

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        MethodCallHandlerImpl methodCallHandlerImpl = new MethodCallHandlerImpl(this.permissionManager, this.geolocationManager, this.locationAccuracyManager);
        this.methodCallHandler = methodCallHandlerImpl;
        methodCallHandlerImpl.startListening(flutterPluginBinding.getApplicationContext(), flutterPluginBinding.getBinaryMessenger());
        StreamHandlerImpl streamHandlerImpl = new StreamHandlerImpl(this.permissionManager, this.geolocationManager);
        this.streamHandler = streamHandlerImpl;
        streamHandlerImpl.startListening(flutterPluginBinding.getApplicationContext(), flutterPluginBinding.getBinaryMessenger());
        LocationServiceHandlerImpl locationServiceHandlerImpl = new LocationServiceHandlerImpl();
        this.locationServiceHandler = locationServiceHandlerImpl;
        locationServiceHandlerImpl.setContext(flutterPluginBinding.getApplicationContext());
        this.locationServiceHandler.startListening(flutterPluginBinding.getApplicationContext(), flutterPluginBinding.getBinaryMessenger());
        bindForegroundService(flutterPluginBinding.getApplicationContext());
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding binding) {
        unbindForegroundService(binding.getApplicationContext());
        dispose();
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public void onAttachedToActivity(ActivityPluginBinding binding) {
        Log.d(TAG, "Attaching Geolocator to activity");
        this.pluginBinding = binding;
        registerListeners();
        MethodCallHandlerImpl methodCallHandlerImpl = this.methodCallHandler;
        if (methodCallHandlerImpl != null) {
            methodCallHandlerImpl.setActivity(binding.getActivity());
        }
        StreamHandlerImpl streamHandlerImpl = this.streamHandler;
        if (streamHandlerImpl != null) {
            streamHandlerImpl.setActivity(binding.getActivity());
        }
        GeolocatorLocationService geolocatorLocationService = this.foregroundLocationService;
        if (geolocatorLocationService != null) {
            geolocatorLocationService.setActivity(this.pluginBinding.getActivity());
        }
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public void onDetachedFromActivityForConfigChanges() {
        onDetachedFromActivity();
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public void onReattachedToActivityForConfigChanges(ActivityPluginBinding binding) {
        onAttachedToActivity(binding);
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public void onDetachedFromActivity() {
        Log.d(TAG, "Detaching Geolocator from activity");
        deregisterListeners();
        MethodCallHandlerImpl methodCallHandlerImpl = this.methodCallHandler;
        if (methodCallHandlerImpl != null) {
            methodCallHandlerImpl.setActivity(null);
        }
        StreamHandlerImpl streamHandlerImpl = this.streamHandler;
        if (streamHandlerImpl != null) {
            streamHandlerImpl.setActivity(null);
        }
        GeolocatorLocationService geolocatorLocationService = this.foregroundLocationService;
        if (geolocatorLocationService != null) {
            geolocatorLocationService.setActivity(null);
        }
        if (this.pluginBinding != null) {
            this.pluginBinding = null;
        }
    }

    private void registerListeners() {
        ActivityPluginBinding activityPluginBinding = this.pluginBinding;
        if (activityPluginBinding != null) {
            activityPluginBinding.addActivityResultListener(this.geolocationManager);
            this.pluginBinding.addRequestPermissionsResultListener(this.permissionManager);
        }
    }

    private void deregisterListeners() {
        ActivityPluginBinding activityPluginBinding = this.pluginBinding;
        if (activityPluginBinding != null) {
            activityPluginBinding.removeActivityResultListener(this.geolocationManager);
            this.pluginBinding.removeRequestPermissionsResultListener(this.permissionManager);
        }
    }

    private void bindForegroundService(Context context) {
        context.bindService(new Intent(context, GeolocatorLocationService.class), this.serviceConnection, 1);
    }

    private void unbindForegroundService(Context context) {
        GeolocatorLocationService geolocatorLocationService = this.foregroundLocationService;
        if (geolocatorLocationService != null) {
            geolocatorLocationService.flutterEngineDisconnected();
        }
        context.unbindService(this.serviceConnection);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initialize(GeolocatorLocationService service) {
        Log.d(TAG, "Initializing Geolocator services");
        this.foregroundLocationService = service;
        service.setGeolocationManager(this.geolocationManager);
        this.foregroundLocationService.flutterEngineConnected();
        StreamHandlerImpl streamHandlerImpl = this.streamHandler;
        if (streamHandlerImpl != null) {
            streamHandlerImpl.setForegroundLocationService(service);
        }
    }

    private void dispose() {
        Log.d(TAG, "Disposing Geolocator services");
        MethodCallHandlerImpl methodCallHandlerImpl = this.methodCallHandler;
        if (methodCallHandlerImpl != null) {
            methodCallHandlerImpl.stopListening();
            this.methodCallHandler.setActivity(null);
            this.methodCallHandler = null;
        }
        StreamHandlerImpl streamHandlerImpl = this.streamHandler;
        if (streamHandlerImpl != null) {
            streamHandlerImpl.stopListening();
            this.streamHandler.setForegroundLocationService(null);
            this.streamHandler = null;
        }
        LocationServiceHandlerImpl locationServiceHandlerImpl = this.locationServiceHandler;
        if (locationServiceHandlerImpl != null) {
            locationServiceHandlerImpl.setContext(null);
            this.locationServiceHandler.stopListening();
            this.locationServiceHandler = null;
        }
        GeolocatorLocationService geolocatorLocationService = this.foregroundLocationService;
        if (geolocatorLocationService != null) {
            geolocatorLocationService.setActivity(null);
        }
    }
}
