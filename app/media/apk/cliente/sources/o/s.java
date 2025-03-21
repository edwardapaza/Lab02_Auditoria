package o;

import android.animation.Animator;
import android.app.Activity;
import android.app.Application;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.lifecycle.i;
import androidx.lifecycle.i0;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public class s implements ComponentCallbacks, View.OnCreateContextMenuListener, androidx.lifecycle.m, androidx.lifecycle.m0, androidx.lifecycle.h, u.f {

    /* renamed from: h0  reason: collision with root package name */
    static final Object f6596h0 = new Object();
    s B;
    int C;
    int D;
    String E;
    boolean F;
    boolean G;
    boolean H;
    boolean I;
    boolean J;
    private boolean L;
    ViewGroup M;
    View N;
    boolean O;
    g Q;
    Handler R;
    boolean T;
    LayoutInflater U;
    boolean V;
    public String W;
    androidx.lifecycle.n Y;
    x0 Z;

    /* renamed from: b  reason: collision with root package name */
    Bundle f6599b;

    /* renamed from: b0  reason: collision with root package name */
    i0.b f6600b0;

    /* renamed from: c  reason: collision with root package name */
    SparseArray<Parcelable> f6601c;

    /* renamed from: c0  reason: collision with root package name */
    u.e f6602c0;

    /* renamed from: d  reason: collision with root package name */
    Bundle f6603d;

    /* renamed from: d0  reason: collision with root package name */
    private int f6604d0;

    /* renamed from: e  reason: collision with root package name */
    Boolean f6605e;

    /* renamed from: k  reason: collision with root package name */
    Bundle f6610k;

    /* renamed from: l  reason: collision with root package name */
    s f6611l;

    /* renamed from: n  reason: collision with root package name */
    int f6613n;

    /* renamed from: p  reason: collision with root package name */
    boolean f6615p;

    /* renamed from: q  reason: collision with root package name */
    boolean f6616q;

    /* renamed from: r  reason: collision with root package name */
    boolean f6617r;

    /* renamed from: s  reason: collision with root package name */
    boolean f6618s;

    /* renamed from: t  reason: collision with root package name */
    boolean f6619t;

    /* renamed from: u  reason: collision with root package name */
    boolean f6620u;

    /* renamed from: v  reason: collision with root package name */
    boolean f6621v;

    /* renamed from: w  reason: collision with root package name */
    boolean f6622w;

    /* renamed from: x  reason: collision with root package name */
    int f6623x;

    /* renamed from: y  reason: collision with root package name */
    l0 f6624y;

    /* renamed from: z  reason: collision with root package name */
    d0<?> f6625z;

    /* renamed from: a  reason: collision with root package name */
    int f6597a = -1;

    /* renamed from: f  reason: collision with root package name */
    String f6607f = UUID.randomUUID().toString();

    /* renamed from: m  reason: collision with root package name */
    String f6612m = null;

    /* renamed from: o  reason: collision with root package name */
    private Boolean f6614o = null;
    l0 A = new m0();
    boolean K = true;
    boolean P = true;
    Runnable S = new a();
    i.b X = i.b.RESUMED;

    /* renamed from: a0  reason: collision with root package name */
    androidx.lifecycle.s<androidx.lifecycle.m> f6598a0 = new androidx.lifecycle.s<>();

    /* renamed from: e0  reason: collision with root package name */
    private final AtomicInteger f6606e0 = new AtomicInteger();

    /* renamed from: f0  reason: collision with root package name */
    private final ArrayList<i> f6608f0 = new ArrayList<>();

    /* renamed from: g0  reason: collision with root package name */
    private final i f6609g0 = new b();

    /* loaded from: classes.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            s.this.C1();
        }
    }

    /* loaded from: classes.dex */
    class b extends i {
        b() {
            super(null);
        }

        @Override // o.s.i
        void a() {
            s.this.f6602c0.c();
            androidx.lifecycle.d0.a(s.this);
            Bundle bundle = s.this.f6599b;
            s.this.f6602c0.d(bundle != null ? bundle.getBundle("registryState") : null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            s.this.f(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class d implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b1 f6629a;

        d(b1 b1Var) {
            this.f6629a = b1Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f6629a.w()) {
                this.f6629a.n();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class e extends z {
        e() {
        }

        @Override // o.z
        public View g(int i5) {
            View view = s.this.N;
            if (view != null) {
                return view.findViewById(i5);
            }
            throw new IllegalStateException("Fragment " + s.this + " does not have a view");
        }

        @Override // o.z
        public boolean s() {
            return s.this.N != null;
        }
    }

    /* loaded from: classes.dex */
    class f implements androidx.lifecycle.k {
        f() {
        }

        @Override // androidx.lifecycle.k
        public void d(androidx.lifecycle.m mVar, i.a aVar) {
            View view;
            if (aVar != i.a.ON_STOP || (view = s.this.N) == null) {
                return;
            }
            view.cancelPendingInputEvents();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class g {

        /* renamed from: a  reason: collision with root package name */
        View f6633a;

        /* renamed from: b  reason: collision with root package name */
        boolean f6634b;

        /* renamed from: c  reason: collision with root package name */
        int f6635c;

        /* renamed from: d  reason: collision with root package name */
        int f6636d;

        /* renamed from: e  reason: collision with root package name */
        int f6637e;

        /* renamed from: f  reason: collision with root package name */
        int f6638f;

        /* renamed from: g  reason: collision with root package name */
        int f6639g;

        /* renamed from: h  reason: collision with root package name */
        ArrayList<String> f6640h;

        /* renamed from: i  reason: collision with root package name */
        ArrayList<String> f6641i;

        /* renamed from: j  reason: collision with root package name */
        Object f6642j = null;

        /* renamed from: k  reason: collision with root package name */
        Object f6643k;

        /* renamed from: l  reason: collision with root package name */
        Object f6644l;

        /* renamed from: m  reason: collision with root package name */
        Object f6645m;

        /* renamed from: n  reason: collision with root package name */
        Object f6646n;

        /* renamed from: o  reason: collision with root package name */
        Object f6647o;

        /* renamed from: p  reason: collision with root package name */
        Boolean f6648p;

        /* renamed from: q  reason: collision with root package name */
        Boolean f6649q;

        /* renamed from: r  reason: collision with root package name */
        androidx.core.app.c1 f6650r;

        /* renamed from: s  reason: collision with root package name */
        androidx.core.app.c1 f6651s;

        /* renamed from: t  reason: collision with root package name */
        float f6652t;

        /* renamed from: u  reason: collision with root package name */
        View f6653u;

        /* renamed from: v  reason: collision with root package name */
        boolean f6654v;

        g() {
            Object obj = s.f6596h0;
            this.f6643k = obj;
            this.f6644l = null;
            this.f6645m = obj;
            this.f6646n = null;
            this.f6647o = obj;
            this.f6650r = null;
            this.f6651s = null;
            this.f6652t = 1.0f;
            this.f6653u = null;
        }
    }

    /* loaded from: classes.dex */
    public static class h extends RuntimeException {
        public h(String str, Exception exc) {
            super(str, exc);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static abstract class i {
        private i() {
        }

        /* synthetic */ i(a aVar) {
            this();
        }

        abstract void a();
    }

    public s() {
        W();
    }

    private int E() {
        i.b bVar = this.X;
        return (bVar == i.b.INITIALIZED || this.B == null) ? bVar.ordinal() : Math.min(bVar.ordinal(), this.B.E());
    }

    private s T(boolean z4) {
        String str;
        if (z4) {
            p.d.j(this);
        }
        s sVar = this.f6611l;
        if (sVar != null) {
            return sVar;
        }
        l0 l0Var = this.f6624y;
        if (l0Var == null || (str = this.f6612m) == null) {
            return null;
        }
        return l0Var.f0(str);
    }

    private void W() {
        this.Y = new androidx.lifecycle.n(this);
        this.f6602c0 = u.e.a(this);
        this.f6600b0 = null;
        if (this.f6608f0.contains(this.f6609g0)) {
            return;
        }
        n1(this.f6609g0);
    }

    @Deprecated
    public static s Y(Context context, String str, Bundle bundle) {
        try {
            s newInstance = c0.d(context.getClassLoader(), str).getConstructor(new Class[0]).newInstance(new Object[0]);
            if (bundle != null) {
                bundle.setClassLoader(newInstance.getClass().getClassLoader());
                newInstance.v1(bundle);
            }
            return newInstance;
        } catch (IllegalAccessException e5) {
            throw new h("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an empty constructor that is public", e5);
        } catch (InstantiationException e6) {
            throw new h("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an empty constructor that is public", e6);
        } catch (NoSuchMethodException e7) {
            throw new h("Unable to instantiate fragment " + str + ": could not find Fragment constructor", e7);
        } catch (InvocationTargetException e8) {
            throw new h("Unable to instantiate fragment " + str + ": calling Fragment constructor caused an exception", e8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g0() {
        this.Z.e(this.f6603d);
        this.f6603d = null;
    }

    private g l() {
        if (this.Q == null) {
            this.Q = new g();
        }
        return this.Q;
    }

    private void n1(i iVar) {
        if (this.f6597a >= 0) {
            iVar.a();
        } else {
            this.f6608f0.add(iVar);
        }
    }

    private void s1() {
        if (l0.I0(3)) {
            Log.d("FragmentManager", "moveto RESTORE_VIEW_STATE: " + this);
        }
        if (this.N != null) {
            Bundle bundle = this.f6599b;
            t1(bundle != null ? bundle.getBundle("savedInstanceState") : null);
        }
        this.f6599b = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public androidx.core.app.c1 A() {
        g gVar = this.Q;
        if (gVar == null) {
            return null;
        }
        return gVar.f6651s;
    }

    public void A0(Context context, AttributeSet attributeSet, Bundle bundle) {
        this.L = true;
        d0<?> d0Var = this.f6625z;
        Activity t5 = d0Var == null ? null : d0Var.t();
        if (t5 != null) {
            this.L = false;
            z0(t5, attributeSet, bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void A1(ArrayList<String> arrayList, ArrayList<String> arrayList2) {
        l();
        g gVar = this.Q;
        gVar.f6640h = arrayList;
        gVar.f6641i = arrayList2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View B() {
        g gVar = this.Q;
        if (gVar == null) {
            return null;
        }
        return gVar.f6653u;
    }

    public void B0(boolean z4) {
    }

    @Deprecated
    public void B1(Intent intent, int i5, Bundle bundle) {
        if (this.f6625z != null) {
            H().V0(this, intent, i5, bundle);
            return;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    }

    public final Object C() {
        d0<?> d0Var = this.f6625z;
        if (d0Var == null) {
            return null;
        }
        return d0Var.y();
    }

    @Deprecated
    public boolean C0(MenuItem menuItem) {
        return false;
    }

    public void C1() {
        if (this.Q == null || !l().f6654v) {
            return;
        }
        if (this.f6625z == null) {
            l().f6654v = false;
        } else if (Looper.myLooper() != this.f6625z.w().getLooper()) {
            this.f6625z.w().postAtFrontOfQueue(new c());
        } else {
            f(true);
        }
    }

    @Deprecated
    public LayoutInflater D(Bundle bundle) {
        d0<?> d0Var = this.f6625z;
        if (d0Var != null) {
            LayoutInflater z4 = d0Var.z();
            androidx.core.view.c.a(z4, this.A.w0());
            return z4;
        }
        throw new IllegalStateException("onGetLayoutInflater() cannot be executed until the Fragment is attached to the FragmentManager.");
    }

    @Deprecated
    public void D0(Menu menu) {
    }

    public void E0() {
        this.L = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int F() {
        g gVar = this.Q;
        if (gVar == null) {
            return 0;
        }
        return gVar.f6639g;
    }

    public void F0(boolean z4) {
    }

    public final s G() {
        return this.B;
    }

    @Deprecated
    public void G0(Menu menu) {
    }

    public final l0 H() {
        l0 l0Var = this.f6624y;
        if (l0Var != null) {
            return l0Var;
        }
        throw new IllegalStateException("Fragment " + this + " not associated with a fragment manager.");
    }

    public void H0(boolean z4) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean I() {
        g gVar = this.Q;
        if (gVar == null) {
            return false;
        }
        return gVar.f6634b;
    }

    @Deprecated
    public void I0(int i5, String[] strArr, int[] iArr) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int J() {
        g gVar = this.Q;
        if (gVar == null) {
            return 0;
        }
        return gVar.f6637e;
    }

    public void J0() {
        this.L = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int K() {
        g gVar = this.Q;
        if (gVar == null) {
            return 0;
        }
        return gVar.f6638f;
    }

    public void K0(Bundle bundle) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float L() {
        g gVar = this.Q;
        if (gVar == null) {
            return 1.0f;
        }
        return gVar.f6652t;
    }

    public void L0() {
        this.L = true;
    }

    public Object M() {
        g gVar = this.Q;
        if (gVar == null) {
            return null;
        }
        Object obj = gVar.f6645m;
        return obj == f6596h0 ? z() : obj;
    }

    public void M0() {
        this.L = true;
    }

    public final Resources N() {
        return p1().getResources();
    }

    public void N0(View view, Bundle bundle) {
    }

    public Object O() {
        g gVar = this.Q;
        if (gVar == null) {
            return null;
        }
        Object obj = gVar.f6643k;
        return obj == f6596h0 ? w() : obj;
    }

    public void O0(Bundle bundle) {
        this.L = true;
    }

    public Object P() {
        g gVar = this.Q;
        if (gVar == null) {
            return null;
        }
        return gVar.f6646n;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void P0(Bundle bundle) {
        this.A.X0();
        this.f6597a = 3;
        this.L = false;
        i0(bundle);
        if (this.L) {
            s1();
            this.A.x();
            return;
        }
        throw new d1("Fragment " + this + " did not call through to super.onActivityCreated()");
    }

    public Object Q() {
        g gVar = this.Q;
        if (gVar == null) {
            return null;
        }
        Object obj = gVar.f6647o;
        return obj == f6596h0 ? P() : obj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Q0() {
        Iterator<i> it = this.f6608f0.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
        this.f6608f0.clear();
        this.A.l(this.f6625z, h(), this);
        this.f6597a = 0;
        this.L = false;
        l0(this.f6625z.u());
        if (this.L) {
            this.f6624y.H(this);
            this.A.y();
            return;
        }
        throw new d1("Fragment " + this + " did not call through to super.onAttach()");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayList<String> R() {
        ArrayList<String> arrayList;
        g gVar = this.Q;
        return (gVar == null || (arrayList = gVar.f6640h) == null) ? new ArrayList<>() : arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void R0(Configuration configuration) {
        onConfigurationChanged(configuration);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayList<String> S() {
        ArrayList<String> arrayList;
        g gVar = this.Q;
        return (gVar == null || (arrayList = gVar.f6641i) == null) ? new ArrayList<>() : arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean S0(MenuItem menuItem) {
        if (this.F) {
            return false;
        }
        if (n0(menuItem)) {
            return true;
        }
        return this.A.A(menuItem);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void T0(Bundle bundle) {
        this.A.X0();
        this.f6597a = 1;
        this.L = false;
        this.Y.a(new f());
        o0(bundle);
        this.V = true;
        if (this.L) {
            this.Y.h(i.a.ON_CREATE);
            return;
        }
        throw new d1("Fragment " + this + " did not call through to super.onCreate()");
    }

    public View U() {
        return this.N;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean U0(Menu menu, MenuInflater menuInflater) {
        boolean z4 = false;
        if (this.F) {
            return false;
        }
        if (this.J && this.K) {
            z4 = true;
            r0(menu, menuInflater);
        }
        return z4 | this.A.C(menu, menuInflater);
    }

    public androidx.lifecycle.q<androidx.lifecycle.m> V() {
        return this.f6598a0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void V0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.A.X0();
        this.f6622w = true;
        this.Z = new x0(this, p(), new Runnable() { // from class: o.r
            @Override // java.lang.Runnable
            public final void run() {
                s.this.g0();
            }
        });
        View s02 = s0(layoutInflater, viewGroup, bundle);
        this.N = s02;
        if (s02 == null) {
            if (this.Z.d()) {
                throw new IllegalStateException("Called getViewLifecycleOwner() but onCreateView() returned null");
            }
            this.Z = null;
            return;
        }
        this.Z.c();
        if (l0.I0(3)) {
            Log.d("FragmentManager", "Setting ViewLifecycleOwner on View " + this.N + " for Fragment " + this);
        }
        androidx.lifecycle.n0.a(this.N, this.Z);
        androidx.lifecycle.o0.a(this.N, this.Z);
        u.g.a(this.N, this.Z);
        this.f6598a0.i(this.Z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void W0() {
        this.A.D();
        this.Y.h(i.a.ON_DESTROY);
        this.f6597a = 0;
        this.L = false;
        this.V = false;
        t0();
        if (this.L) {
            return;
        }
        throw new d1("Fragment " + this + " did not call through to super.onDestroy()");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void X() {
        W();
        this.W = this.f6607f;
        this.f6607f = UUID.randomUUID().toString();
        this.f6615p = false;
        this.f6616q = false;
        this.f6619t = false;
        this.f6620u = false;
        this.f6621v = false;
        this.f6623x = 0;
        this.f6624y = null;
        this.A = new m0();
        this.f6625z = null;
        this.C = 0;
        this.D = 0;
        this.E = null;
        this.F = false;
        this.G = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void X0() {
        this.A.E();
        if (this.N != null && this.Z.a().b().c(i.b.CREATED)) {
            this.Z.b(i.a.ON_DESTROY);
        }
        this.f6597a = 1;
        this.L = false;
        v0();
        if (this.L) {
            androidx.loader.app.a.b(this).c();
            this.f6622w = false;
            return;
        }
        throw new d1("Fragment " + this + " did not call through to super.onDestroyView()");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void Y0() {
        this.f6597a = -1;
        this.L = false;
        w0();
        this.U = null;
        if (this.L) {
            if (this.A.H0()) {
                return;
            }
            this.A.D();
            this.A = new m0();
            return;
        }
        throw new d1("Fragment " + this + " did not call through to super.onDetach()");
    }

    public final boolean Z() {
        return this.f6625z != null && this.f6615p;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public LayoutInflater Z0(Bundle bundle) {
        LayoutInflater x02 = x0(bundle);
        this.U = x02;
        return x02;
    }

    @Override // androidx.lifecycle.m
    public androidx.lifecycle.i a() {
        return this.Y;
    }

    public final boolean a0() {
        l0 l0Var;
        return this.F || ((l0Var = this.f6624y) != null && l0Var.L0(this.B));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a1() {
        onLowMemory();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean b0() {
        return this.f6623x > 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b1(boolean z4) {
        B0(z4);
    }

    public final boolean c0() {
        l0 l0Var;
        return this.K && ((l0Var = this.f6624y) == null || l0Var.M0(this.B));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean c1(MenuItem menuItem) {
        if (this.F) {
            return false;
        }
        if (this.J && this.K && C0(menuItem)) {
            return true;
        }
        return this.A.J(menuItem);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean d0() {
        g gVar = this.Q;
        if (gVar == null) {
            return false;
        }
        return gVar.f6654v;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d1(Menu menu) {
        if (this.F) {
            return;
        }
        if (this.J && this.K) {
            D0(menu);
        }
        this.A.K(menu);
    }

    public final boolean e0() {
        return this.f6616q;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e1() {
        this.A.M();
        if (this.N != null) {
            this.Z.b(i.a.ON_PAUSE);
        }
        this.Y.h(i.a.ON_PAUSE);
        this.f6597a = 6;
        this.L = false;
        E0();
        if (this.L) {
            return;
        }
        throw new d1("Fragment " + this + " did not call through to super.onPause()");
    }

    public final boolean equals(Object obj) {
        return super.equals(obj);
    }

    void f(boolean z4) {
        ViewGroup viewGroup;
        l0 l0Var;
        g gVar = this.Q;
        if (gVar != null) {
            gVar.f6654v = false;
        }
        if (this.N == null || (viewGroup = this.M) == null || (l0Var = this.f6624y) == null) {
            return;
        }
        b1 u5 = b1.u(viewGroup, l0Var);
        u5.x();
        if (z4) {
            this.f6625z.w().post(new d(u5));
        } else {
            u5.n();
        }
        Handler handler = this.R;
        if (handler != null) {
            handler.removeCallbacks(this.S);
            this.R = null;
        }
    }

    public final boolean f0() {
        l0 l0Var = this.f6624y;
        if (l0Var == null) {
            return false;
        }
        return l0Var.P0();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f1(boolean z4) {
        F0(z4);
    }

    @Override // androidx.lifecycle.h
    public r.a g() {
        Application application;
        Context applicationContext = p1().getApplicationContext();
        while (true) {
            if (!(applicationContext instanceof ContextWrapper)) {
                application = null;
                break;
            } else if (applicationContext instanceof Application) {
                application = (Application) applicationContext;
                break;
            } else {
                applicationContext = ((ContextWrapper) applicationContext).getBaseContext();
            }
        }
        if (application == null && l0.I0(3)) {
            Log.d("FragmentManager", "Could not find Application instance from Context " + p1().getApplicationContext() + ", you will not be able to use AndroidViewModel with the default ViewModelProvider.Factory");
        }
        r.b bVar = new r.b();
        if (application != null) {
            bVar.b(i0.a.f557d, application);
        }
        bVar.b(androidx.lifecycle.d0.f528a, this);
        bVar.b(androidx.lifecycle.d0.f529b, this);
        if (s() != null) {
            bVar.b(androidx.lifecycle.d0.f530c, s());
        }
        return bVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean g1(Menu menu) {
        boolean z4 = false;
        if (this.F) {
            return false;
        }
        if (this.J && this.K) {
            z4 = true;
            G0(menu);
        }
        return z4 | this.A.O(menu);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public z h() {
        return new e();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h0() {
        this.A.X0();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h1() {
        boolean N0 = this.f6624y.N0(this);
        Boolean bool = this.f6614o;
        if (bool == null || bool.booleanValue() != N0) {
            this.f6614o = Boolean.valueOf(N0);
            H0(N0);
            this.A.P();
        }
    }

    public final int hashCode() {
        return super.hashCode();
    }

    public void i(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mFragmentId=#");
        printWriter.print(Integer.toHexString(this.C));
        printWriter.print(" mContainerId=#");
        printWriter.print(Integer.toHexString(this.D));
        printWriter.print(" mTag=");
        printWriter.println(this.E);
        printWriter.print(str);
        printWriter.print("mState=");
        printWriter.print(this.f6597a);
        printWriter.print(" mWho=");
        printWriter.print(this.f6607f);
        printWriter.print(" mBackStackNesting=");
        printWriter.println(this.f6623x);
        printWriter.print(str);
        printWriter.print("mAdded=");
        printWriter.print(this.f6615p);
        printWriter.print(" mRemoving=");
        printWriter.print(this.f6616q);
        printWriter.print(" mFromLayout=");
        printWriter.print(this.f6619t);
        printWriter.print(" mInLayout=");
        printWriter.println(this.f6620u);
        printWriter.print(str);
        printWriter.print("mHidden=");
        printWriter.print(this.F);
        printWriter.print(" mDetached=");
        printWriter.print(this.G);
        printWriter.print(" mMenuVisible=");
        printWriter.print(this.K);
        printWriter.print(" mHasMenu=");
        printWriter.println(this.J);
        printWriter.print(str);
        printWriter.print("mRetainInstance=");
        printWriter.print(this.H);
        printWriter.print(" mUserVisibleHint=");
        printWriter.println(this.P);
        if (this.f6624y != null) {
            printWriter.print(str);
            printWriter.print("mFragmentManager=");
            printWriter.println(this.f6624y);
        }
        if (this.f6625z != null) {
            printWriter.print(str);
            printWriter.print("mHost=");
            printWriter.println(this.f6625z);
        }
        if (this.B != null) {
            printWriter.print(str);
            printWriter.print("mParentFragment=");
            printWriter.println(this.B);
        }
        if (this.f6610k != null) {
            printWriter.print(str);
            printWriter.print("mArguments=");
            printWriter.println(this.f6610k);
        }
        if (this.f6599b != null) {
            printWriter.print(str);
            printWriter.print("mSavedFragmentState=");
            printWriter.println(this.f6599b);
        }
        if (this.f6601c != null) {
            printWriter.print(str);
            printWriter.print("mSavedViewState=");
            printWriter.println(this.f6601c);
        }
        if (this.f6603d != null) {
            printWriter.print(str);
            printWriter.print("mSavedViewRegistryState=");
            printWriter.println(this.f6603d);
        }
        s T = T(false);
        if (T != null) {
            printWriter.print(str);
            printWriter.print("mTarget=");
            printWriter.print(T);
            printWriter.print(" mTargetRequestCode=");
            printWriter.println(this.f6613n);
        }
        printWriter.print(str);
        printWriter.print("mPopDirection=");
        printWriter.println(I());
        if (v() != 0) {
            printWriter.print(str);
            printWriter.print("getEnterAnim=");
            printWriter.println(v());
        }
        if (y() != 0) {
            printWriter.print(str);
            printWriter.print("getExitAnim=");
            printWriter.println(y());
        }
        if (J() != 0) {
            printWriter.print(str);
            printWriter.print("getPopEnterAnim=");
            printWriter.println(J());
        }
        if (K() != 0) {
            printWriter.print(str);
            printWriter.print("getPopExitAnim=");
            printWriter.println(K());
        }
        if (this.M != null) {
            printWriter.print(str);
            printWriter.print("mContainer=");
            printWriter.println(this.M);
        }
        if (this.N != null) {
            printWriter.print(str);
            printWriter.print("mView=");
            printWriter.println(this.N);
        }
        if (r() != null) {
            printWriter.print(str);
            printWriter.print("mAnimatingAway=");
            printWriter.println(r());
        }
        if (u() != null) {
            androidx.loader.app.a.b(this).a(str, fileDescriptor, printWriter, strArr);
        }
        printWriter.print(str);
        printWriter.println("Child " + this.A + ":");
        l0 l0Var = this.A;
        l0Var.W(str + "  ", fileDescriptor, printWriter, strArr);
    }

    @Deprecated
    public void i0(Bundle bundle) {
        this.L = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i1() {
        this.A.X0();
        this.A.a0(true);
        this.f6597a = 7;
        this.L = false;
        J0();
        if (!this.L) {
            throw new d1("Fragment " + this + " did not call through to super.onResume()");
        }
        androidx.lifecycle.n nVar = this.Y;
        i.a aVar = i.a.ON_RESUME;
        nVar.h(aVar);
        if (this.N != null) {
            this.Z.b(aVar);
        }
        this.A.Q();
    }

    @Deprecated
    public void j0(int i5, int i6, Intent intent) {
        if (l0.I0(2)) {
            Log.v("FragmentManager", "Fragment " + this + " received the following in onActivityResult(): requestCode: " + i5 + " resultCode: " + i6 + " data: " + intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j1(Bundle bundle) {
        K0(bundle);
    }

    @Override // u.f
    public final u.d k() {
        return this.f6602c0.b();
    }

    @Deprecated
    public void k0(Activity activity) {
        this.L = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k1() {
        this.A.X0();
        this.A.a0(true);
        this.f6597a = 5;
        this.L = false;
        L0();
        if (!this.L) {
            throw new d1("Fragment " + this + " did not call through to super.onStart()");
        }
        androidx.lifecycle.n nVar = this.Y;
        i.a aVar = i.a.ON_START;
        nVar.h(aVar);
        if (this.N != null) {
            this.Z.b(aVar);
        }
        this.A.R();
    }

    public void l0(Context context) {
        this.L = true;
        d0<?> d0Var = this.f6625z;
        Activity t5 = d0Var == null ? null : d0Var.t();
        if (t5 != null) {
            this.L = false;
            k0(t5);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void l1() {
        this.A.T();
        if (this.N != null) {
            this.Z.b(i.a.ON_STOP);
        }
        this.Y.h(i.a.ON_STOP);
        this.f6597a = 4;
        this.L = false;
        M0();
        if (this.L) {
            return;
        }
        throw new d1("Fragment " + this + " did not call through to super.onStop()");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public s m(String str) {
        return str.equals(this.f6607f) ? this : this.A.j0(str);
    }

    @Deprecated
    public void m0(s sVar) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void m1() {
        Bundle bundle = this.f6599b;
        N0(this.N, bundle != null ? bundle.getBundle("savedInstanceState") : null);
        this.A.U();
    }

    public final x n() {
        d0<?> d0Var = this.f6625z;
        if (d0Var == null) {
            return null;
        }
        return (x) d0Var.t();
    }

    public boolean n0(MenuItem menuItem) {
        return false;
    }

    public boolean o() {
        Boolean bool;
        g gVar = this.Q;
        if (gVar == null || (bool = gVar.f6649q) == null) {
            return true;
        }
        return bool.booleanValue();
    }

    public void o0(Bundle bundle) {
        this.L = true;
        r1();
        if (this.A.O0(1)) {
            return;
        }
        this.A.B();
    }

    public final x o1() {
        x n5 = n();
        if (n5 != null) {
            return n5;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to an activity.");
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        this.L = true;
    }

    @Override // android.view.View.OnCreateContextMenuListener
    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        o1().onCreateContextMenu(contextMenu, view, contextMenuInfo);
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
        this.L = true;
    }

    @Override // androidx.lifecycle.m0
    public androidx.lifecycle.l0 p() {
        if (this.f6624y != null) {
            if (E() != i.b.INITIALIZED.ordinal()) {
                return this.f6624y.D0(this);
            }
            throw new IllegalStateException("Calling getViewModelStore() before a Fragment reaches onCreate() when using setMaxLifecycle(INITIALIZED) is not supported");
        }
        throw new IllegalStateException("Can't access ViewModels from detached fragment");
    }

    public Animation p0(int i5, boolean z4, int i6) {
        return null;
    }

    public final Context p1() {
        Context u5 = u();
        if (u5 != null) {
            return u5;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to a context.");
    }

    public boolean q() {
        Boolean bool;
        g gVar = this.Q;
        if (gVar == null || (bool = gVar.f6648p) == null) {
            return true;
        }
        return bool.booleanValue();
    }

    public Animator q0(int i5, boolean z4, int i6) {
        return null;
    }

    public final View q1() {
        View U = U();
        if (U != null) {
            return U;
        }
        throw new IllegalStateException("Fragment " + this + " did not return a View from onCreateView() or this was called before onCreateView().");
    }

    View r() {
        g gVar = this.Q;
        if (gVar == null) {
            return null;
        }
        return gVar.f6633a;
    }

    @Deprecated
    public void r0(Menu menu, MenuInflater menuInflater) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void r1() {
        Bundle bundle;
        Bundle bundle2 = this.f6599b;
        if (bundle2 == null || (bundle = bundle2.getBundle("childFragmentManager")) == null) {
            return;
        }
        this.A.k1(bundle);
        this.A.B();
    }

    public final Bundle s() {
        return this.f6610k;
    }

    public View s0(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int i5 = this.f6604d0;
        if (i5 != 0) {
            return layoutInflater.inflate(i5, viewGroup, false);
        }
        return null;
    }

    @Deprecated
    public void startActivityForResult(Intent intent, int i5) {
        B1(intent, i5, null);
    }

    public final l0 t() {
        if (this.f6625z != null) {
            return this.A;
        }
        throw new IllegalStateException("Fragment " + this + " has not been attached yet.");
    }

    public void t0() {
        this.L = true;
    }

    final void t1(Bundle bundle) {
        SparseArray<Parcelable> sparseArray = this.f6601c;
        if (sparseArray != null) {
            this.N.restoreHierarchyState(sparseArray);
            this.f6601c = null;
        }
        this.L = false;
        O0(bundle);
        if (this.L) {
            if (this.N != null) {
                this.Z.b(i.a.ON_CREATE);
                return;
            }
            return;
        }
        throw new d1("Fragment " + this + " did not call through to super.onViewStateRestored()");
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append(getClass().getSimpleName());
        sb.append("{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("}");
        sb.append(" (");
        sb.append(this.f6607f);
        if (this.C != 0) {
            sb.append(" id=0x");
            sb.append(Integer.toHexString(this.C));
        }
        if (this.E != null) {
            sb.append(" tag=");
            sb.append(this.E);
        }
        sb.append(")");
        return sb.toString();
    }

    public Context u() {
        d0<?> d0Var = this.f6625z;
        if (d0Var == null) {
            return null;
        }
        return d0Var.u();
    }

    @Deprecated
    public void u0() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void u1(int i5, int i6, int i7, int i8) {
        if (this.Q == null && i5 == 0 && i6 == 0 && i7 == 0 && i8 == 0) {
            return;
        }
        l().f6635c = i5;
        l().f6636d = i6;
        l().f6637e = i7;
        l().f6638f = i8;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int v() {
        g gVar = this.Q;
        if (gVar == null) {
            return 0;
        }
        return gVar.f6635c;
    }

    public void v0() {
        this.L = true;
    }

    public void v1(Bundle bundle) {
        if (this.f6624y != null && f0()) {
            throw new IllegalStateException("Fragment already added and state has been saved");
        }
        this.f6610k = bundle;
    }

    public Object w() {
        g gVar = this.Q;
        if (gVar == null) {
            return null;
        }
        return gVar.f6642j;
    }

    public void w0() {
        this.L = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void w1(View view) {
        l().f6653u = view;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public androidx.core.app.c1 x() {
        g gVar = this.Q;
        if (gVar == null) {
            return null;
        }
        return gVar.f6650r;
    }

    public LayoutInflater x0(Bundle bundle) {
        return D(bundle);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void x1(int i5) {
        if (this.Q == null && i5 == 0) {
            return;
        }
        l();
        this.Q.f6639g = i5;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int y() {
        g gVar = this.Q;
        if (gVar == null) {
            return 0;
        }
        return gVar.f6636d;
    }

    public void y0(boolean z4) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void y1(boolean z4) {
        if (this.Q == null) {
            return;
        }
        l().f6634b = z4;
    }

    public Object z() {
        g gVar = this.Q;
        if (gVar == null) {
            return null;
        }
        return gVar.f6644l;
    }

    @Deprecated
    public void z0(Activity activity, AttributeSet attributeSet, Bundle bundle) {
        this.L = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void z1(float f5) {
        l().f6652t = f5;
    }
}
