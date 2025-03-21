package u1;

import g2.a;
import h2.a;
import i2.a0;
import i2.e0;
import i2.k;
import i2.p;
import java.util.ArrayList;
import java.util.List;
import s1.a1;
import v1.q;
import x1.a;
import x1.b;
import x1.c;
import x1.d;
import x1.e;
/* loaded from: classes.dex */
public final class o {

    /* renamed from: a  reason: collision with root package name */
    private final y1.o0 f7932a;

    /* loaded from: classes.dex */
    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f7933a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f7934b;

        static {
            int[] iArr = new int[c.EnumC0128c.values().length];
            f7934b = iArr;
            try {
                iArr[c.EnumC0128c.DOCUMENTS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f7934b[c.EnumC0128c.QUERY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[a.c.values().length];
            f7933a = iArr2;
            try {
                iArr2[a.c.DOCUMENT.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f7933a[a.c.NO_DOCUMENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f7933a[a.c.UNKNOWN_DOCUMENT.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public o(y1.o0 o0Var) {
        this.f7932a = o0Var;
    }

    private v1.s b(i2.k kVar, boolean z4) {
        v1.s p5 = v1.s.p(this.f7932a.l(kVar.k0()), this.f7932a.y(kVar.l0()), v1.t.j(kVar.i0()));
        return z4 ? p5.t() : p5;
    }

    private v1.s g(x1.b bVar, boolean z4) {
        v1.s r5 = v1.s.r(this.f7932a.l(bVar.h0()), this.f7932a.y(bVar.i0()));
        return z4 ? r5.t() : r5;
    }

    private v1.s i(x1.d dVar) {
        return v1.s.s(this.f7932a.l(dVar.h0()), this.f7932a.y(dVar.i0()));
    }

    private i2.k k(v1.i iVar) {
        k.b o02 = i2.k.o0();
        o02.F(this.f7932a.L(iVar.getKey()));
        o02.E(iVar.k().m());
        o02.G(this.f7932a.W(iVar.j().c()));
        return o02.build();
    }

    private x1.b p(v1.i iVar) {
        b.C0127b j02 = x1.b.j0();
        j02.E(this.f7932a.L(iVar.getKey()));
        j02.F(this.f7932a.W(iVar.j().c()));
        return j02.build();
    }

    private x1.d r(v1.i iVar) {
        d.b j02 = x1.d.j0();
        j02.E(this.f7932a.L(iVar.getKey()));
        j02.F(this.f7932a.W(iVar.j().c()));
        return j02.build();
    }

    public r1.i a(h2.a aVar) {
        return new r1.i(this.f7932a.u(aVar.i0(), aVar.j0()), aVar.h0().equals(a.c.FIRST) ? a1.a.LIMIT_TO_FIRST : a1.a.LIMIT_TO_LAST);
    }

    public List<q.c> c(g2.a aVar) {
        ArrayList arrayList = new ArrayList();
        for (a.c cVar : aVar.i0()) {
            arrayList.add(q.c.c(v1.r.u(cVar.h0()), cVar.j0().equals(a.c.d.ARRAY_CONFIG) ? q.c.a.CONTAINS : cVar.i0().equals(a.c.EnumC0055c.ASCENDING) ? q.c.a.ASCENDING : q.c.a.DESCENDING));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public v1.s d(x1.a aVar) {
        int i5 = a.f7933a[aVar.j0().ordinal()];
        if (i5 != 1) {
            if (i5 != 2) {
                if (i5 == 3) {
                    return i(aVar.m0());
                }
                throw z1.b.a("Unknown MaybeDocument %s", aVar);
            }
            return g(aVar.l0(), aVar.k0());
        }
        return b(aVar.i0(), aVar.k0());
    }

    public w1.f e(i2.e0 e0Var) {
        return this.f7932a.o(e0Var);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public w1.g f(x1.e eVar) {
        int o02 = eVar.o0();
        f1.q w5 = this.f7932a.w(eVar.p0());
        int n02 = eVar.n0();
        ArrayList arrayList = new ArrayList(n02);
        for (int i5 = 0; i5 < n02; i5++) {
            arrayList.add(this.f7932a.o(eVar.m0(i5)));
        }
        ArrayList arrayList2 = new ArrayList(eVar.r0());
        int i6 = 0;
        while (i6 < eVar.r0()) {
            i2.e0 q02 = eVar.q0(i6);
            int i7 = i6 + 1;
            if (i7 < eVar.r0() && eVar.q0(i7).v0()) {
                z1.b.d(eVar.q0(i6).w0(), "TransformMutation should be preceded by a patch or set mutation", new Object[0]);
                e0.b z02 = i2.e0.z0(q02);
                for (p.c cVar : eVar.q0(i7).p0().f0()) {
                    z02.E(cVar);
                }
                arrayList2.add(this.f7932a.o(z02.build()));
                i6 = i7;
            } else {
                arrayList2.add(this.f7932a.o(q02));
            }
            i6++;
        }
        return new w1.g(o02, w5, arrayList, arrayList2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public i4 h(x1.c cVar) {
        s1.f1 e5;
        int t02 = cVar.t0();
        v1.w y4 = this.f7932a.y(cVar.s0());
        v1.w y5 = this.f7932a.y(cVar.o0());
        com.google.protobuf.i r02 = cVar.r0();
        long p02 = cVar.p0();
        int i5 = a.f7934b[cVar.u0().ordinal()];
        if (i5 == 1) {
            e5 = this.f7932a.e(cVar.n0());
        } else if (i5 != 2) {
            throw z1.b.a("Unknown targetType %d", cVar.u0());
        } else {
            e5 = this.f7932a.t(cVar.q0());
        }
        return new i4(e5, t02, p02, h1.LISTEN, y4, y5, r02, null);
    }

    public h2.a j(r1.i iVar) {
        a0.d S = this.f7932a.S(iVar.b());
        a.b k02 = h2.a.k0();
        k02.E(iVar.a().equals(a1.a.LIMIT_TO_FIRST) ? a.c.FIRST : a.c.LAST);
        k02.F(S.h0());
        k02.G(S.i0());
        return k02.build();
    }

    public g2.a l(List<q.c> list) {
        a.b j02 = g2.a.j0();
        j02.F(a.d.COLLECTION_GROUP);
        for (q.c cVar : list) {
            a.c.b k02 = a.c.k0();
            k02.F(cVar.d().d());
            if (cVar.e() == q.c.a.CONTAINS) {
                k02.E(a.c.EnumC0053a.CONTAINS);
            } else {
                k02.G(cVar.e() == q.c.a.ASCENDING ? a.c.EnumC0055c.ASCENDING : a.c.EnumC0055c.DESCENDING);
            }
            j02.E(k02);
        }
        return j02.build();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public x1.a m(v1.i iVar) {
        a.b n02 = x1.a.n0();
        if (iVar.h()) {
            n02.G(p(iVar));
        } else if (iVar.b()) {
            n02.E(k(iVar));
        } else if (!iVar.i()) {
            throw z1.b.a("Cannot encode invalid document %s", iVar);
        } else {
            n02.H(r(iVar));
        }
        n02.F(iVar.c());
        return n02.build();
    }

    public i2.e0 n(w1.f fVar) {
        return this.f7932a.O(fVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public x1.e o(w1.g gVar) {
        e.b s02 = x1.e.s0();
        s02.G(gVar.e());
        s02.H(this.f7932a.W(gVar.g()));
        for (w1.f fVar : gVar.d()) {
            s02.E(this.f7932a.O(fVar));
        }
        for (w1.f fVar2 : gVar.h()) {
            s02.F(this.f7932a.O(fVar2));
        }
        return s02.build();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public x1.c q(i4 i4Var) {
        h1 h1Var = h1.LISTEN;
        z1.b.d(h1Var.equals(i4Var.c()), "Only queries with purpose %s may be stored, got %s", h1Var, i4Var.c());
        c.b v02 = x1.c.v0();
        v02.L(i4Var.h()).H(i4Var.e()).G(this.f7932a.Y(i4Var.b())).K(this.f7932a.Y(i4Var.f())).J(i4Var.d());
        s1.f1 g5 = i4Var.g();
        if (g5.s()) {
            v02.F(this.f7932a.F(g5));
        } else {
            v02.I(this.f7932a.S(g5));
        }
        return v02.build();
    }
}
