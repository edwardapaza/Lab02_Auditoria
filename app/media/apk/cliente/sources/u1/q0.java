package u1;

import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
class q0 implements a {

    /* renamed from: a  reason: collision with root package name */
    private final Map<String, r1.e> f7966a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private final Map<String, r1.j> f7967b = new HashMap();

    @Override // u1.a
    public r1.e a(String str) {
        return this.f7966a.get(str);
    }

    @Override // u1.a
    public r1.j b(String str) {
        return this.f7967b.get(str);
    }

    @Override // u1.a
    public void c(r1.j jVar) {
        this.f7967b.put(jVar.b(), jVar);
    }

    @Override // u1.a
    public void d(r1.e eVar) {
        this.f7966a.put(eVar.a(), eVar);
    }
}
