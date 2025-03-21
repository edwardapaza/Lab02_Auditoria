package i3;

import java.util.Arrays;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
/* loaded from: classes.dex */
public final class t implements Comparable<t> {

    /* renamed from: d  reason: collision with root package name */
    private static final b f3559d = new b();

    /* renamed from: e  reason: collision with root package name */
    private static final long f3560e;

    /* renamed from: f  reason: collision with root package name */
    private static final long f3561f;

    /* renamed from: k  reason: collision with root package name */
    private static final long f3562k;

    /* renamed from: a  reason: collision with root package name */
    private final c f3563a;

    /* renamed from: b  reason: collision with root package name */
    private final long f3564b;

    /* renamed from: c  reason: collision with root package name */
    private volatile boolean f3565c;

    /* loaded from: classes.dex */
    private static class b extends c {
        private b() {
        }

        @Override // i3.t.c
        public long a() {
            return System.nanoTime();
        }
    }

    /* loaded from: classes.dex */
    public static abstract class c {
        public abstract long a();
    }

    static {
        long nanos = TimeUnit.DAYS.toNanos(36500L);
        f3560e = nanos;
        f3561f = -nanos;
        f3562k = TimeUnit.SECONDS.toNanos(1L);
    }

    private t(c cVar, long j5, long j6, boolean z4) {
        this.f3563a = cVar;
        long min = Math.min(f3560e, Math.max(f3561f, j6));
        this.f3564b = j5 + min;
        this.f3565c = z4 && min <= 0;
    }

    private t(c cVar, long j5, boolean z4) {
        this(cVar, cVar.a(), j5, z4);
    }

    public static t a(long j5, TimeUnit timeUnit) {
        return c(j5, timeUnit, f3559d);
    }

    public static t c(long j5, TimeUnit timeUnit, c cVar) {
        d(timeUnit, "units");
        return new t(cVar, timeUnit.toNanos(j5), true);
    }

    private static <T> T d(T t5, Object obj) {
        if (t5 != null) {
            return t5;
        }
        throw new NullPointerException(String.valueOf(obj));
    }

    private void e(t tVar) {
        if (this.f3563a == tVar.f3563a) {
            return;
        }
        throw new AssertionError("Tickers (" + this.f3563a + " and " + tVar.f3563a + ") don't match. Custom Ticker should only be used in tests!");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof t) {
            t tVar = (t) obj;
            c cVar = this.f3563a;
            if (cVar != null ? cVar == tVar.f3563a : tVar.f3563a == null) {
                return this.f3564b == tVar.f3564b;
            }
            return false;
        }
        return false;
    }

    @Override // java.lang.Comparable
    /* renamed from: h */
    public int compareTo(t tVar) {
        e(tVar);
        int i5 = ((this.f3564b - tVar.f3564b) > 0L ? 1 : ((this.f3564b - tVar.f3564b) == 0L ? 0 : -1));
        if (i5 < 0) {
            return -1;
        }
        return i5 > 0 ? 1 : 0;
    }

    public int hashCode() {
        return Arrays.asList(this.f3563a, Long.valueOf(this.f3564b)).hashCode();
    }

    public boolean k(t tVar) {
        e(tVar);
        return this.f3564b - tVar.f3564b < 0;
    }

    public boolean m() {
        if (!this.f3565c) {
            if (this.f3564b - this.f3563a.a() > 0) {
                return false;
            }
            this.f3565c = true;
        }
        return true;
    }

    public t n(t tVar) {
        e(tVar);
        return k(tVar) ? this : tVar;
    }

    public long o(TimeUnit timeUnit) {
        long a5 = this.f3563a.a();
        if (!this.f3565c && this.f3564b - a5 <= 0) {
            this.f3565c = true;
        }
        return timeUnit.convert(this.f3564b - a5, TimeUnit.NANOSECONDS);
    }

    public String toString() {
        long o5 = o(TimeUnit.NANOSECONDS);
        long abs = Math.abs(o5);
        long j5 = f3562k;
        long j6 = abs / j5;
        long abs2 = Math.abs(o5) % j5;
        StringBuilder sb = new StringBuilder();
        if (o5 < 0) {
            sb.append('-');
        }
        sb.append(j6);
        if (abs2 > 0) {
            sb.append(String.format(Locale.US, ".%09d", Long.valueOf(abs2)));
        }
        sb.append("s from now");
        if (this.f3563a != f3559d) {
            sb.append(" (ticker=" + this.f3563a + ")");
        }
        return sb.toString();
    }
}
