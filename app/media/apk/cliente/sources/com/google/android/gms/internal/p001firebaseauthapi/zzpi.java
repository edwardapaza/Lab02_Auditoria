package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.android.gms.internal.p001firebaseauthapi.zzpp;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzpi  reason: invalid package */
/* loaded from: classes.dex */
public final class zzpi extends zzqp {
    private final zzpp zza;
    private final zzxt zzb;
    private final zzxr zzc;
    private final Integer zzd;

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzpi$zza */
    /* loaded from: classes.dex */
    public static class zza {
        private zzpp zza;
        private zzxt zzb;
        private Integer zzc;

        private zza() {
            this.zza = null;
            this.zzb = null;
            this.zzc = null;
        }

        public final zza zza(zzpp zzppVar) {
            this.zza = zzppVar;
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

        public final zzpi zza() {
            zzxr zza;
            zzpp zzppVar = this.zza;
            if (zzppVar == null || this.zzb == null) {
                throw new GeneralSecurityException("Cannot build without parameters and/or key material");
            }
            if (zzppVar.zzc() == this.zzb.zza()) {
                if (this.zza.zza() && this.zzc == null) {
                    throw new GeneralSecurityException("Cannot create key without ID requirement with parameters with ID requirement");
                }
                if (this.zza.zza() || this.zzc == null) {
                    if (this.zza.zze() == zzpp.zzb.zzd) {
                        zza = zzxr.zza(new byte[0]);
                    } else if (this.zza.zze() == zzpp.zzb.zzc || this.zza.zze() == zzpp.zzb.zzb) {
                        zza = zzxr.zza(ByteBuffer.allocate(5).put((byte) 0).putInt(this.zzc.intValue()).array());
                    } else if (this.zza.zze() != zzpp.zzb.zza) {
                        String valueOf = String.valueOf(this.zza.zze());
                        throw new IllegalStateException("Unknown AesCmacParametersParameters.Variant: " + valueOf);
                    } else {
                        zza = zzxr.zza(ByteBuffer.allocate(5).put((byte) 1).putInt(this.zzc.intValue()).array());
                    }
                    return new zzpi(this.zza, this.zzb, zza, this.zzc);
                }
                throw new GeneralSecurityException("Cannot create key with ID requirement with parameters without ID requirement");
            }
            throw new GeneralSecurityException("Key size mismatch");
        }
    }

    private zzpi(zzpp zzppVar, zzxt zzxtVar, zzxr zzxrVar, Integer num) {
        this.zza = zzppVar;
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

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzqp
    public final /* synthetic */ zzqs zzc() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzqp
    public final zzxr zzd() {
        return this.zzc;
    }

    public final zzxt zze() {
        return this.zzb;
    }
}
