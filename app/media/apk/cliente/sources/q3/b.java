package q3;

import i3.j1;
import i3.r0;
/* loaded from: classes.dex */
public abstract class b extends r0 {
    @Override // i3.r0
    public boolean b() {
        return g().b();
    }

    @Override // i3.r0
    public void c(j1 j1Var) {
        g().c(j1Var);
    }

    @Override // i3.r0
    public void d(r0.g gVar) {
        g().d(gVar);
    }

    @Override // i3.r0
    public void e() {
        g().e();
    }

    protected abstract r0 g();

    public String toString() {
        return z0.f.b(this).d("delegate", g()).toString();
    }
}
