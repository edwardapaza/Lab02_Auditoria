package p4;

import r4.h0;
/* loaded from: classes.dex */
public final class o {

    /* renamed from: a  reason: collision with root package name */
    private static final h0 f6914a = new h0("NONE");

    /* renamed from: b  reason: collision with root package name */
    private static final h0 f6915b = new h0("PENDING");

    public static final <T> j<T> a(T t5) {
        if (t5 == null) {
            t5 = (T) q4.k.f7105a;
        }
        return new n(t5);
    }

    public static final <T> c<T> d(m<? extends T> mVar, v3.g gVar, int i5, o4.a aVar) {
        boolean z4 = false;
        if (i5 >= 0 && i5 < 2) {
            z4 = true;
        }
        return ((z4 || i5 == -2) && aVar == o4.a.DROP_OLDEST) ? mVar : l.a(mVar, gVar, i5, aVar);
    }
}
