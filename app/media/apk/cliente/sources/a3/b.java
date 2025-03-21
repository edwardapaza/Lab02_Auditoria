package a3;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.os.LocaleList;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import y2.h;
/* loaded from: classes.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private final h f83a;

    /* renamed from: b  reason: collision with root package name */
    private final Context f84b;

    /* renamed from: c  reason: collision with root package name */
    final h.b f85c;

    /* loaded from: classes.dex */
    class a implements h.b {
        a() {
        }

        @Override // y2.h.b
        public String a(String str, String str2) {
            Context context = b.this.f84b;
            if (str2 != null) {
                Locale b5 = b.b(str2);
                Configuration configuration = new Configuration(b.this.f84b.getResources().getConfiguration());
                configuration.setLocale(b5);
                context = b.this.f84b.createConfigurationContext(configuration);
            }
            int identifier = context.getResources().getIdentifier(str, "string", b.this.f84b.getPackageName());
            if (identifier != 0) {
                return context.getResources().getString(identifier);
            }
            return null;
        }
    }

    public b(Context context, h hVar) {
        a aVar = new a();
        this.f85c = aVar;
        this.f84b = context;
        this.f83a = hVar;
        hVar.c(aVar);
    }

    public static Locale b(String str) {
        String str2;
        String[] split = str.replace('_', '-').split("-", -1);
        String str3 = split[0];
        String str4 = "";
        int i5 = 1;
        if (split.length <= 1 || split[1].length() != 4) {
            str2 = "";
        } else {
            str2 = split[1];
            i5 = 2;
        }
        if (split.length > i5 && split[i5].length() >= 2 && split[i5].length() <= 3) {
            str4 = split[i5];
        }
        return new Locale(str3, str4, str2);
    }

    public Locale c(List<Locale> list) {
        LocaleList locales;
        LocaleList locales2;
        Locale lookup;
        if (list == null || list.isEmpty()) {
            return null;
        }
        int i5 = Build.VERSION.SDK_INT;
        if (i5 >= 26) {
            ArrayList arrayList = new ArrayList();
            locales2 = this.f84b.getResources().getConfiguration().getLocales();
            int size = locales2.size();
            for (int i6 = 0; i6 < size; i6++) {
                Locale locale = locales2.get(i6);
                String language = locale.getLanguage();
                if (!locale.getScript().isEmpty()) {
                    language = language + "-" + locale.getScript();
                }
                if (!locale.getCountry().isEmpty()) {
                    language = language + "-" + locale.getCountry();
                }
                arrayList.add(new Locale.LanguageRange(language));
                arrayList.add(new Locale.LanguageRange(locale.getLanguage()));
                arrayList.add(new Locale.LanguageRange(locale.getLanguage() + "-*"));
            }
            lookup = Locale.lookup(arrayList, list);
            if (lookup != null) {
                return lookup;
            }
        } else if (i5 >= 24) {
            locales = this.f84b.getResources().getConfiguration().getLocales();
            for (int i7 = 0; i7 < locales.size(); i7++) {
                Locale locale2 = locales.get(i7);
                for (Locale locale3 : list) {
                    if (locale2.equals(locale3)) {
                        return locale3;
                    }
                }
                for (Locale locale4 : list) {
                    if (locale2.getLanguage().equals(locale4.toLanguageTag())) {
                        return locale4;
                    }
                }
                for (Locale locale5 : list) {
                    if (locale2.getLanguage().equals(locale5.getLanguage())) {
                        return locale5;
                    }
                }
            }
        } else {
            Locale locale6 = this.f84b.getResources().getConfiguration().locale;
            if (locale6 != null) {
                for (Locale locale7 : list) {
                    if (locale6.equals(locale7)) {
                        return locale7;
                    }
                }
                for (Locale locale8 : list) {
                    if (locale6.getLanguage().equals(locale8.toString())) {
                        return locale8;
                    }
                }
            }
        }
        return list.get(0);
    }

    public void d(Configuration configuration) {
        LocaleList locales;
        ArrayList arrayList = new ArrayList();
        if (Build.VERSION.SDK_INT >= 24) {
            locales = configuration.getLocales();
            int size = locales.size();
            for (int i5 = 0; i5 < size; i5++) {
                arrayList.add(locales.get(i5));
            }
        } else {
            arrayList.add(configuration.locale);
        }
        this.f83a.b(arrayList);
    }
}
