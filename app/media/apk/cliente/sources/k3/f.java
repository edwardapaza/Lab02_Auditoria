package k3;

import com.google.android.gms.common.api.a;
import i3.p1;
import i3.v0;
import io.grpc.internal.e1;
import io.grpc.internal.h;
import io.grpc.internal.j0;
import io.grpc.internal.j1;
import io.grpc.internal.k2;
import io.grpc.internal.l2;
import io.grpc.internal.r1;
import io.grpc.internal.t0;
import io.grpc.internal.t2;
import io.grpc.internal.v;
import io.grpc.internal.x;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.security.GeneralSecurityException;
import java.util.EnumSet;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import l3.b;
/* loaded from: classes.dex */
public final class f extends io.grpc.internal.b<f> {

    /* renamed from: r  reason: collision with root package name */
    private static final Logger f5682r = Logger.getLogger(f.class.getName());

    /* renamed from: s  reason: collision with root package name */
    static final l3.b f5683s = new b.C0087b(l3.b.f5965f).g(l3.a.TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256, l3.a.TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256, l3.a.TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384, l3.a.TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384, l3.a.TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256, l3.a.TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256).j(l3.k.TLS_1_2).h(true).e();

    /* renamed from: t  reason: collision with root package name */
    private static final long f5684t = TimeUnit.DAYS.toNanos(1000);

    /* renamed from: u  reason: collision with root package name */
    private static final k2.d<Executor> f5685u;

    /* renamed from: v  reason: collision with root package name */
    static final r1<Executor> f5686v;

    /* renamed from: w  reason: collision with root package name */
    private static final EnumSet<p1> f5687w;

    /* renamed from: b  reason: collision with root package name */
    private final j1 f5688b;

    /* renamed from: f  reason: collision with root package name */
    private SocketFactory f5692f;

    /* renamed from: g  reason: collision with root package name */
    private SSLSocketFactory f5693g;

    /* renamed from: i  reason: collision with root package name */
    private HostnameVerifier f5695i;

    /* renamed from: o  reason: collision with root package name */
    private boolean f5701o;

    /* renamed from: c  reason: collision with root package name */
    private t2.b f5689c = t2.a();

    /* renamed from: d  reason: collision with root package name */
    private r1<Executor> f5690d = f5686v;

    /* renamed from: e  reason: collision with root package name */
    private r1<ScheduledExecutorService> f5691e = l2.c(t0.f5196v);

    /* renamed from: j  reason: collision with root package name */
    private l3.b f5696j = f5683s;

    /* renamed from: k  reason: collision with root package name */
    private c f5697k = c.TLS;

    /* renamed from: l  reason: collision with root package name */
    private long f5698l = Long.MAX_VALUE;

    /* renamed from: m  reason: collision with root package name */
    private long f5699m = t0.f5188n;

    /* renamed from: n  reason: collision with root package name */
    private int f5700n = 65535;

    /* renamed from: p  reason: collision with root package name */
    private int f5702p = a.e.API_PRIORITY_OTHER;

    /* renamed from: q  reason: collision with root package name */
    private final boolean f5703q = false;

