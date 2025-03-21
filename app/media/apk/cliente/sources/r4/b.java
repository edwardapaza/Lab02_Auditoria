package r4;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
/* loaded from: classes.dex */
public abstract class b<T> extends a0 {

    /* renamed from: a  reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater f7179a = AtomicReferenceFieldUpdater.newUpdater(b.class, Object.class, "_consensus");
    private volatile Object _consensus = a.f7178a;

    private final Object c(Object obj) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f7179a;
        Object obj2 = atomicReferenceFieldUpdater.get(this);
        Object obj3 = a.f7178a;
        return obj2 != obj3 ? obj2 : androidx.concurrent.futures.b.a(atomicReferenceFieldUpdater, this, obj3, obj) ? obj : atomicReferenceFieldUpdater.get(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // r4.a0
    public final Object a(Object obj) {
        Object obj2 = f7179a.get(this);
        if (obj2 == a.f7178a) {
            obj2 = c(d(obj));
        }
        b(obj, obj2);
        return obj2;
    }

    public abstract void b(T t5, Object obj);

    public abstract Object d(T t5);
}
