package w1;

import i2.d0;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import v1.r;
import v1.s;
import v1.t;
/* loaded from: classes.dex */
public final class o extends f {

    /* renamed from: d  reason: collision with root package name */
    private final t f8257d;

    public o(v1.l lVar, t tVar, m mVar) {
        this(lVar, tVar, mVar, new ArrayList());
    }

    public o(v1.l lVar, t tVar, m mVar, List<e> list) {
        super(lVar, mVar, list);
        this.f8257d = tVar;
    }

    @Override // w1.f
    public d a(s sVar, d dVar, f1.q qVar) {
        n(sVar);
        if (h().e(sVar)) {
            Map<r, d0> l5 = l(qVar, sVar);
            t clone = this.f8257d.clone();
            clone.o(l5);
            sVar.l(sVar.j(), clone).u();
            return null;
        }
        return dVar;
    }

    @Override // w1.f
    public void b(s sVar, i iVar) {
        n(sVar);
        t clone = this.f8257d.clone();
        clone.o(m(sVar, iVar.a()));
        sVar.l(iVar.b(), clone).t();
    }

    @Override // w1.f
    public d e() {
        return null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || o.class != obj.getClass()) {
            return false;
        }
        o oVar = (o) obj;
        return i(oVar) && this.f8257d.equals(oVar.f8257d) && f().equals(oVar.f());
    }

    public int hashCode() {
        return (j() * 31) + this.f8257d.hashCode();
    }

    public t o() {
        return this.f8257d;
    }

    public String toString() {
        return "SetMutation{" + k() + ", value=" + this.f8257d + "}";
    }
}
