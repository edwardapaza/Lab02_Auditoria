package u1;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import u1.k;
import v1.q;
import z1.g;
/* loaded from: classes.dex */
public class k {

    /* renamed from: f  reason: collision with root package name */
    private static final long f7893f = TimeUnit.SECONDS.toMillis(15);

    /* renamed from: g  reason: collision with root package name */
    private static final long f7894g = TimeUnit.MINUTES.toMillis(1);

    /* renamed from: a  reason: collision with root package name */
    private final a f7895a;

    /* renamed from: b  reason: collision with root package name */
    private final e1 f7896b;

    /* renamed from: c  reason: collision with root package name */
    private final z0.o<l> f7897c;

    /* renamed from: d  reason: collision with root package name */
    private final z0.o<n> f7898d;

    /* renamed from: e  reason: collision with root package name */
    private int f7899e;

    /* loaded from: classes.dex */
    public class a implements g4 {

        /* renamed from: a  reason: collision with root package name */
        private g.b f7900a;

        /* renamed from: b  reason: collision with root package name */
        private final z1.g f7901b;

        public a(z1.g gVar) {
            this.f7901b = gVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void c() {
            z1.w.a("IndexBackfiller", "Documents written: %s", Integer.valueOf(k.this.d()));
            d(k.f7894g);
        }

        private void d(long j5) {
            this.f7900a = this.f7901b.k(g.d.INDEX_BACKFILL, j5, new Runnable() { // from class: u1.j
                @Override // java.lang.Runnable
                public final void run() {
                    k.a.this.c();
                }
            });
        }

        @Override // u1.g4
        public void a() {
            g.b bVar = this.f7900a;
            if (bVar != null) {
                bVar.c();
            }
        }

        @Override // u1.g4
        public void start() {
            d(k.f7893f);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public k(e1 e1Var, z1.g gVar, final i0 i0Var) {
        this(e1Var, gVar, new z0.o() { // from class: u1.g
            @Override // z0.o
            public final Object get() {
                return i0.this.C();
            }
        }, new z0.o() { // from class: u1.h
            @Override // z0.o
            public final Object get() {
                return i0.this.G();
            }
        });
        Objects.requireNonNull(i0Var);
    }

    public k(e1 e1Var, z1.g gVar, z0.o<l> oVar, z0.o<n> oVar2) {
        this.f7899e = 50;
        this.f7896b = e1Var;
        this.f7895a = new a(gVar);
        this.f7897c = oVar;
        this.f7898d = oVar2;
    }

    private q.a e(q.a aVar, m mVar) {
        Iterator<Map.Entry<v1.l, v1.i>> it = mVar.c().iterator();
        q.a aVar2 = aVar;
        while (it.hasNext()) {
            q.a h5 = q.a.h(it.next().getValue());
            if (h5.compareTo(aVar2) > 0) {
                aVar2 = h5;
            }
        }
        return q.a.d(aVar2.n(), aVar2.k(), Math.max(mVar.b(), aVar.m()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Integer g() {
        return Integer.valueOf(i());
    }

    private int h(String str, int i5) {
        l lVar = this.f7897c.get();
        q.a g5 = lVar.g(str);
        m k5 = this.f7898d.get().k(str, g5, i5);
        lVar.a(k5.c());
        q.a e5 = e(g5, k5);
        z1.w.a("IndexBackfiller", "Updating offset: %s", e5);
        lVar.d(str, e5);
        return k5.c().size();
    }

    private int i() {
        l lVar = this.f7897c.get();
        HashSet hashSet = new HashSet();
        int i5 = this.f7899e;
        while (i5 > 0) {
            String m5 = lVar.m();
            if (m5 == null || hashSet.contains(m5)) {
                break;
            }
            z1.w.a("IndexBackfiller", "Processing collection: %s", m5);
            i5 -= h(m5, i5);
            hashSet.add(m5);
        }
        return this.f7899e - i5;
    }

    public int d() {
        return ((Integer) this.f7896b.j("Backfill Indexes", new z1.z() { // from class: u1.i
            @Override // z1.z
            public final Object get() {
                Integer g5;
                g5 = k.this.g();
                return g5;
            }
        })).intValue();
    }

    public a f() {
        return this.f7895a;
    }
}
