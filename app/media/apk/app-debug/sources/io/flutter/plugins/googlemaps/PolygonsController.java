package io.flutter.plugins.googlemaps;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Polygon;
import com.google.android.gms.maps.model.PolygonOptions;
import io.flutter.plugin.common.MethodChannel;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class PolygonsController {
    private final float density;
    private GoogleMap googleMap;
    private final MethodChannel methodChannel;
    private final Map<String, PolygonController> polygonIdToController = new HashMap();
    private final Map<String, String> googleMapsPolygonIdToDartPolygonId = new HashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    public PolygonsController(MethodChannel methodChannel, float density) {
        this.methodChannel = methodChannel;
        this.density = density;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setGoogleMap(GoogleMap googleMap) {
        this.googleMap = googleMap;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void addPolygons(List<Object> polygonsToAdd) {
        if (polygonsToAdd != null) {
            for (Object polygonToAdd : polygonsToAdd) {
                addPolygon(polygonToAdd);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void changePolygons(List<Object> polygonsToChange) {
        if (polygonsToChange != null) {
            for (Object polygonToChange : polygonsToChange) {
                changePolygon(polygonToChange);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void removePolygons(List<Object> polygonIdsToRemove) {
        if (polygonIdsToRemove == null) {
            return;
        }
        for (Object rawPolygonId : polygonIdsToRemove) {
            if (rawPolygonId != null) {
                String polygonId = (String) rawPolygonId;
                PolygonController polygonController = this.polygonIdToController.remove(polygonId);
                if (polygonController != null) {
                    polygonController.remove();
                    this.googleMapsPolygonIdToDartPolygonId.remove(polygonController.getGoogleMapsPolygonId());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean onPolygonTap(String googlePolygonId) {
        String polygonId = this.googleMapsPolygonIdToDartPolygonId.get(googlePolygonId);
        if (polygonId == null) {
            return false;
        }
        this.methodChannel.invokeMethod("polygon#onTap", Convert.polygonIdToJson(polygonId));
        PolygonController polygonController = this.polygonIdToController.get(polygonId);
        if (polygonController == null) {
            return false;
        }
        return polygonController.consumeTapEvents();
    }

    private void addPolygon(Object polygon) {
        if (polygon == null) {
            return;
        }
        PolygonBuilder polygonBuilder = new PolygonBuilder(this.density);
        String polygonId = Convert.interpretPolygonOptions(polygon, polygonBuilder);
        PolygonOptions options = polygonBuilder.build();
        addPolygon(polygonId, options, polygonBuilder.consumeTapEvents());
    }

    private void addPolygon(String polygonId, PolygonOptions polygonOptions, boolean consumeTapEvents) {
        Polygon polygon = this.googleMap.addPolygon(polygonOptions);
        PolygonController controller = new PolygonController(polygon, consumeTapEvents, this.density);
        this.polygonIdToController.put(polygonId, controller);
        this.googleMapsPolygonIdToDartPolygonId.put(polygon.getId(), polygonId);
    }

    private void changePolygon(Object polygon) {
        if (polygon == null) {
            return;
        }
        String polygonId = getPolygonId(polygon);
        PolygonController polygonController = this.polygonIdToController.get(polygonId);
        if (polygonController != null) {
            Convert.interpretPolygonOptions(polygon, polygonController);
        }
    }

    private static String getPolygonId(Object polygon) {
        Map<String, Object> polygonMap = (Map) polygon;
        return (String) polygonMap.get("polygonId");
    }
}
