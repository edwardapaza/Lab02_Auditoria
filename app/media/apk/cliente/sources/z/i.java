package z;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class i<T> extends h<T> {

    /* renamed from: b  reason: collision with root package name */
    private final T f8838b;

    /* renamed from: c  reason: collision with root package name */
    private final String f8839c;

    /* renamed from: d  reason: collision with root package name */
    private final j f8840d;

    /* renamed from: e  reason: collision with root package name */
    private final g f8841e;

    public i(T t5, String str, j jVar, g gVar) {
        e4.k.e(t5, "value");
        e4.k.e(str, "tag");
        e4.k.e(jVar, "verificationMode");
        e4.k.e(gVar, "logger");
        this.f8838b = t5;
        this.f8839c = str;
        this.f8840d = jVar;
        this.f8841e = gVar;
    }

    @Override // z.h
    public T a() {
        return this.f8838b;
    }

    @Override // z.h
    public h<T> c(String str, d4.l<? super T, Boolean> lVar) {
        e4.k.e(str, "message");
        e4.k.e(lVar, "condition");
        return lVar.invoke((T) this.f8838b).booleanValue() ? this : new f(this.f8838b, this.f8839c, str, this.f8841e, this.f8840d);
    }
}
