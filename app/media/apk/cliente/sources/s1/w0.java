package s1;

import s1.j;
import u1.g4;
import u1.o0;
import y1.s0;
/* loaded from: classes.dex */
public class w0 extends j {

    /* loaded from: classes.dex */
    private class b implements s0.c {
        private b() {
        }

        @Override // y1.s0.c
        public void a(y0 y0Var) {
            w0.this.p().a(y0Var);
        }

        @Override // y1.s0.c
        public m1.e<v1.l> b(int i5) {
            return w0.this.p().b(i5);
        }

        @Override // y1.s0.c
        public void c(int i5, i3.j1 j1Var) {
            w0.this.p().c(i5, j1Var);
        }

        @Override // y1.s0.c
        public void d(int i5, i3.j1 j1Var) {
            w0.this.p().d(i5, j1Var);
        }

        @Override // y1.s0.c
        public void e(y1.n0 n0Var) {
            w0.this.p().e(n0Var);
        }

        @Override // y1.s0.c
        public void f(w1.h hVar) {
            w0.this.p().f(hVar);
        }
    }

    private boolean s(com.google.firebase.firestore.a0 a0Var) {
        if (a0Var.a() == null || !(a0Var.a() instanceof com.google.firebase.firestore.l0)) {
            return false;
        }
        return ((com.google.firebase.firestore.l0) a0Var.a()).a() instanceof com.google.firebase.firestore.o0;
    }

    @Override // s1.j
    protected o b(j.a aVar) {
        return new o(p());
    }

    @Override // s1.j
    protected g4 c(j.a aVar) {
        return null;
    }

    @Override // s1.j
    protected u1.k d(j.a aVar) {
        return null;
    }

    @Override // s1.j
    protected u1.i0 e(j.a aVar) {
        return new u1.i0(n(), new u1.g1(), aVar.e());
    }

    @Override // s1.j
    protected u1.e1 f(j.a aVar) {
        if (s(aVar.g())) {
            return u1.y0.o(o0.b.a(aVar.g().b()), new u1.o(new y1.o0(aVar.c().a())));
        }
        return u1.y0.n();
    }

    @Override // s1.j
    protected y1.s0 g(j.a aVar) {
        return new y1.s0(new b(), m(), aVar.d(), aVar.a(), i());
    }

    @Override // s1.j
    protected e1 h(j.a aVar) {
        return new e1(m(), o(), aVar.e(), aVar.f());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // s1.j
    /* renamed from: r */
    public y1.k a(j.a aVar) {
        return new y1.k(aVar.b());
    }
}
