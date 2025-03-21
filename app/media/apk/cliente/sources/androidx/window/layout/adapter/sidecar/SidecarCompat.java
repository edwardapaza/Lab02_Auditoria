package androidx.window.layout.adapter.sidecar;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.os.IBinder;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.core.content.m;
import androidx.window.layout.adapter.sidecar.SidecarCompat;
import androidx.window.layout.adapter.sidecar.a;
import androidx.window.sidecar.SidecarDeviceState;
import androidx.window.sidecar.SidecarDisplayFeature;
import androidx.window.sidecar.SidecarInterface;
import androidx.window.sidecar.SidecarProvider;
import androidx.window.sidecar.SidecarWindowLayoutInfo;
import c0.j;
import e4.g;
import e4.k;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.locks.ReentrantLock;
import s3.t;
import t3.p;
/* loaded from: classes.dex */
public final class SidecarCompat implements androidx.window.layout.adapter.sidecar.a {

    /* renamed from: f  reason: collision with root package name */
    public static final a f710f = new a(null);

    /* renamed from: a  reason: collision with root package name */
    private final SidecarInterface f711a;

    /* renamed from: b  reason: collision with root package name */
    private final f0.a f712b;

    /* renamed from: c  reason: collision with root package name */
    private final Map<IBinder, Activity> f713c;

    /* renamed from: d  reason: collision with root package name */
    private final Map<Activity, k.a<Configuration>> f714d;

    /* renamed from: e  reason: collision with root package name */
    private b f715e;

    /* loaded from: classes.dex */
    public final class TranslatingCallback implements SidecarInterface.SidecarCallback {
        public TranslatingCallback() {
        }

        public void onDeviceStateChanged(SidecarDeviceState sidecarDeviceState) {
            SidecarInterface h5;
            k.e(sidecarDeviceState, "newDeviceState");
            Collection<Activity> values = SidecarCompat.this.f713c.values();
            SidecarCompat sidecarCompat = SidecarCompat.this;
            for (Activity activity : values) {
                IBinder a5 = SidecarCompat.f710f.a(activity);
                SidecarWindowLayoutInfo sidecarWindowLayoutInfo = null;
                if (a5 != null && (h5 = sidecarCompat.h()) != null) {
                    sidecarWindowLayoutInfo = h5.getWindowLayoutInfo(a5);
                }
                b bVar = sidecarCompat.f715e;
                if (bVar != null) {
                    bVar.a(activity, sidecarCompat.f712b.e(sidecarWindowLayoutInfo, sidecarDeviceState));
                }
            }
        }

