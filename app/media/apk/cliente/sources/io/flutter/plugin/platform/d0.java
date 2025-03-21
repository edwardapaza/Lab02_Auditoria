package io.flutter.plugin.platform;

import android.view.Surface;
import io.flutter.view.TextureRegistry;
/* loaded from: classes.dex */
public class d0 implements n {

    /* renamed from: a  reason: collision with root package name */
    private TextureRegistry.SurfaceProducer f4014a;

    public d0(TextureRegistry.SurfaceProducer surfaceProducer) {
        this.f4014a = surfaceProducer;
    }

    @Override // io.flutter.plugin.platform.n
    public void a(int i5, int i6) {
        this.f4014a.setSize(i5, i6);
    }

    @Override // io.flutter.plugin.platform.n
    public int getHeight() {
        return this.f4014a.getHeight();
    }

    @Override // io.flutter.plugin.platform.n
    public long getId() {
        return this.f4014a.id();
    }

    @Override // io.flutter.plugin.platform.n
    public Surface getSurface() {
        return this.f4014a.getSurface();
    }

    @Override // io.flutter.plugin.platform.n
    public int getWidth() {
        return this.f4014a.getWidth();
    }

    @Override // io.flutter.plugin.platform.n
    public void release() {
        this.f4014a.release();
        this.f4014a = null;
    }

    @Override // io.flutter.plugin.platform.n
    public void scheduleFrame() {
        this.f4014a.scheduleFrame();
    }
}
