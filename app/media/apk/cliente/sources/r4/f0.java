package r4;

import r4.e0;
/* loaded from: classes.dex */
public final class f0<S extends e0<S>> {
    public static <S extends e0<S>> Object a(Object obj) {
        return obj;
    }

    public static final S b(Object obj) {
        if (obj != d.f7182a) {
            e4.k.c(obj, "null cannot be cast to non-null type S of kotlinx.coroutines.internal.SegmentOrClosed");
            return (S) obj;
        }
        throw new IllegalStateException("Does not contain segment".toString());
    }

    public static final boolean c(Object obj) {
        return obj == d.f7182a;
    }
}
