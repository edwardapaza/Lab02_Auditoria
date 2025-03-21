package i3;

import i3.y;
import java.util.concurrent.TimeUnit;
/* loaded from: classes.dex */
public abstract class y<T extends y<T>> extends v0<T> {
    protected abstract v0<?> e();

    @Override // i3.v0
    /* renamed from: f */
    public T c(long j5, TimeUnit timeUnit) {
        e().c(j5, timeUnit);
        return g();
    }

    protected final T g() {
        return this;
    }

    @Override // i3.v0
    /* renamed from: h */
    public T d() {
        e().d();
        return g();
    }

    public String toString() {
        return z0.f.b(this).d("delegate", e()).toString();
    }
}
