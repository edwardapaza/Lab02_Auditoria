package com.google.android.gms.internal.location;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.tasks.TaskCompletionSource;
/* compiled from: com.google.android.gms:play-services-location@@21.2.0 */
/* loaded from: classes.dex */
final /* synthetic */ class zzbr implements RemoteCall {
    static final /* synthetic */ zzbr zza = new zzbr();

    private /* synthetic */ zzbr() {
    }

    @Override // com.google.android.gms.common.api.internal.RemoteCall
    public final /* synthetic */ void accept(Object obj, Object obj2) {
        Api api = zzbi.zzb;
        ((zzdz) obj).zzp(com.google.android.gms.location.zzac.zza(), (TaskCompletionSource) obj2);
    }
}
