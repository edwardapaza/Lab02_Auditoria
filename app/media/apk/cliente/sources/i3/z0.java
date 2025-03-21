package i3;

import java.io.InputStream;
import java.util.concurrent.atomic.AtomicReferenceArray;
/* loaded from: classes.dex */
public final class z0<ReqT, RespT> {

    /* renamed from: a  reason: collision with root package name */
    private final d f3602a;

    /* renamed from: b  reason: collision with root package name */
    private final String f3603b;

    /* renamed from: c  reason: collision with root package name */
    private final String f3604c;

    /* renamed from: d  reason: collision with root package name */
    private final c<ReqT> f3605d;

    /* renamed from: e  reason: collision with root package name */
    private final c<RespT> f3606e;

    /* renamed from: f  reason: collision with root package name */
    private final Object f3607f;

    /* renamed from: g  reason: collision with root package name */
    private final boolean f3608g;

    /* renamed from: h  reason: collision with root package name */
    private final boolean f3609h;

    /* renamed from: i  reason: collision with root package name */
    private final boolean f3610i;

    /* renamed from: j  reason: collision with root package name */
    private final AtomicReferenceArray<Object> f3611j;

    /* loaded from: classes.dex */
    public static final class b<ReqT, RespT> {

        /* renamed from: a  reason: collision with root package name */
        private c<ReqT> f3612a;

        /* renamed from: b  reason: collision with root package name */
        private c<RespT> f3613b;

        /* renamed from: c  reason: collision with root package name */
        private d f3614c;

        /* renamed from: d  reason: collision with root package name */
        private String f3615d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f3616e;

        /* renamed from: f  reason: collision with root package name */
        private boolean f3617f;

        /* renamed from: g  reason: collision with root package name */
        private Object f3618g;

        /* renamed from: h  reason: collision with root package name */
        private boolean f3619h;

        private b() {
        }

        public z0<ReqT, RespT> a() {
            return new z0<>(this.f3614c, this.f3615d, this.f3612a, this.f3613b, this.f3618g, this.f3616e, this.f3617f, this.f3619h);
        }

        public b<ReqT, RespT> b(String str) {
            this.f3615d = str;
            return this;
        }

        public b<ReqT, RespT> c(c<ReqT> cVar) {
            this.f3612a = cVar;
            return this;
        }

        public b<ReqT, RespT> d(c<RespT> cVar) {
            this.f3613b = cVar;
            return this;
        }

        public b<ReqT, RespT> e(boolean z4) {
            this.f3619h = z4;
            return this;
        }

        public b<ReqT, RespT> f(d dVar) {
            this.f3614c = dVar;
            return this;
        }
    }

    /* loaded from: classes.dex */
    public interface c<T> {
        InputStream a(T t5);

        T b(InputStream inputStream);
    }

    /* loaded from: classes.dex */
    public enum d {
        UNARY,
        CLIENT_STREAMING,
        SERVER_STREAMING,
        BIDI_STREAMING,
        UNKNOWN;

        public final boolean a() {
            return this == UNARY || this == SERVER_STREAMING;
        }
    }

    private z0(d dVar, String str, c<ReqT> cVar, c<RespT> cVar2, Object obj, boolean z4, boolean z5, boolean z6) {
        this.f3611j = new AtomicReferenceArray<>(2);
        this.f3602a = (d) z0.k.o(dVar, "type");
        this.f3603b = (String) z0.k.o(str, "fullMethodName");
        this.f3604c = a(str);
        this.f3605d = (c) z0.k.o(cVar, "requestMarshaller");
        this.f3606e = (c) z0.k.o(cVar2, "responseMarshaller");
        this.f3607f = obj;
        this.f3608g = z4;
        this.f3609h = z5;
        this.f3610i = z6;
    }

    public static String a(String str) {
        int lastIndexOf = ((String) z0.k.o(str, "fullMethodName")).lastIndexOf(47);
        if (lastIndexOf == -1) {
            return null;
        }
        return str.substring(0, lastIndexOf);
    }

    public static String b(String str, String str2) {
        return ((String) z0.k.o(str, "fullServiceName")) + "/" + ((String) z0.k.o(str2, "methodName"));
    }

    public static <ReqT, RespT> b<ReqT, RespT> g() {
        return h(null, null);
    }

    public static <ReqT, RespT> b<ReqT, RespT> h(c<ReqT> cVar, c<RespT> cVar2) {
        return new b().c(cVar).d(cVar2);
    }

    public String c() {
        return this.f3603b;
    }

    public String d() {
        return this.f3604c;
    }

    public d e() {
        return this.f3602a;
    }

    public boolean f() {
        return this.f3609h;
    }

    public RespT i(InputStream inputStream) {
        return this.f3606e.b(inputStream);
    }

    public InputStream j(ReqT reqt) {
        return this.f3605d.a(reqt);
    }

    public String toString() {
        return z0.f.b(this).d("fullMethodName", this.f3603b).d("type", this.f3602a).e("idempotent", this.f3608g).e("safe", this.f3609h).e("sampledToLocalTracing", this.f3610i).d("requestMarshaller", this.f3605d).d("responseMarshaller", this.f3606e).d("schemaDescriptor", this.f3607f).k().toString();
    }
}
