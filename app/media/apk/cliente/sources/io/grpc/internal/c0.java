package io.grpc.internal;

import i3.r0;
import io.grpc.internal.m1;
import io.grpc.internal.t;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.concurrent.Executor;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class c0 implements m1 {

    /* renamed from: c  reason: collision with root package name */
    private final Executor f4581c;

    /* renamed from: d  reason: collision with root package name */
    private final i3.n1 f4582d;

    /* renamed from: e  reason: collision with root package name */
    private Runnable f4583e;

    /* renamed from: f  reason: collision with root package name */
    private Runnable f4584f;

    /* renamed from: g  reason: collision with root package name */
    private Runnable f4585g;

    /* renamed from: h  reason: collision with root package name */
    private m1.a f4586h;

    /* renamed from: j  reason: collision with root package name */
    private i3.j1 f4588j;

    /* renamed from: k  reason: collision with root package name */
    private r0.i f4589k;

    /* renamed from: l  reason: collision with root package name */
    private long f4590l;

    /* renamed from: a  reason: collision with root package name */
    private final i3.j0 f4579a = i3.j0.a(c0.class, null);

    /* renamed from: b  reason: collision with root package name */
    private final Object f4580b = new Object();

    /* renamed from: i  reason: collision with root package name */
    private Collection<e> f4587i = new LinkedHashSet();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ m1.a f4591a;

        a(m1.a aVar) {
            this.f4591a = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f4591a.b(true);
        }
    }

    /* loaded from: classes.dex */
    class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ m1.a f4593a;

        b(m1.a aVar) {
            this.f4593a = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f4593a.b(false);
        }
    }

    /* loaded from: classes.dex */
    class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ m1.a f4595a;

        c(m1.a aVar) {
            this.f4595a = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f4595a.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class d implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ i3.j1 f4597a;

        d(i3.j1 j1Var) {
            this.f4597a = j1Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            c0.this.f4586h.d(this.f4597a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class e extends d0 {

        /* renamed from: j  reason: collision with root package name */
        private final r0.f f4599j;

        /* renamed from: k  reason: collision with root package name */
        private final i3.r f4600k;

        /* renamed from: l  reason: collision with root package name */
        private final i3.k[] f4601l;

        private e(r0.f fVar, i3.k[] kVarArr) {
            this.f4600k = i3.r.e();
            this.f4599j = fVar;
            this.f4601l = kVarArr;
        }

        /* synthetic */ e(c0 c0Var, r0.f fVar, i3.k[] kVarArr, a aVar) {
            this(fVar, kVarArr);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Runnable A(u uVar) {
            i3.r b5 = this.f4600k.b();
            try {
                s c5 = uVar.c(this.f4599j.c(), this.f4599j.b(), this.f4599j.a(), this.f4601l);
                this.f4600k.f(b5);
                return w(c5);
            } catch (Throwable th) {
                this.f4600k.f(b5);
                throw th;
            }
        }

        @Override // io.grpc.internal.d0, io.grpc.internal.s
        public void a(i3.j1 j1Var) {
            super.a(j1Var);
            synchronized (c0.this.f4580b) {
                if (c0.this.f4585g != null) {
                    boolean remove = c0.this.f4587i.remove(this);
                    if (!c0.this.q() && remove) {
                        c0.this.f4582d.b(c0.this.f4584f);
                        if (c0.this.f4588j != null) {
                            c0.this.f4582d.b(c0.this.f4585g);
                            c0.this.f4585g = null;
                        }
                    }
                }
            }
            c0.this.f4582d.a();
        }

        @Override // io.grpc.internal.d0, io.grpc.internal.s
        public void l(z0 z0Var) {
            if (this.f4599j.a().j()) {
                z0Var.a("wait_for_ready");
            }
            super.l(z0Var);
        }

        @Override // io.grpc.internal.d0
        protected void u(i3.j1 j1Var) {
            for (i3.k kVar : this.f4601l) {
                kVar.i(j1Var);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c0(Executor executor, i3.n1 n1Var) {
        this.f4581c = executor;
        this.f4582d = n1Var;
    }

    private e o(r0.f fVar, i3.k[] kVarArr) {
        e eVar = new e(this, fVar, kVarArr, null);
        this.f4587i.add(eVar);
        if (p() == 1) {
            this.f4582d.b(this.f4583e);
        }
        for (i3.k kVar : kVarArr) {
            kVar.j();
        }
        return eVar;
    }

    @Override // io.grpc.internal.m1
    public final Runnable b(m1.a aVar) {
        this.f4586h = aVar;
        this.f4583e = new a(aVar);
        this.f4584f = new b(aVar);
        this.f4585g = new c(aVar);
        return null;
    }

    @Override // io.grpc.internal.u
    public final s c(i3.z0<?, ?> z0Var, i3.y0 y0Var, i3.c cVar, i3.k[] kVarArr) {
        s h0Var;
        try {
            v1 v1Var = new v1(z0Var, y0Var, cVar);
            r0.i iVar = null;
            long j5 = -1;
            while (true) {
                synchronized (this.f4580b) {
                    if (this.f4588j == null) {
                        r0.i iVar2 = this.f4589k;
                        if (iVar2 != null) {
                            if (iVar != null && j5 == this.f4590l) {
                                h0Var = o(v1Var, kVarArr);
                                break;
                            }
                            j5 = this.f4590l;
                            u j6 = t0.j(iVar2.a(v1Var), cVar.j());
                            if (j6 != null) {
                                h0Var = j6.c(v1Var.c(), v1Var.b(), v1Var.a(), kVarArr);
                                break;
                            }
                            iVar = iVar2;
                        } else {
                            h0Var = o(v1Var, kVarArr);
                            break;
                        }
                    } else {
                        h0Var = new h0(this.f4588j, kVarArr);
                        break;
                    }
                }
            }
            return h0Var;
        } finally {
            this.f4582d.a();
        }
    }

    @Override // i3.p0
    public i3.j0 e() {
        return this.f4579a;
    }

    @Override // io.grpc.internal.m1
    public final void f(i3.j1 j1Var) {
        Runnable runnable;
        synchronized (this.f4580b) {
            if (this.f4588j != null) {
                return;
            }
            this.f4588j = j1Var;
            this.f4582d.b(new d(j1Var));
            if (!q() && (runnable = this.f4585g) != null) {
                this.f4582d.b(runnable);
                this.f4585g = null;
            }
            this.f4582d.a();
        }
    }

    @Override // io.grpc.internal.m1
    public final void h(i3.j1 j1Var) {
        Collection<e> collection;
        Runnable runnable;
        f(j1Var);
        synchronized (this.f4580b) {
            collection = this.f4587i;
            runnable = this.f4585g;
            this.f4585g = null;
            if (!collection.isEmpty()) {
                this.f4587i = Collections.emptyList();
            }
        }
        if (runnable != null) {
            for (e eVar : collection) {
                Runnable w5 = eVar.w(new h0(j1Var, t.a.REFUSED, eVar.f4601l));
                if (w5 != null) {
                    w5.run();
                }
            }
            this.f4582d.execute(runnable);
        }
    }

    final int p() {
        int size;
        synchronized (this.f4580b) {
            size = this.f4587i.size();
        }
        return size;
    }

    public final boolean q() {
        boolean z4;
        synchronized (this.f4580b) {
            z4 = !this.f4587i.isEmpty();
        }
        return z4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void r(r0.i iVar) {
        Runnable runnable;
        synchronized (this.f4580b) {
            this.f4589k = iVar;
            this.f4590l++;
            if (iVar != null && q()) {
                ArrayList arrayList = new ArrayList(this.f4587i);
                ArrayList arrayList2 = new ArrayList();
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    e eVar = (e) it.next();
                    r0.e a5 = iVar.a(eVar.f4599j);
                    i3.c a6 = eVar.f4599j.a();
                    u j5 = t0.j(a5, a6.j());
                    if (j5 != null) {
                        Executor executor = this.f4581c;
                        if (a6.e() != null) {
                            executor = a6.e();
                        }
                        Runnable A = eVar.A(j5);
                        if (A != null) {
                            executor.execute(A);
                        }
                        arrayList2.add(eVar);
                    }
                }
                synchronized (this.f4580b) {
                    if (q()) {
                        this.f4587i.removeAll(arrayList2);
                        if (this.f4587i.isEmpty()) {
                            this.f4587i = new LinkedHashSet();
                        }
                        if (!q()) {
                            this.f4582d.b(this.f4584f);
                            if (this.f4588j != null && (runnable = this.f4585g) != null) {
                                this.f4582d.b(runnable);
                                this.f4585g = null;
                            }
                        }
                        this.f4582d.a();
                    }
                }
            }
        }
    }
}
