package io.grpc.internal;

import com.google.android.gms.common.api.a;
import i3.b;
import io.grpc.internal.p1;
import io.grpc.internal.v;
import java.net.SocketAddress;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
final class n implements v {

    /* renamed from: a  reason: collision with root package name */
    private final v f5012a;

    /* renamed from: b  reason: collision with root package name */
    private final i3.b f5013b;

    /* renamed from: c  reason: collision with root package name */
    private final Executor f5014c;

    /* loaded from: classes.dex */
    private class a extends m0 {

        /* renamed from: a  reason: collision with root package name */
        private final x f5015a;

        /* renamed from: b  reason: collision with root package name */
        private final String f5016b;

        /* renamed from: d  reason: collision with root package name */
        private volatile i3.j1 f5018d;

        /* renamed from: e  reason: collision with root package name */
        private i3.j1 f5019e;

        /* renamed from: f  reason: collision with root package name */
        private i3.j1 f5020f;

        /* renamed from: c  reason: collision with root package name */
        private final AtomicInteger f5017c = new AtomicInteger(-2147483647);

        /* renamed from: g  reason: collision with root package name */
        private final p1.a f5021g = new C0078a();

        /* renamed from: io.grpc.internal.n$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class C0078a implements p1.a {
            C0078a() {
            }

            @Override // io.grpc.internal.p1.a
            public void a() {
                if (a.this.f5017c.decrementAndGet() == 0) {
                    a.this.j();
                }
            }
        }

        /* loaded from: classes.dex */
        class b extends b.AbstractC0068b {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ i3.z0 f5024a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ i3.c f5025b;

            b(i3.z0 z0Var, i3.c cVar) {
                this.f5024a = z0Var;
                this.f5025b = cVar;
            }
        }

        a(x xVar, String str) {
            this.f5015a = (x) z0.k.o(xVar, "delegate");
            this.f5016b = (String) z0.k.o(str, "authority");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void j() {
            synchronized (this) {
                if (this.f5017c.get() != 0) {
                    return;
                }
                i3.j1 j1Var = this.f5019e;
                i3.j1 j1Var2 = this.f5020f;
                this.f5019e = null;
                this.f5020f = null;
                if (j1Var != null) {
                    super.f(j1Var);
                }
                if (j1Var2 != null) {
                    super.h(j1Var2);
                }
            }
        }

        @Override // io.grpc.internal.m0
        protected x a() {
            return this.f5015a;
        }

        @Override // io.grpc.internal.m0, io.grpc.internal.u
        public s c(i3.z0<?, ?> z0Var, i3.y0 y0Var, i3.c cVar, i3.k[] kVarArr) {
            i3.b c5 = cVar.c();
            if (c5 == null) {
                c5 = n.this.f5013b;
            } else if (n.this.f5013b != null) {
                c5 = new i3.m(n.this.f5013b, c5);
            }
            if (c5 == null) {
                return this.f5017c.get() >= 0 ? new h0(this.f5018d, kVarArr) : this.f5015a.c(z0Var, y0Var, cVar, kVarArr);
            }
            p1 p1Var = new p1(this.f5015a, z0Var, y0Var, cVar, this.f5021g, kVarArr);
            if (this.f5017c.incrementAndGet() > 0) {
                this.f5021g.a();
                return new h0(this.f5018d, kVarArr);
            }
            try {
                c5.a(new b(z0Var, cVar), ((c5 instanceof i3.l0) && ((i3.l0) c5).a() && cVar.e() != null) ? cVar.e() : n.this.f5014c, p1Var);
            } catch (Throwable th) {
                p1Var.b(i3.j1.f3440n.q("Credentials should use fail() instead of throwing exceptions").p(th));
            }
            return p1Var.d();
        }

        @Override // io.grpc.internal.m0, io.grpc.internal.m1
        public void f(i3.j1 j1Var) {
            z0.k.o(j1Var, "status");
            synchronized (this) {
                if (this.f5017c.get() < 0) {
                    this.f5018d = j1Var;
                    this.f5017c.addAndGet(a.e.API_PRIORITY_OTHER);
                    if (this.f5017c.get() != 0) {
                        this.f5019e = j1Var;
                    } else {
                        super.f(j1Var);
                    }
                }
            }
        }

        @Override // io.grpc.internal.m0, io.grpc.internal.m1
        public void h(i3.j1 j1Var) {
            z0.k.o(j1Var, "status");
            synchronized (this) {
                if (this.f5017c.get() < 0) {
                    this.f5018d = j1Var;
                    this.f5017c.addAndGet(a.e.API_PRIORITY_OTHER);
                } else if (this.f5020f != null) {
                    return;
                }
                if (this.f5017c.get() != 0) {
                    this.f5020f = j1Var;
                } else {
                    super.h(j1Var);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(v vVar, i3.b bVar, Executor executor) {
        this.f5012a = (v) z0.k.o(vVar, "delegate");
        this.f5013b = bVar;
        this.f5014c = (Executor) z0.k.o(executor, "appExecutor");
    }

    @Override // io.grpc.internal.v
    public ScheduledExecutorService R() {
        return this.f5012a.R();
    }

    @Override // io.grpc.internal.v, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f5012a.close();
    }

    @Override // io.grpc.internal.v
    public x y(SocketAddress socketAddress, v.a aVar, i3.f fVar) {
        return new a(this.f5012a.y(socketAddress, aVar, fVar), aVar.a());
    }
}
