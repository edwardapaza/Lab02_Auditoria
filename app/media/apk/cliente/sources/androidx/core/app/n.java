package androidx.core.app;

import android.app.LocaleManager;
import android.content.Context;
import android.os.Build;
import android.os.LocaleList;
/* loaded from: classes.dex */
public final class n {

    /* loaded from: classes.dex */
    static class a {
        static LocaleList a(Object obj) {
            return ((LocaleManager) obj).getApplicationLocales();
        }

        static LocaleList b(Object obj) {
            return ((LocaleManager) obj).getSystemLocales();
        }
    }

    public static androidx.core.os.h a(Context context) {
        if (Build.VERSION.SDK_INT >= 33) {
            Object b5 = b(context);
            return b5 != null ? androidx.core.os.h.h(a.a(b5)) : androidx.core.os.h.e();
        }
        return androidx.core.os.h.c(e.a(context));
    }

    private static Object b(Context context) {
        return context.getSystemService("locale");
    }
}
