package u1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import u1.l;
import v1.q;
/* loaded from: classes.dex */
class t0 implements l {

    /* renamed from: a  reason: collision with root package name */
    private final a f8000a = new a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private final HashMap<String, HashSet<v1.u>> f8001a = new HashMap<>();

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean a(v1.u uVar) {
            z1.b.d(uVar.p() % 2 == 1, "Expected a collection path.", new Object[0]);
            String k5 = uVar.k();
            v1.u r5 = uVar.r();
            HashSet<v1.u> hashSet = this.f8001a.get(k5);
            if (hashSet == null) {
                hashSet = new HashSet<>();
                this.f8001a.put(k5, hashSet);
            }
            return hashSet.add(r5);
        }

        List<v1.u> b(String str) {
            HashSet<v1.u> hashSet = this.f8001a.get(str);
            return hashSet != null ? new ArrayList(hashSet) : Collections.emptyList();
        }
    }

    @Override // u1.l
    public void a(m1.c<v1.l, v1.i> cVar) {
    }

    @Override // u1.l
    public l.a b(s1.f1 f1Var) {
        return l.a.NONE;
    }

    @Override // u1.l
    public List<v1.u> c(String str) {
        return this.f8000a.b(str);
    }

    @Override // u1.l
    public void d(String str, q.a aVar) {
    }

    @Override // u1.l
    public q.a e(s1.f1 f1Var) {
        return q.a.f8128a;
    }

    @Override // u1.l
    public void f(v1.q qVar) {
    }

    @Override // u1.l
    public q.a g(String str) {
        return q.a.f8128a;
    }

    @Override // u1.l
    public void h(v1.q qVar) {
    }

    @Override // u1.l
    public List<v1.l> i(s1.f1 f1Var) {
        return null;
    }

    @Override // u1.l
    public void j(v1.u uVar) {
        this.f8000a.a(uVar);
    }

    @Override // u1.l
    public Collection<v1.q> k() {
        return Collections.emptyList();
    }

    @Override // u1.l
    public void l(s1.f1 f1Var) {
    }

    @Override // u1.l
    public String m() {
        return null;
    }

    @Override // u1.l
    public void start() {
    }
}
