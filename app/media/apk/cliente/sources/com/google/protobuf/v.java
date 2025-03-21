package com.google.protobuf;

import com.google.protobuf.c2;
import com.google.protobuf.d0;
import com.google.protobuf.i0;
import com.google.protobuf.v.b;
import com.google.protobuf.w0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class v<T extends b<T>> {

    /* renamed from: d  reason: collision with root package name */
    private static final v f2143d = new v(true);

    /* renamed from: a  reason: collision with root package name */
    private final r1<T, Object> f2144a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f2145b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f2146c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f2147a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f2148b;

        static {
            int[] iArr = new int[c2.b.values().length];
            f2148b = iArr;
            try {
                iArr[c2.b.f1875c.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f2148b[c2.b.f1876d.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f2148b[c2.b.f1877e.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f2148b[c2.b.f1878f.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f2148b[c2.b.f1879k.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f2148b[c2.b.f1880l.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f2148b[c2.b.f1881m.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f2148b[c2.b.f1882n.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f2148b[c2.b.f1884p.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f2148b[c2.b.f1885q.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f2148b[c2.b.f1883o.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f2148b[c2.b.f1886r.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f2148b[c2.b.f1887s.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f2148b[c2.b.f1889u.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f2148b[c2.b.f1890v.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f2148b[c2.b.f1891w.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f2148b[c2.b.f1892x.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                f2148b[c2.b.f1888t.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            int[] iArr2 = new int[c2.c.values().length];
            f2147a = iArr2;
            try {
                iArr2[c2.c.INT.ordinal()] = 1;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                f2147a[c2.c.LONG.ordinal()] = 2;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                f2147a[c2.c.FLOAT.ordinal()] = 3;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                f2147a[c2.c.DOUBLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                f2147a[c2.c.BOOLEAN.ordinal()] = 5;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                f2147a[c2.c.STRING.ordinal()] = 6;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                f2147a[c2.c.BYTE_STRING.ordinal()] = 7;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                f2147a[c2.c.ENUM.ordinal()] = 8;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                f2147a[c2.c.MESSAGE.ordinal()] = 9;
            } catch (NoSuchFieldError unused27) {
            }
        }
    }

    /* loaded from: classes.dex */
    public interface b<T extends b<T>> extends Comparable<T> {
        int b();

        boolean f();

        c2.b g();

        w0.a i(w0.a aVar, w0 w0Var);

        c2.c j();

        boolean l();
    }

    private v() {
        this.f2144a = r1.q(16);
    }

    private v(r1<T, Object> r1Var) {
        this.f2144a = r1Var;
        u();
    }

    private v(boolean z4) {
        this(r1.q(0));
        u();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void A(l lVar, c2.b bVar, int i5, Object obj) {
        if (bVar == c2.b.f1884p) {
            lVar.A0(i5, (w0) obj);
            return;
        }
        lVar.W0(i5, m(bVar, false));
        B(lVar, bVar, obj);
    }

    static void B(l lVar, c2.b bVar, Object obj) {
        switch (a.f2148b[bVar.ordinal()]) {
            case 1:
                lVar.r0(((Double) obj).doubleValue());
                return;
            case 2:
                lVar.z0(((Float) obj).floatValue());
                return;
            case 3:
                lVar.H0(((Long) obj).longValue());
                return;
            case 4:
                lVar.a1(((Long) obj).longValue());
                return;
            case 5:
                lVar.F0(((Integer) obj).intValue());
                return;
            case 6:
                lVar.x0(((Long) obj).longValue());
                return;
            case 7:
                lVar.v0(((Integer) obj).intValue());
                return;
            case 8:
                lVar.l0(((Boolean) obj).booleanValue());
                return;
            case i2.d0.ARRAY_VALUE_FIELD_NUMBER /* 9 */:
                lVar.C0((w0) obj);
                return;
            case i2.d0.TIMESTAMP_VALUE_FIELD_NUMBER /* 10 */:
                lVar.J0((w0) obj);
                return;
            case 11:
                if (!(obj instanceof i)) {
                    lVar.V0((String) obj);
                    return;
                }
                break;
            case i2.a0.EXPECTED_COUNT_FIELD_NUMBER /* 12 */:
                if (!(obj instanceof i)) {
                    lVar.m0((byte[]) obj);
                    return;
                }
                break;
            case 13:
                lVar.Y0(((Integer) obj).intValue());
                return;
            case 14:
                lVar.N0(((Integer) obj).intValue());
                return;
            case 15:
                lVar.P0(((Long) obj).longValue());
                return;
            case 16:
                lVar.R0(((Integer) obj).intValue());
                return;
            case i2.d0.STRING_VALUE_FIELD_NUMBER /* 17 */:
                lVar.T0(((Long) obj).longValue());
                return;
            case i2.d0.BYTES_VALUE_FIELD_NUMBER /* 18 */:
                lVar.t0(obj instanceof d0.c ? ((d0.c) obj).b() : ((Integer) obj).intValue());
                return;
            default:
                return;
        }
        lVar.p0((i) obj);
    }

    private static Object c(Object obj) {
        if (obj instanceof byte[]) {
            byte[] bArr = (byte[]) obj;
            byte[] bArr2 = new byte[bArr.length];
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            return bArr2;
        }
        return obj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int d(c2.b bVar, int i5, Object obj) {
        int V = l.V(i5);
        if (bVar == c2.b.f1884p) {
            V *= 2;
        }
        return V + e(bVar, obj);
    }

    static int e(c2.b bVar, Object obj) {
        switch (a.f2148b[bVar.ordinal()]) {
            case 1:
                return l.k(((Double) obj).doubleValue());
            case 2:
                return l.s(((Float) obj).floatValue());
            case 3:
                return l.z(((Long) obj).longValue());
            case 4:
                return l.Z(((Long) obj).longValue());
            case 5:
                return l.x(((Integer) obj).intValue());
            case 6:
                return l.q(((Long) obj).longValue());
            case 7:
                return l.o(((Integer) obj).intValue());
            case 8:
                return l.f(((Boolean) obj).booleanValue());
            case i2.d0.ARRAY_VALUE_FIELD_NUMBER /* 9 */:
                return l.u((w0) obj);
            case i2.d0.TIMESTAMP_VALUE_FIELD_NUMBER /* 10 */:
                return obj instanceof i0 ? l.C((i0) obj) : l.H((w0) obj);
            case 11:
                return obj instanceof i ? l.i((i) obj) : l.U((String) obj);
            case i2.a0.EXPECTED_COUNT_FIELD_NUMBER /* 12 */:
                return obj instanceof i ? l.i((i) obj) : l.g((byte[]) obj);
            case 13:
                return l.X(((Integer) obj).intValue());
            case 14:
                return l.M(((Integer) obj).intValue());
            case 15:
                return l.O(((Long) obj).longValue());
            case 16:
                return l.Q(((Integer) obj).intValue());
            case i2.d0.STRING_VALUE_FIELD_NUMBER /* 17 */:
                return l.S(((Long) obj).longValue());
            case i2.d0.BYTES_VALUE_FIELD_NUMBER /* 18 */:
                return obj instanceof d0.c ? l.m(((d0.c) obj).b()) : l.m(((Integer) obj).intValue());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    public static int f(b<?> bVar, Object obj) {
        c2.b g5 = bVar.g();
        int b5 = bVar.b();
        if (bVar.f()) {
            List<Object> list = (List) obj;
            int i5 = 0;
            if (!bVar.l()) {
                for (Object obj2 : list) {
                    i5 += d(g5, b5, obj2);
                }
                return i5;
            } else if (list.isEmpty()) {
                return 0;
            } else {
                for (Object obj3 : list) {
                    i5 += e(g5, obj3);
                }
                return l.V(b5) + i5 + l.X(i5);
            }
        }
        return d(g5, b5, obj);
    }

    public static <T extends b<T>> v<T> h() {
        return f2143d;
    }

    private int k(Map.Entry<T, Object> entry) {
        T key = entry.getKey();
        Object value = entry.getValue();
        if (key.j() != c2.c.MESSAGE || key.f() || key.l()) {
            return f(key, value);
        }
        boolean z4 = value instanceof i0;
        int b5 = entry.getKey().b();
        return z4 ? l.A(b5, (i0) value) : l.E(b5, (w0) value);
    }

    static int m(c2.b bVar, boolean z4) {
        if (z4) {
            return 2;
        }
        return bVar.c();
    }

    private static <T extends b<T>> boolean q(Map.Entry<T, Object> entry) {
        T key = entry.getKey();
        if (key.j() == c2.c.MESSAGE) {
            boolean f5 = key.f();
            Object value = entry.getValue();
            if (f5) {
                for (Object obj : (List) value) {
                    if (!r(obj)) {
                        return false;
                    }
                }
                return true;
            }
            return r(value);
        }
        return true;
    }

    private static boolean r(Object obj) {
        if (obj instanceof x0) {
            return ((x0) obj).n();
        }
        if (obj instanceof i0) {
            return true;
        }
        throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
    }

    private static boolean s(c2.b bVar, Object obj) {
        d0.a(obj);
        switch (a.f2147a[bVar.a().ordinal()]) {
            case 1:
                return obj instanceof Integer;
            case 2:
                return obj instanceof Long;
            case 3:
                return obj instanceof Float;
            case 4:
                return obj instanceof Double;
            case 5:
                return obj instanceof Boolean;
            case 6:
                return obj instanceof String;
            case 7:
                return (obj instanceof i) || (obj instanceof byte[]);
            case 8:
                return (obj instanceof Integer) || (obj instanceof d0.c);
            case i2.d0.ARRAY_VALUE_FIELD_NUMBER /* 9 */:
                return (obj instanceof w0) || (obj instanceof i0);
            default:
                return false;
        }
    }

    private void w(Map.Entry<T, Object> entry) {
        r1<T, Object> r1Var;
        Object c5;
        Object i5;
        T key = entry.getKey();
        Object value = entry.getValue();
        if (value instanceof i0) {
            value = ((i0) value).f();
        }
        if (key.f()) {
            Object i6 = i(key);
            if (i6 == null) {
                i6 = new ArrayList();
            }
            for (Object obj : (List) value) {
                ((List) i6).add(c(obj));
            }
            this.f2144a.put(key, i6);
            return;
        }
        if (key.j() != c2.c.MESSAGE || (i5 = i(key)) == null) {
            r1Var = this.f2144a;
            c5 = c(value);
        } else {
            c5 = key.i(((w0) i5).c(), (w0) value).build();
            r1Var = this.f2144a;
        }
        r1Var.put(key, c5);
    }

    public static <T extends b<T>> v<T> x() {
        return new v<>();
    }

    private void z(T t5, Object obj) {
        if (!s(t5.g(), obj)) {
            throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(t5.b()), t5.g().a(), obj.getClass().getName()));
        }
    }

    public void a(T t5, Object obj) {
        List list;
        if (!t5.f()) {
            throw new IllegalArgumentException("addRepeatedField() can only be called on repeated fields.");
        }
        z(t5, obj);
        Object i5 = i(t5);
        if (i5 == null) {
            list = new ArrayList();
            this.f2144a.put(t5, list);
        } else {
            list = (List) i5;
        }
        list.add(obj);
    }

    /* renamed from: b */
    public v<T> clone() {
        v<T> x4 = x();
        for (int i5 = 0; i5 < this.f2144a.k(); i5++) {
            Map.Entry<T, Object> j5 = this.f2144a.j(i5);
            x4.y(j5.getKey(), j5.getValue());
        }
        for (Map.Entry<T, Object> entry : this.f2144a.m()) {
            x4.y(entry.getKey(), entry.getValue());
        }
        x4.f2146c = this.f2146c;
        return x4;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof v) {
            return this.f2144a.equals(((v) obj).f2144a);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Iterator<Map.Entry<T, Object>> g() {
        return this.f2146c ? new i0.c(this.f2144a.h().iterator()) : this.f2144a.h().iterator();
    }

    public int hashCode() {
        return this.f2144a.hashCode();
    }

    public Object i(T t5) {
        Object obj = this.f2144a.get(t5);
        return obj instanceof i0 ? ((i0) obj).f() : obj;
    }

    public int j() {
        int i5 = 0;
        for (int i6 = 0; i6 < this.f2144a.k(); i6++) {
            i5 += k(this.f2144a.j(i6));
        }
        for (Map.Entry<T, Object> entry : this.f2144a.m()) {
            i5 += k(entry);
        }
        return i5;
    }

    public int l() {
        int i5 = 0;
        for (int i6 = 0; i6 < this.f2144a.k(); i6++) {
            Map.Entry<T, Object> j5 = this.f2144a.j(i6);
            i5 += f(j5.getKey(), j5.getValue());
        }
        for (Map.Entry<T, Object> entry : this.f2144a.m()) {
            i5 += f(entry.getKey(), entry.getValue());
        }
        return i5;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean n() {
        return this.f2144a.isEmpty();
    }

    public boolean o() {
        return this.f2145b;
    }

    public boolean p() {
        for (int i5 = 0; i5 < this.f2144a.k(); i5++) {
            if (!q(this.f2144a.j(i5))) {
                return false;
            }
        }
        for (Map.Entry<T, Object> entry : this.f2144a.m()) {
            if (!q(entry)) {
                return false;
            }
        }
        return true;
    }

    public Iterator<Map.Entry<T, Object>> t() {
        return this.f2146c ? new i0.c(this.f2144a.entrySet().iterator()) : this.f2144a.entrySet().iterator();
    }

    public void u() {
        if (this.f2145b) {
            return;
        }
        for (int i5 = 0; i5 < this.f2144a.k(); i5++) {
            Map.Entry<T, Object> j5 = this.f2144a.j(i5);
            if (j5.getValue() instanceof z) {
                ((z) j5.getValue()).O();
            }
        }
        this.f2144a.p();
        this.f2145b = true;
    }

    public void v(v<T> vVar) {
        for (int i5 = 0; i5 < vVar.f2144a.k(); i5++) {
            w(vVar.f2144a.j(i5));
        }
        for (Map.Entry<T, Object> entry : vVar.f2144a.m()) {
            w(entry);
        }
    }

    public void y(T t5, Object obj) {
        if (!t5.f()) {
            z(t5, obj);
        } else if (!(obj instanceof List)) {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        } else {
            ArrayList<Object> arrayList = new ArrayList();
            arrayList.addAll((List) obj);
            for (Object obj2 : arrayList) {
                z(t5, obj2);
            }
            obj = arrayList;
        }
        if (obj instanceof i0) {
            this.f2146c = true;
        }
        this.f2144a.put(t5, obj);
    }
}
