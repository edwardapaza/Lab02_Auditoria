package i3;

import java.lang.Thread;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes.dex */
public final class n1 implements Executor {

    /* renamed from: a  reason: collision with root package name */
    private final Thread.UncaughtExceptionHandler f3501a;

    /* renamed from: b  reason: collision with root package name */
    private final Queue<Runnable> f3502b = new ConcurrentLinkedQueue();

    /* renamed from: c  reason: collision with root package name */
    private final AtomicReference<Thread> f3503c = new AtomicReference<>();

    /* loaded from: classes.dex */
    class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f3504a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Runnable f3505b;

        a(c cVar, Runnable runnable) {
            this.f3504a = cVar;
            this.f3505b = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            n1.this.execute(this.f3504a);
        }

        public String toString() {
            return this.f3505b.toString() + "(scheduled in SynchronizationContext)";
        }
    }

    /* loaded from: classes.dex */
    class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f3507a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Runnable f3508b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ long f3509c;

        b(c cVar, Runnable runnable, long j5) {
            this.f3507a = cVar;
            this.f3508b = runnable;
            this.f3509c = j5;
        }

        @Override // java.lang.Runnable
        public void run() {
            n1.this.execute(this.f3507a);
        }

        public String toString() {
            return this.f3508b.toString() + "(scheduled in SynchronizationContext with delay of " + this.f3509c + ")";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final Runnable f3511a;

        /* renamed from: b  reason: collision with root package name */
        boolean f3512b;

        /* renamed from: c  reason: collision with root package name */
        boolean f3513c;

        c(Runnable runnable) {
            this.f3511a = (Runnable) z0.k.o(runnable, "task");
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f3512b) {
                return;
            }
            this.f3513c = true;
            this.f3511a.run();
        }
    }

    /* loaded from: classes.dex */
    public static final class d {

        /* renamed from: a  reason: collision with root package name */
        private final c f3514a;

        /* renamed from: b  reason: collision with root package name */
        private final ScheduledFuture<?> f3515b;

        private d(c cVar, ScheduledFuture<?> scheduledFuture) {
            this.f3514a = (c) z0.k.o(cVar, "runnable");
            this.f3515b = (ScheduledFuture) z0.k.o(scheduledFuture, "future");
        }

        /* synthetic */ d(c cVar, ScheduledFuture scheduledFuture, a aVar) {
            this(cVar, scheduledFuture);
        }

        public void a() {
            this.f3514a.f3512b = true;
            this.f3515b.cancel(false);
        }

        public boolean b() {
            c cVar = this.f3514a;
            return (cVar.f3513c || cVar.f3512b) ? false : true;
        }
    }

    public n1(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.f3501a = (Thread.UncaughtExceptionHandler) z0.k.o(uncaughtExceptionHandler, "uncaughtExceptionHandler");
    }

    public final void a() {
        while (com.google.android.gms.common.api.internal.m1.a(this.f3503c, null, Thread.currentThread())) {
            while (true) {
                try {
                    Runnable poll = this.f3502b.poll();
                    if (poll != null) {
                        poll.run();
                    } else {
                        this.f3503c.set(null);
                        if (this.f3502b.isEmpty()) {
                            return;
                        }
                    }
                } catch (Throwable th) {
                    this.f3503c.set(null);
                    throw th;
                }
            }
        }
    }

    public final void b(Runnable runnable) {
        this.f3502b.add((Runnable) z0.k.o(runnable, "runnable is null"));
    }

    public final d c(Runnable runnable, long j5, TimeUnit timeUnit, ScheduledExecutorService scheduledExecutorService) {
        c cVar = new c(runnable);
        return new d(cVar, scheduledExecutorService.schedule(new a(cVar, runnable), j5, timeUnit), null);
    }

    public final d d(Runnable runnable, long j5, long j6, TimeUnit timeUnit, ScheduledExecutorService scheduledExecutorService) {
        c cVar = new c(runnable);
        return new d(cVar, scheduledExecutorService.scheduleWithFixedDelay(new b(cVar, runnable, j6), j5, j6, timeUnit), null);
    }

    public void e() {
        z0.k.u(Thread.currentThread() == this.f3503c.get(), "Not called from the SynchronizationContext");
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        b(runnable);
        a();
    }
}
