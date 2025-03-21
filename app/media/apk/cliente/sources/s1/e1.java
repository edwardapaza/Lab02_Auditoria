package s1;

import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.firestore.z;
import i3.j1;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import s1.t0;
import s1.v1;
import s1.x1;
import u1.i4;
import y1.s0;
/* loaded from: classes.dex */
public class e1 implements s0.c {

    /* renamed from: o  reason: collision with root package name */
    private static final String f7300o = "e1";

    /* renamed from: a  reason: collision with root package name */
    private final u1.i0 f7301a;

    /* renamed from: b  reason: collision with root package name */
    private final y1.s0 f7302b;

    /* renamed from: e  reason: collision with root package name */
    private final int f7305e;

    /* renamed from: m  reason: collision with root package name */
    private q1.j f7313m;

    /* renamed from: n  reason: collision with root package name */
    private c f7314n;

    /* renamed from: c  reason: collision with root package name */
    private final Map<a1, c1> f7303c = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    private final Map<Integer, List<a1>> f7304d = new HashMap();

    /* renamed from: f  reason: collision with root package name */
    private final LinkedHashSet<v1.l> f7306f = new LinkedHashSet<>();

    /* renamed from: g  reason: collision with root package name */
    private final Map<v1.l, Integer> f7307g = new HashMap();

    /* renamed from: h  reason: collision with root package name */
    private final Map<Integer, b> f7308h = new HashMap();

    /* renamed from: i  reason: collision with root package name */
    private final u1.k1 f7309i = new u1.k1();

    /* renamed from: j  reason: collision with root package name */
    private final Map<q1.j, Map<Integer, TaskCompletionSource<Void>>> f7310j = new HashMap();

    /* renamed from: l  reason: collision with root package name */
    private final g1 f7312l = g1.a();

    /* renamed from: k  reason: collision with root package name */
    private final Map<Integer, List<TaskCompletionSource<Void>>> f7311k = new HashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f7315a;

