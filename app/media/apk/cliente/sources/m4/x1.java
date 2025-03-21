package m4;
/* loaded from: classes.dex */
public class x1 extends b2 implements x {

    /* renamed from: c  reason: collision with root package name */
    private final boolean f6289c;

    public x1(u1 u1Var) {
        super(true);
        p0(u1Var);
        this.f6289c = T0();
    }

    private final boolean T0() {
        b2 v5;
        r l02 = l0();
        s sVar = l02 instanceof s ? (s) l02 : null;
        if (sVar != null && (v5 = sVar.v()) != null) {
            while (!v5.i0()) {
                r l03 = v5.l0();
                s sVar2 = l03 instanceof s ? (s) l03 : null;
                if (sVar2 != null) {
                    v5 = sVar2.v();
                    if (v5 == null) {
                    }
                }
            }
            return true;
        }
        return false;
    }

    @Override // m4.b2
    public boolean i0() {
        return this.f6289c;
    }

    @Override // m4.b2
    public boolean j0() {
        return true;
    }
}
