package io.grpc.internal;

import java.util.logging.Level;
import java.util.logging.Logger;
/* loaded from: classes.dex */
public final class f1 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    private static final Logger f4754b = Logger.getLogger(f1.class.getName());

    /* renamed from: a  reason: collision with root package name */
    private final Runnable f4755a;

    public f1(Runnable runnable) {
        this.f4755a = (Runnable) z0.k.o(runnable, "task");
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.f4755a.run();
        } catch (Throwable th) {
            Logger logger = f4754b;
            Level level = Level.SEVERE;
            logger.log(level, "Exception while executing runnable " + this.f4755a, th);
            z0.p.f(th);
            throw new AssertionError(th);
        }
    }

    public String toString() {
        return "LogExceptionRunnable(" + this.f4755a + ")";
    }
}
