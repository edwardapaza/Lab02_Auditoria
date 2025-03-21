package com.google.protobuf;

import com.google.protobuf.c2;
import com.google.protobuf.d2;
import com.google.protobuf.p0;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class m implements d2 {

    /* renamed from: a  reason: collision with root package name */
    private final l f2064a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f2065a;

        static {
            int[] iArr = new int[c2.b.values().length];
            f2065a = iArr;
            try {
                iArr[c2.b.f1882n.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f2065a[c2.b.f1881m.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f2065a[c2.b.f1879k.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f2065a[c2.b.f1889u.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f2065a[c2.b.f1891w.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f2065a[c2.b.f1887s.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f2065a[c2.b.f1880l.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f2065a[c2.b.f1877e.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f2065a[c2.b.f1890v.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f2065a[c2.b.f1892x.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f2065a[c2.b.f1878f.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f2065a[c2.b.f1883o.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    private m(l lVar) {
        l lVar2 = (l) d0.b(lVar, "output");
        this.f2064a = lVar2;
        lVar2.f2049a = this;
    }

    public static m P(l lVar) {
        m mVar = lVar.f2049a;
        return mVar != null ? mVar : new m(lVar);
    }

    private <V> void Q(int i5, boolean z4, V v5, p0.a<Boolean, V> aVar) {
        this.f2064a.W0(i5, 2);
        this.f2064a.Y0(p0.b(aVar, Boolean.valueOf(z4), v5));
        p0.e(this.f2064a, aVar, Boolean.valueOf(z4), v5);
    }

    private <V> void R(int i5, p0.a<Integer, V> aVar, Map<Integer, V> map) {
        int size = map.size();
        int[] iArr = new int[size];
        int i6 = 0;
        for (Integer num : map.keySet()) {
            iArr[i6] = num.intValue();
            i6++;
        }
        Arrays.sort(iArr);
        for (int i7 = 0; i7 < size; i7++) {
            int i8 = iArr[i7];
            V v5 = map.get(Integer.valueOf(i8));
            this.f2064a.W0(i5, 2);
            this.f2064a.Y0(p0.b(aVar, Integer.valueOf(i8), v5));
            p0.e(this.f2064a, aVar, Integer.valueOf(i8), v5);
        }
    }

    private <V> void S(int i5, p0.a<Long, V> aVar, Map<Long, V> map) {
        int size = map.size();
        long[] jArr = new long[size];
        int i6 = 0;
        for (Long l5 : map.keySet()) {
            jArr[i6] = l5.longValue();
            i6++;
        }
        Arrays.sort(jArr);
        for (int i7 = 0; i7 < size; i7++) {
            long j5 = jArr[i7];
            V v5 = map.get(Long.valueOf(j5));
            this.f2064a.W0(i5, 2);
            this.f2064a.Y0(p0.b(aVar, Long.valueOf(j5), v5));
            p0.e(this.f2064a, aVar, Long.valueOf(j5), v5);
        }
    }

    private <K, V> void T(int i5, p0.a<K, V> aVar, Map<K, V> map) {
        switch (a.f2065a[aVar.f2094a.ordinal()]) {
            case 1:
                V v5 = map.get(Boolean.FALSE);
                if (v5 != null) {
                    Q(i5, false, v5, aVar);
                }
                V v6 = map.get(Boolean.TRUE);
                if (v6 != null) {
                    Q(i5, true, v6, aVar);
                    return;
                }
                return;
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                R(i5, aVar, map);
                return;
            case 7:
            case 8:
            case i2.d0.ARRAY_VALUE_FIELD_NUMBER /* 9 */:
            case i2.d0.TIMESTAMP_VALUE_FIELD_NUMBER /* 10 */:
            case 11:
                S(i5, aVar, map);
                return;
            case i2.a0.EXPECTED_COUNT_FIELD_NUMBER /* 12 */:
                U(i5, aVar, map);
                return;
            default:
                throw new IllegalArgumentException("does not support key type: " + aVar.f2094a);
        }
    }

    private <V> void U(int i5, p0.a<String, V> aVar, Map<String, V> map) {
        int size = map.size();
        String[] strArr = new String[size];
        int i6 = 0;
        for (String str : map.keySet()) {
            strArr[i6] = str;
            i6++;
        }
        Arrays.sort(strArr);
        for (int i7 = 0; i7 < size; i7++) {
            String str2 = strArr[i7];
            V v5 = map.get(str2);
            this.f2064a.W0(i5, 2);
            this.f2064a.Y0(p0.b(aVar, str2, v5));
            p0.e(this.f2064a, aVar, str2, v5);
        }
    }

    private void V(int i5, Object obj) {
        if (obj instanceof String) {
            this.f2064a.U0(i5, (String) obj);
        } else {
            this.f2064a.o0(i5, (i) obj);
        }
    }

    @Override // com.google.protobuf.d2
    public void A(int i5, long j5) {
        this.f2064a.w0(i5, j5);
    }

    @Override // com.google.protobuf.d2
    public d2.a B() {
        return d2.a.ASCENDING;
    }

    @Override // com.google.protobuf.d2
    public void C(int i5, long j5) {
        this.f2064a.S0(i5, j5);
    }

    @Override // com.google.protobuf.d2
    public void D(int i5, float f5) {
        this.f2064a.y0(i5, f5);
    }

    @Override // com.google.protobuf.d2
    public void E(int i5, List<String> list) {
        int i6 = 0;
        if (!(list instanceof l0)) {
            while (i6 < list.size()) {
                this.f2064a.U0(i5, list.get(i6));
                i6++;
            }
            return;
        }
        l0 l0Var = (l0) list;
        while (i6 < list.size()) {
            V(i5, l0Var.e(i6));
            i6++;
        }
    }

    @Override // com.google.protobuf.d2
    @Deprecated
    public void F(int i5) {
        this.f2064a.W0(i5, 4);
    }

    @Override // com.google.protobuf.d2
    public void G(int i5, String str) {
        this.f2064a.U0(i5, str);
    }

    @Override // com.google.protobuf.d2
    public void H(int i5, List<Integer> list, boolean z4) {
        int i6 = 0;
        if (!z4) {
            while (i6 < list.size()) {
                this.f2064a.Q0(i5, list.get(i6).intValue());
                i6++;
            }
            return;
        }
        this.f2064a.W0(i5, 2);
        int i7 = 0;
        for (int i8 = 0; i8 < list.size(); i8++) {
            i7 += l.Q(list.get(i8).intValue());
        }
        this.f2064a.Y0(i7);
        while (i6 < list.size()) {
            this.f2064a.R0(list.get(i6).intValue());
            i6++;
        }
    }

    @Override // com.google.protobuf.d2
    public void I(int i5, long j5) {
        this.f2064a.Z0(i5, j5);
    }

    @Override // com.google.protobuf.d2
    public void J(int i5, int i6) {
        this.f2064a.s0(i5, i6);
    }

    @Override // com.google.protobuf.d2
    public void K(int i5, List<Long> list, boolean z4) {
        int i6 = 0;
        if (!z4) {
            while (i6 < list.size()) {
                this.f2064a.G0(i5, list.get(i6).longValue());
                i6++;
            }
            return;
        }
        this.f2064a.W0(i5, 2);
        int i7 = 0;
        for (int i8 = 0; i8 < list.size(); i8++) {
            i7 += l.z(list.get(i8).longValue());
        }
        this.f2064a.Y0(i7);
        while (i6 < list.size()) {
            this.f2064a.H0(list.get(i6).longValue());
            i6++;
        }
    }

    @Override // com.google.protobuf.d2
    public void L(int i5, List<Integer> list, boolean z4) {
        int i6 = 0;
        if (!z4) {
            while (i6 < list.size()) {
                this.f2064a.s0(i5, list.get(i6).intValue());
                i6++;
            }
            return;
        }
        this.f2064a.W0(i5, 2);
        int i7 = 0;
        for (int i8 = 0; i8 < list.size(); i8++) {
            i7 += l.m(list.get(i8).intValue());
        }
        this.f2064a.Y0(i7);
        while (i6 < list.size()) {
            this.f2064a.t0(list.get(i6).intValue());
            i6++;
        }
    }

    @Override // com.google.protobuf.d2
    public void M(int i5, List<Double> list, boolean z4) {
        int i6 = 0;
        if (!z4) {
            while (i6 < list.size()) {
                this.f2064a.q0(i5, list.get(i6).doubleValue());
                i6++;
            }
            return;
        }
        this.f2064a.W0(i5, 2);
        int i7 = 0;
        for (int i8 = 0; i8 < list.size(); i8++) {
            i7 += l.k(list.get(i8).doubleValue());
        }
        this.f2064a.Y0(i7);
        while (i6 < list.size()) {
            this.f2064a.r0(list.get(i6).doubleValue());
            i6++;
        }
    }

    @Override // com.google.protobuf.d2
    public void N(int i5, int i6) {
        this.f2064a.Q0(i5, i6);
    }

    @Override // com.google.protobuf.d2
    public void O(int i5, List<i> list) {
        for (int i6 = 0; i6 < list.size(); i6++) {
            this.f2064a.o0(i5, list.get(i6));
        }
    }

    @Override // com.google.protobuf.d2
    public void a(int i5, List<?> list, o1 o1Var) {
        for (int i6 = 0; i6 < list.size(); i6++) {
            w(i5, list.get(i6), o1Var);
        }
    }

    @Override // com.google.protobuf.d2
    public void b(int i5, List<?> list, o1 o1Var) {
        for (int i6 = 0; i6 < list.size(); i6++) {
            i(i5, list.get(i6), o1Var);
        }
    }

    @Override // com.google.protobuf.d2
    public void c(int i5, List<Integer> list, boolean z4) {
        int i6 = 0;
        if (!z4) {
            while (i6 < list.size()) {
                this.f2064a.E0(i5, list.get(i6).intValue());
                i6++;
            }
            return;
        }
        this.f2064a.W0(i5, 2);
        int i7 = 0;
        for (int i8 = 0; i8 < list.size(); i8++) {
            i7 += l.x(list.get(i8).intValue());
        }
        this.f2064a.Y0(i7);
        while (i6 < list.size()) {
            this.f2064a.F0(list.get(i6).intValue());
            i6++;
        }
    }

    @Override // com.google.protobuf.d2
    public void d(int i5, List<Float> list, boolean z4) {
        int i6 = 0;
        if (!z4) {
            while (i6 < list.size()) {
                this.f2064a.y0(i5, list.get(i6).floatValue());
                i6++;
            }
            return;
        }
        this.f2064a.W0(i5, 2);
        int i7 = 0;
        for (int i8 = 0; i8 < list.size(); i8++) {
            i7 += l.s(list.get(i8).floatValue());
        }
        this.f2064a.Y0(i7);
        while (i6 < list.size()) {
            this.f2064a.z0(list.get(i6).floatValue());
            i6++;
        }
    }

    @Override // com.google.protobuf.d2
    public void e(int i5, long j5) {
        this.f2064a.G0(i5, j5);
    }

    @Override // com.google.protobuf.d2
    public void f(int i5, boolean z4) {
        this.f2064a.k0(i5, z4);
    }

    @Override // com.google.protobuf.d2
    public void g(int i5, int i6) {
        this.f2064a.X0(i5, i6);
    }

    @Override // com.google.protobuf.d2
    public final void h(int i5, Object obj) {
        if (obj instanceof i) {
            this.f2064a.L0(i5, (i) obj);
        } else {
            this.f2064a.K0(i5, (w0) obj);
        }
    }

    @Override // com.google.protobuf.d2
    public void i(int i5, Object obj, o1 o1Var) {
        this.f2064a.B0(i5, (w0) obj, o1Var);
    }

    @Override // com.google.protobuf.d2
    public void j(int i5, int i6) {
        this.f2064a.M0(i5, i6);
    }

    @Override // com.google.protobuf.d2
    @Deprecated
    public void k(int i5) {
        this.f2064a.W0(i5, 3);
    }

    @Override // com.google.protobuf.d2
    public void l(int i5, i iVar) {
        this.f2064a.o0(i5, iVar);
    }

    @Override // com.google.protobuf.d2
    public void m(int i5, int i6) {
        this.f2064a.E0(i5, i6);
    }

    @Override // com.google.protobuf.d2
    public void n(int i5, List<Long> list, boolean z4) {
        int i6 = 0;
        if (!z4) {
            while (i6 < list.size()) {
                this.f2064a.w0(i5, list.get(i6).longValue());
                i6++;
            }
            return;
        }
        this.f2064a.W0(i5, 2);
        int i7 = 0;
        for (int i8 = 0; i8 < list.size(); i8++) {
            i7 += l.q(list.get(i8).longValue());
        }
        this.f2064a.Y0(i7);
        while (i6 < list.size()) {
            this.f2064a.x0(list.get(i6).longValue());
            i6++;
        }
    }

    @Override // com.google.protobuf.d2
    public void o(int i5, List<Integer> list, boolean z4) {
        int i6 = 0;
        if (!z4) {
            while (i6 < list.size()) {
                this.f2064a.M0(i5, list.get(i6).intValue());
                i6++;
            }
            return;
        }
        this.f2064a.W0(i5, 2);
        int i7 = 0;
        for (int i8 = 0; i8 < list.size(); i8++) {
            i7 += l.M(list.get(i8).intValue());
        }
        this.f2064a.Y0(i7);
        while (i6 < list.size()) {
            this.f2064a.N0(list.get(i6).intValue());
            i6++;
        }
    }

    @Override // com.google.protobuf.d2
    public void p(int i5, int i6) {
        this.f2064a.u0(i5, i6);
    }

    @Override // com.google.protobuf.d2
    public void q(int i5, double d5) {
        this.f2064a.q0(i5, d5);
    }

    @Override // com.google.protobuf.d2
    public void r(int i5, long j5) {
        this.f2064a.O0(i5, j5);
    }

    @Override // com.google.protobuf.d2
    public void s(int i5, List<Long> list, boolean z4) {
        int i6 = 0;
        if (!z4) {
            while (i6 < list.size()) {
                this.f2064a.O0(i5, list.get(i6).longValue());
                i6++;
            }
            return;
        }
        this.f2064a.W0(i5, 2);
        int i7 = 0;
        for (int i8 = 0; i8 < list.size(); i8++) {
            i7 += l.O(list.get(i8).longValue());
        }
        this.f2064a.Y0(i7);
        while (i6 < list.size()) {
            this.f2064a.P0(list.get(i6).longValue());
            i6++;
        }
    }

    @Override // com.google.protobuf.d2
    public void t(int i5, List<Integer> list, boolean z4) {
        int i6 = 0;
        if (!z4) {
            while (i6 < list.size()) {
                this.f2064a.u0(i5, list.get(i6).intValue());
                i6++;
            }
            return;
        }
        this.f2064a.W0(i5, 2);
        int i7 = 0;
        for (int i8 = 0; i8 < list.size(); i8++) {
            i7 += l.o(list.get(i8).intValue());
        }
        this.f2064a.Y0(i7);
        while (i6 < list.size()) {
            this.f2064a.v0(list.get(i6).intValue());
            i6++;
        }
    }

    @Override // com.google.protobuf.d2
    public void u(int i5, List<Long> list, boolean z4) {
        int i6 = 0;
        if (!z4) {
            while (i6 < list.size()) {
                this.f2064a.Z0(i5, list.get(i6).longValue());
                i6++;
            }
            return;
        }
        this.f2064a.W0(i5, 2);
        int i7 = 0;
        for (int i8 = 0; i8 < list.size(); i8++) {
            i7 += l.Z(list.get(i8).longValue());
        }
        this.f2064a.Y0(i7);
        while (i6 < list.size()) {
            this.f2064a.a1(list.get(i6).longValue());
            i6++;
        }
    }

    @Override // com.google.protobuf.d2
    public void v(int i5, List<Boolean> list, boolean z4) {
        int i6 = 0;
        if (!z4) {
            while (i6 < list.size()) {
                this.f2064a.k0(i5, list.get(i6).booleanValue());
                i6++;
            }
            return;
        }
        this.f2064a.W0(i5, 2);
        int i7 = 0;
        for (int i8 = 0; i8 < list.size(); i8++) {
            i7 += l.f(list.get(i8).booleanValue());
        }
        this.f2064a.Y0(i7);
        while (i6 < list.size()) {
            this.f2064a.l0(list.get(i6).booleanValue());
            i6++;
        }
    }

    @Override // com.google.protobuf.d2
    public void w(int i5, Object obj, o1 o1Var) {
        this.f2064a.I0(i5, (w0) obj, o1Var);
    }

    @Override // com.google.protobuf.d2
    public <K, V> void x(int i5, p0.a<K, V> aVar, Map<K, V> map) {
        if (this.f2064a.e0()) {
            T(i5, aVar, map);
            return;
        }
        for (Map.Entry<K, V> entry : map.entrySet()) {
            this.f2064a.W0(i5, 2);
            this.f2064a.Y0(p0.b(aVar, entry.getKey(), entry.getValue()));
            p0.e(this.f2064a, aVar, entry.getKey(), entry.getValue());
        }
    }

    @Override // com.google.protobuf.d2
    public void y(int i5, List<Integer> list, boolean z4) {
        int i6 = 0;
        if (!z4) {
            while (i6 < list.size()) {
                this.f2064a.X0(i5, list.get(i6).intValue());
                i6++;
            }
            return;
        }
        this.f2064a.W0(i5, 2);
        int i7 = 0;
        for (int i8 = 0; i8 < list.size(); i8++) {
            i7 += l.X(list.get(i8).intValue());
        }
        this.f2064a.Y0(i7);
        while (i6 < list.size()) {
            this.f2064a.Y0(list.get(i6).intValue());
            i6++;
        }
    }

    @Override // com.google.protobuf.d2
    public void z(int i5, List<Long> list, boolean z4) {
        int i6 = 0;
        if (!z4) {
            while (i6 < list.size()) {
                this.f2064a.S0(i5, list.get(i6).longValue());
                i6++;
            }
            return;
        }
        this.f2064a.W0(i5, 2);
        int i7 = 0;
        for (int i8 = 0; i8 < list.size(); i8++) {
            i7 += l.S(list.get(i8).longValue());
        }
        this.f2064a.Y0(i7);
        while (i6 < list.size()) {
            this.f2064a.T0(list.get(i6).longValue());
            i6++;
        }
    }
}
