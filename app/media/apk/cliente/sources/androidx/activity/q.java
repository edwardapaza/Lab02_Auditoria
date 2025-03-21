package androidx.activity;

import android.os.Build;
import android.window.BackEvent;
import android.window.OnBackAnimationCallback;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.activity.q;
import androidx.lifecycle.i;
import java.util.Collection;
import java.util.Iterator;
import java.util.ListIterator;
/* loaded from: classes.dex */
public final class q {

    /* renamed from: a  reason: collision with root package name */
    private final Runnable f157a;

    /* renamed from: b  reason: collision with root package name */
    private final k.a<Boolean> f158b;

    /* renamed from: c  reason: collision with root package name */
    private final t3.f<p> f159c;

    /* renamed from: d  reason: collision with root package name */
    private p f160d;

    /* renamed from: e  reason: collision with root package name */
    private OnBackInvokedCallback f161e;

    /* renamed from: f  reason: collision with root package name */
    private OnBackInvokedDispatcher f162f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f163g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f164h;

    /* loaded from: classes.dex */
    static final class a extends e4.l implements d4.l<androidx.activity.b, s3.t> {
        a() {
            super(1);
        }

        public final void a(androidx.activity.b bVar) {
            e4.k.e(bVar, "backEvent");
            q.this.m(bVar);
        }

        @Override // d4.l
        public /* bridge */ /* synthetic */ s3.t invoke(androidx.activity.b bVar) {
            a(bVar);
            return s3.t.f7573a;
        }
    }

    /* loaded from: classes.dex */
    static final class b extends e4.l implements d4.l<androidx.activity.b, s3.t> {
        b() {
            super(1);
        }

        public final void a(androidx.activity.b bVar) {
            e4.k.e(bVar, "backEvent");
            q.this.l(bVar);
        }

        @Override // d4.l
        public /* bridge */ /* synthetic */ s3.t invoke(androidx.activity.b bVar) {
            a(bVar);
            return s3.t.f7573a;
        }
    }

    /* loaded from: classes.dex */
    static final class c extends e4.l implements d4.a<s3.t> {
        c() {
            super(0);
        }

        public final void a() {
            q.this.k();
        }

        @Override // d4.a
        public /* bridge */ /* synthetic */ s3.t b() {
            a();
            return s3.t.f7573a;
        }
    }

    /* loaded from: classes.dex */
    static final class d extends e4.l implements d4.a<s3.t> {
        d() {
            super(0);
        }

        public final void a() {
            q.this.j();
        }

        @Override // d4.a
        public /* bridge */ /* synthetic */ s3.t b() {
            a();
            return s3.t.f7573a;
        }
    }

    /* loaded from: classes.dex */
    static final class e extends e4.l implements d4.a<s3.t> {
        e() {
            super(0);
        }

        public final void a() {
            q.this.k();
        }

        @Override // d4.a
        public /* bridge */ /* synthetic */ s3.t b() {
            a();
            return s3.t.f7573a;
        }
    }

    /* loaded from: classes.dex */
    public static final class f {

        /* renamed from: a  reason: collision with root package name */
        public static final f f170a = new f();

        private f() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(d4.a aVar) {
            e4.k.e(aVar, "$onBackInvoked");
            aVar.b();
        }

        public final OnBackInvokedCallback b(final d4.a<s3.t> aVar) {
            e4.k.e(aVar, "onBackInvoked");
            return new OnBackInvokedCallback() { // from class: androidx.activity.r
                public final void onBackInvoked() {
                    q.f.c(d4.a.this);
                }
            };
        }

        public final void d(Object obj, int i5, Object obj2) {
            e4.k.e(obj, "dispatcher");
            e4.k.e(obj2, "callback");
            ((OnBackInvokedDispatcher) obj).registerOnBackInvokedCallback(i5, (OnBackInvokedCallback) obj2);
        }

        public final void e(Object obj, Object obj2) {
            e4.k.e(obj, "dispatcher");
            e4.k.e(obj2, "callback");
            ((OnBackInvokedDispatcher) obj).unregisterOnBackInvokedCallback((OnBackInvokedCallback) obj2);
        }
    }

    /* loaded from: classes.dex */
    public static final class g {

        /* renamed from: a  reason: collision with root package name */
        public static final g f171a = new g();

        /* loaded from: classes.dex */
        public static final class a implements OnBackAnimationCallback {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ d4.l<androidx.activity.b, s3.t> f172a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ d4.l<androidx.activity.b, s3.t> f173b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ d4.a<s3.t> f174c;

            /* renamed from: d  reason: collision with root package name */
            final /* synthetic */ d4.a<s3.t> f175d;

