package io.grpc.internal;

import i3.c;
import i3.j1;
import i3.k;
import i3.m0;
import i3.r0;
import i3.y0;
import io.grpc.internal.k2;
import io.grpc.internal.p2;
import io.grpc.internal.t;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
/* loaded from: classes.dex */
public final class t0 {

    /* renamed from: a  reason: collision with root package name */
    private static final Logger f5175a = Logger.getLogger(t0.class.getName());

    /* renamed from: b  reason: collision with root package name */
    private static final Set<j1.b> f5176b = Collections.unmodifiableSet(EnumSet.of(j1.b.OK, j1.b.INVALID_ARGUMENT, j1.b.NOT_FOUND, j1.b.ALREADY_EXISTS, j1.b.FAILED_PRECONDITION, j1.b.ABORTED, j1.b.OUT_OF_RANGE, j1.b.DATA_LOSS));

    /* renamed from: c  reason: collision with root package name */
    public static final Charset f5177c = Charset.forName("US-ASCII");

    /* renamed from: d  reason: collision with root package name */
    public static final y0.g<Long> f5178d = y0.g.e("grpc-timeout", new i());

    /* renamed from: e  reason: collision with root package name */
    public static final y0.g<String> f5179e;

    /* renamed from: f  reason: collision with root package name */
    public static final y0.g<byte[]> f5180f;

    /* renamed from: g  reason: collision with root package name */
    public static final y0.g<String> f5181g;

    /* renamed from: h  reason: collision with root package name */
    public static final y0.g<byte[]> f5182h;

    /* renamed from: i  reason: collision with root package name */
    static final y0.g<String> f5183i;

    /* renamed from: j  reason: collision with root package name */
    public static final y0.g<String> f5184j;

    /* renamed from: k  reason: collision with root package name */
    public static final y0.g<String> f5185k;

    /* renamed from: l  reason: collision with root package name */
    public static final y0.g<String> f5186l;

    /* renamed from: m  reason: collision with root package name */
    public static final z0.l f5187m;

    /* renamed from: n  reason: collision with root package name */
    public static final long f5188n;

    /* renamed from: o  reason: collision with root package name */
    public static final long f5189o;

    /* renamed from: p  reason: collision with root package name */
    public static final long f5190p;

    /* renamed from: q  reason: collision with root package name */
    public static final i3.g1 f5191q;

    /* renamed from: r  reason: collision with root package name */
    public static final i3.g1 f5192r;

    /* renamed from: s  reason: collision with root package name */
    public static final c.C0069c<Boolean> f5193s;

    /* renamed from: t  reason: collision with root package name */
    private static final i3.k f5194t;

    /* renamed from: u  reason: collision with root package name */
    public static final k2.d<Executor> f5195u;

    /* renamed from: v  reason: collision with root package name */
    public static final k2.d<ScheduledExecutorService> f5196v;

    /* renamed from: w  reason: collision with root package name */
    public static final z0.o<z0.m> f5197w;

    /* loaded from: classes.dex */
    class a implements i3.g1 {
        a() {
        }

        @Override // i3.g1
        public i3.f1 a(SocketAddress socketAddress) {
            return null;
        }
    }

    /* loaded from: classes.dex */
    class b extends i3.k {
        b() {
        }
    }

    /* loaded from: classes.dex */
    class c implements k2.d<Executor> {
        c() {
        }

        @Override // io.grpc.internal.k2.d
        /* renamed from: c */
        public void b(Executor executor) {
            ((ExecutorService) executor).shutdown();
        }

        @Override // io.grpc.internal.k2.d
        /* renamed from: d */
        public Executor a() {
            return Executors.newCachedThreadPool(t0.i("grpc-default-executor-%d", true));
        }

        public String toString() {
            return "grpc-default-executor";
        }
    }

    /* loaded from: classes.dex */
    class d implements k2.d<ScheduledExecutorService> {
        d() {
        }

