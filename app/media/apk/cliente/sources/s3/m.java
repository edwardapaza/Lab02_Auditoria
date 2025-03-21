package s3;

import java.io.Serializable;
/* loaded from: classes.dex */
public final class m<T> implements Serializable {

    /* renamed from: b  reason: collision with root package name */
    public static final a f7565b = new a(null);

    /* renamed from: a  reason: collision with root package name */
    private final Object f7566a;

    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(e4.g gVar) {
            this();
        }
    }

    /* loaded from: classes.dex */
    public static final class b implements Serializable {

        /* renamed from: a  reason: collision with root package name */
        public final Throwable f7567a;

        public b(Throwable th) {
            e4.k.e(th, "exception");
            this.f7567a = th;
        }

        public boolean equals(Object obj) {
            return (obj instanceof b) && e4.k.a(this.f7567a, ((b) obj).f7567a);
        }

        public int hashCode() {
            return this.f7567a.hashCode();
        }

        public String toString() {
            return "Failure(" + this.f7567a + ')';
        }
    }

    private /* synthetic */ m(Object obj) {
        this.f7566a = obj;
    }

    public static final /* synthetic */ m a(Object obj) {
        return new m(obj);
    }

    public static <T> Object b(Object obj) {
        return obj;
    }

    public static boolean c(Object obj, Object obj2) {
        return (obj2 instanceof m) && e4.k.a(obj, ((m) obj2).i());
    }

    public static final Throwable d(Object obj) {
        if (obj instanceof b) {
            return ((b) obj).f7567a;
        }
        return null;
    }

    public static int e(Object obj) {
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public static final boolean f(Object obj) {
        return obj instanceof b;
    }

    public static final boolean g(Object obj) {
        return !(obj instanceof b);
    }

    public static String h(Object obj) {
        if (obj instanceof b) {
            return ((b) obj).toString();
        }
        return "Success(" + obj + ')';
    }

    public boolean equals(Object obj) {
        return c(this.f7566a, obj);
    }

    public int hashCode() {
        return e(this.f7566a);
    }

    public final /* synthetic */ Object i() {
        return this.f7566a;
    }

    public String toString() {
        return h(this.f7566a);
    }
}
