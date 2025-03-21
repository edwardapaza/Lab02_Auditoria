package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.android.gms.internal.p001firebaseauthapi.zzjx;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.spec.ECParameterSpec;
import java.util.Arrays;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzkc  reason: invalid package */
/* loaded from: classes.dex */
public final class zzkc extends zzks {
    private final zzkk zza;
    private final zzxt zzb;

    private zzkc(zzkk zzkkVar, zzxt zzxtVar) {
        this.zza = zzkkVar;
        this.zzb = zzxtVar;
    }

    public static zzkc zza(zzkk zzkkVar, zzxt zzxtVar) {
        ECParameterSpec eCParameterSpec;
        if (zzkkVar != null) {
            if (zzxtVar != null) {
                zzjx.zzd zze = zzkkVar.zzb().zze();
                int zza = zzxtVar.zza();
                String str = "Encoded private key byte length for " + String.valueOf(zze) + " must be %d, not " + zza;
                zzjx.zzd zzdVar = zzjx.zzd.zza;
                boolean z4 = false;
                if (zze == zzdVar) {
                    if (zza != 32) {
                        throw new GeneralSecurityException(String.format(str, 32));
                    }
                } else if (zze == zzjx.zzd.zzb) {
                    if (zza != 48) {
                        throw new GeneralSecurityException(String.format(str, 48));
                    }
                } else if (zze == zzjx.zzd.zzc) {
                    if (zza != 66) {
                        throw new GeneralSecurityException(String.format(str, 66));
                    }
                } else if (zze != zzjx.zzd.zzd) {
                    throw new GeneralSecurityException("Unable to validate private key length for " + String.valueOf(zze));
                } else if (zza != 32) {
                    throw new GeneralSecurityException(String.format(str, 32));
                }
                zzjx.zzd zze2 = zzkkVar.zzb().zze();
                byte[] zzb = zzkkVar.zzc().zzb();
                byte[] zza2 = zzxtVar.zza(zzbr.zza());
                if ((zze2 == zzdVar || zze2 == zzjx.zzd.zzb || zze2 == zzjx.zzd.zzc) ? true : true) {
                    if (zze2 == zzdVar) {
                        eCParameterSpec = zzmd.zza;
                    } else if (zze2 == zzjx.zzd.zzb) {
                        eCParameterSpec = zzmd.zzb;
                    } else if (zze2 != zzjx.zzd.zzc) {
                        throw new IllegalArgumentException("Unable to determine NIST curve params for " + String.valueOf(zze2));
                    } else {
                        eCParameterSpec = zzmd.zzc;
                    }
                    BigInteger order = eCParameterSpec.getOrder();
                    BigInteger zza3 = zzmb.zza(zza2);
                    if (zza3.signum() <= 0 || zza3.compareTo(order) >= 0) {
                        throw new GeneralSecurityException("Invalid private key.");
                    }
                    if (!zzmd.zza(zza3, eCParameterSpec).equals(zzwn.zza(eCParameterSpec.getCurve(), zzwp.UNCOMPRESSED, zzb))) {
                        throw new GeneralSecurityException("Invalid private key for public key.");
                    }
                } else if (zze2 != zzjx.zzd.zzd) {
                    throw new IllegalArgumentException("Unable to validate key pair for " + String.valueOf(zze2));
                } else if (!Arrays.equals(zzxp.zza(zza2), zzb)) {
                    throw new GeneralSecurityException("Invalid private key for public key.");
                }
                return new zzkc(zzkkVar, zzxtVar);
            }
            throw new GeneralSecurityException("HPKE private key cannot be constructed without secret");
        }
        throw new GeneralSecurityException("HPKE private key cannot be constructed without an HPKE public key");
    }

    public final zzjx zzb() {
        return this.zza.zzb();
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzks
    public final /* synthetic */ zzkr zzc() {
        return this.zza;
    }

    public final zzxt zzd() {
        return this.zzb;
    }
}
