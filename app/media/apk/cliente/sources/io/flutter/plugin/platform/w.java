package io.flutter.plugin.platform;

import android.content.Context;
import android.content.MutableContextWrapper;
import android.os.Build;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import io.flutter.embedding.android.d0;
import io.flutter.embedding.engine.FlutterOverlaySurface;
import io.flutter.embedding.engine.mutatorsstack.FlutterMutatorsStack;
import io.flutter.embedding.engine.renderer.FlutterRenderer;
import io.flutter.plugin.platform.w;
import io.flutter.view.TextureRegistry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import y2.m;
/* loaded from: classes.dex */
public class w implements q {

    /* renamed from: w  reason: collision with root package name */
    private static Class[] f4075w = {SurfaceView.class};

    /* renamed from: x  reason: collision with root package name */
    private static boolean f4076x = true;

    /* renamed from: y  reason: collision with root package name */
    private static boolean f4077y = true;

    /* renamed from: b  reason: collision with root package name */
    private io.flutter.embedding.android.c f4079b;

    /* renamed from: c  reason: collision with root package name */
    private Context f4080c;

    /* renamed from: d  reason: collision with root package name */
    private io.flutter.embedding.android.t f4081d;

    /* renamed from: e  reason: collision with root package name */
    private TextureRegistry f4082e;

    /* renamed from: f  reason: collision with root package name */
    private io.flutter.plugin.editing.m f4083f;

    /* renamed from: g  reason: collision with root package name */
    private y2.m f4084g;

    /* renamed from: o  reason: collision with root package name */
    private int f4092o = 0;

    /* renamed from: p  reason: collision with root package name */
    private boolean f4093p = false;

    /* renamed from: q  reason: collision with root package name */
    private boolean f4094q = true;

    /* renamed from: u  reason: collision with root package name */
    private boolean f4098u = false;

    /* renamed from: v  reason: collision with root package name */
    private final m.g f4099v = new a();

    /* renamed from: a  reason: collision with root package name */
    private final l f4078a = new l();

    /* renamed from: i  reason: collision with root package name */
    final HashMap<Integer, g0> f4086i = new HashMap<>();

    /* renamed from: h  reason: collision with root package name */
    private final io.flutter.plugin.platform.a f4085h = new io.flutter.plugin.platform.a();

    /* renamed from: j  reason: collision with root package name */
    final HashMap<Context, View> f4087j = new HashMap<>();

    /* renamed from: m  reason: collision with root package name */
    private final SparseArray<c> f4090m = new SparseArray<>();

    /* renamed from: r  reason: collision with root package name */
    private final HashSet<Integer> f4095r = new HashSet<>();

    /* renamed from: s  reason: collision with root package name */
    private final HashSet<Integer> f4096s = new HashSet<>();

    /* renamed from: n  reason: collision with root package name */
    private final SparseArray<p> f4091n = new SparseArray<>();

    /* renamed from: k  reason: collision with root package name */
    private final SparseArray<i> f4088k = new SparseArray<>();

    /* renamed from: l  reason: collision with root package name */
    private final SparseArray<r2.a> f4089l = new SparseArray<>();

    /* renamed from: t  reason: collision with root package name */
    private final io.flutter.embedding.android.d0 f4097t = io.flutter.embedding.android.d0.a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements m.g {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void k(g0 g0Var, float f5, m.b bVar) {
            w.this.A0(g0Var);
            if (w.this.f4080c != null) {
                f5 = w.this.V();
            }
            bVar.a(new m.c(w.this.w0(g0Var.f(), f5), w.this.w0(g0Var.e(), f5)));
        }

        @Override // y2.m.g
        public void a(m.d dVar) {
            w.this.S(19);
            w.this.T(dVar);
            w.this.H(w.this.M(dVar, false), dVar);
        }

        @Override // y2.m.g
        public void b(boolean z4) {
            w.this.f4094q = z4;
        }

        @Override // y2.m.g
        public void c(int i5, double d5, double d6) {
            if (w.this.b(i5)) {
                return;
            }
            p pVar = (p) w.this.f4091n.get(i5);
            if (pVar == null) {
                n2.b.b("PlatformViewsController", "Setting offset for unknown platform view with id: " + i5);
                return;
            }
            int y02 = w.this.y0(d5);
            int y03 = w.this.y0(d6);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) pVar.getLayoutParams();
            layoutParams.topMargin = y02;
            layoutParams.leftMargin = y03;
            pVar.setLayoutParams(layoutParams);
        }

