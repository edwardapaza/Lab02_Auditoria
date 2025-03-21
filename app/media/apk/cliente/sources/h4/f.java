package h4;
/* loaded from: classes.dex */
public final class f extends d {

    /* renamed from: e  reason: collision with root package name */
    public static final a f3134e = new a(null);

    /* renamed from: f  reason: collision with root package name */
    private static final f f3135f = new f(1, 0);

    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(e4.g gVar) {
            this();
        }

        public final f a() {
            return f.f3135f;
        }
    }

    public f(int i5, int i6) {
        super(i5, i6, 1);
    }

    @Override // h4.d
    public boolean equals(Object obj) {
        if (obj instanceof f) {
            if (!isEmpty() || !((f) obj).isEmpty()) {
                f fVar = (f) obj;
                if (g() != fVar.g() || h() != fVar.h()) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // h4.d
    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (g() * 31) + h();
    }

    @Override // h4.d
    public boolean isEmpty() {
        return g() > h();
    }

    public boolean m(int i5) {
        return g() <= i5 && i5 <= h();
    }

    public Integer n() {
        return Integer.valueOf(h());
    }

    public Integer o() {
        return Integer.valueOf(g());
    }

    @Override // h4.d
    public String toString() {
        return g() + ".." + h();
    }
}