        @Override // io.grpc.internal.k2.d
        /* renamed from: c */
        public void b(ScheduledExecutorService scheduledExecutorService) {
            scheduledExecutorService.shutdown();
        }

        @Override // io.grpc.internal.k2.d
        /* renamed from: d */
        public ScheduledExecutorService a() {
            ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(1, t0.i("grpc-timer-%d", true));
            try {
                newScheduledThreadPool.getClass().getMethod("setRemoveOnCancelPolicy", Boolean.TYPE).invoke(newScheduledThreadPool, Boolean.TRUE);
            } catch (NoSuchMethodException unused) {
            } catch (RuntimeException e5) {
                throw e5;
            } catch (Exception e6) {
                throw new RuntimeException(e6);
            }
            return Executors.unconfigurableScheduledExecutorService(newScheduledThreadPool);
        }
    }

    /* loaded from: classes.dex */
    class e implements z0.o<z0.m> {
        e() {
        }

        @Override // z0.o
        /* renamed from: a */
        public z0.m get() {
            return z0.m.c();
        }
    }

    /* loaded from: classes.dex */
    class f implements u {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ k.a f5198a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ u f5199b;

        f(k.a aVar, u uVar) {
            this.f5198a = aVar;
            this.f5199b = uVar;
        }

        @Override // io.grpc.internal.u
        public s c(i3.z0<?, ?> z0Var, i3.y0 y0Var, i3.c cVar, i3.k[] kVarArr) {
            i3.k a5 = this.f5198a.a(k.b.a().b(cVar).a(), y0Var);
            z0.k.u(kVarArr[kVarArr.length - 1] == t0.f5194t, "lb tracer already assigned");
            kVarArr[kVarArr.length - 1] = a5;
            return this.f5199b.c(z0Var, y0Var, cVar, kVarArr);
        }

        @Override // i3.p0
        public i3.j0 e() {
            return this.f5199b.e();
        }
    }

    /* loaded from: classes.dex */
    private static final class g implements m0.a<byte[]> {
        private g() {
        }

        /* synthetic */ g(a aVar) {
            this();
        }

        @Override // i3.y0.j
        /* renamed from: c */
        public byte[] b(byte[] bArr) {
            return bArr;
        }

        @Override // i3.y0.j
        /* renamed from: d */
        public byte[] a(byte[] bArr) {
            return bArr;
        }
    }

    /* JADX WARN: Enum visitor error
    jadx.core.utils.exceptions.JadxRuntimeException: Init of enum c uses external variables
    	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:444)
    	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:391)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:320)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:258)
    	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
    	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
     */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes.dex */
    public static final class h {

        /* renamed from: c  reason: collision with root package name */
        public static final h f5200c;

        /* renamed from: d  reason: collision with root package name */
        public static final h f5201d;

        /* renamed from: e  reason: collision with root package name */
        public static final h f5202e;

        /* renamed from: f  reason: collision with root package name */
        public static final h f5203f;

        /* renamed from: k  reason: collision with root package name */
        public static final h f5204k;

        /* renamed from: l  reason: collision with root package name */
        public static final h f5205l;

        /* renamed from: m  reason: collision with root package name */
        public static final h f5206m;

        /* renamed from: n  reason: collision with root package name */
        public static final h f5207n;

        /* renamed from: o  reason: collision with root package name */
        public static final h f5208o;

        /* renamed from: p  reason: collision with root package name */
        public static final h f5209p;

        /* renamed from: q  reason: collision with root package name */
        public static final h f5210q;

        /* renamed from: r  reason: collision with root package name */
        public static final h f5211r;

        /* renamed from: s  reason: collision with root package name */
        public static final h f5212s;

        /* renamed from: t  reason: collision with root package name */
        public static final h f5213t;

        /* renamed from: u  reason: collision with root package name */
        private static final h[] f5214u;

