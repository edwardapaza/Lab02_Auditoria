package a1;

import java.util.Arrays;
/* loaded from: classes.dex */
final class s {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> T[] a(Object[] objArr, int i5, int i6, T[] tArr) {
        return (T[]) Arrays.copyOfRange(objArr, i5, i6, tArr.getClass());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> T[] b(T[] tArr, int i5) {
        if (tArr.length != 0) {
            tArr = (T[]) Arrays.copyOf(tArr, 0);
        }
        return (T[]) Arrays.copyOf(tArr, i5);
    }
}
