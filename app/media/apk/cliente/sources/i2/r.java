package i2;

import i3.z0;
import p3.b;
/* loaded from: classes.dex */
public final class r {

    /* renamed from: a  reason: collision with root package name */
    private static volatile z0<d, e> f3234a;

    /* renamed from: b  reason: collision with root package name */
    private static volatile z0<h, i> f3235b;

    /* renamed from: c  reason: collision with root package name */
    private static volatile z0<w, x> f3236c;

    /* renamed from: d  reason: collision with root package name */
    private static volatile z0<f0, g0> f3237d;

    /* renamed from: e  reason: collision with root package name */
    private static volatile z0<s, t> f3238e;

    /* loaded from: classes.dex */
    class a implements b.a<b> {
        a() {
        }

        @Override // p3.b.a
        /* renamed from: b */
        public b a(i3.d dVar, i3.c cVar) {
            return new b(dVar, cVar, null);
        }
    }

    /* loaded from: classes.dex */
    public static final class b extends p3.a<b> {
        private b(i3.d dVar, i3.c cVar) {
            super(dVar, cVar);
        }

        /* synthetic */ b(i3.d dVar, i3.c cVar, a aVar) {
            this(dVar, cVar);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // p3.b
        /* renamed from: g */
        public b a(i3.d dVar, i3.c cVar) {
            return new b(dVar, cVar);
        }
    }

    private r() {
    }

    public static z0<d, e> a() {
        z0<d, e> z0Var = f3234a;
        if (z0Var == null) {
            synchronized (r.class) {
                z0Var = f3234a;
                if (z0Var == null) {
                    z0Var = z0.g().f(z0.d.SERVER_STREAMING).b(z0.b("google.firestore.v1.Firestore", "BatchGetDocuments")).e(true).c(o3.b.b(d.i0())).d(o3.b.b(e.e0())).a();
                    f3234a = z0Var;
                }
            }
        }
        return z0Var;
    }

    public static z0<h, i> b() {
        z0<h, i> z0Var = f3235b;
        if (z0Var == null) {
            synchronized (r.class) {
                z0Var = f3235b;
                if (z0Var == null) {
                    z0Var = z0.g().f(z0.d.UNARY).b(z0.b("google.firestore.v1.Firestore", "Commit")).e(true).c(o3.b.b(h.i0())).d(o3.b.b(i.f0())).a();
                    f3235b = z0Var;
                }
            }
        }
        return z0Var;
    }

    public static z0<s, t> c() {
        z0<s, t> z0Var = f3238e;
        if (z0Var == null) {
            synchronized (r.class) {
                z0Var = f3238e;
                if (z0Var == null) {
                    z0Var = z0.g().f(z0.d.BIDI_STREAMING).b(z0.b("google.firestore.v1.Firestore", "Listen")).e(true).c(o3.b.b(s.i0())).d(o3.b.b(t.e0())).a();
                    f3238e = z0Var;
                }
            }
        }
        return z0Var;
    }

    public static z0<w, x> d() {
        z0<w, x> z0Var = f3236c;
        if (z0Var == null) {
            synchronized (r.class) {
                z0Var = f3236c;
                if (z0Var == null) {
                    z0Var = z0.g().f(z0.d.SERVER_STREAMING).b(z0.b("google.firestore.v1.Firestore", "RunAggregationQuery")).e(true).c(o3.b.b(w.g0())).d(o3.b.b(x.e0())).a();
                    f3236c = z0Var;
                }
            }
        }
        return z0Var;
    }

    public static z0<f0, g0> e() {
        z0<f0, g0> z0Var = f3237d;
        if (z0Var == null) {
            synchronized (r.class) {
                z0Var = f3237d;
                if (z0Var == null) {
                    z0Var = z0.g().f(z0.d.BIDI_STREAMING).b(z0.b("google.firestore.v1.Firestore", "Write")).e(true).c(o3.b.b(f0.j0())).d(o3.b.b(g0.f0())).a();
                    f3237d = z0Var;
                }
            }
        }
        return z0Var;
    }

    public static b f(i3.d dVar) {
        return (b) p3.a.e(new a(), dVar);
    }
}
