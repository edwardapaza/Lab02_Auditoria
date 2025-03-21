package v1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import v1.q;
/* loaded from: classes.dex */
public abstract class q {

    /* renamed from: a  reason: collision with root package name */
    public static b f8126a = b.a(0, a.f8128a);

    /* renamed from: b  reason: collision with root package name */
    public static final Comparator<q> f8127b = new Comparator() { // from class: v1.o
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            int i5;
            i5 = q.i((q) obj, (q) obj2);
            return i5;
        }
    };

    /* loaded from: classes.dex */
    public static abstract class a implements Comparable<a> {

        /* renamed from: a  reason: collision with root package name */
        public static final a f8128a = d(w.f8154b, l.d(), -1);

        /* renamed from: b  reason: collision with root package name */
        public static final Comparator<s> f8129b = new Comparator() { // from class: v1.p
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int o5;
                o5 = q.a.o((s) obj, (s) obj2);
                return o5;
            }
        };

        public static a d(w wVar, l lVar, int i5) {
            return new v1.b(wVar, lVar, i5);
        }

        public static a e(w wVar, int i5) {
            long n5 = wVar.c().n();
            int h5 = wVar.c().h() + 1;
            return d(new w(((double) h5) == 1.0E9d ? new f1.q(n5 + 1, 0) : new f1.q(n5, h5)), l.d(), i5);
        }

        public static a h(i iVar) {
            return d(iVar.g(), iVar.getKey(), -1);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ int o(s sVar, s sVar2) {
            return h(sVar).compareTo(h(sVar2));
        }

        @Override // java.lang.Comparable
        /* renamed from: c */
        public int compareTo(a aVar) {
            int compareTo = n().compareTo(aVar.n());
            if (compareTo != 0) {
                return compareTo;
            }
            int compareTo2 = k().compareTo(aVar.k());
            return compareTo2 != 0 ? compareTo2 : Integer.compare(m(), aVar.m());
        }

        public abstract l k();

        public abstract int m();

        public abstract w n();
    }

    /* loaded from: classes.dex */
    public static abstract class b {
        public static b a(long j5, a aVar) {
            return new v1.c(j5, aVar);
        }

        public static b b(long j5, w wVar, l lVar, int i5) {
            return a(j5, a.d(wVar, lVar, i5));
        }

        public abstract a c();

        public abstract long d();
    }

    /* loaded from: classes.dex */
    public static abstract class c implements Comparable<c> {

        /* loaded from: classes.dex */
        public enum a {
            ASCENDING,
            DESCENDING,
            CONTAINS
        }

        public static c c(r rVar, a aVar) {
            return new d(rVar, aVar);
        }

        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(c cVar) {
            int compareTo = d().compareTo(cVar.d());
            return compareTo != 0 ? compareTo : e().compareTo(cVar.e());
        }

        public abstract r d();

        public abstract a e();
    }

    public static q b(int i5, String str, List<c> list, b bVar) {
        return new v1.a(i5, str, list, bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int i(q qVar, q qVar2) {
        int compareTo = qVar.d().compareTo(qVar2.d());
        if (compareTo != 0) {
            return compareTo;
        }
        Iterator<c> it = qVar.h().iterator();
        Iterator<c> it2 = qVar2.h().iterator();
        while (it.hasNext() && it2.hasNext()) {
            int compareTo2 = it.next().compareTo(it2.next());
            if (compareTo2 != 0) {
                return compareTo2;
            }
        }
        return Boolean.compare(it.hasNext(), it2.hasNext());
    }

    public c c() {
        for (c cVar : h()) {
            if (cVar.e().equals(c.a.CONTAINS)) {
                return cVar;
            }
        }
        return null;
    }

    public abstract String d();

    public List<c> e() {
        ArrayList arrayList = new ArrayList();
        for (c cVar : h()) {
            if (!cVar.e().equals(c.a.CONTAINS)) {
                arrayList.add(cVar);
            }
        }
        return arrayList;
    }

    public abstract int f();

    public abstract b g();

    public abstract List<c> h();
}
