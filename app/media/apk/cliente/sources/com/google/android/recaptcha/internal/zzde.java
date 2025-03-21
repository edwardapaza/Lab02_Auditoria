package com.google.android.recaptcha.internal;

import java.util.ArrayList;
import java.util.List;
import t3.k;
import t3.q;
/* loaded from: classes.dex */
public final class zzde implements zzdd {
    public static final zzde zza = new zzde();

    private zzde() {
    }

    private static final List zzc(Object obj) {
        List J;
        List K;
        List M;
        List L;
        List O;
        List I;
        if (obj instanceof byte[]) {
            I = k.I((byte[]) obj);
            return I;
        } else if (obj instanceof short[]) {
            O = k.O((short[]) obj);
            return O;
        } else if (obj instanceof int[]) {
            L = k.L((int[]) obj);
            return L;
        } else if (obj instanceof long[]) {
            M = k.M((long[]) obj);
            return M;
        } else if (obj instanceof float[]) {
            K = k.K((float[]) obj);
            return K;
        } else if (obj instanceof double[]) {
            J = k.J((double[]) obj);
            return J;
        } else {
            return null;
        }
    }

    @Override // com.google.android.recaptcha.internal.zzdd
    public final void zza(int i5, zzcj zzcjVar, zzpq... zzpqVarArr) {
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
        if (true != (zza3 instanceof Object)) {
            zza3 = null;
        }
        if (zza3 == null) {
            throw new zzae(4, 5, null);
        }
        zzcjVar.zzc().zzf(i5, zzb(zza2, zza3));
    }

    public final Object zzb(Object obj, Object obj2) {
        int k5;
        int k6;
        List<Number> zzc = zzc(obj);
        List<Number> zzc2 = zzc(obj2);
        if (obj instanceof Number) {
            if (obj2 instanceof Number) {
                return Double.valueOf(Math.pow(((Number) obj).doubleValue(), ((Number) obj2).doubleValue()));
            }
            if (zzc2 != null) {
                k6 = q.k(zzc2, 10);
                ArrayList arrayList = new ArrayList(k6);
                for (Number number : zzc2) {
                    arrayList.add(Double.valueOf(Math.pow(number.doubleValue(), ((Number) obj).doubleValue())));
                }
                return arrayList.toArray(new Double[0]);
            }
        }
        if (zzc != null && (obj2 instanceof Number)) {
            k5 = q.k(zzc, 10);
            ArrayList arrayList2 = new ArrayList(k5);
            for (Number number2 : zzc) {
                arrayList2.add(Double.valueOf(Math.pow(number2.doubleValue(), ((Number) obj2).doubleValue())));
            }
            return arrayList2.toArray(new Double[0]);
        } else if (zzc == null || zzc2 == null) {
            throw new zzae(4, 5, null);
        } else {
            zzdc.zza(this, zzc.size(), zzc2.size());
            int size = zzc.size();
            Double[] dArr = new Double[size];
            for (int i5 = 0; i5 < size; i5++) {
                dArr[i5] = Double.valueOf(Math.pow(((Number) zzc.get(i5)).doubleValue(), ((Number) zzc2.get(i5)).doubleValue()));
            }
            return dArr;
        }
    }
}
