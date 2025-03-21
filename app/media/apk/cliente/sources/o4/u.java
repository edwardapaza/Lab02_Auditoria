package o4;
/* loaded from: classes.dex */
public interface u<E> {

    /* loaded from: classes.dex */
    public static final class a {
        public static /* synthetic */ boolean a(u uVar, Throwable th, int i5, Object obj) {
            if (obj == null) {
                if ((i5 & 1) != 0) {
                    th = null;
                }
                return uVar.a(th);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: close");
        }
    }

    boolean a(Throwable th);

    void f(d4.l<? super Throwable, s3.t> lVar);

    Object l(E e5);

    boolean m();

    Object o(E e5, v3.d<? super s3.t> dVar);
}
