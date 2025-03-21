package s4;

import d4.l;
import d4.p;
import r4.k;
import s3.m;
import s3.n;
import s3.t;
import v3.d;
import w3.c;
/* loaded from: classes.dex */
public final class a {
    private static final void a(d<?> dVar, Throwable th) {
        m.a aVar = m.f7565b;
        dVar.resumeWith(m.b(n.a(th)));
        throw th;
    }

    public static final <R, T> void b(p<? super R, ? super d<? super T>, ? extends Object> pVar, R r5, d<? super T> dVar, l<? super Throwable, t> lVar) {
        d a5;
        d b5;
        try {
            a5 = c.a(pVar, r5, dVar);
            b5 = c.b(a5);
            m.a aVar = m.f7565b;
            k.b(b5, m.b(t.f7573a), lVar);
        } catch (Throwable th) {
            a(dVar, th);
        }
    }

    public static final void c(d<? super t> dVar, d<?> dVar2) {
        d b5;
        try {
            b5 = c.b(dVar);
            m.a aVar = m.f7565b;
            k.c(b5, m.b(t.f7573a), null, 2, null);
        } catch (Throwable th) {
            a(dVar2, th);
        }
    }

    public static /* synthetic */ void d(p pVar, Object obj, d dVar, l lVar, int i5, Object obj2) {
        if ((i5 & 4) != 0) {
            lVar = null;
        }
        b(pVar, obj, dVar, lVar);
    }
}
