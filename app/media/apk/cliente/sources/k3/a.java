package k3;

import io.grpc.internal.i2;
import java.io.IOException;
import java.net.Socket;
import k3.b;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class a implements w4.m {

    /* renamed from: c  reason: collision with root package name */
    private final i2 f5650c;

    /* renamed from: d  reason: collision with root package name */
    private final b.a f5651d;

    /* renamed from: e  reason: collision with root package name */
    private final int f5652e;

    /* renamed from: m  reason: collision with root package name */
    private w4.m f5656m;

    /* renamed from: n  reason: collision with root package name */
    private Socket f5657n;

    /* renamed from: o  reason: collision with root package name */
    private boolean f5658o;

    /* renamed from: p  reason: collision with root package name */
    private int f5659p;

    /* renamed from: q  reason: collision with root package name */
    private int f5660q;

    /* renamed from: a  reason: collision with root package name */
    private final Object f5648a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private final w4.c f5649b = new w4.c();

    /* renamed from: f  reason: collision with root package name */
    private boolean f5653f = false;

    /* renamed from: k  reason: collision with root package name */
    private boolean f5654k = false;

    /* renamed from: l  reason: collision with root package name */
    private boolean f5655l = false;

    /* renamed from: k3.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class C0084a extends e {

        /* renamed from: b  reason: collision with root package name */
        final r3.b f5661b;

        C0084a() {
            super(a.this, null);
            this.f5661b = r3.c.f();
        }

        @Override // k3.a.e
        public void a() {
            int i5;
            w4.c cVar = new w4.c();
            r3.e h5 = r3.c.h("WriteRunnable.runWrite");
            try {
                r3.c.e(this.f5661b);
                synchronized (a.this.f5648a) {
                    cVar.Z(a.this.f5649b, a.this.f5649b.l());
                    a.this.f5653f = false;
                    i5 = a.this.f5660q;
                }
                a.this.f5656m.Z(cVar, cVar.size());
                synchronized (a.this.f5648a) {
                    a.i(a.this, i5);
                }
                if (h5 != null) {
                    h5.close();
                }
            } catch (Throwable th) {
                if (h5 != null) {
                    try {
                        h5.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        }
    }

    /* loaded from: classes.dex */
    class b extends e {

        /* renamed from: b  reason: collision with root package name */
        final r3.b f5663b;

        b() {
            super(a.this, null);
            this.f5663b = r3.c.f();
        }

        @Override // k3.a.e
        public void a() {
            w4.c cVar = new w4.c();
            r3.e h5 = r3.c.h("WriteRunnable.runFlush");
            try {
                r3.c.e(this.f5663b);
                synchronized (a.this.f5648a) {
                    cVar.Z(a.this.f5649b, a.this.f5649b.size());
                    a.this.f5654k = false;
                }
                a.this.f5656m.Z(cVar, cVar.size());
                a.this.f5656m.flush();
                if (h5 != null) {
                    h5.close();
                }
            } catch (Throwable th) {
                if (h5 != null) {
                    try {
                        h5.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        }
    }

    /* loaded from: classes.dex */
    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (a.this.f5656m != null && a.this.f5649b.size() > 0) {
                    a.this.f5656m.Z(a.this.f5649b, a.this.f5649b.size());
                }
            } catch (IOException e5) {
                a.this.f5651d.d(e5);
            }
            a.this.f5649b.close();
            try {
                if (a.this.f5656m != null) {
                    a.this.f5656m.close();
                }
            } catch (IOException e6) {
                a.this.f5651d.d(e6);
            }
            try {
                if (a.this.f5657n != null) {
                    a.this.f5657n.close();
                }
            } catch (IOException e7) {
                a.this.f5651d.d(e7);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class d extends k3.c {
        public d(m3.c cVar) {
            super(cVar);
        }

        @Override // k3.c, m3.c
        public void H(m3.i iVar) {
            a.r(a.this);
            super.H(iVar);
        }

        @Override // k3.c, m3.c
        public void a(int i5, m3.a aVar) {
            a.r(a.this);
            super.a(i5, aVar);
        }

        @Override // k3.c, m3.c
        public void e(boolean z4, int i5, int i6) {
            if (z4) {
                a.r(a.this);
            }
            super.e(z4, i5, i6);
        }
    }

    /* loaded from: classes.dex */
    private abstract class e implements Runnable {
        private e() {
        }

        /* synthetic */ e(a aVar, C0084a c0084a) {
            this();
        }

        public abstract void a();

        @Override // java.lang.Runnable
        public final void run() {
            try {
                if (a.this.f5656m == null) {
                    throw new IOException("Unable to perform write due to unavailable sink.");
                }
                a();
            } catch (Exception e5) {
                a.this.f5651d.d(e5);
            }
        }
    }

    private a(i2 i2Var, b.a aVar, int i5) {
        this.f5650c = (i2) z0.k.o(i2Var, "executor");
        this.f5651d = (b.a) z0.k.o(aVar, "exceptionHandler");
        this.f5652e = i5;
    }

    static /* synthetic */ int i(a aVar, int i5) {
        int i6 = aVar.f5660q - i5;
        aVar.f5660q = i6;
        return i6;
    }

    static /* synthetic */ int r(a aVar) {
        int i5 = aVar.f5659p;
        aVar.f5659p = i5 + 1;
        return i5;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a w(i2 i2Var, b.a aVar, int i5) {
        return new a(i2Var, aVar, i5);
    }

    @Override // w4.m
    public void Z(w4.c cVar, long j5) {
        z0.k.o(cVar, "source");
        if (this.f5655l) {
            throw new IOException("closed");
        }
        r3.e h5 = r3.c.h("AsyncSink.write");
        try {
            synchronized (this.f5648a) {
                this.f5649b.Z(cVar, j5);
                int i5 = this.f5660q + this.f5659p;
                this.f5660q = i5;
                boolean z4 = false;
                this.f5659p = 0;
                if (this.f5658o || i5 <= this.f5652e) {
                    if (!this.f5653f && !this.f5654k && this.f5649b.l() > 0) {
                        this.f5653f = true;
                    }
                    if (h5 != null) {
                        h5.close();
                        return;
                    }
                    return;
                }
                this.f5658o = true;
                z4 = true;
                if (!z4) {
                    this.f5650c.execute(new C0084a());
                    if (h5 != null) {
                        h5.close();
                        return;
                    }
                    return;
                }
                try {
                    this.f5657n.close();
                } catch (IOException e5) {
                    this.f5651d.d(e5);
                }
                if (h5 != null) {
                    h5.close();
                }
            }
        } catch (Throwable th) {
            if (h5 != null) {
                try {
                    h5.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    @Override // w4.m, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.f5655l) {
            return;
        }
        this.f5655l = true;
        this.f5650c.execute(new c());
    }

    @Override // w4.m, java.io.Flushable
    public void flush() {
        if (this.f5655l) {
            throw new IOException("closed");
        }
        r3.e h5 = r3.c.h("AsyncSink.flush");
        try {
            synchronized (this.f5648a) {
                if (this.f5654k) {
                    if (h5 != null) {
                        h5.close();
                        return;
                    }
                    return;
                }
                this.f5654k = true;
                this.f5650c.execute(new b());
                if (h5 != null) {
                    h5.close();
                }
            }
        } catch (Throwable th) {
            if (h5 != null) {
                try {
                    h5.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void u(w4.m mVar, Socket socket) {
        z0.k.u(this.f5656m == null, "AsyncSink's becomeConnected should only be called once.");
        this.f5656m = (w4.m) z0.k.o(mVar, "sink");
        this.f5657n = (Socket) z0.k.o(socket, "socket");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public m3.c v(m3.c cVar) {
        return new d(cVar);
    }
}
