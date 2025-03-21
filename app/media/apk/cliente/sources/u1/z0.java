package u1;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import v1.q;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class z0 implements l1 {

    /* renamed from: a  reason: collision with root package name */
    private m1.c<v1.l, v1.i> f8066a = v1.j.a();

    /* renamed from: b  reason: collision with root package name */
    private l f8067b;

    /* loaded from: classes.dex */
    private class b implements Iterable<v1.i> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public class a implements Iterator<v1.i> {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ Iterator f8069a;

            a(Iterator it) {
                this.f8069a = it;
            }

            @Override // java.util.Iterator
            /* renamed from: b */
            public v1.i next() {
                return (v1.i) ((Map.Entry) this.f8069a.next()).getValue();
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.f8069a.hasNext();
            }
        }

        private b() {
        }

        @Override // java.lang.Iterable
        public Iterator<v1.i> iterator() {
            return new a(z0.this.f8066a.iterator());
        }
    }

    @Override // u1.l1
    public void a(v1.s sVar, v1.w wVar) {
        z1.b.d(this.f8067b != null, "setIndexManager() not called", new Object[0]);
        z1.b.d(!wVar.equals(v1.w.f8154b), "Cannot add document to the RemoteDocumentCache with a read time of zero", new Object[0]);
        this.f8066a = this.f8066a.m(sVar.getKey(), sVar.a().v(wVar));
        this.f8067b.j(sVar.getKey().o());
    }

    @Override // u1.l1
    public Map<v1.l, v1.s> b(s1.a1 a1Var, q.a aVar, Set<v1.l> set, f1 f1Var) {
        HashMap hashMap = new HashMap();
        Iterator<Map.Entry<v1.l, v1.i>> n5 = this.f8066a.n(v1.l.k(a1Var.n().a("")));
        while (n5.hasNext()) {
            Map.Entry<v1.l, v1.i> next = n5.next();
            v1.i value = next.getValue();
            v1.l key = next.getKey();
            if (!a1Var.n().o(key.q())) {
                break;
            } else if (key.q().p() <= a1Var.n().p() + 1 && q.a.h(value).compareTo(aVar) > 0 && (set.contains(value.getKey()) || a1Var.u(value))) {
                hashMap.put(value.getKey(), value.a());
            }
        }
        return hashMap;
    }

    @Override // u1.l1
    public Map<v1.l, v1.s> c(String str, q.a aVar, int i5) {
        throw new UnsupportedOperationException("getAll(String, IndexOffset, int) is not supported.");
    }

    @Override // u1.l1
    public v1.s d(v1.l lVar) {
        v1.i h5 = this.f8066a.h(lVar);
        return h5 != null ? h5.a() : v1.s.q(lVar);
    }

    @Override // u1.l1
    public void e(l lVar) {
        this.f8067b = lVar;
    }

    @Override // u1.l1
    public Map<v1.l, v1.s> f(Iterable<v1.l> iterable) {
        HashMap hashMap = new HashMap();
        for (v1.l lVar : iterable) {
            hashMap.put(lVar, d(lVar));
        }
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long h(o oVar) {
        Iterator<v1.i> it = new b().iterator();
        long j5 = 0;
        while (it.hasNext()) {
            j5 += oVar.m(it.next()).a();
        }
        return j5;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Iterable<v1.i> i() {
        return new b();
    }

    @Override // u1.l1
    public void removeAll(Collection<v1.l> collection) {
        z1.b.d(this.f8067b != null, "setIndexManager() not called", new Object[0]);
        m1.c<v1.l, v1.i> a5 = v1.j.a();
        for (v1.l lVar : collection) {
            this.f8066a = this.f8066a.o(lVar);
            a5 = a5.m(lVar, v1.s.r(lVar, v1.w.f8154b));
        }
        this.f8067b.a(a5);
    }
}
