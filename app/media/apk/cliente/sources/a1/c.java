package a1;
/* loaded from: classes.dex */
final class c {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Object obj, Object obj2) {
        if (obj == null) {
            throw new NullPointerException("null key in entry: null=" + obj2);
        } else if (obj2 != null) {
        } else {
            throw new NullPointerException("null value in entry: " + obj + "=null");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int b(int i5, String str) {
        if (i5 >= 0) {
            return i5;
        }
        throw new IllegalArgumentException(str + " cannot be negative but was: " + i5);
    }
}
