package w1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import u1.d1;
import v1.s;
import v1.w;
/* loaded from: classes.dex */
public final class g {

    /* renamed from: a  reason: collision with root package name */
    private final int f8239a;

    /* renamed from: b  reason: collision with root package name */
    private final f1.q f8240b;

    /* renamed from: c  reason: collision with root package name */
    private final List<f> f8241c;

    /* renamed from: d  reason: collision with root package name */
    private final List<f> f8242d;

    public g(int i5, f1.q qVar, List<f> list, List<f> list2) {
        z1.b.d(!list2.isEmpty(), "Cannot create an empty mutation batch", new Object[0]);
        this.f8239a = i5;
        this.f8240b = qVar;
        this.f8241c = list;
        this.f8242d = list2;
    }

    public Map<v1.l, f> a(Map<v1.l, d1> map, Set<v1.l> set) {
        HashMap hashMap = new HashMap();
        for (v1.l lVar : f()) {
            s sVar = (s) map.get(lVar).a();
            d b5 = b(sVar, map.get(lVar).b());
            if (set.contains(lVar)) {
                b5 = null;
            }
            f c5 = f.c(sVar, b5);
            if (c5 != null) {
                hashMap.put(lVar, c5);
            }
            if (!sVar.o()) {
                sVar.m(w.f8154b);
            }
        }
        return hashMap;
    }

    public d b(s sVar, d dVar) {
        for (int i5 = 0; i5 < this.f8241c.size(); i5++) {
            f fVar = this.f8241c.get(i5);
            if (fVar.g().equals(sVar.getKey())) {
                dVar = fVar.a(sVar, dVar, this.f8240b);
            }
        }
        for (int i6 = 0; i6 < this.f8242d.size(); i6++) {
            f fVar2 = this.f8242d.get(i6);
            if (fVar2.g().equals(sVar.getKey())) {
                dVar = fVar2.a(sVar, dVar, this.f8240b);
            }
        }
        return dVar;
    }

    public void c(s sVar, h hVar) {
        int size = this.f8242d.size();
        List<i> e5 = hVar.e();
        z1.b.d(e5.size() == size, "Mismatch between mutations length (%d) and results length (%d)", Integer.valueOf(size), Integer.valueOf(e5.size()));
        for (int i5 = 0; i5 < size; i5++) {
            f fVar = this.f8242d.get(i5);
            if (fVar.g().equals(sVar.getKey())) {
                fVar.b(sVar, e5.get(i5));
            }
        }
    }

    public List<f> d() {
        return this.f8241c;
    }

    public int e() {
        return this.f8239a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || g.class != obj.getClass()) {
            return false;
        }
        g gVar = (g) obj;
        return this.f8239a == gVar.f8239a && this.f8240b.equals(gVar.f8240b) && this.f8241c.equals(gVar.f8241c) && this.f8242d.equals(gVar.f8242d);
    }

    public Set<v1.l> f() {
        HashSet hashSet = new HashSet();
        for (f fVar : this.f8242d) {
            hashSet.add(fVar.g());
        }
        return hashSet;
    }

    public f1.q g() {
        return this.f8240b;
    }

    public List<f> h() {
        return this.f8242d;
    }

    public int hashCode() {
        return (((((this.f8239a * 31) + this.f8240b.hashCode()) * 31) + this.f8241c.hashCode()) * 31) + this.f8242d.hashCode();
    }

    public String toString() {
        return "MutationBatch(batchId=" + this.f8239a + ", localWriteTime=" + this.f8240b + ", baseMutations=" + this.f8241c + ", mutations=" + this.f8242d + ')';
    }
}
