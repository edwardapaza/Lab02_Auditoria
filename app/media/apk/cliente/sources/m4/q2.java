package m4;
/* loaded from: classes.dex */
public final class q2 {

    /* renamed from: a  reason: collision with root package name */
    public static final q2 f6272a = new q2();

    /* renamed from: b  reason: collision with root package name */
    private static final ThreadLocal<f1> f6273b = r4.m0.a(new r4.h0("ThreadLocalEventLoop"));

    private q2() {
    }

    public final f1 a() {
        ThreadLocal<f1> threadLocal = f6273b;
        f1 f1Var = threadLocal.get();
        if (f1Var == null) {
            f1 a5 = i1.a();
            threadLocal.set(a5);
            return a5;
        }
        return f1Var;
    }

    public final void b() {
        f6273b.set(null);
    }

    public final void c(f1 f1Var) {
        f6273b.set(f1Var);
    }
}
