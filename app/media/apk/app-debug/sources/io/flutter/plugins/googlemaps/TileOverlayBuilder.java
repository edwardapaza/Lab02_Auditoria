package io.flutter.plugins.googlemaps;

import com.google.android.gms.maps.model.TileOverlayOptions;
import com.google.android.gms.maps.model.TileProvider;
/* loaded from: classes2.dex */
class TileOverlayBuilder implements TileOverlaySink {
    private final TileOverlayOptions tileOverlayOptions = new TileOverlayOptions();

    /* JADX INFO: Access modifiers changed from: package-private */
    public TileOverlayOptions build() {
        return this.tileOverlayOptions;
    }

    @Override // io.flutter.plugins.googlemaps.TileOverlaySink
    public void setFadeIn(boolean fadeIn) {
        this.tileOverlayOptions.fadeIn(fadeIn);
    }

    @Override // io.flutter.plugins.googlemaps.TileOverlaySink
    public void setTransparency(float transparency) {
        this.tileOverlayOptions.transparency(transparency);
    }

    @Override // io.flutter.plugins.googlemaps.TileOverlaySink
    public void setZIndex(float zIndex) {
        this.tileOverlayOptions.zIndex(zIndex);
    }

    @Override // io.flutter.plugins.googlemaps.TileOverlaySink
    public void setVisible(boolean visible) {
        this.tileOverlayOptions.visible(visible);
    }

    @Override // io.flutter.plugins.googlemaps.TileOverlaySink
    public void setTileProvider(TileProvider tileProvider) {
        this.tileOverlayOptions.tileProvider(tileProvider);
    }
}
