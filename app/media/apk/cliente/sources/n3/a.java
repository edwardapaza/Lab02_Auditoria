package n3;

import java.net.IDN;
import java.net.InetAddress;
import java.util.Locale;
import w4.c;
/* loaded from: classes.dex */
public final class a {

    /* renamed from: e  reason: collision with root package name */
    private static final char[] f6329e = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* renamed from: a  reason: collision with root package name */
    private final String f6330a;

    /* renamed from: b  reason: collision with root package name */
    private final String f6331b;

    /* renamed from: c  reason: collision with root package name */
    private final int f6332c;

    /* renamed from: d  reason: collision with root package name */
    private final String f6333d;

    /* loaded from: classes.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        String f6334a;

        /* renamed from: b  reason: collision with root package name */
        String f6335b;

        /* renamed from: c  reason: collision with root package name */
        int f6336c = -1;

        private static String b(String str, int i5, int i6) {
            String d5 = a.d(str, i5, i6, false);
            if (d5.startsWith("[") && d5.endsWith("]")) {
                InetAddress e5 = e(d5, 1, d5.length() - 1);
                if (e5 == null) {
                    return null;
                }
                byte[] address = e5.getAddress();
                if (address.length == 16) {
                    return i(address);
                }
                throw new AssertionError();
            }
            return f(d5);
        }

        private static boolean c(String str) {
            for (int i5 = 0; i5 < str.length(); i5++) {
                char charAt = str.charAt(i5);
                if (charAt <= 31 || charAt >= 127 || " #%/:?@[\\]".indexOf(charAt) != -1) {
                    return true;
                }
            }
            return false;
        }

        private static boolean d(String str, int i5, int i6, byte[] bArr, int i7) {
            int i8 = i7;
            while (i5 < i6) {
                if (i8 == bArr.length) {
                    return false;
                }
                if (i8 != i7) {
                    if (str.charAt(i5) != '.') {
                        return false;
                    }
                    i5++;
                }
                int i9 = i5;
                int i10 = 0;
                while (i9 < i6) {
                    char charAt = str.charAt(i9);
                    if (charAt < '0' || charAt > '9') {
                        break;
                    } else if ((i10 == 0 && i5 != i9) || (i10 = ((i10 * 10) + charAt) - 48) > 255) {
                        return false;
                    } else {
                        i9++;
                    }
                }
                if (i9 - i5 == 0) {
                    return false;
                }
                bArr[i8] = (byte) i10;
                i8++;
                i5 = i9;
            }
            return i8 == i7 + 4;
        }

