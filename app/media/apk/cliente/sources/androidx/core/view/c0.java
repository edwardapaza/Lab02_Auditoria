package androidx.core.view;

import android.graphics.Insets;
import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.DisplayCutout;
import android.view.View;
import android.view.WindowInsets;
import android.view.WindowInsets$Builder;
import android.view.WindowInsets$Type;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Objects;
/* loaded from: classes.dex */
public class c0 {

    /* renamed from: b  reason: collision with root package name */
    public static final c0 f444b;

    /* renamed from: a  reason: collision with root package name */
    private final l f445a;

    /* loaded from: classes.dex */
    static class a {

        /* renamed from: a  reason: collision with root package name */
        private static Field f446a;

        /* renamed from: b  reason: collision with root package name */
        private static Field f447b;

        /* renamed from: c  reason: collision with root package name */
        private static Field f448c;

        /* renamed from: d  reason: collision with root package name */
        private static boolean f449d;

        static {
            try {
                Field declaredField = View.class.getDeclaredField("mAttachInfo");
                f446a = declaredField;
                declaredField.setAccessible(true);
                Class<?> cls = Class.forName("android.view.View$AttachInfo");
                Field declaredField2 = cls.getDeclaredField("mStableInsets");
                f447b = declaredField2;
                declaredField2.setAccessible(true);
                Field declaredField3 = cls.getDeclaredField("mContentInsets");
                f448c = declaredField3;
                declaredField3.setAccessible(true);
                f449d = true;
            } catch (ReflectiveOperationException e5) {
                Log.w("WindowInsetsCompat", "Failed to get visible insets from AttachInfo " + e5.getMessage(), e5);
            }
        }

        public static c0 a(View view) {
            if (f449d && view.isAttachedToWindow()) {
                try {
                    Object obj = f446a.get(view.getRootView());
                    if (obj != null) {
                        Rect rect = (Rect) f447b.get(obj);
                        Rect rect2 = (Rect) f448c.get(obj);
                        if (rect != null && rect2 != null) {
                            c0 a5 = new b().b(androidx.core.graphics.b.c(rect)).c(androidx.core.graphics.b.c(rect2)).a();
                            a5.k(a5);
                            a5.d(view.getRootView());
                            return a5;
                        }
                    }
                } catch (IllegalAccessException e5) {
                    Log.w("WindowInsetsCompat", "Failed to get insets from AttachInfo. " + e5.getMessage(), e5);
                }
            }
            return null;
        }
    }

    /* loaded from: classes.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private final f f450a;

        public b() {
            int i5 = Build.VERSION.SDK_INT;
            this.f450a = i5 >= 30 ? new e() : i5 >= 29 ? new d() : new c();
        }

        public c0 a() {
            return this.f450a.b();
        }

        @Deprecated
        public b b(androidx.core.graphics.b bVar) {
            this.f450a.d(bVar);
            return this;
        }

        @Deprecated
        public b c(androidx.core.graphics.b bVar) {
            this.f450a.f(bVar);
            return this;
        }
    }

    /* loaded from: classes.dex */
    private static class c extends f {

        /* renamed from: e  reason: collision with root package name */
        private static Field f451e = null;

        /* renamed from: f  reason: collision with root package name */
        private static boolean f452f = false;

        /* renamed from: g  reason: collision with root package name */
        private static Constructor<WindowInsets> f453g = null;

        /* renamed from: h  reason: collision with root package name */
        private static boolean f454h = false;

        /* renamed from: c  reason: collision with root package name */
        private WindowInsets f455c = h();

        /* renamed from: d  reason: collision with root package name */
        private androidx.core.graphics.b f456d;

        c() {
        }

