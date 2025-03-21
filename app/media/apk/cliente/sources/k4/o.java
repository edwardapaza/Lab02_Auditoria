package k4;

import java.util.Collection;
import java.util.Iterator;
import t3.c0;
/* loaded from: classes.dex */
public class o extends n {
    public static boolean h(CharSequence charSequence) {
        boolean z4;
        e4.k.e(charSequence, "<this>");
        if (charSequence.length() != 0) {
            h4.f p5 = p.p(charSequence);
            if (!(p5 instanceof Collection) || !((Collection) p5).isEmpty()) {
                Iterator<Integer> it = p5.iterator();
                while (it.hasNext()) {
                    if (!a.c(charSequence.charAt(((c0) it).nextInt()))) {
                        z4 = false;
                        break;
                    }
                }
            }
            z4 = true;
            if (!z4) {
                return false;
            }
        }
        return true;
    }

    public static final boolean i(String str, int i5, String str2, int i6, int i7, boolean z4) {
        e4.k.e(str, "<this>");
        e4.k.e(str2, "other");
        return !z4 ? str.regionMatches(i5, str2, i6, i7) : str.regionMatches(z4, i5, str2, i6, i7);
    }

    public static final String j(String str, String str2, String str3, boolean z4) {
        int a5;
        e4.k.e(str, "<this>");
        e4.k.e(str2, "oldValue");
        e4.k.e(str3, "newValue");
        int i5 = 0;
        int s5 = p.s(str, str2, 0, z4);
        if (s5 < 0) {
            return str;
        }
        int length = str2.length();
        a5 = h4.l.a(length, 1);
        int length2 = (str.length() - length) + str3.length();
        if (length2 >= 0) {
            StringBuilder sb = new StringBuilder(length2);
            do {
                sb.append((CharSequence) str, i5, s5);
                sb.append(str3);
                i5 = s5 + length;
                if (s5 >= str.length()) {
                    break;
                }
                s5 = p.s(str, str2, s5 + a5, z4);
            } while (s5 > 0);
            sb.append((CharSequence) str, i5, str.length());
            String sb2 = sb.toString();
            e4.k.d(sb2, "stringBuilder.append(this, i, length).toString()");
            return sb2;
        }
        throw new OutOfMemoryError();
    }

    public static /* synthetic */ String k(String str, String str2, String str3, boolean z4, int i5, Object obj) {
        if ((i5 & 4) != 0) {
            z4 = false;
        }
        return j(str, str2, str3, z4);
    }

    public static final boolean l(String str, String str2, boolean z4) {
        e4.k.e(str, "<this>");
        e4.k.e(str2, "prefix");
        return !z4 ? str.startsWith(str2) : i(str, 0, str2, 0, str2.length(), z4);
    }

    public static /* synthetic */ boolean m(String str, String str2, boolean z4, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            z4 = false;
        }
        return l(str, str2, z4);
    }
}
