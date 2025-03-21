package y1;

import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.firestore.z;
import i3.j1;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import u1.h1;
import u1.i4;
import y1.a1;
import y1.b1;
import y1.m0;
import y1.o;
import y1.s0;
import y1.y0;
import y1.z0;
/* loaded from: classes.dex */
public final class s0 implements z0.c {

    /* renamed from: a  reason: collision with root package name */
    private final c f8492a;

    /* renamed from: b  reason: collision with root package name */
    private final u1.i0 f8493b;

    /* renamed from: c  reason: collision with root package name */
    private final r f8494c;

    /* renamed from: d  reason: collision with root package name */
    private final o f8495d;

    /* renamed from: f  reason: collision with root package name */
    private final m0 f8497f;

    /* renamed from: h  reason: collision with root package name */
    private final a1 f8499h;

    /* renamed from: i  reason: collision with root package name */
    private final b1 f8500i;

    /* renamed from: j  reason: collision with root package name */
    private z0 f8501j;

    /* renamed from: g  reason: collision with root package name */
    private boolean f8498g = false;

    /* renamed from: e  reason: collision with root package name */
    private final Map<Integer, i4> f8496e = new HashMap();

    /* renamed from: k  reason: collision with root package name */
    private final Deque<w1.g> f8502k = new ArrayDeque();

    /* loaded from: classes.dex */
    class a implements a1.a {
        a() {
        }

        @Override // y1.u0
        public void a() {
            s0.this.y();
        }

        @Override // y1.u0
        public void b(j1 j1Var) {
            s0.this.x(j1Var);
        }

        @Override // y1.a1.a
        public void d(v1.w wVar, y0 y0Var) {
            s0.this.w(wVar, y0Var);
        }
    }

    /* loaded from: classes.dex */
    class b implements b1.a {
        b() {
        }

        @Override // y1.u0
        public void a() {
            s0.this.f8500i.C();
        }

        @Override // y1.u0
        public void b(j1 j1Var) {
            s0.this.B(j1Var);
        }

        @Override // y1.b1.a
        public void c() {
            s0.this.C();
        }

        @Override // y1.b1.a
        public void e(v1.w wVar, List<w1.i> list) {
            s0.this.D(wVar, list);
        }
    }

    /* loaded from: classes.dex */
    public interface c {
        void a(s1.y0 y0Var);

        m1.e<v1.l> b(int i5);

        void c(int i5, j1 j1Var);

        void d(int i5, j1 j1Var);

        void e(n0 n0Var);

        void f(w1.h hVar);
    }

    public s0(final c cVar, u1.i0 i0Var, r rVar, final z1.g gVar, o oVar) {
        this.f8492a = cVar;
        this.f8493b = i0Var;
        this.f8494c = rVar;
        this.f8495d = oVar;
        Objects.requireNonNull(cVar);
        this.f8497f = new m0(gVar, new m0.a() { // from class: y1.p0
            @Override // y1.m0.a
            public final void a(s1.y0 y0Var) {
                s0.c.this.a(y0Var);
            }
        });
        this.f8499h = rVar.f(new a());
        this.f8500i = rVar.g(new b());
        oVar.a(new z1.n() { // from class: y1.q0
            @Override // z1.n
            public final void accept(Object obj) {
                s0.this.F(gVar, (o.a) obj);
            }
        });
    }

