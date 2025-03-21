package s1;

import java.util.ArrayList;
import s1.m;
import s1.o;
/* loaded from: classes.dex */
public class b1 {

    /* renamed from: a  reason: collision with root package name */
    private final a1 f7280a;

    /* renamed from: b  reason: collision with root package name */
    private final o.b f7281b;

    /* renamed from: c  reason: collision with root package name */
    private final com.google.firebase.firestore.o<x1> f7282c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f7283d = false;

    /* renamed from: e  reason: collision with root package name */
    private y0 f7284e = y0.UNKNOWN;

    /* renamed from: f  reason: collision with root package name */
    private x1 f7285f;

    public b1(a1 a1Var, o.b bVar, com.google.firebase.firestore.o<x1> oVar) {
        this.f7280a = a1Var;
        this.f7282c = oVar;
        this.f7281b = bVar;
    }

    private void f(x1 x1Var) {
        z1.b.d(!this.f7283d, "Trying to raise initial event for second time", new Object[0]);
        x1 c5 = x1.c(x1Var.h(), x1Var.e(), x1Var.f(), x1Var.k(), x1Var.b(), x1Var.i());
        this.f7283d = true;
        this.f7282c.a(c5, null);
    }

    private boolean g(x1 x1Var) {
        boolean z4 = true;
        if (x1Var.d().isEmpty()) {
            x1 x1Var2 = this.f7285f;
            z4 = (x1Var2 == null || x1Var2.j() == x1Var.j()) ? false : false;
            if (x1Var.a() || z4) {
                return this.f7281b.f7414b;
            }
            return false;
        }
        return true;
    }

    private boolean h(x1 x1Var, y0 y0Var) {
        z1.b.d(!this.f7283d, "Determining whether to raise first event but already had first event.", new Object[0]);
        if (x1Var.k() && b()) {
            y0 y0Var2 = y0.OFFLINE;
            boolean z4 = !y0Var.equals(y0Var2);
            if (!this.f7281b.f7415c || !z4) {
                return !x1Var.e().isEmpty() || x1Var.i() || y0Var.equals(y0Var2);
            }
            z1.b.d(x1Var.k(), "Waiting for sync, but snapshot is not from cache", new Object[0]);
            return false;
        }
        return true;
    }

    public a1 a() {
        return this.f7280a;
    }

    public boolean b() {
        o.b bVar = this.f7281b;
        if (bVar != null) {
            return !bVar.f7416d.equals(com.google.firebase.firestore.f0.CACHE);
        }
        return true;
    }

    public void c(com.google.firebase.firestore.z zVar) {
        this.f7282c.a(null, zVar);
    }

    public boolean d(y0 y0Var) {
        this.f7284e = y0Var;
        x1 x1Var = this.f7285f;
        if (x1Var == null || this.f7283d || !h(x1Var, y0Var)) {
            return false;
        }
        f(this.f7285f);
        return true;
    }

    public boolean e(x1 x1Var) {
        boolean z4 = false;
        z1.b.d(!x1Var.d().isEmpty() || x1Var.a(), "We got a new snapshot with no changes?", new Object[0]);
        if (!this.f7281b.f7413a) {
            ArrayList arrayList = new ArrayList();
            for (m mVar : x1Var.d()) {
                if (mVar.c() != m.a.METADATA) {
                    arrayList.add(mVar);
                }
            }
            x1Var = new x1(x1Var.h(), x1Var.e(), x1Var.g(), arrayList, x1Var.k(), x1Var.f(), x1Var.a(), true, x1Var.i());
        }
        if (this.f7283d) {
            if (g(x1Var)) {
                this.f7282c.a(x1Var, null);
                z4 = true;
            }
        } else if (h(x1Var, this.f7284e)) {
            f(x1Var);
            z4 = true;
        }
        this.f7285f = x1Var;
        return z4;
    }
}
