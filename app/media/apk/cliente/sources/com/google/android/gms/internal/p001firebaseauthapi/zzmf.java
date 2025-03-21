package com.google.android.gms.internal.p001firebaseauthapi;

import java.lang.Enum;
import java.security.GeneralSecurityException;
import java.util.Map;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzmf  reason: invalid package */
/* loaded from: classes.dex */
public final class zzmf<E extends Enum<E>, O> {
    private final Map<E, O> zza;
    private final Map<O, E> zzb;

    private zzmf(Map<E, O> map, Map<O, E> map2) {
        this.zza = map;
        this.zzb = map2;
    }

    public static <E extends Enum<E>, O> zzmi<E, O> zza() {
        return new zzmi<>();
    }

    public final E zza(O o5) {
        E e5 = this.zzb.get(o5);
        if (e5 != null) {
            return e5;
        }
        String valueOf = String.valueOf(o5);
        throw new GeneralSecurityException("Unable to convert object enum: " + valueOf);
    }

    public final O zza(E e5) {
        O o5 = this.zza.get(e5);
        if (o5 != null) {
            return o5;
        }
        String valueOf = String.valueOf(e5);
        throw new GeneralSecurityException("Unable to convert proto enum: " + valueOf);
    }
}
