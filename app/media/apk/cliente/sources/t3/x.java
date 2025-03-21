package t3;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
/* loaded from: classes.dex */
public class x extends w {
    public static <T> List<T> A(Collection<? extends T> collection, T t5) {
        e4.k.e(collection, "<this>");
        ArrayList arrayList = new ArrayList(collection.size() + 1);
        arrayList.addAll(collection);
        arrayList.add(t5);
        return arrayList;
    }

    public static <T> T B(Iterable<? extends T> iterable) {
        e4.k.e(iterable, "<this>");
        if (iterable instanceof List) {
            return (T) C((List) iterable);
        }
        Iterator<? extends T> it = iterable.iterator();
        if (it.hasNext()) {
            T next = it.next();
            if (it.hasNext()) {
                throw new IllegalArgumentException("Collection has more than one element.");
            }
            return next;
        }
        throw new NoSuchElementException("Collection is empty.");
    }

    public static final <T> T C(List<? extends T> list) {
        e4.k.e(list, "<this>");
        int size = list.size();
        if (size != 0) {
            if (size == 1) {
                return list.get(0);
            }
            throw new IllegalArgumentException("List has more than one element.");
        }
        throw new NoSuchElementException("List is empty.");
    }

    public static <T> List<T> D(Iterable<? extends T> iterable, int i5) {
        List<T> i6;
        List<T> b5;
        List<T> H;
        List<T> f5;
        e4.k.e(iterable, "<this>");
        int i7 = 0;
        if (!(i5 >= 0)) {
            throw new IllegalArgumentException(("Requested element count " + i5 + " is less than zero.").toString());
        } else if (i5 == 0) {
            f5 = p.f();
            return f5;
        } else {
            if (iterable instanceof Collection) {
                if (i5 >= ((Collection) iterable).size()) {
                    H = H(iterable);
                    return H;
                } else if (i5 == 1) {
                    b5 = o.b(p(iterable));
                    return b5;
                }
            }
            ArrayList arrayList = new ArrayList(i5);
            for (T t5 : iterable) {
                arrayList.add(t5);
                i7++;
                if (i7 == i5) {
                    break;
                }
            }
            i6 = p.i(arrayList);
            return i6;
        }
    }

    public static byte[] E(Collection<Byte> collection) {
        e4.k.e(collection, "<this>");
        byte[] bArr = new byte[collection.size()];
        int i5 = 0;
        for (Byte b5 : collection) {
            bArr[i5] = b5.byteValue();
            i5++;
        }
        return bArr;
    }

    public static final <T, C extends Collection<? super T>> C F(Iterable<? extends T> iterable, C c5) {
        e4.k.e(iterable, "<this>");
        e4.k.e(c5, "destination");
        for (T t5 : iterable) {
            c5.add(t5);
        }
        return c5;
    }

    public static int[] G(Collection<Integer> collection) {
        e4.k.e(collection, "<this>");
        int[] iArr = new int[collection.size()];
        int i5 = 0;
        for (Integer num : collection) {
            iArr[i5] = num.intValue();
            i5++;
        }
        return iArr;
    }

    public static <T> List<T> H(Iterable<? extends T> iterable) {
        List<T> i5;
        List<T> f5;
        List<T> b5;
        List<T> K;
        e4.k.e(iterable, "<this>");
        if (!(iterable instanceof Collection)) {
            i5 = p.i(J(iterable));
            return i5;
        }
        Collection collection = (Collection) iterable;
        int size = collection.size();
        if (size == 0) {
            f5 = p.f();
            return f5;
        } else if (size != 1) {
            K = K(collection);
            return K;
        } else {
            b5 = o.b(iterable instanceof List ? ((List) iterable).get(0) : iterable.iterator().next());
            return b5;
        }
    }

    public static long[] I(Collection<Long> collection) {
        e4.k.e(collection, "<this>");
        long[] jArr = new long[collection.size()];
        int i5 = 0;
        for (Long l5 : collection) {
            jArr[i5] = l5.longValue();
            i5++;
        }
        return jArr;
    }