        @Override // y2.m.g
        public void d(int i5, int i6) {
            View c5;
            StringBuilder sb;
            String str;
            if (!w.B0(i6)) {
                throw new IllegalStateException("Trying to set unknown direction value: " + i6 + "(view id: " + i5 + ")");
            }
            if (w.this.b(i5)) {
                c5 = w.this.f4086i.get(Integer.valueOf(i5)).g();
            } else {
                i iVar = (i) w.this.f4088k.get(i5);
                if (iVar == null) {
                    sb = new StringBuilder();
                    str = "Setting direction to an unknown view with id: ";
                    sb.append(str);
                    sb.append(i5);
                    n2.b.b("PlatformViewsController", sb.toString());
                }
                c5 = iVar.c();
            }
            if (c5 != null) {
                c5.setLayoutDirection(i6);
                return;
            }
            sb = new StringBuilder();
            str = "Setting direction to a null view with id: ";
            sb.append(str);
            sb.append(i5);
            n2.b.b("PlatformViewsController", sb.toString());
        }

        @Override // y2.m.g
        public void e(m.f fVar) {
            int i5 = fVar.f8711a;
            float f5 = w.this.f4080c.getResources().getDisplayMetrics().density;
            if (w.this.b(i5)) {
                w.this.f4086i.get(Integer.valueOf(i5)).c(w.this.x0(f5, fVar, true));
                return;
            }
            i iVar = (i) w.this.f4088k.get(i5);
            if (iVar == null) {
                n2.b.b("PlatformViewsController", "Sending touch to an unknown view with id: " + i5);
                return;
            }
            View c5 = iVar.c();
            if (c5 != null) {
                c5.dispatchTouchEvent(w.this.x0(f5, fVar, false));
                return;
            }
            n2.b.b("PlatformViewsController", "Sending touch to a null view with id: " + i5);
        }

        @Override // y2.m.g
        public void f(int i5) {
            View c5;
            StringBuilder sb;
            String str;
            if (w.this.b(i5)) {
                c5 = w.this.f4086i.get(Integer.valueOf(i5)).g();
            } else {
                i iVar = (i) w.this.f4088k.get(i5);
                if (iVar == null) {
                    sb = new StringBuilder();
                    str = "Clearing focus on an unknown view with id: ";
                    sb.append(str);
                    sb.append(i5);
                    n2.b.b("PlatformViewsController", sb.toString());
                }
                c5 = iVar.c();
            }
            if (c5 != null) {
                c5.clearFocus();
                return;
            }
            sb = new StringBuilder();
            str = "Clearing focus on a null view with id: ";
            sb.append(str);
            sb.append(i5);
            n2.b.b("PlatformViewsController", sb.toString());
        }

        @Override // y2.m.g
        public void g(m.e eVar, final m.b bVar) {
            int y02 = w.this.y0(eVar.f8709b);
            int y03 = w.this.y0(eVar.f8710c);
            int i5 = eVar.f8708a;
            if (w.this.b(i5)) {
                final float V = w.this.V();
                final g0 g0Var = w.this.f4086i.get(Integer.valueOf(i5));
                w.this.d0(g0Var);
                g0Var.k(y02, y03, new Runnable() { // from class: io.flutter.plugin.platform.v
                    @Override // java.lang.Runnable
                    public final void run() {
                        w.a.this.k(g0Var, V, bVar);
                    }
                });
                return;
            }
            i iVar = (i) w.this.f4088k.get(i5);
            p pVar = (p) w.this.f4091n.get(i5);
            if (iVar == null || pVar == null) {
                n2.b.b("PlatformViewsController", "Resizing unknown platform view with id: " + i5);
                return;
            }
            if (y02 > pVar.getRenderTargetWidth() || y03 > pVar.getRenderTargetHeight()) {
                pVar.b(y02, y03);
            }
            ViewGroup.LayoutParams layoutParams = pVar.getLayoutParams();
            layoutParams.width = y02;
            layoutParams.height = y03;
            pVar.setLayoutParams(layoutParams);
            View c5 = iVar.c();
            if (c5 != null) {
                ViewGroup.LayoutParams layoutParams2 = c5.getLayoutParams();
                layoutParams2.width = y02;
                layoutParams2.height = y03;
                c5.setLayoutParams(layoutParams2);
            }
            bVar.a(new m.c(w.this.v0(pVar.getRenderTargetWidth()), w.this.v0(pVar.getRenderTargetHeight())));
        }

