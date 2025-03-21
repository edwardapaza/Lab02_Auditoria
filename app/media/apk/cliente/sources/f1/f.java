package f1;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.api.internal.c;
import com.google.android.gms.common.api.internal.m1;
import com.google.firebase.FirebaseCommonRegistrar;
import com.google.firebase.components.ComponentDiscoveryService;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.concurrent.ExecutorsRegistrar;
import com.google.firebase.provider.FirebaseInitProvider;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import k1.o;
import k1.x;
/* loaded from: classes.dex */
public class f {

    /* renamed from: k  reason: collision with root package name */
    private static final Object f2974k = new Object();

    /* renamed from: l  reason: collision with root package name */
    static final Map<String, f> f2975l = new androidx.collection.a();

    /* renamed from: a  reason: collision with root package name */
    private final Context f2976a;

    /* renamed from: b  reason: collision with root package name */
    private final String f2977b;

    /* renamed from: c  reason: collision with root package name */
    private final n f2978c;

    /* renamed from: d  reason: collision with root package name */
    private final k1.o f2979d;

    /* renamed from: g  reason: collision with root package name */
    private final x<c2.a> f2982g;

    /* renamed from: h  reason: collision with root package name */
    private final b2.b<a2.f> f2983h;

    /* renamed from: e  reason: collision with root package name */
    private final AtomicBoolean f2980e = new AtomicBoolean(false);

    /* renamed from: f  reason: collision with root package name */
    private final AtomicBoolean f2981f = new AtomicBoolean();

    /* renamed from: i  reason: collision with root package name */
    private final List<a> f2984i = new CopyOnWriteArrayList();

    /* renamed from: j  reason: collision with root package name */
    private final List<g> f2985j = new CopyOnWriteArrayList();

