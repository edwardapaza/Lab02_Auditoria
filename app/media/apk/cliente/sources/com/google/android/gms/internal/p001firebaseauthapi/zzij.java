package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.android.gms.internal.p001firebaseauthapi.zziq;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzij  reason: invalid package */
/* loaded from: classes.dex */
public final class zzij extends zziv {
    private final zziq zza;
    private final zzxt zzb;
    private final zzxr zzc;
    private final Integer zzd;

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzij$zza */
    /* loaded from: classes.dex */
    public static class zza {
        private zziq zza;
        private zzxt zzb;
        private Integer zzc;

        private zza() {
            this.zza = null;
            this.zzb = null;
            this.zzc = null;
        }

        public final zza zza(zziq zziqVar) {
            this.zza = zziqVar;
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

        public final zzij zza() {
            zzxr zza;
            zziq zziqVar = this.zza;
            if (zziqVar == null || this.zzb == null) {
                throw new IllegalArgumentException("Cannot build without parameters and/or key material");
            }
            if (zziqVar.zzb() == this.zzb.zza()) {
                if (this.zza.zza() && this.zzc == null) {
                    throw new GeneralSecurityException("Cannot create key without ID requirement with parameters with ID requirement");
                }
                if (this.zza.zza() || this.zzc == null) {
                    if (this.zza.zzd() == zziq.zzb.zzc) {
                        zza = zzxr.zza(new byte[0]);
                    } else if (this.zza.zzd() == zziq.zzb.zzb) {
                        zza = zzxr.zza(ByteBuffer.allocate(5).put((byte) 0).putInt(this.zzc.intValue()).array());
                    } else if (this.zza.zzd() != zziq.zzb.zza) {
                        String valueOf = String.valueOf(this.zza.zzd());
                        throw new IllegalStateException("Unknown AesSivParameters.Variant: " + valueOf);
                    } else {
                        zza = zzxr.zza(ByteBuffer.allocate(5).put((byte) 1).putInt(this.zzc.intValue()).array());
                    }
                    return new zzij(this.zza, this.zzb, zza, this.zzc);
                }
                throw new GeneralSecurityException("Cannot create key with ID requirement with parameters without ID requirement");
            }
            throw new GeneralSecurityException("Key size mismatch");
        }
    }

    private zzij(zziq zziqVar, zzxt zzxtVar, zzxr zzxrVar, Integer num) {
        this.zza = zziqVar;
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

    public final zziq zzc() {
        return this.zza;
    }

    public final zzxr zzd() {
        return this.zzc;
    }

    public final zzxt zze() {
        return this.zzb;
    }
}
