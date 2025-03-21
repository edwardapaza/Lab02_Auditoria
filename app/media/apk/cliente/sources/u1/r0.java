package u1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeMap;
/* loaded from: classes.dex */
public class r0 implements b {

    /* renamed from: a  reason: collision with root package name */
    private final TreeMap<v1.l, w1.k> f7976a = new TreeMap<>();

    /* renamed from: b  reason: collision with root package name */
    private final Map<Integer, Set<v1.l>> f7977b = new HashMap();

    private void g(int i5, w1.f fVar) {
        w1.k kVar = this.f7976a.get(fVar.g());
        if (kVar != null) {
            this.f7977b.get(Integer.valueOf(kVar.c())).remove(fVar.g());
        }
        this.f7976a.put(fVar.g(), w1.k.a(i5, fVar));
        if (this.f7977b.get(Integer.valueOf(i5)) == null) {
            this.f7977b.put(Integer.valueOf(i5), new HashSet());
        }
        this.f7977b.get(Integer.valueOf(i5)).add(fVar.g());
    }

    @Override // u1.b
    public w1.k a(v1.l lVar) {
        return this.f7976a.get(lVar);
    }

    @Override // u1.b
    public Map<v1.l, w1.k> b(SortedSet<v1.l> sortedSet) {
        HashMap hashMap = new HashMap();
        for (v1.l lVar : sortedSet) {
            w1.k kVar = this.f7976a.get(lVar);
            if (kVar != null) {
                hashMap.put(lVar, kVar);
            }
        }
        return hashMap;
    }

    @Override // u1.b
    public void c(int i5) {
        if (this.f7977b.containsKey(Integer.valueOf(i5))) {
            this.f7977b.remove(Integer.valueOf(i5));
            for (v1.l lVar : this.f7977b.get(Integer.valueOf(i5))) {
                this.f7976a.remove(lVar);
            }
        }
    }

    @Override // u1.b
    public Map<v1.l, w1.k> d(v1.u uVar, int i5) {
        HashMap hashMap = new HashMap();
        int p5 = uVar.p() + 1;
        for (w1.k kVar : this.f7976a.tailMap(v1.l.k(uVar.a(""))).values()) {
            v1.l b5 = kVar.b();
            if (!uVar.o(b5.q())) {
                break;
            } else if (b5.q().p() == p5 && kVar.c() > i5) {
                hashMap.put(kVar.b(), kVar);
            }
        }
        return hashMap;
    }

    @Override // u1.b
    public void e(int i5, Map<v1.l, w1.f> map) {
        for (Map.Entry<v1.l, w1.f> entry : map.entrySet()) {
            g(i5, (w1.f) z1.y.d(entry.getValue(), "null value for key: %s", entry.getKey()));
        }
    }

    @Override // u1.b
    public Map<v1.l, w1.k> f(String str, int i5, int i6) {
        TreeMap treeMap = new TreeMap();
        for (w1.k kVar : this.f7976a.values()) {
            if (kVar.b().n().equals(str) && kVar.c() > i5) {
                Map map = (Map) treeMap.get(Integer.valueOf(kVar.c()));
                if (map == null) {
                    map = new HashMap();
                    treeMap.put(Integer.valueOf(kVar.c()), map);
                }
                map.put(kVar.b(), kVar);
            }
        }
        HashMap hashMap = new HashMap();
        for (Map map2 : treeMap.values()) {
            hashMap.putAll(map2);
            if (hashMap.size() >= i6) {
                break;
            }
        }
        return hashMap;
    }
}
