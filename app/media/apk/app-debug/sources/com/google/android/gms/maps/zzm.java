package com.google.android.gms.maps;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.GroundOverlay;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-maps@@18.2.0 */
/* loaded from: classes.dex */
public final class zzm extends com.google.android.gms.maps.internal.zzy {
    final /* synthetic */ GoogleMap.OnGroundOverlayClickListener zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzm(GoogleMap googleMap, GoogleMap.OnGroundOverlayClickListener onGroundOverlayClickListener) {
        this.zza = onGroundOverlayClickListener;
    }

    @Override // com.google.android.gms.maps.internal.zzz
    public final void zzb(com.google.android.gms.internal.maps.zzr zzrVar) {
        this.zza.onGroundOverlayClick(new GroundOverlay(zzrVar));
    }
}
