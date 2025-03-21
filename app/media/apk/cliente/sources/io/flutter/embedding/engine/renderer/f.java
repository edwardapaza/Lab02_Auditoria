package io.flutter.embedding.engine.renderer;

import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.view.Surface;
import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.embedding.engine.renderer.FlutterRenderer;
import io.flutter.view.TextureRegistry;
/* loaded from: classes.dex */
final class f implements TextureRegistry.SurfaceProducer, TextureRegistry.GLTextureConsumer {

    /* renamed from: a  reason: collision with root package name */
    private final long f3917a;

    /* renamed from: b  reason: collision with root package name */
    private int f3918b;

    /* renamed from: c  reason: collision with root package name */
    private int f3919c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f3920d;

    /* renamed from: e  reason: collision with root package name */
    private Surface f3921e;

    /* renamed from: f  reason: collision with root package name */
    private final TextureRegistry.SurfaceTextureEntry f3922f;

    /* renamed from: g  reason: collision with root package name */
    private final Handler f3923g;

    /* renamed from: h  reason: collision with root package name */
    private final FlutterJNI f3924h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(long j5, Handler handler, FlutterJNI flutterJNI, TextureRegistry.SurfaceTextureEntry surfaceTextureEntry) {
        this.f3917a = j5;
        this.f3923g = handler;
        this.f3924h = flutterJNI;
        this.f3922f = surfaceTextureEntry;
    }

    protected void finalize() {
        try {
            if (this.f3920d) {
                return;
            }
            release();
            this.f3923g.post(new FlutterRenderer.g(this.f3917a, this.f3924h));
        } finally {
            super.finalize();
        }
    }

    @Override // io.flutter.view.TextureRegistry.SurfaceProducer
    public int getHeight() {
        return this.f3919c;
    }

    @Override // io.flutter.view.TextureRegistry.SurfaceProducer
    public Surface getSurface() {
        if (this.f3921e == null) {
            this.f3921e = new Surface(this.f3922f.surfaceTexture());
        }
        return this.f3921e;
    }

    @Override // io.flutter.view.TextureRegistry.GLTextureConsumer
    public SurfaceTexture getSurfaceTexture() {
        return this.f3922f.surfaceTexture();
    }

    @Override // io.flutter.view.TextureRegistry.SurfaceProducer
    public int getWidth() {
        return this.f3918b;
    }

    @Override // io.flutter.view.TextureRegistry.SurfaceProducer
    public long id() {
        return this.f3917a;
    }

    @Override // io.flutter.view.TextureRegistry.SurfaceProducer
    public void release() {
        this.f3922f.release();
        this.f3920d = true;
    }

    @Override // io.flutter.view.TextureRegistry.SurfaceProducer
    public void scheduleFrame() {
        this.f3924h.markTextureFrameAvailable(this.f3917a);
    }

    @Override // io.flutter.view.TextureRegistry.SurfaceProducer
    public void setCallback(TextureRegistry.SurfaceProducer.a aVar) {
    }

    @Override // io.flutter.view.TextureRegistry.SurfaceProducer
    public void setSize(int i5, int i6) {
        this.f3918b = i5;
        this.f3919c = i6;
        getSurfaceTexture().setDefaultBufferSize(i5, i6);
    }
}
