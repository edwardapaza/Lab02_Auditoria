package io.grpc.internal;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;
/* loaded from: classes.dex */
public final class z1 implements g1 {

    /* renamed from: b  reason: collision with root package name */
    private static final Logger f5329b = Logger.getLogger(z1.class.getName());

    /* renamed from: c  reason: collision with root package name */
    private static final Constructor<?> f5330c;

    /* renamed from: d  reason: collision with root package name */
    private static final Method f5331d;

    /* renamed from: e  reason: collision with root package name */
    private static final Method f5332e;

    /* renamed from: f  reason: collision with root package name */
    private static final RuntimeException f5333f;

    /* renamed from: g  reason: collision with root package name */
    private static final Object[] f5334g;

    /* renamed from: a  reason: collision with root package name */
    private final Object f5335a;

    static {
        Method method;
        Method method2;
        Constructor<?> constructor;
        RuntimeException runtimeException = null;
        try {
            Class<?> cls = Class.forName("java.util.concurrent.atomic.LongAdder");
            method = cls.getMethod("add", Long.TYPE);
            try {
                method2 = cls.getMethod("sum", new Class[0]);
                try {
                    Constructor<?>[] constructors = cls.getConstructors();
                    int length = constructors.length;
                    int i5 = 0;
                    while (true) {
                        if (i5 >= length) {
                            constructor = null;
                            break;
                        }
                        constructor = constructors[i5];
                        if (constructor.getParameterTypes().length == 0) {
                            break;
                        }
                        i5++;
                    }
                    th = null;
                } catch (Throwable th) {
                    th = th;
                    f5329b.log(Level.FINE, "LongAdder can not be found via reflection, this is normal for JDK7 and below", th);
                    constructor = null;
                    if (th == null) {
                    }
                    f5330c = null;
                    f5331d = null;
                    f5332e = null;
                    runtimeException = new RuntimeException(th);
                    f5333f = runtimeException;
                    f5334g = new Object[]{1L};
                }
            } catch (Throwable th2) {
                th = th2;
                method2 = null;
            }
        } catch (Throwable th3) {
            th = th3;
            method = null;
            method2 = null;
        }
        if (th == null || constructor == null) {
            f5330c = null;
            f5331d = null;
            f5332e = null;
            runtimeException = new RuntimeException(th);
        } else {
            f5330c = constructor;
            f5331d = method;
            f5332e = method2;
        }
        f5333f = runtimeException;
        f5334g = new Object[]{1L};
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public z1() {
        RuntimeException runtimeException = f5333f;
        if (runtimeException != null) {
            throw runtimeException;
        }
        try {
            this.f5335a = f5330c.newInstance(new Object[0]);
        } catch (IllegalAccessException e5) {
            throw new RuntimeException(e5);
        } catch (InstantiationException e6) {
            throw new RuntimeException(e6);
        } catch (InvocationTargetException e7) {
            throw new RuntimeException(e7);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a() {
        return f5333f == null;
    }

    @Override // io.grpc.internal.g1
    public void add(long j5) {
        try {
            f5331d.invoke(this.f5335a, j5 == 1 ? f5334g : new Object[]{Long.valueOf(j5)});
        } catch (IllegalAccessException e5) {
            throw new RuntimeException(e5);
        } catch (InvocationTargetException e6) {
            throw new RuntimeException(e6);
        }
    }
}
