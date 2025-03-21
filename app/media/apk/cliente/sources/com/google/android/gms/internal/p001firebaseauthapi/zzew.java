package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.android.gms.internal.p001firebaseauthapi.zzfa;
import com.google.android.gms.internal.p001firebaseauthapi.zzux;
import java.security.NoSuchAlgorithmException;
import java.util.Collections;
import java.util.HashMap;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzew  reason: invalid package */
/* loaded from: classes.dex */
public final class zzew {
    private static final zzoe<zzet, zzbh> zza = zzoe.zza(new zzog() { // from class: com.google.android.gms.internal.firebase-auth-api.zzez
        @Override // com.google.android.gms.internal.p001firebaseauthapi.zzog
        public final Object zza(zzbu zzbuVar) {
            return zzia.zza((zzet) zzbuVar);
        }
    }, zzet.class, zzbh.class);
    private static final zznn<zzfa> zzb = new zznn() { // from class: com.google.android.gms.internal.firebase-auth-api.zzey
        @Override // com.google.android.gms.internal.p001firebaseauthapi.zznn
        public final zzbu zza(zzci zzciVar, Integer num) {
            zzet zza2;
            zza2 = zzet.zzb().zza(r1).zza((Integer) null).zza(zzxt.zza(((zzfa) zzciVar).zzb())).zza();
            return zza2;
        }
    };
    private static final zznp<zzfa> zzc = new zznp() { // from class: com.google.android.gms.internal.firebase-auth-api.zzfb
    };
    private static final zzbt<zzbh> zzd = zznd.zza("type.googleapis.com/google.crypto.tink.AesGcmSivKey", zzbh.class, zzux.zzb.SYMMETRIC, zzsx.zze());

    public static void zza(boolean z4) {
        zzff.zza();
        if (zza()) {
            zzns.zza().zza(zza);
            zznt zza2 = zznt.zza();
            HashMap hashMap = new HashMap();
            zzfa.zza zza3 = zzfa.zzc().zza(16);
            zzfa.zzb zzbVar = zzfa.zzb.zza;
            hashMap.put("AES128_GCM_SIV", zza3.zza(zzbVar).zza());
            zzfa.zza zza4 = zzfa.zzc().zza(16);
            zzfa.zzb zzbVar2 = zzfa.zzb.zzc;
            hashMap.put("AES128_GCM_SIV_RAW", zza4.zza(zzbVar2).zza());
            hashMap.put("AES256_GCM_SIV", zzfa.zzc().zza(32).zza(zzbVar).zza());
            hashMap.put("AES256_GCM_SIV_RAW", zzfa.zzc().zza(32).zza(zzbVar2).zza());
            zza2.zza(Collections.unmodifiableMap(hashMap));
            zznm.zza().zza(zzc, zzfa.class);
            zznk.zza().zza(zzb, zzfa.class);
            zzcu.zza((zzbt) zzd, true);
        }
    }

    private static boolean zza() {
        try {
            Cipher.getInstance("AES/GCM-SIV/NoPadding");
            return true;
        } catch (NoSuchAlgorithmException | NoSuchPaddingException unused) {
            return false;
        }
    }
}
