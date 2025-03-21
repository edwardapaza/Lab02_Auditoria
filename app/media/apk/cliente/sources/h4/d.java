package h4;

import t3.c0;
/* loaded from: classes.dex */
public class d implements Iterable<Integer> {

    /* renamed from: d  reason: collision with root package name */
    public static final a f3126d = new a(null);

    /* renamed from: a  reason: collision with root package name */
    private final int f3127a;

    /* renamed from: b  reason: collision with root package name */
    private final int f3128b;

    /* renamed from: c  reason: collision with root package name */
    private final int f3129c;

    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(e4.g gVar) {
            this();
        }

        public final d a(int i5, int i6, int i7) {
            return new d(i5, i6, i7);
        }
    }

    public d(int i5, int i6, int i7) {
        if (i7 == 0) {
            throw new IllegalArgumentException("Step must be non-zero.");
        }
        if (i7 == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
        }
        this.f3127a = i5;
        this.f3128b = y3.c.c(i5, i6, i7);
        this.f3129c = i7;
    }

    public boolean equals(Object obj) {
        if (obj instanceof d) {
            if (!isEmpty() || !((d) obj).isEmpty()) {
                d dVar = (d) obj;
                if (this.f3127a != dVar.f3127a || this.f3128b != dVar.f3128b || this.f3129c != dVar.f3129c) {
                }
            }
            return true;
        }
        return false;
    }

    public final int g() {
        return this.f3127a;
    }

    public final int h() {
        return this.f3128b;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.f3127a * 31) + this.f3128b) * 31) + this.f3129c;
    }

    public final int i() {
        return this.f3129c;
    }

    public boolean isEmpty() {
        if (this.f3129c > 0) {
            if (this.f3127a > this.f3128b) {
                return true;
            }
        } else if (this.f3127a < this.f3128b) {
            return true;
        }
        return false;
    }

    @Override // java.lang.Iterable
    /* renamed from: k */
    public c0 iterator() {
        return new e(this.f3127a, this.f3128b, this.f3129c);
    }

    public String toString() {
        StringBuilder sb;
        int i5;
        if (this.f3129c > 0) {
            sb = new StringBuilder();
            sb.append(this.f3127a);
            sb.append("..");
            sb.append(this.f3128b);
            sb.append(" step ");
            i5 = this.f3129c;
        } else {
            sb = new StringBuilder();
            sb.append(this.f3127a);
            sb.append(" downTo ");
            sb.append(this.f3128b);
            sb.append(" step ");
            i5 = -this.f3129c;
        }
        sb.append(i5);
        return sb.toString();
    }
}
