package c0;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import androidx.window.extensions.WindowExtensionsProvider;
import androidx.window.extensions.core.util.function.Consumer;
import androidx.window.extensions.layout.WindowLayoutComponent;
import e4.s;
import java.lang.reflect.Method;
/* loaded from: classes.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    private final ClassLoader f801a;

    /* renamed from: b  reason: collision with root package name */
    private final z.d f802b;

    /* renamed from: c  reason: collision with root package name */
    private final y.a f803c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class a extends e4.l implements d4.a<Boolean> {
        a() {
            super(0);
        }

        @Override // d4.a
        /* renamed from: a */
        public final Boolean b() {
            Class f5 = e.this.f();
            boolean z4 = false;
            Method method = f5.getMethod("getBounds", new Class[0]);
            Method method2 = f5.getMethod("getType", new Class[0]);
            Method method3 = f5.getMethod("getState", new Class[0]);
            h0.a aVar = h0.a.f3107a;
            e4.k.d(method, "getBoundsMethod");
            if (aVar.b(method, s.b(Rect.class)) && aVar.d(method)) {
                e4.k.d(method2, "getTypeMethod");
                Class cls = Integer.TYPE;
                if (aVar.b(method2, s.b(cls)) && aVar.d(method2)) {
                    e4.k.d(method3, "getStateMethod");
                    if (aVar.b(method3, s.b(cls)) && aVar.d(method3)) {
                        z4 = true;
                    }
                }
            }
            return Boolean.valueOf(z4);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class b extends e4.l implements d4.a<Boolean> {
        b() {
            super(0);
        }

        @Override // d4.a
        /* renamed from: a */
        public final Boolean b() {
            Class<?> b5 = e.this.f802b.b();
            if (b5 == null) {
                return Boolean.FALSE;
            }
            Class h5 = e.this.h();
            boolean z4 = false;
            Method method = h5.getMethod("addWindowLayoutInfoListener", Activity.class, b5);
            Method method2 = h5.getMethod("removeWindowLayoutInfoListener", b5);
            h0.a aVar = h0.a.f3107a;
            e4.k.d(method, "addListenerMethod");
            if (aVar.d(method)) {
                e4.k.d(method2, "removeListenerMethod");
                if (aVar.d(method2)) {
                    z4 = true;
                }
            }
            return Boolean.valueOf(z4);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class c extends e4.l implements d4.a<Boolean> {
        c() {
            super(0);
        }

        @Override // d4.a
        /* renamed from: a */
        public final Boolean b() {
            Class h5 = e.this.h();
            boolean z4 = false;
            Method method = h5.getMethod("addWindowLayoutInfoListener", Context.class, Consumer.class);
            Method method2 = h5.getMethod("removeWindowLayoutInfoListener", Consumer.class);
            h0.a aVar = h0.a.f3107a;
            e4.k.d(method, "addListenerMethod");
            if (aVar.d(method)) {
                e4.k.d(method2, "removeListenerMethod");
                if (aVar.d(method2)) {
                    z4 = true;
                }
            }
            return Boolean.valueOf(z4);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class d extends e4.l implements d4.a<Boolean> {
        d() {
            super(0);
        }

        @Override // d4.a
        /* renamed from: a */
        public final Boolean b() {
            boolean z4 = false;
            Method method = e.this.f803c.c().getMethod("getWindowLayoutComponent", new Class[0]);
            Class<?> h5 = e.this.h();
            h0.a aVar = h0.a.f3107a;
            e4.k.d(method, "getWindowLayoutComponentMethod");
            if (aVar.d(method) && aVar.c(method, h5)) {
                z4 = true;
            }
            return Boolean.valueOf(z4);
        }
    }

    public e(ClassLoader classLoader, z.d dVar) {
        e4.k.e(classLoader, "loader");
        e4.k.e(dVar, "consumerAdapter");
        this.f801a = classLoader;
        this.f802b = dVar;
        this.f803c = new y.a(classLoader);
    }

    private final boolean e() {
        if (n()) {
            int a5 = z.e.f8828a.a();
            boolean z4 = true;
            if (a5 == 1) {
                return i();
            }
            if ((2 > a5 || a5 > Integer.MAX_VALUE) ? false : false) {
                return j();
            }
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Class<?> f() {
        Class<?> loadClass = this.f801a.loadClass("androidx.window.extensions.layout.FoldingFeature");
        e4.k.d(loadClass, "loader.loadClass(FOLDING_FEATURE_CLASS)");
        return loadClass;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Class<?> h() {
        Class<?> loadClass = this.f801a.loadClass("androidx.window.extensions.layout.WindowLayoutComponent");
        e4.k.d(loadClass, "loader.loadClass(WINDOW_LAYOUT_COMPONENT_CLASS)");
        return loadClass;
    }

    private final boolean k() {
        return h0.a.e("FoldingFeature class is not valid", new a());
    }

    private final boolean l() {
        return h0.a.e("WindowLayoutComponent#addWindowLayoutInfoListener(" + Activity.class.getName() + ", java.util.function.Consumer) is not valid", new b());
    }

    private final boolean m() {
        return h0.a.e("WindowLayoutComponent#addWindowLayoutInfoListener(" + Context.class.getName() + ", androidx.window.extensions.core.util.function.Consumer) is not valid", new c());
    }

    private final boolean o() {
        return h0.a.e("WindowExtensions#getWindowLayoutComponent is not valid", new d());
    }

    public final WindowLayoutComponent g() {
        if (e()) {
            try {
                return WindowExtensionsProvider.getWindowExtensions().getWindowLayoutComponent();
            } catch (UnsupportedOperationException unused) {
                return null;
            }
        }
        return null;
    }

    public final boolean i() {
        return l();
    }

    public final boolean j() {
        return i() && m();
    }

    public final boolean n() {
        return this.f803c.f() && o() && k();
    }
}
