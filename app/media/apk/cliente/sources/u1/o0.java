package u1;

import android.util.SparseArray;
import java.util.Comparator;
import java.util.Locale;
import java.util.PriorityQueue;
import java.util.concurrent.TimeUnit;
import u1.o0;
import z1.g;
/* loaded from: classes.dex */
public class o0 {

    /* renamed from: c  reason: collision with root package name */
    private static final long f7935c;

    /* renamed from: d  reason: collision with root package name */
    private static final long f7936d;

    /* renamed from: a  reason: collision with root package name */
    private final k0 f7937a;

    /* renamed from: b  reason: collision with root package name */
    private final b f7938b;

    /* loaded from: classes.dex */
    public class a implements g4 {

        /* renamed from: a  reason: collision with root package name */
        private final z1.g f7939a;

        /* renamed from: b  reason: collision with root package name */
        private final i0 f7940b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f7941c = false;

        /* renamed from: d  reason: collision with root package name */
        private g.b f7942d;

        public a(z1.g gVar, i0 i0Var) {
            this.f7939a = gVar;
            this.f7940b = i0Var;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void c() {
            this.f7940b.y(o0.this);
            this.f7941c = true;
            d();
        }

        private void d() {
            this.f7942d = this.f7939a.k(g.d.GARBAGE_COLLECTION, this.f7941c ? o0.f7936d : o0.f7935c, new Runnable() { // from class: u1.n0
                @Override // java.lang.Runnable
                public final void run() {
                    o0.a.this.c();
                }
            });
        }

        @Override // u1.g4
        public void a() {
            g.b bVar = this.f7942d;
            if (bVar != null) {
                bVar.c();
            }
        }

        @Override // u1.g4
        public void start() {
            if (o0.this.f7938b.f7944a != -1) {
                d();
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        long f7944a;

        /* renamed from: b  reason: collision with root package name */
        int f7945b;

        /* renamed from: c  reason: collision with root package name */
        final int f7946c;

        b(long j5, int i5, int i6) {
            this.f7944a = j5;
            this.f7945b = i5;
            this.f7946c = i6;
        }

        public static b a(long j5) {
            return new b(j5, 10, 1000);
        }
    }

    /* loaded from: classes.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        private final boolean f7947a;

        /* renamed from: b  reason: collision with root package name */
        private final int f7948b;

        /* renamed from: c  reason: collision with root package name */
        private final int f7949c;

        /* renamed from: d  reason: collision with root package name */
        private final int f7950d;

        c(boolean z4, int i5, int i6, int i7) {
            this.f7947a = z4;
            this.f7948b = i5;
            this.f7949c = i6;
            this.f7950d = i7;
        }

        static c a() {
            return new c(false, 0, 0, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class d {

        /* renamed from: c  reason: collision with root package name */
        private static final Comparator<Long> f7951c = new Comparator() { // from class: u1.p0
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int d5;
                d5 = o0.d.d((Long) obj, (Long) obj2);
                return d5;
            }
        };

        /* renamed from: a  reason: collision with root package name */
        private final PriorityQueue<Long> f7952a;

        /* renamed from: b  reason: collision with root package name */
        private final int f7953b;

        d(int i5) {
            this.f7953b = i5;
            this.f7952a = new PriorityQueue<>(i5, f7951c);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ int d(Long l5, Long l6) {
            return l6.compareTo(l5);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void b(Long l5) {
            if (this.f7952a.size() >= this.f7953b) {
                if (l5.longValue() >= this.f7952a.peek().longValue()) {
                    return;
                }
                this.f7952a.poll();
            }
            this.f7952a.add(l5);
        }

        long c() {
            return this.f7952a.peek().longValue();
        }
    }

    static {
        TimeUnit timeUnit = TimeUnit.MINUTES;
        f7935c = timeUnit.toMillis(1L);
        f7936d = timeUnit.toMillis(5L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public o0(k0 k0Var, b bVar) {
        this.f7937a = k0Var;
        this.f7938b = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void i(d dVar, i4 i4Var) {
        dVar.b(Long.valueOf(i4Var.e()));
    }

    private c m(SparseArray<?> sparseArray) {
        Locale locale;
        long currentTimeMillis = System.currentTimeMillis();
        int e5 = e(this.f7938b.f7945b);
        if (e5 > this.f7938b.f7946c) {
            z1.w.a("LruGarbageCollector", "Capping sequence numbers to collect down to the maximum of " + this.f7938b.f7946c + " from " + e5, new Object[0]);
            e5 = this.f7938b.f7946c;
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        long h5 = h(e5);
        long currentTimeMillis3 = System.currentTimeMillis();
        int l5 = l(h5, sparseArray);
        long currentTimeMillis4 = System.currentTimeMillis();
        int k5 = k(h5);
        long currentTimeMillis5 = System.currentTimeMillis();
        if (z1.w.c()) {
            StringBuilder sb = new StringBuilder();
            sb.append("LRU Garbage Collection:\n\tCounted targets in " + (currentTimeMillis2 - currentTimeMillis) + "ms\n");
            sb.append(String.format(Locale.ROOT, "\tDetermined least recently used %d sequence numbers in %dms\n", Integer.valueOf(e5), Long.valueOf(currentTimeMillis3 - currentTimeMillis2)));
            z1.w.a("LruGarbageCollector", ((sb.toString() + String.format(locale, "\tRemoved %d targets in %dms\n", Integer.valueOf(l5), Long.valueOf(currentTimeMillis4 - currentTimeMillis3))) + String.format(locale, "\tRemoved %d documents in %dms\n", Integer.valueOf(k5), Long.valueOf(currentTimeMillis5 - currentTimeMillis4))) + String.format(locale, "Total Duration: %dms", Long.valueOf(currentTimeMillis5 - currentTimeMillis)), new Object[0]);
        }
        return new c(true, e5, l5, k5);
    }

    int e(int i5) {
        return (int) ((i5 / 100.0f) * ((float) this.f7937a.a()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c f(SparseArray<?> sparseArray) {
        if (this.f7938b.f7944a == -1) {
            z1.w.a("LruGarbageCollector", "Garbage collection skipped; disabled", new Object[0]);
        } else {
            long g5 = g();
            if (g5 >= this.f7938b.f7944a) {
                return m(sparseArray);
            }
            z1.w.a("LruGarbageCollector", "Garbage collection skipped; Cache size " + g5 + " is lower than threshold " + this.f7938b.f7944a, new Object[0]);
        }
        return c.a();
    }

    long g() {
        return this.f7937a.k();
    }

    long h(int i5) {
        if (i5 == 0) {
            return -1L;
        }
        final d dVar = new d(i5);
        this.f7937a.l(new z1.n() { // from class: u1.l0
            @Override // z1.n
            public final void accept(Object obj) {
                o0.i(o0.d.this, (i4) obj);
            }
        });
        this.f7937a.h(new z1.n() { // from class: u1.m0
            @Override // z1.n
            public final void accept(Object obj) {
                o0.d.this.b((Long) obj);
            }
        });
        return dVar.c();
    }

    public a j(z1.g gVar, i0 i0Var) {
        return new a(gVar, i0Var);
    }

    int k(long j5) {
        return this.f7937a.d(j5);
    }

    int l(long j5, SparseArray<?> sparseArray) {
        return this.f7937a.b(j5, sparseArray);
    }
}
