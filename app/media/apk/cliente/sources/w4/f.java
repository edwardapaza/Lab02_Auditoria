package w4;

import java.io.Serializable;
import java.util.Arrays;
/* loaded from: classes.dex */
public class f implements Serializable, Comparable<f> {

    /* renamed from: d  reason: collision with root package name */
    static final char[] f8284d = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* renamed from: e  reason: collision with root package name */
    public static final f f8285e = m(new byte[0]);

    /* renamed from: a  reason: collision with root package name */
    final byte[] f8286a;

    /* renamed from: b  reason: collision with root package name */
    transient int f8287b;

    /* renamed from: c  reason: collision with root package name */
    transient String f8288c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(byte[] bArr) {
        this.f8286a = bArr;
    }

    static int c(String str, int i5) {
        int length = str.length();
        int i6 = 0;
        int i7 = 0;
        while (i6 < length) {
            if (i7 == i5) {
                return i6;
            }
            int codePointAt = str.codePointAt(i6);
            if ((Character.isISOControl(codePointAt) && codePointAt != 10 && codePointAt != 13) || codePointAt == 65533) {
                return -1;
            }
            i7++;
            i6 += Character.charCount(codePointAt);
        }
        return str.length();
    }

    public static f e(String str) {
        if (str != null) {
            f fVar = new f(str.getBytes(p.f8316a));
            fVar.f8288c = str;
            return fVar;
        }
        throw new IllegalArgumentException("s == null");
    }

    public static f m(byte... bArr) {
        if (bArr != null) {
            return new f((byte[]) bArr.clone());
        }
        throw new IllegalArgumentException("data == null");
    }

    public String a() {
        return b.a(this.f8286a);
    }

    @Override // java.lang.Comparable
    /* renamed from: d */
    public int compareTo(f fVar) {
        int p5 = p();
        int p6 = fVar.p();
        int min = Math.min(p5, p6);
        for (int i5 = 0; i5 < min; i5++) {
            int h5 = h(i5) & 255;
            int h6 = fVar.h(i5) & 255;
            if (h5 != h6) {
                return h5 < h6 ? -1 : 1;
            }
        }
        if (p5 == p6) {
            return 0;
        }
        return p5 < p6 ? -1 : 1;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof f) {
            f fVar = (f) obj;
            int p5 = fVar.p();
            byte[] bArr = this.f8286a;
            if (p5 == bArr.length && fVar.o(0, bArr, 0, bArr.length)) {
                return true;
            }
        }
        return false;
    }

    public byte h(int i5) {
        return this.f8286a[i5];
    }

    public int hashCode() {
        int i5 = this.f8287b;
        if (i5 != 0) {
            return i5;
        }
        int hashCode = Arrays.hashCode(this.f8286a);
        this.f8287b = hashCode;
        return hashCode;
    }

    public String k() {
        byte[] bArr = this.f8286a;
        char[] cArr = new char[bArr.length * 2];
        int i5 = 0;
        for (byte b5 : bArr) {
            int i6 = i5 + 1;
            char[] cArr2 = f8284d;
            cArr[i5] = cArr2[(b5 >> 4) & 15];
            i5 = i6 + 1;
            cArr[i6] = cArr2[b5 & 15];
        }
        return new String(cArr);
    }

    public boolean n(int i5, f fVar, int i6, int i7) {
        return fVar.o(i6, this.f8286a, i5, i7);
    }

    public boolean o(int i5, byte[] bArr, int i6, int i7) {
        if (i5 >= 0) {
            byte[] bArr2 = this.f8286a;
            if (i5 <= bArr2.length - i7 && i6 >= 0 && i6 <= bArr.length - i7 && p.a(bArr2, i5, bArr, i6, i7)) {
                return true;
            }
        }
        return false;
    }

    public int p() {
        return this.f8286a.length;
    }

    public final boolean q(f fVar) {
        return n(0, fVar, 0, fVar.p());
    }

    public f r(int i5, int i6) {
        if (i5 >= 0) {
            byte[] bArr = this.f8286a;
            if (i6 > bArr.length) {
                throw new IllegalArgumentException("endIndex > length(" + this.f8286a.length + ")");
            }
            int i7 = i6 - i5;
            if (i7 >= 0) {
                if (i5 == 0 && i6 == bArr.length) {
                    return this;
                }
                byte[] bArr2 = new byte[i7];
                System.arraycopy(bArr, i5, bArr2, 0, i7);
                return new f(bArr2);
            }
            throw new IllegalArgumentException("endIndex < beginIndex");
        }
        throw new IllegalArgumentException("beginIndex < 0");
    }

    public f s() {
        int i5 = 0;
        while (true) {
            byte[] bArr = this.f8286a;
            if (i5 >= bArr.length) {
                return this;
            }
            byte b5 = bArr[i5];
            if (b5 >= 65 && b5 <= 90) {
                byte[] bArr2 = (byte[]) bArr.clone();
                bArr2[i5] = (byte) (b5 + 32);
                for (int i6 = i5 + 1; i6 < bArr2.length; i6++) {
                    byte b6 = bArr2[i6];
                    if (b6 >= 65 && b6 <= 90) {
                        bArr2[i6] = (byte) (b6 + 32);
                    }
                }
                return new f(bArr2);
            }
            i5++;
        }
    }

    public byte[] t() {
        return (byte[]) this.f8286a.clone();
    }

    public String toString() {
        StringBuilder sb;
        StringBuilder sb2;
        if (this.f8286a.length == 0) {
            return "[size=0]";
        }
        String u5 = u();
        int c5 = c(u5, 64);
        if (c5 == -1) {
            if (this.f8286a.length <= 64) {
                sb2 = new StringBuilder();
                sb2.append("[hex=");
                sb2.append(k());
                sb2.append("]");
            } else {
                sb2 = new StringBuilder();
                sb2.append("[size=");
                sb2.append(this.f8286a.length);
                sb2.append(" hex=");
                sb2.append(r(0, 64).k());
                sb2.append("…]");
            }
            return sb2.toString();
        }
        String replace = u5.substring(0, c5).replace("\\", "\\\\").replace("\n", "\\n").replace("\r", "\\r");
        if (c5 < u5.length()) {
            sb = new StringBuilder();
            sb.append("[size=");
            sb.append(this.f8286a.length);
            sb.append(" text=");
            sb.append(replace);
            sb.append("…]");
        } else {
            sb = new StringBuilder();
            sb.append("[text=");
            sb.append(replace);
            sb.append("]");
        }
        return sb.toString();
    }

    public String u() {
        String str = this.f8288c;
        if (str != null) {
            return str;
        }
        String str2 = new String(this.f8286a, p.f8316a);
        this.f8288c = str2;
        return str2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void v(c cVar) {
        byte[] bArr = this.f8286a;
        cVar.S(bArr, 0, bArr.length);
    }
}
