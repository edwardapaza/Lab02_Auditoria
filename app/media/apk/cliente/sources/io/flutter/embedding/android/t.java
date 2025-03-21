package io.flutter.embedding.android;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.database.ContentObserver;
import android.graphics.Insets;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.DisplayCutout;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewStructure;
import android.view.WindowInsets;
import android.view.WindowInsets$Type;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeProvider;
import android.view.autofill.AutofillValue;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.textservice.SpellCheckerInfo;
import android.view.textservice.TextServicesManager;
import android.widget.FrameLayout;
import b3.b;
import io.flutter.embedding.android.b0;
import io.flutter.embedding.android.l;
import io.flutter.embedding.engine.renderer.FlutterRenderer;
import io.flutter.view.h;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes.dex */
public class t extends FrameLayout implements b.c, b0.e {
    private final k.a<c0.j> A;

    /* renamed from: a  reason: collision with root package name */
    private m f3720a;

    /* renamed from: b  reason: collision with root package name */
    private n f3721b;

    /* renamed from: c  reason: collision with root package name */
    private l f3722c;

    /* renamed from: d  reason: collision with root package name */
    io.flutter.embedding.engine.renderer.e f3723d;

    /* renamed from: e  reason: collision with root package name */
    private io.flutter.embedding.engine.renderer.e f3724e;

    /* renamed from: f  reason: collision with root package name */
    private final Set<io.flutter.embedding.engine.renderer.d> f3725f;

    /* renamed from: k  reason: collision with root package name */
    private boolean f3726k;

    /* renamed from: l  reason: collision with root package name */
    private io.flutter.embedding.engine.a f3727l;

    /* renamed from: m  reason: collision with root package name */
    private final Set<f> f3728m;

    /* renamed from: n  reason: collision with root package name */
    private b3.b f3729n;

    /* renamed from: o  reason: collision with root package name */
    private io.flutter.plugin.editing.m f3730o;

    /* renamed from: p  reason: collision with root package name */
    private io.flutter.plugin.editing.f f3731p;

    /* renamed from: q  reason: collision with root package name */
    private a3.b f3732q;

    /* renamed from: r  reason: collision with root package name */
    private b0 f3733r;

    /* renamed from: s  reason: collision with root package name */
    private io.flutter.embedding.android.c f3734s;

    /* renamed from: t  reason: collision with root package name */
    private io.flutter.view.h f3735t;

    /* renamed from: u  reason: collision with root package name */
    private TextServicesManager f3736u;

    /* renamed from: v  reason: collision with root package name */
    private g0 f3737v;

    /* renamed from: w  reason: collision with root package name */
    private final FlutterRenderer.h f3738w;

    /* renamed from: x  reason: collision with root package name */
    private final h.k f3739x;

    /* renamed from: y  reason: collision with root package name */
    private final ContentObserver f3740y;

    /* renamed from: z  reason: collision with root package name */
    private final io.flutter.embedding.engine.renderer.d f3741z;

    /* loaded from: classes.dex */
    class a implements h.k {
        a() {
        }

        @Override // io.flutter.view.h.k
        public void a(boolean z4, boolean z5) {
            t.this.z(z4, z5);
        }
    }

    /* loaded from: classes.dex */
    class b extends ContentObserver {
        b(Handler handler) {
            super(handler);
        }

        @Override // android.database.ContentObserver
        public boolean deliverSelfNotifications() {
            return true;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z4) {
            super.onChange(z4);
            if (t.this.f3727l == null) {
                return;
            }
            n2.b.f("FlutterView", "System settings changed. Sending user settings to Flutter.");
            t.this.B();
        }
    }

    /* loaded from: classes.dex */
    class c implements io.flutter.embedding.engine.renderer.d {
        c() {
        }

        @Override // io.flutter.embedding.engine.renderer.d
        public void c() {
            t.this.f3726k = false;
            for (io.flutter.embedding.engine.renderer.d dVar : t.this.f3725f) {
                dVar.c();
            }
        }

        @Override // io.flutter.embedding.engine.renderer.d
        public void f() {
            t.this.f3726k = true;
            for (io.flutter.embedding.engine.renderer.d dVar : t.this.f3725f) {
                dVar.f();
            }
        }
    }

    /* loaded from: classes.dex */
    class d implements k.a<c0.j> {
        d() {
        }

