package c1;
/* loaded from: classes.dex */
final class c {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(boolean z4, String str, long j5, long j6) {
        if (z4) {
            return;
        }
        throw new ArithmeticException("overflow: " + str + "(" + j5 + ", " + j6 + ")");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int b(String str, int i5) {
        if (i5 > 0) {
            return i5;
        }
        throw new IllegalArgumentException(str + " (" + i5 + ") must be > 0");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void c(boolean z4) {
        if (!z4) {
            throw new ArithmeticException("mode was UNNECESSARY, but rounding was necessary");
        }
    }
}
