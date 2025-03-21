package i3;

import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes.dex */
public final class j0 {

    /* renamed from: d  reason: collision with root package name */
    private static final AtomicLong f3426d = new AtomicLong();

    /* renamed from: a  reason: collision with root package name */
    private final String f3427a;

    /* renamed from: b  reason: collision with root package name */
    private final String f3428b;

    /* renamed from: c  reason: collision with root package name */
    private final long f3429c;

    j0(String str, String str2, long j5) {
        z0.k.o(str, "typeName");
        z0.k.e(!str.isEmpty(), "empty type");
        this.f3427a = str;
        this.f3428b = str2;
        this.f3429c = j5;
    }

    public static j0 a(Class<?> cls, String str) {
        return b(c(cls), str);
    }

    public static j0 b(String str, String str2) {
        return new j0(str, str2, e());
    }

    private static String c(Class<?> cls) {
        String simpleName = ((Class) z0.k.o(cls, "type")).getSimpleName();
        return !simpleName.isEmpty() ? simpleName : cls.getName().substring(cls.getPackage().getName().length() + 1);
    }

    static long e() {
        return f3426d.incrementAndGet();
    }

    public long d() {
        return this.f3429c;
    }

    public String f() {
        return this.f3427a + "<" + this.f3429c + ">";
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(f());
        if (this.f3428b != null) {
            sb.append(": (");
            sb.append(this.f3428b);
            sb.append(')');
        }
        return sb.toString();
    }
}
