package io.flutter.embedding.engine;

import android.view.Surface;
/* loaded from: classes.dex */
public class FlutterOverlaySurface {
    private final int id;
    private final Surface surface;

    public FlutterOverlaySurface(int i5, Surface surface) {
        this.id = i5;
        this.surface = surface;
    }

    public int getId() {
        return this.id;
    }

    public Surface getSurface() {
        return this.surface;
    }
}
