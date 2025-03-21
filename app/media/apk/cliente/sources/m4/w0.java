package m4;

import java.util.concurrent.CancellationException;
import s3.m;
/* loaded from: classes.dex */
public abstract class w0<T> extends t4.h {

    /* renamed from: c  reason: collision with root package name */
    public int f6287c;

    public w0(int i5) {
        this.f6287c = i5;
    }

    public void a(Object obj, Throwable th) {
    }

    public abstract v3.d<T> b();

    public Throwable c(Object obj) {
        z zVar = obj instanceof z ? (z) obj : null;
        if (zVar != null) {
            return zVar.f6298a;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> T d(Object obj) {
        return obj;
    }

    public final void g(Throwable th, Throwable th2) {
        if (th == null && th2 == null) {
            return;
        }
        if (th != null && th2 != null) {
            s3.b.a(th, th2);
        }
        if (th == null) {
            th = th2;
        }
        e4.k.b(th);
        i0.a(b().getContext(), new m0("Fatal exception in coroutines machinery for " + this + ". Please read KDoc to 'handleFatalException' method and report this incident to maintainers", th));
    }

    public abstract Object i();

    @Override // java.lang.Runnable
    public final void run() {
        Object b5;
        Object b6;
        Object b7;
        t4.i iVar = this.f7686b;
        try {
            v3.d<T> b8 = b();
            e4.k.c(b8, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<T of kotlinx.coroutines.DispatchedTask>");
            r4.j jVar = (r4.j) b8;
            v3.d<T> dVar = jVar.f7197e;
            Object obj = jVar.f7199k;
            v3.g context = dVar.getContext();
            Object c5 = r4.l0.c(context, obj);
            z2<?> g5 = c5 != r4.l0.f7204a ? f0.g(dVar, context, c5) : null;
            v3.g context2 = dVar.getContext();
            Object i5 = i();
            Throwable c6 = c(i5);
            u1 u1Var = (c6 == null && x0.b(this.f6287c)) ? (u1) context2.d(u1.f6282h) : null;
            if (u1Var != null && !u1Var.c()) {
                CancellationException P = u1Var.P();
                a(i5, P);
                m.a aVar = s3.m.f7565b;
                b6 = s3.m.b(s3.n.a(P));
            } else if (c6 != null) {
                m.a aVar2 = s3.m.f7565b;
                b6 = s3.m.b(s3.n.a(c6));
            } else {
                m.a aVar3 = s3.m.f7565b;
                b6 = s3.m.b(d(i5));
            }
            dVar.resumeWith(b6);
            s3.t tVar = s3.t.f7573a;
            if (g5 == null || g5.X0()) {
                r4.l0.a(context, c5);
            }
            try {
                iVar.a();
                b7 = s3.m.b(s3.t.f7573a);
            } catch (Throwable th) {
                m.a aVar4 = s3.m.f7565b;
                b7 = s3.m.b(s3.n.a(th));
            }
            g(null, s3.m.d(b7));
        } catch (Throwable th2) {
            try {
                m.a aVar5 = s3.m.f7565b;
                iVar.a();
                b5 = s3.m.b(s3.t.f7573a);
            } catch (Throwable th3) {
                m.a aVar6 = s3.m.f7565b;
                b5 = s3.m.b(s3.n.a(th3));
            }
            g(th2, s3.m.d(b5));
        }
    }
}