        /* JADX WARN: Code restructure failed: missing block: B:41:0x0079, code lost:
            return null;
         */
        /* JADX WARN: Removed duplicated region for block: B:31:0x004f  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private static java.net.InetAddress e(java.lang.String r11, int r12, int r13) {
            /*
                r0 = 16
                byte[] r1 = new byte[r0]
                r2 = -1
                r3 = 0
                r4 = 0
                r5 = -1
                r6 = -1
            L9:
                r7 = 0
                if (r12 >= r13) goto L7a
                if (r4 != r0) goto Lf
                return r7
            Lf:
                int r8 = r12 + 2
                if (r8 > r13) goto L27
                java.lang.String r9 = "::"
                r10 = 2
                boolean r9 = r11.regionMatches(r12, r9, r3, r10)
                if (r9 == 0) goto L27
                if (r5 == r2) goto L1f
                return r7
            L1f:
                int r4 = r4 + 2
                r5 = r4
                if (r8 != r13) goto L25
                goto L7a
            L25:
                r6 = r8
                goto L4b
            L27:
                if (r4 == 0) goto L4a
                java.lang.String r8 = ":"
                r9 = 1
                boolean r8 = r11.regionMatches(r12, r8, r3, r9)
                if (r8 == 0) goto L35
                int r12 = r12 + 1
                goto L4a
            L35:
                java.lang.String r8 = "."
                boolean r12 = r11.regionMatches(r12, r8, r3, r9)
                if (r12 == 0) goto L49
                int r12 = r4 + (-2)
                boolean r11 = d(r11, r6, r13, r1, r12)
                if (r11 != 0) goto L46
                return r7
            L46:
                int r4 = r4 + 2
                goto L7a
            L49:
                return r7
            L4a:
                r6 = r12
            L4b:
                r12 = r6
                r8 = 0
            L4d:
                if (r12 >= r13) goto L60
                char r9 = r11.charAt(r12)
                int r9 = n3.a.a(r9)
                if (r9 != r2) goto L5a
                goto L60
            L5a:
                int r8 = r8 << 4
                int r8 = r8 + r9
                int r12 = r12 + 1
                goto L4d
            L60:
                int r9 = r12 - r6
                if (r9 == 0) goto L79
                r10 = 4
                if (r9 <= r10) goto L68
                goto L79
            L68:
                int r7 = r4 + 1
                int r9 = r8 >>> 8
                r9 = r9 & 255(0xff, float:3.57E-43)
                byte r9 = (byte) r9
                r1[r4] = r9
                int r4 = r7 + 1
                r8 = r8 & 255(0xff, float:3.57E-43)
                byte r8 = (byte) r8
                r1[r7] = r8
                goto L9
            L79:
                return r7
            L7a:
                if (r4 == r0) goto L8b
                if (r5 != r2) goto L7f
                return r7
            L7f:
                int r11 = r4 - r5
                int r12 = 16 - r11
                java.lang.System.arraycopy(r1, r5, r1, r12, r11)
                int r0 = r0 - r4
                int r0 = r0 + r5
                java.util.Arrays.fill(r1, r5, r0, r3)
            L8b:
                java.net.InetAddress r11 = java.net.InetAddress.getByAddress(r1)     // Catch: java.net.UnknownHostException -> L90
                return r11
            L90:
                java.lang.AssertionError r11 = new java.lang.AssertionError
                r11.<init>()
                throw r11
            */
            throw new UnsupportedOperationException("Method not decompiled: n3.a.b.e(java.lang.String, int, int):java.net.InetAddress");
        }

        private static String f(String str) {
            try {
                String lowerCase = IDN.toASCII(str).toLowerCase(Locale.US);
                if (lowerCase.isEmpty()) {
                    return null;
                }
                if (c(lowerCase)) {
                    return null;
                }
                return lowerCase;
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }

        private static String i(byte[] bArr) {
            int i5 = 0;
            int i6 = -1;
            int i7 = 0;
            int i8 = 0;
            while (i7 < bArr.length) {
                int i9 = i7;
                while (i9 < 16 && bArr[i9] == 0 && bArr[i9 + 1] == 0) {
                    i9 += 2;
                }
                int i10 = i9 - i7;
                if (i10 > i8) {
                    i6 = i7;
                    i8 = i10;
                }
                i7 = i9 + 2;
            }
            c cVar = new c();
            while (i5 < bArr.length) {
                if (i5 == i6) {
                    cVar.writeByte(58);
                    i5 += i8;
                    if (i5 == 16) {
                        cVar.writeByte(58);
                    }
                } else {
                    if (i5 > 0) {
                        cVar.writeByte(58);
                    }
                    cVar.X(((bArr[i5] & 255) << 8) | (bArr[i5 + 1] & 255));
                    i5 += 2;
                }
            }
            return cVar.A();
        }

        public a a() {
            if (this.f6334a != null) {
                if (this.f6335b != null) {
                    return new a(this);
                }
                throw new IllegalStateException("host == null");
            }
            throw new IllegalStateException("scheme == null");
        }

        int g() {
            int i5 = this.f6336c;
            return i5 != -1 ? i5 : a.b(this.f6334a);
        }

        public b h(String str) {
            if (str != null) {
                String b5 = b(str, 0, str.length());
                if (b5 != null) {
                    this.f6335b = b5;
                    return this;
                }
                throw new IllegalArgumentException("unexpected host: " + str);
            }
            throw new IllegalArgumentException("host == null");
        }

        public b j(int i5) {
            if (i5 > 0 && i5 <= 65535) {
                this.f6336c = i5;
                return this;
            }
            throw new IllegalArgumentException("unexpected port: " + i5);
        }

        public b k(String str) {
            if (str != null) {
                String str2 = "http";
                if (!str.equalsIgnoreCase("http")) {
                    str2 = "https";
                    if (!str.equalsIgnoreCase("https")) {
                        throw new IllegalArgumentException("unexpected scheme: " + str);
                    }
                }
                this.f6334a = str2;
                return this;
            }
            throw new IllegalArgumentException("scheme == null");
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(this.f6334a);
            sb.append("://");
            if (this.f6335b.indexOf(58) != -1) {
                sb.append('[');
                sb.append(this.f6335b);
                sb.append(']');
            } else {
                sb.append(this.f6335b);
            }
            int g5 = g();
            if (g5 != a.b(this.f6334a)) {
                sb.append(':');
                sb.append(g5);
            }
            return sb.toString();
        }
    }

    private a(b bVar) {
        this.f6330a = bVar.f6334a;
        this.f6331b = bVar.f6335b;
        this.f6332c = bVar.g();
        this.f6333d = bVar.toString();
    }

    static int a(char c5) {
        if (c5 < '0' || c5 > '9') {
            char c6 = 'a';
            if (c5 < 'a' || c5 > 'f') {
                c6 = 'A';
                if (c5 < 'A' || c5 > 'F') {
                    return -1;
                }
            }
            return (c5 - c6) + 10;
        }
        return c5 - '0';
    }

    public static int b(String str) {
        if (str.equals("http")) {
            return 80;
        }
        return str.equals("https") ? 443 : -1;
    }

    static String d(String str, int i5, int i6, boolean z4) {
        for (int i7 = i5; i7 < i6; i7++) {
            char charAt = str.charAt(i7);
            if (charAt == '%' || (charAt == '+' && z4)) {
                c cVar = new c();
                cVar.h0(str, i5, i7);
                e(cVar, str, i7, i6, z4);
                return cVar.A();
            }
        }
        return str.substring(i5, i6);
    }

    static void e(c cVar, String str, int i5, int i6, boolean z4) {
        int i7;
        while (i5 < i6) {
            int codePointAt = str.codePointAt(i5);
            if (codePointAt != 37 || (i7 = i5 + 2) >= i6) {
                if (codePointAt == 43 && z4) {
                    cVar.writeByte(32);
                }
                cVar.i0(codePointAt);
            } else {
                int a5 = a(str.charAt(i5 + 1));
                int a6 = a(str.charAt(i7));
                if (a5 != -1 && a6 != -1) {
                    cVar.writeByte((a5 << 4) + a6);
                    i5 = i7;
                }
                cVar.i0(codePointAt);
            }
            i5 += Character.charCount(codePointAt);
        }
    }

    public String c() {
        return this.f6331b;
    }

    public boolean equals(Object obj) {
        return (obj instanceof a) && ((a) obj).f6333d.equals(this.f6333d);
    }

    public int f() {
        return this.f6332c;
    }

    public int hashCode() {
        return this.f6333d.hashCode();
    }

    public String toString() {
        return this.f6333d;
    }
}
