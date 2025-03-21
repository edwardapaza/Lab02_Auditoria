package i3;
/* loaded from: classes.dex */
public final class e0 {

    /* renamed from: a  reason: collision with root package name */
    public final String f3392a;

    /* renamed from: b  reason: collision with root package name */
    public final b f3393b;

    /* renamed from: c  reason: collision with root package name */
    public final long f3394c;

    /* renamed from: d  reason: collision with root package name */
    public final p0 f3395d;

    /* renamed from: e  reason: collision with root package name */
    public final p0 f3396e;

    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private String f3397a;

        /* renamed from: b  reason: collision with root package name */
        private b f3398b;

        /* renamed from: c  reason: collision with root package name */
        private Long f3399c;

        /* renamed from: d  reason: collision with root package name */
        private p0 f3400d;

        /* renamed from: e  reason: collision with root package name */
        private p0 f3401e;

        public e0 a() {
            z0.k.o(this.f3397a, "description");
            z0.k.o(this.f3398b, "severity");
            z0.k.o(this.f3399c, "timestampNanos");
            z0.k.u(this.f3400d == null || this.f3401e == null, "at least one of channelRef and subchannelRef must be null");
            return new e0(this.f3397a, this.f3398b, this.f3399c.longValue(), this.f3400d, this.f3401e);
        }

        public a b(String str) {
            this.f3397a = str;
            return this;
        }

        public a c(b bVar) {
            this.f3398b = bVar;
            return this;
        }

        public a d(p0 p0Var) {
            this.f3401e = p0Var;
            return this;
        }

        public a e(long j5) {
            this.f3399c = Long.valueOf(j5);
            return this;
        }
    }

    /* loaded from: classes.dex */
    public enum b {
        CT_UNKNOWN,
        CT_INFO,
        CT_WARNING,
        CT_ERROR
    }

    private e0(String str, b bVar, long j5, p0 p0Var, p0 p0Var2) {
        this.f3392a = str;
        this.f3393b = (b) z0.k.o(bVar, "severity");
        this.f3394c = j5;
        this.f3395d = p0Var;
        this.f3396e = p0Var2;
    }

    public boolean equals(Object obj) {
        if (obj instanceof e0) {
            e0 e0Var = (e0) obj;
            return z0.g.a(this.f3392a, e0Var.f3392a) && z0.g.a(this.f3393b, e0Var.f3393b) && this.f3394c == e0Var.f3394c && z0.g.a(this.f3395d, e0Var.f3395d) && z0.g.a(this.f3396e, e0Var.f3396e);
        }
        return false;
    }

    public int hashCode() {
        return z0.g.b(this.f3392a, this.f3393b, Long.valueOf(this.f3394c), this.f3395d, this.f3396e);
    }

    public String toString() {
        return z0.f.b(this).d("description", this.f3392a).d("severity", this.f3393b).c("timestampNanos", this.f3394c).d("channelRef", this.f3395d).d("subchannelRef", this.f3396e).toString();
    }
}
