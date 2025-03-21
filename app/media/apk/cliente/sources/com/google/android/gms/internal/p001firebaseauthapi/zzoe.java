package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.android.gms.internal.p001firebaseauthapi.zzbu;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzoe  reason: invalid package */
/* loaded from: classes.dex */
public abstract class zzoe<KeyT extends zzbu, PrimitiveT> {
    private final Class<KeyT> zza;
    private final Class<PrimitiveT> zzb;

    private zzoe(Class<KeyT> cls, Class<PrimitiveT> cls2) {
        this.zza = cls;
        this.zzb = cls2;
    }

    public static <KeyT extends zzbu, PrimitiveT> zzoe<KeyT, PrimitiveT> zza(zzog<KeyT, PrimitiveT> zzogVar, Class<KeyT> cls, Class<PrimitiveT> cls2) {
        return new zzoh(cls, cls2, zzogVar);
    }

    public final Class<KeyT> zza() {
        return this.zza;
    }

    public abstract PrimitiveT zza(KeyT keyt);

    public final Class<PrimitiveT> zzb() {
        return this.zzb;
    }
}