        private static WindowInsets h() {
            if (!f452f) {
                try {
                    f451e = WindowInsets.class.getDeclaredField("CONSUMED");
                } catch (ReflectiveOperationException e5) {
                    Log.i("WindowInsetsCompat", "Could not retrieve WindowInsets.CONSUMED field", e5);
                }
                f452f = true;
            }
            Field field = f451e;
            if (field != null) {
                try {
                    WindowInsets windowInsets = (WindowInsets) field.get(null);
                    if (windowInsets != null) {
                        return new WindowInsets(windowInsets);
                    }
                } catch (ReflectiveOperationException e6) {
                    Log.i("WindowInsetsCompat", "Could not get value from WindowInsets.CONSUMED field", e6);
                }
            }
            if (!f454h) {
                try {
                    f453g = WindowInsets.class.getConstructor(Rect.class);
                } catch (ReflectiveOperationException e7) {
                    Log.i("WindowInsetsCompat", "Could not retrieve WindowInsets(Rect) constructor", e7);
                }
                f454h = true;
            }
            Constructor<WindowInsets> constructor = f453g;
            if (constructor != null) {
                try {
                    return constructor.newInstance(new Rect());
                } catch (ReflectiveOperationException e8) {
                    Log.i("WindowInsetsCompat", "Could not invoke WindowInsets(Rect) constructor", e8);
                }
            }
            return null;
        }

        @Override // androidx.core.view.c0.f
        c0 b() {
            a();
            c0 n5 = c0.n(this.f455c);
            n5.i(this.f459b);
            n5.l(this.f456d);
            return n5;
        }

        @Override // androidx.core.view.c0.f
        void d(androidx.core.graphics.b bVar) {
            this.f456d = bVar;
        }

        @Override // androidx.core.view.c0.f
        void f(androidx.core.graphics.b bVar) {
            WindowInsets windowInsets = this.f455c;
            if (windowInsets != null) {
                this.f455c = windowInsets.replaceSystemWindowInsets(bVar.f406a, bVar.f407b, bVar.f408c, bVar.f409d);
            }
        }
    }

    /* loaded from: classes.dex */
    private static class d extends f {

        /* renamed from: c  reason: collision with root package name */
        final WindowInsets$Builder f457c = new WindowInsets$Builder();

        d() {
        }

        @Override // androidx.core.view.c0.f
        c0 b() {
            a();
            c0 n5 = c0.n(this.f457c.build());
            n5.i(this.f459b);
            return n5;
        }

        @Override // androidx.core.view.c0.f
        void c(androidx.core.graphics.b bVar) {
            this.f457c.setMandatorySystemGestureInsets(bVar.e());
        }

        @Override // androidx.core.view.c0.f
        void d(androidx.core.graphics.b bVar) {
            this.f457c.setStableInsets(bVar.e());
        }

        @Override // androidx.core.view.c0.f
        void e(androidx.core.graphics.b bVar) {
            this.f457c.setSystemGestureInsets(bVar.e());
        }

        @Override // androidx.core.view.c0.f
        void f(androidx.core.graphics.b bVar) {
            this.f457c.setSystemWindowInsets(bVar.e());
        }

        @Override // androidx.core.view.c0.f
        void g(androidx.core.graphics.b bVar) {
            this.f457c.setTappableElementInsets(bVar.e());
        }
    }

    /* loaded from: classes.dex */
    private static class e extends d {
        e() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class f {

        /* renamed from: a  reason: collision with root package name */
        private final c0 f458a;

        /* renamed from: b  reason: collision with root package name */
        androidx.core.graphics.b[] f459b;

        f() {
            this(new c0((c0) null));
        }

        f(c0 c0Var) {
            this.f458a = c0Var;
        }

        protected final void a() {
            androidx.core.graphics.b[] bVarArr = this.f459b;
            if (bVarArr != null) {
                androidx.core.graphics.b bVar = bVarArr[m.d(1)];
                androidx.core.graphics.b bVar2 = this.f459b[m.d(2)];
                if (bVar2 == null) {
                    bVar2 = this.f458a.f(2);
                }
                if (bVar == null) {
                    bVar = this.f458a.f(1);
                }
                f(androidx.core.graphics.b.a(bVar, bVar2));
                androidx.core.graphics.b bVar3 = this.f459b[m.d(16)];
                if (bVar3 != null) {
                    e(bVar3);
                }
                androidx.core.graphics.b bVar4 = this.f459b[m.d(32)];
                if (bVar4 != null) {
                    c(bVar4);
                }
                androidx.core.graphics.b bVar5 = this.f459b[m.d(64)];
                if (bVar5 != null) {
                    g(bVar5);
                }
            }
        }

        c0 b() {
            throw null;
        }

        void c(androidx.core.graphics.b bVar) {
        }

        void d(androidx.core.graphics.b bVar) {
            throw null;
        }

        void e(androidx.core.graphics.b bVar) {
        }

        void f(androidx.core.graphics.b bVar) {
            throw null;
        }

        void g(androidx.core.graphics.b bVar) {
        }
    }

