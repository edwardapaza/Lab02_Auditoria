package y1;

import i2.s;
import java.util.Map;
import u1.i4;
import z1.g;
/* loaded from: classes.dex */
public class a1 extends c<i2.s, i2.t, a> {

    /* renamed from: t  reason: collision with root package name */
    public static final com.google.protobuf.i f8355t = com.google.protobuf.i.f1961b;

    /* renamed from: s  reason: collision with root package name */
    private final o0 f8356s;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface a extends u0 {
        void d(v1.w wVar, y0 y0Var);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a1(z zVar, z1.g gVar, o0 o0Var, a aVar) {
        super(zVar, i2.r.c(), gVar, g.d.LISTEN_STREAM_CONNECTION_BACKOFF, g.d.LISTEN_STREAM_IDLE, g.d.HEALTH_CHECK_TIMEOUT, aVar);
        this.f8356s = o0Var;
    }

    public void A(i4 i4Var) {
        z1.b.d(m(), "Watching queries requires an open stream", new Object[0]);
        s.b F = i2.s.l0().G(this.f8356s.a()).F(this.f8356s.V(i4Var));
        Map<String, String> N = this.f8356s.N(i4Var);
        if (N != null) {
            F.E(N);
        }
        x(F.build());
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
    public /* bridge */ /* synthetic */ void u() {
        super.u();
    }

    @Override // y1.c
    public /* bridge */ /* synthetic */ void v() {
        super.v();
    }

    @Override // y1.c
    /* renamed from: y */
    public void r(i2.t tVar) {
        this.f8379l.f();
        y0 A = this.f8356s.A(tVar);
        ((a) this.f8380m).d(this.f8356s.z(tVar), A);
    }

    public void z(int i5) {
        z1.b.d(m(), "Unwatching targets requires an open stream", new Object[0]);
        x(i2.s.l0().G(this.f8356s.a()).H(i5).build());
    }
}
