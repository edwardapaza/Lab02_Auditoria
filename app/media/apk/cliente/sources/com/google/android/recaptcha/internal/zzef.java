package com.google.android.recaptcha.internal;

import java.util.Iterator;
import java.util.List;
import t3.k;
import t3.p;
import t3.x;
/* loaded from: classes.dex */
public final class zzef {
    private List zza;

    public zzef() {
        List f5;
        f5 = p.f();
        this.zza = f5;
    }

    public final long zza(long[] jArr) {
        List M;
        List z4;
        List list = this.zza;
        M = k.M(jArr);
        z4 = x.z(list, M);
        Iterator it = z4.iterator();
        if (it.hasNext()) {
            Object next = it.next();
            while (it.hasNext()) {
                next = Long.valueOf(((Number) next).longValue() ^ ((Number) it.next()).longValue());
            }
            return ((Number) next).longValue();
        }
        throw new UnsupportedOperationException("Empty collection can't be reduced.");
    }

    public final void zzb(long[] jArr) {
        List M;
        M = k.M(jArr);
        this.zza = M;
    }
}
