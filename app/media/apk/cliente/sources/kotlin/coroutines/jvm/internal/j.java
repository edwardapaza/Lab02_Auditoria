package kotlin.coroutines.jvm.internal;
/* loaded from: classes.dex */
public abstract class j extends a {
    public j(v3.d<Object> dVar) {
        super(dVar);
        if (dVar != null) {
            if (!(dVar.getContext() == v3.h.f8175a)) {
                throw new IllegalArgumentException("Coroutines with restricted suspension must have EmptyCoroutineContext".toString());
            }
        }
    }

    @Override // v3.d
    public v3.g getContext() {
        return v3.h.f8175a;
    }
}
