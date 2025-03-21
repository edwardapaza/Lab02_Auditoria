package r1;

import com.google.firebase.firestore.j0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import v1.l;
import v1.s;
import z1.y;
/* loaded from: classes.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private final a f7130a;

    /* renamed from: b  reason: collision with root package name */
    private final e f7131b;

    /* renamed from: f  reason: collision with root package name */
    private long f7135f;

    /* renamed from: g  reason: collision with root package name */
    private h f7136g;

    /* renamed from: c  reason: collision with root package name */
    private final List<j> f7132c = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    private m1.c<l, s> f7134e = v1.j.b();

    /* renamed from: d  reason: collision with root package name */
    private final Map<l, h> f7133d = new HashMap();

    public d(a aVar, e eVar) {
        this.f7130a = aVar;
        this.f7131b = eVar;
    }

    private Map<String, m1.e<l>> c() {
        HashMap hashMap = new HashMap();
        for (j jVar : this.f7132c) {
            hashMap.put(jVar.b(), l.e());
        }
        for (h hVar : this.f7133d.values()) {
            for (String str : hVar.c()) {
                hashMap.put(str, ((m1.e) hashMap.get(str)).i(hVar.b()));
            }
        }
        return hashMap;
    }

    public j0 a(c cVar, long j5) {
        m1.c<l, s> cVar2;
        l b5;
        s v5;
        y.a(!(cVar instanceof e), "Unexpected bundle metadata element.", new Object[0]);
        int size = this.f7134e.size();
        if (cVar instanceof j) {
            this.f7132c.add((j) cVar);
        } else if (cVar instanceof h) {
            h hVar = (h) cVar;
            this.f7133d.put(hVar.b(), hVar);
            this.f7136g = hVar;
            if (!hVar.a()) {
                cVar2 = this.f7134e;
                b5 = hVar.b();
                v5 = s.r(hVar.b(), hVar.d()).v(hVar.d());
                this.f7134e = cVar2.m(b5, v5);
                this.f7136g = null;
            }
        } else if (cVar instanceof b) {
            b bVar = (b) cVar;
            if (this.f7136g == null || !bVar.b().equals(this.f7136g.b())) {
                throw new IllegalArgumentException("The document being added does not match the stored metadata.");
            }
            cVar2 = this.f7134e;
            b5 = bVar.b();
            v5 = bVar.a().v(this.f7136g.d());
            this.f7134e = cVar2.m(b5, v5);
            this.f7136g = null;
        }
        this.f7135f += j5;
        if (size != this.f7134e.size()) {
            return new j0(this.f7134e.size(), this.f7131b.e(), this.f7135f, this.f7131b.d(), null, j0.a.RUNNING);
        }
        return null;
    }

    public m1.c<l, v1.i> b() {
        y.a(this.f7136g == null, "Bundled documents end with a document metadata element instead of a document.", new Object[0]);
        y.a(this.f7131b.a() != null, "Bundle ID must be set", new Object[0]);
        y.a(this.f7134e.size() == this.f7131b.e(), "Expected %s documents, but loaded %s.", Integer.valueOf(this.f7131b.e()), Integer.valueOf(this.f7134e.size()));
        m1.c<l, v1.i> a5 = this.f7130a.a(this.f7134e, this.f7131b.a());
        Map<String, m1.e<l>> c5 = c();
        for (j jVar : this.f7132c) {
            this.f7130a.c(jVar, c5.get(jVar.b()));
        }
        this.f7130a.b(this.f7131b);
        return a5;
    }
}
