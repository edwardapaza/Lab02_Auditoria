package z;

import android.util.Log;
import androidx.window.extensions.WindowExtensionsProvider;
import e4.s;
/* loaded from: classes.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    public static final e f8828a = new e();

    /* renamed from: b  reason: collision with root package name */
    private static final String f8829b = s.b(e.class).c();

    private e() {
    }

    public final int a() {
        String str;
        String str2;
        try {
            return WindowExtensionsProvider.getWindowExtensions().getVendorApiLevel();
        } catch (NoClassDefFoundError unused) {
            if (c.f8820a.a() == j.LOG) {
                str = f8829b;
                str2 = "Embedding extension version not found";
                Log.d(str, str2);
                return 0;
            }
            return 0;
        } catch (UnsupportedOperationException unused2) {
            if (c.f8820a.a() == j.LOG) {
                str = f8829b;
                str2 = "Stub Extension";
                Log.d(str, str2);
                return 0;
            }
            return 0;
        }
    }
}
