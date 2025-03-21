package androidx.collection;
/* loaded from: classes.dex */
class c {

    /* renamed from: a  reason: collision with root package name */
    static final int[] f198a = new int[0];

    /* renamed from: b  reason: collision with root package name */
    static final long[] f199b = new long[0];

    /* renamed from: c  reason: collision with root package name */
    static final Object[] f200c = new Object[0];

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(int[] iArr, int i5, int i6) {
        int i7 = i5 - 1;
        int i8 = 0;
        while (i8 <= i7) {
            int i9 = (i8 + i7) >>> 1;
            int i10 = iArr[i9];
            if (i10 < i6) {
                i8 = i9 + 1;
            } else if (i10 <= i6) {
                return i9;
            } else {
                i7 = i9 - 1;
            }
        }
        return ~i8;
    }

    public static boolean b(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static int c(int i5) {
        for (int i6 = 4; i6 < 32; i6++) {
            int i7 = (1 << i6) - 12;
            if (i5 <= i7) {
                return i7;
            }
        }
        return i5;
    }

    public static int d(int i5) {
        return c(i5 * 4) / 4;
    }
}
