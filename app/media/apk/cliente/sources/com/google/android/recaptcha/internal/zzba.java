package com.google.android.recaptcha.internal;

import e4.k;
/* loaded from: classes.dex */
public final class zzba {
    private final String zza;
    private final long zzb;
    private final int zzc;

    public zzba(String str, long j5, int i5) {
        this.zza = str;
        this.zzb = j5;
        this.zzc = i5;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzba) {
            zzba zzbaVar = (zzba) obj;
            return k.a(zzbaVar.zza, this.zza) && zzbaVar.zzb == this.zzb && zzbaVar.zzc == this.zzc;
        }
        return false;
    }

    public final int zza() {
        return this.zzc;
    }

    public final long zzb() {
        return this.zzb;
    }

    public final String zzc() {
        return this.zza;
    }
}
