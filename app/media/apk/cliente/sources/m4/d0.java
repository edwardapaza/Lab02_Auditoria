package m4;

import s3.m;
/* loaded from: classes.dex */
public final class d0 {
    public static final <T> Object a(Object obj, v3.d<? super T> dVar) {
        if (obj instanceof z) {
            m.a aVar = s3.m.f7565b;
            obj = s3.n.a(((z) obj).f6298a);
        }
        return s3.m.b(obj);
    }

    public static final <T> Object b(Object obj, d4.l<? super Throwable, s3.t> lVar) {
        Throwable d5 = s3.m.d(obj);
        return d5 == null ? lVar != null ? new a0(obj, lVar) : obj : new z(d5, false, 2, null);
    }

    public static final <T> Object c(Object obj, l<?> lVar) {
        Throwable d5 = s3.m.d(obj);
        return d5 == null ? obj : new z(d5, false, 2, null);
    }

    public static /* synthetic */ Object d(Object obj, d4.l lVar, int i5, Object obj2) {
        if ((i5 & 1) != 0) {
            lVar = null;
        }
        return b(obj, lVar);
    }
}
