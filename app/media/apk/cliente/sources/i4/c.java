package i4;

import e4.k;
/* loaded from: classes.dex */
public final class c {
    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> T a(b<T> bVar, Object obj) {
        k.e(bVar, "<this>");
        if (bVar.b(obj)) {
            k.c(obj, "null cannot be cast to non-null type T of kotlin.reflect.KClasses.cast");
            return obj;
        }
        throw new ClassCastException("Value cannot be cast to " + bVar.a());
    }
}
