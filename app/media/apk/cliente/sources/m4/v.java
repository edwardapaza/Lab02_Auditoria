package m4;
/* loaded from: classes.dex */
final class v<T> extends b2 implements u<T> {
    public v(u1 u1Var) {
        super(true);
        p0(u1Var);
    }

    @Override // m4.u
    public boolean D(T t5) {
        return v0(t5);
    }

    @Override // m4.q0
    public T i() {
        return (T) f0();
    }

    @Override // m4.b2
    public boolean j0() {
        return true;
    }

    @Override // m4.q0
    public Object n(v3.d<? super T> dVar) {
        Object F = F(dVar);
        w3.d.c();
        return F;
    }

    @Override // m4.u
    public boolean z(Throwable th) {
        return v0(new z(th, false, 2, null));
    }
}