        @Override // y2.m.g
        public void h(int i5) {
            i iVar = (i) w.this.f4088k.get(i5);
            if (iVar == null) {
                n2.b.b("PlatformViewsController", "Disposing unknown platform view with id: " + i5);
                return;
            }
            if (iVar.c() != null) {
                View c5 = iVar.c();
                ViewGroup viewGroup = (ViewGroup) c5.getParent();
                if (viewGroup != null) {
                    viewGroup.removeView(c5);
                }
            }
            w.this.f4088k.remove(i5);
            try {
                iVar.a();
            } catch (RuntimeException e5) {
                n2.b.c("PlatformViewsController", "Disposing platform view threw an exception", e5);
            }
            if (w.this.b(i5)) {
                g0 g0Var = w.this.f4086i.get(Integer.valueOf(i5));
                View g5 = g0Var.g();
                if (g5 != null) {
                    w.this.f4087j.remove(g5.getContext());
                }
                g0Var.d();
                w.this.f4086i.remove(Integer.valueOf(i5));
                return;
            }
            p pVar = (p) w.this.f4091n.get(i5);
            if (pVar != null) {
                pVar.removeAllViews();
                pVar.a();
                pVar.c();
                ViewGroup viewGroup2 = (ViewGroup) pVar.getParent();
                if (viewGroup2 != null) {
                    viewGroup2.removeView(pVar);
                }
                w.this.f4091n.remove(i5);
                return;
            }
            r2.a aVar = (r2.a) w.this.f4089l.get(i5);
            if (aVar != null) {
                aVar.removeAllViews();
                aVar.b();
                ViewGroup viewGroup3 = (ViewGroup) aVar.getParent();
                if (viewGroup3 != null) {
                    viewGroup3.removeView(aVar);
                }
                w.this.f4089l.remove(i5);
            }
        }

