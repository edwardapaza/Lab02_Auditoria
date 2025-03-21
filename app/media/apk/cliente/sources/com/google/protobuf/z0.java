package com.google.protobuf;

import com.google.protobuf.c2;
import com.google.protobuf.d0;
import com.google.protobuf.d2;
import com.google.protobuf.f;
import com.google.protobuf.i;
import com.google.protobuf.p0;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import sun.misc.Unsafe;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class z0<T> implements o1<T> {

    /* renamed from: r  reason: collision with root package name */
    private static final int[] f2220r = new int[0];

    /* renamed from: s  reason: collision with root package name */
    private static final Unsafe f2221s = a2.H();

    /* renamed from: a  reason: collision with root package name */
    private final int[] f2222a;

    /* renamed from: b  reason: collision with root package name */
    private final Object[] f2223b;

    /* renamed from: c  reason: collision with root package name */
    private final int f2224c;

    /* renamed from: d  reason: collision with root package name */
    private final int f2225d;

    /* renamed from: e  reason: collision with root package name */
    private final w0 f2226e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f2227f;

    /* renamed from: g  reason: collision with root package name */
    private final boolean f2228g;

    /* renamed from: h  reason: collision with root package name */
    private final boolean f2229h;

    /* renamed from: i  reason: collision with root package name */
    private final boolean f2230i;

    /* renamed from: j  reason: collision with root package name */
    private final int[] f2231j;

    /* renamed from: k  reason: collision with root package name */
    private final int f2232k;

    /* renamed from: l  reason: collision with root package name */
    private final int f2233l;

    /* renamed from: m  reason: collision with root package name */
    private final b1 f2234m;

    /* renamed from: n  reason: collision with root package name */
    private final m0 f2235n;

    /* renamed from: o  reason: collision with root package name */
    private final w1<?, ?> f2236o;

    /* renamed from: p  reason: collision with root package name */
    private final r<?> f2237p;

    /* renamed from: q  reason: collision with root package name */
    private final r0 f2238q;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f2239a;

        static {
            int[] iArr = new int[c2.b.values().length];
            f2239a = iArr;
            try {
                iArr[c2.b.f1882n.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f2239a[c2.b.f1886r.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f2239a[c2.b.f1875c.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f2239a[c2.b.f1881m.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f2239a[c2.b.f1889u.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f2239a[c2.b.f1880l.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f2239a[c2.b.f1890v.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f2239a[c2.b.f1876d.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f2239a[c2.b.f1888t.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f2239a[c2.b.f1879k.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f2239a[c2.b.f1887s.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f2239a[c2.b.f1877e.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f2239a[c2.b.f1878f.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f2239a[c2.b.f1885q.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f2239a[c2.b.f1891w.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f2239a[c2.b.f1892x.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f2239a[c2.b.f1883o.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
        }
    }

    private z0(int[] iArr, Object[] objArr, int i5, int i6, w0 w0Var, boolean z4, boolean z5, int[] iArr2, int i7, int i8, b1 b1Var, m0 m0Var, w1<?, ?> w1Var, r<?> rVar, r0 r0Var) {
        this.f2222a = iArr;
        this.f2223b = objArr;
        this.f2224c = i5;
        this.f2225d = i6;
        this.f2228g = w0Var instanceof z;
        this.f2229h = z4;
        this.f2227f = rVar != null && rVar.e(w0Var);
        this.f2230i = z5;
        this.f2231j = iArr2;
        this.f2232k = i7;
        this.f2233l = i8;
        this.f2234m = b1Var;
        this.f2235n = m0Var;
        this.f2236o = w1Var;
        this.f2237p = rVar;
        this.f2226e = w0Var;
        this.f2238q = r0Var;
    }

    private <UT, UB> int A(w1<UT, UB> w1Var, T t5) {
        return w1Var.h(w1Var.g(t5));
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x0528  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void A0(T r13, com.google.protobuf.d2 r14) {
        /*
            Method dump skipped, instructions count: 1488
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.z0.A0(java.lang.Object, com.google.protobuf.d2):void");
    }

    private static <T> int B(T t5, long j5) {
        return a2.C(t5, j5);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x052e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void B0(T r11, com.google.protobuf.d2 r12) {
        /*
            Method dump skipped, instructions count: 1490
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.z0.B0(java.lang.Object, com.google.protobuf.d2):void");
    }

    private static boolean C(int i5) {
        return (i5 & 536870912) != 0;
    }

    private <K, V> void C0(d2 d2Var, int i5, Object obj, int i6) {
        if (obj != null) {
            d2Var.x(i5, this.f2238q.f(v(i6)), this.f2238q.g(obj));
        }
    }

    private boolean D(T t5, int i5) {
        int m02 = m0(i5);
        long j5 = 1048575 & m02;
        if (j5 != 1048575) {
            return (a2.C(t5, j5) & (1 << (m02 >>> 20))) != 0;
        }
        int y02 = y0(i5);
        long Z = Z(y02);
        switch (x0(y02)) {
            case 0:
                return Double.doubleToRawLongBits(a2.A(t5, Z)) != 0;
            case 1:
                return Float.floatToRawIntBits(a2.B(t5, Z)) != 0;
            case 2:
                return a2.E(t5, Z) != 0;
            case 3:
                return a2.E(t5, Z) != 0;
            case 4:
                return a2.C(t5, Z) != 0;
            case 5:
                return a2.E(t5, Z) != 0;
            case 6:
                return a2.C(t5, Z) != 0;
            case 7:
                return a2.t(t5, Z);
            case 8:
                Object G = a2.G(t5, Z);
                if (G instanceof String) {
                    return !((String) G).isEmpty();
                }
                if (G instanceof i) {
                    return !i.f1961b.equals(G);
                }
                throw new IllegalArgumentException();
            case i2.d0.ARRAY_VALUE_FIELD_NUMBER /* 9 */:
                return a2.G(t5, Z) != null;
            case i2.d0.TIMESTAMP_VALUE_FIELD_NUMBER /* 10 */:
                return !i.f1961b.equals(a2.G(t5, Z));
            case 11:
                return a2.C(t5, Z) != 0;
            case i2.a0.EXPECTED_COUNT_FIELD_NUMBER /* 12 */:
                return a2.C(t5, Z) != 0;
            case 13:
                return a2.C(t5, Z) != 0;
            case 14:
                return a2.E(t5, Z) != 0;
            case 15:
                return a2.C(t5, Z) != 0;
            case 16:
                return a2.E(t5, Z) != 0;
            case i2.d0.STRING_VALUE_FIELD_NUMBER /* 17 */:
                return a2.G(t5, Z) != null;
            default:
                throw new IllegalArgumentException();
        }
    }

    private void D0(int i5, Object obj, d2 d2Var) {
        if (obj instanceof String) {
            d2Var.G(i5, (String) obj);
        } else {
            d2Var.l(i5, (i) obj);
        }
    }

    private boolean E(T t5, int i5, int i6, int i7, int i8) {
        return i6 == 1048575 ? D(t5, i5) : (i7 & i8) != 0;
    }

    private <UT, UB> void E0(w1<UT, UB> w1Var, T t5, d2 d2Var) {
        w1Var.t(w1Var.g(t5), d2Var);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static boolean F(Object obj, int i5, o1 o1Var) {
        return o1Var.d(a2.G(obj, Z(i5)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <N> boolean G(Object obj, int i5, int i6) {
        List list = (List) a2.G(obj, Z(i5));
        if (list.isEmpty()) {
            return true;
        }
        o1 w5 = w(i6);
        for (int i7 = 0; i7 < list.size(); i7++) {
            if (!w5.d(list.get(i7))) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v8, types: [com.google.protobuf.o1] */
    private boolean H(T t5, int i5, int i6) {
        Map<?, ?> g5 = this.f2238q.g(a2.G(t5, Z(i5)));
        if (g5.isEmpty()) {
            return true;
        }
        if (this.f2238q.f(v(i6)).f2096c.a() != c2.c.MESSAGE) {
            return true;
        }
        o1<T> o1Var = 0;
        for (Object obj : g5.values()) {
            if (o1Var == null) {
                o1Var = j1.a().c(obj.getClass());
            }
            boolean d5 = o1Var.d(obj);
            o1Var = o1Var;
            if (!d5) {
                return false;
            }
        }
        return true;
    }

    private static boolean I(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof z) {
            return ((z) obj).N();
        }
        return true;
    }

    private boolean J(T t5, T t6, int i5) {
        long m02 = m0(i5) & 1048575;
        return a2.C(t5, m02) == a2.C(t6, m02);
    }

    private boolean K(T t5, int i5, int i6) {
        return a2.C(t5, (long) (m0(i6) & 1048575)) == i5;
    }

    private static boolean L(int i5) {
        return (i5 & 268435456) != 0;
    }

    private static List<?> M(Object obj, long j5) {
        return (List) a2.G(obj, j5);
    }

    private static <T> long N(T t5, long j5) {
        return a2.E(t5, j5);
    }

    /* JADX WARN: Code restructure failed: missing block: B:266:?, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x008d, code lost:
        r0 = r18.f2232k;
        r4 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0092, code lost:
        if (r0 >= r18.f2233l) goto L233;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0094, code lost:
        r4 = (UB) r(r21, r18.f2231j[r0], r4, r19, r21);
        r0 = r0 + 1;
        r3 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00aa, code lost:
        r10 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00ab, code lost:
        if (r4 == null) goto L238;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00ad, code lost:
        r7.o(r10, r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00b0, code lost:
        return;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:190:0x05bd A[Catch: all -> 0x0615, TRY_LEAVE, TryCatch #5 {all -> 0x0615, blocks: (B:177:0x058e, B:188:0x05b7, B:190:0x05bd, B:200:0x05e5, B:201:0x05ea), top: B:231:0x058e }] */
    /* JADX WARN: Removed duplicated region for block: B:199:0x05e3  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x0627 A[LOOP:2: B:220:0x0623->B:222:0x0627, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:224:0x063c  */
    /* JADX WARN: Type inference failed for: r14v1, types: [com.google.protobuf.w1] */
    /* JADX WARN: Type inference failed for: r14v78 */
    /* JADX WARN: Type inference failed for: r1v153, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v26, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r22v0, types: [com.google.protobuf.m1] */
    /* JADX WARN: Type inference failed for: r7v5 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private <UT, UB, ET extends com.google.protobuf.v.b<ET>> void O(com.google.protobuf.w1<UT, UB> r19, com.google.protobuf.r<ET> r20, T r21, com.google.protobuf.m1 r22, com.google.protobuf.q r23) {
        /*
            Method dump skipped, instructions count: 1742
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.z0.O(com.google.protobuf.w1, com.google.protobuf.r, java.lang.Object, com.google.protobuf.m1, com.google.protobuf.q):void");
    }

    private final <K, V> void P(Object obj, int i5, Object obj2, q qVar, m1 m1Var) {
        long Z = Z(y0(i5));
        Object G = a2.G(obj, Z);
        if (G == null) {
            G = this.f2238q.b(obj2);
            a2.V(obj, Z, G);
        } else if (this.f2238q.d(G)) {
            Object b5 = this.f2238q.b(obj2);
            this.f2238q.a(b5, G);
            a2.V(obj, Z, b5);
            G = b5;
        }
        m1Var.y(this.f2238q.h(G), this.f2238q.f(obj2), qVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void Q(T t5, T t6, int i5) {
        if (D(t6, i5)) {
            long Z = Z(y0(i5));
            Unsafe unsafe = f2221s;
            Object object = unsafe.getObject(t6, Z);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + Y(i5) + " is present but null: " + t6);
            }
            o1 w5 = w(i5);
            if (!D(t5, i5)) {
                if (I(object)) {
                    Object i6 = w5.i();
                    w5.a(i6, object);
                    unsafe.putObject(t5, Z, i6);
                } else {
                    unsafe.putObject(t5, Z, object);
                }
                s0(t5, i5);
                return;
            }
            Object object2 = unsafe.getObject(t5, Z);
            if (!I(object2)) {
                Object i7 = w5.i();
                w5.a(i7, object2);
                unsafe.putObject(t5, Z, i7);
                object2 = i7;
            }
            w5.a(object2, object);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void R(T t5, T t6, int i5) {
        int Y = Y(i5);
        if (K(t6, Y, i5)) {
            long Z = Z(y0(i5));
            Unsafe unsafe = f2221s;
            Object object = unsafe.getObject(t6, Z);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + Y(i5) + " is present but null: " + t6);
            }
            o1 w5 = w(i5);
            if (!K(t5, Y, i5)) {
                if (I(object)) {
                    Object i6 = w5.i();
                    w5.a(i6, object);
                    unsafe.putObject(t5, Z, i6);
                } else {
                    unsafe.putObject(t5, Z, object);
                }
                t0(t5, Y, i5);
                return;
            }
            Object object2 = unsafe.getObject(t5, Z);
            if (!I(object2)) {
                Object i7 = w5.i();
                w5.a(i7, object2);
                unsafe.putObject(t5, Z, i7);
                object2 = i7;
            }
            w5.a(object2, object);
        }
    }

    private void S(T t5, T t6, int i5) {
        int y02 = y0(i5);
        long Z = Z(y02);
        int Y = Y(i5);
        switch (x0(y02)) {
            case 0:
                if (D(t6, i5)) {
                    a2.R(t5, Z, a2.A(t6, Z));
                    s0(t5, i5);
                    return;
                }
                return;
            case 1:
                if (D(t6, i5)) {
                    a2.S(t5, Z, a2.B(t6, Z));
                    s0(t5, i5);
                    return;
                }
                return;
            case 2:
                if (!D(t6, i5)) {
                    return;
                }
                a2.U(t5, Z, a2.E(t6, Z));
                s0(t5, i5);
                return;
            case 3:
                if (!D(t6, i5)) {
                    return;
                }
                a2.U(t5, Z, a2.E(t6, Z));
                s0(t5, i5);
                return;
            case 4:
                if (!D(t6, i5)) {
                    return;
                }
                a2.T(t5, Z, a2.C(t6, Z));
                s0(t5, i5);
                return;
            case 5:
                if (!D(t6, i5)) {
                    return;
                }
                a2.U(t5, Z, a2.E(t6, Z));
                s0(t5, i5);
                return;
            case 6:
                if (!D(t6, i5)) {
                    return;
                }
                a2.T(t5, Z, a2.C(t6, Z));
                s0(t5, i5);
                return;
            case 7:
                if (D(t6, i5)) {
                    a2.L(t5, Z, a2.t(t6, Z));
                    s0(t5, i5);
                    return;
                }
                return;
            case 8:
                if (!D(t6, i5)) {
                    return;
                }
                a2.V(t5, Z, a2.G(t6, Z));
                s0(t5, i5);
                return;
            case i2.d0.ARRAY_VALUE_FIELD_NUMBER /* 9 */:
            case i2.d0.STRING_VALUE_FIELD_NUMBER /* 17 */:
                Q(t5, t6, i5);
                return;
            case i2.d0.TIMESTAMP_VALUE_FIELD_NUMBER /* 10 */:
                if (!D(t6, i5)) {
                    return;
                }
                a2.V(t5, Z, a2.G(t6, Z));
                s0(t5, i5);
                return;
            case 11:
                if (!D(t6, i5)) {
                    return;
                }
                a2.T(t5, Z, a2.C(t6, Z));
                s0(t5, i5);
                return;
            case i2.a0.EXPECTED_COUNT_FIELD_NUMBER /* 12 */:
                if (!D(t6, i5)) {
                    return;
                }
                a2.T(t5, Z, a2.C(t6, Z));
                s0(t5, i5);
                return;
            case 13:
                if (!D(t6, i5)) {
                    return;
                }
                a2.T(t5, Z, a2.C(t6, Z));
                s0(t5, i5);
                return;
            case 14:
                if (!D(t6, i5)) {
                    return;
                }
                a2.U(t5, Z, a2.E(t6, Z));
                s0(t5, i5);
                return;
            case 15:
                if (!D(t6, i5)) {
                    return;
                }
                a2.T(t5, Z, a2.C(t6, Z));
                s0(t5, i5);
                return;
            case 16:
                if (!D(t6, i5)) {
                    return;
                }
                a2.U(t5, Z, a2.E(t6, Z));
                s0(t5, i5);
                return;
            case i2.d0.BYTES_VALUE_FIELD_NUMBER /* 18 */:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 46:
            case 47:
            case 48:
            case 49:
                this.f2235n.d(t5, t6, Z);
                return;
            case 50:
                q1.F(this.f2238q, t5, t6, Z);
                return;
            case 51:
            case 52:
            case 53:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
                if (!K(t6, Y, i5)) {
                    return;
                }
                a2.V(t5, Z, a2.G(t6, Z));
                t0(t5, Y, i5);
                return;
            case 60:
            case 68:
                R(t5, t6, i5);
                return;
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case 66:
            case 67:
                if (!K(t6, Y, i5)) {
                    return;
                }
                a2.V(t5, Z, a2.G(t6, Z));
                t0(t5, Y, i5);
                return;
            default:
                return;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private Object T(T t5, int i5) {
        o1 w5 = w(i5);
        long Z = Z(y0(i5));
        if (D(t5, i5)) {
            Object object = f2221s.getObject(t5, Z);
            if (I(object)) {
                return object;
            }
            Object i6 = w5.i();
            if (object != null) {
                w5.a(i6, object);
            }
            return i6;
        }
        return w5.i();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private Object U(T t5, int i5, int i6) {
        o1 w5 = w(i6);
        if (K(t5, i5, i6)) {
            Object object = f2221s.getObject(t5, Z(y0(i6)));
            if (I(object)) {
                return object;
            }
            Object i7 = w5.i();
            if (object != null) {
                w5.a(i7, object);
            }
            return i7;
        }
        return w5.i();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> z0<T> V(Class<T> cls, u0 u0Var, b1 b1Var, m0 m0Var, w1<?, ?> w1Var, r<?> rVar, r0 r0Var) {
        return u0Var instanceof l1 ? X((l1) u0Var, b1Var, m0Var, w1Var, rVar, r0Var) : W((s1) u0Var, b1Var, m0Var, w1Var, rVar, r0Var);
    }

    static <T> z0<T> W(s1 s1Var, b1 b1Var, m0 m0Var, w1<?, ?> w1Var, r<?> rVar, r0 r0Var) {
        boolean z4 = s1Var.b() == i1.PROTO3;
        u[] e5 = s1Var.e();
        if (e5.length != 0) {
            u uVar = e5[0];
            throw null;
        }
        int length = e5.length;
        int[] iArr = new int[length * 3];
        Object[] objArr = new Object[length * 2];
        if (e5.length > 0) {
            u uVar2 = e5[0];
            throw null;
        }
        int[] d5 = s1Var.d();
        if (d5 == null) {
            d5 = f2220r;
        }
        if (e5.length > 0) {
            u uVar3 = e5[0];
            throw null;
        }
        int[] iArr2 = f2220r;
        int[] iArr3 = f2220r;
        int[] iArr4 = new int[d5.length + iArr2.length + iArr3.length];
        System.arraycopy(d5, 0, iArr4, 0, d5.length);
        System.arraycopy(iArr2, 0, iArr4, d5.length, iArr2.length);
        System.arraycopy(iArr3, 0, iArr4, d5.length + iArr2.length, iArr3.length);
        return new z0<>(iArr, objArr, 0, 0, s1Var.c(), z4, true, iArr4, d5.length, d5.length + iArr2.length, b1Var, m0Var, w1Var, rVar, r0Var);
    }

    /* JADX WARN: Removed duplicated region for block: B:122:0x024d  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0250  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0268  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x026b  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x031a  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x031c  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x031f  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x037c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static <T> com.google.protobuf.z0<T> X(com.google.protobuf.l1 r34, com.google.protobuf.b1 r35, com.google.protobuf.m0 r36, com.google.protobuf.w1<?, ?> r37, com.google.protobuf.r<?> r38, com.google.protobuf.r0 r39) {
        /*
            Method dump skipped, instructions count: 999
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.z0.X(com.google.protobuf.l1, com.google.protobuf.b1, com.google.protobuf.m0, com.google.protobuf.w1, com.google.protobuf.r, com.google.protobuf.r0):com.google.protobuf.z0");
    }

    private int Y(int i5) {
        return this.f2222a[i5];
    }

    private static long Z(int i5) {
        return i5 & 1048575;
    }

    private static <T> boolean a0(T t5, long j5) {
        return ((Boolean) a2.G(t5, j5)).booleanValue();
    }

    private static <T> double b0(T t5, long j5) {
        return ((Double) a2.G(t5, j5)).doubleValue();
    }

    private static <T> float c0(T t5, long j5) {
        return ((Float) a2.G(t5, j5)).floatValue();
    }

    private static <T> int d0(T t5, long j5) {
        return ((Integer) a2.G(t5, j5)).intValue();
    }

    private static <T> long e0(T t5, long j5) {
        return ((Long) a2.G(t5, j5)).longValue();
    }

    private <K, V> int f0(T t5, byte[] bArr, int i5, int i6, int i7, long j5, f.b bVar) {
        Unsafe unsafe = f2221s;
        Object v5 = v(i7);
        Object object = unsafe.getObject(t5, j5);
        if (this.f2238q.d(object)) {
            Object b5 = this.f2238q.b(v5);
            this.f2238q.a(b5, object);
            unsafe.putObject(t5, j5, b5);
            object = b5;
        }
        return n(bArr, i5, i6, this.f2238q.f(v5), this.f2238q.h(object), bVar);
    }

    private int g0(T t5, byte[] bArr, int i5, int i6, int i7, int i8, int i9, int i10, int i11, long j5, int i12, f.b bVar) {
        Object valueOf;
        Object valueOf2;
        int L;
        long j6;
        int i13;
        Object valueOf3;
        Object U;
        int O;
        Unsafe unsafe = f2221s;
        long j7 = this.f2222a[i12 + 2] & 1048575;
        switch (i11) {
            case 51:
                if (i9 == 1) {
                    valueOf = Double.valueOf(f.d(bArr, i5));
                    unsafe.putObject(t5, j5, valueOf);
                    L = i5 + 8;
                    unsafe.putInt(t5, j7, i8);
                    return L;
                }
                return i5;
            case 52:
                if (i9 == 5) {
                    valueOf2 = Float.valueOf(f.l(bArr, i5));
                    unsafe.putObject(t5, j5, valueOf2);
                    L = i5 + 4;
                    unsafe.putInt(t5, j7, i8);
                    return L;
                }
                return i5;
            case 53:
            case 54:
                if (i9 == 0) {
                    L = f.L(bArr, i5, bVar);
                    j6 = bVar.f1927b;
                    valueOf3 = Long.valueOf(j6);
                    unsafe.putObject(t5, j5, valueOf3);
                    unsafe.putInt(t5, j7, i8);
                    return L;
                }
                return i5;
            case 55:
            case 62:
                if (i9 == 0) {
                    L = f.I(bArr, i5, bVar);
                    i13 = bVar.f1926a;
                    valueOf3 = Integer.valueOf(i13);
                    unsafe.putObject(t5, j5, valueOf3);
                    unsafe.putInt(t5, j7, i8);
                    return L;
                }
                return i5;
            case 56:
            case 65:
                if (i9 == 1) {
                    valueOf = Long.valueOf(f.j(bArr, i5));
                    unsafe.putObject(t5, j5, valueOf);
                    L = i5 + 8;
                    unsafe.putInt(t5, j7, i8);
                    return L;
                }
                return i5;
            case 57:
            case 64:
                if (i9 == 5) {
                    valueOf2 = Integer.valueOf(f.h(bArr, i5));
                    unsafe.putObject(t5, j5, valueOf2);
                    L = i5 + 4;
                    unsafe.putInt(t5, j7, i8);
                    return L;
                }
                return i5;
            case 58:
                if (i9 == 0) {
                    L = f.L(bArr, i5, bVar);
                    valueOf3 = Boolean.valueOf(bVar.f1927b != 0);
                    unsafe.putObject(t5, j5, valueOf3);
                    unsafe.putInt(t5, j7, i8);
                    return L;
                }
                return i5;
            case 59:
                if (i9 == 2) {
                    L = f.I(bArr, i5, bVar);
                    int i14 = bVar.f1926a;
                    if (i14 == 0) {
                        valueOf3 = "";
                        unsafe.putObject(t5, j5, valueOf3);
                        unsafe.putInt(t5, j7, i8);
                        return L;
                    } else if ((i10 & 536870912) == 0 || b2.t(bArr, L, L + i14)) {
                        unsafe.putObject(t5, j5, new String(bArr, L, i14, d0.f1911b));
                        L += i14;
                        unsafe.putInt(t5, j7, i8);
                        return L;
                    } else {
                        throw e0.d();
                    }
                }
                return i5;
            case 60:
                if (i9 == 2) {
                    U = U(t5, i8, i12);
                    O = f.O(U, w(i12), bArr, i5, i6, bVar);
                    w0(t5, i8, i12, U);
                    return O;
                }
                return i5;
            case 61:
                if (i9 == 2) {
                    L = f.b(bArr, i5, bVar);
                    valueOf3 = bVar.f1928c;
                    unsafe.putObject(t5, j5, valueOf3);
                    unsafe.putInt(t5, j7, i8);
                    return L;
                }
                return i5;
            case 63:
                if (i9 == 0) {
                    int I = f.I(bArr, i5, bVar);
                    int i15 = bVar.f1926a;
                    d0.e u5 = u(i12);
                    if (u5 == null || u5.a(i15)) {
                        unsafe.putObject(t5, j5, Integer.valueOf(i15));
                        unsafe.putInt(t5, j7, i8);
                    } else {
                        x(t5).n(i7, Long.valueOf(i15));
                    }
                    return I;
                }
                return i5;
            case 66:
                if (i9 == 0) {
                    L = f.I(bArr, i5, bVar);
                    i13 = j.b(bVar.f1926a);
                    valueOf3 = Integer.valueOf(i13);
                    unsafe.putObject(t5, j5, valueOf3);
                    unsafe.putInt(t5, j7, i8);
                    return L;
                }
                return i5;
            case 67:
                if (i9 == 0) {
                    L = f.L(bArr, i5, bVar);
                    j6 = j.c(bVar.f1927b);
                    valueOf3 = Long.valueOf(j6);
                    unsafe.putObject(t5, j5, valueOf3);
                    unsafe.putInt(t5, j7, i8);
                    return L;
                }
                return i5;
            case 68:
                if (i9 == 3) {
                    U = U(t5, i8, i12);
                    O = f.N(U, w(i12), bArr, i5, i6, (i7 & (-8)) | 4, bVar);
                    w0(t5, i8, i12, U);
                    return O;
                }
                return i5;
            default:
                return i5;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:105:0x0282, code lost:
        if (r0 != r15) goto L130;
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x02a3, code lost:
        if (r0 != r15) goto L130;
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x02a6, code lost:
        r2 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x023b, code lost:
        if (r0 != r15) goto L130;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x023d, code lost:
        r15 = r30;
        r14 = r31;
        r12 = r32;
        r13 = r34;
        r11 = r35;
        r1 = r19;
        r2 = r20;
        r6 = r24;
        r7 = r25;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v10, types: [int] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private int i0(T r31, byte[] r32, int r33, int r34, com.google.protobuf.f.b r35) {
        /*
            Method dump skipped, instructions count: 782
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.z0.i0(java.lang.Object, byte[], int, int, com.google.protobuf.f$b):int");
    }

    private int j0(T t5, byte[] bArr, int i5, int i6, int i7, int i8, int i9, int i10, long j5, int i11, long j6, f.b bVar) {
        int J;
        Unsafe unsafe = f2221s;
        d0.i iVar = (d0.i) unsafe.getObject(t5, j6);
        if (!iVar.j()) {
            int size = iVar.size();
            iVar = iVar.b(size == 0 ? 10 : size * 2);
            unsafe.putObject(t5, j6, iVar);
        }
        switch (i11) {
            case i2.d0.BYTES_VALUE_FIELD_NUMBER /* 18 */:
            case 35:
                if (i9 == 2) {
                    return f.s(bArr, i5, iVar, bVar);
                }
                if (i9 == 1) {
                    return f.e(i7, bArr, i5, i6, iVar, bVar);
                }
                break;
            case 19:
            case 36:
                if (i9 == 2) {
                    return f.v(bArr, i5, iVar, bVar);
                }
                if (i9 == 5) {
                    return f.m(i7, bArr, i5, i6, iVar, bVar);
                }
                break;
            case 20:
            case 21:
            case 37:
            case 38:
                if (i9 == 2) {
                    return f.z(bArr, i5, iVar, bVar);
                }
                if (i9 == 0) {
                    return f.M(i7, bArr, i5, i6, iVar, bVar);
                }
                break;
            case 22:
            case 29:
            case 39:
            case 43:
                if (i9 == 2) {
                    return f.y(bArr, i5, iVar, bVar);
                }
                if (i9 == 0) {
                    return f.J(i7, bArr, i5, i6, iVar, bVar);
                }
                break;
            case 23:
            case 32:
            case 40:
            case 46:
                if (i9 == 2) {
                    return f.u(bArr, i5, iVar, bVar);
                }
                if (i9 == 1) {
                    return f.k(i7, bArr, i5, i6, iVar, bVar);
                }
                break;
            case 24:
            case 31:
            case 41:
            case 45:
                if (i9 == 2) {
                    return f.t(bArr, i5, iVar, bVar);
                }
                if (i9 == 5) {
                    return f.i(i7, bArr, i5, i6, iVar, bVar);
                }
                break;
            case 25:
            case 42:
                if (i9 == 2) {
                    return f.r(bArr, i5, iVar, bVar);
                }
                if (i9 == 0) {
                    return f.a(i7, bArr, i5, i6, iVar, bVar);
                }
                break;
            case 26:
                if (i9 == 2) {
                    int i12 = ((j5 & 536870912) > 0L ? 1 : ((j5 & 536870912) == 0L ? 0 : -1));
                    d0.i iVar2 = iVar;
                    return i12 == 0 ? f.D(i7, bArr, i5, i6, iVar2, bVar) : f.E(i7, bArr, i5, i6, iVar2, bVar);
                }
                break;
            case 27:
                if (i9 == 2) {
                    return f.q(w(i10), i7, bArr, i5, i6, iVar, bVar);
                }
                break;
            case 28:
                if (i9 == 2) {
                    return f.c(i7, bArr, i5, i6, iVar, bVar);
                }
                break;
            case 30:
            case 44:
                if (i9 == 2) {
                    J = f.y(bArr, i5, iVar, bVar);
                } else if (i9 == 0) {
                    J = f.J(i7, bArr, i5, i6, iVar, bVar);
                }
                q1.A(t5, i8, iVar, u(i10), null, this.f2236o);
                return J;
            case 33:
            case 47:
                if (i9 == 2) {
                    return f.w(bArr, i5, iVar, bVar);
                }
                if (i9 == 0) {
                    return f.A(i7, bArr, i5, i6, iVar, bVar);
                }
                break;
            case 34:
            case 48:
                if (i9 == 2) {
                    return f.x(bArr, i5, iVar, bVar);
                }
                if (i9 == 0) {
                    return f.B(i7, bArr, i5, i6, iVar, bVar);
                }
                break;
            case 49:
                if (i9 == 3) {
                    return f.o(w(i10), i7, bArr, i5, i6, iVar, bVar);
                }
                break;
        }
        return i5;
    }

    private boolean k(T t5, T t6, int i5) {
        return D(t5, i5) == D(t6, i5);
    }

    private int k0(int i5) {
        if (i5 < this.f2224c || i5 > this.f2225d) {
            return -1;
        }
        return u0(i5, 0);
    }

    private static <T> boolean l(T t5, long j5) {
        return a2.t(t5, j5);
    }

    private int l0(int i5, int i6) {
        if (i5 < this.f2224c || i5 > this.f2225d) {
            return -1;
        }
        return u0(i5, i6);
    }

    private static void m(Object obj) {
        if (I(obj)) {
            return;
        }
        throw new IllegalArgumentException("Mutating immutable message: " + obj);
    }

    private int m0(int i5) {
        return this.f2222a[i5 + 2];
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v1, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r12v2 */
    /* JADX WARN: Type inference failed for: r12v3, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r13v1, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r13v2, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r13v3 */
    /* JADX WARN: Type inference failed for: r19v0, types: [java.util.Map, java.util.Map<K, V>] */
    /* JADX WARN: Type inference failed for: r1v10, types: [int] */
    private <K, V> int n(byte[] bArr, int i5, int i6, p0.a<K, V> aVar, Map<K, V> map, f.b bVar) {
        int i7;
        int I = f.I(bArr, i5, bVar);
        int i8 = bVar.f1926a;
        if (i8 < 0 || i8 > i6 - I) {
            throw e0.m();
        }
        int i9 = I + i8;
        K k5 = aVar.f2095b;
        V v5 = aVar.f2097d;
        while (I < i9) {
            int i10 = I + 1;
            byte b5 = bArr[I];
            if (b5 < 0) {
                i7 = f.H(b5, bArr, i10, bVar);
                b5 = bVar.f1926a;
            } else {
                i7 = i10;
            }
            int i11 = b5 >>> 3;
            int i12 = b5 & 7;
            if (i11 != 1) {
                if (i11 == 2 && i12 == aVar.f2096c.c()) {
                    I = o(bArr, i7, i6, aVar.f2096c, aVar.f2097d.getClass(), bVar);
                    v5 = bVar.f1928c;
                }
                I = f.P(b5, bArr, i7, i6, bVar);
            } else if (i12 == aVar.f2094a.c()) {
                I = o(bArr, i7, i6, aVar.f2094a, null, bVar);
                k5 = bVar.f1928c;
            } else {
                I = f.P(b5, bArr, i7, i6, bVar);
            }
        }
        if (I == i9) {
            map.put(k5, v5);
            return i9;
        }
        throw e0.h();
    }

    private <E> void n0(Object obj, long j5, m1 m1Var, o1<E> o1Var, q qVar) {
        m1Var.j(this.f2235n.e(obj, j5), o1Var, qVar);
    }

    private int o(byte[] bArr, int i5, int i6, c2.b bVar, Class<?> cls, f.b bVar2) {
        int L;
        Object valueOf;
        Object valueOf2;
        Object valueOf3;
        int i7;
        long j5;
        switch (a.f2239a[bVar.ordinal()]) {
            case 1:
                L = f.L(bArr, i5, bVar2);
                valueOf = Boolean.valueOf(bVar2.f1927b != 0);
                bVar2.f1928c = valueOf;
                return L;
            case 2:
                return f.b(bArr, i5, bVar2);
            case 3:
                valueOf2 = Double.valueOf(f.d(bArr, i5));
                bVar2.f1928c = valueOf2;
                return i5 + 8;
            case 4:
            case 5:
                valueOf3 = Integer.valueOf(f.h(bArr, i5));
                bVar2.f1928c = valueOf3;
                return i5 + 4;
            case 6:
            case 7:
                valueOf2 = Long.valueOf(f.j(bArr, i5));
                bVar2.f1928c = valueOf2;
                return i5 + 8;
            case 8:
                valueOf3 = Float.valueOf(f.l(bArr, i5));
                bVar2.f1928c = valueOf3;
                return i5 + 4;
            case i2.d0.ARRAY_VALUE_FIELD_NUMBER /* 9 */:
            case i2.d0.TIMESTAMP_VALUE_FIELD_NUMBER /* 10 */:
            case 11:
                L = f.I(bArr, i5, bVar2);
                i7 = bVar2.f1926a;
                valueOf = Integer.valueOf(i7);
                bVar2.f1928c = valueOf;
                return L;
            case i2.a0.EXPECTED_COUNT_FIELD_NUMBER /* 12 */:
            case 13:
                L = f.L(bArr, i5, bVar2);
                j5 = bVar2.f1927b;
                valueOf = Long.valueOf(j5);
                bVar2.f1928c = valueOf;
                return L;
            case 14:
                return f.p(j1.a().c(cls), bArr, i5, i6, bVar2);
            case 15:
                L = f.I(bArr, i5, bVar2);
                i7 = j.b(bVar2.f1926a);
                valueOf = Integer.valueOf(i7);
                bVar2.f1928c = valueOf;
                return L;
            case 16:
                L = f.L(bArr, i5, bVar2);
                j5 = j.c(bVar2.f1927b);
                valueOf = Long.valueOf(j5);
                bVar2.f1928c = valueOf;
                return L;
            case i2.d0.STRING_VALUE_FIELD_NUMBER /* 17 */:
                return f.F(bArr, i5, bVar2);
            default:
                throw new RuntimeException("unsupported field type.");
        }
    }

    private <E> void o0(Object obj, int i5, m1 m1Var, o1<E> o1Var, q qVar) {
        m1Var.t(this.f2235n.e(obj, Z(i5)), o1Var, qVar);
    }

    private static <T> double p(T t5, long j5) {
        return a2.A(t5, j5);
    }

    private void p0(Object obj, int i5, m1 m1Var) {
        long Z;
        Object B;
        if (C(i5)) {
            Z = Z(i5);
            B = m1Var.M();
        } else if (this.f2228g) {
            Z = Z(i5);
            B = m1Var.p();
        } else {
            Z = Z(i5);
            B = m1Var.B();
        }
        a2.V(obj, Z, B);
    }

    private boolean q(T t5, T t6, int i5) {
        int y02 = y0(i5);
        long Z = Z(y02);
        switch (x0(y02)) {
            case 0:
                return k(t5, t6, i5) && Double.doubleToLongBits(a2.A(t5, Z)) == Double.doubleToLongBits(a2.A(t6, Z));
            case 1:
                return k(t5, t6, i5) && Float.floatToIntBits(a2.B(t5, Z)) == Float.floatToIntBits(a2.B(t6, Z));
            case 2:
                return k(t5, t6, i5) && a2.E(t5, Z) == a2.E(t6, Z);
            case 3:
                return k(t5, t6, i5) && a2.E(t5, Z) == a2.E(t6, Z);
            case 4:
                return k(t5, t6, i5) && a2.C(t5, Z) == a2.C(t6, Z);
            case 5:
                return k(t5, t6, i5) && a2.E(t5, Z) == a2.E(t6, Z);
            case 6:
                return k(t5, t6, i5) && a2.C(t5, Z) == a2.C(t6, Z);
            case 7:
                return k(t5, t6, i5) && a2.t(t5, Z) == a2.t(t6, Z);
            case 8:
                return k(t5, t6, i5) && q1.K(a2.G(t5, Z), a2.G(t6, Z));
            case i2.d0.ARRAY_VALUE_FIELD_NUMBER /* 9 */:
                return k(t5, t6, i5) && q1.K(a2.G(t5, Z), a2.G(t6, Z));
            case i2.d0.TIMESTAMP_VALUE_FIELD_NUMBER /* 10 */:
                return k(t5, t6, i5) && q1.K(a2.G(t5, Z), a2.G(t6, Z));
            case 11:
                return k(t5, t6, i5) && a2.C(t5, Z) == a2.C(t6, Z);
            case i2.a0.EXPECTED_COUNT_FIELD_NUMBER /* 12 */:
                return k(t5, t6, i5) && a2.C(t5, Z) == a2.C(t6, Z);
            case 13:
                return k(t5, t6, i5) && a2.C(t5, Z) == a2.C(t6, Z);
            case 14:
                return k(t5, t6, i5) && a2.E(t5, Z) == a2.E(t6, Z);
            case 15:
                return k(t5, t6, i5) && a2.C(t5, Z) == a2.C(t6, Z);
            case 16:
                return k(t5, t6, i5) && a2.E(t5, Z) == a2.E(t6, Z);
            case i2.d0.STRING_VALUE_FIELD_NUMBER /* 17 */:
                return k(t5, t6, i5) && q1.K(a2.G(t5, Z), a2.G(t6, Z));
            case i2.d0.BYTES_VALUE_FIELD_NUMBER /* 18 */:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 46:
            case 47:
            case 48:
            case 49:
            case 50:
                return q1.K(a2.G(t5, Z), a2.G(t6, Z));
            case 51:
            case 52:
            case 53:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
            case 60:
            case 61:
            case 62:
            case 63:
            case 64:
            case 65:
            case 66:
            case 67:
            case 68:
                return J(t5, t6, i5) && q1.K(a2.G(t5, Z), a2.G(t6, Z));
            default:
                return true;
        }
    }

    private void q0(Object obj, int i5, m1 m1Var) {
        if (C(i5)) {
            m1Var.A(this.f2235n.e(obj, Z(i5)));
        } else {
            m1Var.v(this.f2235n.e(obj, Z(i5)));
        }
    }

    private <UT, UB> UB r(Object obj, int i5, UB ub, w1<UT, UB> w1Var, Object obj2) {
        d0.e u5;
        int Y = Y(i5);
        Object G = a2.G(obj, Z(y0(i5)));
        return (G == null || (u5 = u(i5)) == null) ? ub : (UB) s(i5, Y, this.f2238q.h(G), u5, ub, w1Var, obj2);
    }

    private static Field r0(Class<?> cls, String str) {
        Field[] declaredFields;
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            for (Field field : cls.getDeclaredFields()) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            throw new RuntimeException("Field " + str + " for " + cls.getName() + " not found. Known fields are " + Arrays.toString(declaredFields));
        }
    }

    private <K, V, UT, UB> UB s(int i5, int i6, Map<K, V> map, d0.e eVar, UB ub, w1<UT, UB> w1Var, Object obj) {
        p0.a<?, ?> f5 = this.f2238q.f(v(i5));
        Iterator<Map.Entry<K, V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<K, V> next = it.next();
            if (!eVar.a(((Integer) next.getValue()).intValue())) {
                if (ub == null) {
                    ub = w1Var.f(obj);
                }
                i.h z4 = i.z(p0.b(f5, next.getKey(), next.getValue()));
                try {
                    p0.e(z4.b(), f5, next.getKey(), next.getValue());
                    w1Var.d(ub, i6, z4.a());
                    it.remove();
                } catch (IOException e5) {
                    throw new RuntimeException(e5);
                }
            }
        }
        return ub;
    }

    private void s0(T t5, int i5) {
        int m02 = m0(i5);
        long j5 = 1048575 & m02;
        if (j5 == 1048575) {
            return;
        }
        a2.T(t5, j5, (1 << (m02 >>> 20)) | a2.C(t5, j5));
    }

    private static <T> float t(T t5, long j5) {
        return a2.B(t5, j5);
    }

    private void t0(T t5, int i5, int i6) {
        a2.T(t5, m0(i6) & 1048575, i5);
    }

    private d0.e u(int i5) {
        return (d0.e) this.f2223b[((i5 / 3) * 2) + 1];
    }

    private int u0(int i5, int i6) {
        int length = (this.f2222a.length / 3) - 1;
        while (i6 <= length) {
            int i7 = (length + i6) >>> 1;
            int i8 = i7 * 3;
            int Y = Y(i8);
            if (i5 == Y) {
                return i8;
            }
            if (i5 < Y) {
                length = i7 - 1;
            } else {
                i6 = i7 + 1;
            }
        }
        return -1;
    }

    private Object v(int i5) {
        return this.f2223b[(i5 / 3) * 2];
    }

    private void v0(T t5, int i5, Object obj) {
        f2221s.putObject(t5, Z(y0(i5)), obj);
        s0(t5, i5);
    }

    private o1 w(int i5) {
        int i6 = (i5 / 3) * 2;
        o1 o1Var = (o1) this.f2223b[i6];
        if (o1Var != null) {
            return o1Var;
        }
        o1<T> c5 = j1.a().c((Class) this.f2223b[i6 + 1]);
        this.f2223b[i6] = c5;
        return c5;
    }

    private void w0(T t5, int i5, int i6, Object obj) {
        f2221s.putObject(t5, Z(y0(i6)), obj);
        t0(t5, i5, i6);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static x1 x(Object obj) {
        z zVar = (z) obj;
        x1 x1Var = zVar.unknownFields;
        if (x1Var == x1.c()) {
            x1 k5 = x1.k();
            zVar.unknownFields = k5;
            return k5;
        }
        return x1Var;
    }

    private static int x0(int i5) {
        return (i5 & 267386880) >>> 20;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x01bb, code lost:
        if (r16.f2230i != false) goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x01cd, code lost:
        if (r16.f2230i != false) goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x01df, code lost:
        if (r16.f2230i != false) goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x01f1, code lost:
        if (r16.f2230i != false) goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:124:0x0202, code lost:
        if (r16.f2230i != false) goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:129:0x0213, code lost:
        if (r16.f2230i != false) goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:134:0x0224, code lost:
        if (r16.f2230i != false) goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:139:0x0235, code lost:
        if (r16.f2230i != false) goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:144:0x0246, code lost:
        if (r16.f2230i != false) goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:149:0x0257, code lost:
        if (r16.f2230i != false) goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:150:0x0259, code lost:
        r2.putInt(r17, r12, r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:151:0x025d, code lost:
        r4 = (com.google.protobuf.l.V(r10) + com.google.protobuf.l.X(r3)) + r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:168:0x030e, code lost:
        if ((r8 & r15) != 0) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:169:0x0310, code lost:
        r3 = com.google.protobuf.l.t(r10, (com.google.protobuf.w0) r2.getObject(r17, r13), w(r5));
     */
    /* JADX WARN: Code restructure failed: missing block: B:179:0x033b, code lost:
        if ((r8 & r15) != 0) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:180:0x033d, code lost:
        r3 = com.google.protobuf.l.N(r10, 0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:182:0x0344, code lost:
        if ((r8 & r15) != 0) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:183:0x0346, code lost:
        r4 = com.google.protobuf.l.L(r10, 0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:194:0x0369, code lost:
        if ((r8 & r15) != 0) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:195:0x036b, code lost:
        r3 = com.google.protobuf.l.h(r10, (com.google.protobuf.i) r2.getObject(r17, r13));
     */
    /* JADX WARN: Code restructure failed: missing block: B:197:0x0378, code lost:
        if ((r8 & r15) != 0) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:198:0x037a, code lost:
        r3 = com.google.protobuf.q1.o(r10, r2.getObject(r17, r13), w(r5));
     */
    /* JADX WARN: Code restructure failed: missing block: B:206:0x03a5, code lost:
        if ((r8 & r15) != 0) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:207:0x03a7, code lost:
        r3 = com.google.protobuf.l.e(r10, true);
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0068, code lost:
        if (K(r17, r10, r5) != false) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0088, code lost:
        if (K(r17, r10, r5) != false) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0090, code lost:
        if (K(r17, r10, r5) != false) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00b0, code lost:
        if (K(r17, r10, r5) != false) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00b8, code lost:
        if (K(r17, r10, r5) != false) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00de, code lost:
        if (K(r17, r10, r5) != false) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x0173, code lost:
        if (r16.f2230i != false) goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x0185, code lost:
        if (r16.f2230i != false) goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x0197, code lost:
        if (r16.f2230i != false) goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x01a9, code lost:
        if (r16.f2230i != false) goto L81;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private int y(T r17) {
        /*
            Method dump skipped, instructions count: 1198
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.z0.y(java.lang.Object):int");
    }

    private int y0(int i5) {
        return this.f2222a[i5 + 1];
    }

    /* JADX WARN: Code restructure failed: missing block: B:101:0x0184, code lost:
        if (r15.f2230i != false) goto L103;
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x0196, code lost:
        if (r15.f2230i != false) goto L103;
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x01a8, code lost:
        if (r15.f2230i != false) goto L103;
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x01b9, code lost:
        if (r15.f2230i != false) goto L103;
     */
    /* JADX WARN: Code restructure failed: missing block: B:121:0x01ca, code lost:
        if (r15.f2230i != false) goto L103;
     */
    /* JADX WARN: Code restructure failed: missing block: B:126:0x01db, code lost:
        if (r15.f2230i != false) goto L103;
     */
    /* JADX WARN: Code restructure failed: missing block: B:131:0x01ec, code lost:
        if (r15.f2230i != false) goto L103;
     */
    /* JADX WARN: Code restructure failed: missing block: B:136:0x01fd, code lost:
        if (r15.f2230i != false) goto L103;
     */
    /* JADX WARN: Code restructure failed: missing block: B:141:0x020e, code lost:
        if (r15.f2230i != false) goto L103;
     */
    /* JADX WARN: Code restructure failed: missing block: B:142:0x0210, code lost:
        r2.putInt(r16, r6, r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:143:0x0214, code lost:
        r6 = (com.google.protobuf.l.V(r8) + com.google.protobuf.l.X(r7)) + r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:193:0x0334, code lost:
        if ((r6 instanceof com.google.protobuf.i) != false) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00a6, code lost:
        if ((r6 instanceof com.google.protobuf.i) != false) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00aa, code lost:
        r6 = com.google.protobuf.l.T(r8, (java.lang.String) r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x012a, code lost:
        if (r15.f2230i != false) goto L103;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x013c, code lost:
        if (r15.f2230i != false) goto L103;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x014e, code lost:
        if (r15.f2230i != false) goto L103;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x0160, code lost:
        if (r15.f2230i != false) goto L103;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x0172, code lost:
        if (r15.f2230i != false) goto L103;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private int z(T r16) {
        /*
            Method dump skipped, instructions count: 1088
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.z0.z(java.lang.Object):int");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x0491  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void z0(T r18, com.google.protobuf.d2 r19) {
        /*
            Method dump skipped, instructions count: 1338
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.z0.z0(java.lang.Object, com.google.protobuf.d2):void");
    }

    @Override // com.google.protobuf.o1
    public void a(T t5, T t6) {
        m(t5);
        t6.getClass();
        for (int i5 = 0; i5 < this.f2222a.length; i5 += 3) {
            S(t5, t6, i5);
        }
        q1.G(this.f2236o, t5, t6);
        if (this.f2227f) {
            q1.E(this.f2237p, t5, t6);
        }
    }

    @Override // com.google.protobuf.o1
    public void b(T t5, d2 d2Var) {
        if (d2Var.B() == d2.a.DESCENDING) {
            B0(t5, d2Var);
        } else if (this.f2229h) {
            A0(t5, d2Var);
        } else {
            z0(t5, d2Var);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.protobuf.o1
    public void c(T t5) {
        int i5;
        if (I(t5)) {
            if (t5 instanceof z) {
                z zVar = (z) t5;
                zVar.x();
                zVar.w();
                zVar.P();
            }
            int length = this.f2222a.length;
            while (i5 < length) {
                int y02 = y0(i5);
                long Z = Z(y02);
                int x02 = x0(y02);
                if (x02 != 9) {
                    if (x02 != 60 && x02 != 68) {
                        switch (x02) {
                            case i2.d0.BYTES_VALUE_FIELD_NUMBER /* 18 */:
                            case 19:
                            case 20:
                            case 21:
                            case 22:
                            case 23:
                            case 24:
                            case 25:
                            case 26:
                            case 27:
                            case 28:
                            case 29:
                            case 30:
                            case 31:
                            case 32:
                            case 33:
                            case 34:
                            case 35:
                            case 36:
                            case 37:
                            case 38:
                            case 39:
                            case 40:
                            case 41:
                            case 42:
                            case 43:
                            case 44:
                            case 45:
                            case 46:
                            case 47:
                            case 48:
                            case 49:
                                this.f2235n.c(t5, Z);
                                break;
                            case 50:
                                Unsafe unsafe = f2221s;
                                Object object = unsafe.getObject(t5, Z);
                                if (object == null) {
                                    break;
                                } else {
                                    unsafe.putObject(t5, Z, this.f2238q.e(object));
                                    break;
                                }
                        }
                    } else {
                        if (!K(t5, Y(i5), i5)) {
                        }
                        w(i5).c(f2221s.getObject(t5, Z));
                    }
                }
                i5 = D(t5, i5) ? 0 : i5 + 3;
                w(i5).c(f2221s.getObject(t5, Z));
            }
            this.f2236o.j(t5);
            if (this.f2227f) {
                this.f2237p.f(t5);
            }
        }
    }

    @Override // com.google.protobuf.o1
    public final boolean d(T t5) {
        int i5;
        int i6;
        int i7 = 1048575;
        int i8 = 0;
        int i9 = 0;
        while (i9 < this.f2232k) {
            int i10 = this.f2231j[i9];
            int Y = Y(i10);
            int y02 = y0(i10);
            int i11 = this.f2222a[i10 + 2];
            int i12 = i11 & 1048575;
            int i13 = 1 << (i11 >>> 20);
            if (i12 != i7) {
                if (i12 != 1048575) {
                    i8 = f2221s.getInt(t5, i12);
                }
                i6 = i8;
                i5 = i12;
            } else {
                i5 = i7;
                i6 = i8;
            }
            if (L(y02) && !E(t5, i10, i5, i6, i13)) {
                return false;
            }
            int x02 = x0(y02);
            if (x02 != 9 && x02 != 17) {
                if (x02 != 27) {
                    if (x02 == 60 || x02 == 68) {
                        if (K(t5, Y, i10) && !F(t5, y02, w(i10))) {
                            return false;
                        }
                    } else if (x02 != 49) {
                        if (x02 == 50 && !H(t5, y02, i10)) {
                            return false;
                        }
                    }
                }
                if (!G(t5, y02, i10)) {
                    return false;
                }
            } else if (E(t5, i10, i5, i6, i13) && !F(t5, y02, w(i10))) {
                return false;
            }
            i9++;
            i7 = i5;
            i8 = i6;
        }
        return !this.f2227f || this.f2237p.c(t5).p();
    }

    @Override // com.google.protobuf.o1
    public void e(T t5, m1 m1Var, q qVar) {
        qVar.getClass();
        m(t5);
        O(this.f2236o, this.f2237p, t5, m1Var, qVar);
    }

    @Override // com.google.protobuf.o1
    public boolean f(T t5, T t6) {
        int length = this.f2222a.length;
        for (int i5 = 0; i5 < length; i5 += 3) {
            if (!q(t5, t6, i5)) {
                return false;
            }
        }
        if (this.f2236o.g(t5).equals(this.f2236o.g(t6))) {
            if (this.f2227f) {
                return this.f2237p.c(t5).equals(this.f2237p.c(t6));
            }
            return true;
        }
        return false;
    }

    @Override // com.google.protobuf.o1
    public void g(T t5, byte[] bArr, int i5, int i6, f.b bVar) {
        if (this.f2229h) {
            i0(t5, bArr, i5, i6, bVar);
        } else {
            h0(t5, bArr, i5, i6, 0, bVar);
        }
    }

    @Override // com.google.protobuf.o1
    public int h(T t5) {
        return this.f2229h ? z(t5) : y(t5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int h0(T t5, byte[] bArr, int i5, int i6, int i7, f.b bVar) {
        Unsafe unsafe;
        int i8;
        z0<T> z0Var;
        int i9;
        int i10;
        int i11;
        int i12;
        T t6;
        byte b5;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        int i22;
        byte[] bArr2;
        long j5;
        int L;
        Unsafe unsafe2;
        T t7;
        long j6;
        int i23;
        long j7;
        long j8;
        int i24;
        int i25;
        z0<T> z0Var2 = this;
        T t8 = t5;
        byte[] bArr3 = bArr;
        int i26 = i6;
        int i27 = i7;
        f.b bVar2 = bVar;
        m(t5);
        Unsafe unsafe3 = f2221s;
        int i28 = i5;
        int i29 = -1;
        int i30 = 0;
        int i31 = 0;
        int i32 = 0;
        int i33 = 1048575;
        while (true) {
            if (i28 < i26) {
                int i34 = i28 + 1;
                byte b6 = bArr3[i28];
                if (b6 < 0) {
                    int H = f.H(b6, bArr3, i34, bVar2);
                    b5 = bVar2.f1926a;
                    i34 = H;
                } else {
                    b5 = b6;
                }
                int i35 = b5 >>> 3;
                int i36 = b5 & 7;
                int l02 = i35 > i29 ? z0Var2.l0(i35, i30 / 3) : z0Var2.k0(i35);
                if (l02 == -1) {
                    i13 = i35;
                    i14 = i34;
                    i10 = b5;
                    i15 = i32;
                    i16 = i33;
                    unsafe = unsafe3;
                    i8 = i27;
                    i17 = 0;
                } else {
                    int i37 = z0Var2.f2222a[l02 + 1];
                    int x02 = x0(i37);
                    long Z = Z(i37);
                    int i38 = b5;
                    if (x02 <= 17) {
                        int i39 = z0Var2.f2222a[l02 + 2];
                        int i40 = 1 << (i39 >>> 20);
                        int i41 = i39 & 1048575;
                        if (i41 != i33) {
                            if (i33 != 1048575) {
                                unsafe3.putInt(t8, i33, i32);
                            }
                            i19 = i41;
                            i18 = unsafe3.getInt(t8, i41);
                        } else {
                            i18 = i32;
                            i19 = i33;
                        }
                        switch (x02) {
                            case 0:
                                bArr2 = bArr;
                                i13 = i35;
                                i20 = l02;
                                i21 = i19;
                                i22 = i38;
                                if (i36 == 1) {
                                    a2.R(t8, Z, f.d(bArr2, i34));
                                    i28 = i34 + 8;
                                    i32 = i18 | i40;
                                    i27 = i7;
                                    i30 = i20;
                                    i31 = i22;
                                    i29 = i13;
                                    bArr3 = bArr2;
                                    i33 = i21;
                                    break;
                                } else {
                                    i16 = i21;
                                    i14 = i34;
                                    i17 = i20;
                                    unsafe = unsafe3;
                                    i15 = i18;
                                    i10 = i22;
                                    i8 = i7;
                                    break;
                                }
                            case 1:
                                bArr2 = bArr;
                                i13 = i35;
                                i20 = l02;
                                i21 = i19;
                                i22 = i38;
                                if (i36 == 5) {
                                    a2.S(t8, Z, f.l(bArr2, i34));
                                    i28 = i34 + 4;
                                    i32 = i18 | i40;
                                    i27 = i7;
                                    i30 = i20;
                                    i31 = i22;
                                    i29 = i13;
                                    bArr3 = bArr2;
                                    i33 = i21;
                                    break;
                                } else {
                                    i16 = i21;
                                    i14 = i34;
                                    i17 = i20;
                                    unsafe = unsafe3;
                                    i15 = i18;
                                    i10 = i22;
                                    i8 = i7;
                                    break;
                                }
                            case 2:
                            case 3:
                                bArr2 = bArr;
                                i13 = i35;
                                i20 = l02;
                                i21 = i19;
                                i22 = i38;
                                j5 = Z;
                                if (i36 == 0) {
                                    L = f.L(bArr2, i34, bVar2);
                                    unsafe2 = unsafe3;
                                    t7 = t5;
                                    j6 = bVar2.f1927b;
                                    unsafe2.putLong(t7, j5, j6);
                                    i32 = i18 | i40;
                                    i27 = i7;
                                    i28 = L;
                                    i30 = i20;
                                    i31 = i22;
                                    i29 = i13;
                                    bArr3 = bArr2;
                                    i33 = i21;
                                    break;
                                } else {
                                    i16 = i21;
                                    i14 = i34;
                                    i17 = i20;
                                    unsafe = unsafe3;
                                    i15 = i18;
                                    i10 = i22;
                                    i8 = i7;
                                    break;
                                }
                            case 4:
                            case 11:
                                bArr2 = bArr;
                                i13 = i35;
                                i20 = l02;
                                i21 = i19;
                                i22 = i38;
                                if (i36 == 0) {
                                    i28 = f.I(bArr2, i34, bVar2);
                                    i23 = bVar2.f1926a;
                                    j7 = Z;
                                    unsafe3.putInt(t8, j7, i23);
                                    i32 = i18 | i40;
                                    i27 = i7;
                                    i30 = i20;
                                    i31 = i22;
                                    i29 = i13;
                                    bArr3 = bArr2;
                                    i33 = i21;
                                    break;
                                } else {
                                    i16 = i21;
                                    i14 = i34;
                                    i17 = i20;
                                    unsafe = unsafe3;
                                    i15 = i18;
                                    i10 = i22;
                                    i8 = i7;
                                    break;
                                }
                            case 5:
                            case 14:
                                bArr2 = bArr;
                                i13 = i35;
                                i20 = l02;
                                i21 = i19;
                                i22 = i38;
                                if (i36 == 1) {
                                    unsafe3.putLong(t5, Z, f.j(bArr2, i34));
                                    i28 = i34 + 8;
                                    i32 = i18 | i40;
                                    i27 = i7;
                                    i30 = i20;
                                    i31 = i22;
                                    i29 = i13;
                                    bArr3 = bArr2;
                                    i33 = i21;
                                    break;
                                } else {
                                    i16 = i21;
                                    i14 = i34;
                                    i17 = i20;
                                    unsafe = unsafe3;
                                    i15 = i18;
                                    i10 = i22;
                                    i8 = i7;
                                    break;
                                }
                            case 6:
                            case 13:
                                bArr2 = bArr;
                                i13 = i35;
                                i20 = l02;
                                i21 = i19;
                                i22 = i38;
                                if (i36 == 5) {
                                    unsafe3.putInt(t8, Z, f.h(bArr2, i34));
                                    i28 = i34 + 4;
                                    i32 = i18 | i40;
                                    i27 = i7;
                                    i30 = i20;
                                    i31 = i22;
                                    i29 = i13;
                                    bArr3 = bArr2;
                                    i33 = i21;
                                    break;
                                } else {
                                    i16 = i21;
                                    i14 = i34;
                                    i17 = i20;
                                    unsafe = unsafe3;
                                    i15 = i18;
                                    i10 = i22;
                                    i8 = i7;
                                    break;
                                }
                            case 7:
                                bArr2 = bArr;
                                i13 = i35;
                                i20 = l02;
                                i21 = i19;
                                i22 = i38;
                                if (i36 == 0) {
                                    i28 = f.L(bArr2, i34, bVar2);
                                    a2.L(t8, Z, bVar2.f1927b != 0);
                                    i32 = i18 | i40;
                                    i27 = i7;
                                    i30 = i20;
                                    i31 = i22;
                                    i29 = i13;
                                    bArr3 = bArr2;
                                    i33 = i21;
                                    break;
                                } else {
                                    i16 = i21;
                                    i14 = i34;
                                    i17 = i20;
                                    unsafe = unsafe3;
                                    i15 = i18;
                                    i10 = i22;
                                    i8 = i7;
                                    break;
                                }
                            case 8:
                                bArr2 = bArr;
                                i13 = i35;
                                i20 = l02;
                                i21 = i19;
                                i22 = i38;
                                j8 = Z;
                                if (i36 == 2) {
                                    i28 = (536870912 & i37) == 0 ? f.C(bArr2, i34, bVar2) : f.F(bArr2, i34, bVar2);
                                    unsafe3.putObject(t8, j8, bVar2.f1928c);
                                    i32 = i18 | i40;
                                    i27 = i7;
                                    i30 = i20;
                                    i31 = i22;
                                    i29 = i13;
                                    bArr3 = bArr2;
                                    i33 = i21;
                                    break;
                                } else {
                                    i16 = i21;
                                    i14 = i34;
                                    i17 = i20;
                                    unsafe = unsafe3;
                                    i15 = i18;
                                    i10 = i22;
                                    i8 = i7;
                                    break;
                                }
                            case i2.d0.ARRAY_VALUE_FIELD_NUMBER /* 9 */:
                                bArr2 = bArr;
                                i13 = i35;
                                i20 = l02;
                                i21 = i19;
                                i22 = i38;
                                if (i36 == 2) {
                                    Object T = z0Var2.T(t8, i20);
                                    i28 = f.O(T, z0Var2.w(i20), bArr, i34, i6, bVar);
                                    z0Var2.v0(t8, i20, T);
                                    i32 = i18 | i40;
                                    i27 = i7;
                                    i30 = i20;
                                    i31 = i22;
                                    i29 = i13;
                                    bArr3 = bArr2;
                                    i33 = i21;
                                    break;
                                } else {
                                    i16 = i21;
                                    i14 = i34;
                                    i17 = i20;
                                    unsafe = unsafe3;
                                    i15 = i18;
                                    i10 = i22;
                                    i8 = i7;
                                    break;
                                }
                            case i2.d0.TIMESTAMP_VALUE_FIELD_NUMBER /* 10 */:
                                bArr2 = bArr;
                                i13 = i35;
                                i20 = l02;
                                i21 = i19;
                                i22 = i38;
                                j8 = Z;
                                if (i36 == 2) {
                                    i28 = f.b(bArr2, i34, bVar2);
                                    unsafe3.putObject(t8, j8, bVar2.f1928c);
                                    i32 = i18 | i40;
                                    i27 = i7;
                                    i30 = i20;
                                    i31 = i22;
                                    i29 = i13;
                                    bArr3 = bArr2;
                                    i33 = i21;
                                    break;
                                } else {
                                    i16 = i21;
                                    i14 = i34;
                                    i17 = i20;
                                    unsafe = unsafe3;
                                    i15 = i18;
                                    i10 = i22;
                                    i8 = i7;
                                    break;
                                }
                            case i2.a0.EXPECTED_COUNT_FIELD_NUMBER /* 12 */:
                                bArr2 = bArr;
                                i13 = i35;
                                i20 = l02;
                                i21 = i19;
                                i22 = i38;
                                j7 = Z;
                                if (i36 != 0) {
                                    i16 = i21;
                                    i14 = i34;
                                    i17 = i20;
                                    unsafe = unsafe3;
                                    i15 = i18;
                                    i10 = i22;
                                    i8 = i7;
                                    break;
                                } else {
                                    i28 = f.I(bArr2, i34, bVar2);
                                    i23 = bVar2.f1926a;
                                    d0.e u5 = z0Var2.u(i20);
                                    if (u5 != null && !u5.a(i23)) {
                                        x(t5).n(i22, Long.valueOf(i23));
                                        i30 = i20;
                                        i32 = i18;
                                        i31 = i22;
                                        i29 = i13;
                                        i27 = i7;
                                        bArr3 = bArr2;
                                        i33 = i21;
                                        break;
                                    }
                                    unsafe3.putInt(t8, j7, i23);
                                    i32 = i18 | i40;
                                    i27 = i7;
                                    i30 = i20;
                                    i31 = i22;
                                    i29 = i13;
                                    bArr3 = bArr2;
                                    i33 = i21;
                                }
                                break;
                            case 15:
                                bArr2 = bArr;
                                i13 = i35;
                                i20 = l02;
                                i21 = i19;
                                i22 = i38;
                                j7 = Z;
                                if (i36 == 0) {
                                    i28 = f.I(bArr2, i34, bVar2);
                                    i23 = j.b(bVar2.f1926a);
                                    unsafe3.putInt(t8, j7, i23);
                                    i32 = i18 | i40;
                                    i27 = i7;
                                    i30 = i20;
                                    i31 = i22;
                                    i29 = i13;
                                    bArr3 = bArr2;
                                    i33 = i21;
                                    break;
                                } else {
                                    i16 = i21;
                                    i14 = i34;
                                    i17 = i20;
                                    unsafe = unsafe3;
                                    i15 = i18;
                                    i10 = i22;
                                    i8 = i7;
                                    break;
                                }
                            case 16:
                                i13 = i35;
                                i20 = l02;
                                i21 = i19;
                                i22 = i38;
                                bArr2 = bArr;
                                if (i36 == 0) {
                                    j5 = Z;
                                    L = f.L(bArr2, i34, bVar2);
                                    j6 = j.c(bVar2.f1927b);
                                    unsafe2 = unsafe3;
                                    t7 = t5;
                                    unsafe2.putLong(t7, j5, j6);
                                    i32 = i18 | i40;
                                    i27 = i7;
                                    i28 = L;
                                    i30 = i20;
                                    i31 = i22;
                                    i29 = i13;
                                    bArr3 = bArr2;
                                    i33 = i21;
                                    break;
                                } else {
                                    i16 = i21;
                                    i14 = i34;
                                    i17 = i20;
                                    unsafe = unsafe3;
                                    i15 = i18;
                                    i10 = i22;
                                    i8 = i7;
                                    break;
                                }
                            case i2.d0.STRING_VALUE_FIELD_NUMBER /* 17 */:
                                if (i36 == 3) {
                                    Object T2 = z0Var2.T(t8, l02);
                                    i28 = f.N(T2, z0Var2.w(l02), bArr, i34, i6, (i35 << 3) | 4, bVar);
                                    z0Var2.v0(t8, l02, T2);
                                    i32 = i18 | i40;
                                    i33 = i19;
                                    i27 = i7;
                                    i30 = l02;
                                    i31 = i38;
                                    i29 = i35;
                                    bArr3 = bArr;
                                    break;
                                } else {
                                    i13 = i35;
                                    i20 = l02;
                                    i21 = i19;
                                    i22 = i38;
                                    i16 = i21;
                                    i14 = i34;
                                    i17 = i20;
                                    unsafe = unsafe3;
                                    i15 = i18;
                                    i10 = i22;
                                    i8 = i7;
                                    break;
                                }
                            default:
                                i13 = i35;
                                i20 = l02;
                                i21 = i19;
                                i22 = i38;
                                i16 = i21;
                                i14 = i34;
                                i17 = i20;
                                unsafe = unsafe3;
                                i15 = i18;
                                i10 = i22;
                                i8 = i7;
                                break;
                        }
                    } else {
                        i13 = i35;
                        i16 = i33;
                        i15 = i32;
                        if (x02 == 27) {
                            if (i36 == 2) {
                                d0.i iVar = (d0.i) unsafe3.getObject(t8, Z);
                                if (!iVar.j()) {
                                    int size = iVar.size();
                                    iVar = iVar.b(size == 0 ? 10 : size * 2);
                                    unsafe3.putObject(t8, Z, iVar);
                                }
                                i28 = f.q(z0Var2.w(l02), i38, bArr, i34, i6, iVar, bVar);
                                i30 = l02;
                                i31 = i38;
                                i33 = i16;
                                i32 = i15;
                                i29 = i13;
                                bArr3 = bArr;
                                i27 = i7;
                            } else {
                                i24 = i34;
                                unsafe = unsafe3;
                                i17 = l02;
                                i25 = i38;
                                i8 = i7;
                                i14 = i24;
                            }
                        } else if (x02 <= 49) {
                            int i42 = i34;
                            unsafe = unsafe3;
                            i17 = l02;
                            i25 = i38;
                            i28 = j0(t5, bArr, i34, i6, i38, i13, i36, l02, i37, x02, Z, bVar);
                            if (i28 != i42) {
                                z0Var2 = this;
                                t8 = t5;
                                bArr3 = bArr;
                                i26 = i6;
                                i27 = i7;
                                bVar2 = bVar;
                                i33 = i16;
                                i32 = i15;
                                i30 = i17;
                                i31 = i25;
                                i29 = i13;
                                unsafe3 = unsafe;
                            } else {
                                i8 = i7;
                                i14 = i28;
                            }
                        } else {
                            i24 = i34;
                            unsafe = unsafe3;
                            i17 = l02;
                            i25 = i38;
                            if (x02 != 50) {
                                i28 = g0(t5, bArr, i24, i6, i25, i13, i36, i37, x02, Z, i17, bVar);
                                if (i28 != i24) {
                                    z0Var2 = this;
                                    t8 = t5;
                                    bArr3 = bArr;
                                    i26 = i6;
                                    i27 = i7;
                                    bVar2 = bVar;
                                    i33 = i16;
                                    i32 = i15;
                                    i30 = i17;
                                    i31 = i25;
                                    i29 = i13;
                                    unsafe3 = unsafe;
                                } else {
                                    i8 = i7;
                                    i14 = i28;
                                }
                            } else if (i36 == 2) {
                                i28 = f0(t5, bArr, i24, i6, i17, Z, bVar);
                                if (i28 != i24) {
                                    z0Var2 = this;
                                    t8 = t5;
                                    bArr3 = bArr;
                                    i26 = i6;
                                    i27 = i7;
                                    bVar2 = bVar;
                                    i33 = i16;
                                    i32 = i15;
                                    i30 = i17;
                                    i31 = i25;
                                    i29 = i13;
                                    unsafe3 = unsafe;
                                } else {
                                    i8 = i7;
                                    i14 = i28;
                                }
                            } else {
                                i8 = i7;
                                i14 = i24;
                            }
                        }
                        i10 = i25;
                    }
                }
                if (i10 != i8 || i8 == 0) {
                    i28 = (!this.f2227f || bVar.f1929d == q.b()) ? f.G(i10, bArr, i14, i6, x(t5), bVar) : f.g(i10, bArr, i14, i6, t5, this.f2226e, this.f2236o, bVar);
                    t8 = t5;
                    bArr3 = bArr;
                    i26 = i6;
                    i31 = i10;
                    z0Var2 = this;
                    bVar2 = bVar;
                    i33 = i16;
                    i32 = i15;
                    i30 = i17;
                    i29 = i13;
                    unsafe3 = unsafe;
                    i27 = i8;
                } else {
                    i12 = 1048575;
                    z0Var = this;
                    i9 = i14;
                    i11 = i16;
                    i32 = i15;
                }
            } else {
                int i43 = i33;
                unsafe = unsafe3;
                i8 = i27;
                z0Var = z0Var2;
                i9 = i28;
                i10 = i31;
                i11 = i43;
                i12 = 1048575;
            }
        }
        if (i11 != i12) {
            t6 = t5;
            unsafe.putInt(t6, i11, i32);
        } else {
            t6 = t5;
        }
        x1 x1Var = null;
        for (int i44 = z0Var.f2232k; i44 < z0Var.f2233l; i44++) {
            x1Var = (x1) r(t5, z0Var.f2231j[i44], x1Var, z0Var.f2236o, t5);
        }
        if (x1Var != null) {
            z0Var.f2236o.o(t6, x1Var);
        }
        if (i8 == 0) {
            if (i9 != i6) {
                throw e0.h();
            }
        } else if (i9 > i6 || i10 != i8) {
            throw e0.h();
        }
        return i9;
    }

    @Override // com.google.protobuf.o1
    public T i() {
        return (T) this.f2234m.a(this.f2226e);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00cc, code lost:
        if (r3 != null) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00de, code lost:
        if (r3 != null) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x00e0, code lost:
        r7 = r3.hashCode();
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x00e4, code lost:
        r2 = (r2 * 53) + r7;
     */
    @Override // com.google.protobuf.o1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int j(T r9) {
        /*
            Method dump skipped, instructions count: 474
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.z0.j(java.lang.Object):int");
    }
}
