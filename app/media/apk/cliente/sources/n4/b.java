package n4;

import android.os.Build;
import java.lang.Thread;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import m4.h0;
import v3.g;
/* loaded from: classes.dex */
public final class b extends v3.a implements h0 {
    private volatile Object _preHandler;

    public b() {
        super(h0.f6242g);
        this._preHandler = this;
    }

    private final Method f0() {
        Object obj = this._preHandler;
        if (obj != this) {
            return (Method) obj;
        }
        Method method = null;
        try {
            boolean z4 = false;
            Method declaredMethod = Thread.class.getDeclaredMethod("getUncaughtExceptionPreHandler", new Class[0]);
            if (Modifier.isPublic(declaredMethod.getModifiers())) {
                if (Modifier.isStatic(declaredMethod.getModifiers())) {
                    z4 = true;
                }
            }
            if (z4) {
                method = declaredMethod;
            }
        } catch (Throwable unused) {
        }
        this._preHandler = method;
        return method;
    }

    @Override // m4.h0
    public void U(g gVar, Throwable th) {
        int i5 = Build.VERSION.SDK_INT;
        if (26 <= i5 && i5 < 28) {
            Method f02 = f0();
            Object invoke = f02 != null ? f02.invoke(null, new Object[0]) : null;
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler = invoke instanceof Thread.UncaughtExceptionHandler ? (Thread.UncaughtExceptionHandler) invoke : null;
            if (uncaughtExceptionHandler != null) {
                uncaughtExceptionHandler.uncaughtException(Thread.currentThread(), th);
            }
        }
    }
}
