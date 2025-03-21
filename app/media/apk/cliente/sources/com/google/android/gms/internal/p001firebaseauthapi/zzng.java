package com.google.android.gms.internal.p001firebaseauthapi;

import java.security.GeneralSecurityException;
import java.util.List;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzng  reason: invalid package */
/* loaded from: classes.dex */
public final class zzng {
    public static final zzrp zza = new zzni();

    public static <P> zzrs zza(zzch<P> zzchVar) {
        zzbw zzbwVar;
        zzrr zzrrVar = new zzrr();
        zzrrVar.zza(zzchVar.zzb());
        for (List<zzcm<P>> list : zzchVar.zzd()) {
            for (zzcm<P> zzcmVar : list) {
                int i5 = zznj.zza[zzcmVar.zzc().ordinal()];
                if (i5 == 1) {
                    zzbwVar = zzbw.zza;
                } else if (i5 == 2) {
                    zzbwVar = zzbw.zzb;
                } else if (i5 != 3) {
                    throw new IllegalStateException("Unknown key status");
                } else {
                    zzbwVar = zzbw.zzc;
                }
                int zza2 = zzcmVar.zza();
                String zzg = zzcmVar.zzg();
                if (zzg.startsWith("type.googleapis.com/google.crypto.")) {
                    zzg = zzg.substring(34);
                }
                zzrrVar.zza(zzbwVar, zza2, zzg, zzcmVar.zzd().name());
            }
        }
        if (zzchVar.zza() != null) {
            zzrrVar.zza(zzchVar.zza().zza());
        }
        try {
            return zzrrVar.zza();
        } catch (GeneralSecurityException e5) {
            throw new IllegalStateException(e5);
        }
    }
}