        public void onWindowLayoutChanged(IBinder iBinder, SidecarWindowLayoutInfo sidecarWindowLayoutInfo) {
            SidecarDeviceState sidecarDeviceState;
            k.e(iBinder, "windowToken");
            k.e(sidecarWindowLayoutInfo, "newLayout");
            Activity activity = (Activity) SidecarCompat.this.f713c.get(iBinder);
            if (activity == null) {
                Log.w("SidecarCompat", "Unable to resolve activity from window token. Missing a call to #onWindowLayoutChangeListenerAdded()?");
                return;
            }
            f0.a aVar = SidecarCompat.this.f712b;
            SidecarInterface h5 = SidecarCompat.this.h();
            if (h5 == null || (sidecarDeviceState = h5.getDeviceState()) == null) {
                sidecarDeviceState = new SidecarDeviceState();
            }
            j e5 = aVar.e(sidecarWindowLayoutInfo, sidecarDeviceState);
            b bVar = SidecarCompat.this.f715e;
            if (bVar != null) {
                bVar.a(activity, e5);
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }

        public final IBinder a(Activity activity) {
            Window window;
            WindowManager.LayoutParams attributes;
            if (activity == null || (window = activity.getWindow()) == null || (attributes = window.getAttributes()) == null) {
                return null;
            }
            return attributes.token;
        }

        public final SidecarInterface b(Context context) {
            k.e(context, "context");
            return SidecarProvider.getSidecarImpl(context.getApplicationContext());
        }

        public final z.k c() {
            try {
                String apiVersion = SidecarProvider.getApiVersion();
                if (TextUtils.isEmpty(apiVersion)) {
                    return null;
                }
                return z.k.f8846f.b(apiVersion);
            } catch (NoClassDefFoundError | UnsupportedOperationException unused) {
                return null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class b implements a.InterfaceC0025a {

        /* renamed from: a  reason: collision with root package name */
        private final a.InterfaceC0025a f717a;

        /* renamed from: b  reason: collision with root package name */
        private final ReentrantLock f718b;

        /* renamed from: c  reason: collision with root package name */
        private final WeakHashMap<Activity, j> f719c;

        public b(a.InterfaceC0025a interfaceC0025a) {
            k.e(interfaceC0025a, "callbackInterface");
            this.f717a = interfaceC0025a;
            this.f718b = new ReentrantLock();
            this.f719c = new WeakHashMap<>();
        }

        @Override // androidx.window.layout.adapter.sidecar.a.InterfaceC0025a
        public void a(Activity activity, j jVar) {
            k.e(activity, "activity");
            k.e(jVar, "newLayout");
            ReentrantLock reentrantLock = this.f718b;
            reentrantLock.lock();
            try {
                if (k.a(jVar, this.f719c.get(activity))) {
                    return;
                }
                this.f719c.put(activity, jVar);
                reentrantLock.unlock();
                this.f717a.a(activity, jVar);
            } finally {
                reentrantLock.unlock();
            }
        }

        public final void b(Activity activity) {
            k.e(activity, "activity");
            ReentrantLock reentrantLock = this.f718b;
            reentrantLock.lock();
            try {
                this.f719c.put(activity, null);
                t tVar = t.f7573a;
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    /* loaded from: classes.dex */
    private static final class c implements View.OnAttachStateChangeListener {

        /* renamed from: a  reason: collision with root package name */
        private final SidecarCompat f720a;

        /* renamed from: b  reason: collision with root package name */
        private final WeakReference<Activity> f721b;

        public c(SidecarCompat sidecarCompat, Activity activity) {
            k.e(sidecarCompat, "sidecarCompat");
            k.e(activity, "activity");
            this.f720a = sidecarCompat;
            this.f721b = new WeakReference<>(activity);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            k.e(view, "view");
            view.removeOnAttachStateChangeListener(this);
            Activity activity = this.f721b.get();
            IBinder a5 = SidecarCompat.f710f.a(activity);
            if (activity == null || a5 == null) {
                return;
            }
            this.f720a.j(a5, activity);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            k.e(view, "view");
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SidecarCompat(Context context) {
        this(f710f.b(context), new f0.a(null, 1, null));
        k.e(context, "context");
    }

    public SidecarCompat(SidecarInterface sidecarInterface, f0.a aVar) {
        k.e(aVar, "sidecarAdapter");
        this.f711a = sidecarInterface;
        this.f712b = aVar;
        this.f713c = new LinkedHashMap();
        this.f714d = new LinkedHashMap();
    }

    private final void k(final Activity activity) {
        if (this.f714d.get(activity) == null && (activity instanceof m)) {
            k.a<Configuration> aVar = new k.a() { // from class: f0.b
                @Override // k.a
                public final void accept(Object obj) {
                    SidecarCompat.l(SidecarCompat.this, activity, (Configuration) obj);
                }
            };
            this.f714d.put(activity, aVar);
            ((m) activity).r(aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(SidecarCompat sidecarCompat, Activity activity, Configuration configuration) {
        k.e(sidecarCompat, "this$0");
        k.e(activity, "$activity");
        b bVar = sidecarCompat.f715e;
        if (bVar != null) {
            bVar.a(activity, sidecarCompat.i(activity));
        }
    }

    private final void m(Activity activity) {
        k.a<Configuration> aVar = this.f714d.get(activity);
        if (aVar == null) {
            return;
        }
        if (activity instanceof m) {
            ((m) activity).f(aVar);
        }
        this.f714d.remove(activity);
    }

    @Override // androidx.window.layout.adapter.sidecar.a
    public void a(a.InterfaceC0025a interfaceC0025a) {
        k.e(interfaceC0025a, "extensionCallback");
        this.f715e = new b(interfaceC0025a);
        SidecarInterface sidecarInterface = this.f711a;
        if (sidecarInterface != null) {
            sidecarInterface.setSidecarCallback(new DistinctElementSidecarCallback(this.f712b, new TranslatingCallback()));
        }
    }

    @Override // androidx.window.layout.adapter.sidecar.a
    public void b(Activity activity) {
        k.e(activity, "activity");
        IBinder a5 = f710f.a(activity);
        if (a5 != null) {
            j(a5, activity);
            return;
        }
        activity.getWindow().getDecorView().addOnAttachStateChangeListener(new c(this, activity));
    }

    @Override // androidx.window.layout.adapter.sidecar.a
    public void c(Activity activity) {
        SidecarInterface sidecarInterface;
        k.e(activity, "activity");
        IBinder a5 = f710f.a(activity);
        if (a5 == null) {
            return;
        }
        SidecarInterface sidecarInterface2 = this.f711a;
        if (sidecarInterface2 != null) {
            sidecarInterface2.onWindowLayoutChangeListenerRemoved(a5);
        }
        m(activity);
        b bVar = this.f715e;
        if (bVar != null) {
            bVar.b(activity);
        }
        boolean z4 = this.f713c.size() == 1;
        this.f713c.remove(a5);
        if (!z4 || (sidecarInterface = this.f711a) == null) {
            return;
        }
        sidecarInterface.onDeviceStateListenersChanged(true);
    }

    public final SidecarInterface h() {
        return this.f711a;
    }

    public final j i(Activity activity) {
        SidecarDeviceState sidecarDeviceState;
        List f5;
        k.e(activity, "activity");
        IBinder a5 = f710f.a(activity);
        if (a5 == null) {
            f5 = p.f();
            return new j(f5);
        }
        SidecarInterface sidecarInterface = this.f711a;
        SidecarWindowLayoutInfo windowLayoutInfo = sidecarInterface != null ? sidecarInterface.getWindowLayoutInfo(a5) : null;
        f0.a aVar = this.f712b;
        SidecarInterface sidecarInterface2 = this.f711a;
        if (sidecarInterface2 == null || (sidecarDeviceState = sidecarInterface2.getDeviceState()) == null) {
            sidecarDeviceState = new SidecarDeviceState();
        }
        return aVar.e(windowLayoutInfo, sidecarDeviceState);
    }

    public final void j(IBinder iBinder, Activity activity) {
        SidecarInterface sidecarInterface;
        k.e(iBinder, "windowToken");
        k.e(activity, "activity");
        this.f713c.put(iBinder, activity);
        SidecarInterface sidecarInterface2 = this.f711a;
        if (sidecarInterface2 != null) {
            sidecarInterface2.onWindowLayoutChangeListenerAdded(iBinder);
        }
        if (this.f713c.size() == 1 && (sidecarInterface = this.f711a) != null) {
            sidecarInterface.onDeviceStateListenersChanged(false);
        }
        b bVar = this.f715e;
        if (bVar != null) {
            bVar.a(activity, i(activity));
        }
        k(activity);
    }

    public boolean n() {
        Class<?> cls;
        Class<?> cls2;
        Class<?> cls3;
        Class<?> cls4;
        try {
            SidecarInterface sidecarInterface = this.f711a;
            Method method = (sidecarInterface == null || (cls4 = sidecarInterface.getClass()) == null) ? null : cls4.getMethod("setSidecarCallback", SidecarInterface.SidecarCallback.class);
            Class<?> returnType = method != null ? method.getReturnType() : null;
            if (!k.a(returnType, Void.TYPE)) {
                throw new NoSuchMethodException("Illegal return type for 'setSidecarCallback': " + returnType);
            }
            SidecarInterface sidecarInterface2 = this.f711a;
            if (sidecarInterface2 != null) {
                sidecarInterface2.getDeviceState();
            }
            SidecarInterface sidecarInterface3 = this.f711a;
            if (sidecarInterface3 != null) {
                sidecarInterface3.onDeviceStateListenersChanged(true);
            }
            SidecarInterface sidecarInterface4 = this.f711a;
            Method method2 = (sidecarInterface4 == null || (cls3 = sidecarInterface4.getClass()) == null) ? null : cls3.getMethod("getWindowLayoutInfo", IBinder.class);
            Class<?> returnType2 = method2 != null ? method2.getReturnType() : null;
            if (!k.a(returnType2, SidecarWindowLayoutInfo.class)) {
                throw new NoSuchMethodException("Illegal return type for 'getWindowLayoutInfo': " + returnType2);
            }
            SidecarInterface sidecarInterface5 = this.f711a;
            Method method3 = (sidecarInterface5 == null || (cls2 = sidecarInterface5.getClass()) == null) ? null : cls2.getMethod("onWindowLayoutChangeListenerAdded", IBinder.class);
            Class<?> returnType3 = method3 != null ? method3.getReturnType() : null;
            if (!k.a(returnType3, Void.TYPE)) {
                throw new NoSuchMethodException("Illegal return type for 'onWindowLayoutChangeListenerAdded': " + returnType3);
            }
            SidecarInterface sidecarInterface6 = this.f711a;
            Method method4 = (sidecarInterface6 == null || (cls = sidecarInterface6.getClass()) == null) ? null : cls.getMethod("onWindowLayoutChangeListenerRemoved", IBinder.class);
            Class<?> returnType4 = method4 != null ? method4.getReturnType() : null;
            if (!k.a(returnType4, Void.TYPE)) {
                throw new NoSuchMethodException("Illegal return type for 'onWindowLayoutChangeListenerRemoved': " + returnType4);
            }
            SidecarDeviceState sidecarDeviceState = new SidecarDeviceState();
            try {
                sidecarDeviceState.posture = 3;
            } catch (NoSuchFieldError unused) {
                SidecarDeviceState.class.getMethod("setPosture", Integer.TYPE).invoke(sidecarDeviceState, 3);
                Object invoke = SidecarDeviceState.class.getMethod("getPosture", new Class[0]).invoke(sidecarDeviceState, new Object[0]);
                k.c(invoke, "null cannot be cast to non-null type kotlin.Int");
                if (((Integer) invoke).intValue() != 3) {
                    throw new Exception("Invalid device posture getter/setter");
                }
            }
            SidecarDisplayFeature sidecarDisplayFeature = new SidecarDisplayFeature();
            Rect rect = sidecarDisplayFeature.getRect();
            k.d(rect, "displayFeature.rect");
            sidecarDisplayFeature.setRect(rect);
            sidecarDisplayFeature.getType();
            sidecarDisplayFeature.setType(1);
            SidecarWindowLayoutInfo sidecarWindowLayoutInfo = new SidecarWindowLayoutInfo();
            try {
                List list = sidecarWindowLayoutInfo.displayFeatures;
                return true;
            } catch (NoSuchFieldError unused2) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(sidecarDisplayFeature);
                SidecarWindowLayoutInfo.class.getMethod("setDisplayFeatures", List.class).invoke(sidecarWindowLayoutInfo, arrayList);
                Object invoke2 = SidecarWindowLayoutInfo.class.getMethod("getDisplayFeatures", new Class[0]).invoke(sidecarWindowLayoutInfo, new Object[0]);
                k.c(invoke2, "null cannot be cast to non-null type kotlin.collections.List<androidx.window.sidecar.SidecarDisplayFeature>");
                if (k.a(arrayList, (List) invoke2)) {
                    return true;
                }
                throw new Exception("Invalid display feature getter/setter");
            }
        } catch (Throwable unused3) {
            return false;
        }
    }
}
