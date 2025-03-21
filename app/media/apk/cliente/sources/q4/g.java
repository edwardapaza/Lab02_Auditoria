package q4;

import s3.t;
/* loaded from: classes.dex */
public final class g<T> extends f<T, T> {
    public g(p4.c<? extends T> cVar, v3.g gVar, int i5, o4.a aVar) {
        super(cVar, gVar, i5, aVar);
    }

    public /* synthetic */ g(p4.c cVar, v3.g gVar, int i5, o4.a aVar, int i6, e4.g gVar2) {
        this(cVar, (i6 & 2) != 0 ? v3.h.f8175a : gVar, (i6 & 4) != 0 ? -3 : i5, (i6 & 8) != 0 ? o4.a.SUSPEND : aVar);
    }

    @Override // q4.d
    protected d<T> f(v3.g gVar, int i5, o4.a aVar) {
        return new g(this.f7097d, gVar, i5, aVar);
    }

    @Override // q4.f
    protected Object m(p4.d<? super T> dVar, v3.d<? super t> dVar2) {
        Object c5;
        Object b5 = this.f7097d.b(dVar, dVar2);
        c5 = w3.d.c();
        return b5 == c5 ? b5 : t.f7573a;
    }
}
