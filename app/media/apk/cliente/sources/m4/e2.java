package m4;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class e2 extends m2 {

    /* renamed from: d  reason: collision with root package name */
    private final v3.d<s3.t> f6221d;

    public e2(v3.g gVar, d4.p<? super j0, ? super v3.d<? super s3.t>, ? extends Object> pVar) {
        super(gVar, false);
        v3.d<s3.t> a5;
        a5 = w3.c.a(pVar, this, this);
        this.f6221d = a5;
    }

    @Override // m4.b2
    protected void E0() {
        s4.a.c(this.f6221d, this);
    }
}
