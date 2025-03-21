package l3;

import javax.security.auth.x500.X500Principal;
/* loaded from: classes.dex */
final class d {

    /* renamed from: a  reason: collision with root package name */
    private final String f5976a;

    /* renamed from: b  reason: collision with root package name */
    private final int f5977b;

    /* renamed from: c  reason: collision with root package name */
    private int f5978c;

    /* renamed from: d  reason: collision with root package name */
    private int f5979d;

    /* renamed from: e  reason: collision with root package name */
    private int f5980e;

    /* renamed from: f  reason: collision with root package name */
    private int f5981f;

    /* renamed from: g  reason: collision with root package name */
    private char[] f5982g;

    public d(X500Principal x500Principal) {
        String name = x500Principal.getName("RFC2253");
        this.f5976a = name;
        this.f5977b = name.length();
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x004d, code lost:
        r2 = r8.f5979d;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0057, code lost:
        return new java.lang.String(r1, r2, r8.f5980e - r2);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.lang.String a() {
        /*
            r8 = this;
            int r0 = r8.f5978c
            r8.f5979d = r0
            r8.f5980e = r0
        L6:
            int r0 = r8.f5978c
            int r1 = r8.f5977b
            if (r0 < r1) goto L19
            java.lang.String r0 = new java.lang.String
            char[] r1 = r8.f5982g
            int r2 = r8.f5979d
            int r3 = r8.f5980e
            int r3 = r3 - r2
            r0.<init>(r1, r2, r3)
            return r0
        L19:
            char[] r1 = r8.f5982g
            char r2 = r1[r0]
            r3 = 44
            r4 = 43
            r5 = 59
            r6 = 32
            if (r2 == r6) goto L58
            if (r2 == r5) goto L4d
            r5 = 92
            if (r2 == r5) goto L3a
            if (r2 == r4) goto L4d
            if (r2 == r3) goto L4d
            int r3 = r8.f5980e
            int r4 = r3 + 1
            r8.f5980e = r4
            r1[r3] = r2
            goto L48
        L3a:
            int r0 = r8.f5980e
            int r2 = r0 + 1
            r8.f5980e = r2
            char r2 = r8.d()
            r1[r0] = r2
            int r0 = r8.f5978c
        L48:
            int r0 = r0 + 1
            r8.f5978c = r0
            goto L6
        L4d:
            java.lang.String r0 = new java.lang.String
            int r2 = r8.f5979d
            int r3 = r8.f5980e
            int r3 = r3 - r2
            r0.<init>(r1, r2, r3)
            return r0
        L58:
            int r2 = r8.f5980e
            r8.f5981f = r2
            int r0 = r0 + 1
            r8.f5978c = r0
            int r0 = r2 + 1
            r8.f5980e = r0
            r1[r2] = r6
        L66:
            int r0 = r8.f5978c
            int r1 = r8.f5977b
            if (r0 >= r1) goto L7f
            char[] r2 = r8.f5982g
            char r7 = r2[r0]
            if (r7 != r6) goto L7f
            int r1 = r8.f5980e
            int r7 = r1 + 1
            r8.f5980e = r7
            r2[r1] = r6
            int r0 = r0 + 1
            r8.f5978c = r0
            goto L66
        L7f:
            if (r0 == r1) goto L8b
            char[] r1 = r8.f5982g
            char r0 = r1[r0]
            if (r0 == r3) goto L8b
            if (r0 == r4) goto L8b
            if (r0 != r5) goto L6
        L8b:
            java.lang.String r0 = new java.lang.String
            char[] r1 = r8.f5982g
            int r2 = r8.f5979d
            int r3 = r8.f5981f
            int r3 = r3 - r2
            r0.<init>(r1, r2, r3)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: l3.d.a():java.lang.String");
    }

    private int c(int i5) {
        int i6;
        int i7;
        int i8 = i5 + 1;
        if (i8 >= this.f5977b) {
            throw new IllegalStateException("Malformed DN: " + this.f5976a);
        }
        char[] cArr = this.f5982g;
        char c5 = cArr[i5];
        if (c5 >= '0' && c5 <= '9') {
            i6 = c5 - '0';
        } else if (c5 >= 'a' && c5 <= 'f') {
            i6 = c5 - 'W';
        } else if (c5 < 'A' || c5 > 'F') {
            throw new IllegalStateException("Malformed DN: " + this.f5976a);
        } else {
            i6 = c5 - '7';
        }
        char c6 = cArr[i8];
        if (c6 >= '0' && c6 <= '9') {
            i7 = c6 - '0';
        } else if (c6 >= 'a' && c6 <= 'f') {
            i7 = c6 - 'W';
        } else if (c6 < 'A' || c6 > 'F') {
            throw new IllegalStateException("Malformed DN: " + this.f5976a);
        } else {
            i7 = c6 - '7';
        }
        return (i6 << 4) + i7;
    }

    private char d() {
        int i5 = this.f5978c + 1;
        this.f5978c = i5;
        if (i5 == this.f5977b) {
            throw new IllegalStateException("Unexpected end of DN: " + this.f5976a);
        }
        char c5 = this.f5982g[i5];
        if (c5 == ' ' || c5 == '%' || c5 == '\\' || c5 == '_' || c5 == '\"' || c5 == '#') {
            return c5;
        }
        switch (c5) {
            case '*':
            case '+':
            case ',':
                return c5;
            default:
                switch (c5) {
                    case ';':
                    case '<':
                    case '=':
                    case '>':
                        return c5;
                    default:
                        return e();
                }
        }
    }

    private char e() {
        int i5;
        int i6;
        int c5 = c(this.f5978c);
        this.f5978c++;
        if (c5 < 128) {
            return (char) c5;
        }
        if (c5 < 192 || c5 > 247) {
            return '?';
        }
        if (c5 <= 223) {
            i6 = c5 & 31;
            i5 = 1;
        } else if (c5 <= 239) {
            i5 = 2;
            i6 = c5 & 15;
        } else {
            i5 = 3;
            i6 = c5 & 7;
        }
        for (int i7 = 0; i7 < i5; i7++) {
            int i8 = this.f5978c + 1;
            this.f5978c = i8;
            if (i8 == this.f5977b || this.f5982g[i8] != '\\') {
                return '?';
            }
            int i9 = i8 + 1;
            this.f5978c = i9;
            int c6 = c(i9);
            this.f5978c++;
            if ((c6 & 192) != 128) {
                return '?';
            }
            i6 = (i6 << 6) + (c6 & 63);
        }
        return (char) i6;
    }

    private String f() {
        char[] cArr;
        char c5;
        int i5 = this.f5978c;
        if (i5 + 4 >= this.f5977b) {
            throw new IllegalStateException("Unexpected end of DN: " + this.f5976a);
        }
        this.f5979d = i5;
        while (true) {
            this.f5978c = i5 + 1;
            i5 = this.f5978c;
            if (i5 == this.f5977b || (c5 = (cArr = this.f5982g)[i5]) == '+' || c5 == ',' || c5 == ';') {
                break;
            } else if (c5 == ' ') {
                this.f5980e = i5;
                do {
                    this.f5978c = i5 + 1;
                    i5 = this.f5978c;
                    if (i5 >= this.f5977b) {
                        break;
                    }
                } while (this.f5982g[i5] == ' ');
            } else if (c5 >= 'A' && c5 <= 'F') {
                cArr[i5] = (char) (c5 + ' ');
            }
        }
        this.f5980e = i5;
        int i6 = this.f5980e;
        int i7 = this.f5979d;
        int i8 = i6 - i7;
        if (i8 < 5 || (i8 & 1) == 0) {
            throw new IllegalStateException("Unexpected end of DN: " + this.f5976a);
        }
        int i9 = i8 / 2;
        byte[] bArr = new byte[i9];
        int i10 = i7 + 1;
        for (int i11 = 0; i11 < i9; i11++) {
            bArr[i11] = (byte) c(i10);
            i10 += 2;
        }
        return new String(this.f5982g, this.f5979d, i8);
    }

    private String g() {
        int i5;
        int i6;
        int i7;
        char c5;
        int i8;
        int i9;
        char c6;
        char c7;
        while (true) {
            i5 = this.f5978c;
            i6 = this.f5977b;
            if (i5 >= i6 || this.f5982g[i5] != ' ') {
                break;
            }
            this.f5978c = i5 + 1;
        }
        if (i5 == i6) {
            return null;
        }
        this.f5979d = i5;
        do {
            this.f5978c = i5 + 1;
            i5 = this.f5978c;
            i7 = this.f5977b;
            if (i5 >= i7 || (c7 = this.f5982g[i5]) == '=') {
                break;
            }
        } while (c7 != ' ');
        if (i5 >= i7) {
            throw new IllegalStateException("Unexpected end of DN: " + this.f5976a);
        }
        this.f5980e = i5;
        if (this.f5982g[i5] == ' ') {
            while (true) {
                i8 = this.f5978c;
                i9 = this.f5977b;
                if (i8 >= i9 || (c6 = this.f5982g[i8]) == '=' || c6 != ' ') {
                    break;
                }
                this.f5978c = i8 + 1;
            }
            if (this.f5982g[i8] != '=' || i8 == i9) {
                throw new IllegalStateException("Unexpected end of DN: " + this.f5976a);
            }
        }
        int i10 = this.f5978c;
        do {
            this.f5978c = i10 + 1;
            i10 = this.f5978c;
            if (i10 >= this.f5977b) {
                break;
            }
        } while (this.f5982g[i10] == ' ');
        int i11 = this.f5980e;
        int i12 = this.f5979d;
        if (i11 - i12 > 4) {
            char[] cArr = this.f5982g;
            if (cArr[i12 + 3] == '.' && (((c5 = cArr[i12]) == 'O' || c5 == 'o') && ((cArr[i12 + 1] == 'I' || cArr[i12 + 1] == 'i') && (cArr[i12 + 2] == 'D' || cArr[i12 + 2] == 'd')))) {
                this.f5979d = i12 + 4;
            }
        }
        char[] cArr2 = this.f5982g;
        int i13 = this.f5979d;
        return new String(cArr2, i13, i11 - i13);
    }

    private String h() {
        int i5 = this.f5978c + 1;
        this.f5978c = i5;
        this.f5979d = i5;
        while (true) {
            this.f5980e = i5;
            int i6 = this.f5978c;
            if (i6 == this.f5977b) {
                throw new IllegalStateException("Unexpected end of DN: " + this.f5976a);
            }
            char[] cArr = this.f5982g;
            char c5 = cArr[i6];
            if (c5 == '\"') {
                do {
                    this.f5978c = i6 + 1;
                    i6 = this.f5978c;
                    if (i6 >= this.f5977b) {
                        break;
                    }
                } while (this.f5982g[i6] == ' ');
                char[] cArr2 = this.f5982g;
                int i7 = this.f5979d;
                return new String(cArr2, i7, this.f5980e - i7);
            }
            if (c5 == '\\') {
                cArr[this.f5980e] = d();
            } else {
                cArr[this.f5980e] = c5;
            }
            this.f5978c++;
            i5 = this.f5980e + 1;
        }
    }

    public String b(String str) {
        this.f5978c = 0;
        this.f5979d = 0;
        this.f5980e = 0;
        this.f5981f = 0;
        this.f5982g = this.f5976a.toCharArray();
        String g5 = g();
        if (g5 == null) {
            return null;
        }
        do {
            int i5 = this.f5978c;
            if (i5 == this.f5977b) {
                return null;
            }
            char c5 = this.f5982g[i5];
            String a5 = c5 != '\"' ? c5 != '#' ? (c5 == '+' || c5 == ',' || c5 == ';') ? "" : a() : f() : h();
            if (str.equalsIgnoreCase(g5)) {
                return a5;
            }
            int i6 = this.f5978c;
            if (i6 >= this.f5977b) {
                return null;
            }
            char c6 = this.f5982g[i6];
            if (c6 != ',' && c6 != ';' && c6 != '+') {
                throw new IllegalStateException("Malformed DN: " + this.f5976a);
            }
            this.f5978c = i6 + 1;
            g5 = g();
        } while (g5 != null);
        throw new IllegalStateException("Malformed DN: " + this.f5976a);
    }
}
