package androidx.lifecycle;
/* loaded from: classes.dex */
public abstract class q<T> {

    /* renamed from: k  reason: collision with root package name */
    static final Object f580k = new Object();

    /* renamed from: a  reason: collision with root package name */
    final Object f581a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private f.b<t<? super T>, q<T>.d> f582b = new f.b<>();

    /* renamed from: c  reason: collision with root package name */
    int f583c = 0;

    /* renamed from: d  reason: collision with root package name */
    private boolean f584d;

    /* renamed from: e  reason: collision with root package name */
    private volatile Object f585e;

    /* renamed from: f  reason: collision with root package name */
    volatile Object f586f;

    /* renamed from: g  reason: collision with root package name */
    private int f587g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f588h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f589i;

    /* renamed from: j  reason: collision with root package name */
    private final Runnable f590j;

    /* loaded from: classes.dex */
    class a implements Runnable {
        a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            Object obj;
            synchronized (q.this.f581a) {
                obj = q.this.f586f;
                q.this.f586f = q.f580k;
            }
            q.this.i(obj);
        }
    }

    /* loaded from: classes.dex */
    private class b extends q<T>.d {
        b(t<? super T> tVar) {
            super(tVar);
        }

        @Override // androidx.lifecycle.q.d
        boolean j() {
            return true;
        }
    }

    /* loaded from: classes.dex */
    class c extends q<T>.d implements k {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public abstract class d {

        /* renamed from: a  reason: collision with root package name */
        final t<? super T> f593a;

        /* renamed from: b  reason: collision with root package name */
        boolean f594b;

        /* renamed from: c  reason: collision with root package name */
        int f595c = -1;

        d(t<? super T> tVar) {
            this.f593a = tVar;
        }

        void h(boolean z4) {
            if (z4 == this.f594b) {
                return;
            }
            this.f594b = z4;
            q.this.b(z4 ? 1 : -1);
            if (this.f594b) {
                q.this.d(this);
            }
        }

        void i() {
        }

        abstract boolean j();
    }

    public q() {
        Object obj = f580k;
        this.f586f = obj;
        this.f590j = new a();
        this.f585e = obj;
        this.f587g = -1;
    }

    static void a(String str) {
        if (e.c.f().b()) {
            return;
        }
        throw new IllegalStateException("Cannot invoke " + str + " on a background thread");
    }

    private void c(q<T>.d dVar) {
        if (dVar.f594b) {
            if (!dVar.j()) {
                dVar.h(false);
                return;
            }
            int i5 = dVar.f595c;
            int i6 = this.f587g;
            if (i5 >= i6) {
                return;
            }
            dVar.f595c = i6;
            dVar.f593a.a((Object) this.f585e);
        }
    }

    void b(int i5) {
        int i6 = this.f583c;
        this.f583c = i5 + i6;
        if (this.f584d) {
            return;
        }
        this.f584d = true;
        while (true) {
            try {
                int i7 = this.f583c;
                if (i6 == i7) {
                    return;
                }
                boolean z4 = i6 == 0 && i7 > 0;
                boolean z5 = i6 > 0 && i7 == 0;
                if (z4) {
                    f();
                } else if (z5) {
                    g();
                }
                i6 = i7;
            } finally {
                this.f584d = false;
            }
        }
    }

    void d(q<T>.d dVar) {
        if (this.f588h) {
            this.f589i = true;
            return;
        }
        this.f588h = true;
        do {
            this.f589i = false;
            if (dVar == null) {
                f.b<t<? super T>, q<T>.d>.d i5 = this.f582b.i();
                while (i5.hasNext()) {
                    c((d) i5.next().getValue());
                    if (this.f589i) {
                        break;
                    }
                }
            } else {
                c(dVar);
                dVar = null;
            }
        } while (this.f589i);
        this.f588h = false;
    }

    public void e(t<? super T> tVar) {
        a("observeForever");
        b bVar = new b(tVar);
        q<T>.d m5 = this.f582b.m(tVar, bVar);
        if (m5 instanceof c) {
            throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
        }
        if (m5 != null) {
            return;
        }
        bVar.h(true);
    }

    protected void f() {
    }

    protected void g() {
    }

    public void h(t<? super T> tVar) {
        a("removeObserver");
        q<T>.d n5 = this.f582b.n(tVar);
        if (n5 == null) {
            return;
        }
        n5.i();
        n5.h(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void i(T t5) {
        a("setValue");
        this.f587g++;
        this.f585e = t5;
        d(null);
    }
}
