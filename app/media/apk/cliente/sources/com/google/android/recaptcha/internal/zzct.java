package com.google.android.recaptcha.internal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import t3.k;
import t3.q;
/* loaded from: classes.dex */
public final class zzct implements zzdd {
    public static final zzct zza = new zzct();

    private zzct() {
    }

    private static final boolean zzb(List list) {
        int k5;
        k5 = q.k(list, 10);
        ArrayList arrayList = new ArrayList(k5);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(Boolean.valueOf(((zzpq) it.next()).zzN()));
        }
        return !arrayList.contains(Boolean.FALSE);
    }

    @Override // com.google.android.recaptcha.internal.zzdd
    public final void zza(int i5, zzcj zzcjVar, zzpq... zzpqVarArr) {
        List N;
        N = k.N(zzpqVarArr);
        if (!zzb(N)) {
            throw new zzae(4, 5, null);
        }
        for (zzpq zzpqVar : zzpqVarArr) {
            zzcjVar.zzc().zzb(zzpqVar.zzi());
        }
    }
}
