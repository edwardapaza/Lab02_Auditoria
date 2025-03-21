package m4;

import java.util.concurrent.Future;
/* loaded from: classes.dex */
final class a1 implements b1 {

    /* renamed from: a  reason: collision with root package name */
    private final Future<?> f6178a;

    public a1(Future<?> future) {
        this.f6178a = future;
    }

    @Override // m4.b1
    public void a() {
        this.f6178a.cancel(false);
    }

    public String toString() {
        return "DisposableFutureHandle[" + this.f6178a + ']';
    }
}
