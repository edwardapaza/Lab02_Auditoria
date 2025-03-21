package v1;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
/* loaded from: classes.dex */
public final class n implements Iterable<i> {

    /* renamed from: a  reason: collision with root package name */
    private final m1.c<l, i> f8124a;

    /* renamed from: b  reason: collision with root package name */
    private final m1.e<i> f8125b;

    private n(m1.c<l, i> cVar, m1.e<i> eVar) {
        this.f8124a = cVar;
        this.f8125b = eVar;
    }

    public static n i(final Comparator<i> comparator) {
        return new n(j.a(), new m1.e(Collections.emptyList(), new Comparator() { // from class: v1.m
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int o5;
                o5 = n.o(comparator, (i) obj, (i) obj2);
                return o5;
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int o(Comparator comparator, i iVar, i iVar2) {
        int compare = comparator.compare(iVar, iVar2);
        return compare == 0 ? i.f8118a.compare(iVar, iVar2) : compare;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || n.class != obj.getClass()) {
            return false;
        }
        n nVar = (n) obj;
        if (size() != nVar.size()) {
            return false;
        }
        Iterator<i> it = iterator();
        Iterator<i> it2 = nVar.iterator();
        while (it.hasNext()) {
            if (!it.next().equals(it2.next())) {
                return false;
            }
        }
        return true;
    }

    public n h(i iVar) {
        n p5 = p(iVar.getKey());
        return new n(p5.f8124a.m(iVar.getKey(), iVar), p5.f8125b.i(iVar));
    }

    public int hashCode() {
        Iterator<i> it = iterator();
        int i5 = 0;
        while (it.hasNext()) {
            i next = it.next();
            i5 = (((i5 * 31) + next.getKey().hashCode()) * 31) + next.k().hashCode();
        }
        return i5;
    }

    public boolean isEmpty() {
        return this.f8124a.isEmpty();
    }

    @Override // java.lang.Iterable
    public Iterator<i> iterator() {
        return this.f8125b.iterator();
    }

    public i k(l lVar) {
        return this.f8124a.h(lVar);
    }

    public i l() {
        return this.f8125b.h();
    }

    public i m() {
        return this.f8125b.g();
    }

    public int n(l lVar) {
        i h5 = this.f8124a.h(lVar);
        if (h5 == null) {
            return -1;
        }
        return this.f8125b.indexOf(h5);
    }

    public n p(l lVar) {
        i h5 = this.f8124a.h(lVar);
        return h5 == null ? this : new n(this.f8124a.o(lVar), this.f8125b.l(h5));
    }

    public int size() {
        return this.f8124a.size();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Iterator<i> it = iterator();
        boolean z4 = true;
        while (it.hasNext()) {
            i next = it.next();
            if (z4) {
                z4 = false;
            } else {
                sb.append(", ");
            }
            sb.append(next);
        }
        sb.append("]");
        return sb.toString();
    }
}