        static {
            int[] iArr = new int[t0.a.values().length];
            f7315a = iArr;
            try {
                iArr[t0.a.ADDED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f7315a[t0.a.REMOVED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        private final v1.l f7316a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f7317b;

        b(v1.l lVar) {
            this.f7316a = lVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface c {
        void a(y0 y0Var);

        void b(a1 a1Var, i3.j1 j1Var);

        void c(List<x1> list);
    }

    public e1(u1.i0 i0Var, y1.s0 s0Var, q1.j jVar, int i5) {
        this.f7301a = i0Var;
        this.f7302b = s0Var;
        this.f7305e = i5;
        this.f7313m = jVar;
    }

    private void B(t0 t0Var) {
        v1.l a5 = t0Var.a();
        if (this.f7307g.containsKey(a5) || this.f7306f.contains(a5)) {
            return;
        }
        z1.w.a(f7300o, "New document in limbo: %s", a5);
        this.f7306f.add(a5);
        s();
    }

    private void D(List<t0> list, int i5) {
        for (t0 t0Var : list) {
            int i6 = a.f7315a[t0Var.b().ordinal()];
            if (i6 == 1) {
                this.f7309i.a(t0Var.a(), i5);
                B(t0Var);
            } else if (i6 != 2) {
                throw z1.b.a("Unknown limbo change type: %s", t0Var.b());
            } else {
                z1.w.a(f7300o, "Document no longer in limbo: %s", t0Var.a());
                v1.l a5 = t0Var.a();
                this.f7309i.f(a5, i5);
                if (!this.f7309i.c(a5)) {
                    v(a5);
                }
            }
        }
    }

    private void g(int i5, TaskCompletionSource<Void> taskCompletionSource) {
        Map<Integer, TaskCompletionSource<Void>> map = this.f7310j.get(this.f7313m);
        if (map == null) {
            map = new HashMap<>();
            this.f7310j.put(this.f7313m, map);
        }
        map.put(Integer.valueOf(i5), taskCompletionSource);
    }

    private void h(String str) {
        z1.b.d(this.f7314n != null, "Trying to call %s before setting callback", str);
    }

    private void i(m1.c<v1.l, v1.i> cVar, y1.n0 n0Var) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (Map.Entry<a1, c1> entry : this.f7303c.entrySet()) {
            c1 value = entry.getValue();
            v1 c5 = value.c();
            v1.b h5 = c5.h(cVar);
            boolean z4 = false;
            if (h5.b()) {
                h5 = c5.i(this.f7301a.A(value.a(), false).a(), h5);
            }
            y1.v0 v0Var = n0Var == null ? null : n0Var.d().get(Integer.valueOf(value.b()));
            if (n0Var != null && n0Var.e().get(Integer.valueOf(value.b())) != null) {
                z4 = true;
            }
            w1 d5 = value.c().d(h5, v0Var, z4);
            D(d5.a(), value.b());
            if (d5.b() != null) {
                arrayList.add(d5.b());
                arrayList2.add(u1.j0.a(value.b(), d5.b()));
            }
        }
        this.f7314n.c(arrayList);
        this.f7301a.f0(arrayList2);
    }

    private boolean j(i3.j1 j1Var) {
        j1.b m5 = j1Var.m();
        return (m5 == j1.b.FAILED_PRECONDITION && (j1Var.n() != null ? j1Var.n() : "").contains("requires an index")) || m5 == j1.b.PERMISSION_DENIED;
    }

    private void k() {
        for (Map.Entry<Integer, List<TaskCompletionSource<Void>>> entry : this.f7311k.entrySet()) {
            for (TaskCompletionSource<Void> taskCompletionSource : entry.getValue()) {
                taskCompletionSource.setException(new com.google.firebase.firestore.z("'waitForPendingWrites' task is cancelled due to User change.", z.a.CANCELLED));
            }
        }
        this.f7311k.clear();
    }

    private x1 m(a1 a1Var, int i5, com.google.protobuf.i iVar) {
        u1.i1 A = this.f7301a.A(a1Var, true);
        x1.a aVar = x1.a.NONE;
        if (this.f7304d.get(Integer.valueOf(i5)) != null) {
            aVar = this.f7303c.get(this.f7304d.get(Integer.valueOf(i5)).get(0)).c().j();
        }
        y1.v0 a5 = y1.v0.a(aVar == x1.a.SYNCED, iVar);
        v1 v1Var = new v1(a1Var, A.b());
        w1 c5 = v1Var.c(v1Var.h(A.a()), a5);
        D(c5.a(), i5);
        this.f7303c.put(a1Var, new c1(a1Var, i5, v1Var));
        if (!this.f7304d.containsKey(Integer.valueOf(i5))) {
            this.f7304d.put(Integer.valueOf(i5), new ArrayList(1));
        }
        this.f7304d.get(Integer.valueOf(i5)).add(a1Var);
        return c5.b();
    }

    private void q(i3.j1 j1Var, String str, Object... objArr) {
        if (j(j1Var)) {
            z1.w.e("Firestore", "%s: %s", String.format(str, objArr), j1Var);
        }
    }

    private void r(int i5, i3.j1 j1Var) {
        Integer valueOf;
        TaskCompletionSource<Void> taskCompletionSource;
        Map<Integer, TaskCompletionSource<Void>> map = this.f7310j.get(this.f7313m);
        if (map == null || (taskCompletionSource = map.get((valueOf = Integer.valueOf(i5)))) == null) {
            return;
        }
        if (j1Var != null) {
            taskCompletionSource.setException(z1.h0.t(j1Var));
        } else {
            taskCompletionSource.setResult(null);
        }
        map.remove(valueOf);
    }

    private void s() {
        while (!this.f7306f.isEmpty() && this.f7307g.size() < this.f7305e) {
            Iterator<v1.l> it = this.f7306f.iterator();
            v1.l next = it.next();
            it.remove();
            int c5 = this.f7312l.c();
            this.f7308h.put(Integer.valueOf(c5), new b(next));
            this.f7307g.put(next, Integer.valueOf(c5));
            this.f7302b.G(new i4(a1.b(next.q()).D(), c5, -1L, u1.h1.LIMBO_RESOLUTION));
        }
    }

    private void u(int i5, i3.j1 j1Var) {
        for (a1 a1Var : this.f7304d.get(Integer.valueOf(i5))) {
            this.f7303c.remove(a1Var);
            if (!j1Var.o()) {
                this.f7314n.b(a1Var, j1Var);
                q(j1Var, "Listen for %s failed", a1Var);
            }
        }
        this.f7304d.remove(Integer.valueOf(i5));
        m1.e<v1.l> d5 = this.f7309i.d(i5);
        this.f7309i.h(i5);
        Iterator<v1.l> it = d5.iterator();
        while (it.hasNext()) {
            v1.l next = it.next();
            if (!this.f7309i.c(next)) {
                v(next);
            }
        }
    }

    private void v(v1.l lVar) {
        this.f7306f.remove(lVar);
        Integer num = this.f7307g.get(lVar);
        if (num != null) {
            this.f7302b.T(num.intValue());
            this.f7307g.remove(lVar);
            this.f7308h.remove(num);
            s();
        }
    }

    private void w(int i5) {
        if (this.f7311k.containsKey(Integer.valueOf(i5))) {
            for (TaskCompletionSource<Void> taskCompletionSource : this.f7311k.get(Integer.valueOf(i5))) {
                taskCompletionSource.setResult(null);
            }
            this.f7311k.remove(Integer.valueOf(i5));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void A(a1 a1Var) {
        h("stopListeningToRemoteStore");
        c1 c1Var = this.f7303c.get(a1Var);
        z1.b.d(c1Var != null, "Trying to stop listening to a query not found", new Object[0]);
        int b5 = c1Var.b();
        List<a1> list = this.f7304d.get(Integer.valueOf(b5));
        list.remove(a1Var);
        if (list.isEmpty()) {
            this.f7302b.T(b5);
        }
    }

    public <TResult> Task<TResult> C(z1.g gVar, com.google.firebase.firestore.h1 h1Var, z1.u<j1, Task<TResult>> uVar) {
        return new n1(gVar, this.f7302b, h1Var, uVar).i();
    }

    public void E(List<w1.f> list, TaskCompletionSource<Void> taskCompletionSource) {
        h("writeMutations");
        u1.m p02 = this.f7301a.p0(list);
        g(p02.b(), taskCompletionSource);
        i(p02.c(), null);
        this.f7302b.u();
    }

    @Override // y1.s0.c
    public void a(y0 y0Var) {
        h("handleOnlineStateChange");
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<a1, c1> entry : this.f7303c.entrySet()) {
            w1 e5 = entry.getValue().c().e(y0Var);
            z1.b.d(e5.a().isEmpty(), "OnlineState should not affect limbo documents.", new Object[0]);
            if (e5.b() != null) {
                arrayList.add(e5.b());
            }
        }
        this.f7314n.c(arrayList);
        this.f7314n.a(y0Var);
    }

    @Override // y1.s0.c
    public m1.e<v1.l> b(int i5) {
        b bVar = this.f7308h.get(Integer.valueOf(i5));
        if (bVar == null || !bVar.f7317b) {
            m1.e<v1.l> e5 = v1.l.e();
            if (this.f7304d.containsKey(Integer.valueOf(i5))) {
                for (a1 a1Var : this.f7304d.get(Integer.valueOf(i5))) {
                    if (this.f7303c.containsKey(a1Var)) {
                        e5 = e5.m(this.f7303c.get(a1Var).c().k());
                    }
                }
            }
            return e5;
        }
        return v1.l.e().i(bVar.f7316a);
    }

    @Override // y1.s0.c
    public void c(int i5, i3.j1 j1Var) {
        h("handleRejectedWrite");
        m1.c<v1.l, v1.i> i02 = this.f7301a.i0(i5);
        if (!i02.isEmpty()) {
            q(j1Var, "Write failed at %s", i02.l().q());
        }
        r(i5, j1Var);
        w(i5);
        i(i02, null);
    }

    @Override // y1.s0.c
    public void d(int i5, i3.j1 j1Var) {
        h("handleRejectedListen");
        b bVar = this.f7308h.get(Integer.valueOf(i5));
        v1.l lVar = bVar != null ? bVar.f7316a : null;
        if (lVar == null) {
            this.f7301a.j0(i5);
            u(i5, j1Var);
            return;
        }
        this.f7307g.remove(lVar);
        this.f7308h.remove(Integer.valueOf(i5));
        s();
        v1.w wVar = v1.w.f8154b;
        e(new y1.n0(wVar, Collections.emptyMap(), Collections.emptyMap(), Collections.singletonMap(lVar, v1.s.r(lVar, wVar)), Collections.singleton(lVar)));
    }

    @Override // y1.s0.c
    public void e(y1.n0 n0Var) {
        h("handleRemoteEvent");
        for (Map.Entry<Integer, y1.v0> entry : n0Var.d().entrySet()) {
            y1.v0 value = entry.getValue();
            b bVar = this.f7308h.get(entry.getKey());
            if (bVar != null) {
                z1.b.d((value.b().size() + value.c().size()) + value.d().size() <= 1, "Limbo resolution for single document contains multiple changes.", new Object[0]);
                if (value.b().size() > 0) {
                    bVar.f7317b = true;
                } else if (value.c().size() > 0) {
                    z1.b.d(bVar.f7317b, "Received change for limbo target document without add.", new Object[0]);
                } else if (value.d().size() > 0) {
                    z1.b.d(bVar.f7317b, "Received remove for limbo target document without add.", new Object[0]);
                    bVar.f7317b = false;
                }
            }
        }
        i(this.f7301a.w(n0Var), n0Var);
    }

    @Override // y1.s0.c
    public void f(w1.h hVar) {
        h("handleSuccessfulWrite");
        r(hVar.b().e(), null);
        w(hVar.b().e());
        i(this.f7301a.u(hVar), null);
    }

    public void l(q1.j jVar) {
        boolean z4 = !this.f7313m.equals(jVar);
        this.f7313m = jVar;
        if (z4) {
            k();
            i(this.f7301a.K(jVar), null);
        }
        this.f7302b.v();
    }

    public int n(a1 a1Var, boolean z4) {
        h("listen");
        z1.b.d(!this.f7303c.containsKey(a1Var), "We already listen to query: %s", a1Var);
        i4 v5 = this.f7301a.v(a1Var.D());
        this.f7314n.c(Collections.singletonList(m(a1Var, v5.h(), v5.d())));
        if (z4) {
            this.f7302b.G(v5);
        }
        return v5.h();
    }

    public void o(a1 a1Var) {
        h("listenToRemoteStore");
        z1.b.d(this.f7303c.containsKey(a1Var), "This is the first listen to query: %s", a1Var);
        this.f7302b.G(this.f7301a.v(a1Var.D()));
    }

    public void p(r1.f fVar, com.google.firebase.firestore.i0 i0Var) {
        try {
            try {
                r1.e d5 = fVar.d();
                if (this.f7301a.L(d5)) {
                    i0Var.e(com.google.firebase.firestore.j0.b(d5));
                    try {
                        fVar.b();
                        return;
                    } catch (IOException e5) {
                        z1.w.e("SyncEngine", "Exception while closing bundle", e5);
                        return;
                    }
                }
                i0Var.f(com.google.firebase.firestore.j0.a(d5));
                r1.d dVar = new r1.d(this.f7301a, d5);
                long j5 = 0;
                while (true) {
                    r1.c f5 = fVar.f();
                    if (f5 == null) {
                        i(dVar.b(), null);
                        this.f7301a.b(d5);
                        i0Var.e(com.google.firebase.firestore.j0.b(d5));
                        try {
                            fVar.b();
                            return;
                        } catch (IOException e6) {
                            z1.w.e("SyncEngine", "Exception while closing bundle", e6);
                            return;
                        }
                    }
                    long e7 = fVar.e();
                    com.google.firebase.firestore.j0 a5 = dVar.a(f5, e7 - j5);
                    if (a5 != null) {
                        i0Var.f(a5);
                    }
                    j5 = e7;
                }
            } catch (Exception e8) {
                z1.w.e("Firestore", "Loading bundle failed : %s", e8);
                i0Var.d(new com.google.firebase.firestore.z("Bundle failed to load", z.a.INVALID_ARGUMENT, e8));
                try {
                    fVar.b();
                } catch (IOException e9) {
                    z1.w.e("SyncEngine", "Exception while closing bundle", e9);
                }
            }
        } catch (Throwable th) {
            try {
                fVar.b();
            } catch (IOException e10) {
                z1.w.e("SyncEngine", "Exception while closing bundle", e10);
            }
            throw th;
        }
    }

    public void t(TaskCompletionSource<Void> taskCompletionSource) {
        if (!this.f7302b.o()) {
            z1.w.a(f7300o, "The network is disabled. The task returned by 'awaitPendingWrites()' will not complete until the network is enabled.", new Object[0]);
        }
        int B = this.f7301a.B();
        if (B == -1) {
            taskCompletionSource.setResult(null);
            return;
        }
        if (!this.f7311k.containsKey(Integer.valueOf(B))) {
            this.f7311k.put(Integer.valueOf(B), new ArrayList());
        }
        this.f7311k.get(Integer.valueOf(B)).add(taskCompletionSource);
    }

    public Task<Map<String, i2.d0>> x(a1 a1Var, List<com.google.firebase.firestore.a> list) {
        return this.f7302b.K(a1Var, list);
    }

    public void y(c cVar) {
        this.f7314n = cVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void z(a1 a1Var, boolean z4) {
        h("stopListening");
        c1 c1Var = this.f7303c.get(a1Var);
        z1.b.d(c1Var != null, "Trying to stop listening to a query not found", new Object[0]);
        this.f7303c.remove(a1Var);
        int b5 = c1Var.b();
        List<a1> list = this.f7304d.get(Integer.valueOf(b5));
        list.remove(a1Var);
        if (list.isEmpty()) {
            this.f7301a.j0(b5);
            if (z4) {
                this.f7302b.T(b5);
            }
            u(b5, i3.j1.f3432f);
        }
    }
}
