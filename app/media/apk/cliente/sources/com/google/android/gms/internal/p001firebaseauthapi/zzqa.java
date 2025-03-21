package com.google.android.gms.internal.p001firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.List;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzqa  reason: invalid package */
/* loaded from: classes.dex */
public final class zzqa implements zzcq<zzpx, zzpx> {
    private static final zzqa zza = new zzqa();

    private zzqa() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zzc() {
        zzcu.zza(zza);
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzcq
    public final Class<zzpx> zza() {
        return zzpx.class;
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzcq
    public final /* synthetic */ zzpx zza(zzch<zzpx> zzchVar) {
        if (zzchVar != null) {
            if (zzchVar.zza() != null) {
                for (List<zzcm<zzpx>> list : zzchVar.zzd()) {
                    for (zzcm<zzpx> zzcmVar : list) {
                        zzcmVar.zze();
                    }
                }
                return new zzpz(zzchVar);
            }
            throw new GeneralSecurityException("no primary in primitive set");
        }
        throw new GeneralSecurityException("primitive set must be non-null");
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzcq
    public final Class<zzpx> zzb() {
        return zzpx.class;
    }
}
