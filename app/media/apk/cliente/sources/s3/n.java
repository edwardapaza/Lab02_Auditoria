package s3;

import s3.m;
/* loaded from: classes.dex */
public final class n {
    public static final Object a(Throwable th) {
        e4.k.e(th, "exception");
        return new m.b(th);
    }

    public static final void b(Object obj) {
        if (obj instanceof m.b) {
            throw ((m.b) obj).f7567a;
        }
    }
}
