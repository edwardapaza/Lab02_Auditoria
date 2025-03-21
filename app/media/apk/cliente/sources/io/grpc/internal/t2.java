package io.grpc.internal;
/* loaded from: classes.dex */
public final class t2 {

    /* renamed from: l  reason: collision with root package name */
    private static final b f5231l = new b(q2.f5109a);

    /* renamed from: a  reason: collision with root package name */
    private final q2 f5232a;

    /* renamed from: b  reason: collision with root package name */
    private long f5233b;

    /* renamed from: c  reason: collision with root package name */
    private long f5234c;

    /* renamed from: d  reason: collision with root package name */
    private long f5235d;

    /* renamed from: e  reason: collision with root package name */
    private long f5236e;

    /* renamed from: f  reason: collision with root package name */
    private long f5237f;

    /* renamed from: g  reason: collision with root package name */
    private c f5238g;

    /* renamed from: h  reason: collision with root package name */
    private long f5239h;

    /* renamed from: i  reason: collision with root package name */
    private long f5240i;

    /* renamed from: j  reason: collision with root package name */
    private final g1 f5241j;

    /* renamed from: k  reason: collision with root package name */
    private volatile long f5242k;

    /* loaded from: classes.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private final q2 f5243a;

        public b(q2 q2Var) {
            this.f5243a = q2Var;
        }

        public t2 a() {
            return new t2(this.f5243a);
        }
    }

    /* loaded from: classes.dex */
    public interface c {
    }

    public t2() {
        this.f5241j = h1.a();
        this.f5232a = q2.f5109a;
    }

    private t2(q2 q2Var) {
        this.f5241j = h1.a();
        this.f5232a = q2Var;
    }

    public static b a() {
        return f5231l;
    }

    public void b() {
        this.f5237f++;
    }

    public void c() {
        this.f5233b++;
        this.f5234c = this.f5232a.a();
    }

    public void d() {
        this.f5241j.add(1L);
        this.f5242k = this.f5232a.a();
    }

    public void e(int i5) {
        if (i5 == 0) {
            return;
        }
        this.f5239h += i5;
        this.f5240i = this.f5232a.a();
    }

    public void f(boolean z4) {
        if (z4) {
            this.f5235d++;
        } else {
            this.f5236e++;
        }
    }

    public void g(c cVar) {
        this.f5238g = (c) z0.k.n(cVar);
    }
}
