package e2;

import java.util.Iterator;
import java.util.Set;
import k1.r;
/* loaded from: classes.dex */
public class c implements i {

    /* renamed from: a  reason: collision with root package name */
    private final String f2667a;

    /* renamed from: b  reason: collision with root package name */
    private final d f2668b;

    c(Set<f> set, d dVar) {
        this.f2667a = e(set);
        this.f2668b = dVar;
    }

    public static k1.c<i> c() {
        return k1.c.c(i.class).b(r.m(f.class)).d(new k1.h() { // from class: e2.b
            @Override // k1.h
            public final Object a(k1.e eVar) {
                i d5;
                d5 = c.d(eVar);
                return d5;
            }
        }).c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ i d(k1.e eVar) {
        return new c(eVar.b(f.class), d.a());
    }

    private static String e(Set<f> set) {
        StringBuilder sb = new StringBuilder();
        Iterator<f> it = set.iterator();
        while (it.hasNext()) {
            f next = it.next();
            sb.append(next.b());
            sb.append('/');
            sb.append(next.c());
            if (it.hasNext()) {
                sb.append(' ');
            }
        }
        return sb.toString();
    }

    @Override // e2.i
    public String a() {
        if (this.f2668b.b().isEmpty()) {
            return this.f2667a;
        }
        return this.f2667a + ' ' + e(this.f2668b.b());
    }
}
