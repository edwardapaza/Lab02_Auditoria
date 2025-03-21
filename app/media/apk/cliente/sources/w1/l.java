package w1;

import i2.d0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import v1.r;
import v1.s;
import v1.t;
/* loaded from: classes.dex */
public final class l extends f {

    /* renamed from: d  reason: collision with root package name */
    private final t f8251d;

    /* renamed from: e  reason: collision with root package name */
    private final d f8252e;

    public l(v1.l lVar, t tVar, d dVar, m mVar) {
        this(lVar, tVar, dVar, mVar, new ArrayList());
    }

    public l(v1.l lVar, t tVar, d dVar, m mVar, List<e> list) {
        super(lVar, mVar, list);
        this.f8251d = tVar;
        this.f8252e = dVar;
    }

    private List<r> o() {
        ArrayList arrayList = new ArrayList();
        for (e eVar : f()) {
            arrayList.add(eVar.a());
        }
        return arrayList;
    }

    private Map<r, d0> p() {
        HashMap hashMap = new HashMap();
        for (r rVar : this.f8252e.c()) {
            if (!rVar.n()) {
                hashMap.put(rVar, this.f8251d.k(rVar));
            }
        }
        return hashMap;
    }

    @Override // w1.f
    public d a(s sVar, d dVar, f1.q qVar) {
        n(sVar);
        if (h().e(sVar)) {
            Map<r, d0> l5 = l(qVar, sVar);
            Map<r, d0> p5 = p();
            t k5 = sVar.k();
            k5.o(p5);
            k5.o(l5);
            sVar.l(sVar.j(), sVar.k()).u();
            if (dVar == null) {
                return null;
            }
            HashSet hashSet = new HashSet(dVar.c());
            hashSet.addAll(this.f8252e.c());
            hashSet.addAll(o());
            return d.b(hashSet);
        }
        return dVar;
    }

    @Override // w1.f
    public void b(s sVar, i iVar) {
        n(sVar);
        if (!h().e(sVar)) {
            sVar.n(iVar.b());
            return;
        }
        Map<r, d0> m5 = m(sVar, iVar.a());
        t k5 = sVar.k();
        k5.o(p());
        k5.o(m5);
        sVar.l(iVar.b(), sVar.k()).t();
    }

    @Override // w1.f
    public d e() {
        return this.f8252e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || l.class != obj.getClass()) {
            return false;
        }
        l lVar = (l) obj;
        return i(lVar) && this.f8251d.equals(lVar.f8251d) && f().equals(lVar.f());
    }

    public int hashCode() {
        return (j() * 31) + this.f8251d.hashCode();
    }

    public t q() {
        return this.f8251d;
    }

    public String toString() {
        return "PatchMutation{" + k() + ", mask=" + this.f8252e + ", value=" + this.f8251d + "}";
    }
}
