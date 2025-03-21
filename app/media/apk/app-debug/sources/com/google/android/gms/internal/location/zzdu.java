package com.google.android.gms.internal.location;

import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.location.LocationCallback;
/* compiled from: com.google.android.gms:play-services-location@@21.2.0 */
/* loaded from: classes.dex */
final class zzdu implements ListenerHolder.Notifier {
    final /* synthetic */ zzdv zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdu(zzdv zzdvVar) {
        this.zza = zzdvVar;
    }

    @Override // com.google.android.gms.common.api.internal.ListenerHolder.Notifier
    public final /* bridge */ /* synthetic */ void notifyListener(Object obj) {
        LocationCallback locationCallback = (LocationCallback) obj;
        this.zza.zzh().zzc();
    }

    @Override // com.google.android.gms.common.api.internal.ListenerHolder.Notifier
    public final void onNotifyListenerFailed() {
    }
}
