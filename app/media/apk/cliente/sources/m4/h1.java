package m4;

import java.util.concurrent.locks.LockSupport;
import m4.g1;
/* loaded from: classes.dex */
public abstract class h1 extends f1 {
    protected abstract Thread r0();

    /* JADX INFO: Access modifiers changed from: protected */
    public void s0(long j5, g1.b bVar) {
        o0.f6264m.E0(j5, bVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void t0() {
        Thread r02 = r0();
        if (Thread.currentThread() != r02) {
            c.a();
            LockSupport.unpark(r02);
        }
    }
}
