package com.google.protobuf;

import com.google.protobuf.b2;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.logging.Level;
import java.util.logging.Logger;
/* loaded from: classes.dex */
public abstract class l extends h {

    /* renamed from: c  reason: collision with root package name */
    private static final Logger f2047c = Logger.getLogger(l.class.getName());

    /* renamed from: d  reason: collision with root package name */
    private static final boolean f2048d = a2.I();

    /* renamed from: a  reason: collision with root package name */
    m f2049a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f2050b;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static abstract class b extends l {

        /* renamed from: e  reason: collision with root package name */
        final byte[] f2051e;

        /* renamed from: f  reason: collision with root package name */
        final int f2052f;

        /* renamed from: g  reason: collision with root package name */
        int f2053g;

        /* renamed from: h  reason: collision with root package name */
        int f2054h;

        b(int i5) {
            super();
            if (i5 < 0) {
                throw new IllegalArgumentException("bufferSize must be >= 0");
            }
            byte[] bArr = new byte[Math.max(i5, 20)];
            this.f2051e = bArr;
            this.f2052f = bArr.length;
        }

        final void b1(byte b5) {
            byte[] bArr = this.f2051e;
            int i5 = this.f2053g;
            this.f2053g = i5 + 1;
            bArr[i5] = b5;
            this.f2054h++;
        }

        final void c1(int i5) {
            byte[] bArr = this.f2051e;
            int i6 = this.f2053g;
            int i7 = i6 + 1;
            bArr[i6] = (byte) (i5 & 255);
            int i8 = i7 + 1;
            bArr[i7] = (byte) ((i5 >> 8) & 255);
            int i9 = i8 + 1;
            bArr[i8] = (byte) ((i5 >> 16) & 255);
            this.f2053g = i9 + 1;
            bArr[i9] = (byte) ((i5 >> 24) & 255);
            this.f2054h += 4;
        }

        final void d1(long j5) {
            byte[] bArr = this.f2051e;
            int i5 = this.f2053g;
            int i6 = i5 + 1;
            bArr[i5] = (byte) (j5 & 255);
            int i7 = i6 + 1;
            bArr[i6] = (byte) ((j5 >> 8) & 255);
            int i8 = i7 + 1;
            bArr[i7] = (byte) ((j5 >> 16) & 255);
            int i9 = i8 + 1;
            bArr[i8] = (byte) (255 & (j5 >> 24));
            int i10 = i9 + 1;
            bArr[i9] = (byte) (((int) (j5 >> 32)) & 255);
            int i11 = i10 + 1;
            bArr[i10] = (byte) (((int) (j5 >> 40)) & 255);
            int i12 = i11 + 1;
            bArr[i11] = (byte) (((int) (j5 >> 48)) & 255);
            this.f2053g = i12 + 1;
            bArr[i12] = (byte) (((int) (j5 >> 56)) & 255);
            this.f2054h += 8;
        }

        final void e1(int i5) {
            if (i5 >= 0) {
                g1(i5);
            } else {
                h1(i5);
            }
        }

        final void f1(int i5, int i6) {
            g1(c2.c(i5, i6));
        }

        final void g1(int i5) {
            if (!l.f2048d) {
                while ((i5 & (-128)) != 0) {
                    byte[] bArr = this.f2051e;
                    int i6 = this.f2053g;
                    this.f2053g = i6 + 1;
                    bArr[i6] = (byte) ((i5 & 127) | 128);
                    this.f2054h++;
                    i5 >>>= 7;
                }
                byte[] bArr2 = this.f2051e;
                int i7 = this.f2053g;
                this.f2053g = i7 + 1;
                bArr2[i7] = (byte) i5;
                this.f2054h++;
                return;
            }
            long j5 = this.f2053g;
            while ((i5 & (-128)) != 0) {
                byte[] bArr3 = this.f2051e;
                int i8 = this.f2053g;
                this.f2053g = i8 + 1;
                a2.O(bArr3, i8, (byte) ((i5 & 127) | 128));
                i5 >>>= 7;
            }
            byte[] bArr4 = this.f2051e;
            int i9 = this.f2053g;
            this.f2053g = i9 + 1;
            a2.O(bArr4, i9, (byte) i5);
            this.f2054h += (int) (this.f2053g - j5);
        }

        final void h1(long j5) {
            if (!l.f2048d) {
                while ((j5 & (-128)) != 0) {
                    byte[] bArr = this.f2051e;
                    int i5 = this.f2053g;
                    this.f2053g = i5 + 1;
                    bArr[i5] = (byte) ((((int) j5) & 127) | 128);
                    this.f2054h++;
                    j5 >>>= 7;
                }
                byte[] bArr2 = this.f2051e;
                int i6 = this.f2053g;
                this.f2053g = i6 + 1;
                bArr2[i6] = (byte) j5;
                this.f2054h++;
                return;
            }
            long j6 = this.f2053g;
            while ((j5 & (-128)) != 0) {
                byte[] bArr3 = this.f2051e;
                int i7 = this.f2053g;
                this.f2053g = i7 + 1;
                a2.O(bArr3, i7, (byte) ((((int) j5) & 127) | 128));
                j5 >>>= 7;
            }
            byte[] bArr4 = this.f2051e;
            int i8 = this.f2053g;
            this.f2053g = i8 + 1;
            a2.O(bArr4, i8, (byte) j5);
            this.f2054h += (int) (this.f2053g - j6);
        }

        @Override // com.google.protobuf.l
        public final int i0() {
            throw new UnsupportedOperationException("spaceLeft() can only be called on CodedOutputStreams that are writing to a flat array or ByteBuffer.");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c extends l {

        /* renamed from: e  reason: collision with root package name */
        private final byte[] f2055e;

        /* renamed from: f  reason: collision with root package name */
        private final int f2056f;

        /* renamed from: g  reason: collision with root package name */
        private final int f2057g;

        /* renamed from: h  reason: collision with root package name */
        private int f2058h;

        c(byte[] bArr, int i5, int i6) {
            super();
            if (bArr == null) {
                throw new NullPointerException("buffer");
            }
            int i7 = i5 + i6;
            if ((i5 | i6 | (bArr.length - i7)) < 0) {
                throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", Integer.valueOf(bArr.length), Integer.valueOf(i5), Integer.valueOf(i6)));
            }
            this.f2055e = bArr;
            this.f2056f = i5;
            this.f2058h = i5;
            this.f2057g = i7;
        }

        @Override // com.google.protobuf.l
        public final void E0(int i5, int i6) {
            W0(i5, 0);
            F0(i6);
        }

        @Override // com.google.protobuf.l
        public final void F0(int i5) {
            if (i5 >= 0) {
                Y0(i5);
            } else {
                a1(i5);
            }
        }

        @Override // com.google.protobuf.l
        final void I0(int i5, w0 w0Var, o1 o1Var) {
            W0(i5, 2);
            Y0(((com.google.protobuf.a) w0Var).q(o1Var));
            o1Var.b(w0Var, this.f2049a);
        }

        @Override // com.google.protobuf.l
        public final void J0(w0 w0Var) {
            Y0(w0Var.a());
            w0Var.f(this);
        }

        @Override // com.google.protobuf.l
        public final void K0(int i5, w0 w0Var) {
            W0(1, 3);
            X0(2, i5);
            d1(3, w0Var);
            W0(1, 4);
        }

        @Override // com.google.protobuf.l
        public final void L0(int i5, i iVar) {
            W0(1, 3);
            X0(2, i5);
            o0(3, iVar);
            W0(1, 4);
        }

        @Override // com.google.protobuf.l
        public final void U0(int i5, String str) {
            W0(i5, 2);
            V0(str);
        }

        @Override // com.google.protobuf.l
        public final void V0(String str) {
            int i5;
            int i6 = this.f2058h;
            try {
                int X = l.X(str.length() * 3);
                int X2 = l.X(str.length());
                if (X2 == X) {
                    int i7 = i6 + X2;
                    this.f2058h = i7;
                    i5 = b2.i(str, this.f2055e, i7, i0());
                    this.f2058h = i6;
                    Y0((i5 - i6) - X2);
                } else {
                    Y0(b2.j(str));
                    i5 = b2.i(str, this.f2055e, this.f2058h, i0());
                }
                this.f2058h = i5;
            } catch (b2.d e5) {
                this.f2058h = i6;
                d0(str, e5);
            } catch (IndexOutOfBoundsException e6) {
                throw new d(e6);
            }
        }

        @Override // com.google.protobuf.l
        public final void W0(int i5, int i6) {
            Y0(c2.c(i5, i6));
        }

        @Override // com.google.protobuf.l
        public final void X0(int i5, int i6) {
            W0(i5, 0);
            Y0(i6);
        }

        @Override // com.google.protobuf.l
        public final void Y0(int i5) {
            while ((i5 & (-128)) != 0) {
                try {
                    byte[] bArr = this.f2055e;
                    int i6 = this.f2058h;
                    this.f2058h = i6 + 1;
                    bArr[i6] = (byte) ((i5 & 127) | 128);
                    i5 >>>= 7;
                } catch (IndexOutOfBoundsException e5) {
                    throw new d(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f2058h), Integer.valueOf(this.f2057g), 1), e5);
                }
            }
            byte[] bArr2 = this.f2055e;
            int i7 = this.f2058h;
            this.f2058h = i7 + 1;
            bArr2[i7] = (byte) i5;
        }

        @Override // com.google.protobuf.l
        public final void Z0(int i5, long j5) {
            W0(i5, 0);
            a1(j5);
        }

        @Override // com.google.protobuf.h
        public final void a(ByteBuffer byteBuffer) {
            b1(byteBuffer);
        }

        @Override // com.google.protobuf.l
        public final void a1(long j5) {
            if (l.f2048d && i0() >= 10) {
                while ((j5 & (-128)) != 0) {
                    byte[] bArr = this.f2055e;
                    int i5 = this.f2058h;
                    this.f2058h = i5 + 1;
                    a2.O(bArr, i5, (byte) ((((int) j5) & 127) | 128));
                    j5 >>>= 7;
                }
                byte[] bArr2 = this.f2055e;
                int i6 = this.f2058h;
                this.f2058h = i6 + 1;
                a2.O(bArr2, i6, (byte) j5);
                return;
            }
            while ((j5 & (-128)) != 0) {
                try {
                    byte[] bArr3 = this.f2055e;
                    int i7 = this.f2058h;
                    this.f2058h = i7 + 1;
                    bArr3[i7] = (byte) ((((int) j5) & 127) | 128);
                    j5 >>>= 7;
                } catch (IndexOutOfBoundsException e5) {
                    throw new d(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f2058h), Integer.valueOf(this.f2057g), 1), e5);
                }
            }
            byte[] bArr4 = this.f2055e;
            int i8 = this.f2058h;
            this.f2058h = i8 + 1;
            bArr4[i8] = (byte) j5;
        }

        @Override // com.google.protobuf.l, com.google.protobuf.h
        public final void b(byte[] bArr, int i5, int i6) {
            c1(bArr, i5, i6);
        }

        public final void b1(ByteBuffer byteBuffer) {
            int remaining = byteBuffer.remaining();
            try {
                byteBuffer.get(this.f2055e, this.f2058h, remaining);
                this.f2058h += remaining;
            } catch (IndexOutOfBoundsException e5) {
                throw new d(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f2058h), Integer.valueOf(this.f2057g), Integer.valueOf(remaining)), e5);
            }
        }

        @Override // com.google.protobuf.l
        public void c0() {
        }

        public final void c1(byte[] bArr, int i5, int i6) {
            try {
                System.arraycopy(bArr, i5, this.f2055e, this.f2058h, i6);
                this.f2058h += i6;
            } catch (IndexOutOfBoundsException e5) {
                throw new d(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f2058h), Integer.valueOf(this.f2057g), Integer.valueOf(i6)), e5);
            }
        }

        public final void d1(int i5, w0 w0Var) {
            W0(i5, 2);
            J0(w0Var);
        }

        @Override // com.google.protobuf.l
        public final int i0() {
            return this.f2057g - this.f2058h;
        }

        @Override // com.google.protobuf.l
        public final void j0(byte b5) {
            try {
                byte[] bArr = this.f2055e;
                int i5 = this.f2058h;
                this.f2058h = i5 + 1;
                bArr[i5] = b5;
            } catch (IndexOutOfBoundsException e5) {
                throw new d(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f2058h), Integer.valueOf(this.f2057g), 1), e5);
            }
        }

        @Override // com.google.protobuf.l
        public final void k0(int i5, boolean z4) {
            W0(i5, 0);
            j0(z4 ? (byte) 1 : (byte) 0);
        }

        @Override // com.google.protobuf.l
        public final void n0(byte[] bArr, int i5, int i6) {
            Y0(i6);
            c1(bArr, i5, i6);
        }

        @Override // com.google.protobuf.l
        public final void o0(int i5, i iVar) {
            W0(i5, 2);
            p0(iVar);
        }

        @Override // com.google.protobuf.l
        public final void p0(i iVar) {
            Y0(iVar.size());
            iVar.P(this);
        }

        @Override // com.google.protobuf.l
        public final void u0(int i5, int i6) {
            W0(i5, 5);
            v0(i6);
        }

        @Override // com.google.protobuf.l
        public final void v0(int i5) {
            try {
                byte[] bArr = this.f2055e;
                int i6 = this.f2058h;
                int i7 = i6 + 1;
                bArr[i6] = (byte) (i5 & 255);
                int i8 = i7 + 1;
                bArr[i7] = (byte) ((i5 >> 8) & 255);
                int i9 = i8 + 1;
                bArr[i8] = (byte) ((i5 >> 16) & 255);
                this.f2058h = i9 + 1;
                bArr[i9] = (byte) ((i5 >> 24) & 255);
            } catch (IndexOutOfBoundsException e5) {
                throw new d(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f2058h), Integer.valueOf(this.f2057g), 1), e5);
            }
        }

        @Override // com.google.protobuf.l
        public final void w0(int i5, long j5) {
            W0(i5, 1);
            x0(j5);
        }

        @Override // com.google.protobuf.l
        public final void x0(long j5) {
            try {
                byte[] bArr = this.f2055e;
                int i5 = this.f2058h;
                int i6 = i5 + 1;
                bArr[i5] = (byte) (((int) j5) & 255);
                int i7 = i6 + 1;
                bArr[i6] = (byte) (((int) (j5 >> 8)) & 255);
                int i8 = i7 + 1;
                bArr[i7] = (byte) (((int) (j5 >> 16)) & 255);
                int i9 = i8 + 1;
                bArr[i8] = (byte) (((int) (j5 >> 24)) & 255);
                int i10 = i9 + 1;
                bArr[i9] = (byte) (((int) (j5 >> 32)) & 255);
                int i11 = i10 + 1;
                bArr[i10] = (byte) (((int) (j5 >> 40)) & 255);
                int i12 = i11 + 1;
                bArr[i11] = (byte) (((int) (j5 >> 48)) & 255);
                this.f2058h = i12 + 1;
                bArr[i12] = (byte) (((int) (j5 >> 56)) & 255);
            } catch (IndexOutOfBoundsException e5) {
                throw new d(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.f2058h), Integer.valueOf(this.f2057g), 1), e5);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class d extends IOException {
        d(String str, Throwable th) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.: " + str, th);
        }

        d(Throwable th) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.", th);
        }
    }

    /* loaded from: classes.dex */
    private static final class e extends b {

        /* renamed from: i  reason: collision with root package name */
        private final OutputStream f2059i;

        e(OutputStream outputStream, int i5) {
            super(i5);
            if (outputStream == null) {
                throw new NullPointerException("out");
            }
            this.f2059i = outputStream;
        }

        private void i1() {
            this.f2059i.write(this.f2051e, 0, this.f2053g);
            this.f2053g = 0;
        }

        private void j1(int i5) {
            if (this.f2052f - this.f2053g < i5) {
                i1();
            }
        }

        @Override // com.google.protobuf.l
        public void E0(int i5, int i6) {
            j1(20);
            f1(i5, 0);
            e1(i6);
        }

        @Override // com.google.protobuf.l
        public void F0(int i5) {
            if (i5 >= 0) {
                Y0(i5);
            } else {
                a1(i5);
            }
        }

        @Override // com.google.protobuf.l
        void I0(int i5, w0 w0Var, o1 o1Var) {
            W0(i5, 2);
            n1(w0Var, o1Var);
        }

        @Override // com.google.protobuf.l
        public void J0(w0 w0Var) {
            Y0(w0Var.a());
            w0Var.f(this);
        }

        @Override // com.google.protobuf.l
        public void K0(int i5, w0 w0Var) {
            W0(1, 3);
            X0(2, i5);
            m1(3, w0Var);
            W0(1, 4);
        }

        @Override // com.google.protobuf.l
        public void L0(int i5, i iVar) {
            W0(1, 3);
            X0(2, i5);
            o0(3, iVar);
            W0(1, 4);
        }

        @Override // com.google.protobuf.l
        public void U0(int i5, String str) {
            W0(i5, 2);
            V0(str);
        }

        @Override // com.google.protobuf.l
        public void V0(String str) {
            int j5;
            try {
                int length = str.length() * 3;
                int X = l.X(length);
                int i5 = X + length;
                int i6 = this.f2052f;
                if (i5 > i6) {
                    byte[] bArr = new byte[length];
                    int i7 = b2.i(str, bArr, 0, length);
                    Y0(i7);
                    b(bArr, 0, i7);
                    return;
                }
                if (i5 > i6 - this.f2053g) {
                    i1();
                }
                int X2 = l.X(str.length());
                int i8 = this.f2053g;
                try {
                    if (X2 == X) {
                        int i9 = i8 + X2;
                        this.f2053g = i9;
                        int i10 = b2.i(str, this.f2051e, i9, this.f2052f - i9);
                        this.f2053g = i8;
                        j5 = (i10 - i8) - X2;
                        g1(j5);
                        this.f2053g = i10;
                    } else {
                        j5 = b2.j(str);
                        g1(j5);
                        this.f2053g = b2.i(str, this.f2051e, this.f2053g, j5);
                    }
                    this.f2054h += j5;
                } catch (b2.d e5) {
                    this.f2054h -= this.f2053g - i8;
                    this.f2053g = i8;
                    throw e5;
                } catch (ArrayIndexOutOfBoundsException e6) {
                    throw new d(e6);
                }
            } catch (b2.d e7) {
                d0(str, e7);
            }
        }

        @Override // com.google.protobuf.l
        public void W0(int i5, int i6) {
            Y0(c2.c(i5, i6));
        }

        @Override // com.google.protobuf.l
        public void X0(int i5, int i6) {
            j1(20);
            f1(i5, 0);
            g1(i6);
        }

        @Override // com.google.protobuf.l
        public void Y0(int i5) {
            j1(5);
            g1(i5);
        }

        @Override // com.google.protobuf.l
        public void Z0(int i5, long j5) {
            j1(20);
            f1(i5, 0);
            h1(j5);
        }

        @Override // com.google.protobuf.h
        public void a(ByteBuffer byteBuffer) {
            k1(byteBuffer);
        }

        @Override // com.google.protobuf.l
        public void a1(long j5) {
            j1(10);
            h1(j5);
        }

        @Override // com.google.protobuf.l, com.google.protobuf.h
        public void b(byte[] bArr, int i5, int i6) {
            l1(bArr, i5, i6);
        }

        @Override // com.google.protobuf.l
        public void c0() {
            if (this.f2053g > 0) {
                i1();
            }
        }

        @Override // com.google.protobuf.l
        public void j0(byte b5) {
            if (this.f2053g == this.f2052f) {
                i1();
            }
            b1(b5);
        }

        @Override // com.google.protobuf.l
        public void k0(int i5, boolean z4) {
            j1(11);
            f1(i5, 0);
            b1(z4 ? (byte) 1 : (byte) 0);
        }

        public void k1(ByteBuffer byteBuffer) {
            int remaining = byteBuffer.remaining();
            int i5 = this.f2052f;
            int i6 = this.f2053g;
            if (i5 - i6 >= remaining) {
                byteBuffer.get(this.f2051e, i6, remaining);
                this.f2053g += remaining;
            } else {
                int i7 = i5 - i6;
                byteBuffer.get(this.f2051e, i6, i7);
                remaining -= i7;
                this.f2053g = this.f2052f;
                this.f2054h += i7;
                i1();
                while (true) {
                    int i8 = this.f2052f;
                    if (remaining <= i8) {
                        break;
                    }
                    byteBuffer.get(this.f2051e, 0, i8);
                    this.f2059i.write(this.f2051e, 0, this.f2052f);
                    int i9 = this.f2052f;
                    remaining -= i9;
                    this.f2054h += i9;
                }
                byteBuffer.get(this.f2051e, 0, remaining);
                this.f2053g = remaining;
            }
            this.f2054h += remaining;
        }

        public void l1(byte[] bArr, int i5, int i6) {
            int i7 = this.f2052f;
            int i8 = this.f2053g;
            if (i7 - i8 >= i6) {
                System.arraycopy(bArr, i5, this.f2051e, i8, i6);
                this.f2053g += i6;
            } else {
                int i9 = i7 - i8;
                System.arraycopy(bArr, i5, this.f2051e, i8, i9);
                int i10 = i5 + i9;
                i6 -= i9;
                this.f2053g = this.f2052f;
                this.f2054h += i9;
                i1();
                if (i6 <= this.f2052f) {
                    System.arraycopy(bArr, i10, this.f2051e, 0, i6);
                    this.f2053g = i6;
                } else {
                    this.f2059i.write(bArr, i10, i6);
                }
            }
            this.f2054h += i6;
        }

        public void m1(int i5, w0 w0Var) {
            W0(i5, 2);
            J0(w0Var);
        }

        @Override // com.google.protobuf.l
        public void n0(byte[] bArr, int i5, int i6) {
            Y0(i6);
            l1(bArr, i5, i6);
        }

        void n1(w0 w0Var, o1 o1Var) {
            Y0(((com.google.protobuf.a) w0Var).q(o1Var));
            o1Var.b(w0Var, this.f2049a);
        }

        @Override // com.google.protobuf.l
        public void o0(int i5, i iVar) {
            W0(i5, 2);
            p0(iVar);
        }

        @Override // com.google.protobuf.l
        public void p0(i iVar) {
            Y0(iVar.size());
            iVar.P(this);
        }

        @Override // com.google.protobuf.l
        public void u0(int i5, int i6) {
            j1(14);
            f1(i5, 5);
            c1(i6);
        }

        @Override // com.google.protobuf.l
        public void v0(int i5) {
            j1(4);
            c1(i5);
        }

        @Override // com.google.protobuf.l
        public void w0(int i5, long j5) {
            j1(18);
            f1(i5, 1);
            d1(j5);
        }

        @Override // com.google.protobuf.l
        public void x0(long j5) {
            j1(8);
            d1(j5);
        }
    }

    private l() {
    }

    public static int A(int i5, j0 j0Var) {
        return (V(1) * 2) + W(2, i5) + B(3, j0Var);
    }

    public static int B(int i5, j0 j0Var) {
        return V(i5) + C(j0Var);
    }

    public static int C(j0 j0Var) {
        return D(j0Var.b());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int D(int i5) {
        return X(i5) + i5;
    }

    public static int E(int i5, w0 w0Var) {
        return (V(1) * 2) + W(2, i5) + F(3, w0Var);
    }

    public static int F(int i5, w0 w0Var) {
        return V(i5) + H(w0Var);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int G(int i5, w0 w0Var, o1 o1Var) {
        return V(i5) + I(w0Var, o1Var);
    }

    public static int H(w0 w0Var) {
        return D(w0Var.a());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int I(w0 w0Var, o1 o1Var) {
        return D(((com.google.protobuf.a) w0Var).q(o1Var));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int J(int i5) {
        if (i5 > 4096) {
            return 4096;
        }
        return i5;
    }

    public static int K(int i5, i iVar) {
        return (V(1) * 2) + W(2, i5) + h(3, iVar);
    }

    public static int L(int i5, int i6) {
        return V(i5) + M(i6);
    }

    public static int M(int i5) {
        return 4;
    }

    public static int N(int i5, long j5) {
        return V(i5) + O(j5);
    }

    public static int O(long j5) {
        return 8;
    }

    public static int P(int i5, int i6) {
        return V(i5) + Q(i6);
    }

    public static int Q(int i5) {
        return X(a0(i5));
    }

    public static int R(int i5, long j5) {
        return V(i5) + S(j5);
    }

    public static int S(long j5) {
        return Z(b0(j5));
    }

    public static int T(int i5, String str) {
        return V(i5) + U(str);
    }

    public static int U(String str) {
        int length;
        try {
            length = b2.j(str);
        } catch (b2.d unused) {
            length = str.getBytes(d0.f1911b).length;
        }
        return D(length);
    }

    public static int V(int i5) {
        return X(c2.c(i5, 0));
    }

    public static int W(int i5, int i6) {
        return V(i5) + X(i6);
    }

    public static int X(int i5) {
        if ((i5 & (-128)) == 0) {
            return 1;
        }
        if ((i5 & (-16384)) == 0) {
            return 2;
        }
        if (((-2097152) & i5) == 0) {
            return 3;
        }
        return (i5 & (-268435456)) == 0 ? 4 : 5;
    }

    public static int Y(int i5, long j5) {
        return V(i5) + Z(j5);
    }

    public static int Z(long j5) {
        int i5;
        if (((-128) & j5) == 0) {
            return 1;
        }
        if (j5 < 0) {
            return 10;
        }
        if (((-34359738368L) & j5) != 0) {
            i5 = 6;
            j5 >>>= 28;
        } else {
            i5 = 2;
        }
        if (((-2097152) & j5) != 0) {
            i5 += 2;
            j5 >>>= 14;
        }
        return (j5 & (-16384)) != 0 ? i5 + 1 : i5;
    }

    public static int a0(int i5) {
        return (i5 >> 31) ^ (i5 << 1);
    }

    public static long b0(long j5) {
        return (j5 >> 63) ^ (j5 << 1);
    }

    public static int e(int i5, boolean z4) {
        return V(i5) + f(z4);
    }

    public static int f(boolean z4) {
        return 1;
    }

    public static l f0(OutputStream outputStream, int i5) {
        return new e(outputStream, i5);
    }

    public static int g(byte[] bArr) {
        return D(bArr.length);
    }

    public static l g0(byte[] bArr) {
        return h0(bArr, 0, bArr.length);
    }

    public static int h(int i5, i iVar) {
        return V(i5) + i(iVar);
    }

    public static l h0(byte[] bArr, int i5, int i6) {
        return new c(bArr, i5, i6);
    }

    public static int i(i iVar) {
        return D(iVar.size());
    }

    public static int j(int i5, double d5) {
        return V(i5) + k(d5);
    }

    public static int k(double d5) {
        return 8;
    }

    public static int l(int i5, int i6) {
        return V(i5) + m(i6);
    }

    public static int m(int i5) {
        return x(i5);
    }

    public static int n(int i5, int i6) {
        return V(i5) + o(i6);
    }

    public static int o(int i5) {
        return 4;
    }

    public static int p(int i5, long j5) {
        return V(i5) + q(j5);
    }

    public static int q(long j5) {
        return 8;
    }

    public static int r(int i5, float f5) {
        return V(i5) + s(f5);
    }

    public static int s(float f5) {
        return 4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Deprecated
    public static int t(int i5, w0 w0Var, o1 o1Var) {
        return (V(i5) * 2) + v(w0Var, o1Var);
    }

    @Deprecated
    public static int u(w0 w0Var) {
        return w0Var.a();
    }

    @Deprecated
    static int v(w0 w0Var, o1 o1Var) {
        return ((com.google.protobuf.a) w0Var).q(o1Var);
    }

    public static int w(int i5, int i6) {
        return V(i5) + x(i6);
    }

    public static int x(int i5) {
        if (i5 >= 0) {
            return X(i5);
        }
        return 10;
    }

    public static int y(int i5, long j5) {
        return V(i5) + z(j5);
    }

    public static int z(long j5) {
        return Z(j5);
    }

    @Deprecated
    public final void A0(int i5, w0 w0Var) {
        W0(i5, 3);
        C0(w0Var);
        W0(i5, 4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Deprecated
    public final void B0(int i5, w0 w0Var, o1 o1Var) {
        W0(i5, 3);
        D0(w0Var, o1Var);
        W0(i5, 4);
    }

    @Deprecated
    public final void C0(w0 w0Var) {
        w0Var.f(this);
    }

    @Deprecated
    final void D0(w0 w0Var, o1 o1Var) {
        o1Var.b(w0Var, this.f2049a);
    }

    public abstract void E0(int i5, int i6);

    public abstract void F0(int i5);

    public final void G0(int i5, long j5) {
        Z0(i5, j5);
    }

    public final void H0(long j5) {
        a1(j5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void I0(int i5, w0 w0Var, o1 o1Var);

    public abstract void J0(w0 w0Var);

    public abstract void K0(int i5, w0 w0Var);

    public abstract void L0(int i5, i iVar);

    public final void M0(int i5, int i6) {
        u0(i5, i6);
    }

    public final void N0(int i5) {
        v0(i5);
    }

    public final void O0(int i5, long j5) {
        w0(i5, j5);
    }

    public final void P0(long j5) {
        x0(j5);
    }

    public final void Q0(int i5, int i6) {
        X0(i5, a0(i6));
    }

    public final void R0(int i5) {
        Y0(a0(i5));
    }

    public final void S0(int i5, long j5) {
        Z0(i5, b0(j5));
    }

    public final void T0(long j5) {
        a1(b0(j5));
    }

    public abstract void U0(int i5, String str);

    public abstract void V0(String str);

    public abstract void W0(int i5, int i6);

    public abstract void X0(int i5, int i6);

    public abstract void Y0(int i5);

    public abstract void Z0(int i5, long j5);

    public abstract void a1(long j5);

    @Override // com.google.protobuf.h
    public abstract void b(byte[] bArr, int i5, int i6);

    public abstract void c0();

    public final void d() {
        if (i0() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    final void d0(String str, b2.d dVar) {
        f2047c.log(Level.WARNING, "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) dVar);
        byte[] bytes = str.getBytes(d0.f1911b);
        try {
            Y0(bytes.length);
            b(bytes, 0, bytes.length);
        } catch (IndexOutOfBoundsException e5) {
            throw new d(e5);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean e0() {
        return this.f2050b;
    }

    public abstract int i0();

    public abstract void j0(byte b5);

    public abstract void k0(int i5, boolean z4);

    public final void l0(boolean z4) {
        j0(z4 ? (byte) 1 : (byte) 0);
    }

    public final void m0(byte[] bArr) {
        n0(bArr, 0, bArr.length);
    }

    abstract void n0(byte[] bArr, int i5, int i6);

    public abstract void o0(int i5, i iVar);

    public abstract void p0(i iVar);

    public final void q0(int i5, double d5) {
        w0(i5, Double.doubleToRawLongBits(d5));
    }

    public final void r0(double d5) {
        x0(Double.doubleToRawLongBits(d5));
    }

    public final void s0(int i5, int i6) {
        E0(i5, i6);
    }

    public final void t0(int i5) {
        F0(i5);
    }

    public abstract void u0(int i5, int i6);

    public abstract void v0(int i5);

    public abstract void w0(int i5, long j5);

    public abstract void x0(long j5);

    public final void y0(int i5, float f5) {
        u0(i5, Float.floatToRawIntBits(f5));
    }

    public final void z0(float f5) {
        v0(Float.floatToRawIntBits(f5));
    }
}
