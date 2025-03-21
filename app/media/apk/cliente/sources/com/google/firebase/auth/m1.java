package com.google.firebase.auth;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class m1 implements Continuation<c0, Task<Void>> {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ a0 f1492a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m1(a0 a0Var) {
        this.f1492a = a0Var;
    }

    @Override // com.google.android.gms.tasks.Continuation
    public final /* synthetic */ Task<Void> then(Task<c0> task) {
        return FirebaseAuth.getInstance(this.f1492a.P()).M(null, (String) com.google.android.gms.common.internal.q.k(task.getResult().g()));
    }
}
