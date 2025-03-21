package m4;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class d2<T> extends r0<T> {

    /* renamed from: d  reason: collision with root package name */
    private final v3.d<s3.t> f6211d;

    public d2(v3.g gVar, d4.p<? super j0, ? super v3.d<? super T>, ? extends Object> pVar) {
        super(gVar, false);
        v3.d<s3.t> a5;
        a5 = w3.c.a(pVar, this, this);
        this.f6211d = a5;
    }

    @Override // m4.b2
    protected void E0() {
        s4.a.c(this.f6211d, this);
    }
}
