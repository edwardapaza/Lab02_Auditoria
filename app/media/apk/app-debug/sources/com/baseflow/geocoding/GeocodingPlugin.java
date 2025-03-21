package com.baseflow.geocoding;

import android.util.Log;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
/* loaded from: classes2.dex */
public final class GeocodingPlugin implements FlutterPlugin {
    private static final String TAG = "GeocodingPlugin";
    private Geocoding geocoding;
    private MethodCallHandlerImpl methodCallHandler;

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding binding) {
        Geocoding geocoding = new Geocoding(binding.getApplicationContext());
        this.geocoding = geocoding;
        MethodCallHandlerImpl methodCallHandlerImpl = new MethodCallHandlerImpl(geocoding);
        this.methodCallHandler = methodCallHandlerImpl;
        methodCallHandlerImpl.startListening(binding.getBinaryMessenger());
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding binding) {
        MethodCallHandlerImpl methodCallHandlerImpl = this.methodCallHandler;
        if (methodCallHandlerImpl == null) {
            Log.wtf(TAG, "Already detached from the engine.");
            return;
        }
        methodCallHandlerImpl.stopListening();
        this.methodCallHandler = null;
        this.geocoding = null;
    }
}
