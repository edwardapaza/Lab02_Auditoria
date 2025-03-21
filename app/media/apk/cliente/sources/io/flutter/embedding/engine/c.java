package io.flutter.embedding.engine;

import android.app.Activity;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ContentProvider;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.lifecycle.i;
import io.flutter.embedding.engine.plugins.lifecycle.HiddenLifecycleReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import s2.a;
import t2.c;
import z2.l;
import z2.m;
import z2.n;
import z2.o;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class c implements s2.b, t2.b {

    /* renamed from: b  reason: collision with root package name */
    private final io.flutter.embedding.engine.a f3810b;

    /* renamed from: c  reason: collision with root package name */
    private final a.b f3811c;

    /* renamed from: e  reason: collision with root package name */
    private io.flutter.embedding.android.d<Activity> f3813e;

    /* renamed from: f  reason: collision with root package name */
    private C0071c f3814f;

    /* renamed from: i  reason: collision with root package name */
    private Service f3817i;

    /* renamed from: k  reason: collision with root package name */
    private BroadcastReceiver f3819k;

    /* renamed from: m  reason: collision with root package name */
    private ContentProvider f3821m;

    /* renamed from: a  reason: collision with root package name */
    private final Map<Class<? extends s2.a>, s2.a> f3809a = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    private final Map<Class<? extends s2.a>, t2.a> f3812d = new HashMap();

    /* renamed from: g  reason: collision with root package name */
    private boolean f3815g = false;

    /* renamed from: h  reason: collision with root package name */
    private final Map<Class<? extends s2.a>, w2.a> f3816h = new HashMap();

    /* renamed from: j  reason: collision with root package name */
    private final Map<Class<? extends s2.a>, u2.a> f3818j = new HashMap();

    /* renamed from: l  reason: collision with root package name */
    private final Map<Class<? extends s2.a>, v2.a> f3820l = new HashMap();

    /* loaded from: classes.dex */
    private static class b implements a.InterfaceC0113a {

        /* renamed from: a  reason: collision with root package name */
        final q2.d f3822a;

        private b(q2.d dVar) {
            this.f3822a = dVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: io.flutter.embedding.engine.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0071c implements t2.c {

        /* renamed from: a  reason: collision with root package name */
        private final Activity f3823a;

        /* renamed from: b  reason: collision with root package name */
        private final HiddenLifecycleReference f3824b;

        /* renamed from: c  reason: collision with root package name */
        private final Set<n> f3825c = new HashSet();

        /* renamed from: d  reason: collision with root package name */
        private final Set<l> f3826d = new HashSet();

        /* renamed from: e  reason: collision with root package name */
        private final Set<m> f3827e = new HashSet();

        /* renamed from: f  reason: collision with root package name */
        private final Set<o> f3828f = new HashSet();

        /* renamed from: g  reason: collision with root package name */
        private final Set<Object> f3829g = new HashSet();

        /* renamed from: h  reason: collision with root package name */
        private final Set<c.a> f3830h = new HashSet();

        public C0071c(Activity activity, i iVar) {
            this.f3823a = activity;
            this.f3824b = new HiddenLifecycleReference(iVar);
        }

        @Override // t2.c
        public void a(l lVar) {
            this.f3826d.add(lVar);
        }

        @Override // t2.c
        public void b(l lVar) {
            this.f3826d.remove(lVar);
        }

        boolean c(int i5, int i6, Intent intent) {
            boolean z4;
            Iterator it = new HashSet(this.f3826d).iterator();
            while (true) {
                while (it.hasNext()) {
                    z4 = ((l) it.next()).a(i5, i6, intent) || z4;
                }
                return z4;
            }
        }

        @Override // t2.c
        public Activity d() {
            return this.f3823a;
        }

        void e(Intent intent) {
            for (m mVar : this.f3827e) {
                mVar.b(intent);
            }
        }

        boolean f(int i5, String[] strArr, int[] iArr) {
            boolean z4;
            while (true) {
                for (n nVar : this.f3825c) {
                    z4 = nVar.onRequestPermissionsResult(i5, strArr, iArr) || z4;
                }
                return z4;
            }
        }

        void g(Bundle bundle) {
            for (c.a aVar : this.f3830h) {
                aVar.c(bundle);
            }
        }

        void h(Bundle bundle) {
            for (c.a aVar : this.f3830h) {
                aVar.d(bundle);
            }
        }

        void i() {
            for (o oVar : this.f3828f) {
                oVar.e();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(Context context, io.flutter.embedding.engine.a aVar, q2.d dVar, d dVar2) {
        this.f3810b = aVar;
        this.f3811c = new a.b(context, aVar, aVar.k(), aVar.t(), aVar.q().W(), new b(dVar), dVar2);
    }

    private void j(Activity activity, i iVar) {
        this.f3814f = new C0071c(activity, iVar);
        this.f3810b.q().u0(activity.getIntent() != null ? activity.getIntent().getBooleanExtra("enable-software-rendering", false) : false);
        this.f3810b.q().C(activity, this.f3810b.t(), this.f3810b.k());
        for (t2.a aVar : this.f3812d.values()) {
            if (this.f3815g) {
                aVar.r(this.f3814f);
            } else {
                aVar.z(this.f3814f);
            }
        }
        this.f3815g = false;
    }

    private void l() {
        this.f3810b.q().O();
        this.f3813e = null;
        this.f3814f = null;
    }

    private void m() {
        if (r()) {
            i();
        } else if (u()) {
            p();
        } else if (s()) {
            n();
        } else if (t()) {
            o();
        }
    }

    private boolean r() {
        return this.f3813e != null;
    }

    private boolean s() {
        return this.f3819k != null;
    }

    private boolean t() {
        return this.f3821m != null;
    }

    private boolean u() {
        return this.f3817i != null;
    }

    @Override // t2.b
    public boolean a(int i5, int i6, Intent intent) {
        if (!r()) {
            n2.b.b("FlutterEngineCxnRegstry", "Attempted to notify ActivityAware plugins of onActivityResult, but no Activity was attached.");
            return false;
        }
        h3.e j5 = h3.e.j("FlutterEngineConnectionRegistry#onActivityResult");
        try {
            boolean c5 = this.f3814f.c(i5, i6, intent);
            if (j5 != null) {
                j5.close();
            }
            return c5;
        } catch (Throwable th) {
            if (j5 != null) {
                try {
                    j5.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    @Override // t2.b
    public void b(Intent intent) {
        if (!r()) {
            n2.b.b("FlutterEngineCxnRegstry", "Attempted to notify ActivityAware plugins of onNewIntent, but no Activity was attached.");
            return;
        }
        h3.e j5 = h3.e.j("FlutterEngineConnectionRegistry#onNewIntent");
        try {
            this.f3814f.e(intent);
            if (j5 != null) {
                j5.close();
            }
        } catch (Throwable th) {
            if (j5 != null) {
                try {
                    j5.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    @Override // t2.b
    public void c(Bundle bundle) {
        if (!r()) {
            n2.b.b("FlutterEngineCxnRegstry", "Attempted to notify ActivityAware plugins of onRestoreInstanceState, but no Activity was attached.");
            return;
        }
        h3.e j5 = h3.e.j("FlutterEngineConnectionRegistry#onRestoreInstanceState");
        try {
            this.f3814f.g(bundle);
            if (j5 != null) {
                j5.close();
            }
        } catch (Throwable th) {
            if (j5 != null) {
                try {
                    j5.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    @Override // t2.b
    public void d(Bundle bundle) {
        if (!r()) {
            n2.b.b("FlutterEngineCxnRegstry", "Attempted to notify ActivityAware plugins of onSaveInstanceState, but no Activity was attached.");
            return;
        }
        h3.e j5 = h3.e.j("FlutterEngineConnectionRegistry#onSaveInstanceState");
        try {
            this.f3814f.h(bundle);
            if (j5 != null) {
                j5.close();
            }
        } catch (Throwable th) {
            if (j5 != null) {
                try {
                    j5.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    @Override // t2.b
    public void e() {
        if (!r()) {
            n2.b.b("FlutterEngineCxnRegstry", "Attempted to notify ActivityAware plugins of onUserLeaveHint, but no Activity was attached.");
            return;
        }
        h3.e j5 = h3.e.j("FlutterEngineConnectionRegistry#onUserLeaveHint");
        try {
            this.f3814f.i();
            if (j5 != null) {
                j5.close();
            }
        } catch (Throwable th) {
            if (j5 != null) {
                try {
                    j5.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    @Override // t2.b
    public void f(io.flutter.embedding.android.d<Activity> dVar, i iVar) {
        h3.e j5 = h3.e.j("FlutterEngineConnectionRegistry#attachToActivity");
        try {
            io.flutter.embedding.android.d<Activity> dVar2 = this.f3813e;
            if (dVar2 != null) {
                dVar2.e();
            }
            m();
            this.f3813e = dVar;
            j(dVar.f(), iVar);
            if (j5 != null) {
                j5.close();
            }
        } catch (Throwable th) {
            if (j5 != null) {
                try {
                    j5.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // s2.b
    public void g(s2.a aVar) {
        h3.e j5 = h3.e.j("FlutterEngineConnectionRegistry#add " + aVar.getClass().getSimpleName());
        try {
            if (q(aVar.getClass())) {
                n2.b.g("FlutterEngineCxnRegstry", "Attempted to register plugin (" + aVar + ") but it was already registered with this FlutterEngine (" + this.f3810b + ").");
                if (j5 != null) {
                    j5.close();
                    return;
                }
                return;
            }
            n2.b.f("FlutterEngineCxnRegstry", "Adding plugin: " + aVar);
            this.f3809a.put(aVar.getClass(), aVar);
            aVar.b(this.f3811c);
            if (aVar instanceof t2.a) {
                t2.a aVar2 = (t2.a) aVar;
                this.f3812d.put(aVar.getClass(), aVar2);
                if (r()) {
                    aVar2.z(this.f3814f);
                }
            }
            if (aVar instanceof w2.a) {
                w2.a aVar3 = (w2.a) aVar;
                this.f3816h.put(aVar.getClass(), aVar3);
                if (u()) {
                    aVar3.a(null);
                }
            }
            if (aVar instanceof u2.a) {
                u2.a aVar4 = (u2.a) aVar;
                this.f3818j.put(aVar.getClass(), aVar4);
                if (s()) {
                    aVar4.a(null);
                }
            }
            if (aVar instanceof v2.a) {
                v2.a aVar5 = (v2.a) aVar;
                this.f3820l.put(aVar.getClass(), aVar5);
                if (t()) {
                    aVar5.b(null);
                }
            }
            if (j5 != null) {
                j5.close();
            }
        } catch (Throwable th) {
            if (j5 != null) {
                try {
                    j5.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    @Override // t2.b
    public void h() {
        if (!r()) {
            n2.b.b("FlutterEngineCxnRegstry", "Attempted to detach plugins from an Activity when no Activity was attached.");
            return;
        }
        h3.e j5 = h3.e.j("FlutterEngineConnectionRegistry#detachFromActivityForConfigChanges");
        try {
            this.f3815g = true;
            for (t2.a aVar : this.f3812d.values()) {
                aVar.A();
            }
            l();
            if (j5 != null) {
                j5.close();
            }
        } catch (Throwable th) {
            if (j5 != null) {
                try {
                    j5.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    @Override // t2.b
    public void i() {
        if (!r()) {
            n2.b.b("FlutterEngineCxnRegstry", "Attempted to detach plugins from an Activity when no Activity was attached.");
            return;
        }
        h3.e j5 = h3.e.j("FlutterEngineConnectionRegistry#detachFromActivity");
        try {
            for (t2.a aVar : this.f3812d.values()) {
                aVar.j();
            }
            l();
            if (j5 != null) {
                j5.close();
            }
        } catch (Throwable th) {
            if (j5 != null) {
                try {
                    j5.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    public void k() {
        n2.b.f("FlutterEngineCxnRegstry", "Destroying.");
        m();
        x();
    }

    public void n() {
        if (!s()) {
            n2.b.b("FlutterEngineCxnRegstry", "Attempted to detach plugins from a BroadcastReceiver when no BroadcastReceiver was attached.");
            return;
        }
        h3.e j5 = h3.e.j("FlutterEngineConnectionRegistry#detachFromBroadcastReceiver");
        try {
            for (u2.a aVar : this.f3818j.values()) {
                aVar.b();
            }
            if (j5 != null) {
                j5.close();
            }
        } catch (Throwable th) {
            if (j5 != null) {
                try {
                    j5.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    public void o() {
        if (!t()) {
            n2.b.b("FlutterEngineCxnRegstry", "Attempted to detach plugins from a ContentProvider when no ContentProvider was attached.");
            return;
        }
        h3.e j5 = h3.e.j("FlutterEngineConnectionRegistry#detachFromContentProvider");
        try {
            for (v2.a aVar : this.f3820l.values()) {
                aVar.a();
            }
            if (j5 != null) {
                j5.close();
            }
        } catch (Throwable th) {
            if (j5 != null) {
                try {
                    j5.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    @Override // t2.b
    public boolean onRequestPermissionsResult(int i5, String[] strArr, int[] iArr) {
        if (!r()) {
            n2.b.b("FlutterEngineCxnRegstry", "Attempted to notify ActivityAware plugins of onRequestPermissionsResult, but no Activity was attached.");
            return false;
        }
        h3.e j5 = h3.e.j("FlutterEngineConnectionRegistry#onRequestPermissionsResult");
        try {
            boolean f5 = this.f3814f.f(i5, strArr, iArr);
            if (j5 != null) {
                j5.close();
            }
            return f5;
        } catch (Throwable th) {
            if (j5 != null) {
                try {
                    j5.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    public void p() {
        if (!u()) {
            n2.b.b("FlutterEngineCxnRegstry", "Attempted to detach plugins from a Service when no Service was attached.");
            return;
        }
        h3.e j5 = h3.e.j("FlutterEngineConnectionRegistry#detachFromService");
        try {
            for (w2.a aVar : this.f3816h.values()) {
                aVar.b();
            }
            this.f3817i = null;
            if (j5 != null) {
                j5.close();
            }
        } catch (Throwable th) {
            if (j5 != null) {
                try {
                    j5.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    public boolean q(Class<? extends s2.a> cls) {
        return this.f3809a.containsKey(cls);
    }

    public void v(Class<? extends s2.a> cls) {
        s2.a aVar = this.f3809a.get(cls);
        if (aVar == null) {
            return;
        }
        h3.e j5 = h3.e.j("FlutterEngineConnectionRegistry#remove " + cls.getSimpleName());
        try {
            if (aVar instanceof t2.a) {
                if (r()) {
                    ((t2.a) aVar).j();
                }
                this.f3812d.remove(cls);
            }
            if (aVar instanceof w2.a) {
                if (u()) {
                    ((w2.a) aVar).b();
                }
                this.f3816h.remove(cls);
            }
            if (aVar instanceof u2.a) {
                if (s()) {
                    ((u2.a) aVar).b();
                }
                this.f3818j.remove(cls);
            }
            if (aVar instanceof v2.a) {
                if (t()) {
                    ((v2.a) aVar).a();
                }
                this.f3820l.remove(cls);
            }
            aVar.t(this.f3811c);
            this.f3809a.remove(cls);
            if (j5 != null) {
                j5.close();
            }
        } catch (Throwable th) {
            if (j5 != null) {
                try {
                    j5.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    public void w(Set<Class<? extends s2.a>> set) {
        for (Class<? extends s2.a> cls : set) {
            v(cls);
        }
    }

    public void x() {
        w(new HashSet(this.f3809a.keySet()));
        this.f3809a.clear();
    }
}
