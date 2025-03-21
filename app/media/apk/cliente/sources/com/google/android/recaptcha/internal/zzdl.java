package com.google.android.recaptcha.internal;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import t3.k;
/* loaded from: classes.dex */
public final class zzdl implements zzdd {
    public static final zzdl zza = new zzdl();

    private zzdl() {
    }

    @Override // com.google.android.recaptcha.internal.zzdd
    public final void zza(int i5, zzcj zzcjVar, zzpq... zzpqVarArr) {
        List N;
        int length = zzpqVarArr.length;
        if (length < 2) {
            throw new zzae(4, 3, null);
        }
        Object zza2 = zzcjVar.zzc().zza(zzpqVarArr[0]);
        if (true != (zza2 instanceof Method)) {
            zza2 = null;
        }
        Method method = (Method) zza2;
        if (method == null) {
            throw new zzae(4, 5, null);
        }
        Object zza3 = zzcjVar.zzc().zza(zzpqVarArr[1]);
        zzck zzc = zzcjVar.zzc();
        N = k.N(zzpqVarArr);
        Object[] zzh = zzc.zzh(N.subList(2, length));
        try {
            zzcjVar.zzc().zzf(i5, method.invoke(zza3, Arrays.copyOf(zzh, zzh.length)));
        } catch (Exception e5) {
            throw new zzae(6, 15, e5);
        }
    }
}
