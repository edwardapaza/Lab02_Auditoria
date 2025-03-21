package com.google.android.recaptcha.internal;

import java.lang.reflect.Proxy;
/* loaded from: classes.dex */
public final class zzcy implements zzdd {
    public static final zzcy zza = new zzcy();

    private zzcy() {
    }

    @Override // com.google.android.recaptcha.internal.zzdd
    public final void zza(int i5, zzcj zzcjVar, zzpq... zzpqVarArr) {
        int i6;
        int length = zzpqVarArr.length;
        if (length != 4 && length != 5) {
            throw new zzae(4, 3, null);
        }
        Object zza2 = zzcjVar.zzc().zza(zzpqVarArr[0]);
        if (true != (zza2 instanceof String)) {
            zza2 = null;
        }
        String str = (String) zza2;
        if (str == null) {
            throw new zzae(4, 5, null);
        }
        Object zza3 = zzcjVar.zzc().zza(zzpqVarArr[1]);
        if (true != (zza3 instanceof Object)) {
            zza3 = null;
        }
        if (zza3 == null) {
            throw new zzae(4, 5, null);
        }
        Object zza4 = zzcjVar.zzc().zza(zzpqVarArr[2]);
        if (true != (zza4 instanceof String)) {
            zza4 = null;
        }
        String str2 = (String) zza4;
        if (str2 == null) {
            throw new zzae(4, 5, null);
        }
        String zza5 = zzcjVar.zzh().zza(str2);
        Object zza6 = zzcjVar.zzc().zza(zzpqVarArr[3]);
        if (length == 5) {
            Object zza7 = zzcjVar.zzc().zza(zzpqVarArr[4]);
            if (true != (zza7 instanceof Integer)) {
                zza7 = null;
            }
            Integer num = (Integer) zza7;
            if (num == null) {
                throw new zzae(4, 5, null);
            }
            i6 = num.intValue();
        } else {
            i6 = -1;
        }
        try {
            if (zza3 instanceof String) {
                zza3 = zzcjVar.zzh().zza((String) zza3);
            }
            Class zza8 = zzci.zza(zza3);
            zzcjVar.zzc().zzf(i5, Proxy.newProxyInstance(zza8.getClassLoader(), new Class[]{zza8}, new zzcf(new zzcx(zzcjVar, str, i6), zza5, zza6)));
        } catch (Exception e5) {
            throw new zzae(6, 20, e5);
        }
    }
}
