package q3;

import i3.a;
import i3.j1;
import i3.p;
import i3.q;
import i3.r0;
import i3.x;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import z0.k;
/* loaded from: classes.dex */
public class i extends r0 {

    /* renamed from: h  reason: collision with root package name */
    static final a.c<d<q>> f7068h = a.c.a("state-info");

    /* renamed from: i  reason: collision with root package name */
    private static final j1 f7069i = j1.f3432f.q("no subchannels ready");

    /* renamed from: c  reason: collision with root package name */
    private final r0.d f7070c;

    /* renamed from: f  reason: collision with root package name */
    private p f7073f;

    /* renamed from: d  reason: collision with root package name */
    private final Map<x, r0.h> f7071d = new HashMap();

    /* renamed from: g  reason: collision with root package name */
    protected e f7074g = new b(f7069i);

    /* renamed from: e  reason: collision with root package name */
    private final Random f7072e = new Random();

    /* loaded from: classes.dex */
    class a implements r0.j {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ r0.h f7075a;

        a(r0.h hVar) {
            this.f7075a = hVar;
        }

        @Override // i3.r0.j
        public void a(q qVar) {
            i.this.m(this.f7075a, qVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class b extends e {

        /* renamed from: a  reason: collision with root package name */
        private final j1 f7077a;

        b(j1 j1Var) {
            this.f7077a = (j1) k.o(j1Var, "status");
        }

        @Override // i3.r0.i
        public r0.e a(r0.f fVar) {
            return this.f7077a.o() ? r0.e.g() : r0.e.f(this.f7077a);
        }

        @Override // q3.i.e
        public boolean c(e eVar) {
            if (eVar instanceof b) {
                b bVar = (b) eVar;
                if (z0.g.a(this.f7077a, bVar.f7077a) || (this.f7077a.o() && bVar.f7077a.o())) {
                    return true;
                }
            }
            return false;
        }

        public String toString() {
            return z0.f.a(b.class).d("status", this.f7077a).toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class c extends e {

        /* renamed from: c  reason: collision with root package name */
        private static final AtomicIntegerFieldUpdater<c> f7078c = AtomicIntegerFieldUpdater.newUpdater(c.class, "b");

        /* renamed from: a  reason: collision with root package name */
        private final List<r0.h> f7079a;

        /* renamed from: b  reason: collision with root package name */
        private volatile int f7080b;

        public c(List<r0.h> list, int i5) {
            k.e(!list.isEmpty(), "empty list");
            this.f7079a = list;
            this.f7080b = i5 - 1;
        }

        private r0.h d() {
            int size = this.f7079a.size();
            AtomicIntegerFieldUpdater<c> atomicIntegerFieldUpdater = f7078c;
            int incrementAndGet = atomicIntegerFieldUpdater.incrementAndGet(this);
            if (incrementAndGet >= size) {
                int i5 = incrementAndGet % size;
                atomicIntegerFieldUpdater.compareAndSet(this, incrementAndGet, i5);
                incrementAndGet = i5;
            }
            return this.f7079a.get(incrementAndGet);
        }

        @Override // i3.r0.i
        public r0.e a(r0.f fVar) {
            return r0.e.h(d());
        }

        @Override // q3.i.e
        public boolean c(e eVar) {
            if (eVar instanceof c) {
                c cVar = (c) eVar;
                return cVar == this || (this.f7079a.size() == cVar.f7079a.size() && new HashSet(this.f7079a).containsAll(cVar.f7079a));
            }
            return false;
        }

        public String toString() {
            return z0.f.a(c.class).d("list", this.f7079a).toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class d<T> {

        /* renamed from: a  reason: collision with root package name */
        T f7081a;

        d(T t5) {
            this.f7081a = t5;
        }
    }

    /* loaded from: classes.dex */
    public static abstract class e extends r0.i {
        public abstract boolean c(e eVar);
    }

    public i(r0.d dVar) {
        this.f7070c = (r0.d) k.o(dVar, "helper");
    }

    private static List<r0.h> i(Collection<r0.h> collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        for (r0.h hVar : collection) {
            if (l(hVar)) {
                arrayList.add(hVar);
            }
        }
        return arrayList;
    }

    private static d<q> j(r0.h hVar) {
        return (d) k.o((d) hVar.c().b(f7068h), "STATE_INFO");
    }

    static boolean l(r0.h hVar) {
        return j(hVar).f7081a.c() == p.READY;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void m(r0.h hVar, q qVar) {
        if (this.f7071d.get(p(hVar.a())) != hVar) {
            return;
        }
        p c5 = qVar.c();
        p pVar = p.TRANSIENT_FAILURE;
        if (c5 == pVar || qVar.c() == p.IDLE) {
            this.f7070c.e();
        }
        p c6 = qVar.c();
        p pVar2 = p.IDLE;
        if (c6 == pVar2) {
            hVar.f();
        }
        d<q> j5 = j(hVar);
        if (j5.f7081a.c().equals(pVar) && (qVar.c().equals(p.CONNECTING) || qVar.c().equals(pVar2))) {
            return;
        }
        j5.f7081a = qVar;
        r();
    }

    private static <T> Set<T> n(Set<T> set, Set<T> set2) {
        HashSet hashSet = new HashSet(set);
        hashSet.removeAll(set2);
        return hashSet;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [T, i3.q] */
    private void o(r0.h hVar) {
        hVar.g();
        j(hVar).f7081a = q.a(p.SHUTDOWN);
    }

    private static x p(x xVar) {
        return new x(xVar.a());
    }

    private static Map<x, x> q(List<x> list) {
        HashMap hashMap = new HashMap(list.size() * 2);
        for (x xVar : list) {
            hashMap.put(p(xVar), xVar);
        }
        return hashMap;
    }

    private void r() {
        List<r0.h> i5 = i(k());
        if (!i5.isEmpty()) {
            s(p.READY, h(i5));
            return;
        }
        boolean z4 = false;
        j1 j1Var = f7069i;
        for (r0.h hVar : k()) {
            q qVar = j(hVar).f7081a;
            z4 = (qVar.c() == p.CONNECTING || qVar.c() == p.IDLE) ? true : true;
            if (j1Var == f7069i || !j1Var.o()) {
                j1Var = qVar.d();
            }
        }
        s(z4 ? p.CONNECTING : p.TRANSIENT_FAILURE, new b(j1Var));
    }

    private void s(p pVar, e eVar) {
        if (pVar == this.f7073f && eVar.c(this.f7074g)) {
            return;
        }
        this.f7070c.f(pVar, eVar);
        this.f7073f = pVar;
        this.f7074g = eVar;
    }

    @Override // i3.r0
    public boolean a(r0.g gVar) {
        if (gVar.a().isEmpty()) {
            j1 j1Var = j1.f3447u;
            c(j1Var.q("NameResolver returned no usable address. addrs=" + gVar.a() + ", attrs=" + gVar.b()));
            return false;
        }
        List<x> a5 = gVar.a();
        Set<x> keySet = this.f7071d.keySet();
        Map<x, x> q5 = q(a5);
        Set<x> n5 = n(keySet, q5.keySet());
        for (Map.Entry<x, x> entry : q5.entrySet()) {
            x key = entry.getKey();
            x value = entry.getValue();
            r0.h hVar = this.f7071d.get(key);
            if (hVar != null) {
                hVar.i(Collections.singletonList(value));
            } else {
                r0.h hVar2 = (r0.h) k.o(this.f7070c.a(r0.b.c().d(value).f(i3.a.c().d(f7068h, new d(q.a(p.IDLE))).a()).b()), "subchannel");
                hVar2.h(new a(hVar2));
                this.f7071d.put(key, hVar2);
                hVar2.f();
            }
        }
        ArrayList arrayList = new ArrayList();
        for (x xVar : n5) {
            arrayList.add(this.f7071d.remove(xVar));
        }
        r();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            o((r0.h) it.next());
        }
        return true;
    }

    @Override // i3.r0
    public void c(j1 j1Var) {
        if (this.f7073f != p.READY) {
            s(p.TRANSIENT_FAILURE, new b(j1Var));
        }
    }

    @Override // i3.r0
    public void f() {
        for (r0.h hVar : k()) {
            o(hVar);
        }
        this.f7071d.clear();
    }

    protected e h(List<r0.h> list) {
        return new c(list, this.f7072e.nextInt(list.size()));
    }

    protected Collection<r0.h> k() {
        return this.f7071d.values();
    }
}
