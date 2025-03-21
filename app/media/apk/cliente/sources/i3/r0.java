package i3;

import i3.a;
import i3.k;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;
/* loaded from: classes.dex */
public abstract class r0 {

    /* renamed from: b  reason: collision with root package name */
    public static final a.c<Map<String, ?>> f3539b = a.c.a("internal:health-checking-config");

    /* renamed from: a  reason: collision with root package name */
    private int f3540a;

    /* loaded from: classes.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private final List<x> f3541a;

        /* renamed from: b  reason: collision with root package name */
        private final i3.a f3542b;

        /* renamed from: c  reason: collision with root package name */
        private final Object[][] f3543c;

        /* loaded from: classes.dex */
        public static final class a {

            /* renamed from: a  reason: collision with root package name */
            private List<x> f3544a;

            /* renamed from: b  reason: collision with root package name */
            private i3.a f3545b = i3.a.f3307c;

            /* renamed from: c  reason: collision with root package name */
            private Object[][] f3546c = (Object[][]) Array.newInstance(Object.class, 0, 2);

            a() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public a c(Object[][] objArr) {
                Object[][] objArr2 = (Object[][]) Array.newInstance(Object.class, objArr.length, 2);
                this.f3546c = objArr2;
                System.arraycopy(objArr, 0, objArr2, 0, objArr.length);
                return this;
            }

            public b b() {
                return new b(this.f3544a, this.f3545b, this.f3546c);
            }

            public a d(x xVar) {
                this.f3544a = Collections.singletonList(xVar);
                return this;
            }

            public a e(List<x> list) {
                z0.k.e(!list.isEmpty(), "addrs is empty");
                this.f3544a = Collections.unmodifiableList(new ArrayList(list));
                return this;
            }

            public a f(i3.a aVar) {
                this.f3545b = (i3.a) z0.k.o(aVar, "attrs");
                return this;
            }
        }

        private b(List<x> list, i3.a aVar, Object[][] objArr) {
            this.f3541a = (List) z0.k.o(list, "addresses are not set");
            this.f3542b = (i3.a) z0.k.o(aVar, "attrs");
            this.f3543c = (Object[][]) z0.k.o(objArr, "customOptions");
        }

        public static a c() {
            return new a();
        }

        public List<x> a() {
            return this.f3541a;
        }

        public i3.a b() {
            return this.f3542b;
        }

        public a d() {
            return c().e(this.f3541a).f(this.f3542b).c(this.f3543c);
        }

