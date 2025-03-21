package w;

import android.os.Trace;
/* loaded from: classes.dex */
final class f {
    public static void a(String str, int i5) {
        Trace.beginAsyncSection(str, i5);
    }

    public static void b(String str, int i5) {
        Trace.endAsyncSection(str, i5);
    }

    public static boolean c() {
        boolean isEnabled;
        isEnabled = Trace.isEnabled();
        return isEnabled;
    }
}
