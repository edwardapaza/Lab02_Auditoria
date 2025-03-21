package z;

import android.app.Activity;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import s3.t;
/* loaded from: classes.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    private final ClassLoader f8822a;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class a<T> implements InvocationHandler {

        /* renamed from: a  reason: collision with root package name */
        private final i4.b<T> f8823a;

        /* renamed from: b  reason: collision with root package name */
        private final d4.l<T, t> f8824b;

        /* JADX WARN: Multi-variable type inference failed */
        public a(i4.b<T> bVar, d4.l<? super T, t> lVar) {
            e4.k.e(bVar, "clazz");
            e4.k.e(lVar, "consumer");
            this.f8823a = bVar;
            this.f8824b = lVar;
        }

        private final boolean b(Method method, Object[] objArr) {
            if (e4.k.a(method.getName(), "accept")) {
                if (objArr != null && objArr.length == 1) {
                    return true;
                }
            }
            return false;
        }

        private final boolean c(Method method, Object[] objArr) {
            if (e4.k.a(method.getName(), "equals") && method.getReturnType().equals(Boolean.TYPE)) {
                if (objArr != null && objArr.length == 1) {
                    return true;
                }
            }
            return false;
        }

        private final boolean d(Method method, Object[] objArr) {
            return e4.k.a(method.getName(), "hashCode") && method.getReturnType().equals(Integer.TYPE) && objArr == null;
        }

        private final boolean e(Method method, Object[] objArr) {
            return e4.k.a(method.getName(), "toString") && method.getReturnType().equals(String.class) && objArr == null;
        }

        public final void a(T t5) {
            e4.k.e(t5, "parameter");
            this.f8824b.invoke(t5);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) {
            e4.k.e(obj, "obj");
            e4.k.e(method, "method");
            if (b(method, objArr)) {
                a(i4.c.a(this.f8823a, objArr != null ? objArr[0] : null));
                return t.f7573a;
            } else if (c(method, objArr)) {
                return Boolean.valueOf(obj == (objArr != null ? objArr[0] : null));
            } else if (d(method, objArr)) {
                return Integer.valueOf(this.f8824b.hashCode());
            } else {
                if (e(method, objArr)) {
                    return this.f8824b.toString();
                }
                throw new UnsupportedOperationException("Unexpected method call object:" + obj + ", method: " + method + ", args: " + objArr);
            }
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        void a();
    }

    /* loaded from: classes.dex */
    public static final class c implements b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Method f8825a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Object f8826b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Object f8827c;

        c(Method method, Object obj, Object obj2) {
            this.f8825a = method;
            this.f8826b = obj;
            this.f8827c = obj2;
        }

        @Override // z.d.b
        public void a() {
            this.f8825a.invoke(this.f8826b, this.f8827c);
        }
    }

    public d(ClassLoader classLoader) {
        e4.k.e(classLoader, "loader");
        this.f8822a = classLoader;
    }

    private final <T> Object a(i4.b<T> bVar, d4.l<? super T, t> lVar) {
        Object newProxyInstance = Proxy.newProxyInstance(this.f8822a, new Class[]{d()}, new a(bVar, lVar));
        e4.k.d(newProxyInstance, "newProxyInstance(loader,…onsumerClass()), handler)");
        return newProxyInstance;
    }

    private final Class<?> d() {
        Class<?> loadClass = this.f8822a.loadClass("java.util.function.Consumer");
        e4.k.d(loadClass, "loader.loadClass(\"java.util.function.Consumer\")");
        return loadClass;
    }

    public final Class<?> b() {
        try {
            return d();
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    public final <T> b c(Object obj, i4.b<T> bVar, String str, String str2, Activity activity, d4.l<? super T, t> lVar) {
        e4.k.e(obj, "obj");
        e4.k.e(bVar, "clazz");
        e4.k.e(str, "addMethodName");
        e4.k.e(str2, "removeMethodName");
        e4.k.e(activity, "activity");
        e4.k.e(lVar, "consumer");
        Object a5 = a(bVar, lVar);
        obj.getClass().getMethod(str, Activity.class, d()).invoke(obj, activity, a5);
        return new c(obj.getClass().getMethod(str2, d()), obj, a5);
    }
}
