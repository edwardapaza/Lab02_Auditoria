package m4;

import s3.m;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class k2<T> extends a2 {

    /* renamed from: e  reason: collision with root package name */
    private final m<T> f6247e;

    /* JADX WARN: Multi-variable type inference failed */
    public k2(m<? super T> mVar) {
        this.f6247e = mVar;
    }

    @Override // d4.l
    public /* bridge */ /* synthetic */ s3.t invoke(Throwable th) {
        u(th);
        return s3.t.f7573a;
    }

    @Override // m4.b0
    public void u(Throwable th) {
        m<T> mVar;
        Object h5;
        Object m02 = v().m0();
        if (m02 instanceof z) {
            mVar = this.f6247e;
            m.a aVar = s3.m.f7565b;
            h5 = s3.n.a(((z) m02).f6298a);
        } else {
            mVar = this.f6247e;
            m.a aVar2 = s3.m.f7565b;
            h5 = c2.h(m02);
        }
        mVar.resumeWith(s3.m.b(h5));
    }
}
