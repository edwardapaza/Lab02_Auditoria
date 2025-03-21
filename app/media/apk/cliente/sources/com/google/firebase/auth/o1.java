package com.google.firebase.auth;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class o1 implements Continuation<c0, Task<Void>> {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ e f1515a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ a0 f1516b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o1(a0 a0Var, e eVar) {
        this.f1515a = eVar;
        this.f1516b = a0Var;
    }

    @Override // com.google.android.gms.tasks.Continuation
    public final /* synthetic */ Task<Void> then(Task<c0> task) {
        return FirebaseAuth.getInstance(this.f1516b.P()).M(this.f1515a, (String) com.google.android.gms.common.internal.q.k(task.getResult().g()));
    }
}
