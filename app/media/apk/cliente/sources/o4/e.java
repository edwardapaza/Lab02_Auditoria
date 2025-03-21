package o4;

import java.util.concurrent.CancellationException;
import m4.b2;
import m4.v1;
/* loaded from: classes.dex */
public class e<E> extends m4.a<s3.t> implements d<E> {

    /* renamed from: d  reason: collision with root package name */
    private final d<E> f6834d;

    public e(v3.g gVar, d<E> dVar, boolean z4, boolean z5) {
        super(gVar, z4, z5);
        this.f6834d = dVar;
    }

    @Override // m4.b2
    public void Q(Throwable th) {
        CancellationException M0 = b2.M0(this, th, null, 1, null);
        this.f6834d.g(M0);
        H(M0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final d<E> X0() {
        return this.f6834d;
    }

    @Override // o4.u
    public boolean a(Throwable th) {
        return this.f6834d.a(th);
    }

    @Override // o4.u
    public void f(d4.l<? super Throwable, s3.t> lVar) {
        this.f6834d.f(lVar);
    }

    @Override // m4.b2, m4.u1
    public final void g(CancellationException cancellationException) {
        if (q0()) {
            return;
        }
        if (cancellationException == null) {
            cancellationException = new v1(V(), null, this);
        }
        Q(cancellationException);
    }

    @Override // o4.t
    public f<E> iterator() {
        return this.f6834d.iterator();
    }

    @Override // o4.u
    public Object l(E e5) {
        return this.f6834d.l(e5);
    }

    @Override // o4.u
    public boolean m() {
        return this.f6834d.m();
    }

    @Override // o4.u
    public Object o(E e5, v3.d<? super s3.t> dVar) {
        return this.f6834d.o(e5, dVar);
    }
}
