package com.google.android.recaptcha.internal;

import com.google.android.gms.tasks.CancellationTokenSource;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import m4.q0;
/* loaded from: classes.dex */
public final class zzj {
    public static final Task zza(q0 q0Var) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource(new CancellationTokenSource().getToken());
        q0Var.O(new zzi(taskCompletionSource, q0Var));
        return taskCompletionSource.getTask();
    }
}
