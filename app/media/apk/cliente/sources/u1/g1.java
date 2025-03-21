package u1;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import s1.a1;
import u1.l;
import v1.q;
/* loaded from: classes.dex */
public class g1 {

    /* renamed from: a  reason: collision with root package name */
    private n f7824a;

    /* renamed from: b  reason: collision with root package name */
    private l f7825b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f7826c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f7827d = false;

    /* renamed from: e  reason: collision with root package name */
    private int f7828e = 100;

    /* renamed from: f  reason: collision with root package name */
    private double f7829f = 2.0d;

    private m1.c<v1.l, v1.i> a(Iterable<v1.i> iterable, s1.a1 a1Var, q.a aVar) {
        m1.c<v1.l, v1.i> h5 = this.f7824a.h(a1Var, aVar);
        for (v1.i iVar : iterable) {
            h5 = h5.m(iVar.getKey(), iVar);
        }
        return h5;
    }

    private m1.e<v1.i> b(s1.a1 a1Var, m1.c<v1.l, v1.i> cVar) {
        m1.e<v1.i> eVar = new m1.e<>(Collections.emptyList(), a1Var.c());
        Iterator<Map.Entry<v1.l, v1.i>> it = cVar.iterator();
        while (it.hasNext()) {
            v1.i value = it.next().getValue();
            if (a1Var.u(value)) {
                eVar = eVar.i(value);
            }
        }
        return eVar;
    }

    private void c(s1.a1 a1Var, f1 f1Var, int i5) {
        if (f1Var.a() < this.f7828e) {
            z1.w.a("QueryEngine", "SDK will not create cache indexes for query: %s, since it only creates cache indexes for collection contains more than or equal to %s documents.", a1Var.toString(), Integer.valueOf(this.f7828e));
            return;
        }
        z1.w.a("QueryEngine", "Query: %s, scans %s local documents and returns %s documents as results.", a1Var.toString(), Integer.valueOf(f1Var.a()), Integer.valueOf(i5));
        if (f1Var.a() > this.f7829f * i5) {
            this.f7825b.l(a1Var.D());
            z1.w.a("QueryEngine", "The SDK decides to create cache indexes for query: %s, as using cache indexes may help improve performance.", a1Var.toString());
        }
    }

    private m1.c<v1.l, v1.i> d(s1.a1 a1Var, f1 f1Var) {
        if (z1.w.c()) {
            z1.w.a("QueryEngine", "Using full collection scan to execute query: %s", a1Var.toString());
        }
        return this.f7824a.i(a1Var, q.a.f8128a, f1Var);
    }

    private boolean g(s1.a1 a1Var, int i5, m1.e<v1.i> eVar, v1.w wVar) {
        if (a1Var.p()) {
            if (i5 != eVar.size()) {
                return true;
            }
            v1.i g5 = a1Var.l() == a1.a.LIMIT_TO_FIRST ? eVar.g() : eVar.h();
            if (g5 == null) {
                return false;
            }
            return g5.f() || g5.j().compareTo(wVar) > 0;
        }
        return false;
    }

    private m1.c<v1.l, v1.i> h(s1.a1 a1Var) {
        if (a1Var.v()) {
            return null;
        }
        s1.f1 D = a1Var.D();
        l.a b5 = this.f7825b.b(D);
        if (b5.equals(l.a.NONE)) {
            return null;
        }
        if (!a1Var.p() || !b5.equals(l.a.PARTIAL)) {
            List<v1.l> i5 = this.f7825b.i(D);
            z1.b.d(i5 != null, "index manager must return results for partial and full indexes.", new Object[0]);
            m1.c<v1.l, v1.i> d5 = this.f7824a.d(i5);
            q.a e5 = this.f7825b.e(D);
            m1.e<v1.i> b6 = b(a1Var, d5);
            if (!g(a1Var, i5.size(), b6, e5.n())) {
                return a(b6, a1Var, e5);
            }
        }
        return h(a1Var.s(-1L));
    }

    private m1.c<v1.l, v1.i> i(s1.a1 a1Var, m1.e<v1.l> eVar, v1.w wVar) {
        if (a1Var.v() || wVar.equals(v1.w.f8154b)) {
            return null;
        }
        m1.e<v1.i> b5 = b(a1Var, this.f7824a.d(eVar));
        if (g(a1Var, eVar.size(), b5, wVar)) {
            return null;
        }
        if (z1.w.c()) {
            z1.w.a("QueryEngine", "Re-using previous result from %s to execute query: %s", wVar.toString(), a1Var.toString());
        }
        return a(b5, a1Var, q.a.e(wVar, -1));
    }

    public m1.c<v1.l, v1.i> e(s1.a1 a1Var, v1.w wVar, m1.e<v1.l> eVar) {
        z1.b.d(this.f7826c, "initialize() not called", new Object[0]);
        m1.c<v1.l, v1.i> h5 = h(a1Var);
        if (h5 != null) {
            return h5;
        }
        m1.c<v1.l, v1.i> i5 = i(a1Var, eVar, wVar);
        if (i5 != null) {
            return i5;
        }
        f1 f1Var = new f1();
        m1.c<v1.l, v1.i> d5 = d(a1Var, f1Var);
        if (d5 != null && this.f7827d) {
            c(a1Var, f1Var, d5.size());
        }
        return d5;
    }

    public void f(n nVar, l lVar) {
        this.f7824a = nVar;
        this.f7825b = lVar;
        this.f7826c = true;
    }
}
