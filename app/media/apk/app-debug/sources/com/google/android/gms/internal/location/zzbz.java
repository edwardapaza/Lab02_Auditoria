package com.google.android.gms.internal.location;

import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.tasks.TaskCompletionSource;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-location@@21.2.0 */
/* loaded from: classes.dex */
public final /* synthetic */ class zzbz implements zzbg {
    static final /* synthetic */ zzbz zza = new zzbz();

    private /* synthetic */ zzbz() {
    }

    @Override // com.google.android.gms.internal.location.zzbg
    public final /* synthetic */ void zza(zzdz zzdzVar, ListenerHolder.ListenerKey listenerKey, boolean z, TaskCompletionSource taskCompletionSource) {
        zzdzVar.zzw(listenerKey, z, taskCompletionSource);
    }
}
