package com.google.android.recaptcha.internal;

import sun.misc.Unsafe;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class zzlu {
    final Unsafe zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzlu(Unsafe unsafe) {
        this.zza = unsafe;
    }

    public abstract double zza(Object obj, long j5);

    public abstract float zzb(Object obj, long j5);

    public abstract void zzc(Object obj, long j5, boolean z4);

    public abstract void zzd(Object obj, long j5, byte b5);

    public abstract void zze(Object obj, long j5, double d5);

    public abstract void zzf(Object obj, long j5, float f5);

    public abstract boolean zzg(Object obj, long j5);
}
