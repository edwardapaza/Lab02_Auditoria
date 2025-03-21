package q0;

import com.google.android.gms.common.internal.p;
/* loaded from: classes.dex */
public final class b {
    public static boolean a(int[] iArr, int i5) {
        if (iArr != null) {
            for (int i6 : iArr) {
                if (i6 == i5) {
                    return true;
                }
            }
        }
        return false;
    }

    public static <T> boolean b(T[] tArr, T t5) {
        int length = tArr != null ? tArr.length : 0;
        int i5 = 0;
        while (true) {
            if (i5 >= length) {
                break;
            } else if (!p.a(tArr[i5], t5)) {
                i5++;
            } else if (i5 >= 0) {
                return true;
            }
        }
        return false;
    }
}
