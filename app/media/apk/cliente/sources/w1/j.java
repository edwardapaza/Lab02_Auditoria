package w1;

import i2.d0;
import v1.z;
/* loaded from: classes.dex */
public class j implements p {

    /* renamed from: a  reason: collision with root package name */
    private d0 f8250a;

    public j(d0 d0Var) {
        z1.b.d(z.A(d0Var), "NumericIncrementTransformOperation expects a NumberValue operand", new Object[0]);
        this.f8250a = d0Var;
    }

    private double e() {
        if (z.u(this.f8250a)) {
            return this.f8250a.t0();
        }
        if (z.v(this.f8250a)) {
            return this.f8250a.v0();
        }
        throw z1.b.a("Expected 'operand' to be of Number type, but was " + this.f8250a.getClass().getCanonicalName(), new Object[0]);
    }

    private long f() {
        if (z.u(this.f8250a)) {
            return (long) this.f8250a.t0();
        }
        if (z.v(this.f8250a)) {
            return this.f8250a.v0();
        }
        throw z1.b.a("Expected 'operand' to be of Number type, but was " + this.f8250a.getClass().getCanonicalName(), new Object[0]);
    }

    private long g(long j5, long j6) {
        long j7 = j5 + j6;
        return ((j5 ^ j7) & (j6 ^ j7)) >= 0 ? j7 : j7 >= 0 ? Long.MIN_VALUE : Long.MAX_VALUE;
    }

    @Override // w1.p
    public d0 a(d0 d0Var, d0 d0Var2) {
        return d0Var2;
    }

    @Override // w1.p
    public d0 b(d0 d0Var, f1.q qVar) {
        double t02;
        d0.b J;
        d0 c5 = c(d0Var);
        if (z.v(c5) && z.v(this.f8250a)) {
            J = d0.B0().L(g(c5.v0(), f()));
        } else {
            if (z.v(c5)) {
                t02 = c5.v0();
            } else {
                z1.b.d(z.u(c5), "Expected NumberValue to be of type DoubleValue, but was ", d0Var.getClass().getCanonicalName());
                t02 = c5.t0();
            }
            J = d0.B0().J(t02 + e());
        }
        return J.build();
    }

    @Override // w1.p
    public d0 c(d0 d0Var) {
        return z.A(d0Var) ? d0Var : d0.B0().L(0L).build();
    }

    public d0 d() {
        return this.f8250a;
    }
}
