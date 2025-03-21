package io.flutter.plugins.googlemaps;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import io.flutter.plugin.common.MethodChannel;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class CirclesController {
    private final float density;
    private GoogleMap googleMap;
    private final MethodChannel methodChannel;
    private final Map<String, CircleController> circleIdToController = new HashMap();
    private final Map<String, String> googleMapsCircleIdToDartCircleId = new HashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    public CirclesController(MethodChannel methodChannel, float density) {
        this.methodChannel = methodChannel;
        this.density = density;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setGoogleMap(GoogleMap googleMap) {
        this.googleMap = googleMap;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void addCircles(List<Object> circlesToAdd) {
        if (circlesToAdd != null) {
            for (Object circleToAdd : circlesToAdd) {
                addCircle(circleToAdd);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void changeCircles(List<Object> circlesToChange) {
        if (circlesToChange != null) {
            for (Object circleToChange : circlesToChange) {
                changeCircle(circleToChange);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void removeCircles(List<Object> circleIdsToRemove) {
        if (circleIdsToRemove == null) {
            return;
        }
        for (Object rawCircleId : circleIdsToRemove) {
            if (rawCircleId != null) {
                String circleId = (String) rawCircleId;
                CircleController circleController = this.circleIdToController.remove(circleId);
                if (circleController != null) {
                    circleController.remove();
                    this.googleMapsCircleIdToDartCircleId.remove(circleController.getGoogleMapsCircleId());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean onCircleTap(String googleCircleId) {
        String circleId = this.googleMapsCircleIdToDartCircleId.get(googleCircleId);
        if (circleId == null) {
            return false;
        }
        this.methodChannel.invokeMethod("circle#onTap", Convert.circleIdToJson(circleId));
        CircleController circleController = this.circleIdToController.get(circleId);
        if (circleController == null) {
            return false;
        }
        return circleController.consumeTapEvents();
    }

    private void addCircle(Object circle) {
        if (circle == null) {
            return;
        }
        CircleBuilder circleBuilder = new CircleBuilder(this.density);
        String circleId = Convert.interpretCircleOptions(circle, circleBuilder);
        CircleOptions options = circleBuilder.build();
        addCircle(circleId, options, circleBuilder.consumeTapEvents());
    }

    private void addCircle(String circleId, CircleOptions circleOptions, boolean consumeTapEvents) {
        Circle circle = this.googleMap.addCircle(circleOptions);
        CircleController controller = new CircleController(circle, consumeTapEvents, this.density);
        this.circleIdToController.put(circleId, controller);
        this.googleMapsCircleIdToDartCircleId.put(circle.getId(), circleId);
    }

    private void changeCircle(Object circle) {
        if (circle == null) {
            return;
        }
        String circleId = getCircleId(circle);
        CircleController circleController = this.circleIdToController.get(circleId);
        if (circleController != null) {
            Convert.interpretCircleOptions(circle, circleController);
        }
    }

    private static String getCircleId(Object circle) {
        Map<String, Object> circleMap = (Map) circle;
        return (String) circleMap.get("circleId");
    }
}
