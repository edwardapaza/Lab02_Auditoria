package com.google.android.gms.internal.p001firebaseauthapi;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.util.Objects;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zziq  reason: invalid package */
/* loaded from: classes.dex */
public final class zziq extends zziu {
    private final int zza;
    private final zzb zzb;

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zziq$zza */
    /* loaded from: classes.dex */
    public static final class zza {
        private Integer zza;
        private zzb zzb;

        private zza() {
            this.zza = null;
            this.zzb = zzb.zzc;
        }

        public final zza zza(int i5) {
            if (i5 == 32 || i5 == 48 || i5 == 64) {
                this.zza = Integer.valueOf(i5);
                return this;
            }
            throw new InvalidAlgorithmParameterException(String.format("Invalid key size %d; only 32-byte, 48-byte and 64-byte AES-SIV keys are supported", Integer.valueOf(i5)));
        }

        public final zza zza(zzb zzbVar) {
            this.zzb = zzbVar;
            return this;
        }

        public final zziq zza() {
            Integer num = this.zza;
            if (num != null) {
                if (this.zzb != null) {
                    return new zziq(num.intValue(), this.zzb);
                }
                throw new GeneralSecurityException("Variant is not set");
            }
            throw new GeneralSecurityException("Key size is not set");
        }
    }

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zziq$zzb */
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

    private zziq(int i5, zzb zzbVar) {
        this.zza = i5;
        this.zzb = zzbVar;
    }

    public static zza zzc() {
        return new zza();
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zziq) {
            zziq zziqVar = (zziq) obj;
            return zziqVar.zza == this.zza && zziqVar.zzb == this.zzb;
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hash(zziq.class, Integer.valueOf(this.zza), this.zzb);
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zzb);
        int i5 = this.zza;
        return "AesSiv Parameters (variant: " + valueOf + ", " + i5 + "-byte key)";
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzci
    public final boolean zza() {
        return this.zzb != zzb.zzc;
    }

    public final int zzb() {
        return this.zza;
    }

    public final zzb zzd() {
        return this.zzb;
    }
}
