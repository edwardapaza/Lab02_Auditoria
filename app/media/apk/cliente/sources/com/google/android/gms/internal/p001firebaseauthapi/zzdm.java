package com.google.android.gms.internal.p001firebaseauthapi;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.util.Objects;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzdm  reason: invalid package */
/* loaded from: classes.dex */
public final class zzdm extends zzdc {
    private final int zza;
    private final int zzb;
    private final int zzc;
    private final int zzd;
    private final zzc zze;
    private final zzb zzf;

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzdm$zza */
    /* loaded from: classes.dex */
    public static final class zza {
        private Integer zza;
        private Integer zzb;
        private Integer zzc;
        private Integer zzd;
        private zzb zze;
        private zzc zzf;

        private zza() {
            this.zza = null;
            this.zzb = null;
            this.zzc = null;
            this.zzd = null;
            this.zze = null;
            this.zzf = zzc.zzc;
        }

        public final zza zza(int i5) {
            if (i5 == 16 || i5 == 24 || i5 == 32) {
                this.zza = Integer.valueOf(i5);
                return this;
            }
            throw new InvalidAlgorithmParameterException(String.format("Invalid key size %d; only 16-byte, 24-byte and 32-byte AES keys are supported", Integer.valueOf(i5)));
        }

        public final zza zza(zzb zzbVar) {
            this.zze = zzbVar;
            return this;
        }

        public final zza zza(zzc zzcVar) {
            this.zzf = zzcVar;
            return this;
        }

        public final zzdm zza() {
            if (this.zza != null) {
                if (this.zzb != null) {
                    if (this.zzc != null) {
                        Integer num = this.zzd;
                        if (num != null) {
                            if (this.zze != null) {
                                if (this.zzf != null) {
                                    int intValue = num.intValue();
                                    zzb zzbVar = this.zze;
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
                                        throw new GeneralSecurityException("unknown hash type; must be SHA1, SHA224, SHA256, SHA384 or SHA512");
                                    } else {
                                        if (intValue > 64) {
                                            throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 64 bytes for SHA512", Integer.valueOf(intValue)));
                                        }
                                    }
                                    return new zzdm(this.zza.intValue(), this.zzb.intValue(), this.zzc.intValue(), this.zzd.intValue(), this.zzf, this.zze);
                                }
                                throw new GeneralSecurityException("variant is not set");
                            }
                            throw new GeneralSecurityException("hash type is not set");
                        }
                        throw new GeneralSecurityException("tag size is not set");
                    }
                    throw new GeneralSecurityException("iv size is not set");
                }
                throw new GeneralSecurityException("HMAC key size is not set");
            }
            throw new GeneralSecurityException("AES key size is not set");
        }

        public final zza zzb(int i5) {
            if (i5 >= 16) {
                this.zzb = Integer.valueOf(i5);
                return this;
            }
            throw new InvalidAlgorithmParameterException(String.format("Invalid key size in bytes %d; HMAC key must be at least 16 bytes", Integer.valueOf(i5)));
        }

        public final zza zzc(int i5) {
            if (i5 < 12 || i5 > 16) {
                throw new GeneralSecurityException(String.format("Invalid IV size in bytes %d; IV size must be between 12 and 16 bytes", Integer.valueOf(i5)));
            }
            this.zzc = Integer.valueOf(i5);
            return this;
        }

        public final zza zzd(int i5) {
            if (i5 >= 10) {
                this.zzd = Integer.valueOf(i5);
                return this;
            }
            throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; must be at least 10 bytes", Integer.valueOf(i5)));
        }
    }

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzdm$zzb */
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

    /* renamed from: com.google.android.gms.internal.firebase-auth-api.zzdm$zzc */
    /* loaded from: classes.dex */
    public static final class zzc {
        public static final zzc zza = new zzc("TINK");
        public static final zzc zzb = new zzc("CRUNCHY");
        public static final zzc zzc = new zzc("NO_PREFIX");
        private final String zzd;

        private zzc(String str) {
            this.zzd = str;
        }

        public final String toString() {
            return this.zzd;
        }
    }

    private zzdm(int i5, int i6, int i7, int i8, zzc zzcVar, zzb zzbVar) {
        this.zza = i5;
        this.zzb = i6;
        this.zzc = i7;
        this.zzd = i8;
        this.zze = zzcVar;
        this.zzf = zzbVar;
    }

    public static zza zzf() {
        return new zza();
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzdm) {
            zzdm zzdmVar = (zzdm) obj;
            return zzdmVar.zza == this.zza && zzdmVar.zzb == this.zzb && zzdmVar.zzc == this.zzc && zzdmVar.zzd == this.zzd && zzdmVar.zze == this.zze && zzdmVar.zzf == this.zzf;
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hash(zzdm.class, Integer.valueOf(this.zza), Integer.valueOf(this.zzb), Integer.valueOf(this.zzc), Integer.valueOf(this.zzd), this.zze, this.zzf);
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zze);
        String valueOf2 = String.valueOf(this.zzf);
        int i5 = this.zzc;
        int i6 = this.zzd;
        int i7 = this.zza;
        int i8 = this.zzb;
        return "AesCtrHmacAead Parameters (variant: " + valueOf + ", hashType: " + valueOf2 + ", " + i5 + "-byte IV, and " + i6 + "-byte tags, and " + i7 + "-byte AES key, and " + i8 + "-byte HMAC key)";
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzci
    public final boolean zza() {
        return this.zze != zzc.zzc;
    }

    public final int zzb() {
        return this.zza;
    }

    public final int zzc() {
        return this.zzb;
    }

    public final int zzd() {
        return this.zzc;
    }

    public final int zze() {
        return this.zzd;
    }

    public final zzb zzg() {
        return this.zzf;
    }

    public final zzc zzh() {
        return this.zze;
    }
}
