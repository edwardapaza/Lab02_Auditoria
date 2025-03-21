package androidx.core.text;

import android.icu.util.ULocale;
import android.os.Build;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Locale;
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static Method f437a;

    /* renamed from: androidx.core.text.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    static class C0015a {
        static String a(Locale locale) {
            return locale.getScript();
        }
    }

    /* loaded from: classes.dex */
    static class b {
        static ULocale a(Object obj) {
            return ULocale.addLikelySubtags((ULocale) obj);
        }

        static ULocale b(Locale locale) {
            return ULocale.forLocale(locale);
        }

        static String c(Object obj) {
            return ((ULocale) obj).getScript();
        }
    }

    static {
        if (Build.VERSION.SDK_INT < 24) {
            try {
                f437a = Class.forName("libcore.icu.ICU").getMethod("addLikelySubtags", Locale.class);
            } catch (Exception e5) {
                throw new IllegalStateException(e5);
            }
        }
    }

    public static String a(Locale locale) {
        if (Build.VERSION.SDK_INT >= 24) {
            return b.c(b.a(b.b(locale)));
        }
        try {
            return C0015a.a((Locale) f437a.invoke(null, locale));
        } catch (IllegalAccessException | InvocationTargetException e5) {
            Log.w("ICUCompat", e5);
            return C0015a.a(locale);
        }
    }
}
