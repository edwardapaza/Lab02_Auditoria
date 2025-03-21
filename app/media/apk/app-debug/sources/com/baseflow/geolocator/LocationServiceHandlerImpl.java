package com.baseflow.geolocator;

import android.content.Context;
import android.content.IntentFilter;
import android.util.Log;
import androidx.core.content.ContextCompat;
import com.baseflow.geolocator.location.LocationServiceStatusReceiver;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.EventChannel;
/* loaded from: classes2.dex */
public class LocationServiceHandlerImpl implements EventChannel.StreamHandler {
    private static final String TAG = "LocationServiceHandler";
    private EventChannel channel;
    private Context context;
    private LocationServiceStatusReceiver receiver;

    /* JADX INFO: Access modifiers changed from: package-private */
    public void startListening(Context context, BinaryMessenger messenger) {
        if (this.channel != null) {
            Log.w(TAG, "Setting a event call handler before the last was disposed.");
            stopListening();
        }
        EventChannel eventChannel = new EventChannel(messenger, "flutter.baseflow.com/geolocator_service_updates_android");
        this.channel = eventChannel;
        eventChannel.setStreamHandler(this);
        this.context = context;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void stopListening() {
        if (this.channel == null) {
            return;
        }
        disposeListeners();
        this.channel.setStreamHandler(null);
        this.channel = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setContext(Context context) {
        this.context = context;
    }

    @Override // io.flutter.plugin.common.EventChannel.StreamHandler
    public void onListen(Object arguments, EventChannel.EventSink events) {
        if (this.context == null) {
            return;
        }
        IntentFilter filter = new IntentFilter("android.location.PROVIDERS_CHANGED");
        filter.addAction("android.intent.action.PROVIDER_CHANGED");
        LocationServiceStatusReceiver locationServiceStatusReceiver = new LocationServiceStatusReceiver(events);
        this.receiver = locationServiceStatusReceiver;
        ContextCompat.registerReceiver(this.context, locationServiceStatusReceiver, filter, 2);
    }

    @Override // io.flutter.plugin.common.EventChannel.StreamHandler
    public void onCancel(Object arguments) {
        disposeListeners();
    }

    private void disposeListeners() {
        LocationServiceStatusReceiver locationServiceStatusReceiver;
        Context context = this.context;
        if (context != null && (locationServiceStatusReceiver = this.receiver) != null) {
            context.unregisterReceiver(locationServiceStatusReceiver);
        }
    }
}
