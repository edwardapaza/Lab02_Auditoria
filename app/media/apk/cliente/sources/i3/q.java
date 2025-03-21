package i3;
/* loaded from: classes.dex */
public final class q {

    /* renamed from: a  reason: collision with root package name */
    private final p f3532a;

    /* renamed from: b  reason: collision with root package name */
    private final j1 f3533b;

    private q(p pVar, j1 j1Var) {
        this.f3532a = (p) z0.k.o(pVar, "state is null");
        this.f3533b = (j1) z0.k.o(j1Var, "status is null");
    }

    public static q a(p pVar) {
        z0.k.e(pVar != p.TRANSIENT_FAILURE, "state is TRANSIENT_ERROR. Use forError() instead");
        return new q(pVar, j1.f3432f);
    }

    public static q b(j1 j1Var) {
        z0.k.e(!j1Var.o(), "The error status must not be OK");
        return new q(p.TRANSIENT_FAILURE, j1Var);
    }

    public p c() {
        return this.f3532a;
    }

    public j1 d() {
        return this.f3533b;
    }

    public boolean equals(Object obj) {
        if (obj instanceof q) {
            q qVar = (q) obj;
            return this.f3532a.equals(qVar.f3532a) && this.f3533b.equals(qVar.f3533b);
        }
        return false;
    }

    public int hashCode() {
        return this.f3532a.hashCode() ^ this.f3533b.hashCode();
    }

    public String toString() {
        if (this.f3533b.o()) {
            return this.f3532a.toString();
        }
        return this.f3532a + "(" + this.f3533b + ")";
    }
}
