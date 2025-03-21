package z0;
/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: z0.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    static abstract class AbstractC0135a extends a {
        AbstractC0135a() {
        }
    }

    /* loaded from: classes.dex */
    private static final class b extends AbstractC0135a {

        /* renamed from: a  reason: collision with root package name */
        private final char f8857a;

        b(char c5) {
            this.f8857a = c5;
        }

        public String toString() {
            return "CharMatcher.is('" + a.d(this.f8857a) + "')";
        }
    }

    /* loaded from: classes.dex */
    static abstract class c extends AbstractC0135a {

        /* renamed from: a  reason: collision with root package name */
        private final String f8858a;

        c(String str) {
            this.f8858a = (String) k.n(str);
        }

        public final String toString() {
            return this.f8858a;
        }
    }

    /* loaded from: classes.dex */
    private static final class d extends c {

        /* renamed from: b  reason: collision with root package name */
        static final d f8859b = new d();

        private d() {
            super("CharMatcher.none()");
        }
    }

    /* loaded from: classes.dex */
    static final class e extends c {

        /* renamed from: b  reason: collision with root package name */
        static final int f8860b = Integer.numberOfLeadingZeros(31);

        /* renamed from: c  reason: collision with root package name */
        static final e f8861c = new e();

        e() {
            super("CharMatcher.whitespace()");
        }
    }

    protected a() {
    }

    public static a b(char c5) {
        return new b(c5);
    }

    public static a c() {
        return d.f8859b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String d(char c5) {
        char[] cArr = {'\\', 'u', 0, 0, 0, 0};
        for (int i5 = 0; i5 < 4; i5++) {
            cArr[5 - i5] = "0123456789ABCDEF".charAt(c5 & 15);
            c5 = (char) (c5 >> 4);
        }
        return String.copyValueOf(cArr);
    }

    public static a e() {
        return e.f8861c;
    }
}
