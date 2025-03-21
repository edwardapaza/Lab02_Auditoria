package i3;

import i3.l;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
/* loaded from: classes.dex */
public final class o {

    /* renamed from: b  reason: collision with root package name */
    private static final o f3516b = new o(new l.a(), l.b.f3486a);

    /* renamed from: a  reason: collision with root package name */
    private final ConcurrentMap<String, n> f3517a = new ConcurrentHashMap();

    o(n... nVarArr) {
        for (n nVar : nVarArr) {
            this.f3517a.put(nVar.a(), nVar);
        }
    }

    public static o a() {
        return f3516b;
    }

    public n b(String str) {
        return this.f3517a.get(str);
    }
}
