package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.android.gms.internal.p001firebaseauthapi.zziq;
import com.google.android.gms.internal.p001firebaseauthapi.zzux;
import java.security.InvalidAlgorithmParameterException;
import java.util.Collections;
import java.util.HashMap;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzin  reason: invalid package */
/* loaded from: classes.dex */
public final class zzin {
    private static final zzoe<zzij, zzbq> zza = zzoe.zza(new zzog() { // from class: com.google.android.gms.internal.firebase-auth-api.zzim
        @Override // com.google.android.gms.internal.p001firebaseauthapi.zzog
        public final Object zza(zzbu zzbuVar) {
            return zzin.zza((zzij) zzbuVar);
        }
    }, zzij.class, zzbq.class);
    private static final zzbt<zzbq> zzb = zznd.zza(zzis.zza, zzbq.class, zzux.zzb.SYMMETRIC, zztb.zze());
    private static final zznp<zziq> zzc = new zznp() { // from class: com.google.android.gms.internal.firebase-auth-api.zzip
    };
    private static final zznn<zziq> zzd = new zznn() { // from class: com.google.android.gms.internal.firebase-auth-api.zzio
        @Override // com.google.android.gms.internal.p001firebaseauthapi.zznn
        public final zzbu zza(zzci zzciVar, Integer num) {
            return zzin.zza((zziq) zzciVar, null);
        }
    };

    public static /* synthetic */ zzbq zza(zzij zzijVar) {
        zza(zzijVar.zzc());
        return zzwf.zza(zzijVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzij zza(zziq zziqVar, Integer num) {
        zza(zziqVar);
        return zzij.zzb().zza(zziqVar).zza(num).zza(zzxt.zza(zziqVar.zzb())).zza();
    }

    private static void zza(zziq zziqVar) {
        if (zziqVar.zzb() == 64) {
            return;
        }
        int zzb2 = zziqVar.zzb();
        throw new InvalidAlgorithmParameterException("invalid key size: " + zzb2 + ". Valid keys must have 64 bytes.");
    }

    public static void zza(boolean z4) {
        zzjb.zza();
        zzns.zza().zza(zza);
        zznt zza2 = zznt.zza();
        HashMap hashMap = new HashMap();
        hashMap.put("AES256_SIV", zziz.zza);
        hashMap.put("AES256_SIV_RAW", zziq.zzc().zza(64).zza(zziq.zzb.zzc).zza());
        zza2.zza(Collections.unmodifiableMap(hashMap));
        zznm.zza().zza(zzc, zziq.class);
        zznk.zza().zza(zzd, zziq.class);
        zzcu.zza((zzbt) zzb, true);
    }
}
