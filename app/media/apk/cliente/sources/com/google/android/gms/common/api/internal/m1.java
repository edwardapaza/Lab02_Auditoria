package com.google.android.gms.common.api.internal;

import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes.dex */
public final /* synthetic */ class m1 {
    public static /* synthetic */ boolean a(AtomicReference atomicReference, Object obj, Object obj2) {
        while (!atomicReference.compareAndSet(obj, obj2)) {
            if (atomicReference.get() != obj) {
                return false;
            }
        }
        return true;
    }
}
