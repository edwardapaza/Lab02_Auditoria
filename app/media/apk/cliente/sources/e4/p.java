package e4;
/* loaded from: classes.dex */
public abstract class p extends c implements i4.g {

    /* renamed from: l  reason: collision with root package name */
    private final boolean f2937l;

    public p() {
        this.f2937l = false;
    }

    public p(Object obj, Class cls, String str, String str2, int i5) {
        super(obj, cls, str, str2, (i5 & 1) == 1);
        this.f2937l = (i5 & 2) == 2;
    }

    @Override // e4.c
    public i4.a a() {
        return this.f2937l ? this : super.a();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof p) {
            p pVar = (p) obj;
            return g().equals(pVar.g()) && f().equals(pVar.f()) && h().equals(pVar.h()) && k.a(e(), pVar.e());
        } else if (obj instanceof i4.g) {
            return obj.equals(a());
        } else {
            return false;
        }
    }

    public int hashCode() {
        return (((g().hashCode() * 31) + f().hashCode()) * 31) + h().hashCode();
    }

    public String toString() {
        i4.a a5 = a();
        if (a5 != this) {
            return a5.toString();
        }
        return "property " + f() + " (Kotlin reflection is not available)";
    }
}
