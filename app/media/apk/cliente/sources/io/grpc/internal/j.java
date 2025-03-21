package io.grpc.internal;

import i3.a1;
import i3.f;
import i3.r0;
import io.grpc.internal.j2;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public final class j {

    /* renamed from: a  reason: collision with root package name */
    private final i3.t0 f4928a;

    /* renamed from: b  reason: collision with root package name */
    private final String f4929b;

    /* loaded from: classes.dex */
    public final class b {

        /* renamed from: a  reason: collision with root package name */
        private final r0.d f4930a;

        /* renamed from: b  reason: collision with root package name */
        private i3.r0 f4931b;

        /* renamed from: c  reason: collision with root package name */
        private i3.s0 f4932c;

        b(r0.d dVar) {
            this.f4930a = dVar;
            i3.s0 d5 = j.this.f4928a.d(j.this.f4929b);
            this.f4932c = d5;
            if (d5 != null) {
                this.f4931b = d5.a(dVar);
                return;
            }
            throw new IllegalStateException("Could not find policy '" + j.this.f4929b + "'. Make sure its implementation is either registered to LoadBalancerRegistry or included in META-INF/services/io.grpc.LoadBalancerProvider from your jar files.");
        }

        public i3.r0 a() {
            return this.f4931b;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void b(i3.j1 j1Var) {
            a().c(j1Var);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void c() {
            a().e();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void d() {
            this.f4931b.f();
            this.f4931b = null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean e(r0.g gVar) {
            j2.b bVar = (j2.b) gVar.c();
            if (bVar == null) {
                try {
                    j jVar = j.this;
                    bVar = new j2.b(jVar.d(jVar.f4929b, "using default policy"), null);
                } catch (f e5) {
                    this.f4930a.f(i3.p.TRANSIENT_FAILURE, new d(i3.j1.f3446t.q(e5.getMessage())));
                    this.f4931b.f();
                    this.f4932c = null;
                    this.f4931b = new e();
                    return true;
                }
            }
            if (this.f4932c == null || !bVar.f4964a.b().equals(this.f4932c.b())) {
                this.f4930a.f(i3.p.CONNECTING, new c());
                this.f4931b.f();
                i3.s0 s0Var = bVar.f4964a;
                this.f4932c = s0Var;
                i3.r0 r0Var = this.f4931b;
                this.f4931b = s0Var.a(this.f4930a);
                this.f4930a.b().b(f.a.INFO, "Load balancer changed from {0} to {1}", r0Var.getClass().getSimpleName(), this.f4931b.getClass().getSimpleName());
            }
            Object obj = bVar.f4965b;
            if (obj != null) {
                this.f4930a.b().b(f.a.DEBUG, "Load-balancing config: {0}", bVar.f4965b);
            }
            return a().a(r0.g.d().b(gVar.a()).c(gVar.b()).d(obj).a());
        }
    }

    /* loaded from: classes.dex */
    private static final class c extends r0.i {
        private c() {
        }

        @Override // i3.r0.i
        public r0.e a(r0.f fVar) {
            return r0.e.g();
        }

        public String toString() {
            return z0.f.a(c.class).toString();
        }
    }

    /* loaded from: classes.dex */
    private static final class d extends r0.i {

        /* renamed from: a  reason: collision with root package name */
        private final i3.j1 f4934a;

        d(i3.j1 j1Var) {
            this.f4934a = j1Var;
        }

        @Override // i3.r0.i
        public r0.e a(r0.f fVar) {
            return r0.e.f(this.f4934a);
        }
    }

    /* loaded from: classes.dex */
    private static final class e extends i3.r0 {
        private e() {
        }

        @Override // i3.r0
        public boolean a(r0.g gVar) {
            return true;
        }

        @Override // i3.r0
        public void c(i3.j1 j1Var) {
        }

        @Override // i3.r0
        @Deprecated
        public void d(r0.g gVar) {
        }

        @Override // i3.r0
        public void f() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class f extends Exception {
        private f(String str) {
            super(str);
        }
    }

    j(i3.t0 t0Var, String str) {
        this.f4928a = (i3.t0) z0.k.o(t0Var, "registry");
        this.f4929b = (String) z0.k.o(str, "defaultPolicy");
    }

    public j(String str) {
        this(i3.t0.b(), str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public i3.s0 d(String str, String str2) {
        i3.s0 d5 = this.f4928a.d(str);
        if (d5 != null) {
            return d5;
        }
        throw new f("Trying to load '" + str + "' because " + str2 + ", but it's unavailable");
    }

    public b e(r0.d dVar) {
        return new b(dVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a1.c f(Map<String, ?> map) {
        List<j2.a> A;
        if (map != null) {
            try {
                A = j2.A(j2.g(map));
            } catch (RuntimeException e5) {
                return a1.c.b(i3.j1.f3434h.q("can't parse load balancer configuration").p(e5));
            }
        } else {
            A = null;
        }
        if (A == null || A.isEmpty()) {
            return null;
        }
        return j2.y(A, this.f4928a);
    }
}
