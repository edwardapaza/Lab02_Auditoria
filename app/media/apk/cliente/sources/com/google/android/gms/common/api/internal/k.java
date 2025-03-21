package com.google.android.gms.common.api.internal;

import android.os.Looper;
/* loaded from: classes.dex */
public class k {
    public static <L> j<L> a(L l5, Looper looper, String str) {
        com.google.android.gms.common.internal.q.l(l5, "Listener must not be null");
        com.google.android.gms.common.internal.q.l(looper, "Looper must not be null");
        com.google.android.gms.common.internal.q.l(str, "Listener type must not be null");
        return new j<>(looper, l5, str);
    }
}
