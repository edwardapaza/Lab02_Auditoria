package com.google.android.gms.internal.p000authapiphone;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.g;
import com.google.android.gms.common.api.internal.s;
import com.google.android.gms.common.internal.b;
import com.google.android.gms.tasks.TaskCompletionSource;
/* renamed from: com.google.android.gms.internal.auth-api-phone.zzq  reason: invalid package */
/* loaded from: classes.dex */
final class zzq extends g.a {
    private final /* synthetic */ TaskCompletionSource zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzq(zzn zznVar, TaskCompletionSource taskCompletionSource) {
        this.zza = taskCompletionSource;
    }

    @Override // com.google.android.gms.common.api.internal.g
    public final void onResult(Status status) {
        if (status.u() == 6) {
            this.zza.trySetException(b.a(status));
        } else {
            s.a(status, this.zza);
        }
    }
}
