package y;

import e4.k;
import e4.l;
import java.lang.reflect.Method;
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private final ClassLoader f8351a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: y.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0129a extends l implements d4.a<Class<?>> {
        C0129a() {
            super(0);
        }

        @Override // d4.a
        /* renamed from: a */
        public final Class<?> b() {
            Class<?> loadClass = a.this.f8351a.loadClass("androidx.window.extensions.WindowExtensionsProvider");
            k.d(loadClass, "loader.loadClass(WindowE…XTENSIONS_PROVIDER_CLASS)");
            return loadClass;
        }
    }

    /* loaded from: classes.dex */
    static final class b extends l implements d4.a<Boolean> {
        b() {
            super(0);
        }

        @Override // d4.a
        /* renamed from: a */
        public final Boolean b() {
            boolean z4 = false;
            Method declaredMethod = a.this.d().getDeclaredMethod("getWindowExtensions", new Class[0]);
            Class<?> c5 = a.this.c();
            h0.a aVar = h0.a.f3107a;
            k.d(declaredMethod, "getWindowExtensionsMethod");
            if (aVar.c(declaredMethod, c5) && aVar.d(declaredMethod)) {
                z4 = true;
            }
            return Boolean.valueOf(z4);
        }
    }

    public a(ClassLoader classLoader) {
        k.e(classLoader, "loader");
        this.f8351a = classLoader;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Class<?> d() {
        Class<?> loadClass = this.f8351a.loadClass("androidx.window.extensions.WindowExtensionsProvider");
        k.d(loadClass, "loader.loadClass(WindowE…XTENSIONS_PROVIDER_CLASS)");
        return loadClass;
    }

    private final boolean e() {
        return h0.a.f3107a.a(new C0129a());
    }

    public final Class<?> c() {
        Class<?> loadClass = this.f8351a.loadClass("androidx.window.extensions.WindowExtensions");
        k.d(loadClass, "loader.loadClass(WindowE….WINDOW_EXTENSIONS_CLASS)");
        return loadClass;
    }

    public final boolean f() {
        return e() && h0.a.e("WindowExtensionsProvider#getWindowExtensions is not valid", new b());
    }
}