        @Override // y2.m.g
        public long i(m.d dVar) {
            w.this.T(dVar);
            int i5 = dVar.f8695a;
            if (w.this.f4091n.get(i5) != null) {
                throw new IllegalStateException("Trying to create an already created platform view, view id: " + i5);
            } else if (w.this.f4082e == null) {
                throw new IllegalStateException("Texture registry is null. This means that platform views controller was detached, view id: " + i5);
            } else if (w.this.f4081d == null) {
                throw new IllegalStateException("Flutter view is null. This means the platform views controller doesn't have an attached view, view id: " + i5);
            } else {
                boolean z4 = true;
                i M = w.this.M(dVar, true);
                View c5 = M.c();
                if (c5.getParent() == null) {
                    if (!((Build.VERSION.SDK_INT < 23 || h3.h.f(c5, w.f4075w)) ? false : false)) {
                        if (dVar.f8702h == m.d.a.TEXTURE_WITH_HYBRID_FALLBACK) {
                            w.this.H(M, dVar);
                            return -2L;
                        } else if (!w.this.f4098u) {
                            return w.this.J(M, dVar);
                        }
                    }
                    return w.this.I(M, dVar);
                }
                throw new IllegalStateException("The Android view returned from PlatformView#getView() was already added to a parent view.");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0(g0 g0Var) {
        io.flutter.plugin.editing.m mVar = this.f4083f;
        if (mVar == null) {
            return;
        }
        mVar.F();
        g0Var.i();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean B0(int i5) {
        return i5 == 0 || i5 == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H(i iVar, m.d dVar) {
        S(19);
        n2.b.e("PlatformViewsController", "Using hybrid composition for platform view: " + dVar.f8695a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long J(i iVar, final m.d dVar) {
        S(20);
        n2.b.e("PlatformViewsController", "Hosting view in a virtual display for platform view: " + dVar.f8695a);
        n e02 = e0(this.f4082e);
        g0 b5 = g0.b(this.f4080c, this.f4085h, iVar, e02, y0(dVar.f8697c), y0(dVar.f8698d), dVar.f8695a, null, new View.OnFocusChangeListener() { // from class: io.flutter.plugin.platform.u
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z4) {
                w.this.a0(dVar, view, z4);
            }
        });
        if (b5 != null) {
            this.f4086i.put(Integer.valueOf(dVar.f8695a), b5);
            View c5 = iVar.c();
            this.f4087j.put(c5.getContext(), c5);
            return e02.getId();
        }
        throw new IllegalStateException("Failed creating virtual display for a " + dVar.f8696b + " with id: " + dVar.f8695a);
    }

    private void R() {
        while (this.f4088k.size() > 0) {
            this.f4099v.h(this.f4088k.keyAt(0));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S(int i5) {
        int i6 = Build.VERSION.SDK_INT;
        if (i6 >= i5) {
            return;
        }
        throw new IllegalStateException("Trying to use platform views with API " + i6 + ", required API level is: " + i5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T(m.d dVar) {
        if (B0(dVar.f8701g)) {
            return;
        }
        throw new IllegalStateException("Trying to create a view with unknown direction value: " + dVar.f8701g + "(view id: " + dVar.f8695a + ")");
    }

    private void U(boolean z4) {
        for (int i5 = 0; i5 < this.f4090m.size(); i5++) {
            int keyAt = this.f4090m.keyAt(i5);
            c valueAt = this.f4090m.valueAt(i5);
            if (this.f4095r.contains(Integer.valueOf(keyAt))) {
                this.f4081d.m(valueAt);
                z4 &= valueAt.e();
            } else {
                if (!this.f4093p) {
                    valueAt.a();
                }
                valueAt.setVisibility(8);
                this.f4081d.removeView(valueAt);
            }
        }
        for (int i6 = 0; i6 < this.f4089l.size(); i6++) {
            int keyAt2 = this.f4089l.keyAt(i6);
            r2.a aVar = this.f4089l.get(keyAt2);
            if (!this.f4096s.contains(Integer.valueOf(keyAt2)) || (!z4 && this.f4094q)) {
                aVar.setVisibility(8);
            } else {
                aVar.setVisibility(0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float V() {
        return this.f4080c.getResources().getDisplayMetrics().density;
    }

    private void Y() {
        if (!this.f4094q || this.f4093p) {
            return;
        }
        this.f4081d.p();
        this.f4093p = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Z(m.d dVar, View view, boolean z4) {
        if (z4) {
            this.f4084g.d(dVar.f8695a);
            return;
        }
        io.flutter.plugin.editing.m mVar = this.f4083f;
        if (mVar != null) {
            mVar.k(dVar.f8695a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a0(m.d dVar, View view, boolean z4) {
        if (z4) {
            this.f4084g.d(dVar.f8695a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b0(int i5, View view, boolean z4) {
        if (z4) {
            this.f4084g.d(i5);
            return;
        }
        io.flutter.plugin.editing.m mVar = this.f4083f;
        if (mVar != null) {
            mVar.k(i5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c0() {
        U(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d0(g0 g0Var) {
        io.flutter.plugin.editing.m mVar = this.f4083f;
        if (mVar == null) {
            return;
        }
        mVar.t();
        g0Var.h();
    }

    private static n e0(TextureRegistry textureRegistry) {
        if (f4077y && Build.VERSION.SDK_INT >= 29) {
            TextureRegistry.SurfaceProducer b5 = textureRegistry.b();
            n2.b.e("PlatformViewsController", "PlatformView is using SurfaceProducer backend");
            return new d0(b5);
        } else if (!f4076x || Build.VERSION.SDK_INT < 29) {
            TextureRegistry.SurfaceTextureEntry c5 = textureRegistry.c();
            n2.b.e("PlatformViewsController", "PlatformView is using SurfaceTexture backend");
            return new f0(c5);
        } else {
            TextureRegistry.ImageTextureEntry a5 = textureRegistry.a();
            n2.b.e("PlatformViewsController", "PlatformView is using ImageReader backend");
            return new b(a5);
        }
    }

    private void f0(i iVar) {
        io.flutter.embedding.android.t tVar = this.f4081d;
        if (tVar == null) {
            n2.b.e("PlatformViewsController", "null flutterView");
        } else {
            iVar.d(tVar);
        }
    }

    private static MotionEvent.PointerCoords p0(Object obj, float f5) {
        List list = (List) obj;
        MotionEvent.PointerCoords pointerCoords = new MotionEvent.PointerCoords();
        pointerCoords.orientation = (float) ((Double) list.get(0)).doubleValue();
        pointerCoords.pressure = (float) ((Double) list.get(1)).doubleValue();
        pointerCoords.size = (float) ((Double) list.get(2)).doubleValue();
        double d5 = f5;
        pointerCoords.toolMajor = (float) (((Double) list.get(3)).doubleValue() * d5);
        pointerCoords.toolMinor = (float) (((Double) list.get(4)).doubleValue() * d5);
        pointerCoords.touchMajor = (float) (((Double) list.get(5)).doubleValue() * d5);
        pointerCoords.touchMinor = (float) (((Double) list.get(6)).doubleValue() * d5);
        pointerCoords.x = (float) (((Double) list.get(7)).doubleValue() * d5);
        pointerCoords.y = (float) (((Double) list.get(8)).doubleValue() * d5);
        return pointerCoords;
    }

    private static List<MotionEvent.PointerCoords> q0(Object obj, float f5) {
        ArrayList arrayList = new ArrayList();
        for (Object obj2 : (List) obj) {
            arrayList.add(p0(obj2, f5));
        }
        return arrayList;
    }

    private static MotionEvent.PointerProperties r0(Object obj) {
        List list = (List) obj;
        MotionEvent.PointerProperties pointerProperties = new MotionEvent.PointerProperties();
        pointerProperties.id = ((Integer) list.get(0)).intValue();
        pointerProperties.toolType = ((Integer) list.get(1)).intValue();
        return pointerProperties;
    }

    private static List<MotionEvent.PointerProperties> s0(Object obj) {
        ArrayList arrayList = new ArrayList();
        for (Object obj2 : (List) obj) {
            arrayList.add(r0(obj2));
        }
        return arrayList;
    }

    private void t0() {
        if (this.f4081d == null) {
            n2.b.b("PlatformViewsController", "removeOverlaySurfaces called while flutter view is null");
            return;
        }
        for (int i5 = 0; i5 < this.f4090m.size(); i5++) {
            this.f4081d.removeView(this.f4090m.valueAt(i5));
        }
        this.f4090m.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int v0(double d5) {
        return w0(d5, V());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int w0(double d5, float f5) {
        return (int) Math.round(d5 / f5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int y0(double d5) {
        return (int) Math.round(d5 * V());
    }

    private static void z0(MotionEvent motionEvent, MotionEvent.PointerCoords[] pointerCoordsArr) {
        if (pointerCoordsArr.length < 1) {
            return;
        }
        motionEvent.offsetLocation(pointerCoordsArr[0].x - motionEvent.getX(), pointerCoordsArr[0].y - motionEvent.getY());
    }

    public void C(Context context, TextureRegistry textureRegistry, o2.a aVar) {
        if (this.f4080c != null) {
            throw new AssertionError("A PlatformViewsController can only be attached to a single output target.\nattach was called while the PlatformViewsController was already attached.");
        }
        this.f4080c = context;
        this.f4082e = textureRegistry;
        y2.m mVar = new y2.m(aVar);
        this.f4084g = mVar;
        mVar.e(this.f4099v);
    }

    public void D(io.flutter.plugin.editing.m mVar) {
        this.f4083f = mVar;
    }

    public void E(FlutterRenderer flutterRenderer) {
        this.f4079b = new io.flutter.embedding.android.c(flutterRenderer, true);
    }

    public void F(io.flutter.embedding.android.t tVar) {
        this.f4081d = tVar;
        for (int i5 = 0; i5 < this.f4091n.size(); i5++) {
            this.f4081d.addView(this.f4091n.valueAt(i5));
        }
        for (int i6 = 0; i6 < this.f4089l.size(); i6++) {
            this.f4081d.addView(this.f4089l.valueAt(i6));
        }
        for (int i7 = 0; i7 < this.f4088k.size(); i7++) {
            this.f4088k.valueAt(i7).d(this.f4081d);
        }
    }

    public boolean G(View view) {
        if (view != null && this.f4087j.containsKey(view.getContext())) {
            View view2 = this.f4087j.get(view.getContext());
            if (view2 == view) {
                return true;
            }
            return view2.checkInputConnectionProxy(view);
        }
        return false;
    }

    public long I(i iVar, final m.d dVar) {
        p pVar;
        long j5;
        S(23);
        n2.b.e("PlatformViewsController", "Hosting view in view hierarchy for platform view: " + dVar.f8695a);
        int y02 = y0(dVar.f8697c);
        int y03 = y0(dVar.f8698d);
        if (this.f4098u) {
            pVar = new p(this.f4080c);
            j5 = -1;
        } else {
            n e02 = e0(this.f4082e);
            p pVar2 = new p(this.f4080c, e02);
            long id = e02.getId();
            pVar = pVar2;
            j5 = id;
        }
        pVar.setTouchProcessor(this.f4079b);
        pVar.b(y02, y03);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(y02, y03);
        int y04 = y0(dVar.f8699e);
        int y05 = y0(dVar.f8700f);
        layoutParams.topMargin = y04;
        layoutParams.leftMargin = y05;
        pVar.setLayoutParams(layoutParams);
        View c5 = iVar.c();
        c5.setLayoutParams(new FrameLayout.LayoutParams(y02, y03));
        c5.setImportantForAccessibility(4);
        pVar.addView(c5);
        pVar.setOnDescendantFocusChangeListener(new View.OnFocusChangeListener() { // from class: io.flutter.plugin.platform.t
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z4) {
                w.this.Z(dVar, view, z4);
            }
        });
        this.f4081d.addView(pVar);
        this.f4091n.append(dVar.f8695a, pVar);
        f0(iVar);
        return j5;
    }

    public FlutterOverlaySurface K() {
        return L(new c(this.f4081d.getContext(), this.f4081d.getWidth(), this.f4081d.getHeight(), this.f4085h));
    }

    public FlutterOverlaySurface L(c cVar) {
        int i5 = this.f4092o;
        this.f4092o = i5 + 1;
        this.f4090m.put(i5, cVar);
        return new FlutterOverlaySurface(i5, cVar.getSurface());
    }

    public i M(m.d dVar, boolean z4) {
        j a5 = this.f4078a.a(dVar.f8696b);
        if (a5 == null) {
            throw new IllegalStateException("Trying to create a platform view of unregistered type: " + dVar.f8696b);
        }
        i a6 = a5.a(z4 ? new MutableContextWrapper(this.f4080c) : this.f4080c, dVar.f8695a, dVar.f8703i != null ? a5.b().b(dVar.f8703i) : null);
        View c5 = a6.c();
        if (c5 != null) {
            c5.setLayoutDirection(dVar.f8701g);
            this.f4088k.put(dVar.f8695a, a6);
            f0(a6);
            return a6;
        }
        throw new IllegalStateException("PlatformView#getView() returned null, but an Android view reference was expected.");
    }

    public void N() {
        for (int i5 = 0; i5 < this.f4090m.size(); i5++) {
            c valueAt = this.f4090m.valueAt(i5);
            valueAt.a();
            valueAt.g();
        }
    }

    public void O() {
        y2.m mVar = this.f4084g;
        if (mVar != null) {
            mVar.e(null);
        }
        N();
        this.f4084g = null;
        this.f4080c = null;
        this.f4082e = null;
    }

    public void P() {
        for (int i5 = 0; i5 < this.f4091n.size(); i5++) {
            this.f4081d.removeView(this.f4091n.valueAt(i5));
        }
        for (int i6 = 0; i6 < this.f4089l.size(); i6++) {
            this.f4081d.removeView(this.f4089l.valueAt(i6));
        }
        N();
        t0();
        this.f4081d = null;
        this.f4093p = false;
        for (int i7 = 0; i7 < this.f4088k.size(); i7++) {
            this.f4088k.valueAt(i7).e();
        }
    }

    public void Q() {
        this.f4083f = null;
    }

    public k W() {
        return this.f4078a;
    }

    void X(final int i5) {
        i iVar = this.f4088k.get(i5);
        if (iVar == null) {
            throw new IllegalStateException("Platform view hasn't been initialized from the platform view channel.");
        }
        if (this.f4089l.get(i5) != null) {
            return;
        }
        View c5 = iVar.c();
        if (c5 == null) {
            throw new IllegalStateException("PlatformView#getView() returned null, but an Android view reference was expected.");
        }
        if (c5.getParent() != null) {
            throw new IllegalStateException("The Android view returned from PlatformView#getView() was already added to a parent view.");
        }
        Context context = this.f4080c;
        r2.a aVar = new r2.a(context, context.getResources().getDisplayMetrics().density, this.f4079b);
        aVar.setOnDescendantFocusChangeListener(new View.OnFocusChangeListener() { // from class: io.flutter.plugin.platform.r
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z4) {
                w.this.b0(i5, view, z4);
            }
        });
        this.f4089l.put(i5, aVar);
        c5.setImportantForAccessibility(4);
        aVar.addView(c5);
        this.f4081d.addView(aVar);
    }

    @Override // io.flutter.plugin.platform.q
    public void a(io.flutter.view.h hVar) {
        this.f4085h.c(hVar);
    }

    @Override // io.flutter.plugin.platform.q
    public boolean b(int i5) {
        return this.f4086i.containsKey(Integer.valueOf(i5));
    }

    @Override // io.flutter.plugin.platform.q
    public View c(int i5) {
        if (b(i5)) {
            return this.f4086i.get(Integer.valueOf(i5)).g();
        }
        i iVar = this.f4088k.get(i5);
        if (iVar == null) {
            return null;
        }
        return iVar.c();
    }

    @Override // io.flutter.plugin.platform.q
    public void d() {
        this.f4085h.c(null);
    }

    public void g0() {
    }

    public void h0() {
        this.f4095r.clear();
        this.f4096s.clear();
    }

    public void i0() {
        R();
    }

    public void j0(int i5, int i6, int i7, int i8, int i9) {
        if (this.f4090m.get(i5) == null) {
            throw new IllegalStateException("The overlay surface (id:" + i5 + ") doesn't exist");
        }
        Y();
        c cVar = this.f4090m.get(i5);
        if (cVar.getParent() == null) {
            this.f4081d.addView(cVar);
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i8, i9);
        layoutParams.leftMargin = i6;
        layoutParams.topMargin = i7;
        cVar.setLayoutParams(layoutParams);
        cVar.setVisibility(0);
        cVar.bringToFront();
        this.f4095r.add(Integer.valueOf(i5));
    }

    public void k0(int i5, int i6, int i7, int i8, int i9, int i10, int i11, FlutterMutatorsStack flutterMutatorsStack) {
        Y();
        X(i5);
        r2.a aVar = this.f4089l.get(i5);
        aVar.a(flutterMutatorsStack, i6, i7, i8, i9);
        aVar.setVisibility(0);
        aVar.bringToFront();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i10, i11);
        View c5 = this.f4088k.get(i5).c();
        if (c5 != null) {
            c5.setLayoutParams(layoutParams);
            c5.bringToFront();
        }
        this.f4096s.add(Integer.valueOf(i5));
    }

    public void l0() {
        boolean z4 = false;
        if (this.f4093p && this.f4096s.isEmpty()) {
            this.f4093p = false;
            this.f4081d.A(new Runnable() { // from class: io.flutter.plugin.platform.s
                @Override // java.lang.Runnable
                public final void run() {
                    w.this.c0();
                }
            });
            return;
        }
        if (this.f4093p && this.f4081d.k()) {
            z4 = true;
        }
        U(z4);
    }

    public void m0() {
        R();
    }

    public void n0() {
        for (g0 g0Var : this.f4086i.values()) {
            g0Var.j();
        }
    }

    public void o0(int i5) {
        if (i5 < 40) {
            return;
        }
        for (g0 g0Var : this.f4086i.values()) {
            g0Var.a();
        }
    }

    public void u0(boolean z4) {
        this.f4098u = z4;
    }

    public MotionEvent x0(float f5, m.f fVar, boolean z4) {
        MotionEvent b5 = this.f4097t.b(d0.a.c(fVar.f8726p));
        MotionEvent.PointerCoords[] pointerCoordsArr = (MotionEvent.PointerCoords[]) q0(fVar.f8717g, f5).toArray(new MotionEvent.PointerCoords[fVar.f8715e]);
        if (z4 || b5 == null) {
            return MotionEvent.obtain(fVar.f8712b.longValue(), fVar.f8713c.longValue(), fVar.f8714d, fVar.f8715e, (MotionEvent.PointerProperties[]) s0(fVar.f8716f).toArray(new MotionEvent.PointerProperties[fVar.f8715e]), pointerCoordsArr, fVar.f8718h, fVar.f8719i, fVar.f8720j, fVar.f8721k, fVar.f8722l, fVar.f8723m, fVar.f8724n, fVar.f8725o);
        }
        z0(b5, pointerCoordsArr);
        return b5;
    }
}