    /* loaded from: classes.dex */
    private static class g extends l {

        /* renamed from: h  reason: collision with root package name */
        private static boolean f460h = false;

        /* renamed from: i  reason: collision with root package name */
        private static Method f461i;

        /* renamed from: j  reason: collision with root package name */
        private static Class<?> f462j;

        /* renamed from: k  reason: collision with root package name */
        private static Field f463k;

        /* renamed from: l  reason: collision with root package name */
        private static Field f464l;

        /* renamed from: c  reason: collision with root package name */
        final WindowInsets f465c;

        /* renamed from: d  reason: collision with root package name */
        private androidx.core.graphics.b[] f466d;

        /* renamed from: e  reason: collision with root package name */
        private androidx.core.graphics.b f467e;

        /* renamed from: f  reason: collision with root package name */
        private c0 f468f;

        /* renamed from: g  reason: collision with root package name */
        androidx.core.graphics.b f469g;

        g(c0 c0Var, WindowInsets windowInsets) {
            super(c0Var);
            this.f467e = null;
            this.f465c = windowInsets;
        }

        g(c0 c0Var, g gVar) {
            this(c0Var, new WindowInsets(gVar.f465c));
        }

        private androidx.core.graphics.b s(int i5, boolean z4) {
            androidx.core.graphics.b bVar = androidx.core.graphics.b.f405e;
            for (int i6 = 1; i6 <= 256; i6 <<= 1) {
                if ((i5 & i6) != 0) {
                    bVar = androidx.core.graphics.b.a(bVar, t(i6, z4));
                }
            }
            return bVar;
        }

        private androidx.core.graphics.b u() {
            c0 c0Var = this.f468f;
            return c0Var != null ? c0Var.g() : androidx.core.graphics.b.f405e;
        }

        private androidx.core.graphics.b v(View view) {
            if (Build.VERSION.SDK_INT < 30) {
                if (!f460h) {
                    w();
                }
                Method method = f461i;
                if (method != null && f462j != null && f463k != null) {
                    try {
                        Object invoke = method.invoke(view, new Object[0]);
                        if (invoke == null) {
                            Log.w("WindowInsetsCompat", "Failed to get visible insets. getViewRootImpl() returned null from the provided view. This means that the view is either not attached or the method has been overridden", new NullPointerException());
                            return null;
                        }
                        Rect rect = (Rect) f463k.get(f464l.get(invoke));
                        if (rect != null) {
                            return androidx.core.graphics.b.c(rect);
                        }
                        return null;
                    } catch (ReflectiveOperationException e5) {
                        Log.e("WindowInsetsCompat", "Failed to get visible insets. (Reflection error). " + e5.getMessage(), e5);
                    }
                }
                return null;
            }
            throw new UnsupportedOperationException("getVisibleInsets() should not be called on API >= 30. Use WindowInsets.isVisible() instead.");
        }

        private static void w() {
            try {
                f461i = View.class.getDeclaredMethod("getViewRootImpl", new Class[0]);
                Class<?> cls = Class.forName("android.view.View$AttachInfo");
                f462j = cls;
                f463k = cls.getDeclaredField("mVisibleInsets");
                f464l = Class.forName("android.view.ViewRootImpl").getDeclaredField("mAttachInfo");
                f463k.setAccessible(true);
                f464l.setAccessible(true);
            } catch (ReflectiveOperationException e5) {
                Log.e("WindowInsetsCompat", "Failed to get visible insets. (Reflection error). " + e5.getMessage(), e5);
            }
            f460h = true;
        }

