package androidx.lifecycle;

import androidx.lifecycle.i;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes.dex */
public class n extends i {

    /* renamed from: k  reason: collision with root package name */
    public static final a f565k = new a(null);

    /* renamed from: b  reason: collision with root package name */
    private final boolean f566b;

    /* renamed from: c  reason: collision with root package name */
    private f.a<l, b> f567c;

    /* renamed from: d  reason: collision with root package name */
    private i.b f568d;

    /* renamed from: e  reason: collision with root package name */
    private final WeakReference<m> f569e;

    /* renamed from: f  reason: collision with root package name */
    private int f570f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f571g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f572h;

    /* renamed from: i  reason: collision with root package name */
    private ArrayList<i.b> f573i;

    /* renamed from: j  reason: collision with root package name */
    private final p4.j<i.b> f574j;

    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(e4.g gVar) {
            this();
        }

        public final i.b a(i.b bVar, i.b bVar2) {
            e4.k.e(bVar, "state1");
            return (bVar2 == null || bVar2.compareTo(bVar) >= 0) ? bVar : bVar2;
        }
    }

    /* loaded from: classes.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private i.b f575a;

        /* renamed from: b  reason: collision with root package name */
        private k f576b;

        public b(l lVar, i.b bVar) {
            e4.k.e(bVar, "initialState");
            e4.k.b(lVar);
            this.f576b = p.f(lVar);
            this.f575a = bVar;
        }

        public final void a(m mVar, i.a aVar) {
            e4.k.e(aVar, "event");
            i.b c5 = aVar.c();
            this.f575a = n.f565k.a(this.f575a, c5);
            k kVar = this.f576b;
            e4.k.b(mVar);
            kVar.d(mVar, aVar);
            this.f575a = c5;
        }

        public final i.b b() {
            return this.f575a;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public n(m mVar) {
        this(mVar, true);
        e4.k.e(mVar, "provider");
    }

    private n(m mVar, boolean z4) {
        this.f566b = z4;
        this.f567c = new f.a<>();
        i.b bVar = i.b.INITIALIZED;
        this.f568d = bVar;
        this.f573i = new ArrayList<>();
        this.f569e = new WeakReference<>(mVar);
        this.f574j = p4.o.a(bVar);
    }

    private final void d(m mVar) {
        Iterator<Map.Entry<l, b>> descendingIterator = this.f567c.descendingIterator();
        e4.k.d(descendingIterator, "observerMap.descendingIterator()");
        while (descendingIterator.hasNext() && !this.f572h) {
            Map.Entry<l, b> next = descendingIterator.next();
            e4.k.d(next, "next()");
            l key = next.getKey();
            b value = next.getValue();
            while (value.b().compareTo(this.f568d) > 0 && !this.f572h && this.f567c.contains(key)) {
                i.a a5 = i.a.Companion.a(value.b());
                if (a5 == null) {
                    throw new IllegalStateException("no event down from " + value.b());
                }
                l(a5.c());
                value.a(mVar, a5);
                k();
            }
        }
    }

    private final i.b e(l lVar) {
        b value;
        Map.Entry<l, b> o5 = this.f567c.o(lVar);
        i.b bVar = null;
        i.b b5 = (o5 == null || (value = o5.getValue()) == null) ? null : value.b();
        if (!this.f573i.isEmpty()) {
            ArrayList<i.b> arrayList = this.f573i;
            bVar = arrayList.get(arrayList.size() - 1);
        }
        a aVar = f565k;
        return aVar.a(aVar.a(this.f568d, b5), bVar);
    }

    private final void f(String str) {
        if (!this.f566b || e.c.f().b()) {
            return;
        }
        throw new IllegalStateException(("Method " + str + " must be called on the main thread").toString());
    }

    private final void g(m mVar) {
        f.b<l, b>.d i5 = this.f567c.i();
        e4.k.d(i5, "observerMap.iteratorWithAdditions()");
        while (i5.hasNext() && !this.f572h) {
            Map.Entry next = i5.next();
            l lVar = (l) next.getKey();
            b bVar = (b) next.getValue();
            while (bVar.b().compareTo(this.f568d) < 0 && !this.f572h && this.f567c.contains(lVar)) {
                l(bVar.b());
                i.a b5 = i.a.Companion.b(bVar.b());
                if (b5 == null) {
                    throw new IllegalStateException("no event up from " + bVar.b());
                }
                bVar.a(mVar, b5);
                k();
            }
        }
    }

    private final boolean i() {
        if (this.f567c.size() == 0) {
            return true;
        }
        Map.Entry<l, b> g5 = this.f567c.g();
        e4.k.b(g5);
        i.b b5 = g5.getValue().b();
        Map.Entry<l, b> k5 = this.f567c.k();
        e4.k.b(k5);
        i.b b6 = k5.getValue().b();
        return b5 == b6 && this.f568d == b6;
    }

    private final void j(i.b bVar) {
        i.b bVar2 = this.f568d;
        if (bVar2 == bVar) {
            return;
        }
        if (!((bVar2 == i.b.INITIALIZED && bVar == i.b.DESTROYED) ? false : true)) {
            throw new IllegalStateException(("no event down from " + this.f568d + " in component " + this.f569e.get()).toString());
        }
        this.f568d = bVar;
        if (this.f571g || this.f570f != 0) {
            this.f572h = true;
            return;
        }
        this.f571g = true;
        n();
        this.f571g = false;
        if (this.f568d == i.b.DESTROYED) {
            this.f567c = new f.a<>();
        }
    }

    private final void k() {
        ArrayList<i.b> arrayList = this.f573i;
        arrayList.remove(arrayList.size() - 1);
    }

    private final void l(i.b bVar) {
        this.f573i.add(bVar);
    }

    private final void n() {
        m mVar = this.f569e.get();
        if (mVar == null) {
            throw new IllegalStateException("LifecycleOwner of this LifecycleRegistry is already garbage collected. It is too late to change lifecycle state.");
        }
        while (true) {
            boolean i5 = i();
            this.f572h = false;
            if (i5) {
                this.f574j.setValue(b());
                return;
            }
            i.b bVar = this.f568d;
            Map.Entry<l, b> g5 = this.f567c.g();
            e4.k.b(g5);
            if (bVar.compareTo(g5.getValue().b()) < 0) {
                d(mVar);
            }
            Map.Entry<l, b> k5 = this.f567c.k();
            if (!this.f572h && k5 != null && this.f568d.compareTo(k5.getValue().b()) > 0) {
                g(mVar);
            }
        }
    }

    @Override // androidx.lifecycle.i
    public void a(l lVar) {
        m mVar;
        e4.k.e(lVar, "observer");
        f("addObserver");
        i.b bVar = this.f568d;
        i.b bVar2 = i.b.DESTROYED;
        if (bVar != bVar2) {
            bVar2 = i.b.INITIALIZED;
        }
        b bVar3 = new b(lVar, bVar2);
        if (this.f567c.m(lVar, bVar3) == null && (mVar = this.f569e.get()) != null) {
            boolean z4 = this.f570f != 0 || this.f571g;
            i.b e5 = e(lVar);
            this.f570f++;
            while (bVar3.b().compareTo(e5) < 0 && this.f567c.contains(lVar)) {
                l(bVar3.b());
                i.a b5 = i.a.Companion.b(bVar3.b());
                if (b5 == null) {
                    throw new IllegalStateException("no event up from " + bVar3.b());
                }
                bVar3.a(mVar, b5);
                k();
                e5 = e(lVar);
            }
            if (!z4) {
                n();
            }
            this.f570f--;
        }
    }

    @Override // androidx.lifecycle.i
    public i.b b() {
        return this.f568d;
    }

    @Override // androidx.lifecycle.i
    public void c(l lVar) {
        e4.k.e(lVar, "observer");
        f("removeObserver");
        this.f567c.n(lVar);
    }

    public void h(i.a aVar) {
        e4.k.e(aVar, "event");
        f("handleLifecycleEvent");
        j(aVar.c());
    }

    public void m(i.b bVar) {
        e4.k.e(bVar, "state");
        f("setCurrentState");
        j(bVar);
    }
}
