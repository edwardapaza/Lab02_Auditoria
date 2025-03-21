package t4;

import java.util.concurrent.Executor;
import m4.g0;
import m4.l1;
import r4.i0;
import r4.k0;
/* loaded from: classes.dex */
public final class b extends l1 implements Executor {

    /* renamed from: d  reason: collision with root package name */
    public static final b f7676d = new b();

    /* renamed from: e  reason: collision with root package name */
    private static final g0 f7677e;

    static {
        int a5;
        int e5;
        m mVar = m.f7697c;
        a5 = h4.l.a(64, i0.a());
        e5 = k0.e("kotlinx.coroutines.io.parallelism", a5, 0, 0, 12, null);
        f7677e = mVar.h0(e5);
    }

    private b() {
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        throw new IllegalStateException("Cannot be invoked on Dispatchers.IO".toString());
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        f0(v3.h.f8175a, runnable);
    }

    @Override // m4.g0
    public void f0(v3.g gVar, Runnable runnable) {
        f7677e.f0(gVar, runnable);
    }

    @Override // m4.g0
    public String toString() {
        return "Dispatchers.IO";
    }
}
