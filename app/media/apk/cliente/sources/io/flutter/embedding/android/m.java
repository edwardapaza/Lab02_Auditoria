package io.flutter.embedding.android;

import android.content.Context;
import android.graphics.Region;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import io.flutter.embedding.engine.renderer.FlutterRenderer;
/* loaded from: classes.dex */
public class m extends SurfaceView implements io.flutter.embedding.engine.renderer.e {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f3706a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f3707b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f3708c;

    /* renamed from: d  reason: collision with root package name */
    private FlutterRenderer f3709d;

    /* renamed from: e  reason: collision with root package name */
    private final SurfaceHolder.Callback f3710e;

    /* renamed from: f  reason: collision with root package name */
    private final io.flutter.embedding.engine.renderer.d f3711f;

    /* loaded from: classes.dex */
    class a implements SurfaceHolder.Callback {
        a() {
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceChanged(SurfaceHolder surfaceHolder, int i5, int i6, int i7) {
            n2.b.f("FlutterSurfaceView", "SurfaceHolder.Callback.surfaceChanged()");
            if (m.this.p()) {
                m.this.k(i6, i7);
            }
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            n2.b.f("FlutterSurfaceView", "SurfaceHolder.Callback.startRenderingToSurface()");
            m.this.f3707b = true;
            if (m.this.p()) {
                m.this.l();
            }
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            n2.b.f("FlutterSurfaceView", "SurfaceHolder.Callback.stopRenderingToSurface()");
            m.this.f3707b = false;
            if (m.this.p()) {
                m.this.m();
            }
        }
    }

    /* loaded from: classes.dex */
    class b implements io.flutter.embedding.engine.renderer.d {
        b() {
        }

        @Override // io.flutter.embedding.engine.renderer.d
        public void c() {
        }

        @Override // io.flutter.embedding.engine.renderer.d
        public void f() {
            n2.b.f("FlutterSurfaceView", "onFlutterUiDisplayed()");
            m.this.setAlpha(1.0f);
            if (m.this.f3709d != null) {
                m.this.f3709d.u(this);
            }
        }
    }

    private m(Context context, AttributeSet attributeSet, boolean z4) {
        super(context, attributeSet);
        this.f3707b = false;
        this.f3708c = false;
        this.f3710e = new a();
        this.f3711f = new b();
        this.f3706a = z4;
        n();
    }

    public m(Context context, boolean z4) {
        this(context, null, z4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(int i5, int i6) {
        if (this.f3709d == null) {
            throw new IllegalStateException("changeSurfaceSize() should only be called when flutterRenderer is non-null.");
        }
        n2.b.f("FlutterSurfaceView", "Notifying FlutterRenderer that Android surface size has changed to " + i5 + " x " + i6);
        this.f3709d.B(i5, i6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        if (this.f3709d == null || getHolder() == null) {
            throw new IllegalStateException("connectSurfaceToRenderer() should only be called when flutterRenderer and getHolder() are non-null.");
        }
        this.f3709d.z(getHolder().getSurface(), this.f3708c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        FlutterRenderer flutterRenderer = this.f3709d;
        if (flutterRenderer == null) {
            throw new IllegalStateException("disconnectSurfaceFromRenderer() should only be called when flutterRenderer is non-null.");
        }
        flutterRenderer.A();
    }

    private void n() {
        if (this.f3706a) {
            getHolder().setFormat(-2);
            setZOrderOnTop(true);
        }
        getHolder().addCallback(this.f3710e);
        setAlpha(0.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean p() {
        return (this.f3709d == null || this.f3708c) ? false : true;
    }

    @Override // io.flutter.embedding.engine.renderer.e
    public void a() {
        if (this.f3709d == null) {
            n2.b.g("FlutterSurfaceView", "detachFromRenderer() invoked when no FlutterRenderer was attached.");
            return;
        }
        if (getWindowToken() != null) {
            n2.b.f("FlutterSurfaceView", "Disconnecting FlutterRenderer from Android surface.");
            m();
        }
        setAlpha(0.0f);
        this.f3709d.u(this.f3711f);
        this.f3709d = null;
    }

    @Override // io.flutter.embedding.engine.renderer.e
    public void b() {
        FlutterRenderer flutterRenderer = this.f3709d;
        if (flutterRenderer == null) {
            n2.b.g("FlutterSurfaceView", "resume() invoked when no FlutterRenderer was attached.");
            return;
        }
        flutterRenderer.j(this.f3711f);
        if (o()) {
            n2.b.f("FlutterSurfaceView", "Surface is available for rendering. Connecting FlutterRenderer to Android surface.");
            l();
        }
        this.f3708c = false;
    }

    @Override // io.flutter.embedding.engine.renderer.e
    public void c(FlutterRenderer flutterRenderer) {
        n2.b.f("FlutterSurfaceView", "Attaching to FlutterRenderer.");
        if (this.f3709d != null) {
            n2.b.f("FlutterSurfaceView", "Already connected to a FlutterRenderer. Detaching from old one and attaching to new one.");
            this.f3709d.A();
            this.f3709d.u(this.f3711f);
        }
        this.f3709d = flutterRenderer;
        b();
    }

    @Override // io.flutter.embedding.engine.renderer.e
    public void d() {
        if (this.f3709d == null) {
            n2.b.g("FlutterSurfaceView", "pause() invoked when no FlutterRenderer was attached.");
        } else {
            this.f3708c = true;
        }
    }

    @Override // android.view.SurfaceView, android.view.View
    public boolean gatherTransparentRegion(Region region) {
        if (getAlpha() < 1.0f) {
            return false;
        }
        int[] iArr = new int[2];
        getLocationInWindow(iArr);
        int i5 = iArr[0];
        region.op(i5, iArr[1], (getRight() + i5) - getLeft(), (iArr[1] + getBottom()) - getTop(), Region.Op.DIFFERENCE);
        return true;
    }

    @Override // io.flutter.embedding.engine.renderer.e
    public FlutterRenderer getAttachedRenderer() {
        return this.f3709d;
    }

    boolean o() {
        return this.f3707b;
    }
}
