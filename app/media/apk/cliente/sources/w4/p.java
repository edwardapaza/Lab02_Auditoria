package w4;

import java.nio.charset.Charset;
/* loaded from: classes.dex */
final class p {

    /* renamed from: a  reason: collision with root package name */
    public static final Charset f8316a = Charset.forName("UTF-8");

    public static boolean a(byte[] bArr, int i5, byte[] bArr2, int i6, int i7) {
        for (int i8 = 0; i8 < i7; i8++) {
            if (bArr[i8 + i5] != bArr2[i8 + i6]) {
                return false;
            }
        }
        return true;
    }

    public static void b(long j5, long j6, long j7) {
        if ((j6 | j7) < 0 || j6 > j5 || j5 - j6 < j7) {
            throw new ArrayIndexOutOfBoundsException(String.format("size=%s offset=%s byteCount=%s", Long.valueOf(j5), Long.valueOf(j6), Long.valueOf(j7)));
        }
    }

    public static void c(Throwable th) {
        d(th);
    }

    private static <T extends Throwable> void d(Throwable th) {
        throw th;
    }
}
