package y0;
/* loaded from: classes.dex */
public final class a {
    public static int a(long j5, long j6) {
        int i5 = (j5 > j6 ? 1 : (j5 == j6 ? 0 : -1));
        if (i5 < 0) {
            return -1;
        }
        return i5 > 0 ? 1 : 0;
    }

    public static int b(double d5, long j5) {
        if (!Double.isNaN(d5) && d5 >= -9.223372036854776E18d) {
            if (d5 >= 9.223372036854776E18d) {
                return 1;
            }
            int a5 = a((long) d5, j5);
            return a5 != 0 ? a5 : c(d5, j5);
        }
        return -1;
    }

    public static int c(double d5, double d6) {
        if (d5 < d6) {
            return -1;
        }
        int i5 = (d5 > d6 ? 1 : (d5 == d6 ? 0 : -1));
        if (i5 > 0) {
            return 1;
        }
        if (i5 == 0) {
            return 0;
        }
        if (Double.isNaN(d6)) {
            return !Double.isNaN(d5) ? 1 : 0;
        }
        return -1;
    }
}
