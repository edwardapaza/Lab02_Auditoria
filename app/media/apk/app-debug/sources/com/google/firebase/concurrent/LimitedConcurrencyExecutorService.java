package com.google.firebase.concurrent;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
/* loaded from: classes.dex */
final class LimitedConcurrencyExecutorService extends LimitedConcurrencyExecutor implements ExecutorService {
    private final ExecutorService delegate;

    /* JADX INFO: Access modifiers changed from: package-private */
    public LimitedConcurrencyExecutorService(ExecutorService delegate, int concurrency) {
        super(delegate, concurrency);
        this.delegate = delegate;
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
    public boolean isShutdown() {
        return this.delegate.isShutdown();
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isTerminated() {
        return this.delegate.isTerminated();
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean awaitTermination(long timeout, TimeUnit unit) throws InterruptedException {
        return this.delegate.awaitTermination(timeout, unit);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> Future<T> submit(Callable<T> task) {
        FutureTask<T> ft = new FutureTask<>(task);
        execute(ft);
        return ft;
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> Future<T> submit(final Runnable task, final T result) {
        return submit(new Callable() { // from class: com.google.firebase.concurrent.LimitedConcurrencyExecutorService$$ExternalSyntheticLambda0
            /*  JADX ERROR: JadxRuntimeException in pass: InlineMethods
                jadx.core.utils.exceptions.JadxRuntimeException: Failed to process method for inline: com.google.firebase.concurrent.LimitedConcurrencyExecutorService.lambda$submit$0(java.lang.Runnable, java.lang.Object):java.lang.Object
                	at jadx.core.dex.visitors.InlineMethods.processInvokeInsn(InlineMethods.java:76)
                	at jadx.core.dex.visitors.InlineMethods.visit(InlineMethods.java:51)
                Caused by: java.lang.NullPointerException
                	at jadx.core.dex.instructions.args.RegisterArg.sameRegAndSVar(RegisterArg.java:173)
                	at jadx.core.dex.instructions.args.InsnArg.isSameVar(InsnArg.java:269)
                	at jadx.core.dex.visitors.MarkMethodsForInline.isSyntheticAccessPattern(MarkMethodsForInline.java:118)
                	at jadx.core.dex.visitors.MarkMethodsForInline.inlineMth(MarkMethodsForInline.java:86)
                	at jadx.core.dex.visitors.MarkMethodsForInline.process(MarkMethodsForInline.java:53)
                	at jadx.core.dex.visitors.InlineMethods.processInvokeInsn(InlineMethods.java:65)
                	... 1 more
                */
            @Override // java.util.concurrent.Callable
            public final java.lang.Object call() {
                /*
                    r2 = this;
                    java.lang.Runnable r0 = r1
                    java.lang.Object r1 = r2
                    java.lang.Object r0 = com.google.firebase.concurrent.LimitedConcurrencyExecutorService.lambda$submit$0(r0, r1)
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.concurrent.LimitedConcurrencyExecutorService$$ExternalSyntheticLambda0.call():java.lang.Object");
            }
        });
    }

    /*  JADX ERROR: NullPointerException in pass: MarkMethodsForInline
        java.lang.NullPointerException
        	at jadx.core.dex.instructions.args.RegisterArg.sameRegAndSVar(RegisterArg.java:173)
        	at jadx.core.dex.instructions.args.InsnArg.isSameVar(InsnArg.java:269)
        	at jadx.core.dex.visitors.MarkMethodsForInline.isSyntheticAccessPattern(MarkMethodsForInline.java:118)
        	at jadx.core.dex.visitors.MarkMethodsForInline.inlineMth(MarkMethodsForInline.java:86)
        	at jadx.core.dex.visitors.MarkMethodsForInline.process(MarkMethodsForInline.java:53)
        	at jadx.core.dex.visitors.MarkMethodsForInline.visit(MarkMethodsForInline.java:37)
        */
    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ java.lang.Object lambda$submit$0(java.lang.Runnable r0, java.lang.Object r1) throws java.lang.Exception {
        /*
            r0.run()
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.concurrent.LimitedConcurrencyExecutorService.lambda$submit$0(java.lang.Runnable, java.lang.Object):java.lang.Object");
    }

    @Override // java.util.concurrent.ExecutorService
    public Future<?> submit(final Runnable task) {
        return submit(new Callable() { // from class: com.google.firebase.concurrent.LimitedConcurrencyExecutorService$$ExternalSyntheticLambda1
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return LimitedConcurrencyExecutorService.lambda$submit$1(task);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Object lambda$submit$1(Runnable task) throws Exception {
        task.run();
        return null;
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks) throws InterruptedException {
        return this.delegate.invokeAll(tasks);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks, long timeout, TimeUnit unit) throws InterruptedException {
        return this.delegate.invokeAll(tasks, timeout, unit);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> T invokeAny(Collection<? extends Callable<T>> tasks) throws ExecutionException, InterruptedException {
        return (T) this.delegate.invokeAny(tasks);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> T invokeAny(Collection<? extends Callable<T>> tasks, long timeout, TimeUnit unit) throws ExecutionException, InterruptedException, TimeoutException {
        return (T) this.delegate.invokeAny(tasks, timeout, unit);
    }
}
