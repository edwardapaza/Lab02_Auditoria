package com.google.android.gms.internal.location;

import com.google.android.gms.common.api.internal.TaskUtil;
import com.google.android.gms.tasks.TaskCompletionSource;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-location@@21.2.0 */
/* loaded from: classes.dex */
public final class zzdn extends zzq {
    final /* synthetic */ Object zza;
    final /* synthetic */ TaskCompletionSource zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdn(Object obj, TaskCompletionSource taskCompletionSource) {
        this.zza = obj;
        this.zzb = taskCompletionSource;
    }

    @Override // com.google.android.gms.internal.location.zzr
    public final void zzd(zzl zzlVar) {
        TaskUtil.setResultOrApiException(zzlVar.getStatus(), this.zza, this.zzb);
    }

    @Override // com.google.android.gms.internal.location.zzr
    public final void zze() {
    }
}
