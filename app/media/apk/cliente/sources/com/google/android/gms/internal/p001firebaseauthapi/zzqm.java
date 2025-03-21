package com.google.android.gms.internal.p001firebaseauthapi;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.util.Objects;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzqm  reason: invalid package */
/* loaded from: classes.dex */
public final class zzqm extends zzqs {
    private final int zza;
    private final int zzb;
    private final zzc zzc;
    private final zzb zzd;

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzqm$zza */
    /* loaded from: classes.dex */
    public static final class zza {
        private Integer zza;
        private Integer zzb;
        private zzb zzc;
        private zzc zzd;

        private zza() {
            this.zza = null;
            this.zzb = null;
            this.zzc = null;
            this.zzd = zzc.zzd;
        }

        public final zza zza(int i5) {
            this.zza = Integer.valueOf(i5);
            return this;
        }

        public final zza zza(zzb zzbVar) {
            this.zzc = zzbVar;
            return this;
        }

        public final zza zza(zzc zzcVar) {
            this.zzd = zzcVar;
            return this;
        }

        public final zzqm zza() {
            Integer num = this.zza;
            if (num != null) {
                if (this.zzb != null) {
                    if (this.zzc != null) {
                        if (this.zzd != null) {
                            if (num.intValue() >= 16) {
                                int intValue = this.zzb.intValue();
                                zzb zzbVar = this.zzc;
                                if (intValue >= 10) {
                                    if (zzbVar == zzb.zza) {
                                        if (intValue > 20) {
                                            throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 20 bytes for SHA1", Integer.valueOf(intValue)));
                                        }
                                    } else if (zzbVar == zzb.zzb) {
                                        if (intValue > 28) {
                                            throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 28 bytes for SHA224", Integer.valueOf(intValue)));
                                        }
                                    } else if (zzbVar == zzb.zzc) {
                                        if (intValue > 32) {
                                            throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 32 bytes for SHA256", Integer.valueOf(intValue)));
                                        }
                                    } else if (zzbVar == zzb.zzd) {
                                        if (intValue > 48) {
                                            throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 48 bytes for SHA384", Integer.valueOf(intValue)));
                                        }
                                    } else if (zzbVar != zzb.zze) {
                                        throw new GeneralSecurityException("unknown hash type; must be SHA256, SHA384 or SHA512");
                                    } else {
                                        if (intValue > 64) {
                                            throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 64 bytes for SHA512", Integer.valueOf(intValue)));
                                        }
                                    }
                                    return new zzqm(this.zza.intValue(), this.zzb.intValue(), this.zzd, this.zzc);
                                }
                                throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; must be at least 10 bytes", Integer.valueOf(intValue)));
                            }
                            throw new InvalidAlgorithmParameterException(String.format("Invalid key size in bytes %d; must be at least 16 bytes", this.zza));
                        }
                        throw new GeneralSecurityException("variant is not set");
                    }
                    throw new GeneralSecurityException("hash type is not set");
                }
                throw new GeneralSecurityException("tag size is not set");
            }
            throw new GeneralSecurityException("key size is not set");
        }

        public final zza zzb(int i5) {
            this.zzb = Integer.valueOf(i5);
            return this;
        }
    }

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzqm$zzb */
    /* loaded from: classes.dex */
    public static final class zzb {
        public static final zzb zza = new zzb("SHA1");
        public static final zzb zzb = new zzb("SHA224");
        public static final zzb zzc = new zzb("SHA256");
        public static final zzb zzd = new zzb("SHA384");
        public static final zzb zze = new zzb("SHA512");
        private final String zzf;

        private zzb(String str) {
            this.zzf = str;
        }

        public final String toString() {
            return this.zzf;
        }
    }

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzqm$zzc */
    /* loaded from: classes.dex */
    public static final class zzc {
        public static final zzc zza = new zzc("TINK");
        public static final zzc zzb = new zzc("CRUNCHY");
        public static final zzc zzc = new zzc("LEGACY");
        public static final zzc zzd = new zzc("NO_PREFIX");
        private final String zze;

        private zzc(String str) {
            this.zze = str;
        }

        public final String toString() {
            return this.zze;
        }
    }

    private zzqm(int i5, int i6, zzc zzcVar, zzb zzbVar) {
        this.zza = i5;
        this.zzb = i6;
        this.zzc = zzcVar;
        this.zzd = zzbVar;
    }

    public static zza zzd() {
        return new zza();
    }

    private final int zzg() {
        zzc zzcVar = this.zzc;
        if (zzcVar == zzc.zzd) {
            return this.zzb;
        }
        if (zzcVar == zzc.zza || zzcVar == zzc.zzb || zzcVar == zzc.zzc) {
            return this.zzb + 5;
        }
        throw new IllegalStateException("Unknown variant");
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzqm) {
            zzqm zzqmVar = (zzqm) obj;
            return zzqmVar.zza == this.zza && zzqmVar.zzg() == zzg() && zzqmVar.zzc == this.zzc && zzqmVar.zzd == this.zzd;
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hash(zzqm.class, Integer.valueOf(this.zza), Integer.valueOf(this.zzb), this.zzc, this.zzd);
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zzc);
        String valueOf2 = String.valueOf(this.zzd);
        int i5 = this.zzb;
        int i6 = this.zza;
        return "HMAC Parameters (variant: " + valueOf + ", hashType: " + valueOf2 + ", " + i5 + "-byte tags, and " + i6 + "-byte key)";
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzci
    public final boolean zza() {
        return this.zzc != zzc.zzd;
    }

    public final int zzb() {
        return this.zzb;
    }

    public final int zzc() {
        return this.zza;
    }

    public final zzb zze() {
        return this.zzd;
    }

    public final zzc zzf() {
        return this.zzc;
    }
}
