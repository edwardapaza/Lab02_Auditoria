package k3;

import com.google.android.gms.common.api.a;
import i3.b0;
import i3.c0;
import i3.d0;
import i3.h1;
import i3.j0;
import i3.j1;
import i3.k1;
import i3.z0;
import io.grpc.internal.e1;
import io.grpc.internal.i2;
import io.grpc.internal.m1;
import io.grpc.internal.n2;
import io.grpc.internal.s0;
import io.grpc.internal.t;
import io.grpc.internal.t0;
import io.grpc.internal.t2;
import io.grpc.internal.u;
import io.grpc.internal.x;
import io.grpc.internal.x0;
import io.grpc.internal.y0;
import java.io.EOFException;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.URI;
import java.util.Collections;
import java.util.Deque;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import k3.b;
import k3.f;
import k3.h;
import k3.j;
import k3.q;
import m3.b;
import n3.a;
import n3.b;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements x, b.a, q.d {
    private static final Map<m3.a, j1> V = Q();
    private static final Logger W = Logger.getLogger(i.class.getName());
    private final SocketFactory A;
    private SSLSocketFactory B;
    private HostnameVerifier C;
    private Socket D;
    private int E;
    private final Deque<h> F;
    private final l3.b G;
    private e1 H;
    private boolean I;
    private long J;
    private long K;
    private boolean L;
    private final Runnable M;
    private final int N;
    private final boolean O;
    private final t2 P;
    private final y0<h> Q;
    private d0.b R;
    final c0 S;
    int T;
    Runnable U;

    /* renamed from: a  reason: collision with root package name */
    private final InetSocketAddress f5744a;

    /* renamed from: b  reason: collision with root package name */
    private final String f5745b;

    /* renamed from: c  reason: collision with root package name */
    private final String f5746c;

    /* renamed from: d  reason: collision with root package name */
    private final Random f5747d;

    /* renamed from: e  reason: collision with root package name */
    private final z0.o<z0.m> f5748e;

    /* renamed from: f  reason: collision with root package name */
    private final int f5749f;

    /* renamed from: g  reason: collision with root package name */
    private final m3.j f5750g;

    /* renamed from: h  reason: collision with root package name */
    private m1.a f5751h;

    /* renamed from: i  reason: collision with root package name */
    private k3.b f5752i;

    /* renamed from: j  reason: collision with root package name */
    private q f5753j;

    /* renamed from: k  reason: collision with root package name */
    private final Object f5754k;

    /* renamed from: l  reason: collision with root package name */
    private final j0 f5755l;

    /* renamed from: m  reason: collision with root package name */
    private int f5756m;

    /* renamed from: n  reason: collision with root package name */
    private final Map<Integer, h> f5757n;

    /* renamed from: o  reason: collision with root package name */
    private final Executor f5758o;

    /* renamed from: p  reason: collision with root package name */
    private final i2 f5759p;

    /* renamed from: q  reason: collision with root package name */
    private final ScheduledExecutorService f5760q;

    /* renamed from: r  reason: collision with root package name */
    private final int f5761r;

    /* renamed from: s  reason: collision with root package name */
    private int f5762s;

    /* renamed from: t  reason: collision with root package name */
    private e f5763t;

    /* renamed from: u  reason: collision with root package name */
    private i3.a f5764u;

    /* renamed from: v  reason: collision with root package name */
    private j1 f5765v;

    /* renamed from: w  reason: collision with root package name */
    private boolean f5766w;

    /* renamed from: x  reason: collision with root package name */
    private x0 f5767x;

    /* renamed from: y  reason: collision with root package name */
    private boolean f5768y;

    /* renamed from: z  reason: collision with root package name */
    private boolean f5769z;

    /* loaded from: classes.dex */
    class a extends y0<h> {
        a() {
        }

        @Override // io.grpc.internal.y0
        protected void b() {
            i.this.f5751h.b(true);
        }

        @Override // io.grpc.internal.y0
        protected void c() {
            i.this.f5751h.b(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b implements t2.c {
        b() {
        }
    }

    /* loaded from: classes.dex */
    class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CountDownLatch f5772a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ k3.a f5773b;

        /* loaded from: classes.dex */
        class a implements w4.n {
            a() {
            }

            @Override // w4.n, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
            }

            @Override // w4.n
            public long s(w4.c cVar, long j5) {
                return -1L;
            }
        }

        c(CountDownLatch countDownLatch, k3.a aVar) {
            this.f5772a = countDownLatch;
            this.f5773b = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            i iVar;
            e eVar;
            Socket S;
            try {
                this.f5772a.await();
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
            w4.e b5 = w4.g.b(new a());
            SSLSession sSLSession = null;
            try {
                try {
                    i iVar2 = i.this;
                    c0 c0Var = iVar2.S;
                    if (c0Var == null) {
                        S = iVar2.A.createSocket(i.this.f5744a.getAddress(), i.this.f5744a.getPort());
                    } else if (!(c0Var.b() instanceof InetSocketAddress)) {
                        j1 j1Var = j1.f3446t;
                        throw j1Var.q("Unsupported SocketAddress implementation " + i.this.S.b().getClass()).c();
                    } else {
                        i iVar3 = i.this;
                        S = iVar3.S(iVar3.S.c(), (InetSocketAddress) i.this.S.b(), i.this.S.d(), i.this.S.a());
                    }
                    Socket socket = S;
                    SSLSocket sSLSocket = socket;
                    if (i.this.B != null) {
                        SSLSocket b6 = n.b(i.this.B, i.this.C, socket, i.this.W(), i.this.X(), i.this.G);
                        sSLSession = b6.getSession();
                        sSLSocket = b6;
                    }
                    sSLSocket.setTcpNoDelay(true);
                    w4.e b7 = w4.g.b(w4.g.g(sSLSocket));
                    this.f5773b.u(w4.g.e(sSLSocket), sSLSocket);
                    i iVar4 = i.this;
                    iVar4.f5764u = iVar4.f5764u.d().d(b0.f3340a, sSLSocket.getRemoteSocketAddress()).d(b0.f3341b, sSLSocket.getLocalSocketAddress()).d(b0.f3342c, sSLSession).d(s0.f5157a, sSLSession == null ? h1.NONE : h1.PRIVACY_AND_INTEGRITY).a();
                    i iVar5 = i.this;
                    iVar5.f5763t = new e(iVar5.f5750g.a(b7, true));
                    synchronized (i.this.f5754k) {
                        i.this.D = (Socket) z0.k.o(sSLSocket, "socket");
                        if (sSLSession != null) {
                            i.this.R = new d0.b(new d0.c(sSLSession));
                        }
                    }
                } catch (k1 e5) {
                    i.this.k0(0, m3.a.INTERNAL_ERROR, e5.a());
                    iVar = i.this;
                    eVar = new e(iVar.f5750g.a(b5, true));
                    iVar.f5763t = eVar;
                } catch (Exception e6) {
                    i.this.d(e6);
                    iVar = i.this;
                    eVar = new e(iVar.f5750g.a(b5, true));
                    iVar.f5763t = eVar;
                }
            } catch (Throwable th) {
                i iVar6 = i.this;
                iVar6.f5763t = new e(iVar6.f5750g.a(b5, true));
                throw th;
            }
        }
    }

    /* loaded from: classes.dex */
    class d implements Runnable {
        d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Runnable runnable = i.this.U;
            if (runnable != null) {
                runnable.run();
            }
            i.this.f5758o.execute(i.this.f5763t);
            synchronized (i.this.f5754k) {
                i.this.E = a.e.API_PRIORITY_OTHER;
                i.this.l0();
            }
            i.this.getClass();
        }
    }

    /* loaded from: classes.dex */
    class e implements b.a, Runnable {

        /* renamed from: b  reason: collision with root package name */
        m3.b f5778b;

        /* renamed from: a  reason: collision with root package name */
        private final j f5777a = new j(Level.FINE, i.class);

        /* renamed from: c  reason: collision with root package name */
        boolean f5779c = true;

        e(m3.b bVar) {
            this.f5778b = bVar;
        }

        private int b(List<m3.d> list) {
            long j5 = 0;
            for (int i5 = 0; i5 < list.size(); i5++) {
                m3.d dVar = list.get(i5);
                j5 += dVar.f6114a.p() + 32 + dVar.f6115b.p();
            }
            return (int) Math.min(j5, 2147483647L);
        }

        @Override // m3.b.a
        public void a(int i5, m3.a aVar) {
            this.f5777a.h(j.a.INBOUND, i5, aVar);
            j1 e5 = i.p0(aVar).e("Rst Stream");
            boolean z4 = e5.m() == j1.b.CANCELLED || e5.m() == j1.b.DEADLINE_EXCEEDED;
            synchronized (i.this.f5754k) {
                h hVar = (h) i.this.f5757n.get(Integer.valueOf(i5));
                if (hVar != null) {
                    r3.c.d("OkHttpClientTransport$ClientFrameHandler.rstStream", hVar.y().h0());
                    i.this.U(i5, e5, aVar == m3.a.REFUSED_STREAM ? t.a.REFUSED : t.a.PROCESSED, z4, null, null);
                }
            }
        }

        @Override // m3.b.a
        public void e(boolean z4, int i5, int i6) {
            x0 x0Var;
            long j5 = (i5 << 32) | (i6 & 4294967295L);
            this.f5777a.e(j.a.INBOUND, j5);
            if (!z4) {
                synchronized (i.this.f5754k) {
                    i.this.f5752i.e(true, i5, i6);
                }
                return;
            }
            synchronized (i.this.f5754k) {
                x0Var = null;
                if (i.this.f5767x == null) {
                    i.W.warning("Received unexpected ping ack. No ping outstanding");
                } else if (i.this.f5767x.h() == j5) {
                    x0 x0Var2 = i.this.f5767x;
                    i.this.f5767x = null;
                    x0Var = x0Var2;
                } else {
                    i.W.log(Level.WARNING, String.format(Locale.US, "Received unexpected ping ack. Expecting %d, got %d", Long.valueOf(i.this.f5767x.h()), Long.valueOf(j5)));
                }
            }
            if (x0Var != null) {
                x0Var.d();
            }
        }

        @Override // m3.b.a
        public void f(int i5, long j5) {
            this.f5777a.k(j.a.INBOUND, i5, j5);
            if (j5 == 0) {
                if (i5 == 0) {
                    i.this.f0(m3.a.PROTOCOL_ERROR, "Received 0 flow control window increment.");
                    return;
                } else {
                    i.this.U(i5, j1.f3446t.q("Received 0 flow control window increment."), t.a.PROCESSED, false, m3.a.PROTOCOL_ERROR, null);
                    return;
                }
            }
            boolean z4 = false;
            synchronized (i.this.f5754k) {
                if (i5 == 0) {
                    i.this.f5753j.g(null, (int) j5);
                    return;
                }
                h hVar = (h) i.this.f5757n.get(Integer.valueOf(i5));
                if (hVar != null) {
                    i.this.f5753j.g(hVar.y().b0(), (int) j5);
                } else if (!i.this.c0(i5)) {
                    z4 = true;
                }
                if (z4) {
                    i iVar = i.this;
                    m3.a aVar = m3.a.PROTOCOL_ERROR;
                    iVar.f0(aVar, "Received window_update for unknown stream: " + i5);
                }
            }
        }

        @Override // m3.b.a
        public void g() {
        }

        @Override // m3.b.a
        public void h(int i5, int i6, int i7, boolean z4) {
        }

        @Override // m3.b.a
        public void i(boolean z4, m3.i iVar) {
            boolean z5;
            this.f5777a.i(j.a.INBOUND, iVar);
            synchronized (i.this.f5754k) {
                if (m.b(iVar, 4)) {
                    i.this.E = m.a(iVar, 4);
                }
                if (m.b(iVar, 7)) {
                    z5 = i.this.f5753j.f(m.a(iVar, 7));
                } else {
                    z5 = false;
                }
                if (this.f5779c) {
                    i.this.f5751h.c();
                    this.f5779c = false;
                }
                i.this.f5752i.H(iVar);
                if (z5) {
                    i.this.f5753j.h();
                }
                i.this.l0();
            }
        }

        @Override // m3.b.a
        public void j(int i5, int i6, List<m3.d> list) {
            this.f5777a.g(j.a.INBOUND, i5, i6, list);
            synchronized (i.this.f5754k) {
                i.this.f5752i.a(i5, m3.a.PROTOCOL_ERROR);
            }
        }

        @Override // m3.b.a
        public void k(boolean z4, int i5, w4.e eVar, int i6) {
            this.f5777a.b(j.a.INBOUND, i5, eVar.B(), i6, z4);
            h Z = i.this.Z(i5);
            if (Z != null) {
                long j5 = i6;
                eVar.Y(j5);
                w4.c cVar = new w4.c();
                cVar.Z(eVar.B(), j5);
                r3.c.d("OkHttpClientTransport$ClientFrameHandler.data", Z.y().h0());
                synchronized (i.this.f5754k) {
                    Z.y().i0(cVar, z4);
                }
            } else if (!i.this.c0(i5)) {
                i.this.f0(m3.a.PROTOCOL_ERROR, "Received data for unknown stream: " + i5);
                return;
            } else {
                synchronized (i.this.f5754k) {
                    i.this.f5752i.a(i5, m3.a.STREAM_CLOSED);
                }
                eVar.skip(i6);
            }
            i.D(i.this, i6);
            if (i.this.f5762s >= i.this.f5749f * 0.5f) {
                synchronized (i.this.f5754k) {
                    i.this.f5752i.f(0, i.this.f5762s);
                }
                i.this.f5762s = 0;
            }
        }

        @Override // m3.b.a
        public void l(boolean z4, boolean z5, int i5, int i6, List<m3.d> list, m3.e eVar) {
            j1 j1Var;
            int b5;
            this.f5777a.d(j.a.INBOUND, i5, list, z5);
            boolean z6 = true;
            if (i.this.N == Integer.MAX_VALUE || (b5 = b(list)) <= i.this.N) {
                j1Var = null;
            } else {
                j1 j1Var2 = j1.f3441o;
                Locale locale = Locale.US;
                Object[] objArr = new Object[3];
                objArr[0] = z5 ? "trailer" : "header";
                objArr[1] = Integer.valueOf(i.this.N);
                objArr[2] = Integer.valueOf(b5);
                j1Var = j1Var2.q(String.format(locale, "Response %s metadata larger than %d: %d", objArr));
            }
            synchronized (i.this.f5754k) {
                h hVar = (h) i.this.f5757n.get(Integer.valueOf(i5));
                if (hVar == null) {
                    if (i.this.c0(i5)) {
                        i.this.f5752i.a(i5, m3.a.STREAM_CLOSED);
                    }
                } else if (j1Var == null) {
                    r3.c.d("OkHttpClientTransport$ClientFrameHandler.headers", hVar.y().h0());
                    hVar.y().j0(list, z5);
                } else {
                    if (!z5) {
                        i.this.f5752i.a(i5, m3.a.CANCEL);
                    }
                    hVar.y().N(j1Var, false, new i3.y0());
                }
                z6 = false;
            }
            if (z6) {
                i iVar = i.this;
                m3.a aVar = m3.a.PROTOCOL_ERROR;
                iVar.f0(aVar, "Received header for unknown stream: " + i5);
            }
        }

        @Override // m3.b.a
        public void m(int i5, m3.a aVar, w4.f fVar) {
            this.f5777a.c(j.a.INBOUND, i5, aVar, fVar);
            if (aVar == m3.a.ENHANCE_YOUR_CALM) {
                String u5 = fVar.u();
                i.W.log(Level.WARNING, String.format("%s: Received GOAWAY with ENHANCE_YOUR_CALM. Debug data: %s", this, u5));
                if ("too_many_pings".equals(u5)) {
                    i.this.M.run();
                }
            }
            j1 e5 = t0.h.h(aVar.f6104a).e("Received Goaway");
            if (fVar.p() > 0) {
                e5 = e5.e(fVar.u());
            }
            i.this.k0(i5, null, e5);
        }

        @Override // java.lang.Runnable
        public void run() {
            j1 j1Var;
            String name = Thread.currentThread().getName();
            Thread.currentThread().setName("OkHttpClientTransport");
            while (this.f5778b.o(this)) {
                try {
                    if (i.this.H != null) {
                        i.this.H.m();
                    }
                } catch (Throwable th) {
                    try {
                        i.this.k0(0, m3.a.PROTOCOL_ERROR, j1.f3446t.q("error in frame handler").p(th));
                        try {
                            this.f5778b.close();
                        } catch (IOException e5) {
                            e = e5;
                            i.W.log(Level.INFO, "Exception closing frame reader", (Throwable) e);
                            i.this.f5751h.a();
                            Thread.currentThread().setName(name);
                        }
                    } catch (Throwable th2) {
                        try {
                            this.f5778b.close();
                        } catch (IOException e6) {
                            i.W.log(Level.INFO, "Exception closing frame reader", (Throwable) e6);
                        }
                        i.this.f5751h.a();
                        Thread.currentThread().setName(name);
                        throw th2;
                    }
                }
            }
            synchronized (i.this.f5754k) {
                j1Var = i.this.f5765v;
            }
            if (j1Var == null) {
                j1Var = j1.f3447u.q("End of stream or IOException");
            }
            i.this.k0(0, m3.a.INTERNAL_ERROR, j1Var);
            try {
                this.f5778b.close();
            } catch (IOException e7) {
                e = e7;
                i.W.log(Level.INFO, "Exception closing frame reader", (Throwable) e);
                i.this.f5751h.a();
                Thread.currentThread().setName(name);
            }
            i.this.f5751h.a();
            Thread.currentThread().setName(name);
        }
    }

    public i(f.C0085f c0085f, InetSocketAddress inetSocketAddress, String str, String str2, i3.a aVar, c0 c0Var, Runnable runnable) {
        this(c0085f, inetSocketAddress, str, str2, aVar, t0.f5197w, new m3.g(), c0Var, runnable);
    }

    private i(f.C0085f c0085f, InetSocketAddress inetSocketAddress, String str, String str2, i3.a aVar, z0.o<z0.m> oVar, m3.j jVar, c0 c0Var, Runnable runnable) {
        this.f5747d = new Random();
        this.f5754k = new Object();
        this.f5757n = new HashMap();
        this.E = 0;
        this.F = new LinkedList();
        this.Q = new a();
        this.T = 30000;
        this.f5744a = (InetSocketAddress) z0.k.o(inetSocketAddress, "address");
        this.f5745b = str;
        this.f5761r = c0085f.f5720n;
        this.f5749f = c0085f.f5725s;
        this.f5758o = (Executor) z0.k.o(c0085f.f5712b, "executor");
        this.f5759p = new i2(c0085f.f5712b);
        this.f5760q = (ScheduledExecutorService) z0.k.o(c0085f.f5714d, "scheduledExecutorService");
        this.f5756m = 3;
        SocketFactory socketFactory = c0085f.f5716f;
        this.A = socketFactory == null ? SocketFactory.getDefault() : socketFactory;
        this.B = c0085f.f5717k;
        this.C = c0085f.f5718l;
        this.G = (l3.b) z0.k.o(c0085f.f5719m, "connectionSpec");
        this.f5748e = (z0.o) z0.k.o(oVar, "stopwatchFactory");
        this.f5750g = (m3.j) z0.k.o(jVar, "variant");
        this.f5746c = t0.g("okhttp", str2);
        this.S = c0Var;
        this.M = (Runnable) z0.k.o(runnable, "tooManyPingsRunnable");
        this.N = c0085f.f5727u;
        this.P = c0085f.f5715e.a();
        this.f5755l = j0.a(getClass(), inetSocketAddress.toString());
        this.f5764u = i3.a.c().d(s0.f5158b, aVar).a();
        this.O = c0085f.f5728v;
        a0();
    }

    static /* synthetic */ int D(i iVar, int i5) {
        int i6 = iVar.f5762s + i5;
        iVar.f5762s = i6;
        return i6;
    }

    private static Map<m3.a, j1> Q() {
        EnumMap enumMap = new EnumMap(m3.a.class);
        m3.a aVar = m3.a.NO_ERROR;
        j1 j1Var = j1.f3446t;
        enumMap.put((EnumMap) aVar, (m3.a) j1Var.q("No error: A GRPC status of OK should have been sent"));
        enumMap.put((EnumMap) m3.a.PROTOCOL_ERROR, (m3.a) j1Var.q("Protocol error"));
        enumMap.put((EnumMap) m3.a.INTERNAL_ERROR, (m3.a) j1Var.q("Internal error"));
        enumMap.put((EnumMap) m3.a.FLOW_CONTROL_ERROR, (m3.a) j1Var.q("Flow control error"));
        enumMap.put((EnumMap) m3.a.STREAM_CLOSED, (m3.a) j1Var.q("Stream closed"));
        enumMap.put((EnumMap) m3.a.FRAME_TOO_LARGE, (m3.a) j1Var.q("Frame too large"));
        enumMap.put((EnumMap) m3.a.REFUSED_STREAM, (m3.a) j1.f3447u.q("Refused stream"));
        enumMap.put((EnumMap) m3.a.CANCEL, (m3.a) j1.f3433g.q("Cancelled"));
        enumMap.put((EnumMap) m3.a.COMPRESSION_ERROR, (m3.a) j1Var.q("Compression error"));
        enumMap.put((EnumMap) m3.a.CONNECT_ERROR, (m3.a) j1Var.q("Connect error"));
        enumMap.put((EnumMap) m3.a.ENHANCE_YOUR_CALM, (m3.a) j1.f3441o.q("Enhance your calm"));
        enumMap.put((EnumMap) m3.a.INADEQUATE_SECURITY, (m3.a) j1.f3439m.q("Inadequate security"));
        return Collections.unmodifiableMap(enumMap);
    }

    private n3.b R(InetSocketAddress inetSocketAddress, String str, String str2) {
        n3.a a5 = new a.b().k("https").h(inetSocketAddress.getHostName()).j(inetSocketAddress.getPort()).a();
        b.C0099b e5 = new b.C0099b().e(a5);
        b.C0099b d5 = e5.d("Host", a5.c() + ":" + a5.f()).d("User-Agent", this.f5746c);
        if (str != null && str2 != null) {
            d5.d("Proxy-Authorization", l3.c.a(str, str2));
        }
        return d5.c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Socket S(InetSocketAddress inetSocketAddress, InetSocketAddress inetSocketAddress2, String str, String str2) {
        Socket socket = null;
        try {
            socket = inetSocketAddress2.getAddress() != null ? this.A.createSocket(inetSocketAddress2.getAddress(), inetSocketAddress2.getPort()) : this.A.createSocket(inetSocketAddress2.getHostName(), inetSocketAddress2.getPort());
            socket.setTcpNoDelay(true);
            socket.setSoTimeout(this.T);
            w4.n g5 = w4.g.g(socket);
            w4.d a5 = w4.g.a(w4.g.e(socket));
            n3.b R = R(inetSocketAddress, str, str2);
            n3.a b5 = R.b();
            a5.b0(String.format(Locale.US, "CONNECT %s:%d HTTP/1.1", b5.c(), Integer.valueOf(b5.f()))).b0("\r\n");
            int b6 = R.a().b();
            for (int i5 = 0; i5 < b6; i5++) {
                a5.b0(R.a().a(i5)).b0(": ").b0(R.a().c(i5)).b0("\r\n");
            }
            a5.b0("\r\n");
            a5.flush();
            l3.j a6 = l3.j.a(g0(g5));
            while (!g0(g5).equals("")) {
            }
            int i6 = a6.f6022b;
            if (i6 >= 200 && i6 < 300) {
                socket.setSoTimeout(0);
                return socket;
            }
            w4.c cVar = new w4.c();
            try {
                socket.shutdownOutput();
                g5.s(cVar, 1024L);
            } catch (IOException e5) {
                cVar.b0("Unable to read body: " + e5.toString());
            }
            try {
                socket.close();
            } catch (IOException unused) {
            }
            throw j1.f3447u.q(String.format(Locale.US, "Response returned from proxy was not successful (expected 2xx, got %d %s). Response body:\n%s", Integer.valueOf(a6.f6022b), a6.f6023c, cVar.A())).c();
        } catch (IOException e6) {
            if (socket != null) {
                t0.e(socket);
            }
            throw j1.f3447u.q("Failed trying to connect with proxy").p(e6).c();
        }
    }

    private Throwable Y() {
        synchronized (this.f5754k) {
            j1 j1Var = this.f5765v;
            if (j1Var != null) {
                return j1Var.c();
            }
            return j1.f3447u.q("Connection closed").c();
        }
    }

    private void a0() {
        synchronized (this.f5754k) {
            this.P.g(new b());
        }
    }

    private void d0(h hVar) {
        if (this.f5769z && this.F.isEmpty() && this.f5757n.isEmpty()) {
            this.f5769z = false;
            e1 e1Var = this.H;
            if (e1Var != null) {
                e1Var.o();
            }
        }
        if (hVar.x()) {
            this.Q.e(hVar, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f0(m3.a aVar, String str) {
        k0(0, aVar, p0(aVar).e(str));
    }

    private static String g0(w4.n nVar) {
        w4.c cVar = new w4.c();
        while (nVar.s(cVar, 1L) != -1) {
            if (cVar.p(cVar.size() - 1) == 10) {
                return cVar.J();
            }
        }
        throw new EOFException("\\n not found: " + cVar.w().k());
    }

    private void i0() {
        synchronized (this.f5754k) {
            this.f5752i.E();
            m3.i iVar = new m3.i();
            m.c(iVar, 7, this.f5749f);
            this.f5752i.F(iVar);
            int i5 = this.f5749f;
            if (i5 > 65535) {
                this.f5752i.f(0, i5 - 65535);
            }
        }
    }

    private void j0(h hVar) {
        if (!this.f5769z) {
            this.f5769z = true;
            e1 e1Var = this.H;
            if (e1Var != null) {
                e1Var.n();
            }
        }
        if (hVar.x()) {
            this.Q.e(hVar, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k0(int i5, m3.a aVar, j1 j1Var) {
        synchronized (this.f5754k) {
            if (this.f5765v == null) {
                this.f5765v = j1Var;
                this.f5751h.d(j1Var);
            }
            if (aVar != null && !this.f5766w) {
                this.f5766w = true;
                this.f5752i.T(0, aVar, new byte[0]);
            }
            Iterator<Map.Entry<Integer, h>> it = this.f5757n.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<Integer, h> next = it.next();
                if (next.getKey().intValue() > i5) {
                    it.remove();
                    next.getValue().y().M(j1Var, t.a.REFUSED, false, new i3.y0());
                    d0(next.getValue());
                }
            }
            for (h hVar : this.F) {
                hVar.y().M(j1Var, t.a.MISCARRIED, true, new i3.y0());
                d0(hVar);
            }
            this.F.clear();
            n0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean l0() {
        boolean z4 = false;
        while (!this.F.isEmpty() && this.f5757n.size() < this.E) {
            m0(this.F.poll());
            z4 = true;
        }
        return z4;
    }

    private void m0(h hVar) {
        z0.k.u(hVar.y().c0() == -1, "StreamId already assigned");
        this.f5757n.put(Integer.valueOf(this.f5756m), hVar);
        j0(hVar);
        hVar.y().f0(this.f5756m);
        if ((hVar.L() != z0.d.UNARY && hVar.L() != z0.d.SERVER_STREAMING) || hVar.N()) {
            this.f5752i.flush();
        }
        int i5 = this.f5756m;
        if (i5 < 2147483645) {
            this.f5756m = i5 + 2;
            return;
        }
        this.f5756m = a.e.API_PRIORITY_OTHER;
        k0(a.e.API_PRIORITY_OTHER, m3.a.NO_ERROR, j1.f3447u.q("Stream ids exhausted"));
    }

    private void n0() {
        if (this.f5765v == null || !this.f5757n.isEmpty() || !this.F.isEmpty() || this.f5768y) {
            return;
        }
        this.f5768y = true;
        e1 e1Var = this.H;
        if (e1Var != null) {
            e1Var.q();
        }
        x0 x0Var = this.f5767x;
        if (x0Var != null) {
            x0Var.f(Y());
            this.f5767x = null;
        }
        if (!this.f5766w) {
            this.f5766w = true;
            this.f5752i.T(0, m3.a.NO_ERROR, new byte[0]);
        }
        this.f5752i.close();
    }

    static j1 p0(m3.a aVar) {
        j1 j1Var = V.get(aVar);
        if (j1Var != null) {
            return j1Var;
        }
        j1 j1Var2 = j1.f3434h;
        return j1Var2.q("Unknown http2 error code: " + aVar.f6104a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void T(boolean z4, long j5, long j6, boolean z5) {
        this.I = z4;
        this.J = j5;
        this.K = j6;
        this.L = z5;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void U(int i5, j1 j1Var, t.a aVar, boolean z4, m3.a aVar2, i3.y0 y0Var) {
        synchronized (this.f5754k) {
            h remove = this.f5757n.remove(Integer.valueOf(i5));
            if (remove != null) {
                if (aVar2 != null) {
                    this.f5752i.a(i5, m3.a.CANCEL);
                }
                if (j1Var != null) {
                    h.b y4 = remove.y();
                    if (y0Var == null) {
                        y0Var = new i3.y0();
                    }
                    y4.M(j1Var, aVar, z4, y0Var);
                }
                if (!l0()) {
                    n0();
                    d0(remove);
                }
            }
        }
    }

    public i3.a V() {
        return this.f5764u;
    }

    String W() {
        URI b5 = t0.b(this.f5745b);
        return b5.getHost() != null ? b5.getHost() : this.f5745b;
    }

    int X() {
        URI b5 = t0.b(this.f5745b);
        return b5.getPort() != -1 ? b5.getPort() : this.f5744a.getPort();
    }

    h Z(int i5) {
        h hVar;
        synchronized (this.f5754k) {
            hVar = this.f5757n.get(Integer.valueOf(i5));
        }
        return hVar;
    }

    @Override // k3.q.d
    public q.c[] a() {
        q.c[] cVarArr;
        synchronized (this.f5754k) {
            cVarArr = new q.c[this.f5757n.size()];
            int i5 = 0;
            for (h hVar : this.f5757n.values()) {
                cVarArr[i5] = hVar.y().b0();
                i5++;
            }
        }
        return cVarArr;
    }

    @Override // io.grpc.internal.m1
    public Runnable b(m1.a aVar) {
        this.f5751h = (m1.a) z0.k.o(aVar, "listener");
        if (this.I) {
            e1 e1Var = new e1(new e1.c(this), this.f5760q, this.J, this.K, this.L);
            this.H = e1Var;
            e1Var.p();
        }
        k3.a w5 = k3.a.w(this.f5759p, this, 10000);
        m3.c v5 = w5.v(this.f5750g.b(w4.g.a(w5), true));
        synchronized (this.f5754k) {
            k3.b bVar = new k3.b(this, v5);
            this.f5752i = bVar;
            this.f5753j = new q(this, bVar);
        }
        CountDownLatch countDownLatch = new CountDownLatch(1);
        this.f5759p.execute(new c(countDownLatch, w5));
        try {
            i0();
            countDownLatch.countDown();
            this.f5759p.execute(new d());
            return null;
        } catch (Throwable th) {
            countDownLatch.countDown();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b0() {
        return this.B == null;
    }

    boolean c0(int i5) {
        boolean z4;
        synchronized (this.f5754k) {
            z4 = true;
            if (i5 >= this.f5756m || (i5 & 1) != 1) {
                z4 = false;
            }
        }
        return z4;
    }

    @Override // k3.b.a
    public void d(Throwable th) {
        z0.k.o(th, "failureCause");
        k0(0, m3.a.INTERNAL_ERROR, j1.f3447u.p(th));
    }

    @Override // i3.p0
    public j0 e() {
        return this.f5755l;
    }

    @Override // io.grpc.internal.u
    /* renamed from: e0 */
    public h c(z0<?, ?> z0Var, i3.y0 y0Var, i3.c cVar, i3.k[] kVarArr) {
        z0.k.o(z0Var, "method");
        z0.k.o(y0Var, "headers");
        n2 h5 = n2.h(kVarArr, V(), y0Var);
        synchronized (this.f5754k) {
            try {
                try {
                    return new h(z0Var, y0Var, this.f5752i, this, this.f5753j, this.f5754k, this.f5761r, this.f5749f, this.f5745b, this.f5746c, h5, this.P, cVar, this.O);
                } catch (Throwable th) {
                    th = th;
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    @Override // io.grpc.internal.m1
    public void f(j1 j1Var) {
        synchronized (this.f5754k) {
            if (this.f5765v != null) {
                return;
            }
            this.f5765v = j1Var;
            this.f5751h.d(j1Var);
            n0();
        }
    }

    @Override // io.grpc.internal.u
    public void g(u.a aVar, Executor executor) {
        long nextLong;
        synchronized (this.f5754k) {
            boolean z4 = true;
            z0.k.t(this.f5752i != null);
            if (this.f5768y) {
                x0.g(aVar, executor, Y());
                return;
            }
            x0 x0Var = this.f5767x;
            if (x0Var != null) {
                nextLong = 0;
                z4 = false;
            } else {
                nextLong = this.f5747d.nextLong();
                z0.m mVar = this.f5748e.get();
                mVar.g();
                x0 x0Var2 = new x0(nextLong, mVar);
                this.f5767x = x0Var2;
                this.P.b();
                x0Var = x0Var2;
            }
            if (z4) {
                this.f5752i.e(false, (int) (nextLong >>> 32), (int) nextLong);
            }
            x0Var.a(aVar, executor);
        }
    }

    @Override // io.grpc.internal.m1
    public void h(j1 j1Var) {
        f(j1Var);
        synchronized (this.f5754k) {
            Iterator<Map.Entry<Integer, h>> it = this.f5757n.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<Integer, h> next = it.next();
                it.remove();
                next.getValue().y().N(j1Var, false, new i3.y0());
                d0(next.getValue());
            }
            for (h hVar : this.F) {
                hVar.y().M(j1Var, t.a.MISCARRIED, true, new i3.y0());
                d0(hVar);
            }
            this.F.clear();
            n0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h0(h hVar) {
        this.F.remove(hVar);
        d0(hVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o0(h hVar) {
        if (this.f5765v != null) {
            hVar.y().M(this.f5765v, t.a.MISCARRIED, true, new i3.y0());
        } else if (this.f5757n.size() < this.E) {
            m0(hVar);
        } else {
            this.F.add(hVar);
            j0(hVar);
        }
    }

    public String toString() {
        return z0.f.b(this).c("logId", this.f5755l.d()).d("address", this.f5744a).toString();
    }
}
