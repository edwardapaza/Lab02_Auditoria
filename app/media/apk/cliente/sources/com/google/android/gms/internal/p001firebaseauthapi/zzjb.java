package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.android.gms.internal.p001firebaseauthapi.zziq;
import com.google.android.gms.internal.p001firebaseauthapi.zzux;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzjb  reason: invalid package */
/* loaded from: classes.dex */
public final class zzjb {
    private static final zzxr zza;
    private static final zzoa<zziq, zzos> zzb;
    private static final zznw<zzos> zzc;
    private static final zzmx<zzij, zzot> zzd;
    private static final zzmt<zzot> zze;
    private static final Map<zziq.zzb, zzvt> zzf;
    private static final Map<zzvt, zziq.zzb> zzg;

    static {
        zzxr zzb2 = zzpg.zzb(zzis.zza);
        zza = zzb2;
        zzb = zzoa.zza(new zzoc() { // from class: com.google.android.gms.internal.firebase-auth-api.zzja
            @Override // com.google.android.gms.internal.p001firebaseauthapi.zzoc
            public final zzow zza(zzci zzciVar) {
                zzos zzb3;
                zzb3 = zzos.zzb((zzvd) ((zzaja) zzvd.zza().zza(zzis.zza).zza(((zzte) ((zzaja) zzte.zzc().zza(r1.zzb()).zzf())).zzi()).zza(zzjb.zza(((zziq) zzciVar).zzd())).zzf()));
                return zzb3;
            }
        }, zziq.class, zzos.class);
        zzc = zznw.zza(new zzny() { // from class: com.google.android.gms.internal.firebase-auth-api.zzjd
            @Override // com.google.android.gms.internal.p001firebaseauthapi.zzny
            public final zzci zza(zzow zzowVar) {
                zziq zzb3;
                zzb3 = zzjb.zzb((zzos) zzowVar);
                return zzb3;
            }
        }, zzb2, zzos.class);
        zzd = zzmx.zza(new zzmz() { // from class: com.google.android.gms.internal.firebase-auth-api.zzjc
            @Override // com.google.android.gms.internal.p001firebaseauthapi.zzmz
            public final zzow zza(zzbu zzbuVar, zzct zzctVar) {
                zzot zza2;
                zza2 = zzot.zza(zzis.zza, ((zztb) ((zzaja) zztb.zzb().zza(zzahm.zza(r1.zze().zza(zzct.zza(zzctVar)))).zzf())).zzi(), zzux.zzb.SYMMETRIC, zzjb.zza(r1.zzc().zzd()), ((zzij) zzbuVar).zza());
                return zza2;
            }
        }, zzij.class, zzot.class);
        zze = zzmt.zza(new zzmv() { // from class: com.google.android.gms.internal.firebase-auth-api.zzjf
            @Override // com.google.android.gms.internal.p001firebaseauthapi.zzmv
            public final zzbu zza(zzow zzowVar, zzct zzctVar) {
                zzij zzb3;
                zzb3 = zzjb.zzb((zzot) zzowVar, zzctVar);
                return zzb3;
            }
        }, zzb2, zzot.class);
        HashMap hashMap = new HashMap();
        zziq.zzb zzbVar = zziq.zzb.zzc;
        zzvt zzvtVar = zzvt.RAW;
        hashMap.put(zzbVar, zzvtVar);
        zziq.zzb zzbVar2 = zziq.zzb.zza;
        zzvt zzvtVar2 = zzvt.TINK;
        hashMap.put(zzbVar2, zzvtVar2);
        zziq.zzb zzbVar3 = zziq.zzb.zzb;
        zzvt zzvtVar3 = zzvt.CRUNCHY;
        hashMap.put(zzbVar3, zzvtVar3);
        zzf = Collections.unmodifiableMap(hashMap);
        EnumMap enumMap = new EnumMap(zzvt.class);
        enumMap.put((EnumMap) zzvtVar, (zzvt) zzbVar);
        enumMap.put((EnumMap) zzvtVar2, (zzvt) zzbVar2);
        enumMap.put((EnumMap) zzvtVar3, (zzvt) zzbVar3);
        enumMap.put((EnumMap) zzvt.LEGACY, (zzvt) zzbVar3);
        zzg = Collections.unmodifiableMap(enumMap);
    }

    private static zziq.zzb zza(zzvt zzvtVar) {
        Map<zzvt, zziq.zzb> map = zzg;
        if (map.containsKey(zzvtVar)) {
            return map.get(zzvtVar);
        }
        int zza2 = zzvtVar.zza();
        throw new GeneralSecurityException("Unable to parse OutputPrefixType: " + zza2);
    }

    private static zzvt zza(zziq.zzb zzbVar) {
        Map<zziq.zzb, zzvt> map = zzf;
        if (map.containsKey(zzbVar)) {
            return map.get(zzbVar);
        }
        String valueOf = String.valueOf(zzbVar);
        throw new GeneralSecurityException("Unable to serialize variant: " + valueOf);
    }

    public static void zza() {
        zznv zza2 = zznv.zza();
        zza2.zza(zzb);
        zza2.zza(zzc);
        zza2.zza(zzd);
        zza2.zza(zze);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static zzij zzb(zzot zzotVar, zzct zzctVar) {
        if (zzotVar.zzf().equals(zzis.zza)) {
            try {
                zztb zza2 = zztb.zza(zzotVar.zzd(), zzaip.zza());
                if (zza2.zza() == 0) {
                    return zzij.zzb().zza(zziq.zzc().zza(zza2.zzd().zzb()).zza(zza(zzotVar.zzc())).zza()).zza(zzxt.zza(zza2.zzd().zzg(), zzct.zza(zzctVar))).zza(zzotVar.zze()).zza();
                }
                throw new GeneralSecurityException("Only version 0 keys are accepted");
            } catch (zzajj unused) {
                throw new GeneralSecurityException("Parsing AesSivKey failed");
            }
        }
        throw new IllegalArgumentException("Wrong type URL in call to AesSivParameters.parseParameters");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static zziq zzb(zzos zzosVar) {
        if (!zzosVar.zza().zzf().equals(zzis.zza)) {
            String zzf2 = zzosVar.zza().zzf();
            throw new IllegalArgumentException("Wrong type URL in call to AesSivParameters.parseParameters: " + zzf2);
        }
        try {
            zzte zza2 = zzte.zza(zzosVar.zza().zze(), zzaip.zza());
            if (zza2.zzb() == 0) {
                return zziq.zzc().zza(zza2.zza()).zza(zza(zzosVar.zza().zzd())).zza();
            }
            throw new GeneralSecurityException("Only version 0 keys are accepted");
        } catch (zzajj e5) {
            throw new GeneralSecurityException("Parsing AesSivParameters failed: ", e5);
        }
    }
}
