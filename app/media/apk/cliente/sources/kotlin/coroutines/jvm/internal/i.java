package kotlin.coroutines.jvm.internal;

import java.lang.reflect.Method;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class i {

    /* renamed from: a  reason: collision with root package name */
    public static final i f5857a = new i();

    /* renamed from: b  reason: collision with root package name */
    private static final a f5858b = new a(null, null, null);

    /* renamed from: c  reason: collision with root package name */
    private static a f5859c;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final Method f5860a;

        /* renamed from: b  reason: collision with root package name */
        public final Method f5861b;

        /* renamed from: c  reason: collision with root package name */
        public final Method f5862c;

        public a(Method method, Method method2, Method method3) {
            this.f5860a = method;
            this.f5861b = method2;
            this.f5862c = method3;
        }
    }

    private i() {
    }

    private final a a(kotlin.coroutines.jvm.internal.a aVar) {
        try {
            a aVar2 = new a(Class.class.getDeclaredMethod("getModule", new Class[0]), aVar.getClass().getClassLoader().loadClass("java.lang.Module").getDeclaredMethod("getDescriptor", new Class[0]), aVar.getClass().getClassLoader().loadClass("java.lang.module.ModuleDescriptor").getDeclaredMethod("name", new Class[0]));
            f5859c = aVar2;
            return aVar2;
        } catch (Exception unused) {
            a aVar3 = f5858b;
            f5859c = aVar3;
            return aVar3;
        }
    }

    public final String b(kotlin.coroutines.jvm.internal.a aVar) {
        e4.k.e(aVar, "continuation");
        a aVar2 = f5859c;
        if (aVar2 == null) {
            aVar2 = a(aVar);
        }
        if (aVar2 == f5858b) {
            return null;
        }
        Method method = aVar2.f5860a;
        Object invoke = method != null ? method.invoke(aVar.getClass(), new Object[0]) : null;
        if (invoke == null) {
            return null;
        }
        Method method2 = aVar2.f5861b;
        Object invoke2 = method2 != null ? method2.invoke(invoke, new Object[0]) : null;
        if (invoke2 == null) {
            return null;
        }
        Method method3 = aVar2.f5862c;
        Object invoke3 = method3 != null ? method3.invoke(invoke2, new Object[0]) : null;
        if (invoke3 instanceof String) {
            return (String) invoke3;
        }
        return null;
    }
}
