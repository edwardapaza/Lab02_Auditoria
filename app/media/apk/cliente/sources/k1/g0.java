package k1;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes.dex */
final class g0 implements e {

    /* renamed from: a  reason: collision with root package name */
    private final Set<f0<?>> f5573a;

    /* renamed from: b  reason: collision with root package name */
    private final Set<f0<?>> f5574b;

    /* renamed from: c  reason: collision with root package name */
    private final Set<f0<?>> f5575c;

    /* renamed from: d  reason: collision with root package name */
    private final Set<f0<?>> f5576d;

    /* renamed from: e  reason: collision with root package name */
    private final Set<f0<?>> f5577e;

    /* renamed from: f  reason: collision with root package name */
    private final Set<Class<?>> f5578f;

    /* renamed from: g  reason: collision with root package name */
    private final e f5579g;

    /* loaded from: classes.dex */
    private static class a implements p1.c {

        /* renamed from: a  reason: collision with root package name */
        private final Set<Class<?>> f5580a;

        /* renamed from: b  reason: collision with root package name */
        private final p1.c f5581b;

        public a(Set<Class<?>> set, p1.c cVar) {
            this.f5580a = set;
            this.f5581b = cVar;
        }

        @Override // p1.c
        public void a(p1.a<?> aVar) {
            if (!this.f5580a.contains(aVar.a())) {
                throw new t(String.format("Attempting to publish an undeclared event %s.", aVar));
            }
            this.f5581b.a(aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public g0(c<?> cVar, e eVar) {
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        HashSet hashSet3 = new HashSet();
        HashSet hashSet4 = new HashSet();
        HashSet hashSet5 = new HashSet();
        for (r rVar : cVar.g()) {
            if (rVar.e()) {
                boolean g5 = rVar.g();
                f0<?> c5 = rVar.c();
                if (g5) {
                    hashSet4.add(c5);
                } else {
                    hashSet.add(c5);
                }
            } else if (rVar.d()) {
                hashSet3.add(rVar.c());
            } else {
                boolean g6 = rVar.g();
                f0<?> c6 = rVar.c();
                if (g6) {
                    hashSet5.add(c6);
                } else {
                    hashSet2.add(c6);
                }
            }
        }
        if (!cVar.k().isEmpty()) {
            hashSet.add(f0.b(p1.c.class));
        }
        this.f5573a = Collections.unmodifiableSet(hashSet);
        this.f5574b = Collections.unmodifiableSet(hashSet2);
        this.f5575c = Collections.unmodifiableSet(hashSet3);
        this.f5576d = Collections.unmodifiableSet(hashSet4);
        this.f5577e = Collections.unmodifiableSet(hashSet5);
        this.f5578f = cVar.k();
        this.f5579g = eVar;
    }

    @Override // k1.e
    public <T> T a(Class<T> cls) {
        if (this.f5573a.contains(f0.b(cls))) {
            T t5 = (T) this.f5579g.a(cls);
            return !cls.equals(p1.c.class) ? t5 : (T) new a(this.f5578f, (p1.c) t5);
        }
        throw new t(String.format("Attempting to request an undeclared dependency %s.", cls));
    }

    @Override // k1.e
    public /* synthetic */ Set b(Class cls) {
        return d.e(this, cls);
    }

    @Override // k1.e
    public <T> b2.b<Set<T>> c(f0<T> f0Var) {
        if (this.f5577e.contains(f0Var)) {
            return this.f5579g.c(f0Var);
        }
        throw new t(String.format("Attempting to request an undeclared dependency Provider<Set<%s>>.", f0Var));
    }

    @Override // k1.e
    public <T> b2.b<T> d(f0<T> f0Var) {
        if (this.f5574b.contains(f0Var)) {
            return this.f5579g.d(f0Var);
        }
        throw new t(String.format("Attempting to request an undeclared dependency Provider<%s>.", f0Var));
    }

    @Override // k1.e
    public <T> T e(f0<T> f0Var) {
        if (this.f5573a.contains(f0Var)) {
            return (T) this.f5579g.e(f0Var);
        }
        throw new t(String.format("Attempting to request an undeclared dependency %s.", f0Var));
    }

    @Override // k1.e
    public <T> b2.b<T> f(Class<T> cls) {
        return d(f0.b(cls));
    }

    @Override // k1.e
    public <T> Set<T> g(f0<T> f0Var) {
        if (this.f5576d.contains(f0Var)) {
            return this.f5579g.g(f0Var);
        }
        throw new t(String.format("Attempting to request an undeclared dependency Set<%s>.", f0Var));
    }

    @Override // k1.e
    public <T> b2.a<T> h(f0<T> f0Var) {
        if (this.f5575c.contains(f0Var)) {
            return this.f5579g.h(f0Var);
        }
        throw new t(String.format("Attempting to request an undeclared dependency Deferred<%s>.", f0Var));
    }

    @Override // k1.e
    public <T> b2.a<T> i(Class<T> cls) {
        return h(f0.b(cls));
    }
}
