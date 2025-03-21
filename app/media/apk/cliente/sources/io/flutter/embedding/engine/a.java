package io.flutter.embedding.engine;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import h3.h;
import io.flutter.embedding.engine.renderer.FlutterRenderer;
import io.flutter.plugin.platform.w;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import o2.a;
import y2.i;
import y2.j;
import y2.k;
import y2.n;
import y2.o;
import y2.p;
import y2.q;
import y2.r;
import y2.s;
/* loaded from: classes.dex */
public class a implements h.a {

    /* renamed from: a  reason: collision with root package name */
    private final FlutterJNI f3784a;

    /* renamed from: b  reason: collision with root package name */
    private final FlutterRenderer f3785b;

    /* renamed from: c  reason: collision with root package name */
    private final o2.a f3786c;

    /* renamed from: d  reason: collision with root package name */
    private final c f3787d;

    /* renamed from: e  reason: collision with root package name */
    private final a3.b f3788e;

    /* renamed from: f  reason: collision with root package name */
    private final y2.a f3789f;

    /* renamed from: g  reason: collision with root package name */
    private final y2.c f3790g;

    /* renamed from: h  reason: collision with root package name */
    private final y2.g f3791h;

    /* renamed from: i  reason: collision with root package name */
    private final y2.h f3792i;

    /* renamed from: j  reason: collision with root package name */
    private final i f3793j;

    /* renamed from: k  reason: collision with root package name */
    private final j f3794k;

    /* renamed from: l  reason: collision with root package name */
    private final y2.b f3795l;

    /* renamed from: m  reason: collision with root package name */
    private final o f3796m;

    /* renamed from: n  reason: collision with root package name */
    private final k f3797n;

    /* renamed from: o  reason: collision with root package name */
    private final n f3798o;

    /* renamed from: p  reason: collision with root package name */
    private final p f3799p;

    /* renamed from: q  reason: collision with root package name */
    private final q f3800q;

    /* renamed from: r  reason: collision with root package name */
    private final r f3801r;

    /* renamed from: s  reason: collision with root package name */
    private final s f3802s;

    /* renamed from: t  reason: collision with root package name */
    private final w f3803t;

    /* renamed from: u  reason: collision with root package name */
    private final Set<b> f3804u;

    /* renamed from: v  reason: collision with root package name */
    private final b f3805v;

