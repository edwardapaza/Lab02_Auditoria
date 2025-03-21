package io.flutter.plugins.googlemaps;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.maps.android.collections.MarkerManager;
import io.flutter.plugin.common.MethodChannel;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class MarkersController {
    private final ClusterManagersController clusterManagersController;
    private MarkerManager.Collection markerCollection;
    private final MethodChannel methodChannel;
    private final HashMap<String, MarkerBuilder> markerIdToMarkerBuilder = new HashMap<>();
    private final HashMap<String, MarkerController> markerIdToController = new HashMap<>();
    private final HashMap<String, String> googleMapsMarkerIdToDartMarkerId = new HashMap<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    public MarkersController(MethodChannel methodChannel, ClusterManagersController clusterManagersController) {
        this.methodChannel = methodChannel;
        this.clusterManagersController = clusterManagersController;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setCollection(MarkerManager.Collection markerCollection) {
        this.markerCollection = markerCollection;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void addMarkers(List<Object> markersToAdd) {
        if (markersToAdd != null) {
            for (Object markerToAdd : markersToAdd) {
                addMarker(markerToAdd);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void changeMarkers(List<Object> markersToChange) {
        if (markersToChange != null) {
            for (Object markerToChange : markersToChange) {
                changeMarker(markerToChange);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void removeMarkers(List<Object> markerIdsToRemove) {
        if (markerIdsToRemove == null) {
            return;
        }
        for (Object rawMarkerId : markerIdsToRemove) {
            if (rawMarkerId != null) {
                String markerId = (String) rawMarkerId;
                removeMarker(markerId);
            }
        }
    }

    private void removeMarker(String markerId) {
        MarkerManager.Collection collection;
        MarkerBuilder markerBuilder = this.markerIdToMarkerBuilder.remove(markerId);
        if (markerBuilder == null) {
            return;
        }
        MarkerController markerController = this.markerIdToController.remove(markerId);
        String clusterManagerId = markerBuilder.clusterManagerId();
        if (clusterManagerId != null) {
            this.clusterManagersController.removeItem(markerBuilder);
        } else if (markerController != null && (collection = this.markerCollection) != null) {
            markerController.removeFromCollection(collection);
        }
        if (markerController != null) {
            this.googleMapsMarkerIdToDartMarkerId.remove(markerController.getGoogleMapsMarkerId());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void showMarkerInfoWindow(String markerId, MethodChannel.Result result) {
        MarkerController markerController = this.markerIdToController.get(markerId);
        if (markerController == null) {
            result.error("Invalid markerId", "showInfoWindow called with invalid markerId", null);
            return;
        }
        markerController.showInfoWindow();
        result.success(null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void hideMarkerInfoWindow(String markerId, MethodChannel.Result result) {
        MarkerController markerController = this.markerIdToController.get(markerId);
        if (markerController == null) {
            result.error("Invalid markerId", "hideInfoWindow called with invalid markerId", null);
            return;
        }
        markerController.hideInfoWindow();
        result.success(null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void isInfoWindowShown(String markerId, MethodChannel.Result result) {
        MarkerController markerController = this.markerIdToController.get(markerId);
        if (markerController != null) {
            result.success(Boolean.valueOf(markerController.isInfoWindowShown()));
        } else {
            result.error("Invalid markerId", "isInfoWindowShown called with invalid markerId", null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean onMapsMarkerTap(String googleMarkerId) {
        String markerId = this.googleMapsMarkerIdToDartMarkerId.get(googleMarkerId);
        if (markerId == null) {
            return false;
        }
        return onMarkerTap(markerId);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean onMarkerTap(String markerId) {
        this.methodChannel.invokeMethod("marker#onTap", Convert.markerIdToJson(markerId));
        MarkerController markerController = this.markerIdToController.get(markerId);
        if (markerController != null) {
            return markerController.consumeTapEvents();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onMarkerDragStart(String googleMarkerId, LatLng latLng) {
        Object markerId = (String) this.googleMapsMarkerIdToDartMarkerId.get(googleMarkerId);
        if (markerId == null) {
            return;
        }
        Map<String, Object> data = new HashMap<>();
        data.put("markerId", markerId);
        data.put("position", Convert.latLngToJson(latLng));
        this.methodChannel.invokeMethod("marker#onDragStart", data);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onMarkerDrag(String googleMarkerId, LatLng latLng) {
        Object markerId = (String) this.googleMapsMarkerIdToDartMarkerId.get(googleMarkerId);
        if (markerId == null) {
            return;
        }
        Map<String, Object> data = new HashMap<>();
        data.put("markerId", markerId);
        data.put("position", Convert.latLngToJson(latLng));
        this.methodChannel.invokeMethod("marker#onDrag", data);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onMarkerDragEnd(String googleMarkerId, LatLng latLng) {
        Object markerId = (String) this.googleMapsMarkerIdToDartMarkerId.get(googleMarkerId);
        if (markerId == null) {
            return;
        }
        Map<String, Object> data = new HashMap<>();
        data.put("markerId", markerId);
        data.put("position", Convert.latLngToJson(latLng));
        this.methodChannel.invokeMethod("marker#onDragEnd", data);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onInfoWindowTap(String googleMarkerId) {
        String markerId = this.googleMapsMarkerIdToDartMarkerId.get(googleMarkerId);
        if (markerId == null) {
            return;
        }
        this.methodChannel.invokeMethod("infoWindow#onTap", Convert.markerIdToJson(markerId));
    }

    public void onClusterItemRendered(MarkerBuilder markerBuilder, Marker marker) {
        String markerId = markerBuilder.markerId();
        if (this.markerIdToMarkerBuilder.get(markerId) == markerBuilder) {
            createControllerForMarker(markerBuilder.markerId(), marker, markerBuilder.consumeTapEvents());
        }
    }

    private void addMarker(Object marker) {
        if (marker == null) {
            return;
        }
        String markerId = getMarkerId(marker);
        if (markerId == null) {
            throw new IllegalArgumentException("markerId was null");
        }
        String clusterManagerId = getClusterManagerId(marker);
        MarkerBuilder markerBuilder = new MarkerBuilder(markerId, clusterManagerId);
        Convert.interpretMarkerOptions(marker, markerBuilder);
        addMarker(markerBuilder);
    }

    private void addMarker(MarkerBuilder markerBuilder) {
        if (markerBuilder == null) {
            return;
        }
        String markerId = markerBuilder.markerId();
        this.markerIdToMarkerBuilder.put(markerId, markerBuilder);
        if (markerBuilder.clusterManagerId() == null) {
            addMarkerToCollection(markerId, markerBuilder);
        } else {
            addMarkerBuilderForCluster(markerBuilder);
        }
    }

    private void addMarkerToCollection(String markerId, MarkerBuilder markerBuilder) {
        MarkerOptions options = markerBuilder.build();
        Marker marker = this.markerCollection.addMarker(options);
        createControllerForMarker(markerId, marker, markerBuilder.consumeTapEvents());
    }

    private void addMarkerBuilderForCluster(MarkerBuilder markerBuilder) {
        this.clusterManagersController.addItem(markerBuilder);
    }

    private void createControllerForMarker(String markerId, Marker marker, boolean consumeTapEvents) {
        MarkerController controller = new MarkerController(marker, consumeTapEvents);
        this.markerIdToController.put(markerId, controller);
        this.googleMapsMarkerIdToDartMarkerId.put(marker.getId(), markerId);
    }

    private void changeMarker(Object marker) {
        String markerId;
        MarkerBuilder markerBuilder;
        if (marker == null || (markerBuilder = this.markerIdToMarkerBuilder.get((markerId = getMarkerId(marker)))) == null) {
            return;
        }
        String clusterManagerId = getClusterManagerId(marker);
        String oldClusterManagerId = markerBuilder.clusterManagerId();
        if (!Objects.equals(clusterManagerId, oldClusterManagerId)) {
            removeMarker(markerId);
            addMarker(marker);
            return;
        }
        Convert.interpretMarkerOptions(marker, markerBuilder);
        MarkerController markerController = this.markerIdToController.get(markerId);
        if (markerController != null) {
            Convert.interpretMarkerOptions(marker, markerController);
        }
    }

    private static String getMarkerId(Object marker) {
        Map<String, Object> markerMap = (Map) marker;
        return (String) markerMap.get("markerId");
    }

    private static String getClusterManagerId(Object marker) {
        Map<String, Object> markerMap = (Map) marker;
        return (String) markerMap.get("clusterManagerId");
    }
}
