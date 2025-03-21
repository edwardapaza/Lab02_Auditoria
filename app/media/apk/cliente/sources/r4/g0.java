package r4;

import s3.m;
/* loaded from: classes.dex */
public final class g0 {

    /* renamed from: a  reason: collision with root package name */
    private static final StackTraceElement f7190a = new a.a().a();

    /* renamed from: b  reason: collision with root package name */
    private static final String f7191b;

    /* renamed from: c  reason: collision with root package name */
    private static final String f7192c;

    static {
        Object b5;
        Object b6;
        try {
            m.a aVar = s3.m.f7565b;
            b5 = s3.m.b(Class.forName("kotlin.coroutines.jvm.internal.a").getCanonicalName());
        } catch (Throwable th) {
            m.a aVar2 = s3.m.f7565b;
            b5 = s3.m.b(s3.n.a(th));
        }
        if (s3.m.d(b5) != null) {
            b5 = "kotlin.coroutines.jvm.internal.BaseContinuationImpl";
        }
        f7191b = (String) b5;
        try {
            b6 = s3.m.b(g0.class.getCanonicalName());
        } catch (Throwable th2) {
            m.a aVar3 = s3.m.f7565b;
            b6 = s3.m.b(s3.n.a(th2));
        }
        if (s3.m.d(b6) != null) {
            b6 = "kotlinx.coroutines.internal.StackTraceRecoveryKt";
        }
        f7192c = (String) b6;
    }

    public static final <E extends Throwable> E a(E e5) {
        return e5;
    }
}
