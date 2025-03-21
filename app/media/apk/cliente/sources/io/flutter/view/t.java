package io.flutter.view;

import android.hardware.display.DisplayManager;
import android.view.Choreographer;
import io.flutter.embedding.engine.FlutterJNI;
import java.util.Objects;
/* loaded from: classes.dex */
public class t {

    /* renamed from: e  reason: collision with root package name */
    private static t f4324e;

    /* renamed from: f  reason: collision with root package name */
    private static b f4325f;

    /* renamed from: b  reason: collision with root package name */
    private FlutterJNI f4327b;

    /* renamed from: a  reason: collision with root package name */
    private long f4326a = -1;

    /* renamed from: c  reason: collision with root package name */
    private c f4328c = new c(0);

    /* renamed from: d  reason: collision with root package name */
    private final FlutterJNI.b f4329d = new a();

    /* loaded from: classes.dex */
    class a implements FlutterJNI.b {
        a() {
        }

        private Choreographer.FrameCallback b(long j5) {
            if (t.this.f4328c != null) {
                t.this.f4328c.f4333a = j5;
                c cVar = t.this.f4328c;
                t.this.f4328c = null;
                return cVar;
            }
            return new c(j5);
        }

        @Override // io.flutter.embedding.engine.FlutterJNI.b
        public void a(long j5) {
            Choreographer.getInstance().postFrameCallback(b(j5));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b implements DisplayManager.DisplayListener {

        /* renamed from: a  reason: collision with root package name */
        private DisplayManager f4331a;

        b(DisplayManager displayManager) {
            this.f4331a = displayManager;
        }

        void a() {
            this.f4331a.registerDisplayListener(this, null);
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayAdded(int i5) {
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayChanged(int i5) {
            if (i5 == 0) {
                float refreshRate = this.f4331a.getDisplay(0).getRefreshRate();
                t.this.f4326a = (long) (1.0E9d / refreshRate);
                t.this.f4327b.setRefreshRateFPS(refreshRate);
            }
        }

        @Override // android.hardware.display.DisplayManager.DisplayListener
        public void onDisplayRemoved(int i5) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class c implements Choreographer.FrameCallback {

        /* renamed from: a  reason: collision with root package name */
        private long f4333a;

        c(long j5) {
            this.f4333a = j5;
        }

        @Override // android.view.Choreographer.FrameCallback
        public void doFrame(long j5) {
            long nanoTime = System.nanoTime() - j5;
            t.this.f4327b.onVsync(nanoTime < 0 ? 0L : nanoTime, t.this.f4326a, this.f4333a);
            t.this.f4328c = this;
        }
    }

    private t(FlutterJNI flutterJNI) {
        this.f4327b = flutterJNI;
    }

    public static t f(DisplayManager displayManager, FlutterJNI flutterJNI) {
        if (f4324e == null) {
            f4324e = new t(flutterJNI);
        }
        if (f4325f == null) {
            t tVar = f4324e;
            Objects.requireNonNull(tVar);
            b bVar = new b(displayManager);
            f4325f = bVar;
            bVar.a();
        }
        if (f4324e.f4326a == -1) {
            float refreshRate = displayManager.getDisplay(0).getRefreshRate();
            f4324e.f4326a = (long) (1.0E9d / refreshRate);
            flutterJNI.setRefreshRateFPS(refreshRate);
        }
        return f4324e;
    }

    public void g() {
        this.f4327b.setAsyncWaitForVsyncDelegate(this.f4329d);
    }
}
