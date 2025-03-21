package com.google.android.recaptcha.internal;

import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.List;
import t3.k;
/* loaded from: classes.dex */
public final class zzdp implements zzdd {
    public static final zzdp zza = new zzdp();

    private zzdp() {
    }

    @Override // com.google.android.recaptcha.internal.zzdd
    public final void zza(int i5, zzcj zzcjVar, zzpq... zzpqVarArr) {
        List N;
        int length = zzpqVarArr.length;
        if (length == 0) {
            throw new zzae(4, 3, null);
        }
        Constructor<?> zza2 = zzcjVar.zzc().zza(zzpqVarArr[0]);
        if (true != (zza2 instanceof Object)) {
            zza2 = null;
        }
        if (zza2 == null) {
            throw new zzae(4, 5, null);
        }
        Constructor<?> constructor = zza2 instanceof Constructor ? zza2 : zza2.getClass().getConstructor(new Class[0]);
        zzck zzc = zzcjVar.zzc();
        N = k.N(zzpqVarArr);
        Object[] zzh = zzc.zzh(N.subList(1, length));
        try {
            zzcjVar.zzc().zzf(i5, constructor.newInstance(Arrays.copyOf(zzh, zzh.length)));
        } catch (Exception e5) {
            throw new zzae(6, 14, e5);
        }
    }
}
