package u1;

import android.util.SparseArray;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import u1.o0;
/* loaded from: classes.dex */
public final class i0 implements r1.a {

    /* renamed from: n  reason: collision with root package name */
    private static final long f7849n = TimeUnit.MINUTES.toSeconds(5);

    /* renamed from: a  reason: collision with root package name */
    private final e1 f7850a;

    /* renamed from: b  reason: collision with root package name */
    private l f7851b;

    /* renamed from: c  reason: collision with root package name */
    private b1 f7852c;

    /* renamed from: d  reason: collision with root package name */
    private u1.b f7853d;

    /* renamed from: e  reason: collision with root package name */
    private final l1 f7854e;

    /* renamed from: f  reason: collision with root package name */
    private n f7855f;

    /* renamed from: g  reason: collision with root package name */
    private final g1 f7856g;

    /* renamed from: h  reason: collision with root package name */
    private final k1 f7857h;

    /* renamed from: i  reason: collision with root package name */
    private final h4 f7858i;

    /* renamed from: j  reason: collision with root package name */
    private final u1.a f7859j;

    /* renamed from: k  reason: collision with root package name */
    private final SparseArray<i4> f7860k;

    /* renamed from: l  reason: collision with root package name */
    private final Map<s1.f1, Integer> f7861l;

    /* renamed from: m  reason: collision with root package name */
    private final s1.g1 f7862m;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        i4 f7863a;

        /* renamed from: b  reason: collision with root package name */
        int f7864b;

        private b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        private final Map<v1.l, v1.s> f7865a;

        /* renamed from: b  reason: collision with root package name */
        private final Set<v1.l> f7866b;

