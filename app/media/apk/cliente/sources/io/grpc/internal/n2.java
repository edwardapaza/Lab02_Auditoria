package io.grpc.internal;

import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
public final class n2 {

    /* renamed from: c  reason: collision with root package name */
    public static final n2 f5056c = new n2(new i3.m1[0]);

    /* renamed from: a  reason: collision with root package name */
    private final i3.m1[] f5057a;

    /* renamed from: b  reason: collision with root package name */
    private final AtomicBoolean f5058b = new AtomicBoolean(false);

    n2(i3.m1[] m1VarArr) {
        this.f5057a = m1VarArr;
    }

    public static n2 h(i3.k[] kVarArr, i3.a aVar, i3.y0 y0Var) {
        n2 n2Var = new n2(kVarArr);
        for (i3.k kVar : kVarArr) {
            kVar.n(aVar, y0Var);
        }
        return n2Var;
    }

    public void a() {
        for (i3.m1 m1Var : this.f5057a) {
            ((i3.k) m1Var).k();
        }
    }

    public void b(i3.y0 y0Var) {
        for (i3.m1 m1Var : this.f5057a) {
            ((i3.k) m1Var).l(y0Var);
        }
    }

    public void c() {
        for (i3.m1 m1Var : this.f5057a) {
            ((i3.k) m1Var).m();
        }
    }

    public void d(int i5) {
        for (i3.m1 m1Var : this.f5057a) {
            m1Var.a(i5);
        }
    }

    public void e(int i5, long j5, long j6) {
        for (i3.m1 m1Var : this.f5057a) {
            m1Var.b(i5, j5, j6);
        }
    }

    public void f(long j5) {
        for (i3.m1 m1Var : this.f5057a) {
            m1Var.c(j5);
        }
    }

    public void g(long j5) {
        for (i3.m1 m1Var : this.f5057a) {
            m1Var.d(j5);
        }
    }

    public void i(int i5) {
        for (i3.m1 m1Var : this.f5057a) {
            m1Var.e(i5);
        }
    }

    public void j(int i5, long j5, long j6) {
        for (i3.m1 m1Var : this.f5057a) {
            m1Var.f(i5, j5, j6);
        }
    }

    public void k(long j5) {
        for (i3.m1 m1Var : this.f5057a) {
            m1Var.g(j5);
        }
    }

    public void l(long j5) {
        for (i3.m1 m1Var : this.f5057a) {
            m1Var.h(j5);
        }
    }

    public void m(i3.j1 j1Var) {
        if (this.f5058b.compareAndSet(false, true)) {
            for (i3.m1 m1Var : this.f5057a) {
                m1Var.i(j1Var);
            }
        }
    }
}
