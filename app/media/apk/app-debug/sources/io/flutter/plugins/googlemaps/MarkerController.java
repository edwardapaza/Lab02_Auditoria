package io.flutter.plugins.googlemaps;

import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.maps.android.collections.MarkerManager;
import java.lang.ref.WeakReference;
/* loaded from: classes2.dex */
class MarkerController implements MarkerOptionsSink {
    private boolean consumeTapEvents;
    private final String googleMapsMarkerId;
    private final WeakReference<Marker> weakMarker;

    /* JADX INFO: Access modifiers changed from: package-private */
    public MarkerController(Marker marker, boolean consumeTapEvents) {
        this.weakMarker = new WeakReference<>(marker);
        this.consumeTapEvents = consumeTapEvents;
        this.googleMapsMarkerId = marker.getId();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void removeFromCollection(MarkerManager.Collection markerCollection) {
        Marker marker = this.weakMarker.get();
        if (marker == null) {
            return;
        }
        markerCollection.remove(marker);
    }

    @Override // io.flutter.plugins.googlemaps.MarkerOptionsSink
    public void setAlpha(float alpha) {
        Marker marker = this.weakMarker.get();
        if (marker == null) {
            return;
        }
        marker.setAlpha(alpha);
    }

    @Override // io.flutter.plugins.googlemaps.MarkerOptionsSink
    public void setAnchor(float u, float v) {
        Marker marker = this.weakMarker.get();
        if (marker == null) {
            return;
        }
        marker.setAnchor(u, v);
    }

    @Override // io.flutter.plugins.googlemaps.MarkerOptionsSink
    public void setConsumeTapEvents(boolean consumeTapEvents) {
        Marker marker = this.weakMarker.get();
        if (marker == null) {
            return;
        }
        this.consumeTapEvents = consumeTapEvents;
    }

    @Override // io.flutter.plugins.googlemaps.MarkerOptionsSink
    public void setDraggable(boolean draggable) {
        Marker marker = this.weakMarker.get();
        if (marker == null) {
            return;
        }
        marker.setDraggable(draggable);
    }

    @Override // io.flutter.plugins.googlemaps.MarkerOptionsSink
    public void setFlat(boolean flat) {
        Marker marker = this.weakMarker.get();
        if (marker == null) {
            return;
        }
        marker.setFlat(flat);
    }

    @Override // io.flutter.plugins.googlemaps.MarkerOptionsSink
    public void setIcon(BitmapDescriptor bitmapDescriptor) {
        Marker marker = this.weakMarker.get();
        if (marker == null) {
            return;
        }
        marker.setIcon(bitmapDescriptor);
    }

    @Override // io.flutter.plugins.googlemaps.MarkerOptionsSink
    public void setInfoWindowAnchor(float u, float v) {
        Marker marker = this.weakMarker.get();
        if (marker == null) {
            return;
        }
        marker.setInfoWindowAnchor(u, v);
    }

    @Override // io.flutter.plugins.googlemaps.MarkerOptionsSink
    public void setInfoWindowText(String title, String snippet) {
        Marker marker = this.weakMarker.get();
        if (marker == null) {
            return;
        }
        marker.setTitle(title);
        marker.setSnippet(snippet);
    }

    @Override // io.flutter.plugins.googlemaps.MarkerOptionsSink
    public void setPosition(LatLng position) {
        Marker marker = this.weakMarker.get();
        if (marker == null) {
            return;
        }
        marker.setPosition(position);
    }

    @Override // io.flutter.plugins.googlemaps.MarkerOptionsSink
    public void setRotation(float rotation) {
        Marker marker = this.weakMarker.get();
        if (marker == null) {
            return;
        }
        marker.setRotation(rotation);
    }

    @Override // io.flutter.plugins.googlemaps.MarkerOptionsSink
    public void setVisible(boolean visible) {
        Marker marker = this.weakMarker.get();
        if (marker == null) {
            return;
        }
        marker.setVisible(visible);
    }

    @Override // io.flutter.plugins.googlemaps.MarkerOptionsSink
    public void setZIndex(float zIndex) {
        Marker marker = this.weakMarker.get();
        if (marker == null) {
            return;
        }
        marker.setZIndex(zIndex);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getGoogleMapsMarkerId() {
        return this.googleMapsMarkerId;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean consumeTapEvents() {
        return this.consumeTapEvents;
    }

    public void showInfoWindow() {
        Marker marker = this.weakMarker.get();
        if (marker == null) {
            return;
        }
        marker.showInfoWindow();
    }

    public void hideInfoWindow() {
        Marker marker = this.weakMarker.get();
        if (marker == null) {
            return;
        }
        marker.hideInfoWindow();
    }

    public boolean isInfoWindowShown() {
        Marker marker = this.weakMarker.get();
        if (marker == null) {
            return false;
        }
        return marker.isInfoWindowShown();
    }
}
