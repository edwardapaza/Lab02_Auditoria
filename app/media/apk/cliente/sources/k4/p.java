package k4;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import t3.c0;
import t3.x;
/* loaded from: classes.dex */
public class p extends o {

    /* loaded from: classes.dex */
    public static final class a extends e4.l implements d4.p<CharSequence, Integer, s3.l<? extends Integer, ? extends Integer>> {

        /* renamed from: a */
        final /* synthetic */ char[] f5851a;

        /* renamed from: b */
        final /* synthetic */ boolean f5852b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(char[] cArr, boolean z4) {
            super(2);
            this.f5851a = cArr;
            this.f5852b = z4;
        }

        public final s3.l<Integer, Integer> a(CharSequence charSequence, int i5) {
            e4.k.e(charSequence, "$this$$receiver");
            int x4 = p.x(charSequence, this.f5851a, i5, this.f5852b);
            if (x4 < 0) {
                return null;
            }
            return s3.p.a(Integer.valueOf(x4), 1);
        }

        @Override // d4.p
        public /* bridge */ /* synthetic */ s3.l<? extends Integer, ? extends Integer> invoke(CharSequence charSequence, Integer num) {
            return a(charSequence, num.intValue());
        }
    }

    /* loaded from: classes.dex */
    public static final class b extends e4.l implements d4.p<CharSequence, Integer, s3.l<? extends Integer, ? extends Integer>> {

        /* renamed from: a */
        final /* synthetic */ List<String> f5853a;

        /* renamed from: b */
        final /* synthetic */ boolean f5854b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(List<String> list, boolean z4) {
            super(2);
            this.f5853a = list;
            this.f5854b = z4;
        }

        public final s3.l<Integer, Integer> a(CharSequence charSequence, int i5) {
            e4.k.e(charSequence, "$this$$receiver");
            s3.l o5 = p.o(charSequence, this.f5853a, i5, this.f5854b, false);
            if (o5 != null) {
                return s3.p.a(o5.c(), Integer.valueOf(((String) o5.d()).length()));
            }
            return null;
        }

        @Override // d4.p
        public /* bridge */ /* synthetic */ s3.l<? extends Integer, ? extends Integer> invoke(CharSequence charSequence, Integer num) {
            return a(charSequence, num.intValue());
        }
    }

    /* loaded from: classes.dex */
    public static final class c extends e4.l implements d4.l<h4.f, String> {

        /* renamed from: a */
        final /* synthetic */ CharSequence f5855a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(CharSequence charSequence) {
            super(1);
            this.f5855a = charSequence;
        }

        @Override // d4.l
        /* renamed from: a */
        public final String invoke(h4.f fVar) {
            e4.k.e(fVar, "it");
            return p.V(this.f5855a, fVar);
        }
    }

