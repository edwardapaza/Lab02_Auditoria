package com.google.firebase.auth;

import com.google.android.gms.internal.p001firebaseauthapi.zzah;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.android.recaptcha.RecaptchaTasksClient;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class y2 implements Continuation<RecaptchaTasksClient, Task<Void>> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public y2(FirebaseAuth firebaseAuth) {
    }

    @Override // com.google.android.gms.tasks.Continuation
    public final /* synthetic */ Task<Void> then(Task<RecaptchaTasksClient> task) {
        if (task.isSuccessful()) {
            return Tasks.forResult(null);
        }
        Exception exception = task.getException();
        return Tasks.forException(new q("INTERNAL_ERROR", zzah.zzb(exception != null ? exception.getMessage() : "")));
    }
}
