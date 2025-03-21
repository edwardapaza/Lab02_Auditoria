package io.flutter.embedding.android;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.window.BackEvent;
import android.window.OnBackAnimationCallback;
import android.window.OnBackInvokedCallback;
import androidx.lifecycle.i;
import io.flutter.embedding.android.g;
import java.util.List;
/* loaded from: classes.dex */
public class f extends Activity implements g.c, androidx.lifecycle.m {

    /* renamed from: e  reason: collision with root package name */
    public static final int f3668e = View.generateViewId();

    /* renamed from: a  reason: collision with root package name */
    private boolean f3669a = false;

    /* renamed from: b  reason: collision with root package name */
    protected g f3670b;

    /* renamed from: c  reason: collision with root package name */
    private androidx.lifecycle.n f3671c;

    /* renamed from: d  reason: collision with root package name */
    private final OnBackInvokedCallback f3672d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements OnBackAnimationCallback {
        a() {
        }

        public void onBackCancelled() {
            f.this.F();
        }

        public void onBackInvoked() {
            f.this.G();
        }

        public void onBackProgressed(BackEvent backEvent) {
            f.this.V(backEvent);
        }

        public void onBackStarted(BackEvent backEvent) {
            f.this.R(backEvent);
        }
    }

    public f() {
        this.f3672d = Build.VERSION.SDK_INT < 33 ? null : K();
        this.f3671c = new androidx.lifecycle.n(this);
    }

    private void H() {
        Window window = getWindow();
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(1073741824);
        window.getDecorView().setSystemUiVisibility(1280);
    }

    private void I() {
        if (L() == h.transparent) {
            getWindow().setBackgroundDrawable(new ColorDrawable(0));
        }
    }

    private View J() {
        return this.f3670b.u(null, null, null, f3668e, z() == e0.surface);
    }

    private OnBackInvokedCallback K() {
        return Build.VERSION.SDK_INT >= 34 ? new a() : new OnBackInvokedCallback() { // from class: io.flutter.embedding.android.e
            public final void onBackInvoked() {
                f.this.onBackPressed();
            }
        };
    }

    private boolean O() {
        return (getApplicationInfo().flags & 2) != 0;
    }

    private boolean S(String str) {
        StringBuilder sb;
        String str2;
        g gVar = this.f3670b;
        if (gVar == null) {
            sb = new StringBuilder();
            sb.append("FlutterActivity ");
            sb.append(hashCode());
            sb.append(" ");
            sb.append(str);
            str2 = " called after release.";
        } else if (gVar.o()) {
            return true;
        } else {
            sb = new StringBuilder();
            sb.append("FlutterActivity ");
            sb.append(hashCode());
            sb.append(" ");
            sb.append(str);
            str2 = " called after detach.";
        }
        sb.append(str2);
        n2.b.g("FlutterActivity", sb.toString());
        return false;
    }

    private void T() {
        try {
            Bundle N = N();
            if (N != null) {
                int i5 = N.getInt("io.flutter.embedding.android.NormalTheme", -1);
                if (i5 != -1) {
                    setTheme(i5);
                }
            } else {
                n2.b.f("FlutterActivity", "Using the launch theme as normal theme.");
            }
        } catch (PackageManager.NameNotFoundException unused) {
            n2.b.b("FlutterActivity", "Could not read meta-data for FlutterActivity. Using the launch theme as normal theme.");
        }
    }

    @Override // io.flutter.embedding.android.g.c
    public boolean A() {
        return true;
    }

    @Override // io.flutter.embedding.android.g.c
    public io.flutter.embedding.engine.a B(Context context) {
        return null;
    }

    @Override // io.flutter.embedding.android.g.c
    public f0 C() {
        return L() == h.opaque ? f0.opaque : f0.transparent;
    }

    @Override // io.flutter.embedding.android.g.c
    public void D(n nVar) {
    }

    @Override // io.flutter.embedding.android.g.c
    public void E(io.flutter.embedding.engine.a aVar) {
        if (this.f3670b.p()) {
            return;
        }
        x2.a.a(aVar);
    }