        /* renamed from: v  reason: collision with root package name */
        private static final /* synthetic */ h[] f5215v;

        /* renamed from: a  reason: collision with root package name */
        private final int f5216a;

        /* renamed from: b  reason: collision with root package name */
        private final i3.j1 f5217b;

        static {
            i3.j1 j1Var = i3.j1.f3447u;
            h hVar = new h("NO_ERROR", 0, 0, j1Var);
            f5200c = hVar;
            i3.j1 j1Var2 = i3.j1.f3446t;
            h hVar2 = new h("PROTOCOL_ERROR", 1, 1, j1Var2);
            f5201d = hVar2;
            h hVar3 = new h("INTERNAL_ERROR", 2, 2, j1Var2);
            f5202e = hVar3;
            h hVar4 = new h("FLOW_CONTROL_ERROR", 3, 3, j1Var2);
            f5203f = hVar4;
            h hVar5 = new h("SETTINGS_TIMEOUT", 4, 4, j1Var2);
            f5204k = hVar5;
            h hVar6 = new h("STREAM_CLOSED", 5, 5, j1Var2);
            f5205l = hVar6;
            h hVar7 = new h("FRAME_SIZE_ERROR", 6, 6, j1Var2);
            f5206m = hVar7;
            h hVar8 = new h("REFUSED_STREAM", 7, 7, j1Var);
            f5207n = hVar8;
            h hVar9 = new h("CANCEL", 8, 8, i3.j1.f3433g);
            f5208o = hVar9;
            h hVar10 = new h("COMPRESSION_ERROR", 9, 9, j1Var2);
            f5209p = hVar10;
            h hVar11 = new h("CONNECT_ERROR", 10, 10, j1Var2);
            f5210q = hVar11;
            h hVar12 = new h("ENHANCE_YOUR_CALM", 11, 11, i3.j1.f3441o.q("Bandwidth exhausted"));
            f5211r = hVar12;
            h hVar13 = new h("INADEQUATE_SECURITY", 12, 12, i3.j1.f3439m.q("Permission denied as protocol is not secure enough to call"));
            f5212s = hVar13;
            h hVar14 = new h("HTTP_1_1_REQUIRED", 13, 13, i3.j1.f3434h);
            f5213t = hVar14;
            f5215v = new h[]{hVar, hVar2, hVar3, hVar4, hVar5, hVar6, hVar7, hVar8, hVar9, hVar10, hVar11, hVar12, hVar13, hVar14};
            f5214u = a();
        }

        private h(String str, int i5, int i6, i3.j1 j1Var) {
            this.f5216a = i6;
            String str2 = "HTTP/2 error code: " + name();
            if (j1Var.n() != null) {
                str2 = str2 + " (" + j1Var.n() + ")";
            }
            this.f5217b = j1Var.q(str2);
        }

        private static h[] a() {
            h[] values = values();
            h[] hVarArr = new h[((int) values[values.length - 1].c()) + 1];
            for (h hVar : values) {
                hVarArr[(int) hVar.c()] = hVar;
            }
            return hVarArr;
        }

        public static h d(long j5) {
            h[] hVarArr = f5214u;
            if (j5 >= hVarArr.length || j5 < 0) {
                return null;
            }
            return hVarArr[(int) j5];
        }

        public static i3.j1 h(long j5) {
            h d5 = d(j5);
            if (d5 == null) {
                i3.j1 h5 = i3.j1.h(f5202e.e().m().d());
                return h5.q("Unrecognized HTTP/2 error code: " + j5);
            }
            return d5.e();
        }

        public static h valueOf(String str) {
            return (h) Enum.valueOf(h.class, str);
        }

        public static h[] values() {
            return (h[]) f5215v.clone();
        }

        public long c() {
            return this.f5216a;
        }

        public i3.j1 e() {
            return this.f5217b;
        }
    }

    /* loaded from: classes.dex */
    static class i implements y0.d<Long> {
        i() {
        }

