package t3;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;
/* loaded from: classes.dex */
public class k extends j {
    public static /* synthetic */ String A(float[] fArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i5, CharSequence charSequence4, d4.l lVar, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            charSequence = ", ";
        }
        String str = (i6 & 2) != 0 ? "" : charSequence2;
        String str2 = (i6 & 4) == 0 ? charSequence3 : "";
        int i7 = (i6 & 8) != 0 ? -1 : i5;
        if ((i6 & 16) != 0) {
            charSequence4 = "...";
        }
        CharSequence charSequence5 = charSequence4;
        if ((i6 & 32) != 0) {
            lVar = null;
        }
        return u(fArr, charSequence, str, str2, i7, charSequence5, lVar);
    }

    public static /* synthetic */ String B(int[] iArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i5, CharSequence charSequence4, d4.l lVar, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            charSequence = ", ";
        }
        String str = (i6 & 2) != 0 ? "" : charSequence2;
        String str2 = (i6 & 4) == 0 ? charSequence3 : "";
        int i7 = (i6 & 8) != 0 ? -1 : i5;
        if ((i6 & 16) != 0) {
            charSequence4 = "...";
        }
        CharSequence charSequence5 = charSequence4;
        if ((i6 & 32) != 0) {
            lVar = null;
        }
        return v(iArr, charSequence, str, str2, i7, charSequence5, lVar);
    }

    public static /* synthetic */ String C(long[] jArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i5, CharSequence charSequence4, d4.l lVar, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            charSequence = ", ";
        }
        String str = (i6 & 2) != 0 ? "" : charSequence2;
        String str2 = (i6 & 4) == 0 ? charSequence3 : "";
        int i7 = (i6 & 8) != 0 ? -1 : i5;
        if ((i6 & 16) != 0) {
            charSequence4 = "...";
        }
        CharSequence charSequence5 = charSequence4;
        if ((i6 & 32) != 0) {
            lVar = null;
        }
        return w(jArr, charSequence, str, str2, i7, charSequence5, lVar);
    }

    public static /* synthetic */ String D(Object[] objArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i5, CharSequence charSequence4, d4.l lVar, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            charSequence = ", ";
        }
        String str = (i6 & 2) != 0 ? "" : charSequence2;
        String str2 = (i6 & 4) == 0 ? charSequence3 : "";
        int i7 = (i6 & 8) != 0 ? -1 : i5;
        if ((i6 & 16) != 0) {
            charSequence4 = "...";
        }
        CharSequence charSequence5 = charSequence4;
        if ((i6 & 32) != 0) {
            lVar = null;
        }
        return x(objArr, charSequence, str, str2, i7, charSequence5, lVar);
    }

    public static /* synthetic */ String E(short[] sArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i5, CharSequence charSequence4, d4.l lVar, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            charSequence = ", ";
        }
        String str = (i6 & 2) != 0 ? "" : charSequence2;
        String str2 = (i6 & 4) == 0 ? charSequence3 : "";
        int i7 = (i6 & 8) != 0 ? -1 : i5;
        if ((i6 & 16) != 0) {
            charSequence4 = "...";
        }
        CharSequence charSequence5 = charSequence4;
        if ((i6 & 32) != 0) {
            lVar = null;
        }
        return y(sArr, charSequence, str, str2, i7, charSequence5, lVar);
    }

    public static char F(char[] cArr) {
        e4.k.e(cArr, "<this>");
        int length = cArr.length;
        if (length != 0) {
            if (length == 1) {
                return cArr[0];
            }
            throw new IllegalArgumentException("Array has more than one element.");
        }
        throw new NoSuchElementException("Array is empty.");
    }

    public static <T> T G(T[] tArr) {
        e4.k.e(tArr, "<this>");
        if (tArr.length == 1) {
            return tArr[0];
        }
        return null;
    }

    public static final <T> List<T> H(T[] tArr, int i5) {
        List<T> b5;
        List<T> N;
        List<T> f5;
        e4.k.e(tArr, "<this>");
        if (!(i5 >= 0)) {
            throw new IllegalArgumentException(("Requested element count " + i5 + " is less than zero.").toString());
        } else if (i5 == 0) {
            f5 = p.f();
            return f5;
        } else {
            int length = tArr.length;
            if (i5 >= length) {
                N = N(tArr);
                return N;
            } else if (i5 == 1) {
                b5 = o.b(tArr[length - 1]);
                return b5;
            } else {
                ArrayList arrayList = new ArrayList(i5);
                for (int i6 = length - i5; i6 < length; i6++) {
                    arrayList.add(tArr[i6]);
                }
                return arrayList;
            }
        }
    }

    public static List<Byte> I(byte[] bArr) {
        List<Byte> f5;
        List<Byte> b5;
        e4.k.e(bArr, "<this>");
        int length = bArr.length;
        if (length == 0) {
            f5 = p.f();
            return f5;
        } else if (length != 1) {
            return P(bArr);
        } else {
            b5 = o.b(Byte.valueOf(bArr[0]));
            return b5;
        }
    }

    public static List<Double> J(double[] dArr) {
        List<Double> f5;
        List<Double> b5;
        e4.k.e(dArr, "<this>");
        int length = dArr.length;
        if (length == 0) {
            f5 = p.f();
            return f5;
        } else if (length != 1) {
            return Q(dArr);
        } else {
            b5 = o.b(Double.valueOf(dArr[0]));
            return b5;
        }
    }

    public static List<Float> K(float[] fArr) {
        List<Float> f5;
        List<Float> b5;
        e4.k.e(fArr, "<this>");
        int length = fArr.length;
        if (length == 0) {
            f5 = p.f();
            return f5;
        } else if (length != 1) {
            return R(fArr);
        } else {
            b5 = o.b(Float.valueOf(fArr[0]));
            return b5;
        }
    }

    public static List<Integer> L(int[] iArr) {
        List<Integer> f5;
        List<Integer> b5;
        e4.k.e(iArr, "<this>");
        int length = iArr.length;
        if (length == 0) {
            f5 = p.f();
            return f5;
        } else if (length != 1) {
            return S(iArr);
        } else {
            b5 = o.b(Integer.valueOf(iArr[0]));
            return b5;
        }
    }

    public static List<Long> M(long[] jArr) {
        List<Long> f5;
        List<Long> b5;
        e4.k.e(jArr, "<this>");
        int length = jArr.length;
        if (length == 0) {
            f5 = p.f();
            return f5;
        } else if (length != 1) {
            return T(jArr);
        } else {
            b5 = o.b(Long.valueOf(jArr[0]));
            return b5;
        }
    }

    public static <T> List<T> N(T[] tArr) {
        List<T> f5;
        List<T> b5;
        e4.k.e(tArr, "<this>");
        int length = tArr.length;
        if (length == 0) {
            f5 = p.f();
            return f5;
        } else if (length != 1) {
            return U(tArr);
        } else {
            b5 = o.b(tArr[0]);
            return b5;
        }
    }

    public static List<Short> O(short[] sArr) {
        List<Short> f5;
        List<Short> b5;
        e4.k.e(sArr, "<this>");
        int length = sArr.length;
        if (length == 0) {
            f5 = p.f();
            return f5;
        } else if (length != 1) {
            return V(sArr);
        } else {
            b5 = o.b(Short.valueOf(sArr[0]));
            return b5;
        }
    }

    public static final List<Byte> P(byte[] bArr) {
        e4.k.e(bArr, "<this>");
        ArrayList arrayList = new ArrayList(bArr.length);
        for (byte b5 : bArr) {
            arrayList.add(Byte.valueOf(b5));
        }
        return arrayList;
    }

    public static final List<Double> Q(double[] dArr) {
        e4.k.e(dArr, "<this>");
        ArrayList arrayList = new ArrayList(dArr.length);
        for (double d5 : dArr) {
            arrayList.add(Double.valueOf(d5));
        }
        return arrayList;
    }

    public static final List<Float> R(float[] fArr) {
        e4.k.e(fArr, "<this>");
        ArrayList arrayList = new ArrayList(fArr.length);
        for (float f5 : fArr) {
            arrayList.add(Float.valueOf(f5));
        }
        return arrayList;
    }

    public static final List<Integer> S(int[] iArr) {
        e4.k.e(iArr, "<this>");
        ArrayList arrayList = new ArrayList(iArr.length);
        for (int i5 : iArr) {
            arrayList.add(Integer.valueOf(i5));
        }
        return arrayList;
    }

    public static final List<Long> T(long[] jArr) {
        e4.k.e(jArr, "<this>");
        ArrayList arrayList = new ArrayList(jArr.length);
        for (long j5 : jArr) {
            arrayList.add(Long.valueOf(j5));
        }
        return arrayList;
    }

    public static final <T> List<T> U(T[] tArr) {
        e4.k.e(tArr, "<this>");
        return new ArrayList(p.e(tArr));
    }

    public static final List<Short> V(short[] sArr) {
        e4.k.e(sArr, "<this>");
        ArrayList arrayList = new ArrayList(sArr.length);
        for (short s5 : sArr) {
            arrayList.add(Short.valueOf(s5));
        }
        return arrayList;
    }

    public static final <T> boolean g(T[] tArr, T t5) {
        e4.k.e(tArr, "<this>");
        return m(tArr, t5) >= 0;
    }

    public static <T> List<T> h(T[] tArr, int i5) {
        int a5;
        e4.k.e(tArr, "<this>");
        if (i5 >= 0) {
            a5 = h4.l.a(tArr.length - i5, 0);
            return H(tArr, a5);
        }
        throw new IllegalArgumentException(("Requested element count " + i5 + " is less than zero.").toString());
    }

    public static <T> List<T> i(T[] tArr) {
        e4.k.e(tArr, "<this>");
        return (List) j(tArr, new ArrayList());
    }

    public static final <C extends Collection<? super T>, T> C j(T[] tArr, C c5) {
        e4.k.e(tArr, "<this>");
        e4.k.e(c5, "destination");
        for (T t5 : tArr) {
            if (t5 != null) {
                c5.add(t5);
            }
        }
        return c5;
    }

    public static final <T> int k(T[] tArr) {
        e4.k.e(tArr, "<this>");
        return tArr.length - 1;
    }

    public static <T> T l(T[] tArr, int i5) {
        e4.k.e(tArr, "<this>");
        if (i5 < 0 || i5 > k(tArr)) {
            return null;
        }
        return tArr[i5];
    }

    public static final <T> int m(T[] tArr, T t5) {
        e4.k.e(tArr, "<this>");
        int i5 = 0;
        if (t5 == null) {
            int length = tArr.length;
            while (i5 < length) {
                if (tArr[i5] == null) {
                    return i5;
                }
                i5++;
            }
            return -1;
        }
        int length2 = tArr.length;
        while (i5 < length2) {
            if (e4.k.a(t5, tArr[i5])) {
                return i5;
            }
            i5++;
        }
        return -1;
    }

    public static final <A extends Appendable> A n(double[] dArr, A a5, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i5, CharSequence charSequence4, d4.l<? super Double, ? extends CharSequence> lVar) {
        e4.k.e(dArr, "<this>");
        e4.k.e(a5, "buffer");
        e4.k.e(charSequence, "separator");
        e4.k.e(charSequence2, "prefix");
        e4.k.e(charSequence3, "postfix");
        e4.k.e(charSequence4, "truncated");
        a5.append(charSequence2);
        int i6 = 0;
        for (double d5 : dArr) {
            i6++;
            if (i6 > 1) {
                a5.append(charSequence);
            }
            if (i5 >= 0 && i6 > i5) {
                break;
            }
            a5.append(lVar != null ? lVar.invoke(Double.valueOf(d5)) : String.valueOf(d5));
        }
        if (i5 >= 0 && i6 > i5) {
            a5.append(charSequence4);
        }
        a5.append(charSequence3);
        return a5;
    }

    public static final <A extends Appendable> A o(float[] fArr, A a5, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i5, CharSequence charSequence4, d4.l<? super Float, ? extends CharSequence> lVar) {
        e4.k.e(fArr, "<this>");
        e4.k.e(a5, "buffer");
        e4.k.e(charSequence, "separator");
        e4.k.e(charSequence2, "prefix");
        e4.k.e(charSequence3, "postfix");
        e4.k.e(charSequence4, "truncated");
        a5.append(charSequence2);
        int i6 = 0;
        for (float f5 : fArr) {
            i6++;
            if (i6 > 1) {
                a5.append(charSequence);
            }
            if (i5 >= 0 && i6 > i5) {
                break;
            }
            a5.append(lVar != null ? lVar.invoke(Float.valueOf(f5)) : String.valueOf(f5));
        }
        if (i5 >= 0 && i6 > i5) {
            a5.append(charSequence4);
        }
        a5.append(charSequence3);
        return a5;
    }

    public static final <A extends Appendable> A p(int[] iArr, A a5, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i5, CharSequence charSequence4, d4.l<? super Integer, ? extends CharSequence> lVar) {
        e4.k.e(iArr, "<this>");
        e4.k.e(a5, "buffer");
        e4.k.e(charSequence, "separator");
        e4.k.e(charSequence2, "prefix");
        e4.k.e(charSequence3, "postfix");
        e4.k.e(charSequence4, "truncated");
        a5.append(charSequence2);
        int i6 = 0;
        for (int i7 : iArr) {
            i6++;
            if (i6 > 1) {
                a5.append(charSequence);
            }
            if (i5 >= 0 && i6 > i5) {
                break;
            }
            a5.append(lVar != null ? lVar.invoke(Integer.valueOf(i7)) : String.valueOf(i7));
        }
        if (i5 >= 0 && i6 > i5) {
            a5.append(charSequence4);
        }
        a5.append(charSequence3);
        return a5;
    }

    public static final <A extends Appendable> A q(long[] jArr, A a5, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i5, CharSequence charSequence4, d4.l<? super Long, ? extends CharSequence> lVar) {
        e4.k.e(jArr, "<this>");
        e4.k.e(a5, "buffer");
        e4.k.e(charSequence, "separator");
        e4.k.e(charSequence2, "prefix");
        e4.k.e(charSequence3, "postfix");
        e4.k.e(charSequence4, "truncated");
        a5.append(charSequence2);
        int i6 = 0;
        for (long j5 : jArr) {
            i6++;
            if (i6 > 1) {
                a5.append(charSequence);
            }
            if (i5 >= 0 && i6 > i5) {
                break;
            }
            a5.append(lVar != null ? lVar.invoke(Long.valueOf(j5)) : String.valueOf(j5));
        }
        if (i5 >= 0 && i6 > i5) {
            a5.append(charSequence4);
        }
        a5.append(charSequence3);
        return a5;
    }

    public static final <T, A extends Appendable> A r(T[] tArr, A a5, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i5, CharSequence charSequence4, d4.l<? super T, ? extends CharSequence> lVar) {
        e4.k.e(tArr, "<this>");
        e4.k.e(a5, "buffer");
        e4.k.e(charSequence, "separator");
        e4.k.e(charSequence2, "prefix");
        e4.k.e(charSequence3, "postfix");
        e4.k.e(charSequence4, "truncated");
        a5.append(charSequence2);
        int i6 = 0;
        for (T t5 : tArr) {
            i6++;
            if (i6 > 1) {
                a5.append(charSequence);
            }
            if (i5 >= 0 && i6 > i5) {
                break;
            }
            k4.g.a(a5, t5, lVar);
        }
        if (i5 >= 0 && i6 > i5) {
            a5.append(charSequence4);
        }
        a5.append(charSequence3);
        return a5;
    }

    public static final <A extends Appendable> A s(short[] sArr, A a5, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i5, CharSequence charSequence4, d4.l<? super Short, ? extends CharSequence> lVar) {
        e4.k.e(sArr, "<this>");
        e4.k.e(a5, "buffer");
        e4.k.e(charSequence, "separator");
        e4.k.e(charSequence2, "prefix");
        e4.k.e(charSequence3, "postfix");
        e4.k.e(charSequence4, "truncated");
        a5.append(charSequence2);
        int i6 = 0;
        for (short s5 : sArr) {
            i6++;
            if (i6 > 1) {
                a5.append(charSequence);
            }
            if (i5 >= 0 && i6 > i5) {
                break;
            }
            a5.append(lVar != null ? lVar.invoke(Short.valueOf(s5)) : String.valueOf((int) s5));
        }
        if (i5 >= 0 && i6 > i5) {
            a5.append(charSequence4);
        }
        a5.append(charSequence3);
        return a5;
    }

    public static final String t(double[] dArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i5, CharSequence charSequence4, d4.l<? super Double, ? extends CharSequence> lVar) {
        e4.k.e(dArr, "<this>");
        e4.k.e(charSequence, "separator");
        e4.k.e(charSequence2, "prefix");
        e4.k.e(charSequence3, "postfix");
        e4.k.e(charSequence4, "truncated");
        String sb = ((StringBuilder) n(dArr, new StringBuilder(), charSequence, charSequence2, charSequence3, i5, charSequence4, lVar)).toString();
        e4.k.d(sb, "joinTo(StringBuilder(), …ed, transform).toString()");
        return sb;
    }

    public static final String u(float[] fArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i5, CharSequence charSequence4, d4.l<? super Float, ? extends CharSequence> lVar) {
        e4.k.e(fArr, "<this>");
        e4.k.e(charSequence, "separator");
        e4.k.e(charSequence2, "prefix");
        e4.k.e(charSequence3, "postfix");
        e4.k.e(charSequence4, "truncated");
        String sb = ((StringBuilder) o(fArr, new StringBuilder(), charSequence, charSequence2, charSequence3, i5, charSequence4, lVar)).toString();
        e4.k.d(sb, "joinTo(StringBuilder(), …ed, transform).toString()");
        return sb;
    }

    public static final String v(int[] iArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i5, CharSequence charSequence4, d4.l<? super Integer, ? extends CharSequence> lVar) {
        e4.k.e(iArr, "<this>");
        e4.k.e(charSequence, "separator");
        e4.k.e(charSequence2, "prefix");
        e4.k.e(charSequence3, "postfix");
        e4.k.e(charSequence4, "truncated");
        String sb = ((StringBuilder) p(iArr, new StringBuilder(), charSequence, charSequence2, charSequence3, i5, charSequence4, lVar)).toString();
        e4.k.d(sb, "joinTo(StringBuilder(), …ed, transform).toString()");
        return sb;
    }

    public static final String w(long[] jArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i5, CharSequence charSequence4, d4.l<? super Long, ? extends CharSequence> lVar) {
        e4.k.e(jArr, "<this>");
        e4.k.e(charSequence, "separator");
        e4.k.e(charSequence2, "prefix");
        e4.k.e(charSequence3, "postfix");
        e4.k.e(charSequence4, "truncated");
        String sb = ((StringBuilder) q(jArr, new StringBuilder(), charSequence, charSequence2, charSequence3, i5, charSequence4, lVar)).toString();
        e4.k.d(sb, "joinTo(StringBuilder(), …ed, transform).toString()");
        return sb;
    }

    public static final <T> String x(T[] tArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i5, CharSequence charSequence4, d4.l<? super T, ? extends CharSequence> lVar) {
        e4.k.e(tArr, "<this>");
        e4.k.e(charSequence, "separator");
        e4.k.e(charSequence2, "prefix");
        e4.k.e(charSequence3, "postfix");
        e4.k.e(charSequence4, "truncated");
        String sb = ((StringBuilder) r(tArr, new StringBuilder(), charSequence, charSequence2, charSequence3, i5, charSequence4, lVar)).toString();
        e4.k.d(sb, "joinTo(StringBuilder(), …ed, transform).toString()");
        return sb;
    }

    public static final String y(short[] sArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i5, CharSequence charSequence4, d4.l<? super Short, ? extends CharSequence> lVar) {
        e4.k.e(sArr, "<this>");
        e4.k.e(charSequence, "separator");
        e4.k.e(charSequence2, "prefix");
        e4.k.e(charSequence3, "postfix");
        e4.k.e(charSequence4, "truncated");
        String sb = ((StringBuilder) s(sArr, new StringBuilder(), charSequence, charSequence2, charSequence3, i5, charSequence4, lVar)).toString();
        e4.k.d(sb, "joinTo(StringBuilder(), …ed, transform).toString()");
        return sb;
    }

    public static /* synthetic */ String z(double[] dArr, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i5, CharSequence charSequence4, d4.l lVar, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            charSequence = ", ";
        }
        String str = (i6 & 2) != 0 ? "" : charSequence2;
        String str2 = (i6 & 4) == 0 ? charSequence3 : "";
        int i7 = (i6 & 8) != 0 ? -1 : i5;
        if ((i6 & 16) != 0) {
            charSequence4 = "...";
        }
        CharSequence charSequence5 = charSequence4;
        if ((i6 & 32) != 0) {
            lVar = null;
        }
        return t(dArr, charSequence, str, str2, i7, charSequence5, lVar);
    }
}
