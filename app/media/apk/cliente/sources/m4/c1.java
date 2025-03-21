package m4;
/* loaded from: classes.dex */
final class c1 extends j {

    /* renamed from: a  reason: collision with root package name */
    private final b1 f6199a;

    public c1(b1 b1Var) {
        this.f6199a = b1Var;
    }

    @Override // m4.k
    public void e(Throwable th) {
        this.f6199a.a();
    }

    @Override // d4.l
    public /* bridge */ /* synthetic */ s3.t invoke(Throwable th) {
        e(th);
        return s3.t.f7573a;
    }

    public String toString() {
        return "DisposeOnCancel[" + this.f6199a + ']';
    }
}
