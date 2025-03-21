package m4;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
/* loaded from: classes.dex */
public final class n1 {
    public static final g0 a(Executor executor) {
        g0 g0Var;
        y0 y0Var = executor instanceof y0 ? (y0) executor : null;
        return (y0Var == null || (g0Var = y0Var.f6295a) == null) ? new m1(executor) : g0Var;
    }

    public static final l1 b(ExecutorService executorService) {
        return new m1(executorService);
    }
}
