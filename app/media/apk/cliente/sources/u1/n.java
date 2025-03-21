package u1;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import v1.q;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n {

    /* renamed from: a  reason: collision with root package name */
    private final l1 f7924a;

    /* renamed from: b  reason: collision with root package name */
    private final b1 f7925b;

    /* renamed from: c  reason: collision with root package name */
    private final b f7926c;

    /* renamed from: d  reason: collision with root package name */
    private final l f7927d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(l1 l1Var, b1 b1Var, b bVar, l lVar) {
        this.f7924a = l1Var;
        this.f7925b = b1Var;
        this.f7926c = bVar;
        this.f7927d = lVar;
    }

    private Map<v1.l, d1> a(Map<v1.l, v1.s> map, Map<v1.l, w1.k> map2, Set<v1.l> set) {
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        for (v1.s sVar : map.values()) {
            w1.k kVar = map2.get(sVar.getKey());
            if (set.contains(sVar.getKey()) && (kVar == null || (kVar.d() instanceof w1.l))) {
                hashMap.put(sVar.getKey(), sVar);
            } else if (kVar != null) {
                hashMap2.put(sVar.getKey(), kVar.d().e());
                kVar.d().a(sVar, kVar.d().e(), f1.q.q());
            } else {
                hashMap2.put(sVar.getKey(), w1.d.f8232b);
            }
        }
        hashMap2.putAll(n(hashMap));
        HashMap hashMap3 = new HashMap();
        for (Map.Entry<v1.l, v1.s> entry : map.entrySet()) {
            hashMap3.put(entry.getKey(), new d1(entry.getValue(), (w1.d) hashMap2.get(entry.getKey())));
        }
        return hashMap3;
    }

    private v1.s b(v1.l lVar, w1.k kVar) {
        return (kVar == null || (kVar.d() instanceof w1.l)) ? this.f7924a.d(lVar) : v1.s.q(lVar);
    }

    private m1.c<v1.l, v1.i> e(s1.a1 a1Var, q.a aVar, f1 f1Var) {
        z1.b.d(a1Var.n().n(), "Currently we only support collection group queries at the root.", new Object[0]);
        String f5 = a1Var.f();
        m1.c<v1.l, v1.i> a5 = v1.j.a();
        for (v1.u uVar : this.f7927d.c(f5)) {
            Iterator<Map.Entry<v1.l, v1.i>> it = f(a1Var.a(uVar.a(f5)), aVar, f1Var).iterator();
            while (it.hasNext()) {
                Map.Entry<v1.l, v1.i> next = it.next();
                a5 = a5.m(next.getKey(), next.getValue());
            }
        }
        return a5;
    }

    private m1.c<v1.l, v1.i> f(s1.a1 a1Var, q.a aVar, f1 f1Var) {
        Map<v1.l, w1.k> d5 = this.f7926c.d(a1Var.n(), aVar.m());
        Map<v1.l, v1.s> b5 = this.f7924a.b(a1Var, aVar, d5.keySet(), f1Var);
        for (Map.Entry<v1.l, w1.k> entry : d5.entrySet()) {
            if (!b5.containsKey(entry.getKey())) {
                b5.put(entry.getKey(), v1.s.q(entry.getKey()));
            }
        }
        m1.c<v1.l, v1.i> a5 = v1.j.a();
        for (Map.Entry<v1.l, v1.s> entry2 : b5.entrySet()) {
            w1.k kVar = d5.get(entry2.getKey());
            if (kVar != null) {
                kVar.d().a(entry2.getValue(), w1.d.f8232b, f1.q.q());
            }
            if (a1Var.u(entry2.getValue())) {
                a5 = a5.m(entry2.getKey(), entry2.getValue());
            }
        }
        return a5;
    }

    private m1.c<v1.l, v1.i> g(v1.u uVar) {
        m1.c<v1.l, v1.i> a5 = v1.j.a();
        v1.i c5 = c(v1.l.k(uVar));
        return c5.b() ? a5.m(c5.getKey(), c5) : a5;
    }

    private void m(Map<v1.l, w1.k> map, Set<v1.l> set) {
        TreeSet treeSet = new TreeSet();
        for (v1.l lVar : set) {
            if (!map.containsKey(lVar)) {
                treeSet.add(lVar);
            }
        }
        map.putAll(this.f7926c.b(treeSet));
    }

    private Map<v1.l, w1.d> n(Map<v1.l, v1.s> map) {
        List<w1.g> d5 = this.f7925b.d(map.keySet());
        HashMap hashMap = new HashMap();
        TreeMap treeMap = new TreeMap();
        for (w1.g gVar : d5) {
            for (v1.l lVar : gVar.f()) {
                v1.s sVar = map.get(lVar);
                if (sVar != null) {
                    hashMap.put(lVar, gVar.b(sVar, hashMap.containsKey(lVar) ? (w1.d) hashMap.get(lVar) : w1.d.f8232b));
                    int e5 = gVar.e();
                    if (!treeMap.containsKey(Integer.valueOf(e5))) {
                        treeMap.put(Integer.valueOf(e5), new HashSet());
                    }
                    ((Set) treeMap.get(Integer.valueOf(e5))).add(lVar);
                }
            }
        }
        HashSet hashSet = new HashSet();
        for (Map.Entry entry : treeMap.descendingMap().entrySet()) {
            HashMap hashMap2 = new HashMap();
            for (v1.l lVar2 : (Set) entry.getValue()) {
                if (!hashSet.contains(lVar2)) {
                    w1.f c5 = w1.f.c(map.get(lVar2), (w1.d) hashMap.get(lVar2));
                    if (c5 != null) {
                        hashMap2.put(lVar2, c5);
                    }
                    hashSet.add(lVar2);
                }
            }
            this.f7926c.e(((Integer) entry.getKey()).intValue(), hashMap2);
        }
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public v1.i c(v1.l lVar) {
        w1.k a5 = this.f7926c.a(lVar);
        v1.s b5 = b(lVar, a5);
        if (a5 != null) {
            a5.d().a(b5, w1.d.f8232b, f1.q.q());
        }
        return b5;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public m1.c<v1.l, v1.i> d(Iterable<v1.l> iterable) {
        return j(this.f7924a.f(iterable), new HashSet());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public m1.c<v1.l, v1.i> h(s1.a1 a1Var, q.a aVar) {
        return i(a1Var, aVar, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public m1.c<v1.l, v1.i> i(s1.a1 a1Var, q.a aVar, f1 f1Var) {
        return a1Var.r() ? g(a1Var.n()) : a1Var.q() ? e(a1Var, aVar, f1Var) : f(a1Var, aVar, f1Var);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public m1.c<v1.l, v1.i> j(Map<v1.l, v1.s> map, Set<v1.l> set) {
        HashMap hashMap = new HashMap();
        m(hashMap, map.keySet());
        m1.c<v1.l, v1.i> a5 = v1.j.a();
        for (Map.Entry<v1.l, d1> entry : a(map, hashMap, set).entrySet()) {
            a5 = a5.m(entry.getKey(), entry.getValue().a());
        }
        return a5;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public m k(String str, q.a aVar, int i5) {
        Map<v1.l, v1.s> c5 = this.f7924a.c(str, aVar, i5);
        Map<v1.l, w1.k> f5 = i5 - c5.size() > 0 ? this.f7926c.f(str, aVar.m(), i5 - c5.size()) : new HashMap<>();
        int i6 = -1;
        for (w1.k kVar : f5.values()) {
            if (!c5.containsKey(kVar.b())) {
                c5.put(kVar.b(), b(kVar.b(), kVar));
            }
            i6 = Math.max(i6, kVar.c());
        }
        m(f5, c5.keySet());
        return m.a(i6, a(c5, f5, Collections.emptySet()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Map<v1.l, d1> l(Map<v1.l, v1.s> map) {
        HashMap hashMap = new HashMap();
        m(hashMap, map.keySet());
        return a(map, hashMap, new HashSet());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o(Set<v1.l> set) {
        n(this.f7924a.f(set));
    }
}