    public void F() {
        if (S("cancelBackGesture")) {
            this.f3670b.h();
        }
    }

    public void G() {
        if (S("commitBackGesture")) {
            this.f3670b.i();
        }
    }

    protected h L() {
        return getIntent().hasExtra("background_mode") ? h.valueOf(getIntent().getStringExtra("background_mode")) : h.opaque;
    }

    protected io.flutter.embedding.engine.a M() {
        return this.f3670b.n();
    }

    protected Bundle N() {
        return getPackageManager().getActivityInfo(getComponentName(), 128).metaData;
    }

    public void P() {
        if (Build.VERSION.SDK_INT >= 33) {
            getOnBackInvokedDispatcher().registerOnBackInvokedCallback(0, this.f3672d);
            this.f3669a = true;
        }
    }

    public void Q() {
        U();
        g gVar = this.f3670b;
        if (gVar != null) {
            gVar.J();
            this.f3670b = null;
        }
    }

    public void R(BackEvent backEvent) {
        if (S("startBackGesture")) {
            this.f3670b.L(backEvent);
        }
    }

    public void U() {
        if (Build.VERSION.SDK_INT >= 33) {
            getOnBackInvokedDispatcher().unregisterOnBackInvokedCallback(this.f3672d);
            this.f3669a = false;
        }
    }

    public void V(BackEvent backEvent) {
        if (S("updateBackGestureProgress")) {
            this.f3670b.M(backEvent);
        }
    }

    @Override // io.flutter.embedding.android.g.c, androidx.lifecycle.m
    public androidx.lifecycle.i a() {
        return this.f3671c;
    }

    @Override // io.flutter.plugin.platform.g.d
    public boolean b() {
        return false;
    }

    @Override // io.flutter.embedding.android.g.c
    public void c() {
    }

    @Override // io.flutter.embedding.android.g.c
    public Activity d() {
        return this;
    }

    @Override // io.flutter.embedding.android.g.c
    public void e() {
        n2.b.g("FlutterActivity", "FlutterActivity " + this + " connection to the engine " + M() + " evicted by another attaching activity");
        g gVar = this.f3670b;
        if (gVar != null) {
            gVar.v();
            this.f3670b.w();
        }
    }

    @Override // io.flutter.embedding.android.g.c
    public void f() {
        if (Build.VERSION.SDK_INT >= 29) {
            reportFullyDrawn();
        }
    }

    @Override // io.flutter.plugin.platform.g.d
    public void g(boolean z4) {
        if (z4 && !this.f3669a) {
            P();
        } else if (z4 || !this.f3669a) {
        } else {
            U();
        }
    }

    @Override // io.flutter.embedding.android.g.c
    public Context getContext() {
        return this;
    }

    @Override // io.flutter.embedding.android.g.c
    public String h() {
        return getIntent().getStringExtra("cached_engine_group_id");
    }

