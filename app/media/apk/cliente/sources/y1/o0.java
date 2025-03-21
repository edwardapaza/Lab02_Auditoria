package y1;

import com.google.firebase.firestore.a;
import com.google.protobuf.u1;
import i2.a0;
import i2.b0;
import i2.e;
import i2.e0;
import i2.j;
import i2.k;
import i2.n;
import i2.p;
import i2.t;
import i2.v;
import i2.y;
import i2.z;
import i3.j1;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import s1.f1;
import s1.k;
import s1.p;
import s1.z0;
import u1.h1;
import u1.i4;
import w1.a;
import y1.y0;
/* loaded from: classes.dex */
public final class o0 {

    /* renamed from: a  reason: collision with root package name */
    private final v1.f f8457a;

    /* renamed from: b  reason: collision with root package name */
    private final String f8458b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f8459a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f8460b;

        /* renamed from: c  reason: collision with root package name */
        static final /* synthetic */ int[] f8461c;

        /* renamed from: d  reason: collision with root package name */
        static final /* synthetic */ int[] f8462d;

        /* renamed from: e  reason: collision with root package name */
        static final /* synthetic */ int[] f8463e;

        /* renamed from: f  reason: collision with root package name */
        static final /* synthetic */ int[] f8464f;

        /* renamed from: g  reason: collision with root package name */
        static final /* synthetic */ int[] f8465g;

        /* renamed from: h  reason: collision with root package name */
        static final /* synthetic */ int[] f8466h;

        /* renamed from: i  reason: collision with root package name */
        static final /* synthetic */ int[] f8467i;

        /* renamed from: j  reason: collision with root package name */
        static final /* synthetic */ int[] f8468j;

        /* renamed from: k  reason: collision with root package name */
        static final /* synthetic */ int[] f8469k;

        /* renamed from: l  reason: collision with root package name */
        static final /* synthetic */ int[] f8470l;

        /* renamed from: m  reason: collision with root package name */
        static final /* synthetic */ int[] f8471m;

