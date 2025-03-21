package s1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
/* loaded from: classes.dex */
public class p1 {

    /* renamed from: a */
    private final t1 f7460a;

    /* renamed from: b */
    private final Set<v1.r> f7461b = new HashSet();

    /* renamed from: c */
    private final ArrayList<w1.e> f7462c = new ArrayList<>();

    public p1(t1 t1Var) {
        this.f7460a = t1Var;
    }

    public void b(v1.r rVar) {
        this.f7461b.add(rVar);
    }

    public void c(v1.r rVar, w1.p pVar) {
        this.f7462c.add(new w1.e(rVar, pVar));
    }

    public boolean d(v1.r rVar) {
        for (v1.r rVar2 : this.f7461b) {
            if (rVar.o(rVar2)) {
                return true;
            }
        }
        Iterator<w1.e> it = this.f7462c.iterator();
        while (it.hasNext()) {
            if (rVar.o(it.next().a())) {
                return true;
            }
        }
        return false;
    }

    public List<w1.e> e() {
        return this.f7462c;
    }

    public q1 f() {
        return new q1(this, v1.r.f8135c, false, null);
    }

    public r1 g(v1.t tVar) {
        return new r1(tVar, w1.d.b(this.f7461b), Collections.unmodifiableList(this.f7462c));
    }

    public r1 h(v1.t tVar, w1.d dVar) {
        ArrayList arrayList = new ArrayList();
        Iterator<w1.e> it = this.f7462c.iterator();
        while (it.hasNext()) {
            w1.e next = it.next();
            if (dVar.a(next.a())) {
                arrayList.add(next);
            }
        }
        return new r1(tVar, dVar, Collections.unmodifiableList(arrayList));
    }

    public r1 i(v1.t tVar) {
        return new r1(tVar, null, Collections.unmodifiableList(this.f7462c));
    }

    public s1 j(v1.t tVar) {
        return new s1(tVar, w1.d.b(this.f7461b), Collections.unmodifiableList(this.f7462c));
    }
}
