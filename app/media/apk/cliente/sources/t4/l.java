package t4;

import java.util.concurrent.TimeUnit;
import r4.i0;
import r4.k0;
/* loaded from: classes.dex */
public final class l {

    /* renamed from: a  reason: collision with root package name */
    public static final String f7689a = i0.e("kotlinx.coroutines.scheduler.default.name", "DefaultDispatcher");

    /* renamed from: b  reason: collision with root package name */
    public static final long f7690b;

    /* renamed from: c  reason: collision with root package name */
    public static final int f7691c;

    /* renamed from: d  reason: collision with root package name */
    public static final int f7692d;

    /* renamed from: e  reason: collision with root package name */
    public static final long f7693e;

    /* renamed from: f  reason: collision with root package name */
    public static g f7694f;

    /* renamed from: g  reason: collision with root package name */
    public static final i f7695g;

    /* renamed from: h  reason: collision with root package name */
    public static final i f7696h;

    static {
        long f5;
        int a5;
        int e5;
        int e6;
        long f6;
        f5 = k0.f("kotlinx.coroutines.scheduler.resolution.ns", 100000L, 0L, 0L, 12, null);
        f7690b = f5;
        a5 = h4.l.a(i0.a(), 2);
        e5 = k0.e("kotlinx.coroutines.scheduler.core.pool.size", a5, 1, 0, 8, null);
        f7691c = e5;
        e6 = k0.e("kotlinx.coroutines.scheduler.max.pool.size", 2097150, 0, 2097150, 4, null);
        f7692d = e6;
        TimeUnit timeUnit = TimeUnit.SECONDS;
        f6 = k0.f("kotlinx.coroutines.scheduler.keep.alive.sec", 60L, 0L, 0L, 12, null);
        f7693e = timeUnit.toNanos(f6);
        f7694f = e.f7679a;
        f7695g = new j(0);
        f7696h = new j(1);
    }
}
