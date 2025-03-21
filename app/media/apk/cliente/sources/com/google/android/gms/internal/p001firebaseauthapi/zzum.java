package com.google.android.gms.internal.p001firebaseauthapi;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzum  reason: invalid package */
/* loaded from: classes.dex */
public enum zzum implements zzajf {
    KEM_UNKNOWN(0),
    DHKEM_X25519_HKDF_SHA256(1),
    DHKEM_P256_HKDF_SHA256(2),
    DHKEM_P384_HKDF_SHA384(3),
    DHKEM_P521_HKDF_SHA512(4),
    UNRECOGNIZED(-1);
    
    private static final zzaje<zzum> zzg = new zzaje<zzum>() { // from class: com.google.android.gms.internal.firebase-auth-api.zzup
    };
    private final int zzi;

    zzum(int i5) {
        this.zzi = i5;
    }

    public static zzum zza(int i5) {
        if (i5 != 0) {
            if (i5 != 1) {
                if (i5 != 2) {
                    if (i5 != 3) {
                        if (i5 != 4) {
                            return null;
                        }
                        return DHKEM_P521_HKDF_SHA512;
                    }
                    return DHKEM_P384_HKDF_SHA384;
                }
                return DHKEM_P256_HKDF_SHA256;
            }
            return DHKEM_X25519_HKDF_SHA256;
        }
        return KEM_UNKNOWN;
    }

    @Override // java.lang.Enum
    public final String toString() {
        StringBuilder sb = new StringBuilder("<");
        sb.append(zzum.class.getName());
        sb.append('@');
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        if (this != UNRECOGNIZED) {
            sb.append(" number=");
            sb.append(zza());
        }
        sb.append(" name=");
        sb.append(name());
        sb.append('>');
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzajf
    public final int zza() {
        if (this != UNRECOGNIZED) {
            return this.zzi;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
