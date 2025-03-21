package q3;

import i3.n1;
import i3.r0;
import java.util.concurrent.ScheduledExecutorService;
/* loaded from: classes.dex */
public abstract class c extends r0.d {
    @Override // i3.r0.d
    public r0.h a(r0.b bVar) {
        return g().a(bVar);
    }

    @Override // i3.r0.d
    public i3.f b() {
        return g().b();
    }

    @Override // i3.r0.d
    public ScheduledExecutorService c() {
        return g().c();
    }

    @Override // i3.r0.d
    public n1 d() {
        return g().d();
    }

    @Override // i3.r0.d
    public void e() {
        g().e();
    }

    protected abstract r0.d g();

    public String toString() {
        return z0.f.b(this).d("delegate", g()).toString();
    }
}
