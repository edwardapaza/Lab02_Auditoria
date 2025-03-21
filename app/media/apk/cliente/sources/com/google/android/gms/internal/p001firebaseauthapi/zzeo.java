package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.android.gms.internal.p001firebaseauthapi.zzer;
import com.google.android.gms.internal.p001firebaseauthapi.zzic;
import com.google.android.gms.internal.p001firebaseauthapi.zzux;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzeo  reason: invalid package */
/* loaded from: classes.dex */
public final class zzeo {
    private static final zzoe<zzek, zzbh> zza = zzoe.zza(new zzog() { // from class: com.google.android.gms.internal.firebase-auth-api.zzen
        @Override // com.google.android.gms.internal.p001firebaseauthapi.zzog
        public final Object zza(zzbu zzbuVar) {
            return zzwg.zza((zzek) zzbuVar);
        }
    }, zzek.class, zzbh.class);
    private static final zzbt<zzbh> zzb = zznd.zza(zzcx.zzb, zzbh.class, zzux.zzb.SYMMETRIC, zzst.zze());
    private static final zznp<zzer> zzc = new zznp() { // from class: com.google.android.gms.internal.firebase-auth-api.zzeq
    };
    private static final zznn<zzer> zzd = new zznn() { // from class: com.google.android.gms.internal.firebase-auth-api.zzep
        @Override // com.google.android.gms.internal.p001firebaseauthapi.zznn
        public final zzbu zza(zzci zzciVar, Integer num) {
            return zzeo.zza((zzer) zzciVar, null);
        }
    };

    public static /* synthetic */ zzek zza(zzer zzerVar, Integer num) {
        if (zzerVar.zzc() != 24) {
            return zzek.zzb().zza(zzerVar).zza(num).zza(zzxt.zza(zzerVar.zzc())).zza();
        }
        throw new GeneralSecurityException("192 bit AES GCM Parameters are not valid");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String zza() {
        return zzcx.zzb;
    }

    public static void zza(boolean z4) {
        zzhf.zza();
        zzns.zza().zza(zza);
        zznt zza2 = zznt.zza();
        HashMap hashMap = new HashMap();
        hashMap.put("AES128_GCM", zzgr.zza);
        zzer.zza zzc2 = zzer.zze().zza(12).zzb(16).zzc(16);
        zzer.zzb zzbVar = zzer.zzb.zzc;
        hashMap.put("AES128_GCM_RAW", zzc2.zza(zzbVar).zza());
        hashMap.put("AES256_GCM", zzgr.zzb);
        hashMap.put("AES256_GCM_RAW", zzer.zze().zza(12).zzb(32).zzc(16).zza(zzbVar).zza());
        zza2.zza(Collections.unmodifiableMap(hashMap));
        zznm.zza().zza(zzc, zzer.class);
        zznk.zza().zza(zzd, zzer.class);
        zzmn.zza().zza((zzbt) zzb, zzic.zza.zzb, true);
    }
}
