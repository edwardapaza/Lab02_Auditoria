package k3;

import i3.j1;
import i3.y0;
import i3.z0;
import io.grpc.internal.a;
import io.grpc.internal.n2;
import io.grpc.internal.t;
import io.grpc.internal.t2;
import io.grpc.internal.u2;
import io.grpc.internal.w0;
import java.util.List;
import k3.q;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h extends io.grpc.internal.a {

    /* renamed from: p  reason: collision with root package name */
    private static final w4.c f5732p = new w4.c();

    /* renamed from: h  reason: collision with root package name */
    private final z0<?, ?> f5733h;

    /* renamed from: i  reason: collision with root package name */
    private final String f5734i;

    /* renamed from: j  reason: collision with root package name */
    private final n2 f5735j;

    /* renamed from: k  reason: collision with root package name */
    private String f5736k;

    /* renamed from: l  reason: collision with root package name */
    private final b f5737l;

    /* renamed from: m  reason: collision with root package name */
    private final a f5738m;

    /* renamed from: n  reason: collision with root package name */
    private final i3.a f5739n;

    /* renamed from: o  reason: collision with root package name */
    private boolean f5740o;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements a.b {
        a() {
        }

        @Override // io.grpc.internal.a.b
        public void a(j1 j1Var) {
            r3.e h5 = r3.c.h("OkHttpClientStream$Sink.cancel");
            try {
                synchronized (h.this.f5737l.f5743z) {
                    h.this.f5737l.a0(j1Var, true, null);
                }
                if (h5 != null) {
                    h5.close();
                }
            } catch (Throwable th) {
                if (h5 != null) {
                    try {
                        h5.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        }

        @Override // io.grpc.internal.a.b
        public void b(u2 u2Var, boolean z4, boolean z5, int i5) {
            w4.c d5;
            r3.e h5 = r3.c.h("OkHttpClientStream$Sink.writeFrame");
            try {
                if (u2Var == null) {
                    d5 = h.f5732p;
                } else {
                    d5 = ((o) u2Var).d();
                    int size = (int) d5.size();
                    if (size > 0) {
                        h.this.s(size);
                    }
                }
                synchronized (h.this.f5737l.f5743z) {
                    h.this.f5737l.e0(d5, z4, z5);
                    h.this.w().e(i5);
                }
                if (h5 != null) {
                    h5.close();
                }
            } catch (Throwable th) {
                if (h5 != null) {
                    try {
                        h5.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        }

        @Override // io.grpc.internal.a.b
        public void c(y0 y0Var, byte[] bArr) {
            r3.e h5 = r3.c.h("OkHttpClientStream$Sink.writeHeaders");
            try {
                String str = "/" + h.this.f5733h.c();
                if (bArr != null) {
                    h.this.f5740o = true;
                    str = str + "?" + b1.a.a().e(bArr);
                }
                synchronized (h.this.f5737l.f5743z) {
                    h.this.f5737l.g0(y0Var, str);
                }
                if (h5 != null) {
                    h5.close();
                }
            } catch (Throwable th) {
                if (h5 != null) {
                    try {
                        h5.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b extends w0 implements q.b {
        private List<m3.d> A;
        private w4.c B;
        private boolean C;
        private boolean D;
        private boolean E;
        private int F;
        private int G;
        private final k3.b H;
        private final q I;
        private final i J;
        private boolean K;
        private final r3.d L;
        private q.c M;
        private int N;

        /* renamed from: y  reason: collision with root package name */
        private final int f5742y;

        /* renamed from: z  reason: collision with root package name */
        private final Object f5743z;

        public b(int i5, n2 n2Var, Object obj, k3.b bVar, q qVar, i iVar, int i6, String str) {
            super(i5, n2Var, h.this.w());
            this.B = new w4.c();
            this.C = false;
            this.D = false;
            this.E = false;
            this.K = true;
            this.N = -1;
            this.f5743z = z0.k.o(obj, "lock");
            this.H = bVar;
            this.I = qVar;
            this.J = iVar;
            this.F = i6;
            this.G = i6;
            this.f5742y = i6;
            this.L = r3.c.b(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a0(j1 j1Var, boolean z4, y0 y0Var) {
            if (this.E) {
                return;
            }
            this.E = true;
            if (!this.K) {
                this.J.U(c0(), j1Var, t.a.PROCESSED, z4, m3.a.CANCEL, y0Var);
                return;
            }
            this.J.h0(h.this);
            this.A = null;
            this.B.d();
            this.K = false;
            if (y0Var == null) {
                y0Var = new y0();
            }
            N(j1Var, true, y0Var);
        }

        private void d0() {
            if (G()) {
                this.J.U(c0(), null, t.a.PROCESSED, false, null, null);
            } else {
                this.J.U(c0(), null, t.a.PROCESSED, false, m3.a.CANCEL, null);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void e0(w4.c cVar, boolean z4, boolean z5) {
            if (this.E) {
                return;
            }
            if (!this.K) {
                z0.k.u(c0() != -1, "streamId should be set");
                this.I.d(z4, this.M, cVar, z5);
                return;
            }
            this.B.Z(cVar, (int) cVar.size());
            this.C |= z4;
            this.D |= z5;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void g0(y0 y0Var, String str) {
            this.A = d.b(y0Var, str, h.this.f5736k, h.this.f5734i, h.this.f5740o, this.J.b0());
            this.J.o0(h.this);
        }

        @Override // io.grpc.internal.w0
        protected void P(j1 j1Var, boolean z4, y0 y0Var) {
            a0(j1Var, z4, y0Var);
        }

        @Override // io.grpc.internal.n1.b
        public void b(Throwable th) {
            P(j1.k(th), true, new y0());
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public q.c b0() {
            q.c cVar;
            synchronized (this.f5743z) {
                cVar = this.M;
            }
            return cVar;
        }

        @Override // io.grpc.internal.g.d
        public void c(Runnable runnable) {
            synchronized (this.f5743z) {
                runnable.run();
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public int c0() {
            return this.N;
        }

        @Override // io.grpc.internal.w0, io.grpc.internal.a.c, io.grpc.internal.n1.b
        public void e(boolean z4) {
            d0();
            super.e(z4);
        }

        @Override // io.grpc.internal.n1.b
        public void f(int i5) {
            int i6 = this.G - i5;
            this.G = i6;
            int i7 = this.f5742y;
            if (i6 <= i7 * 0.5f) {
                int i8 = i7 - i6;
                this.F += i8;
                this.G = i6 + i8;
                this.H.f(c0(), i8);
            }
        }

        public void f0(int i5) {
            z0.k.v(this.N == -1, "the stream has been started with id %s", i5);
            this.N = i5;
            this.M = this.I.c(this, i5);
            h.this.f5737l.r();
            if (this.K) {
                this.H.W(h.this.f5740o, false, this.N, 0, this.A);
                h.this.f5735j.c();
                this.A = null;
                if (this.B.size() > 0) {
                    this.I.d(this.C, this.M, this.B, this.D);
                }
                this.K = false;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public r3.d h0() {
            return this.L;
        }

        public void i0(w4.c cVar, boolean z4) {
            int size = this.F - ((int) cVar.size());
            this.F = size;
            if (size >= 0) {
                super.S(new l(cVar), z4);
                return;
            }
            this.H.a(c0(), m3.a.FLOW_CONTROL_ERROR);
            this.J.U(c0(), j1.f3446t.q("Received data size exceeded our receiving window size"), t.a.PROCESSED, false, null, null);
        }

        public void j0(List<m3.d> list, boolean z4) {
            if (z4) {
                U(r.c(list));
            } else {
                T(r.a(list));
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // io.grpc.internal.d.a
        public void r() {
            super.r();
            m().c();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(z0<?, ?> z0Var, y0 y0Var, k3.b bVar, i iVar, q qVar, Object obj, int i5, int i6, String str, String str2, n2 n2Var, t2 t2Var, i3.c cVar, boolean z4) {
        super(new p(), n2Var, t2Var, y0Var, cVar, z4 && z0Var.f());
        this.f5738m = new a();
        this.f5740o = false;
        this.f5735j = (n2) z0.k.o(n2Var, "statsTraceCtx");
        this.f5733h = z0Var;
        this.f5736k = str;
        this.f5734i = str2;
        this.f5739n = iVar.V();
        this.f5737l = new b(i5, n2Var, obj, bVar, qVar, iVar, i6, z0Var.c());
    }

    public z0.d L() {
        return this.f5733h.e();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.grpc.internal.a
    /* renamed from: M */
    public b y() {
        return this.f5737l;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean N() {
        return this.f5740o;
    }

    @Override // io.grpc.internal.s
    public i3.a getAttributes() {
        return this.f5739n;
    }

    @Override // io.grpc.internal.s
    public void k(String str) {
        this.f5736k = (String) z0.k.o(str, "authority");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.grpc.internal.a
    /* renamed from: z */
    public a u() {
        return this.f5738m;
    }
}
