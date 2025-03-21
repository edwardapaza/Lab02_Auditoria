package com.google.protobuf;

import com.google.protobuf.d0;
import com.google.protobuf.v;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class q1 {

    /* renamed from: a  reason: collision with root package name */
    private static final Class<?> f2106a = B();

    /* renamed from: b  reason: collision with root package name */
    private static final w1<?, ?> f2107b = C(false);

    /* renamed from: c  reason: collision with root package name */
    private static final w1<?, ?> f2108c = C(true);

    /* renamed from: d  reason: collision with root package name */
    private static final w1<?, ?> f2109d = new y1();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <UT, UB> UB A(Object obj, int i5, List<Integer> list, d0.e eVar, UB ub, w1<UT, UB> w1Var) {
        if (eVar == null) {
            return ub;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i6 = 0;
            for (int i7 = 0; i7 < size; i7++) {
                int intValue = list.get(i7).intValue();
                if (eVar.a(intValue)) {
                    if (i7 != i6) {
                        list.set(i6, Integer.valueOf(intValue));
                    }
                    i6++;
                } else {
                    ub = (UB) L(obj, i5, intValue, ub, w1Var);
                }
            }
            if (i6 != size) {
                list.subList(i6, size).clear();
            }
        } else {
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                int intValue2 = it.next().intValue();
                if (!eVar.a(intValue2)) {
                    ub = (UB) L(obj, i5, intValue2, ub, w1Var);
                    it.remove();
                }
            }
        }
        return ub;
    }

    private static Class<?> B() {
        try {
            return Class.forName("com.google.protobuf.GeneratedMessageV3");
        } catch (Throwable unused) {
            return null;
        }
    }

    private static w1<?, ?> C(boolean z4) {
        try {
            Class<?> D = D();
            if (D == null) {
                return null;
            }
            return (w1) D.getConstructor(Boolean.TYPE).newInstance(Boolean.valueOf(z4));
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Class<?> D() {
        try {
            return Class.forName("com.google.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T, FT extends v.b<FT>> void E(r<FT> rVar, T t5, T t6) {
        v<FT> c5 = rVar.c(t6);
        if (c5.n()) {
            return;
        }
        rVar.d(t5).v(c5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> void F(r0 r0Var, T t5, T t6, long j5) {
        a2.V(t5, j5, r0Var.a(a2.G(t5, j5), a2.G(t6, j5)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T, UT, UB> void G(w1<UT, UB> w1Var, T t5, T t6) {
        w1Var.p(t5, w1Var.k(w1Var.g(t5), w1Var.g(t6)));
    }

    public static w1<?, ?> H() {
        return f2107b;
    }

    public static w1<?, ?> I() {
        return f2108c;
    }

    public static void J(Class<?> cls) {
        Class<?> cls2;
        if (!z.class.isAssignableFrom(cls) && (cls2 = f2106a) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessageV3 or GeneratedMessageLite");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean K(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <UT, UB> UB L(Object obj, int i5, int i6, UB ub, w1<UT, UB> w1Var) {
        if (ub == null) {
            ub = w1Var.f(obj);
        }
        w1Var.e(ub, i5, i6);
        return ub;
    }

    public static w1<?, ?> M() {
        return f2109d;
    }

    public static void N(int i5, List<Boolean> list, d2 d2Var, boolean z4) {
        if (list == null || list.isEmpty()) {
            return;
        }
        d2Var.v(i5, list, z4);
    }

    public static void O(int i5, List<i> list, d2 d2Var) {
        if (list == null || list.isEmpty()) {
            return;
        }
        d2Var.O(i5, list);
    }

    public static void P(int i5, List<Double> list, d2 d2Var, boolean z4) {
        if (list == null || list.isEmpty()) {
            return;
        }
        d2Var.M(i5, list, z4);
    }

    public static void Q(int i5, List<Integer> list, d2 d2Var, boolean z4) {
        if (list == null || list.isEmpty()) {
            return;
        }
        d2Var.L(i5, list, z4);
    }

    public static void R(int i5, List<Integer> list, d2 d2Var, boolean z4) {
        if (list == null || list.isEmpty()) {
            return;
        }
        d2Var.t(i5, list, z4);
    }

    public static void S(int i5, List<Long> list, d2 d2Var, boolean z4) {
        if (list == null || list.isEmpty()) {
            return;
        }
        d2Var.n(i5, list, z4);
    }

    public static void T(int i5, List<Float> list, d2 d2Var, boolean z4) {
        if (list == null || list.isEmpty()) {
            return;
        }
        d2Var.d(i5, list, z4);
    }

    public static void U(int i5, List<?> list, d2 d2Var, o1 o1Var) {
        if (list == null || list.isEmpty()) {
            return;
        }
        d2Var.b(i5, list, o1Var);
    }

    public static void V(int i5, List<Integer> list, d2 d2Var, boolean z4) {
        if (list == null || list.isEmpty()) {
            return;
        }
        d2Var.c(i5, list, z4);
    }

    public static void W(int i5, List<Long> list, d2 d2Var, boolean z4) {
        if (list == null || list.isEmpty()) {
            return;
        }
        d2Var.K(i5, list, z4);
    }

    public static void X(int i5, List<?> list, d2 d2Var, o1 o1Var) {
        if (list == null || list.isEmpty()) {
            return;
        }
        d2Var.a(i5, list, o1Var);
    }

    public static void Y(int i5, List<Integer> list, d2 d2Var, boolean z4) {
        if (list == null || list.isEmpty()) {
            return;
        }
        d2Var.o(i5, list, z4);
    }

    public static void Z(int i5, List<Long> list, d2 d2Var, boolean z4) {
        if (list == null || list.isEmpty()) {
            return;
        }
        d2Var.s(i5, list, z4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(int i5, List<?> list, boolean z4) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return z4 ? l.V(i5) + l.D(size) : size * l.e(i5, true);
    }

    public static void a0(int i5, List<Integer> list, d2 d2Var, boolean z4) {
        if (list == null || list.isEmpty()) {
            return;
        }
        d2Var.H(i5, list, z4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int b(List<?> list) {
        return list.size();
    }

    public static void b0(int i5, List<Long> list, d2 d2Var, boolean z4) {
        if (list == null || list.isEmpty()) {
            return;
        }
        d2Var.z(i5, list, z4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int c(int i5, List<i> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int V = size * l.V(i5);
        for (int i6 = 0; i6 < list.size(); i6++) {
            V += l.i(list.get(i6));
        }
        return V;
    }

    public static void c0(int i5, List<String> list, d2 d2Var) {
        if (list == null || list.isEmpty()) {
            return;
        }
        d2Var.E(i5, list);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int d(int i5, List<Integer> list, boolean z4) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int e5 = e(list);
        int V = l.V(i5);
        return z4 ? V + l.D(e5) : e5 + (size * V);
    }

    public static void d0(int i5, List<Integer> list, d2 d2Var, boolean z4) {
        if (list == null || list.isEmpty()) {
            return;
        }
        d2Var.y(i5, list, z4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int e(List<Integer> list) {
        int i5;
        int size = list.size();
        int i6 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof c0) {
            c0 c0Var = (c0) list;
            i5 = 0;
            while (i6 < size) {
                i5 += l.m(c0Var.p(i6));
                i6++;
            }
        } else {
            i5 = 0;
            while (i6 < size) {
                i5 += l.m(list.get(i6).intValue());
                i6++;
            }
        }
        return i5;
    }

    public static void e0(int i5, List<Long> list, d2 d2Var, boolean z4) {
        if (list == null || list.isEmpty()) {
            return;
        }
        d2Var.u(i5, list, z4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int f(int i5, List<?> list, boolean z4) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return z4 ? l.V(i5) + l.D(size * 4) : size * l.n(i5, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int g(List<?> list) {
        return list.size() * 4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int h(int i5, List<?> list, boolean z4) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return z4 ? l.V(i5) + l.D(size * 8) : size * l.p(i5, 0L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int i(List<?> list) {
        return list.size() * 8;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int j(int i5, List<w0> list, o1 o1Var) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i6 = 0;
        for (int i7 = 0; i7 < size; i7++) {
            i6 += l.t(i5, list.get(i7), o1Var);
        }
        return i6;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int k(int i5, List<Integer> list, boolean z4) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int l5 = l(list);
        int V = l.V(i5);
        return z4 ? V + l.D(l5) : l5 + (size * V);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int l(List<Integer> list) {
        int i5;
        int size = list.size();
        int i6 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof c0) {
            c0 c0Var = (c0) list;
            i5 = 0;
            while (i6 < size) {
                i5 += l.x(c0Var.p(i6));
                i6++;
            }
        } else {
            i5 = 0;
            while (i6 < size) {
                i5 += l.x(list.get(i6).intValue());
                i6++;
            }
        }
        return i5;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int m(int i5, List<Long> list, boolean z4) {
        if (list.size() == 0) {
            return 0;
        }
        int n5 = n(list);
        return z4 ? l.V(i5) + l.D(n5) : n5 + (list.size() * l.V(i5));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int n(List<Long> list) {
        int i5;
        int size = list.size();
        int i6 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof n0) {
            n0 n0Var = (n0) list;
            i5 = 0;
            while (i6 < size) {
                i5 += l.z(n0Var.o(i6));
                i6++;
            }
        } else {
            i5 = 0;
            while (i6 < size) {
                i5 += l.z(list.get(i6).longValue());
                i6++;
            }
        }
        return i5;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int o(int i5, Object obj, o1 o1Var) {
        return obj instanceof j0 ? l.B(i5, (j0) obj) : l.G(i5, (w0) obj, o1Var);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int p(int i5, List<?> list, o1 o1Var) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int V = l.V(i5) * size;
        for (int i6 = 0; i6 < size; i6++) {
            Object obj = list.get(i6);
            V += obj instanceof j0 ? l.C((j0) obj) : l.I((w0) obj, o1Var);
        }
        return V;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int q(int i5, List<Integer> list, boolean z4) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int r5 = r(list);
        int V = l.V(i5);
        return z4 ? V + l.D(r5) : r5 + (size * V);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int r(List<Integer> list) {
        int i5;
        int size = list.size();
        int i6 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof c0) {
            c0 c0Var = (c0) list;
            i5 = 0;
            while (i6 < size) {
                i5 += l.Q(c0Var.p(i6));
                i6++;
            }
        } else {
            i5 = 0;
            while (i6 < size) {
                i5 += l.Q(list.get(i6).intValue());
                i6++;
            }
        }
        return i5;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int s(int i5, List<Long> list, boolean z4) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int t5 = t(list);
        int V = l.V(i5);
        return z4 ? V + l.D(t5) : t5 + (size * V);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int t(List<Long> list) {
        int i5;
        int size = list.size();
        int i6 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof n0) {
            n0 n0Var = (n0) list;
            i5 = 0;
            while (i6 < size) {
                i5 += l.S(n0Var.o(i6));
                i6++;
            }
        } else {
            i5 = 0;
            while (i6 < size) {
                i5 += l.S(list.get(i6).longValue());
                i6++;
            }
        }
        return i5;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int u(int i5, List<?> list) {
        int size = list.size();
        int i6 = 0;
        if (size == 0) {
            return 0;
        }
        int V = l.V(i5) * size;
        if (list instanceof l0) {
            l0 l0Var = (l0) list;
            while (i6 < size) {
                Object e5 = l0Var.e(i6);
                V += e5 instanceof i ? l.i((i) e5) : l.U((String) e5);
                i6++;
            }
        } else {
            while (i6 < size) {
                Object obj = list.get(i6);
                V += obj instanceof i ? l.i((i) obj) : l.U((String) obj);
                i6++;
            }
        }
        return V;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int v(int i5, List<Integer> list, boolean z4) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int w5 = w(list);
        int V = l.V(i5);
        return z4 ? V + l.D(w5) : w5 + (size * V);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int w(List<Integer> list) {
        int i5;
        int size = list.size();
        int i6 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof c0) {
            c0 c0Var = (c0) list;
            i5 = 0;
            while (i6 < size) {
                i5 += l.X(c0Var.p(i6));
                i6++;
            }
        } else {
            i5 = 0;
            while (i6 < size) {
                i5 += l.X(list.get(i6).intValue());
                i6++;
            }
        }
        return i5;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int x(int i5, List<Long> list, boolean z4) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int y4 = y(list);
        int V = l.V(i5);
        return z4 ? V + l.D(y4) : y4 + (size * V);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int y(List<Long> list) {
        int i5;
        int size = list.size();
        int i6 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof n0) {
            n0 n0Var = (n0) list;
            i5 = 0;
            while (i6 < size) {
                i5 += l.Z(n0Var.o(i6));
                i6++;
            }
        } else {
            i5 = 0;
            while (i6 < size) {
                i5 += l.Z(list.get(i6).longValue());
                i6++;
            }
        }
        return i5;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <UT, UB> UB z(Object obj, int i5, List<Integer> list, d0.d<?> dVar, UB ub, w1<UT, UB> w1Var) {
        if (dVar == null) {
            return ub;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i6 = 0;
            for (int i7 = 0; i7 < size; i7++) {
                int intValue = list.get(i7).intValue();
                if (dVar.a(intValue) != null) {
                    if (i7 != i6) {
                        list.set(i6, Integer.valueOf(intValue));
                    }
                    i6++;
                } else {
                    ub = (UB) L(obj, i5, intValue, ub, w1Var);
                }
            }
            if (i6 != size) {
                list.subList(i6, size).clear();
            }
        } else {
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                int intValue2 = it.next().intValue();
                if (dVar.a(intValue2) == null) {
                    ub = (UB) L(obj, i5, intValue2, ub, w1Var);
                    it.remove();
                }
            }
        }
        return ub;
    }
}
