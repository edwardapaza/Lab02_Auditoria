package m4;
/* loaded from: classes.dex */
public abstract class a<T> extends b2 implements v3.d<T>, j0 {

    /* renamed from: c  reason: collision with root package name */
    private final v3.g f6175c;

    public a(v3.g gVar, boolean z4, boolean z5) {
        super(z5);
        if (z4) {
            p0((u1) gVar.d(u1.f6282h));
        }
        this.f6175c = gVar.J(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // m4.b2
    protected final void D0(Object obj) {
        if (!(obj instanceof z)) {
            V0(obj);
            return;
        }
        z zVar = (z) obj;
        U0(zVar.f6298a, zVar.a());
    }

    protected void T0(Object obj) {
        E(obj);
    }

    protected void U0(Throwable th, boolean z4) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // m4.b2
    public String V() {
        return n0.a(this) + " was cancelled";
    }

    protected void V0(T t5) {
    }

    public final <R> void W0(l0 l0Var, R r5, d4.p<? super R, ? super v3.d<? super T>, ? extends Object> pVar) {
        l0Var.c(pVar, r5, this);
    }

    @Override // m4.j0
    public v3.g b() {
        return this.f6175c;
    }

    @Override // m4.b2, m4.u1
    public boolean c() {
        return super.c();
    }

    @Override // v3.d
    public final v3.g getContext() {
        return this.f6175c;
    }

    @Override // m4.b2
    public final void o0(Throwable th) {
        i0.a(this.f6175c, th);
    }

    @Override // v3.d
    public final void resumeWith(Object obj) {
        Object w02 = w0(d0.d(obj, null, 1, null));
        if (w02 == c2.f6201b) {
            return;
        }
        T0(w02);
    }

    @Override // m4.b2
    public String y0() {
        String b5 = f0.b(this.f6175c);
        if (b5 == null) {
            return super.y0();
        }
        return '\"' + b5 + "\":" + super.y0();
    }
}
