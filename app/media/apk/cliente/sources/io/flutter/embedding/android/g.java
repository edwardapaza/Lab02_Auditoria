package io.flutter.embedding.android;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.window.BackEvent;
import io.flutter.embedding.engine.d;
import io.flutter.plugin.platform.g;
import java.util.Arrays;
import java.util.List;
import o2.a;
/* loaded from: classes.dex */
class g implements d<Activity> {

    /* renamed from: a  reason: collision with root package name */
    private c f3677a;

    /* renamed from: b  reason: collision with root package name */
    private io.flutter.embedding.engine.a f3678b;

    /* renamed from: c  reason: collision with root package name */
    t f3679c;

    /* renamed from: d  reason: collision with root package name */
    private io.flutter.plugin.platform.g f3680d;

    /* renamed from: e  reason: collision with root package name */
    ViewTreeObserver.OnPreDrawListener f3681e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f3682f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f3683g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f3684h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f3685i;

    /* renamed from: j  reason: collision with root package name */
    private Integer f3686j;

    /* renamed from: k  reason: collision with root package name */
    private io.flutter.embedding.engine.d f3687k;

    /* renamed from: l  reason: collision with root package name */
    private final io.flutter.embedding.engine.renderer.d f3688l;

    /* loaded from: classes.dex */
    class a implements io.flutter.embedding.engine.renderer.d {
        a() {
        }

        @Override // io.flutter.embedding.engine.renderer.d
        public void c() {
            g.this.f3677a.c();
            g.this.f3683g = false;
        }

