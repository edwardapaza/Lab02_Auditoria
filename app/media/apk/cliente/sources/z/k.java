package z;

import java.math.BigInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import k4.o;
/* loaded from: classes.dex */
public final class k implements Comparable<k> {

    /* renamed from: f  reason: collision with root package name */
    public static final a f8846f = new a(null);

    /* renamed from: k  reason: collision with root package name */
    private static final k f8847k = new k(0, 0, 0, "");

    /* renamed from: l  reason: collision with root package name */
    private static final k f8848l = new k(0, 1, 0, "");

    /* renamed from: m  reason: collision with root package name */
    private static final k f8849m;

    /* renamed from: n  reason: collision with root package name */
    private static final k f8850n;

    /* renamed from: a  reason: collision with root package name */
    private final int f8851a;

    /* renamed from: b  reason: collision with root package name */
    private final int f8852b;

    /* renamed from: c  reason: collision with root package name */
    private final int f8853c;

    /* renamed from: d  reason: collision with root package name */
    private final String f8854d;

    /* renamed from: e  reason: collision with root package name */
    private final s3.g f8855e;

    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(e4.g gVar) {
            this();
        }

        public final k a() {
            return k.f8848l;
        }

        public final k b(String str) {
            boolean h5;
            String group;
            if (str != null) {
                h5 = o.h(str);
                if (!h5) {
                    Matcher matcher = Pattern.compile("(\\d+)(?:\\.(\\d+))(?:\\.(\\d+))(?:-(.+))?").matcher(str);
                    if (matcher.matches() && (group = matcher.group(1)) != null) {
                        int parseInt = Integer.parseInt(group);
                        String group2 = matcher.group(2);
                        if (group2 != null) {
                            int parseInt2 = Integer.parseInt(group2);
                            String group3 = matcher.group(3);
                            if (group3 != null) {
                                int parseInt3 = Integer.parseInt(group3);
                                String group4 = matcher.group(4) != null ? matcher.group(4) : "";
                                e4.k.d(group4, "description");
                                return new k(parseInt, parseInt2, parseInt3, group4, null);
                            }
                        }
                    }
                }
            }
            return null;
        }
    }

    /* loaded from: classes.dex */
    static final class b extends e4.l implements d4.a<BigInteger> {
        b() {
            super(0);
        }

        @Override // d4.a
        /* renamed from: a */
        public final BigInteger b() {
            return BigInteger.valueOf(k.this.e()).shiftLeft(32).or(BigInteger.valueOf(k.this.h())).shiftLeft(32).or(BigInteger.valueOf(k.this.k()));
        }
    }

    static {
        k kVar = new k(1, 0, 0, "");
        f8849m = kVar;
        f8850n = kVar;
    }

    private k(int i5, int i6, int i7, String str) {
        s3.g a5;
        this.f8851a = i5;
        this.f8852b = i6;
        this.f8853c = i7;
        this.f8854d = str;
        a5 = s3.i.a(new b());
        this.f8855e = a5;
    }

    public /* synthetic */ k(int i5, int i6, int i7, String str, e4.g gVar) {
        this(i5, i6, i7, str);
    }

    private final BigInteger d() {
        Object value = this.f8855e.getValue();
        e4.k.d(value, "<get-bigInteger>(...)");
        return (BigInteger) value;
    }

    @Override // java.lang.Comparable
    /* renamed from: c */
    public int compareTo(k kVar) {
        e4.k.e(kVar, "other");
        return d().compareTo(kVar.d());
    }

    public final int e() {
        return this.f8851a;
    }

    public boolean equals(Object obj) {
        if (obj instanceof k) {
            k kVar = (k) obj;
            return this.f8851a == kVar.f8851a && this.f8852b == kVar.f8852b && this.f8853c == kVar.f8853c;
        }
        return false;
    }

    public final int h() {
        return this.f8852b;
    }

    public int hashCode() {
        return ((((527 + this.f8851a) * 31) + this.f8852b) * 31) + this.f8853c;
    }

    public final int k() {
        return this.f8853c;
    }

    public String toString() {
        boolean h5;
        String str;
        h5 = o.h(this.f8854d);
        if (!h5) {
            str = '-' + this.f8854d;
        } else {
            str = "";
        }
        return this.f8851a + '.' + this.f8852b + '.' + this.f8853c + str;
    }
}
