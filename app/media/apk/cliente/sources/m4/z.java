package m4;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
/* loaded from: classes.dex */
public class z {

    /* renamed from: b  reason: collision with root package name */
    private static final AtomicIntegerFieldUpdater f6297b = AtomicIntegerFieldUpdater.newUpdater(z.class, "_handled");
    private volatile int _handled;

    /* renamed from: a  reason: collision with root package name */
    public final Throwable f6298a;

    public z(Throwable th, boolean z4) {
        this.f6298a = th;
        this._handled = z4 ? 1 : 0;
    }

    public /* synthetic */ z(Throwable th, boolean z4, int i5, e4.g gVar) {
        this(th, (i5 & 2) != 0 ? false : z4);
    }

    public final boolean a() {
        return f6297b.get(this) != 0;
    }

    public final boolean b() {
        return f6297b.compareAndSet(this, 0, 1);
    }

    public String toString() {
        return n0.a(this) + '[' + this.f6298a + ']';
    }
}
