package io.flutter.plugins.googlemaps;

import android.content.Context;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapsSdkInitializedCallback;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
/* loaded from: classes2.dex */
final class GoogleMapInitializer implements OnMapsSdkInitializedCallback, MethodChannel.MethodCallHandler {
    private static MethodChannel.Result initializationResult;
    private final Context context;
    private final MethodChannel methodChannel;
    private boolean rendererInitialized = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public GoogleMapInitializer(Context context, BinaryMessenger binaryMessenger) {
        this.context = context;
        MethodChannel methodChannel = new MethodChannel(binaryMessenger, "plugins.flutter.dev/google_maps_android_initializer");
        this.methodChannel = methodChannel;
        methodChannel.setMethodCallHandler(this);
    }

    @Override // io.flutter.plugin.common.MethodChannel.MethodCallHandler
    public void onMethodCall(MethodCall call, MethodChannel.Result result) {
        char c;
        String str = call.method;
        switch (str.hashCode()) {
            case 2111588020:
                if (str.equals("initializer#preferRenderer")) {
                    c = 0;
                    break;
                }
            default:
                c = 65535;
                break;
        }
        switch (c) {
            case 0:
                String preferredRenderer = (String) call.argument("value");
                initializeWithPreferredRenderer(preferredRenderer, result);
                return;
            default:
                result.notImplemented();
                return;
        }
    }

    private void initializeWithPreferredRenderer(String preferredRenderer, MethodChannel.Result result) {
        if (this.rendererInitialized || initializationResult != null) {
            result.error("Renderer already initialized", "Renderer initialization called multiple times", null);
            return;
        }
        initializationResult = result;
        char c = 65535;
        switch (preferredRenderer.hashCode()) {
            case -1109880953:
                if (preferredRenderer.equals("latest")) {
                    c = 0;
                    break;
                }
                break;
            case -1106578487:
                if (preferredRenderer.equals("legacy")) {
                    c = 1;
                    break;
                }
                break;
            case 1544803905:
                if (preferredRenderer.equals("default")) {
                    c = 2;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                initializeWithRendererRequest(MapsInitializer.Renderer.LATEST);
                return;
            case 1:
                initializeWithRendererRequest(MapsInitializer.Renderer.LEGACY);
                return;
            case 2:
                initializeWithRendererRequest(null);
                return;
            default:
                initializationResult.error("Invalid renderer type", "Renderer initialization called with invalid renderer type", null);
                initializationResult = null;
                return;
        }
    }

    public void initializeWithRendererRequest(MapsInitializer.Renderer renderer) {
        MapsInitializer.initialize(this.context, renderer, this);
    }

    @Override // com.google.android.gms.maps.OnMapsSdkInitializedCallback
    public void onMapsSdkInitialized(MapsInitializer.Renderer renderer) {
        this.rendererInitialized = true;
        if (initializationResult != null) {
            switch (AnonymousClass1.$SwitchMap$com$google$android$gms$maps$MapsInitializer$Renderer[renderer.ordinal()]) {
                case 1:
                    initializationResult.success("latest");
                    break;
                case 2:
                    initializationResult.success("legacy");
                    break;
                default:
                    initializationResult.error("Unknown renderer type", "Initialized with unknown renderer type", null);
                    break;
            }
            initializationResult = null;
        }
    }

    /* renamed from: io.flutter.plugins.googlemaps.GoogleMapInitializer$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$android$gms$maps$MapsInitializer$Renderer;

        static {
            int[] iArr = new int[MapsInitializer.Renderer.values().length];
            $SwitchMap$com$google$android$gms$maps$MapsInitializer$Renderer = iArr;
            try {
                iArr[MapsInitializer.Renderer.LATEST.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$com$google$android$gms$maps$MapsInitializer$Renderer[MapsInitializer.Renderer.LEGACY.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }
}
