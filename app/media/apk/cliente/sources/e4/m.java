package e4;
/* loaded from: classes.dex */
public final class m implements d {

    /* renamed from: a  reason: collision with root package name */
    private final Class<?> f2935a;

    /* renamed from: b  reason: collision with root package name */
    private final String f2936b;

    public m(Class<?> cls, String str) {
        k.e(cls, "jClass");
        k.e(str, "moduleName");
        this.f2935a = cls;
        this.f2936b = str;
    }

    @Override // e4.d
    public Class<?> d() {
        return this.f2935a;
    }

    public boolean equals(Object obj) {
        return (obj instanceof m) && k.a(d(), ((m) obj).d());
    }

    public int hashCode() {
        return d().hashCode();
    }

    public String toString() {
        return d().toString() + " (Kotlin reflection is not available)";
    }
}
