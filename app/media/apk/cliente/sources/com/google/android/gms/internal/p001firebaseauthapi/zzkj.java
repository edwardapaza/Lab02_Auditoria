package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.android.gms.internal.p001firebaseauthapi.zzdm;
import com.google.android.gms.internal.p001firebaseauthapi.zzer;
import com.google.android.gms.internal.p001firebaseauthapi.zzjl;
import com.google.android.gms.internal.p001firebaseauthapi.zzjx;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzkj  reason: invalid package */
/* loaded from: classes.dex */
public final class zzkj {
    private static final String zza = "type.googleapis.com/google.crypto.tink.EciesAeadHkdfPublicKey";
    private static final String zzb = "type.googleapis.com/google.crypto.tink.EciesAeadHkdfPrivateKey";
    @Deprecated
    private static final zzvv zzc = zzvv.zzb();
    @Deprecated
    private static final zzvv zzd = zzvv.zzb();
    @Deprecated
    private static final zzvv zze = zzvv.zzb();

    static {
        try {
            zza();
        } catch (GeneralSecurityException e5) {
            throw new ExceptionInInitializerError(e5);
        }
    }

    public static void zza() {
        zzkm.zzc();
        zzko.zzc();
        zzcx.zza();
        zzis.zza();
        if (zzic.zzb()) {
            return;
        }
        zzcu.zza((zzoq) new zzje(), (zznb) new zzjj(), true);
        zzjq.zza();
        zznt zza2 = zznt.zza();
        HashMap hashMap = new HashMap();
        zzjl.zza zzc2 = zzjl.zzc();
        zzjl.zzc zzcVar = zzjl.zzc.zza;
        zzjl.zza zza3 = zzc2.zza(zzcVar);
        zzjl.zzb zzbVar = zzjl.zzb.zzc;
        zzjl.zza zza4 = zza3.zza(zzbVar);
        zzjl.zze zzeVar = zzjl.zze.zzb;
        zzjl.zza zza5 = zza4.zza(zzeVar);
        zzjl.zzd zzdVar = zzjl.zzd.zza;
        zzjl.zza zza6 = zza5.zza(zzdVar);
        zzer.zza zzc3 = zzer.zze().zza(12).zzb(16).zzc(16);
        zzer.zzb zzbVar2 = zzer.zzb.zzc;
        hashMap.put("ECIES_P256_HKDF_HMAC_SHA256_AES128_GCM", zza6.zza(zzc3.zza(zzbVar2).zza()).zza());
        zzjl.zza zza7 = zzjl.zzc().zza(zzcVar).zza(zzbVar).zza(zzeVar);
        zzjl.zzd zzdVar2 = zzjl.zzd.zzc;
        hashMap.put("ECIES_P256_HKDF_HMAC_SHA256_AES128_GCM_RAW", zza7.zza(zzdVar2).zza(zzer.zze().zza(12).zzb(16).zzc(16).zza(zzbVar2).zza()).zza());
        zzjl.zza zza8 = zzjl.zzc().zza(zzcVar).zza(zzbVar);
        zzjl.zze zzeVar2 = zzjl.zze.zza;
        hashMap.put("ECIES_P256_COMPRESSED_HKDF_HMAC_SHA256_AES128_GCM", zza8.zza(zzeVar2).zza(zzdVar).zza(zzer.zze().zza(12).zzb(16).zzc(16).zza(zzbVar2).zza()).zza());
        hashMap.put("ECIES_P256_COMPRESSED_HKDF_HMAC_SHA256_AES128_GCM_RAW", zzjl.zzc().zza(zzcVar).zza(zzbVar).zza(zzeVar2).zza(zzdVar2).zza(zzer.zze().zza(12).zzb(16).zzc(16).zza(zzbVar2).zza()).zza());
        hashMap.put("ECIES_P256_HKDF_HMAC_SHA256_AES128_GCM_COMPRESSED_WITHOUT_PREFIX", zzjl.zzc().zza(zzcVar).zza(zzbVar).zza(zzeVar2).zza(zzdVar2).zza(zzer.zze().zza(12).zzb(16).zzc(16).zza(zzbVar2).zza()).zza());
        zzjl.zza zza9 = zzjl.zzc().zza(zzcVar).zza(zzbVar).zza(zzeVar).zza(zzdVar);
        zzdm.zza zzc4 = zzdm.zzf().zza(16).zzb(32).zzd(16).zzc(16);
        zzdm.zzb zzbVar3 = zzdm.zzb.zzc;
        zzdm.zza zza10 = zzc4.zza(zzbVar3);
        zzdm.zzc zzcVar2 = zzdm.zzc.zzc;
        hashMap.put("ECIES_P256_HKDF_HMAC_SHA256_AES128_CTR_HMAC_SHA256", zza9.zza(zza10.zza(zzcVar2).zza()).zza());
        hashMap.put("ECIES_P256_HKDF_HMAC_SHA256_AES128_CTR_HMAC_SHA256_RAW", zzjl.zzc().zza(zzcVar).zza(zzbVar).zza(zzeVar).zza(zzdVar2).zza(zzdm.zzf().zza(16).zzb(32).zzd(16).zzc(16).zza(zzbVar3).zza(zzcVar2).zza()).zza());
        hashMap.put("ECIES_P256_COMPRESSED_HKDF_HMAC_SHA256_AES128_CTR_HMAC_SHA256", zzjl.zzc().zza(zzcVar).zza(zzbVar).zza(zzeVar2).zza(zzdVar).zza(zzdm.zzf().zza(16).zzb(32).zzd(16).zzc(16).zza(zzbVar3).zza(zzcVar2).zza()).zza());
        hashMap.put("ECIES_P256_COMPRESSED_HKDF_HMAC_SHA256_AES128_CTR_HMAC_SHA256_RAW", zzjl.zzc().zza(zzcVar).zza(zzbVar).zza(zzeVar2).zza(zzdVar2).zza(zzdm.zzf().zza(16).zzb(32).zzd(16).zzc(16).zza(zzbVar3).zza(zzcVar2).zza()).zza());
        zza2.zza(Collections.unmodifiableMap(hashMap));
        zzcu.zza((zzoq) new zzlk(), (zznb) new zzlo(), true);
        zzkb.zza();
        zznt zza11 = zznt.zza();
        HashMap hashMap2 = new HashMap();
        zzjx.zzc zzc5 = zzjx.zzc();
        zzjx.zzf zzfVar = zzjx.zzf.zza;
        zzjx.zzc zza12 = zzc5.zza(zzfVar);
        zzjx.zzd zzdVar3 = zzjx.zzd.zzd;
        zzjx.zzc zza13 = zza12.zza(zzdVar3);
        zzjx.zze zzeVar3 = zzjx.zze.zza;
        zzjx.zzc zza14 = zza13.zza(zzeVar3);
        zzjx.zza zzaVar = zzjx.zza.zza;
        hashMap2.put("DHKEM_X25519_HKDF_SHA256_HKDF_SHA256_AES_128_GCM", zza14.zza(zzaVar).zza());
        zzjx.zzc zzc6 = zzjx.zzc();
        zzjx.zzf zzfVar2 = zzjx.zzf.zzc;
        hashMap2.put("DHKEM_X25519_HKDF_SHA256_HKDF_SHA256_AES_128_GCM_RAW", zzc6.zza(zzfVar2).zza(zzdVar3).zza(zzeVar3).zza(zzaVar).zza());
        zzjx.zzc zza15 = zzjx.zzc().zza(zzfVar).zza(zzdVar3).zza(zzeVar3);
        zzjx.zza zzaVar2 = zzjx.zza.zzb;
        hashMap2.put("DHKEM_X25519_HKDF_SHA256_HKDF_SHA256_AES_256_GCM", zza15.zza(zzaVar2).zza());
        hashMap2.put("DHKEM_X25519_HKDF_SHA256_HKDF_SHA256_AES_256_GCM_RAW", zzjx.zzc().zza(zzfVar2).zza(zzdVar3).zza(zzeVar3).zza(zzaVar2).zza());
        zzjx.zzc zza16 = zzjx.zzc().zza(zzfVar).zza(zzdVar3).zza(zzeVar3);
        zzjx.zza zzaVar3 = zzjx.zza.zzc;
        hashMap2.put("DHKEM_X25519_HKDF_SHA256_HKDF_SHA256_CHACHA20_POLY1305", zza16.zza(zzaVar3).zza());
        hashMap2.put("DHKEM_X25519_HKDF_SHA256_HKDF_SHA256_CHACHA20_POLY1305_RAW", zzjx.zzc().zza(zzfVar2).zza(zzdVar3).zza(zzeVar3).zza(zzaVar3).zza());
        zzjx.zzc zza17 = zzjx.zzc().zza(zzfVar);
        zzjx.zzd zzdVar4 = zzjx.zzd.zza;
        hashMap2.put("DHKEM_P256_HKDF_SHA256_HKDF_SHA256_AES_128_GCM", zza17.zza(zzdVar4).zza(zzeVar3).zza(zzaVar).zza());
        hashMap2.put("DHKEM_P256_HKDF_SHA256_HKDF_SHA256_AES_128_GCM_RAW", zzjx.zzc().zza(zzfVar2).zza(zzdVar4).zza(zzeVar3).zza(zzaVar).zza());
        hashMap2.put("DHKEM_P256_HKDF_SHA256_HKDF_SHA256_AES_256_GCM", zzjx.zzc().zza(zzfVar).zza(zzdVar4).zza(zzeVar3).zza(zzaVar2).zza());
        hashMap2.put("DHKEM_P256_HKDF_SHA256_HKDF_SHA256_AES_256_GCM_RAW", zzjx.zzc().zza(zzfVar2).zza(zzdVar4).zza(zzeVar3).zza(zzaVar2).zza());
        zzjx.zzc zza18 = zzjx.zzc().zza(zzfVar);
        zzjx.zzd zzdVar5 = zzjx.zzd.zzb;
        zzjx.zzc zza19 = zza18.zza(zzdVar5);
        zzjx.zze zzeVar4 = zzjx.zze.zzb;
        hashMap2.put("DHKEM_P384_HKDF_SHA384_HKDF_SHA384_AES_128_GCM", zza19.zza(zzeVar4).zza(zzaVar).zza());
        hashMap2.put("DHKEM_P384_HKDF_SHA384_HKDF_SHA384_AES_128_GCM_RAW", zzjx.zzc().zza(zzfVar2).zza(zzdVar5).zza(zzeVar4).zza(zzaVar).zza());
        hashMap2.put("DHKEM_P384_HKDF_SHA384_HKDF_SHA384_AES_256_GCM", zzjx.zzc().zza(zzfVar).zza(zzdVar5).zza(zzeVar4).zza(zzaVar2).zza());
        hashMap2.put("DHKEM_P384_HKDF_SHA384_HKDF_SHA384_AES_256_GCM_RAW", zzjx.zzc().zza(zzfVar2).zza(zzdVar5).zza(zzeVar4).zza(zzaVar2).zza());
        zzjx.zzc zza20 = zzjx.zzc().zza(zzfVar);
        zzjx.zzd zzdVar6 = zzjx.zzd.zzc;
        zzjx.zzc zza21 = zza20.zza(zzdVar6);
        zzjx.zze zzeVar5 = zzjx.zze.zzc;
        hashMap2.put("DHKEM_P521_HKDF_SHA512_HKDF_SHA512_AES_128_GCM", zza21.zza(zzeVar5).zza(zzaVar).zza());
        hashMap2.put("DHKEM_P521_HKDF_SHA512_HKDF_SHA512_AES_128_GCM_RAW", zzjx.zzc().zza(zzfVar2).zza(zzdVar6).zza(zzeVar5).zza(zzaVar).zza());
        hashMap2.put("DHKEM_P521_HKDF_SHA512_HKDF_SHA512_AES_256_GCM", zzjx.zzc().zza(zzfVar).zza(zzdVar6).zza(zzeVar5).zza(zzaVar2).zza());
        hashMap2.put("DHKEM_P521_HKDF_SHA512_HKDF_SHA512_AES_256_GCM_RAW", zzjx.zzc().zza(zzfVar2).zza(zzdVar6).zza(zzeVar5).zza(zzaVar2).zza());
        zza11.zza(Collections.unmodifiableMap(hashMap2));
    }
}
