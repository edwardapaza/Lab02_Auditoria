package com.google.android.recaptcha.internal;

import java.util.Collection;
import k4.c;
import t3.k;
import t3.x;
/* loaded from: classes.dex */
public final class zzcv implements zzdd {
    public static final zzcv zza = new zzcv();

    private zzcv() {
    }

    @Override // com.google.android.recaptcha.internal.zzdd
    public final void zza(int i5, zzcj zzcjVar, zzpq... zzpqVarArr) {
        String w5;
        String str;
        if (zzpqVarArr.length != 1) {
            throw new zzae(4, 3, null);
        }
        Object zza2 = zzcjVar.zzc().zza(zzpqVarArr[0]);
        if (true != (zza2 instanceof Object)) {
            zza2 = null;
        }
        if (zza2 == null) {
            throw new zzae(4, 5, null);
        }
        if (zza2 instanceof int[]) {
            w5 = k.B((int[]) zza2, ",", "[", "]", 0, null, null, 56, null);
        } else {
            if (zza2 instanceof byte[]) {
                str = new String((byte[]) zza2, c.f5831b);
            } else if (zza2 instanceof long[]) {
                w5 = k.C((long[]) zza2, ",", "[", "]", 0, null, null, 56, null);
            } else if (zza2 instanceof short[]) {
                w5 = k.E((short[]) zza2, ",", "[", "]", 0, null, null, 56, null);
            } else if (zza2 instanceof float[]) {
                w5 = k.A((float[]) zza2, ",", "[", "]", 0, null, null, 56, null);
            } else if (zza2 instanceof double[]) {
                w5 = k.z((double[]) zza2, ",", "[", "]", 0, null, null, 56, null);
            } else if (zza2 instanceof char[]) {
                str = new String((char[]) zza2);
            } else if (zza2 instanceof Object[]) {
                w5 = k.D((Object[]) zza2, ",", "[", "]", 0, null, null, 56, null);
            } else if (!(zza2 instanceof Collection)) {
                throw new zzae(4, 5, null);
            } else {
                w5 = x.w((Iterable) zza2, ",", "[", "]", 0, null, null, 56, null);
            }
            w5 = str;
        }
        zzcjVar.zzc().zzf(i5, w5);
    }
}
