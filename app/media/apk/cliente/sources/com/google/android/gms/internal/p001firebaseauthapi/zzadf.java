package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.concurrent.Executor;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzadf  reason: invalid package */
/* loaded from: classes.dex */
public class zzadf {
    zzace zza;
    Executor zzb;

    public final <ResultT> Task<ResultT> zza(final zzadh<ResultT> zzadhVar) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.zzb.execute(new Runnable() { // from class: com.google.android.gms.internal.firebase-auth-api.zzadi
            @Override // java.lang.Runnable
            public final void run() {
                zzadhVar.zza(taskCompletionSource, zzadf.this.zza);
            }
        });
        return taskCompletionSource.getTask();
    }
}
