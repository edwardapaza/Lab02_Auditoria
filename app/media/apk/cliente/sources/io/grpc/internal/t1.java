package io.grpc.internal;

import i3.r0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
final class t1 extends i3.r0 {

    /* renamed from: c  reason: collision with root package name */
    private final r0.d f5218c;

    /* renamed from: d  reason: collision with root package name */
    private r0.h f5219d;

    /* renamed from: e  reason: collision with root package name */
    private i3.p f5220e = i3.p.IDLE;

    /* loaded from: classes.dex */
    class a implements r0.j {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ r0.h f5221a;

        a(r0.h hVar) {
            this.f5221a = hVar;
        }

        @Override // i3.r0.j
        public void a(i3.q qVar) {
            t1.this.i(this.f5221a, qVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f5223a;

        static {
            int[] iArr = new int[i3.p.values().length];
            f5223a = iArr;
            try {
                iArr[i3.p.IDLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f5223a[i3.p.CONNECTING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f5223a[i3.p.READY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f5223a[i3.p.TRANSIENT_FAILURE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        public final Boolean f5224a;

        /* renamed from: b  reason: collision with root package name */
        final Long f5225b;

        public c(Boolean bool) {
            this(bool, null);
        }

        c(Boolean bool, Long l5) {
            this.f5224a = bool;
            this.f5225b = l5;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class d extends r0.i {

        /* renamed from: a  reason: collision with root package name */
        private final r0.e f5226a;

        d(r0.e eVar) {
            this.f5226a = (r0.e) z0.k.o(eVar, "result");
        }

        @Override // i3.r0.i
        public r0.e a(r0.f fVar) {
            return this.f5226a;
        }

        public String toString() {
            return z0.f.a(d.class).d("result", this.f5226a).toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public final class e extends r0.i {

        /* renamed from: a  reason: collision with root package name */
        private final r0.h f5227a;

        /* renamed from: b  reason: collision with root package name */
        private final AtomicBoolean f5228b = new AtomicBoolean(false);

        /* loaded from: classes.dex */
        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                e.this.f5227a.f();
            }
        }

        e(r0.h hVar) {
            this.f5227a = (r0.h) z0.k.o(hVar, "subchannel");
        }

        @Override // i3.r0.i
        public r0.e a(r0.f fVar) {
            if (this.f5228b.compareAndSet(false, true)) {
                t1.this.f5218c.d().execute(new a());
            }
            return r0.e.g();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public t1(r0.d dVar) {
        this.f5218c = (r0.d) z0.k.o(dVar, "helper");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(r0.h hVar, i3.q qVar) {
        r0.i eVar;
        r0.i iVar;
        i3.p c5 = qVar.c();
        if (c5 == i3.p.SHUTDOWN) {
            return;
        }
        i3.p pVar = i3.p.TRANSIENT_FAILURE;
        if (c5 == pVar || c5 == i3.p.IDLE) {
            this.f5218c.e();
        }
        if (this.f5220e == pVar) {
            if (c5 == i3.p.CONNECTING) {
                return;
            }
            if (c5 == i3.p.IDLE) {
                e();
                return;
            }
        }
        int i5 = b.f5223a[c5.ordinal()];
        if (i5 != 1) {
            if (i5 == 2) {
                iVar = new d(r0.e.g());
            } else if (i5 == 3) {
                eVar = new d(r0.e.h(hVar));
            } else if (i5 != 4) {
                throw new IllegalArgumentException("Unsupported state:" + c5);
            } else {
                iVar = new d(r0.e.f(qVar.d()));
            }
            j(c5, iVar);
        }
        eVar = new e(hVar);
        iVar = eVar;
        j(c5, iVar);
    }

    private void j(i3.p pVar, r0.i iVar) {
        this.f5220e = pVar;
        this.f5218c.f(pVar, iVar);
    }

    @Override // i3.r0
    public boolean a(r0.g gVar) {
        c cVar;
        Boolean bool;
        List<i3.x> a5 = gVar.a();
        if (a5.isEmpty()) {
            i3.j1 j1Var = i3.j1.f3447u;
            c(j1Var.q("NameResolver returned no usable address. addrs=" + gVar.a() + ", attrs=" + gVar.b()));
            return false;
        }
        if ((gVar.c() instanceof c) && (bool = (cVar = (c) gVar.c()).f5224a) != null && bool.booleanValue()) {
            ArrayList arrayList = new ArrayList(a5);
            Collections.shuffle(arrayList, cVar.f5225b != null ? new Random(cVar.f5225b.longValue()) : new Random());
            a5 = arrayList;
        }
        r0.h hVar = this.f5219d;
        if (hVar != null) {
            hVar.i(a5);
            return true;
        }
        r0.h a6 = this.f5218c.a(r0.b.c().e(a5).b());
        a6.h(new a(a6));
        this.f5219d = a6;
        j(i3.p.CONNECTING, new d(r0.e.h(a6)));
        a6.f();
        return true;
    }

    @Override // i3.r0
    public void c(i3.j1 j1Var) {
        r0.h hVar = this.f5219d;
        if (hVar != null) {
            hVar.g();
            this.f5219d = null;
        }
        j(i3.p.TRANSIENT_FAILURE, new d(r0.e.f(j1Var)));
    }

    @Override // i3.r0
    public void e() {
        r0.h hVar = this.f5219d;
        if (hVar != null) {
            hVar.f();
        }
    }

    @Override // i3.r0
    public void f() {
        r0.h hVar = this.f5219d;
        if (hVar != null) {
            hVar.g();
        }
    }
}