    public static final <T> List<T> J(Iterable<? extends T> iterable) {
        List<T> K;
        e4.k.e(iterable, "<this>");
        if (iterable instanceof Collection) {
            K = K((Collection) iterable);
            return K;
        }
        return (List) F(iterable, new ArrayList());
    }

    public static <T> List<T> K(Collection<? extends T> collection) {
        e4.k.e(collection, "<this>");
        return new ArrayList(collection);
    }

    public static <T> Set<T> L(Iterable<? extends T> iterable) {
        Set<T> b5;
        int a5;
        e4.k.e(iterable, "<this>");
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            int size = collection.size();
            if (size == 0) {
                b5 = n0.b();
                return b5;
            } else if (size == 1) {
                return m0.a(iterable instanceof List ? ((List) iterable).get(0) : iterable.iterator().next());
            } else {
                a5 = g0.a(collection.size());
                return (Set) F(iterable, new LinkedHashSet(a5));
            }
        }
        return n0.c((Set) F(iterable, new LinkedHashSet()));
    }

    /* JADX WARN: Code restructure failed: missing block: B:49:0x0031, code lost:
        r5 = h4.l.c(r10, r0 - r2);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static <T> java.util.List<java.util.List<T>> M(java.lang.Iterable<? extends T> r9, int r10, int r11, boolean r12) {
        /*
            java.lang.String r0 = "<this>"
            e4.k.e(r9, r0)
            t3.p0.a(r10, r11)
            boolean r0 = r9 instanceof java.util.RandomAccess
            r1 = 0
            if (r0 == 0) goto L55
            boolean r0 = r9 instanceof java.util.List
            if (r0 == 0) goto L55
            java.util.List r9 = (java.util.List) r9
            int r0 = r9.size()
            int r2 = r0 / r11
            int r3 = r0 % r11
            r4 = 1
            if (r3 != 0) goto L20
            r3 = 0
            goto L21
        L20:
            r3 = 1
        L21:
            int r2 = r2 + r3
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>(r2)
            r2 = 0
        L28:
            if (r2 < 0) goto L2e
            if (r2 >= r0) goto L2e
            r5 = 1
            goto L2f
        L2e:
            r5 = 0
        L2f:
            if (r5 == 0) goto L54
            int r5 = r0 - r2
            int r5 = h4.j.c(r10, r5)
            if (r5 >= r10) goto L3b
            if (r12 == 0) goto L54
        L3b:
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>(r5)
            r7 = 0
        L41:
            if (r7 >= r5) goto L4f
            int r8 = r7 + r2
            java.lang.Object r8 = r9.get(r8)
            r6.add(r8)
            int r7 = r7 + 1
            goto L41
        L4f:
            r3.add(r6)
            int r2 = r2 + r11
            goto L28
        L54:
            return r3
        L55:
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.Iterator r9 = r9.iterator()
            java.util.Iterator r9 = t3.p0.b(r9, r10, r11, r12, r1)
        L62:
            boolean r10 = r9.hasNext()
            if (r10 == 0) goto L72
            java.lang.Object r10 = r9.next()
            java.util.List r10 = (java.util.List) r10
            r0.add(r10)
            goto L62
        L72:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: t3.x.M(java.lang.Iterable, int, int, boolean):java.util.List");
    }

    public static <T, R> List<s3.l<T, R>> N(Iterable<? extends T> iterable, Iterable<? extends R> iterable2) {
        int k5;
        int k6;
        e4.k.e(iterable, "<this>");
        e4.k.e(iterable2, "other");
        Iterator<? extends T> it = iterable.iterator();
        Iterator<? extends R> it2 = iterable2.iterator();
        k5 = q.k(iterable, 10);
        k6 = q.k(iterable2, 10);
        ArrayList arrayList = new ArrayList(Math.min(k5, k6));
        while (it.hasNext() && it2.hasNext()) {
            arrayList.add(s3.p.a(it.next(), it2.next()));
        }
        return arrayList;
    }

    public static <T> boolean o(Iterable<? extends T> iterable, T t5) {
        e4.k.e(iterable, "<this>");
        return iterable instanceof Collection ? ((Collection) iterable).contains(t5) : s(iterable, t5) >= 0;
    }

    public static final <T> T p(Iterable<? extends T> iterable) {
        e4.k.e(iterable, "<this>");
        if (iterable instanceof List) {
            return (T) q((List) iterable);
        }
        Iterator<? extends T> it = iterable.iterator();
        if (it.hasNext()) {
            return it.next();
        }
        throw new NoSuchElementException("Collection is empty.");
    }

    public static final <T> T q(List<? extends T> list) {
        e4.k.e(list, "<this>");
        if (list.isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        return list.get(0);
    }

    public static <T> T r(List<? extends T> list) {
        e4.k.e(list, "<this>");
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    public static final <T> int s(Iterable<? extends T> iterable, T t5) {
        e4.k.e(iterable, "<this>");
        if (iterable instanceof List) {
            return ((List) iterable).indexOf(t5);
        }
        int i5 = 0;
        for (T t6 : iterable) {
            if (i5 < 0) {
                p.j();
            }
            if (e4.k.a(t5, t6)) {
                return i5;
            }
            i5++;
        }
        return -1;
    }

    public static final <T, A extends Appendable> A t(Iterable<? extends T> iterable, A a5, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i5, CharSequence charSequence4, d4.l<? super T, ? extends CharSequence> lVar) {
        e4.k.e(iterable, "<this>");
        e4.k.e(a5, "buffer");
        e4.k.e(charSequence, "separator");
        e4.k.e(charSequence2, "prefix");
        e4.k.e(charSequence3, "postfix");
        e4.k.e(charSequence4, "truncated");
        a5.append(charSequence2);
        int i6 = 0;
        for (T t5 : iterable) {
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

    public static final <T> String v(Iterable<? extends T> iterable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i5, CharSequence charSequence4, d4.l<? super T, ? extends CharSequence> lVar) {
        e4.k.e(iterable, "<this>");
        e4.k.e(charSequence, "separator");
        e4.k.e(charSequence2, "prefix");
        e4.k.e(charSequence3, "postfix");
        e4.k.e(charSequence4, "truncated");
        String sb = ((StringBuilder) t(iterable, new StringBuilder(), charSequence, charSequence2, charSequence3, i5, charSequence4, lVar)).toString();
        e4.k.d(sb, "joinTo(StringBuilder(), …ed, transform).toString()");
        return sb;
    }

    public static /* synthetic */ String w(Iterable iterable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i5, CharSequence charSequence4, d4.l lVar, int i6, Object obj) {
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
        return v(iterable, charSequence, str, str2, i7, charSequence5, lVar);
    }

    public static <T> T x(List<? extends T> list) {
        int g5;
        e4.k.e(list, "<this>");
        if (list.isEmpty()) {
            throw new NoSuchElementException("List is empty.");
        }
        g5 = p.g(list);
        return list.get(g5);
    }

    public static <T extends Comparable<? super T>> T y(Iterable<? extends T> iterable) {
        e4.k.e(iterable, "<this>");
        Iterator<? extends T> it = iterable.iterator();
        if (it.hasNext()) {
            T next = it.next();
            while (it.hasNext()) {
                T next2 = it.next();
                if (next.compareTo(next2) > 0) {
                    next = next2;
                }
            }
            return next;
        }
        return null;
    }

    public static <T> List<T> z(Collection<? extends T> collection, Iterable<? extends T> iterable) {
        e4.k.e(collection, "<this>");
        e4.k.e(iterable, "elements");
        if (!(iterable instanceof Collection)) {
            ArrayList arrayList = new ArrayList(collection);
            u.l(arrayList, iterable);
            return arrayList;
        }
        Collection collection2 = (Collection) iterable;
        ArrayList arrayList2 = new ArrayList(collection.size() + collection2.size());
        arrayList2.addAll(collection);
        arrayList2.addAll(collection2);
        return arrayList2;
    }
}
