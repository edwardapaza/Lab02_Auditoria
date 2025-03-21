package k1;
/* loaded from: classes.dex */
public final class r {

    /* renamed from: a  reason: collision with root package name */
    private final f0<?> f5608a;

    /* renamed from: b  reason: collision with root package name */
    private final int f5609b;

    /* renamed from: c  reason: collision with root package name */
    private final int f5610c;

    private r(Class<?> cls, int i5, int i6) {
        this(f0.b(cls), i5, i6);
    }

    private r(f0<?> f0Var, int i5, int i6) {
        this.f5608a = (f0) e0.c(f0Var, "Null dependency anInterface.");
        this.f5609b = i5;
        this.f5610c = i6;
    }

    public static r a(Class<?> cls) {
        return new r(cls, 0, 2);
    }

    private static String b(int i5) {
        if (i5 != 0) {
            if (i5 != 1) {
                if (i5 == 2) {
                    return "deferred";
                }
                throw new AssertionError("Unsupported injection: " + i5);
            }
            return "provider";
        }
        return "direct";
    }

    @Deprecated
    public static r h(Class<?> cls) {
        return new r(cls, 0, 0);
    }

    public static r i(Class<?> cls) {
        return new r(cls, 0, 1);
    }

    public static r j(Class<?> cls) {
        return new r(cls, 1, 0);
    }

    public static r k(f0<?> f0Var) {
        return new r(f0Var, 1, 0);
    }

    public static r l(Class<?> cls) {
        return new r(cls, 1, 1);
    }

    public static r m(Class<?> cls) {
        return new r(cls, 2, 0);
    }

    public f0<?> c() {
        return this.f5608a;
    }

    public boolean d() {
        return this.f5610c == 2;
    }

    public boolean e() {
        return this.f5610c == 0;
    }

    public boolean equals(Object obj) {
        if (obj instanceof r) {
            r rVar = (r) obj;
            return this.f5608a.equals(rVar.f5608a) && this.f5609b == rVar.f5609b && this.f5610c == rVar.f5610c;
        }
        return false;
    }

    public boolean f() {
        return this.f5609b == 1;
    }

    public boolean g() {
        return this.f5609b == 2;
    }

    public int hashCode() {
        return ((((this.f5608a.hashCode() ^ 1000003) * 1000003) ^ this.f5609b) * 1000003) ^ this.f5610c;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Dependency{anInterface=");
        sb.append(this.f5608a);
        sb.append(", type=");
        int i5 = this.f5609b;
        sb.append(i5 == 1 ? "required" : i5 == 0 ? "optional" : "set");
        sb.append(", injection=");
        sb.append(b(this.f5610c));
        sb.append("}");
        return sb.toString();
    }
}
