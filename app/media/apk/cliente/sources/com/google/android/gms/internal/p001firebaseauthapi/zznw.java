package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.android.gms.internal.p001firebaseauthapi.zzow;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zznw  reason: invalid package */
/* loaded from: classes.dex */
public abstract class zznw<SerializationT extends zzow> {
    private final zzxr zza;
    private final Class<SerializationT> zzb;

    private zznw(zzxr zzxrVar, Class<SerializationT> cls) {
        this.zza = zzxrVar;
        this.zzb = cls;
    }

    public static <SerializationT extends zzow> zznw<SerializationT> zza(zzny<SerializationT> zznyVar, zzxr zzxrVar, Class<SerializationT> cls) {
        return new zznz(zzxrVar, cls, zznyVar);
    }

    public abstract zzci zza(SerializationT serializationt);

    public final zzxr zza() {
        return this.zza;
    }

    public final Class<SerializationT> zzb() {
        return this.zzb;
    }
}
