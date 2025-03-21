package k2;

import i2.a0;
import i2.d0;
import java.io.Closeable;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;
import java.util.Objects;
/* loaded from: classes.dex */
public class a implements Closeable {

    /* renamed from: a  reason: collision with root package name */
    private final Reader f5622a;

    /* renamed from: m  reason: collision with root package name */
    private long f5630m;

    /* renamed from: n  reason: collision with root package name */
    private int f5631n;

    /* renamed from: o  reason: collision with root package name */
    private String f5632o;

    /* renamed from: p  reason: collision with root package name */
    private int[] f5633p;

    /* renamed from: r  reason: collision with root package name */
    private String[] f5635r;

    /* renamed from: s  reason: collision with root package name */
    private int[] f5636s;

    /* renamed from: b  reason: collision with root package name */
    private boolean f5623b = false;

    /* renamed from: c  reason: collision with root package name */
    private final char[] f5624c = new char[1024];

    /* renamed from: d  reason: collision with root package name */
    private int f5625d = 0;

    /* renamed from: e  reason: collision with root package name */
    private int f5626e = 0;

    /* renamed from: f  reason: collision with root package name */
    private int f5627f = 0;

    /* renamed from: k  reason: collision with root package name */
    private int f5628k = 0;

    /* renamed from: l  reason: collision with root package name */
    int f5629l = 0;

    /* renamed from: q  reason: collision with root package name */
    private int f5634q = 0 + 1;

