package com.google.android.gms.internal.p001firebaseauthapi;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.util.Objects;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzfa  reason: invalid package */
/* loaded from: classes.dex */
public final class zzfa extends zzdc {
    private final int zza;
    private final zzb zzb;

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzfa$zza */
    /* loaded from: classes.dex */
    public static final class zza {
        private Integer zza;
        private zzb zzb;

        private zza() {
            this.zza = null;
            this.zzb = zzb.zzc;
        }

        public final zza zza(int i5) {
            if (i5 == 16 || i5 == 32) {
                this.zza = Integer.valueOf(i5);
                return this;
            }
            throw new InvalidAlgorithmParameterException(String.format("Invalid key size %d; only 16-byte and 32-byte AES keys are supported", Integer.valueOf(i5)));
        }

        public final zza zza(zzb zzbVar) {
            this.zzb = zzbVar;
            return this;
        }

        public final zzfa zza() {
            Integer num = this.zza;
            if (num != null) {
                if (this.zzb != null) {
                    return new zzfa(num.intValue(), this.zzb);
                }
                throw new GeneralSecurityException("Variant is not set");
            }
            throw new GeneralSecurityException("Key size is not set");
        }
    }

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzfa$zzb */
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

    private zzfa(int i5, zzb zzbVar) {
        this.zza = i5;
        this.zzb = zzbVar;
    }

    public static zza zzc() {
        return new zza();
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzfa) {
            zzfa zzfaVar = (zzfa) obj;
            return zzfaVar.zza == this.zza && zzfaVar.zzb == this.zzb;
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hash(zzfa.class, Integer.valueOf(this.zza), this.zzb);
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zzb);
        int i5 = this.zza;
        return "AesGcmSiv Parameters (variant: " + valueOf + ", " + i5 + "-byte key)";
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
