package s1;
/* loaded from: classes.dex */
public class m {

    /* renamed from: a  reason: collision with root package name */
    private final a f7387a;

    /* renamed from: b  reason: collision with root package name */
    private final v1.i f7388b;

    /* loaded from: classes.dex */
    public enum a {
        REMOVED,
        ADDED,
        MODIFIED,
        METADATA
    }

    private m(a aVar, v1.i iVar) {
        this.f7387a = aVar;
        this.f7388b = iVar;
    }

    public static m a(a aVar, v1.i iVar) {
        return new m(aVar, iVar);
    }

    public v1.i b() {
        return this.f7388b;
    }

    public a c() {
        return this.f7387a;
    }

    public boolean equals(Object obj) {
        if (obj instanceof m) {
            m mVar = (m) obj;
            return this.f7387a.equals(mVar.f7387a) && this.f7388b.equals(mVar.f7388b);
        }
        return false;
    }

    public int hashCode() {
        return ((((1891 + this.f7387a.hashCode()) * 31) + this.f7388b.getKey().hashCode()) * 31) + this.f7388b.k().hashCode();
    }

    public String toString() {
        return "DocumentViewChange(" + this.f7388b + "," + this.f7387a + ")";
    }
}
