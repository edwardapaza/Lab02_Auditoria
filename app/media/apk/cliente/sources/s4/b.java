package s4;

import d4.p;
import e4.u;
import kotlin.coroutines.jvm.internal.h;
import m4.c2;
import m4.v2;
import m4.z;
import r4.d0;
import r4.l0;
import s3.m;
import s3.n;
import v3.d;
import v3.g;
/* loaded from: classes.dex */
public final class b {
    public static final <R, T> void a(p<? super R, ? super d<? super T>, ? extends Object> pVar, R r5, d<? super T> dVar) {
        Object a5;
        Object c5;
        d a6 = h.a(dVar);
        try {
            g context = dVar.getContext();
            Object c6 = l0.c(context, null);
            a5 = ((p) u.a(pVar, 2)).invoke(r5, a6);
            l0.a(context, c6);
            c5 = w3.d.c();
            if (a5 == c5) {
                return;
            }
        } catch (Throwable th) {
            m.a aVar = m.f7565b;
            a5 = n.a(th);
        }
        a6.resumeWith(m.b(a5));
    }

    public static final <T, R> Object b(d0<? super T> d0Var, R r5, p<? super R, ? super d<? super T>, ? extends Object> pVar) {
        Object zVar;
        Object c5;
        Object w02;
        Object c6;
        try {
            zVar = ((p) u.a(pVar, 2)).invoke(r5, d0Var);
        } catch (Throwable th) {
            zVar = new z(th, false, 2, null);
        }
        c5 = w3.d.c();
        if (zVar == c5 || (w02 = d0Var.w0(zVar)) == c2.f6201b) {
            c6 = w3.d.c();
            return c6;
        } else if (w02 instanceof z) {
            throw ((z) w02).f6298a;
        } else {
            return c2.h(w02);
        }
    }

    public static final <T, R> Object c(d0<? super T> d0Var, R r5, p<? super R, ? super d<? super T>, ? extends Object> pVar) {
        Object zVar;
        Object c5;
        Object w02;
        Object c6;
        boolean z4 = false;
        try {
            zVar = ((p) u.a(pVar, 2)).invoke(r5, d0Var);
        } catch (Throwable th) {
            zVar = new z(th, false, 2, null);
        }
        c5 = w3.d.c();
        if (zVar == c5 || (w02 = d0Var.w0(zVar)) == c2.f6201b) {
            c6 = w3.d.c();
            return c6;
        }
        if (w02 instanceof z) {
            Throwable th2 = ((z) w02).f6298a;
            if (((th2 instanceof v2) && ((v2) th2).f6286a == d0Var) ? true : true) {
                throw th2;
            }
            if (zVar instanceof z) {
                throw ((z) zVar).f6298a;
            }
        } else {
            zVar = c2.h(w02);
        }
        return zVar;
    }
}
