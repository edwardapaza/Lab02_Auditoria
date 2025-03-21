package r4;
/* loaded from: classes.dex */
public class d0<T> extends m4.a<T> implements kotlin.coroutines.jvm.internal.e {

    /* renamed from: d  reason: collision with root package name */
    public final v3.d<T> f7183d;

    /* JADX WARN: Multi-variable type inference failed */
    public d0(v3.g gVar, v3.d<? super T> dVar) {
        super(gVar, true, true);
        this.f7183d = dVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // m4.b2
    public void E(Object obj) {
        v3.d b5;
        b5 = w3.c.b(this.f7183d);
        k.c(b5, m4.d0.a(obj, this.f7183d), null, 2, null);
    }

    @Override // m4.a
    protected void T0(Object obj) {
        v3.d<T> dVar = this.f7183d;
        dVar.resumeWith(m4.d0.a(obj, dVar));
    }

    @Override // kotlin.coroutines.jvm.internal.e
    public final kotlin.coroutines.jvm.internal.e getCallerFrame() {
        v3.d<T> dVar = this.f7183d;
        if (dVar instanceof kotlin.coroutines.jvm.internal.e) {
            return (kotlin.coroutines.jvm.internal.e) dVar;
        }
        return null;
    }

    @Override // m4.b2
    protected final boolean r0() {
        return true;
    }
}
