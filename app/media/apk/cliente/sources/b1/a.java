package b1;

import java.io.IOException;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Objects;
import z0.k;
/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    private static final a f736a = new c("base64()", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", '=');

    /* renamed from: b  reason: collision with root package name */
    private static final a f737b = new c("base64Url()", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_", '=');

    /* renamed from: c  reason: collision with root package name */
    private static final a f738c = new e("base32()", "ABCDEFGHIJKLMNOPQRSTUVWXYZ234567", '=');

    /* renamed from: d  reason: collision with root package name */
    private static final a f739d = new e("base32Hex()", "0123456789ABCDEFGHIJKLMNOPQRSTUV", '=');

    /* renamed from: e  reason: collision with root package name */
    private static final a f740e = new b("base16()", "0123456789ABCDEF");

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b1.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0027a {

        /* renamed from: a  reason: collision with root package name */
        private final String f741a;

        /* renamed from: b  reason: collision with root package name */
        private final char[] f742b;

        /* renamed from: c  reason: collision with root package name */
        final int f743c;

        /* renamed from: d  reason: collision with root package name */
        final int f744d;

        /* renamed from: e  reason: collision with root package name */
        final int f745e;

        /* renamed from: f  reason: collision with root package name */
        final int f746f;

        /* renamed from: g  reason: collision with root package name */
        private final byte[] f747g;

        /* renamed from: h  reason: collision with root package name */
        private final boolean[] f748h;

        /* renamed from: i  reason: collision with root package name */
        private final boolean f749i;

        C0027a(String str, char[] cArr) {
            this(str, cArr, b(cArr), false);
        }

        private C0027a(String str, char[] cArr, byte[] bArr, boolean z4) {
            this.f741a = (String) k.n(str);
            this.f742b = (char[]) k.n(cArr);
            try {
                int d5 = c1.a.d(cArr.length, RoundingMode.UNNECESSARY);
                this.f744d = d5;
                int numberOfTrailingZeros = Integer.numberOfTrailingZeros(d5);
                int i5 = 1 << (3 - numberOfTrailingZeros);
                this.f745e = i5;
                this.f746f = d5 >> numberOfTrailingZeros;
                this.f743c = cArr.length - 1;
                this.f747g = bArr;
                boolean[] zArr = new boolean[i5];
                for (int i6 = 0; i6 < this.f746f; i6++) {
                    zArr[c1.a.a(i6 * 8, this.f744d, RoundingMode.CEILING)] = true;
                }
                this.f748h = zArr;
                this.f749i = z4;
            } catch (ArithmeticException e5) {
                throw new IllegalArgumentException("Illegal alphabet length " + cArr.length, e5);
            }
        }

        private static byte[] b(char[] cArr) {
            byte[] bArr = new byte[128];
            Arrays.fill(bArr, (byte) -1);
            for (int i5 = 0; i5 < cArr.length; i5++) {
                char c5 = cArr[i5];
                boolean z4 = true;
                k.f(c5 < 128, "Non-ASCII character: %s", c5);
                if (bArr[c5] != -1) {
                    z4 = false;
                }
                k.f(z4, "Duplicate character: %s", c5);
                bArr[c5] = (byte) i5;
            }
            return bArr;
        }

        int c(char c5) {
            if (c5 > 127) {
                throw new d("Unrecognized character: 0x" + Integer.toHexString(c5));
            }
            byte b5 = this.f747g[c5];
            if (b5 == -1) {
                if (c5 <= ' ' || c5 == 127) {
                    throw new d("Unrecognized character: 0x" + Integer.toHexString(c5));
                }
                throw new d("Unrecognized character: " + c5);
            }
            return b5;
        }

        char d(int i5) {
            return this.f742b[i5];
        }

        boolean e(int i5) {
            return this.f748h[i5 % this.f745e];
        }

        public boolean equals(Object obj) {
            if (obj instanceof C0027a) {
                C0027a c0027a = (C0027a) obj;
                return this.f749i == c0027a.f749i && Arrays.equals(this.f742b, c0027a.f742b);
            }
            return false;
        }

        public boolean f(char c5) {
            byte[] bArr = this.f747g;
            return c5 < bArr.length && bArr[c5] != -1;
        }

        public int hashCode() {
            return Arrays.hashCode(this.f742b) + (this.f749i ? 1231 : 1237);
        }

        public String toString() {
            return this.f741a;
        }
    }

    /* loaded from: classes.dex */
    static final class b extends e {

        /* renamed from: h  reason: collision with root package name */
        final char[] f750h;

        private b(C0027a c0027a) {
            super(c0027a, null);
            this.f750h = new char[512];
            k.d(c0027a.f742b.length == 16);
            for (int i5 = 0; i5 < 256; i5++) {
                this.f750h[i5] = c0027a.d(i5 >>> 4);
                this.f750h[i5 | 256] = c0027a.d(i5 & 15);
            }
        }

        b(String str, String str2) {
            this(new C0027a(str, str2.toCharArray()));
        }

        @Override // b1.a.e, b1.a
        int d(byte[] bArr, CharSequence charSequence) {
            k.n(bArr);
            if (charSequence.length() % 2 == 1) {
                throw new d("Invalid input length " + charSequence.length());
            }
            int i5 = 0;
            int i6 = 0;
            while (i5 < charSequence.length()) {
                bArr[i6] = (byte) ((this.f751f.c(charSequence.charAt(i5)) << 4) | this.f751f.c(charSequence.charAt(i5 + 1)));
                i5 += 2;
                i6++;
            }
            return i6;
        }

        @Override // b1.a.e, b1.a
        void g(Appendable appendable, byte[] bArr, int i5, int i6) {
            k.n(appendable);
            k.s(i5, i5 + i6, bArr.length);
            for (int i7 = 0; i7 < i6; i7++) {
                int i8 = bArr[i5 + i7] & 255;
                appendable.append(this.f750h[i8]);
                appendable.append(this.f750h[i8 | 256]);
            }
        }

        @Override // b1.a.e
        a n(C0027a c0027a, Character ch) {
            return new b(c0027a);
        }
    }

    /* loaded from: classes.dex */
    static final class c extends e {
        private c(C0027a c0027a, Character ch) {
            super(c0027a, ch);
            k.d(c0027a.f742b.length == 64);
        }

        c(String str, String str2, Character ch) {
            this(new C0027a(str, str2.toCharArray()), ch);
        }

        @Override // b1.a.e, b1.a
        int d(byte[] bArr, CharSequence charSequence) {
            k.n(bArr);
            CharSequence l5 = l(charSequence);
            if (!this.f751f.e(l5.length())) {
                throw new d("Invalid input length " + l5.length());
            }
            int i5 = 0;
            int i6 = 0;
            while (i5 < l5.length()) {
                int i7 = i5 + 1;
                int i8 = i7 + 1;
                int c5 = (this.f751f.c(l5.charAt(i5)) << 18) | (this.f751f.c(l5.charAt(i7)) << 12);
                int i9 = i6 + 1;
                bArr[i6] = (byte) (c5 >>> 16);
                if (i8 < l5.length()) {
                    int i10 = i8 + 1;
                    int c6 = c5 | (this.f751f.c(l5.charAt(i8)) << 6);
                    i6 = i9 + 1;
                    bArr[i9] = (byte) ((c6 >>> 8) & 255);
                    if (i10 < l5.length()) {
                        i8 = i10 + 1;
                        i9 = i6 + 1;
                        bArr[i6] = (byte) ((c6 | this.f751f.c(l5.charAt(i10))) & 255);
                    } else {
                        i5 = i10;
                    }
                }
                i6 = i9;
                i5 = i8;
            }
            return i6;
        }

        @Override // b1.a.e, b1.a
        void g(Appendable appendable, byte[] bArr, int i5, int i6) {
            k.n(appendable);
            int i7 = i5 + i6;
            k.s(i5, i7, bArr.length);
            while (i6 >= 3) {
                int i8 = i5 + 1;
                int i9 = i8 + 1;
                int i10 = ((bArr[i5] & 255) << 16) | ((bArr[i8] & 255) << 8) | (bArr[i9] & 255);
                appendable.append(this.f751f.d(i10 >>> 18));
                appendable.append(this.f751f.d((i10 >>> 12) & 63));
                appendable.append(this.f751f.d((i10 >>> 6) & 63));
                appendable.append(this.f751f.d(i10 & 63));
                i6 -= 3;
                i5 = i9 + 1;
            }
            if (i5 < i7) {
                m(appendable, bArr, i5, i7 - i5);
            }
        }

        @Override // b1.a.e
        a n(C0027a c0027a, Character ch) {
            return new c(c0027a, ch);
        }
    }

    /* loaded from: classes.dex */
    public static final class d extends IOException {
        d(String str) {
            super(str);
        }
    }

    /* loaded from: classes.dex */
    static class e extends a {

        /* renamed from: f  reason: collision with root package name */
        final C0027a f751f;

        /* renamed from: g  reason: collision with root package name */
        final Character f752g;

        e(C0027a c0027a, Character ch) {
            this.f751f = (C0027a) k.n(c0027a);
            k.j(ch == null || !c0027a.f(ch.charValue()), "Padding character %s was already in alphabet", ch);
            this.f752g = ch;
        }

        e(String str, String str2, Character ch) {
            this(new C0027a(str, str2.toCharArray()), ch);
        }

        @Override // b1.a
        int d(byte[] bArr, CharSequence charSequence) {
            C0027a c0027a;
            k.n(bArr);
            CharSequence l5 = l(charSequence);
            if (!this.f751f.e(l5.length())) {
                throw new d("Invalid input length " + l5.length());
            }
            int i5 = 0;
            int i6 = 0;
            while (i5 < l5.length()) {
                long j5 = 0;
                int i7 = 0;
                int i8 = 0;
                while (true) {
                    c0027a = this.f751f;
                    if (i7 >= c0027a.f745e) {
                        break;
                    }
                    j5 <<= c0027a.f744d;
                    if (i5 + i7 < l5.length()) {
                        j5 |= this.f751f.c(l5.charAt(i8 + i5));
                        i8++;
                    }
                    i7++;
                }
                int i9 = c0027a.f746f;
                int i10 = (i9 * 8) - (i8 * c0027a.f744d);
                int i11 = (i9 - 1) * 8;
                while (i11 >= i10) {
                    bArr[i6] = (byte) ((j5 >>> i11) & 255);
                    i11 -= 8;
                    i6++;
                }
                i5 += this.f751f.f745e;
            }
            return i6;
        }

        public boolean equals(Object obj) {
            if (obj instanceof e) {
                e eVar = (e) obj;
                return this.f751f.equals(eVar.f751f) && Objects.equals(this.f752g, eVar.f752g);
            }
            return false;
        }

        @Override // b1.a
        void g(Appendable appendable, byte[] bArr, int i5, int i6) {
            k.n(appendable);
            k.s(i5, i5 + i6, bArr.length);
            int i7 = 0;
            while (i7 < i6) {
                m(appendable, bArr, i5 + i7, Math.min(this.f751f.f746f, i6 - i7));
                i7 += this.f751f.f746f;
            }
        }

        public int hashCode() {
            return this.f751f.hashCode() ^ Objects.hashCode(this.f752g);
        }

        @Override // b1.a
        int i(int i5) {
            return (int) (((this.f751f.f744d * i5) + 7) / 8);
        }

        @Override // b1.a
        int j(int i5) {
            C0027a c0027a = this.f751f;
            return c0027a.f745e * c1.a.a(i5, c0027a.f746f, RoundingMode.CEILING);
        }

        @Override // b1.a
        public a k() {
            return this.f752g == null ? this : n(this.f751f, null);
        }

        @Override // b1.a
        CharSequence l(CharSequence charSequence) {
            k.n(charSequence);
            Character ch = this.f752g;
            if (ch == null) {
                return charSequence;
            }
            char charValue = ch.charValue();
            int length = charSequence.length() - 1;
            while (length >= 0 && charSequence.charAt(length) == charValue) {
                length--;
            }
            return charSequence.subSequence(0, length + 1);
        }

        void m(Appendable appendable, byte[] bArr, int i5, int i6) {
            k.n(appendable);
            k.s(i5, i5 + i6, bArr.length);
            int i7 = 0;
            k.d(i6 <= this.f751f.f746f);
            long j5 = 0;
            for (int i8 = 0; i8 < i6; i8++) {
                j5 = (j5 | (bArr[i5 + i8] & 255)) << 8;
            }
            int i9 = ((i6 + 1) * 8) - this.f751f.f744d;
            while (i7 < i6 * 8) {
                C0027a c0027a = this.f751f;
                appendable.append(c0027a.d(((int) (j5 >>> (i9 - i7))) & c0027a.f743c));
                i7 += this.f751f.f744d;
            }
            if (this.f752g != null) {
                while (i7 < this.f751f.f746f * 8) {
                    appendable.append(this.f752g.charValue());
                    i7 += this.f751f.f744d;
                }
            }
        }

        a n(C0027a c0027a, Character ch) {
            return new e(c0027a, ch);
        }

        public String toString() {
            String str;
            StringBuilder sb = new StringBuilder("BaseEncoding.");
            sb.append(this.f751f);
            if (8 % this.f751f.f744d != 0) {
                if (this.f752g == null) {
                    str = ".omitPadding()";
                } else {
                    sb.append(".withPadChar('");
                    sb.append(this.f752g);
                    str = "')";
                }
                sb.append(str);
            }
            return sb.toString();
        }
    }

    a() {
    }

    public static a a() {
        return f736a;
    }

    private static byte[] h(byte[] bArr, int i5) {
        if (i5 == bArr.length) {
            return bArr;
        }
        byte[] bArr2 = new byte[i5];
        System.arraycopy(bArr, 0, bArr2, 0, i5);
        return bArr2;
    }

    public final byte[] b(CharSequence charSequence) {
        try {
            return c(charSequence);
        } catch (d e5) {
            throw new IllegalArgumentException(e5);
        }
    }

    final byte[] c(CharSequence charSequence) {
        CharSequence l5 = l(charSequence);
        byte[] bArr = new byte[i(l5.length())];
        return h(bArr, d(bArr, l5));
    }

    abstract int d(byte[] bArr, CharSequence charSequence);

    public String e(byte[] bArr) {
        return f(bArr, 0, bArr.length);
    }

    public final String f(byte[] bArr, int i5, int i6) {
        k.s(i5, i5 + i6, bArr.length);
        StringBuilder sb = new StringBuilder(j(i6));
        try {
            g(sb, bArr, i5, i6);
            return sb.toString();
        } catch (IOException e5) {
            throw new AssertionError(e5);
        }
    }

    abstract void g(Appendable appendable, byte[] bArr, int i5, int i6);

    abstract int i(int i5);

    abstract int j(int i5);

    public abstract a k();

    abstract CharSequence l(CharSequence charSequence);
}
