package n4;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import e4.k;
import s3.m;
import s3.n;
/* loaded from: classes.dex */
public final class f {

    /* renamed from: a  reason: collision with root package name */
    public static final e f6347a;
    private static volatile Choreographer choreographer;

    static {
        Object b5;
        try {
            m.a aVar = m.f7565b;
            b5 = m.b(new d(a(Looper.getMainLooper(), true), null, 2, null));
        } catch (Throwable th) {
            m.a aVar2 = m.f7565b;
            b5 = m.b(n.a(th));
        }
        f6347a = m.f(b5) ? null : b5;
    }

    public static final Handler a(Looper looper, boolean z4) {
        Object newInstance;
        if (z4) {
            if (Build.VERSION.SDK_INT >= 28) {
                newInstance = Handler.class.getDeclaredMethod("createAsync", Looper.class).invoke(null, looper);
                k.c(newInstance, "null cannot be cast to non-null type android.os.Handler");
            } else {
                try {
                    newInstance = Handler.class.getDeclaredConstructor(Looper.class, Handler.Callback.class, Boolean.TYPE).newInstance(looper, null, Boolean.TRUE);
                } catch (NoSuchMethodException unused) {
                    return new Handler(looper);
                }
            }
            return (Handler) newInstance;
        }
        return new Handler(looper);
    }
}
