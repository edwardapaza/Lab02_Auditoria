package o;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
/* loaded from: classes.dex */
public abstract class b1 {

    /* renamed from: f  reason: collision with root package name */
    public static final a f6374f = new a(null);

    /* renamed from: a  reason: collision with root package name */
    private final ViewGroup f6375a;

    /* renamed from: b  reason: collision with root package name */
    private final List<d> f6376b;

    /* renamed from: c  reason: collision with root package name */
    private final List<d> f6377c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f6378d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f6379e;

    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(e4.g gVar) {
            this();
        }

        public final b1 a(ViewGroup viewGroup, l0 l0Var) {
            e4.k.e(viewGroup, "container");
            e4.k.e(l0Var, "fragmentManager");
            c1 A0 = l0Var.A0();
            e4.k.d(A0, "fragmentManager.specialEffectsControllerFactory");
            return b(viewGroup, A0);
        }

        public final b1 b(ViewGroup viewGroup, c1 c1Var) {
            e4.k.e(viewGroup, "container");
            e4.k.e(c1Var, "factory");
            int i5 = n.b.special_effects_controller_view_tag;
            Object tag = viewGroup.getTag(i5);
            if (tag instanceof b1) {
                return (b1) tag;
            }
            b1 a5 = c1Var.a(viewGroup);
            e4.k.d(a5, "factory.createController(container)");
            viewGroup.setTag(i5, a5);
            return a5;
        }
    }

    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        private final boolean f6380a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f6381b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f6382c;

        public final void a(ViewGroup viewGroup) {
            e4.k.e(viewGroup, "container");
            if (!this.f6382c) {
                c(viewGroup);
            }
            this.f6382c = true;
        }

        public boolean b() {
            return this.f6380a;
        }

        public void c(ViewGroup viewGroup) {
            e4.k.e(viewGroup, "container");
        }

        public void d(ViewGroup viewGroup) {
            e4.k.e(viewGroup, "container");
        }

        public void e(androidx.activity.b bVar, ViewGroup viewGroup) {
            e4.k.e(bVar, "backEvent");
            e4.k.e(viewGroup, "container");
        }

        public void f(ViewGroup viewGroup) {
            e4.k.e(viewGroup, "container");
        }

        public final void g(ViewGroup viewGroup) {
            e4.k.e(viewGroup, "container");
            if (!this.f6381b) {
                f(viewGroup);
            }
            this.f6381b = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class c extends d {

        /* renamed from: l  reason: collision with root package name */
        private final r0 f6383l;

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public c(o.b1.d.b r3, o.b1.d.a r4, o.r0 r5) {
            /*
                r2 = this;
                java.lang.String r0 = "finalState"
                e4.k.e(r3, r0)
                java.lang.String r0 = "lifecycleImpact"
                e4.k.e(r4, r0)
                java.lang.String r0 = "fragmentStateManager"
                e4.k.e(r5, r0)
                o.s r0 = r5.k()
                java.lang.String r1 = "fragmentStateManager.fragment"
                e4.k.d(r0, r1)
                r2.<init>(r3, r4, r0)
                r2.f6383l = r5
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: o.b1.c.<init>(o.b1$d$b, o.b1$d$a, o.r0):void");
        }

        @Override // o.b1.d
        public void e() {
            super.e();
            i().f6617r = false;
            this.f6383l.m();
        }

        @Override // o.b1.d
        public void q() {
            if (o()) {
                return;
            }
            super.q();
            if (j() != d.a.ADDING) {
                if (j() == d.a.REMOVING) {
                    s k5 = this.f6383l.k();
                    e4.k.d(k5, "fragmentStateManager.fragment");
                    View q12 = k5.q1();
                    e4.k.d(q12, "fragment.requireView()");
                    if (l0.I0(2)) {
                        Log.v("FragmentManager", "Clearing focus " + q12.findFocus() + " on view " + q12 + " for Fragment " + k5);
                    }
                    q12.clearFocus();
                    return;
                }
                return;
            }
            s k6 = this.f6383l.k();
            e4.k.d(k6, "fragmentStateManager.fragment");
            View findFocus = k6.N.findFocus();
            if (findFocus != null) {
                k6.w1(findFocus);
                if (l0.I0(2)) {
                    Log.v("FragmentManager", "requestFocus: Saved focused view " + findFocus + " for Fragment " + k6);
                }
            }
            View q13 = i().q1();
            e4.k.d(q13, "this.fragment.requireView()");
            if (q13.getParent() == null) {
                this.f6383l.b();
                q13.setAlpha(0.0f);
            }
            if ((q13.getAlpha() == 0.0f) && q13.getVisibility() == 0) {
                q13.setVisibility(4);
            }
            q13.setAlpha(k6.L());
        }
    }

    /* loaded from: classes.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        private b f6384a;

        /* renamed from: b  reason: collision with root package name */
        private a f6385b;

        /* renamed from: c  reason: collision with root package name */
        private final s f6386c;

        /* renamed from: d  reason: collision with root package name */
        private final List<Runnable> f6387d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f6388e;

        /* renamed from: f  reason: collision with root package name */
        private boolean f6389f;

        /* renamed from: g  reason: collision with root package name */
        private boolean f6390g;

        /* renamed from: h  reason: collision with root package name */
        private boolean f6391h;

        /* renamed from: i  reason: collision with root package name */
        private boolean f6392i;

        /* renamed from: j  reason: collision with root package name */
        private final List<b> f6393j;

        /* renamed from: k  reason: collision with root package name */
        private final List<b> f6394k;

        /* loaded from: classes.dex */
        public enum a {
            NONE,
            ADDING,
            REMOVING
        }

        /* loaded from: classes.dex */
        public enum b {
            REMOVED,
            VISIBLE,
            GONE,
            INVISIBLE;
            

            /* renamed from: a  reason: collision with root package name */
            public static final a f6399a = new a(null);

            /* loaded from: classes.dex */
            public static final class a {
                private a() {
                }

                public /* synthetic */ a(e4.g gVar) {
                    this();
                }

                public final b a(View view) {
                    e4.k.e(view, "<this>");
                    return (((view.getAlpha() > 0.0f ? 1 : (view.getAlpha() == 0.0f ? 0 : -1)) == 0) && view.getVisibility() == 0) ? b.INVISIBLE : b(view.getVisibility());
                }

                public final b b(int i5) {
                    if (i5 != 0) {
                        if (i5 != 4) {
                            if (i5 == 8) {
                                return b.GONE;
                            }
                            throw new IllegalArgumentException("Unknown visibility " + i5);
                        }
                        return b.INVISIBLE;
                    }
                    return b.VISIBLE;
                }
            }

            /* renamed from: o.b1$d$b$b  reason: collision with other inner class name */
            /* loaded from: classes.dex */
            public /* synthetic */ class C0100b {

                /* renamed from: a  reason: collision with root package name */
                public static final /* synthetic */ int[] f6405a;

                static {
                    int[] iArr = new int[b.values().length];
                    try {
                        iArr[b.REMOVED.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[b.VISIBLE.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[b.GONE.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    try {
                        iArr[b.INVISIBLE.ordinal()] = 4;
                    } catch (NoSuchFieldError unused4) {
                    }
                    f6405a = iArr;
                }
            }

            public static final b d(int i5) {
                return f6399a.b(i5);
            }

            public final void c(View view, ViewGroup viewGroup) {
                int i5;
                e4.k.e(view, "view");
                e4.k.e(viewGroup, "container");
                int i6 = C0100b.f6405a[ordinal()];
                if (i6 == 1) {
                    ViewParent parent = view.getParent();
                    ViewGroup viewGroup2 = parent instanceof ViewGroup ? (ViewGroup) parent : null;
                    if (viewGroup2 != null) {
                        if (l0.I0(2)) {
                            Log.v("FragmentManager", "SpecialEffectsController: Removing view " + view + " from container " + viewGroup2);
                        }
                        viewGroup2.removeView(view);
                        return;
                    }
                    return;
                }
                if (i6 == 2) {
                    if (l0.I0(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: Setting view " + view + " to VISIBLE");
                    }
                    ViewParent parent2 = view.getParent();
                    if ((parent2 instanceof ViewGroup ? (ViewGroup) parent2 : null) == null) {
                        if (l0.I0(2)) {
                            Log.v("FragmentManager", "SpecialEffectsController: Adding view " + view + " to Container " + viewGroup);
                        }
                        viewGroup.addView(view);
                    }
                    i5 = 0;
                } else if (i6 != 3) {
                    i5 = 4;
                    if (i6 != 4) {
                        return;
                    }
                    if (l0.I0(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: Setting view " + view + " to INVISIBLE");
                    }
                } else {
                    if (l0.I0(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: Setting view " + view + " to GONE");
                    }
                    i5 = 8;
                }
                view.setVisibility(i5);
            }
        }

        /* loaded from: classes.dex */
        public /* synthetic */ class c {

            /* renamed from: a  reason: collision with root package name */
            public static final /* synthetic */ int[] f6406a;

            static {
                int[] iArr = new int[a.values().length];
                try {
                    iArr[a.ADDING.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[a.REMOVING.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[a.NONE.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                f6406a = iArr;
            }
        }

        public d(b bVar, a aVar, s sVar) {
            e4.k.e(bVar, "finalState");
            e4.k.e(aVar, "lifecycleImpact");
            e4.k.e(sVar, "fragment");
            this.f6384a = bVar;
            this.f6385b = aVar;
            this.f6386c = sVar;
            this.f6387d = new ArrayList();
            this.f6392i = true;
            ArrayList arrayList = new ArrayList();
            this.f6393j = arrayList;
            this.f6394k = arrayList;
        }

        public final void a(Runnable runnable) {
            e4.k.e(runnable, "listener");
            this.f6387d.add(runnable);
        }

        public final void b(b bVar) {
            e4.k.e(bVar, "effect");
            this.f6393j.add(bVar);
        }

        public final void c(ViewGroup viewGroup) {
            List<b> H;
            e4.k.e(viewGroup, "container");
            this.f6391h = false;
            if (this.f6388e) {
                return;
            }
            this.f6388e = true;
            if (this.f6393j.isEmpty()) {
                e();
                return;
            }
            H = t3.x.H(this.f6394k);
            for (b bVar : H) {
                bVar.a(viewGroup);
            }
        }

        public final void d(ViewGroup viewGroup, boolean z4) {
            e4.k.e(viewGroup, "container");
            if (this.f6388e) {
                return;
            }
            if (z4) {
                this.f6390g = true;
            }
            c(viewGroup);
        }

        public void e() {
            this.f6391h = false;
            if (this.f6389f) {
                return;
            }
            if (l0.I0(2)) {
                Log.v("FragmentManager", "SpecialEffectsController: " + this + " has called complete.");
            }
            this.f6389f = true;
            for (Runnable runnable : this.f6387d) {
                runnable.run();
            }
        }

        public final void f(b bVar) {
            e4.k.e(bVar, "effect");
            if (this.f6393j.remove(bVar) && this.f6393j.isEmpty()) {
                e();
            }
        }

        public final List<b> g() {
            return this.f6394k;
        }

        public final b h() {
            return this.f6384a;
        }

        public final s i() {
            return this.f6386c;
        }

        public final a j() {
            return this.f6385b;
        }

        public final boolean k() {
            return this.f6392i;
        }

        public final boolean l() {
            return this.f6388e;
        }

        public final boolean m() {
            return this.f6389f;
        }

        public final boolean n() {
            return this.f6390g;
        }

        public final boolean o() {
            return this.f6391h;
        }

        public final void p(b bVar, a aVar) {
            a aVar2;
            e4.k.e(bVar, "finalState");
            e4.k.e(aVar, "lifecycleImpact");
            int i5 = c.f6406a[aVar.ordinal()];
            if (i5 != 1) {
                if (i5 != 2) {
                    if (i5 == 3 && this.f6384a != b.REMOVED) {
                        if (l0.I0(2)) {
                            Log.v("FragmentManager", "SpecialEffectsController: For fragment " + this.f6386c + " mFinalState = " + this.f6384a + " -> " + bVar + '.');
                        }
                        this.f6384a = bVar;
                        return;
                    }
                    return;
                }
                if (l0.I0(2)) {
                    Log.v("FragmentManager", "SpecialEffectsController: For fragment " + this.f6386c + " mFinalState = " + this.f6384a + " -> REMOVED. mLifecycleImpact  = " + this.f6385b + " to REMOVING.");
                }
                this.f6384a = b.REMOVED;
                aVar2 = a.REMOVING;
            } else if (this.f6384a != b.REMOVED) {
                return;
            } else {
                if (l0.I0(2)) {
                    Log.v("FragmentManager", "SpecialEffectsController: For fragment " + this.f6386c + " mFinalState = REMOVED -> VISIBLE. mLifecycleImpact = " + this.f6385b + " to ADDING.");
                }
                this.f6384a = b.VISIBLE;
                aVar2 = a.ADDING;
            }
            this.f6385b = aVar2;
            this.f6392i = true;
        }

        public void q() {
            this.f6391h = true;
        }

        public final void r(boolean z4) {
            this.f6392i = z4;
        }

        public String toString() {
            String hexString = Integer.toHexString(System.identityHashCode(this));
            return "Operation {" + hexString + "} {finalState = " + this.f6384a + " lifecycleImpact = " + this.f6385b + " fragment = " + this.f6386c + '}';
        }
    }

    /* loaded from: classes.dex */
    public /* synthetic */ class e {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f6407a;

        static {
            int[] iArr = new int[d.a.values().length];
            try {
                iArr[d.a.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            f6407a = iArr;
        }
    }

    public b1(ViewGroup viewGroup) {
        e4.k.e(viewGroup, "container");
        this.f6375a = viewGroup;
        this.f6376b = new ArrayList();
        this.f6377c = new ArrayList();
    }

    private final void A() {
        for (d dVar : this.f6376b) {
            if (dVar.j() == d.a.ADDING) {
                View q12 = dVar.i().q1();
                e4.k.d(q12, "fragment.requireView()");
                dVar.p(d.b.f6399a.b(q12.getVisibility()), d.a.NONE);
            }
        }
    }

    private final void g(d.b bVar, d.a aVar, r0 r0Var) {
        synchronized (this.f6376b) {
            s k5 = r0Var.k();
            e4.k.d(k5, "fragmentStateManager.fragment");
            d o5 = o(k5);
            if (o5 == null) {
                if (r0Var.k().f6617r) {
                    s k6 = r0Var.k();
                    e4.k.d(k6, "fragmentStateManager.fragment");
                    o5 = p(k6);
                } else {
                    o5 = null;
                }
            }
            if (o5 != null) {
                o5.p(bVar, aVar);
                return;
            }
            final c cVar = new c(bVar, aVar, r0Var);
            this.f6376b.add(cVar);
            cVar.a(new Runnable() { // from class: o.z0
                @Override // java.lang.Runnable
                public final void run() {
                    b1.h(b1.this, cVar);
                }
            });
            cVar.a(new Runnable() { // from class: o.a1
                @Override // java.lang.Runnable
                public final void run() {
                    b1.i(b1.this, cVar);
                }
            });
            s3.t tVar = s3.t.f7573a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(b1 b1Var, c cVar) {
        e4.k.e(b1Var, "this$0");
        e4.k.e(cVar, "$operation");
        if (b1Var.f6376b.contains(cVar)) {
            d.b h5 = cVar.h();
            View view = cVar.i().N;
            e4.k.d(view, "operation.fragment.mView");
            h5.c(view, b1Var.f6375a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(b1 b1Var, c cVar) {
        e4.k.e(b1Var, "this$0");
        e4.k.e(cVar, "$operation");
        b1Var.f6376b.remove(cVar);
        b1Var.f6377c.remove(cVar);
    }

    private final d o(s sVar) {
        Object obj;
        boolean z4;
        Iterator<T> it = this.f6376b.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            d dVar = (d) obj;
            if (!e4.k.a(dVar.i(), sVar) || dVar.l()) {
                z4 = false;
                continue;
            } else {
                z4 = true;
                continue;
            }
            if (z4) {
                break;
            }
        }
        return (d) obj;
    }

    private final d p(s sVar) {
        Object obj;
        boolean z4;
        Iterator<T> it = this.f6377c.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            d dVar = (d) obj;
            if (!e4.k.a(dVar.i(), sVar) || dVar.l()) {
                z4 = false;
                continue;
            } else {
                z4 = true;
                continue;
            }
            if (z4) {
                break;
            }
        }
        return (d) obj;
    }

    public static final b1 u(ViewGroup viewGroup, l0 l0Var) {
        return f6374f.a(viewGroup, l0Var);
    }

    public static final b1 v(ViewGroup viewGroup, c1 c1Var) {
        return f6374f.b(viewGroup, c1Var);
    }

    private final void z(List<d> list) {
        Set L;
        List H;
        int size = list.size();
        for (int i5 = 0; i5 < size; i5++) {
            list.get(i5).q();
        }
        ArrayList arrayList = new ArrayList();
        for (d dVar : list) {
            t3.u.l(arrayList, dVar.g());
        }
        L = t3.x.L(arrayList);
        H = t3.x.H(L);
        int size2 = H.size();
        for (int i6 = 0; i6 < size2; i6++) {
            ((b) H.get(i6)).g(this.f6375a);
        }
    }

    public final void B(boolean z4) {
        this.f6378d = z4;
    }

    public final void c(d dVar) {
        e4.k.e(dVar, "operation");
        if (dVar.k()) {
            d.b h5 = dVar.h();
            View q12 = dVar.i().q1();
            e4.k.d(q12, "operation.fragment.requireView()");
            h5.c(q12, this.f6375a);
            dVar.r(false);
        }
    }

    public abstract void d(List<d> list, boolean z4);

    public void e(List<d> list) {
        Set L;
        List H;
        List H2;
        e4.k.e(list, "operations");
        ArrayList arrayList = new ArrayList();
        for (d dVar : list) {
            t3.u.l(arrayList, dVar.g());
        }
        L = t3.x.L(arrayList);
        H = t3.x.H(L);
        int size = H.size();
        for (int i5 = 0; i5 < size; i5++) {
            ((b) H.get(i5)).d(this.f6375a);
        }
        int size2 = list.size();
        for (int i6 = 0; i6 < size2; i6++) {
            c(list.get(i6));
        }
        H2 = t3.x.H(list);
        int size3 = H2.size();
        for (int i7 = 0; i7 < size3; i7++) {
            d dVar2 = (d) H2.get(i7);
            if (dVar2.g().isEmpty()) {
                dVar2.e();
            }
        }
    }

    public final void f() {
        if (l0.I0(3)) {
            Log.d("FragmentManager", "SpecialEffectsController: Completing Back ");
        }
        z(this.f6377c);
        e(this.f6377c);
    }

    public final void j(d.b bVar, r0 r0Var) {
        e4.k.e(bVar, "finalState");
        e4.k.e(r0Var, "fragmentStateManager");
        if (l0.I0(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Enqueuing add operation for fragment " + r0Var.k());
        }
        g(bVar, d.a.ADDING, r0Var);
    }

    public final void k(r0 r0Var) {
        e4.k.e(r0Var, "fragmentStateManager");
        if (l0.I0(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Enqueuing hide operation for fragment " + r0Var.k());
        }
        g(d.b.GONE, d.a.NONE, r0Var);
    }

    public final void l(r0 r0Var) {
        e4.k.e(r0Var, "fragmentStateManager");
        if (l0.I0(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Enqueuing remove operation for fragment " + r0Var.k());
        }
        g(d.b.REMOVED, d.a.REMOVING, r0Var);
    }

    public final void m(r0 r0Var) {
        e4.k.e(r0Var, "fragmentStateManager");
        if (l0.I0(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Enqueuing show operation for fragment " + r0Var.k());
        }
        g(d.b.VISIBLE, d.a.NONE, r0Var);
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x00f5 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0172 A[Catch: all -> 0x01a4, TryCatch #0 {, blocks: (B:11:0x0017, B:13:0x0020, B:14:0x002f, B:16:0x0035, B:18:0x0041, B:19:0x005c, B:21:0x0067, B:80:0x01a0, B:22:0x006d, B:23:0x007c, B:25:0x0082, B:27:0x008e, B:28:0x00a4, B:30:0x00b5, B:31:0x00bb, B:35:0x00cc, B:37:0x00dc, B:38:0x00e3, B:39:0x00f5, B:41:0x00fb, B:43:0x010c, B:45:0x0114, B:57:0x0138, B:48:0x011c, B:49:0x0120, B:51:0x0126, B:60:0x0144, B:62:0x0148, B:63:0x0151, B:65:0x0157, B:66:0x0165, B:70:0x016e, B:72:0x0172, B:77:0x0191, B:79:0x0199, B:74:0x017b, B:76:0x0185), top: B:86:0x0017 }] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0179  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0199 A[Catch: all -> 0x01a4, TryCatch #0 {, blocks: (B:11:0x0017, B:13:0x0020, B:14:0x002f, B:16:0x0035, B:18:0x0041, B:19:0x005c, B:21:0x0067, B:80:0x01a0, B:22:0x006d, B:23:0x007c, B:25:0x0082, B:27:0x008e, B:28:0x00a4, B:30:0x00b5, B:31:0x00bb, B:35:0x00cc, B:37:0x00dc, B:38:0x00e3, B:39:0x00f5, B:41:0x00fb, B:43:0x010c, B:45:0x0114, B:57:0x0138, B:48:0x011c, B:49:0x0120, B:51:0x0126, B:60:0x0144, B:62:0x0148, B:63:0x0151, B:65:0x0157, B:66:0x0165, B:70:0x016e, B:72:0x0172, B:77:0x0191, B:79:0x0199, B:74:0x017b, B:76:0x0185), top: B:86:0x0017 }] */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0142 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void n() {
        /*
            Method dump skipped, instructions count: 423
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: o.b1.n():void");
    }

    public final void q() {
        List<d> K;
        List<d> K2;
        if (l0.I0(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Forcing all operations to complete");
        }
        boolean isAttachedToWindow = this.f6375a.isAttachedToWindow();
        synchronized (this.f6376b) {
            A();
            z(this.f6376b);
            K = t3.x.K(this.f6377c);
            for (d dVar : K) {
                if (l0.I0(2)) {
                    Log.v("FragmentManager", "SpecialEffectsController: " + (isAttachedToWindow ? "" : "Container " + this.f6375a + " is not attached to window. ") + "Cancelling running operation " + dVar);
                }
                dVar.c(this.f6375a);
            }
            K2 = t3.x.K(this.f6376b);
            for (d dVar2 : K2) {
                if (l0.I0(2)) {
                    Log.v("FragmentManager", "SpecialEffectsController: " + (isAttachedToWindow ? "" : "Container " + this.f6375a + " is not attached to window. ") + "Cancelling pending operation " + dVar2);
                }
                dVar2.c(this.f6375a);
            }
            s3.t tVar = s3.t.f7573a;
        }
    }

    public final void r() {
        if (this.f6379e) {
            if (l0.I0(2)) {
                Log.v("FragmentManager", "SpecialEffectsController: Forcing postponed operations");
            }
            this.f6379e = false;
            n();
        }
    }

    public final d.a s(r0 r0Var) {
        e4.k.e(r0Var, "fragmentStateManager");
        s k5 = r0Var.k();
        e4.k.d(k5, "fragmentStateManager.fragment");
        d o5 = o(k5);
        d.a j5 = o5 != null ? o5.j() : null;
        d p5 = p(k5);
        d.a j6 = p5 != null ? p5.j() : null;
        int i5 = j5 == null ? -1 : e.f6407a[j5.ordinal()];
        return (i5 == -1 || i5 == 1) ? j6 : j5;
    }

    public final ViewGroup t() {
        return this.f6375a;
    }

    public final boolean w() {
        return !this.f6376b.isEmpty();
    }

    public final void x() {
        d dVar;
        boolean z4;
        synchronized (this.f6376b) {
            A();
            List<d> list = this.f6376b;
            ListIterator<d> listIterator = list.listIterator(list.size());
            while (true) {
                if (!listIterator.hasPrevious()) {
                    dVar = null;
                    break;
                }
                dVar = listIterator.previous();
                d dVar2 = dVar;
                d.b.a aVar = d.b.f6399a;
                View view = dVar2.i().N;
                e4.k.d(view, "operation.fragment.mView");
                d.b a5 = aVar.a(view);
                d.b h5 = dVar2.h();
                d.b bVar = d.b.VISIBLE;
                if (h5 != bVar || a5 == bVar) {
                    z4 = false;
                    continue;
                } else {
                    z4 = true;
                    continue;
                }
                if (z4) {
                    break;
                }
            }
            d dVar3 = dVar;
            s i5 = dVar3 != null ? dVar3.i() : null;
            this.f6379e = i5 != null ? i5.d0() : false;
            s3.t tVar = s3.t.f7573a;
        }
    }

    public final void y(androidx.activity.b bVar) {
        Set L;
        List H;
        e4.k.e(bVar, "backEvent");
        if (l0.I0(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Processing Progress " + bVar.a());
        }
        List<d> list = this.f6377c;
        ArrayList arrayList = new ArrayList();
        for (d dVar : list) {
            t3.u.l(arrayList, dVar.g());
        }
        L = t3.x.L(arrayList);
        H = t3.x.H(L);
        int size = H.size();
        for (int i5 = 0; i5 < size; i5++) {
            ((b) H.get(i5)).e(bVar, this.f6375a);
        }
    }
}