        @Override // i3.y0.d
        /* renamed from: c */
        public Long b(String str) {
            TimeUnit timeUnit;
            z0.k.e(str.length() > 0, "empty timeout");
            z0.k.e(str.length() <= 9, "bad timeout format");
            long parseLong = Long.parseLong(str.substring(0, str.length() - 1));
            char charAt = str.charAt(str.length() - 1);
            if (charAt == 'H') {
                timeUnit = TimeUnit.HOURS;
            } else if (charAt == 'M') {
                timeUnit = TimeUnit.MINUTES;
            } else if (charAt == 'S') {
                timeUnit = TimeUnit.SECONDS;
            } else if (charAt == 'u') {
                timeUnit = TimeUnit.MICROSECONDS;
            } else if (charAt != 'm') {
                if (charAt == 'n') {
                    return Long.valueOf(parseLong);
                }
                throw new IllegalArgumentException(String.format("Invalid timeout unit: %s", Character.valueOf(charAt)));
            } else {
                timeUnit = TimeUnit.MILLISECONDS;
            }
            return Long.valueOf(timeUnit.toNanos(parseLong));
        }

        @Override // i3.y0.d
        /* renamed from: d */
        public String a(Long l5) {
            TimeUnit timeUnit = TimeUnit.NANOSECONDS;
            if (l5.longValue() >= 0) {
                if (l5.longValue() < 100000000) {
                    return l5 + "n";
                } else if (l5.longValue() < 100000000000L) {
                    return timeUnit.toMicros(l5.longValue()) + "u";
                } else if (l5.longValue() < 100000000000000L) {
                    return timeUnit.toMillis(l5.longValue()) + "m";
                } else if (l5.longValue() < 100000000000000000L) {
                    return timeUnit.toSeconds(l5.longValue()) + "S";
                } else if (l5.longValue() < 6000000000000000000L) {
                    return timeUnit.toMinutes(l5.longValue()) + "M";
                } else {
                    return timeUnit.toHours(l5.longValue()) + "H";
                }
            }
            throw new IllegalArgumentException("Timeout too small");
        }
    }

    static {
        y0.d<String> dVar = i3.y0.f3588e;
        f5179e = y0.g.e("grpc-encoding", dVar);
        f5180f = i3.m0.b("grpc-accept-encoding", new g(null));
        f5181g = y0.g.e("content-encoding", dVar);
        f5182h = i3.m0.b("accept-encoding", new g(null));
        f5183i = y0.g.e("content-length", dVar);
        f5184j = y0.g.e("content-type", dVar);
        f5185k = y0.g.e("te", dVar);
        f5186l = y0.g.e("user-agent", dVar);
        f5187m = z0.l.a(',').c();
        TimeUnit timeUnit = TimeUnit.SECONDS;
        f5188n = timeUnit.toNanos(20L);
        f5189o = TimeUnit.HOURS.toNanos(2L);
        f5190p = timeUnit.toNanos(20L);
        f5191q = new w1();
        f5192r = new a();
        f5193s = c.C0069c.b("io.grpc.internal.CALL_OPTIONS_RPC_OWNED_BY_BALANCER");
        f5194t = new b();
        f5195u = new c();
        f5196v = new d();
        f5197w = new e();
    }

    private t0() {
    }

    public static URI b(String str) {
        z0.k.o(str, "authority");
        try {
            return new URI(null, str, null, null, null);
        } catch (URISyntaxException e5) {
            throw new IllegalArgumentException("Invalid authority: " + str, e5);
        }
    }

