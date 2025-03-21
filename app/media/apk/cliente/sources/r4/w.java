package r4;

import java.util.Iterator;
import java.util.List;
import java.util.ServiceLoader;
import m4.f2;
/* loaded from: classes.dex */
public final class w {

    /* renamed from: a  reason: collision with root package name */
    public static final w f7242a;

    /* renamed from: b  reason: collision with root package name */
    private static final boolean f7243b;

    /* renamed from: c  reason: collision with root package name */
    public static final f2 f7244c;

    static {
        w wVar = new w();
        f7242a = wVar;
        f7243b = i0.f("kotlinx.coroutines.fast.service.loader", true);
        f7244c = wVar.a();
    }

    private w() {
    }

    private final f2 a() {
        j4.b c5;
        List<v> h5;
        Object next;
        f2 e5;
        try {
            if (f7243b) {
                h5 = l.f7203a.c();
            } else {
                c5 = j4.h.c(ServiceLoader.load(v.class, v.class.getClassLoader()).iterator());
                h5 = j4.j.h(c5);
            }
            Iterator<T> it = h5.iterator();
            if (it.hasNext()) {
                next = it.next();
                if (it.hasNext()) {
                    int c6 = ((v) next).c();
                    do {
                        Object next2 = it.next();
                        int c7 = ((v) next2).c();
                        if (c6 < c7) {
                            next = next2;
                            c6 = c7;
                        }
                    } while (it.hasNext());
                }
            } else {
                next = null;
            }
            v vVar = (v) next;
            return (vVar == null || (e5 = x.e(vVar, h5)) == null) ? x.b(null, null, 3, null) : e5;
        } catch (Throwable th) {
            return x.b(th, null, 2, null);
        }
    }
}
