package io.flutter.plugins.googlemaps;

import android.content.Context;
import com.google.android.gms.maps.model.CameraPosition;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.StandardMessageCodec;
import io.flutter.plugin.platform.PlatformView;
import io.flutter.plugin.platform.PlatformViewFactory;
import java.util.List;
import java.util.Map;
/* loaded from: classes2.dex */
public class GoogleMapFactory extends PlatformViewFactory {
    private final BinaryMessenger binaryMessenger;
    private final GoogleMapInitializer googleMapInitializer;
    private final LifecycleProvider lifecycleProvider;

    /* JADX INFO: Access modifiers changed from: package-private */
    public GoogleMapFactory(BinaryMessenger binaryMessenger, Context context, LifecycleProvider lifecycleProvider) {
        super(StandardMessageCodec.INSTANCE);
        this.binaryMessenger = binaryMessenger;
        this.lifecycleProvider = lifecycleProvider;
        this.googleMapInitializer = new GoogleMapInitializer(context, binaryMessenger);
    }

    @Override // io.flutter.plugin.platform.PlatformViewFactory
    public PlatformView create(Context context, int id, Object args) {
        Map<String, Object> params = (Map) args;
        GoogleMapBuilder builder = new GoogleMapBuilder();
        Object options = params.get("options");
        Convert.interpretGoogleMapOptions(options, builder);
        if (params.containsKey("initialCameraPosition")) {
            CameraPosition position = Convert.toCameraPosition(params.get("initialCameraPosition"));
            builder.setInitialCameraPosition(position);
        }
        if (params.containsKey("clusterManagersToAdd")) {
            builder.setInitialClusterManagers(params.get("clusterManagersToAdd"));
        }
        if (params.containsKey("markersToAdd")) {
            builder.setInitialMarkers(params.get("markersToAdd"));
        }
        if (params.containsKey("polygonsToAdd")) {
            builder.setInitialPolygons(params.get("polygonsToAdd"));
        }
        if (params.containsKey("polylinesToAdd")) {
            builder.setInitialPolylines(params.get("polylinesToAdd"));
        }
        if (params.containsKey("circlesToAdd")) {
            builder.setInitialCircles(params.get("circlesToAdd"));
        }
        if (params.containsKey("tileOverlaysToAdd")) {
            builder.setInitialTileOverlays((List) params.get("tileOverlaysToAdd"));
        }
        Object cloudMapId = ((Map) options).get("cloudMapId");
        if (cloudMapId != null) {
            builder.setMapId((String) cloudMapId);
        }
        return builder.build(id, context, this.binaryMessenger, this.lifecycleProvider);
    }
}
