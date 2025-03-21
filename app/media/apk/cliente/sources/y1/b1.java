package y1;

import i2.f0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import z1.g;
/* loaded from: classes.dex */
public class b1 extends c<i2.f0, i2.g0, a> {

    /* renamed from: v  reason: collision with root package name */
    public static final com.google.protobuf.i f8359v = com.google.protobuf.i.f1961b;

    /* renamed from: s  reason: collision with root package name */
    private final o0 f8360s;

    /* renamed from: t  reason: collision with root package name */
    protected boolean f8361t;

    /* renamed from: u  reason: collision with root package name */
    private com.google.protobuf.i f8362u;

    /* loaded from: classes.dex */
    public interface a extends u0 {
        void c();

        void e(v1.w wVar, List<w1.i> list);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b1(z zVar, z1.g gVar, o0 o0Var, a aVar) {
        super(zVar, i2.r.e(), gVar, g.d.WRITE_STREAM_CONNECTION_BACKOFF, g.d.WRITE_STREAM_IDLE, g.d.HEALTH_CHECK_TIMEOUT, aVar);
        this.f8361t = false;
        this.f8362u = f8359v;
        this.f8360s = o0Var;
    }

    @Override // y1.c
    /* renamed from: A */
    public void r(i2.g0 g0Var) {
        this.f8362u = g0Var.g0();
        if (!this.f8361t) {
            this.f8361t = true;
            ((a) this.f8380m).c();
            return;
        }
        this.f8379l.f();
        v1.w y4 = this.f8360s.y(g0Var.e0());
        int i02 = g0Var.i0();
        ArrayList arrayList = new ArrayList(i02);
        for (int i5 = 0; i5 < i02; i5++) {
            arrayList.add(this.f8360s.p(g0Var.h0(i5), y4));
        }
        ((a) this.f8380m).e(y4, arrayList);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void B(com.google.protobuf.i iVar) {
        this.f8362u = (com.google.protobuf.i) z1.y.b(iVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void C() {
        z1.b.d(m(), "Writing handshake requires an opened stream", new Object[0]);
        z1.b.d(!this.f8361t, "Handshake already completed", new Object[0]);
        x(i2.f0.k0().F(this.f8360s.a()).build());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void D(List<w1.f> list) {
        z1.b.d(m(), "Writing mutations requires an opened stream", new Object[0]);
        z1.b.d(this.f8361t, "Handshake must be complete before writing mutations", new Object[0]);
        f0.b k02 = i2.f0.k0();
        for (w1.f fVar : list) {
            k02.E(this.f8360s.O(fVar));
        }
        k02.G(this.f8362u);
        x(k02.build());
    }

    @Override // y1.c
    public /* bridge */ /* synthetic */ void l() {
        super.l();
    }

    @Override // y1.c
    public /* bridge */ /* synthetic */ boolean m() {
        return super.m();
    }

    @Override // y1.c
    public /* bridge */ /* synthetic */ boolean n() {
        return super.n();
    }

    @Override // y1.c
    public void u() {
        this.f8361t = false;
        super.u();
    }

    @Override // y1.c
    public /* bridge */ /* synthetic */ void v() {
        super.v();
    }

    @Override // y1.c
    protected void w() {
        if (this.f8361t) {
            D(Collections.emptyList());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.google.protobuf.i y() {
        return this.f8362u;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean z() {
        return this.f8361t;
    }
}