    /* renamed from: k2.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    class C0083a extends j2.a {
        C0083a() {
        }
    }

    static {
        j2.a.f5517a = new C0083a();
    }

    public a(Reader reader) {
        int[] iArr = new int[32];
        this.f5633p = iArr;
        iArr[0] = 6;
        this.f5635r = new String[32];
        this.f5636s = new int[32];
        Objects.requireNonNull(reader, "in == null");
        this.f5622a = reader;
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0053, code lost:
        if (r1 != '/') goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0055, code lost:
        r7.f5625d = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0058, code lost:
        if (r4 != r2) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x005a, code lost:
        r7.f5625d = r4 - 1;
        r2 = n(2);
        r7.f5625d++;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0067, code lost:
        if (r2 != false) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0069, code lost:
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x006a, code lost:
        g();
        r2 = r7.f5625d;
        r3 = r0[r2];
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0073, code lost:
        if (r3 == '*') goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0075, code lost:
        if (r3 == '/') goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0077, code lost:
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0078, code lost:
        r7.f5625d = r2 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0080, code lost:
        r7.f5625d = r2 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x008a, code lost:
        if (U("*\/") == false) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0097, code lost:
        throw c0("Unterminated comment");
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0098, code lost:
        r7.f5625d = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x009c, code lost:
        if (r1 != '#') goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x009e, code lost:
        g();
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00a2, code lost:
        return r1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private int D(boolean r8) {
        /*
            r7 = this;
            char[] r0 = r7.f5624c
        L2:
            int r1 = r7.f5625d
        L4:
            int r2 = r7.f5626e
        L6:
            r3 = 1
            if (r1 != r2) goto L34
            r7.f5625d = r1
            boolean r1 = r7.n(r3)
            if (r1 != 0) goto L30
            if (r8 != 0) goto L15
            r8 = -1
            return r8
        L15:
            java.io.EOFException r8 = new java.io.EOFException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "End of input"
            r0.append(r1)
            java.lang.String r1 = r7.w()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r8.<init>(r0)
            throw r8
        L30:
            int r1 = r7.f5625d
            int r2 = r7.f5626e
        L34:
            int r4 = r1 + 1
            char r1 = r0[r1]
            r5 = 10
            if (r1 != r5) goto L44
            int r1 = r7.f5627f
            int r1 = r1 + r3
            r7.f5627f = r1
            r7.f5628k = r4
            goto La3
        L44:
            r5 = 32
            if (r1 == r5) goto La3
            r5 = 13
            if (r1 == r5) goto La3
            r5 = 9
            if (r1 != r5) goto L51
            goto La3
        L51:
            r5 = 47
            if (r1 != r5) goto L98
            r7.f5625d = r4
            r6 = 2
            if (r4 != r2) goto L6a
            int r4 = r4 + (-1)
            r7.f5625d = r4
            boolean r2 = r7.n(r6)
            int r4 = r7.f5625d
            int r4 = r4 + r3
            r7.f5625d = r4
            if (r2 != 0) goto L6a
            return r1
        L6a:
            r7.g()
            int r2 = r7.f5625d
            char r3 = r0[r2]
            r4 = 42
            if (r3 == r4) goto L80
            if (r3 == r5) goto L78
            return r1
        L78:
            int r2 = r2 + 1
            r7.f5625d = r2
        L7c:
            r7.X()
            goto L2
        L80:
            int r2 = r2 + 1
            r7.f5625d = r2
        */
        //  java.lang.String r1 = "*/"
        /*
            boolean r1 = r7.U(r1)
            if (r1 == 0) goto L91
            int r1 = r7.f5625d
            int r1 = r1 + r6
            goto L4
        L91:
            java.lang.String r8 = "Unterminated comment"
            java.io.IOException r8 = r7.c0(r8)
            throw r8
        L98:
            r2 = 35
            r7.f5625d = r4
            if (r1 != r2) goto La2
            r7.g()
            goto L7c
        La2:
            return r1
        La3:
            r1 = r4
            goto L6
        */
        throw new UnsupportedOperationException("Method not decompiled: k2.a.D(boolean):int");
    }

    private String J(char c5) {
        char[] cArr = this.f5624c;
        StringBuilder sb = null;
        while (true) {
            int i5 = this.f5625d;
            int i6 = this.f5626e;
            while (true) {
                if (i5 < i6) {
                    int i7 = i5 + 1;
                    char c6 = cArr[i5];
                    if (c6 == c5) {
                        this.f5625d = i7;
                        int i8 = (i7 - i5) - 1;
                        if (sb == null) {
                            return new String(cArr, i5, i8);
                        }
                        sb.append(cArr, i5, i8);
                        return sb.toString();
                    } else if (c6 == '\\') {
                        this.f5625d = i7;
                        int i9 = (i7 - i5) - 1;
                        if (sb == null) {
                            sb = new StringBuilder(Math.max((i9 + 1) * 2, 16));
                        }
                        sb.append(cArr, i5, i9);
                        sb.append(S());
                    } else {
                        if (c6 == '\n') {
                            this.f5627f++;
                            this.f5628k = i7;
                        }
                        i5 = i7;
                    }
                } else {
                    if (sb == null) {
                        sb = new StringBuilder(Math.max((i5 - i5) * 2, 16));
                    }
                    sb.append(cArr, i5, i5 - i5);
                    this.f5625d = i5;
                    if (!n(1)) {
                        throw c0("Unterminated string");
                    }
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x004a, code lost:
        g();
     */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x008a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.lang.String L() {
        /*
            r6 = this;
            r0 = 0
            r1 = 0
        L2:
            r2 = 0
        L3:
            int r3 = r6.f5625d
            int r4 = r3 + r2
            int r5 = r6.f5626e
            if (r4 >= r5) goto L4e
            char[] r4 = r6.f5624c
            int r3 = r3 + r2
            char r3 = r4[r3]
            r4 = 9
            if (r3 == r4) goto L5c
            r4 = 10
            if (r3 == r4) goto L5c
            r4 = 12
            if (r3 == r4) goto L5c
            r4 = 13
            if (r3 == r4) goto L5c
            r4 = 32
            if (r3 == r4) goto L5c
            r4 = 35
            if (r3 == r4) goto L4a
            r4 = 44
            if (r3 == r4) goto L5c
            r4 = 47
            if (r3 == r4) goto L4a
            r4 = 61
            if (r3 == r4) goto L4a
            r4 = 123(0x7b, float:1.72E-43)
            if (r3 == r4) goto L5c
            r4 = 125(0x7d, float:1.75E-43)
            if (r3 == r4) goto L5c
            r4 = 58
            if (r3 == r4) goto L5c
            r4 = 59
            if (r3 == r4) goto L4a
            switch(r3) {
                case 91: goto L5c;
                case 92: goto L4a;
                case 93: goto L5c;
                default: goto L47;
            }
        L47:
            int r2 = r2 + 1
            goto L3
        L4a:
            r6.g()
            goto L5c
        L4e:
            char[] r3 = r6.f5624c
            int r3 = r3.length
            if (r2 >= r3) goto L5e
            int r3 = r2 + 1
            boolean r3 = r6.n(r3)
            if (r3 == 0) goto L5c
            goto L3
        L5c:
            r0 = r2
            goto L7e
        L5e:
            if (r1 != 0) goto L6b
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r3 = 16
            int r3 = java.lang.Math.max(r2, r3)
            r1.<init>(r3)
        L6b:
            char[] r3 = r6.f5624c
            int r4 = r6.f5625d
            r1.append(r3, r4, r2)
            int r3 = r6.f5625d
            int r3 = r3 + r2
            r6.f5625d = r3
            r2 = 1
            boolean r2 = r6.n(r2)
            if (r2 != 0) goto L2
        L7e:
            if (r1 != 0) goto L8a
            java.lang.String r1 = new java.lang.String
            char[] r2 = r6.f5624c
            int r3 = r6.f5625d
            r1.<init>(r2, r3, r0)
            goto L95
        L8a:
            char[] r2 = r6.f5624c
            int r3 = r6.f5625d
            r1.append(r2, r3, r0)
            java.lang.String r1 = r1.toString()
        L95:
            int r2 = r6.f5625d
            int r2 = r2 + r0
            r6.f5625d = r2
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: k2.a.L():java.lang.String");
    }

    private int N() {
        int i5;
        String str;
        String str2;
        char c5 = this.f5624c[this.f5625d];
        if (c5 == 't' || c5 == 'T') {
            i5 = 5;
            str = "true";
            str2 = "TRUE";
        } else if (c5 == 'f' || c5 == 'F') {
            i5 = 6;
            str = "false";
            str2 = "FALSE";
        } else if (c5 != 'n' && c5 != 'N') {
            return 0;
        } else {
            i5 = 7;
            str = "null";
            str2 = "NULL";
        }
        int length = str.length();
        for (int i6 = 1; i6 < length; i6++) {
            if (this.f5625d + i6 >= this.f5626e && !n(i6 + 1)) {
                return 0;
            }
            char c6 = this.f5624c[this.f5625d + i6];
            if (c6 != str.charAt(i6) && c6 != str2.charAt(i6)) {
                return 0;
            }
        }
        if ((this.f5625d + length < this.f5626e || n(length + 1)) && v(this.f5624c[this.f5625d + length])) {
            return 0;
        }
        this.f5625d += length;
        this.f5629l = i5;
        return i5;
    }

    /* JADX WARN: Code restructure failed: missing block: B:55:0x0095, code lost:
        if (v(r14) != false) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0097, code lost:
        if (r9 != 2) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0099, code lost:
        if (r10 == false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x009f, code lost:
        if (r11 != Long.MIN_VALUE) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00a1, code lost:
        if (r13 == false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00a7, code lost:
        if (r11 != 0) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00a9, code lost:
        if (r13 != false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00ab, code lost:
        if (r13 == false) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x00ae, code lost:
        r11 = -r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00af, code lost:
        r18.f5630m = r11;
        r18.f5625d += r8;
        r1 = 15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x00b8, code lost:
        r18.f5629l = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x00ba, code lost:
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x00bb, code lost:
        if (r9 == 2) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x00be, code lost:
        if (r9 == 4) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x00c1, code lost:
        if (r9 != 7) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x00c4, code lost:
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x00c6, code lost:
        r18.f5631n = r8;
        r1 = 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x00cb, code lost:
        return 0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private int O() {
        /*
            Method dump skipped, instructions count: 250
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: k2.a.O():int");
    }

    private void P(int i5) {
        int i6 = this.f5634q;
        int[] iArr = this.f5633p;
        if (i6 == iArr.length) {
            int i7 = i6 * 2;
            this.f5633p = Arrays.copyOf(iArr, i7);
            this.f5636s = Arrays.copyOf(this.f5636s, i7);
            this.f5635r = (String[]) Arrays.copyOf(this.f5635r, i7);
        }
        int[] iArr2 = this.f5633p;
        int i8 = this.f5634q;
        this.f5634q = i8 + 1;
        iArr2[i8] = i5;
    }

    private char S() {
        int i5;
        int i6;
        if (this.f5625d != this.f5626e || n(1)) {
            char[] cArr = this.f5624c;
            int i7 = this.f5625d;
            int i8 = i7 + 1;
            this.f5625d = i8;
            char c5 = cArr[i7];
            if (c5 == '\n') {
                this.f5627f++;
                this.f5628k = i8;
            } else if (c5 != '\"' && c5 != '\'' && c5 != '/' && c5 != '\\') {
                if (c5 != 'b') {
                    if (c5 != 'f') {
                        if (c5 != 'n') {
                            if (c5 != 'r') {
                                if (c5 != 't') {
                                    if (c5 == 'u') {
                                        if (i8 + 4 <= this.f5626e || n(4)) {
                                            char c6 = 0;
                                            int i9 = this.f5625d;
                                            int i10 = i9 + 4;
                                            while (i9 < i10) {
                                                char c7 = this.f5624c[i9];
                                                char c8 = (char) (c6 << 4);
                                                if (c7 < '0' || c7 > '9') {
                                                    if (c7 >= 'a' && c7 <= 'f') {
                                                        i5 = c7 - 'a';
                                                    } else if (c7 < 'A' || c7 > 'F') {
                                                        throw new NumberFormatException("\\u" + new String(this.f5624c, this.f5625d, 4));
                                                    } else {
                                                        i5 = c7 - 'A';
                                                    }
                                                    i6 = i5 + 10;
                                                } else {
                                                    i6 = c7 - '0';
                                                }
                                                c6 = (char) (c8 + i6);
                                                i9++;
                                            }
                                            this.f5625d += 4;
                                            return c6;
                                        }
                                        throw c0("Unterminated escape sequence");
                                    }
                                    throw c0("Invalid escape sequence");
                                }
                                return '\t';
                            }
                            return '\r';
                        }
                        return '\n';
                    }
                    return '\f';
                }
                return '\b';
            }
            return c5;
        }
        throw c0("Unterminated escape sequence");
    }

    private boolean U(String str) {
        int length = str.length();
        while (true) {
            if (this.f5625d + length > this.f5626e && !n(length)) {
                return false;
            }
            char[] cArr = this.f5624c;
            int i5 = this.f5625d;
            if (cArr[i5] != '\n') {
                for (int i6 = 0; i6 < length; i6++) {
                    if (this.f5624c[this.f5625d + i6] != str.charAt(i6)) {
                        break;
                    }
                }
                return true;
            }
            this.f5627f++;
            this.f5628k = i5 + 1;
            this.f5625d++;
        }
    }

    private void X() {
        char c5;
        do {
            if (this.f5625d >= this.f5626e && !n(1)) {
                return;
            }
            char[] cArr = this.f5624c;
            int i5 = this.f5625d;
            int i6 = i5 + 1;
            this.f5625d = i6;
            c5 = cArr[i5];
            if (c5 == '\n') {
                this.f5627f++;
                this.f5628k = i6;
                return;
            }
        } while (c5 != '\r');
    }

    private IOException c0(String str) {
        throw new c(str + w());
    }

    private void g() {
        if (!this.f5623b) {
            throw c0("Use JsonReader.setLenient(true) to accept malformed JSON");
        }
    }

    private void h() {
        D(true);
        int i5 = this.f5625d - 1;
        this.f5625d = i5;
        if (i5 + 5 <= this.f5626e || n(5)) {
            int i6 = this.f5625d;
            char[] cArr = this.f5624c;
            if (cArr[i6] == ')' && cArr[i6 + 1] == ']' && cArr[i6 + 2] == '}' && cArr[i6 + 3] == '\'' && cArr[i6 + 4] == '\n') {
                this.f5625d = i6 + 5;
            }
        }
    }

    private boolean n(int i5) {
        int i6;
        int i7;
        char[] cArr = this.f5624c;
        int i8 = this.f5628k;
        int i9 = this.f5625d;
        this.f5628k = i8 - i9;
        int i10 = this.f5626e;
        if (i10 != i9) {
            int i11 = i10 - i9;
            this.f5626e = i11;
            System.arraycopy(cArr, i9, cArr, 0, i11);
        } else {
            this.f5626e = 0;
        }
        this.f5625d = 0;
        do {
            Reader reader = this.f5622a;
            int i12 = this.f5626e;
            int read = reader.read(cArr, i12, cArr.length - i12);
            if (read == -1) {
                return false;
            }
            i6 = this.f5626e + read;
            this.f5626e = i6;
            if (this.f5627f == 0 && (i7 = this.f5628k) == 0 && i6 > 0 && cArr[0] == 65279) {
                this.f5625d++;
                this.f5628k = i7 + 1;
                i5++;
                continue;
            }
        } while (i6 < i5);
        return true;
    }

    private String r(boolean z4) {
        StringBuilder sb = new StringBuilder();
        sb.append('$');
        int i5 = 0;
        while (true) {
            int i6 = this.f5634q;
            if (i5 >= i6) {
                return sb.toString();
            }
            int i7 = this.f5633p[i5];
            if (i7 == 1 || i7 == 2) {
                int i8 = this.f5636s[i5];
                if (z4 && i8 > 0 && i5 == i6 - 1) {
                    i8--;
                }
                sb.append('[');
                sb.append(i8);
                sb.append(']');
            } else if (i7 == 3 || i7 == 4 || i7 == 5) {
                sb.append('.');
                String str = this.f5635r[i5];
                if (str != null) {
                    sb.append(str);
                }
            }
            i5++;
        }
    }

    private boolean v(char c5) {
        if (c5 == '\t' || c5 == '\n' || c5 == '\f' || c5 == '\r' || c5 == ' ') {
            return false;
        }
        if (c5 != '#') {
            if (c5 == ',') {
                return false;
            }
            if (c5 != '/' && c5 != '=') {
                if (c5 == '{' || c5 == '}' || c5 == ':') {
                    return false;
                }
                if (c5 != ';') {
                    switch (c5) {
                        case '[':
                        case ']':
                            return false;
                        case '\\':
                            break;
                        default:
                            return true;
                    }
                }
            }
        }
        g();
        return false;
    }

    public String A() {
        char c5;
        String J;
        int i5 = this.f5629l;
        if (i5 == 0) {
            i5 = i();
        }
        if (i5 == 14) {
            J = L();
        } else {
            if (i5 == 12) {
                c5 = '\'';
            } else if (i5 != 13) {
                throw new IllegalStateException("Expected a name but was " + M() + w());
            } else {
                c5 = '\"';
            }
            J = J(c5);
        }
        this.f5629l = 0;
        this.f5635r[this.f5634q - 1] = J;
        return J;
    }

    public void I() {
        int i5 = this.f5629l;
        if (i5 == 0) {
            i5 = i();
        }
        if (i5 == 7) {
            this.f5629l = 0;
            int[] iArr = this.f5636s;
            int i6 = this.f5634q - 1;
            iArr[i6] = iArr[i6] + 1;
            return;
        }
        throw new IllegalStateException("Expected null but was " + M() + w());
    }

    public String K() {
        String str;
        char c5;
        int i5 = this.f5629l;
        if (i5 == 0) {
            i5 = i();
        }
        if (i5 == 10) {
            str = L();
        } else {
            if (i5 == 8) {
                c5 = '\'';
            } else if (i5 == 9) {
                c5 = '\"';
            } else if (i5 == 11) {
                str = this.f5632o;
                this.f5632o = null;
            } else if (i5 == 15) {
                str = Long.toString(this.f5630m);
            } else if (i5 != 16) {
                throw new IllegalStateException("Expected a string but was " + M() + w());
            } else {
                str = new String(this.f5624c, this.f5625d, this.f5631n);
                this.f5625d += this.f5631n;
            }
            str = J(c5);
        }
        this.f5629l = 0;
        int[] iArr = this.f5636s;
        int i6 = this.f5634q - 1;
        iArr[i6] = iArr[i6] + 1;
        return str;
    }

    public b M() {
        int i5 = this.f5629l;
        if (i5 == 0) {
            i5 = i();
        }
        switch (i5) {
            case 1:
                return b.BEGIN_OBJECT;
            case 2:
                return b.END_OBJECT;
            case 3:
                return b.BEGIN_ARRAY;
            case 4:
                return b.END_ARRAY;
            case 5:
            case 6:
                return b.BOOLEAN;
            case 7:
                return b.NULL;
            case 8:
            case d0.ARRAY_VALUE_FIELD_NUMBER /* 9 */:
            case d0.TIMESTAMP_VALUE_FIELD_NUMBER /* 10 */:
            case 11:
                return b.STRING;
            case a0.EXPECTED_COUNT_FIELD_NUMBER /* 12 */:
            case 13:
            case 14:
                return b.NAME;
            case 15:
            case 16:
                return b.NUMBER;
            case d0.STRING_VALUE_FIELD_NUMBER /* 17 */:
                return b.END_DOCUMENT;
            default:
                throw new AssertionError();
        }
    }

    public void c() {
        int i5 = this.f5629l;
        if (i5 == 0) {
            i5 = i();
        }
        if (i5 == 3) {
            P(1);
            this.f5636s[this.f5634q - 1] = 0;
            this.f5629l = 0;
            return;
        }
        throw new IllegalStateException("Expected BEGIN_ARRAY but was " + M() + w());
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f5629l = 0;
        this.f5633p[0] = 8;
        this.f5634q = 1;
        this.f5622a.close();
    }

    public void d() {
        int i5 = this.f5629l;
        if (i5 == 0) {
            i5 = i();
        }
        if (i5 == 1) {
            P(3);
            this.f5629l = 0;
            return;
        }
        throw new IllegalStateException("Expected BEGIN_OBJECT but was " + M() + w());
    }

    int i() {
        int i5;
        int D;
        int[] iArr = this.f5633p;
        int i6 = this.f5634q;
        int i7 = iArr[i6 - 1];
        if (i7 == 1) {
            iArr[i6 - 1] = 2;
        } else if (i7 != 2) {
            if (i7 == 3 || i7 == 5) {
                iArr[i6 - 1] = 4;
                if (i7 == 5 && (D = D(true)) != 44) {
                    if (D != 59) {
                        if (D == 125) {
                            this.f5629l = 2;
                            return 2;
                        }
                        throw c0("Unterminated object");
                    }
                    g();
                }
                int D2 = D(true);
                if (D2 == 34) {
                    i5 = 13;
                } else if (D2 == 39) {
                    g();
                    i5 = 12;
                } else if (D2 == 125) {
                    if (i7 != 5) {
                        this.f5629l = 2;
                        return 2;
                    }
                    throw c0("Expected name");
                } else {
                    g();
                    this.f5625d--;
                    if (!v((char) D2)) {
                        throw c0("Expected name");
                    }
                    i5 = 14;
                }
            } else if (i7 == 4) {
                iArr[i6 - 1] = 5;
                int D3 = D(true);
                if (D3 != 58) {
                    if (D3 != 61) {
                        throw c0("Expected ':'");
                    }
                    g();
                    if (this.f5625d < this.f5626e || n(1)) {
                        char[] cArr = this.f5624c;
                        int i8 = this.f5625d;
                        if (cArr[i8] == '>') {
                            this.f5625d = i8 + 1;
                        }
                    }
                }
            } else if (i7 == 6) {
                if (this.f5623b) {
                    h();
                }
                this.f5633p[this.f5634q - 1] = 7;
            } else if (i7 == 7) {
                if (D(false) == -1) {
                    i5 = 17;
                } else {
                    g();
                    this.f5625d--;
                }
            } else if (i7 == 8) {
                throw new IllegalStateException("JsonReader is closed");
            }
            this.f5629l = i5;
            return i5;
        } else {
            int D4 = D(true);
            if (D4 != 44) {
                if (D4 != 59) {
                    if (D4 == 93) {
                        this.f5629l = 4;
                        return 4;
                    }
                    throw c0("Unterminated array");
                }
                g();
            }
        }
        int D5 = D(true);
        if (D5 != 34) {
            if (D5 == 39) {
                g();
                this.f5629l = 8;
                return 8;
            }
            if (D5 != 44 && D5 != 59) {
                if (D5 == 91) {
                    this.f5629l = 3;
                    return 3;
                } else if (D5 != 93) {
                    if (D5 == 123) {
                        this.f5629l = 1;
                        return 1;
                    }
                    this.f5625d--;
                    int N = N();
                    if (N != 0) {
                        return N;
                    }
                    int O = O();
                    if (O != 0) {
                        return O;
                    }
                    if (!v(this.f5624c[this.f5625d])) {
                        throw c0("Expected value");
                    }
                    g();
                    i5 = 10;
                } else if (i7 == 1) {
                    this.f5629l = 4;
                    return 4;
                }
            }
            if (i7 == 1 || i7 == 2) {
                g();
                this.f5625d--;
                this.f5629l = 7;
                return 7;
            }
            throw c0("Unexpected value");
        }
        i5 = 9;
        this.f5629l = i5;
        return i5;
    }

    public void j() {
        int i5 = this.f5629l;
        if (i5 == 0) {
            i5 = i();
        }
        if (i5 != 4) {
            throw new IllegalStateException("Expected END_ARRAY but was " + M() + w());
        }
        int i6 = this.f5634q - 1;
        this.f5634q = i6;
        int[] iArr = this.f5636s;
        int i7 = i6 - 1;
        iArr[i7] = iArr[i7] + 1;
        this.f5629l = 0;
    }

    public void l() {
        int i5 = this.f5629l;
        if (i5 == 0) {
            i5 = i();
        }
        if (i5 != 2) {
            throw new IllegalStateException("Expected END_OBJECT but was " + M() + w());
        }
        int i6 = this.f5634q - 1;
        this.f5634q = i6;
        this.f5635r[i6] = null;
        int[] iArr = this.f5636s;
        int i7 = i6 - 1;
        iArr[i7] = iArr[i7] + 1;
        this.f5629l = 0;
    }

    public String p() {
        return r(false);
    }

    public String toString() {
        return getClass().getSimpleName() + w();
    }

    public boolean u() {
        int i5 = this.f5629l;
        if (i5 == 0) {
            i5 = i();
        }
        return (i5 == 2 || i5 == 4 || i5 == 17) ? false : true;
    }

    String w() {
        return " at line " + (this.f5627f + 1) + " column " + ((this.f5625d - this.f5628k) + 1) + " path " + p();
    }

    public boolean x() {
        int i5 = this.f5629l;
        if (i5 == 0) {
            i5 = i();
        }
        if (i5 == 5) {
            this.f5629l = 0;
            int[] iArr = this.f5636s;
            int i6 = this.f5634q - 1;
            iArr[i6] = iArr[i6] + 1;
            return true;
        } else if (i5 == 6) {
            this.f5629l = 0;
            int[] iArr2 = this.f5636s;
            int i7 = this.f5634q - 1;
            iArr2[i7] = iArr2[i7] + 1;
            return false;
        } else {
            throw new IllegalStateException("Expected a boolean but was " + M() + w());
        }
    }

    public double z() {
        String J;
        int i5 = this.f5629l;
        if (i5 == 0) {
            i5 = i();
        }
        if (i5 == 15) {
            this.f5629l = 0;
            int[] iArr = this.f5636s;
            int i6 = this.f5634q - 1;
            iArr[i6] = iArr[i6] + 1;
            return this.f5630m;
        }
        if (i5 == 16) {
            this.f5632o = new String(this.f5624c, this.f5625d, this.f5631n);
            this.f5625d += this.f5631n;
        } else {
            if (i5 == 8 || i5 == 9) {
                J = J(i5 == 8 ? '\'' : '\"');
            } else if (i5 == 10) {
                J = L();
            } else if (i5 != 11) {
                throw new IllegalStateException("Expected a double but was " + M() + w());
            }
            this.f5632o = J;
        }
        this.f5629l = 11;
        double parseDouble = Double.parseDouble(this.f5632o);
        if (!this.f5623b && (Double.isNaN(parseDouble) || Double.isInfinite(parseDouble))) {
            throw new c("JSON forbids NaN and infinities: " + parseDouble + w());
        }
        this.f5632o = null;
        this.f5629l = 0;
        int[] iArr2 = this.f5636s;
        int i7 = this.f5634q - 1;
        iArr2[i7] = iArr2[i7] + 1;
        return parseDouble;
    }
}
