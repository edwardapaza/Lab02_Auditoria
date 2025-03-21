package com.google.android.gms.internal.p001firebaseauthapi;

import com.google.android.gms.common.api.a;
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzan  reason: invalid package */
/* loaded from: classes.dex */
public class zzan<E> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zza(int i5, int i6) {
        if (i6 >= 0) {
            int i7 = i5 + (i5 >> 1) + 1;
            if (i7 < i6) {
                i7 = Integer.highestOneBit(i6 - 1) << 1;
            }
            return i7 < 0 ? a.e.API_PRIORITY_OTHER : i7;
        }
        throw new AssertionError("cannot store more than MAX_VALUE elements");
    }
}
