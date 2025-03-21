package io.grpc.internal;

import i3.l;
import io.grpc.internal.f;
import io.grpc.internal.n1;
import io.grpc.internal.p2;
import java.io.InputStream;
/* loaded from: classes.dex */
public abstract class d implements o2 {

    /* loaded from: classes.dex */
    public static abstract class a implements f.h, n1.b {

        /* renamed from: a  reason: collision with root package name */
        private a0 f4611a;

        /* renamed from: b  reason: collision with root package name */
        private final Object f4612b = new Object();

        /* renamed from: c  reason: collision with root package name */
        private final n2 f4613c;

        /* renamed from: d  reason: collision with root package name */
        private final t2 f4614d;

        /* renamed from: e  reason: collision with root package name */
        private final n1 f4615e;

        /* renamed from: f  reason: collision with root package name */
        private int f4616f;

        /* renamed from: g  reason: collision with root package name */
        private boolean f4617g;

        /* renamed from: h  reason: collision with root package name */
        private boolean f4618h;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: io.grpc.internal.d$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class RunnableC0076a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ r3.b f4619a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ int f4620b;

            RunnableC0076a(r3.b bVar, int i5) {
                this.f4619a = bVar;
                this.f4620b = i5;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    r3.e h5 = r3.c.h("AbstractStream.request");
                    r3.c.e(this.f4619a);
                    a.this.f4611a.c(this.f4620b);
                    if (h5 != null) {
                        h5.close();
                    }
                } catch (Throwable th) {
                    a.this.b(th);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public a(int i5, n2 n2Var, t2 t2Var) {
            this.f4613c = (n2) z0.k.o(n2Var, "statsTraceCtx");
            this.f4614d = (t2) z0.k.o(t2Var, "transportTracer");
            n1 n1Var = new n1(this, l.b.f3486a, i5, n2Var, t2Var);
            this.f4615e = n1Var;
            this.f4611a = n1Var;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean n() {
            boolean z4;
            synchronized (this.f4612b) {
                z4 = this.f4617g && this.f4616f < 32768 && !this.f4618h;
            }
            return z4;
        }

        private void p() {
            boolean n5;
            synchronized (this.f4612b) {
                n5 = n();
            }
            if (n5) {
                o().b();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void q(int i5) {
            synchronized (this.f4612b) {
                this.f4616f += i5;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void u(int i5) {
            c(new RunnableC0076a(r3.c.f(), i5));
        }

        @Override // io.grpc.internal.n1.b
        public void a(p2.a aVar) {
            o().a(aVar);
        }

        public final void d(int i5) {
            boolean z4;
            synchronized (this.f4612b) {
                z0.k.u(this.f4617g, "onStreamAllocated was not called, but it seems the stream is active");
                int i6 = this.f4616f;
                z4 = true;
                boolean z5 = i6 < 32768;
                int i7 = i6 - i5;
                this.f4616f = i7;
                boolean z6 = i7 < 32768;
                if (z5 || !z6) {
                    z4 = false;
                }
            }
            if (z4) {
                p();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public final void k(boolean z4) {
            if (z4) {
                this.f4611a.close();
            } else {
                this.f4611a.h();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public final void l(x1 x1Var) {
            try {
                this.f4611a.i(x1Var);
            } catch (Throwable th) {
                b(th);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public t2 m() {
            return this.f4614d;
        }

        protected abstract p2 o();

        /* JADX INFO: Access modifiers changed from: protected */
        public void r() {
            z0.k.t(o() != null);
            synchronized (this.f4612b) {
                z0.k.u(this.f4617g ? false : true, "Already allocated");
                this.f4617g = true;
            }
            p();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public final void s() {
            synchronized (this.f4612b) {
                this.f4618h = true;
            }
        }

        final void t() {
            this.f4615e.z(this);
            this.f4611a = this.f4615e;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public final void v(i3.u uVar) {
            this.f4611a.g(uVar);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public void w(u0 u0Var) {
            this.f4615e.x(u0Var);
            this.f4611a = new f(this, this, this.f4615e);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public final void x(int i5) {
            this.f4611a.d(i5);
        }
    }

    @Override // io.grpc.internal.o2
    public final void b(i3.n nVar) {
        r().b((i3.n) z0.k.o(nVar, "compressor"));
    }

    @Override // io.grpc.internal.o2
    public final void c(int i5) {
        t().u(i5);
    }

    @Override // io.grpc.internal.o2
    public final void flush() {
        if (r().isClosed()) {
            return;
        }
        r().flush();
    }

    @Override // io.grpc.internal.o2
    public boolean i() {
        return t().n();
    }

    @Override // io.grpc.internal.o2
    public final void j(InputStream inputStream) {
        z0.k.o(inputStream, "message");
        try {
            if (!r().isClosed()) {
                r().c(inputStream);
            }
        } finally {
            t0.e(inputStream);
        }
    }

    @Override // io.grpc.internal.o2
    public void m() {
        t().t();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void q() {
        r().close();
    }

    protected abstract r0 r();

    /* JADX INFO: Access modifiers changed from: protected */
    public final void s(int i5) {
        t().q(i5);
    }

    protected abstract a t();
}