    private void A(j1 j1Var) {
        z1.b.d(!j1Var.o(), "Handling write error with status OK.", new Object[0]);
        if (r.l(j1Var)) {
            z1.w.a("RemoteStore", "RemoteStore error before completed handshake; resetting stream token %s: %s", z1.h0.A(this.f8500i.y()), j1Var);
            b1 b1Var = this.f8500i;
            com.google.protobuf.i iVar = b1.f8359v;
            b1Var.B(iVar);
            this.f8493b.k0(iVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B(j1 j1Var) {
        if (j1Var.o()) {
            z1.b.d(!O(), "Write stream was stopped gracefully while still needed.", new Object[0]);
        }
        if (!j1Var.o() && !this.f8502k.isEmpty()) {
            if (this.f8500i.z()) {
                z(j1Var);
            } else {
                A(j1Var);
            }
        }
        if (O()) {
            S();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C() {
        this.f8493b.k0(this.f8500i.y());
        for (w1.g gVar : this.f8502k) {
            this.f8500i.D(gVar.h());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D(v1.w wVar, List<w1.i> list) {
        this.f8492a.f(w1.h.a(this.f8502k.poll(), wVar, list, this.f8500i.y()));
        u();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void E(o.a aVar) {
        if (aVar.equals(o.a.REACHABLE) && this.f8497f.c().equals(s1.y0.ONLINE)) {
            return;
        }
        if (!(aVar.equals(o.a.UNREACHABLE) && this.f8497f.c().equals(s1.y0.OFFLINE)) && o()) {
            z1.w.a("RemoteStore", "Restarting streams for network reachability change.", new Object[0]);
            J();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void F(z1.g gVar, final o.a aVar) {
        gVar.l(new Runnable() { // from class: y1.r0
            @Override // java.lang.Runnable
            public final void run() {
                s0.this.E(aVar);
            }
        });
    }

    private void H(y0.d dVar) {
        z1.b.d(dVar.a() != null, "Processing target error without a cause", new Object[0]);
        for (Integer num : dVar.d()) {
            if (this.f8496e.containsKey(num)) {
                this.f8496e.remove(num);
                this.f8501j.q(num.intValue());
                this.f8492a.d(num.intValue(), dVar.a());
            }
        }
    }

    private void I(v1.w wVar) {
        z1.b.d(!wVar.equals(v1.w.f8154b), "Can't raise event for unknown SnapshotVersion", new Object[0]);
        n0 c5 = this.f8501j.c(wVar);
        for (Map.Entry<Integer, v0> entry : c5.d().entrySet()) {
            v0 value = entry.getValue();
            if (!value.e().isEmpty()) {
                int intValue = entry.getKey().intValue();
                i4 i4Var = this.f8496e.get(Integer.valueOf(intValue));
                if (i4Var != null) {
                    this.f8496e.put(Integer.valueOf(intValue), i4Var.k(value.e(), wVar));
                }
            }
        }
        for (Map.Entry<Integer, h1> entry2 : c5.e().entrySet()) {
            int intValue2 = entry2.getKey().intValue();
            i4 i4Var2 = this.f8496e.get(Integer.valueOf(intValue2));
            if (i4Var2 != null) {
                this.f8496e.put(Integer.valueOf(intValue2), i4Var2.k(com.google.protobuf.i.f1961b, i4Var2.f()));
                L(intValue2);
                M(new i4(i4Var2.g(), intValue2, i4Var2.e(), entry2.getValue()));
            }
        }
        this.f8492a.e(c5);
    }

    private void J() {
        this.f8498g = false;
        s();
        this.f8497f.i(s1.y0.UNKNOWN);
        this.f8500i.l();
        this.f8499h.l();
        t();
    }

    private void L(int i5) {
        this.f8501j.o(i5);
        this.f8499h.z(i5);
    }

    private void M(i4 i4Var) {
        this.f8501j.o(i4Var.h());
        if (!i4Var.d().isEmpty() || i4Var.f().compareTo(v1.w.f8154b) > 0) {
            i4Var = i4Var.i(Integer.valueOf(b(i4Var.h()).size()));
        }
        this.f8499h.A(i4Var);
    }

    private boolean N() {
        return (!o() || this.f8499h.n() || this.f8496e.isEmpty()) ? false : true;
    }

    private boolean O() {
        return (!o() || this.f8500i.n() || this.f8502k.isEmpty()) ? false : true;
    }

    private void R() {
        z1.b.d(N(), "startWatchStream() called when shouldStartWatchStream() is false.", new Object[0]);
        this.f8501j = new z0(this);
        this.f8499h.u();
        this.f8497f.e();
    }

    private void S() {
        z1.b.d(O(), "startWriteStream() called when shouldStartWriteStream() is false.", new Object[0]);
        this.f8500i.u();
    }

    private void m(w1.g gVar) {
        z1.b.d(n(), "addToWritePipeline called when pipeline is full", new Object[0]);
        this.f8502k.add(gVar);
        if (this.f8500i.m() && this.f8500i.z()) {
            this.f8500i.D(gVar.h());
        }
    }

    private boolean n() {
        return o() && this.f8502k.size() < 10;
    }

    private void p() {
        this.f8501j = null;
    }

    private void s() {
        this.f8499h.v();
        this.f8500i.v();
        if (!this.f8502k.isEmpty()) {
            z1.w.a("RemoteStore", "Stopping write stream with %d pending writes", Integer.valueOf(this.f8502k.size()));
            this.f8502k.clear();
        }
        p();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(v1.w wVar, y0 y0Var) {
        this.f8497f.i(s1.y0.ONLINE);
        z1.b.d((this.f8499h == null || this.f8501j == null) ? false : true, "WatchStream and WatchStreamAggregator should both be non-null", new Object[0]);
        boolean z4 = y0Var instanceof y0.d;
        y0.d dVar = z4 ? (y0.d) y0Var : null;
        if (dVar != null && dVar.b().equals(y0.e.Removed) && dVar.a() != null) {
            H(dVar);
            return;
        }
        if (y0Var instanceof y0.b) {
            this.f8501j.i((y0.b) y0Var);
        } else if (y0Var instanceof y0.c) {
            this.f8501j.j((y0.c) y0Var);
        } else {
            z1.b.d(z4, "Expected watchChange to be an instance of WatchTargetChange", new Object[0]);
            this.f8501j.k((y0.d) y0Var);
        }
        if (wVar.equals(v1.w.f8154b) || wVar.compareTo(this.f8493b.E()) < 0) {
            return;
        }
        I(wVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(j1 j1Var) {
        if (j1Var.o()) {
            z1.b.d(!N(), "Watch stream was stopped gracefully while still needed.", new Object[0]);
        }
        p();
        if (!N()) {
            this.f8497f.i(s1.y0.UNKNOWN);
            return;
        }
        this.f8497f.d(j1Var);
        R();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y() {
        for (i4 i4Var : this.f8496e.values()) {
            M(i4Var);
        }
    }

    private void z(j1 j1Var) {
        z1.b.d(!j1Var.o(), "Handling write error with status OK.", new Object[0]);
        if (r.m(j1Var)) {
            this.f8500i.l();
            this.f8492a.c(this.f8502k.poll().e(), j1Var);
            u();
        }
    }

    public void G(i4 i4Var) {
        Integer valueOf = Integer.valueOf(i4Var.h());
        if (this.f8496e.containsKey(valueOf)) {
            return;
        }
        this.f8496e.put(valueOf, i4Var);
        if (N()) {
            R();
        } else if (this.f8499h.m()) {
            M(i4Var);
        }
    }

    public Task<Map<String, i2.d0>> K(s1.a1 a1Var, List<com.google.firebase.firestore.a> list) {
        return o() ? this.f8494c.q(a1Var, list) : Tasks.forException(new com.google.firebase.firestore.z("Failed to get result from server.", z.a.UNAVAILABLE));
    }

    public void P() {
        z1.w.a("RemoteStore", "Shutting down", new Object[0]);
        this.f8495d.shutdown();
        this.f8498g = false;
        s();
        this.f8494c.r();
        this.f8497f.i(s1.y0.UNKNOWN);
    }

    public void Q() {
        t();
    }

    public void T(int i5) {
        z1.b.d(this.f8496e.remove(Integer.valueOf(i5)) != null, "stopListening called on target no currently watched: %d", Integer.valueOf(i5));
        if (this.f8499h.m()) {
            L(i5);
        }
        if (this.f8496e.isEmpty()) {
            if (this.f8499h.m()) {
                this.f8499h.q();
            } else if (o()) {
                this.f8497f.i(s1.y0.UNKNOWN);
            }
        }
    }

    @Override // y1.z0.c
    public i4 a(int i5) {
        return this.f8496e.get(Integer.valueOf(i5));
    }

    @Override // y1.z0.c
    public m1.e<v1.l> b(int i5) {
        return this.f8492a.b(i5);
    }

    @Override // y1.z0.c
    public v1.f c() {
        return this.f8494c.h().a();
    }

    public boolean o() {
        return this.f8498g;
    }

    public s1.j1 q() {
        return new s1.j1(this.f8494c);
    }

    public void r() {
        this.f8498g = false;
        s();
        this.f8497f.i(s1.y0.OFFLINE);
    }

    public void t() {
        this.f8498g = true;
        if (o()) {
            this.f8500i.B(this.f8493b.F());
            if (N()) {
                R();
            } else {
                this.f8497f.i(s1.y0.UNKNOWN);
            }
            u();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x003d  */
    /* JADX WARN: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0019  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x0032 -> B:6:0x0013). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void u() {
        /*
            r2 = this;
            java.util.Deque<w1.g> r0 = r2.f8502k
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto La
            r0 = -1
            goto L13
        La:
            java.util.Deque<w1.g> r0 = r2.f8502k
            java.lang.Object r0 = r0.getLast()
            w1.g r0 = (w1.g) r0
            goto L32
        L13:
            boolean r1 = r2.n()
            if (r1 == 0) goto L37
            u1.i0 r1 = r2.f8493b
            w1.g r0 = r1.I(r0)
            if (r0 != 0) goto L2f
            java.util.Deque<w1.g> r0 = r2.f8502k
            int r0 = r0.size()
            if (r0 != 0) goto L37
            y1.b1 r0 = r2.f8500i
            r0.q()
            goto L37
        L2f:
            r2.m(r0)
        L32:
            int r0 = r0.e()
            goto L13
        L37:
            boolean r0 = r2.O()
            if (r0 == 0) goto L40
            r2.S()
        L40:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: y1.s0.u():void");
    }

    public void v() {
        if (o()) {
            z1.w.a("RemoteStore", "Restarting streams for new credential.", new Object[0]);
            J();
        }
    }
}
