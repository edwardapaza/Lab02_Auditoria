package com.google.firebase.firestore;

import android.app.Activity;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCanceledListener;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.TaskExecutors;
import com.google.firebase.firestore.i0;
import com.google.firebase.firestore.j0;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.Executor;
/* loaded from: classes.dex */
public class i0 extends Task<j0> {

    /* renamed from: a  reason: collision with root package name */
    private final Object f1711a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private j0 f1712b = j0.f1720g;

    /* renamed from: c  reason: collision with root package name */
    private final TaskCompletionSource<j0> f1713c;

    /* renamed from: d  reason: collision with root package name */
    private final Task<j0> f1714d;

    /* renamed from: e  reason: collision with root package name */
    private final Queue<a> f1715e;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        Executor f1716a;

        /* renamed from: b  reason: collision with root package name */
        q0<j0> f1717b;

        a(Executor executor, q0<j0> q0Var) {
            this.f1716a = executor == null ? TaskExecutors.MAIN_THREAD : executor;
            this.f1717b = q0Var;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void c(j0 j0Var) {
            this.f1717b.a(j0Var);
        }

        public void b(final j0 j0Var) {
            this.f1716a.execute(new Runnable() { // from class: com.google.firebase.firestore.h0
                @Override // java.lang.Runnable
                public final void run() {
                    i0.a.this.c(j0Var);
                }
            });
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            return this.f1717b.equals(((a) obj).f1717b);
        }

        public int hashCode() {
            return this.f1717b.hashCode();
        }
    }

    public i0() {
        TaskCompletionSource<j0> taskCompletionSource = new TaskCompletionSource<>();
        this.f1713c = taskCompletionSource;
        this.f1714d = taskCompletionSource.getTask();
        this.f1715e = new ArrayDeque();
    }

    public i0 a(q0<j0> q0Var) {
        a aVar = new a(null, q0Var);
        synchronized (this.f1711a) {
            this.f1715e.add(aVar);
        }
        return this;
    }

    @Override // com.google.android.gms.tasks.Task
    public Task<j0> addOnCanceledListener(Activity activity, OnCanceledListener onCanceledListener) {
        return this.f1714d.addOnCanceledListener(activity, onCanceledListener);
    }

    @Override // com.google.android.gms.tasks.Task
    public Task<j0> addOnCanceledListener(OnCanceledListener onCanceledListener) {
        return this.f1714d.addOnCanceledListener(onCanceledListener);
    }

    @Override // com.google.android.gms.tasks.Task
    public Task<j0> addOnCanceledListener(Executor executor, OnCanceledListener onCanceledListener) {
        return this.f1714d.addOnCanceledListener(executor, onCanceledListener);
    }

    @Override // com.google.android.gms.tasks.Task
    public Task<j0> addOnCompleteListener(Activity activity, OnCompleteListener<j0> onCompleteListener) {
        return this.f1714d.addOnCompleteListener(activity, onCompleteListener);
    }

    @Override // com.google.android.gms.tasks.Task
    public Task<j0> addOnCompleteListener(OnCompleteListener<j0> onCompleteListener) {
        return this.f1714d.addOnCompleteListener(onCompleteListener);
    }

    @Override // com.google.android.gms.tasks.Task
    public Task<j0> addOnCompleteListener(Executor executor, OnCompleteListener<j0> onCompleteListener) {
        return this.f1714d.addOnCompleteListener(executor, onCompleteListener);
    }

    @Override // com.google.android.gms.tasks.Task
    public Task<j0> addOnFailureListener(Activity activity, OnFailureListener onFailureListener) {
        return this.f1714d.addOnFailureListener(activity, onFailureListener);
    }

    @Override // com.google.android.gms.tasks.Task
    public Task<j0> addOnFailureListener(OnFailureListener onFailureListener) {
        return this.f1714d.addOnFailureListener(onFailureListener);
    }

    @Override // com.google.android.gms.tasks.Task
    public Task<j0> addOnFailureListener(Executor executor, OnFailureListener onFailureListener) {
        return this.f1714d.addOnFailureListener(executor, onFailureListener);
    }

