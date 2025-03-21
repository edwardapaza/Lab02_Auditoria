package t1;

import com.google.protobuf.i;
import java.math.RoundingMode;
import java.util.Arrays;
/* loaded from: classes.dex */
public class g {

    /* renamed from: c  reason: collision with root package name */
    private static final byte[][] f7601c = {new byte[]{0, 0}, new byte[]{Byte.MIN_VALUE, 0}, new byte[]{-64, 0}, new byte[]{-32, 0}, new byte[]{-16, 0}, new byte[]{-8, 0}, new byte[]{-4, 0}, new byte[]{-2, 0}, new byte[]{-1, 0}, new byte[]{-1, Byte.MIN_VALUE}, new byte[]{-1, -64}};

    /* renamed from: b  reason: collision with root package name */
    private int f7603b = 0;

    /* renamed from: a  reason: collision with root package name */
    private byte[] f7602a = new byte[1024];

    private void b(int i5) {
        int i6 = i5 + this.f7603b;
        byte[] bArr = this.f7602a;
        if (i6 <= bArr.length) {
            return;
        }
        int length = bArr.length * 2;
        if (length >= i6) {
            i6 = length;
        }
        this.f7602a = Arrays.copyOf(bArr, i6);
    }

    private int d(long j5) {
        if (j5 < 0) {
            j5 = ~j5;
        }
        return f.a((64 - Long.numberOfLeadingZeros(j5)) + 1, 7, RoundingMode.UP);
    }

    private int e(long j5) {
        return f.a(64 - Long.numberOfLeadingZeros(j5), 8, RoundingMode.UP);
    }

    private void f(byte b5) {
        if (b5 == 0) {
            l((byte) 0);
            l((byte) -1);
        } else if (b5 != -1) {
            l(b5);
        } else {
            l((byte) -1);
            l((byte) 0);
        }
    }

    private void g(byte b5) {
        if (b5 == 0) {
            m((byte) 0);
            m((byte) -1);
        } else if (b5 != -1) {
            m(b5);
        } else {
            m((byte) -1);
            m((byte) 0);
        }
    }

    private void l(byte b5) {
        b(1);
        byte[] bArr = this.f7602a;
        int i5 = this.f7603b;
        this.f7603b = i5 + 1;
        bArr[i5] = b5;
    }

    private void m(byte b5) {
        b(1);
        byte[] bArr = this.f7602a;
        int i5 = this.f7603b;
        this.f7603b = i5 + 1;
        bArr[i5] = (byte) (~b5);
    }

    private void p() {
        l((byte) 0);
        l((byte) 1);
    }

    private void q() {
        m((byte) 0);
        m((byte) 1);
    }

    public byte[] a() {
        return Arrays.copyOf(this.f7602a, this.f7603b);
    }

    public void c(byte[] bArr) {
        b(bArr.length);
        for (byte b5 : bArr) {
            byte[] bArr2 = this.f7602a;
            int i5 = this.f7603b;
            this.f7603b = i5 + 1;
            bArr2[i5] = b5;
        }
    }

    public void h(i iVar) {
        for (int i5 = 0; i5 < iVar.size(); i5++) {
            f(iVar.k(i5));
        }
        p();
    }

    public void i(i iVar) {
        for (int i5 = 0; i5 < iVar.size(); i5++) {
            g(iVar.k(i5));
        }
        q();
    }

    public void j(double d5) {
        long doubleToLongBits = Double.doubleToLongBits(d5);
        t(doubleToLongBits ^ (doubleToLongBits < 0 ? -1L : Long.MIN_VALUE));
    }

    public void k(double d5) {
        long doubleToLongBits = Double.doubleToLongBits(d5);
        u(doubleToLongBits ^ (doubleToLongBits < 0 ? -1L : Long.MIN_VALUE));
    }

    public void n() {
        l((byte) -1);
        l((byte) -1);
    }

    public void o() {
        m((byte) -1);
        m((byte) -1);
    }

