package com.google.android.gms.internal.p001firebaseauthapi;

import java.util.concurrent.atomic.AtomicReference;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzns  reason: invalid package */
/* loaded from: classes.dex */
public final class zzns {
    private static zzns zza = new zzns();
    private final AtomicReference<zzol> zzb = new AtomicReference<>(new zzok().zza());

    zzns() {
    }

    public static zzns zza() {
        return zza;
    }

    public final <WrapperPrimitiveT> Class<?> zza(Class<WrapperPrimitiveT> cls) {
        return this.zzb.get().zza((Class<?>) cls);
    }

    public final <KeyT extends zzbu, PrimitiveT> PrimitiveT zza(KeyT keyt, Class<PrimitiveT> cls) {
        return (PrimitiveT) this.zzb.get().zza((zzol) keyt, (Class<Object>) cls);
    }

    public final <InputPrimitiveT, WrapperPrimitiveT> WrapperPrimitiveT zza(zzch<InputPrimitiveT> zzchVar, Class<WrapperPrimitiveT> cls) {
        return (WrapperPrimitiveT) this.zzb.get().zza(zzchVar, cls);
    }

    public final synchronized <InputPrimitiveT, WrapperPrimitiveT> void zza(zzcq<InputPrimitiveT, WrapperPrimitiveT> zzcqVar) {
        this.zzb.set(zzol.zza(this.zzb.get()).zza(zzcqVar).zza());
    }

    public final synchronized <KeyT extends zzbu, PrimitiveT> void zza(zzoe<KeyT, PrimitiveT> zzoeVar) {
        this.zzb.set(zzol.zza(this.zzb.get()).zza(zzoeVar).zza());
    }
}
