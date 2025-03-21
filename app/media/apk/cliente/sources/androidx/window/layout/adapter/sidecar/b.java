package androidx.window.layout.adapter.sidecar;

import android.app.Activity;
import android.content.Context;
import androidx.window.layout.adapter.sidecar.a;
import androidx.window.layout.adapter.sidecar.b;
import c0.j;
import e4.g;
import e4.k;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.ReentrantLock;
import s3.t;
import t3.p;
/* loaded from: classes.dex */
public final class b implements d0.a {

    /* renamed from: d  reason: collision with root package name */
    private static volatile b f723d;

    /* renamed from: a  reason: collision with root package name */
    private androidx.window.layout.adapter.sidecar.a f725a;

    /* renamed from: b  reason: collision with root package name */
    private final CopyOnWriteArrayList<c> f726b = new CopyOnWriteArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    public static final a f722c = new a(null);

    /* renamed from: e  reason: collision with root package name */
    private static final ReentrantLock f724e = new ReentrantLock();

    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }

        public final b a(Context context) {
            k.e(context, "context");
            if (b.f723d == null) {
                ReentrantLock reentrantLock = b.f724e;
                reentrantLock.lock();
                try {
                    if (b.f723d == null) {
                        b.f723d = new b(b.f722c.b(context));
                    }
                    t tVar = t.f7573a;
                } finally {
                    reentrantLock.unlock();
                }
            }
            b bVar = b.f723d;
            k.b(bVar);
            return bVar;
        }

        public final androidx.window.layout.adapter.sidecar.a b(Context context) {
            k.e(context, "context");
            try {
                if (c(SidecarCompat.f710f.c())) {
                    SidecarCompat sidecarCompat = new SidecarCompat(context);
                    if (sidecarCompat.n()) {
                        return sidecarCompat;
                    }
                    return null;
                }
                return null;
            } catch (Throwable unused) {
                return null;
            }
        }

        public final boolean c(z.k kVar) {
            return kVar != null && kVar.compareTo(z.k.f8846f.a()) >= 0;
        }
    }

    /* renamed from: androidx.window.layout.adapter.sidecar.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public final class C0026b implements a.InterfaceC0025a {
        public C0026b() {
        }

        @Override // androidx.window.layout.adapter.sidecar.a.InterfaceC0025a
        public void a(Activity activity, j jVar) {
            k.e(activity, "activity");
            k.e(jVar, "newLayout");
            Iterator<c> it = b.this.g().iterator();
            while (it.hasNext()) {
                c next = it.next();
                if (k.a(next.d(), activity)) {
                    next.b(jVar);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        private final Activity f728a;

        /* renamed from: b  reason: collision with root package name */
        private final Executor f729b;

        /* renamed from: c  reason: collision with root package name */
        private final k.a<j> f730c;

        /* renamed from: d  reason: collision with root package name */
        private j f731d;

        public c(Activity activity, Executor executor, k.a<j> aVar) {
            k.e(activity, "activity");
            k.e(executor, "executor");
            k.e(aVar, "callback");
            this.f728a = activity;
            this.f729b = executor;
            this.f730c = aVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(c cVar, j jVar) {
            k.e(cVar, "this$0");
            k.e(jVar, "$newLayoutInfo");
            cVar.f730c.accept(jVar);
        }

        public final void b(final j jVar) {
            k.e(jVar, "newLayoutInfo");
            this.f731d = jVar;
            this.f729b.execute(new Runnable() { // from class: f0.c
                @Override // java.lang.Runnable
                public final void run() {
                    b.c.c(b.c.this, jVar);
                }
            });
        }

        public final Activity d() {
            return this.f728a;
        }

        public final k.a<j> e() {
            return this.f730c;
        }

        public final j f() {
            return this.f731d;
        }
    }

    public b(androidx.window.layout.adapter.sidecar.a aVar) {
        this.f725a = aVar;
        androidx.window.layout.adapter.sidecar.a aVar2 = this.f725a;
        if (aVar2 != null) {
            aVar2.a(new C0026b());
        }
    }

    private final void f(Activity activity) {
        androidx.window.layout.adapter.sidecar.a aVar;
        CopyOnWriteArrayList<c> copyOnWriteArrayList = this.f726b;
        boolean z4 = false;
        if (!(copyOnWriteArrayList instanceof Collection) || !copyOnWriteArrayList.isEmpty()) {
            Iterator<T> it = copyOnWriteArrayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (k.a(((c) it.next()).d(), activity)) {
                    z4 = true;
                    break;
                }
            }
        }
        if (z4 || (aVar = this.f725a) == null) {
            return;
        }
        aVar.c(activity);
    }

    private final boolean h(Activity activity) {
        CopyOnWriteArrayList<c> copyOnWriteArrayList = this.f726b;
        if ((copyOnWriteArrayList instanceof Collection) && copyOnWriteArrayList.isEmpty()) {
            return false;
        }
        for (c cVar : copyOnWriteArrayList) {
            if (k.a(cVar.d(), activity)) {
                return true;
            }
        }
        return false;
    }

    @Override // d0.a
    public void a(Context context, Executor executor, k.a<j> aVar) {
        List f5;
        Object obj;
        List f6;
        k.e(context, "context");
        k.e(executor, "executor");
        k.e(aVar, "callback");
        t tVar = null;
        Activity activity = context instanceof Activity ? (Activity) context : null;
        if (activity != null) {
            ReentrantLock reentrantLock = f724e;
            reentrantLock.lock();
            try {
                androidx.window.layout.adapter.sidecar.a aVar2 = this.f725a;
                if (aVar2 == null) {
                    f6 = p.f();
                    aVar.accept(new j(f6));
                    return;
                }
                boolean h5 = h(activity);
                c cVar = new c(activity, executor, aVar);
                this.f726b.add(cVar);
                if (h5) {
                    Iterator<T> it = this.f726b.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            obj = null;
                            break;
                        }
                        obj = it.next();
                        if (k.a(activity, ((c) obj).d())) {
                            break;
                        }
                    }
                    c cVar2 = (c) obj;
                    j f7 = cVar2 != null ? cVar2.f() : null;
                    if (f7 != null) {
                        cVar.b(f7);
                    }
                } else {
                    aVar2.b(activity);
                }
                t tVar2 = t.f7573a;
                reentrantLock.unlock();
                tVar = t.f7573a;
            } finally {
                reentrantLock.unlock();
            }
        }
        if (tVar == null) {
            f5 = p.f();
            aVar.accept(new j(f5));
        }
    }

    @Override // d0.a
    public void b(k.a<j> aVar) {
        k.e(aVar, "callback");
        synchronized (f724e) {
            if (this.f725a == null) {
                return;
            }
            ArrayList<c> arrayList = new ArrayList();
            Iterator<c> it = this.f726b.iterator();
            while (it.hasNext()) {
                c next = it.next();
                if (next.e() == aVar) {
                    k.d(next, "callbackWrapper");
                    arrayList.add(next);
                }
            }
            this.f726b.removeAll(arrayList);
            for (c cVar : arrayList) {
                f(cVar.d());
            }
            t tVar = t.f7573a;
        }
    }

    public final CopyOnWriteArrayList<c> g() {
        return this.f726b;
    }
}
