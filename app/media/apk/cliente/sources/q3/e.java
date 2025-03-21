package q3;

import i3.j1;
import i3.p;
import i3.r0;
import z0.k;
/* loaded from: classes.dex */
public final class e extends q3.b {

    /* renamed from: l  reason: collision with root package name */
    static final r0.i f6978l = new c();

    /* renamed from: c  reason: collision with root package name */
    private final r0 f6979c;

    /* renamed from: d  reason: collision with root package name */
    private final r0.d f6980d;

    /* renamed from: e  reason: collision with root package name */
    private r0.c f6981e;

    /* renamed from: f  reason: collision with root package name */
    private r0 f6982f;

    /* renamed from: g  reason: collision with root package name */
    private r0.c f6983g;

    /* renamed from: h  reason: collision with root package name */
    private r0 f6984h;

    /* renamed from: i  reason: collision with root package name */
    private p f6985i;

    /* renamed from: j  reason: collision with root package name */
    private r0.i f6986j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f6987k;

    /* loaded from: classes.dex */
    class a extends r0 {

        /* renamed from: q3.e$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class C0107a extends r0.i {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ j1 f6989a;

            C0107a(j1 j1Var) {
                this.f6989a = j1Var;
            }

            @Override // i3.r0.i
            public r0.e a(r0.f fVar) {
                return r0.e.f(this.f6989a);
            }

            public String toString() {
                return z0.f.a(C0107a.class).d("error", this.f6989a).toString();
            }
        }

        a() {
        }

        @Override // i3.r0
        public void c(j1 j1Var) {
            e.this.f6980d.f(p.TRANSIENT_FAILURE, new C0107a(j1Var));
        }

        @Override // i3.r0
        public void d(r0.g gVar) {
            throw new IllegalStateException("GracefulSwitchLoadBalancer must switch to a load balancing policy before handling ResolvedAddresses");
        }

        @Override // i3.r0
        public void f() {
        }
    }

    /* loaded from: classes.dex */
    class b extends q3.c {

        /* renamed from: a  reason: collision with root package name */
        r0 f6991a;

        b() {
        }

        @Override // i3.r0.d
        public void f(p pVar, r0.i iVar) {
            if (this.f6991a == e.this.f6984h) {
                k.u(e.this.f6987k, "there's pending lb while current lb has been out of READY");
                e.this.f6985i = pVar;
                e.this.f6986j = iVar;
                if (pVar != p.READY) {
                    return;
                }
            } else if (this.f6991a != e.this.f6982f) {
                return;
            } else {
                e.this.f6987k = pVar == p.READY;
                if (e.this.f6987k || e.this.f6984h == e.this.f6979c) {
                    e.this.f6980d.f(pVar, iVar);
                    return;
                }
            }
            e.this.q();
        }

        @Override // q3.c
        protected r0.d g() {
            return e.this.f6980d;
        }
    }

    /* loaded from: classes.dex */
    class c extends r0.i {
        c() {
        }

        @Override // i3.r0.i
        public r0.e a(r0.f fVar) {
            return r0.e.g();
        }

        public String toString() {
            return "BUFFER_PICKER";
        }
    }

    public e(r0.d dVar) {
        a aVar = new a();
        this.f6979c = aVar;
        this.f6982f = aVar;
        this.f6984h = aVar;
        this.f6980d = (r0.d) k.o(dVar, "helper");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        this.f6980d.f(this.f6985i, this.f6986j);
        this.f6982f.f();
        this.f6982f = this.f6984h;
        this.f6981e = this.f6983g;
        this.f6984h = this.f6979c;
        this.f6983g = null;
    }

    @Override // i3.r0
    public void f() {
        this.f6984h.f();
        this.f6982f.f();
    }

    @Override // q3.b
    protected r0 g() {
        r0 r0Var = this.f6984h;
        return r0Var == this.f6979c ? this.f6982f : r0Var;
    }

    public void r(r0.c cVar) {
        k.o(cVar, "newBalancerFactory");
        if (cVar.equals(this.f6983g)) {
            return;
        }
        this.f6984h.f();
        this.f6984h = this.f6979c;
        this.f6983g = null;
        this.f6985i = p.CONNECTING;
        this.f6986j = f6978l;
        if (cVar.equals(this.f6981e)) {
            return;
        }
        b bVar = new b();
        r0 a5 = cVar.a(bVar);
        bVar.f6991a = a5;
        this.f6984h = a5;
        this.f6983g = cVar;
        if (this.f6987k) {
            return;
        }
        q();
    }
}
