package com.google.protobuf;

import com.google.android.gms.common.api.a;
import com.google.protobuf.c2;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class k implements m1 {

    /* renamed from: a  reason: collision with root package name */
    private final j f2036a;

    /* renamed from: b  reason: collision with root package name */
    private int f2037b;

    /* renamed from: c  reason: collision with root package name */
    private int f2038c;

    /* renamed from: d  reason: collision with root package name */
    private int f2039d = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f2040a;

        static {
            int[] iArr = new int[c2.b.values().length];
            f2040a = iArr;
            try {
                iArr[c2.b.f1882n.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f2040a[c2.b.f1886r.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f2040a[c2.b.f1875c.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f2040a[c2.b.f1888t.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f2040a[c2.b.f1881m.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f2040a[c2.b.f1880l.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f2040a[c2.b.f1876d.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f2040a[c2.b.f1879k.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f2040a[c2.b.f1877e.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f2040a[c2.b.f1885q.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f2040a[c2.b.f1889u.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f2040a[c2.b.f1890v.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f2040a[c2.b.f1891w.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f2040a[c2.b.f1892x.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f2040a[c2.b.f1883o.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f2040a[c2.b.f1887s.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f2040a[c2.b.f1878f.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
        }
    }

    private k(j jVar) {
        j jVar2 = (j) d0.b(jVar, "input");
        this.f2036a = jVar2;
        jVar2.f1983d = this;
    }

    public static k Q(j jVar) {
        k kVar = jVar.f1983d;
        return kVar != null ? kVar : new k(jVar);
    }

    private <T> void R(T t5, o1<T> o1Var, q qVar) {
        int i5 = this.f2038c;
        this.f2038c = c2.c(c2.a(this.f2037b), 4);
        try {
            o1Var.e(t5, this, qVar);
            if (this.f2037b == this.f2038c) {
                return;
            }
            throw e0.h();
        } finally {
            this.f2038c = i5;
        }
    }

    private <T> void S(T t5, o1<T> o1Var, q qVar) {
        j jVar;
        int E = this.f2036a.E();
        j jVar2 = this.f2036a;
        if (jVar2.f1980a >= jVar2.f1981b) {
            throw e0.i();
        }
        int n5 = jVar2.n(E);
        this.f2036a.f1980a++;
        o1Var.e(t5, this, qVar);
        this.f2036a.a(0);
        jVar.f1980a--;
        this.f2036a.m(n5);
    }

    private Object T(c2.b bVar, Class<?> cls, q qVar) {
        switch (a.f2040a[bVar.ordinal()]) {
            case 1:
                return Boolean.valueOf(s());
            case 2:
                return B();
            case 3:
                return Double.valueOf(readDouble());
            case 4:
                return Integer.valueOf(b());
            case 5:
                return Integer.valueOf(q());
            case 6:
                return Long.valueOf(f());
            case 7:
                return Float.valueOf(readFloat());
            case 8:
                return Integer.valueOf(E());
            case i2.d0.ARRAY_VALUE_FIELD_NUMBER /* 9 */:
                return Long.valueOf(L());
            case i2.d0.TIMESTAMP_VALUE_FIELD_NUMBER /* 10 */:
                return m(cls, qVar);
            case 11:
                return Integer.valueOf(G());
            case i2.a0.EXPECTED_COUNT_FIELD_NUMBER /* 12 */:
                return Long.valueOf(w());
            case 13:
                return Integer.valueOf(h());
            case 14:
                return Long.valueOf(k());
            case 15:
                return M();
            case 16:
                return Integer.valueOf(D());
            case i2.d0.STRING_VALUE_FIELD_NUMBER /* 17 */:
                return Long.valueOf(d());
            default:
                throw new IllegalArgumentException("unsupported field type.");
        }
    }

    private <T> T U(o1<T> o1Var, q qVar) {
        T i5 = o1Var.i();
        R(i5, o1Var, qVar);
        o1Var.c(i5);
        return i5;
    }

    private <T> T V(o1<T> o1Var, q qVar) {
        T i5 = o1Var.i();
        S(i5, o1Var, qVar);
        o1Var.c(i5);
        return i5;
    }

    private void X(int i5) {
        if (this.f2036a.d() != i5) {
            throw e0.m();
        }
    }

    private void Y(int i5) {
        if (c2.b(this.f2037b) != i5) {
            throw e0.e();
        }
    }

    private void Z(int i5) {
        if ((i5 & 3) != 0) {
            throw e0.h();
        }
    }

    private void a0(int i5) {
        if ((i5 & 7) != 0) {
            throw e0.h();
        }
    }

    @Override // com.google.protobuf.m1
    public void A(List<String> list) {
        W(list, true);
    }

    @Override // com.google.protobuf.m1
    public i B() {
        Y(2);
        return this.f2036a.p();
    }

    @Override // com.google.protobuf.m1
    public void C(List<Float> list) {
        int D;
        int D2;
        if (!(list instanceof x)) {
            int b5 = c2.b(this.f2037b);
            if (b5 == 2) {
                int E = this.f2036a.E();
                Z(E);
                int d5 = this.f2036a.d() + E;
                do {
                    list.add(Float.valueOf(this.f2036a.u()));
                } while (this.f2036a.d() < d5);
                return;
            } else if (b5 != 5) {
                throw e0.e();
            } else {
                do {
                    list.add(Float.valueOf(this.f2036a.u()));
                    if (this.f2036a.e()) {
                        return;
                    }
                    D = this.f2036a.D();
                } while (D == this.f2037b);
                this.f2039d = D;
                return;
            }
        }
        x xVar = (x) list;
        int b6 = c2.b(this.f2037b);
        if (b6 == 2) {
            int E2 = this.f2036a.E();
            Z(E2);
            int d6 = this.f2036a.d() + E2;
            do {
                xVar.k(this.f2036a.u());
            } while (this.f2036a.d() < d6);
        } else if (b6 != 5) {
            throw e0.e();
        } else {
            do {
                xVar.k(this.f2036a.u());
                if (this.f2036a.e()) {
                    return;
                }
                D2 = this.f2036a.D();
            } while (D2 == this.f2037b);
            this.f2039d = D2;
        }
    }

    @Override // com.google.protobuf.m1
    public int D() {
        Y(0);
        return this.f2036a.E();
    }

    @Override // com.google.protobuf.m1
    public int E() {
        Y(0);
        return this.f2036a.v();
    }

    @Override // com.google.protobuf.m1
    public boolean F() {
        int i5;
        if (this.f2036a.e() || (i5 = this.f2037b) == this.f2038c) {
            return false;
        }
        return this.f2036a.I(i5);
    }

    @Override // com.google.protobuf.m1
    public int G() {
        Y(5);
        return this.f2036a.x();
    }

    @Override // com.google.protobuf.m1
    public void H(List<i> list) {
        int D;
        if (c2.b(this.f2037b) != 2) {
            throw e0.e();
        }
        do {
            list.add(B());
            if (this.f2036a.e()) {
                return;
            }
            D = this.f2036a.D();
        } while (D == this.f2037b);
        this.f2039d = D;
    }

    @Override // com.google.protobuf.m1
    public void I(List<Double> list) {
        int D;
        int D2;
        if (!(list instanceof n)) {
            int b5 = c2.b(this.f2037b);
            if (b5 == 1) {
                do {
                    list.add(Double.valueOf(this.f2036a.q()));
                    if (this.f2036a.e()) {
                        return;
                    }
                    D = this.f2036a.D();
                } while (D == this.f2037b);
                this.f2039d = D;
                return;
            } else if (b5 != 2) {
                throw e0.e();
            } else {
                int E = this.f2036a.E();
                a0(E);
                int d5 = this.f2036a.d() + E;
                do {
                    list.add(Double.valueOf(this.f2036a.q()));
                } while (this.f2036a.d() < d5);
                return;
            }
        }
        n nVar = (n) list;
        int b6 = c2.b(this.f2037b);
        if (b6 == 1) {
            do {
                nVar.k(this.f2036a.q());
                if (this.f2036a.e()) {
                    return;
                }
                D2 = this.f2036a.D();
            } while (D2 == this.f2037b);
            this.f2039d = D2;
        } else if (b6 != 2) {
            throw e0.e();
        } else {
            int E2 = this.f2036a.E();
            a0(E2);
            int d6 = this.f2036a.d() + E2;
            do {
                nVar.k(this.f2036a.q());
            } while (this.f2036a.d() < d6);
        }
    }

    @Override // com.google.protobuf.m1
    public void J(List<Long> list) {
        int D;
        int d5;
        int D2;
        if (list instanceof n0) {
            n0 n0Var = (n0) list;
            int b5 = c2.b(this.f2037b);
            if (b5 == 0) {
                do {
                    n0Var.l(this.f2036a.w());
                    if (this.f2036a.e()) {
                        return;
                    }
                    D2 = this.f2036a.D();
                } while (D2 == this.f2037b);
                this.f2039d = D2;
                return;
            } else if (b5 != 2) {
                throw e0.e();
            } else {
                d5 = this.f2036a.d() + this.f2036a.E();
                do {
                    n0Var.l(this.f2036a.w());
                } while (this.f2036a.d() < d5);
            }
        } else {
            int b6 = c2.b(this.f2037b);
            if (b6 == 0) {
                do {
                    list.add(Long.valueOf(this.f2036a.w()));
                    if (this.f2036a.e()) {
                        return;
                    }
                    D = this.f2036a.D();
                } while (D == this.f2037b);
                this.f2039d = D;
                return;
            } else if (b6 != 2) {
                throw e0.e();
            } else {
                d5 = this.f2036a.d() + this.f2036a.E();
                do {
                    list.add(Long.valueOf(this.f2036a.w()));
                } while (this.f2036a.d() < d5);
            }
        }
        X(d5);
    }

    @Override // com.google.protobuf.m1
    public void K(List<Long> list) {
        int D;
        int D2;
        if (!(list instanceof n0)) {
            int b5 = c2.b(this.f2037b);
            if (b5 == 1) {
                do {
                    list.add(Long.valueOf(this.f2036a.y()));
                    if (this.f2036a.e()) {
                        return;
                    }
                    D = this.f2036a.D();
                } while (D == this.f2037b);
                this.f2039d = D;
                return;
            } else if (b5 != 2) {
                throw e0.e();
            } else {
                int E = this.f2036a.E();
                a0(E);
                int d5 = this.f2036a.d() + E;
                do {
                    list.add(Long.valueOf(this.f2036a.y()));
                } while (this.f2036a.d() < d5);
                return;
            }
        }
        n0 n0Var = (n0) list;
        int b6 = c2.b(this.f2037b);
        if (b6 == 1) {
            do {
                n0Var.l(this.f2036a.y());
                if (this.f2036a.e()) {
                    return;
                }
                D2 = this.f2036a.D();
            } while (D2 == this.f2037b);
            this.f2039d = D2;
        } else if (b6 != 2) {
            throw e0.e();
        } else {
            int E2 = this.f2036a.E();
            a0(E2);
            int d6 = this.f2036a.d() + E2;
            do {
                n0Var.l(this.f2036a.y());
            } while (this.f2036a.d() < d6);
        }
    }

    @Override // com.google.protobuf.m1
    public long L() {
        Y(0);
        return this.f2036a.w();
    }

    @Override // com.google.protobuf.m1
    public String M() {
        Y(2);
        return this.f2036a.C();
    }

    @Override // com.google.protobuf.m1
    public void N(List<Long> list) {
        int D;
        int D2;
        if (!(list instanceof n0)) {
            int b5 = c2.b(this.f2037b);
            if (b5 == 1) {
                do {
                    list.add(Long.valueOf(this.f2036a.t()));
                    if (this.f2036a.e()) {
                        return;
                    }
                    D = this.f2036a.D();
                } while (D == this.f2037b);
                this.f2039d = D;
                return;
            } else if (b5 != 2) {
                throw e0.e();
            } else {
                int E = this.f2036a.E();
                a0(E);
                int d5 = this.f2036a.d() + E;
                do {
                    list.add(Long.valueOf(this.f2036a.t()));
                } while (this.f2036a.d() < d5);
                return;
            }
        }
        n0 n0Var = (n0) list;
        int b6 = c2.b(this.f2037b);
        if (b6 == 1) {
            do {
                n0Var.l(this.f2036a.t());
                if (this.f2036a.e()) {
                    return;
                }
                D2 = this.f2036a.D();
            } while (D2 == this.f2037b);
            this.f2039d = D2;
        } else if (b6 != 2) {
            throw e0.e();
        } else {
            int E2 = this.f2036a.E();
            a0(E2);
            int d6 = this.f2036a.d() + E2;
            do {
                n0Var.l(this.f2036a.t());
            } while (this.f2036a.d() < d6);
        }
    }

    @Override // com.google.protobuf.m1
    public void O(List<Integer> list) {
        int D;
        int d5;
        int D2;
        if (list instanceof c0) {
            c0 c0Var = (c0) list;
            int b5 = c2.b(this.f2037b);
            if (b5 == 0) {
                do {
                    c0Var.k(this.f2036a.v());
                    if (this.f2036a.e()) {
                        return;
                    }
                    D2 = this.f2036a.D();
                } while (D2 == this.f2037b);
                this.f2039d = D2;
                return;
            } else if (b5 != 2) {
                throw e0.e();
            } else {
                d5 = this.f2036a.d() + this.f2036a.E();
                do {
                    c0Var.k(this.f2036a.v());
                } while (this.f2036a.d() < d5);
            }
        } else {
            int b6 = c2.b(this.f2037b);
            if (b6 == 0) {
                do {
                    list.add(Integer.valueOf(this.f2036a.v()));
                    if (this.f2036a.e()) {
                        return;
                    }
                    D = this.f2036a.D();
                } while (D == this.f2037b);
                this.f2039d = D;
                return;
            } else if (b6 != 2) {
                throw e0.e();
            } else {
                d5 = this.f2036a.d() + this.f2036a.E();
                do {
                    list.add(Integer.valueOf(this.f2036a.v()));
                } while (this.f2036a.d() < d5);
            }
        }
        X(d5);
    }

    @Override // com.google.protobuf.m1
    public void P(List<Integer> list) {
        int D;
        int d5;
        int D2;
        if (list instanceof c0) {
            c0 c0Var = (c0) list;
            int b5 = c2.b(this.f2037b);
            if (b5 == 0) {
                do {
                    c0Var.k(this.f2036a.r());
                    if (this.f2036a.e()) {
                        return;
                    }
                    D2 = this.f2036a.D();
                } while (D2 == this.f2037b);
                this.f2039d = D2;
                return;
            } else if (b5 != 2) {
                throw e0.e();
            } else {
                d5 = this.f2036a.d() + this.f2036a.E();
                do {
                    c0Var.k(this.f2036a.r());
                } while (this.f2036a.d() < d5);
            }
        } else {
            int b6 = c2.b(this.f2037b);
            if (b6 == 0) {
                do {
                    list.add(Integer.valueOf(this.f2036a.r()));
                    if (this.f2036a.e()) {
                        return;
                    }
                    D = this.f2036a.D();
                } while (D == this.f2037b);
                this.f2039d = D;
                return;
            } else if (b6 != 2) {
                throw e0.e();
            } else {
                d5 = this.f2036a.d() + this.f2036a.E();
                do {
                    list.add(Integer.valueOf(this.f2036a.r()));
                } while (this.f2036a.d() < d5);
            }
        }
        X(d5);
    }

    public void W(List<String> list, boolean z4) {
        int D;
        int D2;
        if (c2.b(this.f2037b) != 2) {
            throw e0.e();
        }
        if (!(list instanceof l0) || z4) {
            do {
                list.add(z4 ? M() : p());
                if (this.f2036a.e()) {
                    return;
                }
                D = this.f2036a.D();
            } while (D == this.f2037b);
            this.f2039d = D;
            return;
        }
        l0 l0Var = (l0) list;
        do {
            l0Var.c(B());
            if (this.f2036a.e()) {
                return;
            }
            D2 = this.f2036a.D();
        } while (D2 == this.f2037b);
        this.f2039d = D2;
    }

    @Override // com.google.protobuf.m1
    public void a(List<Integer> list) {
        int D;
        int d5;
        int D2;
        if (list instanceof c0) {
            c0 c0Var = (c0) list;
            int b5 = c2.b(this.f2037b);
            if (b5 == 0) {
                do {
                    c0Var.k(this.f2036a.z());
                    if (this.f2036a.e()) {
                        return;
                    }
                    D2 = this.f2036a.D();
                } while (D2 == this.f2037b);
                this.f2039d = D2;
                return;
            } else if (b5 != 2) {
                throw e0.e();
            } else {
                d5 = this.f2036a.d() + this.f2036a.E();
                do {
                    c0Var.k(this.f2036a.z());
                } while (this.f2036a.d() < d5);
            }
        } else {
            int b6 = c2.b(this.f2037b);
            if (b6 == 0) {
                do {
                    list.add(Integer.valueOf(this.f2036a.z()));
                    if (this.f2036a.e()) {
                        return;
                    }
                    D = this.f2036a.D();
                } while (D == this.f2037b);
                this.f2039d = D;
                return;
            } else if (b6 != 2) {
                throw e0.e();
            } else {
                d5 = this.f2036a.d() + this.f2036a.E();
                do {
                    list.add(Integer.valueOf(this.f2036a.z()));
                } while (this.f2036a.d() < d5);
            }
        }
        X(d5);
    }

    @Override // com.google.protobuf.m1
    public int b() {
        Y(0);
        return this.f2036a.r();
    }

    @Override // com.google.protobuf.m1
    public int c() {
        return this.f2037b;
    }

    @Override // com.google.protobuf.m1
    public long d() {
        Y(0);
        return this.f2036a.F();
    }

    @Override // com.google.protobuf.m1
    public void e(List<Integer> list) {
        int D;
        int D2;
        if (!(list instanceof c0)) {
            int b5 = c2.b(this.f2037b);
            if (b5 == 2) {
                int E = this.f2036a.E();
                Z(E);
                int d5 = this.f2036a.d() + E;
                do {
                    list.add(Integer.valueOf(this.f2036a.s()));
                } while (this.f2036a.d() < d5);
                return;
            } else if (b5 != 5) {
                throw e0.e();
            } else {
                do {
                    list.add(Integer.valueOf(this.f2036a.s()));
                    if (this.f2036a.e()) {
                        return;
                    }
                    D = this.f2036a.D();
                } while (D == this.f2037b);
                this.f2039d = D;
                return;
            }
        }
        c0 c0Var = (c0) list;
        int b6 = c2.b(this.f2037b);
        if (b6 == 2) {
            int E2 = this.f2036a.E();
            Z(E2);
            int d6 = this.f2036a.d() + E2;
            do {
                c0Var.k(this.f2036a.s());
            } while (this.f2036a.d() < d6);
        } else if (b6 != 5) {
            throw e0.e();
        } else {
            do {
                c0Var.k(this.f2036a.s());
                if (this.f2036a.e()) {
                    return;
                }
                D2 = this.f2036a.D();
            } while (D2 == this.f2037b);
            this.f2039d = D2;
        }
    }

    @Override // com.google.protobuf.m1
    public long f() {
        Y(1);
        return this.f2036a.t();
    }

    @Override // com.google.protobuf.m1
    public void g(List<Integer> list) {
        int D;
        int D2;
        if (!(list instanceof c0)) {
            int b5 = c2.b(this.f2037b);
            if (b5 == 2) {
                int E = this.f2036a.E();
                Z(E);
                int d5 = this.f2036a.d() + E;
                do {
                    list.add(Integer.valueOf(this.f2036a.x()));
                } while (this.f2036a.d() < d5);
                return;
            } else if (b5 != 5) {
                throw e0.e();
            } else {
                do {
                    list.add(Integer.valueOf(this.f2036a.x()));
                    if (this.f2036a.e()) {
                        return;
                    }
                    D = this.f2036a.D();
                } while (D == this.f2037b);
                this.f2039d = D;
                return;
            }
        }
        c0 c0Var = (c0) list;
        int b6 = c2.b(this.f2037b);
        if (b6 == 2) {
            int E2 = this.f2036a.E();
            Z(E2);
            int d6 = this.f2036a.d() + E2;
            do {
                c0Var.k(this.f2036a.x());
            } while (this.f2036a.d() < d6);
        } else if (b6 != 5) {
            throw e0.e();
        } else {
            do {
                c0Var.k(this.f2036a.x());
                if (this.f2036a.e()) {
                    return;
                }
                D2 = this.f2036a.D();
            } while (D2 == this.f2037b);
            this.f2039d = D2;
        }
    }

    @Override // com.google.protobuf.m1
    public int h() {
        Y(0);
        return this.f2036a.z();
    }

    @Override // com.google.protobuf.m1
    public void i(List<Long> list) {
        int D;
        int d5;
        int D2;
        if (list instanceof n0) {
            n0 n0Var = (n0) list;
            int b5 = c2.b(this.f2037b);
            if (b5 == 0) {
                do {
                    n0Var.l(this.f2036a.A());
                    if (this.f2036a.e()) {
                        return;
                    }
                    D2 = this.f2036a.D();
                } while (D2 == this.f2037b);
                this.f2039d = D2;
                return;
            } else if (b5 != 2) {
                throw e0.e();
            } else {
                d5 = this.f2036a.d() + this.f2036a.E();
                do {
                    n0Var.l(this.f2036a.A());
                } while (this.f2036a.d() < d5);
            }
        } else {
            int b6 = c2.b(this.f2037b);
            if (b6 == 0) {
                do {
                    list.add(Long.valueOf(this.f2036a.A()));
                    if (this.f2036a.e()) {
                        return;
                    }
                    D = this.f2036a.D();
                } while (D == this.f2037b);
                this.f2039d = D;
                return;
            } else if (b6 != 2) {
                throw e0.e();
            } else {
                d5 = this.f2036a.d() + this.f2036a.E();
                do {
                    list.add(Long.valueOf(this.f2036a.A()));
                } while (this.f2036a.d() < d5);
            }
        }
        X(d5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.protobuf.m1
    @Deprecated
    public <T> void j(List<T> list, o1<T> o1Var, q qVar) {
        int D;
        if (c2.b(this.f2037b) != 3) {
            throw e0.e();
        }
        int i5 = this.f2037b;
        do {
            list.add(U(o1Var, qVar));
            if (this.f2036a.e() || this.f2039d != 0) {
                return;
            }
            D = this.f2036a.D();
        } while (D == i5);
        this.f2039d = D;
    }

    @Override // com.google.protobuf.m1
    public long k() {
        Y(0);
        return this.f2036a.A();
    }

    @Override // com.google.protobuf.m1
    public void l(List<Integer> list) {
        int D;
        int d5;
        int D2;
        if (list instanceof c0) {
            c0 c0Var = (c0) list;
            int b5 = c2.b(this.f2037b);
            if (b5 == 0) {
                do {
                    c0Var.k(this.f2036a.E());
                    if (this.f2036a.e()) {
                        return;
                    }
                    D2 = this.f2036a.D();
                } while (D2 == this.f2037b);
                this.f2039d = D2;
                return;
            } else if (b5 != 2) {
                throw e0.e();
            } else {
                d5 = this.f2036a.d() + this.f2036a.E();
                do {
                    c0Var.k(this.f2036a.E());
                } while (this.f2036a.d() < d5);
            }
        } else {
            int b6 = c2.b(this.f2037b);
            if (b6 == 0) {
                do {
                    list.add(Integer.valueOf(this.f2036a.E()));
                    if (this.f2036a.e()) {
                        return;
                    }
                    D = this.f2036a.D();
                } while (D == this.f2037b);
                this.f2039d = D;
                return;
            } else if (b6 != 2) {
                throw e0.e();
            } else {
                d5 = this.f2036a.d() + this.f2036a.E();
                do {
                    list.add(Integer.valueOf(this.f2036a.E()));
                } while (this.f2036a.d() < d5);
            }
        }
        X(d5);
    }

    @Override // com.google.protobuf.m1
    public <T> T m(Class<T> cls, q qVar) {
        Y(2);
        return (T) V(j1.a().c(cls), qVar);
    }

    @Override // com.google.protobuf.m1
    public void n(List<Boolean> list) {
        int D;
        int d5;
        int D2;
        if (list instanceof g) {
            g gVar = (g) list;
            int b5 = c2.b(this.f2037b);
            if (b5 == 0) {
                do {
                    gVar.l(this.f2036a.o());
                    if (this.f2036a.e()) {
                        return;
                    }
                    D2 = this.f2036a.D();
                } while (D2 == this.f2037b);
                this.f2039d = D2;
                return;
            } else if (b5 != 2) {
                throw e0.e();
            } else {
                d5 = this.f2036a.d() + this.f2036a.E();
                do {
                    gVar.l(this.f2036a.o());
                } while (this.f2036a.d() < d5);
            }
        } else {
            int b6 = c2.b(this.f2037b);
            if (b6 == 0) {
                do {
                    list.add(Boolean.valueOf(this.f2036a.o()));
                    if (this.f2036a.e()) {
                        return;
                    }
                    D = this.f2036a.D();
                } while (D == this.f2037b);
                this.f2039d = D;
                return;
            } else if (b6 != 2) {
                throw e0.e();
            } else {
                d5 = this.f2036a.d() + this.f2036a.E();
                do {
                    list.add(Boolean.valueOf(this.f2036a.o()));
                } while (this.f2036a.d() < d5);
            }
        }
        X(d5);
    }

    @Override // com.google.protobuf.m1
    public <T> void o(T t5, o1<T> o1Var, q qVar) {
        Y(3);
        R(t5, o1Var, qVar);
    }

    @Override // com.google.protobuf.m1
    public String p() {
        Y(2);
        return this.f2036a.B();
    }

    @Override // com.google.protobuf.m1
    public int q() {
        Y(5);
        return this.f2036a.s();
    }

    @Override // com.google.protobuf.m1
    @Deprecated
    public <T> T r(Class<T> cls, q qVar) {
        Y(3);
        return (T) U(j1.a().c(cls), qVar);
    }

    @Override // com.google.protobuf.m1
    public double readDouble() {
        Y(1);
        return this.f2036a.q();
    }

    @Override // com.google.protobuf.m1
    public float readFloat() {
        Y(5);
        return this.f2036a.u();
    }

    @Override // com.google.protobuf.m1
    public boolean s() {
        Y(0);
        return this.f2036a.o();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.protobuf.m1
    public <T> void t(List<T> list, o1<T> o1Var, q qVar) {
        int D;
        if (c2.b(this.f2037b) != 2) {
            throw e0.e();
        }
        int i5 = this.f2037b;
        do {
            list.add(V(o1Var, qVar));
            if (this.f2036a.e() || this.f2039d != 0) {
                return;
            }
            D = this.f2036a.D();
        } while (D == i5);
        this.f2039d = D;
    }

    @Override // com.google.protobuf.m1
    public int u() {
        int i5 = this.f2039d;
        if (i5 != 0) {
            this.f2037b = i5;
            this.f2039d = 0;
        } else {
            this.f2037b = this.f2036a.D();
        }
        int i6 = this.f2037b;
        return (i6 == 0 || i6 == this.f2038c) ? a.e.API_PRIORITY_OTHER : c2.a(i6);
    }

    @Override // com.google.protobuf.m1
    public void v(List<String> list) {
        W(list, false);
    }

    @Override // com.google.protobuf.m1
    public long w() {
        Y(1);
        return this.f2036a.y();
    }

    @Override // com.google.protobuf.m1
    public <T> void x(T t5, o1<T> o1Var, q qVar) {
        Y(2);
        S(t5, o1Var, qVar);
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x005c, code lost:
        r8.put(r2, r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0064, code lost:
        return;
     */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.protobuf.m1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public <K, V> void y(java.util.Map<K, V> r8, com.google.protobuf.p0.a<K, V> r9, com.google.protobuf.q r10) {
        /*
            r7 = this;
            r0 = 2
            r7.Y(r0)
            com.google.protobuf.j r1 = r7.f2036a
            int r1 = r1.E()
            com.google.protobuf.j r2 = r7.f2036a
            int r1 = r2.n(r1)
            K r2 = r9.f2095b
            V r3 = r9.f2097d
        L14:
            int r4 = r7.u()     // Catch: java.lang.Throwable -> L65
            r5 = 2147483647(0x7fffffff, float:NaN)
            if (r4 == r5) goto L5c
            com.google.protobuf.j r5 = r7.f2036a     // Catch: java.lang.Throwable -> L65
            boolean r5 = r5.e()     // Catch: java.lang.Throwable -> L65
            if (r5 == 0) goto L26
            goto L5c
        L26:
            r5 = 1
            java.lang.String r6 = "Unable to parse map entry."
            if (r4 == r5) goto L47
            if (r4 == r0) goto L3a
            boolean r4 = r7.F()     // Catch: com.google.protobuf.e0.a -> L4f java.lang.Throwable -> L65
            if (r4 == 0) goto L34
            goto L14
        L34:
            com.google.protobuf.e0 r4 = new com.google.protobuf.e0     // Catch: com.google.protobuf.e0.a -> L4f java.lang.Throwable -> L65
            r4.<init>(r6)     // Catch: com.google.protobuf.e0.a -> L4f java.lang.Throwable -> L65
            throw r4     // Catch: com.google.protobuf.e0.a -> L4f java.lang.Throwable -> L65
        L3a:
            com.google.protobuf.c2$b r4 = r9.f2096c     // Catch: com.google.protobuf.e0.a -> L4f java.lang.Throwable -> L65
            V r5 = r9.f2097d     // Catch: com.google.protobuf.e0.a -> L4f java.lang.Throwable -> L65
            java.lang.Class r5 = r5.getClass()     // Catch: com.google.protobuf.e0.a -> L4f java.lang.Throwable -> L65
            java.lang.Object r3 = r7.T(r4, r5, r10)     // Catch: com.google.protobuf.e0.a -> L4f java.lang.Throwable -> L65
            goto L14
        L47:
            com.google.protobuf.c2$b r4 = r9.f2094a     // Catch: com.google.protobuf.e0.a -> L4f java.lang.Throwable -> L65
            r5 = 0
            java.lang.Object r2 = r7.T(r4, r5, r5)     // Catch: com.google.protobuf.e0.a -> L4f java.lang.Throwable -> L65
            goto L14
        L4f:
            boolean r4 = r7.F()     // Catch: java.lang.Throwable -> L65
            if (r4 == 0) goto L56
            goto L14
        L56:
            com.google.protobuf.e0 r8 = new com.google.protobuf.e0     // Catch: java.lang.Throwable -> L65
            r8.<init>(r6)     // Catch: java.lang.Throwable -> L65
            throw r8     // Catch: java.lang.Throwable -> L65
        L5c:
            r8.put(r2, r3)     // Catch: java.lang.Throwable -> L65
            com.google.protobuf.j r8 = r7.f2036a
            r8.m(r1)
            return
        L65:
            r8 = move-exception
            com.google.protobuf.j r9 = r7.f2036a
            r9.m(r1)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.k.y(java.util.Map, com.google.protobuf.p0$a, com.google.protobuf.q):void");
    }

    @Override // com.google.protobuf.m1
    public void z(List<Long> list) {
        int D;
        int d5;
        int D2;
        if (list instanceof n0) {
            n0 n0Var = (n0) list;
            int b5 = c2.b(this.f2037b);
            if (b5 == 0) {
                do {
                    n0Var.l(this.f2036a.F());
                    if (this.f2036a.e()) {
                        return;
                    }
                    D2 = this.f2036a.D();
                } while (D2 == this.f2037b);
                this.f2039d = D2;
                return;
            } else if (b5 != 2) {
                throw e0.e();
            } else {
                d5 = this.f2036a.d() + this.f2036a.E();
                do {
                    n0Var.l(this.f2036a.F());
                } while (this.f2036a.d() < d5);
            }
        } else {
            int b6 = c2.b(this.f2037b);
            if (b6 == 0) {
                do {
                    list.add(Long.valueOf(this.f2036a.F()));
                    if (this.f2036a.e()) {
                        return;
                    }
                    D = this.f2036a.D();
                } while (D == this.f2037b);
                this.f2039d = D;
                return;
            } else if (b6 != 2) {
                throw e0.e();
            } else {
                d5 = this.f2036a.d() + this.f2036a.E();
                do {
                    list.add(Long.valueOf(this.f2036a.F()));
                } while (this.f2036a.d() < d5);
            }
        }
        X(d5);
    }
}
