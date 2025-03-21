package r4;

import s3.m;
/* loaded from: classes.dex */
public final class m {

    /* renamed from: a  reason: collision with root package name */
    private static final boolean f7211a;

    static {
        Object b5;
        try {
            m.a aVar = s3.m.f7565b;
            b5 = s3.m.b(Class.forName("android.os.Build"));
        } catch (Throwable th) {
            m.a aVar2 = s3.m.f7565b;
            b5 = s3.m.b(s3.n.a(th));
        }
        f7211a = s3.m.g(b5);
    }

    public static final boolean a() {
        return f7211a;
    }
}
