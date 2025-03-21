package s1;

import s1.p;
/* loaded from: classes.dex */
public class p0 extends p {
    /* JADX INFO: Access modifiers changed from: package-private */
    public p0(v1.r rVar, i2.d0 d0Var) {
        super(rVar, p.b.IN, d0Var);
        z1.b.d(v1.z.t(d0Var), "InFilter expects an ArrayValue", new Object[0]);
    }

    @Override // s1.p, s1.q
    public boolean d(v1.i iVar) {
        i2.d0 e5 = iVar.e(f());
        return e5 != null && v1.z.p(h().p0(), e5);
    }
}