            /* JADX WARN: Multi-variable type inference failed */
            a(d4.l<? super androidx.activity.b, s3.t> lVar, d4.l<? super androidx.activity.b, s3.t> lVar2, d4.a<s3.t> aVar, d4.a<s3.t> aVar2) {
                this.f172a = lVar;
                this.f173b = lVar2;
                this.f174c = aVar;
                this.f175d = aVar2;
            }

            public void onBackCancelled() {
                this.f175d.b();
            }

            public void onBackInvoked() {
                this.f174c.b();
            }

            public void onBackProgressed(BackEvent backEvent) {
                e4.k.e(backEvent, "backEvent");
                this.f173b.invoke(new androidx.activity.b(backEvent));
            }

            public void onBackStarted(BackEvent backEvent) {
                e4.k.e(backEvent, "backEvent");
                this.f172a.invoke(new androidx.activity.b(backEvent));
            }
        }

        private g() {
        }

        public final OnBackInvokedCallback a(d4.l<? super androidx.activity.b, s3.t> lVar, d4.l<? super androidx.activity.b, s3.t> lVar2, d4.a<s3.t> aVar, d4.a<s3.t> aVar2) {
            e4.k.e(lVar, "onBackStarted");
            e4.k.e(lVar2, "onBackProgressed");
            e4.k.e(aVar, "onBackInvoked");
            e4.k.e(aVar2, "onBackCancelled");
            return new a(lVar, lVar2, aVar, aVar2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public final class h implements androidx.lifecycle.k, androidx.activity.c {

        /* renamed from: a  reason: collision with root package name */
        private final androidx.lifecycle.i f176a;

        /* renamed from: b  reason: collision with root package name */
        private final p f177b;

        /* renamed from: c  reason: collision with root package name */
        private androidx.activity.c f178c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ q f179d;

        public h(q qVar, androidx.lifecycle.i iVar, p pVar) {
            e4.k.e(iVar, "lifecycle");
            e4.k.e(pVar, "onBackPressedCallback");
            this.f179d = qVar;
            this.f176a = iVar;
            this.f177b = pVar;
            iVar.a(this);
        }

        @Override // androidx.activity.c
        public void cancel() {
            this.f176a.c(this);
            this.f177b.i(this);
            androidx.activity.c cVar = this.f178c;
            if (cVar != null) {
                cVar.cancel();
            }
            this.f178c = null;
        }

        @Override // androidx.lifecycle.k
        public void d(androidx.lifecycle.m mVar, i.a aVar) {
            e4.k.e(mVar, "source");
            e4.k.e(aVar, "event");
            if (aVar == i.a.ON_START) {
                this.f178c = this.f179d.i(this.f177b);
            } else if (aVar != i.a.ON_STOP) {
                if (aVar == i.a.ON_DESTROY) {
                    cancel();
                }
            } else {
                androidx.activity.c cVar = this.f178c;
                if (cVar != null) {
                    cVar.cancel();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public final class i implements androidx.activity.c {

        /* renamed from: a  reason: collision with root package name */
        private final p f180a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ q f181b;

        public i(q qVar, p pVar) {
            e4.k.e(pVar, "onBackPressedCallback");
            this.f181b = qVar;
            this.f180a = pVar;
        }

        @Override // androidx.activity.c
        public void cancel() {
            this.f181b.f159c.remove(this.f180a);
            if (e4.k.a(this.f181b.f160d, this.f180a)) {
                this.f180a.c();
                this.f181b.f160d = null;
            }
            this.f180a.i(this);
            d4.a<s3.t> b5 = this.f180a.b();
            if (b5 != null) {
                b5.b();
            }
            this.f180a.k(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public /* synthetic */ class j extends e4.j implements d4.a<s3.t> {
        j(Object obj) {
            super(0, obj, q.class, "updateEnabledCallbacks", "updateEnabledCallbacks()V", 0);
        }

        @Override // d4.a
        public /* bridge */ /* synthetic */ s3.t b() {
            i();
            return s3.t.f7573a;
        }

        public final void i() {
            ((q) this.f2919b).p();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public /* synthetic */ class k extends e4.j implements d4.a<s3.t> {
        k(Object obj) {
            super(0, obj, q.class, "updateEnabledCallbacks", "updateEnabledCallbacks()V", 0);
        }

        @Override // d4.a
        public /* bridge */ /* synthetic */ s3.t b() {
            i();
            return s3.t.f7573a;
        }

        public final void i() {
            ((q) this.f2919b).p();
        }
    }

    public q() {
        this(null, 1, null);
    }

    public q(Runnable runnable) {
        this(runnable, null);
    }

    public /* synthetic */ q(Runnable runnable, int i5, e4.g gVar) {
        this((i5 & 1) != 0 ? null : runnable);
    }

    public q(Runnable runnable, k.a<Boolean> aVar) {
        this.f157a = runnable;
        this.f158b = aVar;
        this.f159c = new t3.f<>();
        int i5 = Build.VERSION.SDK_INT;
        if (i5 >= 33) {
            this.f161e = i5 >= 34 ? g.f171a.a(new a(), new b(), new c(), new d()) : f.f170a.b(new e());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j() {
        p pVar;
        p pVar2 = this.f160d;
        if (pVar2 == null) {
            t3.f<p> fVar = this.f159c;
            ListIterator<p> listIterator = fVar.listIterator(fVar.size());
            while (true) {
                if (!listIterator.hasPrevious()) {
                    pVar = null;
                    break;
                }
                pVar = listIterator.previous();
                if (pVar.g()) {
                    break;
                }
            }
            pVar2 = pVar;
        }
        this.f160d = null;
        if (pVar2 != null) {
            pVar2.c();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l(androidx.activity.b bVar) {
        p pVar;
        p pVar2 = this.f160d;
        if (pVar2 == null) {
            t3.f<p> fVar = this.f159c;
            ListIterator<p> listIterator = fVar.listIterator(fVar.size());
            while (true) {
                if (!listIterator.hasPrevious()) {
                    pVar = null;
                    break;
                }
                pVar = listIterator.previous();
                if (pVar.g()) {
                    break;
                }
            }
            pVar2 = pVar;
        }
        if (pVar2 != null) {
            pVar2.e(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m(androidx.activity.b bVar) {
        p pVar;
        t3.f<p> fVar = this.f159c;
        ListIterator<p> listIterator = fVar.listIterator(fVar.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                pVar = null;
                break;
            }
            pVar = listIterator.previous();
            if (pVar.g()) {
                break;
            }
        }
        p pVar2 = pVar;
        this.f160d = pVar2;
        if (pVar2 != null) {
            pVar2.f(bVar);
        }
    }

    private final void o(boolean z4) {
        OnBackInvokedDispatcher onBackInvokedDispatcher = this.f162f;
        OnBackInvokedCallback onBackInvokedCallback = this.f161e;
        if (onBackInvokedDispatcher == null || onBackInvokedCallback == null) {
            return;
        }
        if (z4 && !this.f163g) {
            f.f170a.d(onBackInvokedDispatcher, 0, onBackInvokedCallback);
            this.f163g = true;
        } else if (z4 || !this.f163g) {
        } else {
            f.f170a.e(onBackInvokedDispatcher, onBackInvokedCallback);
            this.f163g = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p() {
        boolean z4 = this.f164h;
        t3.f<p> fVar = this.f159c;
        boolean z5 = false;
        if (!(fVar instanceof Collection) || !fVar.isEmpty()) {
            Iterator<p> it = fVar.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (it.next().g()) {
                    z5 = true;
                    break;
                }
            }
        }
        this.f164h = z5;
        if (z5 != z4) {
            k.a<Boolean> aVar = this.f158b;
            if (aVar != null) {
                aVar.accept(Boolean.valueOf(z5));
            }
            if (Build.VERSION.SDK_INT >= 33) {
                o(z5);
            }
        }
    }

    public final void h(androidx.lifecycle.m mVar, p pVar) {
        e4.k.e(mVar, "owner");
        e4.k.e(pVar, "onBackPressedCallback");
        androidx.lifecycle.i a5 = mVar.a();
        if (a5.b() == i.b.DESTROYED) {
            return;
        }
        pVar.a(new h(this, a5, pVar));
        p();
        pVar.k(new j(this));
    }

    public final androidx.activity.c i(p pVar) {
        e4.k.e(pVar, "onBackPressedCallback");
        this.f159c.add(pVar);
        i iVar = new i(this, pVar);
        pVar.a(iVar);
        p();
        pVar.k(new k(this));
        return iVar;
    }

    public final void k() {
        p pVar;
        p pVar2 = this.f160d;
        if (pVar2 == null) {
            t3.f<p> fVar = this.f159c;
            ListIterator<p> listIterator = fVar.listIterator(fVar.size());
            while (true) {
                if (!listIterator.hasPrevious()) {
                    pVar = null;
                    break;
                }
                pVar = listIterator.previous();
                if (pVar.g()) {
                    break;
                }
            }
            pVar2 = pVar;
        }
        this.f160d = null;
        if (pVar2 != null) {
            pVar2.d();
            return;
        }
        Runnable runnable = this.f157a;
        if (runnable != null) {
            runnable.run();
        }
    }

    public final void n(OnBackInvokedDispatcher onBackInvokedDispatcher) {
        e4.k.e(onBackInvokedDispatcher, "invoker");
        this.f162f = onBackInvokedDispatcher;
        o(this.f164h);
    }
}
