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
final class PausableExecutorServiceImpl implements PausableExecutorService {
    private final ExecutorService delegateService;
    private final PausableExecutor pausableDelegate;

    /* JADX INFO: Access modifiers changed from: package-private */
    public PausableExecutorServiceImpl(boolean paused, ExecutorService delegate) {
        this.delegateService = delegate;
        this.pausableDelegate = new PausableExecutorImpl(paused, delegate);
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable command) {
        this.pausableDelegate.execute(command);
    }

    @Override // com.google.firebase.concurrent.PausableExecutor
    public void pause() {
        this.pausableDelegate.pause();
    }

    @Override // com.google.firebase.concurrent.PausableExecutor
    public void resume() {
        this.pausableDelegate.resume();
    }

    @Override // com.google.firebase.concurrent.PausableExecutor
    public boolean isPaused() {
        return this.pausableDelegate.isPaused();
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
        return this.delegateService.isShutdown();
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isTerminated() {
        return this.delegateService.isTerminated();
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean awaitTermination(long timeout, TimeUnit unit) throws InterruptedException {
        return this.delegateService.awaitTermination(timeout, unit);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> Future<T> submit(Callable<T> task) {
        FutureTask<T> ft = new FutureTask<>(task);
        execute(ft);
        return ft;
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> Future<T> submit(final Runnable task, final T result) {
        return submit(new Callable() { // from class: com.google.firebase.concurrent.PausableExecutorServiceImpl$$ExternalSyntheticLambda0
            /*  JADX ERROR: JadxRuntimeException in pass: InlineMethods
                jadx.core.utils.exceptions.JadxRuntimeException: Failed to process method for inline: com.google.firebase.concurrent.PausableExecutorServiceImpl.lambda$submit$0(java.lang.Runnable, java.lang.Object):java.lang.Object
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
                    java.lang.Object r0 = com.google.firebase.concurrent.PausableExecutorServiceImpl.lambda$submit$0(r0, r1)
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.concurrent.PausableExecutorServiceImpl$$ExternalSyntheticLambda0.call():java.lang.Object");
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.concurrent.PausableExecutorServiceImpl.lambda$submit$0(java.lang.Runnable, java.lang.Object):java.lang.Object");
    }

    @Override // java.util.concurrent.ExecutorService
    public Future<?> submit(final Runnable task) {
        return submit(new Callable() { // from class: com.google.firebase.concurrent.PausableExecutorServiceImpl$$ExternalSyntheticLambda1
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return PausableExecutorServiceImpl.lambda$submit$1(task);
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
        return this.delegateService.invokeAll(tasks);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks, long timeout, TimeUnit unit) throws InterruptedException {
        return this.delegateService.invokeAll(tasks, timeout, unit);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> T invokeAny(Collection<? extends Callable<T>> tasks) throws ExecutionException, InterruptedException {
        return (T) this.delegateService.invokeAny(tasks);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> T invokeAny(Collection<? extends Callable<T>> tasks, long timeout, TimeUnit unit) throws ExecutionException, InterruptedException, TimeoutException {
        return (T) this.delegateService.invokeAny(tasks, timeout, unit);
    }
}
