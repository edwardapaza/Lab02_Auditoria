package o;

import android.app.Activity;
import android.content.res.Resources;
import android.os.BadParcelableException;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.lifecycle.i;
import o.b1;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r0 {

    /* renamed from: a  reason: collision with root package name */
    private final f0 f6588a;

    /* renamed from: b  reason: collision with root package name */
    private final s0 f6589b;

    /* renamed from: c  reason: collision with root package name */
    private final s f6590c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f6591d = false;

    /* renamed from: e  reason: collision with root package name */
    private int f6592e = -1;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements View.OnAttachStateChangeListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ View f6593a;

        a(View view) {
            this.f6593a = view;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            this.f6593a.removeOnAttachStateChangeListener(this);
            androidx.core.view.l.j(this.f6593a);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f6595a;

        static {
            int[] iArr = new int[i.b.values().length];
            f6595a = iArr;
            try {
                iArr[i.b.RESUMED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f6595a[i.b.STARTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f6595a[i.b.CREATED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f6595a[i.b.INITIALIZED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public r0(f0 f0Var, s0 s0Var, ClassLoader classLoader, c0 c0Var, Bundle bundle) {
        this.f6588a = f0Var;
        this.f6589b = s0Var;
        s a5 = ((q0) bundle.getParcelable("state")).a(c0Var, classLoader);
        this.f6590c = a5;
        a5.f6599b = bundle;
        Bundle bundle2 = bundle.getBundle("arguments");
        if (bundle2 != null) {
            bundle2.setClassLoader(classLoader);
        }
        a5.v1(bundle2);
        if (l0.I0(2)) {
            Log.v("FragmentManager", "Instantiated fragment " + a5);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public r0(f0 f0Var, s0 s0Var, s sVar) {
        this.f6588a = f0Var;
        this.f6589b = s0Var;
        this.f6590c = sVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public r0(f0 f0Var, s0 s0Var, s sVar, Bundle bundle) {
        this.f6588a = f0Var;
        this.f6589b = s0Var;
        this.f6590c = sVar;
        sVar.f6601c = null;
        sVar.f6603d = null;
        sVar.f6623x = 0;
        sVar.f6620u = false;
        sVar.f6615p = false;
        s sVar2 = sVar.f6611l;
        sVar.f6612m = sVar2 != null ? sVar2.f6607f : null;
        sVar.f6611l = null;
        sVar.f6599b = bundle;
        sVar.f6610k = bundle.getBundle("arguments");
    }

    private boolean l(View view) {
        if (view == this.f6590c.N) {
            return true;
        }
        for (ViewParent parent = view.getParent(); parent != null; parent = parent.getParent()) {
            if (parent == this.f6590c.N) {
                return true;
            }
        }
        return false;
    }

    void a() {
        if (l0.I0(3)) {
            Log.d("FragmentManager", "moveto ACTIVITY_CREATED: " + this.f6590c);
        }
        Bundle bundle = this.f6590c.f6599b;
        Bundle bundle2 = bundle != null ? bundle.getBundle("savedInstanceState") : null;
        this.f6590c.P0(bundle2);
        this.f6588a.a(this.f6590c, bundle2, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        s l02 = l0.l0(this.f6590c.M);
        s G = this.f6590c.G();
        if (l02 != null && !l02.equals(G)) {
            s sVar = this.f6590c;
            p.d.l(sVar, l02, sVar.D);
        }
        int j5 = this.f6589b.j(this.f6590c);
        s sVar2 = this.f6590c;
        sVar2.M.addView(sVar2.N, j5);
    }

    void c() {
        if (l0.I0(3)) {
            Log.d("FragmentManager", "moveto ATTACHED: " + this.f6590c);
        }
        s sVar = this.f6590c;
        s sVar2 = sVar.f6611l;
        r0 r0Var = null;
        if (sVar2 != null) {
            r0 n5 = this.f6589b.n(sVar2.f6607f);
            if (n5 == null) {
                throw new IllegalStateException("Fragment " + this.f6590c + " declared target fragment " + this.f6590c.f6611l + " that does not belong to this FragmentManager!");
            }
            s sVar3 = this.f6590c;
            sVar3.f6612m = sVar3.f6611l.f6607f;
            sVar3.f6611l = null;
            r0Var = n5;
        } else {
            String str = sVar.f6612m;
            if (str != null && (r0Var = this.f6589b.n(str)) == null) {
                throw new IllegalStateException("Fragment " + this.f6590c + " declared target fragment " + this.f6590c.f6612m + " that does not belong to this FragmentManager!");
            }
        }
        if (r0Var != null) {
            r0Var.m();
        }
        s sVar4 = this.f6590c;
        sVar4.f6625z = sVar4.f6624y.v0();
        s sVar5 = this.f6590c;
        sVar5.B = sVar5.f6624y.y0();
        this.f6588a.g(this.f6590c, false);
        this.f6590c.Q0();
        this.f6588a.b(this.f6590c, false);
    }

    int d() {
        s sVar = this.f6590c;
        if (sVar.f6624y == null) {
            return sVar.f6597a;
        }
        int i5 = this.f6592e;
        int i6 = b.f6595a[sVar.X.ordinal()];
        if (i6 != 1) {
            i5 = i6 != 2 ? i6 != 3 ? i6 != 4 ? Math.min(i5, -1) : Math.min(i5, 0) : Math.min(i5, 1) : Math.min(i5, 5);
        }
        s sVar2 = this.f6590c;
        if (sVar2.f6619t) {
            if (sVar2.f6620u) {
                i5 = Math.max(this.f6592e, 2);
                View view = this.f6590c.N;
                if (view != null && view.getParent() == null) {
                    i5 = Math.min(i5, 2);
                }
            } else {
                i5 = this.f6592e < 4 ? Math.min(i5, sVar2.f6597a) : Math.min(i5, 1);
            }
        }
        if (!this.f6590c.f6615p) {
            i5 = Math.min(i5, 1);
        }
        s sVar3 = this.f6590c;
        ViewGroup viewGroup = sVar3.M;
        b1.d.a s5 = viewGroup != null ? b1.u(viewGroup, sVar3.H()).s(this) : null;
        if (s5 == b1.d.a.ADDING) {
            i5 = Math.min(i5, 6);
        } else if (s5 == b1.d.a.REMOVING) {
            i5 = Math.max(i5, 3);
        } else {
            s sVar4 = this.f6590c;
            if (sVar4.f6616q) {
                i5 = sVar4.b0() ? Math.min(i5, 1) : Math.min(i5, -1);
            }
        }
        s sVar5 = this.f6590c;
        if (sVar5.O && sVar5.f6597a < 5) {
            i5 = Math.min(i5, 4);
        }
        s sVar6 = this.f6590c;
        if (sVar6.f6617r && sVar6.M != null) {
            i5 = Math.max(i5, 3);
        }
        if (l0.I0(2)) {
            Log.v("FragmentManager", "computeExpectedState() of " + i5 + " for " + this.f6590c);
        }
        return i5;
    }

    void e() {
        if (l0.I0(3)) {
            Log.d("FragmentManager", "moveto CREATED: " + this.f6590c);
        }
        Bundle bundle = this.f6590c.f6599b;
        Bundle bundle2 = bundle != null ? bundle.getBundle("savedInstanceState") : null;
        s sVar = this.f6590c;
        if (sVar.V) {
            sVar.f6597a = 1;
            sVar.r1();
            return;
        }
        this.f6588a.h(sVar, bundle2, false);
        this.f6590c.T0(bundle2);
        this.f6588a.c(this.f6590c, bundle2, false);
    }

    void f() {
        String str;
        if (this.f6590c.f6619t) {
            return;
        }
        if (l0.I0(3)) {
            Log.d("FragmentManager", "moveto CREATE_VIEW: " + this.f6590c);
        }
        Bundle bundle = this.f6590c.f6599b;
        ViewGroup viewGroup = null;
        Bundle bundle2 = bundle != null ? bundle.getBundle("savedInstanceState") : null;
        LayoutInflater Z0 = this.f6590c.Z0(bundle2);
        s sVar = this.f6590c;
        ViewGroup viewGroup2 = sVar.M;
        if (viewGroup2 != null) {
            viewGroup = viewGroup2;
        } else {
            int i5 = sVar.D;
            if (i5 != 0) {
                if (i5 == -1) {
                    throw new IllegalArgumentException("Cannot create fragment " + this.f6590c + " for a container view with no id");
                }
                viewGroup = (ViewGroup) sVar.f6624y.r0().g(this.f6590c.D);
                if (viewGroup == null) {
                    s sVar2 = this.f6590c;
                    if (!sVar2.f6621v) {
                        try {
                            str = sVar2.N().getResourceName(this.f6590c.D);
                        } catch (Resources.NotFoundException unused) {
                            str = "unknown";
                        }
                        throw new IllegalArgumentException("No view found for id 0x" + Integer.toHexString(this.f6590c.D) + " (" + str + ") for fragment " + this.f6590c);
                    }
                } else if (!(viewGroup instanceof a0)) {
                    p.d.k(this.f6590c, viewGroup);
                }
            }
        }
        s sVar3 = this.f6590c;
        sVar3.M = viewGroup;
        sVar3.V0(Z0, viewGroup, bundle2);
        if (this.f6590c.N != null) {
            if (l0.I0(3)) {
                Log.d("FragmentManager", "moveto VIEW_CREATED: " + this.f6590c);
            }
            this.f6590c.N.setSaveFromParentEnabled(false);
            s sVar4 = this.f6590c;
            sVar4.N.setTag(n.b.fragment_container_view_tag, sVar4);
            if (viewGroup != null) {
                b();
            }
            s sVar5 = this.f6590c;
            if (sVar5.F) {
                sVar5.N.setVisibility(8);
            }
            if (this.f6590c.N.isAttachedToWindow()) {
                androidx.core.view.l.j(this.f6590c.N);
            } else {
                View view = this.f6590c.N;
                view.addOnAttachStateChangeListener(new a(view));
            }
            this.f6590c.m1();
            f0 f0Var = this.f6588a;
            s sVar6 = this.f6590c;
            f0Var.m(sVar6, sVar6.N, bundle2, false);
            int visibility = this.f6590c.N.getVisibility();
            this.f6590c.z1(this.f6590c.N.getAlpha());
            s sVar7 = this.f6590c;
            if (sVar7.M != null && visibility == 0) {
                View findFocus = sVar7.N.findFocus();
                if (findFocus != null) {
                    this.f6590c.w1(findFocus);
                    if (l0.I0(2)) {
                        Log.v("FragmentManager", "requestFocus: Saved focused view " + findFocus + " for Fragment " + this.f6590c);
                    }
                }
                this.f6590c.N.setAlpha(0.0f);
            }
        }
        this.f6590c.f6597a = 2;
    }

    void g() {
        s f5;
        if (l0.I0(3)) {
            Log.d("FragmentManager", "movefrom CREATED: " + this.f6590c);
        }
        s sVar = this.f6590c;
        boolean z4 = true;
        boolean z5 = sVar.f6616q && !sVar.b0();
        if (z5) {
            s sVar2 = this.f6590c;
            if (!sVar2.f6618s) {
                this.f6589b.B(sVar2.f6607f, null);
            }
        }
        if (!(z5 || this.f6589b.p().p(this.f6590c))) {
            String str = this.f6590c.f6612m;
            if (str != null && (f5 = this.f6589b.f(str)) != null && f5.H) {
                this.f6590c.f6611l = f5;
            }
            this.f6590c.f6597a = 0;
            return;
        }
        d0<?> d0Var = this.f6590c.f6625z;
        if (d0Var instanceof androidx.lifecycle.m0) {
            z4 = this.f6589b.p().m();
        } else if (d0Var.u() instanceof Activity) {
            z4 = true ^ ((Activity) d0Var.u()).isChangingConfigurations();
        }
        if ((z5 && !this.f6590c.f6618s) || z4) {
            this.f6589b.p().f(this.f6590c, false);
        }
        this.f6590c.W0();
        this.f6588a.d(this.f6590c, false);
        for (r0 r0Var : this.f6589b.k()) {
            if (r0Var != null) {
                s k5 = r0Var.k();
                if (this.f6590c.f6607f.equals(k5.f6612m)) {
                    k5.f6611l = this.f6590c;
                    k5.f6612m = null;
                }
            }
        }
        s sVar3 = this.f6590c;
        String str2 = sVar3.f6612m;
        if (str2 != null) {
            sVar3.f6611l = this.f6589b.f(str2);
        }
        this.f6589b.s(this);
    }

    void h() {
        View view;
        if (l0.I0(3)) {
            Log.d("FragmentManager", "movefrom CREATE_VIEW: " + this.f6590c);
        }
        s sVar = this.f6590c;
        ViewGroup viewGroup = sVar.M;
        if (viewGroup != null && (view = sVar.N) != null) {
            viewGroup.removeView(view);
        }
        this.f6590c.X0();
        this.f6588a.n(this.f6590c, false);
        s sVar2 = this.f6590c;
        sVar2.M = null;
        sVar2.N = null;
        sVar2.Z = null;
        sVar2.f6598a0.i(null);
        this.f6590c.f6620u = false;
    }

    void i() {
        if (l0.I0(3)) {
            Log.d("FragmentManager", "movefrom ATTACHED: " + this.f6590c);
        }
        this.f6590c.Y0();
        boolean z4 = false;
        this.f6588a.e(this.f6590c, false);
        s sVar = this.f6590c;
        sVar.f6597a = -1;
        sVar.f6625z = null;
        sVar.B = null;
        sVar.f6624y = null;
        if (sVar.f6616q && !sVar.b0()) {
            z4 = true;
        }
        if (z4 || this.f6589b.p().p(this.f6590c)) {
            if (l0.I0(3)) {
                Log.d("FragmentManager", "initState called for fragment: " + this.f6590c);
            }
            this.f6590c.X();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j() {
        s sVar = this.f6590c;
        if (sVar.f6619t && sVar.f6620u && !sVar.f6622w) {
            if (l0.I0(3)) {
                Log.d("FragmentManager", "moveto CREATE_VIEW: " + this.f6590c);
            }
            Bundle bundle = this.f6590c.f6599b;
            Bundle bundle2 = bundle != null ? bundle.getBundle("savedInstanceState") : null;
            s sVar2 = this.f6590c;
            sVar2.V0(sVar2.Z0(bundle2), null, bundle2);
            View view = this.f6590c.N;
            if (view != null) {
                view.setSaveFromParentEnabled(false);
                s sVar3 = this.f6590c;
                sVar3.N.setTag(n.b.fragment_container_view_tag, sVar3);
                s sVar4 = this.f6590c;
                if (sVar4.F) {
                    sVar4.N.setVisibility(8);
                }
                this.f6590c.m1();
                f0 f0Var = this.f6588a;
                s sVar5 = this.f6590c;
                f0Var.m(sVar5, sVar5.N, bundle2, false);
                this.f6590c.f6597a = 2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public s k() {
        return this.f6590c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void m() {
        ViewGroup viewGroup;
        ViewGroup viewGroup2;
        ViewGroup viewGroup3;
        if (this.f6591d) {
            if (l0.I0(2)) {
                Log.v("FragmentManager", "Ignoring re-entrant call to moveToExpectedState() for " + k());
                return;
            }
            return;
        }
        try {
            this.f6591d = true;
            boolean z4 = false;
            while (true) {
                int d5 = d();
                s sVar = this.f6590c;
                int i5 = sVar.f6597a;
                if (d5 == i5) {
                    if (!z4 && i5 == -1 && sVar.f6616q && !sVar.b0() && !this.f6590c.f6618s) {
                        if (l0.I0(3)) {
                            Log.d("FragmentManager", "Cleaning up state of never attached fragment: " + this.f6590c);
                        }
                        this.f6589b.p().f(this.f6590c, true);
                        this.f6589b.s(this);
                        if (l0.I0(3)) {
                            Log.d("FragmentManager", "initState called for fragment: " + this.f6590c);
                        }
                        this.f6590c.X();
                    }
                    s sVar2 = this.f6590c;
                    if (sVar2.T) {
                        if (sVar2.N != null && (viewGroup = sVar2.M) != null) {
                            b1 u5 = b1.u(viewGroup, sVar2.H());
                            if (this.f6590c.F) {
                                u5.k(this);
                            } else {
                                u5.m(this);
                            }
                        }
                        s sVar3 = this.f6590c;
                        l0 l0Var = sVar3.f6624y;
                        if (l0Var != null) {
                            l0Var.G0(sVar3);
                        }
                        s sVar4 = this.f6590c;
                        sVar4.T = false;
                        sVar4.y0(sVar4.F);
                        this.f6590c.A.I();
                    }
                    return;
                }
                if (d5 > i5) {
                    switch (i5 + 1) {
                        case 0:
                            c();
                            continue;
                        case 1:
                            e();
                            continue;
                        case 2:
                            j();
                            f();
                            continue;
                        case 3:
                            a();
                            continue;
                        case 4:
                            if (sVar.N != null && (viewGroup3 = sVar.M) != null) {
                                b1.u(viewGroup3, sVar.H()).j(b1.d.b.d(this.f6590c.N.getVisibility()), this);
                            }
                            this.f6590c.f6597a = 4;
                            continue;
                        case 5:
                            t();
                            continue;
                        case 6:
                            sVar.f6597a = 6;
                            continue;
                        case 7:
                            p();
                            continue;
                        default:
                            continue;
                    }
                } else {
                    switch (i5 - 1) {
                        case -1:
                            i();
                            continue;
                        case 0:
                            if (sVar.f6618s && this.f6589b.q(sVar.f6607f) == null) {
                                this.f6589b.B(this.f6590c.f6607f, q());
                            }
                            g();
                            continue;
                        case 1:
                            h();
                            this.f6590c.f6597a = 1;
                            continue;
                        case 2:
                            sVar.f6620u = false;
                            sVar.f6597a = 2;
                            continue;
                        case 3:
                            if (l0.I0(3)) {
                                Log.d("FragmentManager", "movefrom ACTIVITY_CREATED: " + this.f6590c);
                            }
                            s sVar5 = this.f6590c;
                            if (sVar5.f6618s) {
                                this.f6589b.B(sVar5.f6607f, q());
                            } else if (sVar5.N != null && sVar5.f6601c == null) {
                                r();
                            }
                            s sVar6 = this.f6590c;
                            if (sVar6.N != null && (viewGroup2 = sVar6.M) != null) {
                                b1.u(viewGroup2, sVar6.H()).l(this);
                            }
                            this.f6590c.f6597a = 3;
                            continue;
                        case 4:
                            u();
                            continue;
                        case 5:
                            sVar.f6597a = 5;
                            continue;
                        case 6:
                            n();
                            continue;
                        default:
                            continue;
                    }
                }
                z4 = true;
            }
        } finally {
            this.f6591d = false;
        }
    }

    void n() {
        if (l0.I0(3)) {
            Log.d("FragmentManager", "movefrom RESUMED: " + this.f6590c);
        }
        this.f6590c.e1();
        this.f6588a.f(this.f6590c, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o(ClassLoader classLoader) {
        Bundle bundle = this.f6590c.f6599b;
        if (bundle == null) {
            return;
        }
        bundle.setClassLoader(classLoader);
        if (this.f6590c.f6599b.getBundle("savedInstanceState") == null) {
            this.f6590c.f6599b.putBundle("savedInstanceState", new Bundle());
        }
        try {
            s sVar = this.f6590c;
            sVar.f6601c = sVar.f6599b.getSparseParcelableArray("viewState");
            s sVar2 = this.f6590c;
            sVar2.f6603d = sVar2.f6599b.getBundle("viewRegistryState");
            q0 q0Var = (q0) this.f6590c.f6599b.getParcelable("state");
            if (q0Var != null) {
                s sVar3 = this.f6590c;
                sVar3.f6612m = q0Var.f6584p;
                sVar3.f6613n = q0Var.f6585q;
                Boolean bool = sVar3.f6605e;
                if (bool != null) {
                    sVar3.P = bool.booleanValue();
                    this.f6590c.f6605e = null;
                } else {
                    sVar3.P = q0Var.f6586r;
                }
            }
            s sVar4 = this.f6590c;
            if (sVar4.P) {
                return;
            }
            sVar4.O = true;
        } catch (BadParcelableException e5) {
            throw new IllegalStateException("Failed to restore view hierarchy state for fragment " + k(), e5);
        }
    }

    void p() {
        if (l0.I0(3)) {
            Log.d("FragmentManager", "moveto RESUMED: " + this.f6590c);
        }
        View B = this.f6590c.B();
        if (B != null && l(B)) {
            boolean requestFocus = B.requestFocus();
            if (l0.I0(2)) {
                StringBuilder sb = new StringBuilder();
                sb.append("requestFocus: Restoring focused view ");
                sb.append(B);
                sb.append(" ");
                sb.append(requestFocus ? "succeeded" : "failed");
                sb.append(" on Fragment ");
                sb.append(this.f6590c);
                sb.append(" resulting in focused view ");
                sb.append(this.f6590c.N.findFocus());
                Log.v("FragmentManager", sb.toString());
            }
        }
        this.f6590c.w1(null);
        this.f6590c.i1();
        this.f6588a.i(this.f6590c, false);
        this.f6589b.B(this.f6590c.f6607f, null);
        s sVar = this.f6590c;
        sVar.f6599b = null;
        sVar.f6601c = null;
        sVar.f6603d = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Bundle q() {
        Bundle bundle;
        Bundle bundle2 = new Bundle();
        s sVar = this.f6590c;
        if (sVar.f6597a == -1 && (bundle = sVar.f6599b) != null) {
            bundle2.putAll(bundle);
        }
        bundle2.putParcelable("state", new q0(this.f6590c));
        if (this.f6590c.f6597a > -1) {
            Bundle bundle3 = new Bundle();
            this.f6590c.j1(bundle3);
            if (!bundle3.isEmpty()) {
                bundle2.putBundle("savedInstanceState", bundle3);
            }
            this.f6588a.j(this.f6590c, bundle3, false);
            Bundle bundle4 = new Bundle();
            this.f6590c.f6602c0.e(bundle4);
            if (!bundle4.isEmpty()) {
                bundle2.putBundle("registryState", bundle4);
            }
            Bundle Q0 = this.f6590c.A.Q0();
            if (!Q0.isEmpty()) {
                bundle2.putBundle("childFragmentManager", Q0);
            }
            if (this.f6590c.N != null) {
                r();
            }
            SparseArray<Parcelable> sparseArray = this.f6590c.f6601c;
            if (sparseArray != null) {
                bundle2.putSparseParcelableArray("viewState", sparseArray);
            }
            Bundle bundle5 = this.f6590c.f6603d;
            if (bundle5 != null) {
                bundle2.putBundle("viewRegistryState", bundle5);
            }
        }
        Bundle bundle6 = this.f6590c.f6610k;
        if (bundle6 != null) {
            bundle2.putBundle("arguments", bundle6);
        }
        return bundle2;
    }

    void r() {
        if (this.f6590c.N == null) {
            return;
        }
        if (l0.I0(2)) {
            Log.v("FragmentManager", "Saving view state for fragment " + this.f6590c + " with view " + this.f6590c.N);
        }
        SparseArray<Parcelable> sparseArray = new SparseArray<>();
        this.f6590c.N.saveHierarchyState(sparseArray);
        if (sparseArray.size() > 0) {
            this.f6590c.f6601c = sparseArray;
        }
        Bundle bundle = new Bundle();
        this.f6590c.Z.f(bundle);
        if (bundle.isEmpty()) {
            return;
        }
        this.f6590c.f6603d = bundle;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void s(int i5) {
        this.f6592e = i5;
    }

    void t() {
        if (l0.I0(3)) {
            Log.d("FragmentManager", "moveto STARTED: " + this.f6590c);
        }
        this.f6590c.k1();
        this.f6588a.k(this.f6590c, false);
    }

    void u() {
        if (l0.I0(3)) {
            Log.d("FragmentManager", "movefrom STARTED: " + this.f6590c);
        }
        this.f6590c.l1();
        this.f6588a.l(this.f6590c, false);
    }
}
