package s3;
/* loaded from: classes.dex */
public final class e implements Comparable<e> {

    /* renamed from: e  reason: collision with root package name */
    public static final a f7556e = new a(null);

    /* renamed from: f  reason: collision with root package name */
    public static final e f7557f = f.a();

    /* renamed from: a  reason: collision with root package name */
    private final int f7558a;

    /* renamed from: b  reason: collision with root package name */
    private final int f7559b;

    /* renamed from: c  reason: collision with root package name */
    private final int f7560c;

    /* renamed from: d  reason: collision with root package name */
    private final int f7561d;

    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(e4.g gVar) {
            this();
        }
    }

    public e(int i5, int i6, int i7) {
        this.f7558a = i5;
        this.f7559b = i6;
        this.f7560c = i7;
        this.f7561d = c(i5, i6, i7);
    }

    private final int c(int i5, int i6, int i7) {
        boolean z4 = false;
        if (new h4.f(0, 255).m(i5) && new h4.f(0, 255).m(i6) && new h4.f(0, 255).m(i7)) {
            z4 = true;
        }
        if (z4) {
            return (i5 << 16) + (i6 << 8) + i7;
        }
        throw new IllegalArgumentException(("Version components are out of range: " + i5 + '.' + i6 + '.' + i7).toString());
    }

    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(e eVar) {
        e4.k.e(eVar, "other");
        return this.f7561d - eVar.f7561d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        e eVar = obj instanceof e ? (e) obj : null;
        return eVar != null && this.f7561d == eVar.f7561d;
    }

    public int hashCode() {
        return this.f7561d;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f7558a);
        sb.append('.');
        sb.append(this.f7559b);
        sb.append('.');
        sb.append(this.f7560c);
        return sb.toString();
    }
}
