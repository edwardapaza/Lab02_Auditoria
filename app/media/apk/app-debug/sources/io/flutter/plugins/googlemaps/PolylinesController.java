package io.flutter.plugins.googlemaps;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;
import io.flutter.plugin.common.MethodChannel;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class PolylinesController {
    private final float density;
    private GoogleMap googleMap;
    private final MethodChannel methodChannel;
    private final Map<String, PolylineController> polylineIdToController = new HashMap();
    private final Map<String, String> googleMapsPolylineIdToDartPolylineId = new HashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    public PolylinesController(MethodChannel methodChannel, float density) {
        this.methodChannel = methodChannel;
        this.density = density;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setGoogleMap(GoogleMap googleMap) {
        this.googleMap = googleMap;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void addPolylines(List<Object> polylinesToAdd) {
        if (polylinesToAdd != null) {
            for (Object polylineToAdd : polylinesToAdd) {
                addPolyline(polylineToAdd);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void changePolylines(List<Object> polylinesToChange) {
        if (polylinesToChange != null) {
            for (Object polylineToChange : polylinesToChange) {
                changePolyline(polylineToChange);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void removePolylines(List<Object> polylineIdsToRemove) {
        if (polylineIdsToRemove == null) {
            return;
        }
        for (Object rawPolylineId : polylineIdsToRemove) {
            if (rawPolylineId != null) {
                String polylineId = (String) rawPolylineId;
                PolylineController polylineController = this.polylineIdToController.remove(polylineId);
                if (polylineController != null) {
                    polylineController.remove();
                    this.googleMapsPolylineIdToDartPolylineId.remove(polylineController.getGoogleMapsPolylineId());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean onPolylineTap(String googlePolylineId) {
        String polylineId = this.googleMapsPolylineIdToDartPolylineId.get(googlePolylineId);
        if (polylineId == null) {
            return false;
        }
        this.methodChannel.invokeMethod("polyline#onTap", Convert.polylineIdToJson(polylineId));
        PolylineController polylineController = this.polylineIdToController.get(polylineId);
        if (polylineController == null) {
            return false;
        }
        return polylineController.consumeTapEvents();
    }

    private void addPolyline(Object polyline) {
        if (polyline == null) {
            return;
        }
        PolylineBuilder polylineBuilder = new PolylineBuilder(this.density);
        String polylineId = Convert.interpretPolylineOptions(polyline, polylineBuilder);
        PolylineOptions options = polylineBuilder.build();
        addPolyline(polylineId, options, polylineBuilder.consumeTapEvents());
    }

    private void addPolyline(String polylineId, PolylineOptions polylineOptions, boolean consumeTapEvents) {
        Polyline polyline = this.googleMap.addPolyline(polylineOptions);
        PolylineController controller = new PolylineController(polyline, consumeTapEvents, this.density);
        this.polylineIdToController.put(polylineId, controller);
        this.googleMapsPolylineIdToDartPolylineId.put(polyline.getId(), polylineId);
    }

    private void changePolyline(Object polyline) {
        if (polyline == null) {
            return;
        }
        String polylineId = getPolylineId(polyline);
        PolylineController polylineController = this.polylineIdToController.get(polylineId);
        if (polylineController != null) {
            Convert.interpretPolylineOptions(polyline, polylineController);
        }
    }

    private static String getPolylineId(Object polyline) {
        Map<String, Object> polylineMap = (Map) polyline;
        return (String) polylineMap.get("polylineId");
    }
}
