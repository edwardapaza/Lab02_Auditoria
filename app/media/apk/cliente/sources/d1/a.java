package d1;

import com.google.android.gms.common.api.a;
/* loaded from: classes.dex */
public final class a extends b {
    public static int a(long j5) {
        if (j5 > 2147483647L) {
            return a.e.API_PRIORITY_OTHER;
        }
        if (j5 < -2147483648L) {
            return Integer.MIN_VALUE;
        }
        return (int) j5;
    }
}
