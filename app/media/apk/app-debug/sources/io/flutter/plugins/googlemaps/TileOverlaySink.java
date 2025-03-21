package io.flutter.plugins.googlemaps;

import com.google.android.gms.maps.model.TileProvider;
/* loaded from: classes2.dex */
interface TileOverlaySink {
    void setFadeIn(boolean z);

    void setTileProvider(TileProvider tileProvider);

    void setTransparency(float f);

    void setVisible(boolean z);

    void setZIndex(float f);
}
