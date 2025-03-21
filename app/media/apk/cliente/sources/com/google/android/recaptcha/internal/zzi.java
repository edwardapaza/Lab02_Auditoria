package com.google.android.recaptcha.internal;

import com.google.android.gms.tasks.RuntimeExecutionException;
import com.google.android.gms.tasks.TaskCompletionSource;
import e4.l;
import java.util.concurrent.CancellationException;
import m4.q0;
import s3.t;
/* loaded from: classes.dex */
final class zzi extends l implements d4.l {
    final /* synthetic */ TaskCompletionSource zza;
    final /* synthetic */ q0 zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzi(TaskCompletionSource taskCompletionSource, q0 q0Var) {
        super(1);
        this.zza = taskCompletionSource;
        this.zzb = q0Var;
    }

    @Override // d4.l
    public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
        Throwable th = (Throwable) obj;
        if (th instanceof CancellationException) {
            this.zza.setException((Exception) th);
        } else {
            Throwable w5 = this.zzb.w();
            if (w5 == null) {
                this.zza.setResult(this.zzb.i());
            } else {
                TaskCompletionSource taskCompletionSource = this.zza;
                Exception exc = w5 instanceof Exception ? (Exception) w5 : null;
                if (exc == null) {
                    exc = new RuntimeExecutionException(w5);
                }
                taskCompletionSource.setException(exc);
            }
        }
        return t.f7573a;
    }
}
