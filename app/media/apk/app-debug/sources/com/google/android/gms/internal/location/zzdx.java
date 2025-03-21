package com.google.android.gms.internal.location;

import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.location.LocationListener;
/* compiled from: com.google.android.gms:play-services-location@@21.2.0 */
/* loaded from: classes.dex */
final class zzdx implements ListenerHolder.Notifier {
    final /* synthetic */ zzdy zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdx(zzdy zzdyVar) {
        this.zza = zzdyVar;
    }

    @Override // com.google.android.gms.common.api.internal.ListenerHolder.Notifier
    public final /* bridge */ /* synthetic */ void notifyListener(Object obj) {
        LocationListener locationListener = (LocationListener) obj;
        this.zza.zzg().zzc();
    }

    @Override // com.google.android.gms.common.api.internal.ListenerHolder.Notifier
    public final void onNotifyListenerFailed() {
    }
}
