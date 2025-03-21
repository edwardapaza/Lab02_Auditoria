package u1;

import java.util.Collections;
import java.util.Iterator;
/* loaded from: classes.dex */
public class k1 {

    /* renamed from: a  reason: collision with root package name */
    private m1.e<e> f7903a = new m1.e<>(Collections.emptyList(), e.f7776c);

    /* renamed from: b  reason: collision with root package name */
    private m1.e<e> f7904b = new m1.e<>(Collections.emptyList(), e.f7777d);

    private void e(e eVar) {
        this.f7903a = this.f7903a.l(eVar);
        this.f7904b = this.f7904b.l(eVar);
    }

    public void a(v1.l lVar, int i5) {
        e eVar = new e(lVar, i5);
        this.f7903a = this.f7903a.i(eVar);
        this.f7904b = this.f7904b.i(eVar);
    }

    public void b(m1.e<v1.l> eVar, int i5) {
        Iterator<v1.l> it = eVar.iterator();
        while (it.hasNext()) {
            a(it.next(), i5);
        }
    }

    public boolean c(v1.l lVar) {
        Iterator<e> k5 = this.f7903a.k(new e(lVar, 0));
        if (k5.hasNext()) {
            return k5.next().d().equals(lVar);
        }
        return false;
    }

    public m1.e<v1.l> d(int i5) {
        Iterator<e> k5 = this.f7904b.k(new e(v1.l.d(), i5));
        m1.e<v1.l> e5 = v1.l.e();
        while (k5.hasNext()) {
            e next = k5.next();
            if (next.c() != i5) {
                break;
            }
            e5 = e5.i(next.d());
        }
        return e5;
    }

    public void f(v1.l lVar, int i5) {
        e(new e(lVar, i5));
    }

    public void g(m1.e<v1.l> eVar, int i5) {
        Iterator<v1.l> it = eVar.iterator();
        while (it.hasNext()) {
            f(it.next(), i5);
        }
    }

    public m1.e<v1.l> h(int i5) {
        Iterator<e> k5 = this.f7904b.k(new e(v1.l.d(), i5));
        m1.e<v1.l> e5 = v1.l.e();
        while (k5.hasNext()) {
            e next = k5.next();
            if (next.c() != i5) {
                break;
            }
            e5 = e5.i(next.d());
            e(next);
        }
        return e5;
    }
}
