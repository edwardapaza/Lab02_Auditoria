package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.android.gms.internal.p001firebaseauthapi.zzea;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzdv  reason: invalid package */
/* loaded from: classes.dex */
public final class zzdv extends zzda {
    private final zzea zza;
    private final zzxt zzb;
    private final zzxr zzc;
    private final Integer zzd;

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzdv$zza */
    /* loaded from: classes.dex */
    public static class zza {
        private zzea zza;
        private zzxt zzb;
        private Integer zzc;

        private zza() {
            this.zza = null;
            this.zzb = null;
            this.zzc = null;
        }

        public final zza zza(zzea zzeaVar) {
            this.zza = zzeaVar;
            return this;
        }

        public final zza zza(zzxt zzxtVar) {
            this.zzb = zzxtVar;
            return this;
        }

        public final zza zza(Integer num) {
            this.zzc = num;
            return this;
        }

        public final zzdv zza() {
            zzxr zza;
            zzea zzeaVar = this.zza;
            if (zzeaVar == null || this.zzb == null) {
                throw new GeneralSecurityException("Cannot build without parameters and/or key material");
            }
            if (zzeaVar.zzc() == this.zzb.zza()) {
                if (this.zza.zza() && this.zzc == null) {
                    throw new GeneralSecurityException("Cannot create key without ID requirement with parameters with ID requirement");
                }
                if (this.zza.zza() || this.zzc == null) {
                    if (this.zza.zzf() == zzea.zzb.zzc) {
                        zza = zzxr.zza(new byte[0]);
                    } else if (this.zza.zzf() == zzea.zzb.zzb) {
                        zza = zzxr.zza(ByteBuffer.allocate(5).put((byte) 0).putInt(this.zzc.intValue()).array());
                    } else if (this.zza.zzf() != zzea.zzb.zza) {
                        String valueOf = String.valueOf(this.zza.zzf());
                        throw new IllegalStateException("Unknown AesEaxParameters.Variant: " + valueOf);
                    } else {
                        zza = zzxr.zza(ByteBuffer.allocate(5).put((byte) 1).putInt(this.zzc.intValue()).array());
                    }
                    return new zzdv(this.zza, this.zzb, zza, this.zzc);
                }
                throw new GeneralSecurityException("Cannot create key with ID requirement with parameters without ID requirement");
            }
            throw new GeneralSecurityException("Key size mismatch");
        }
    }

    private zzdv(zzea zzeaVar, zzxt zzxtVar, zzxr zzxrVar, Integer num) {
        this.zza = zzeaVar;
        this.zzb = zzxtVar;
        this.zzc = zzxrVar;
        this.zzd = num;
    }

    public static zza zzb() {
        return new zza();
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzbu
    public final Integer zza() {
        return this.zzd;
    }

    public final zzea zzc() {
        return this.zza;
    }

    public final zzxr zzd() {
        return this.zzc;
    }

    public final zzxt zze() {
        return this.zzb;
    }
}
