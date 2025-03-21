package com.google.firebase.concurrent;

import com.google.firebase.concurrent.p;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements ScheduledExecutorService {

    /* renamed from: a  reason: collision with root package name */
    private final ExecutorService f1626a;

    /* renamed from: b  reason: collision with root package name */
    private final ScheduledExecutorService f1627b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(ExecutorService executorService, ScheduledExecutorService scheduledExecutorService) {
        this.f1626a = executorService;
        this.f1627b = scheduledExecutorService;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void n(Runnable runnable, p.b bVar) {
        try {
            runnable.run();
            bVar.set(null);
        } catch (Exception e5) {
            bVar.a(e5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o(final Runnable runnable, final p.b bVar) {
        this.f1626a.execute(new Runnable() { // from class: com.google.firebase.concurrent.d
            @Override // java.lang.Runnable
            public final void run() {
                o.n(runnable, bVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ ScheduledFuture p(final Runnable runnable, long j5, TimeUnit timeUnit, final p.b bVar) {
        return this.f1627b.schedule(new Runnable() { // from class: com.google.firebase.concurrent.k
            @Override // java.lang.Runnable
            public final void run() {
                o.this.o(runnable, bVar);
            }
        }, j5, timeUnit);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void q(Callable callable, p.b bVar) {
        try {
            bVar.set(callable.call());
        } catch (Exception e5) {
            bVar.a(e5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Future r(final Callable callable, final p.b bVar) {
        return this.f1626a.submit(new Runnable() { // from class: com.google.firebase.concurrent.m
            @Override // java.lang.Runnable
            public final void run() {
                o.q(callable, bVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ ScheduledFuture s(final Callable callable, long j5, TimeUnit timeUnit, final p.b bVar) {
        return this.f1627b.schedule(new Callable() { // from class: com.google.firebase.concurrent.l
            @Override // java.util.concurrent.Callable
            public final Object call() {
                Future r5;
                r5 = o.this.r(callable, bVar);
                return r5;
            }
        }, j5, timeUnit);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void t(Runnable runnable, p.b bVar) {
        try {
            runnable.run();
        } catch (Exception e5) {
            bVar.a(e5);
            throw e5;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void u(final Runnable runnable, final p.b bVar) {
        this.f1626a.execute(new Runnable() { // from class: com.google.firebase.concurrent.n
            @Override // java.lang.Runnable
            public final void run() {
                o.t(runnable, bVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ ScheduledFuture v(final Runnable runnable, long j5, long j6, TimeUnit timeUnit, final p.b bVar) {
        return this.f1627b.scheduleAtFixedRate(new Runnable() { // from class: com.google.firebase.concurrent.i
            @Override // java.lang.Runnable
            public final void run() {
                o.this.u(runnable, bVar);
            }
        }, j5, j6, timeUnit);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void w(final Runnable runnable, final p.b bVar) {
        this.f1626a.execute(new Runnable() { // from class: com.google.firebase.concurrent.e
            @Override // java.lang.Runnable
            public final void run() {
                o.z(runnable, bVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ ScheduledFuture y(final Runnable runnable, long j5, long j6, TimeUnit timeUnit, final p.b bVar) {
        return this.f1627b.scheduleWithFixedDelay(new Runnable() { // from class: com.google.firebase.concurrent.j
            @Override // java.lang.Runnable
            public final void run() {
                o.this.w(runnable, bVar);
            }
        }, j5, j6, timeUnit);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void z(Runnable runnable, p.b bVar) {
        try {
            runnable.run();
        } catch (Exception e5) {
            bVar.a(e5);
        }
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean awaitTermination(long j5, TimeUnit timeUnit) {
        return this.f1626a.awaitTermination(j5, timeUnit);
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        this.f1626a.execute(runnable);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection) {
        return this.f1626a.invokeAll(collection);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection, long j5, TimeUnit timeUnit) {
        return this.f1626a.invokeAll(collection, j5, timeUnit);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> T invokeAny(Collection<? extends Callable<T>> collection) {
        return (T) this.f1626a.invokeAny(collection);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> T invokeAny(Collection<? extends Callable<T>> collection, long j5, TimeUnit timeUnit) {
        return (T) this.f1626a.invokeAny(collection, j5, timeUnit);
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isShutdown() {
        return this.f1626a.isShutdown();
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isTerminated() {
        return this.f1626a.isTerminated();
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public ScheduledFuture<?> schedule(final Runnable runnable, final long j5, final TimeUnit timeUnit) {
        return new p(new p.c() { // from class: com.google.firebase.concurrent.f
            @Override // com.google.firebase.concurrent.p.c
            public final ScheduledFuture a(p.b bVar) {
                ScheduledFuture p5;
                p5 = o.this.p(runnable, j5, timeUnit, bVar);
                return p5;
            }
        });
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public <V> ScheduledFuture<V> schedule(final Callable<V> callable, final long j5, final TimeUnit timeUnit) {
        return new p(new p.c() { // from class: com.google.firebase.concurrent.c
            @Override // com.google.firebase.concurrent.p.c
            public final ScheduledFuture a(p.b bVar) {
                ScheduledFuture s5;
                s5 = o.this.s(callable, j5, timeUnit, bVar);
                return s5;
            }
        });
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public ScheduledFuture<?> scheduleAtFixedRate(final Runnable runnable, final long j5, final long j6, final TimeUnit timeUnit) {
        return new p(new p.c() { // from class: com.google.firebase.concurrent.h
            @Override // com.google.firebase.concurrent.p.c
            public final ScheduledFuture a(p.b bVar) {
                ScheduledFuture v5;
                v5 = o.this.v(runnable, j5, j6, timeUnit, bVar);
                return v5;
            }
        });
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public ScheduledFuture<?> scheduleWithFixedDelay(final Runnable runnable, final long j5, final long j6, final TimeUnit timeUnit) {
        return new p(new p.c() { // from class: com.google.firebase.concurrent.g
            @Override // com.google.firebase.concurrent.p.c
            public final ScheduledFuture a(p.b bVar) {
                ScheduledFuture y4;
                y4 = o.this.y(runnable, j5, j6, timeUnit, bVar);
                return y4;
            }
        });
    }

    @Override // java.util.concurrent.ExecutorService
    public void shutdown() {
        throw new UnsupportedOperationException("Shutting down is not allowed.");
    }

    @Override // java.util.concurrent.ExecutorService
    public List<Runnable> shutdownNow() {
        throw new UnsupportedOperationException("Shutting down is not allowed.");
    }

    @Override // java.util.concurrent.ExecutorService
    public Future<?> submit(Runnable runnable) {
        return this.f1626a.submit(runnable);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> Future<T> submit(Runnable runnable, T t5) {
        return this.f1626a.submit(runnable, t5);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> Future<T> submit(Callable<T> callable) {
        return this.f1626a.submit(callable);
    }
}
