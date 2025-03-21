package e2;

import android.content.Context;
import k1.r;
/* loaded from: classes.dex */
public class h {

    /* loaded from: classes.dex */
    public interface a<T> {
        String a(T t5);
    }

    public static k1.c<?> b(String str, String str2) {
        return k1.c.l(f.a(str, str2), f.class);
    }

    public static k1.c<?> c(final String str, final a<Context> aVar) {
        return k1.c.m(f.class).b(r.j(Context.class)).d(new k1.h() { // from class: e2.g
            @Override // k1.h
            public final Object a(k1.e eVar) {
                f d5;
                d5 = h.d(str, aVar, eVar);
                return d5;
            }
        }).c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ f d(String str, a aVar, k1.e eVar) {
        return f.a(str, aVar.a((Context) eVar.a(Context.class)));
    }
}
