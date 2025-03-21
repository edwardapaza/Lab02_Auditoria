package w1;

import i2.b;
import i2.d0;
import java.util.Collections;
import java.util.List;
import v1.z;
/* loaded from: classes.dex */
public abstract class a implements p {

    /* renamed from: a  reason: collision with root package name */
    private final List<d0> f8229a;

    /* renamed from: w1.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0124a extends a {
        public C0124a(List<d0> list) {
            super(list);
        }

        @Override // w1.a
        protected d0 d(d0 d0Var) {
            b.C0063b e5 = a.e(d0Var);
            for (d0 d0Var2 : f()) {
                int i5 = 0;
                while (i5 < e5.H()) {
                    if (z.q(e5.G(i5), d0Var2)) {
                        e5.I(i5);
                    } else {
                        i5++;
                    }
                }
            }
            return d0.B0().F(e5).build();
        }
    }

    /* loaded from: classes.dex */
    public static class b extends a {
        public b(List<d0> list) {
            super(list);
        }

        @Override // w1.a
        protected d0 d(d0 d0Var) {
            b.C0063b e5 = a.e(d0Var);
            for (d0 d0Var2 : f()) {
                if (!z.p(e5, d0Var2)) {
                    e5.F(d0Var2);
                }
            }
            return d0.B0().F(e5).build();
        }
    }

    a(List<d0> list) {
        this.f8229a = Collections.unmodifiableList(list);
    }

    static b.C0063b e(d0 d0Var) {
        return z.t(d0Var) ? d0Var.p0().c() : i2.b.n0();
    }

    @Override // w1.p
    public d0 a(d0 d0Var, d0 d0Var2) {
        return d(d0Var);
    }

    @Override // w1.p
    public d0 b(d0 d0Var, f1.q qVar) {
        return d(d0Var);
    }

    @Override // w1.p
    public d0 c(d0 d0Var) {
        return null;
    }

    protected abstract d0 d(d0 d0Var);

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.f8229a.equals(((a) obj).f8229a);
    }

    public List<d0> f() {
        return this.f8229a;
    }

    public int hashCode() {
        return (getClass().hashCode() * 31) + this.f8229a.hashCode();
    }
}