        private c(Map<v1.l, v1.s> map, Set<v1.l> set) {
            this.f7865a = map;
            this.f7866b = set;
        }
    }

    public i0(e1 e1Var, g1 g1Var, q1.j jVar) {
        z1.b.d(e1Var.i(), "LocalStore was passed an unstarted persistence implementation", new Object[0]);
        this.f7850a = e1Var;
        this.f7856g = g1Var;
        h4 h5 = e1Var.h();
        this.f7858i = h5;
        this.f7859j = e1Var.a();
        this.f7862m = s1.g1.b(h5.j());
        this.f7854e = e1Var.g();
        k1 k1Var = new k1();
        this.f7857h = k1Var;
        this.f7860k = new SparseArray<>();
        this.f7861l = new HashMap();
        e1Var.f().c(k1Var);
        M(jVar);
    }

    private Set<v1.l> D(w1.h hVar) {
        HashSet hashSet = new HashSet();
        for (int i5 = 0; i5 < hVar.e().size(); i5++) {
            if (!hVar.e().get(i5).a().isEmpty()) {
                hashSet.add(hVar.b().h().get(i5).g());
            }
        }
        return hashSet;
    }

    private void M(q1.j jVar) {
        l c5 = this.f7850a.c(jVar);
        this.f7851b = c5;
        this.f7852c = this.f7850a.d(jVar, c5);
        u1.b b5 = this.f7850a.b(jVar);
        this.f7853d = b5;
        this.f7855f = new n(this.f7854e, this.f7852c, b5, this.f7851b);
        this.f7854e.e(this.f7851b);
        this.f7856g.f(this.f7855f, this.f7851b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ m1.c N(w1.h hVar) {
        w1.g b5 = hVar.b();
        this.f7852c.h(b5, hVar.f());
        x(hVar);
        this.f7852c.a();
        this.f7853d.c(hVar.b().e());
        this.f7855f.o(D(hVar));
        return this.f7855f.d(b5.f());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void O(b bVar, s1.f1 f1Var) {
        int c5 = this.f7862m.c();
        bVar.f7864b = c5;
        i4 i4Var = new i4(f1Var, c5, this.f7850a.f().n(), h1.LISTEN);
        bVar.f7863a = i4Var;
        this.f7858i.b(i4Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ m1.c P(m1.c cVar, i4 i4Var) {
        m1.e<v1.l> e5 = v1.l.e();
        HashMap hashMap = new HashMap();
        Iterator it = cVar.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            v1.l lVar = (v1.l) entry.getKey();
            v1.s sVar = (v1.s) entry.getValue();
            if (sVar.b()) {
                e5 = e5.i(lVar);
            }
            hashMap.put(lVar, sVar);
        }
        this.f7858i.e(i4Var.h());
        this.f7858i.f(e5, i4Var.h());
        c g02 = g0(hashMap);
        return this.f7855f.j(g02.f7865a, g02.f7866b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ m1.c Q(y1.n0 n0Var, v1.w wVar) {
        Map<Integer, y1.v0> d5 = n0Var.d();
        long n5 = this.f7850a.f().n();
        for (Map.Entry<Integer, y1.v0> entry : d5.entrySet()) {
            int intValue = entry.getKey().intValue();
            y1.v0 value = entry.getValue();
            i4 i4Var = this.f7860k.get(intValue);
            if (i4Var != null) {
                this.f7858i.i(value.d(), intValue);
                this.f7858i.f(value.b(), intValue);
                i4 l5 = i4Var.l(n5);
                if (n0Var.e().containsKey(Integer.valueOf(intValue))) {
                    com.google.protobuf.i iVar = com.google.protobuf.i.f1961b;
                    v1.w wVar2 = v1.w.f8154b;
                    l5 = l5.k(iVar, wVar2).j(wVar2);
                } else if (!value.e().isEmpty()) {
                    l5 = l5.k(value.e(), n0Var.c());
                }
                this.f7860k.put(intValue, l5);
                if (l0(i4Var, l5, value)) {
                    this.f7858i.h(l5);
                }
            }
        }
        Map<v1.l, v1.s> a5 = n0Var.a();
        Set<v1.l> b5 = n0Var.b();
        for (v1.l lVar : a5.keySet()) {
            if (b5.contains(lVar)) {
                this.f7850a.f().p(lVar);
            }
        }
        c g02 = g0(a5);
        Map<v1.l, v1.s> map = g02.f7865a;
        v1.w d6 = this.f7858i.d();
        if (!wVar.equals(v1.w.f8154b)) {
            z1.b.d(wVar.compareTo(d6) >= 0, "Watch stream reverted to previous snapshot?? (%s < %s)", wVar, d6);
            this.f7858i.g(wVar);
        }
        return this.f7855f.j(map, g02.f7866b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ o0.c R(o0 o0Var) {
        return o0Var.f(this.f7860k);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void S(List list) {
        Collection<v1.q> k5 = this.f7851b.k();
        Comparator<v1.q> comparator = v1.q.f8127b;
        final l lVar = this.f7851b;
        Objects.requireNonNull(lVar);
        z1.n nVar = new z1.n() { // from class: u1.w
            @Override // z1.n
            public final void accept(Object obj) {
                l.this.f((v1.q) obj);
            }
        };
        final l lVar2 = this.f7851b;
        Objects.requireNonNull(lVar2);
        z1.h0.q(k5, list, comparator, nVar, new z1.n() { // from class: u1.x
            @Override // z1.n
            public final void accept(Object obj) {
                l.this.h((v1.q) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ r1.j T(String str) {
        return this.f7859j.b(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Boolean U(r1.e eVar) {
        r1.e a5 = this.f7859j.a(eVar.a());
        return Boolean.valueOf(a5 != null && a5.b().compareTo(eVar.b()) >= 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void V(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            j0 j0Var = (j0) it.next();
            int d5 = j0Var.d();
            this.f7857h.b(j0Var.b(), d5);
            m1.e<v1.l> c5 = j0Var.c();
            Iterator<v1.l> it2 = c5.iterator();
            while (it2.hasNext()) {
                this.f7850a.f().e(it2.next());
            }
            this.f7857h.g(c5, d5);
            if (!j0Var.e()) {
                i4 i4Var = this.f7860k.get(d5);
                z1.b.d(i4Var != null, "Can't set limbo-free snapshot version for unknown target: %s", Integer.valueOf(d5));
                i4 j5 = i4Var.j(i4Var.f());
                this.f7860k.put(d5, j5);
                if (l0(i4Var, j5, null)) {
                    this.f7858i.h(j5);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ m1.c W(int i5) {
        w1.g e5 = this.f7852c.e(i5);
        z1.b.d(e5 != null, "Attempt to reject nonexistent batch!", new Object[0]);
        this.f7852c.f(e5);
        this.f7852c.a();
        this.f7853d.c(i5);
        this.f7855f.o(e5.f());
        return this.f7855f.d(e5.f());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void X(int i5) {
        i4 i4Var = this.f7860k.get(i5);
        z1.b.d(i4Var != null, "Tried to release nonexistent target: %s", Integer.valueOf(i5));
        Iterator<v1.l> it = this.f7857h.h(i5).iterator();
        while (it.hasNext()) {
            this.f7850a.f().e(it.next());
        }
        this.f7850a.f().j(i4Var);
        this.f7860k.remove(i5);
        this.f7861l.remove(i4Var.g());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Y(r1.e eVar) {
        this.f7859j.d(eVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Z(r1.j jVar, i4 i4Var, int i5, m1.e eVar) {
        if (jVar.c().compareTo(i4Var.f()) > 0) {
            i4 k5 = i4Var.k(com.google.protobuf.i.f1961b, jVar.c());
            this.f7860k.append(i5, k5);
            this.f7858i.h(k5);
            this.f7858i.e(i5);
            this.f7858i.f(eVar, i5);
        }
        this.f7859j.c(jVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a0(com.google.protobuf.i iVar) {
        this.f7852c.i(iVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b0() {
        this.f7851b.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c0() {
        this.f7852c.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ m d0(Set set, List list, f1.q qVar) {
        Map<v1.l, v1.s> f5 = this.f7854e.f(set);
        HashSet hashSet = new HashSet();
        for (Map.Entry<v1.l, v1.s> entry : f5.entrySet()) {
            if (!entry.getValue().o()) {
                hashSet.add(entry.getKey());
            }
        }
        Map<v1.l, d1> l5 = this.f7855f.l(f5);
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            w1.f fVar = (w1.f) it.next();
            v1.t d5 = fVar.d(l5.get(fVar.g()).a());
            if (d5 != null) {
                arrayList.add(new w1.l(fVar.g(), d5, d5.l(), w1.m.a(true)));
            }
        }
        w1.g j5 = this.f7852c.j(qVar, arrayList, list);
        this.f7853d.e(j5.e(), j5.a(l5, hashSet));
        return m.a(j5.e(), l5);
    }

    private static s1.f1 e0(String str) {
        return s1.a1.b(v1.u.u("__bundle__/docs/" + str)).D();
    }

    private c g0(Map<v1.l, v1.s> map) {
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        HashSet hashSet = new HashSet();
        Map<v1.l, v1.s> f5 = this.f7854e.f(map.keySet());
        for (Map.Entry<v1.l, v1.s> entry : map.entrySet()) {
            v1.l key = entry.getKey();
            v1.s value = entry.getValue();
            v1.s sVar = f5.get(key);
            if (value.b() != sVar.b()) {
                hashSet.add(key);
            }
            if (value.h() && value.j().equals(v1.w.f8154b)) {
                arrayList.add(value.getKey());
            } else if (!sVar.o() || value.j().compareTo(sVar.j()) > 0 || (value.j().compareTo(sVar.j()) == 0 && sVar.f())) {
                z1.b.d(!v1.w.f8154b.equals(value.g()), "Cannot add a document when the remote version is zero", new Object[0]);
                this.f7854e.a(value, value.g());
            } else {
                z1.w.a("LocalStore", "Ignoring outdated watch update for %s.Current version: %s  Watch version: %s", key, sVar.j(), value.j());
            }
            hashMap.put(key, value);
        }
        this.f7854e.removeAll(arrayList);
        return new c(hashMap, hashSet);
    }

    private static boolean l0(i4 i4Var, i4 i4Var2, y1.v0 v0Var) {
        if (i4Var.d().isEmpty()) {
            return true;
        }
        long n5 = i4Var2.f().c().n() - i4Var.f().c().n();
        long j5 = f7849n;
        if (n5 < j5 && i4Var2.b().c().n() - i4Var.b().c().n() < j5) {
            return v0Var != null && (v0Var.b().size() + v0Var.c().size()) + v0Var.d().size() > 0;
        }
        return true;
    }

    private void n0() {
        this.f7850a.k("Start IndexManager", new Runnable() { // from class: u1.p
            @Override // java.lang.Runnable
            public final void run() {
                i0.this.b0();
            }
        });
    }

    private void o0() {
        this.f7850a.k("Start MutationQueue", new Runnable() { // from class: u1.z
            @Override // java.lang.Runnable
            public final void run() {
                i0.this.c0();
            }
        });
    }

    private void x(w1.h hVar) {
        w1.g b5 = hVar.b();
        for (v1.l lVar : b5.f()) {
            v1.s d5 = this.f7854e.d(lVar);
            v1.w h5 = hVar.d().h(lVar);
            z1.b.d(h5 != null, "docVersions should contain every doc in the write.", new Object[0]);
            if (d5.j().compareTo(h5) < 0) {
                b5.c(d5, hVar);
                if (d5.o()) {
                    this.f7854e.a(d5, hVar.c());
                }
            }
        }
        this.f7852c.f(b5);
    }

    public i1 A(s1.a1 a1Var, boolean z4) {
        m1.e<v1.l> eVar;
        v1.w wVar;
        i4 J = J(a1Var.D());
        v1.w wVar2 = v1.w.f8154b;
        m1.e<v1.l> e5 = v1.l.e();
        if (J != null) {
            wVar = J.b();
            eVar = this.f7858i.c(J.h());
        } else {
            eVar = e5;
            wVar = wVar2;
        }
        g1 g1Var = this.f7856g;
        if (z4) {
            wVar2 = wVar;
        }
        return new i1(g1Var.e(a1Var, wVar2, eVar), eVar);
    }

    public int B() {
        return this.f7852c.c();
    }

    public l C() {
        return this.f7851b;
    }

    public v1.w E() {
        return this.f7858i.d();
    }

    public com.google.protobuf.i F() {
        return this.f7852c.g();
    }

    public n G() {
        return this.f7855f;
    }

    public r1.j H(final String str) {
        return (r1.j) this.f7850a.j("Get named query", new z1.z() { // from class: u1.y
            @Override // z1.z
            public final Object get() {
                r1.j T;
                T = i0.this.T(str);
                return T;
            }
        });
    }

    public w1.g I(int i5) {
        return this.f7852c.b(i5);
    }

    i4 J(s1.f1 f1Var) {
        Integer num = this.f7861l.get(f1Var);
        return num != null ? this.f7860k.get(num.intValue()) : this.f7858i.a(f1Var);
    }

    public m1.c<v1.l, v1.i> K(q1.j jVar) {
        List<w1.g> k5 = this.f7852c.k();
        M(jVar);
        n0();
        o0();
        List<w1.g> k6 = this.f7852c.k();
        m1.e<v1.l> e5 = v1.l.e();
        for (List<w1.g> list : Arrays.asList(k5, k6)) {
            for (w1.g gVar : list) {
                for (w1.f fVar : gVar.h()) {
                    e5 = e5.i(fVar.g());
                }
            }
        }
        return this.f7855f.d(e5);
    }

    public boolean L(final r1.e eVar) {
        return ((Boolean) this.f7850a.j("Has newer bundle", new z1.z() { // from class: u1.u
            @Override // z1.z
            public final Object get() {
                Boolean U;
                U = i0.this.U(eVar);
                return U;
            }
        })).booleanValue();
    }

    @Override // r1.a
    public m1.c<v1.l, v1.i> a(final m1.c<v1.l, v1.s> cVar, String str) {
        final i4 v5 = v(e0(str));
        return (m1.c) this.f7850a.j("Apply bundle documents", new z1.z() { // from class: u1.h0
            @Override // z1.z
            public final Object get() {
                m1.c P;
                P = i0.this.P(cVar, v5);
                return P;
            }
        });
    }

    @Override // r1.a
    public void b(final r1.e eVar) {
        this.f7850a.k("Save bundle", new Runnable() { // from class: u1.q
            @Override // java.lang.Runnable
            public final void run() {
                i0.this.Y(eVar);
            }
        });
    }

    @Override // r1.a
    public void c(final r1.j jVar, final m1.e<v1.l> eVar) {
        final i4 v5 = v(jVar.a().b());
        final int h5 = v5.h();
        this.f7850a.k("Saved named query", new Runnable() { // from class: u1.t
            @Override // java.lang.Runnable
            public final void run() {
                i0.this.Z(jVar, v5, h5, eVar);
            }
        });
    }

    public void f0(final List<j0> list) {
        this.f7850a.k("notifyLocalViewChanges", new Runnable() { // from class: u1.b0
            @Override // java.lang.Runnable
            public final void run() {
                i0.this.V(list);
            }
        });
    }

    public v1.i h0(v1.l lVar) {
        return this.f7855f.c(lVar);
    }

    public m1.c<v1.l, v1.i> i0(final int i5) {
        return (m1.c) this.f7850a.j("Reject batch", new z1.z() { // from class: u1.a0
            @Override // z1.z
            public final Object get() {
                m1.c W;
                W = i0.this.W(i5);
                return W;
            }
        });
    }

    public void j0(final int i5) {
        this.f7850a.k("Release target", new Runnable() { // from class: u1.e0
            @Override // java.lang.Runnable
            public final void run() {
                i0.this.X(i5);
            }
        });
    }

    public void k0(final com.google.protobuf.i iVar) {
        this.f7850a.k("Set stream token", new Runnable() { // from class: u1.d0
            @Override // java.lang.Runnable
            public final void run() {
                i0.this.a0(iVar);
            }
        });
    }

    public void m0() {
        this.f7850a.e().run();
        n0();
        o0();
    }

    public m p0(final List<w1.f> list) {
        final f1.q q5 = f1.q.q();
        final HashSet hashSet = new HashSet();
        for (w1.f fVar : list) {
            hashSet.add(fVar.g());
        }
        return (m) this.f7850a.j("Locally write mutations", new z1.z() { // from class: u1.s
            @Override // z1.z
            public final Object get() {
                m d02;
                d02 = i0.this.d0(hashSet, list, q5);
                return d02;
            }
        });
    }

    public m1.c<v1.l, v1.i> u(final w1.h hVar) {
        return (m1.c) this.f7850a.j("Acknowledge batch", new z1.z() { // from class: u1.f0
            @Override // z1.z
            public final Object get() {
                m1.c N;
                N = i0.this.N(hVar);
                return N;
            }
        });
    }

    public i4 v(final s1.f1 f1Var) {
        int i5;
        i4 a5 = this.f7858i.a(f1Var);
        if (a5 != null) {
            i5 = a5.h();
        } else {
            final b bVar = new b();
            this.f7850a.k("Allocate target", new Runnable() { // from class: u1.v
                @Override // java.lang.Runnable
                public final void run() {
                    i0.this.O(bVar, f1Var);
                }
            });
            i5 = bVar.f7864b;
            a5 = bVar.f7863a;
        }
        if (this.f7860k.get(i5) == null) {
            this.f7860k.put(i5, a5);
            this.f7861l.put(f1Var, Integer.valueOf(i5));
        }
        return a5;
    }

    public m1.c<v1.l, v1.i> w(final y1.n0 n0Var) {
        final v1.w c5 = n0Var.c();
        return (m1.c) this.f7850a.j("Apply remote event", new z1.z() { // from class: u1.g0
            @Override // z1.z
            public final Object get() {
                m1.c Q;
                Q = i0.this.Q(n0Var, c5);
                return Q;
            }
        });
    }

    public o0.c y(final o0 o0Var) {
        return (o0.c) this.f7850a.j("Collect garbage", new z1.z() { // from class: u1.c0
            @Override // z1.z
            public final Object get() {
                o0.c R;
                R = i0.this.R(o0Var);
                return R;
            }
        });
    }

    public void z(final List<v1.q> list) {
        this.f7850a.k("Configure indexes", new Runnable() { // from class: u1.r
            @Override // java.lang.Runnable
            public final void run() {
                i0.this.S(list);
            }
        });
    }
}
