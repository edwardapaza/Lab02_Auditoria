package com.google.android.recaptcha.internal;

import e4.k;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes.dex */
public final class zzdi implements zzdd {
    public static final zzdi zza = new zzdi();

    private zzdi() {
    }

    @Override // com.google.android.recaptcha.internal.zzdd
    public final void zza(int i5, zzcj zzcjVar, zzpq... zzpqVarArr) {
        List N;
        int length = zzpqVarArr.length;
        if (length < 2) {
            throw new zzae(4, 3, null);
        }
        Class<?> zza2 = zzcjVar.zzc().zza(zzpqVarArr[0]);
        if (true != (zza2 instanceof Object)) {
            zza2 = null;
        }
        if (zza2 == null) {
            throw new zzae(4, 5, null);
        }
        Class<?> cls = zza2 instanceof Class ? zza2 : zza2.getClass();
        Object zza3 = zzcjVar.zzc().zza(zzpqVarArr[1]);
        if (true != (zza3 instanceof String)) {
            zza3 = null;
        }
        String str = (String) zza3;
        if (str == null) {
            throw new zzae(4, 5, null);
        }
        String zza4 = zzcjVar.zzh().zza(str);
        if (k.a(zza4, "forName")) {
            throw new zzae(6, 48, null);
        }
        zzck zzc = zzcjVar.zzc();
        N = t3.k.N(zzpqVarArr);
        Class[] zzg = zzc.zzg(N.subList(2, length));
        try {
            zzcjVar.zzc().zzf(i5, cls.getMethod(zza4, (Class[]) Arrays.copyOf(zzg, zzg.length)));
        } catch (Exception e5) {
            throw new zzae(6, 13, e5);
        }
    }
}
