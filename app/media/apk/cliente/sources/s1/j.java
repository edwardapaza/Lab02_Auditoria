package s1;

import android.content.Context;
import u1.g4;
/* loaded from: classes.dex */
public abstract class j {

    /* renamed from: a  reason: collision with root package name */
    private u1.e1 f7344a;

    /* renamed from: b  reason: collision with root package name */
    private u1.i0 f7345b;

    /* renamed from: c  reason: collision with root package name */
    private e1 f7346c;

    /* renamed from: d  reason: collision with root package name */
    private y1.s0 f7347d;

    /* renamed from: e  reason: collision with root package name */
    private o f7348e;

    /* renamed from: f  reason: collision with root package name */
    private y1.o f7349f;

    /* renamed from: g  reason: collision with root package name */
    private u1.k f7350g;

    /* renamed from: h  reason: collision with root package name */
    private g4 f7351h;

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private final Context f7352a;

        /* renamed from: b  reason: collision with root package name */
        private final z1.g f7353b;

        /* renamed from: c  reason: collision with root package name */
        private final l f7354c;

        /* renamed from: d  reason: collision with root package name */
        private final y1.r f7355d;

        /* renamed from: e  reason: collision with root package name */
        private final q1.j f7356e;

        /* renamed from: f  reason: collision with root package name */
        private final int f7357f;

        /* renamed from: g  reason: collision with root package name */
        private final com.google.firebase.firestore.a0 f7358g;

        public a(Context context, z1.g gVar, l lVar, y1.r rVar, q1.j jVar, int i5, com.google.firebase.firestore.a0 a0Var) {
            this.f7352a = context;
            this.f7353b = gVar;
            this.f7354c = lVar;
            this.f7355d = rVar;
            this.f7356e = jVar;
            this.f7357f = i5;
            this.f7358g = a0Var;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public z1.g a() {
            return this.f7353b;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Context b() {
            return this.f7352a;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public l c() {
            return this.f7354c;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public y1.r d() {
            return this.f7355d;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public q1.j e() {
            return this.f7356e;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public int f() {
            return this.f7357f;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public com.google.firebase.firestore.a0 g() {
            return this.f7358g;
        }
    }

    protected abstract y1.o a(a aVar);

    protected abstract o b(a aVar);

    protected abstract g4 c(a aVar);

    protected abstract u1.k d(a aVar);

    protected abstract u1.i0 e(a aVar);

    protected abstract u1.e1 f(a aVar);

    protected abstract y1.s0 g(a aVar);

    protected abstract e1 h(a aVar);

    /* JADX INFO: Access modifiers changed from: protected */
    public y1.o i() {
        return (y1.o) z1.b.e(this.f7349f, "connectivityMonitor not initialized yet", new Object[0]);
    }

    public o j() {
        return (o) z1.b.e(this.f7348e, "eventManager not initialized yet", new Object[0]);
    }

    public g4 k() {
        return this.f7351h;
    }

    public u1.k l() {
        return this.f7350g;
    }

    public u1.i0 m() {
        return (u1.i0) z1.b.e(this.f7345b, "localStore not initialized yet", new Object[0]);
    }

    public u1.e1 n() {
        return (u1.e1) z1.b.e(this.f7344a, "persistence not initialized yet", new Object[0]);
    }

    public y1.s0 o() {
        return (y1.s0) z1.b.e(this.f7347d, "remoteStore not initialized yet", new Object[0]);
    }

    public e1 p() {
        return (e1) z1.b.e(this.f7346c, "syncEngine not initialized yet", new Object[0]);
    }

    public void q(a aVar) {
        u1.e1 f5 = f(aVar);
        this.f7344a = f5;
        f5.m();
        this.f7345b = e(aVar);
        this.f7349f = a(aVar);
        this.f7347d = g(aVar);
        this.f7346c = h(aVar);
        this.f7348e = b(aVar);
        this.f7345b.m0();
        this.f7347d.Q();
        this.f7351h = c(aVar);
        this.f7350g = d(aVar);
    }
}
