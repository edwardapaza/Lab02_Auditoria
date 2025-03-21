package r4;

import java.util.concurrent.atomic.AtomicReferenceArray;
/* loaded from: classes.dex */
public final class c0<T> {
    private volatile AtomicReferenceArray<T> array;

    public c0(int i5) {
        this.array = new AtomicReferenceArray<>(i5);
    }

    public final int a() {
        return this.array.length();
    }

    public final T b(int i5) {
        AtomicReferenceArray<T> atomicReferenceArray = this.array;
        if (i5 < atomicReferenceArray.length()) {
            return atomicReferenceArray.get(i5);
        }
        return null;
    }

    public final void c(int i5, T t5) {
        int a5;
        AtomicReferenceArray<T> atomicReferenceArray = this.array;
        int length = atomicReferenceArray.length();
        if (i5 < length) {
            atomicReferenceArray.set(i5, t5);
            return;
        }
        a5 = h4.l.a(i5 + 1, length * 2);
        AtomicReferenceArray<T> atomicReferenceArray2 = new AtomicReferenceArray<>(a5);
        for (int i6 = 0; i6 < length; i6++) {
            atomicReferenceArray2.set(i6, atomicReferenceArray.get(i6));
        }
        atomicReferenceArray2.set(i5, t5);
        this.array = atomicReferenceArray2;
    }
}
