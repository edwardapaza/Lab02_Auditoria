package m4;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
/* loaded from: classes.dex */
final class s1 extends w1 {

    /* renamed from: f  reason: collision with root package name */
    private static final AtomicIntegerFieldUpdater f6276f = AtomicIntegerFieldUpdater.newUpdater(s1.class, "_invoked");
    private volatile int _invoked;

    /* renamed from: e  reason: collision with root package name */
    private final d4.l<Throwable, s3.t> f6277e;

    /* JADX WARN: Multi-variable type inference failed */
    public s1(d4.l<? super Throwable, s3.t> lVar) {
        this.f6277e = lVar;
    }

    @Override // d4.l
    public /* bridge */ /* synthetic */ s3.t invoke(Throwable th) {
        u(th);
        return s3.t.f7573a;
    }

    @Override // m4.b0
    public void u(Throwable th) {
        if (f6276f.compareAndSet(this, 0, 1)) {
            this.f6277e.invoke(th);
        }
    }
}
