package m4;

import java.util.concurrent.Executor;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class y0 implements Executor {

    /* renamed from: a  reason: collision with root package name */
    public final g0 f6295a;

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        g0 g0Var = this.f6295a;
        v3.h hVar = v3.h.f8175a;
        if (g0Var.g0(hVar)) {
            this.f6295a.f0(hVar, runnable);
        } else {
            runnable.run();
        }
    }

    public String toString() {
        return this.f6295a.toString();
    }
}
