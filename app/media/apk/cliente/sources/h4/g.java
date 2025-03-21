package h4;

import t3.d0;
/* loaded from: classes.dex */
public class g implements Iterable<Long> {

    /* renamed from: d  reason: collision with root package name */
    public static final a f3136d = new a(null);

    /* renamed from: a  reason: collision with root package name */
    private final long f3137a;

    /* renamed from: b  reason: collision with root package name */
    private final long f3138b;

    /* renamed from: c  reason: collision with root package name */
    private final long f3139c;

    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(e4.g gVar) {
            this();
        }
    }

    public g(long j5, long j6, long j7) {
        if (j7 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (j7 == Long.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Long.MIN_VALUE to avoid overflow on negation.");
        }
        this.f3137a = j5;
        this.f3138b = y3.c.d(j5, j6, j7);
        this.f3139c = j7;
    }

    public final long g() {
        return this.f3137a;
    }

    public final long h() {
        return this.f3138b;
    }

    @Override // java.lang.Iterable
    /* renamed from: i */
    public d0 iterator() {
        return new h(this.f3137a, this.f3138b, this.f3139c);
    }
}
