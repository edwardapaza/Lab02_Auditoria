package androidx.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.window.OnBackInvokedDispatcher;
import androidx.activity.h;
import androidx.core.app.r0;
import androidx.core.app.s0;
import androidx.core.app.u0;
import androidx.lifecycle.d0;
import androidx.lifecycle.i;
import androidx.lifecycle.i0;
import androidx.lifecycle.l0;
import androidx.lifecycle.m0;
import androidx.lifecycle.n0;
import androidx.lifecycle.o0;
import androidx.lifecycle.z;
import d.a;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;
import u.d;
/* loaded from: classes.dex */
public class h extends androidx.core.app.m implements m0, androidx.lifecycle.h, u.f, s, c.e, androidx.core.content.m, androidx.core.content.n, r0, s0, androidx.core.view.d, n {

    /* renamed from: c  reason: collision with root package name */
    final b.a f99c = new b.a();

    /* renamed from: d  reason: collision with root package name */
    private final androidx.core.view.e f100d = new androidx.core.view.e(new Runnable() { // from class: androidx.activity.d
        @Override // java.lang.Runnable
        public final void run() {
            h.this.E();
        }
    });

    /* renamed from: e  reason: collision with root package name */
    private final androidx.lifecycle.n f101e = new androidx.lifecycle.n(this);

    /* renamed from: f  reason: collision with root package name */
    final u.e f102f;

    /* renamed from: k  reason: collision with root package name */
    private l0 f103k;

    /* renamed from: l  reason: collision with root package name */
    private q f104l;

    /* renamed from: m  reason: collision with root package name */
    final j f105m;

    /* renamed from: n  reason: collision with root package name */
    final m f106n;

    /* renamed from: o  reason: collision with root package name */
    private int f107o;

    /* renamed from: p  reason: collision with root package name */
    private final AtomicInteger f108p;

    /* renamed from: q  reason: collision with root package name */
    private final c.d f109q;

    /* renamed from: r  reason: collision with root package name */
    private final CopyOnWriteArrayList<k.a<Configuration>> f110r;

    /* renamed from: s  reason: collision with root package name */
    private final CopyOnWriteArrayList<k.a<Integer>> f111s;

    /* renamed from: t  reason: collision with root package name */
    private final CopyOnWriteArrayList<k.a<Intent>> f112t;

    /* renamed from: u  reason: collision with root package name */
    private final CopyOnWriteArrayList<k.a<androidx.core.app.o>> f113u;

    /* renamed from: v  reason: collision with root package name */
    private final CopyOnWriteArrayList<k.a<u0>> f114v;

    /* renamed from: w  reason: collision with root package name */
    private boolean f115w;

    /* renamed from: x  reason: collision with root package name */
    private boolean f116x;

    /* loaded from: classes.dex */
    class a extends c.d {

        /* renamed from: androidx.activity.h$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        class RunnableC0006a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ int f118a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ a.C0046a f119b;

            RunnableC0006a(int i5, a.C0046a c0046a) {
                this.f118a = i5;
                this.f119b = c0046a;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.c(this.f118a, this.f119b.a());
            }
        }

        /* loaded from: classes.dex */
        class b implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ int f121a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ IntentSender.SendIntentException f122b;

            b(int i5, IntentSender.SendIntentException sendIntentException) {
                this.f121a = i5;
                this.f122b = sendIntentException;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.b(this.f121a, 0, new Intent().setAction("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST").putExtra("androidx.activity.result.contract.extra.SEND_INTENT_EXCEPTION", this.f122b));
            }
        }

        a() {
        }

