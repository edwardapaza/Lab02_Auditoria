package m4;

import s3.m;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class l2 extends a2 {

    /* renamed from: e  reason: collision with root package name */
    private final v3.d<s3.t> f6256e;

    /* JADX WARN: Multi-variable type inference failed */
    public l2(v3.d<? super s3.t> dVar) {
        this.f6256e = dVar;
    }

    @Override // d4.l
    public /* bridge */ /* synthetic */ s3.t invoke(Throwable th) {
        u(th);
        return s3.t.f7573a;
    }

    @Override // m4.b0
    public void u(Throwable th) {
        v3.d<s3.t> dVar = this.f6256e;
        m.a aVar = s3.m.f7565b;
        dVar.resumeWith(s3.m.b(s3.t.f7573a));
    }
}
