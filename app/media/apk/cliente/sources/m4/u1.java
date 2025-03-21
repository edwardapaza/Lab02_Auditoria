package m4;

import java.util.concurrent.CancellationException;
import v3.g;
/* loaded from: classes.dex */
public interface u1 extends g.b {

    /* renamed from: h  reason: collision with root package name */
    public static final b f6282h = b.f6283a;

    /* loaded from: classes.dex */
    public static final class a {
        public static /* synthetic */ void a(u1 u1Var, CancellationException cancellationException, int i5, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancel");
            }
            if ((i5 & 1) != 0) {
                cancellationException = null;
            }
            u1Var.g(cancellationException);
        }

        public static <R> R b(u1 u1Var, R r5, d4.p<? super R, ? super g.b, ? extends R> pVar) {
            return (R) g.b.a.a(u1Var, r5, pVar);
        }

        public static <E extends g.b> E c(u1 u1Var, g.c<E> cVar) {
            return (E) g.b.a.b(u1Var, cVar);
        }

        public static /* synthetic */ b1 d(u1 u1Var, boolean z4, boolean z5, d4.l lVar, int i5, Object obj) {
            if (obj == null) {
                if ((i5 & 1) != 0) {
                    z4 = false;
                }
                if ((i5 & 2) != 0) {
                    z5 = true;
                }
                return u1Var.v(z4, z5, lVar);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: invokeOnCompletion");
        }

        public static v3.g e(u1 u1Var, g.c<?> cVar) {
            return g.b.a.c(u1Var, cVar);
        }

        public static v3.g f(u1 u1Var, v3.g gVar) {
            return g.b.a.d(u1Var, gVar);
        }
    }

    /* loaded from: classes.dex */
    public static final class b implements g.c<u1> {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ b f6283a = new b();

        private b() {
        }
    }

    r I(t tVar);

    b1 O(d4.l<? super Throwable, s3.t> lVar);

    CancellationException P();

    boolean c();

    void g(CancellationException cancellationException);

    u1 getParent();

    Object p(v3.d<? super s3.t> dVar);

    boolean start();

    j4.b<u1> u();

    b1 v(boolean z4, boolean z5, d4.l<? super Throwable, s3.t> lVar);
}
