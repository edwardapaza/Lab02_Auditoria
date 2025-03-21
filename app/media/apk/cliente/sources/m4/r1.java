package m4;
/* loaded from: classes.dex */
final class r1 extends j {

    /* renamed from: a  reason: collision with root package name */
    private final d4.l<Throwable, s3.t> f6274a;

    /* JADX WARN: Multi-variable type inference failed */
    public r1(d4.l<? super Throwable, s3.t> lVar) {
        this.f6274a = lVar;
    }

    @Override // m4.k
    public void e(Throwable th) {
        this.f6274a.invoke(th);
    }

    @Override // d4.l
    public /* bridge */ /* synthetic */ s3.t invoke(Throwable th) {
        e(th);
        return s3.t.f7573a;
    }

    public String toString() {
        return "InvokeOnCancel[" + n0.a(this.f6274a) + '@' + n0.b(this) + ']';
    }
}
