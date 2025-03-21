package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.android.gms.internal.p001firebaseauthapi.zzaja;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzajb  reason: invalid package */
/* loaded from: classes.dex */
final class zzajb implements zzakl {
    private static final zzajb zza = new zzajb();

    private zzajb() {
    }

    public static zzajb zza() {
        return zza;
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzakl
    public final zzaki zza(Class<?> cls) {
        if (!zzaja.class.isAssignableFrom(cls)) {
            String name = cls.getName();
            throw new IllegalArgumentException("Unsupported message type: " + name);
        }
        try {
            return (zzaki) zzaja.zza((Class<zzaja>) cls.asSubclass(zzaja.class)).zza(zzaja.zze.zzc, (Object) null, (Object) null);
        } catch (Exception e5) {
            String name2 = cls.getName();
            throw new RuntimeException("Unable to get message info for " + name2, e5);
        }
    }

    @Override // com.google.android.gms.internal.p001firebaseauthapi.zzakl
    public final boolean zzb(Class<?> cls) {
        return zzaja.class.isAssignableFrom(cls);
    }
}
