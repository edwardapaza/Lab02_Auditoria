package i3;

import i3.r;
import java.util.logging.Level;
import java.util.logging.Logger;
/* loaded from: classes.dex */
final class o1 extends r.c {

    /* renamed from: a  reason: collision with root package name */
    private static final Logger f3520a = Logger.getLogger(o1.class.getName());

    /* renamed from: b  reason: collision with root package name */
    static final ThreadLocal<r> f3521b = new ThreadLocal<>();

    @Override // i3.r.c
    public r b() {
        r rVar = f3521b.get();
        return rVar == null ? r.f3535d : rVar;
    }

    @Override // i3.r.c
    public void c(r rVar, r rVar2) {
        ThreadLocal<r> threadLocal;
        if (b() != rVar) {
            f3520a.log(Level.SEVERE, "Context was not attached when detaching", new Throwable().fillInStackTrace());
        }
        if (rVar2 != r.f3535d) {
            threadLocal = f3521b;
        } else {
            threadLocal = f3521b;
            rVar2 = null;
        }
        threadLocal.set(rVar2);
    }

    @Override // i3.r.c
    public r d(r rVar) {
        r b5 = b();
        f3521b.set(rVar);
        return b5;
    }
}
