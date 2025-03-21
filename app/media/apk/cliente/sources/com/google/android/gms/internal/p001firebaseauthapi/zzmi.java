package com.google.android.gms.internal.p001firebaseauthapi;

import java.lang.Enum;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzmi  reason: invalid package */
/* loaded from: classes.dex */
public final class zzmi<E extends Enum<E>, O> {
    private Map<E, O> zza;
    private Map<O, E> zzb;

    private zzmi() {
        this.zza = new HashMap();
        this.zzb = new HashMap();
    }

    public final zzmf<E, O> zza() {
        return new zzmf<>(Collections.unmodifiableMap(this.zza), Collections.unmodifiableMap(this.zzb));
    }

    public final zzmi<E, O> zza(E e5, O o5) {
        this.zza.put(e5, o5);
        this.zzb.put(o5, e5);
        return this;
    }
}
