package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.android.gms.internal.p001firebaseauthapi.zzdm;
import com.google.android.gms.internal.p001firebaseauthapi.zzic;
import com.google.android.gms.internal.p001firebaseauthapi.zzux;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzdj  reason: invalid package */
/* loaded from: classes.dex */
public final class zzdj {
    private static final zzoe<zzdf, zzbh> zza = zzoe.zza(new zzog() { // from class: com.google.android.gms.internal.firebase-auth-api.zzdi
        @Override // com.google.android.gms.internal.p001firebaseauthapi.zzog
        public final Object zza(zzbu zzbuVar) {
            return zzws.zza((zzdf) zzbuVar);
        }
    }, zzdf.class, zzbh.class);
    private static final zzbt<zzbh> zzb = zznd.zza(zzcx.zza, zzbh.class, zzux.zzb.SYMMETRIC, zzsd.zzf());
    private static final zznp<zzdm> zzc = new zznp() { // from class: com.google.android.gms.internal.firebase-auth-api.zzdl
    };
    private static final zznn<zzdm> zzd = new zznn() { // from class: com.google.android.gms.internal.firebase-auth-api.zzdk
        @Override // com.google.android.gms.internal.p001firebaseauthapi.zznn
        public final zzbu zza(zzci zzciVar, Integer num) {
            return zzdj.zza((zzdm) zzciVar, null);
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzdf zza(zzdm zzdmVar, Integer num) {
        if (zzdmVar.zzb() == 16 || zzdmVar.zzb() == 32) {
            return zzdf.zzb().zza(zzdmVar).zza(num).zza(zzxt.zza(zzdmVar.zzb())).zzb(zzxt.zza(zzdmVar.zzc())).zza();
        }
        throw new GeneralSecurityException("AES key size must be 16 or 32 bytes");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String zza() {
        return zzcx.zza;
    }

    public static void zza(boolean z4) {
        zzdq.zza();
        zzns.zza().zza(zza);
        zznt zza2 = zznt.zza();
        HashMap hashMap = new HashMap();
        hashMap.put("AES128_CTR_HMAC_SHA256", zzgr.zze);
        zzdm.zza zzc2 = zzdm.zzf().zza(16).zzb(32).zzd(16).zzc(16);
        zzdm.zzb zzbVar = zzdm.zzb.zzc;
        zzdm.zza zza3 = zzc2.zza(zzbVar);
        zzdm.zzc zzcVar = zzdm.zzc.zzc;
        hashMap.put("AES128_CTR_HMAC_SHA256_RAW", zza3.zza(zzcVar).zza());
        hashMap.put("AES256_CTR_HMAC_SHA256", zzgr.zzf);
        hashMap.put("AES256_CTR_HMAC_SHA256_RAW", zzdm.zzf().zza(32).zzb(32).zzd(32).zzc(16).zza(zzbVar).zza(zzcVar).zza());
        zza2.zza(Collections.unmodifiableMap(hashMap));
        zznm.zza().zza(zzc, zzdm.class);
        zznk.zza().zza(zzd, zzdm.class);
        zzmn.zza().zza((zzbt) zzb, zzic.zza.zzb, true);
    }
}
