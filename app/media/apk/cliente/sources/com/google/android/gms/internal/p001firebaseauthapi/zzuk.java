package com.google.android.gms.internal.p001firebaseauthapi;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzuk  reason: invalid package */
/* loaded from: classes.dex */
public enum zzuk implements zzajf {
    KDF_UNKNOWN(0),
    HKDF_SHA256(1),
    HKDF_SHA384(2),
    HKDF_SHA512(3),
    UNRECOGNIZED(-1);
    
    private static final zzaje<zzuk> zzf = new zzaje<zzuk>() { // from class: com.google.android.gms.internal.firebase-auth-api.zzun
    };
    private final int zzh;

    zzuk(int i5) {
        this.zzh = i5;
    }

    public static zzuk zza(int i5) {
        if (i5 != 0) {
            if (i5 != 1) {
                if (i5 != 2) {
                    if (i5 != 3) {
                        return null;
                    }
                    return HKDF_SHA512;
                }
                return HKDF_SHA384;
            }
            return HKDF_SHA256;
        }
        return KDF_UNKNOWN;
    }

    @Override // java.lang.Enum
    public final String toString() {
        StringBuilder sb = new StringBuilder("<");
        sb.append(zzuk.class.getName());
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
            return this.zzh;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
