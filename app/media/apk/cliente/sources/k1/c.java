package k1;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes.dex */
public final class c<T> {

    /* renamed from: a  reason: collision with root package name */
    private final String f5547a;

    /* renamed from: b  reason: collision with root package name */
    private final Set<f0<? super T>> f5548b;

    /* renamed from: c  reason: collision with root package name */
    private final Set<r> f5549c;

    /* renamed from: d  reason: collision with root package name */
    private final int f5550d;

    /* renamed from: e  reason: collision with root package name */
    private final int f5551e;

    /* renamed from: f  reason: collision with root package name */
    private final h<T> f5552f;

    /* renamed from: g  reason: collision with root package name */
    private final Set<Class<?>> f5553g;

    /* loaded from: classes.dex */
    public static class b<T> {

        /* renamed from: a  reason: collision with root package name */
        private String f5554a;

        /* renamed from: b  reason: collision with root package name */
        private final Set<f0<? super T>> f5555b;

        /* renamed from: c  reason: collision with root package name */
        private final Set<r> f5556c;

        /* renamed from: d  reason: collision with root package name */
        private int f5557d;

        /* renamed from: e  reason: collision with root package name */
        private int f5558e;

        /* renamed from: f  reason: collision with root package name */
        private h<T> f5559f;

        /* renamed from: g  reason: collision with root package name */
        private final Set<Class<?>> f5560g;

        @SafeVarargs
        private b(Class<T> cls, Class<? super T>... clsArr) {
            this.f5554a = null;
            HashSet hashSet = new HashSet();
            this.f5555b = hashSet;
            this.f5556c = new HashSet();
            this.f5557d = 0;
            this.f5558e = 0;
            this.f5560g = new HashSet();
            e0.c(cls, "Null interface");
            hashSet.add(f0.b(cls));
            for (Class<? super T> cls2 : clsArr) {
                e0.c(cls2, "Null interface");
                this.f5555b.add(f0.b(cls2));
            }
        }

        @SafeVarargs
        private b(f0<T> f0Var, f0<? super T>... f0VarArr) {
            this.f5554a = null;
            HashSet hashSet = new HashSet();
            this.f5555b = hashSet;
            this.f5556c = new HashSet();
            this.f5557d = 0;
            this.f5558e = 0;
            this.f5560g = new HashSet();
            e0.c(f0Var, "Null interface");
            hashSet.add(f0Var);
            for (f0<? super T> f0Var2 : f0VarArr) {
                e0.c(f0Var2, "Null interface");
            }
            Collections.addAll(this.f5555b, f0VarArr);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public b<T> e() {
            this.f5558e = 1;
            return this;
        }

        private void g(f0<?> f0Var) {
            e0.a(!this.f5555b.contains(f0Var), "Components are not allowed to depend on interfaces they themselves provide.");
        }

        public b<T> b(r rVar) {
            e0.c(rVar, "Null dependency");
            g(rVar.c());
            this.f5556c.add(rVar);
            return this;
        }

        public c<T> c() {
            e0.d(this.f5559f != null, "Missing required property: factory.");
            return new c<>(this.f5554a, new HashSet(this.f5555b), new HashSet(this.f5556c), this.f5557d, this.f5558e, this.f5559f, this.f5560g);
        }

        public b<T> d(h<T> hVar) {
            this.f5559f = (h) e0.c(hVar, "Null factory");
            return this;
        }

        public b<T> f(String str) {
            this.f5554a = str;
            return this;
        }
    }

    private c(String str, Set<f0<? super T>> set, Set<r> set2, int i5, int i6, h<T> hVar, Set<Class<?>> set3) {
        this.f5547a = str;
        this.f5548b = Collections.unmodifiableSet(set);
        this.f5549c = Collections.unmodifiableSet(set2);
        this.f5550d = i5;
        this.f5551e = i6;
        this.f5552f = hVar;
        this.f5553g = Collections.unmodifiableSet(set3);
    }

    public static <T> b<T> c(Class<T> cls) {
        return new b<>(cls, new Class[0]);
    }

    @SafeVarargs
    public static <T> b<T> d(Class<T> cls, Class<? super T>... clsArr) {
        return new b<>(cls, clsArr);
    }

    public static <T> b<T> e(f0<T> f0Var) {
        return new b<>(f0Var, new f0[0]);
    }

    @SafeVarargs
    public static <T> b<T> f(f0<T> f0Var, f0<? super T>... f0VarArr) {
        return new b<>(f0Var, f0VarArr);
    }

    public static <T> c<T> l(final T t5, Class<T> cls) {
        return m(cls).d(new h() { // from class: k1.a
            @Override // k1.h
            public final Object a(e eVar) {
                Object q5;
                q5 = c.q(t5, eVar);
                return q5;
            }
        }).c();
    }

    public static <T> b<T> m(Class<T> cls) {
        return c(cls).e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object q(Object obj, e eVar) {
        return obj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object r(Object obj, e eVar) {
        return obj;
    }

    @SafeVarargs
    public static <T> c<T> s(final T t5, Class<T> cls, Class<? super T>... clsArr) {
        return d(cls, clsArr).d(new h() { // from class: k1.b
            @Override // k1.h
            public final Object a(e eVar) {
                Object r5;
                r5 = c.r(t5, eVar);
                return r5;
            }
        }).c();
    }

    public Set<r> g() {
        return this.f5549c;
    }

    public h<T> h() {
        return this.f5552f;
    }

    public String i() {
        return this.f5547a;
    }

    public Set<f0<? super T>> j() {
        return this.f5548b;
    }

    public Set<Class<?>> k() {
        return this.f5553g;
    }

    public boolean n() {
        return this.f5550d == 1;
    }

    public boolean o() {
        return this.f5550d == 2;
    }

    public boolean p() {
        return this.f5551e == 0;
    }

    public c<T> t(h<T> hVar) {
        return new c<>(this.f5547a, this.f5548b, this.f5549c, this.f5550d, this.f5551e, hVar, this.f5553g);
    }

    public String toString() {
        return "Component<" + Arrays.toString(this.f5548b.toArray()) + ">{" + this.f5550d + ", type=" + this.f5551e + ", deps=" + Arrays.toString(this.f5549c.toArray()) + "}";
    }
}
