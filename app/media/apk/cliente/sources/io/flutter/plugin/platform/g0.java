package io.flutter.plugin.platform;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.hardware.display.VirtualDisplay;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import io.flutter.plugin.platform.SingleViewPresentation;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g0 {

    /* renamed from: i  reason: collision with root package name */
    private static VirtualDisplay.Callback f4035i = new a();

    /* renamed from: a  reason: collision with root package name */
    SingleViewPresentation f4036a;

    /* renamed from: b  reason: collision with root package name */
    private final Context f4037b;

    /* renamed from: c  reason: collision with root package name */
    private final io.flutter.plugin.platform.a f4038c;

    /* renamed from: d  reason: collision with root package name */
    private final int f4039d;

    /* renamed from: e  reason: collision with root package name */
    private final int f4040e;

    /* renamed from: f  reason: collision with root package name */
    private final n f4041f;

    /* renamed from: g  reason: collision with root package name */
    private final View.OnFocusChangeListener f4042g;

    /* renamed from: h  reason: collision with root package name */
    private VirtualDisplay f4043h;

    /* loaded from: classes.dex */
    class a extends VirtualDisplay.Callback {
        a() {
        }

        @Override // android.hardware.display.VirtualDisplay.Callback
        public void onPaused() {
        }

        @Override // android.hardware.display.VirtualDisplay.Callback
        public void onResumed() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b implements View.OnAttachStateChangeListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ View f4044a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Runnable f4045b;

        /* loaded from: classes.dex */
        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                b bVar = b.this;
                bVar.f4044a.postDelayed(bVar.f4045b, 128L);
            }
        }

        b(View view, Runnable runnable) {
            this.f4044a = view;
            this.f4045b = runnable;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            c.a(this.f4044a, new a());
            this.f4044a.removeOnAttachStateChangeListener(this);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }
    }

    /* loaded from: classes.dex */
    static class c implements ViewTreeObserver.OnDrawListener {

        /* renamed from: a  reason: collision with root package name */
        final View f4048a;

        /* renamed from: b  reason: collision with root package name */
        Runnable f4049b;

        /* loaded from: classes.dex */
        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                c.this.f4048a.getViewTreeObserver().removeOnDrawListener(c.this);
            }
        }

        c(View view, Runnable runnable) {
            this.f4048a = view;
            this.f4049b = runnable;
        }

        static void a(View view, Runnable runnable) {
            view.getViewTreeObserver().addOnDrawListener(new c(view, runnable));
        }

        @Override // android.view.ViewTreeObserver.OnDrawListener
        public void onDraw() {
            Runnable runnable = this.f4049b;
            if (runnable == null) {
                return;
            }
            runnable.run();
            this.f4049b = null;
            this.f4048a.post(new a());
        }
    }

    private g0(Context context, io.flutter.plugin.platform.a aVar, VirtualDisplay virtualDisplay, i iVar, n nVar, View.OnFocusChangeListener onFocusChangeListener, int i5, Object obj) {
        this.f4037b = context;
        this.f4038c = aVar;
        this.f4041f = nVar;
        this.f4042g = onFocusChangeListener;
        this.f4040e = i5;
        this.f4043h = virtualDisplay;
        this.f4039d = context.getResources().getDisplayMetrics().densityDpi;
        SingleViewPresentation singleViewPresentation = new SingleViewPresentation(context, this.f4043h.getDisplay(), iVar, aVar, i5, onFocusChangeListener);
        this.f4036a = singleViewPresentation;
        singleViewPresentation.show();
    }

    public static g0 b(Context context, io.flutter.plugin.platform.a aVar, i iVar, n nVar, int i5, int i6, int i7, Object obj, View.OnFocusChangeListener onFocusChangeListener) {
        if (i5 == 0 || i6 == 0) {
            return null;
        }
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        nVar.a(i5, i6);
        VirtualDisplay createVirtualDisplay = ((DisplayManager) context.getSystemService("display")).createVirtualDisplay("flutter-vd#" + i7, i5, i6, displayMetrics.densityDpi, nVar.getSurface(), 0, f4035i, null);
        if (createVirtualDisplay == null) {
            return null;
        }
        return new g0(context, aVar, createVirtualDisplay, iVar, nVar, onFocusChangeListener, i7, obj);
    }

    private void l(View view, int i5, int i6, Runnable runnable) {
        this.f4041f.a(i5, i6);
        this.f4043h.resize(i5, i6, this.f4039d);
        this.f4043h.setSurface(this.f4041f.getSurface());
        view.postDelayed(runnable, 0L);
    }

    public void a() {
        this.f4043h.setSurface(null);
    }

    public void c(MotionEvent motionEvent) {
        SingleViewPresentation singleViewPresentation = this.f4036a;
        if (singleViewPresentation == null) {
            return;
        }
        singleViewPresentation.dispatchTouchEvent(motionEvent);
    }

    public void d() {
        this.f4036a.cancel();
        this.f4036a.detachState();
        this.f4043h.release();
        this.f4041f.release();
    }

    public int e() {
        n nVar = this.f4041f;
        if (nVar != null) {
            return nVar.getHeight();
        }
        return 0;
    }

    public int f() {
        n nVar = this.f4041f;
        if (nVar != null) {
            return nVar.getWidth();
        }
        return 0;
    }

    public View g() {
        SingleViewPresentation singleViewPresentation = this.f4036a;
        if (singleViewPresentation == null) {
            return null;
        }
        return singleViewPresentation.getView().c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h() {
        SingleViewPresentation singleViewPresentation = this.f4036a;
        if (singleViewPresentation == null || singleViewPresentation.getView() == null) {
            return;
        }
        this.f4036a.getView().f();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i() {
        SingleViewPresentation singleViewPresentation = this.f4036a;
        if (singleViewPresentation == null || singleViewPresentation.getView() == null) {
            return;
        }
        this.f4036a.getView().b();
    }

    public void j() {
        int f5 = f();
        int e5 = e();
        boolean isFocused = g().isFocused();
        SingleViewPresentation.d detachState = this.f4036a.detachState();
        this.f4043h.setSurface(null);
        this.f4043h.release();
        this.f4043h = ((DisplayManager) this.f4037b.getSystemService("display")).createVirtualDisplay("flutter-vd#" + this.f4040e, f5, e5, this.f4039d, this.f4041f.getSurface(), 0, f4035i, null);
        SingleViewPresentation singleViewPresentation = new SingleViewPresentation(this.f4037b, this.f4043h.getDisplay(), this.f4038c, detachState, this.f4042g, isFocused);
        singleViewPresentation.show();
        this.f4036a.cancel();
        this.f4036a = singleViewPresentation;
    }

    public void k(int i5, int i6, Runnable runnable) {
        if (i5 == f() && i6 == e()) {
            g().postDelayed(runnable, 0L);
        } else if (Build.VERSION.SDK_INT >= 31) {
            l(g(), i5, i6, runnable);
        } else {
            boolean isFocused = g().isFocused();
            SingleViewPresentation.d detachState = this.f4036a.detachState();
            this.f4043h.setSurface(null);
            this.f4043h.release();
            this.f4041f.a(i5, i6);
            this.f4043h = ((DisplayManager) this.f4037b.getSystemService("display")).createVirtualDisplay("flutter-vd#" + this.f4040e, i5, i6, this.f4039d, this.f4041f.getSurface(), 0, f4035i, null);
            View g5 = g();
            g5.addOnAttachStateChangeListener(new b(g5, runnable));
            SingleViewPresentation singleViewPresentation = new SingleViewPresentation(this.f4037b, this.f4043h.getDisplay(), this.f4038c, detachState, this.f4042g, isFocused);
            singleViewPresentation.show();
            this.f4036a.cancel();
            this.f4036a = singleViewPresentation;
        }
    }
}
