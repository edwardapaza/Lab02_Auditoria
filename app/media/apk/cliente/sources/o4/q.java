package o4;

import m4.i0;
import o4.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class q<E> extends e<E> implements r<E> {
    public q(v3.g gVar, d<E> dVar) {
        super(gVar, dVar, true, true);
    }

    @Override // m4.a
    protected void U0(Throwable th, boolean z4) {
        if (X0().a(th) || z4) {
            return;
        }
        i0.a(getContext(), th);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // m4.a
    /* renamed from: Y0 */
    public void V0(s3.t tVar) {
        u.a.a(X0(), null, 1, null);
    }

    @Override // m4.a, m4.b2, m4.u1
    public boolean c() {
        return super.c();
    }
}
