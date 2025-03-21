package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.android.gms.internal.p001firebaseauthapi.zzjl;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;
import java.util.Arrays;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzjn  reason: invalid package */
/* loaded from: classes.dex */
public final class zzjn extends zzks {
    private final zzjv zza;
    private final zzxu zzb;
    private final zzxt zzc;

    private zzjn(zzjv zzjvVar, zzxu zzxuVar, zzxt zzxtVar) {
        this.zza = zzjvVar;
        this.zzb = zzxuVar;
        this.zzc = zzxtVar;
    }

    public static zzjn zza(zzjv zzjvVar, zzxt zzxtVar) {
        if (zzjvVar != null) {
            if (zzjvVar.zzc() != null) {
                if (zzxtVar != null) {
                    byte[] zza = zzxtVar.zza(zzbr.zza());
                    byte[] zzb = zzjvVar.zzc().zzb();
                    if (zza.length == 32) {
                        if (Arrays.equals(zzxp.zza(zza), zzb)) {
                            return new zzjn(zzjvVar, null, zzxtVar);
                        }
                        throw new GeneralSecurityException("Invalid private key for public key.");
                    }
                    throw new GeneralSecurityException("Private key bytes length for X25519 curve must be 32");
                }
                throw new GeneralSecurityException("ECIES private key cannot be constructed without secret");
            }
            throw new GeneralSecurityException("ECIES private key for X25519 curve cannot be constructed with NIST-curve public key");
        }
        throw new GeneralSecurityException("ECIES private key cannot be constructed without an ECIES public key");
    }

    public static zzjn zza(zzjv zzjvVar, zzxu zzxuVar) {
        if (zzjvVar != null) {
            if (zzjvVar.zzd() != null) {
                if (zzxuVar != null) {
                    BigInteger zza = zzxuVar.zza(zzbr.zza());
                    ECPoint zzd = zzjvVar.zzd();
                    zzjl.zzc zzd2 = zzjvVar.zzb().zzd();
                    BigInteger order = zza(zzd2).getOrder();
                    if (zza.signum() <= 0 || zza.compareTo(order) >= 0) {
                        throw new GeneralSecurityException("Invalid private value");
                    }
                    if (zzmd.zza(zza, zza(zzd2)).equals(zzd)) {
                        return new zzjn(zzjvVar, zzxuVar, null);
                    }
                    throw new GeneralSecurityException("Invalid private value");
                }
                throw new GeneralSecurityException("ECIES private key cannot be constructed without secret");
            }
            throw new GeneralSecurityException("ECIES private key for NIST curve cannot be constructed with X25519-curve public key");
        }
        throw new GeneralSecurityException("ECIES private key cannot be constructed without an ECIES public key");
    }

    private static ECParameterSpec zza(zzjl.zzc zzcVar) {
        if (zzcVar == zzjl.zzc.zza) {
            return zzmd.zza;
        }
        if (zzcVar == zzjl.zzc.zzb) {
            return zzmd.zzb;
        }
        if (zzcVar == zzjl.zzc.zzc) {
            return zzmd.zzc;
        }
        String valueOf = String.valueOf(zzcVar);
        throw new IllegalArgumentException("Unable to determine NIST curve type for " + valueOf);
    }

    public final zzjl zzb() {
        return this.zza.zzb();
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzks
    public final /* synthetic */ zzkr zzc() {
        return this.zza;
    }

    public final zzxu zzd() {
        return this.zzb;
    }

    public final zzxt zze() {
        return this.zzc;
    }
}
