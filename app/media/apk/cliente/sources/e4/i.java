package e4;
/* loaded from: classes.dex */
public class i extends c implements h, i4.e {

    /* renamed from: l  reason: collision with root package name */
    private final int f2933l;

    /* renamed from: m  reason: collision with root package name */
    private final int f2934m;

    public i(int i5, Object obj, Class cls, String str, String str2, int i6) {
        super(obj, cls, str, str2, (i6 & 1) == 1);
        this.f2933l = i5;
        this.f2934m = i6 >> 1;
    }

    @Override // e4.c
    protected i4.a c() {
        return s.a(this);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof i) {
            i iVar = (i) obj;
            return f().equals(iVar.f()) && h().equals(iVar.h()) && this.f2934m == iVar.f2934m && this.f2933l == iVar.f2933l && k.a(e(), iVar.e()) && k.a(g(), iVar.g());
        } else if (obj instanceof i4.e) {
            return obj.equals(a());
        } else {
            return false;
        }
    }

    @Override // e4.h
    public int getArity() {
        return this.f2933l;
    }

    public int hashCode() {
        return (((g() == null ? 0 : g().hashCode() * 31) + f().hashCode()) * 31) + h().hashCode();
    }

    public String toString() {
        i4.a a5 = a();
        if (a5 != this) {
            return a5.toString();
        }
        if ("<init>".equals(f())) {
            return "constructor (Kotlin reflection is not available)";
        }
        return "function " + f() + " (Kotlin reflection is not available)";
    }
}
