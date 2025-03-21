package s1;
/* loaded from: classes.dex */
public class z0 {

    /* renamed from: a  reason: collision with root package name */
    private final a f7543a;

    /* renamed from: b  reason: collision with root package name */
    final v1.r f7544b;

    /* loaded from: classes.dex */
    public enum a {
        ASCENDING(1),
        DESCENDING(-1);
        

        /* renamed from: a  reason: collision with root package name */
        private final int f7548a;

        a(int i5) {
            this.f7548a = i5;
        }

        int a() {
            return this.f7548a;
        }
    }

    private z0(a aVar, v1.r rVar) {
        this.f7543a = aVar;
        this.f7544b = rVar;
    }

    public static z0 d(a aVar, v1.r rVar) {
        return new z0(aVar, rVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a(v1.i iVar, v1.i iVar2) {
        int a5;
        int i5;
        if (this.f7544b.equals(v1.r.f8134b)) {
            a5 = this.f7543a.a();
            i5 = iVar.getKey().compareTo(iVar2.getKey());
        } else {
            i2.d0 e5 = iVar.e(this.f7544b);
            i2.d0 e6 = iVar2.e(this.f7544b);
            z1.b.d((e5 == null || e6 == null) ? false : true, "Trying to compare documents on fields that don't exist.", new Object[0]);
            a5 = this.f7543a.a();
            i5 = v1.z.i(e5, e6);
        }
        return a5 * i5;
    }

    public a b() {
        return this.f7543a;
    }

    public v1.r c() {
        return this.f7544b;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof z0)) {
            return false;
        }
        z0 z0Var = (z0) obj;
        return this.f7543a == z0Var.f7543a && this.f7544b.equals(z0Var.f7544b);
    }

    public int hashCode() {
        return ((899 + this.f7543a.hashCode()) * 31) + this.f7544b.hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f7543a == a.ASCENDING ? "" : "-");
        sb.append(this.f7544b.d());
        return sb.toString();
    }
}
