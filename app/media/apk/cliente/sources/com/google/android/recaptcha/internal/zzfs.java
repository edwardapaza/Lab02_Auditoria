package com.google.android.recaptcha.internal;

import java.util.Collection;
import java.util.Iterator;
/* loaded from: classes.dex */
public final class zzfs {
    public static boolean zza(Collection collection, Iterator it) {
        it.getClass();
        boolean z4 = false;
        while (it.hasNext()) {
            z4 |= collection.add(it.next());
        }
        return z4;
    }
}
