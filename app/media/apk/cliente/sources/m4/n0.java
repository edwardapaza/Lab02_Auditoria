package m4;

import s3.m;
/* loaded from: classes.dex */
public final class n0 {
    public static final String a(Object obj) {
        return obj.getClass().getSimpleName();
    }

    public static final String b(Object obj) {
        return Integer.toHexString(System.identityHashCode(obj));
    }

    public static final String c(v3.d<?> dVar) {
        String b5;
        if (dVar instanceof r4.j) {
            return dVar.toString();
        }
        try {
            m.a aVar = s3.m.f7565b;
            b5 = s3.m.b(dVar + '@' + b(dVar));
        } catch (Throwable th) {
            m.a aVar2 = s3.m.f7565b;
            b5 = s3.m.b(s3.n.a(th));
        }
        if (s3.m.d(b5) != null) {
            b5 = dVar.getClass().getName() + '@' + b(dVar);
        }
        return (String) b5;
    }
}
