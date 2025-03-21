package a1;
/* loaded from: classes.dex */
public final class q {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object a(Object obj, int i5) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException("at index " + i5);
    }

    public static <T> T[] b(T[] tArr, int i5) {
        return (T[]) s.b(tArr, i5);
    }
}