        public String toString() {
            return z0.f.b(this).d("addrs", this.f3541a).d("attrs", this.f3542b).d("customOptions", Arrays.deepToString(this.f3543c)).toString();
        }
    }

    /* loaded from: classes.dex */
    public static abstract class c {
        public abstract r0 a(d dVar);
    }

    /* loaded from: classes.dex */
    public static abstract class d {
        public h a(b bVar) {
            throw new UnsupportedOperationException();
        }

        public i3.f b() {
            throw new UnsupportedOperationException();
        }

        public ScheduledExecutorService c() {
            throw new UnsupportedOperationException();
        }

        public n1 d() {
            throw new UnsupportedOperationException();
        }

        public void e() {
            throw new UnsupportedOperationException();
        }

        public abstract void f(p pVar, i iVar);
    }

    /* loaded from: classes.dex */
    public static final class e {

        /* renamed from: e  reason: collision with root package name */
        private static final e f3547e = new e(null, null, j1.f3432f, false);

        /* renamed from: a  reason: collision with root package name */
        private final h f3548a;

        /* renamed from: b  reason: collision with root package name */
        private final k.a f3549b;

        /* renamed from: c  reason: collision with root package name */
        private final j1 f3550c;

        /* renamed from: d  reason: collision with root package name */
        private final boolean f3551d;

        private e(h hVar, k.a aVar, j1 j1Var, boolean z4) {
            this.f3548a = hVar;
            this.f3549b = aVar;
            this.f3550c = (j1) z0.k.o(j1Var, "status");
            this.f3551d = z4;
        }

        public static e e(j1 j1Var) {
            z0.k.e(!j1Var.o(), "drop status shouldn't be OK");
            return new e(null, null, j1Var, true);
        }

        public static e f(j1 j1Var) {
            z0.k.e(!j1Var.o(), "error status shouldn't be OK");
            return new e(null, null, j1Var, false);
        }

        public static e g() {
            return f3547e;
        }

        public static e h(h hVar) {
            return i(hVar, null);
        }

        public static e i(h hVar, k.a aVar) {
            return new e((h) z0.k.o(hVar, "subchannel"), aVar, j1.f3432f, false);
        }

        public j1 a() {
            return this.f3550c;
        }

        public k.a b() {
            return this.f3549b;
        }

        public h c() {
            return this.f3548a;
        }

        public boolean d() {
            return this.f3551d;
        }

        public boolean equals(Object obj) {
            if (obj instanceof e) {
                e eVar = (e) obj;
                return z0.g.a(this.f3548a, eVar.f3548a) && z0.g.a(this.f3550c, eVar.f3550c) && z0.g.a(this.f3549b, eVar.f3549b) && this.f3551d == eVar.f3551d;
            }
            return false;
        }

        public int hashCode() {
            return z0.g.b(this.f3548a, this.f3550c, this.f3549b, Boolean.valueOf(this.f3551d));
        }

        public String toString() {
            return z0.f.b(this).d("subchannel", this.f3548a).d("streamTracerFactory", this.f3549b).d("status", this.f3550c).e("drop", this.f3551d).toString();
        }
    }

    /* loaded from: classes.dex */
    public static abstract class f {
        public abstract i3.c a();

        public abstract y0 b();

        public abstract z0<?, ?> c();
    }

    /* loaded from: classes.dex */
    public static final class g {

        /* renamed from: a  reason: collision with root package name */
        private final List<x> f3552a;

        /* renamed from: b  reason: collision with root package name */
        private final i3.a f3553b;

        /* renamed from: c  reason: collision with root package name */
        private final Object f3554c;

        /* loaded from: classes.dex */
        public static final class a {

            /* renamed from: a  reason: collision with root package name */
            private List<x> f3555a;

            /* renamed from: b  reason: collision with root package name */
            private i3.a f3556b = i3.a.f3307c;

            /* renamed from: c  reason: collision with root package name */
            private Object f3557c;

            a() {
            }

            public g a() {
                return new g(this.f3555a, this.f3556b, this.f3557c);
            }

            public a b(List<x> list) {
                this.f3555a = list;
                return this;
            }

            public a c(i3.a aVar) {
                this.f3556b = aVar;
                return this;
            }

            public a d(Object obj) {
                this.f3557c = obj;
                return this;
            }
        }

        private g(List<x> list, i3.a aVar, Object obj) {
            this.f3552a = Collections.unmodifiableList(new ArrayList((Collection) z0.k.o(list, "addresses")));
            this.f3553b = (i3.a) z0.k.o(aVar, "attributes");
            this.f3554c = obj;
        }

        public static a d() {
            return new a();
        }

        public List<x> a() {
            return this.f3552a;
        }

        public i3.a b() {
            return this.f3553b;
        }

        public Object c() {
            return this.f3554c;
        }

        public a e() {
            return d().b(this.f3552a).c(this.f3553b).d(this.f3554c);
        }

        public boolean equals(Object obj) {
            if (obj instanceof g) {
                g gVar = (g) obj;
                return z0.g.a(this.f3552a, gVar.f3552a) && z0.g.a(this.f3553b, gVar.f3553b) && z0.g.a(this.f3554c, gVar.f3554c);
            }
            return false;
        }

        public int hashCode() {
            return z0.g.b(this.f3552a, this.f3553b, this.f3554c);
        }

        public String toString() {
            return z0.f.b(this).d("addresses", this.f3552a).d("attributes", this.f3553b).d("loadBalancingPolicyConfig", this.f3554c).toString();
        }
    }

    /* loaded from: classes.dex */
    public static abstract class h {
        public final x a() {
            List<x> b5 = b();
            z0.k.w(b5.size() == 1, "%s does not have exactly one group", b5);
            return b5.get(0);
        }

        public List<x> b() {
            throw new UnsupportedOperationException();
        }

        public abstract i3.a c();

        public i3.f d() {
            throw new UnsupportedOperationException();
        }

        public Object e() {
            throw new UnsupportedOperationException();
        }

        public abstract void f();

        public abstract void g();

        public void h(j jVar) {
            throw new UnsupportedOperationException("Not implemented");
        }

        public void i(List<x> list) {
            throw new UnsupportedOperationException();
        }
    }

    /* loaded from: classes.dex */
    public static abstract class i {
        public abstract e a(f fVar);

        @Deprecated
        public void b() {
        }
    }

    /* loaded from: classes.dex */
    public interface j {
        void a(q qVar);
    }

    public boolean a(g gVar) {
        if (!gVar.a().isEmpty() || b()) {
            int i5 = this.f3540a;
            this.f3540a = i5 + 1;
            if (i5 == 0) {
                d(gVar);
            }
            this.f3540a = 0;
            return true;
        }
        j1 j1Var = j1.f3447u;
        c(j1Var.q("NameResolver returned no usable address. addrs=" + gVar.a() + ", attrs=" + gVar.b()));
        return false;
    }

    public boolean b() {
        return false;
    }

    public abstract void c(j1 j1Var);

    public void d(g gVar) {
        int i5 = this.f3540a;
        this.f3540a = i5 + 1;
        if (i5 == 0) {
            a(gVar);
        }
        this.f3540a = 0;
    }

    public void e() {
    }

    public abstract void f();
}
