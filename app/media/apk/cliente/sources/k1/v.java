package k1;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
/* loaded from: classes.dex */
class v implements p1.d, p1.c {

    /* renamed from: a  reason: collision with root package name */
    private final Map<Class<?>, ConcurrentHashMap<p1.b<Object>, Executor>> f5614a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private Queue<p1.a<?>> f5615b = new ArrayDeque();

    /* renamed from: c  reason: collision with root package name */
    private final Executor f5616c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(Executor executor) {
        this.f5616c = executor;
    }

    private synchronized Set<Map.Entry<p1.b<Object>, Executor>> d(p1.a<?> aVar) {
        ConcurrentHashMap<p1.b<Object>, Executor> concurrentHashMap;
        concurrentHashMap = this.f5614a.get(aVar.a());
        return concurrentHashMap == null ? Collections.emptySet() : concurrentHashMap.entrySet();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void e(Map.Entry entry, p1.a aVar) {
        ((p1.b) entry.getKey()).a(aVar);
    }

    @Override // p1.c
    public void a(final p1.a<?> aVar) {
        e0.b(aVar);
        synchronized (this) {
            Queue<p1.a<?>> queue = this.f5615b;
            if (queue != null) {
                queue.add(aVar);
                return;
            }
            for (final Map.Entry<p1.b<Object>, Executor> entry : d(aVar)) {
                entry.getValue().execute(new Runnable() { // from class: k1.u
                    @Override // java.lang.Runnable
                    public final void run() {
                        v.e(entry, aVar);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c() {
        Queue<p1.a<?>> queue;
        synchronized (this) {
            queue = this.f5615b;
            if (queue != null) {
                this.f5615b = null;
            } else {
                queue = null;
            }
        }
        if (queue != null) {
            for (p1.a<?> aVar : queue) {
                a(aVar);
            }
        }
    }
}
