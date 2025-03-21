package androidx.core.os;

import android.content.res.Configuration;
import android.os.Build;
import android.os.LocaleList;
/* loaded from: classes.dex */
public final class f {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {
        static LocaleList a(Configuration configuration) {
            LocaleList locales;
            locales = configuration.getLocales();
            return locales;
        }

        static void b(Configuration configuration, h hVar) {
            configuration.setLocales((LocaleList) hVar.g());
        }
    }

    public static h a(Configuration configuration) {
        return Build.VERSION.SDK_INT >= 24 ? h.h(a.a(configuration)) : h.a(configuration.locale);
    }

    public static void b(Configuration configuration, h hVar) {
        if (Build.VERSION.SDK_INT >= 24) {
            a.b(configuration, hVar);
        } else if (hVar.f()) {
        } else {
            configuration.setLocale(hVar.d(0));
        }
    }
}
