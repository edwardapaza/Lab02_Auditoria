package io.flutter.plugins.googlemaps;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.TileOverlay;
import com.google.android.gms.maps.model.TileOverlayOptions;
import io.flutter.plugin.common.MethodChannel;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class TileOverlaysController {
    private GoogleMap googleMap;
    private final MethodChannel methodChannel;
    private final Map<String, TileOverlayController> tileOverlayIdToController = new HashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    public TileOverlaysController(MethodChannel methodChannel) {
        this.methodChannel = methodChannel;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setGoogleMap(GoogleMap googleMap) {
        this.googleMap = googleMap;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void addTileOverlays(List<Map<String, ?>> tileOverlaysToAdd) {
        if (tileOverlaysToAdd == null) {
            return;
        }
        for (Map<String, ?> tileOverlayToAdd : tileOverlaysToAdd) {
            addTileOverlay(tileOverlayToAdd);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void changeTileOverlays(List<Map<String, ?>> tileOverlaysToChange) {
        if (tileOverlaysToChange == null) {
            return;
        }
        for (Map<String, ?> tileOverlayToChange : tileOverlaysToChange) {
            changeTileOverlay(tileOverlayToChange);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void removeTileOverlays(List<String> tileOverlayIdsToRemove) {
        if (tileOverlayIdsToRemove == null) {
            return;
        }
        for (String tileOverlayId : tileOverlayIdsToRemove) {
            if (tileOverlayId != null) {
                removeTileOverlay(tileOverlayId);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void clearTileCache(String tileOverlayId) {
        TileOverlayController tileOverlayController;
        if (tileOverlayId != null && (tileOverlayController = this.tileOverlayIdToController.get(tileOverlayId)) != null) {
            tileOverlayController.clearTileCache();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Map<String, Object> getTileOverlayInfo(String tileOverlayId) {
        TileOverlayController tileOverlayController;
        if (tileOverlayId == null || (tileOverlayController = this.tileOverlayIdToController.get(tileOverlayId)) == null) {
            return null;
        }
        return tileOverlayController.getTileOverlayInfo();
    }

    private void addTileOverlay(Map<String, ?> tileOverlayOptions) {
        if (tileOverlayOptions == null) {
            return;
        }
        TileOverlayBuilder tileOverlayOptionsBuilder = new TileOverlayBuilder();
        String tileOverlayId = Convert.interpretTileOverlayOptions(tileOverlayOptions, tileOverlayOptionsBuilder);
        TileProviderController tileProviderController = new TileProviderController(this.methodChannel, tileOverlayId);
        tileOverlayOptionsBuilder.setTileProvider(tileProviderController);
        TileOverlayOptions options = tileOverlayOptionsBuilder.build();
        TileOverlay tileOverlay = this.googleMap.addTileOverlay(options);
        TileOverlayController tileOverlayController = new TileOverlayController(tileOverlay);
        this.tileOverlayIdToController.put(tileOverlayId, tileOverlayController);
    }

    private void changeTileOverlay(Map<String, ?> tileOverlayOptions) {
        if (tileOverlayOptions == null) {
            return;
        }
        String tileOverlayId = getTileOverlayId(tileOverlayOptions);
        TileOverlayController tileOverlayController = this.tileOverlayIdToController.get(tileOverlayId);
        if (tileOverlayController != null) {
            Convert.interpretTileOverlayOptions(tileOverlayOptions, tileOverlayController);
        }
    }

    private void removeTileOverlay(String tileOverlayId) {
        TileOverlayController tileOverlayController = this.tileOverlayIdToController.get(tileOverlayId);
        if (tileOverlayController != null) {
            tileOverlayController.remove();
            this.tileOverlayIdToController.remove(tileOverlayId);
        }
    }

    private static String getTileOverlayId(Map<String, ?> tileOverlay) {
        return (String) tileOverlay.get("tileOverlayId");
    }
}
