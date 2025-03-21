package l4;

import e4.g;
import e4.k;
import h4.i;
import k4.p;
/* loaded from: classes.dex */
public final class b implements Comparable<b> {

    /* renamed from: b  reason: collision with root package name */
    public static final a f6033b = new a(null);

    /* renamed from: c  reason: collision with root package name */
    private static final long f6034c = e(0);

    /* renamed from: d  reason: collision with root package name */
    private static final long f6035d;

    /* renamed from: e  reason: collision with root package name */
    private static final long f6036e;

    /* renamed from: a  reason: collision with root package name */
    private final long f6037a;

    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }
    }

    static {
        long e5;
        long e6;
        e5 = d.e(4611686018427387903L);
        f6035d = e5;
        e6 = d.e(-4611686018427387903L);
        f6036e = e6;
    }

    public static final boolean A(long j5) {
        return j5 < 0;
    }

    public static final long B(long j5, e eVar) {
        k.e(eVar, "unit");
        if (j5 == f6035d) {
            return Long.MAX_VALUE;
        }
        if (j5 == f6036e) {
            return Long.MIN_VALUE;
        }
        return f.a(v(j5), u(j5), eVar);
    }

    public static String C(long j5) {
        int i5;
        long j6;
        StringBuilder sb;
        int i6;
        int i7;
        String str;
        boolean z4;
        if (j5 == 0) {
            return "0s";
        }
        if (j5 == f6035d) {
            return "Infinity";
        }
        if (j5 == f6036e) {
            return "-Infinity";
        }
        boolean A = A(j5);
        StringBuilder sb2 = new StringBuilder();
        if (A) {
            sb2.append('-');
        }
        long k5 = k(j5);
        long n5 = n(k5);
        int m5 = m(k5);
        int r5 = r(k5);
        int t5 = t(k5);
        int s5 = s(k5);
        int i8 = 0;
        boolean z5 = n5 != 0;
        boolean z6 = m5 != 0;
        boolean z7 = r5 != 0;
        boolean z8 = (t5 == 0 && s5 == 0) ? false : true;
        if (z5) {
            sb2.append(n5);
            sb2.append('d');
            i8 = 1;
        }
        if (z6 || (z5 && (z7 || z8))) {
            int i9 = i8 + 1;
            if (i8 > 0) {
                sb2.append(' ');
            }
            sb2.append(m5);
            sb2.append('h');
            i8 = i9;
        }
        if (z7 || (z8 && (z6 || z5))) {
            int i10 = i8 + 1;
            if (i8 > 0) {
                sb2.append(' ');
            }
            sb2.append(r5);
            sb2.append('m');
            i8 = i10;
        }
        if (z8) {
            int i11 = i8 + 1;
            if (i8 > 0) {
                sb2.append(' ');
            }
            if (t5 != 0 || z5 || z6 || z7) {
                i5 = 9;
                j6 = j5;
                sb = sb2;
                i6 = t5;
                i7 = s5;
                str = "s";
                z4 = false;
            } else {
                if (s5 >= 1000000) {
                    i6 = s5 / 1000000;
                    i7 = s5 % 1000000;
                    i5 = 6;
                    z4 = false;
                    str = "ms";
                } else if (s5 >= 1000) {
                    i6 = s5 / 1000;
                    i7 = s5 % 1000;
                    i5 = 3;
                    z4 = false;
                    str = "us";
                } else {
                    sb2.append(s5);
                    sb2.append("ns");
                    i8 = i11;
                }
                j6 = j5;
                sb = sb2;
            }
            a(j6, sb, i6, i7, i5, str, z4);
            i8 = i11;
        }
        if (A && i8 > 1) {
            sb2.insert(1, '(').append(')');
        }
        String sb3 = sb2.toString();
        k.d(sb3, "StringBuilder().apply(builderAction).toString()");
        return sb3;
    }

    public static final long D(long j5) {
        long d5;
        d5 = d.d(-v(j5), ((int) j5) & 1);
        return d5;
    }

    private static final void a(long j5, StringBuilder sb, int i5, int i6, int i7, String str, boolean z4) {
        String J;
        sb.append(i5);
        if (i6 != 0) {
            sb.append('.');
            J = p.J(String.valueOf(i6), i7, '0');
            int i8 = -1;
            int length = J.length() - 1;
            if (length >= 0) {
                while (true) {
                    int i9 = length - 1;
                    if (J.charAt(length) != '0') {
                        i8 = length;
                        break;
                    } else if (i9 < 0) {
                        break;
                    } else {
                        length = i9;
                    }
                }
            }
            int i10 = i8 + 1;
            if (z4 || i10 >= 3) {
                i10 = ((i10 + 2) / 3) * 3;
            }
            sb.append((CharSequence) J, 0, i10);
            k.d(sb, "this.append(value, startIndex, endIndex)");
        }
        sb.append(str);
    }

    public static int d(long j5, long j6) {
        long j7 = j5 ^ j6;
        if (j7 < 0 || (((int) j7) & 1) == 0) {
            return k.g(j5, j6);
        }
        int i5 = (((int) j5) & 1) - (((int) j6) & 1);
        return A(j5) ? -i5 : i5;
    }

    public static long e(long j5) {
        if (c.a()) {
            if (y(j5)) {
                if (!new i(-4611686018426999999L, 4611686018426999999L).k(v(j5))) {
                    throw new AssertionError(v(j5) + " ns is out of nanoseconds range");
                }
            } else if (!new i(-4611686018427387903L, 4611686018427387903L).k(v(j5))) {
                throw new AssertionError(v(j5) + " ms is out of milliseconds range");
            } else if (new i(-4611686018426L, 4611686018426L).k(v(j5))) {
                throw new AssertionError(v(j5) + " ms is denormalized");
            }
        }
        return j5;
    }

    public static boolean h(long j5, Object obj) {
        return (obj instanceof b) && j5 == ((b) obj).E();
    }

    public static final long k(long j5) {
        return A(j5) ? D(j5) : j5;
    }

    public static final int m(long j5) {
        if (z(j5)) {
            return 0;
        }
        return (int) (o(j5) % 24);
    }

    public static final long n(long j5) {
        return B(j5, e.DAYS);
    }

    public static final long o(long j5) {
        return B(j5, e.HOURS);
    }

    public static final long p(long j5) {
        return B(j5, e.MINUTES);
    }

    public static final long q(long j5) {
        return B(j5, e.SECONDS);
    }

    public static final int r(long j5) {
        if (z(j5)) {
            return 0;
        }
        return (int) (p(j5) % 60);
    }

    public static final int s(long j5) {
        if (z(j5)) {
            return 0;
        }
        boolean x4 = x(j5);
        long v5 = v(j5);
        return (int) (x4 ? d.g(v5 % 1000) : v5 % 1000000000);
    }

    public static final int t(long j5) {
        if (z(j5)) {
            return 0;
        }
        return (int) (q(j5) % 60);
    }

    private static final e u(long j5) {
        return y(j5) ? e.NANOSECONDS : e.MILLISECONDS;
    }

    private static final long v(long j5) {
        return j5 >> 1;
    }

    public static int w(long j5) {
        return l4.a.a(j5);
    }

    private static final boolean x(long j5) {
        return (((int) j5) & 1) == 1;
    }

    private static final boolean y(long j5) {
        return (((int) j5) & 1) == 0;
    }

    public static final boolean z(long j5) {
        return j5 == f6035d || j5 == f6036e;
    }

    public final /* synthetic */ long E() {
        return this.f6037a;
    }

    public int c(long j5) {
        return d(this.f6037a, j5);
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(b bVar) {
        return c(bVar.E());
    }

    public boolean equals(Object obj) {
        return h(this.f6037a, obj);
    }

    public int hashCode() {
        return w(this.f6037a);
    }

    public String toString() {
        return C(this.f6037a);
    }
}
