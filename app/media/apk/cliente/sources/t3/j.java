package t3;

import java.util.Arrays;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j extends i {
    public static <T> List<T> b(T[] tArr) {
        e4.k.e(tArr, "<this>");
        List<T> a5 = l.a(tArr);
        e4.k.d(a5, "asList(this)");
        return a5;
    }

    public static byte[] c(byte[] bArr, byte[] bArr2, int i5, int i6, int i7) {
        e4.k.e(bArr, "<this>");
        e4.k.e(bArr2, "destination");
        System.arraycopy(bArr, i6, bArr2, i5, i7 - i6);
        return bArr2;
    }

    public static final <T> T[] d(T[] tArr, T[] tArr2, int i5, int i6, int i7) {
        e4.k.e(tArr, "<this>");
        e4.k.e(tArr2, "destination");
        System.arraycopy(tArr, i6, tArr2, i5, i7 - i6);
        return tArr2;
    }

    public static /* synthetic */ Object[] e(Object[] objArr, Object[] objArr2, int i5, int i6, int i7, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            i5 = 0;
        }
        if ((i8 & 4) != 0) {
            i6 = 0;
        }
        if ((i8 & 8) != 0) {
            i7 = objArr.length;
        }
        return d(objArr, objArr2, i5, i6, i7);
    }

    public static final <T> void f(T[] tArr, T t5, int i5, int i6) {
        e4.k.e(tArr, "<this>");
        Arrays.fill(tArr, i5, i6, t5);
    }
}
