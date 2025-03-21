package k1;

import android.util.Log;
import com.google.android.gms.common.api.internal.m1;
import com.google.firebase.components.ComponentRegistrar;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;
import k1.o;
/* loaded from: classes.dex */
public class o implements e, n1.a {

    /* renamed from: i  reason: collision with root package name */
    private static final b2.b<Set<Object>> f5589i = new b2.b() { // from class: k1.l
        @Override // b2.b
        public final Object get() {
            return Collections.emptySet();
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private final Map<c<?>, b2.b<?>> f5590a;

    /* renamed from: b  reason: collision with root package name */
    private final Map<f0<?>, b2.b<?>> f5591b;

    /* renamed from: c  reason: collision with root package name */
    private final Map<f0<?>, y<?>> f5592c;

    /* renamed from: d  reason: collision with root package name */
    private final List<b2.b<ComponentRegistrar>> f5593d;

    /* renamed from: e  reason: collision with root package name */
    private Set<String> f5594e;

    /* renamed from: f  reason: collision with root package name */
    private final v f5595f;

    /* renamed from: g  reason: collision with root package name */
    private final AtomicReference<Boolean> f5596g;

    /* renamed from: h  reason: collision with root package name */
    private final j f5597h;

    /* loaded from: classes.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private final Executor f5598a;

        /* renamed from: b  reason: collision with root package name */
        private final List<b2.b<ComponentRegistrar>> f5599b = new ArrayList();

        /* renamed from: c  reason: collision with root package name */
        private final List<c<?>> f5600c = new ArrayList();

        /* renamed from: d  reason: collision with root package name */
        private j f5601d = j.f5582a;

        b(Executor executor) {
            this.f5598a = executor;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ ComponentRegistrar f(ComponentRegistrar componentRegistrar) {
            return componentRegistrar;
        }

        public b b(c<?> cVar) {
            this.f5600c.add(cVar);
            return this;
        }

        public b c(final ComponentRegistrar componentRegistrar) {
            this.f5599b.add(new b2.b() { // from class: k1.p
                @Override // b2.b
                public final Object get() {
                    ComponentRegistrar f5;
                    f5 = o.b.f(ComponentRegistrar.this);
                    return f5;
                }
            });
            return this;
        }

        public b d(Collection<b2.b<ComponentRegistrar>> collection) {
            this.f5599b.addAll(collection);
            return this;
        }

        public o e() {
            return new o(this.f5598a, this.f5599b, this.f5600c, this.f5601d);
        }

        public b g(j jVar) {
            this.f5601d = jVar;
            return this;
        }
    }

    private o(Executor executor, Iterable<b2.b<ComponentRegistrar>> iterable, Collection<c<?>> collection, j jVar) {
        this.f5590a = new HashMap();
        this.f5591b = new HashMap();
        this.f5592c = new HashMap();
        this.f5594e = new HashSet();
        this.f5596g = new AtomicReference<>();
        v vVar = new v(executor);
        this.f5595f = vVar;
        this.f5597h = jVar;
        ArrayList arrayList = new ArrayList();
        arrayList.add(c.s(vVar, v.class, p1.d.class, p1.c.class));
        arrayList.add(c.s(this, n1.a.class, new Class[0]));
        for (c<?> cVar : collection) {
            if (cVar != null) {
                arrayList.add(cVar);
            }
        }
        this.f5593d = q(iterable);
        n(arrayList);
    }

    public static b m(Executor executor) {
        return new b(executor);
    }

    private void n(List<c<?>> list) {
        ArrayList<Runnable> arrayList = new ArrayList();
        synchronized (this) {
            Iterator<b2.b<ComponentRegistrar>> it = this.f5593d.iterator();
            while (it.hasNext()) {
                try {
                    ComponentRegistrar componentRegistrar = it.next().get();
                    if (componentRegistrar != null) {
                        list.addAll(this.f5597h.a(componentRegistrar));
                        it.remove();
                    }
                } catch (w e5) {
                    it.remove();
                    Log.w("ComponentDiscovery", "Invalid component registrar.", e5);
                }
            }
            Iterator<c<?>> it2 = list.iterator();
            while (it2.hasNext()) {
                Object[] array = it2.next().j().toArray();
                int length = array.length;
                int i5 = 0;
                while (true) {
                    if (i5 < length) {
                        Object obj = array[i5];
                        if (obj.toString().contains("kotlinx.coroutines.CoroutineDispatcher")) {
                            if (this.f5594e.contains(obj.toString())) {
                                it2.remove();
                                break;
                            }
                            this.f5594e.add(obj.toString());
                        }
                        i5++;
                    }
                }
            }
            if (this.f5590a.isEmpty()) {
                q.a(list);
            } else {
                ArrayList arrayList2 = new ArrayList(this.f5590a.keySet());
                arrayList2.addAll(list);
                q.a(arrayList2);
            }
            for (final c<?> cVar : list) {
                this.f5590a.put(cVar, new x(new b2.b() { // from class: k1.k
                    @Override // b2.b
                    public final Object get() {
                        Object r5;
                        r5 = o.this.r(cVar);
                        return r5;
                    }
                }));
            }
            arrayList.addAll(w(list));
            arrayList.addAll(x());
            v();
        }
        for (Runnable runnable : arrayList) {
            runnable.run();
        }
        u();
    }

    private void o(Map<c<?>, b2.b<?>> map, boolean z4) {
        for (Map.Entry<c<?>, b2.b<?>> entry : map.entrySet()) {
            c<?> key = entry.getKey();
            b2.b<?> value = entry.getValue();
            if (key.n() || (key.o() && z4)) {
                value.get();
            }
        }
        this.f5595f.c();
    }

    private static <T> List<T> q(Iterable<T> iterable) {
        ArrayList arrayList = new ArrayList();
        for (T t5 : iterable) {
            arrayList.add(t5);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object r(c cVar) {
        return cVar.h().a(new g0(cVar, this));
    }

    private void u() {
        Boolean bool = this.f5596g.get();
        if (bool != null) {
            o(this.f5590a, bool.booleanValue());
        }
    }

    private void v() {
        Map map;
        f0<?> c5;
        b2.b e5;
        for (c<?> cVar : this.f5590a.keySet()) {
            for (r rVar : cVar.g()) {
                if (rVar.g() && !this.f5592c.containsKey(rVar.c())) {
                    map = this.f5592c;
                    c5 = rVar.c();
                    e5 = y.b(Collections.emptySet());
                } else if (this.f5591b.containsKey(rVar.c())) {
                    continue;
                } else if (rVar.f()) {
                    throw new z(String.format("Unsatisfied dependency for component %s: %s", cVar, rVar.c()));
                } else {
                    if (!rVar.g()) {
                        map = this.f5591b;
                        c5 = rVar.c();
                        e5 = d0.e();
                    }
                }
                map.put(c5, e5);
            }
        }
    }

    private List<Runnable> w(List<c<?>> list) {
        ArrayList arrayList = new ArrayList();
        for (c<?> cVar : list) {
            if (cVar.p()) {
                final b2.b<?> bVar = this.f5590a.get(cVar);
                for (f0<? super Object> f0Var : cVar.j()) {
                    if (this.f5591b.containsKey(f0Var)) {
                        final d0 d0Var = (d0) this.f5591b.get(f0Var);
                        arrayList.add(new Runnable() { // from class: k1.m
                            @Override // java.lang.Runnable
                            public final void run() {
                                d0.this.j(bVar);
                            }
                        });
                    } else {
                        this.f5591b.put(f0Var, bVar);
                    }
                }
            }
        }
        return arrayList;
    }

    private List<Runnable> x() {
        ArrayList arrayList = new ArrayList();
        HashMap hashMap = new HashMap();
        for (Map.Entry<c<?>, b2.b<?>> entry : this.f5590a.entrySet()) {
            c<?> key = entry.getKey();
            if (!key.p()) {
                b2.b<?> value = entry.getValue();
                for (f0<? super Object> f0Var : key.j()) {
                    if (!hashMap.containsKey(f0Var)) {
                        hashMap.put(f0Var, new HashSet());
                    }
                    ((Set) hashMap.get(f0Var)).add(value);
                }
            }
        }
        for (Map.Entry entry2 : hashMap.entrySet()) {
            if (this.f5592c.containsKey(entry2.getKey())) {
                final y<?> yVar = this.f5592c.get(entry2.getKey());
                for (final b2.b bVar : (Set) entry2.getValue()) {
                    arrayList.add(new Runnable() { // from class: k1.n
                        @Override // java.lang.Runnable
                        public final void run() {
                            y.this.a(bVar);
                        }
                    });
                }
            } else {
                this.f5592c.put((f0) entry2.getKey(), y.b((Collection) entry2.getValue()));
            }
        }
        return arrayList;
    }

    @Override // k1.e
    public /* synthetic */ Object a(Class cls) {
        return d.a(this, cls);
    }

    @Override // k1.e
    public /* synthetic */ Set b(Class cls) {
        return d.e(this, cls);
    }

    @Override // k1.e
    public synchronized <T> b2.b<Set<T>> c(f0<T> f0Var) {
        y<?> yVar = this.f5592c.get(f0Var);
        if (yVar != null) {
            return yVar;
        }
        return (b2.b<Set<T>>) f5589i;
    }

    @Override // k1.e
    public synchronized <T> b2.b<T> d(f0<T> f0Var) {
        e0.c(f0Var, "Null interface requested.");
        return (b2.b<T>) this.f5591b.get(f0Var);
    }

    @Override // k1.e
    public /* synthetic */ Object e(f0 f0Var) {
        return d.b(this, f0Var);
    }

    @Override // k1.e
    public /* synthetic */ b2.b f(Class cls) {
        return d.d(this, cls);
    }

    @Override // k1.e
    public /* synthetic */ Set g(f0 f0Var) {
        return d.f(this, f0Var);
    }

    @Override // k1.e
    public <T> b2.a<T> h(f0<T> f0Var) {
        b2.b<T> d5 = d(f0Var);
        return d5 == null ? d0.e() : d5 instanceof d0 ? (d0) d5 : d0.i(d5);
    }

    @Override // k1.e
    public /* synthetic */ b2.a i(Class cls) {
        return d.c(this, cls);
    }

    public void p(boolean z4) {
        HashMap hashMap;
        if (m1.a(this.f5596g, null, Boolean.valueOf(z4))) {
            synchronized (this) {
                hashMap = new HashMap(this.f5590a);
            }
            o(hashMap, z4);
        }
    }
}
