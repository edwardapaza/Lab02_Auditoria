package j1;
/* loaded from: classes.dex */
final class r1 extends n1 {

    /* renamed from: a  reason: collision with root package name */
    private String f5464a;

    /* renamed from: b  reason: collision with root package name */
    private String f5465b;

    /* renamed from: c  reason: collision with root package name */
    private String f5466c;

    @Override // j1.n1
    public final n1 a(String str) {
        this.f5465b = str;
        return this;
    }

    @Override // j1.n1
    public final o1 b() {
        return new s1(this.f5464a, this.f5465b, this.f5466c);
    }

    @Override // j1.n1
    public final n1 c(String str) {
        this.f5466c = str;
        return this;
    }

    @Override // j1.n1
    public final n1 d(String str) {
        this.f5464a = str;
        return this;
    }
}
