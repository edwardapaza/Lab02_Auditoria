package l3;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
/* loaded from: classes.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    private final String[] f5983a;

    /* loaded from: classes.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private final List<String> f5984a = new ArrayList(20);

        private void d(String str, String str2) {
            if (str == null) {
                throw new IllegalArgumentException("name == null");
            }
            if (str.isEmpty()) {
                throw new IllegalArgumentException("name is empty");
            }
            int length = str.length();
            for (int i5 = 0; i5 < length; i5++) {
                char charAt = str.charAt(i5);
                if (charAt <= 31 || charAt >= 127) {
                    throw new IllegalArgumentException(String.format(Locale.US, "Unexpected char %#04x at %d in header name: %s", Integer.valueOf(charAt), Integer.valueOf(i5), str));
                }
            }
            if (str2 == null) {
                throw new IllegalArgumentException("value == null");
            }
            int length2 = str2.length();
            for (int i6 = 0; i6 < length2; i6++) {
                char charAt2 = str2.charAt(i6);
                if (charAt2 <= 31 || charAt2 >= 127) {
                    throw new IllegalArgumentException(String.format(Locale.US, "Unexpected char %#04x at %d in header value: %s", Integer.valueOf(charAt2), Integer.valueOf(i6), str2));
                }
            }
        }

        b b(String str, String str2) {
            this.f5984a.add(str);
            this.f5984a.add(str2.trim());
            return this;
        }

        public e c() {
            return new e(this);
        }

        public b e(String str) {
            int i5 = 0;
            while (i5 < this.f5984a.size()) {
                if (str.equalsIgnoreCase(this.f5984a.get(i5))) {
                    this.f5984a.remove(i5);
                    this.f5984a.remove(i5);
                    i5 -= 2;
                }
                i5 += 2;
            }
            return this;
        }

        public b f(String str, String str2) {
            d(str, str2);
            e(str);
            b(str, str2);
            return this;
        }
    }

    private e(b bVar) {
        this.f5983a = (String[]) bVar.f5984a.toArray(new String[bVar.f5984a.size()]);
    }

    public String a(int i5) {
        int i6 = i5 * 2;
        if (i6 >= 0) {
            String[] strArr = this.f5983a;
            if (i6 >= strArr.length) {
                return null;
            }
            return strArr[i6];
        }
        return null;
    }

    public int b() {
        return this.f5983a.length / 2;
    }

    public String c(int i5) {
        int i6 = (i5 * 2) + 1;
        if (i6 >= 0) {
            String[] strArr = this.f5983a;
            if (i6 >= strArr.length) {
                return null;
            }
            return strArr[i6];
        }
        return null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        int b5 = b();
        for (int i5 = 0; i5 < b5; i5++) {
            sb.append(a(i5));
            sb.append(": ");
            sb.append(c(i5));
            sb.append("\n");
        }
        return sb.toString();
    }
}
