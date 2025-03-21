package com.google.protobuf;

import com.google.protobuf.c2;
import com.google.protobuf.w0;
import com.google.protobuf.z;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
final class s extends r<z.d> {

    /* loaded from: classes.dex */
    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f2131a;

        static {
            int[] iArr = new int[c2.b.values().length];
            f2131a = iArr;
            try {
                iArr[c2.b.f1875c.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f2131a[c2.b.f1876d.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f2131a[c2.b.f1877e.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f2131a[c2.b.f1878f.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f2131a[c2.b.f1879k.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f2131a[c2.b.f1880l.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f2131a[c2.b.f1881m.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f2131a[c2.b.f1882n.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f2131a[c2.b.f1887s.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f2131a[c2.b.f1889u.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f2131a[c2.b.f1890v.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f2131a[c2.b.f1891w.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f2131a[c2.b.f1892x.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f2131a[c2.b.f1888t.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f2131a[c2.b.f1886r.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f2131a[c2.b.f1883o.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f2131a[c2.b.f1884p.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                f2131a[c2.b.f1885q.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.r
    public int a(Map.Entry<?, ?> entry) {
        return ((z.d) entry.getKey()).b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.r
    public Object b(q qVar, w0 w0Var, int i5) {
        return qVar.a(w0Var, i5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.r
    public v<z.d> c(Object obj) {
        return ((z.c) obj).extensions;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.r
    public v<z.d> d(Object obj) {
        return ((z.c) obj).d0();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.r
    public boolean e(w0 w0Var) {
        return w0Var instanceof z.c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.r
    public void f(Object obj) {
        c(obj).u();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.r
    public <UT, UB> UB g(Object obj, m1 m1Var, Object obj2, q qVar, v<z.d> vVar, UB ub, w1<UT, UB> w1Var) {
        long L;
        int E;
        Object i5;
        ArrayList arrayList;
        z.e eVar = (z.e) obj2;
        int c5 = eVar.c();
        if (eVar.f2211b.f() && eVar.f2211b.l()) {
            switch (a.f2131a[eVar.a().ordinal()]) {
                case 1:
                    arrayList = new ArrayList();
                    m1Var.I(arrayList);
                    break;
                case 2:
                    arrayList = new ArrayList();
                    m1Var.C(arrayList);
                    break;
                case 3:
                    arrayList = new ArrayList();
                    m1Var.J(arrayList);
                    break;
                case 4:
                    arrayList = new ArrayList();
                    m1Var.z(arrayList);
                    break;
                case 5:
                    arrayList = new ArrayList();
                    m1Var.O(arrayList);
                    break;
                case 6:
                    arrayList = new ArrayList();
                    m1Var.N(arrayList);
                    break;
                case 7:
                    arrayList = new ArrayList();
                    m1Var.e(arrayList);
                    break;
                case 8:
                    arrayList = new ArrayList();
                    m1Var.n(arrayList);
                    break;
                case i2.d0.ARRAY_VALUE_FIELD_NUMBER /* 9 */:
                    arrayList = new ArrayList();
                    m1Var.l(arrayList);
                    break;
                case i2.d0.TIMESTAMP_VALUE_FIELD_NUMBER /* 10 */:
                    arrayList = new ArrayList();
                    m1Var.g(arrayList);
                    break;
                case 11:
                    arrayList = new ArrayList();
                    m1Var.K(arrayList);
                    break;
                case i2.a0.EXPECTED_COUNT_FIELD_NUMBER /* 12 */:
                    arrayList = new ArrayList();
                    m1Var.a(arrayList);
                    break;
                case 13:
                    arrayList = new ArrayList();
                    m1Var.i(arrayList);
                    break;
                case 14:
                    arrayList = new ArrayList();
                    m1Var.P(arrayList);
                    ub = (UB) q1.z(obj, c5, arrayList, eVar.f2211b.c(), ub, w1Var);
                    break;
                default:
                    throw new IllegalStateException("Type cannot be packed: " + eVar.f2211b.g());
            }
            vVar.y(eVar.f2211b, arrayList);
        } else {
            Object obj3 = null;
            if (eVar.a() != c2.b.f1888t) {
                switch (a.f2131a[eVar.a().ordinal()]) {
                    case 1:
                        obj3 = Double.valueOf(m1Var.readDouble());
                        break;
                    case 2:
                        obj3 = Float.valueOf(m1Var.readFloat());
                        break;
                    case 3:
                        L = m1Var.L();
                        obj3 = Long.valueOf(L);
                        break;
                    case 4:
                        L = m1Var.d();
                        obj3 = Long.valueOf(L);
                        break;
                    case 5:
                        E = m1Var.E();
                        obj3 = Integer.valueOf(E);
                        break;
                    case 6:
                        L = m1Var.f();
                        obj3 = Long.valueOf(L);
                        break;
                    case 7:
                        E = m1Var.q();
                        obj3 = Integer.valueOf(E);
                        break;
                    case 8:
                        obj3 = Boolean.valueOf(m1Var.s());
                        break;
                    case i2.d0.ARRAY_VALUE_FIELD_NUMBER /* 9 */:
                        E = m1Var.D();
                        obj3 = Integer.valueOf(E);
                        break;
                    case i2.d0.TIMESTAMP_VALUE_FIELD_NUMBER /* 10 */:
                        E = m1Var.G();
                        obj3 = Integer.valueOf(E);
                        break;
                    case 11:
                        L = m1Var.w();
                        obj3 = Long.valueOf(L);
                        break;
                    case i2.a0.EXPECTED_COUNT_FIELD_NUMBER /* 12 */:
                        E = m1Var.h();
                        obj3 = Integer.valueOf(E);
                        break;
                    case 13:
                        L = m1Var.k();
                        obj3 = Long.valueOf(L);
                        break;
                    case 14:
                        throw new IllegalStateException("Shouldn't reach here.");
                    case 15:
                        obj3 = m1Var.B();
                        break;
                    case 16:
                        obj3 = m1Var.p();
                        break;
                    case i2.d0.STRING_VALUE_FIELD_NUMBER /* 17 */:
                        if (!eVar.d()) {
                            Object i6 = vVar.i(eVar.f2211b);
                            if (i6 instanceof z) {
                                o1 d5 = j1.a().d(i6);
                                if (!((z) i6).N()) {
                                    Object i7 = d5.i();
                                    d5.a(i7, i6);
                                    vVar.y(eVar.f2211b, i7);
                                    i6 = i7;
                                }
                                m1Var.o(i6, d5, qVar);
                                return ub;
                            }
                        }
                        obj3 = m1Var.r(eVar.b().getClass(), qVar);
                        break;
                    case i2.d0.BYTES_VALUE_FIELD_NUMBER /* 18 */:
                        if (!eVar.d()) {
                            Object i8 = vVar.i(eVar.f2211b);
                            if (i8 instanceof z) {
                                o1 d6 = j1.a().d(i8);
                                if (!((z) i8).N()) {
                                    Object i9 = d6.i();
                                    d6.a(i9, i8);
                                    vVar.y(eVar.f2211b, i9);
                                    i8 = i9;
                                }
                                m1Var.x(i8, d6, qVar);
                                return ub;
                            }
                        }
                        obj3 = m1Var.m(eVar.b().getClass(), qVar);
                        break;
                }
            } else {
                int E2 = m1Var.E();
                if (eVar.f2211b.c().a(E2) == null) {
                    return (UB) q1.L(obj, c5, E2, ub, w1Var);
                }
                obj3 = Integer.valueOf(E2);
            }
            if (eVar.d()) {
                vVar.a(eVar.f2211b, obj3);
            } else {
                int i10 = a.f2131a[eVar.a().ordinal()];
                if ((i10 == 17 || i10 == 18) && (i5 = vVar.i(eVar.f2211b)) != null) {
                    obj3 = d0.h(i5, obj3);
                }
                vVar.y(eVar.f2211b, obj3);
            }
        }
        return ub;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.r
    public void h(m1 m1Var, Object obj, q qVar, v<z.d> vVar) {
        z.e eVar = (z.e) obj;
        vVar.y(eVar.f2211b, m1Var.m(eVar.b().getClass(), qVar));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.r
    public void i(i iVar, Object obj, q qVar, v<z.d> vVar) {
        z.e eVar = (z.e) obj;
        w0.a k5 = eVar.b().k();
        j A = iVar.A();
        k5.h(A, qVar);
        vVar.y(eVar.f2211b, k5.i());
        A.a(0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.r
    public void j(d2 d2Var, Map.Entry<?, ?> entry) {
        z.d dVar = (z.d) entry.getKey();
        if (!dVar.f()) {
            switch (a.f2131a[dVar.g().ordinal()]) {
                case 1:
                    d2Var.q(dVar.b(), ((Double) entry.getValue()).doubleValue());
                    return;
                case 2:
                    d2Var.D(dVar.b(), ((Float) entry.getValue()).floatValue());
                    return;
                case 3:
                    d2Var.e(dVar.b(), ((Long) entry.getValue()).longValue());
                    return;
                case 4:
                    d2Var.I(dVar.b(), ((Long) entry.getValue()).longValue());
                    return;
                case 5:
                case 14:
                    d2Var.m(dVar.b(), ((Integer) entry.getValue()).intValue());
                    return;
                case 6:
                    d2Var.A(dVar.b(), ((Long) entry.getValue()).longValue());
                    return;
                case 7:
                    d2Var.p(dVar.b(), ((Integer) entry.getValue()).intValue());
                    return;
                case 8:
                    d2Var.f(dVar.b(), ((Boolean) entry.getValue()).booleanValue());
                    return;
                case i2.d0.ARRAY_VALUE_FIELD_NUMBER /* 9 */:
                    d2Var.g(dVar.b(), ((Integer) entry.getValue()).intValue());
                    return;
                case i2.d0.TIMESTAMP_VALUE_FIELD_NUMBER /* 10 */:
                    d2Var.j(dVar.b(), ((Integer) entry.getValue()).intValue());
                    return;
                case 11:
                    d2Var.r(dVar.b(), ((Long) entry.getValue()).longValue());
                    return;
                case i2.a0.EXPECTED_COUNT_FIELD_NUMBER /* 12 */:
                    d2Var.N(dVar.b(), ((Integer) entry.getValue()).intValue());
                    return;
                case 13:
                    d2Var.C(dVar.b(), ((Long) entry.getValue()).longValue());
                    return;
                case 15:
                    d2Var.l(dVar.b(), (i) entry.getValue());
                    return;
                case 16:
                    d2Var.G(dVar.b(), (String) entry.getValue());
                    return;
                case i2.d0.STRING_VALUE_FIELD_NUMBER /* 17 */:
                    d2Var.i(dVar.b(), entry.getValue(), j1.a().c(entry.getValue().getClass()));
                    return;
                case i2.d0.BYTES_VALUE_FIELD_NUMBER /* 18 */:
                    d2Var.w(dVar.b(), entry.getValue(), j1.a().c(entry.getValue().getClass()));
                    return;
                default:
                    return;
            }
        }
        switch (a.f2131a[dVar.g().ordinal()]) {
            case 1:
                q1.P(dVar.b(), (List) entry.getValue(), d2Var, dVar.l());
                return;
            case 2:
                q1.T(dVar.b(), (List) entry.getValue(), d2Var, dVar.l());
                return;
            case 3:
                q1.W(dVar.b(), (List) entry.getValue(), d2Var, dVar.l());
                return;
            case 4:
                q1.e0(dVar.b(), (List) entry.getValue(), d2Var, dVar.l());
                return;
            case 5:
            case 14:
                q1.V(dVar.b(), (List) entry.getValue(), d2Var, dVar.l());
                return;
            case 6:
                q1.S(dVar.b(), (List) entry.getValue(), d2Var, dVar.l());
                return;
            case 7:
                q1.R(dVar.b(), (List) entry.getValue(), d2Var, dVar.l());
                return;
            case 8:
                q1.N(dVar.b(), (List) entry.getValue(), d2Var, dVar.l());
                return;
            case i2.d0.ARRAY_VALUE_FIELD_NUMBER /* 9 */:
                q1.d0(dVar.b(), (List) entry.getValue(), d2Var, dVar.l());
                return;
            case i2.d0.TIMESTAMP_VALUE_FIELD_NUMBER /* 10 */:
                q1.Y(dVar.b(), (List) entry.getValue(), d2Var, dVar.l());
                return;
            case 11:
                q1.Z(dVar.b(), (List) entry.getValue(), d2Var, dVar.l());
                return;
            case i2.a0.EXPECTED_COUNT_FIELD_NUMBER /* 12 */:
                q1.a0(dVar.b(), (List) entry.getValue(), d2Var, dVar.l());
                return;
            case 13:
                q1.b0(dVar.b(), (List) entry.getValue(), d2Var, dVar.l());
                return;
            case 15:
                q1.O(dVar.b(), (List) entry.getValue(), d2Var);
                return;
            case 16:
                q1.c0(dVar.b(), (List) entry.getValue(), d2Var);
                return;
            case i2.d0.STRING_VALUE_FIELD_NUMBER /* 17 */:
                List list = (List) entry.getValue();
                if (list == null || list.isEmpty()) {
                    return;
                }
                q1.U(dVar.b(), (List) entry.getValue(), d2Var, j1.a().c(list.get(0).getClass()));
                return;
            case i2.d0.BYTES_VALUE_FIELD_NUMBER /* 18 */:
                List list2 = (List) entry.getValue();
                if (list2 == null || list2.isEmpty()) {
                    return;
                }
                q1.X(dVar.b(), (List) entry.getValue(), d2Var, j1.a().c(list2.get(0).getClass()));
                return;
            default:
                return;
        }
    }
}