        @Override // io.flutter.embedding.engine.renderer.d
        public void f() {
            g.this.f3677a.f();
            g.this.f3683g = true;
            g.this.f3684h = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b implements ViewTreeObserver.OnPreDrawListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ t f3690a;

        b(t tVar) {
            this.f3690a = tVar;
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            if (g.this.f3683g && g.this.f3681e != null) {
                this.f3690a.getViewTreeObserver().removeOnPreDrawListener(this);
                g.this.f3681e = null;
            }
            return g.this.f3683g;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface c extends g.d {
        boolean A();

        io.flutter.embedding.engine.a B(Context context);

        f0 C();

        void D(n nVar);

        void E(io.flutter.embedding.engine.a aVar);

        androidx.lifecycle.i a();

        void c();

        Activity d();

        void e();

        void f();

        Context getContext();

        String h();

        String i();

        List<String> l();

        boolean m();

        boolean n();

        boolean o();

        String p();

        boolean q();

        String r();

        void s(io.flutter.embedding.engine.a aVar);

        String t();

        io.flutter.plugin.platform.g u(Activity activity, io.flutter.embedding.engine.a aVar);

        void v(m mVar);

        String w();

        boolean x();

        io.flutter.embedding.engine.g y();

        e0 z();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(c cVar) {
        this(cVar, null);
    }

    g(c cVar, io.flutter.embedding.engine.d dVar) {
        this.f3688l = new a();
        this.f3677a = cVar;
        this.f3684h = false;
        this.f3687k = dVar;
    }

    private d.b g(d.b bVar) {
        String w5 = this.f3677a.w();
        if (w5 == null || w5.isEmpty()) {
            w5 = n2.a.e().c().g();
        }
        a.b bVar2 = new a.b(w5, this.f3677a.r());
        String i5 = this.f3677a.i();
        if (i5 == null && (i5 = q(this.f3677a.d().getIntent())) == null) {
            i5 = "/";
        }
        return bVar.i(bVar2).k(i5).j(this.f3677a.l());
    }

    private void j(t tVar) {
        if (this.f3677a.z() != e0.surface) {
            throw new IllegalArgumentException("Cannot delay the first Android view draw when the render mode is not set to `RenderMode.surface`.");
        }
        if (this.f3681e != null) {
            tVar.getViewTreeObserver().removeOnPreDrawListener(this.f3681e);
        }
        this.f3681e = new b(tVar);
        tVar.getViewTreeObserver().addOnPreDrawListener(this.f3681e);
    }

    private void k() {
        String str;
        if (this.f3677a.p() == null && !this.f3678b.k().i()) {
            String i5 = this.f3677a.i();
            if (i5 == null && (i5 = q(this.f3677a.d().getIntent())) == null) {
                i5 = "/";
            }
            String t5 = this.f3677a.t();
            if (("Executing Dart entrypoint: " + this.f3677a.r() + ", library uri: " + t5) == null) {
                str = "\"\"";
            } else {
                str = t5 + ", and sending initial route: " + i5;
            }
            n2.b.f("FlutterActivityAndFragmentDelegate", str);
            this.f3678b.o().c(i5);
            String w5 = this.f3677a.w();
            if (w5 == null || w5.isEmpty()) {
                w5 = n2.a.e().c().g();
            }
            this.f3678b.k().h(t5 == null ? new a.b(w5, this.f3677a.r()) : new a.b(w5, t5, this.f3677a.r()), this.f3677a.l());
        }
    }

    private void l() {
        if (this.f3677a == null) {
            throw new IllegalStateException("Cannot execute method on a destroyed FlutterActivityAndFragmentDelegate.");
        }
    }

    private String q(Intent intent) {
        Uri data;
        if (!this.f3677a.x() || (data = intent.getData()) == null) {
            return null;
        }
        return data.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void A(int i5, String[] strArr, int[] iArr) {
        l();
        if (this.f3678b == null) {
            n2.b.g("FlutterActivityAndFragmentDelegate", "onRequestPermissionResult() invoked before FlutterFragment was attached to an Activity.");
            return;
        }
        n2.b.f("FlutterActivityAndFragmentDelegate", "Forwarding onRequestPermissionsResult() to FlutterEngine:\nrequestCode: " + i5 + "\npermissions: " + Arrays.toString(strArr) + "\ngrantResults: " + Arrays.toString(iArr));
        this.f3678b.i().onRequestPermissionsResult(i5, strArr, iArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void B(Bundle bundle) {
        Bundle bundle2;
        n2.b.f("FlutterActivityAndFragmentDelegate", "onRestoreInstanceState. Giving framework and plugins an opportunity to restore state.");
        l();
        byte[] bArr = null;
        if (bundle != null) {
            Bundle bundle3 = bundle.getBundle("plugins");
            bArr = bundle.getByteArray("framework");
            bundle2 = bundle3;
        } else {
            bundle2 = null;
        }
        if (this.f3677a.q()) {
            this.f3678b.u().j(bArr);
        }
        if (this.f3677a.m()) {
            this.f3678b.i().c(bundle2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void C() {
        io.flutter.embedding.engine.a aVar;
        n2.b.f("FlutterActivityAndFragmentDelegate", "onResume()");
        l();
        if (!this.f3677a.o() || (aVar = this.f3678b) == null) {
            return;
        }
        aVar.l().e();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void D(Bundle bundle) {
        n2.b.f("FlutterActivityAndFragmentDelegate", "onSaveInstanceState. Giving framework and plugins an opportunity to save state.");
        l();
        if (this.f3677a.q()) {
            bundle.putByteArray("framework", this.f3678b.u().h());
        }
        if (this.f3677a.m()) {
            Bundle bundle2 = new Bundle();
            this.f3678b.i().d(bundle2);
            bundle.putBundle("plugins", bundle2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void E() {
        n2.b.f("FlutterActivityAndFragmentDelegate", "onStart()");
        l();
        k();
        Integer num = this.f3686j;
        if (num != null) {
            this.f3679c.setVisibility(num.intValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void F() {
        io.flutter.embedding.engine.a aVar;
        n2.b.f("FlutterActivityAndFragmentDelegate", "onStop()");
        l();
        if (this.f3677a.o() && (aVar = this.f3678b) != null) {
            aVar.l().d();
        }
        this.f3686j = Integer.valueOf(this.f3679c.getVisibility());
        this.f3679c.setVisibility(8);
        io.flutter.embedding.engine.a aVar2 = this.f3678b;
        if (aVar2 != null) {
            aVar2.t().p(40);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void G(int i5) {
        l();
        io.flutter.embedding.engine.a aVar = this.f3678b;
        if (aVar != null) {
            if (this.f3684h && i5 >= 10) {
                aVar.k().j();
                this.f3678b.x().a();
            }
            this.f3678b.t().p(i5);
            this.f3678b.q().o0(i5);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void H() {
        l();
        if (this.f3678b == null) {
            n2.b.g("FlutterActivityAndFragmentDelegate", "onUserLeaveHint() invoked before FlutterFragment was attached to an Activity.");
            return;
        }
        n2.b.f("FlutterActivityAndFragmentDelegate", "Forwarding onUserLeaveHint() to FlutterEngine.");
        this.f3678b.i().e();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void I(boolean z4) {
        io.flutter.embedding.engine.a aVar;
        l();
        StringBuilder sb = new StringBuilder();
        sb.append("Received onWindowFocusChanged: ");
        sb.append(z4 ? "true" : "false");
        n2.b.f("FlutterActivityAndFragmentDelegate", sb.toString());
        if (!this.f3677a.o() || (aVar = this.f3678b) == null) {
            return;
        }
        if (z4) {
            aVar.l().a();
        } else {
            aVar.l().f();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void J() {
        this.f3677a = null;
        this.f3678b = null;
        this.f3679c = null;
        this.f3680d = null;
    }

    void K() {
        io.flutter.embedding.engine.d dVar;
        d.b l5;
        n2.b.f("FlutterActivityAndFragmentDelegate", "Setting up FlutterEngine.");
        String p5 = this.f3677a.p();
        if (p5 != null) {
            io.flutter.embedding.engine.a a5 = io.flutter.embedding.engine.b.b().a(p5);
            this.f3678b = a5;
            this.f3682f = true;
            if (a5 != null) {
                return;
            }
            throw new IllegalStateException("The requested cached FlutterEngine did not exist in the FlutterEngineCache: '" + p5 + "'");
        }
        c cVar = this.f3677a;
        io.flutter.embedding.engine.a B = cVar.B(cVar.getContext());
        this.f3678b = B;
        if (B != null) {
            this.f3682f = true;
            return;
        }
        String h5 = this.f3677a.h();
        if (h5 != null) {
            dVar = io.flutter.embedding.engine.e.b().a(h5);
            if (dVar == null) {
                throw new IllegalStateException("The requested cached FlutterEngineGroup did not exist in the FlutterEngineGroupCache: '" + h5 + "'");
            }
            l5 = new d.b(this.f3677a.getContext());
        } else {
            n2.b.f("FlutterActivityAndFragmentDelegate", "No preferred FlutterEngine was provided. Creating a new FlutterEngine for this FlutterFragment.");
            dVar = this.f3687k;
            if (dVar == null) {
                dVar = new io.flutter.embedding.engine.d(this.f3677a.getContext(), this.f3677a.y().b());
            }
            l5 = new d.b(this.f3677a.getContext()).h(false).l(this.f3677a.q());
        }
        this.f3678b = dVar.a(g(l5));
        this.f3682f = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void L(BackEvent backEvent) {
        l();
        if (this.f3678b == null) {
            n2.b.g("FlutterActivityAndFragmentDelegate", "Invoked startBackGesture() before FlutterFragment was attached to an Activity.");
            return;
        }
        n2.b.f("FlutterActivityAndFragmentDelegate", "Forwarding startBackGesture() to FlutterEngine.");
        this.f3678b.j().d(backEvent);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void M(BackEvent backEvent) {
        l();
        if (this.f3678b == null) {
            n2.b.g("FlutterActivityAndFragmentDelegate", "Invoked updateBackGestureProgress() before FlutterFragment was attached to an Activity.");
            return;
        }
        n2.b.f("FlutterActivityAndFragmentDelegate", "Forwarding updateBackGestureProgress() to FlutterEngine.");
        this.f3678b.j().e(backEvent);
    }

    void N() {
        io.flutter.plugin.platform.g gVar = this.f3680d;
        if (gVar != null) {
            gVar.E();
        }
    }

    @Override // io.flutter.embedding.android.d
    public void e() {
        if (!this.f3677a.n()) {
            this.f3677a.e();
            return;
        }
        throw new AssertionError("The internal FlutterEngine created by " + this.f3677a + " has been attached to by another activity. To persist a FlutterEngine beyond the ownership of this activity, explicitly create a FlutterEngine");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h() {
        l();
        if (this.f3678b == null) {
            n2.b.g("FlutterActivityAndFragmentDelegate", "Invoked cancelBackGesture() before FlutterFragment was attached to an Activity.");
            return;
        }
        n2.b.f("FlutterActivityAndFragmentDelegate", "Forwarding cancelBackGesture() to FlutterEngine.");
        this.f3678b.j().b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i() {
        l();
        if (this.f3678b == null) {
            n2.b.g("FlutterActivityAndFragmentDelegate", "Invoked commitBackGesture() before FlutterFragment was attached to an Activity.");
            return;
        }
        n2.b.f("FlutterActivityAndFragmentDelegate", "Forwarding commitBackGesture() to FlutterEngine.");
        this.f3678b.j().c();
    }

    @Override // io.flutter.embedding.android.d
    /* renamed from: m */
    public Activity f() {
        Activity d5 = this.f3677a.d();
        if (d5 != null) {
            return d5;
        }
        throw new AssertionError("FlutterActivityAndFragmentDelegate's getAppComponent should only be queried after onAttach, when the host's activity should always be non-null");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public io.flutter.embedding.engine.a n() {
        return this.f3678b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean o() {
        return this.f3685i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean p() {
        return this.f3682f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void r(int i5, int i6, Intent intent) {
        l();
        if (this.f3678b == null) {
            n2.b.g("FlutterActivityAndFragmentDelegate", "onActivityResult() invoked before FlutterFragment was attached to an Activity.");
            return;
        }
        n2.b.f("FlutterActivityAndFragmentDelegate", "Forwarding onActivityResult() to FlutterEngine:\nrequestCode: " + i5 + "\nresultCode: " + i6 + "\ndata: " + intent);
        this.f3678b.i().a(i5, i6, intent);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void s(Context context) {
        l();
        if (this.f3678b == null) {
            K();
        }
        if (this.f3677a.m()) {
            n2.b.f("FlutterActivityAndFragmentDelegate", "Attaching FlutterEngine to the Activity that owns this delegate.");
            this.f3678b.i().f(this, this.f3677a.a());
        }
        c cVar = this.f3677a;
        this.f3680d = cVar.u(cVar.d(), this.f3678b);
        this.f3677a.E(this.f3678b);
        this.f3685i = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void t() {
        l();
        if (this.f3678b == null) {
            n2.b.g("FlutterActivityAndFragmentDelegate", "Invoked onBackPressed() before FlutterFragment was attached to an Activity.");
            return;
        }
        n2.b.f("FlutterActivityAndFragmentDelegate", "Forwarding onBackPressed() to FlutterEngine.");
        this.f3678b.o().a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View u(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle, int i5, boolean z4) {
        t tVar;
        n2.b.f("FlutterActivityAndFragmentDelegate", "Creating FlutterView.");
        l();
        if (this.f3677a.z() == e0.surface) {
            m mVar = new m(this.f3677a.getContext(), this.f3677a.C() == f0.transparent);
            this.f3677a.v(mVar);
            tVar = new t(this.f3677a.getContext(), mVar);
        } else {
            n nVar = new n(this.f3677a.getContext());
            nVar.setOpaque(this.f3677a.C() == f0.opaque);
            this.f3677a.D(nVar);
            tVar = new t(this.f3677a.getContext(), nVar);
        }
        this.f3679c = tVar;
        this.f3679c.l(this.f3688l);
        if (this.f3677a.A()) {
            n2.b.f("FlutterActivityAndFragmentDelegate", "Attaching FlutterEngine to FlutterView.");
            this.f3679c.n(this.f3678b);
        }
        this.f3679c.setId(i5);
        if (z4) {
            j(this.f3679c);
        }
        return this.f3679c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void v() {
        n2.b.f("FlutterActivityAndFragmentDelegate", "onDestroyView()");
        l();
        if (this.f3681e != null) {
            this.f3679c.getViewTreeObserver().removeOnPreDrawListener(this.f3681e);
            this.f3681e = null;
        }
        t tVar = this.f3679c;
        if (tVar != null) {
            tVar.s();
            this.f3679c.y(this.f3688l);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void w() {
        io.flutter.embedding.engine.a aVar;
        if (this.f3685i) {
            n2.b.f("FlutterActivityAndFragmentDelegate", "onDetach()");
            l();
            this.f3677a.s(this.f3678b);
            if (this.f3677a.m()) {
                n2.b.f("FlutterActivityAndFragmentDelegate", "Detaching FlutterEngine from the Activity that owns this Fragment.");
                if (this.f3677a.d().isChangingConfigurations()) {
                    this.f3678b.i().h();
                } else {
                    this.f3678b.i().i();
                }
            }
            io.flutter.plugin.platform.g gVar = this.f3680d;
            if (gVar != null) {
                gVar.q();
                this.f3680d = null;
            }
            if (this.f3677a.o() && (aVar = this.f3678b) != null) {
                aVar.l().b();
            }
            if (this.f3677a.n()) {
                this.f3678b.g();
                if (this.f3677a.p() != null) {
                    io.flutter.embedding.engine.b.b().d(this.f3677a.p());
                }
                this.f3678b = null;
            }
            this.f3685i = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void x(Intent intent) {
        l();
        if (this.f3678b == null) {
            n2.b.g("FlutterActivityAndFragmentDelegate", "onNewIntent() invoked before FlutterFragment was attached to an Activity.");
            return;
        }
        n2.b.f("FlutterActivityAndFragmentDelegate", "Forwarding onNewIntent() to FlutterEngine and sending pushRouteInformation message.");
        this.f3678b.i().b(intent);
        String q5 = q(intent);
        if (q5 == null || q5.isEmpty()) {
            return;
        }
        this.f3678b.o().b(q5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void y() {
        io.flutter.embedding.engine.a aVar;
        n2.b.f("FlutterActivityAndFragmentDelegate", "onPause()");
        l();
        if (!this.f3677a.o() || (aVar = this.f3678b) == null) {
            return;
        }
        aVar.l().c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void z() {
        n2.b.f("FlutterActivityAndFragmentDelegate", "onPostResume()");
        l();
        if (this.f3678b == null) {
            n2.b.g("FlutterActivityAndFragmentDelegate", "onPostResume() invoked before FlutterFragment was attached to an Activity.");
            return;
        }
        N();
        this.f3678b.q().n0();
    }
}
