package com.google.android.gms.maps;

import android.os.RemoteException;
import com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate;
import com.google.android.gms.maps.internal.zzbs;
/* compiled from: com.google.android.gms:play-services-maps@@18.2.0 */
/* loaded from: classes.dex */
final class zzax extends zzbs {
    final /* synthetic */ OnStreetViewPanoramaReadyCallback zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzax(zzay zzayVar, OnStreetViewPanoramaReadyCallback onStreetViewPanoramaReadyCallback) {
        this.zza = onStreetViewPanoramaReadyCallback;
    }

    @Override // com.google.android.gms.maps.internal.zzbt
    public final void zzb(IStreetViewPanoramaDelegate iStreetViewPanoramaDelegate) throws RemoteException {
        this.zza.onStreetViewPanoramaReady(new StreetViewPanorama(iStreetViewPanoramaDelegate));
    }
}
