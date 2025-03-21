package j4;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes.dex */
public final class a<T> implements b<T> {

    /* renamed from: a  reason: collision with root package name */
    private final AtomicReference<b<T>> f5533a;

    public a(b<? extends T> bVar) {
        e4.k.e(bVar, "sequence");
        this.f5533a = new AtomicReference<>(bVar);
    }

    @Override // j4.b
    public Iterator<T> iterator() {
        b<T> andSet = this.f5533a.getAndSet(null);
        if (andSet != null) {
            return andSet.iterator();
        }
        throw new IllegalStateException("This sequence can be consumed only once.");
    }
}
