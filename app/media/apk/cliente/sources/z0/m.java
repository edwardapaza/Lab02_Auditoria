package z0;

import java.util.concurrent.TimeUnit;
/* loaded from: classes.dex */
public final class m {

    /* renamed from: a  reason: collision with root package name */
    private final q f8884a = q.b();

    /* renamed from: b  reason: collision with root package name */
    private boolean f8885b;

    /* renamed from: c  reason: collision with root package name */
    private long f8886c;

    /* renamed from: d  reason: collision with root package name */
    private long f8887d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f8888a;

        static {
            int[] iArr = new int[TimeUnit.values().length];
            f8888a = iArr;
            try {
                iArr[TimeUnit.NANOSECONDS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f8888a[TimeUnit.MICROSECONDS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f8888a[TimeUnit.MILLISECONDS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f8888a[TimeUnit.SECONDS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f8888a[TimeUnit.MINUTES.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f8888a[TimeUnit.HOURS.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f8888a[TimeUnit.DAYS.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    m() {
    }

    private static String a(TimeUnit timeUnit) {
        switch (a.f8888a[timeUnit.ordinal()]) {
            case 1:
                return "ns";
            case 2:
                return "μs";
            case 3:
                return "ms";
            case 4:
                return "s";
            case 5:
                return "min";
            case 6:
                return "h";
            case 7:
                return "d";
            default:
                throw new AssertionError();
        }
    }

    private static TimeUnit b(long j5) {
        TimeUnit timeUnit = TimeUnit.DAYS;
        TimeUnit timeUnit2 = TimeUnit.NANOSECONDS;
        if (timeUnit.convert(j5, timeUnit2) > 0) {
            return timeUnit;
        }
        TimeUnit timeUnit3 = TimeUnit.HOURS;
        if (timeUnit3.convert(j5, timeUnit2) > 0) {
            return timeUnit3;
        }
        TimeUnit timeUnit4 = TimeUnit.MINUTES;
        if (timeUnit4.convert(j5, timeUnit2) > 0) {
            return timeUnit4;
        }
        TimeUnit timeUnit5 = TimeUnit.SECONDS;
        if (timeUnit5.convert(j5, timeUnit2) > 0) {
            return timeUnit5;
        }
        TimeUnit timeUnit6 = TimeUnit.MILLISECONDS;
        if (timeUnit6.convert(j5, timeUnit2) > 0) {
            return timeUnit6;
        }
        TimeUnit timeUnit7 = TimeUnit.MICROSECONDS;
        return timeUnit7.convert(j5, timeUnit2) > 0 ? timeUnit7 : timeUnit2;
    }

    public static m c() {
        return new m();
    }

    private long e() {
        return this.f8885b ? (this.f8884a.a() - this.f8887d) + this.f8886c : this.f8886c;
    }

    public long d(TimeUnit timeUnit) {
        return timeUnit.convert(e(), TimeUnit.NANOSECONDS);
    }

    public m f() {
        this.f8886c = 0L;
        this.f8885b = false;
        return this;
    }

    public m g() {
        k.u(!this.f8885b, "This stopwatch is already running.");
        this.f8885b = true;
        this.f8887d = this.f8884a.a();
        return this;
    }

    public String toString() {
        long e5 = e();
        TimeUnit b5 = b(e5);
        double convert = e5 / TimeUnit.NANOSECONDS.convert(1L, b5);
        return j.a(convert) + " " + a(b5);
    }
}
