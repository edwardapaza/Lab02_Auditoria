package com.google.android.gms.internal.p001firebaseauthapi;

import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzku  reason: invalid package */
/* loaded from: classes.dex */
final class zzku {
    public static zzwp zza(zztj zztjVar) {
        int i5 = zzkt.zzc[zztjVar.ordinal()];
        if (i5 != 1) {
            if (i5 != 2) {
                if (i5 == 3) {
                    return zzwp.COMPRESSED;
                }
                String valueOf = String.valueOf(zztjVar);
                throw new GeneralSecurityException("unknown point format: " + valueOf);
            }
            return zzwp.DO_NOT_USE_CRUNCHY_UNCOMPRESSED;
        }
        return zzwp.UNCOMPRESSED;
    }

    public static zzwq zza(zztx zztxVar) {
        int i5 = zzkt.zzb[zztxVar.ordinal()];
        if (i5 != 1) {
            if (i5 != 2) {
                if (i5 == 3) {
                    return zzwq.NIST_P521;
                }
                String valueOf = String.valueOf(zztxVar);
                throw new GeneralSecurityException("unknown curve type: " + valueOf);
            }
            return zzwq.NIST_P384;
        }
        return zzwq.NIST_P256;
    }

    public static String zza(zzuc zzucVar) {
        int i5 = zzkt.zza[zzucVar.ordinal()];
        if (i5 != 1) {
            if (i5 != 2) {
                if (i5 != 3) {
                    if (i5 != 4) {
                        if (i5 == 5) {
                            return "HmacSha512";
                        }
                        String valueOf = String.valueOf(zzucVar);
                        throw new NoSuchAlgorithmException("hash unsupported for HMAC: " + valueOf);
                    }
                    return "HmacSha384";
                }
                return "HmacSha256";
            }
            return "HmacSha224";
        }
        return "HmacSha1";
    }

    public static void zza(zztp zztpVar) {
        zzwn.zza(zza(zztpVar.zzf().zzd()));
        zza(zztpVar.zzf().zze());
        if (zztpVar.zza() == zztj.UNKNOWN_FORMAT) {
            throw new GeneralSecurityException("unknown EC point format");
        }
        zzcu.zza(zztpVar.zzb().zzd());
    }
}
