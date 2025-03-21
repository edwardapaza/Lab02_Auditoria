package com.google.firebase.auth;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class n1 implements Continuation<c0, Task<Void>> {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ String f1504a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ e f1505b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ a0 f1506c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n1(a0 a0Var, String str, e eVar) {
        this.f1504a = str;
        this.f1505b = eVar;
        this.f1506c = a0Var;
    }

    @Override // com.google.android.gms.tasks.Continuation
    public final /* synthetic */ Task<Void> then(Task<c0> task) {
        return FirebaseAuth.getInstance(this.f1506c.P()).Z((String) com.google.android.gms.common.internal.q.k(task.getResult().g()), this.f1504a, this.f1505b);
    }
}
