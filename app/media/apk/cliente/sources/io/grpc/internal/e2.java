package io.grpc.internal;

import i3.a;
import i3.a1;
import io.grpc.internal.e2;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class e2 extends p0 {

    /* renamed from: e  reason: collision with root package name */
    static final a.c<b> f4728e = a.c.a("io.grpc.internal.RetryingNameResolver.RESOLUTION_RESULT_LISTENER_KEY");

    /* renamed from: b  reason: collision with root package name */
    private final i3.a1 f4729b;

    /* renamed from: c  reason: collision with root package name */
    private final d2 f4730c;

    /* renamed from: d  reason: collision with root package name */
    private final i3.n1 f4731d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            e2.this.b();
        }
    }

    /* loaded from: classes.dex */
    class b {
        b() {
        }

        public void a(boolean z4) {
            if (z4) {
                e2.this.f4730c.reset();
            } else {
                e2.this.f4730c.a(new a());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class c extends a1.e {

        /* renamed from: a  reason: collision with root package name */
        private a1.e f4734a;

        c(a1.e eVar) {
            this.f4734a = eVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void e() {
            e2.this.f4730c.a(new a());
        }

        @Override // i3.a1.e, i3.a1.f
        public void a(i3.j1 j1Var) {
            this.f4734a.a(j1Var);
            e2.this.f4731d.execute(new Runnable() { // from class: io.grpc.internal.f2
                @Override // java.lang.Runnable
                public final void run() {
                    e2.c.this.e();
                }
            });
        }

        @Override // i3.a1.e
        public void c(a1.g gVar) {
            i3.a b5 = gVar.b();
            a.c<b> cVar = e2.f4728e;
            if (b5.b(cVar) != null) {
                throw new IllegalStateException("RetryingNameResolver can only be used once to wrap a NameResolver");
            }
            this.f4734a.c(gVar.e().c(gVar.b().d().d(cVar, new b()).a()).a());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e2(i3.a1 a1Var, d2 d2Var, i3.n1 n1Var) {
        super(a1Var);
        this.f4729b = a1Var;
        this.f4730c = d2Var;
        this.f4731d = n1Var;
    }

    @Override // io.grpc.internal.p0, i3.a1
    public void c() {
        super.c();
        this.f4730c.reset();
    }

    @Override // io.grpc.internal.p0, i3.a1
    public void d(a1.e eVar) {
        super.d(new c(eVar));
    }
}
