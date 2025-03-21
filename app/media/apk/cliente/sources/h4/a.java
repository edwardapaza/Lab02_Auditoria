package h4;

import t3.m;
/* loaded from: classes.dex */
public class a implements Iterable<Character> {

    /* renamed from: d  reason: collision with root package name */
    public static final C0061a f3116d = new C0061a(null);

    /* renamed from: a  reason: collision with root package name */
    private final char f3117a;

    /* renamed from: b  reason: collision with root package name */
    private final char f3118b;

    /* renamed from: c  reason: collision with root package name */
    private final int f3119c;

    /* renamed from: h4.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0061a {
        private C0061a() {
        }

        public /* synthetic */ C0061a(e4.g gVar) {
            this();
        }
    }

    public a(char c5, char c6, int i5) {
        if (i5 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (i5 == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
        this.f3117a = c5;
        this.f3118b = (char) y3.c.c(c5, c6, i5);
        this.f3119c = i5;
    }

    public final char g() {
        return this.f3117a;
    }

    public final char h() {
        return this.f3118b;
    }

    @Override // java.lang.Iterable
    /* renamed from: i */
    public m iterator() {
        return new b(this.f3117a, this.f3118b, this.f3119c);
    }
}
