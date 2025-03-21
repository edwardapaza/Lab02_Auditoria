package m4;
/* loaded from: classes.dex */
public final class s extends w1 implements r {

    /* renamed from: e  reason: collision with root package name */
    public final t f6275e;

    public s(t tVar) {
        this.f6275e = tVar;
    }

    @Override // m4.r
    public boolean e(Throwable th) {
        return v().W(th);
    }

    @Override // m4.r
    public u1 getParent() {
        return v();
    }

    @Override // d4.l
    public /* bridge */ /* synthetic */ s3.t invoke(Throwable th) {
        u(th);
        return s3.t.f7573a;
    }

    @Override // m4.b0
    public void u(Throwable th) {
        this.f6275e.j(v());
    }
}