    public static /* synthetic */ int A(CharSequence charSequence, char c5, int i5, boolean z4, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            i5 = q(charSequence);
        }
        if ((i6 & 4) != 0) {
            z4 = false;
        }
        return y(charSequence, c5, i5, z4);
    }

    public static /* synthetic */ int B(CharSequence charSequence, String str, int i5, boolean z4, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            i5 = q(charSequence);
        }
        if ((i6 & 4) != 0) {
            z4 = false;
        }
        return z(charSequence, str, i5, z4);
    }

    public static final int C(CharSequence charSequence, char[] cArr, int i5, boolean z4) {
        int c5;
        char F;
        e4.k.e(charSequence, "<this>");
        e4.k.e(cArr, "chars");
        if (!z4 && cArr.length == 1 && (charSequence instanceof String)) {
            F = t3.k.F(cArr);
            return ((String) charSequence).lastIndexOf(F, i5);
        }
        for (c5 = h4.l.c(i5, q(charSequence)); -1 < c5; c5--) {
            char charAt = charSequence.charAt(c5);
            int length = cArr.length;
            boolean z5 = false;
            int i6 = 0;
            while (true) {
                if (i6 >= length) {
                    break;
                } else if (k4.b.d(cArr[i6], charAt, z4)) {
                    z5 = true;
                    break;
                } else {
                    i6++;
                }
            }
            if (z5) {
                return c5;
            }
        }
        return -1;
    }

    public static final j4.b<String> D(CharSequence charSequence) {
        e4.k.e(charSequence, "<this>");
        return U(charSequence, new String[]{"\r\n", "\n", "\r"}, false, 0, 6, null);
    }

    public static final List<String> E(CharSequence charSequence) {
        List<String> h5;
        e4.k.e(charSequence, "<this>");
        h5 = j4.j.h(D(charSequence));
        return h5;
    }

    public static final CharSequence F(CharSequence charSequence, int i5, char c5) {
        e4.k.e(charSequence, "<this>");
        if (i5 < 0) {
            throw new IllegalArgumentException("Desired length " + i5 + " is less than zero.");
        } else if (i5 <= charSequence.length()) {
            return charSequence.subSequence(0, charSequence.length());
        } else {
            StringBuilder sb = new StringBuilder(i5);
            sb.append(charSequence);
            c0 it = new h4.f(1, i5 - charSequence.length()).iterator();
            while (it.hasNext()) {
                it.nextInt();
                sb.append(c5);
            }
            return sb;
        }
    }

    public static final String G(String str, int i5, char c5) {
        e4.k.e(str, "<this>");
        return F(str, i5, c5).toString();
    }

    public static /* synthetic */ String H(String str, int i5, char c5, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            c5 = ' ';
        }
        return G(str, i5, c5);
    }

    public static final CharSequence I(CharSequence charSequence, int i5, char c5) {
        e4.k.e(charSequence, "<this>");
        if (i5 < 0) {
            throw new IllegalArgumentException("Desired length " + i5 + " is less than zero.");
        } else if (i5 <= charSequence.length()) {
            return charSequence.subSequence(0, charSequence.length());
        } else {
            StringBuilder sb = new StringBuilder(i5);
            c0 it = new h4.f(1, i5 - charSequence.length()).iterator();
            while (it.hasNext()) {
                it.nextInt();
                sb.append(c5);
            }
            sb.append(charSequence);
            return sb;
        }
    }

    public static String J(String str, int i5, char c5) {
        e4.k.e(str, "<this>");
        return I(str, i5, c5).toString();
    }

    private static final j4.b<h4.f> K(CharSequence charSequence, char[] cArr, int i5, boolean z4, int i6) {
        P(i6);
        return new d(charSequence, i5, i6, new a(cArr, z4));
    }

    private static final j4.b<h4.f> L(CharSequence charSequence, String[] strArr, int i5, boolean z4, int i6) {
        List b5;
        P(i6);
        b5 = t3.j.b(strArr);
        return new d(charSequence, i5, i6, new b(b5, z4));
    }

    static /* synthetic */ j4.b M(CharSequence charSequence, char[] cArr, int i5, boolean z4, int i6, int i7, Object obj) {
        if ((i7 & 2) != 0) {
            i5 = 0;
        }
        if ((i7 & 4) != 0) {
            z4 = false;
        }
        if ((i7 & 8) != 0) {
            i6 = 0;
        }
        return K(charSequence, cArr, i5, z4, i6);
    }

    static /* synthetic */ j4.b N(CharSequence charSequence, String[] strArr, int i5, boolean z4, int i6, int i7, Object obj) {
        if ((i7 & 2) != 0) {
            i5 = 0;
        }
        if ((i7 & 4) != 0) {
            z4 = false;
        }
        if ((i7 & 8) != 0) {
            i6 = 0;
        }
        return L(charSequence, strArr, i5, z4, i6);
    }

    public static final boolean O(CharSequence charSequence, int i5, CharSequence charSequence2, int i6, int i7, boolean z4) {
        e4.k.e(charSequence, "<this>");
        e4.k.e(charSequence2, "other");
        if (i6 < 0 || i5 < 0 || i5 > charSequence.length() - i7 || i6 > charSequence2.length() - i7) {
            return false;
        }
        for (int i8 = 0; i8 < i7; i8++) {
            if (!k4.b.d(charSequence.charAt(i5 + i8), charSequence2.charAt(i6 + i8), z4)) {
                return false;
            }
        }
        return true;
    }

    public static final void P(int i5) {
        if (i5 >= 0) {
            return;
        }
        throw new IllegalArgumentException(("Limit must be non-negative, but was " + i5).toString());
    }

    public static final List<String> Q(CharSequence charSequence, char[] cArr, boolean z4, int i5) {
        Iterable<h4.f> e5;
        int k5;
        e4.k.e(charSequence, "<this>");
        e4.k.e(cArr, "delimiters");
        if (cArr.length == 1) {
            return R(charSequence, String.valueOf(cArr[0]), z4, i5);
        }
        e5 = j4.j.e(M(charSequence, cArr, 0, z4, i5, 2, null));
        k5 = t3.q.k(e5, 10);
        ArrayList arrayList = new ArrayList(k5);
        for (h4.f fVar : e5) {
            arrayList.add(V(charSequence, fVar));
        }
        return arrayList;
    }

    private static final List<String> R(CharSequence charSequence, String str, boolean z4, int i5) {
        List<String> b5;
        P(i5);
        int i6 = 0;
        int s5 = s(charSequence, str, 0, z4);
        if (s5 == -1 || i5 == 1) {
            b5 = t3.o.b(charSequence.toString());
            return b5;
        }
        boolean z5 = i5 > 0;
        ArrayList arrayList = new ArrayList(z5 ? h4.l.c(i5, 10) : 10);
        do {
            arrayList.add(charSequence.subSequence(i6, s5).toString());
            i6 = str.length() + s5;
            if (z5 && arrayList.size() == i5 - 1) {
                break;
            }
            s5 = s(charSequence, str, i6, z4);
        } while (s5 != -1);
        arrayList.add(charSequence.subSequence(i6, charSequence.length()).toString());
        return arrayList;
    }

    public static /* synthetic */ List S(CharSequence charSequence, char[] cArr, boolean z4, int i5, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            z4 = false;
        }
        if ((i6 & 4) != 0) {
            i5 = 0;
        }
        return Q(charSequence, cArr, z4, i5);
    }

    public static final j4.b<String> T(CharSequence charSequence, String[] strArr, boolean z4, int i5) {
        j4.b<String> f5;
        e4.k.e(charSequence, "<this>");
        e4.k.e(strArr, "delimiters");
        f5 = j4.j.f(N(charSequence, strArr, 0, z4, i5, 2, null), new c(charSequence));
        return f5;
    }

    public static /* synthetic */ j4.b U(CharSequence charSequence, String[] strArr, boolean z4, int i5, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            z4 = false;
        }
        if ((i6 & 4) != 0) {
            i5 = 0;
        }
        return T(charSequence, strArr, z4, i5);
    }

    public static final String V(CharSequence charSequence, h4.f fVar) {
        e4.k.e(charSequence, "<this>");
        e4.k.e(fVar, "range");
        return charSequence.subSequence(fVar.o().intValue(), fVar.n().intValue() + 1).toString();
    }

    public static final String W(String str, char c5, String str2) {
        e4.k.e(str, "<this>");
        e4.k.e(str2, "missingDelimiterValue");
        int v5 = v(str, c5, 0, false, 6, null);
        if (v5 == -1) {
            return str2;
        }
        String substring = str.substring(v5 + 1, str.length());
        e4.k.d(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    public static final String X(String str, String str2, String str3) {
        e4.k.e(str, "<this>");
        e4.k.e(str2, "delimiter");
        e4.k.e(str3, "missingDelimiterValue");
        int w5 = w(str, str2, 0, false, 6, null);
        if (w5 == -1) {
            return str3;
        }
        String substring = str.substring(w5 + str2.length(), str.length());
        e4.k.d(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    public static /* synthetic */ String Y(String str, char c5, String str2, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            str2 = str;
        }
        return W(str, c5, str2);
    }

    public static /* synthetic */ String Z(String str, String str2, String str3, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            str3 = str;
        }
        return X(str, str2, str3);
    }

    public static final String a0(String str, char c5, String str2) {
        e4.k.e(str, "<this>");
        e4.k.e(str2, "missingDelimiterValue");
        int A = A(str, c5, 0, false, 6, null);
        if (A == -1) {
            return str2;
        }
        String substring = str.substring(A + 1, str.length());
        e4.k.d(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    public static /* synthetic */ String b0(String str, char c5, String str2, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            str2 = str;
        }
        return a0(str, c5, str2);
    }

    public static final String c0(String str, char c5, String str2) {
        e4.k.e(str, "<this>");
        e4.k.e(str2, "missingDelimiterValue");
        int v5 = v(str, c5, 0, false, 6, null);
        if (v5 == -1) {
            return str2;
        }
        String substring = str.substring(0, v5);
        e4.k.d(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    public static final String d0(String str, String str2, String str3) {
        e4.k.e(str, "<this>");
        e4.k.e(str2, "delimiter");
        e4.k.e(str3, "missingDelimiterValue");
        int w5 = w(str, str2, 0, false, 6, null);
        if (w5 == -1) {
            return str3;
        }
        String substring = str.substring(0, w5);
        e4.k.d(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    public static /* synthetic */ String e0(String str, char c5, String str2, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            str2 = str;
        }
        return c0(str, c5, str2);
    }

    public static /* synthetic */ String f0(String str, String str2, String str3, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            str3 = str;
        }
        return d0(str, str2, str3);
    }

    public static CharSequence g0(CharSequence charSequence) {
        e4.k.e(charSequence, "<this>");
        int length = charSequence.length() - 1;
        int i5 = 0;
        boolean z4 = false;
        while (i5 <= length) {
            boolean c5 = k4.a.c(charSequence.charAt(!z4 ? i5 : length));
            if (z4) {
                if (!c5) {
                    break;
                }
                length--;
            } else if (c5) {
                i5++;
            } else {
                z4 = true;
            }
        }
        return charSequence.subSequence(i5, length + 1);
    }

    public static final s3.l<Integer, String> o(CharSequence charSequence, Collection<String> collection, int i5, boolean z4, boolean z5) {
        int c5;
        h4.d g5;
        int g6;
        Object obj;
        String str;
        Object obj2;
        int a5;
        Object B;
        if (!z4 && collection.size() == 1) {
            B = x.B(collection);
            String str2 = (String) B;
            int w5 = !z5 ? w(charSequence, str2, i5, false, 4, null) : B(charSequence, str2, i5, false, 4, null);
            if (w5 < 0) {
                return null;
            }
            return s3.p.a(Integer.valueOf(w5), str2);
        }
        if (z5) {
            c5 = h4.l.c(i5, q(charSequence));
            g5 = h4.l.g(c5, 0);
        } else {
            a5 = h4.l.a(i5, 0);
            g5 = new h4.f(a5, charSequence.length());
        }
        if (charSequence instanceof String) {
            g6 = g5.g();
            int h5 = g5.h();
            int i6 = g5.i();
            if ((i6 > 0 && g6 <= h5) || (i6 < 0 && h5 <= g6)) {
                while (true) {
                    Iterator<T> it = collection.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            obj2 = null;
                            break;
                        }
                        obj2 = it.next();
                        String str3 = (String) obj2;
                        if (o.i(str3, 0, (String) charSequence, g6, str3.length(), z4)) {
                            break;
                        }
                    }
                    str = (String) obj2;
                    if (str == null) {
                        if (g6 == h5) {
                            break;
                        }
                        g6 += i6;
                    } else {
                        break;
                    }
                }
                return s3.p.a(Integer.valueOf(g6), str);
            }
            return null;
        }
        g6 = g5.g();
        int h6 = g5.h();
        int i7 = g5.i();
        if ((i7 > 0 && g6 <= h6) || (i7 < 0 && h6 <= g6)) {
            while (true) {
                Iterator<T> it2 = collection.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        obj = null;
                        break;
                    }
                    obj = it2.next();
                    String str4 = (String) obj;
                    if (O(str4, 0, charSequence, g6, str4.length(), z4)) {
                        break;
                    }
                }
                str = (String) obj;
                if (str == null) {
                    if (g6 == h6) {
                        break;
                    }
                    g6 += i7;
                } else {
                    break;
                }
            }
            return s3.p.a(Integer.valueOf(g6), str);
        }
        return null;
    }

    public static final h4.f p(CharSequence charSequence) {
        e4.k.e(charSequence, "<this>");
        return new h4.f(0, charSequence.length() - 1);
    }

    public static final int q(CharSequence charSequence) {
        e4.k.e(charSequence, "<this>");
        return charSequence.length() - 1;
    }

    public static final int r(CharSequence charSequence, char c5, int i5, boolean z4) {
        e4.k.e(charSequence, "<this>");
        return (z4 || !(charSequence instanceof String)) ? x(charSequence, new char[]{c5}, i5, z4) : ((String) charSequence).indexOf(c5, i5);
    }

    public static final int s(CharSequence charSequence, String str, int i5, boolean z4) {
        e4.k.e(charSequence, "<this>");
        e4.k.e(str, "string");
        return (z4 || !(charSequence instanceof String)) ? u(charSequence, str, i5, charSequence.length(), z4, false, 16, null) : ((String) charSequence).indexOf(str, i5);
    }

    private static final int t(CharSequence charSequence, CharSequence charSequence2, int i5, int i6, boolean z4, boolean z5) {
        int c5;
        int a5;
        h4.d g5;
        int a6;
        int c6;
        if (z5) {
            c5 = h4.l.c(i5, q(charSequence));
            a5 = h4.l.a(i6, 0);
            g5 = h4.l.g(c5, a5);
        } else {
            a6 = h4.l.a(i5, 0);
            c6 = h4.l.c(i6, charSequence.length());
            g5 = new h4.f(a6, c6);
        }
        if ((charSequence instanceof String) && (charSequence2 instanceof String)) {
            int g6 = g5.g();
            int h5 = g5.h();
            int i7 = g5.i();
            if ((i7 <= 0 || g6 > h5) && (i7 >= 0 || h5 > g6)) {
                return -1;
            }
            while (!o.i((String) charSequence2, 0, (String) charSequence, g6, charSequence2.length(), z4)) {
                if (g6 == h5) {
                    return -1;
                }
                g6 += i7;
            }
            return g6;
        }
        int g7 = g5.g();
        int h6 = g5.h();
        int i8 = g5.i();
        if ((i8 <= 0 || g7 > h6) && (i8 >= 0 || h6 > g7)) {
            return -1;
        }
        while (!O(charSequence2, 0, charSequence, g7, charSequence2.length(), z4)) {
            if (g7 == h6) {
                return -1;
            }
            g7 += i8;
        }
        return g7;
    }

    static /* synthetic */ int u(CharSequence charSequence, CharSequence charSequence2, int i5, int i6, boolean z4, boolean z5, int i7, Object obj) {
        return t(charSequence, charSequence2, i5, i6, z4, (i7 & 16) != 0 ? false : z5);
    }

    public static /* synthetic */ int v(CharSequence charSequence, char c5, int i5, boolean z4, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            i5 = 0;
        }
        if ((i6 & 4) != 0) {
            z4 = false;
        }
        return r(charSequence, c5, i5, z4);
    }

    public static /* synthetic */ int w(CharSequence charSequence, String str, int i5, boolean z4, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            i5 = 0;
        }
        if ((i6 & 4) != 0) {
            z4 = false;
        }
        return s(charSequence, str, i5, z4);
    }

    public static final int x(CharSequence charSequence, char[] cArr, int i5, boolean z4) {
        int a5;
        boolean z5;
        char F;
        e4.k.e(charSequence, "<this>");
        e4.k.e(cArr, "chars");
        if (!z4 && cArr.length == 1 && (charSequence instanceof String)) {
            F = t3.k.F(cArr);
            return ((String) charSequence).indexOf(F, i5);
        }
        a5 = h4.l.a(i5, 0);
        c0 it = new h4.f(a5, q(charSequence)).iterator();
        while (it.hasNext()) {
            int nextInt = it.nextInt();
            char charAt = charSequence.charAt(nextInt);
            int length = cArr.length;
            int i6 = 0;
            while (true) {
                if (i6 >= length) {
                    z5 = false;
                    continue;
                    break;
                } else if (k4.b.d(cArr[i6], charAt, z4)) {
                    z5 = true;
                    continue;
                    break;
                } else {
                    i6++;
                }
            }
            if (z5) {
                return nextInt;
            }
        }
        return -1;
    }

    public static final int y(CharSequence charSequence, char c5, int i5, boolean z4) {
        e4.k.e(charSequence, "<this>");
        return (z4 || !(charSequence instanceof String)) ? C(charSequence, new char[]{c5}, i5, z4) : ((String) charSequence).lastIndexOf(c5, i5);
    }

    public static final int z(CharSequence charSequence, String str, int i5, boolean z4) {
        e4.k.e(charSequence, "<this>");
        e4.k.e(str, "string");
        return (z4 || !(charSequence instanceof String)) ? t(charSequence, str, i5, 0, z4, true) : ((String) charSequence).lastIndexOf(str, i5);
    }
}
