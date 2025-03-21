package u4;

import d4.l;
import d4.q;
import e4.k;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import m4.b1;
import m4.b3;
import m4.j;
import r4.e0;
import r4.h0;
import s3.t;
import t3.o;
import t3.x;
import v3.g;
/* loaded from: classes.dex */
public class a<R> extends j implements b, b3 {

    /* renamed from: f  reason: collision with root package name */
    private static final AtomicReferenceFieldUpdater f8075f = AtomicReferenceFieldUpdater.newUpdater(a.class, Object.class, "state");

    /* renamed from: a  reason: collision with root package name */
    private final g f8076a;

    /* renamed from: b  reason: collision with root package name */
    private List<a<R>.C0119a> f8077b;

    /* renamed from: c  reason: collision with root package name */
    private Object f8078c;

    /* renamed from: d  reason: collision with root package name */
    private int f8079d;

    /* renamed from: e  reason: collision with root package name */
    private Object f8080e;
    private volatile Object state;

    /* renamed from: u4.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public final class C0119a {

        /* renamed from: a  reason: collision with root package name */
        public final Object f8081a;

        /* renamed from: b  reason: collision with root package name */
        private final Object f8082b;

        /* renamed from: c  reason: collision with root package name */
        public final q<b<?>, Object, Object, l<Throwable, t>> f8083c;

        /* renamed from: d  reason: collision with root package name */
        public Object f8084d;

        /* renamed from: e  reason: collision with root package name */
        public int f8085e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ a<R> f8086f;

        public final l<Throwable, t> a(b<?> bVar, Object obj) {
            q<b<?>, Object, Object, l<Throwable, t>> qVar = this.f8083c;
            if (qVar != null) {
                return qVar.d(bVar, this.f8082b, obj);
            }
            return null;
        }

        public final void b() {
            Object obj = this.f8084d;
            a<R> aVar = this.f8086f;
            if (obj instanceof e0) {
                ((e0) obj).o(this.f8085e, null, aVar.getContext());
                return;
            }
            b1 b1Var = obj instanceof b1 ? (b1) obj : null;
            if (b1Var != null) {
                b1Var.a();
            }
        }
    }

    private final a<R>.C0119a g(Object obj) {
        boolean z4;
        List<a<R>.C0119a> list = this.f8077b;
        Object obj2 = null;
        if (list == null) {
            return null;
        }
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (((C0119a) next).f8081a == obj) {
                z4 = true;
                continue;
            } else {
                z4 = false;
                continue;
            }
            if (z4) {
                obj2 = next;
                break;
            }
        }
        a<R>.C0119a c0119a = (C0119a) obj2;
        if (c0119a != null) {
            return c0119a;
        }
        throw new IllegalStateException(("Clause with object " + obj + " is not found").toString());
    }

    private final int i(Object obj, Object obj2) {
        boolean h5;
        h0 h0Var;
        h0 h0Var2;
        h0 h0Var3;
        List b5;
        List A;
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f8075f;
            Object obj3 = atomicReferenceFieldUpdater.get(this);
            if (obj3 instanceof m4.l) {
                a<R>.C0119a g5 = g(obj);
                if (g5 == null) {
                    continue;
                } else {
                    l<Throwable, t> a5 = g5.a(this, obj2);
                    if (androidx.concurrent.futures.b.a(atomicReferenceFieldUpdater, this, obj3, g5)) {
                        this.f8080e = obj2;
                        h5 = c.h((m4.l) obj3, a5);
                        if (h5) {
                            return 0;
                        }
                        this.f8080e = null;
                        return 2;
                    }
                }
            } else {
                h0Var = c.f8089c;
                if (k.a(obj3, h0Var) ? true : obj3 instanceof C0119a) {
                    return 3;
                }
                h0Var2 = c.f8090d;
                if (k.a(obj3, h0Var2)) {
                    return 2;
                }
                h0Var3 = c.f8088b;
                if (k.a(obj3, h0Var3)) {
                    b5 = o.b(obj);
                    if (androidx.concurrent.futures.b.a(atomicReferenceFieldUpdater, this, obj3, b5)) {
                        return 1;
                    }
                } else if (!(obj3 instanceof List)) {
                    throw new IllegalStateException(("Unexpected state: " + obj3).toString());
                } else {
                    A = x.A((Collection) obj3, obj);
                    if (androidx.concurrent.futures.b.a(atomicReferenceFieldUpdater, this, obj3, A)) {
                        return 1;
                    }
                }
            }
        }
    }

    @Override // u4.b
    public boolean a(Object obj, Object obj2) {
        return i(obj, obj2) == 0;
    }

    @Override // u4.b
    public void c(Object obj) {
        this.f8080e = obj;
    }

    @Override // m4.k
    public void e(Throwable th) {
        Object obj;
        h0 h0Var;
        h0 h0Var2;
        h0 h0Var3;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f8075f;
        do {
            obj = atomicReferenceFieldUpdater.get(this);
            h0Var = c.f8089c;
            if (obj == h0Var) {
                return;
            }
            h0Var2 = c.f8090d;
        } while (!androidx.concurrent.futures.b.a(atomicReferenceFieldUpdater, this, obj, h0Var2));
        List<a<R>.C0119a> list = this.f8077b;
        if (list == null) {
            return;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            ((C0119a) it.next()).b();
        }
        h0Var3 = c.f8091e;
        this.f8080e = h0Var3;
        this.f8077b = null;
    }

    @Override // m4.b3
    public void f(e0<?> e0Var, int i5) {
        this.f8078c = e0Var;
        this.f8079d = i5;
    }

    @Override // u4.b
    public g getContext() {
        return this.f8076a;
    }

    public final d h(Object obj, Object obj2) {
        d a5;
        a5 = c.a(i(obj, obj2));
        return a5;
    }

    @Override // d4.l
    public /* bridge */ /* synthetic */ t invoke(Throwable th) {
        e(th);
        return t.f7573a;
    }
}
