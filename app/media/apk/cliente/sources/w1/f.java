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
public abstract class f {

    /* renamed from: a  reason: collision with root package name */
    private final v1.l f8236a;

    /* renamed from: b  reason: collision with root package name */
    private final m f8237b;

    /* renamed from: c  reason: collision with root package name */
    private final List<e> f8238c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(v1.l lVar, m mVar) {
        this(lVar, mVar, new ArrayList());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(v1.l lVar, m mVar, List<e> list) {
        this.f8236a = lVar;
        this.f8237b = mVar;
        this.f8238c = list;
    }

    public static f c(s sVar, d dVar) {
        if (sVar.d()) {
            if (dVar == null || !dVar.c().isEmpty()) {
                if (dVar == null) {
                    return sVar.h() ? new c(sVar.getKey(), m.f8253c) : new o(sVar.getKey(), sVar.k(), m.f8253c);
                }
                t k5 = sVar.k();
                t tVar = new t();
                HashSet hashSet = new HashSet();
                for (r rVar : dVar.c()) {
                    if (!hashSet.contains(rVar)) {
                        if (k5.k(rVar) == null && rVar.p() > 1) {
                            rVar = rVar.r();
                        }
                        tVar.n(rVar, k5.k(rVar));
                        hashSet.add(rVar);
                    }
                }
                return new l(sVar.getKey(), tVar, d.b(hashSet), m.f8253c);
            }
            return null;
        }
        return null;
    }

    public abstract d a(s sVar, d dVar, f1.q qVar);

    public abstract void b(s sVar, i iVar);

    public t d(v1.i iVar) {
        t tVar = null;
        for (e eVar : this.f8238c) {
            d0 c5 = eVar.b().c(iVar.e(eVar.a()));
            if (c5 != null) {
                if (tVar == null) {
                    tVar = new t();
                }
                tVar.n(eVar.a(), c5);
            }
        }
        return tVar;
    }

    public abstract d e();

    public List<e> f() {
        return this.f8238c;
    }

    public v1.l g() {
        return this.f8236a;
    }

    public m h() {
        return this.f8237b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean i(f fVar) {
        return this.f8236a.equals(fVar.f8236a) && this.f8237b.equals(fVar.f8237b);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int j() {
        return (g().hashCode() * 31) + this.f8237b.hashCode();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String k() {
        return "key=" + this.f8236a + ", precondition=" + this.f8237b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Map<r, d0> l(f1.q qVar, s sVar) {
        HashMap hashMap = new HashMap(this.f8238c.size());
        for (e eVar : this.f8238c) {
            hashMap.put(eVar.a(), eVar.b().b(sVar.e(eVar.a()), qVar));
        }
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Map<r, d0> m(s sVar, List<d0> list) {
        HashMap hashMap = new HashMap(this.f8238c.size());
        z1.b.d(this.f8238c.size() == list.size(), "server transform count (%d) should match field transform count (%d)", Integer.valueOf(list.size()), Integer.valueOf(this.f8238c.size()));
        for (int i5 = 0; i5 < list.size(); i5++) {
            e eVar = this.f8238c.get(i5);
            hashMap.put(eVar.a(), eVar.b().a(sVar.e(eVar.a()), list.get(i5)));
        }
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void n(s sVar) {
        z1.b.d(sVar.getKey().equals(g()), "Can only apply a mutation to a document with the same key", new Object[0]);
    }
}
