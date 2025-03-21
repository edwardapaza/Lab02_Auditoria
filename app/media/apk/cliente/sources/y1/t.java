package y1;

import i3.y0;
/* loaded from: classes.dex */
public class t implements j0 {

    /* renamed from: d  reason: collision with root package name */
    private static final y0.g<String> f8505d;

    /* renamed from: e  reason: collision with root package name */
    private static final y0.g<String> f8506e;

    /* renamed from: f  reason: collision with root package name */
    private static final y0.g<String> f8507f;

    /* renamed from: a  reason: collision with root package name */
    private final b2.b<a2.j> f8508a;

    /* renamed from: b  reason: collision with root package name */
    private final b2.b<e2.i> f8509b;

    /* renamed from: c  reason: collision with root package name */
    private final f1.n f8510c;

    static {
        y0.d<String> dVar = i3.y0.f3588e;
        f8505d = y0.g.e("x-firebase-client-log-type", dVar);
        f8506e = y0.g.e("x-firebase-client", dVar);
        f8507f = y0.g.e("x-firebase-gmpid", dVar);
    }

    public t(b2.b<e2.i> bVar, b2.b<a2.j> bVar2, f1.n nVar) {
        this.f8509b = bVar;
        this.f8508a = bVar2;
        this.f8510c = nVar;
    }

    private void b(i3.y0 y0Var) {
        f1.n nVar = this.f8510c;
        if (nVar == null) {
            return;
        }
        String c5 = nVar.c();
        if (c5.length() != 0) {
            y0Var.p(f8507f, c5);
        }
    }

    @Override // y1.j0
    public void a(i3.y0 y0Var) {
        if (this.f8508a.get() == null || this.f8509b.get() == null) {
            return;
        }
        int a5 = this.f8508a.get().b("fire-fst").a();
        if (a5 != 0) {
            y0Var.p(f8505d, Integer.toString(a5));
        }
        y0Var.p(f8506e, this.f8509b.get().a());
        b(y0Var);
    }
}