        static {
            int[] iArr = new int[t.c.values().length];
            f8471m = iArr;
            try {
                iArr[t.c.TARGET_CHANGE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f8471m[t.c.DOCUMENT_CHANGE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f8471m[t.c.DOCUMENT_DELETE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f8471m[t.c.DOCUMENT_REMOVE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f8471m[t.c.FILTER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f8471m[t.c.RESPONSETYPE_NOT_SET.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            int[] iArr2 = new int[b0.c.values().length];
            f8470l = iArr2;
            try {
                iArr2[b0.c.NO_CHANGE.ordinal()] = 1;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f8470l[b0.c.ADD.ordinal()] = 2;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f8470l[b0.c.REMOVE.ordinal()] = 3;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f8470l[b0.c.CURRENT.ordinal()] = 4;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f8470l[b0.c.RESET.ordinal()] = 5;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f8470l[b0.c.UNRECOGNIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused12) {
            }
            int[] iArr3 = new int[z.e.values().length];
            f8469k = iArr3;
            try {
                iArr3[z.e.ASCENDING.ordinal()] = 1;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f8469k[z.e.DESCENDING.ordinal()] = 2;
            } catch (NoSuchFieldError unused14) {
            }
            int[] iArr4 = new int[z.f.b.values().length];
            f8468j = iArr4;
            try {
                iArr4[z.f.b.LESS_THAN.ordinal()] = 1;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f8468j[z.f.b.LESS_THAN_OR_EQUAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f8468j[z.f.b.EQUAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                f8468j[z.f.b.NOT_EQUAL.ordinal()] = 4;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                f8468j[z.f.b.GREATER_THAN_OR_EQUAL.ordinal()] = 5;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                f8468j[z.f.b.GREATER_THAN.ordinal()] = 6;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                f8468j[z.f.b.ARRAY_CONTAINS.ordinal()] = 7;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                f8468j[z.f.b.IN.ordinal()] = 8;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                f8468j[z.f.b.ARRAY_CONTAINS_ANY.ordinal()] = 9;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                f8468j[z.f.b.NOT_IN.ordinal()] = 10;
            } catch (NoSuchFieldError unused24) {
            }
            int[] iArr5 = new int[p.b.values().length];
            f8467i = iArr5;
            try {
                iArr5[p.b.LESS_THAN.ordinal()] = 1;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                f8467i[p.b.LESS_THAN_OR_EQUAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                f8467i[p.b.EQUAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused27) {
            }
            try {
                f8467i[p.b.NOT_EQUAL.ordinal()] = 4;
            } catch (NoSuchFieldError unused28) {
            }
            try {
                f8467i[p.b.GREATER_THAN.ordinal()] = 5;
            } catch (NoSuchFieldError unused29) {
            }
            try {
                f8467i[p.b.GREATER_THAN_OR_EQUAL.ordinal()] = 6;
            } catch (NoSuchFieldError unused30) {
            }
            try {
                f8467i[p.b.ARRAY_CONTAINS.ordinal()] = 7;
            } catch (NoSuchFieldError unused31) {
            }
            try {
                f8467i[p.b.IN.ordinal()] = 8;
            } catch (NoSuchFieldError unused32) {
            }
            try {
                f8467i[p.b.ARRAY_CONTAINS_ANY.ordinal()] = 9;
            } catch (NoSuchFieldError unused33) {
            }
            try {
                f8467i[p.b.NOT_IN.ordinal()] = 10;
            } catch (NoSuchFieldError unused34) {
            }
            int[] iArr6 = new int[z.k.b.values().length];
            f8466h = iArr6;
            try {
                iArr6[z.k.b.IS_NAN.ordinal()] = 1;
            } catch (NoSuchFieldError unused35) {
            }
            try {
                f8466h[z.k.b.IS_NULL.ordinal()] = 2;
            } catch (NoSuchFieldError unused36) {
            }
            try {
                f8466h[z.k.b.IS_NOT_NAN.ordinal()] = 3;
            } catch (NoSuchFieldError unused37) {
            }
            try {
                f8466h[z.k.b.IS_NOT_NULL.ordinal()] = 4;
            } catch (NoSuchFieldError unused38) {
            }
            int[] iArr7 = new int[z.h.b.values().length];
            f8465g = iArr7;
            try {
                iArr7[z.h.b.COMPOSITE_FILTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused39) {
            }
            try {
                f8465g[z.h.b.FIELD_FILTER.ordinal()] = 2;
            } catch (NoSuchFieldError unused40) {
            }
            try {
                f8465g[z.h.b.UNARY_FILTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused41) {
            }
            int[] iArr8 = new int[z.d.b.values().length];
            f8464f = iArr8;
            try {
                iArr8[z.d.b.AND.ordinal()] = 1;
            } catch (NoSuchFieldError unused42) {
            }
            try {
                f8464f[z.d.b.OR.ordinal()] = 2;
            } catch (NoSuchFieldError unused43) {
            }
            int[] iArr9 = new int[k.a.values().length];
            f8463e = iArr9;
            try {
                iArr9[k.a.AND.ordinal()] = 1;
            } catch (NoSuchFieldError unused44) {
            }
            try {
                f8463e[k.a.OR.ordinal()] = 2;
            } catch (NoSuchFieldError unused45) {
            }
            int[] iArr10 = new int[h1.values().length];
            f8462d = iArr10;
            try {
                iArr10[h1.LISTEN.ordinal()] = 1;
            } catch (NoSuchFieldError unused46) {
            }
            try {
                f8462d[h1.EXISTENCE_FILTER_MISMATCH.ordinal()] = 2;
            } catch (NoSuchFieldError unused47) {
            }
            try {
                f8462d[h1.EXISTENCE_FILTER_MISMATCH_BLOOM.ordinal()] = 3;
            } catch (NoSuchFieldError unused48) {
            }
            try {
                f8462d[h1.LIMBO_RESOLUTION.ordinal()] = 4;
            } catch (NoSuchFieldError unused49) {
            }
            int[] iArr11 = new int[p.c.EnumC0064c.values().length];
            f8461c = iArr11;
            try {
                iArr11[p.c.EnumC0064c.SET_TO_SERVER_VALUE.ordinal()] = 1;
            } catch (NoSuchFieldError unused50) {
            }
            try {
                f8461c[p.c.EnumC0064c.APPEND_MISSING_ELEMENTS.ordinal()] = 2;
            } catch (NoSuchFieldError unused51) {
            }
            try {
                f8461c[p.c.EnumC0064c.REMOVE_ALL_FROM_ARRAY.ordinal()] = 3;
            } catch (NoSuchFieldError unused52) {
            }
            try {
                f8461c[p.c.EnumC0064c.INCREMENT.ordinal()] = 4;
            } catch (NoSuchFieldError unused53) {
            }
            int[] iArr12 = new int[v.c.values().length];
            f8460b = iArr12;
            try {
                iArr12[v.c.UPDATE_TIME.ordinal()] = 1;
            } catch (NoSuchFieldError unused54) {
            }
            try {
                f8460b[v.c.EXISTS.ordinal()] = 2;
            } catch (NoSuchFieldError unused55) {
            }
            try {
                f8460b[v.c.CONDITIONTYPE_NOT_SET.ordinal()] = 3;
            } catch (NoSuchFieldError unused56) {
            }
            int[] iArr13 = new int[e0.c.values().length];
            f8459a = iArr13;
            try {
                iArr13[e0.c.UPDATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused57) {
            }
            try {
                f8459a[e0.c.DELETE.ordinal()] = 2;
            } catch (NoSuchFieldError unused58) {
            }
            try {
                f8459a[e0.c.VERIFY.ordinal()] = 3;
            } catch (NoSuchFieldError unused59) {
            }
        }
    }

    public o0(v1.f fVar) {
        this.f8457a = fVar;
        this.f8458b = Z(fVar).d();
    }

    private i2.n E(w1.d dVar) {
        n.b k02 = i2.n.k0();
        for (v1.r rVar : dVar.c()) {
            k02.E(rVar.d());
        }
        return k02.build();
    }

    private z.f.b G(p.b bVar) {
        switch (a.f8467i[bVar.ordinal()]) {
            case 1:
                return z.f.b.LESS_THAN;
            case 2:
                return z.f.b.LESS_THAN_OR_EQUAL;
            case 3:
                return z.f.b.EQUAL;
            case 4:
                return z.f.b.NOT_EQUAL;
            case 5:
                return z.f.b.GREATER_THAN;
            case 6:
                return z.f.b.GREATER_THAN_OR_EQUAL;
            case 7:
                return z.f.b.ARRAY_CONTAINS;
            case 8:
                return z.f.b.IN;
            case i2.d0.ARRAY_VALUE_FIELD_NUMBER /* 9 */:
                return z.f.b.ARRAY_CONTAINS_ANY;
            case i2.d0.TIMESTAMP_VALUE_FIELD_NUMBER /* 10 */:
                return z.f.b.NOT_IN;
            default:
                throw z1.b.a("Unknown operator %d", bVar);
        }
    }

    private z.g H(v1.r rVar) {
        return z.g.h0().E(rVar.d()).build();
    }

    private p.c I(w1.e eVar) {
        p.c.a G;
        w1.p b5 = eVar.b();
        if (b5 instanceof w1.n) {
            G = p.c.p0().F(eVar.a().d()).I(p.c.b.REQUEST_TIME);
        } else if (b5 instanceof a.b) {
            G = p.c.p0().F(eVar.a().d()).E(i2.b.n0().E(((a.b) b5).f()));
        } else if (b5 instanceof a.C0124a) {
            G = p.c.p0().F(eVar.a().d()).H(i2.b.n0().E(((a.C0124a) b5).f()));
        } else if (!(b5 instanceof w1.j)) {
            throw z1.b.a("Unknown transform: %s", b5);
        } else {
            G = p.c.p0().F(eVar.a().d()).G(((w1.j) b5).d());
        }
        return G.build();
    }

    private z.h K(List<s1.q> list) {
        return J(new s1.k(list, k.a.AND));
    }

    private String M(h1 h1Var) {
        int i5 = a.f8462d[h1Var.ordinal()];
        if (i5 != 1) {
            if (i5 != 2) {
                if (i5 != 3) {
                    if (i5 == 4) {
                        return "limbo-document";
                    }
                    throw z1.b.a("Unrecognized query purpose: %s", h1Var);
                }
                return "existence-filter-mismatch-bloom";
            }
            return "existence-filter-mismatch";
        }
        return null;
    }

    private z.i P(s1.z0 z0Var) {
        z.i.a i02 = z.i.i0();
        i02.E(z0Var.b().equals(z0.a.ASCENDING) ? z.e.ASCENDING : z.e.DESCENDING);
        i02.F(H(z0Var.c()));
        return i02.build();
    }

    private i2.v Q(w1.m mVar) {
        v.b E;
        z1.b.d(!mVar.d(), "Can't serialize an empty precondition", new Object[0]);
        v.b k02 = i2.v.k0();
        if (mVar.c() != null) {
            E = k02.F(Y(mVar.c()));
        } else if (mVar.b() == null) {
            throw z1.b.a("Unknown Precondition", new Object[0]);
        } else {
            E = k02.E(mVar.b().booleanValue());
        }
        return E.build();
    }

    private String R(v1.u uVar) {
        return T(this.f8457a, uVar);
    }

    private String T(v1.f fVar, v1.u uVar) {
        return Z(fVar).a("documents").c(uVar).d();
    }

    private static v1.u Z(v1.f fVar) {
        return v1.u.t(Arrays.asList("projects", fVar.h(), "databases", fVar.e()));
    }

    private static v1.u a0(v1.u uVar) {
        z1.b.d(uVar.p() > 4 && uVar.m(4).equals("documents"), "Tried to deserialize invalid key %s", uVar);
        return uVar.q(5);
    }

    private j1 b0(l2.a aVar) {
        return j1.h(aVar.e0()).q(aVar.g0());
    }

    private w1.d d(i2.n nVar) {
        int j02 = nVar.j0();
        HashSet hashSet = new HashSet(j02);
        for (int i5 = 0; i5 < j02; i5++) {
            hashSet.add(v1.r.u(nVar.i0(i5)));
        }
        return w1.d.b(hashSet);
    }

    private static boolean d0(v1.u uVar) {
        return uVar.p() >= 4 && uVar.m(0).equals("projects") && uVar.m(2).equals("databases");
    }

    private p.b g(z.f.b bVar) {
        switch (a.f8468j[bVar.ordinal()]) {
            case 1:
                return p.b.LESS_THAN;
            case 2:
                return p.b.LESS_THAN_OR_EQUAL;
            case 3:
                return p.b.EQUAL;
            case 4:
                return p.b.NOT_EQUAL;
            case 5:
                return p.b.GREATER_THAN_OR_EQUAL;
            case 6:
                return p.b.GREATER_THAN;
            case 7:
                return p.b.ARRAY_CONTAINS;
            case 8:
                return p.b.IN;
            case i2.d0.ARRAY_VALUE_FIELD_NUMBER /* 9 */:
                return p.b.ARRAY_CONTAINS_ANY;
            case i2.d0.TIMESTAMP_VALUE_FIELD_NUMBER /* 10 */:
                return p.b.NOT_IN;
            default:
                throw z1.b.a("Unhandled FieldFilter.operator %d", bVar);
        }
    }

    private w1.e h(p.c cVar) {
        int i5 = a.f8461c[cVar.o0().ordinal()];
        if (i5 == 1) {
            z1.b.d(cVar.n0() == p.c.b.REQUEST_TIME, "Unknown transform setToServerValue: %s", cVar.n0());
            return new w1.e(v1.r.u(cVar.k0()), w1.n.d());
        } else if (i5 != 2) {
            if (i5 != 3) {
                if (i5 == 4) {
                    return new w1.e(v1.r.u(cVar.k0()), new w1.j(cVar.l0()));
                }
                throw z1.b.a("Unknown FieldTransform proto: %s", cVar);
            }
            return new w1.e(v1.r.u(cVar.k0()), new a.C0124a(cVar.m0().e()));
        } else {
            return new w1.e(v1.r.u(cVar.k0()), new a.b(cVar.j0().e()));
        }
    }

    private List<s1.q> j(z.h hVar) {
        s1.q i5 = i(hVar);
        if (i5 instanceof s1.k) {
            s1.k kVar = (s1.k) i5;
            if (kVar.i()) {
                return kVar.b();
            }
        }
        return Collections.singletonList(i5);
    }

    private v1.s k(i2.e eVar) {
        z1.b.d(eVar.i0().equals(e.c.FOUND), "Tried to deserialize a found document from a missing document.", new Object[0]);
        v1.l l5 = l(eVar.f0().k0());
        v1.t j5 = v1.t.j(eVar.f0().i0());
        v1.w y4 = y(eVar.f0().l0());
        z1.b.d(!y4.equals(v1.w.f8154b), "Got a document response with no snapshot version", new Object[0]);
        return v1.s.p(l5, y4, j5);
    }

    private v1.s n(i2.e eVar) {
        z1.b.d(eVar.i0().equals(e.c.MISSING), "Tried to deserialize a missing document from a found document.", new Object[0]);
        v1.l l5 = l(eVar.g0());
        v1.w y4 = y(eVar.h0());
        z1.b.d(!y4.equals(v1.w.f8154b), "Got a no document response with no snapshot version", new Object[0]);
        return v1.s.r(l5, y4);
    }

    private s1.z0 q(z.i iVar) {
        z0.a aVar;
        v1.r u5 = v1.r.u(iVar.h0().g0());
        int i5 = a.f8469k[iVar.g0().ordinal()];
        if (i5 == 1) {
            aVar = z0.a.ASCENDING;
        } else if (i5 != 2) {
            throw z1.b.a("Unrecognized direction %d", iVar.g0());
        } else {
            aVar = z0.a.DESCENDING;
        }
        return s1.z0.d(aVar, u5);
    }

    private w1.m r(i2.v vVar) {
        int i5 = a.f8460b[vVar.g0().ordinal()];
        if (i5 != 1) {
            if (i5 != 2) {
                if (i5 == 3) {
                    return w1.m.f8253c;
                }
                throw z1.b.a("Unknown precondition", new Object[0]);
            }
            return w1.m.a(vVar.i0());
        }
        return w1.m.f(y(vVar.j0()));
    }

    private v1.u s(String str) {
        v1.u v5 = v(str);
        return v5.p() == 4 ? v1.u.f8153b : a0(v5);
    }

    private v1.u v(String str) {
        v1.u u5 = v1.u.u(str);
        z1.b.d(d0(u5), "Tried to deserialize invalid key %s", u5);
        return u5;
    }

    private s1.q x(z.k kVar) {
        p.b bVar;
        i2.d0 d0Var;
        v1.r u5 = v1.r.u(kVar.h0().g0());
        int i5 = a.f8466h[kVar.i0().ordinal()];
        if (i5 != 1) {
            if (i5 == 2) {
                bVar = p.b.EQUAL;
            } else if (i5 == 3) {
                bVar = p.b.NOT_EQUAL;
            } else if (i5 != 4) {
                throw z1.b.a("Unrecognized UnaryFilter.operator %d", kVar.i0());
            } else {
                bVar = p.b.NOT_EQUAL;
            }
            d0Var = v1.z.f8161b;
            return s1.p.e(u5, bVar, d0Var);
        }
        bVar = p.b.EQUAL;
        d0Var = v1.z.f8160a;
        return s1.p.e(u5, bVar, d0Var);
    }

    public y0 A(i2.t tVar) {
        y0.e eVar;
        y0 dVar;
        int i5 = a.f8471m[tVar.j0().ordinal()];
        j1 j1Var = null;
        if (i5 == 1) {
            i2.b0 k02 = tVar.k0();
            int i6 = a.f8470l[k02.i0().ordinal()];
            if (i6 == 1) {
                eVar = y0.e.NoChange;
            } else if (i6 == 2) {
                eVar = y0.e.Added;
            } else if (i6 == 3) {
                eVar = y0.e.Removed;
                j1Var = b0(k02.e0());
            } else if (i6 == 4) {
                eVar = y0.e.Current;
            } else if (i6 != 5) {
                throw new IllegalArgumentException("Unknown target change type");
            } else {
                eVar = y0.e.Reset;
            }
            dVar = new y0.d(eVar, k02.k0(), k02.h0(), j1Var);
        } else if (i5 == 2) {
            i2.l f02 = tVar.f0();
            List<Integer> h02 = f02.h0();
            List<Integer> g02 = f02.g0();
            v1.l l5 = l(f02.f0().k0());
            v1.w y4 = y(f02.f0().l0());
            z1.b.d(!y4.equals(v1.w.f8154b), "Got a document change without an update time", new Object[0]);
            v1.s p5 = v1.s.p(l5, y4, v1.t.j(f02.f0().i0()));
            dVar = new y0.b(h02, g02, p5.getKey(), p5);
        } else if (i5 == 3) {
            i2.m g03 = tVar.g0();
            List<Integer> h03 = g03.h0();
            v1.s r5 = v1.s.r(l(g03.f0()), y(g03.g0()));
            return new y0.b(Collections.emptyList(), h03, r5.getKey(), r5);
        } else if (i5 != 4) {
            if (i5 == 5) {
                i2.q i02 = tVar.i0();
                return new y0.c(i02.g0(), new s(i02.e0(), i02.h0()));
            }
            throw new IllegalArgumentException("Unknown change type set");
        } else {
            i2.o h04 = tVar.h0();
            dVar = new y0.b(Collections.emptyList(), h04.g0(), l(h04.f0()), null);
        }
        return dVar;
    }

    z.h B(s1.k kVar) {
        Object build;
        ArrayList arrayList = new ArrayList(kVar.b().size());
        for (s1.q qVar : kVar.b()) {
            arrayList.add(J(qVar));
        }
        if (arrayList.size() == 1) {
            build = arrayList.get(0);
        } else {
            z.d.a l02 = z.d.l0();
            l02.F(C(kVar.e()));
            l02.E(arrayList);
            build = z.h.m0().E(l02).build();
        }
        return (z.h) build;
    }

    z.d.b C(k.a aVar) {
        int i5 = a.f8463e[aVar.ordinal()];
        if (i5 != 1) {
            if (i5 == 2) {
                return z.d.b.OR;
            }
            throw z1.b.a("Unrecognized composite filter type.", new Object[0]);
        }
        return z.d.b.AND;
    }

    public i2.k D(v1.l lVar, v1.t tVar) {
        k.b o02 = i2.k.o0();
        o02.F(L(lVar));
        o02.E(tVar.m());
        return o02.build();
    }

    public a0.c F(f1 f1Var) {
        a0.c.a k02 = a0.c.k0();
        k02.E(R(f1Var.n()));
        return k02.build();
    }

    z.h J(s1.q qVar) {
        if (qVar instanceof s1.p) {
            return X((s1.p) qVar);
        }
        if (qVar instanceof s1.k) {
            return B((s1.k) qVar);
        }
        throw z1.b.a("Unrecognized filter type %s", qVar.toString());
    }

    public String L(v1.l lVar) {
        return T(this.f8457a, lVar.q());
    }

    public Map<String, String> N(i4 i4Var) {
        String M = M(i4Var.c());
        if (M == null) {
            return null;
        }
        HashMap hashMap = new HashMap(1);
        hashMap.put("goog-listen-tags", M);
        return hashMap;
    }

    public i2.e0 O(w1.f fVar) {
        e0.b y02 = i2.e0.y0();
        if (fVar instanceof w1.o) {
            y02.H(D(fVar.g(), ((w1.o) fVar).o()));
        } else if (fVar instanceof w1.l) {
            y02.H(D(fVar.g(), ((w1.l) fVar).q()));
            y02.I(E(fVar.e()));
        } else if (fVar instanceof w1.c) {
            y02.G(L(fVar.g()));
        } else if (!(fVar instanceof w1.q)) {
            throw z1.b.a("unknown mutation type %s", fVar.getClass());
        } else {
            y02.J(L(fVar.g()));
        }
        for (w1.e eVar : fVar.f()) {
            y02.E(I(eVar));
        }
        if (!fVar.h().d()) {
            y02.F(Q(fVar.h()));
        }
        return y02.build();
    }

    public a0.d S(f1 f1Var) {
        a0.d.a j02 = a0.d.j0();
        z.b B0 = i2.z.B0();
        v1.u n5 = f1Var.n();
        if (f1Var.d() != null) {
            z1.b.d(n5.p() % 2 == 0, "Collection Group queries should be within a document path or root.", new Object[0]);
            j02.E(R(n5));
            z.c.a i02 = z.c.i0();
            i02.F(f1Var.d());
            i02.E(true);
            B0.E(i02);
        } else {
            z1.b.d(n5.p() % 2 != 0, "Document queries with filters are not supported.", new Object[0]);
            j02.E(R(n5.r()));
            z.c.a i03 = z.c.i0();
            i03.F(n5.k());
            B0.E(i03);
        }
        if (f1Var.h().size() > 0) {
            B0.J(K(f1Var.h()));
        }
        for (s1.z0 z0Var : f1Var.m()) {
            B0.F(P(z0Var));
        }
        if (f1Var.r()) {
            B0.H(com.google.protobuf.a0.h0().E((int) f1Var.j()));
        }
        if (f1Var.p() != null) {
            j.b k02 = i2.j.k0();
            k02.E(f1Var.p().b());
            k02.F(f1Var.p().c());
            B0.I(k02);
        }
        if (f1Var.f() != null) {
            j.b k03 = i2.j.k0();
            k03.E(f1Var.f().b());
            k03.F(!f1Var.f().c());
            B0.G(k03);
        }
        j02.F(B0);
        return j02.build();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public i2.y U(a0.d dVar, List<com.google.firebase.firestore.a> list, HashMap<String, String> hashMap) {
        y.c i02 = i2.y.i0();
        i02.F(dVar.i0());
        ArrayList arrayList = new ArrayList();
        HashSet hashSet = new HashSet();
        int i5 = 1;
        for (com.google.firebase.firestore.a aVar : list) {
            if (!hashSet.contains(aVar.c())) {
                hashSet.add(aVar.c());
                StringBuilder sb = new StringBuilder();
                sb.append("aggregate_");
                int i6 = i5 + 1;
                sb.append(i5);
                String sb2 = sb.toString();
                hashMap.put(sb2, aVar.c());
                y.b.C0066b i03 = y.b.i0();
                z.g build = z.g.h0().E(aVar.d()).build();
                if (aVar instanceof a.c) {
                    i03.G(y.b.c.e0());
                } else if (aVar instanceof a.d) {
                    i03.H(y.b.d.f0().E(build).build());
                } else if (!(aVar instanceof a.b)) {
                    throw new RuntimeException("Unsupported aggregation");
                } else {
                    i03.F(y.b.a.f0().E(build).build());
                }
                i03.E(sb2);
                arrayList.add(i03.build());
                i5 = i6;
            }
        }
        i02.E(arrayList);
        return (i2.y) i02.build();
    }

    public i2.a0 V(i4 i4Var) {
        a0.b k02 = i2.a0.k0();
        f1 g5 = i4Var.g();
        if (g5.s()) {
            k02.E(F(g5));
        } else {
            k02.G(S(g5));
        }
        k02.J(i4Var.h());
        if (!i4Var.d().isEmpty() || i4Var.f().compareTo(v1.w.f8154b) <= 0) {
            k02.I(i4Var.d());
        } else {
            k02.H(W(i4Var.f().c()));
        }
        if (i4Var.a() != null && (!i4Var.d().isEmpty() || i4Var.f().compareTo(v1.w.f8154b) > 0)) {
            k02.F(com.google.protobuf.a0.h0().E(i4Var.a().intValue()));
        }
        return k02.build();
    }

    public u1 W(f1.q qVar) {
        u1.b j02 = u1.j0();
        j02.F(qVar.n());
        j02.E(qVar.h());
        return j02.build();
    }

    z.h X(s1.p pVar) {
        z.k.b bVar;
        z.h.a G;
        p.b g5 = pVar.g();
        p.b bVar2 = p.b.EQUAL;
        if (g5 == bVar2 || pVar.g() == p.b.NOT_EQUAL) {
            z.k.a j02 = z.k.j0();
            j02.E(H(pVar.f()));
            if (v1.z.y(pVar.h())) {
                bVar = pVar.g() == bVar2 ? z.k.b.IS_NAN : z.k.b.IS_NOT_NAN;
            } else if (v1.z.z(pVar.h())) {
                bVar = pVar.g() == bVar2 ? z.k.b.IS_NULL : z.k.b.IS_NOT_NULL;
            }
            j02.F(bVar);
            G = z.h.m0().G(j02);
            return G.build();
        }
        z.f.a l02 = z.f.l0();
        l02.E(H(pVar.f()));
        l02.F(G(pVar.g()));
        l02.G(pVar.h());
        G = z.h.m0().F(l02);
        return G.build();
    }

    public u1 Y(v1.w wVar) {
        return W(wVar.c());
    }

    public String a() {
        return this.f8458b;
    }

    s1.k b(z.d dVar) {
        ArrayList arrayList = new ArrayList();
        for (z.h hVar : dVar.j0()) {
            arrayList.add(i(hVar));
        }
        return new s1.k(arrayList, c(dVar.k0()));
    }

    k.a c(z.d.b bVar) {
        int i5 = a.f8464f[bVar.ordinal()];
        if (i5 != 1) {
            if (i5 == 2) {
                return k.a.OR;
            }
            throw z1.b.a("Only AND and OR composite filter types are supported.", new Object[0]);
        }
        return k.a.AND;
    }

    public boolean c0(v1.u uVar) {
        return d0(uVar) && uVar.m(1).equals(this.f8457a.h()) && uVar.m(3).equals(this.f8457a.e());
    }

    public f1 e(a0.c cVar) {
        int j02 = cVar.j0();
        z1.b.d(j02 == 1, "DocumentsTarget contained other than 1 document %d", Integer.valueOf(j02));
        return s1.a1.b(s(cVar.i0(0))).D();
    }

    s1.p f(z.f fVar) {
        return s1.p.e(v1.r.u(fVar.i0().g0()), g(fVar.j0()), fVar.k0());
    }

    s1.q i(z.h hVar) {
        int i5 = a.f8465g[hVar.k0().ordinal()];
        if (i5 != 1) {
            if (i5 != 2) {
                if (i5 == 3) {
                    return x(hVar.l0());
                }
                throw z1.b.a("Unrecognized Filter.filterType %d", hVar.k0());
            }
            return f(hVar.j0());
        }
        return b(hVar.h0());
    }

    public v1.l l(String str) {
        v1.u v5 = v(str);
        z1.b.d(v5.m(1).equals(this.f8457a.h()), "Tried to deserialize key from different project.", new Object[0]);
        z1.b.d(v5.m(3).equals(this.f8457a.e()), "Tried to deserialize key from different database.", new Object[0]);
        return v1.l.k(a0(v5));
    }

    public v1.s m(i2.e eVar) {
        if (eVar.i0().equals(e.c.FOUND)) {
            return k(eVar);
        }
        if (eVar.i0().equals(e.c.MISSING)) {
            return n(eVar);
        }
        throw new IllegalArgumentException("Unknown result case: " + eVar.i0());
    }

    public w1.f o(i2.e0 e0Var) {
        w1.m r5 = e0Var.u0() ? r(e0Var.m0()) : w1.m.f8253c;
        ArrayList arrayList = new ArrayList();
        for (p.c cVar : e0Var.s0()) {
            arrayList.add(h(cVar));
        }
        int i5 = a.f8459a[e0Var.o0().ordinal()];
        if (i5 == 1) {
            return e0Var.x0() ? new w1.l(l(e0Var.q0().k0()), v1.t.j(e0Var.q0().i0()), d(e0Var.r0()), r5, arrayList) : new w1.o(l(e0Var.q0().k0()), v1.t.j(e0Var.q0().i0()), r5, arrayList);
        } else if (i5 != 2) {
            if (i5 == 3) {
                return new w1.q(l(e0Var.t0()), r5);
            }
            throw z1.b.a("Unknown mutation operation: %d", e0Var.o0());
        } else {
            return new w1.c(l(e0Var.n0()), r5);
        }
    }

    public w1.i p(i2.h0 h0Var, v1.w wVar) {
        v1.w y4 = y(h0Var.g0());
        if (!v1.w.f8154b.equals(y4)) {
            wVar = y4;
        }
        int f02 = h0Var.f0();
        ArrayList arrayList = new ArrayList(f02);
        for (int i5 = 0; i5 < f02; i5++) {
            arrayList.add(h0Var.e0(i5));
        }
        return new w1.i(wVar, arrayList);
    }

    public f1 t(a0.d dVar) {
        return u(dVar.h0(), dVar.i0());
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x009d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public s1.f1 u(java.lang.String r14, i2.z r15) {
        /*
            r13 = this;
            v1.u r14 = r13.s(r14)
            int r0 = r15.r0()
            r1 = 0
            r2 = 0
            r3 = 1
            if (r0 <= 0) goto L30
            if (r0 != r3) goto L11
            r0 = 1
            goto L12
        L11:
            r0 = 0
        L12:
            java.lang.Object[] r4 = new java.lang.Object[r2]
            java.lang.String r5 = "StructuredQuery.from with more than one collection is not supported."
            z1.b.d(r0, r5, r4)
            i2.z$c r0 = r15.q0(r2)
            boolean r4 = r0.g0()
            java.lang.String r0 = r0.h0()
            if (r4 == 0) goto L2a
            r5 = r14
            r6 = r0
            goto L32
        L2a:
            v1.e r14 = r14.a(r0)
            v1.u r14 = (v1.u) r14
        L30:
            r5 = r14
            r6 = r1
        L32:
            boolean r14 = r15.A0()
            if (r14 == 0) goto L41
            i2.z$h r14 = r15.w0()
            java.util.List r14 = r13.j(r14)
            goto L45
        L41:
            java.util.List r14 = java.util.Collections.emptyList()
        L45:
            r7 = r14
            int r14 = r15.u0()
            if (r14 <= 0) goto L63
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>(r14)
        L51:
            if (r2 >= r14) goto L61
            i2.z$i r4 = r15.t0(r2)
            s1.z0 r4 = r13.q(r4)
            r0.add(r4)
            int r2 = r2 + 1
            goto L51
        L61:
            r8 = r0
            goto L68
        L63:
            java.util.List r14 = java.util.Collections.emptyList()
            r8 = r14
        L68:
            r9 = -1
            boolean r14 = r15.y0()
            if (r14 == 0) goto L79
            com.google.protobuf.a0 r14 = r15.s0()
            int r14 = r14.g0()
            long r9 = (long) r14
        L79:
            boolean r14 = r15.z0()
            if (r14 == 0) goto L96
            s1.i r14 = new s1.i
            i2.j r0 = r15.v0()
            java.util.List r0 = r0.e()
            i2.j r2 = r15.v0()
            boolean r2 = r2.i0()
            r14.<init>(r0, r2)
            r11 = r14
            goto L97
        L96:
            r11 = r1
        L97:
            boolean r14 = r15.x0()
            if (r14 == 0) goto Lb3
            s1.i r1 = new s1.i
            i2.j r14 = r15.p0()
            java.util.List r14 = r14.e()
            i2.j r15 = r15.p0()
            boolean r15 = r15.i0()
            r15 = r15 ^ r3
            r1.<init>(r14, r15)
        Lb3:
            r12 = r1
            s1.f1 r14 = new s1.f1
            r4 = r14
            r4.<init>(r5, r6, r7, r8, r9, r11, r12)
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: y1.o0.u(java.lang.String, i2.z):s1.f1");
    }

    public f1.q w(u1 u1Var) {
        return new f1.q(u1Var.i0(), u1Var.h0());
    }

    public v1.w y(u1 u1Var) {
        return (u1Var.i0() == 0 && u1Var.h0() == 0) ? v1.w.f8154b : new v1.w(w(u1Var));
    }

    public v1.w z(i2.t tVar) {
        if (tVar.j0() == t.c.TARGET_CHANGE && tVar.k0().j0() == 0) {
            return y(tVar.k0().g0());
        }
        return v1.w.f8154b;
    }
}
