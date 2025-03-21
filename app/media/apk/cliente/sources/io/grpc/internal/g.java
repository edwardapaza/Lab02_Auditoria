package io.grpc.internal;

import io.grpc.internal.n1;
import io.grpc.internal.p2;
import java.io.InputStream;
import java.util.ArrayDeque;
import java.util.Queue;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class g implements n1.b {

    /* renamed from: a  reason: collision with root package name */
    private final d f4757a;

    /* renamed from: b  reason: collision with root package name */
    private final n1.b f4758b;

    /* renamed from: c  reason: collision with root package name */
    private final Queue<InputStream> f4759c = new ArrayDeque();

    /* loaded from: classes.dex */
    class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f4760a;

        a(int i5) {
            this.f4760a = i5;
        }

        @Override // java.lang.Runnable
        public void run() {
            g.this.f4758b.f(this.f4760a);
        }
    }

    /* loaded from: classes.dex */
    class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ boolean f4762a;

        b(boolean z4) {
            this.f4762a = z4;
        }

        @Override // java.lang.Runnable
        public void run() {
            g.this.f4758b.e(this.f4762a);
        }
    }

    /* loaded from: classes.dex */
    class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Throwable f4764a;

        c(Throwable th) {
            this.f4764a = th;
        }

        @Override // java.lang.Runnable
        public void run() {
            g.this.f4758b.b(this.f4764a);
        }
    }

    /* loaded from: classes.dex */
    public interface d {
        void c(Runnable runnable);
    }

    public g(n1.b bVar, d dVar) {
        this.f4758b = (n1.b) z0.k.o(bVar, "listener");
        this.f4757a = (d) z0.k.o(dVar, "transportExecutor");
    }

    @Override // io.grpc.internal.n1.b
    public void a(p2.a aVar) {
        while (true) {
            InputStream next = aVar.next();
            if (next == null) {
                return;
            }
            this.f4759c.add(next);
        }
    }

    @Override // io.grpc.internal.n1.b
    public void b(Throwable th) {
        this.f4757a.c(new c(th));
    }

    public InputStream d() {
        return this.f4759c.poll();
    }

    @Override // io.grpc.internal.n1.b
    public void e(boolean z4) {
        this.f4757a.c(new b(z4));
    }

    @Override // io.grpc.internal.n1.b
    public void f(int i5) {
        this.f4757a.c(new a(i5));
    }
}
