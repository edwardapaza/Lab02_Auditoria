package com.google.android.gms.maps;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-maps@@18.2.0 */
/* loaded from: classes.dex */
public final class zzd extends com.google.android.gms.maps.internal.zzag {
    final /* synthetic */ GoogleMap.OnInfoWindowLongClickListener zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzd(GoogleMap googleMap, GoogleMap.OnInfoWindowLongClickListener onInfoWindowLongClickListener) {
        this.zza = onInfoWindowLongClickListener;
    }

    @Override // com.google.android.gms.maps.internal.zzah
    public final void zzb(com.google.android.gms.internal.maps.zzad zzadVar) {
        this.zza.onInfoWindowLongClick(new Marker(zzadVar));
    }
}
