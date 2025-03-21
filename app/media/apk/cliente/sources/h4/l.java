package h4;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l extends k {
    public static int a(int i5, int i6) {
        return i5 < i6 ? i6 : i5;
    }

    public static long b(long j5, long j6) {
        return j5 < j6 ? j6 : j5;
    }

    public static int c(int i5, int i6) {
        return i5 > i6 ? i6 : i5;
    }

    public static long d(long j5, long j6) {
        return j5 > j6 ? j6 : j5;
    }

    public static int e(int i5, int i6, int i7) {
        if (i6 <= i7) {
            return i5 < i6 ? i6 : i5 > i7 ? i7 : i5;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + i7 + " is less than minimum " + i6 + '.');
    }

    public static long f(long j5, long j6, long j7) {
        if (j6 <= j7) {
            return j5 < j6 ? j6 : j5 > j7 ? j7 : j5;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + j7 + " is less than minimum " + j6 + '.');
    }

    public static d g(int i5, int i6) {
        return d.f3126d.a(i5, i6, -1);
    }

    public static f h(int i5, int i6) {
        return i6 <= Integer.MIN_VALUE ? f.f3134e.a() : new f(i5, i6 - 1);
    }
}
