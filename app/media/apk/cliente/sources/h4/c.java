package h4;
/* loaded from: classes.dex */
public final class c extends h4.a {

    /* renamed from: e  reason: collision with root package name */
    public static final a f3124e = new a(null);

    /* renamed from: f  reason: collision with root package name */
    private static final c f3125f = new c(1, 0);

    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(e4.g gVar) {
            this();
        }
    }

    public c(char c5, char c6) {
        super(c5, c6, 1);
    }

    public boolean equals(Object obj) {
        if (obj instanceof c) {
            if (!isEmpty() || !((c) obj).isEmpty()) {
                c cVar = (c) obj;
                if (g() != cVar.g() || h() != cVar.h()) {
                }
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (g() * 31) + h();
    }

    public boolean isEmpty() {
        return e4.k.f(g(), h()) > 0;
    }

    public String toString() {
        return g() + ".." + h();
    }
}
