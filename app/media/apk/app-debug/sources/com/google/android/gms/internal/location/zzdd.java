package com.google.android.gms.internal.location;

import android.os.RemoteException;
import com.google.android.gms.common.api.internal.TaskUtil;
import com.google.android.gms.tasks.TaskCompletionSource;
/* compiled from: com.google.android.gms:play-services-location@@21.2.0 */
/* loaded from: classes.dex */
final class zzdd extends zzq {
    final /* synthetic */ TaskCompletionSource zza;
    final /* synthetic */ com.google.android.gms.location.zzw zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdd(TaskCompletionSource taskCompletionSource, com.google.android.gms.location.zzw zzwVar) {
        this.zza = taskCompletionSource;
        this.zzb = zzwVar;
    }

    @Override // com.google.android.gms.internal.location.zzr
    public final void zzd(zzl zzlVar) {
        TaskUtil.setResultOrApiException(zzlVar.getStatus(), this.zza);
    }

    @Override // com.google.android.gms.internal.location.zzr
    public final void zze() throws RemoteException {
        this.zzb.zzf();
    }
}
