package m4;
/* loaded from: classes.dex */
public abstract class f2 extends g0 {
    public abstract f2 i0();

    /* JADX INFO: Access modifiers changed from: protected */
    public final String j0() {
        f2 f2Var;
        f2 c5 = z0.c();
        if (this == c5) {
            return "Dispatchers.Main";
        }
        try {
            f2Var = c5.i0();
        } catch (UnsupportedOperationException unused) {
            f2Var = null;
        }
        if (this == f2Var) {
            return "Dispatchers.Main.immediate";
        }
        return null;
    }

    @Override // m4.g0
    public String toString() {
        String j02 = j0();
        if (j02 == null) {
            return n0.a(this) + '@' + n0.b(this);
        }
        return j02;
    }
}
