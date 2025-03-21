package io.flutter.embedding.android;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.TextureView;
import io.flutter.embedding.engine.renderer.FlutterRenderer;
/* loaded from: classes.dex */
public class n extends TextureView implements io.flutter.embedding.engine.renderer.e {

    /* renamed from: a  reason: collision with root package name */
    private boolean f3714a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f3715b;

    /* renamed from: c  reason: collision with root package name */
    private FlutterRenderer f3716c;

    /* renamed from: d  reason: collision with root package name */
    private Surface f3717d;

    /* renamed from: e  reason: collision with root package name */
    private final TextureView.SurfaceTextureListener f3718e;

    /* loaded from: classes.dex */
    class a implements TextureView.SurfaceTextureListener {
        a() {
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i5, int i6) {
            n2.b.f("FlutterTextureView", "SurfaceTextureListener.onSurfaceTextureAvailable()");
            n.this.f3714a = true;
            if (n.this.q()) {
                n.this.m();
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            n2.b.f("FlutterTextureView", "SurfaceTextureListener.onSurfaceTextureDestroyed()");
            n.this.f3714a = false;
            if (n.this.q()) {
                n.this.n();
            }
            if (n.this.f3717d != null) {
                n.this.f3717d.release();
                n.this.f3717d = null;
                return true;
            }
            return true;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i5, int i6) {
            n2.b.f("FlutterTextureView", "SurfaceTextureListener.onSurfaceTextureSizeChanged()");
            if (n.this.q()) {
                n.this.l(i5, i6);
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }
    }

    public n(Context context) {
        this(context, null);
    }

    public n(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3714a = false;
        this.f3715b = false;
        this.f3718e = new a();
        o();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(int i5, int i6) {
        if (this.f3716c == null) {
            throw new IllegalStateException("changeSurfaceSize() should only be called when flutterRenderer is non-null.");
        }
        n2.b.f("FlutterTextureView", "Notifying FlutterRenderer that Android surface size has changed to " + i5 + " x " + i6);
        this.f3716c.B(i5, i6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        if (this.f3716c == null || getSurfaceTexture() == null) {
            throw new IllegalStateException("connectSurfaceToRenderer() should only be called when flutterRenderer and getSurfaceTexture() are non-null.");
        }
        Surface surface = this.f3717d;
        if (surface != null) {
            surface.release();
            this.f3717d = null;
        }
        Surface surface2 = new Surface(getSurfaceTexture());
        this.f3717d = surface2;
        this.f3716c.z(surface2, this.f3715b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        FlutterRenderer flutterRenderer = this.f3716c;
        if (flutterRenderer == null) {
            throw new IllegalStateException("disconnectSurfaceFromRenderer() should only be called when flutterRenderer is non-null.");
        }
        flutterRenderer.A();
        Surface surface = this.f3717d;
        if (surface != null) {
            surface.release();
            this.f3717d = null;
        }
    }

    private void o() {
        setSurfaceTextureListener(this.f3718e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean q() {
        return (this.f3716c == null || this.f3715b) ? false : true;
    }

    @Override // io.flutter.embedding.engine.renderer.e
    public void a() {
        if (this.f3716c == null) {
            n2.b.g("FlutterTextureView", "detachFromRenderer() invoked when no FlutterRenderer was attached.");
            return;
        }
        if (getWindowToken() != null) {
            n2.b.f("FlutterTextureView", "Disconnecting FlutterRenderer from Android surface.");
            n();
        }
        this.f3716c = null;
    }

    @Override // io.flutter.embedding.engine.renderer.e
    public void b() {
        if (this.f3716c == null) {
            n2.b.g("FlutterTextureView", "resume() invoked when no FlutterRenderer was attached.");
            return;
        }
        if (p()) {
            n2.b.f("FlutterTextureView", "Surface is available for rendering. Connecting FlutterRenderer to Android surface.");
            m();
        }
        this.f3715b = false;
    }

    @Override // io.flutter.embedding.engine.renderer.e
    public void c(FlutterRenderer flutterRenderer) {
        n2.b.f("FlutterTextureView", "Attaching to FlutterRenderer.");
        if (this.f3716c != null) {
            n2.b.f("FlutterTextureView", "Already connected to a FlutterRenderer. Detaching from old one and attaching to new one.");
            this.f3716c.A();
        }
        this.f3716c = flutterRenderer;
        b();
    }

    @Override // io.flutter.embedding.engine.renderer.e
    public void d() {
        if (this.f3716c == null) {
            n2.b.g("FlutterTextureView", "pause() invoked when no FlutterRenderer was attached.");
        } else {
            this.f3715b = true;
        }
    }

    @Override // io.flutter.embedding.engine.renderer.e
    public FlutterRenderer getAttachedRenderer() {
        return this.f3716c;
    }

    boolean p() {
        return this.f3714a;
    }

    public void setRenderSurface(Surface surface) {
        this.f3717d = surface;
    }
}
