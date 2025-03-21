package s1;

import s1.p;
/* loaded from: classes.dex */
public class e extends p {
    /* JADX INFO: Access modifiers changed from: package-private */
    public e(v1.r rVar, i2.d0 d0Var) {
        super(rVar, p.b.ARRAY_CONTAINS_ANY, d0Var);
        z1.b.d(v1.z.t(d0Var), "ArrayContainsAnyFilter expects an ArrayValue", new Object[0]);
    }

    @Override // s1.p, s1.q
    public boolean d(v1.i iVar) {
        i2.d0 e5 = iVar.e(f());
        if (v1.z.t(e5)) {
            for (i2.d0 d0Var : e5.p0().e()) {
                if (v1.z.p(h().p0(), d0Var)) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }
}
