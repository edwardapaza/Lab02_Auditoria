package io.flutter.plugins.googlemaps;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.activity.ActivityAware;
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import io.flutter.embedding.engine.plugins.lifecycle.FlutterLifecycleAdapter;
import io.flutter.plugin.common.PluginRegistry;
/* loaded from: classes2.dex */
public class GoogleMapsPlugin implements FlutterPlugin, ActivityAware {
    private static final String VIEW_TYPE = "plugins.flutter.dev/google_maps_android";
    Lifecycle lifecycle;

    public static void registerWith(PluginRegistry.Registrar registrar) {
        final Activity activity = registrar.activity();
        if (activity == null) {
            return;
        }
        if (activity instanceof LifecycleOwner) {
            registrar.platformViewRegistry().registerViewFactory(VIEW_TYPE, new GoogleMapFactory(registrar.messenger(), registrar.context(), new LifecycleProvider() { // from class: io.flutter.plugins.googlemaps.GoogleMapsPlugin.1
                @Override // io.flutter.plugins.googlemaps.LifecycleProvider
                public Lifecycle getLifecycle() {
                    return ((LifecycleOwner) activity).getLifecycle();
                }
            }));
        } else {
            registrar.platformViewRegistry().registerViewFactory(VIEW_TYPE, new GoogleMapFactory(registrar.messenger(), registrar.context(), new ProxyLifecycleProvider(activity)));
        }
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding binding) {
        binding.getPlatformViewRegistry().registerViewFactory(VIEW_TYPE, new GoogleMapFactory(binding.getBinaryMessenger(), binding.getApplicationContext(), new LifecycleProvider() { // from class: io.flutter.plugins.googlemaps.GoogleMapsPlugin.2
            @Override // io.flutter.plugins.googlemaps.LifecycleProvider
            public Lifecycle getLifecycle() {
                return GoogleMapsPlugin.this.lifecycle;
            }
        }));
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding binding) {
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public void onAttachedToActivity(ActivityPluginBinding binding) {
        this.lifecycle = FlutterLifecycleAdapter.getActivityLifecycle(binding);
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public void onDetachedFromActivity() {
        this.lifecycle = null;
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public void onReattachedToActivityForConfigChanges(ActivityPluginBinding binding) {
        onAttachedToActivity(binding);
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public void onDetachedFromActivityForConfigChanges() {
        onDetachedFromActivity();
    }

    /* loaded from: classes2.dex */
    private static final class ProxyLifecycleProvider implements Application.ActivityLifecycleCallbacks, LifecycleOwner, LifecycleProvider {
        private final LifecycleRegistry lifecycle = new LifecycleRegistry(this);
        private final int registrarActivityHashCode;

        ProxyLifecycleProvider(Activity activity) {
            this.registrarActivityHashCode = activity.hashCode();
            activity.getApplication().registerActivityLifecycleCallbacks(this);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
            if (activity.hashCode() != this.registrarActivityHashCode) {
                return;
            }
            this.lifecycle.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            if (activity.hashCode() != this.registrarActivityHashCode) {
                return;
            }
            this.lifecycle.handleLifecycleEvent(Lifecycle.Event.ON_START);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            if (activity.hashCode() != this.registrarActivityHashCode) {
                return;
            }
            this.lifecycle.handleLifecycleEvent(Lifecycle.Event.ON_RESUME);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            if (activity.hashCode() != this.registrarActivityHashCode) {
                return;
            }
            this.lifecycle.handleLifecycleEvent(Lifecycle.Event.ON_PAUSE);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            if (activity.hashCode() != this.registrarActivityHashCode) {
                return;
            }
            this.lifecycle.handleLifecycleEvent(Lifecycle.Event.ON_STOP);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            if (activity.hashCode() != this.registrarActivityHashCode) {
                return;
            }
            activity.getApplication().unregisterActivityLifecycleCallbacks(this);
            this.lifecycle.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY);
        }

        @Override // androidx.lifecycle.LifecycleOwner
        public Lifecycle getLifecycle() {
            return this.lifecycle;
        }
    }
}
