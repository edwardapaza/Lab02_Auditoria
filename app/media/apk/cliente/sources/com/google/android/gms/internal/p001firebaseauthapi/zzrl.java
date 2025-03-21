package com.google.android.gms.internal.p001firebaseauthapi;

import java.util.Map;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzrl  reason: invalid package */
/* loaded from: classes.dex */
public final class zzrl {
    public static final zzrl zza = new zzro().zza();
    private final Map<String, String> zzb;

    private zzrl(Map<String, String> map) {
        this.zzb = map;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzrl) {
            return this.zzb.equals(((zzrl) obj).zzb);
        }
        return false;
    }

    public final int hashCode() {
        return this.zzb.hashCode();
    }

    public final String toString() {
        return this.zzb.toString();
    }

    public final Map<String, String> zza() {
        return this.zzb;
    }
}
