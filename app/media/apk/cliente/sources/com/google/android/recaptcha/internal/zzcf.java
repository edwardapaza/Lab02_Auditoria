package com.google.android.recaptcha.internal;

import d4.p;
import e4.k;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
/* loaded from: classes.dex */
public final class zzcf extends zzce {
    private final p zza;
    private final String zzb;

    public zzcf(p pVar, String str, Object obj) {
        super(obj);
        this.zza = pVar;
        this.zzb = str;
    }

    @Override // com.google.android.recaptcha.internal.zzce
    public final boolean zza(Object obj, Method method, Object[] objArr) {
        Collection f5;
        if (k.a(method.getName(), this.zzb)) {
            zzpi zzf = zzpl.zzf();
            if (objArr != null) {
                f5 = new ArrayList(objArr.length);
                for (Object obj2 : objArr) {
                    zzpj zzf2 = zzpk.zzf();
                    zzf2.zzv(obj2.toString());
                    f5.add((zzpk) zzf2.zzj());
                }
            } else {
                f5 = t3.p.f();
            }
            zzf.zzd(f5);
            p pVar = this.zza;
            byte[] zzd = ((zzpl) zzf.zzj()).zzd();
            pVar.invoke(objArr, zzfy.zzh().zzi(zzd, 0, zzd.length));
            return true;
        }
        return false;
    }
}
