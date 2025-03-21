package com.google.android.gms.internal.p001firebaseauthapi;

import java.util.concurrent.atomic.AtomicReference;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzno  reason: invalid package */
/* loaded from: classes.dex */
public final class zzno {
    private static final zzno zza = new zzno();
    private static final zznr zzb = new zznr();
    private final AtomicReference<zzrq> zzc = new AtomicReference<>();

    public static zzno zza() {
        return zza;
    }

    public final zzrq zzb() {
        zzrq zzrqVar = this.zzc.get();
        return zzrqVar == null ? zzb : zzrqVar;
    }
}
