package w1;

import v1.s;
/* loaded from: classes.dex */
public final class c extends f {
    public c(v1.l lVar, m mVar) {
        super(lVar, mVar);
    }

    @Override // w1.f
    public d a(s sVar, d dVar, f1.q qVar) {
        n(sVar);
        if (h().e(sVar)) {
            sVar.m(sVar.j()).u();
            return null;
        }
        return dVar;
    }

    @Override // w1.f
    public void b(s sVar, i iVar) {
        n(sVar);
        z1.b.d(iVar.a().isEmpty(), "Transform results received by DeleteMutation.", new Object[0]);
        sVar.m(iVar.b()).t();
    }

    @Override // w1.f
    public d e() {
        return null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || c.class != obj.getClass()) {
            return false;
        }
        return i((c) obj);
    }

    public int hashCode() {
        return j();
    }

    public String toString() {
        return "DeleteMutation{" + k() + "}";
    }
}
