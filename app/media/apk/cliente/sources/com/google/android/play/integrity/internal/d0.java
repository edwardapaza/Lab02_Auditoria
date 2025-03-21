package com.google.android.play.integrity.internal;

import com.google.android.gms.tasks.TaskCompletionSource;
/* loaded from: classes.dex */
public abstract class d0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final TaskCompletionSource f1357a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d0() {
        this.f1357a = null;
    }

    public d0(TaskCompletionSource taskCompletionSource) {
        this.f1357a = taskCompletionSource;
    }

    public void a(Exception exc) {
        TaskCompletionSource taskCompletionSource = this.f1357a;
        if (taskCompletionSource != null) {
            taskCompletionSource.trySetException(exc);
        }
    }

    protected abstract void b();

    /* JADX INFO: Access modifiers changed from: package-private */
    public final TaskCompletionSource c() {
        return this.f1357a;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            b();
        } catch (Exception e5) {
            a(e5);
        }
    }
}