        @Override // k.a
        /* renamed from: a */
        public void accept(c0.j jVar) {
            t.this.setWindowInfoListenerDisplayFeatures(jVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class e implements io.flutter.embedding.engine.renderer.d {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ FlutterRenderer f3746a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Runnable f3747b;

        e(FlutterRenderer flutterRenderer, Runnable runnable) {
            this.f3746a = flutterRenderer;
            this.f3747b = runnable;
        }

        @Override // io.flutter.embedding.engine.renderer.d
        public void c() {
        }

        @Override // io.flutter.embedding.engine.renderer.d
        public void f() {
            this.f3746a.u(this);
            this.f3747b.run();
            t tVar = t.this;
            if ((tVar.f3723d instanceof l) || tVar.f3722c == null) {
                return;
            }
            t.this.f3722c.a();
            t.this.x();
        }
    }

    /* loaded from: classes.dex */
    public interface f {
        void a();

        void b(io.flutter.embedding.engine.a aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public enum g {
        NONE,
        LEFT,
        RIGHT,
        BOTH
    }

    private t(Context context, AttributeSet attributeSet, m mVar) {
        super(context, attributeSet);
        this.f3725f = new HashSet();
        this.f3728m = new HashSet();
        this.f3738w = new FlutterRenderer.h();
        this.f3739x = new a();
        this.f3740y = new b(new Handler(Looper.getMainLooper()));
        this.f3741z = new c();
        this.A = new d();
        this.f3720a = mVar;
        this.f3723d = mVar;
        u();
    }

    private t(Context context, AttributeSet attributeSet, n nVar) {
        super(context, attributeSet);
        this.f3725f = new HashSet();
        this.f3728m = new HashSet();
        this.f3738w = new FlutterRenderer.h();
        this.f3739x = new a();
        this.f3740y = new b(new Handler(Looper.getMainLooper()));
        this.f3741z = new c();
        this.A = new d();
        this.f3721b = nVar;
        this.f3723d = nVar;
        u();
    }

    public t(Context context, m mVar) {
        this(context, (AttributeSet) null, mVar);
    }

    public t(Context context, n nVar) {
        this(context, (AttributeSet) null, nVar);
    }

    private void C() {
        if (!v()) {
            n2.b.g("FlutterView", "Tried to send viewport metrics from Android to Flutter but this FlutterView was not attached to a FlutterEngine.");
            return;
        }
        this.f3738w.f3897a = getResources().getDisplayMetrics().density;
        this.f3738w.f3912p = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.f3727l.t().y(this.f3738w);
    }

    private g o() {
        Context context = getContext();
        int i5 = context.getResources().getConfiguration().orientation;
        int rotation = ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRotation();
        if (i5 == 2) {
            if (rotation == 1) {
                return g.RIGHT;
            }
            if (rotation == 3) {
                return Build.VERSION.SDK_INT >= 23 ? g.LEFT : g.RIGHT;
            } else if (rotation == 0 || rotation == 2) {
                return g.BOTH;
            }
        }
        return g.NONE;
    }

    private int t(WindowInsets windowInsets) {
        if (windowInsets.getSystemWindowInsetBottom() < getRootView().getHeight() * 0.18d) {
            return 0;
        }
        return windowInsets.getSystemWindowInsetBottom();
    }

    private void u() {
        View view;
        n2.b.f("FlutterView", "Initializing FlutterView");
        if (this.f3720a != null) {
            n2.b.f("FlutterView", "Internally using a FlutterSurfaceView.");
            view = this.f3720a;
        } else if (this.f3721b != null) {
            n2.b.f("FlutterView", "Internally using a FlutterTextureView.");
            view = this.f3721b;
        } else {
            n2.b.f("FlutterView", "Internally using a FlutterImageView.");
            view = this.f3722c;
        }
        addView(view);
        setFocusable(true);
        setFocusableInTouchMode(true);
        if (Build.VERSION.SDK_INT >= 26) {
            setImportantForAutofill(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean w(SpellCheckerInfo spellCheckerInfo) {
        return spellCheckerInfo.getPackageName().equals("com.google.android.inputmethod.latin");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x() {
        l lVar = this.f3722c;
        if (lVar != null) {
            lVar.g();
            removeView(this.f3722c);
            this.f3722c = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(boolean z4, boolean z5) {
        boolean z6 = false;
        if (!this.f3727l.t().o() && !z4 && !z5) {
            z6 = true;
        }
        setWillNotDraw(z6);
    }

    public void A(Runnable runnable) {
        if (this.f3722c == null) {
            n2.b.f("FlutterView", "Tried to revert the image view, but no image view is used.");
            return;
        }
        io.flutter.embedding.engine.renderer.e eVar = this.f3724e;
        if (eVar == null) {
            n2.b.f("FlutterView", "Tried to revert the image view, but no previous surface was used.");
            return;
        }
        this.f3723d = eVar;
        this.f3724e = null;
        FlutterRenderer t5 = this.f3727l.t();
        if (this.f3727l != null && t5 != null) {
            this.f3723d.b();
            t5.j(new e(t5, runnable));
            return;
        }
        this.f3722c.a();
        x();
        runnable.run();
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x003f, code lost:
        if (r3 != false) goto L13;
     */
    /* JADX WARN: Removed duplicated region for block: B:20:0x007c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    void B() {
        /*
            r6 = this;
            android.content.res.Resources r0 = r6.getResources()
            android.content.res.Configuration r0 = r0.getConfiguration()
            int r0 = r0.uiMode
            r0 = r0 & 48
            r1 = 0
            r2 = 1
            r3 = 32
            if (r0 != r3) goto L14
            r0 = 1
            goto L15
        L14:
            r0 = 0
        L15:
            if (r0 == 0) goto L1a
            y2.p$c r0 = y2.p.c.dark
            goto L1c
        L1a:
            y2.p$c r0 = y2.p.c.light
        L1c:
            android.view.textservice.TextServicesManager r3 = r6.f3736u
            if (r3 == 0) goto L43
            int r4 = android.os.Build.VERSION.SDK_INT
            r5 = 31
            if (r4 < r5) goto L41
            java.util.List r3 = io.flutter.embedding.android.p.a(r3)
            java.util.stream.Stream r3 = io.flutter.embedding.android.q.a(r3)
            io.flutter.embedding.android.s r4 = new io.flutter.embedding.android.s
            r4.<init>()
            boolean r3 = r3.anyMatch(r4)
            android.view.textservice.TextServicesManager r4 = r6.f3736u
            boolean r4 = io.flutter.embedding.android.r.a(r4)
            if (r4 == 0) goto L43
            if (r3 == 0) goto L43
        L41:
            r3 = 1
            goto L44
        L43:
            r3 = 0
        L44:
            io.flutter.embedding.engine.a r4 = r6.f3727l
            y2.p r4 = r4.v()
            y2.p$b r4 = r4.d()
            android.content.res.Resources r5 = r6.getResources()
            android.content.res.Configuration r5 = r5.getConfiguration()
            float r5 = r5.fontScale
            y2.p$b r4 = r4.f(r5)
            android.content.res.Resources r5 = r6.getResources()
            android.util.DisplayMetrics r5 = r5.getDisplayMetrics()
            y2.p$b r4 = r4.c(r5)
            y2.p$b r3 = r4.d(r3)
            android.content.Context r4 = r6.getContext()
            android.content.ContentResolver r4 = r4.getContentResolver()
            java.lang.String r5 = "show_password"
            int r4 = android.provider.Settings.System.getInt(r4, r5, r2)
            if (r4 != r2) goto L7d
            r1 = 1
        L7d:
            y2.p$b r1 = r3.b(r1)
            android.content.Context r2 = r6.getContext()
            boolean r2 = android.text.format.DateFormat.is24HourFormat(r2)
            y2.p$b r1 = r1.g(r2)
            y2.p$b r0 = r1.e(r0)
            r0.a()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flutter.embedding.android.t.B():void");
    }

    @Override // io.flutter.embedding.android.b0.e
    public void a(KeyEvent keyEvent) {
        getRootView().dispatchKeyEvent(keyEvent);
    }

    @Override // android.view.View
    public void autofill(SparseArray<AutofillValue> sparseArray) {
        this.f3730o.j(sparseArray);
    }

    @Override // b3.b.c
    public PointerIcon b(int i5) {
        return PointerIcon.getSystemIcon(getContext(), i5);
    }

    @Override // io.flutter.embedding.android.b0.e
    public boolean c(KeyEvent keyEvent) {
        return this.f3730o.q(keyEvent);
    }

    @Override // android.view.View
    public boolean checkInputConnectionProxy(View view) {
        io.flutter.embedding.engine.a aVar = this.f3727l;
        return aVar != null ? aVar.q().G(view) : super.checkInputConnectionProxy(view);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
            getKeyDispatcherState().startTracking(keyEvent, this);
        } else if (keyEvent.getAction() == 1) {
            getKeyDispatcherState().handleUpEvent(keyEvent);
        }
        return (v() && this.f3733r.b(keyEvent)) || super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.view.View
    public AccessibilityNodeProvider getAccessibilityNodeProvider() {
        io.flutter.view.h hVar = this.f3735t;
        if (hVar == null || !hVar.C()) {
            return null;
        }
        return this.f3735t;
    }

    public io.flutter.embedding.engine.a getAttachedFlutterEngine() {
        return this.f3727l;
    }

    @Override // io.flutter.embedding.android.b0.e
    public z2.b getBinaryMessenger() {
        return this.f3727l.k();
    }

    public l getCurrentImageSurface() {
        return this.f3722c;
    }

    public boolean k() {
        l lVar = this.f3722c;
        if (lVar != null) {
            return lVar.e();
        }
        return false;
    }

    public void l(io.flutter.embedding.engine.renderer.d dVar) {
        this.f3725f.add(dVar);
    }

    public void m(l lVar) {
        io.flutter.embedding.engine.a aVar = this.f3727l;
        if (aVar != null) {
            lVar.c(aVar.t());
        }
    }

    public void n(io.flutter.embedding.engine.a aVar) {
        n2.b.f("FlutterView", "Attaching to a FlutterEngine: " + aVar);
        if (v()) {
            if (aVar == this.f3727l) {
                n2.b.f("FlutterView", "Already attached to this engine. Doing nothing.");
                return;
            } else {
                n2.b.f("FlutterView", "Currently attached to a different engine. Detaching and then attaching to new engine.");
                s();
            }
        }
        this.f3727l = aVar;
        FlutterRenderer t5 = aVar.t();
        this.f3726k = t5.n();
        this.f3723d.c(t5);
        t5.j(this.f3741z);
        if (Build.VERSION.SDK_INT >= 24) {
            this.f3729n = new b3.b(this, this.f3727l.n());
        }
        this.f3730o = new io.flutter.plugin.editing.m(this, this.f3727l.y(), this.f3727l.q());
        try {
            TextServicesManager textServicesManager = (TextServicesManager) getContext().getSystemService("textservices");
            this.f3736u = textServicesManager;
            this.f3731p = new io.flutter.plugin.editing.f(textServicesManager, this.f3727l.w());
        } catch (Exception unused) {
            n2.b.b("FlutterView", "TextServicesManager not supported by device, spell check disabled.");
        }
        this.f3732q = this.f3727l.m();
        this.f3733r = new b0(this);
        this.f3734s = new io.flutter.embedding.android.c(this.f3727l.t(), false);
        io.flutter.view.h hVar = new io.flutter.view.h(this, aVar.h(), (AccessibilityManager) getContext().getSystemService("accessibility"), getContext().getContentResolver(), this.f3727l.q());
        this.f3735t = hVar;
        hVar.a0(this.f3739x);
        z(this.f3735t.C(), this.f3735t.E());
        this.f3727l.q().a(this.f3735t);
        this.f3727l.q().E(this.f3727l.t());
        this.f3730o.p().restartInput(this);
        B();
        getContext().getContentResolver().registerContentObserver(Settings.System.getUriFor("show_password"), false, this.f3740y);
        C();
        aVar.q().F(this);
        for (f fVar : this.f3728m) {
            fVar.b(aVar);
        }
        if (this.f3726k) {
            this.f3741z.f();
        }
    }

    @Override // android.view.View
    public final WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        Insets insets;
        Insets insets2;
        Insets insets3;
        DisplayCutout displayCutout;
        Insets waterfallInsets;
        Insets systemGestureInsets;
        WindowInsets onApplyWindowInsets = super.onApplyWindowInsets(windowInsets);
        int i5 = Build.VERSION.SDK_INT;
        if (i5 == 29) {
            systemGestureInsets = windowInsets.getSystemGestureInsets();
            FlutterRenderer.h hVar = this.f3738w;
            hVar.f3908l = systemGestureInsets.top;
            hVar.f3909m = systemGestureInsets.right;
            hVar.f3910n = systemGestureInsets.bottom;
            hVar.f3911o = systemGestureInsets.left;
        }
        boolean z4 = (getWindowSystemUiVisibility() & 4) == 0;
        boolean z5 = (getWindowSystemUiVisibility() & 2) == 0;
        if (i5 >= 30) {
            int navigationBars = z5 ? 0 | WindowInsets$Type.navigationBars() : 0;
            if (z4) {
                navigationBars |= WindowInsets$Type.statusBars();
            }
            insets = windowInsets.getInsets(navigationBars);
            FlutterRenderer.h hVar2 = this.f3738w;
            hVar2.f3900d = insets.top;
            hVar2.f3901e = insets.right;
            hVar2.f3902f = insets.bottom;
            hVar2.f3903g = insets.left;
            insets2 = windowInsets.getInsets(WindowInsets$Type.ime());
            FlutterRenderer.h hVar3 = this.f3738w;
            hVar3.f3904h = insets2.top;
            hVar3.f3905i = insets2.right;
            hVar3.f3906j = insets2.bottom;
            hVar3.f3907k = insets2.left;
            insets3 = windowInsets.getInsets(WindowInsets$Type.systemGestures());
            FlutterRenderer.h hVar4 = this.f3738w;
            hVar4.f3908l = insets3.top;
            hVar4.f3909m = insets3.right;
            hVar4.f3910n = insets3.bottom;
            hVar4.f3911o = insets3.left;
            displayCutout = windowInsets.getDisplayCutout();
            if (displayCutout != null) {
                waterfallInsets = displayCutout.getWaterfallInsets();
                FlutterRenderer.h hVar5 = this.f3738w;
                hVar5.f3900d = Math.max(Math.max(hVar5.f3900d, waterfallInsets.top), displayCutout.getSafeInsetTop());
                FlutterRenderer.h hVar6 = this.f3738w;
                hVar6.f3901e = Math.max(Math.max(hVar6.f3901e, waterfallInsets.right), displayCutout.getSafeInsetRight());
                FlutterRenderer.h hVar7 = this.f3738w;
                hVar7.f3902f = Math.max(Math.max(hVar7.f3902f, waterfallInsets.bottom), displayCutout.getSafeInsetBottom());
                FlutterRenderer.h hVar8 = this.f3738w;
                hVar8.f3903g = Math.max(Math.max(hVar8.f3903g, waterfallInsets.left), displayCutout.getSafeInsetLeft());
            }
        } else {
            g gVar = g.NONE;
            if (!z5) {
                gVar = o();
            }
            this.f3738w.f3900d = z4 ? windowInsets.getSystemWindowInsetTop() : 0;
            this.f3738w.f3901e = (gVar == g.RIGHT || gVar == g.BOTH) ? 0 : windowInsets.getSystemWindowInsetRight();
            this.f3738w.f3902f = (z5 && t(windowInsets) == 0) ? windowInsets.getSystemWindowInsetBottom() : 0;
            this.f3738w.f3903g = (gVar == g.LEFT || gVar == g.BOTH) ? 0 : windowInsets.getSystemWindowInsetLeft();
            FlutterRenderer.h hVar9 = this.f3738w;
            hVar9.f3904h = 0;
            hVar9.f3905i = 0;
            hVar9.f3906j = t(windowInsets);
            this.f3738w.f3907k = 0;
        }
        n2.b.f("FlutterView", "Updating window insets (onApplyWindowInsets()):\nStatus bar insets: Top: " + this.f3738w.f3900d + ", Left: " + this.f3738w.f3903g + ", Right: " + this.f3738w.f3901e + "\nKeyboard insets: Bottom: " + this.f3738w.f3906j + ", Left: " + this.f3738w.f3907k + ", Right: " + this.f3738w.f3905i + "System Gesture Insets - Left: " + this.f3738w.f3911o + ", Top: " + this.f3738w.f3908l + ", Right: " + this.f3738w.f3909m + ", Bottom: " + this.f3738w.f3906j);
        C();
        return onApplyWindowInsets;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f3737v = r();
        Activity e5 = h3.h.e(getContext());
        g0 g0Var = this.f3737v;
        if (g0Var == null || e5 == null) {
            return;
        }
        g0Var.a(e5, androidx.core.content.a.getMainExecutor(getContext()), this.A);
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.f3727l != null) {
            n2.b.f("FlutterView", "Configuration changed. Sending locales and user settings to Flutter.");
            this.f3732q.d(configuration);
            B();
            h3.h.c(getContext(), this.f3727l);
        }
    }

    @Override // android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        return !v() ? super.onCreateInputConnection(editorInfo) : this.f3730o.n(this, this.f3733r, editorInfo);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        g0 g0Var = this.f3737v;
        if (g0Var != null) {
            g0Var.b(this.A);
        }
        this.f3737v = null;
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        if (v() && this.f3734s.j(motionEvent, getContext())) {
            return true;
        }
        return super.onGenericMotionEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        return !v() ? super.onHoverEvent(motionEvent) : this.f3735t.L(motionEvent);
    }

    @Override // android.view.View
    public void onProvideAutofillVirtualStructure(ViewStructure viewStructure, int i5) {
        super.onProvideAutofillVirtualStructure(viewStructure, i5);
        this.f3730o.y(viewStructure, i5);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i5, int i6, int i7, int i8) {
        super.onSizeChanged(i5, i6, i7, i8);
        n2.b.f("FlutterView", "Size changed. Sending Flutter new viewport metrics. FlutterView was " + i7 + " x " + i8 + ", it is now " + i5 + " x " + i6);
        FlutterRenderer.h hVar = this.f3738w;
        hVar.f3898b = i5;
        hVar.f3899c = i6;
        C();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (v()) {
            requestUnbufferedDispatch(motionEvent);
            return this.f3734s.k(motionEvent);
        }
        return super.onTouchEvent(motionEvent);
    }

    public void p() {
        this.f3723d.d();
        l lVar = this.f3722c;
        if (lVar == null) {
            l q5 = q();
            this.f3722c = q5;
            addView(q5);
        } else {
            lVar.k(getWidth(), getHeight());
        }
        this.f3724e = this.f3723d;
        l lVar2 = this.f3722c;
        this.f3723d = lVar2;
        io.flutter.embedding.engine.a aVar = this.f3727l;
        if (aVar != null) {
            lVar2.c(aVar.t());
        }
    }

    public l q() {
        return new l(getContext(), getWidth(), getHeight(), l.b.background);
    }

    protected g0 r() {
        try {
            return new g0(new b0.a(c0.f.f808a.d(getContext())));
        } catch (NoClassDefFoundError unused) {
            return null;
        }
    }

    public void s() {
        n2.b.f("FlutterView", "Detaching from a FlutterEngine: " + this.f3727l);
        if (!v()) {
            n2.b.f("FlutterView", "FlutterView not attached to an engine. Not detaching.");
            return;
        }
        for (f fVar : this.f3728m) {
            fVar.a();
        }
        getContext().getContentResolver().unregisterContentObserver(this.f3740y);
        this.f3727l.q().P();
        this.f3727l.q().d();
        this.f3735t.S();
        this.f3735t = null;
        this.f3730o.p().restartInput(this);
        this.f3730o.o();
        this.f3733r.d();
        io.flutter.plugin.editing.f fVar2 = this.f3731p;
        if (fVar2 != null) {
            fVar2.b();
        }
        b3.b bVar = this.f3729n;
        if (bVar != null) {
            bVar.c();
        }
        FlutterRenderer t5 = this.f3727l.t();
        this.f3726k = false;
        t5.u(this.f3741z);
        t5.A();
        t5.x(false);
        io.flutter.embedding.engine.renderer.e eVar = this.f3724e;
        if (eVar != null && this.f3723d == this.f3722c) {
            this.f3723d = eVar;
        }
        this.f3723d.a();
        x();
        this.f3724e = null;
        this.f3727l = null;
    }

    @Override // android.view.View
    public void setVisibility(int i5) {
        super.setVisibility(i5);
        io.flutter.embedding.engine.renderer.e eVar = this.f3723d;
        if (eVar instanceof m) {
            ((m) eVar).setVisibility(i5);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x009e, code lost:
        r7 = r7.getDisplayCutout();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void setWindowInfoListenerDisplayFeatures(c0.j r7) {
        /*
            r6 = this;
            java.util.List r7 = r7.a()
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.Iterator r7 = r7.iterator()
        Ld:
            boolean r1 = r7.hasNext()
            java.lang.String r2 = "FlutterView"
            if (r1 == 0) goto L92
            java.lang.Object r1 = r7.next()
            c0.a r1 = (c0.a) r1
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "WindowInfoTracker Display Feature reported with bounds = "
            r3.append(r4)
            android.graphics.Rect r4 = r1.getBounds()
            java.lang.String r4 = r4.toString()
            r3.append(r4)
            java.lang.String r4 = " and type = "
            r3.append(r4)
            java.lang.Class r4 = r1.getClass()
            java.lang.String r4 = r4.getSimpleName()
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            n2.b.f(r2, r3)
            boolean r2 = r1 instanceof c0.c
            if (r2 == 0) goto L80
            r2 = r1
            c0.c r2 = (c0.c) r2
            c0.c$a r3 = r2.b()
            c0.c$a r4 = c0.c.a.f787d
            if (r3 != r4) goto L59
            io.flutter.embedding.engine.renderer.FlutterRenderer$e r3 = io.flutter.embedding.engine.renderer.FlutterRenderer.e.HINGE
            goto L5b
        L59:
            io.flutter.embedding.engine.renderer.FlutterRenderer$e r3 = io.flutter.embedding.engine.renderer.FlutterRenderer.e.FOLD
        L5b:
            c0.c$b r4 = r2.a()
            c0.c$b r5 = c0.c.b.f790c
            if (r4 != r5) goto L66
            io.flutter.embedding.engine.renderer.FlutterRenderer$d r2 = io.flutter.embedding.engine.renderer.FlutterRenderer.d.POSTURE_FLAT
            goto L73
        L66:
            c0.c$b r2 = r2.a()
            c0.c$b r4 = c0.c.b.f791d
            if (r2 != r4) goto L71
            io.flutter.embedding.engine.renderer.FlutterRenderer$d r2 = io.flutter.embedding.engine.renderer.FlutterRenderer.d.POSTURE_HALF_OPENED
            goto L73
        L71:
            io.flutter.embedding.engine.renderer.FlutterRenderer$d r2 = io.flutter.embedding.engine.renderer.FlutterRenderer.d.UNKNOWN
        L73:
            io.flutter.embedding.engine.renderer.FlutterRenderer$c r4 = new io.flutter.embedding.engine.renderer.FlutterRenderer$c
            android.graphics.Rect r1 = r1.getBounds()
            r4.<init>(r1, r3, r2)
            r0.add(r4)
            goto Ld
        L80:
            io.flutter.embedding.engine.renderer.FlutterRenderer$c r2 = new io.flutter.embedding.engine.renderer.FlutterRenderer$c
            android.graphics.Rect r1 = r1.getBounds()
            io.flutter.embedding.engine.renderer.FlutterRenderer$e r3 = io.flutter.embedding.engine.renderer.FlutterRenderer.e.UNKNOWN
            io.flutter.embedding.engine.renderer.FlutterRenderer$d r4 = io.flutter.embedding.engine.renderer.FlutterRenderer.d.UNKNOWN
            r2.<init>(r1, r3, r4)
            r0.add(r2)
            goto Ld
        L92:
            int r7 = android.os.Build.VERSION.SDK_INT
            r1 = 28
            if (r7 < r1) goto Ldb
            android.view.WindowInsets r7 = r6.getRootWindowInsets()
            if (r7 == 0) goto Ldb
            android.view.DisplayCutout r7 = androidx.core.view.d0.a(r7)
            if (r7 == 0) goto Ldb
            java.util.List r7 = r7.getBoundingRects()
            java.util.Iterator r7 = r7.iterator()
        Lac:
            boolean r1 = r7.hasNext()
            if (r1 == 0) goto Ldb
            java.lang.Object r1 = r7.next()
            android.graphics.Rect r1 = (android.graphics.Rect) r1
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "DisplayCutout area reported with bounds = "
            r3.append(r4)
            java.lang.String r4 = r1.toString()
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            n2.b.f(r2, r3)
            io.flutter.embedding.engine.renderer.FlutterRenderer$c r3 = new io.flutter.embedding.engine.renderer.FlutterRenderer$c
            io.flutter.embedding.engine.renderer.FlutterRenderer$e r4 = io.flutter.embedding.engine.renderer.FlutterRenderer.e.CUTOUT
            r3.<init>(r1, r4)
            r0.add(r3)
            goto Lac
        Ldb:
            io.flutter.embedding.engine.renderer.FlutterRenderer$h r7 = r6.f3738w
            r7.f3913q = r0
            r6.C()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flutter.embedding.android.t.setWindowInfoListenerDisplayFeatures(c0.j):void");
    }

    public boolean v() {
        io.flutter.embedding.engine.a aVar = this.f3727l;
        return aVar != null && aVar.t() == this.f3723d.getAttachedRenderer();
    }

    public void y(io.flutter.embedding.engine.renderer.d dVar) {
        this.f3725f.remove(dVar);
    }
}