        @Override // androidx.core.view.c0.l
        void d(View view) {
            androidx.core.graphics.b v5 = v(view);
            if (v5 == null) {
                v5 = androidx.core.graphics.b.f405e;
            }
            p(v5);
        }

        @Override // androidx.core.view.c0.l
        void e(c0 c0Var) {
            c0Var.k(this.f468f);
            c0Var.j(this.f469g);
        }

        @Override // androidx.core.view.c0.l
        public boolean equals(Object obj) {
            if (super.equals(obj)) {
                return Objects.equals(this.f469g, ((g) obj).f469g);
            }
            return false;
        }

        @Override // androidx.core.view.c0.l
        public androidx.core.graphics.b g(int i5) {
            return s(i5, false);
        }

        @Override // androidx.core.view.c0.l
        final androidx.core.graphics.b k() {
            if (this.f467e == null) {
                this.f467e = androidx.core.graphics.b.b(this.f465c.getSystemWindowInsetLeft(), this.f465c.getSystemWindowInsetTop(), this.f465c.getSystemWindowInsetRight(), this.f465c.getSystemWindowInsetBottom());
            }
            return this.f467e;
        }

        @Override // androidx.core.view.c0.l
        boolean n() {
            return this.f465c.isRound();
        }

        @Override // androidx.core.view.c0.l
        public void o(androidx.core.graphics.b[] bVarArr) {
            this.f466d = bVarArr;
        }

        @Override // androidx.core.view.c0.l
        void p(androidx.core.graphics.b bVar) {
            this.f469g = bVar;
        }

        @Override // androidx.core.view.c0.l
        void q(c0 c0Var) {
            this.f468f = c0Var;
        }

        protected androidx.core.graphics.b t(int i5, boolean z4) {
            androidx.core.graphics.b g5;
            int i6;
            if (i5 == 1) {
                return z4 ? androidx.core.graphics.b.b(0, Math.max(u().f407b, k().f407b), 0, 0) : androidx.core.graphics.b.b(0, k().f407b, 0, 0);
            }
            if (i5 == 2) {
                if (z4) {
                    androidx.core.graphics.b u5 = u();
                    androidx.core.graphics.b i7 = i();
                    return androidx.core.graphics.b.b(Math.max(u5.f406a, i7.f406a), 0, Math.max(u5.f408c, i7.f408c), Math.max(u5.f409d, i7.f409d));
                }
                androidx.core.graphics.b k5 = k();
                c0 c0Var = this.f468f;
                g5 = c0Var != null ? c0Var.g() : null;
                int i8 = k5.f409d;
                if (g5 != null) {
                    i8 = Math.min(i8, g5.f409d);
                }
                return androidx.core.graphics.b.b(k5.f406a, 0, k5.f408c, i8);
            } else if (i5 != 8) {
                if (i5 != 16) {
                    if (i5 != 32) {
                        if (i5 != 64) {
                            if (i5 != 128) {
                                return androidx.core.graphics.b.f405e;
                            }
                            c0 c0Var2 = this.f468f;
                            androidx.core.view.a e5 = c0Var2 != null ? c0Var2.e() : f();
                            return e5 != null ? androidx.core.graphics.b.b(e5.b(), e5.d(), e5.c(), e5.a()) : androidx.core.graphics.b.f405e;
                        }
                        return l();
                    }
                    return h();
                }
                return j();
            } else {
                androidx.core.graphics.b[] bVarArr = this.f466d;
                g5 = bVarArr != null ? bVarArr[m.d(8)] : null;
                if (g5 != null) {
                    return g5;
                }
                androidx.core.graphics.b k6 = k();
                androidx.core.graphics.b u6 = u();
                int i9 = k6.f409d;
                if (i9 > u6.f409d) {
                    return androidx.core.graphics.b.b(0, 0, 0, i9);
                }
                androidx.core.graphics.b bVar = this.f469g;
                return (bVar == null || bVar.equals(androidx.core.graphics.b.f405e) || (i6 = this.f469g.f409d) <= u6.f409d) ? androidx.core.graphics.b.f405e : androidx.core.graphics.b.b(0, 0, 0, i6);
            }
        }
    }

