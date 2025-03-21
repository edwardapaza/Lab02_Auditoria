package io.flutter.plugins.googlemaps;

import com.google.android.gms.maps.model.TileOverlay;
import com.google.android.gms.maps.model.TileProvider;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
class TileOverlayController implements TileOverlaySink {
    private final TileOverlay tileOverlay;

    /* JADX INFO: Access modifiers changed from: package-private */
    public TileOverlayController(TileOverlay tileOverlay) {
        this.tileOverlay = tileOverlay;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void remove() {
        this.tileOverlay.remove();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void clearTileCache() {
        this.tileOverlay.clearTileCache();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Map<String, Object> getTileOverlayInfo() {
        Map<String, Object> tileOverlayInfo = new HashMap<>();
        tileOverlayInfo.put("fadeIn", Boolean.valueOf(this.tileOverlay.getFadeIn()));
        tileOverlayInfo.put("transparency", Float.valueOf(this.tileOverlay.getTransparency()));
        tileOverlayInfo.put("id", this.tileOverlay.getId());
        tileOverlayInfo.put("zIndex", Float.valueOf(this.tileOverlay.getZIndex()));
        tileOverlayInfo.put("visible", Boolean.valueOf(this.tileOverlay.isVisible()));
        return tileOverlayInfo;
    }

    @Override // io.flutter.plugins.googlemaps.TileOverlaySink
    public void setFadeIn(boolean fadeIn) {
        this.tileOverlay.setFadeIn(fadeIn);
    }

    @Override // io.flutter.plugins.googlemaps.TileOverlaySink
    public void setTransparency(float transparency) {
        this.tileOverlay.setTransparency(transparency);
    }

    @Override // io.flutter.plugins.googlemaps.TileOverlaySink
    public void setZIndex(float zIndex) {
        this.tileOverlay.setZIndex(zIndex);
    }

    @Override // io.flutter.plugins.googlemaps.TileOverlaySink
    public void setVisible(boolean visible) {
        this.tileOverlay.setVisible(visible);
    }

    @Override // io.flutter.plugins.googlemaps.TileOverlaySink
    public void setTileProvider(TileProvider tileProvider) {
    }
}