    /* renamed from: h  reason: collision with root package name */
    private final boolean f5694h = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements k2.d<Executor> {
        a() {
        }

        @Override // io.grpc.internal.k2.d
        /* renamed from: c */
        public void b(Executor executor) {
            ((ExecutorService) executor).shutdown();
        }

        @Override // io.grpc.internal.k2.d
        /* renamed from: d */
        public Executor a() {
            return Executors.newCachedThreadPool(t0.i("grpc-okhttp-%d", true));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f5704a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f5705b;

        static {
            int[] iArr = new int[c.values().length];
            f5705b = iArr;
            try {
                iArr[c.PLAINTEXT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f5705b[c.TLS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[k3.e.values().length];
            f5704a = iArr2;
            try {
                iArr2[k3.e.TLS.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f5704a[k3.e.PLAINTEXT.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public enum c {
        TLS,
        PLAINTEXT
    }

    /* loaded from: classes.dex */
    private final class d implements j1.b {
        private d() {
        }

        /* synthetic */ d(f fVar, a aVar) {
            this();
        }

        @Override // io.grpc.internal.j1.b
        public int a() {
            return f.this.h();
        }
    }

    /* loaded from: classes.dex */
    private final class e implements j1.c {
        private e() {
        }

        /* synthetic */ e(f fVar, a aVar) {
            this();
        }

        @Override // io.grpc.internal.j1.c
        public v a() {
            return f.this.f();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: k3.f$f  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0085f implements v {

        /* renamed from: a  reason: collision with root package name */
        private final r1<Executor> f5711a;

        /* renamed from: b  reason: collision with root package name */
        final Executor f5712b;

        /* renamed from: c  reason: collision with root package name */
        private final r1<ScheduledExecutorService> f5713c;

        /* renamed from: d  reason: collision with root package name */
        final ScheduledExecutorService f5714d;

        /* renamed from: e  reason: collision with root package name */
        final t2.b f5715e;

        /* renamed from: f  reason: collision with root package name */
        final SocketFactory f5716f;

        /* renamed from: k  reason: collision with root package name */
        final SSLSocketFactory f5717k;

        /* renamed from: l  reason: collision with root package name */
        final HostnameVerifier f5718l;

        /* renamed from: m  reason: collision with root package name */
        final l3.b f5719m;

        /* renamed from: n  reason: collision with root package name */
        final int f5720n;

        /* renamed from: o  reason: collision with root package name */
        private final boolean f5721o;

        /* renamed from: p  reason: collision with root package name */
        private final long f5722p;

        /* renamed from: q  reason: collision with root package name */
        private final io.grpc.internal.h f5723q;

        /* renamed from: r  reason: collision with root package name */
        private final long f5724r;

        /* renamed from: s  reason: collision with root package name */
        final int f5725s;

        /* renamed from: t  reason: collision with root package name */
        private final boolean f5726t;

        /* renamed from: u  reason: collision with root package name */
        final int f5727u;

        /* renamed from: v  reason: collision with root package name */
        final boolean f5728v;

        /* renamed from: w  reason: collision with root package name */
        private boolean f5729w;

        /* renamed from: k3.f$f$a */
        /* loaded from: classes.dex */
        class a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ h.b f5730a;

            a(h.b bVar) {
                this.f5730a = bVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f5730a.a();
            }
        }

        private C0085f(r1<Executor> r1Var, r1<ScheduledExecutorService> r1Var2, SocketFactory socketFactory, SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier, l3.b bVar, int i5, boolean z4, long j5, long j6, int i6, boolean z5, int i7, t2.b bVar2, boolean z6) {
            this.f5711a = r1Var;
            this.f5712b = r1Var.a();
            this.f5713c = r1Var2;
            this.f5714d = r1Var2.a();
            this.f5716f = socketFactory;
            this.f5717k = sSLSocketFactory;
            this.f5718l = hostnameVerifier;
            this.f5719m = bVar;
            this.f5720n = i5;
            this.f5721o = z4;
            this.f5722p = j5;
            this.f5723q = new io.grpc.internal.h("keepalive time nanos", j5);
            this.f5724r = j6;
            this.f5725s = i6;
            this.f5726t = z5;
            this.f5727u = i7;
            this.f5728v = z6;
            this.f5715e = (t2.b) z0.k.o(bVar2, "transportTracerFactory");
        }

        /* synthetic */ C0085f(r1 r1Var, r1 r1Var2, SocketFactory socketFactory, SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier, l3.b bVar, int i5, boolean z4, long j5, long j6, int i6, boolean z5, int i7, t2.b bVar2, boolean z6, a aVar) {
            this(r1Var, r1Var2, socketFactory, sSLSocketFactory, hostnameVerifier, bVar, i5, z4, j5, j6, i6, z5, i7, bVar2, z6);
        }

        @Override // io.grpc.internal.v
        public ScheduledExecutorService R() {
            return this.f5714d;
        }

        @Override // io.grpc.internal.v, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.f5729w) {
                return;
            }
            this.f5729w = true;
            this.f5711a.b(this.f5712b);
            this.f5713c.b(this.f5714d);
        }

        @Override // io.grpc.internal.v
        public x y(SocketAddress socketAddress, v.a aVar, i3.f fVar) {
            if (this.f5729w) {
                throw new IllegalStateException("The transport factory is closed.");
            }
            h.b d5 = this.f5723q.d();
            i iVar = new i(this, (InetSocketAddress) socketAddress, aVar.a(), aVar.d(), aVar.b(), aVar.c(), new a(d5));
            if (this.f5721o) {
                iVar.T(true, d5.b(), this.f5724r, this.f5726t);
            }
            return iVar;
        }
    }

    static {
        a aVar = new a();
        f5685u = aVar;
        f5686v = l2.c(aVar);
        f5687w = EnumSet.of(p1.MTLS, p1.CUSTOM_MANAGERS);
    }

    private f(String str) {
        this.f5688b = new j1(str, new e(this, null), new d(this, null));
    }

    public static f forTarget(String str) {
        return new f(str);
    }

    @Override // io.grpc.internal.b
    protected v0<?> e() {
        return this.f5688b;
    }

    C0085f f() {
        return new C0085f(this.f5690d, this.f5691e, this.f5692f, g(), this.f5695i, this.f5696j, this.f4426a, this.f5698l != Long.MAX_VALUE, this.f5698l, this.f5699m, this.f5700n, this.f5701o, this.f5702p, this.f5689c, false, null);
    }

    SSLSocketFactory g() {
        int i5 = b.f5705b[this.f5697k.ordinal()];
        if (i5 != 1) {
            if (i5 != 2) {
                throw new RuntimeException("Unknown negotiation type: " + this.f5697k);
            }
            try {
                if (this.f5693g == null) {
                    this.f5693g = SSLContext.getInstance("Default", l3.h.e().g()).getSocketFactory();
                }
                return this.f5693g;
            } catch (GeneralSecurityException e5) {
                throw new RuntimeException("TLS Provider failure", e5);
            }
        }
        return null;
    }

    int h() {
        int i5 = b.f5705b[this.f5697k.ordinal()];
        if (i5 != 1) {
            if (i5 == 2) {
                return 443;
            }
            throw new AssertionError(this.f5697k + " not handled");
        }
        return 80;
    }

    @Override // i3.v0
    /* renamed from: i */
    public f c(long j5, TimeUnit timeUnit) {
        z0.k.e(j5 > 0, "keepalive time must be positive");
        long nanos = timeUnit.toNanos(j5);
        this.f5698l = nanos;
        long l5 = e1.l(nanos);
        this.f5698l = l5;
        if (l5 >= f5684t) {
            this.f5698l = Long.MAX_VALUE;
        }
        return this;
    }

    @Override // i3.v0
    /* renamed from: j */
    public f d() {
        z0.k.u(!this.f5694h, "Cannot change security when using ChannelCredentials");
        this.f5697k = c.PLAINTEXT;
        return this;
    }

    public f scheduledExecutorService(ScheduledExecutorService scheduledExecutorService) {
        this.f5691e = new j0((ScheduledExecutorService) z0.k.o(scheduledExecutorService, "scheduledExecutorService"));
        return this;
    }

    public f sslSocketFactory(SSLSocketFactory sSLSocketFactory) {
        z0.k.u(!this.f5694h, "Cannot change security when using ChannelCredentials");
        this.f5693g = sSLSocketFactory;
        this.f5697k = c.TLS;
        return this;
    }

    public f transportExecutor(Executor executor) {
        if (executor == null) {
            this.f5690d = f5686v;
        } else {
            this.f5690d = new j0(executor);
        }
        return this;
    }
}
