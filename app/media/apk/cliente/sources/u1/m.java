package u1;

import java.util.Map;
/* loaded from: classes.dex */
public final class m {

    /* renamed from: a  reason: collision with root package name */
    private final int f7916a;

    /* renamed from: b  reason: collision with root package name */
    private final m1.c<v1.l, v1.i> f7917b;

    m(int i5, m1.c<v1.l, v1.i> cVar) {
        this.f7916a = i5;
        this.f7917b = cVar;
    }

    public static m a(int i5, Map<v1.l, d1> map) {
        m1.c<v1.l, v1.i> a5 = v1.j.a();
        for (Map.Entry<v1.l, d1> entry : map.entrySet()) {
            a5 = a5.m(entry.getKey(), entry.getValue().a());
        }
        return new m(i5, a5);
    }

    public int b() {
        return this.f7916a;
    }

    public m1.c<v1.l, v1.i> c() {
        return this.f7917b;
    }
}