    /* loaded from: classes.dex */
    public interface a {
        void a(boolean z4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b implements c.a {

        /* renamed from: a  reason: collision with root package name */
        private static AtomicReference<b> f2986a = new AtomicReference<>();

        private b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void c(Context context) {
            if (q0.j.a() && (context.getApplicationContext() instanceof Application)) {
                Application application = (Application) context.getApplicationContext();
                if (f2986a.get() == null) {
                    b bVar = new b();
                    if (m1.a(f2986a, null, bVar)) {
                        com.google.android.gms.common.api.internal.c.c(application);
                        com.google.android.gms.common.api.internal.c.b().a(bVar);
                    }
                }
            }
        }

        @Override // com.google.android.gms.common.api.internal.c.a
        public void a(boolean z4) {
            synchronized (f.f2974k) {
                Iterator it = new ArrayList(f.f2975l.values()).iterator();
                while (it.hasNext()) {
                    f fVar = (f) it.next();
                    if (fVar.f2980e.get()) {
                        fVar.C(z4);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c extends BroadcastReceiver {

        /* renamed from: b  reason: collision with root package name */
        private static AtomicReference<c> f2987b = new AtomicReference<>();

        /* renamed from: a  reason: collision with root package name */
        private final Context f2988a;

        public c(Context context) {
            this.f2988a = context;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void b(Context context) {
            if (f2987b.get() == null) {
                c cVar = new c(context);
                if (m1.a(f2987b, null, cVar)) {
                    context.registerReceiver(cVar, new IntentFilter("android.intent.action.USER_UNLOCKED"));
                }
            }
        }

        public void c() {
            this.f2988a.unregisterReceiver(this);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            synchronized (f.f2974k) {
                for (f fVar : f.f2975l.values()) {
                    fVar.t();
                }
            }
            c();
        }
    }

    protected f(final Context context, String str, n nVar) {
        this.f2976a = (Context) com.google.android.gms.common.internal.q.k(context);
        this.f2977b = com.google.android.gms.common.internal.q.e(str);
        this.f2978c = (n) com.google.android.gms.common.internal.q.k(nVar);
        p b5 = FirebaseInitProvider.b();
        f2.c.b("Firebase");
        f2.c.b("ComponentDiscovery");
        List<b2.b<ComponentRegistrar>> b6 = k1.g.c(context, ComponentDiscoveryService.class).b();
        f2.c.a();
        f2.c.b("Runtime");
        o.b g5 = k1.o.m(l1.k.INSTANCE).d(b6).c(new FirebaseCommonRegistrar()).c(new ExecutorsRegistrar()).b(k1.c.s(context, Context.class, new Class[0])).b(k1.c.s(this, f.class, new Class[0])).b(k1.c.s(nVar, n.class, new Class[0])).g(new f2.b());
        if (androidx.core.os.m.a(context) && FirebaseInitProvider.c()) {
            g5.b(k1.c.s(b5, p.class, new Class[0]));
        }
        k1.o e5 = g5.e();
        this.f2979d = e5;
        f2.c.a();
        this.f2982g = new x<>(new b2.b() { // from class: f1.d
            @Override // b2.b
            public final Object get() {
                c2.a z4;
                z4 = f.this.z(context);
                return z4;
            }
        });
        this.f2983h = e5.f(a2.f.class);
        g(new a() { // from class: f1.e
            @Override // f1.f.a
            public final void a(boolean z4) {
                f.this.A(z4);
            }
        });
        f2.c.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void A(boolean z4) {
        if (z4) {
            return;
        }
        this.f2983h.get().l();
    }

    private static String B(String str) {
        return str.trim();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C(boolean z4) {
        Log.d("FirebaseApp", "Notifying background state change listeners.");
        for (a aVar : this.f2984i) {
            aVar.a(z4);
        }
    }

    private void D() {
        for (g gVar : this.f2985j) {
            gVar.a(this.f2977b, this.f2978c);
        }
    }

    private void i() {
        com.google.android.gms.common.internal.q.n(!this.f2981f.get(), "FirebaseApp was deleted");
    }

    private static List<String> l() {
        ArrayList arrayList = new ArrayList();
        synchronized (f2974k) {
            for (f fVar : f2975l.values()) {
                arrayList.add(fVar.q());
            }
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    public static List<f> n(Context context) {
        ArrayList arrayList;
        synchronized (f2974k) {
            arrayList = new ArrayList(f2975l.values());
        }
        return arrayList;
    }

    public static f o() {
        f fVar;
        synchronized (f2974k) {
            fVar = f2975l.get("[DEFAULT]");
            if (fVar == null) {
                throw new IllegalStateException("Default FirebaseApp is not initialized in this process " + q0.l.a() + ". Make sure to call FirebaseApp.initializeApp(Context) first.");
            }
            fVar.f2983h.get().l();
        }
        return fVar;
    }

    public static f p(String str) {
        f fVar;
        List<String> l5;
        String str2;
        synchronized (f2974k) {
            fVar = f2975l.get(B(str));
            if (fVar == null) {
                if (l().isEmpty()) {
                    str2 = "";
                } else {
                    str2 = "Available app names: " + TextUtils.join(", ", l5);
                }
                throw new IllegalStateException(String.format("FirebaseApp with name %s doesn't exist. %s", str, str2));
            }
            fVar.f2983h.get().l();
        }
        return fVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t() {
        if (!androidx.core.os.m.a(this.f2976a)) {
            Log.i("FirebaseApp", "Device in Direct Boot Mode: postponing initialization of Firebase APIs for app " + q());
            c.b(this.f2976a);
            return;
        }
        Log.i("FirebaseApp", "Device unlocked: initializing all Firebase APIs for app " + q());
        this.f2979d.p(y());
        this.f2983h.get().l();
    }

    public static f u(Context context) {
        synchronized (f2974k) {
            if (f2975l.containsKey("[DEFAULT]")) {
                return o();
            }
            n a5 = n.a(context);
            if (a5 == null) {
                Log.w("FirebaseApp", "Default FirebaseApp failed to initialize because no default options were found. This usually means that com.google.gms:google-services was not applied to your gradle project.");
                return null;
            }
            return v(context, a5);
        }
    }

    public static f v(Context context, n nVar) {
        return w(context, nVar, "[DEFAULT]");
    }

    public static f w(Context context, n nVar, String str) {
        f fVar;
        b.c(context);
        String B = B(str);
        if (context.getApplicationContext() != null) {
            context = context.getApplicationContext();
        }
        synchronized (f2974k) {
            Map<String, f> map = f2975l;
            boolean z4 = !map.containsKey(B);
            com.google.android.gms.common.internal.q.n(z4, "FirebaseApp name " + B + " already exists!");
            com.google.android.gms.common.internal.q.l(context, "Application context cannot be null.");
            fVar = new f(context, B, nVar);
            map.put(B, fVar);
        }
        fVar.t();
        return fVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ c2.a z(Context context) {
        return new c2.a(context, s(), (p1.c) this.f2979d.a(p1.c.class));
    }

    public void E(boolean z4) {
        boolean z5;
        i();
        if (this.f2980e.compareAndSet(!z4, z4)) {
            boolean d5 = com.google.android.gms.common.api.internal.c.b().d();
            if (z4 && d5) {
                z5 = true;
            } else if (z4 || !d5) {
                return;
            } else {
                z5 = false;
            }
            C(z5);
        }
    }

    public void F(Boolean bool) {
        i();
        this.f2982g.get().e(bool);
    }

    public boolean equals(Object obj) {
        if (obj instanceof f) {
            return this.f2977b.equals(((f) obj).q());
        }
        return false;
    }

    public void g(a aVar) {
        i();
        if (this.f2980e.get() && com.google.android.gms.common.api.internal.c.b().d()) {
            aVar.a(true);
        }
        this.f2984i.add(aVar);
    }

    public void h(g gVar) {
        i();
        com.google.android.gms.common.internal.q.k(gVar);
        this.f2985j.add(gVar);
    }

    public int hashCode() {
        return this.f2977b.hashCode();
    }

    public void j() {
        if (this.f2981f.compareAndSet(false, true)) {
            synchronized (f2974k) {
                f2975l.remove(this.f2977b);
            }
            D();
        }
    }

    public <T> T k(Class<T> cls) {
        i();
        return (T) this.f2979d.a(cls);
    }

    public Context m() {
        i();
        return this.f2976a;
    }

    public String q() {
        i();
        return this.f2977b;
    }

    public n r() {
        i();
        return this.f2978c;
    }

    public String s() {
        return q0.c.e(q().getBytes(Charset.defaultCharset())) + "+" + q0.c.e(r().c().getBytes(Charset.defaultCharset()));
    }

    public String toString() {
        return com.google.android.gms.common.internal.p.c(this).a("name", this.f2977b).a("options", this.f2978c).toString();
    }

    public boolean x() {
        i();
        return this.f2982g.get().b();
    }

    public boolean y() {
        return "[DEFAULT]".equals(q());
    }
}