    public void r(long j5) {
        int i5;
        int i6 = (j5 > 0L ? 1 : (j5 == 0L ? 0 : -1));
        long j6 = i6 < 0 ? ~j5 : j5;
        if (j6 < 64) {
            b(1);
            byte[] bArr = this.f7602a;
            int i7 = this.f7603b;
            this.f7603b = i7 + 1;
            bArr[i7] = (byte) (j5 ^ f7601c[1][0]);
            return;
        }
        int d5 = d(j6);
        b(d5);
        if (d5 < 2) {
            throw new AssertionError(String.format("Invalid length (%d) returned by signedNumLength", Integer.valueOf(d5)));
        }
        byte b5 = i6 < 0 ? (byte) -1 : (byte) 0;
        int i8 = this.f7603b;
        if (d5 == 10) {
            i5 = i8 + 2;
            byte[] bArr2 = this.f7602a;
            bArr2[i8] = b5;
            bArr2[i8 + 1] = b5;
        } else if (d5 == 9) {
            i5 = i8 + 1;
            this.f7602a[i8] = b5;
        } else {
            i5 = i8;
        }
        for (int i9 = (d5 - 1) + i8; i9 >= i5; i9--) {
            this.f7602a[i9] = (byte) (255 & j5);
            j5 >>= 8;
        }
        byte[] bArr3 = this.f7602a;
        int i10 = this.f7603b;
        byte b6 = bArr3[i10];
        byte[] bArr4 = f7601c[d5];
        bArr3[i10] = (byte) (b6 ^ bArr4[0]);
        int i11 = i10 + 1;
        bArr3[i11] = (byte) (bArr4[1] ^ bArr3[i11]);
        this.f7603b = i10 + d5;
    }

    public void s(long j5) {
        r(~j5);
    }

    public void t(long j5) {
        int e5 = e(j5);
        b(e5 + 1);
        byte[] bArr = this.f7602a;
        int i5 = this.f7603b;
        int i6 = i5 + 1;
        this.f7603b = i6;
        bArr[i5] = (byte) e5;
        int i7 = i6 + e5;
        while (true) {
            i7--;
            int i8 = this.f7603b;
            if (i7 < i8) {
                this.f7603b = i8 + e5;
                return;
            } else {
                this.f7602a[i7] = (byte) (255 & j5);
                j5 >>>= 8;
            }
        }
    }

    public void u(long j5) {
        int e5 = e(j5);
        b(e5 + 1);
        byte[] bArr = this.f7602a;
        int i5 = this.f7603b;
        int i6 = i5 + 1;
        this.f7603b = i6;
        bArr[i5] = (byte) (~e5);
        int i7 = i6 + e5;
        while (true) {
            i7--;
            int i8 = this.f7603b;
            if (i7 < i8) {
                this.f7603b = i8 + e5;
                return;
            } else {
                this.f7602a[i7] = (byte) (~(255 & j5));
                j5 >>>= 8;
            }
        }
    }

    public void v(CharSequence charSequence) {
        int i5;
        int length = charSequence.length();
        int i6 = 0;
        while (i6 < length) {
            int charAt = charSequence.charAt(i6);
            if (charAt >= 128) {
                if (charAt < 2048) {
                    i5 = (charAt >>> 6) | 960;
                } else if (charAt < 55296 || 57343 < charAt) {
                    f((byte) ((charAt >>> 12) | 480));
                    i5 = ((charAt >>> 6) & 63) | 128;
                } else {
                    charAt = Character.codePointAt(charSequence, i6);
                    i6++;
                    f((byte) ((charAt >>> 18) | 240));
                    f((byte) (((charAt >>> 12) & 63) | 128));
                    f((byte) (((charAt >>> 6) & 63) | 128));
                    charAt = (charAt & 63) | 128;
                }
                f((byte) i5);
                charAt = (charAt & 63) | 128;
            }
            f((byte) charAt);
            i6++;
        }
        p();
    }

    public void w(CharSequence charSequence) {
        int i5;
        int length = charSequence.length();
        int i6 = 0;
        while (i6 < length) {
            int charAt = charSequence.charAt(i6);
            if (charAt >= 128) {
                if (charAt < 2048) {
                    i5 = (charAt >>> 6) | 960;
                } else if (charAt < 55296 || 57343 < charAt) {
                    g((byte) ((charAt >>> 12) | 480));
                    i5 = ((charAt >>> 6) & 63) | 128;
                } else {
                    charAt = Character.codePointAt(charSequence, i6);
                    i6++;
                    g((byte) ((charAt >>> 18) | 240));
                    g((byte) (((charAt >>> 12) & 63) | 128));
                    g((byte) (((charAt >>> 6) & 63) | 128));
                    charAt = (charAt & 63) | 128;
                }
                g((byte) i5);
                charAt = (charAt & 63) | 128;
            }
            g((byte) charAt);
            i6++;
        }
        q();
    }
}
