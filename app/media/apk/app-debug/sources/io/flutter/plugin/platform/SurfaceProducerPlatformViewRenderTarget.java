package io.flutter.plugin.platform;

import android.graphics.Canvas;
import android.view.Surface;
import io.flutter.view.TextureRegistry;
/* loaded from: classes.dex */
public class SurfaceProducerPlatformViewRenderTarget implements PlatformViewRenderTarget {
    private static final String TAG = "SurfaceProducerRenderTarget";
    private TextureRegistry.SurfaceProducer producer;

    public SurfaceProducerPlatformViewRenderTarget(TextureRegistry.SurfaceProducer producer) {
        this.producer = producer;
    }

    @Override // io.flutter.plugin.platform.PlatformViewRenderTarget
    public void resize(int width, int height) {
        this.producer.setSize(width, height);
    }

    @Override // io.flutter.plugin.platform.PlatformViewRenderTarget
    public int getWidth() {
        return this.producer.getWidth();
    }

    @Override // io.flutter.plugin.platform.PlatformViewRenderTarget
    public int getHeight() {
        return this.producer.getHeight();
    }

    @Override // io.flutter.plugin.platform.PlatformViewRenderTarget
    public Canvas lockHardwareCanvas() {
        Surface surface = this.producer.getSurface();
        return surface.lockHardwareCanvas();
    }

    @Override // io.flutter.plugin.platform.PlatformViewRenderTarget
    public void unlockCanvasAndPost(Canvas canvas) {
        Surface surface = this.producer.getSurface();
        surface.unlockCanvasAndPost(canvas);
    }

    @Override // io.flutter.plugin.platform.PlatformViewRenderTarget
    public long getId() {
        return this.producer.id();
    }

    @Override // io.flutter.plugin.platform.PlatformViewRenderTarget
    public void release() {
        this.producer.release();
        this.producer = null;
    }

    @Override // io.flutter.plugin.platform.PlatformViewRenderTarget
    public boolean isReleased() {
        return this.producer == null;
    }

    @Override // io.flutter.plugin.platform.PlatformViewRenderTarget
    public Surface getSurface() {
        return this.producer.getSurface();
    }
}