    /* renamed from: io.flutter.embedding.engine.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class C0070a implements b {
        C0070a() {
        }

        @Override // io.flutter.embedding.engine.a.b
        public void a() {
        }

        @Override // io.flutter.embedding.engine.a.b
        public void b() {
            n2.b.f("FlutterEngine", "onPreEngineRestart()");
            for (b bVar : a.this.f3804u) {
                bVar.b();
            }
            a.this.f3803t.m0();
            a.this.f3796m.g();
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        void a();

        void b();
    }

    public a(Context context, q2.d dVar, FlutterJNI flutterJNI, w wVar, String[] strArr, boolean z4, boolean z5) {
        this(context, dVar, flutterJNI, wVar, strArr, z4, z5, null);
    }

    public a(Context context, q2.d dVar, FlutterJNI flutterJNI, w wVar, String[] strArr, boolean z4, boolean z5, d dVar2) {
        AssetManager assets;
        this.f3804u = new HashSet();
        this.f3805v = new C0070a();
        try {
            assets = context.createPackageContext(context.getPackageName(), 0).getAssets();
        } catch (PackageManager.NameNotFoundException unused) {
            assets = context.getAssets();
        }
        n2.a e5 = n2.a.e();
        flutterJNI = flutterJNI == null ? e5.d().a() : flutterJNI;
        this.f3784a = flutterJNI;
        o2.a aVar = new o2.a(flutterJNI, assets);
        this.f3786c = aVar;
        aVar.k();
        p2.a a5 = n2.a.e().a();
        this.f3789f = new y2.a(aVar, flutterJNI);
        y2.c cVar = new y2.c(aVar);
        this.f3790g = cVar;
        this.f3791h = new y2.g(aVar);
        y2.h hVar = new y2.h(aVar);
        this.f3792i = hVar;
        this.f3793j = new i(aVar);
        this.f3794k = new j(aVar);
        this.f3795l = new y2.b(aVar);
        this.f3797n = new k(aVar);
        this.f3798o = new n(aVar, context.getPackageManager());
        this.f3796m = new o(aVar, z5);
        this.f3799p = new p(aVar);
        this.f3800q = new q(aVar);
        this.f3801r = new r(aVar);
        this.f3802s = new s(aVar);
        if (a5 != null) {
            a5.e(cVar);
        }
        a3.b bVar = new a3.b(context, hVar);
        this.f3788e = bVar;
        dVar = dVar == null ? e5.c() : dVar;
        if (!flutterJNI.isAttached()) {
            dVar.k(context.getApplicationContext());
            dVar.f(context, strArr);
        }
        flutterJNI.addEngineLifecycleListener(this.f3805v);
        flutterJNI.setPlatformViewsController(wVar);
        flutterJNI.setLocalizationPlugin(bVar);
        flutterJNI.setDeferredComponentManager(e5.a());
        if (!flutterJNI.isAttached()) {
            f();
        }
        this.f3785b = new FlutterRenderer(flutterJNI);
        this.f3803t = wVar;
        wVar.g0();
        c cVar2 = new c(context.getApplicationContext(), this, dVar, dVar2);
        this.f3787d = cVar2;
        bVar.d(context.getResources().getConfiguration());
        if (z4 && dVar.e()) {
            x2.a.a(this);
        }
        h.c(context, this);
        cVar2.g(new c3.a(s()));
    }

    private void f() {
        n2.b.f("FlutterEngine", "Attaching to JNI.");
        this.f3784a.attachToNative();
        if (!z()) {
            throw new RuntimeException("FlutterEngine failed to attach to its native Object reference.");
        }
    }

    private boolean z() {
        return this.f3784a.isAttached();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a A(Context context, a.b bVar, String str, List<String> list, w wVar, boolean z4, boolean z5) {
        if (z()) {
            return new a(context, null, this.f3784a.spawn(bVar.f6750c, bVar.f6749b, str, list), wVar, null, z4, z5);
        }
        throw new IllegalStateException("Spawn can only be called on a fully constructed FlutterEngine");
    }

    @Override // h3.h.a
    public void a(float f5, float f6, float f7) {
        this.f3784a.updateDisplayMetrics(0, f5, f6, f7);
    }

    public void e(b bVar) {
        this.f3804u.add(bVar);
    }

    public void g() {
        n2.b.f("FlutterEngine", "Destroying.");
        for (b bVar : this.f3804u) {
            bVar.a();
        }
        this.f3787d.k();
        this.f3803t.i0();
        this.f3786c.l();
        this.f3784a.removeEngineLifecycleListener(this.f3805v);
        this.f3784a.setDeferredComponentManager(null);
        this.f3784a.detachFromNativeAndReleaseResources();
        if (n2.a.e().a() != null) {
            n2.a.e().a().destroy();
            this.f3790g.c(null);
        }
    }

    public y2.a h() {
        return this.f3789f;
    }

    public t2.b i() {
        return this.f3787d;
    }

    public y2.b j() {
        return this.f3795l;
    }

    public o2.a k() {
        return this.f3786c;
    }

    public y2.g l() {
        return this.f3791h;
    }

    public a3.b m() {
        return this.f3788e;
    }

    public i n() {
        return this.f3793j;
    }

    public j o() {
        return this.f3794k;
    }

    public k p() {
        return this.f3797n;
    }

    public w q() {
        return this.f3803t;
    }

    public s2.b r() {
        return this.f3787d;
    }

    public n s() {
        return this.f3798o;
    }

    public FlutterRenderer t() {
        return this.f3785b;
    }

    public o u() {
        return this.f3796m;
    }

    public p v() {
        return this.f3799p;
    }

    public q w() {
        return this.f3800q;
    }

    public r x() {
        return this.f3801r;
    }

    public s y() {
        return this.f3802s;
    }
}