    public static String c(String str) {
        URI b5 = b(str);
        z0.k.j(b5.getHost() != null, "No host in authority '%s'", str);
        z0.k.j(b5.getUserInfo() == null, "Userinfo must not be present on authority: '%s'", str);
        return str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void d(p2.a aVar) {
        while (true) {
            InputStream next = aVar.next();
            if (next == null) {
                return;
            }
            e(next);
        }
    }

    public static void e(Closeable closeable) {
        if (closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (IOException e5) {
            f5175a.log(Level.WARNING, "exception caught in closeQuietly", (Throwable) e5);
        }
    }

    public static i3.k[] f(i3.c cVar, i3.y0 y0Var, int i5, boolean z4) {
        List<k.a> i6 = cVar.i();
        int size = i6.size() + 1;
        i3.k[] kVarArr = new i3.k[size];
        k.b a5 = k.b.a().b(cVar).d(i5).c(z4).a();
        for (int i7 = 0; i7 < i6.size(); i7++) {
            kVarArr[i7] = i6.get(i7).a(a5, y0Var);
        }
        kVarArr[size - 1] = f5194t;
        return kVarArr;
    }

    public static String g(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        if (str2 != null) {
            sb.append(str2);
            sb.append(' ');
        }
        sb.append("grpc-java-");
        sb.append(str);
        sb.append('/');
        sb.append("1.57.2");
        return sb.toString();
    }

    public static String h(InetSocketAddress inetSocketAddress) {
        try {
            return (String) InetSocketAddress.class.getMethod("getHostString", new Class[0]).invoke(inetSocketAddress, new Object[0]);
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            return inetSocketAddress.getHostName();
        }
    }

    public static ThreadFactory i(String str, boolean z4) {
        return new e1.d().e(z4).f(str).b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static u j(r0.e eVar, boolean z4) {
        r0.h c5 = eVar.c();
        u a5 = c5 != null ? ((s2) c5.e()).a() : null;
        if (a5 != null) {
            k.a b5 = eVar.b();
            return b5 == null ? a5 : new f(b5, a5);
        }
        if (!eVar.a().o()) {
            if (eVar.d()) {
                return new i0(n(eVar.a()), t.a.DROPPED);
            }
            if (!z4) {
                return new i0(n(eVar.a()), t.a.PROCESSED);
            }
        }
        return null;
    }

    private static j1.b k(int i5) {
        if (i5 < 100 || i5 >= 200) {
            if (i5 != 400) {
                if (i5 != 401) {
                    if (i5 != 403) {
                        if (i5 != 404) {
                            if (i5 != 429) {
                                if (i5 != 431) {
                                    switch (i5) {
                                        case 502:
                                        case 503:
                                        case 504:
                                            break;
                                        default:
                                            return j1.b.UNKNOWN;
                                    }
                                }
                            }
                            return j1.b.UNAVAILABLE;
                        }
                        return j1.b.UNIMPLEMENTED;
                    }
                    return j1.b.PERMISSION_DENIED;
                }
                return j1.b.UNAUTHENTICATED;
            }
            return j1.b.INTERNAL;
        }
        return j1.b.INTERNAL;
    }

    public static i3.j1 l(int i5) {
        i3.j1 c5 = k(i5).c();
        return c5.q("HTTP status code " + i5);
    }

    public static boolean m(String str) {
        char charAt;
        if (str != null && 16 <= str.length()) {
            String lowerCase = str.toLowerCase(Locale.US);
            if (lowerCase.startsWith("application/grpc")) {
                return lowerCase.length() == 16 || (charAt = lowerCase.charAt(16)) == '+' || charAt == ';';
            }
            return false;
        }
        return false;
    }

    public static i3.j1 n(i3.j1 j1Var) {
        z0.k.d(j1Var != null);
        if (f5176b.contains(j1Var.m())) {
            i3.j1 j1Var2 = i3.j1.f3446t;
            return j1Var2.q("Inappropriate status code from control plane: " + j1Var.m() + " " + j1Var.n()).p(j1Var.l());
        }
        return j1Var;
    }

    public static boolean o(i3.c cVar) {
        return !Boolean.TRUE.equals(cVar.h(f5193s));
    }
}
