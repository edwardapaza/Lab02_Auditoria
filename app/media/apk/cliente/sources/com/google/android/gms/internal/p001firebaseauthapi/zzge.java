package com.google.android.gms.internal.p001firebaseauthapi;

import java.util.Objects;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzge  reason: invalid package */
/* loaded from: classes.dex */
public final class zzge extends zzdc {
    private final String zza;

    private zzge(String str) {
        this.zza = str;
    }

    public static zzge zza(String str) {
        return new zzge(str);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzge) {
            return ((zzge) obj).zza.equals(this.zza);
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hash(zzge.class, this.zza);
    }

    public final String toString() {
        String str = this.zza;
        return "LegacyKmsAead Parameters (keyUri: " + str + ")";
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzci
    public final boolean zza() {
        return false;
    }

    public final String zzb() {
        return this.zza;
    }
}
