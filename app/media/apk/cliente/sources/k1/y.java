package k1;

import java.util.Collection;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y<T> implements b2.b<Set<T>> {

    /* renamed from: b  reason: collision with root package name */
    private volatile Set<T> f5621b = null;

    /* renamed from: a  reason: collision with root package name */
    private volatile Set<b2.b<T>> f5620a = Collections.newSetFromMap(new ConcurrentHashMap());

    y(Collection<b2.b<T>> collection) {
        this.f5620a.addAll(collection);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static y<?> b(Collection<b2.b<?>> collection) {
        return new y<>((Set) collection);
    }

    private synchronized void d() {
        for (b2.b<T> bVar : this.f5620a) {
            this.f5621b.add(bVar.get());
        }
        this.f5620a = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void a(b2.b<T> bVar) {
        Set set;
        if (this.f5621b == null) {
            set = this.f5620a;
        } else {
            set = this.f5621b;
            bVar = (b2.b<T>) bVar.get();
        }
        set.add(bVar);
    }

    @Override // b2.b
    /* renamed from: c */
    public Set<T> get() {
        if (this.f5621b == null) {
            synchronized (this) {
                if (this.f5621b == null) {
                    this.f5621b = Collections.newSetFromMap(new ConcurrentHashMap());
                    d();
                }
            }
        }
        return Collections.unmodifiableSet(this.f5621b);
    }
}
