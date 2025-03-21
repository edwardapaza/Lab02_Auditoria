package g3;

import android.util.Log;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.c1;
import com.google.firebase.firestore.d1;
import com.google.firebase.firestore.e;
import com.google.firebase.firestore.f0;
import com.google.firebase.firestore.h;
import com.google.firebase.firestore.n;
import com.google.firebase.firestore.q;
import com.google.firebase.firestore.w0;
import com.google.firebase.firestore.y0;
import e3.y;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
/* loaded from: classes.dex */
public class b {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f3083a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f3084b;

        /* renamed from: c  reason: collision with root package name */
        static final /* synthetic */ int[] f3085c;

        /* renamed from: d  reason: collision with root package name */
        static final /* synthetic */ int[] f3086d;

        /* renamed from: e  reason: collision with root package name */
        static final /* synthetic */ int[] f3087e;

        static {
            int[] iArr = new int[y.c.values().length];
            f3087e = iArr;
            try {
                iArr[y.c.SERVER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            int[] iArr2 = new int[y.k.values().length];
            f3086d = iArr2;
            try {
                iArr2[y.k.DEFAULT_SOURCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3086d[y.k.CACHE.ordinal()] = 2;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr3 = new int[h.b.values().length];
            f3085c = iArr3;
            try {
                iArr3[h.b.ADDED.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f3085c[h.b.MODIFIED.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f3085c[h.b.REMOVED.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            int[] iArr4 = new int[y.x.values().length];
            f3084b = iArr4;
            try {
                iArr4[y.x.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f3084b[y.x.ESTIMATE.ordinal()] = 2;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f3084b[y.x.PREVIOUS.ordinal()] = 3;
            } catch (NoSuchFieldError unused9) {
            }
            int[] iArr5 = new int[y.EnumC0049y.values().length];
            f3083a = iArr5;
            try {
                iArr5[y.EnumC0049y.CACHE.ordinal()] = 1;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f3083a[y.EnumC0049y.SERVER_AND_CACHE.ordinal()] = 2;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f3083a[y.EnumC0049y.SERVER.ordinal()] = 3;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0099, code lost:
        if (r1.equals("not-in") == false) goto L5;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static com.google.firebase.firestore.s a(java.util.Map<java.lang.String, java.lang.Object> r6) {
        /*
            Method dump skipped, instructions count: 378
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: g3.b.a(java.util.Map):com.google.firebase.firestore.s");
    }

    public static e b(y.c cVar) {
        if (a.f3087e[cVar.ordinal()] == 1) {
            return e.SERVER;
        }
        throw new IllegalArgumentException("Unknown AggregateSource value: " + cVar);
    }

    public static List<q> c(List<List<String>> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (List<String> list2 : list) {
            arrayList.add(q.d((String[]) list2.toArray(new String[0])));
        }
        return arrayList;
    }

    public static f0 d(y.k kVar) {
        int i5 = a.f3086d[kVar.ordinal()];
        if (i5 != 1) {
            if (i5 == 2) {
                return f0.CACHE;
            }
            throw new IllegalArgumentException("Unknown ListenSource value: " + kVar);
        }
        return f0.DEFAULT;
    }

    public static n.a e(y.x xVar) {
        int i5;
        if (xVar != null && (i5 = a.f3084b[xVar.ordinal()]) != 1) {
            if (i5 != 2) {
                if (i5 == 3) {
                    return n.a.PREVIOUS;
                }
                throw new IllegalArgumentException("Unknown server timestamp behavior: " + xVar);
            }
            return n.a.ESTIMATE;
        }
        return n.a.NONE;
    }

    public static d1 f(y.EnumC0049y enumC0049y) {
        int i5 = a.f3083a[enumC0049y.ordinal()];
        if (i5 != 1) {
            if (i5 != 2) {
                if (i5 == 3) {
                    return d1.SERVER;
                }
                throw new IllegalArgumentException("Unknown source: " + enumC0049y);
            }
            return d1.DEFAULT;
        }
        return d1.CACHE;
    }

    public static w0 g(FirebaseFirestore firebaseFirestore, String str, boolean z4, y.q qVar) {
        try {
            w0 m5 = z4 ? firebaseFirestore.m(str) : firebaseFirestore.l(str);
            if (qVar == null) {
                return m5;
            }
            if (qVar.d() != null) {
                m5 = m5.G(a(qVar.d()));
            }
            List<List<Object>> j5 = qVar.j();
            Objects.requireNonNull(j5);
            for (List<Object> list : j5) {
                q qVar2 = (q) list.get(0);
                String str2 = (String) list.get(1);
                Object obj = list.get(2);
                if ("==".equals(str2)) {
                    m5 = m5.J(qVar2, obj);
                } else if ("!=".equals(str2)) {
                    m5 = m5.P(qVar2, obj);
                } else if ("<".equals(str2)) {
                    m5 = m5.N(qVar2, obj);
                } else if ("<=".equals(str2)) {
                    m5 = m5.O(qVar2, obj);
                } else if (">".equals(str2)) {
                    m5 = m5.K(qVar2, obj);
                } else if (">=".equals(str2)) {
                    m5 = m5.L(qVar2, obj);
                } else if ("array-contains".equals(str2)) {
                    m5 = m5.H(qVar2, obj);
                } else if ("array-contains-any".equals(str2)) {
                    m5 = m5.I(qVar2, (List) obj);
                } else if ("in".equals(str2)) {
                    m5 = m5.M(qVar2, (List) obj);
                } else if ("not-in".equals(str2)) {
                    m5 = m5.Q(qVar2, (List) obj);
                } else {
                    Log.w("FLTFirestoreMsgCodec", "An invalid query operator " + str2 + " was received but not handled.");
                }
            }
            Long e5 = qVar.e();
            if (e5 != null) {
                m5 = m5.s(e5.longValue());
            }
            Long f5 = qVar.f();
            if (f5 != null) {
                m5 = m5.t(f5.longValue());
            }
            List<List<Object>> g5 = qVar.g();
            if (g5 == null) {
                return m5;
            }
            for (List<Object> list2 : g5) {
                m5 = m5.u((q) list2.get(0), ((Boolean) list2.get(1)).booleanValue() ? w0.c.DESCENDING : w0.c.ASCENDING);
            }
            List<Object> i5 = qVar.i();
            if (i5 != null) {
                Object[] array = i5.toArray();
                Objects.requireNonNull(array);
                m5 = m5.B(array);
            }
            List<Object> h5 = qVar.h();
            if (h5 != null) {
                Object[] array2 = h5.toArray();
                Objects.requireNonNull(array2);
                m5 = m5.A(array2);
            }
            List<Object> b5 = qVar.b();
            if (b5 != null) {
                Object[] array3 = b5.toArray();
                Objects.requireNonNull(array3);
                m5 = m5.i(array3);
            }
            List<Object> c5 = qVar.c();
            if (c5 != null) {
                Object[] array4 = c5.toArray();
                Objects.requireNonNull(array4);
                return m5.j(array4);
            }
            return m5;
        } catch (Exception e6) {
            Log.e("FLTFirestoreMsgCodec", "An error occurred while parsing query arguments, this is most likely an error with this SDK.", e6);
            return null;
        }
    }

    public static y.l h(h hVar, n.a aVar) {
        y.l.a aVar2 = new y.l.a();
        aVar2.e(i(hVar.e()));
        aVar2.d(Long.valueOf(hVar.d()));
        aVar2.c(Long.valueOf(hVar.c()));
        aVar2.b(k(hVar.b(), aVar));
        return aVar2.a();
    }

    public static y.e i(h.b bVar) {
        int i5 = a.f3085c[bVar.ordinal()];
        if (i5 != 1) {
            if (i5 != 2) {
                if (i5 == 3) {
                    return y.e.REMOVED;
                }
                throw new IllegalArgumentException("Unknown change type: " + bVar);
            }
            return y.e.MODIFIED;
        }
        return y.e.ADDED;
    }

    public static List<y.l> j(List<h> list, n.a aVar) {
        ArrayList arrayList = new ArrayList(list.size());
        for (h hVar : list) {
            arrayList.add(h(hVar, aVar));
        }
        return arrayList;
    }

    public static y.n k(n nVar, n.a aVar) {
        y.n.a aVar2 = new y.n.a();
        aVar2.c(n(nVar.f()));
        aVar2.b(nVar.e(aVar));
        aVar2.d(nVar.g().l());
        return aVar2.a();
    }

    public static List<y.n> l(List<n> list, n.a aVar) {
        ArrayList arrayList = new ArrayList(list.size());
        for (n nVar : list) {
            arrayList.add(k(nVar, aVar));
        }
        return arrayList;
    }

    public static y.r m(y0 y0Var, n.a aVar) {
        y.r.a aVar2 = new y.r.a();
        aVar2.d(n(y0Var.m()));
        aVar2.b(j(y0Var.i(), aVar));
        aVar2.c(l(y0Var.l(), aVar));
        return aVar2.a();
    }

    public static y.s n(c1 c1Var) {
        y.s.a aVar = new y.s.a();
        aVar.b(Boolean.valueOf(c1Var.a()));
        aVar.c(Boolean.valueOf(c1Var.b()));
        return aVar.a();
    }
}
