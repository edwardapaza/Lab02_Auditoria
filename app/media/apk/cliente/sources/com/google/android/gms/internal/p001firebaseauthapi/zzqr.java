package com.google.android.gms.internal.p001firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.List;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzqr  reason: invalid package */
/* loaded from: classes.dex */
final class zzqr implements zzcq<zzcf, zzcf> {
    private static final zzqr zza = new zzqr();
    private static final zzoe<zznc, zzcf> zzb = zzoe.zza(new zzog() { // from class: com.google.android.gms.internal.firebase-auth-api.zzqu
        @Override // com.google.android.gms.internal.p001firebaseauthapi.zzog
        public final Object zza(zzbu zzbuVar) {
            return zzrj.zza((zznc) zzbuVar);
        }
    }, zznc.class, zzcf.class);

    zzqr() {
    }

    public static void zzc() {
        zzcu.zza(zza);
        zzns.zza().zza(zzb);
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzcq
    public final Class<zzcf> zza() {
        return zzcf.class;
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzcq
    public final /* synthetic */ zzcf zza(zzch<zzcf> zzchVar) {
        for (List<zzcm<zzcf>> list : zzchVar.zzd()) {
            for (zzcm<zzcf> zzcmVar : list) {
                if (zzcmVar.zzb() instanceof zzqp) {
                    zzqp zzqpVar = (zzqp) zzcmVar.zzb();
                    zzxr zza2 = zzxr.zza(zzcmVar.zzh());
                    if (!zza2.equals(zzqpVar.zzd())) {
                        String valueOf = String.valueOf(zzqpVar.zzc());
                        String valueOf2 = String.valueOf(zzqpVar.zzd());
                        String valueOf3 = String.valueOf(zza2);
                        throw new GeneralSecurityException("Mac Key with parameters " + valueOf + " has wrong output prefix (" + valueOf2 + ") instead of (" + valueOf3 + ")");
                    }
                }
            }
        }
        return new zzqt(zzchVar);
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzcq
    public final Class<zzcf> zzb() {
        return zzcf.class;
    }
}
