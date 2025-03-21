package w1;

import java.util.List;
import v1.w;
/* loaded from: classes.dex */
public final class h {

    /* renamed from: a  reason: collision with root package name */
    private final g f8243a;

    /* renamed from: b  reason: collision with root package name */
    private final w f8244b;

    /* renamed from: c  reason: collision with root package name */
    private final List<i> f8245c;

    /* renamed from: d  reason: collision with root package name */
    private final com.google.protobuf.i f8246d;

    /* renamed from: e  reason: collision with root package name */
    private final m1.c<v1.l, w> f8247e;

    private h(g gVar, w wVar, List<i> list, com.google.protobuf.i iVar, m1.c<v1.l, w> cVar) {
        this.f8243a = gVar;
        this.f8244b = wVar;
        this.f8245c = list;
        this.f8246d = iVar;
        this.f8247e = cVar;
    }

    public static h a(g gVar, w wVar, List<i> list, com.google.protobuf.i iVar) {
        z1.b.d(gVar.h().size() == list.size(), "Mutations sent %d must equal results received %d", Integer.valueOf(gVar.h().size()), Integer.valueOf(list.size()));
        m1.c<v1.l, w> c5 = v1.j.c();
        List<f> h5 = gVar.h();
        m1.c<v1.l, w> cVar = c5;
        for (int i5 = 0; i5 < h5.size(); i5++) {
            cVar = cVar.m(h5.get(i5).g(), list.get(i5).b());
        }
        return new h(gVar, wVar, list, iVar, cVar);
    }

    public g b() {
        return this.f8243a;
    }

    public w c() {
        return this.f8244b;
    }

    public m1.c<v1.l, w> d() {
        return this.f8247e;
    }

    public List<i> e() {
        return this.f8245c;
    }

    public com.google.protobuf.i f() {
        return this.f8246d;
    }
}
