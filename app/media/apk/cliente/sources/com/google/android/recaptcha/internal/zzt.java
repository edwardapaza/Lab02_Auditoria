package com.google.android.recaptcha.internal;

import m4.i;
import m4.j0;
import m4.k0;
import m4.r2;
import m4.z0;
/* loaded from: classes.dex */
public final class zzt {
    public static final zzr zza = new zzr(null);
    private final j0 zzb = k0.b();
    private final j0 zzc;
    private final j0 zzd;

    public zzt() {
        j0 a5 = k0.a(r2.b("reCaptcha"));
        i.d(a5, null, null, new zzs(null), 3, null);
        this.zzc = a5;
        this.zzd = k0.a(z0.b());
    }

    public final j0 zza() {
        return this.zzd;
    }

    public final j0 zzb() {
        return this.zzb;
    }

    public final j0 zzc() {
        return this.zzc;
    }
}
