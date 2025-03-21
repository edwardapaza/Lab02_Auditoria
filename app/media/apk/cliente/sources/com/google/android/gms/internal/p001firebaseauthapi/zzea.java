package com.google.android.gms.internal.p001firebaseauthapi;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.util.Objects;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzea  reason: invalid package */
/* loaded from: classes.dex */
public final class zzea extends zzdc {
    private final int zza;
    private final int zzb;
    private final int zzc;
    private final zzb zzd;

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzea$zza */
    /* loaded from: classes.dex */
    public static final class zza {
        private Integer zza;
        private Integer zzb;
        private Integer zzc;
        private zzb zzd;

        private zza() {
            this.zza = null;
            this.zzb = null;
            this.zzc = null;
            this.zzd = zzb.zzc;
        }

        public final zza zza(int i5) {
            if (i5 == 12 || i5 == 16) {
                this.zzb = Integer.valueOf(i5);
                return this;
            }
            throw new GeneralSecurityException(String.format("Invalid IV size in bytes %d; acceptable values have 12 or 16 bytes", Integer.valueOf(i5)));
        }

        public final zza zza(zzb zzbVar) {
            this.zzd = zzbVar;
            return this;
        }

        public final zzea zza() {
            Integer num = this.zza;
            if (num != null) {
                if (this.zzb != null) {
                    if (this.zzd != null) {
                        if (this.zzc != null) {
                            return new zzea(num.intValue(), this.zzb.intValue(), this.zzc.intValue(), this.zzd);
                        }
                        throw new GeneralSecurityException("Tag size is not set");
                    }
                    throw new GeneralSecurityException("Variant is not set");
                }
                throw new GeneralSecurityException("IV size is not set");
            }
            throw new GeneralSecurityException("Key size is not set");
        }

        public final zza zzb(int i5) {
            if (i5 == 16 || i5 == 24 || i5 == 32) {
                this.zza = Integer.valueOf(i5);
                return this;
            }
            throw new InvalidAlgorithmParameterException(String.format("Invalid key size %d; only 16-byte, 24-byte and 32-byte AES keys are supported", Integer.valueOf(i5)));
        }

        public final zza zzc(int i5) {
            this.zzc = 16;
            return this;
        }
    }

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzea$zzb */
    /* loaded from: classes.dex */
    public static final class zzb {
        public static final zzb zza = new zzb("TINK");
        public static final zzb zzb = new zzb("CRUNCHY");
        public static final zzb zzc = new zzb("NO_PREFIX");
        private final String zzd;

        private zzb(String str) {
            this.zzd = str;
        }

        public final String toString() {
            return this.zzd;
        }
    }

    private zzea(int i5, int i6, int i7, zzb zzbVar) {
        this.zza = i5;
        this.zzb = i6;
        this.zzc = i7;
        this.zzd = zzbVar;
    }

    public static zza zze() {
        return new zza();
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzea) {
            zzea zzeaVar = (zzea) obj;
            return zzeaVar.zza == this.zza && zzeaVar.zzb == this.zzb && zzeaVar.zzc == this.zzc && zzeaVar.zzd == this.zzd;
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hash(zzea.class, Integer.valueOf(this.zza), Integer.valueOf(this.zzb), Integer.valueOf(this.zzc), this.zzd);
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zzd);
        int i5 = this.zzb;
        int i6 = this.zzc;
        int i7 = this.zza;
        return "AesEax Parameters (variant: " + valueOf + ", " + i5 + "-byte IV, " + i6 + "-byte tag, and " + i7 + "-byte key)";
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzci
    public final boolean zza() {
        return this.zzd != zzb.zzc;
    }

    public final int zzb() {
        return this.zzb;
    }

    public final int zzc() {
        return this.zza;
    }

    public final int zzd() {
        return this.zzc;
    }

    public final zzb zzf() {
        return this.zzd;
    }
}
