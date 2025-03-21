package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.android.gms.internal.p001firebaseauthapi.zzjx;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.security.spec.ECParameterSpec;
import java.security.spec.EllipticCurve;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzkk  reason: invalid package */
/* loaded from: classes.dex */
public final class zzkk extends zzkr {
    private final zzjx zza;
    private final zzxr zzb;
    private final zzxr zzc;
    private final Integer zzd;

    private zzkk(zzjx zzjxVar, zzxr zzxrVar, zzxr zzxrVar2, Integer num) {
        this.zza = zzjxVar;
        this.zzb = zzxrVar;
        this.zzc = zzxrVar2;
        this.zzd = num;
    }

    public static zzkk zza(zzjx zzjxVar, zzxr zzxrVar, Integer num) {
        zzxr zza;
        ECParameterSpec eCParameterSpec;
        zzjx.zzf zzf = zzjxVar.zzf();
        zzjx.zzf zzfVar = zzjx.zzf.zzc;
        if (!zzf.equals(zzfVar) && num == null) {
            throw new GeneralSecurityException("'idRequirement' must be non-null for " + String.valueOf(zzf) + " variant.");
        } else if (!zzf.equals(zzfVar) || num == null) {
            zzjx.zzd zze = zzjxVar.zze();
            int zza2 = zzxrVar.zza();
            String str = "Encoded public key byte length for " + String.valueOf(zze) + " must be %d, not " + zza2;
            zzjx.zzd zzdVar = zzjx.zzd.zza;
            if (zze == zzdVar) {
                if (zza2 != 65) {
                    throw new GeneralSecurityException(String.format(str, 65));
                }
            } else if (zze == zzjx.zzd.zzb) {
                if (zza2 != 97) {
                    throw new GeneralSecurityException(String.format(str, 97));
                }
            } else if (zze == zzjx.zzd.zzc) {
                if (zza2 != 133) {
                    throw new GeneralSecurityException(String.format(str, 133));
                }
            } else if (zze != zzjx.zzd.zzd) {
                throw new GeneralSecurityException("Unable to validate public key length for " + String.valueOf(zze));
            } else if (zza2 != 32) {
                throw new GeneralSecurityException(String.format(str, 32));
            }
            if (zze == zzdVar || zze == zzjx.zzd.zzb || zze == zzjx.zzd.zzc) {
                if (zze == zzdVar) {
                    eCParameterSpec = zzmd.zza;
                } else if (zze == zzjx.zzd.zzb) {
                    eCParameterSpec = zzmd.zzb;
                } else if (zze != zzjx.zzd.zzc) {
                    throw new IllegalArgumentException("Unable to determine NIST curve type for " + String.valueOf(zze));
                } else {
                    eCParameterSpec = zzmd.zzc;
                }
                EllipticCurve curve = eCParameterSpec.getCurve();
                zzmd.zza(zzwn.zza(curve, zzwp.UNCOMPRESSED, zzxrVar.zzb()), curve);
            }
            zzjx.zzf zzf2 = zzjxVar.zzf();
            if (zzf2 == zzfVar) {
                zza = zzxr.zza(new byte[0]);
            } else if (num == null) {
                throw new IllegalStateException("idRequirement must be non-null for HpkeParameters.Variant " + String.valueOf(zzf2));
            } else if (zzf2 == zzjx.zzf.zzb) {
                zza = zzxr.zza(ByteBuffer.allocate(5).put((byte) 0).putInt(num.intValue()).array());
            } else if (zzf2 != zzjx.zzf.zza) {
                throw new IllegalStateException("Unknown HpkeParameters.Variant: " + String.valueOf(zzf2));
            } else {
                zza = zzxr.zza(ByteBuffer.allocate(5).put((byte) 1).putInt(num.intValue()).array());
            }
            return new zzkk(zzjxVar, zzxrVar, zza, num);
        } else {
            throw new GeneralSecurityException("'idRequirement' must be null for NO_PREFIX variant.");
        }
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzbu
    public final Integer zza() {
        return this.zzd;
    }

    public final zzjx zzb() {
        return this.zza;
    }

    public final zzxr zzc() {
        return this.zzb;
    }
}
