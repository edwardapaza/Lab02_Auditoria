package com.google.android.recaptcha.internal;
/* loaded from: classes.dex */
public final class zzae extends Exception {
    private final Throwable zza;
    private final zzpg zzb;
    private final int zzc;
    private final int zzd;

    public zzae(int i5, int i6, Throwable th) {
        this.zzc = i5;
        this.zzd = i6;
        this.zza = th;
        zzpg zzf = zzph.zzf();
        zzf.zze(i6);
        zzf.zzp(i5);
        this.zzb = zzf;
    }

    @Override // java.lang.Throwable
    public final Throwable getCause() {
        return this.zza;
    }

    public final zzpg zza() {
        return this.zzb;
    }

    public final int zzb() {
        return this.zzd;
    }
}
