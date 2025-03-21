package y1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import s1.f1;
import s1.m;
import u1.h1;
import u1.i4;
import y1.n;
import y1.x0;
import y1.y0;
/* loaded from: classes.dex */
public class z0 {

    /* renamed from: a  reason: collision with root package name */
    private final c f8584a;

    /* renamed from: b  reason: collision with root package name */
    private final Map<Integer, w0> f8585b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    private Map<v1.l, v1.s> f8586c = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    private Map<v1.l, Set<Integer>> f8587d = new HashMap();

    /* renamed from: e  reason: collision with root package name */
    private Map<Integer, h1> f8588e = new HashMap();

    /* loaded from: classes.dex */
    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f8589a;

        static {
            int[] iArr = new int[y0.e.values().length];
            f8589a = iArr;
            try {
                iArr[y0.e.NoChange.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f8589a[y0.e.Added.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f8589a[y0.e.Removed.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f8589a[y0.e.Current.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f8589a[y0.e.Reset.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public enum b {
        SUCCESS,
        SKIPPED,
        FALSE_POSITIVE
    }

    /* loaded from: classes.dex */
    public interface c {
        i4 a(int i5);

        m1.e<v1.l> b(int i5);

        v1.f c();
    }

    public z0(c cVar) {
        this.f8584a = cVar;
    }

    private void a(int i5, v1.s sVar) {
        if (l(i5)) {
            e(i5).a(sVar.getKey(), s(i5, sVar.getKey()) ? m.a.MODIFIED : m.a.ADDED);
            this.f8586c.put(sVar.getKey(), sVar);
            d(sVar.getKey()).add(Integer.valueOf(i5));
        }
    }

    private b b(n nVar, y0.c cVar, int i5) {
        return cVar.a().a() == i5 - f(nVar, cVar.b()) ? b.SUCCESS : b.FALSE_POSITIVE;
    }

    private Set<Integer> d(v1.l lVar) {
        Set<Integer> set = this.f8587d.get(lVar);
        if (set == null) {
            HashSet hashSet = new HashSet();
            this.f8587d.put(lVar, hashSet);
            return hashSet;
        }
        return set;
    }

    private w0 e(int i5) {
        w0 w0Var = this.f8585b.get(Integer.valueOf(i5));
        if (w0Var == null) {
            w0 w0Var2 = new w0();
            this.f8585b.put(Integer.valueOf(i5), w0Var2);
            return w0Var2;
        }
        return w0Var;
    }

    private int f(n nVar, int i5) {
        Iterator<v1.l> it = this.f8584a.b(i5).iterator();
        int i6 = 0;
        while (it.hasNext()) {
            v1.l next = it.next();
            v1.f c5 = this.f8584a.c();
            if (!nVar.h("projects/" + c5.h() + "/databases/" + c5.e() + "/documents/" + next.q().d())) {
                p(i5, next, null);
                i6++;
            }
        }
        return i6;
    }

    private int g(int i5) {
        v0 j5 = e(i5).j();
        return (this.f8584a.b(i5).size() + j5.b().size()) - j5.d().size();
    }

    private Collection<Integer> h(y0.d dVar) {
        List<Integer> d5 = dVar.d();
        if (d5.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            for (Integer num : this.f8585b.keySet()) {
                if (l(num.intValue())) {
                    arrayList.add(num);
                }
            }
            return arrayList;
        }
        return d5;
    }

    private boolean l(int i5) {
        return n(i5) != null;
    }

    private n m(y0.c cVar) {
        i2.g b5 = cVar.a().b();
        if (b5 != null && b5.h0()) {
            try {
                n a5 = n.a(b5.e0().e0(), b5.e0().g0(), b5.g0());
                if (a5.c() == 0) {
                    return null;
                }
                return a5;
            } catch (n.a e5) {
                z1.w.e("WatchChangeAggregator", "Applying bloom filter failed: (" + e5.getMessage() + "); ignoring the bloom filter and falling back to full re-query.", new Object[0]);
            }
        }
        return null;
    }

    private i4 n(int i5) {
        w0 w0Var = this.f8585b.get(Integer.valueOf(i5));
        if (w0Var == null || !w0Var.e()) {
            return this.f8584a.a(i5);
        }
        return null;
    }

    private void p(int i5, v1.l lVar, v1.s sVar) {
        if (l(i5)) {
            w0 e5 = e(i5);
            if (s(i5, lVar)) {
                e5.a(lVar, m.a.REMOVED);
            } else {
                e5.i(lVar);
            }
            d(lVar).add(Integer.valueOf(i5));
            if (sVar != null) {
                this.f8586c.put(lVar, sVar);
            }
        }
    }

    private void r(int i5) {
        z1.b.d((this.f8585b.get(Integer.valueOf(i5)) == null || this.f8585b.get(Integer.valueOf(i5)).e()) ? false : true, "Should only reset active targets", new Object[0]);
        this.f8585b.put(Integer.valueOf(i5), new w0());
        Iterator<v1.l> it = this.f8584a.b(i5).iterator();
        while (it.hasNext()) {
            p(i5, it.next(), null);
        }
    }

    private boolean s(int i5, v1.l lVar) {
        return this.f8584a.b(i5).contains(lVar);
    }

    public n0 c(v1.w wVar) {
        HashMap hashMap = new HashMap();
        for (Map.Entry<Integer, w0> entry : this.f8585b.entrySet()) {
            int intValue = entry.getKey().intValue();
            w0 value = entry.getValue();
            i4 n5 = n(intValue);
            if (n5 != null) {
                if (value.d() && n5.g().s()) {
                    v1.l k5 = v1.l.k(n5.g().n());
                    if (this.f8586c.get(k5) == null && !s(intValue, k5)) {
                        p(intValue, k5, v1.s.r(k5, wVar));
                    }
                }
                if (value.c()) {
                    hashMap.put(Integer.valueOf(intValue), value.j());
                    value.b();
                }
            }
        }
        HashSet hashSet = new HashSet();
        for (Map.Entry<v1.l, Set<Integer>> entry2 : this.f8587d.entrySet()) {
            v1.l key = entry2.getKey();
            boolean z4 = true;
            Iterator<Integer> it = entry2.getValue().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                i4 n6 = n(it.next().intValue());
                if (n6 != null && !n6.c().equals(h1.LIMBO_RESOLUTION)) {
                    z4 = false;
                    break;
                }
            }
            if (z4) {
                hashSet.add(key);
            }
        }
        for (v1.s sVar : this.f8586c.values()) {
            sVar.v(wVar);
        }
        n0 n0Var = new n0(wVar, Collections.unmodifiableMap(hashMap), Collections.unmodifiableMap(this.f8588e), Collections.unmodifiableMap(this.f8586c), Collections.unmodifiableSet(hashSet));
        this.f8586c = new HashMap();
        this.f8587d = new HashMap();
        this.f8588e = new HashMap();
        return n0Var;
    }

    public void i(y0.b bVar) {
        v1.s b5 = bVar.b();
        v1.l a5 = bVar.a();
        for (Integer num : bVar.d()) {
            int intValue = num.intValue();
            if (b5 == null || !b5.b()) {
                p(intValue, a5, b5);
            } else {
                a(intValue, b5);
            }
        }
        for (Integer num2 : bVar.c()) {
            p(num2.intValue(), a5, bVar.b());
        }
    }

    public void j(y0.c cVar) {
        int b5 = cVar.b();
        int a5 = cVar.a().a();
        i4 n5 = n(b5);
        if (n5 != null) {
            f1 g5 = n5.g();
            if (g5.s()) {
                if (a5 != 0) {
                    z1.b.d(a5 == 1, "Single document existence filter with count: %d", Integer.valueOf(a5));
                    return;
                }
                v1.l k5 = v1.l.k(g5.n());
                p(b5, k5, v1.s.r(k5, v1.w.f8154b));
                return;
            }
            int g6 = g(b5);
            if (g6 != a5) {
                n m5 = m(cVar);
                b b6 = m5 != null ? b(m5, cVar, g6) : b.SKIPPED;
                if (b6 != b.SUCCESS) {
                    r(b5);
                    this.f8588e.put(Integer.valueOf(b5), b6 == b.FALSE_POSITIVE ? h1.EXISTENCE_FILTER_MISMATCH_BLOOM : h1.EXISTENCE_FILTER_MISMATCH);
                }
                x0.a().b(x0.b.e(g6, cVar.a(), this.f8584a.c(), m5, b6));
            }
        }
    }

    public void k(y0.d dVar) {
        for (Integer num : h(dVar)) {
            int intValue = num.intValue();
            w0 e5 = e(intValue);
            int i5 = a.f8589a[dVar.b().ordinal()];
            if (i5 != 1) {
                if (i5 == 2) {
                    e5.h();
                    if (!e5.e()) {
                        e5.b();
                    }
                } else if (i5 == 3) {
                    e5.h();
                    if (!e5.e()) {
                        q(intValue);
                    }
                    z1.b.d(dVar.a() == null, "WatchChangeAggregator does not handle errored targets", new Object[0]);
                } else if (i5 != 4) {
                    if (i5 != 5) {
                        throw z1.b.a("Unknown target watch change state: %s", dVar.b());
                    }
                    if (l(intValue)) {
                        r(intValue);
                    }
                } else if (l(intValue)) {
                    e5.f();
                }
                e5.k(dVar.c());
            } else if (l(intValue)) {
                e5.k(dVar.c());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o(int i5) {
        e(i5).g();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void q(int i5) {
        this.f8585b.remove(Integer.valueOf(i5));
    }
}
