package q4;

import o4.u;
import s3.t;
/* loaded from: classes.dex */
public final class o<T> implements p4.d<T> {

    /* renamed from: a  reason: collision with root package name */
    private final u<T> f7117a;

    /* JADX WARN: Multi-variable type inference failed */
    public o(u<? super T> uVar) {
        this.f7117a = uVar;
    }

    @Override // p4.d
    public Object c(T t5, v3.d<? super t> dVar) {
        Object c5;
        Object o5 = this.f7117a.o(t5, dVar);
        c5 = w3.d.c();
        return o5 == c5 ? o5 : t.f7573a;
    }
}
