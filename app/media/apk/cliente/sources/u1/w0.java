package u1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class w0 implements b1 {

    /* renamed from: a  reason: collision with root package name */
    private final List<w1.g> f8041a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    private m1.e<e> f8042b = new m1.e<>(Collections.emptyList(), e.f7776c);

    /* renamed from: c  reason: collision with root package name */
    private int f8043c = 1;

    /* renamed from: d  reason: collision with root package name */
    private com.google.protobuf.i f8044d = y1.b1.f8359v;

    /* renamed from: e  reason: collision with root package name */
    private final y0 f8045e;

    /* renamed from: f  reason: collision with root package name */
    private final t0 f8046f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w0(y0 y0Var, q1.j jVar) {
        this.f8045e = y0Var;
        this.f8046f = y0Var.c(jVar);
    }

    private int n(int i5) {
        if (this.f8041a.isEmpty()) {
            return 0;
        }
        return i5 - this.f8041a.get(0).e();
    }

    private int o(int i5, String str) {
        int n5 = n(i5);
        z1.b.d(n5 >= 0 && n5 < this.f8041a.size(), "Batches must exist to be %s", str);
        return n5;
    }

    private List<w1.g> q(m1.e<Integer> eVar) {
        ArrayList arrayList = new ArrayList();
        Iterator<Integer> it = eVar.iterator();
        while (it.hasNext()) {
            w1.g e5 = e(it.next().intValue());
            if (e5 != null) {
                arrayList.add(e5);
            }
        }
        return arrayList;
    }

    @Override // u1.b1
    public void a() {
        if (this.f8041a.isEmpty()) {
            z1.b.d(this.f8042b.isEmpty(), "Document leak -- detected dangling mutation references when queue is empty.", new Object[0]);
        }
    }

    @Override // u1.b1
    public w1.g b(int i5) {
        int n5 = n(i5 + 1);
        if (n5 < 0) {
            n5 = 0;
        }
        if (this.f8041a.size() > n5) {
            return this.f8041a.get(n5);
        }
        return null;
    }

    @Override // u1.b1
    public int c() {
        if (this.f8041a.isEmpty()) {
            return -1;
        }
        return this.f8043c - 1;
    }

    @Override // u1.b1
    public List<w1.g> d(Iterable<v1.l> iterable) {
        m1.e<Integer> eVar = new m1.e<>(Collections.emptyList(), z1.h0.g());
        for (v1.l lVar : iterable) {
            Iterator<e> k5 = this.f8042b.k(new e(lVar, 0));
            while (k5.hasNext()) {
                e next = k5.next();
                if (!lVar.equals(next.d())) {
                    break;
                }
                eVar = eVar.i(Integer.valueOf(next.c()));
            }
        }
        return q(eVar);
    }

    @Override // u1.b1
    public w1.g e(int i5) {
        int n5 = n(i5);
        if (n5 < 0 || n5 >= this.f8041a.size()) {
            return null;
        }
        w1.g gVar = this.f8041a.get(n5);
        z1.b.d(gVar.e() == i5, "If found batch must match", new Object[0]);
        return gVar;
    }

    @Override // u1.b1
    public void f(w1.g gVar) {
        z1.b.d(o(gVar.e(), "removed") == 0, "Can only remove the first entry of the mutation queue", new Object[0]);
        this.f8041a.remove(0);
        m1.e<e> eVar = this.f8042b;
        for (w1.f fVar : gVar.h()) {
            v1.l g5 = fVar.g();
            this.f8045e.f().m(g5);
            eVar = eVar.l(new e(g5, gVar.e()));
        }
        this.f8042b = eVar;
    }

    @Override // u1.b1
    public com.google.protobuf.i g() {
        return this.f8044d;
    }

    @Override // u1.b1
    public void h(w1.g gVar, com.google.protobuf.i iVar) {
        int e5 = gVar.e();
        int o5 = o(e5, "acknowledged");
        z1.b.d(o5 == 0, "Can only acknowledge the first batch in the mutation queue", new Object[0]);
        w1.g gVar2 = this.f8041a.get(o5);
        z1.b.d(e5 == gVar2.e(), "Queue ordering failure: expected batch %d, got batch %d", Integer.valueOf(e5), Integer.valueOf(gVar2.e()));
        this.f8044d = (com.google.protobuf.i) z1.y.b(iVar);
    }

    @Override // u1.b1
    public void i(com.google.protobuf.i iVar) {
        this.f8044d = (com.google.protobuf.i) z1.y.b(iVar);
    }

    @Override // u1.b1
    public w1.g j(f1.q qVar, List<w1.f> list, List<w1.f> list2) {
        z1.b.d(!list2.isEmpty(), "Mutation batches should not be empty", new Object[0]);
        int i5 = this.f8043c;
        this.f8043c = i5 + 1;
        int size = this.f8041a.size();
        if (size > 0) {
            z1.b.d(this.f8041a.get(size - 1).e() < i5, "Mutation batchIds must be monotonically increasing order", new Object[0]);
        }
        w1.g gVar = new w1.g(i5, qVar, list, list2);
        this.f8041a.add(gVar);
        for (w1.f fVar : list2) {
            this.f8042b = this.f8042b.i(new e(fVar.g(), i5));
            this.f8046f.j(fVar.g().o());
        }
        return gVar;
    }

    @Override // u1.b1
    public List<w1.g> k() {
        return Collections.unmodifiableList(this.f8041a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean l(v1.l lVar) {
        Iterator<e> k5 = this.f8042b.k(new e(lVar, 0));
        if (k5.hasNext()) {
            return k5.next().d().equals(lVar);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long m(o oVar) {
        long j5 = 0;
        for (w1.g gVar : this.f8041a) {
            j5 += oVar.o(gVar).a();
        }
        return j5;
    }

    public boolean p() {
        return this.f8041a.isEmpty();
    }

    @Override // u1.b1
    public void start() {
        if (p()) {
            this.f8043c = 1;
        }
    }
}
