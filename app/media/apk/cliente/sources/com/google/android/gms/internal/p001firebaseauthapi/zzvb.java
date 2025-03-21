package com.google.android.gms.internal.p001firebaseauthapi;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzvb  reason: invalid package */
/* loaded from: classes.dex */
public enum zzvb implements zzajf {
    UNKNOWN_STATUS(0),
    ENABLED(1),
    DISABLED(2),
    DESTROYED(3),
    UNRECOGNIZED(-1);
    
    private static final zzaje<zzvb> zzf = new zzaje<zzvb>() { // from class: com.google.android.gms.internal.firebase-auth-api.zzva
    };
    private final int zzh;

    zzvb(int i5) {
        this.zzh = i5;
    }

    public static zzvb zza(int i5) {
        if (i5 != 0) {
            if (i5 != 1) {
                if (i5 != 2) {
                    if (i5 != 3) {
                        return null;
                    }
                    return DESTROYED;
                }
                return DISABLED;
            }
            return ENABLED;
        }
        return UNKNOWN_STATUS;
    }

    @Override // java.lang.Enum
    public final String toString() {
        StringBuilder sb = new StringBuilder("<");
        sb.append(zzvb.class.getName());
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
