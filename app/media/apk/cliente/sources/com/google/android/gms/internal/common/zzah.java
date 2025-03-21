package com.google.android.gms.internal.common;

import org.jspecify.nullness.NullMarked;
@NullMarked
/* loaded from: classes.dex */
public final class zzah {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object[] zza(Object[] objArr, int i5) {
        for (int i6 = 0; i6 < i5; i6++) {
            if (objArr[i6] == null) {
                throw new NullPointerException("at index " + i6);
            }
        }
        return objArr;
    }
}