    /* loaded from: classes.dex */
    private static class h extends g {

        /* renamed from: m  reason: collision with root package name */
        private androidx.core.graphics.b f470m;

        h(c0 c0Var, WindowInsets windowInsets) {
            super(c0Var, windowInsets);
            this.f470m = null;
        }

        h(c0 c0Var, h hVar) {
            super(c0Var, hVar);
            this.f470m = null;
            this.f470m = hVar.f470m;
        }

        @Override // androidx.core.view.c0.l
        c0 b() {
            return c0.n(this.f465c.consumeStableInsets());
        }

        @Override // androidx.core.view.c0.l
        c0 c() {
            return c0.n(this.f465c.consumeSystemWindowInsets());
        }

        @Override // androidx.core.view.c0.l
        final androidx.core.graphics.b i() {
            if (this.f470m == null) {
                this.f470m = androidx.core.graphics.b.b(this.f465c.getStableInsetLeft(), this.f465c.getStableInsetTop(), this.f465c.getStableInsetRight(), this.f465c.getStableInsetBottom());
            }
            return this.f470m;
        }

        @Override // androidx.core.view.c0.l
        boolean m() {
            return this.f465c.isConsumed();
        }

        @Override // androidx.core.view.c0.l
        public void r(androidx.core.graphics.b bVar) {
            this.f470m = bVar;
        }
    }

    /* loaded from: classes.dex */
    private static class i extends h {
        i(c0 c0Var, WindowInsets windowInsets) {
            super(c0Var, windowInsets);
        }

        i(c0 c0Var, i iVar) {
            super(c0Var, iVar);
        }

        @Override // androidx.core.view.c0.l
        c0 a() {
            WindowInsets consumeDisplayCutout;
            consumeDisplayCutout = this.f465c.consumeDisplayCutout();
            return c0.n(consumeDisplayCutout);
        }

        @Override // androidx.core.view.c0.g, androidx.core.view.c0.l
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof i) {
                i iVar = (i) obj;
                return Objects.equals(this.f465c, iVar.f465c) && Objects.equals(this.f469g, iVar.f469g);
            }
            return false;
        }

        @Override // androidx.core.view.c0.l
        androidx.core.view.a f() {
            DisplayCutout displayCutout;
            displayCutout = this.f465c.getDisplayCutout();
            return androidx.core.view.a.e(displayCutout);
        }

