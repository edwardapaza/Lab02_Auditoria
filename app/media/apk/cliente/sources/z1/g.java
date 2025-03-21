package z1;

import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import z1.g;
/* loaded from: classes.dex */
public class g {

    /* renamed from: c  reason: collision with root package name */
    private final ArrayList<d> f8906c = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    private final ArrayList<b> f8905b = new ArrayList<>();

    /* renamed from: a  reason: collision with root package name */
    private final c f8904a = new c();

    /* loaded from: classes.dex */
    public class b {

        /* renamed from: a  reason: collision with root package name */
        private final d f8907a;

        /* renamed from: b  reason: collision with root package name */
        private final long f8908b;

        /* renamed from: c  reason: collision with root package name */
        private final Runnable f8909c;

        /* renamed from: d  reason: collision with root package name */
        private ScheduledFuture f8910d;

        private b(d dVar, long j5, Runnable runnable) {
            this.f8907a = dVar;
            this.f8908b = j5;
            this.f8909c = runnable;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void d() {
            g.this.w();
            if (this.f8910d != null) {
                e();
                this.f8909c.run();
            }
        }

        private void e() {
            z1.b.d(this.f8910d != null, "Caller should have verified scheduledFuture is non-null.", new Object[0]);
            this.f8910d = null;
            g.this.v(this);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void f(long j5) {
            this.f8910d = g.this.f8904a.schedule(new Runnable() { // from class: z1.h
                @Override // java.lang.Runnable
                public final void run() {
                    g.b.this.d();
                }
            }, j5, TimeUnit.MILLISECONDS);
        }

        public void c() {
            g.this.w();
            ScheduledFuture scheduledFuture = this.f8910d;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(false);
                e();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class c implements Executor {

        /* renamed from: a  reason: collision with root package name */
        private final ScheduledThreadPoolExecutor f8912a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f8913b;

        /* renamed from: c  reason: collision with root package name */
        private final Thread f8914c;

        /* loaded from: classes.dex */
        class a extends ScheduledThreadPoolExecutor {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ g f8916a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(int i5, ThreadFactory threadFactory, g gVar) {
                super(i5, threadFactory);
                this.f8916a = gVar;
            }

            @Override // java.util.concurrent.ThreadPoolExecutor
            protected void afterExecute(Runnable runnable, Throwable th) {
                super.afterExecute(runnable, th);
                if (th == null && (runnable instanceof Future)) {
                    Future future = (Future) runnable;
                    try {
                        if (future.isDone()) {
                            future.get();
                        }
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    } catch (CancellationException unused2) {
                    } catch (ExecutionException e5) {
                        th = e5.getCause();
                    }
                }
                if (th != null) {
                    g.this.u(th);
                }
            }
        }

        /* loaded from: classes.dex */
        private class b implements Runnable, ThreadFactory {

            /* renamed from: a  reason: collision with root package name */
            private final CountDownLatch f8918a;

            /* renamed from: b  reason: collision with root package name */
            private Runnable f8919b;

            private b() {
                this.f8918a = new CountDownLatch(1);
            }

            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                z1.b.d(this.f8919b == null, "Only one thread may be created in an AsyncQueue.", new Object[0]);
                this.f8919b = runnable;
                this.f8918a.countDown();
                return c.this.f8914c;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    this.f8918a.await();
                } catch (InterruptedException unused) {
                    Thread.currentThread().interrupt();
                }
                this.f8919b.run();
            }
        }

        c() {
            b bVar = new b();
            Thread newThread = Executors.defaultThreadFactory().newThread(bVar);
            this.f8914c = newThread;
            newThread.setName("FirestoreWorker");
            newThread.setDaemon(true);
            newThread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() { // from class: z1.i
                @Override // java.lang.Thread.UncaughtExceptionHandler
                public final void uncaughtException(Thread thread, Throwable th) {
                    g.c.this.q(thread, th);
                }
            });
            a aVar = new a(1, bVar, g.this);
            this.f8912a = aVar;
            aVar.setKeepAliveTime(3L, TimeUnit.SECONDS);
            this.f8913b = false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public synchronized Task<Void> k(final Runnable runnable) {
            if (!n()) {
                Task<Void> l5 = l(new Callable() { // from class: z1.j
                    @Override // java.util.concurrent.Callable
                    public final Object call() {
                        Void o5;
                        o5 = g.c.o(runnable);
                        return o5;
                    }
                });
                this.f8913b = true;
                return l5;
            }
            TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
            taskCompletionSource.setResult(null);
            return taskCompletionSource.getTask();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public <T> Task<T> l(final Callable<T> callable) {
            final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
            try {
                execute(new Runnable() { // from class: z1.k
                    @Override // java.lang.Runnable
                    public final void run() {
                        g.c.p(TaskCompletionSource.this, callable);
                    }
                });
            } catch (RejectedExecutionException unused) {
                w.e(g.class.getSimpleName(), "Refused to enqueue task after panic", new Object[0]);
            }
            return taskCompletionSource.getTask();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public synchronized boolean n() {
            return this.f8913b;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ Void o(Runnable runnable) {
            runnable.run();
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void p(TaskCompletionSource taskCompletionSource, Callable callable) {
            try {
                taskCompletionSource.setResult(callable.call());
            } catch (Exception e5) {
                taskCompletionSource.setException(e5);
                throw new RuntimeException(e5);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void q(Thread thread, Throwable th) {
            g.this.u(th);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void r() {
            this.f8912a.shutdownNow();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public synchronized ScheduledFuture<?> schedule(Runnable runnable, long j5, TimeUnit timeUnit) {
            if (this.f8913b) {
                return null;
            }
            return this.f8912a.schedule(runnable, j5, timeUnit);
        }

        @Override // java.util.concurrent.Executor
        public synchronized void execute(Runnable runnable) {
            if (!this.f8913b) {
                this.f8912a.execute(runnable);
            }
        }

        public void m(Runnable runnable) {
            try {
                this.f8912a.execute(runnable);
            } catch (RejectedExecutionException unused) {
                w.e(g.class.getSimpleName(), "Refused to enqueue task after panic", new Object[0]);
            }
        }
    }

    /* loaded from: classes.dex */
    public enum d {
        ALL,
        LISTEN_STREAM_IDLE,
        LISTEN_STREAM_CONNECTION_BACKOFF,
        WRITE_STREAM_IDLE,
        WRITE_STREAM_CONNECTION_BACKOFF,
        HEALTH_CHECK_TIMEOUT,
        ONLINE_STATE_TIMEOUT,
        GARBAGE_COLLECTION,
        RETRY_TRANSACTION,
        CONNECTIVITY_ATTEMPT_TIMER,
        INDEX_BACKFILL
    }

    public static <TResult> Task<TResult> g(final Executor executor, final Callable<Task<TResult>> callable) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        executor.execute(new Runnable() { // from class: z1.e
            @Override // java.lang.Runnable
            public final void run() {
                g.r(callable, executor, taskCompletionSource);
            }
        });
        return taskCompletionSource.getTask();
    }

    private b h(d dVar, long j5, Runnable runnable) {
        b bVar = new b(dVar, System.currentTimeMillis() + j5, runnable);
        bVar.f(j5);
        return bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Void q(TaskCompletionSource taskCompletionSource, Task task) {
        if (task.isSuccessful()) {
            taskCompletionSource.setResult(task.getResult());
            return null;
        }
        taskCompletionSource.setException(task.getException());
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void r(Callable callable, Executor executor, final TaskCompletionSource taskCompletionSource) {
        try {
            ((Task) callable.call()).continueWith(executor, new Continuation() { // from class: z1.f
                @Override // com.google.android.gms.tasks.Continuation
                public final Object then(Task task) {
                    Void q5;
                    q5 = g.q(TaskCompletionSource.this, task);
                    return q5;
                }
            });
        } catch (Exception e5) {
            taskCompletionSource.setException(e5);
        } catch (Throwable th) {
            taskCompletionSource.setException(new IllegalStateException("Unhandled throwable in callTask.", th));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Void s(Runnable runnable) {
        runnable.run();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void t(Throwable th) {
        if (!(th instanceof OutOfMemoryError)) {
            throw new RuntimeException("Internal error in Cloud Firestore (24.11.0).", th);
        }
        OutOfMemoryError outOfMemoryError = new OutOfMemoryError("Firestore (24.11.0) ran out of memory. Check your queries to make sure they are not loading an excessive amount of data.");
        outOfMemoryError.initCause(th);
        throw outOfMemoryError;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(b bVar) {
        z1.b.d(this.f8905b.remove(bVar), "Delayed task not found.", new Object[0]);
    }

    public Task<Void> i(final Runnable runnable) {
        return j(new Callable() { // from class: z1.c
            @Override // java.util.concurrent.Callable
            public final Object call() {
                Void s5;
                s5 = g.s(runnable);
                return s5;
            }
        });
    }

    public <T> Task<T> j(Callable<T> callable) {
        return this.f8904a.l(callable);
    }

    public b k(d dVar, long j5, Runnable runnable) {
        if (this.f8906c.contains(dVar)) {
            j5 = 0;
        }
        b h5 = h(dVar, j5, runnable);
        this.f8905b.add(h5);
        return h5;
    }

    public void l(Runnable runnable) {
        i(runnable);
    }

    public void m(Runnable runnable) {
        this.f8904a.m(runnable);
    }

    public Task<Void> n(Runnable runnable) {
        return this.f8904a.k(runnable);
    }

    public Executor o() {
        return this.f8904a;
    }

    public boolean p() {
        return this.f8904a.n();
    }

    public void u(final Throwable th) {
        this.f8904a.r();
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: z1.d
            @Override // java.lang.Runnable
            public final void run() {
                g.t(th);
            }
        });
    }

    public void w() {
        Thread currentThread = Thread.currentThread();
        if (this.f8904a.f8914c != currentThread) {
            throw z1.b.a("We are running on the wrong thread. Expected to be on the AsyncQueue thread %s/%d but was %s/%d", this.f8904a.f8914c.getName(), Long.valueOf(this.f8904a.f8914c.getId()), currentThread.getName(), Long.valueOf(currentThread.getId()));
        }
    }
}
