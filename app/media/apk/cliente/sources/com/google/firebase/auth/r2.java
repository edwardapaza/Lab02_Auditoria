package com.google.firebase.auth;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class r2 implements Continuation<Void, Task<Void>> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public r2(FirebaseAuth firebaseAuth) {
    }

    @Override // com.google.android.gms.tasks.Continuation
    public final /* synthetic */ Task<Void> then(Task<Void> task) {
        return (!task.isSuccessful() && (task.getException() instanceof q) && ((q) task.getException()).a().equals("ERROR_INTERNAL_SUCCESS_SIGN_OUT")) ? Tasks.forResult(null) : task;
    }
}
