package m4;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
/* loaded from: classes.dex */
public final class m1 extends l1 implements s0 {

    /* renamed from: d  reason: collision with root package name */
    private final Executor f6262d;

    public m1(Executor executor) {
        this.f6262d = executor;
        r4.c.a(j0());
    }

    private final void i0(v3.g gVar, RejectedExecutionException rejectedExecutionException) {
        y1.c(gVar, k1.a("The task was rejected", rejectedExecutionException));
    }

    private final ScheduledFuture<?> k0(ScheduledExecutorService scheduledExecutorService, Runnable runnable, v3.g gVar, long j5) {
        try {
            return scheduledExecutorService.schedule(runnable, j5, TimeUnit.MILLISECONDS);
        } catch (RejectedExecutionException e5) {
            i0(gVar, e5);
            return null;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        Executor j02 = j0();
        ExecutorService executorService = j02 instanceof ExecutorService ? (ExecutorService) j02 : null;
        if (executorService != null) {
            executorService.shutdown();
        }
    }

    public boolean equals(Object obj) {
        return (obj instanceof m1) && ((m1) obj).j0() == j0();
    }

    @Override // m4.g0
    public void f0(v3.g gVar, Runnable runnable) {
        try {
            Executor j02 = j0();
            c.a();
            j02.execute(runnable);
        } catch (RejectedExecutionException e5) {
            c.a();
            i0(gVar, e5);
            z0.b().f0(gVar, runnable);
        }
    }

    public int hashCode() {
        return System.identityHashCode(j0());
    }

    public Executor j0() {
        return this.f6262d;
    }

    @Override // m4.s0
    public b1 l(long j5, Runnable runnable, v3.g gVar) {
        Executor j02 = j0();
        ScheduledExecutorService scheduledExecutorService = j02 instanceof ScheduledExecutorService ? (ScheduledExecutorService) j02 : null;
        ScheduledFuture<?> k02 = scheduledExecutorService != null ? k0(scheduledExecutorService, runnable, gVar, j5) : null;
        return k02 != null ? new a1(k02) : o0.f6264m.l(j5, runnable, gVar);
    }

    @Override // m4.g0
    public String toString() {
        return j0().toString();
    }
}
