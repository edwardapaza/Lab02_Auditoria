package androidx.activity;
/* loaded from: classes.dex */
public final class b {

    /* renamed from: e  reason: collision with root package name */
    public static final a f90e = new a(null);

    /* renamed from: a  reason: collision with root package name */
    private final float f91a;

    /* renamed from: b  reason: collision with root package name */
    private final float f92b;

    /* renamed from: c  reason: collision with root package name */
    private final float f93c;

    /* renamed from: d  reason: collision with root package name */
    private final int f94d;

    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(e4.g gVar) {
            this();
        }
    }

    public b(float f5, float f6, float f7, int i5) {
        this.f91a = f5;
        this.f92b = f6;
        this.f93c = f7;
        this.f94d = i5;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public b(android.window.BackEvent r5) {
        /*
            r4 = this;
            java.lang.String r0 = "backEvent"
            e4.k.e(r5, r0)
            androidx.activity.a r0 = androidx.activity.a.f89a
            float r1 = r0.d(r5)
            float r2 = r0.e(r5)
            float r3 = r0.b(r5)
            int r5 = r0.c(r5)
            r4.<init>(r1, r2, r3, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.activity.b.<init>(android.window.BackEvent):void");
    }

    public final float a() {
        return this.f93c;
    }

    public String toString() {
        return "BackEventCompat{touchX=" + this.f91a + ", touchY=" + this.f92b + ", progress=" + this.f93c + ", swipeEdge=" + this.f94d + '}';
    }
}
