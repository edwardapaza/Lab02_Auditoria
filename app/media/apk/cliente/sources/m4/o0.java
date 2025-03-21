package m4;

import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;
import m4.g1;
/* loaded from: classes.dex */
public final class o0 extends g1 implements Runnable {
    private static volatile Thread _thread;
    private static volatile int debugStatus;

    /* renamed from: m  reason: collision with root package name */
    public static final o0 f6264m;

    /* renamed from: n  reason: collision with root package name */
    private static final long f6265n;

    static {
        Long l5;
        o0 o0Var = new o0();
        f6264m = o0Var;
        f1.n0(o0Var, false, 1, null);
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        try {
            l5 = Long.getLong("kotlinx.coroutines.DefaultExecutor.keepAlive", 1000L);
        } catch (SecurityException unused) {
            l5 = 1000L;
        }
        f6265n = timeUnit.toNanos(l5.longValue());
    }

    private o0() {
    }

    private final synchronized void J0() {
        if (M0()) {
            debugStatus = 3;
            D0();
            e4.k.c(this, "null cannot be cast to non-null type java.lang.Object");
            notifyAll();
        }
    }

    private final synchronized Thread K0() {
        Thread thread;
        thread = _thread;
        if (thread == null) {
            thread = new Thread(this, "kotlinx.coroutines.DefaultExecutor");
            _thread = thread;
            thread.setDaemon(true);
            thread.start();
        }
        return thread;
    }

    private final boolean L0() {
        return debugStatus == 4;
    }

    private final boolean M0() {
        int i5 = debugStatus;
        return i5 == 2 || i5 == 3;
    }

    private final synchronized boolean N0() {
        if (M0()) {
            return false;
        }
        debugStatus = 1;
        e4.k.c(this, "null cannot be cast to non-null type java.lang.Object");
        notifyAll();
        return true;
    }

    private final void O0() {
        throw new RejectedExecutionException("DefaultExecutor was shut down. This error indicates that Dispatchers.shutdown() was invoked prior to completion of exiting coroutines, leaving coroutines in incomplete state. Please refer to Dispatchers.shutdown documentation for more details");
    }

    @Override // m4.g1, m4.s0
    public b1 l(long j5, Runnable runnable, v3.g gVar) {
        return G0(j5, runnable);
    }

    @Override // m4.h1
    protected Thread r0() {
        Thread thread = _thread;
        return thread == null ? K0() : thread;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean A0;
        q2.f6272a.c(this);
        c.a();
        try {
            if (!N0()) {
                if (A0) {
                    return;
                }
                return;
            }
            long j5 = Long.MAX_VALUE;
            while (true) {
                Thread.interrupted();
                long B0 = B0();
                if (B0 == Long.MAX_VALUE) {
                    c.a();
                    long nanoTime = System.nanoTime();
                    if (j5 == Long.MAX_VALUE) {
                        j5 = f6265n + nanoTime;
                    }
                    long j6 = j5 - nanoTime;
                    if (j6 <= 0) {
                        _thread = null;
                        J0();
                        c.a();
                        if (A0()) {
                            return;
                        }
                        r0();
                        return;
                    }
                    B0 = h4.l.d(B0, j6);
                } else {
                    j5 = Long.MAX_VALUE;
                }
                if (B0 > 0) {
                    if (M0()) {
                        _thread = null;
                        J0();
                        c.a();
                        if (A0()) {
                            return;
                        }
                        r0();
                        return;
                    }
                    c.a();
                    LockSupport.parkNanos(this, B0);
                }
            }
        } finally {
            _thread = null;
            J0();
            c.a();
            if (!A0()) {
                r0();
            }
        }
    }

    @Override // m4.h1
    protected void s0(long j5, g1.b bVar) {
        O0();
    }

    @Override // m4.g1, m4.f1
    public void shutdown() {
        debugStatus = 4;
        super.shutdown();
    }

    @Override // m4.g1
    public void x0(Runnable runnable) {
        if (L0()) {
            O0();
        }
        super.x0(runnable);
    }
}
