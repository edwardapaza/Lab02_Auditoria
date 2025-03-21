package v1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;
import s1.f1;
import s1.p;
import s1.z0;
import v1.q;
/* loaded from: classes.dex */
public class y {

    /* renamed from: a  reason: collision with root package name */
    private final String f8156a;

    /* renamed from: b  reason: collision with root package name */
    private final SortedSet<s1.p> f8157b;

    /* renamed from: c  reason: collision with root package name */
    private final List<s1.p> f8158c;

    /* renamed from: d  reason: collision with root package name */
    private final List<z0> f8159d;

    public y(f1 f1Var) {
        this.f8156a = f1Var.d() != null ? f1Var.d() : f1Var.n().k();
        this.f8159d = f1Var.m();
        this.f8157b = new TreeSet(new Comparator() { // from class: v1.x
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int e5;
                e5 = y.e((s1.p) obj, (s1.p) obj2);
                return e5;
            }
        });
        this.f8158c = new ArrayList();
        Iterator<s1.q> it = f1Var.h().iterator();
        while (it.hasNext()) {
            s1.p pVar = (s1.p) it.next();
            if (pVar.i()) {
                this.f8157b.add(pVar);
            } else {
                this.f8158c.add(pVar);
            }
        }
    }

    private boolean c(q.c cVar) {
        for (s1.p pVar : this.f8158c) {
            if (f(pVar, cVar)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int e(s1.p pVar, s1.p pVar2) {
        return pVar.f().compareTo(pVar2.f());
    }

    private boolean f(s1.p pVar, q.c cVar) {
        if (pVar == null || !pVar.f().equals(cVar.d())) {
            return false;
        }
        return cVar.e().equals(q.c.a.CONTAINS) == (pVar.g().equals(p.b.ARRAY_CONTAINS) || pVar.g().equals(p.b.ARRAY_CONTAINS_ANY));
    }

    private boolean g(z0 z0Var, q.c cVar) {
        if (z0Var.c().equals(cVar.d())) {
            return (cVar.e().equals(q.c.a.ASCENDING) && z0Var.b().equals(z0.a.ASCENDING)) || (cVar.e().equals(q.c.a.DESCENDING) && z0Var.b().equals(z0.a.DESCENDING));
        }
        return false;
    }

    public q b() {
        r f5;
        q.c.a aVar;
        if (d()) {
            return null;
        }
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        for (s1.p pVar : this.f8158c) {
            if (!pVar.f().w()) {
                if (pVar.g().equals(p.b.ARRAY_CONTAINS) || pVar.g().equals(p.b.ARRAY_CONTAINS_ANY)) {
                    f5 = pVar.f();
                    aVar = q.c.a.CONTAINS;
                } else if (!hashSet.contains(pVar.f())) {
                    hashSet.add(pVar.f());
                    f5 = pVar.f();
                    aVar = q.c.a.ASCENDING;
                }
                arrayList.add(q.c.c(f5, aVar));
            }
        }
        for (z0 z0Var : this.f8159d) {
            if (!z0Var.c().w() && !hashSet.contains(z0Var.c())) {
                hashSet.add(z0Var.c());
                arrayList.add(q.c.c(z0Var.c(), z0Var.b() == z0.a.ASCENDING ? q.c.a.ASCENDING : q.c.a.DESCENDING));
            }
        }
        return q.b(-1, this.f8156a, arrayList, q.f8126a);
    }

    public boolean d() {
        return this.f8157b.size() > 1;
    }

    public boolean h(q qVar) {
        z1.b.d(qVar.d().equals(this.f8156a), "Collection IDs do not match", new Object[0]);
        if (d()) {
            return false;
        }
        q.c c5 = qVar.c();
        if (c5 == null || c(c5)) {
            Iterator<z0> it = this.f8159d.iterator();
            List<q.c> e5 = qVar.e();
            HashSet hashSet = new HashSet();
            int i5 = 0;
            while (i5 < e5.size() && c(e5.get(i5))) {
                hashSet.add(e5.get(i5).d().d());
                i5++;
            }
            if (i5 == e5.size()) {
                return true;
            }
            if (this.f8157b.size() > 0) {
                s1.p first = this.f8157b.first();
                if (!hashSet.contains(first.f().d())) {
                    q.c cVar = e5.get(i5);
                    if (!f(first, cVar) || !g(it.next(), cVar)) {
                        return false;
                    }
                }
                i5++;
            }
            while (i5 < e5.size()) {
                q.c cVar2 = e5.get(i5);
                if (!it.hasNext() || !g(it.next(), cVar2)) {
                    return false;
                }
                i5++;
            }
            return true;
        }
        return false;
    }
}