        @Override // c.d
        public <I, O> void f(int i5, d.a<I, O> aVar, I i6, androidx.core.app.d dVar) {
            h hVar = h.this;
            a.C0046a<O> b5 = aVar.b(hVar, i6);
            if (b5 != null) {
                new Handler(Looper.getMainLooper()).post(new RunnableC0006a(i5, b5));
                return;
            }
            Intent a5 = aVar.a(hVar, i6);
            Bundle bundle = null;
            if (a5.getExtras() != null && a5.getExtras().getClassLoader() == null) {
                a5.setExtrasClassLoader(hVar.getClassLoader());
            }
            if (a5.hasExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE")) {
                bundle = a5.getBundleExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
                a5.removeExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
            }
            Bundle bundle2 = bundle;
            if ("androidx.activity.result.contract.action.REQUEST_PERMISSIONS".equals(a5.getAction())) {
                String[] stringArrayExtra = a5.getStringArrayExtra("androidx.activity.result.contract.extra.PERMISSIONS");
                if (stringArrayExtra == null) {
                    stringArrayExtra = new String[0];
                }
                androidx.core.app.a.a(hVar, stringArrayExtra, i5);
            } else if (!"androidx.activity.result.contract.action.INTENT_SENDER_REQUEST".equals(a5.getAction())) {
                androidx.core.app.a.b(hVar, a5, i5, bundle2);
            } else {
                c.f fVar = (c.f) a5.getParcelableExtra("androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST");
                try {
                    androidx.core.app.a.c(hVar, fVar.g(), i5, fVar.a(), fVar.b(), fVar.f(), 0, bundle2);
                } catch (IntentSender.SendIntentException e5) {
                    new Handler(Looper.getMainLooper()).post(new b(i5, e5));
                }
            }
        }
    }

    /* loaded from: classes.dex */
    class b implements androidx.lifecycle.k {
        b() {
        }

        @Override // androidx.lifecycle.k
        public void d(androidx.lifecycle.m mVar, i.a aVar) {
            if (aVar == i.a.ON_STOP) {
                Window window = h.this.getWindow();
                View peekDecorView = window != null ? window.peekDecorView() : null;
                if (peekDecorView != null) {
                    g.a(peekDecorView);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    class c implements androidx.lifecycle.k {
        c() {
        }

        @Override // androidx.lifecycle.k
        public void d(androidx.lifecycle.m mVar, i.a aVar) {
            if (aVar == i.a.ON_DESTROY) {
                h.this.f99c.b();
                if (!h.this.isChangingConfigurations()) {
                    h.this.p().a();
                }
                h.this.f105m.h();
            }
        }
    }

    /* loaded from: classes.dex */
    class d implements androidx.lifecycle.k {
        d() {
        }

        @Override // androidx.lifecycle.k
        public void d(androidx.lifecycle.m mVar, i.a aVar) {
            h.this.C();
            h.this.a().c(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class e implements Runnable {
        e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                h.super.onBackPressed();
            } catch (IllegalStateException e5) {
                if (!TextUtils.equals(e5.getMessage(), "Can not perform this action after onSaveInstanceState")) {
                    throw e5;
                }
            } catch (NullPointerException e6) {
                if (!TextUtils.equals(e6.getMessage(), "Attempt to invoke virtual method 'android.os.Handler android.app.FragmentHostCallback.getHandler()' on a null object reference")) {
                    throw e6;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class f implements androidx.lifecycle.k {
        f() {
        }

        @Override // androidx.lifecycle.k
        public void d(androidx.lifecycle.m mVar, i.a aVar) {
            if (aVar != i.a.ON_CREATE || Build.VERSION.SDK_INT < 33) {
                return;
            }
            h.this.f104l.n(C0007h.a((h) mVar));
        }
    }

    /* loaded from: classes.dex */
    static class g {
        static void a(View view) {
            view.cancelPendingInputEvents();
        }
    }

    /* renamed from: androidx.activity.h$h  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    static class C0007h {
        static OnBackInvokedDispatcher a(Activity activity) {
            return activity.getOnBackInvokedDispatcher();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class i {

        /* renamed from: a  reason: collision with root package name */
        Object f129a;

        /* renamed from: b  reason: collision with root package name */
        l0 f130b;

        i() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public interface j extends Executor {
        void h();

        void x(View view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class k implements j, ViewTreeObserver.OnDrawListener, Runnable {

        /* renamed from: b  reason: collision with root package name */
        Runnable f132b;

        /* renamed from: a  reason: collision with root package name */
        final long f131a = SystemClock.uptimeMillis() + 10000;

        /* renamed from: c  reason: collision with root package name */
        boolean f133c = false;

        k() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b() {
            Runnable runnable = this.f132b;
            if (runnable != null) {
                runnable.run();
                this.f132b = null;
            }
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            this.f132b = runnable;
            View decorView = h.this.getWindow().getDecorView();
            if (!this.f133c) {
                decorView.postOnAnimation(new Runnable() { // from class: androidx.activity.i
                    @Override // java.lang.Runnable
                    public final void run() {
                        h.k.this.b();
                    }
                });
            } else if (Looper.myLooper() == Looper.getMainLooper()) {
                decorView.invalidate();
            } else {
                decorView.postInvalidate();
            }
        }

        @Override // androidx.activity.h.j
        public void h() {
            h.this.getWindow().getDecorView().removeCallbacks(this);
            h.this.getWindow().getDecorView().getViewTreeObserver().removeOnDrawListener(this);
        }

        @Override // android.view.ViewTreeObserver.OnDrawListener
        public void onDraw() {
            Runnable runnable = this.f132b;
            if (runnable != null) {
                runnable.run();
                this.f132b = null;
                if (!h.this.f106n.c()) {
                    return;
                }
            } else if (SystemClock.uptimeMillis() <= this.f131a) {
                return;
            }
            this.f133c = false;
            h.this.getWindow().getDecorView().post(this);
        }

        @Override // java.lang.Runnable
        public void run() {
            h.this.getWindow().getDecorView().getViewTreeObserver().removeOnDrawListener(this);
        }

        @Override // androidx.activity.h.j
        public void x(View view) {
            if (this.f133c) {
                return;
            }
            this.f133c = true;
            view.getViewTreeObserver().addOnDrawListener(this);
        }
    }

    public h() {
        u.e a5 = u.e.a(this);
        this.f102f = a5;
        this.f104l = null;
        j B = B();
        this.f105m = B;
        this.f106n = new m(B, new d4.a() { // from class: androidx.activity.e
            @Override // d4.a
            public final Object b() {
                s3.t F;
                F = h.this.F();
                return F;
            }
        });
        this.f108p = new AtomicInteger();
        this.f109q = new a();
        this.f110r = new CopyOnWriteArrayList<>();
        this.f111s = new CopyOnWriteArrayList<>();
        this.f112t = new CopyOnWriteArrayList<>();
        this.f113u = new CopyOnWriteArrayList<>();
        this.f114v = new CopyOnWriteArrayList<>();
        this.f115w = false;
        this.f116x = false;
        if (a() == null) {
            throw new IllegalStateException("getLifecycle() returned null in ComponentActivity's constructor. Please make sure you are lazily constructing your Lifecycle in the first call to getLifecycle() rather than relying on field initialization.");
        }
        int i5 = Build.VERSION.SDK_INT;
        a().a(new b());
        a().a(new c());
        a().a(new d());
        a5.c();
        d0.a(this);
        if (i5 <= 23) {
            a().a(new o(this));
        }
        k().h("android:support:activity-result", new d.c() { // from class: androidx.activity.f
            @Override // u.d.c
            public final Bundle a() {
                Bundle G;
                G = h.this.G();
                return G;
            }
        });
        z(new b.b() { // from class: androidx.activity.g
            @Override // b.b
            public final void a(Context context) {
                h.this.H(context);
            }
        });
    }

    private j B() {
        return new k();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ s3.t F() {
        reportFullyDrawn();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Bundle G() {
        Bundle bundle = new Bundle();
        this.f109q.h(bundle);
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void H(Context context) {
        Bundle b5 = k().b("android:support:activity-result");
        if (b5 != null) {
            this.f109q.g(b5);
        }
    }

    public final void A(k.a<Intent> aVar) {
        this.f112t.add(aVar);
    }

    void C() {
        if (this.f103k == null) {
            i iVar = (i) getLastNonConfigurationInstance();
            if (iVar != null) {
                this.f103k = iVar.f130b;
            }
            if (this.f103k == null) {
                this.f103k = new l0();
            }
        }
    }

    public void D() {
        n0.a(getWindow().getDecorView(), this);
        o0.a(getWindow().getDecorView(), this);
        u.g.a(getWindow().getDecorView(), this);
        v.a(getWindow().getDecorView(), this);
        u.a(getWindow().getDecorView(), this);
    }

    public void E() {
        invalidateOptionsMenu();
    }

    @Deprecated
    public Object I() {
        return null;
    }

    @Override // androidx.core.app.m, androidx.lifecycle.m
    public androidx.lifecycle.i a() {
        return this.f101e;
    }

    @Override // android.app.Activity
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        D();
        this.f105m.x(getWindow().getDecorView());
        super.addContentView(view, layoutParams);
    }

    @Override // androidx.core.view.d
    public void c(androidx.core.view.f fVar) {
        this.f100d.f(fVar);
    }

    @Override // androidx.core.app.r0
    public final void e(k.a<androidx.core.app.o> aVar) {
        this.f113u.remove(aVar);
    }

    @Override // androidx.core.content.m
    public final void f(k.a<Configuration> aVar) {
        this.f110r.remove(aVar);
    }

    @Override // androidx.lifecycle.h
    public r.a g() {
        r.b bVar = new r.b();
        if (getApplication() != null) {
            bVar.b(i0.a.f557d, getApplication());
        }
        bVar.b(d0.f528a, this);
        bVar.b(d0.f529b, this);
        if (getIntent() != null && getIntent().getExtras() != null) {
            bVar.b(d0.f530c, getIntent().getExtras());
        }
        return bVar;
    }

    @Override // androidx.core.app.s0
    public final void h(k.a<u0> aVar) {
        this.f114v.remove(aVar);
    }

    @Override // androidx.core.app.r0
    public final void i(k.a<androidx.core.app.o> aVar) {
        this.f113u.add(aVar);
    }

    @Override // androidx.activity.s
    public final q j() {
        if (this.f104l == null) {
            this.f104l = new q(new e());
            a().a(new f());
        }
        return this.f104l;
    }

    @Override // u.f
    public final u.d k() {
        return this.f102f.b();
    }

    @Override // androidx.core.view.d
    public void l(androidx.core.view.f fVar) {
        this.f100d.a(fVar);
    }

    @Override // c.e
    public final c.d m() {
        return this.f109q;
    }

    @Override // androidx.core.app.s0
    public final void n(k.a<u0> aVar) {
        this.f114v.add(aVar);
    }

    @Override // androidx.core.content.n
    public final void o(k.a<Integer> aVar) {
        this.f111s.remove(aVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    @Deprecated
    public void onActivityResult(int i5, int i6, Intent intent) {
        if (this.f109q.b(i5, i6, intent)) {
            return;
        }
        super.onActivityResult(i5, i6, intent);
    }

    @Override // android.app.Activity
    @Deprecated
    public void onBackPressed() {
        j().k();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        Iterator<k.a<Configuration>> it = this.f110r.iterator();
        while (it.hasNext()) {
            it.next().accept(configuration);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.core.app.m, android.app.Activity
    public void onCreate(Bundle bundle) {
        this.f102f.d(bundle);
        this.f99c.c(this);
        super.onCreate(bundle);
        z.e(this);
        int i5 = this.f107o;
        if (i5 != 0) {
            setContentView(i5);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onCreatePanelMenu(int i5, Menu menu) {
        if (i5 == 0) {
            super.onCreatePanelMenu(i5, menu);
            this.f100d.b(menu, getMenuInflater());
            return true;
        }
        return true;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuItemSelected(int i5, MenuItem menuItem) {
        if (super.onMenuItemSelected(i5, menuItem)) {
            return true;
        }
        if (i5 == 0) {
            return this.f100d.d(menuItem);
        }
        return false;
    }

    @Override // android.app.Activity
    public void onMultiWindowModeChanged(boolean z4) {
        if (this.f115w) {
            return;
        }
        Iterator<k.a<androidx.core.app.o>> it = this.f113u.iterator();
        while (it.hasNext()) {
            it.next().accept(new androidx.core.app.o(z4));
        }
    }

    @Override // android.app.Activity
    public void onMultiWindowModeChanged(boolean z4, Configuration configuration) {
        this.f115w = true;
        try {
            super.onMultiWindowModeChanged(z4, configuration);
            this.f115w = false;
            Iterator<k.a<androidx.core.app.o>> it = this.f113u.iterator();
            while (it.hasNext()) {
                it.next().accept(new androidx.core.app.o(z4, configuration));
            }
        } catch (Throwable th) {
            this.f115w = false;
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Iterator<k.a<Intent>> it = this.f112t.iterator();
        while (it.hasNext()) {
            it.next().accept(intent);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int i5, Menu menu) {
        this.f100d.c(menu);
        super.onPanelClosed(i5, menu);
    }

    @Override // android.app.Activity
    public void onPictureInPictureModeChanged(boolean z4) {
        if (this.f116x) {
            return;
        }
        Iterator<k.a<u0>> it = this.f114v.iterator();
        while (it.hasNext()) {
            it.next().accept(new u0(z4));
        }
    }

    @Override // android.app.Activity
    public void onPictureInPictureModeChanged(boolean z4, Configuration configuration) {
        this.f116x = true;
        try {
            super.onPictureInPictureModeChanged(z4, configuration);
            this.f116x = false;
            Iterator<k.a<u0>> it = this.f114v.iterator();
            while (it.hasNext()) {
                it.next().accept(new u0(z4, configuration));
            }
        } catch (Throwable th) {
            this.f116x = false;
            throw th;
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onPreparePanel(int i5, View view, Menu menu) {
        if (i5 == 0) {
            super.onPreparePanel(i5, view, menu);
            this.f100d.e(menu);
            return true;
        }
        return true;
    }

    @Override // android.app.Activity
    @Deprecated
    public void onRequestPermissionsResult(int i5, String[] strArr, int[] iArr) {
        if (this.f109q.b(i5, -1, new Intent().putExtra("androidx.activity.result.contract.extra.PERMISSIONS", strArr).putExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS", iArr)) || Build.VERSION.SDK_INT < 23) {
            return;
        }
        super.onRequestPermissionsResult(i5, strArr, iArr);
    }

    @Override // android.app.Activity
    public final Object onRetainNonConfigurationInstance() {
        i iVar;
        Object I = I();
        l0 l0Var = this.f103k;
        if (l0Var == null && (iVar = (i) getLastNonConfigurationInstance()) != null) {
            l0Var = iVar.f130b;
        }
        if (l0Var == null && I == null) {
            return null;
        }
        i iVar2 = new i();
        iVar2.f129a = I;
        iVar2.f130b = l0Var;
        return iVar2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.core.app.m, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        androidx.lifecycle.i a5 = a();
        if (a5 instanceof androidx.lifecycle.n) {
            ((androidx.lifecycle.n) a5).m(i.b.CREATED);
        }
        super.onSaveInstanceState(bundle);
        this.f102f.e(bundle);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks2
    public void onTrimMemory(int i5) {
        super.onTrimMemory(i5);
        Iterator<k.a<Integer>> it = this.f111s.iterator();
        while (it.hasNext()) {
            it.next().accept(Integer.valueOf(i5));
        }
    }

    @Override // androidx.lifecycle.m0
    public l0 p() {
        if (getApplication() != null) {
            C();
            return this.f103k;
        }
        throw new IllegalStateException("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.");
    }

    @Override // androidx.core.content.n
    public final void q(k.a<Integer> aVar) {
        this.f111s.add(aVar);
    }

    @Override // androidx.core.content.m
    public final void r(k.a<Configuration> aVar) {
        this.f110r.add(aVar);
    }

    @Override // android.app.Activity
    public void reportFullyDrawn() {
        try {
            if (w.a.h()) {
                w.a.c("reportFullyDrawn() for ComponentActivity");
            }
            super.reportFullyDrawn();
            this.f106n.b();
        } finally {
            w.a.f();
        }
    }

    @Override // android.app.Activity
    public void setContentView(int i5) {
        D();
        this.f105m.x(getWindow().getDecorView());
        super.setContentView(i5);
    }

    @Override // android.app.Activity
    public void setContentView(View view) {
        D();
        this.f105m.x(getWindow().getDecorView());
        super.setContentView(view);
    }

    @Override // android.app.Activity
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        D();
        this.f105m.x(getWindow().getDecorView());
        super.setContentView(view, layoutParams);
    }

    @Override // android.app.Activity
    @Deprecated
    public void startActivityForResult(Intent intent, int i5) {
        super.startActivityForResult(intent, i5);
    }

    @Override // android.app.Activity
    @Deprecated
    public void startActivityForResult(Intent intent, int i5, Bundle bundle) {
        super.startActivityForResult(intent, i5, bundle);
    }

    @Override // android.app.Activity
    @Deprecated
    public void startIntentSenderForResult(IntentSender intentSender, int i5, Intent intent, int i6, int i7, int i8) {
        super.startIntentSenderForResult(intentSender, i5, intent, i6, i7, i8);
    }

    @Override // android.app.Activity
    @Deprecated
    public void startIntentSenderForResult(IntentSender intentSender, int i5, Intent intent, int i6, int i7, int i8, Bundle bundle) {
        super.startIntentSenderForResult(intentSender, i5, intent, i6, i7, i8, bundle);
    }

    public final void z(b.b bVar) {
        this.f99c.a(bVar);
    }
}