    @Override // com.google.android.gms.tasks.Task
    public Task<j0> addOnSuccessListener(Activity activity, OnSuccessListener<? super j0> onSuccessListener) {
        return this.f1714d.addOnSuccessListener(activity, onSuccessListener);
    }

    @Override // com.google.android.gms.tasks.Task
    public Task<j0> addOnSuccessListener(OnSuccessListener<? super j0> onSuccessListener) {
        return this.f1714d.addOnSuccessListener(onSuccessListener);
    }

    @Override // com.google.android.gms.tasks.Task
    public Task<j0> addOnSuccessListener(Executor executor, OnSuccessListener<? super j0> onSuccessListener) {
        return this.f1714d.addOnSuccessListener(executor, onSuccessListener);
    }

    @Override // com.google.android.gms.tasks.Task
    /* renamed from: b */
    public j0 getResult() {
        return this.f1714d.getResult();
    }

    @Override // com.google.android.gms.tasks.Task
    /* renamed from: c */
    public <X extends Throwable> j0 getResult(Class<X> cls) {
        return this.f1714d.getResult(cls);
    }

    @Override // com.google.android.gms.tasks.Task
    public <TContinuationResult> Task<TContinuationResult> continueWith(Continuation<j0, TContinuationResult> continuation) {
        return this.f1714d.continueWith(continuation);
    }

    @Override // com.google.android.gms.tasks.Task
    public <TContinuationResult> Task<TContinuationResult> continueWith(Executor executor, Continuation<j0, TContinuationResult> continuation) {
        return this.f1714d.continueWith(executor, continuation);
    }

    @Override // com.google.android.gms.tasks.Task
    public <TContinuationResult> Task<TContinuationResult> continueWithTask(Continuation<j0, Task<TContinuationResult>> continuation) {
        return this.f1714d.continueWithTask(continuation);
    }

    @Override // com.google.android.gms.tasks.Task
    public <TContinuationResult> Task<TContinuationResult> continueWithTask(Executor executor, Continuation<j0, Task<TContinuationResult>> continuation) {
        return this.f1714d.continueWithTask(executor, continuation);
    }

    public void d(Exception exc) {
        synchronized (this.f1711a) {
            j0 j0Var = new j0(this.f1712b.d(), this.f1712b.g(), this.f1712b.c(), this.f1712b.f(), exc, j0.a.ERROR);
            this.f1712b = j0Var;
            for (a aVar : this.f1715e) {
                aVar.b(j0Var);
            }
            this.f1715e.clear();
        }
        this.f1713c.setException(exc);
    }

    public void e(j0 j0Var) {
        boolean equals = j0Var.e().equals(j0.a.SUCCESS);
        z1.b.d(equals, "Expected success, but was " + j0Var.e(), new Object[0]);
        synchronized (this.f1711a) {
            this.f1712b = j0Var;
            for (a aVar : this.f1715e) {
                aVar.b(this.f1712b);
            }
            this.f1715e.clear();
        }
        this.f1713c.setResult(j0Var);
    }

    public void f(j0 j0Var) {
        synchronized (this.f1711a) {
            this.f1712b = j0Var;
            for (a aVar : this.f1715e) {
                aVar.b(j0Var);
            }
        }
    }

    @Override // com.google.android.gms.tasks.Task
    public Exception getException() {
        return this.f1714d.getException();
    }

    @Override // com.google.android.gms.tasks.Task
    public boolean isCanceled() {
        return this.f1714d.isCanceled();
    }

    @Override // com.google.android.gms.tasks.Task
    public boolean isComplete() {
        return this.f1714d.isComplete();
    }

    @Override // com.google.android.gms.tasks.Task
    public boolean isSuccessful() {
        return this.f1714d.isSuccessful();
    }

    @Override // com.google.android.gms.tasks.Task
    public <TContinuationResult> Task<TContinuationResult> onSuccessTask(SuccessContinuation<j0, TContinuationResult> successContinuation) {
        return this.f1714d.onSuccessTask(successContinuation);
    }

    @Override // com.google.android.gms.tasks.Task
    public <TContinuationResult> Task<TContinuationResult> onSuccessTask(Executor executor, SuccessContinuation<j0, TContinuationResult> successContinuation) {
        return this.f1714d.onSuccessTask(executor, successContinuation);
    }
}
