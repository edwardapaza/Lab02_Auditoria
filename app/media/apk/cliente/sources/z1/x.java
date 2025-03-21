package z1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import s1.k;
import s1.p;
import s1.p0;
/* loaded from: classes.dex */
public class x {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v3, types: [s1.q] */
    /* JADX WARN: Type inference failed for: r4v4, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v5, types: [s1.k] */
    protected static s1.q a(s1.q qVar) {
        f(qVar);
        if (m(qVar)) {
            return qVar;
        }
        s1.k kVar = (s1.k) qVar;
        List<s1.q> b5 = kVar.b();
        if (b5.size() == 1) {
            return a(b5.get(0));
        }
        if (kVar.h()) {
            return kVar;
        }
        ArrayList<??> arrayList = new ArrayList();
        for (s1.q qVar2 : b5) {
            arrayList.add(a(qVar2));
        }
        ArrayList arrayList2 = new ArrayList();
        for (?? r42 : arrayList) {
            if (!(r42 instanceof s1.p)) {
                if (r42 instanceof s1.k) {
                    r42 = (s1.k) r42;
                    if (r42.e().equals(kVar.e())) {
                        arrayList2.addAll(r42.b());
                    }
                }
            }
            arrayList2.add(r42);
        }
        return arrayList2.size() == 1 ? (s1.q) arrayList2.get(0) : new s1.k(arrayList2, kVar.e());
    }

    private static s1.q b(s1.k kVar, s1.k kVar2) {
        b.d((kVar.b().isEmpty() || kVar2.b().isEmpty()) ? false : true, "Found an empty composite filter", new Object[0]);
        if (kVar.f() && kVar2.f()) {
            return kVar.j(kVar2.b());
        }
        s1.k kVar3 = kVar.g() ? kVar : kVar2;
        if (kVar.g()) {
            kVar = kVar2;
        }
        ArrayList arrayList = new ArrayList();
        for (s1.q qVar : kVar3.b()) {
            arrayList.add(e(qVar, kVar));
        }
        return new s1.k(arrayList, k.a.OR);
    }

    private static s1.q c(s1.p pVar, s1.k kVar) {
        if (kVar.f()) {
            return kVar.j(Collections.singletonList(pVar));
        }
        ArrayList arrayList = new ArrayList();
        for (s1.q qVar : kVar.b()) {
            arrayList.add(e(pVar, qVar));
        }
        return new s1.k(arrayList, k.a.OR);
    }

    private static s1.q d(s1.p pVar, s1.p pVar2) {
        return new s1.k(Arrays.asList(pVar, pVar2), k.a.AND);
    }

    protected static s1.q e(s1.q qVar, s1.q qVar2) {
        f(qVar);
        f(qVar2);
        boolean z4 = qVar instanceof s1.p;
        return a((z4 && (qVar2 instanceof s1.p)) ? d((s1.p) qVar, (s1.p) qVar2) : (z4 && (qVar2 instanceof s1.k)) ? c((s1.p) qVar, (s1.k) qVar2) : ((qVar instanceof s1.k) && (qVar2 instanceof s1.p)) ? c((s1.p) qVar2, (s1.k) qVar) : b((s1.k) qVar, (s1.k) qVar2));
    }

    private static void f(s1.q qVar) {
        b.d((qVar instanceof s1.p) || (qVar instanceof s1.k), "Only field filters and composite filters are accepted.", new Object[0]);
    }

    protected static s1.q g(s1.q qVar) {
        f(qVar);
        if (qVar instanceof s1.p) {
            return qVar;
        }
        s1.k kVar = (s1.k) qVar;
        if (kVar.b().size() == 1) {
            return g(qVar.b().get(0));
        }
        ArrayList arrayList = new ArrayList();
        for (s1.q qVar2 : kVar.b()) {
            arrayList.add(g(qVar2));
        }
        s1.q a5 = a(new s1.k(arrayList, kVar.e()));
        if (k(a5)) {
            return a5;
        }
        b.d(a5 instanceof s1.k, "field filters are already in DNF form.", new Object[0]);
        s1.k kVar2 = (s1.k) a5;
        b.d(kVar2.f(), "Disjunction of filters all of which are already in DNF form is itself in DNF form.", new Object[0]);
        b.d(kVar2.b().size() > 1, "Single-filter composite filters are already in DNF form.", new Object[0]);
        s1.q qVar3 = kVar2.b().get(0);
        for (int i5 = 1; i5 < kVar2.b().size(); i5++) {
            qVar3 = e(qVar3, kVar2.b().get(i5));
        }
        return qVar3;
    }

    protected static s1.q h(s1.q qVar) {
        f(qVar);
        ArrayList arrayList = new ArrayList();
        if (!(qVar instanceof s1.p)) {
            s1.k kVar = (s1.k) qVar;
            for (s1.q qVar2 : kVar.b()) {
                arrayList.add(h(qVar2));
            }
            return new s1.k(arrayList, kVar.e());
        } else if (qVar instanceof p0) {
            p0 p0Var = (p0) qVar;
            for (i2.d0 d0Var : p0Var.h().p0().e()) {
                arrayList.add(s1.p.e(p0Var.f(), p.b.EQUAL, d0Var));
            }
            return new s1.k(arrayList, k.a.OR);
        } else {
            return qVar;
        }
    }

    public static List<s1.q> i(s1.k kVar) {
        if (kVar.b().isEmpty()) {
            return Collections.emptyList();
        }
        s1.q g5 = g(h(kVar));
        b.d(k(g5), "computeDistributedNormalForm did not result in disjunctive normal form", new Object[0]);
        return (m(g5) || l(g5)) ? Collections.singletonList(g5) : g5.b();
    }

    private static boolean j(s1.q qVar) {
        if (qVar instanceof s1.k) {
            s1.k kVar = (s1.k) qVar;
            if (kVar.g()) {
                for (s1.q qVar2 : kVar.b()) {
                    if (!m(qVar2) && !l(qVar2)) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    private static boolean k(s1.q qVar) {
        return m(qVar) || l(qVar) || j(qVar);
    }

    private static boolean l(s1.q qVar) {
        return (qVar instanceof s1.k) && ((s1.k) qVar).i();
    }

    private static boolean m(s1.q qVar) {
        return qVar instanceof s1.p;
    }
}
