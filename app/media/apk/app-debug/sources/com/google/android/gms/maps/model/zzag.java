package com.google.android.gms.maps.model;

import com.google.android.gms.internal.maps.zzao;
/* compiled from: com.google.android.gms:play-services-maps@@18.2.0 */
/* loaded from: classes.dex */
final class zzag extends zzao {
    final /* synthetic */ TileProvider zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzag(TileOverlayOptions tileOverlayOptions, TileProvider tileProvider) {
        this.zza = tileProvider;
    }

    @Override // com.google.android.gms.internal.maps.zzap
    public final Tile zzb(int i, int i2, int i3) {
        return this.zza.getTile(i, i2, i3);
    }
}
