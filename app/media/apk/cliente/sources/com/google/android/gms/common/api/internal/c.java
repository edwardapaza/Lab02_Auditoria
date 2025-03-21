package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
public final class c implements Application.ActivityLifecycleCallbacks, ComponentCallbacks2 {

    /* renamed from: e  reason: collision with root package name */
    private static final c f919e = new c();

    /* renamed from: a  reason: collision with root package name */
    private final AtomicBoolean f920a = new AtomicBoolean();

    /* renamed from: b  reason: collision with root package name */
    private final AtomicBoolean f921b = new AtomicBoolean();

    /* renamed from: c  reason: collision with root package name */
    private final ArrayList f922c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    private boolean f923d = false;

    /* loaded from: classes.dex */
    public interface a {
        void a(boolean z4);
    }

    private c() {
    }

    public static c b() {
        return f919e;
    }

    public static void c(Application application) {
        c cVar = f919e;
        synchronized (cVar) {
            if (!cVar.f923d) {
                application.registerActivityLifecycleCallbacks(cVar);
                application.registerComponentCallbacks(cVar);
                cVar.f923d = true;
            }
        }
    }

    private final void f(boolean z4) {
        synchronized (f919e) {
            Iterator it = this.f922c.iterator();
            while (it.hasNext()) {
                ((a) it.next()).a(z4);
            }
        }
    }

    public void a(a aVar) {
        synchronized (f919e) {
            this.f922c.add(aVar);
        }
    }

    public boolean d() {
        return this.f920a.get();
    }

    public boolean e(boolean z4) {
        if (!this.f921b.get()) {
            if (!q0.j.b()) {
                return z4;
            }
            ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
            ActivityManager.getMyMemoryState(runningAppProcessInfo);
            if (!this.f921b.getAndSet(true) && runningAppProcessInfo.importance > 100) {
                this.f920a.set(true);
            }
        }
        return d();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        AtomicBoolean atomicBoolean = this.f921b;
        boolean compareAndSet = this.f920a.compareAndSet(true, false);
        atomicBoolean.set(true);
        if (compareAndSet) {
            f(false);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        AtomicBoolean atomicBoolean = this.f921b;
        boolean compareAndSet = this.f920a.compareAndSet(true, false);
        atomicBoolean.set(true);
        if (compareAndSet) {
            f(false);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
    }

    @Override // android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration configuration) {
    }

    @Override // android.content.ComponentCallbacks
    public final void onLowMemory() {
    }

    @Override // android.content.ComponentCallbacks2
    public final void onTrimMemory(int i5) {
        if (i5 == 20 && this.f920a.compareAndSet(false, true)) {
            this.f921b.set(true);
            f(true);
        }
    }
}
