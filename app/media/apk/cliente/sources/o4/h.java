package o4;
/* loaded from: classes.dex */
public final class h<T> {

    /* renamed from: b  reason: collision with root package name */
    public static final b f6835b = new b(null);

    /* renamed from: c  reason: collision with root package name */
    private static final c f6836c = new c();

    /* renamed from: a  reason: collision with root package name */
    private final Object f6837a;

    /* loaded from: classes.dex */
    public static final class a extends c {

        /* renamed from: a  reason: collision with root package name */
        public final Throwable f6838a;

        public a(Throwable th) {
            this.f6838a = th;
        }

        public boolean equals(Object obj) {
            return (obj instanceof a) && e4.k.a(this.f6838a, ((a) obj).f6838a);
        }

        public int hashCode() {
            Throwable th = this.f6838a;
            if (th != null) {
                return th.hashCode();
            }
            return 0;
        }

        @Override // o4.h.c
        public String toString() {
            return "Closed(" + this.f6838a + ')';
        }
    }

    /* loaded from: classes.dex */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(e4.g gVar) {
            this();
        }

        public final <E> Object a(Throwable th) {
            return h.c(new a(th));
        }

        public final <E> Object b() {
            return h.c(h.f6836c);
        }

        public final <E> Object c(E e5) {
            return h.c(e5);
        }
    }

    /* loaded from: classes.dex */
    public static class c {
        public String toString() {
            return "Failed";
        }
    }

    private /* synthetic */ h(Object obj) {
        this.f6837a = obj;
    }

    public static final /* synthetic */ h b(Object obj) {
        return new h(obj);
    }

    public static <T> Object c(Object obj) {
        return obj;
    }

    public static boolean d(Object obj, Object obj2) {
        return (obj2 instanceof h) && e4.k.a(obj, ((h) obj2).j());
    }

    public static final Throwable e(Object obj) {
        a aVar = obj instanceof a ? (a) obj : null;
        if (aVar != null) {
            return aVar.f6838a;
        }
        return null;
    }

    public static int f(Object obj) {
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public static final boolean g(Object obj) {
        return obj instanceof a;
    }

    public static final boolean h(Object obj) {
        return !(obj instanceof c);
    }

    public static String i(Object obj) {
        if (obj instanceof a) {
            return ((a) obj).toString();
        }
        return "Value(" + obj + ')';
    }

    public boolean equals(Object obj) {
        return d(this.f6837a, obj);
    }

    public int hashCode() {
        return f(this.f6837a);
    }

    public final /* synthetic */ Object j() {
        return this.f6837a;
    }

    public String toString() {
        return i(this.f6837a);
    }
}
