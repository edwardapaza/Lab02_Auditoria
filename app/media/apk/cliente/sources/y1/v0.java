package y1;
/* loaded from: classes.dex */
public final class v0 {

    /* renamed from: a  reason: collision with root package name */
    private final com.google.protobuf.i f8525a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f8526b;

    /* renamed from: c  reason: collision with root package name */
    private final m1.e<v1.l> f8527c;

    /* renamed from: d  reason: collision with root package name */
    private final m1.e<v1.l> f8528d;

    /* renamed from: e  reason: collision with root package name */
    private final m1.e<v1.l> f8529e;

    public v0(com.google.protobuf.i iVar, boolean z4, m1.e<v1.l> eVar, m1.e<v1.l> eVar2, m1.e<v1.l> eVar3) {
        this.f8525a = iVar;
        this.f8526b = z4;
        this.f8527c = eVar;
        this.f8528d = eVar2;
        this.f8529e = eVar3;
    }

    public static v0 a(boolean z4, com.google.protobuf.i iVar) {
        return new v0(iVar, z4, v1.l.e(), v1.l.e(), v1.l.e());
    }

    public m1.e<v1.l> b() {
        return this.f8527c;
    }

    public m1.e<v1.l> c() {
        return this.f8528d;
    }

    public m1.e<v1.l> d() {
        return this.f8529e;
    }

    public com.google.protobuf.i e() {
        return this.f8525a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || v0.class != obj.getClass()) {
            return false;
        }
        v0 v0Var = (v0) obj;
        if (this.f8526b == v0Var.f8526b && this.f8525a.equals(v0Var.f8525a) && this.f8527c.equals(v0Var.f8527c) && this.f8528d.equals(v0Var.f8528d)) {
            return this.f8529e.equals(v0Var.f8529e);
        }
        return false;
    }

    public boolean f() {
        return this.f8526b;
    }

    public int hashCode() {
        return (((((((this.f8525a.hashCode() * 31) + (this.f8526b ? 1 : 0)) * 31) + this.f8527c.hashCode()) * 31) + this.f8528d.hashCode()) * 31) + this.f8529e.hashCode();
    }
}
