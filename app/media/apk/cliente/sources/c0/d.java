package c0;

import android.graphics.Rect;
import c0.c;
/* loaded from: classes.dex */
public final class d implements c {

    /* renamed from: d  reason: collision with root package name */
    public static final a f793d = new a(null);

    /* renamed from: a  reason: collision with root package name */
    private final z.b f794a;

    /* renamed from: b  reason: collision with root package name */
    private final b f795b;

    /* renamed from: c  reason: collision with root package name */
    private final c.b f796c;

    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(e4.g gVar) {
            this();
        }

        public final void a(z.b bVar) {
            e4.k.e(bVar, "bounds");
            boolean z4 = false;
            if (!((bVar.d() == 0 && bVar.a() == 0) ? false : true)) {
                throw new IllegalArgumentException("Bounds must be non zero".toString());
            }
            if (!((bVar.b() == 0 || bVar.c() == 0) ? true : true)) {
                throw new IllegalArgumentException("Bounding rectangle must start at the top or left window edge for folding features".toString());
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class b {

        /* renamed from: b  reason: collision with root package name */
        public static final a f797b = new a(null);

        /* renamed from: c  reason: collision with root package name */
        private static final b f798c = new b("FOLD");

        /* renamed from: d  reason: collision with root package name */
        private static final b f799d = new b("HINGE");

        /* renamed from: a  reason: collision with root package name */
        private final String f800a;

        /* loaded from: classes.dex */
        public static final class a {
            private a() {
            }

            public /* synthetic */ a(e4.g gVar) {
                this();
            }

            public final b a() {
                return b.f798c;
            }

            public final b b() {
                return b.f799d;
            }
        }

        private b(String str) {
            this.f800a = str;
        }

        public String toString() {
            return this.f800a;
        }
    }

    public d(z.b bVar, b bVar2, c.b bVar3) {
        e4.k.e(bVar, "featureBounds");
        e4.k.e(bVar2, "type");
        e4.k.e(bVar3, "state");
        this.f794a = bVar;
        this.f795b = bVar2;
        this.f796c = bVar3;
        f793d.a(bVar);
    }

    @Override // c0.c
    public c.b a() {
        return this.f796c;
    }

    @Override // c0.c
    public c.a b() {
        return (this.f794a.d() == 0 || this.f794a.a() == 0) ? c.a.f786c : c.a.f787d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (e4.k.a(d.class, obj != null ? obj.getClass() : null)) {
            e4.k.c(obj, "null cannot be cast to non-null type androidx.window.layout.HardwareFoldingFeature");
            d dVar = (d) obj;
            return e4.k.a(this.f794a, dVar.f794a) && e4.k.a(this.f795b, dVar.f795b) && e4.k.a(a(), dVar.a());
        }
        return false;
    }

    @Override // c0.a
    public Rect getBounds() {
        return this.f794a.f();
    }

    public int hashCode() {
        return (((this.f794a.hashCode() * 31) + this.f795b.hashCode()) * 31) + a().hashCode();
    }

    public String toString() {
        return d.class.getSimpleName() + " { " + this.f794a + ", type=" + this.f795b + ", state=" + a() + " }";
    }
}
