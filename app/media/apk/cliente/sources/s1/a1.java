package s1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;
import s1.z0;
/* loaded from: classes.dex */
public final class a1 {

    /* renamed from: l  reason: collision with root package name */
    private static final z0 f7259l;

    /* renamed from: m  reason: collision with root package name */
    private static final z0 f7260m;

    /* renamed from: a  reason: collision with root package name */
    private final List<z0> f7261a;

    /* renamed from: b  reason: collision with root package name */
    private List<z0> f7262b;

    /* renamed from: c  reason: collision with root package name */
    private f1 f7263c;

    /* renamed from: d  reason: collision with root package name */
    private f1 f7264d;

    /* renamed from: e  reason: collision with root package name */
    private final List<q> f7265e;

    /* renamed from: f  reason: collision with root package name */
    private final v1.u f7266f;

    /* renamed from: g  reason: collision with root package name */
    private final String f7267g;

    /* renamed from: h  reason: collision with root package name */
    private final long f7268h;

    /* renamed from: i  reason: collision with root package name */
    private final a f7269i;

    /* renamed from: j  reason: collision with root package name */
    private final i f7270j;

    /* renamed from: k  reason: collision with root package name */
    private final i f7271k;

    /* loaded from: classes.dex */
    public enum a {
        LIMIT_TO_FIRST,
        LIMIT_TO_LAST
    }

    /* loaded from: classes.dex */
    private static class b implements Comparator<v1.i> {

        /* renamed from: a  reason: collision with root package name */
        private final List<z0> f7275a;

        b(List<z0> list) {
            boolean z4;
            loop0: while (true) {
                for (z0 z0Var : list) {
                    z4 = z4 || z0Var.c().equals(v1.r.f8134b);
                }
            }
            if (!z4) {
                throw new IllegalArgumentException("QueryComparator needs to have a key ordering");
            }
            this.f7275a = list;
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(v1.i iVar, v1.i iVar2) {
            for (z0 z0Var : this.f7275a) {
                int a5 = z0Var.a(iVar, iVar2);
                if (a5 != 0) {
                    return a5;
                }
            }
            return 0;
        }
    }

    static {
        z0.a aVar = z0.a.ASCENDING;
        v1.r rVar = v1.r.f8134b;
        f7259l = z0.d(aVar, rVar);
        f7260m = z0.d(z0.a.DESCENDING, rVar);
    }

    public a1(v1.u uVar, String str) {
        this(uVar, str, Collections.emptyList(), Collections.emptyList(), -1L, a.LIMIT_TO_FIRST, null, null);
    }

    public a1(v1.u uVar, String str, List<q> list, List<z0> list2, long j5, a aVar, i iVar, i iVar2) {
        this.f7266f = uVar;
        this.f7267g = str;
        this.f7261a = list2;
        this.f7265e = list;
        this.f7268h = j5;
        this.f7269i = aVar;
        this.f7270j = iVar;
        this.f7271k = iVar2;
    }

    private synchronized f1 E(List<z0> list) {
        if (this.f7269i == a.LIMIT_TO_FIRST) {
            return new f1(n(), f(), i(), list, this.f7268h, o(), g());
        }
        ArrayList arrayList = new ArrayList();
        for (z0 z0Var : list) {
            z0.a b5 = z0Var.b();
            z0.a aVar = z0.a.DESCENDING;
            if (b5 == aVar) {
                aVar = z0.a.ASCENDING;
            }
            arrayList.add(z0.d(aVar, z0Var.c()));
        }
        i iVar = this.f7271k;
        i iVar2 = iVar != null ? new i(iVar.b(), this.f7271k.c()) : null;
        i iVar3 = this.f7270j;
        return new f1(n(), f(), i(), arrayList, this.f7268h, iVar2, iVar3 != null ? new i(iVar3.b(), this.f7270j.c()) : null);
    }

    public static a1 b(v1.u uVar) {
        return new a1(uVar, null);
    }

    private boolean w(v1.i iVar) {
        i iVar2 = this.f7270j;
        if (iVar2 == null || iVar2.f(m(), iVar)) {
            i iVar3 = this.f7271k;
            return iVar3 == null || iVar3.e(m(), iVar);
        }
        return false;
    }

    private boolean x(v1.i iVar) {
        for (q qVar : this.f7265e) {
            if (!qVar.d(iVar)) {
                return false;
            }
        }
        return true;
    }

    private boolean y(v1.i iVar) {
        for (z0 z0Var : m()) {
            if (!z0Var.c().equals(v1.r.f8134b) && iVar.e(z0Var.f7544b) == null) {
                return false;
            }
        }
        return true;
    }

    private boolean z(v1.i iVar) {
        v1.u q5 = iVar.getKey().q();
        return this.f7267g != null ? iVar.getKey().r(this.f7267g) && this.f7266f.o(q5) : v1.l.s(this.f7266f) ? this.f7266f.equals(q5) : this.f7266f.o(q5) && this.f7266f.p() == q5.p() - 1;
    }

