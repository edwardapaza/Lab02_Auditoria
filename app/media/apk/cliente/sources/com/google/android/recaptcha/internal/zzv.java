package com.google.android.recaptcha.internal;

import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public final class zzv {
    public static final zzv zza = new zzv();
    private static final ConcurrentHashMap zzb = new ConcurrentHashMap();

    private zzv() {
    }

    public static final void zza(int i5, long j5) {
        ConcurrentHashMap concurrentHashMap = zzb;
        Integer valueOf = Integer.valueOf(i5);
        Object obj = concurrentHashMap.get(valueOf);
        if (obj == null) {
            obj = new zzu();
        }
        zzu zzuVar = (zzu) obj;
        zzuVar.zzg(zzuVar.zzb() + 1);
        zzuVar.zzf(zzuVar.zzd() + j5);
        zzuVar.zze(Math.max(j5, zzuVar.zzc()));
        concurrentHashMap.put(valueOf, zzuVar);
    }
}
