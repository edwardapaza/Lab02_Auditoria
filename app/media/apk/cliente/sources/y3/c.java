package y3;
/* loaded from: classes.dex */
public final class c {
    private static final int a(int i5, int i6, int i7) {
        return e(e(i5, i7) - e(i6, i7), i7);
    }

    private static final long b(long j5, long j6, long j7) {
        return f(f(j5, j7) - f(j6, j7), j7);
    }

    public static final int c(int i5, int i6, int i7) {
        if (i7 > 0) {
            return i5 >= i6 ? i6 : i6 - a(i6, i5, i7);
        } else if (i7 < 0) {
            return i5 <= i6 ? i6 : i6 + a(i5, i6, -i7);
        } else {
            throw new IllegalArgumentException("Step is zero.");
        }
    }

    public static final long d(long j5, long j6, long j7) {
        int i5 = (j7 > 0L ? 1 : (j7 == 0L ? 0 : -1));
        if (i5 > 0) {
            return j5 >= j6 ? j6 : j6 - b(j6, j5, j7);
        } else if (i5 < 0) {
            return j5 <= j6 ? j6 : j6 + b(j5, j6, -j7);
        } else {
            throw new IllegalArgumentException("Step is zero.");
        }
    }

    private static final int e(int i5, int i6) {
        int i7 = i5 % i6;
        return i7 >= 0 ? i7 : i7 + i6;
    }

    private static final long f(long j5, long j6) {
        long j7 = j5 % j6;
        return j7 >= 0 ? j7 : j7 + j6;
    }
}
