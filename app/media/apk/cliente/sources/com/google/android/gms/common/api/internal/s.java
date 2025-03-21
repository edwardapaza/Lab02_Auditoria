package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.TaskCompletionSource;
/* loaded from: classes.dex */
public class s {
    public static void a(Status status, TaskCompletionSource<Void> taskCompletionSource) {
        b(status, null, taskCompletionSource);
    }

    public static <TResult> void b(Status status, TResult tresult, TaskCompletionSource<TResult> taskCompletionSource) {
        if (status.x()) {
            taskCompletionSource.setResult(tresult);
        } else {
            taskCompletionSource.setException(new com.google.android.gms.common.api.b(status));
        }
    }
}
