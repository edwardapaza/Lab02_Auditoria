package p4;

import s3.t;
/* loaded from: classes.dex */
class b<T> extends q4.d<T> {

    /* renamed from: d  reason: collision with root package name */
    private final d4.p<o4.r<? super T>, v3.d<? super t>, Object> f6896d;

    /* JADX WARN: Multi-variable type inference failed */
    public b(d4.p<? super o4.r<? super T>, ? super v3.d<? super t>, ? extends Object> pVar, v3.g gVar, int i5, o4.a aVar) {
        super(gVar, i5, aVar);
        this.f6896d = pVar;
    }

    static /* synthetic */ <T> Object j(b<T> bVar, o4.r<? super T> rVar, v3.d<? super t> dVar) {
        Object c5;
        Object invoke = ((b) bVar).f6896d.invoke(rVar, dVar);
        c5 = w3.d.c();
        return invoke == c5 ? invoke : t.f7573a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // q4.d
    public Object e(o4.r<? super T> rVar, v3.d<? super t> dVar) {
        return j(this, rVar, dVar);
    }

    @Override // q4.d
    public String toString() {
        return "block[" + this.f6896d + "] -> " + super.toString();
    }
}
