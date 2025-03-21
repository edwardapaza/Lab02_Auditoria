package e2;
/* loaded from: classes.dex */
final class a extends f {

    /* renamed from: a  reason: collision with root package name */
    private final String f2665a;

    /* renamed from: b  reason: collision with root package name */
    private final String f2666b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(String str, String str2) {
        if (str == null) {
            throw new NullPointerException("Null libraryName");
        }
        this.f2665a = str;
        if (str2 == null) {
            throw new NullPointerException("Null version");
        }
        this.f2666b = str2;
    }

    @Override // e2.f
    public String b() {
        return this.f2665a;
    }

    @Override // e2.f
    public String c() {
        return this.f2666b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof f) {
            f fVar = (f) obj;
            return this.f2665a.equals(fVar.b()) && this.f2666b.equals(fVar.c());
        }
        return false;
    }

    public int hashCode() {
        return ((this.f2665a.hashCode() ^ 1000003) * 1000003) ^ this.f2666b.hashCode();
    }

    public String toString() {
        return "LibraryVersion{libraryName=" + this.f2665a + ", version=" + this.f2666b + "}";
    }
}
