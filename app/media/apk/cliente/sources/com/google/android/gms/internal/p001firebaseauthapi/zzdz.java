package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.android.gms.internal.p001firebaseauthapi.zzea;
import com.google.android.gms.internal.p001firebaseauthapi.zzux;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzdz  reason: invalid package */
/* loaded from: classes.dex */
public final class zzdz {
    private static final zzoe<zzdv, zzbh> zza = zzoe.zza(new zzog() { // from class: com.google.android.gms.internal.firebase-auth-api.zzdy
        @Override // com.google.android.gms.internal.p001firebaseauthapi.zzog
        public final Object zza(zzbu zzbuVar) {
            return zzwb.zza((zzdv) zzbuVar);
        }
    }, zzdv.class, zzbh.class);
    private static final zzbt<zzbh> zzb = zznd.zza("type.googleapis.com/google.crypto.tink.AesEaxKey", zzbh.class, zzux.zzb.SYMMETRIC, zzso.zzf());
    private static final zznn<zzea> zzc = new zznn() { // from class: com.google.android.gms.internal.firebase-auth-api.zzeb
        @Override // com.google.android.gms.internal.p001firebaseauthapi.zznn
        public final zzbu zza(zzci zzciVar, Integer num) {
            return zzdz.zza((zzea) zzciVar, null);
        }
    };

    public static /* synthetic */ zzdv zza(zzea zzeaVar, Integer num) {
        if (zzeaVar.zzc() != 24) {
            return zzdv.zzb().zza(zzeaVar).zza(num).zza(zzxt.zza(zzeaVar.zzc())).zza();
        }
        throw new GeneralSecurityException("192 bit AES GCM Parameters are not valid");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String zza() {
        return "type.googleapis.com/google.crypto.tink.AesEaxKey";
    }

    public static void zza(boolean z4) {
        zzef.zza();
        zzns.zza().zza(zza);
        zznt zza2 = zznt.zza();
        HashMap hashMap = new HashMap();
        hashMap.put("AES128_EAX", zzgr.zzc);
        zzea.zza zzc2 = zzea.zze().zza(16).zzb(16).zzc(16);
        zzea.zzb zzbVar = zzea.zzb.zzc;
        hashMap.put("AES128_EAX_RAW", zzc2.zza(zzbVar).zza());
        hashMap.put("AES256_EAX", zzgr.zzd);
        hashMap.put("AES256_EAX_RAW", zzea.zze().zza(16).zzb(32).zzc(16).zza(zzbVar).zza());
        zza2.zza(Collections.unmodifiableMap(hashMap));
        zznk.zza().zza(zzc, zzea.class);
        zzcu.zza((zzbt) zzb, true);
    }
}