    public a1 A(z0 z0Var) {
        z1.b.d(!r(), "No ordering is allowed for document query", new Object[0]);
        ArrayList arrayList = new ArrayList(this.f7261a);
        arrayList.add(z0Var);
        return new a1(this.f7266f, this.f7267g, this.f7265e, arrayList, this.f7268h, this.f7269i, this.f7270j, this.f7271k);
    }

    public a1 B(i iVar) {
        return new a1(this.f7266f, this.f7267g, this.f7265e, this.f7261a, this.f7268h, this.f7269i, iVar, this.f7271k);
    }

    public synchronized f1 C() {
        if (this.f7264d == null) {
            this.f7264d = E(this.f7261a);
        }
        return this.f7264d;
    }

    public synchronized f1 D() {
        if (this.f7263c == null) {
            this.f7263c = E(m());
        }
        return this.f7263c;
    }

    public a1 a(v1.u uVar) {
        return new a1(uVar, null, this.f7265e, this.f7261a, this.f7268h, this.f7269i, this.f7270j, this.f7271k);
    }

    public Comparator<v1.i> c() {
        return new b(m());
    }

    public a1 d(i iVar) {
        return new a1(this.f7266f, this.f7267g, this.f7265e, this.f7261a, this.f7268h, this.f7269i, this.f7270j, iVar);
    }

    public a1 e(q qVar) {
        z1.b.d(!r(), "No filter is allowed for document query", new Object[0]);
        ArrayList arrayList = new ArrayList(this.f7265e);
        arrayList.add(qVar);
        return new a1(this.f7266f, this.f7267g, arrayList, this.f7261a, this.f7268h, this.f7269i, this.f7270j, this.f7271k);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || a1.class != obj.getClass()) {
            return false;
        }
        a1 a1Var = (a1) obj;
        if (this.f7269i != a1Var.f7269i) {
            return false;
        }
        return D().equals(a1Var.D());
    }

    public String f() {
        return this.f7267g;
    }

    public i g() {
        return this.f7271k;
    }

    public List<z0> h() {
        return this.f7261a;
    }

    public int hashCode() {
        return (D().hashCode() * 31) + this.f7269i.hashCode();
    }

    public List<q> i() {
        return this.f7265e;
    }

    public SortedSet<v1.r> j() {
        TreeSet treeSet = new TreeSet();
        for (q qVar : i()) {
            for (p pVar : qVar.c()) {
                if (pVar.i()) {
                    treeSet.add(pVar.f());
                }
            }
        }
        return treeSet;
    }

    public long k() {
        return this.f7268h;
    }

    public a l() {
        return this.f7269i;
    }

    public synchronized List<z0> m() {
        z0.a aVar;
        if (this.f7262b == null) {
            ArrayList arrayList = new ArrayList();
            HashSet hashSet = new HashSet();
            for (z0 z0Var : this.f7261a) {
                arrayList.add(z0Var);
                hashSet.add(z0Var.f7544b.d());
            }
            if (this.f7261a.size() > 0) {
                List<z0> list = this.f7261a;
                aVar = list.get(list.size() - 1).b();
            } else {
                aVar = z0.a.ASCENDING;
            }
            for (v1.r rVar : j()) {
                if (!hashSet.contains(rVar.d()) && !rVar.w()) {
                    arrayList.add(z0.d(aVar, rVar));
                }
            }
            if (!hashSet.contains(v1.r.f8134b.d())) {
                arrayList.add(aVar.equals(z0.a.ASCENDING) ? f7259l : f7260m);
            }
            this.f7262b = Collections.unmodifiableList(arrayList);
        }
        return this.f7262b;
    }

    public v1.u n() {
        return this.f7266f;
    }

    public i o() {
        return this.f7270j;
    }

    public boolean p() {
        return this.f7268h != -1;
    }

    public boolean q() {
        return this.f7267g != null;
    }

    public boolean r() {
        return v1.l.s(this.f7266f) && this.f7267g == null && this.f7265e.isEmpty();
    }

    public a1 s(long j5) {
        return new a1(this.f7266f, this.f7267g, this.f7265e, this.f7261a, j5, a.LIMIT_TO_FIRST, this.f7270j, this.f7271k);
    }

    public a1 t(long j5) {
        return new a1(this.f7266f, this.f7267g, this.f7265e, this.f7261a, j5, a.LIMIT_TO_LAST, this.f7270j, this.f7271k);
    }

    public String toString() {
        return "Query(target=" + D().toString() + ";limitType=" + this.f7269i.toString() + ")";
    }

    public boolean u(v1.i iVar) {
        return iVar.b() && z(iVar) && y(iVar) && x(iVar) && w(iVar);
    }

    public boolean v() {
        if (this.f7265e.isEmpty() && this.f7268h == -1 && this.f7270j == null && this.f7271k == null) {
            if (h().isEmpty()) {
                return true;
            }
            if (h().size() == 1 && h().get(0).f7544b.w()) {
                return true;
            }
        }
        return false;
    }
}
