package com.google.firebase.firestore;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.List;
import java.util.Map;
import java.util.Objects;
/* loaded from: classes.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private final w0 f1676a;

    /* renamed from: b  reason: collision with root package name */
    private final List<a> f1677b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(w0 w0Var, List<a> list) {
        this.f1676a = w0Var;
        this.f1677b = list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object d(TaskCompletionSource taskCompletionSource, Task task) {
        if (task.isSuccessful()) {
            taskCompletionSource.setResult(new d(this, (Map) task.getResult()));
            return null;
        }
        taskCompletionSource.setException(task.getException());
        return null;
    }

    public Task<d> b(e eVar) {
        z1.y.c(eVar, "AggregateSource must not be null");
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.f1676a.f1787b.s().g0(this.f1676a.f1786a, this.f1677b).continueWith(z1.p.f8961b, new Continuation() { // from class: com.google.firebase.firestore.b
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) {
                Object d5;
                d5 = c.this.d(taskCompletionSource, task);
                return d5;
            }
        });
        return taskCompletionSource.getTask();
    }

    public w0 c() {
        return this.f1676a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof c) {
            c cVar = (c) obj;
            return this.f1676a.equals(cVar.f1676a) && this.f1677b.equals(cVar.f1677b);
        }
        return false;
    }

    public int hashCode() {
        return Objects.hash(this.f1676a, this.f1677b);
    }
}
