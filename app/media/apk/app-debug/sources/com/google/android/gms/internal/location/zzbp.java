package com.google.android.gms.internal.location;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.location.CurrentLocationRequest;
import com.google.android.gms.tasks.CancellationToken;
import com.google.android.gms.tasks.TaskCompletionSource;
/* compiled from: com.google.android.gms:play-services-location@@21.2.0 */
/* loaded from: classes.dex */
final /* synthetic */ class zzbp implements RemoteCall {
    private final /* synthetic */ CurrentLocationRequest zza;
    private final /* synthetic */ CancellationToken zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzbp(CurrentLocationRequest currentLocationRequest, CancellationToken cancellationToken) {
        this.zza = currentLocationRequest;
        this.zzb = cancellationToken;
    }

    @Override // com.google.android.gms.common.api.internal.RemoteCall
    public final /* synthetic */ void accept(Object obj, Object obj2) {
        Api api = zzbi.zzb;
        ((zzdz) obj).zzr(this.zza, this.zzb, (TaskCompletionSource) obj2);
    }
}
