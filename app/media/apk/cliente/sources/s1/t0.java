package s1;
/* loaded from: classes.dex */
public class t0 {

    /* renamed from: a  reason: collision with root package name */
    private final a f7482a;

    /* renamed from: b  reason: collision with root package name */
    private final v1.l f7483b;

    /* loaded from: classes.dex */
    public enum a {
        ADDED,
        REMOVED
    }

    public t0(a aVar, v1.l lVar) {
        this.f7482a = aVar;
        this.f7483b = lVar;
    }

    public v1.l a() {
        return this.f7483b;
    }

    public a b() {
        return this.f7482a;
    }

    public boolean equals(Object obj) {
        if (obj instanceof t0) {
            t0 t0Var = (t0) obj;
            return this.f7482a.equals(t0Var.b()) && this.f7483b.equals(t0Var.a());
        }
        return false;
    }

    public int hashCode() {
        return ((2077 + this.f7482a.hashCode()) * 31) + this.f7483b.hashCode();
    }
}
