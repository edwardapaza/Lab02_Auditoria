package com.google.android.recaptcha.internal;

import e4.k;
import java.util.Arrays;
/* loaded from: classes.dex */
public final class zzbb {
    private final zzne zza;
    private final String zzb;
    private final String zzc;
    private final String zzd;
    private final String zze = null;

    public zzbb(zzne zzneVar, String str, String str2, String str3, String str4) {
        this.zza = zzneVar;
        this.zzb = str;
        this.zzc = str2;
        this.zzd = str3;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzbb) {
            zzbb zzbbVar = (zzbb) obj;
            return zzbbVar.zza == this.zza && k.a(zzbbVar.zzb, this.zzb) && k.a(zzbbVar.zzc, this.zzc) && k.a(zzbbVar.zzd, this.zzd) && k.a(null, null);
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.zza, this.zzb, this.zzc, this.zzd, null});
    }

    public final zzne zza() {
        return this.zza;
    }

    public final String zzb() {
        return this.zzb;
    }

    public final String zzc() {
        return this.zzc;
    }

    public final String zzd() {
        return this.zzd;
    }
}
