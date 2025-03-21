package v1;
/* loaded from: classes.dex */
public final class f implements Comparable<f> {

    /* renamed from: c  reason: collision with root package name */
    public static final f f8115c = c("", "");

    /* renamed from: a  reason: collision with root package name */
    private final String f8116a;

    /* renamed from: b  reason: collision with root package name */
    private final String f8117b;

    private f(String str, String str2) {
        this.f8116a = str;
        this.f8117b = str2;
    }

    public static f c(String str, String str2) {
        return new f(str, str2);
    }

    public static f d(String str) {
        u u5 = u.u(str);
        z1.b.d(u5.p() > 3 && u5.m(0).equals("projects") && u5.m(2).equals("databases"), "Tried to parse an invalid resource name: %s", u5);
        return new f(u5.m(1), u5.m(3));
    }

    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(f fVar) {
        int compareTo = this.f8116a.compareTo(fVar.f8116a);
        return compareTo != 0 ? compareTo : this.f8117b.compareTo(fVar.f8117b);
    }

    public String e() {
        return this.f8117b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || f.class != obj.getClass()) {
            return false;
        }
        f fVar = (f) obj;
        return this.f8116a.equals(fVar.f8116a) && this.f8117b.equals(fVar.f8117b);
    }

    public String h() {
        return this.f8116a;
    }

    public int hashCode() {
        return (this.f8116a.hashCode() * 31) + this.f8117b.hashCode();
    }

    public String toString() {
        return "DatabaseId(" + this.f8116a + ", " + this.f8117b + ")";
    }
}
