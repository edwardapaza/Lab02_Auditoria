package com.google.android.gms.internal.location;

import android.location.Location;
import com.google.android.gms.common.api.internal.ListenerHolder;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-location@@21.2.0 */
/* loaded from: classes.dex */
public final class zzdy extends com.google.android.gms.location.zzy {
    private final zzdr zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdy(zzdr zzdrVar) {
        this.zza = zzdrVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzdy zzc(ListenerHolder listenerHolder) {
        this.zza.zzb(listenerHolder);
        return this;
    }

    @Override // com.google.android.gms.location.zzz
    public final void zzd(Location location) {
        this.zza.zza().notifyListener(new zzdw(this, location));
    }

    @Override // com.google.android.gms.location.zzz
    public final void zze() {
        this.zza.zza().notifyListener(new zzdx(this));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzf() {
        this.zza.zza().clear();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzdr zzg() {
        return this.zza;
    }
}