    @Override // io.flutter.embedding.android.g.c
    public String i() {
        if (getIntent().hasExtra("route")) {
            return getIntent().getStringExtra("route");
        }
        try {
            Bundle N = N();
            if (N != null) {
                return N.getString("io.flutter.InitialRoute");
            }
            return null;
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    @Override // io.flutter.embedding.android.g.c
    public List<String> l() {
        return (List) getIntent().getSerializableExtra("dart_entrypoint_args");
    }

    @Override // io.flutter.embedding.android.g.c
    public boolean m() {
        return true;
    }

    @Override // io.flutter.embedding.android.g.c
    public boolean n() {
        boolean booleanExtra = getIntent().getBooleanExtra("destroy_engine_with_activity", false);
        return (p() != null || this.f3670b.p()) ? booleanExtra : getIntent().getBooleanExtra("destroy_engine_with_activity", true);
    }

    @Override // io.flutter.embedding.android.g.c
    public boolean o() {
        return true;
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i5, int i6, Intent intent) {
        if (S("onActivityResult")) {
            this.f3670b.r(i5, i6, intent);
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (S("onBackPressed")) {
            this.f3670b.t();
        }
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        T();
        super.onCreate(bundle);
        g gVar = new g(this);
        this.f3670b = gVar;
        gVar.s(this);
        this.f3670b.B(bundle);
        this.f3671c.h(i.a.ON_CREATE);
        I();
        setContentView(J());
        H();
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        if (S("onDestroy")) {
            this.f3670b.v();
            this.f3670b.w();
        }
        Q();
        this.f3671c.h(i.a.ON_DESTROY);
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (S("onNewIntent")) {
            this.f3670b.x(intent);
        }
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        if (S("onPause")) {
            this.f3670b.y();
        }
        this.f3671c.h(i.a.ON_PAUSE);
    }

    @Override // android.app.Activity
    public void onPostResume() {
        super.onPostResume();
        if (S("onPostResume")) {
            this.f3670b.z();
        }
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i5, String[] strArr, int[] iArr) {
        if (S("onRequestPermissionsResult")) {
            this.f3670b.A(i5, strArr, iArr);
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        this.f3671c.h(i.a.ON_RESUME);
        if (S("onResume")) {
            this.f3670b.C();
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (S("onSaveInstanceState")) {
            this.f3670b.D(bundle);
        }
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        this.f3671c.h(i.a.ON_START);
        if (S("onStart")) {
            this.f3670b.E();
        }
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
        if (S("onStop")) {
            this.f3670b.F();
        }
        this.f3671c.h(i.a.ON_STOP);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks2
    public void onTrimMemory(int i5) {
        super.onTrimMemory(i5);
        if (S("onTrimMemory")) {
            this.f3670b.G(i5);
        }
    }

    @Override // android.app.Activity
    public void onUserLeaveHint() {
        if (S("onUserLeaveHint")) {
            this.f3670b.H();
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z4) {
        super.onWindowFocusChanged(z4);
        if (S("onWindowFocusChanged")) {
            this.f3670b.I(z4);
        }
    }

    @Override // io.flutter.embedding.android.g.c
    public String p() {
        return getIntent().getStringExtra("cached_engine_id");
    }

    @Override // io.flutter.embedding.android.g.c
    public boolean q() {
        return getIntent().hasExtra("enable_state_restoration") ? getIntent().getBooleanExtra("enable_state_restoration", false) : p() == null;
    }

    @Override // io.flutter.embedding.android.g.c
    public String r() {
        if (getIntent().hasExtra("dart_entrypoint")) {
            return getIntent().getStringExtra("dart_entrypoint");
        }
        try {
            Bundle N = N();
            String string = N != null ? N.getString("io.flutter.Entrypoint") : null;
            return string != null ? string : "main";
        } catch (PackageManager.NameNotFoundException unused) {
            return "main";
        }
    }

    @Override // io.flutter.embedding.android.g.c
    public void s(io.flutter.embedding.engine.a aVar) {
    }

    @Override // io.flutter.embedding.android.g.c
    public String t() {
        try {
            Bundle N = N();
            if (N != null) {
                return N.getString("io.flutter.EntrypointUri");
            }
            return null;
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    @Override // io.flutter.embedding.android.g.c
    public io.flutter.plugin.platform.g u(Activity activity, io.flutter.embedding.engine.a aVar) {
        return new io.flutter.plugin.platform.g(d(), aVar.p(), this);
    }

    @Override // io.flutter.embedding.android.g.c
    public void v(m mVar) {
    }

    @Override // io.flutter.embedding.android.g.c
    public String w() {
        String dataString;
        if (O() && "android.intent.action.RUN".equals(getIntent().getAction()) && (dataString = getIntent().getDataString()) != null) {
            return dataString;
        }
        return null;
    }

    @Override // io.flutter.embedding.android.g.c
    public boolean x() {
        try {
            Bundle N = N();
            if (N != null) {
                return N.getBoolean("flutter_deeplinking_enabled");
            }
            return false;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    @Override // io.flutter.embedding.android.g.c
    public io.flutter.embedding.engine.g y() {
        return io.flutter.embedding.engine.g.a(getIntent());
    }

    @Override // io.flutter.embedding.android.g.c
    public e0 z() {
        return L() == h.opaque ? e0.surface : e0.texture;
    }
}
