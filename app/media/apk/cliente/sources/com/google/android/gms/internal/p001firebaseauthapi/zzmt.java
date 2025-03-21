package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.android.gms.internal.p001firebaseauthapi.zzow;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzmt  reason: invalid package */
/* loaded from: classes.dex */
public abstract class zzmt<SerializationT extends zzow> {
    private final zzxr zza;
    private final Class<SerializationT> zzb;

    private zzmt(zzxr zzxrVar, Class<SerializationT> cls) {
        this.zza = zzxrVar;
        this.zzb = cls;
    }

    public static <SerializationT extends zzow> zzmt<SerializationT> zza(zzmv<SerializationT> zzmvVar, zzxr zzxrVar, Class<SerializationT> cls) {
        return new zzms(zzxrVar, cls, zzmvVar);
    }

    public abstract zzbu zza(SerializationT serializationt, zzct zzctVar);

    public final zzxr zza() {
        return this.zza;
    }

    public final Class<SerializationT> zzb() {
        return this.zzb;
    }
}
