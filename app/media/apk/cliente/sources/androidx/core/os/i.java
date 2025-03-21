package androidx.core.os;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Locale;
/* loaded from: classes.dex */
final class i implements j {

    /* renamed from: c  reason: collision with root package name */
    private static final Locale[] f430c = new Locale[0];

    /* renamed from: d  reason: collision with root package name */
    private static final Locale f431d = new Locale("en", "XA");

    /* renamed from: e  reason: collision with root package name */
    private static final Locale f432e = new Locale("ar", "XB");

    /* renamed from: f  reason: collision with root package name */
    private static final Locale f433f = h.b("en-Latn");

    /* renamed from: a  reason: collision with root package name */
    private final Locale[] f434a;

    /* renamed from: b  reason: collision with root package name */
    private final String f435b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(Locale... localeArr) {
        String sb;
        if (localeArr.length == 0) {
            this.f434a = f430c;
            sb = "";
        } else {
            ArrayList arrayList = new ArrayList();
            HashSet hashSet = new HashSet();
            StringBuilder sb2 = new StringBuilder();
            for (int i5 = 0; i5 < localeArr.length; i5++) {
                Locale locale = localeArr[i5];
                if (locale == null) {
                    throw new NullPointerException("list[" + i5 + "] is null");
                }
                if (!hashSet.contains(locale)) {
                    Locale locale2 = (Locale) locale.clone();
                    arrayList.add(locale2);
                    b(sb2, locale2);
                    if (i5 < localeArr.length - 1) {
                        sb2.append(',');
                    }
                    hashSet.add(locale2);
                }
            }
            this.f434a = (Locale[]) arrayList.toArray(new Locale[0]);
            sb = sb2.toString();
        }
        this.f435b = sb;
    }

    static void b(StringBuilder sb, Locale locale) {
        sb.append(locale.getLanguage());
        String country = locale.getCountry();
        if (country == null || country.isEmpty()) {
            return;
        }
        sb.append('-');
        sb.append(locale.getCountry());
    }

    @Override // androidx.core.os.j
    public Object a() {
        return null;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        Locale[] localeArr = ((i) obj).f434a;
        if (this.f434a.length != localeArr.length) {
            return false;
        }
        int i5 = 0;
        while (true) {
            Locale[] localeArr2 = this.f434a;
            if (i5 >= localeArr2.length) {
                return true;
            }
            if (!localeArr2[i5].equals(localeArr[i5])) {
                return false;
            }
            i5++;
        }
    }

    @Override // androidx.core.os.j
    public Locale get(int i5) {
        if (i5 >= 0) {
            Locale[] localeArr = this.f434a;
            if (i5 < localeArr.length) {
                return localeArr[i5];
            }
        }
        return null;
    }

    public int hashCode() {
        int i5 = 1;
        for (Locale locale : this.f434a) {
            i5 = (i5 * 31) + locale.hashCode();
        }
        return i5;
    }

    @Override // androidx.core.os.j
    public boolean isEmpty() {
        return this.f434a.length == 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        int i5 = 0;
        while (true) {
            Locale[] localeArr = this.f434a;
            if (i5 >= localeArr.length) {
                sb.append("]");
                return sb.toString();
            }
            sb.append(localeArr[i5]);
            if (i5 < this.f434a.length - 1) {
                sb.append(',');
            }
            i5++;
        }
    }
}
