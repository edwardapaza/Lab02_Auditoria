package q4;
/* loaded from: classes.dex */
final class p<T> implements v3.d<T>, kotlin.coroutines.jvm.internal.e {

    /* renamed from: a  reason: collision with root package name */
    private final v3.d<T> f7118a;

    /* renamed from: b  reason: collision with root package name */
    private final v3.g f7119b;

    /* JADX WARN: Multi-variable type inference failed */
    public p(v3.d<? super T> dVar, v3.g gVar) {
        this.f7118a = dVar;
        this.f7119b = gVar;
    }

    @Override // kotlin.coroutines.jvm.internal.e
    public kotlin.coroutines.jvm.internal.e getCallerFrame() {
        v3.d<T> dVar = this.f7118a;
        if (dVar instanceof kotlin.coroutines.jvm.internal.e) {
            return (kotlin.coroutines.jvm.internal.e) dVar;
        }
        return null;
    }

    @Override // v3.d
    public v3.g getContext() {
        return this.f7119b;
    }

    @Override // v3.d
    public void resumeWith(Object obj) {
        this.f7118a.resumeWith(obj);
    }
}
