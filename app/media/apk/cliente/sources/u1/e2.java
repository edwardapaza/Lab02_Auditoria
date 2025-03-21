package u1;

import android.database.Cursor;
import android.text.TextUtils;
import android.util.Pair;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.SortedSet;
import java.util.TreeSet;
import s1.k;
import s1.p;
import s1.z0;
import u1.a3;
import u1.l;
import u1.t0;
import v1.q;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class e2 implements l {

    /* renamed from: k  reason: collision with root package name */
    private static final String f7784k = "e2";

    /* renamed from: l  reason: collision with root package name */
    private static final byte[] f7785l = new byte[0];

    /* renamed from: a  reason: collision with root package name */
    private final a3 f7786a;

    /* renamed from: b  reason: collision with root package name */
    private final o f7787b;

    /* renamed from: c  reason: collision with root package name */
    private final String f7788c;

    /* renamed from: d  reason: collision with root package name */
    private final Map<s1.f1, List<s1.f1>> f7789d = new HashMap();

    /* renamed from: e  reason: collision with root package name */
    private final t0.a f7790e = new t0.a();

    /* renamed from: f  reason: collision with root package name */
    private final Map<String, Map<Integer, v1.q>> f7791f = new HashMap();

    /* renamed from: g  reason: collision with root package name */
    private final Queue<v1.q> f7792g = new PriorityQueue(10, new Comparator() { // from class: u1.w1
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            int Q;
            Q = e2.Q((v1.q) obj, (v1.q) obj2);
            return Q;
        }
    });

    /* renamed from: h  reason: collision with root package name */
    private boolean f7793h = false;

    /* renamed from: i  reason: collision with root package name */
    private int f7794i = -1;

    /* renamed from: j  reason: collision with root package name */
    private long f7795j = -1;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e2(a3 a3Var, o oVar, q1.j jVar) {
        this.f7786a = a3Var;
        this.f7787b = oVar;
        this.f7788c = jVar.b() ? jVar.a() : "";
    }

    private byte[] A(v1.q qVar) {
        return this.f7787b.l(qVar.h()).j();
    }

    private byte[] B(i2.d0 d0Var) {
        t1.d dVar = new t1.d();
        t1.c.f7593a.e(d0Var, dVar.b(q.c.a.ASCENDING));
        return dVar.c();
    }

    private Object[] C(v1.q qVar, s1.f1 f1Var, Collection<i2.d0> collection) {
        if (collection == null) {
            return null;
        }
        List<t1.d> arrayList = new ArrayList<>();
        arrayList.add(new t1.d());
        Iterator<i2.d0> it = collection.iterator();
        for (q.c cVar : qVar.e()) {
            i2.d0 next = it.next();
            for (t1.d dVar : arrayList) {
                if (M(f1Var, cVar.d()) && v1.z.t(next)) {
                    arrayList = D(arrayList, cVar, next);
                } else {
                    t1.c.f7593a.e(next, dVar.b(cVar.e()));
                }
            }
        }
        return G(arrayList);
    }

    private List<t1.d> D(List<t1.d> list, q.c cVar, i2.d0 d0Var) {
        ArrayList<t1.d> arrayList = new ArrayList(list);
        ArrayList arrayList2 = new ArrayList();
        for (i2.d0 d0Var2 : d0Var.p0().e()) {
            for (t1.d dVar : arrayList) {
                t1.d dVar2 = new t1.d();
                dVar2.d(dVar.c());
                t1.c.f7593a.e(d0Var2, dVar2.b(cVar.e()));
                arrayList2.add(dVar2);
            }
        }
        return arrayList2;
    }

    private Object[] E(int i5, int i6, List<i2.d0> list, Object[] objArr, Object[] objArr2, Object[] objArr3) {
        int size = i5 / (list != null ? list.size() : 1);
        int i7 = 0;
        Object[] objArr4 = new Object[(i5 * 5) + (objArr3 != null ? objArr3.length : 0)];
        int i8 = 0;
        int i9 = 0;
        while (i8 < i5) {
            int i10 = i9 + 1;
            objArr4[i9] = Integer.valueOf(i6);
            int i11 = i10 + 1;
            objArr4[i10] = this.f7788c;
            int i12 = i11 + 1;
            objArr4[i11] = list != null ? B(list.get(i8 / size)) : f7785l;
            int i13 = i12 + 1;
            int i14 = i8 % size;
            objArr4[i12] = objArr[i14];
            objArr4[i13] = objArr2[i14];
            i8++;
            i9 = i13 + 1;
        }
        if (objArr3 != null) {
            int length = objArr3.length;
            while (i7 < length) {
                objArr4[i9] = objArr3[i7];
                i7++;
                i9++;
            }
        }
        return objArr4;
    }

    private Object[] F(s1.f1 f1Var, int i5, List<i2.d0> list, Object[] objArr, String str, Object[] objArr2, String str2, Object[] objArr3) {
        StringBuilder sb;
        int max = Math.max(objArr.length, objArr2.length) * (list != null ? list.size() : 1);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("SELECT document_key, directional_value FROM index_entries ");
        sb2.append("WHERE index_id = ? AND uid = ? ");
        sb2.append("AND array_value = ? ");
        sb2.append("AND directional_value ");
        sb2.append(str);
        sb2.append(" ? ");
        sb2.append("AND directional_value ");
        sb2.append(str2);
        sb2.append(" ? ");
        StringBuilder z4 = z1.h0.z(sb2, max, " UNION ");
        if (objArr3 != null) {
            StringBuilder sb3 = new StringBuilder("SELECT document_key, directional_value FROM (");
            sb3.append((CharSequence) z4);
            sb3.append(") WHERE directional_value NOT IN (");
            sb3.append((CharSequence) z1.h0.z("?", objArr3.length, ", "));
            sb3.append(")");
            sb = sb3;
        } else {
            sb = z4;
        }
        Object[] E = E(max, i5, list, objArr, objArr2, objArr3);
        ArrayList arrayList = new ArrayList();
        arrayList.add(sb.toString());
        arrayList.addAll(Arrays.asList(E));
        return arrayList.toArray();
    }

    private Object[] G(List<t1.d> list) {
        Object[] objArr = new Object[list.size()];
        for (int i5 = 0; i5 < list.size(); i5++) {
            objArr[i5] = list.get(i5).c();
        }
        return objArr;
    }

    private SortedSet<t1.e> H(final v1.l lVar, final v1.q qVar) {
        final TreeSet treeSet = new TreeSet();
        this.f7786a.E("SELECT array_value, directional_value FROM index_entries WHERE index_id = ? AND document_key = ? AND uid = ?").b(Integer.valueOf(qVar.f()), lVar.toString(), this.f7788c).e(new z1.n() { // from class: u1.b2
            @Override // z1.n
            public final void accept(Object obj) {
                e2.P(treeSet, qVar, lVar, (Cursor) obj);
            }
        });
        return treeSet;
    }

    private v1.q I(s1.f1 f1Var) {
        z1.b.d(this.f7793h, "IndexManager not started", new Object[0]);
        v1.y yVar = new v1.y(f1Var);
        Collection<v1.q> J = J(f1Var.d() != null ? f1Var.d() : f1Var.n().k());
        v1.q qVar = null;
        if (J.isEmpty()) {
            return null;
        }
        for (v1.q qVar2 : J) {
            if (yVar.h(qVar2) && (qVar == null || qVar2.h().size() > qVar.h().size())) {
                qVar = qVar2;
            }
        }
        return qVar;
    }

    private q.a K(Collection<v1.q> collection) {
        z1.b.d(!collection.isEmpty(), "Found empty index group when looking for least recent index offset.", new Object[0]);
        Iterator<v1.q> it = collection.iterator();
        q.a c5 = it.next().g().c();
        int m5 = c5.m();
        while (it.hasNext()) {
            q.a c6 = it.next().g().c();
            if (c6.compareTo(c5) < 0) {
                c5 = c6;
            }
            m5 = Math.max(c6.m(), m5);
        }
        return q.a.d(c5.n(), c5.k(), m5);
    }

    private List<s1.f1> L(s1.f1 f1Var) {
        if (this.f7789d.containsKey(f1Var)) {
            return this.f7789d.get(f1Var);
        }
        ArrayList arrayList = new ArrayList();
        if (f1Var.h().isEmpty()) {
            arrayList.add(f1Var);
        } else {
            for (s1.q qVar : z1.x.i(new s1.k(f1Var.h(), k.a.AND))) {
                arrayList.add(new s1.f1(f1Var.n(), f1Var.d(), qVar.b(), f1Var.m(), f1Var.j(), f1Var.p(), f1Var.f()));
            }
        }
        this.f7789d.put(f1Var, arrayList);
        return arrayList;
    }

    private boolean M(s1.f1 f1Var, v1.r rVar) {
        for (s1.q qVar : f1Var.h()) {
            if (qVar instanceof s1.p) {
                s1.p pVar = (s1.p) qVar;
                if (pVar.f().equals(rVar)) {
                    p.b g5 = pVar.g();
                    if (g5.equals(p.b.IN) || g5.equals(p.b.NOT_IN)) {
                        return true;
                    }
                } else {
                    continue;
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void N(ArrayList arrayList, Cursor cursor) {
        arrayList.add(f.b(cursor.getString(0)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void O(List list, Cursor cursor) {
        list.add(v1.l.k(v1.u.u(cursor.getString(0))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void P(SortedSet sortedSet, v1.q qVar, v1.l lVar, Cursor cursor) {
        sortedSet.add(t1.e.c(qVar.f(), lVar, cursor.getBlob(0), cursor.getBlob(1)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int Q(v1.q qVar, v1.q qVar2) {
        int compare = Long.compare(qVar.g().d(), qVar2.g().d());
        return compare == 0 ? qVar.d().compareTo(qVar2.d()) : compare;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void R(Map map, Cursor cursor) {
        map.put(Integer.valueOf(cursor.getInt(0)), q.b.b(cursor.getLong(1), new v1.w(new f1.q(cursor.getLong(2), cursor.getInt(3))), v1.l.k(f.b(cursor.getString(4))), cursor.getInt(5)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void S(Map map, Cursor cursor) {
        try {
            int i5 = cursor.getInt(0);
            V(v1.q.b(i5, cursor.getString(1), this.f7787b.c(g2.a.k0(cursor.getBlob(2))), map.containsKey(Integer.valueOf(i5)) ? (q.b) map.get(Integer.valueOf(i5)) : v1.q.f8126a));
        } catch (com.google.protobuf.e0 e5) {
            throw z1.b.a("Failed to decode index: " + e5, new Object[0]);
        }
    }

    private void V(v1.q qVar) {
        Map<Integer, v1.q> map = this.f7791f.get(qVar.d());
        if (map == null) {
            map = new HashMap<>();
            this.f7791f.put(qVar.d(), map);
        }
        v1.q qVar2 = map.get(Integer.valueOf(qVar.f()));
        if (qVar2 != null) {
            this.f7792g.remove(qVar2);
        }
        map.put(Integer.valueOf(qVar.f()), qVar);
        this.f7792g.add(qVar);
        this.f7794i = Math.max(this.f7794i, qVar.f());
        this.f7795j = Math.max(this.f7795j, qVar.g().d());
    }

    private void W(final v1.i iVar, SortedSet<t1.e> sortedSet, SortedSet<t1.e> sortedSet2) {
        z1.w.a(f7784k, "Updating index entries for document '%s'", iVar.getKey());
        z1.h0.s(sortedSet, sortedSet2, new z1.n() { // from class: u1.y1
            @Override // z1.n
            public final void accept(Object obj) {
                e2.this.T(iVar, (t1.e) obj);
            }
        }, new z1.n() { // from class: u1.z1
            @Override // z1.n
            public final void accept(Object obj) {
                e2.this.U(iVar, (t1.e) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: v */
    public void T(v1.i iVar, t1.e eVar) {
        this.f7786a.v("INSERT INTO index_entries (index_id, uid, array_value, directional_value, document_key) VALUES(?, ?, ?, ?, ?)", Integer.valueOf(eVar.k()), this.f7788c, eVar.d(), eVar.e(), iVar.getKey().toString());
    }

    private SortedSet<t1.e> w(v1.i iVar, v1.q qVar) {
        TreeSet treeSet = new TreeSet();
        byte[] z4 = z(qVar, iVar);
        if (z4 == null) {
            return treeSet;
        }
        q.c c5 = qVar.c();
        if (c5 != null) {
            i2.d0 e5 = iVar.e(c5.d());
            if (v1.z.t(e5)) {
                for (i2.d0 d0Var : e5.p0().e()) {
                    treeSet.add(t1.e.c(qVar.f(), iVar.getKey(), B(d0Var), z4));
                }
            }
        } else {
            treeSet.add(t1.e.c(qVar.f(), iVar.getKey(), new byte[0], z4));
        }
        return treeSet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: x */
    public void U(v1.i iVar, t1.e eVar) {
        this.f7786a.v("DELETE FROM index_entries WHERE index_id = ? AND uid = ? AND array_value = ? AND directional_value = ? AND document_key = ?", Integer.valueOf(eVar.k()), this.f7788c, eVar.d(), eVar.e(), iVar.getKey().toString());
    }

    private Object[] y(v1.q qVar, s1.f1 f1Var, s1.i iVar) {
        return C(qVar, f1Var, iVar.b());
    }

    private byte[] z(v1.q qVar, v1.i iVar) {
        t1.d dVar = new t1.d();
        for (q.c cVar : qVar.e()) {
            i2.d0 e5 = iVar.e(cVar.d());
            if (e5 == null) {
                return null;
            }
            t1.c.f7593a.e(e5, dVar.b(cVar.e()));
        }
        return dVar.c();
    }

    public Collection<v1.q> J(String str) {
        z1.b.d(this.f7793h, "IndexManager not started", new Object[0]);
        Map<Integer, v1.q> map = this.f7791f.get(str);
        return map == null ? Collections.emptyList() : map.values();
    }

    @Override // u1.l
    public void a(m1.c<v1.l, v1.i> cVar) {
        z1.b.d(this.f7793h, "IndexManager not started", new Object[0]);
        Iterator<Map.Entry<v1.l, v1.i>> it = cVar.iterator();
        while (it.hasNext()) {
            Map.Entry<v1.l, v1.i> next = it.next();
            for (v1.q qVar : J(next.getKey().n())) {
                SortedSet<t1.e> H = H(next.getKey(), qVar);
                SortedSet<t1.e> w5 = w(next.getValue(), qVar);
                if (!H.equals(w5)) {
                    W(next.getValue(), H, w5);
                }
            }
        }
    }

    @Override // u1.l
    public l.a b(s1.f1 f1Var) {
        l.a aVar = l.a.FULL;
        List<s1.f1> L = L(f1Var);
        Iterator<s1.f1> it = L.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            s1.f1 next = it.next();
            v1.q I = I(next);
            if (I == null) {
                aVar = l.a.NONE;
                break;
            } else if (I.h().size() < next.o()) {
                aVar = l.a.PARTIAL;
            }
        }
        return (f1Var.r() && L.size() > 1 && aVar == l.a.FULL) ? l.a.PARTIAL : aVar;
    }

    @Override // u1.l
    public List<v1.u> c(String str) {
        z1.b.d(this.f7793h, "IndexManager not started", new Object[0]);
        final ArrayList arrayList = new ArrayList();
        this.f7786a.E("SELECT parent FROM collection_parents WHERE collection_id = ?").b(str).e(new z1.n() { // from class: u1.a2
            @Override // z1.n
            public final void accept(Object obj) {
                e2.N(arrayList, (Cursor) obj);
            }
        });
        return arrayList;
    }

    @Override // u1.l
    public void d(String str, q.a aVar) {
        z1.b.d(this.f7793h, "IndexManager not started", new Object[0]);
        this.f7795j++;
        for (v1.q qVar : J(str)) {
            v1.q b5 = v1.q.b(qVar.f(), qVar.d(), qVar.h(), q.b.a(this.f7795j, aVar));
            this.f7786a.v("REPLACE INTO index_state (index_id, uid,  sequence_number, read_time_seconds, read_time_nanos, document_key, largest_batch_id) VALUES(?, ?, ?, ?, ?, ?, ?)", Integer.valueOf(qVar.f()), this.f7788c, Long.valueOf(this.f7795j), Long.valueOf(aVar.n().c().n()), Integer.valueOf(aVar.n().c().h()), f.c(aVar.k().q()), Integer.valueOf(aVar.m()));
            V(b5);
        }
    }

    @Override // u1.l
    public q.a e(s1.f1 f1Var) {
        ArrayList arrayList = new ArrayList();
        for (s1.f1 f1Var2 : L(f1Var)) {
            v1.q I = I(f1Var2);
            if (I != null) {
                arrayList.add(I);
            }
        }
        return K(arrayList);
    }

    @Override // u1.l
    public void f(v1.q qVar) {
        z1.b.d(this.f7793h, "IndexManager not started", new Object[0]);
        int i5 = this.f7794i + 1;
        v1.q b5 = v1.q.b(i5, qVar.d(), qVar.h(), qVar.g());
        this.f7786a.v("INSERT INTO index_configuration (index_id, collection_group, index_proto) VALUES(?, ?, ?)", Integer.valueOf(i5), b5.d(), A(b5));
        V(b5);
    }

    @Override // u1.l
    public q.a g(String str) {
        Collection<v1.q> J = J(str);
        z1.b.d(!J.isEmpty(), "minOffset was called for collection without indexes", new Object[0]);
        return K(J);
    }

    @Override // u1.l
    public void h(v1.q qVar) {
        this.f7786a.v("DELETE FROM index_configuration WHERE index_id = ?", Integer.valueOf(qVar.f()));
        this.f7786a.v("DELETE FROM index_entries WHERE index_id = ?", Integer.valueOf(qVar.f()));
        this.f7786a.v("DELETE FROM index_state WHERE index_id = ?", Integer.valueOf(qVar.f()));
        this.f7792g.remove(qVar);
        Map<Integer, v1.q> map = this.f7791f.get(qVar.d());
        if (map != null) {
            map.remove(Integer.valueOf(qVar.f()));
        }
    }

    @Override // u1.l
    public List<v1.l> i(s1.f1 f1Var) {
        z1.b.d(this.f7793h, "IndexManager not started", new Object[0]);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList<Pair> arrayList3 = new ArrayList();
        for (s1.f1 f1Var2 : L(f1Var)) {
            v1.q I = I(f1Var2);
            if (I == null) {
                return null;
            }
            arrayList3.add(Pair.create(f1Var2, I));
        }
        for (Pair pair : arrayList3) {
            s1.f1 f1Var3 = (s1.f1) pair.first;
            v1.q qVar = (v1.q) pair.second;
            List<i2.d0> a5 = f1Var3.a(qVar);
            Collection<i2.d0> l5 = f1Var3.l(qVar);
            s1.i k5 = f1Var3.k(qVar);
            s1.i q5 = f1Var3.q(qVar);
            if (z1.w.c()) {
                z1.w.a(f7784k, "Using index '%s' to execute '%s' (Arrays: %s, Lower bound: %s, Upper bound: %s)", qVar, f1Var3, a5, k5, q5);
            }
            Object[] F = F(f1Var3, qVar.f(), a5, y(qVar, f1Var3, k5), k5.c() ? ">=" : ">", y(qVar, f1Var3, q5), q5.c() ? "<=" : "<", C(qVar, f1Var3, l5));
            arrayList.add(String.valueOf(F[0]));
            arrayList2.addAll(Arrays.asList(F).subList(1, F.length));
        }
        StringBuilder sb = new StringBuilder();
        sb.append(TextUtils.join(" UNION ", arrayList));
        sb.append("ORDER BY directional_value, document_key ");
        sb.append(f1Var.i().equals(z0.a.ASCENDING) ? "asc " : "desc ");
        String str = "SELECT DISTINCT document_key FROM (" + sb.toString() + ")";
        if (f1Var.r()) {
            str = str + " LIMIT " + f1Var.j();
        }
        z1.b.d(arrayList2.size() < 1000, "Cannot perform query with more than 999 bind elements", new Object[0]);
        a3.d b5 = this.f7786a.E(str).b(arrayList2.toArray());
        final ArrayList arrayList4 = new ArrayList();
        b5.e(new z1.n() { // from class: u1.x1
            @Override // z1.n
            public final void accept(Object obj) {
                e2.O(arrayList4, (Cursor) obj);
            }
        });
        z1.w.a(f7784k, "Index scan returned %s documents", Integer.valueOf(arrayList4.size()));
        return arrayList4;
    }

    @Override // u1.l
    public void j(v1.u uVar) {
        z1.b.d(this.f7793h, "IndexManager not started", new Object[0]);
        z1.b.d(uVar.p() % 2 == 1, "Expected a collection path.", new Object[0]);
        if (this.f7790e.a(uVar)) {
            this.f7786a.v("INSERT OR REPLACE INTO collection_parents (collection_id, parent) VALUES (?, ?)", uVar.k(), f.c(uVar.r()));
        }
    }

    @Override // u1.l
    public Collection<v1.q> k() {
        ArrayList arrayList = new ArrayList();
        for (Map<Integer, v1.q> map : this.f7791f.values()) {
            arrayList.addAll(map.values());
        }
        return arrayList;
    }

    @Override // u1.l
    public void l(s1.f1 f1Var) {
        z1.b.d(this.f7793h, "IndexManager not started", new Object[0]);
        for (s1.f1 f1Var2 : L(f1Var)) {
            l.a b5 = b(f1Var2);
            if (b5 == l.a.NONE || b5 == l.a.PARTIAL) {
                v1.q b6 = new v1.y(f1Var2).b();
                if (b6 != null) {
                    f(b6);
                }
            }
        }
    }

    @Override // u1.l
    public String m() {
        z1.b.d(this.f7793h, "IndexManager not started", new Object[0]);
        v1.q peek = this.f7792g.peek();
        if (peek != null) {
            return peek.d();
        }
        return null;
    }

    @Override // u1.l
    public void start() {
        final HashMap hashMap = new HashMap();
        this.f7786a.E("SELECT index_id, sequence_number, read_time_seconds, read_time_nanos, document_key, largest_batch_id FROM index_state WHERE uid = ?").b(this.f7788c).e(new z1.n() { // from class: u1.c2
            @Override // z1.n
            public final void accept(Object obj) {
                e2.R(hashMap, (Cursor) obj);
            }
        });
        this.f7786a.E("SELECT index_id, collection_group, index_proto FROM index_configuration").e(new z1.n() { // from class: u1.d2
            @Override // z1.n
            public final void accept(Object obj) {
                e2.this.S(hashMap, (Cursor) obj);
            }
        });
        this.f7793h = true;
    }
}
