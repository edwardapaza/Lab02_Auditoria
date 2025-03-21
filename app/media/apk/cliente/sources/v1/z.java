package v1;

import com.google.android.gms.common.api.a;
import com.google.protobuf.f1;
import com.google.protobuf.u1;
import i2.d0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import z1.h0;
/* loaded from: classes.dex */
public class z {

    /* renamed from: a  reason: collision with root package name */
    public static final d0 f8160a = d0.B0().J(Double.NaN).build();

    /* renamed from: b  reason: collision with root package name */
    public static final d0 f8161b;

    /* renamed from: c  reason: collision with root package name */
    public static final d0 f8162c;

    /* renamed from: d  reason: collision with root package name */
    private static final d0 f8163d;

    /* renamed from: e  reason: collision with root package name */
    public static final d0 f8164e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f8165a;

        static {
            int[] iArr = new int[d0.c.values().length];
            f8165a = iArr;
            try {
                iArr[d0.c.NULL_VALUE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f8165a[d0.c.BOOLEAN_VALUE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f8165a[d0.c.INTEGER_VALUE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f8165a[d0.c.DOUBLE_VALUE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f8165a[d0.c.TIMESTAMP_VALUE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f8165a[d0.c.STRING_VALUE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f8165a[d0.c.BYTES_VALUE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f8165a[d0.c.REFERENCE_VALUE.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f8165a[d0.c.GEO_POINT_VALUE.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f8165a[d0.c.ARRAY_VALUE.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f8165a[d0.c.MAP_VALUE.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
        }
    }

    static {
        d0 build = d0.B0().O(f1.NULL_VALUE).build();
        f8161b = build;
        f8162c = build;
        d0 build2 = d0.B0().Q("__max__").build();
        f8163d = build2;
        f8164e = d0.B0().M(i2.u.n0().G("__type__", build2)).build();
    }

    public static boolean A(d0 d0Var) {
        return v(d0Var) || u(d0Var);
    }

    public static boolean B(d0 d0Var) {
        return d0Var != null && d0Var.A0() == d0.c.REFERENCE_VALUE;
    }

    public static int C(d0 d0Var, boolean z4, d0 d0Var2, boolean z5) {
        int i5 = i(d0Var, d0Var2);
        if (i5 != 0) {
            return i5;
        }
        if (!z4 || z5) {
            return (z4 || !z5) ? 0 : 1;
        }
        return -1;
    }

    private static boolean D(d0 d0Var, d0 d0Var2) {
        d0.c A0 = d0Var.A0();
        d0.c cVar = d0.c.INTEGER_VALUE;
        if (A0 == cVar && d0Var2.A0() == cVar) {
            return d0Var.v0() == d0Var2.v0();
        }
        d0.c A02 = d0Var.A0();
        d0.c cVar2 = d0.c.DOUBLE_VALUE;
        return A02 == cVar2 && d0Var2.A0() == cVar2 && Double.doubleToLongBits(d0Var.t0()) == Double.doubleToLongBits(d0Var2.t0());
    }

    private static boolean E(d0 d0Var, d0 d0Var2) {
        i2.u w02 = d0Var.w0();
        i2.u w03 = d0Var2.w0();
        if (w02.g0() != w03.g0()) {
            return false;
        }
        for (Map.Entry<String, d0> entry : w02.h0().entrySet()) {
            if (!q(entry.getValue(), w03.h0().get(entry.getKey()))) {
                return false;
            }
        }
        return true;
    }

    public static d0 F(f fVar, l lVar) {
        return d0.B0().P(String.format("projects/%s/databases/%s/documents/%s", fVar.h(), fVar.e(), lVar.toString())).build();
    }

    public static int G(d0 d0Var) {
        switch (a.f8165a[d0Var.A0().ordinal()]) {
            case 1:
                return 0;
            case 2:
                return 1;
            case 3:
            case 4:
                return 2;
            case 5:
                return 3;
            case 6:
                return 5;
            case 7:
                return 6;
            case 8:
                return 7;
            case d0.ARRAY_VALUE_FIELD_NUMBER /* 9 */:
                return 8;
            case d0.TIMESTAMP_VALUE_FIELD_NUMBER /* 10 */:
                return 9;
            case 11:
                if (v.c(d0Var)) {
                    return 4;
                }
                if (x(d0Var)) {
                    return a.e.API_PRIORITY_OTHER;
                }
                return 10;
            default:
                throw z1.b.a("Invalid value type: " + d0Var.A0(), new Object[0]);
        }
    }

    public static int H(d0 d0Var, boolean z4, d0 d0Var2, boolean z5) {
        int i5 = i(d0Var, d0Var2);
        if (i5 != 0) {
            return i5;
        }
        if (!z4 || z5) {
            return (z4 || !z5) ? 0 : -1;
        }
        return 1;
    }

    private static boolean a(d0 d0Var, d0 d0Var2) {
        i2.b p02 = d0Var.p0();
        i2.b p03 = d0Var2.p0();
        if (p02.m0() != p03.m0()) {
            return false;
        }
        for (int i5 = 0; i5 < p02.m0(); i5++) {
            if (!q(p02.l0(i5), p03.l0(i5))) {
                return false;
            }
        }
        return true;
    }

    public static String b(d0 d0Var) {
        StringBuilder sb = new StringBuilder();
        h(sb, d0Var);
        return sb.toString();
    }

    private static void c(StringBuilder sb, i2.b bVar) {
        sb.append("[");
        for (int i5 = 0; i5 < bVar.m0(); i5++) {
            h(sb, bVar.l0(i5));
            if (i5 != bVar.m0() - 1) {
                sb.append(",");
            }
        }
        sb.append("]");
    }

    private static void d(StringBuilder sb, m2.a aVar) {
        sb.append(String.format("geo(%s,%s)", Double.valueOf(aVar.h0()), Double.valueOf(aVar.i0())));
    }

    private static void e(StringBuilder sb, i2.u uVar) {
        ArrayList<String> arrayList = new ArrayList(uVar.h0().keySet());
        Collections.sort(arrayList);
        sb.append("{");
        boolean z4 = true;
        for (String str : arrayList) {
            if (z4) {
                z4 = false;
            } else {
                sb.append(",");
            }
            sb.append(str);
            sb.append(":");
            h(sb, uVar.j0(str));
        }
        sb.append("}");
    }

    private static void f(StringBuilder sb, d0 d0Var) {
        z1.b.d(B(d0Var), "Value should be a ReferenceValue", new Object[0]);
        sb.append(l.h(d0Var.x0()));
    }

    private static void g(StringBuilder sb, u1 u1Var) {
        sb.append(String.format("time(%s,%s)", Long.valueOf(u1Var.i0()), Integer.valueOf(u1Var.h0())));
    }

    private static void h(StringBuilder sb, d0 d0Var) {
        String str;
        switch (a.f8165a[d0Var.A0().ordinal()]) {
            case 1:
                str = "null";
                break;
            case 2:
                sb.append(d0Var.q0());
                return;
            case 3:
                sb.append(d0Var.v0());
                return;
            case 4:
                sb.append(d0Var.t0());
                return;
            case 5:
                g(sb, d0Var.z0());
                return;
            case 6:
                str = d0Var.y0();
                break;
            case 7:
                str = h0.A(d0Var.r0());
                break;
            case 8:
                f(sb, d0Var);
                return;
            case d0.ARRAY_VALUE_FIELD_NUMBER /* 9 */:
                d(sb, d0Var.u0());
                return;
            case d0.TIMESTAMP_VALUE_FIELD_NUMBER /* 10 */:
                c(sb, d0Var.p0());
                return;
            case 11:
                e(sb, d0Var.w0());
                return;
            default:
                throw z1.b.a("Invalid value type: " + d0Var.A0(), new Object[0]);
        }
        sb.append(str);
    }

    public static int i(d0 d0Var, d0 d0Var2) {
        int G = G(d0Var);
        int G2 = G(d0Var2);
        if (G != G2) {
            return h0.l(G, G2);
        }
        if (G != Integer.MAX_VALUE) {
            switch (G) {
                case 0:
                    break;
                case 1:
                    return h0.h(d0Var.q0(), d0Var2.q0());
                case 2:
                    return m(d0Var, d0Var2);
                case 3:
                    return o(d0Var.z0(), d0Var2.z0());
                case 4:
                    return o(v.a(d0Var), v.a(d0Var2));
                case 5:
                    return d0Var.y0().compareTo(d0Var2.y0());
                case 6:
                    return h0.j(d0Var.r0(), d0Var2.r0());
                case 7:
                    return n(d0Var.x0(), d0Var2.x0());
                case 8:
                    return k(d0Var.u0(), d0Var2.u0());
                case d0.ARRAY_VALUE_FIELD_NUMBER /* 9 */:
                    return j(d0Var.p0(), d0Var2.p0());
                case d0.TIMESTAMP_VALUE_FIELD_NUMBER /* 10 */:
                    return l(d0Var.w0(), d0Var2.w0());
                default:
                    throw z1.b.a("Invalid value type: " + G, new Object[0]);
            }
        }
        return 0;
    }

    private static int j(i2.b bVar, i2.b bVar2) {
        int min = Math.min(bVar.m0(), bVar2.m0());
        for (int i5 = 0; i5 < min; i5++) {
            int i6 = i(bVar.l0(i5), bVar2.l0(i5));
            if (i6 != 0) {
                return i6;
            }
        }
        return h0.l(bVar.m0(), bVar2.m0());
    }

    private static int k(m2.a aVar, m2.a aVar2) {
        int k5 = h0.k(aVar.h0(), aVar2.h0());
        return k5 == 0 ? h0.k(aVar.i0(), aVar2.i0()) : k5;
    }

    private static int l(i2.u uVar, i2.u uVar2) {
        Iterator it = new TreeMap(uVar.h0()).entrySet().iterator();
        Iterator it2 = new TreeMap(uVar2.h0()).entrySet().iterator();
        while (it.hasNext() && it2.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Map.Entry entry2 = (Map.Entry) it2.next();
            int compareTo = ((String) entry.getKey()).compareTo((String) entry2.getKey());
            if (compareTo != 0) {
                return compareTo;
            }
            int i5 = i((d0) entry.getValue(), (d0) entry2.getValue());
            if (i5 != 0) {
                return i5;
            }
        }
        return h0.h(it.hasNext(), it2.hasNext());
    }

    private static int m(d0 d0Var, d0 d0Var2) {
        d0.c A0 = d0Var.A0();
        d0.c cVar = d0.c.DOUBLE_VALUE;
        if (A0 == cVar) {
            double t02 = d0Var.t0();
            if (d0Var2.A0() == cVar) {
                return h0.k(t02, d0Var2.t0());
            }
            if (d0Var2.A0() == d0.c.INTEGER_VALUE) {
                return h0.n(t02, d0Var2.v0());
            }
        } else {
            d0.c A02 = d0Var.A0();
            d0.c cVar2 = d0.c.INTEGER_VALUE;
            if (A02 == cVar2) {
                long v02 = d0Var.v0();
                if (d0Var2.A0() == cVar2) {
                    return h0.m(v02, d0Var2.v0());
                }
                if (d0Var2.A0() == cVar) {
                    return h0.n(d0Var2.t0(), v02) * (-1);
                }
            }
        }
        throw z1.b.a("Unexpected values: %s vs %s", d0Var, d0Var2);
    }

    private static int n(String str, String str2) {
        String[] split = str.split("/", -1);
        String[] split2 = str2.split("/", -1);
        int min = Math.min(split.length, split2.length);
        for (int i5 = 0; i5 < min; i5++) {
            int compareTo = split[i5].compareTo(split2[i5]);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        return h0.l(split.length, split2.length);
    }

    private static int o(u1 u1Var, u1 u1Var2) {
        int m5 = h0.m(u1Var.i0(), u1Var2.i0());
        return m5 != 0 ? m5 : h0.l(u1Var.h0(), u1Var2.h0());
    }

    public static boolean p(i2.c cVar, d0 d0Var) {
        for (d0 d0Var2 : cVar.e()) {
            if (q(d0Var2, d0Var)) {
                return true;
            }
        }
        return false;
    }

    public static boolean q(d0 d0Var, d0 d0Var2) {
        int G;
        if (d0Var == d0Var2) {
            return true;
        }
        if (d0Var == null || d0Var2 == null || (G = G(d0Var)) != G(d0Var2)) {
            return false;
        }
        if (G != 2) {
            if (G != 4) {
                if (G != Integer.MAX_VALUE) {
                    return G != 9 ? G != 10 ? d0Var.equals(d0Var2) : E(d0Var, d0Var2) : a(d0Var, d0Var2);
                }
                return true;
            }
            return v.a(d0Var).equals(v.a(d0Var2));
        }
        return D(d0Var, d0Var2);
    }

    public static d0 r(d0.c cVar) {
        switch (a.f8165a[cVar.ordinal()]) {
            case 1:
                return f8161b;
            case 2:
                return d0.B0().H(false).build();
            case 3:
            case 4:
                return d0.B0().J(Double.NaN).build();
            case 5:
                return d0.B0().R(u1.j0().F(Long.MIN_VALUE)).build();
            case 6:
                return d0.B0().Q("").build();
            case 7:
                return d0.B0().I(com.google.protobuf.i.f1961b).build();
            case 8:
                return F(f.f8115c, l.d());
            case d0.ARRAY_VALUE_FIELD_NUMBER /* 9 */:
                return d0.B0().K(m2.a.j0().E(-90.0d).F(-180.0d)).build();
            case d0.TIMESTAMP_VALUE_FIELD_NUMBER /* 10 */:
                return d0.B0().G(i2.b.k0()).build();
            case 11:
                return d0.B0().N(i2.u.f0()).build();
            default:
                throw new IllegalArgumentException("Unknown value type: " + cVar);
        }
    }

    public static d0 s(d0.c cVar) {
        d0.c cVar2;
        switch (a.f8165a[cVar.ordinal()]) {
            case 1:
                cVar2 = d0.c.BOOLEAN_VALUE;
                break;
            case 2:
                cVar2 = d0.c.INTEGER_VALUE;
                break;
            case 3:
            case 4:
                cVar2 = d0.c.TIMESTAMP_VALUE;
                break;
            case 5:
                cVar2 = d0.c.STRING_VALUE;
                break;
            case 6:
                cVar2 = d0.c.BYTES_VALUE;
                break;
            case 7:
                cVar2 = d0.c.REFERENCE_VALUE;
                break;
            case 8:
                cVar2 = d0.c.GEO_POINT_VALUE;
                break;
            case d0.ARRAY_VALUE_FIELD_NUMBER /* 9 */:
                cVar2 = d0.c.ARRAY_VALUE;
                break;
            case d0.TIMESTAMP_VALUE_FIELD_NUMBER /* 10 */:
                cVar2 = d0.c.MAP_VALUE;
                break;
            case 11:
                return f8164e;
            default:
                throw new IllegalArgumentException("Unknown value type: " + cVar);
        }
        return r(cVar2);
    }

    public static boolean t(d0 d0Var) {
        return d0Var != null && d0Var.A0() == d0.c.ARRAY_VALUE;
    }

    public static boolean u(d0 d0Var) {
        return d0Var != null && d0Var.A0() == d0.c.DOUBLE_VALUE;
    }

    public static boolean v(d0 d0Var) {
        return d0Var != null && d0Var.A0() == d0.c.INTEGER_VALUE;
    }

    public static boolean w(d0 d0Var) {
        return d0Var != null && d0Var.A0() == d0.c.MAP_VALUE;
    }

    public static boolean x(d0 d0Var) {
        return f8163d.equals(d0Var.w0().h0().get("__type__"));
    }

    public static boolean y(d0 d0Var) {
        return d0Var != null && Double.isNaN(d0Var.t0());
    }

    public static boolean z(d0 d0Var) {
        return d0Var != null && d0Var.A0() == d0.c.NULL_VALUE;
    }
}
