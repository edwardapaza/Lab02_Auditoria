package com.google.android.gms.internal.common;

import java.util.Iterator;
/* loaded from: classes.dex */
public final class zzad extends zzaa {
    public zzad() {
        super(4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzad(int i5) {
        super(4);
    }

    public final zzad zzb(Object obj) {
        super.zza(obj);
        return this;
    }

    public final zzad zzc(Iterator it) {
        while (it.hasNext()) {
            super.zza(it.next());
        }
        return this;
    }
}
