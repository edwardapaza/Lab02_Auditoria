package u1;

import android.util.SparseArray;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import u1.o0;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v0 implements j1, k0 {

    /* renamed from: a  reason: collision with root package name */
    private final y0 f8028a;

    /* renamed from: b  reason: collision with root package name */
    private final o f8029b;

    /* renamed from: d  reason: collision with root package name */
    private k1 f8031d;

    /* renamed from: e  reason: collision with root package name */
    private final o0 f8032e;

    /* renamed from: f  reason: collision with root package name */
    private final s1.u0 f8033f;

    /* renamed from: c  reason: collision with root package name */
    private final Map<v1.l, Long> f8030c = new HashMap();

    /* renamed from: g  reason: collision with root package name */
    private long f8034g = -1;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v0(y0 y0Var, o0.b bVar, o oVar) {
        this.f8028a = y0Var;
        this.f8029b = oVar;
        this.f8033f = new s1.u0(y0Var.h().n());
        this.f8032e = new o0(this, bVar);
    }

    private boolean r(v1.l lVar, long j5) {
        if (t(lVar) || this.f8031d.c(lVar) || this.f8028a.h().k(lVar)) {
            return true;
        }
        Long l5 = this.f8030c.get(lVar);
        return l5 != null && l5.longValue() > j5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void s(long[] jArr, Long l5) {
        jArr[0] = jArr[0] + 1;
    }

    private boolean t(v1.l lVar) {
        for (w0 w0Var : this.f8028a.q()) {
            if (w0Var.l(lVar)) {
                return true;
            }
        }
        return false;
    }

    @Override // u1.k0
    public long a() {
        long o5 = this.f8028a.h().o();
        final long[] jArr = new long[1];
        h(new z1.n() { // from class: u1.u0
            @Override // z1.n
            public final void accept(Object obj) {
                v0.s(jArr, (Long) obj);
            }
        });
        return o5 + jArr[0];
    }

    @Override // u1.k0
    public int b(long j5, SparseArray<?> sparseArray) {
        return this.f8028a.h().p(j5, sparseArray);
    }

    @Override // u1.j1
    public void c(k1 k1Var) {
        this.f8031d = k1Var;
    }

    @Override // u1.k0
    public int d(long j5) {
        z0 g5 = this.f8028a.g();
        ArrayList arrayList = new ArrayList();
        for (v1.i iVar : g5.i()) {
            v1.l key = iVar.getKey();
            if (!r(key, j5)) {
                arrayList.add(key);
                this.f8030c.remove(key);
            }
        }
        g5.removeAll(arrayList);
        return arrayList.size();
    }

    @Override // u1.j1
    public void e(v1.l lVar) {
        this.f8030c.put(lVar, Long.valueOf(n()));
    }

    @Override // u1.j1
    public void f() {
        z1.b.d(this.f8034g != -1, "Committing a transaction without having started one", new Object[0]);
        this.f8034g = -1L;
    }

    @Override // u1.k0
    public o0 g() {
        return this.f8032e;
    }

    @Override // u1.k0
    public void h(z1.n<Long> nVar) {
        for (Map.Entry<v1.l, Long> entry : this.f8030c.entrySet()) {
            if (!r(entry.getKey(), entry.getValue().longValue())) {
                nVar.accept(entry.getValue());
            }
        }
    }

    @Override // u1.j1
    public void i() {
        z1.b.d(this.f8034g == -1, "Starting a transaction without committing the previous one", new Object[0]);
        this.f8034g = this.f8033f.a();
    }

    @Override // u1.j1
    public void j(i4 i4Var) {
        this.f8028a.h().h(i4Var.l(n()));
    }

    @Override // u1.k0
    public long k() {
        long m5 = this.f8028a.h().m(this.f8029b) + 0 + this.f8028a.g().h(this.f8029b);
        for (w0 w0Var : this.f8028a.q()) {
            m5 += w0Var.m(this.f8029b);
        }
        return m5;
    }

    @Override // u1.k0
    public void l(z1.n<i4> nVar) {
        this.f8028a.h().l(nVar);
    }

    @Override // u1.j1
    public void m(v1.l lVar) {
        this.f8030c.put(lVar, Long.valueOf(n()));
    }

    @Override // u1.j1
    public long n() {
        z1.b.d(this.f8034g != -1, "Attempting to get a sequence number outside of a transaction", new Object[0]);
        return this.f8034g;
    }

    @Override // u1.j1
    public void o(v1.l lVar) {
        this.f8030c.put(lVar, Long.valueOf(n()));
    }

    @Override // u1.j1
    public void p(v1.l lVar) {
        this.f8030c.put(lVar, Long.valueOf(n()));
    }
}
