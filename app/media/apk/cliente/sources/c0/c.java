package c0;
/* loaded from: classes.dex */
public interface c extends c0.a {

    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: b  reason: collision with root package name */
        public static final C0031a f785b = new C0031a(null);

        /* renamed from: c  reason: collision with root package name */
        public static final a f786c = new a("NONE");

        /* renamed from: d  reason: collision with root package name */
        public static final a f787d = new a("FULL");

        /* renamed from: a  reason: collision with root package name */
        private final String f788a;

        /* renamed from: c0.c$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0031a {
            private C0031a() {
            }

            public /* synthetic */ C0031a(e4.g gVar) {
                this();
            }
        }

        private a(String str) {
            this.f788a = str;
        }

        public String toString() {
            return this.f788a;
        }
    }

    /* loaded from: classes.dex */
    public static final class b {

        /* renamed from: b  reason: collision with root package name */
        public static final a f789b = new a(null);

        /* renamed from: c  reason: collision with root package name */
        public static final b f790c = new b("FLAT");

        /* renamed from: d  reason: collision with root package name */
        public static final b f791d = new b("HALF_OPENED");

        /* renamed from: a  reason: collision with root package name */
        private final String f792a;

        /* loaded from: classes.dex */
        public static final class a {
            private a() {
            }

            public /* synthetic */ a(e4.g gVar) {
                this();
            }
        }

        private b(String str) {
            this.f792a = str;
        }

        public String toString() {
            return this.f792a;
        }
    }

    b a();

    a b();
}
