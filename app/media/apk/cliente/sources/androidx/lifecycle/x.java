package androidx.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import androidx.lifecycle.i;
import androidx.lifecycle.z;
/* loaded from: classes.dex */
public final class x implements m {

    /* renamed from: m  reason: collision with root package name */
    public static final b f599m = new b(null);

    /* renamed from: n  reason: collision with root package name */
    private static final x f600n = new x();

    /* renamed from: a  reason: collision with root package name */
    private int f601a;

    /* renamed from: b  reason: collision with root package name */
    private int f602b;

    /* renamed from: e  reason: collision with root package name */
    private Handler f605e;

    /* renamed from: c  reason: collision with root package name */
    private boolean f603c = true;

    /* renamed from: d  reason: collision with root package name */
    private boolean f604d = true;

    /* renamed from: f  reason: collision with root package name */
    private final n f606f = new n(this);

    /* renamed from: k  reason: collision with root package name */
    private final Runnable f607k = new Runnable() { // from class: androidx.lifecycle.v
        @Override // java.lang.Runnable
        public final void run() {
            x.l(x.this);
        }
    };

    /* renamed from: l  reason: collision with root package name */
    private final z.a f608l = new d();

    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public static final a f609a = new a();

        private a() {
        }

        public static final void a(Activity activity, Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
            e4.k.e(activity, "activity");
            e4.k.e(activityLifecycleCallbacks, "callback");
            activity.registerActivityLifecycleCallbacks(activityLifecycleCallbacks);
        }
    }

    /* loaded from: classes.dex */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(e4.g gVar) {
            this();
        }

        public final m a() {
            return x.f600n;
        }

        public final void b(Context context) {
            e4.k.e(context, "context");
            x.f600n.i(context);
        }
    }

    /* loaded from: classes.dex */
    public static final class c extends f {

        /* loaded from: classes.dex */
        public static final class a extends f {
            final /* synthetic */ x this$0;

            a(x xVar) {
                this.this$0 = xVar;
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPostResumed(Activity activity) {
                e4.k.e(activity, "activity");
                this.this$0.f();
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPostStarted(Activity activity) {
                e4.k.e(activity, "activity");
                this.this$0.g();
            }
        }

        c() {
        }

        @Override // androidx.lifecycle.f, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            e4.k.e(activity, "activity");
            if (Build.VERSION.SDK_INT < 29) {
                z.f613b.b(activity).f(x.this.f608l);
            }
        }

        @Override // androidx.lifecycle.f, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            e4.k.e(activity, "activity");
            x.this.e();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPreCreated(Activity activity, Bundle bundle) {
            e4.k.e(activity, "activity");
            a.a(activity, new a(x.this));
        }

        @Override // androidx.lifecycle.f, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            e4.k.e(activity, "activity");
            x.this.h();
        }
    }

    /* loaded from: classes.dex */
    public static final class d implements z.a {
        d() {
        }

        @Override // androidx.lifecycle.z.a
        public void a() {
        }

        @Override // androidx.lifecycle.z.a
        public void b() {
            x.this.f();
        }

        @Override // androidx.lifecycle.z.a
        public void c() {
            x.this.g();
        }
    }

    private x() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(x xVar) {
        e4.k.e(xVar, "this$0");
        xVar.m();
        xVar.n();
    }

    public static final m o() {
        return f599m.a();
    }

    @Override // androidx.lifecycle.m
    public i a() {
        return this.f606f;
    }

    public final void e() {
        int i5 = this.f602b - 1;
        this.f602b = i5;
        if (i5 == 0) {
            Handler handler = this.f605e;
            e4.k.b(handler);
            handler.postDelayed(this.f607k, 700L);
        }
    }

    public final void f() {
        int i5 = this.f602b + 1;
        this.f602b = i5;
        if (i5 == 1) {
            if (this.f603c) {
                this.f606f.h(i.a.ON_RESUME);
                this.f603c = false;
                return;
            }
            Handler handler = this.f605e;
            e4.k.b(handler);
            handler.removeCallbacks(this.f607k);
        }
    }

    public final void g() {
        int i5 = this.f601a + 1;
        this.f601a = i5;
        if (i5 == 1 && this.f604d) {
            this.f606f.h(i.a.ON_START);
            this.f604d = false;
        }
    }

    public final void h() {
        this.f601a--;
        n();
    }

    public final void i(Context context) {
        e4.k.e(context, "context");
        this.f605e = new Handler();
        this.f606f.h(i.a.ON_CREATE);
        Context applicationContext = context.getApplicationContext();
        e4.k.c(applicationContext, "null cannot be cast to non-null type android.app.Application");
        ((Application) applicationContext).registerActivityLifecycleCallbacks(new c());
    }

    public final void m() {
        if (this.f602b == 0) {
            this.f603c = true;
            this.f606f.h(i.a.ON_PAUSE);
        }
    }

    public final void n() {
        if (this.f601a == 0 && this.f603c) {
            this.f606f.h(i.a.ON_STOP);
            this.f604d = true;
        }
    }
}
