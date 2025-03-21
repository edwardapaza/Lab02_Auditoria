package com.google.android.recaptcha.internal;

import java.util.ArrayList;
/* loaded from: classes.dex */
public final class zzdb implements zzdd {
    public static final zzdb zza = new zzdb();

    private zzdb() {
    }

    @Override // com.google.android.recaptcha.internal.zzdd
    public final void zza(int i5, zzcj zzcjVar, zzpq... zzpqVarArr) {
        Object array;
        if (zzpqVarArr.length != 2) {
            throw new zzae(4, 3, null);
        }
        Object zza2 = zzcjVar.zzc().zza(zzpqVarArr[0]);
        if (true != (zza2 instanceof Object)) {
            zza2 = null;
        }
        if (zza2 == null) {
            throw new zzae(4, 5, null);
        }
        Object zza3 = zzcjVar.zzc().zza(zzpqVarArr[1]);
        if (true != (zza3 instanceof Integer)) {
            zza3 = null;
        }
        Integer num = (Integer) zza3;
        if (num == null) {
            throw new zzae(4, 5, null);
        }
        int intValue = num.intValue();
        try {
            if (zza2 instanceof Integer) {
                array = Integer.valueOf(((Number) zza2).intValue() / intValue);
            } else if (!(zza2 instanceof int[])) {
                throw new zzae(4, 5, null);
            } else {
                int[] iArr = (int[]) zza2;
                ArrayList arrayList = new ArrayList(iArr.length);
                for (int i6 : iArr) {
                    arrayList.add(Integer.valueOf(i6 / intValue));
                }
                array = arrayList.toArray(new Integer[0]);
            }
            zzcjVar.zzc().zzf(i5, array);
        } catch (ArithmeticException e5) {
            throw new zzae(4, 6, e5);
        }
    }
}
