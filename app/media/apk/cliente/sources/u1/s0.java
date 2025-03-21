package u1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s0 implements j1 {

    /* renamed from: a  reason: collision with root package name */
    private k1 f7987a;

    /* renamed from: b  reason: collision with root package name */
    private final y0 f7988b;

    /* renamed from: c  reason: collision with root package name */
    private Set<v1.l> f7989c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s0(y0 y0Var) {
        this.f7988b = y0Var;
    }

    private boolean a(v1.l lVar) {
        if (this.f7988b.h().k(lVar) || b(lVar)) {
            return true;
        }
        k1 k1Var = this.f7987a;
        return k1Var != null && k1Var.c(lVar);
    }

    private boolean b(v1.l lVar) {
        for (w0 w0Var : this.f7988b.q()) {
            if (w0Var.l(lVar)) {
                return true;
            }
        }
        return false;
    }

    @Override // u1.j1
    public void c(k1 k1Var) {
        this.f7987a = k1Var;
    }

    @Override // u1.j1
    public void e(v1.l lVar) {
        this.f7989c.add(lVar);
    }

    @Override // u1.j1
    public void f() {
        z0 g5 = this.f7988b.g();
        ArrayList arrayList = new ArrayList();
        for (v1.l lVar : this.f7989c) {
            if (!a(lVar)) {
                arrayList.add(lVar);
            }
        }
        g5.removeAll(arrayList);
        this.f7989c = null;
    }

    @Override // u1.j1
    public void i() {
        this.f7989c = new HashSet();
    }

    @Override // u1.j1
    public void j(i4 i4Var) {
        a1 h5 = this.f7988b.h();
        Iterator<v1.l> it = h5.c(i4Var.h()).iterator();
        while (it.hasNext()) {
            this.f7989c.add(it.next());
        }
        h5.q(i4Var);
    }

    @Override // u1.j1
    public void m(v1.l lVar) {
        this.f7989c.add(lVar);
    }

    @Override // u1.j1
    public long n() {
        return -1L;
    }

    @Override // u1.j1
    public void o(v1.l lVar) {
        this.f7989c.remove(lVar);
    }

    @Override // u1.j1
    public void p(v1.l lVar) {
        if (a(lVar)) {
            this.f7989c.remove(lVar);
        } else {
            this.f7989c.add(lVar);
        }
    }
}
