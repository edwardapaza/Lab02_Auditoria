package io.grpc.internal;

import io.grpc.internal.g;
import io.grpc.internal.n1;
import io.grpc.internal.p2;
import java.io.Closeable;
import java.io.InputStream;
/* loaded from: classes.dex */
public class f implements a0 {

    /* renamed from: a  reason: collision with root package name */
    private final n1.b f4736a;

    /* renamed from: b  reason: collision with root package name */
    private final io.grpc.internal.g f4737b;

    /* renamed from: c  reason: collision with root package name */
    private final n1 f4738c;

    /* loaded from: classes.dex */
    class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f4739a;

        a(int i5) {
            this.f4739a = i5;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (f.this.f4738c.isClosed()) {
                return;
            }
            try {
                f.this.f4738c.c(this.f4739a);
            } catch (Throwable th) {
                f.this.f4737b.b(th);
                f.this.f4738c.close();
            }
        }
    }

    /* loaded from: classes.dex */
    class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ x1 f4741a;

        b(x1 x1Var) {
            this.f4741a = x1Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                f.this.f4738c.i(this.f4741a);
            } catch (Throwable th) {
                f.this.f4737b.b(th);
                f.this.f4738c.close();
            }
        }
    }

    /* loaded from: classes.dex */
    class c implements Closeable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ x1 f4743a;

        c(x1 x1Var) {
            this.f4743a = x1Var;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.f4743a.close();
        }
    }

    /* loaded from: classes.dex */
    class d implements Runnable {
        d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            f.this.f4738c.h();
        }
    }

    /* loaded from: classes.dex */
    class e implements Runnable {
        e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            f.this.f4738c.close();
        }
    }

    /* renamed from: io.grpc.internal.f$f  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private class C0077f extends g implements Closeable {

        /* renamed from: d  reason: collision with root package name */
        private final Closeable f4747d;

        public C0077f(Runnable runnable, Closeable closeable) {
            super(f.this, runnable, null);
            this.f4747d = closeable;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.f4747d.close();
        }
    }

    /* loaded from: classes.dex */
    private class g implements p2.a {

        /* renamed from: a  reason: collision with root package name */
        private final Runnable f4749a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f4750b;

        private g(Runnable runnable) {
            this.f4750b = false;
            this.f4749a = runnable;
        }

        /* synthetic */ g(f fVar, Runnable runnable, a aVar) {
            this(runnable);
        }

        private void c() {
            if (this.f4750b) {
                return;
            }
            this.f4749a.run();
            this.f4750b = true;
        }

        @Override // io.grpc.internal.p2.a
        public InputStream next() {
            c();
            return f.this.f4737b.d();
        }
    }

    /* loaded from: classes.dex */
    interface h extends g.d {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(n1.b bVar, h hVar, n1 n1Var) {
        m2 m2Var = new m2((n1.b) z0.k.o(bVar, "listener"));
        this.f4736a = m2Var;
        io.grpc.internal.g gVar = new io.grpc.internal.g(m2Var, hVar);
        this.f4737b = gVar;
        n1Var.z(gVar);
        this.f4738c = n1Var;
    }

    @Override // io.grpc.internal.a0
    public void c(int i5) {
        this.f4736a.a(new g(this, new a(i5), null));
    }

    @Override // io.grpc.internal.a0
    public void close() {
        this.f4738c.A();
        this.f4736a.a(new g(this, new e(), null));
    }

    @Override // io.grpc.internal.a0
    public void d(int i5) {
        this.f4738c.d(i5);
    }

    @Override // io.grpc.internal.a0
    public void g(i3.u uVar) {
        this.f4738c.g(uVar);
    }

    @Override // io.grpc.internal.a0
    public void h() {
        this.f4736a.a(new g(this, new d(), null));
    }

    @Override // io.grpc.internal.a0
    public void i(x1 x1Var) {
        this.f4736a.a(new C0077f(new b(x1Var), new c(x1Var)));
    }
}
