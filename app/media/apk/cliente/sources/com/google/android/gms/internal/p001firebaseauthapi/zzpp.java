package com.google.android.gms.internal.p001firebaseauthapi;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.util.Objects;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzpp  reason: invalid package */
/* loaded from: classes.dex */
public final class zzpp extends zzqs {
    private final int zza;
    private final int zzb;
    private final zzb zzc;

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzpp$zza */
    /* loaded from: classes.dex */
    public static final class zza {
        private Integer zza;
        private Integer zzb;
        private zzb zzc;

        private zza() {
            this.zza = null;
            this.zzb = null;
            this.zzc = zzb.zzd;
        }

        public final zza zza(int i5) {
            if (i5 == 16 || i5 == 32) {
                this.zza = Integer.valueOf(i5);
                return this;
            }
            throw new InvalidAlgorithmParameterException(String.format("Invalid key size %d; only 128-bit and 256-bit AES keys are supported", Integer.valueOf(i5 << 3)));
        }

        public final zza zza(zzb zzbVar) {
            this.zzc = zzbVar;
            return this;
        }

        public final zzpp zza() {
            Integer num = this.zza;
            if (num != null) {
                if (this.zzb != null) {
                    if (this.zzc != null) {
                        return new zzpp(num.intValue(), this.zzb.intValue(), this.zzc);
                    }
                    throw new GeneralSecurityException("variant not set");
                }
                throw new GeneralSecurityException("tag size not set");
            }
            throw new GeneralSecurityException("key size not set");
        }

        public final zza zzb(int i5) {
            if (i5 >= 10 && 16 >= i5) {
                this.zzb = Integer.valueOf(i5);
                return this;
            }
            throw new GeneralSecurityException("Invalid tag size for AesCmacParameters: " + i5);
        }
    }

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzpp$zzb */
    /* loaded from: classes.dex */
    public static final class zzb {
        public static final zzb zza = new zzb("TINK");
        public static final zzb zzb = new zzb("CRUNCHY");
        public static final zzb zzc = new zzb("LEGACY");
        public static final zzb zzd = new zzb("NO_PREFIX");
        private final String zze;

        private zzb(String str) {
            this.zze = str;
        }

        public final String toString() {
            return this.zze;
        }
    }

    private zzpp(int i5, int i6, zzb zzbVar) {
        this.zza = i5;
        this.zzb = i6;
        this.zzc = zzbVar;
    }

    public static zza zzd() {
        return new zza();
    }

    private final int zzf() {
        zzb zzbVar = this.zzc;
        if (zzbVar == zzb.zzd) {
            return this.zzb;
        }
        if (zzbVar == zzb.zza || zzbVar == zzb.zzb || zzbVar == zzb.zzc) {
            return this.zzb + 5;
        }
        throw new IllegalStateException("Unknown variant");
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzpp) {
            zzpp zzppVar = (zzpp) obj;
            return zzppVar.zza == this.zza && zzppVar.zzf() == zzf() && zzppVar.zzc == this.zzc;
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hash(zzpp.class, Integer.valueOf(this.zza), Integer.valueOf(this.zzb), this.zzc);
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zzc);
        int i5 = this.zzb;
        int i6 = this.zza;
        return "AES-CMAC Parameters (variant: " + valueOf + ", " + i5 + "-byte tags, and " + i6 + "-byte key)";
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzci
    public final boolean zza() {
        return this.zzc != zzb.zzd;
    }

    public final int zzb() {
        return this.zzb;
    }

    public final int zzc() {
        return this.zza;
    }

    public final zzb zze() {
        return this.zzc;
    }
}
