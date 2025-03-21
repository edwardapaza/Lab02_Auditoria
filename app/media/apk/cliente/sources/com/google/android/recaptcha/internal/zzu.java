package com.google.android.recaptcha.internal;

import k4.p;
import u3.b;
/* loaded from: classes.dex */
public final class zzu implements Comparable {
    private int zza;
    private long zzb;
    private long zzc;

    public final String toString() {
        String H;
        String H2;
        String H3;
        String H4;
        H = p.H(String.valueOf(this.zzb / this.zza), 10, (char) 0, 2, null);
        H2 = p.H(String.valueOf(this.zzc), 10, (char) 0, 2, null);
        H3 = p.H(String.valueOf(this.zzb), 10, (char) 0, 2, null);
        H4 = p.H(String.valueOf(this.zza), 5, (char) 0, 2, null);
        return "avgExecutionTime: " + H + " us| maxExecutionTime: " + H2 + " us| totalTime: " + H3 + " us| #Usages: " + H4;
    }

    @Override // java.lang.Comparable
    /* renamed from: zza */
    public final int compareTo(zzu zzuVar) {
        int a5;
        a5 = b.a(Long.valueOf(this.zzb), Long.valueOf(zzuVar.zzb));
        return a5;
    }

    public final int zzb() {
        return this.zza;
    }

    public final long zzc() {
        return this.zzc;
    }

    public final long zzd() {
        return this.zzb;
    }

    public final void zze(long j5) {
        this.zzc = j5;
    }

    public final void zzf(long j5) {
        this.zzb = j5;
    }

    public final void zzg(int i5) {
        this.zza = i5;
    }
}
