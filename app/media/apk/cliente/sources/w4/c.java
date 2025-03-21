package w4;

import java.io.EOFException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;
/* loaded from: classes.dex */
public final class c implements e, d, Cloneable, ByteChannel {

    /* renamed from: c  reason: collision with root package name */
    private static final byte[] f8280c = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102};

    /* renamed from: a  reason: collision with root package name */
    j f8281a;

    /* renamed from: b  reason: collision with root package name */
    long f8282b;

    /* loaded from: classes.dex */
    class a extends OutputStream {
        a() {
        }

        @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // java.io.OutputStream, java.io.Flushable
        public void flush() {
        }

        public String toString() {
            return c.this + ".outputStream()";
        }

        @Override // java.io.OutputStream
        public void write(int i5) {
            c.this.writeByte((byte) i5);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i5, int i6) {
            c.this.S(bArr, i5, i6);
        }
    }

    public String A() {
        try {
            return z(this.f8282b, p.f8316a);
        } catch (EOFException e5) {
            throw new AssertionError(e5);
        }
    }

    @Override // w4.e
    public c B() {
        return this;
    }

    @Override // w4.e
    public boolean C() {
        return this.f8282b == 0;
    }

    public String D(long j5) {
        return z(j5, p.f8316a);
    }

    @Override // w4.e
    public byte[] G(long j5) {
        p.b(this.f8282b, 0L, j5);
        if (j5 <= 2147483647L) {
            byte[] bArr = new byte[(int) j5];
            x(bArr);
            return bArr;
        }
        throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j5);
    }

    String I(long j5) {
        String D;
        long j6 = 1;
        if (j5 > 0) {
            long j7 = j5 - 1;
            if (p(j7) == 13) {
                D = D(j7);
                j6 = 2;
                skip(j6);
                return D;
            }
        }
        D = D(j5);
        skip(j6);
        return D;
    }

    public String J() {
        return K(Long.MAX_VALUE);
    }

    public String K(long j5) {
        if (j5 < 0) {
            throw new IllegalArgumentException("limit < 0: " + j5);
        }
        long j6 = j5 != Long.MAX_VALUE ? j5 + 1 : Long.MAX_VALUE;
        long r5 = r((byte) 10, 0L, j6);
        if (r5 != -1) {
            return I(r5);
        }
        if (j6 < size() && p(j6 - 1) == 13 && p(j6) == 10) {
            return I(j6);
        }
        c cVar = new c();
        n(cVar, 0L, Math.min(32L, size()));
        throw new EOFException("\\n not found: limit=" + Math.min(size(), j5) + " content=" + cVar.w().k() + (char) 8230);
    }

    public final f L() {
        long j5 = this.f8282b;
        if (j5 <= 2147483647L) {
            return M((int) j5);
        }
        throw new IllegalArgumentException("size > Integer.MAX_VALUE: " + this.f8282b);
    }

    public final f M(int i5) {
        return i5 == 0 ? f.f8285e : new l(this, i5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public j N(int i5) {
        if (i5 < 1 || i5 > 8192) {
            throw new IllegalArgumentException();
        }
        j jVar = this.f8281a;
        if (jVar != null) {
            j jVar2 = jVar.f8307g;
            return (jVar2.f8303c + i5 > 8192 || !jVar2.f8305e) ? jVar2.c(k.b()) : jVar2;
        }
        j b5 = k.b();
        this.f8281a = b5;
        b5.f8307g = b5;
        b5.f8306f = b5;
        return b5;
    }

    public c O(f fVar) {
        if (fVar != null) {
            fVar.v(this);
            return this;
        }
        throw new IllegalArgumentException("byteString == null");
    }

    @Override // w4.d
    /* renamed from: P */
    public c write(byte[] bArr) {
        if (bArr != null) {
            return S(bArr, 0, bArr.length);
        }
        throw new IllegalArgumentException("source == null");
    }

    public c S(byte[] bArr, int i5, int i6) {
        if (bArr != null) {
            long j5 = i6;
            p.b(bArr.length, i5, j5);
            int i7 = i6 + i5;
            while (i5 < i7) {
                j N = N(1);
                int min = Math.min(i7 - i5, 8192 - N.f8303c);
                System.arraycopy(bArr, i5, N.f8301a, N.f8303c, min);
                i5 += min;
                N.f8303c += min;
            }
            this.f8282b += j5;
            return this;
        }
        throw new IllegalArgumentException("source == null");
    }

    @Override // w4.d
    /* renamed from: U */
    public c writeByte(int i5) {
        j N = N(1);
        byte[] bArr = N.f8301a;
        int i6 = N.f8303c;
        N.f8303c = i6 + 1;
        bArr[i6] = (byte) i5;
        this.f8282b++;
        return this;
    }

    public c X(long j5) {
        if (j5 == 0) {
            return writeByte(48);
        }
        int numberOfTrailingZeros = (Long.numberOfTrailingZeros(Long.highestOneBit(j5)) / 4) + 1;
        j N = N(numberOfTrailingZeros);
        byte[] bArr = N.f8301a;
        int i5 = N.f8303c;
        for (int i6 = (i5 + numberOfTrailingZeros) - 1; i6 >= i5; i6--) {
            bArr[i6] = f8280c[(int) (15 & j5)];
            j5 >>>= 4;
        }
        N.f8303c += numberOfTrailingZeros;
        this.f8282b += numberOfTrailingZeros;
        return this;
    }

    @Override // w4.e
    public void Y(long j5) {
        if (this.f8282b < j5) {
            throw new EOFException();
        }
    }

    @Override // w4.m
    public void Z(c cVar, long j5) {
        if (cVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        if (cVar == this) {
            throw new IllegalArgumentException("source == this");
        }
        p.b(cVar.f8282b, 0L, j5);
        while (j5 > 0) {
            j jVar = cVar.f8281a;
            if (j5 < jVar.f8303c - jVar.f8302b) {
                j jVar2 = this.f8281a;
                j jVar3 = jVar2 != null ? jVar2.f8307g : null;
                if (jVar3 != null && jVar3.f8305e) {
                    if ((jVar3.f8303c + j5) - (jVar3.f8304d ? 0 : jVar3.f8302b) <= 8192) {
                        jVar.f(jVar3, (int) j5);
                        cVar.f8282b -= j5;
                        this.f8282b += j5;
                        return;
                    }
                }
                cVar.f8281a = jVar.e((int) j5);
            }
            j jVar4 = cVar.f8281a;
            long j6 = jVar4.f8303c - jVar4.f8302b;
            cVar.f8281a = jVar4.b();
            j jVar5 = this.f8281a;
            if (jVar5 == null) {
                this.f8281a = jVar4;
                jVar4.f8307g = jVar4;
                jVar4.f8306f = jVar4;
            } else {
                jVar5.f8307g.c(jVar4).a();
            }
            cVar.f8282b -= j6;
            this.f8282b += j6;
            j5 -= j6;
        }
    }

    public c c() {
        return this;
    }

    @Override // w4.d
    /* renamed from: c0 */
    public c writeInt(int i5) {
        j N = N(4);
        byte[] bArr = N.f8301a;
        int i6 = N.f8303c;
        int i7 = i6 + 1;
        bArr[i6] = (byte) ((i5 >>> 24) & 255);
        int i8 = i7 + 1;
        bArr[i7] = (byte) ((i5 >>> 16) & 255);
        int i9 = i8 + 1;
        bArr[i8] = (byte) ((i5 >>> 8) & 255);
        bArr[i9] = (byte) (i5 & 255);
        N.f8303c = i9 + 1;
        this.f8282b += 4;
        return this;
    }

    @Override // w4.n, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    public final void d() {
        try {
            skip(this.f8282b);
        } catch (EOFException e5) {
            throw new AssertionError(e5);
        }
    }

    @Override // w4.d
    /* renamed from: e0 */
    public c writeShort(int i5) {
        j N = N(2);
        byte[] bArr = N.f8301a;
        int i6 = N.f8303c;
        int i7 = i6 + 1;
        bArr[i6] = (byte) ((i5 >>> 8) & 255);
        bArr[i7] = (byte) (i5 & 255);
        N.f8303c = i7 + 1;
        this.f8282b += 2;
        return this;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof c) {
            c cVar = (c) obj;
            long j5 = this.f8282b;
            if (j5 != cVar.f8282b) {
                return false;
            }
            long j6 = 0;
            if (j5 == 0) {
                return true;
            }
            j jVar = this.f8281a;
            j jVar2 = cVar.f8281a;
            int i5 = jVar.f8302b;
            int i6 = jVar2.f8302b;
            while (j6 < this.f8282b) {
                long min = Math.min(jVar.f8303c - i5, jVar2.f8303c - i6);
                int i7 = 0;
                while (i7 < min) {
                    int i8 = i5 + 1;
                    int i9 = i6 + 1;
                    if (jVar.f8301a[i5] != jVar2.f8301a[i6]) {
                        return false;
                    }
                    i7++;
                    i5 = i8;
                    i6 = i9;
                }
                if (i5 == jVar.f8303c) {
                    jVar = jVar.f8306f;
                    i5 = jVar.f8302b;
                }
                if (i6 == jVar2.f8303c) {
                    jVar2 = jVar2.f8306f;
                    i6 = jVar2.f8302b;
                }
                j6 += min;
            }
            return true;
        }
        return false;
    }

    public final c f0(OutputStream outputStream, long j5) {
        if (outputStream != null) {
            p.b(this.f8282b, 0L, j5);
            j jVar = this.f8281a;
            while (j5 > 0) {
                int min = (int) Math.min(j5, jVar.f8303c - jVar.f8302b);
                outputStream.write(jVar.f8301a, jVar.f8302b, min);
                int i5 = jVar.f8302b + min;
                jVar.f8302b = i5;
                long j6 = min;
                this.f8282b -= j6;
                j5 -= j6;
                if (i5 == jVar.f8303c) {
                    j b5 = jVar.b();
                    this.f8281a = b5;
                    k.a(jVar);
                    jVar = b5;
                }
            }
            return this;
        }
        throw new IllegalArgumentException("out == null");
    }

    @Override // w4.d, w4.m, java.io.Flushable
    public void flush() {
    }

    @Override // w4.d
    /* renamed from: g0 */
    public c b0(String str) {
        return h0(str, 0, str.length());
    }

    public c h0(String str, int i5, int i6) {
        int i7;
        if (str != null) {
            if (i5 < 0) {
                throw new IllegalArgumentException("beginIndex < 0: " + i5);
            } else if (i6 < i5) {
                throw new IllegalArgumentException("endIndex < beginIndex: " + i6 + " < " + i5);
            } else if (i6 > str.length()) {
                throw new IllegalArgumentException("endIndex > string.length: " + i6 + " > " + str.length());
            } else {
                while (i5 < i6) {
                    char charAt = str.charAt(i5);
                    if (charAt < 128) {
                        j N = N(1);
                        byte[] bArr = N.f8301a;
                        int i8 = N.f8303c - i5;
                        int min = Math.min(i6, 8192 - i8);
                        int i9 = i5 + 1;
                        bArr[i5 + i8] = (byte) charAt;
                        while (i9 < min) {
                            char charAt2 = str.charAt(i9);
                            if (charAt2 >= 128) {
                                break;
                            }
                            bArr[i9 + i8] = (byte) charAt2;
                            i9++;
                        }
                        int i10 = N.f8303c;
                        int i11 = (i8 + i9) - i10;
                        N.f8303c = i10 + i11;
                        this.f8282b += i11;
                        i5 = i9;
                    } else {
                        if (charAt < 2048) {
                            i7 = (charAt >> 6) | 192;
                        } else if (charAt < 55296 || charAt > 57343) {
                            writeByte((charAt >> '\f') | 224);
                            i7 = ((charAt >> 6) & 63) | 128;
                        } else {
                            int i12 = i5 + 1;
                            char charAt3 = i12 < i6 ? str.charAt(i12) : (char) 0;
                            if (charAt > 56319 || charAt3 < 56320 || charAt3 > 57343) {
                                writeByte(63);
                                i5 = i12;
                            } else {
                                int i13 = (((charAt & 10239) << 10) | (9215 & charAt3)) + 65536;
                                writeByte((i13 >> 18) | 240);
                                writeByte(((i13 >> 12) & 63) | 128);
                                writeByte(((i13 >> 6) & 63) | 128);
                                writeByte((i13 & 63) | 128);
                                i5 += 2;
                            }
                        }
                        writeByte(i7);
                        writeByte((charAt & '?') | 128);
                        i5++;
                    }
                }
                return this;
            }
        }
        throw new IllegalArgumentException("string == null");
    }

    public int hashCode() {
        j jVar = this.f8281a;
        if (jVar == null) {
            return 0;
        }
        int i5 = 1;
        do {
            int i6 = jVar.f8303c;
            for (int i7 = jVar.f8302b; i7 < i6; i7++) {
                i5 = (i5 * 31) + jVar.f8301a[i7];
            }
            jVar = jVar.f8306f;
        } while (jVar != this.f8281a);
        return i5;
    }

    public c i0(int i5) {
        int i6;
        int i7;
        if (i5 >= 128) {
            if (i5 < 2048) {
                i7 = (i5 >> 6) | 192;
            } else {
                if (i5 < 65536) {
                    if (i5 >= 55296 && i5 <= 57343) {
                        writeByte(63);
                        return this;
                    }
                    i6 = (i5 >> 12) | 224;
                } else if (i5 > 1114111) {
                    throw new IllegalArgumentException("Unexpected code point: " + Integer.toHexString(i5));
                } else {
                    writeByte((i5 >> 18) | 240);
                    i6 = ((i5 >> 12) & 63) | 128;
                }
                writeByte(i6);
                i7 = ((i5 >> 6) & 63) | 128;
            }
            writeByte(i7);
            i5 = (i5 & 63) | 128;
        }
        writeByte(i5);
        return this;
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return true;
    }

    /* renamed from: j */
    public c clone() {
        c cVar = new c();
        if (this.f8282b == 0) {
            return cVar;
        }
        j d5 = this.f8281a.d();
        cVar.f8281a = d5;
        d5.f8307g = d5;
        d5.f8306f = d5;
        j jVar = this.f8281a;
        while (true) {
            jVar = jVar.f8306f;
            if (jVar == this.f8281a) {
                cVar.f8282b = this.f8282b;
                return cVar;
            }
            cVar.f8281a.f8307g.c(jVar.d());
        }
    }

    @Override // w4.e
    public f k(long j5) {
        return new f(G(j5));
    }

    public final long l() {
        long j5 = this.f8282b;
        if (j5 == 0) {
            return 0L;
        }
        j jVar = this.f8281a.f8307g;
        int i5 = jVar.f8303c;
        return (i5 >= 8192 || !jVar.f8305e) ? j5 : j5 - (i5 - jVar.f8302b);
    }

    public final c n(c cVar, long j5, long j6) {
        if (cVar != null) {
            p.b(this.f8282b, j5, j6);
            if (j6 == 0) {
                return this;
            }
            cVar.f8282b += j6;
            j jVar = this.f8281a;
            while (true) {
                int i5 = jVar.f8303c;
                int i6 = jVar.f8302b;
                if (j5 < i5 - i6) {
                    break;
                }
                j5 -= i5 - i6;
                jVar = jVar.f8306f;
            }
            while (j6 > 0) {
                j d5 = jVar.d();
                int i7 = (int) (d5.f8302b + j5);
                d5.f8302b = i7;
                d5.f8303c = Math.min(i7 + ((int) j6), d5.f8303c);
                j jVar2 = cVar.f8281a;
                if (jVar2 == null) {
                    d5.f8307g = d5;
                    d5.f8306f = d5;
                    cVar.f8281a = d5;
                } else {
                    jVar2.f8307g.c(d5);
                }
                j6 -= d5.f8303c - d5.f8302b;
                jVar = jVar.f8306f;
                j5 = 0;
            }
            return this;
        }
        throw new IllegalArgumentException("out == null");
    }

    public final byte p(long j5) {
        int i5;
        p.b(this.f8282b, j5, 1L);
        long j6 = this.f8282b;
        if (j6 - j5 <= j5) {
            long j7 = j5 - j6;
            j jVar = this.f8281a;
            do {
                jVar = jVar.f8307g;
                int i6 = jVar.f8303c;
                i5 = jVar.f8302b;
                j7 += i6 - i5;
            } while (j7 < 0);
            return jVar.f8301a[i5 + ((int) j7)];
        }
        j jVar2 = this.f8281a;
        while (true) {
            int i7 = jVar2.f8303c;
            int i8 = jVar2.f8302b;
            long j8 = i7 - i8;
            if (j5 < j8) {
                return jVar2.f8301a[i8 + ((int) j5)];
            }
            j5 -= j8;
            jVar2 = jVar2.f8306f;
        }
    }

    public long r(byte b5, long j5, long j6) {
        j jVar;
        long j7 = 0;
        if (j5 < 0 || j6 < j5) {
            throw new IllegalArgumentException(String.format("size=%s fromIndex=%s toIndex=%s", Long.valueOf(this.f8282b), Long.valueOf(j5), Long.valueOf(j6)));
        }
        long j8 = this.f8282b;
        long j9 = j6 > j8 ? j8 : j6;
        if (j5 == j9 || (jVar = this.f8281a) == null) {
            return -1L;
        }
        if (j8 - j5 < j5) {
            while (j8 > j5) {
                jVar = jVar.f8307g;
                j8 -= jVar.f8303c - jVar.f8302b;
            }
        } else {
            while (true) {
                long j10 = (jVar.f8303c - jVar.f8302b) + j7;
                if (j10 >= j5) {
                    break;
                }
                jVar = jVar.f8306f;
                j7 = j10;
            }
            j8 = j7;
        }
        long j11 = j5;
        while (j8 < j9) {
            byte[] bArr = jVar.f8301a;
            int min = (int) Math.min(jVar.f8303c, (jVar.f8302b + j9) - j8);
            for (int i5 = (int) ((jVar.f8302b + j11) - j8); i5 < min; i5++) {
                if (bArr[i5] == b5) {
                    return (i5 - jVar.f8302b) + j8;
                }
            }
            j8 += jVar.f8303c - jVar.f8302b;
            jVar = jVar.f8306f;
            j11 = j8;
        }
        return -1L;
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) {
        j jVar = this.f8281a;
        if (jVar == null) {
            return -1;
        }
        int min = Math.min(byteBuffer.remaining(), jVar.f8303c - jVar.f8302b);
        byteBuffer.put(jVar.f8301a, jVar.f8302b, min);
        int i5 = jVar.f8302b + min;
        jVar.f8302b = i5;
        this.f8282b -= min;
        if (i5 == jVar.f8303c) {
            this.f8281a = jVar.b();
            k.a(jVar);
        }
        return min;
    }

    public int read(byte[] bArr, int i5, int i6) {
        p.b(bArr.length, i5, i6);
        j jVar = this.f8281a;
        if (jVar == null) {
            return -1;
        }
        int min = Math.min(i6, jVar.f8303c - jVar.f8302b);
        System.arraycopy(jVar.f8301a, jVar.f8302b, bArr, i5, min);
        int i7 = jVar.f8302b + min;
        jVar.f8302b = i7;
        this.f8282b -= min;
        if (i7 == jVar.f8303c) {
            this.f8281a = jVar.b();
            k.a(jVar);
        }
        return min;
    }

    @Override // w4.e
    public byte readByte() {
        long j5 = this.f8282b;
        if (j5 != 0) {
            j jVar = this.f8281a;
            int i5 = jVar.f8302b;
            int i6 = jVar.f8303c;
            int i7 = i5 + 1;
            byte b5 = jVar.f8301a[i5];
            this.f8282b = j5 - 1;
            if (i7 == i6) {
                this.f8281a = jVar.b();
                k.a(jVar);
            } else {
                jVar.f8302b = i7;
            }
            return b5;
        }
        throw new IllegalStateException("size == 0");
    }

    @Override // w4.e
    public int readInt() {
        long j5 = this.f8282b;
        if (j5 < 4) {
            throw new IllegalStateException("size < 4: " + this.f8282b);
        }
        j jVar = this.f8281a;
        int i5 = jVar.f8302b;
        int i6 = jVar.f8303c;
        if (i6 - i5 < 4) {
            return ((readByte() & 255) << 24) | ((readByte() & 255) << 16) | ((readByte() & 255) << 8) | (readByte() & 255);
        }
        byte[] bArr = jVar.f8301a;
        int i7 = i5 + 1;
        int i8 = i7 + 1;
        int i9 = ((bArr[i5] & 255) << 24) | ((bArr[i7] & 255) << 16);
        int i10 = i8 + 1;
        int i11 = i9 | ((bArr[i8] & 255) << 8);
        int i12 = i10 + 1;
        int i13 = i11 | (bArr[i10] & 255);
        this.f8282b = j5 - 4;
        if (i12 == i6) {
            this.f8281a = jVar.b();
            k.a(jVar);
        } else {
            jVar.f8302b = i12;
        }
        return i13;
    }

    @Override // w4.e
    public short readShort() {
        long j5 = this.f8282b;
        if (j5 < 2) {
            throw new IllegalStateException("size < 2: " + this.f8282b);
        }
        j jVar = this.f8281a;
        int i5 = jVar.f8302b;
        int i6 = jVar.f8303c;
        if (i6 - i5 < 2) {
            return (short) (((readByte() & 255) << 8) | (readByte() & 255));
        }
        byte[] bArr = jVar.f8301a;
        int i7 = i5 + 1;
        int i8 = i7 + 1;
        int i9 = ((bArr[i5] & 255) << 8) | (bArr[i7] & 255);
        this.f8282b = j5 - 2;
        if (i8 == i6) {
            this.f8281a = jVar.b();
            k.a(jVar);
        } else {
            jVar.f8302b = i8;
        }
        return (short) i9;
    }

    @Override // w4.n
    public long s(c cVar, long j5) {
        if (cVar != null) {
            if (j5 < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j5);
            }
            long j6 = this.f8282b;
            if (j6 == 0) {
                return -1L;
            }
            if (j5 > j6) {
                j5 = j6;
            }
            cVar.Z(this, j5);
            return j5;
        }
        throw new IllegalArgumentException("sink == null");
    }

    public final long size() {
        return this.f8282b;
    }

    @Override // w4.e
    public void skip(long j5) {
        j jVar;
        while (j5 > 0) {
            if (this.f8281a == null) {
                throw new EOFException();
            }
            int min = (int) Math.min(j5, jVar.f8303c - jVar.f8302b);
            long j6 = min;
            this.f8282b -= j6;
            j5 -= j6;
            j jVar2 = this.f8281a;
            int i5 = jVar2.f8302b + min;
            jVar2.f8302b = i5;
            if (i5 == jVar2.f8303c) {
                this.f8281a = jVar2.b();
                k.a(jVar2);
            }
        }
    }

    public String toString() {
        return L().toString();
    }

    public OutputStream u() {
        return new a();
    }

    public byte[] v() {
        try {
            return G(this.f8282b);
        } catch (EOFException e5) {
            throw new AssertionError(e5);
        }
    }

    public f w() {
        return new f(v());
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) {
        if (byteBuffer != null) {
            int remaining = byteBuffer.remaining();
            int i5 = remaining;
            while (i5 > 0) {
                j N = N(1);
                int min = Math.min(i5, 8192 - N.f8303c);
                byteBuffer.get(N.f8301a, N.f8303c, min);
                i5 -= min;
                N.f8303c += min;
            }
            this.f8282b += remaining;
            return remaining;
        }
        throw new IllegalArgumentException("source == null");
    }

    public void x(byte[] bArr) {
        int i5 = 0;
        while (i5 < bArr.length) {
            int read = read(bArr, i5, bArr.length - i5);
            if (read == -1) {
                throw new EOFException();
            }
            i5 += read;
        }
    }

    public String z(long j5, Charset charset) {
        p.b(this.f8282b, 0L, j5);
        if (charset != null) {
            if (j5 > 2147483647L) {
                throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: " + j5);
            } else if (j5 == 0) {
                return "";
            } else {
                j jVar = this.f8281a;
                int i5 = jVar.f8302b;
                if (i5 + j5 > jVar.f8303c) {
                    return new String(G(j5), charset);
                }
                String str = new String(jVar.f8301a, i5, (int) j5, charset);
                int i6 = (int) (jVar.f8302b + j5);
                jVar.f8302b = i6;
                this.f8282b -= j5;
                if (i6 == jVar.f8303c) {
                    this.f8281a = jVar.b();
                    k.a(jVar);
                }
                return str;
            }
        }
        throw new IllegalArgumentException("charset == null");
    }
}
