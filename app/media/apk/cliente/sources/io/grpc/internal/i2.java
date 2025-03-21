package io.grpc.internal;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.logging.Level;
import java.util.logging.Logger;
/* loaded from: classes.dex */
public final class i2 implements Executor, Runnable {

    /* renamed from: d  reason: collision with root package name */
    private static final Logger f4922d = Logger.getLogger(i2.class.getName());

    /* renamed from: e  reason: collision with root package name */
    private static final b f4923e = c();

    /* renamed from: a  reason: collision with root package name */
    private Executor f4924a;

    /* renamed from: b  reason: collision with root package name */
    private final Queue<Runnable> f4925b = new ConcurrentLinkedQueue();

    /* renamed from: c  reason: collision with root package name */
    private volatile int f4926c = 0;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static abstract class b {
        private b() {
        }

        public abstract boolean a(i2 i2Var, int i5, int i6);

        public abstract void b(i2 i2Var, int i5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class c extends b {

        /* renamed from: a  reason: collision with root package name */
        private final AtomicIntegerFieldUpdater<i2> f4927a;

        private c(AtomicIntegerFieldUpdater<i2> atomicIntegerFieldUpdater) {
            super();
            this.f4927a = atomicIntegerFieldUpdater;
        }

        @Override // io.grpc.internal.i2.b
        public boolean a(i2 i2Var, int i5, int i6) {
            return this.f4927a.compareAndSet(i2Var, i5, i6);
        }

        @Override // io.grpc.internal.i2.b
        public void b(i2 i2Var, int i5) {
            this.f4927a.set(i2Var, i5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class d extends b {
        private d() {
            super();
        }

        @Override // io.grpc.internal.i2.b
        public boolean a(i2 i2Var, int i5, int i6) {
            synchronized (i2Var) {
                if (i2Var.f4926c == i5) {
                    i2Var.f4926c = i6;
                    return true;
                }
                return false;
            }
        }

        @Override // io.grpc.internal.i2.b
        public void b(i2 i2Var, int i5) {
            synchronized (i2Var) {
                i2Var.f4926c = i5;
            }
        }
    }

    public i2(Executor executor) {
        z0.k.o(executor, "'executor' must not be null.");
        this.f4924a = executor;
    }

    private static b c() {
        try {
            return new c(AtomicIntegerFieldUpdater.newUpdater(i2.class, "c"));
        } catch (Throwable th) {
            f4922d.log(Level.SEVERE, "FieldUpdaterAtomicHelper failed", th);
            return new d();
        }
    }

    private void d(Runnable runnable) {
        if (f4923e.a(this, 0, -1)) {
            try {
                this.f4924a.execute(this);
            } catch (Throwable th) {
                if (runnable != null) {
                    this.f4925b.remove(runnable);
                }
                f4923e.b(this, 0);
                throw th;
            }
        }
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        this.f4925b.add((Runnable) z0.k.o(runnable, "'r' must not be null."));
        d(runnable);
    }

    @Override // java.lang.Runnable
    public void run() {
        Runnable poll;
        try {
            Executor executor = this.f4924a;
            while (executor == this.f4924a && (poll = this.f4925b.poll()) != null) {
                try {
                    poll.run();
                } catch (RuntimeException e5) {
                    Logger logger = f4922d;
                    Level level = Level.SEVERE;
                    logger.log(level, "Exception while executing runnable " + poll, (Throwable) e5);
                }
            }
            f4923e.b(this, 0);
            if (this.f4925b.isEmpty()) {
                return;
            }
            d(null);
        } catch (Throwable th) {
            f4923e.b(this, 0);
            throw th;
        }
    }
}
