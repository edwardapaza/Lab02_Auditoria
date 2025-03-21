package v1;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
/* loaded from: classes.dex */
public final class l implements Comparable<l> {

    /* renamed from: b  reason: collision with root package name */
    private static final Comparator<l> f8120b;

    /* renamed from: c  reason: collision with root package name */
    private static final m1.e<l> f8121c;

    /* renamed from: a  reason: collision with root package name */
    private final u f8122a;

    static {
        Comparator<l> comparator = new Comparator() { // from class: v1.k
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return ((l) obj).compareTo((l) obj2);
            }
        };
        f8120b = comparator;
        f8121c = new m1.e<>(Collections.emptyList(), comparator);
    }

    private l(u uVar) {
        z1.b.d(s(uVar), "Not a document key path: %s", uVar);
        this.f8122a = uVar;
    }

    public static Comparator<l> a() {
        return f8120b;
    }

    public static l d() {
        return m(Collections.emptyList());
    }

    public static m1.e<l> e() {
        return f8121c;
    }

    public static l h(String str) {
        u u5 = u.u(str);
        z1.b.d(u5.p() > 4 && u5.m(0).equals("projects") && u5.m(2).equals("databases") && u5.m(4).equals("documents"), "Tried to parse an invalid key: %s", u5);
        return k(u5.q(5));
    }

    public static l k(u uVar) {
        return new l(uVar);
    }

    public static l m(List<String> list) {
        return new l(u.t(list));
    }

    public static boolean s(u uVar) {
        return uVar.p() % 2 == 0;
    }

    @Override // java.lang.Comparable
    /* renamed from: c */
    public int compareTo(l lVar) {
        return this.f8122a.compareTo(lVar.f8122a);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || l.class != obj.getClass()) {
            return false;
        }
        return this.f8122a.equals(((l) obj).f8122a);
    }

    public int hashCode() {
        return this.f8122a.hashCode();
    }

    public String n() {
        u uVar = this.f8122a;
        return uVar.m(uVar.p() - 2);
    }

    public u o() {
        return this.f8122a.r();
    }

    public String p() {
        return this.f8122a.k();
    }

    public u q() {
        return this.f8122a;
    }

    public boolean r(String str) {
        if (this.f8122a.p() >= 2) {
            u uVar = this.f8122a;
            if (uVar.f8114a.get(uVar.p() - 2).equals(str)) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        return this.f8122a.toString();
    }
}
