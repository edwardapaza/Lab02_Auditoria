package o4;

import java.util.concurrent.atomic.AtomicReferenceArray;
/* loaded from: classes.dex */
public final /* synthetic */ class i {
    public static /* synthetic */ boolean a(AtomicReferenceArray atomicReferenceArray, int i5, Object obj, Object obj2) {
        while (!atomicReferenceArray.compareAndSet(i5, obj, obj2)) {
            if (atomicReferenceArray.get(i5) != obj) {
                return false;
            }
        }
        return true;
    }
}