        @Override // androidx.core.view.c0.l
        public int hashCode() {
            return this.f465c.hashCode();
        }
    }

    /* loaded from: classes.dex */
    private static class j extends i {

        /* renamed from: n  reason: collision with root package name */
        private androidx.core.graphics.b f471n;

        /* renamed from: o  reason: collision with root package name */
        private androidx.core.graphics.b f472o;

        /* renamed from: p  reason: collision with root package name */
        private androidx.core.graphics.b f473p;

        j(c0 c0Var, WindowInsets windowInsets) {
            super(c0Var, windowInsets);
            this.f471n = null;
            this.f472o = null;
            this.f473p = null;
        }

        j(c0 c0Var, j jVar) {
            super(c0Var, jVar);
            this.f471n = null;
            this.f472o = null;
            this.f473p = null;
        }

        @Override // androidx.core.view.c0.l
        androidx.core.graphics.b h() {
            Insets mandatorySystemGestureInsets;
            if (this.f472o == null) {
                mandatorySystemGestureInsets = this.f465c.getMandatorySystemGestureInsets();
                this.f472o = androidx.core.graphics.b.d(mandatorySystemGestureInsets);
            }
            return this.f472o;
        }

        @Override // androidx.core.view.c0.l
        androidx.core.graphics.b j() {
            Insets systemGestureInsets;
            if (this.f471n == null) {
                systemGestureInsets = this.f465c.getSystemGestureInsets();
                this.f471n = androidx.core.graphics.b.d(systemGestureInsets);
            }
            return this.f471n;
        }

        @Override // androidx.core.view.c0.l
        androidx.core.graphics.b l() {
            Insets tappableElementInsets;
            if (this.f473p == null) {
                tappableElementInsets = this.f465c.getTappableElementInsets();
                this.f473p = androidx.core.graphics.b.d(tappableElementInsets);
            }
            return this.f473p;
        }

        @Override // androidx.core.view.c0.h, androidx.core.view.c0.l
        public void r(androidx.core.graphics.b bVar) {
        }
    }

    /* loaded from: classes.dex */
    private static class k extends j {

        /* renamed from: q  reason: collision with root package name */
        static final c0 f474q = c0.n(WindowInsets.CONSUMED);

        k(c0 c0Var, WindowInsets windowInsets) {
            super(c0Var, windowInsets);
        }

        k(c0 c0Var, k kVar) {
            super(c0Var, kVar);
        }

        @Override // androidx.core.view.c0.g, androidx.core.view.c0.l
        final void d(View view) {
        }

        @Override // androidx.core.view.c0.g, androidx.core.view.c0.l
        public androidx.core.graphics.b g(int i5) {
            Insets insets;
            insets = this.f465c.getInsets(n.a(i5));
            return androidx.core.graphics.b.d(insets);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class l {

        /* renamed from: b  reason: collision with root package name */
        static final c0 f475b = new b().a().a().b().c();

        /* renamed from: a  reason: collision with root package name */
        final c0 f476a;

        l(c0 c0Var) {
            this.f476a = c0Var;
        }

        c0 a() {
            return this.f476a;
        }

        c0 b() {
            return this.f476a;
        }

        c0 c() {
            return this.f476a;
        }

        void d(View view) {
        }

        void e(c0 c0Var) {
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof l) {
                l lVar = (l) obj;
                return n() == lVar.n() && m() == lVar.m() && k.c.a(k(), lVar.k()) && k.c.a(i(), lVar.i()) && k.c.a(f(), lVar.f());
            }
            return false;
        }

        androidx.core.view.a f() {
            return null;
        }

        androidx.core.graphics.b g(int i5) {
            return androidx.core.graphics.b.f405e;
        }

        androidx.core.graphics.b h() {
            return k();
        }

        public int hashCode() {
            return k.c.b(Boolean.valueOf(n()), Boolean.valueOf(m()), k(), i(), f());
        }

        androidx.core.graphics.b i() {
            return androidx.core.graphics.b.f405e;
        }

        androidx.core.graphics.b j() {
            return k();
        }

        androidx.core.graphics.b k() {
            return androidx.core.graphics.b.f405e;
        }

        androidx.core.graphics.b l() {
            return k();
        }

        boolean m() {
            return false;
        }

        boolean n() {
            return false;
        }

        public void o(androidx.core.graphics.b[] bVarArr) {
        }

        void p(androidx.core.graphics.b bVar) {
        }

        void q(c0 c0Var) {
        }

        public void r(androidx.core.graphics.b bVar) {
        }
    }

    /* loaded from: classes.dex */
    public static final class m {
        public static int a() {
            return 4;
        }

        public static int b() {
            return 128;
        }

        public static int c() {
            return 8;
        }

        static int d(int i5) {
            if (i5 != 1) {
                if (i5 != 2) {
                    if (i5 != 4) {
                        if (i5 != 8) {
                            if (i5 != 16) {
                                if (i5 != 32) {
                                    if (i5 != 64) {
                                        if (i5 != 128) {
                                            if (i5 == 256) {
                                                return 8;
                                            }
                                            throw new IllegalArgumentException("type needs to be >= FIRST and <= LAST, type=" + i5);
                                        }
                                        return 7;
                                    }
                                    return 6;
                                }
                                return 5;
                            }
                            return 4;
                        }
                        return 3;
                    }
                    return 2;
                }
                return 1;
            }
            return 0;
        }

        public static int e() {
            return 32;
        }

        public static int f() {
            return 2;
        }

        public static int g() {
            return 1;
        }

        public static int h() {
            return 16;
        }

        public static int i() {
            return 64;
        }
    }

    /* loaded from: classes.dex */
    private static final class n {
        static int a(int i5) {
            int statusBars;
            int i6 = 0;
            for (int i7 = 1; i7 <= 256; i7 <<= 1) {
                if ((i5 & i7) != 0) {
                    if (i7 == 1) {
                        statusBars = WindowInsets$Type.statusBars();
                    } else if (i7 == 2) {
                        statusBars = WindowInsets$Type.navigationBars();
                    } else if (i7 == 4) {
                        statusBars = WindowInsets$Type.captionBar();
                    } else if (i7 == 8) {
                        statusBars = WindowInsets$Type.ime();
                    } else if (i7 == 16) {
                        statusBars = WindowInsets$Type.systemGestures();
                    } else if (i7 == 32) {
                        statusBars = WindowInsets$Type.mandatorySystemGestures();
                    } else if (i7 == 64) {
                        statusBars = WindowInsets$Type.tappableElement();
                    } else if (i7 == 128) {
                        statusBars = WindowInsets$Type.displayCutout();
                    }
                    i6 |= statusBars;
                }
            }
            return i6;
        }
    }

    static {
        f444b = Build.VERSION.SDK_INT >= 30 ? k.f474q : l.f475b;
    }

    private c0(WindowInsets windowInsets) {
        int i5 = Build.VERSION.SDK_INT;
        this.f445a = i5 >= 30 ? new k(this, windowInsets) : i5 >= 29 ? new j(this, windowInsets) : i5 >= 28 ? new i(this, windowInsets) : new h(this, windowInsets);
    }

    public c0(c0 c0Var) {
        if (c0Var == null) {
            this.f445a = new l(this);
            return;
        }
        l lVar = c0Var.f445a;
        int i5 = Build.VERSION.SDK_INT;
        this.f445a = (i5 < 30 || !(lVar instanceof k)) ? (i5 < 29 || !(lVar instanceof j)) ? (i5 < 28 || !(lVar instanceof i)) ? lVar instanceof h ? new h(this, (h) lVar) : lVar instanceof g ? new g(this, (g) lVar) : new l(this) : new i(this, (i) lVar) : new j(this, (j) lVar) : new k(this, (k) lVar);
        lVar.e(this);
    }

    public static c0 n(WindowInsets windowInsets) {
        return o(windowInsets, null);
    }

    public static c0 o(WindowInsets windowInsets, View view) {
        c0 c0Var = new c0((WindowInsets) k.d.a(windowInsets));
        if (view != null && view.isAttachedToWindow()) {
            c0Var.k(androidx.core.view.l.e(view));
            c0Var.d(view.getRootView());
        }
        return c0Var;
    }

    @Deprecated
    public c0 a() {
        return this.f445a.a();
    }

    @Deprecated
    public c0 b() {
        return this.f445a.b();
    }

    @Deprecated
    public c0 c() {
        return this.f445a.c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(View view) {
        this.f445a.d(view);
    }

    public androidx.core.view.a e() {
        return this.f445a.f();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof c0) {
            return k.c.a(this.f445a, ((c0) obj).f445a);
        }
        return false;
    }

    public androidx.core.graphics.b f(int i5) {
        return this.f445a.g(i5);
    }

    @Deprecated
    public androidx.core.graphics.b g() {
        return this.f445a.i();
    }

    public boolean h() {
        return this.f445a.m();
    }

    public int hashCode() {
        l lVar = this.f445a;
        if (lVar == null) {
            return 0;
        }
        return lVar.hashCode();
    }

    void i(androidx.core.graphics.b[] bVarArr) {
        this.f445a.o(bVarArr);
    }

    void j(androidx.core.graphics.b bVar) {
        this.f445a.p(bVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k(c0 c0Var) {
        this.f445a.q(c0Var);
    }

    void l(androidx.core.graphics.b bVar) {
        this.f445a.r(bVar);
    }

    public WindowInsets m() {
        l lVar = this.f445a;
        if (lVar instanceof g) {
            return ((g) lVar).f465c;
        }
        return null;
    }
}
