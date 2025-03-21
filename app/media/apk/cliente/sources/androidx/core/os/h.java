package androidx.core.os;

import android.os.Build;
import android.os.LocaleList;
import java.util.Locale;
/* loaded from: classes.dex */
public final class h {

    /* renamed from: b  reason: collision with root package name */
    private static final h f427b = a(new Locale[0]);

    /* renamed from: a  reason: collision with root package name */
    private final j f428a;

    /* loaded from: classes.dex */
    static class a {

        /* renamed from: a  reason: collision with root package name */
        private static final Locale[] f429a = {new Locale("en", "XA"), new Locale("ar", "XB")};

        static Locale a(String str) {
            return Locale.forLanguageTag(str);
        }

        private static boolean b(Locale locale) {
            for (Locale locale2 : f429a) {
                if (locale2.equals(locale)) {
                    return true;
                }
            }
            return false;
        }

        static boolean c(Locale locale, Locale locale2) {
            if (locale.equals(locale2)) {
                return true;
            }
            if (!locale.getLanguage().equals(locale2.getLanguage()) || b(locale) || b(locale2)) {
                return false;
            }
            String a5 = androidx.core.text.a.a(locale);
            if (a5.isEmpty()) {
                String country = locale.getCountry();
                return country.isEmpty() || country.equals(locale2.getCountry());
            }
            return a5.equals(androidx.core.text.a.a(locale2));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class b {
        static LocaleList a(Locale... localeArr) {
            return new LocaleList(localeArr);
        }

        static LocaleList b() {
            return LocaleList.getAdjustedDefault();
        }

        static LocaleList c() {
            return LocaleList.getDefault();
        }
    }

    private h(j jVar) {
        this.f428a = jVar;
    }

    public static h a(Locale... localeArr) {
        return Build.VERSION.SDK_INT >= 24 ? h(b.a(localeArr)) : new h(new i(localeArr));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Locale b(String str) {
        if (str.contains("-")) {
            String[] split = str.split("-", -1);
            if (split.length > 2) {
                return new Locale(split[0], split[1], split[2]);
            }
            if (split.length > 1) {
                return new Locale(split[0], split[1]);
            }
            if (split.length == 1) {
                return new Locale(split[0]);
            }
        } else if (!str.contains("_")) {
            return new Locale(str);
        } else {
            String[] split2 = str.split("_", -1);
            if (split2.length > 2) {
                return new Locale(split2[0], split2[1], split2[2]);
            }
            if (split2.length > 1) {
                return new Locale(split2[0], split2[1]);
            }
            if (split2.length == 1) {
                return new Locale(split2[0]);
            }
        }
        throw new IllegalArgumentException("Can not parse language tag: [" + str + "]");
    }

    public static h c(String str) {
        if (str == null || str.isEmpty()) {
            return e();
        }
        String[] split = str.split(",", -1);
        int length = split.length;
        Locale[] localeArr = new Locale[length];
        for (int i5 = 0; i5 < length; i5++) {
            localeArr[i5] = a.a(split[i5]);
        }
        return a(localeArr);
    }

    public static h e() {
        return f427b;
    }

    public static h h(LocaleList localeList) {
        return new h(new k(localeList));
    }

    public Locale d(int i5) {
        return this.f428a.get(i5);
    }

    public boolean equals(Object obj) {
        return (obj instanceof h) && this.f428a.equals(((h) obj).f428a);
    }

    public boolean f() {
        return this.f428a.isEmpty();
    }

    public Object g() {
        return this.f428a.a();
    }

    public int hashCode() {
        return this.f428a.hashCode();
    }

    public String toString() {
        return this.f428a.toString();
    }
}
