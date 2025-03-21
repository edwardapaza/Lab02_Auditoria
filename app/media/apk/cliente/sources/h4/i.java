package h4;
/* loaded from: classes.dex */
public final class i extends g {

    /* renamed from: e  reason: collision with root package name */
    public static final a f3144e = new a(null);

    /* renamed from: f  reason: collision with root package name */
    private static final i f3145f = new i(1, 0);

    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(e4.g gVar) {
            this();
        }
    }

    public i(long j5, long j6) {
        super(j5, j6, 1L);
    }

    public boolean equals(Object obj) {
        if (obj instanceof i) {
            if (!isEmpty() || !((i) obj).isEmpty()) {
                i iVar = (i) obj;
                if (g() != iVar.g() || h() != iVar.h()) {
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
        return (int) ((31 * (g() ^ (g() >>> 32))) + (h() ^ (h() >>> 32)));
    }

    public boolean isEmpty() {
        return g() > h();
    }

    public boolean k(long j5) {
        return g() <= j5 && j5 <= h();
    }

    public String toString() {
        return g() + ".." + h();
    }
}
