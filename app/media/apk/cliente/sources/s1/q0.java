package s1;

import s1.p;
/* loaded from: classes.dex */
public class q0 extends p {

    /* renamed from: d  reason: collision with root package name */
    private final v1.l f7463d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q0(v1.r rVar, p.b bVar, i2.d0 d0Var) {
        super(rVar, bVar, d0Var);
        z1.b.d(v1.z.B(d0Var), "KeyFieldFilter expects a ReferenceValue", new Object[0]);
        this.f7463d = v1.l.h(h().x0());
    }

    @Override // s1.p, s1.q
    public boolean d(v1.i iVar) {
        return j(iVar.getKey().compareTo(this.f7463d));
    }
}
