package io.grpc.internal;

import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.InvalidMarkException;
import java.nio.charset.Charset;
/* loaded from: classes.dex */
public final class y1 {

    /* renamed from: a  reason: collision with root package name */
    private static final x1 f5321a = new c(new byte[0]);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends q0 {
        a(x1 x1Var) {
            super(x1Var);
        }

        @Override // io.grpc.internal.x1, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }
    }

    /* loaded from: classes.dex */
    private static final class b extends InputStream implements i3.q0 {

        /* renamed from: a  reason: collision with root package name */
        private x1 f5322a;

        public b(x1 x1Var) {
            this.f5322a = (x1) z0.k.o(x1Var, "buffer");
        }

        @Override // java.io.InputStream
        public int available() {
            return this.f5322a.b();
        }

        @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.f5322a.close();
        }

        @Override // java.io.InputStream
        public void mark(int i5) {
            this.f5322a.m();
        }

        @Override // java.io.InputStream
        public boolean markSupported() {
            return this.f5322a.markSupported();
        }

        @Override // java.io.InputStream
        public int read() {
            if (this.f5322a.b() == 0) {
                return -1;
            }
            return this.f5322a.readUnsignedByte();
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i5, int i6) {
            if (this.f5322a.b() == 0) {
                return -1;
            }
            int min = Math.min(this.f5322a.b(), i6);
            this.f5322a.d0(bArr, i5, min);
            return min;
        }

        @Override // java.io.InputStream
        public void reset() {
            this.f5322a.reset();
        }

        @Override // java.io.InputStream
        public long skip(long j5) {
            int min = (int) Math.min(this.f5322a.b(), j5);
            this.f5322a.skipBytes(min);
            return min;
        }
    }

    /* loaded from: classes.dex */
    private static class c extends io.grpc.internal.c {

        /* renamed from: a  reason: collision with root package name */
        int f5323a;

        /* renamed from: b  reason: collision with root package name */
        final int f5324b;

        /* renamed from: c  reason: collision with root package name */
        final byte[] f5325c;

        /* renamed from: d  reason: collision with root package name */
        int f5326d;

        c(byte[] bArr) {
            this(bArr, 0, bArr.length);
        }

        c(byte[] bArr, int i5, int i6) {
            this.f5326d = -1;
            z0.k.e(i5 >= 0, "offset must be >= 0");
            z0.k.e(i6 >= 0, "length must be >= 0");
            int i7 = i6 + i5;
            z0.k.e(i7 <= bArr.length, "offset + length exceeds array boundary");
            this.f5325c = (byte[]) z0.k.o(bArr, "bytes");
            this.f5323a = i5;
            this.f5324b = i7;
        }

        @Override // io.grpc.internal.x1
        public void Q(OutputStream outputStream, int i5) {
            c(i5);
            outputStream.write(this.f5325c, this.f5323a, i5);
            this.f5323a += i5;
        }

        @Override // io.grpc.internal.x1
        public void a0(ByteBuffer byteBuffer) {
            z0.k.o(byteBuffer, "dest");
            int remaining = byteBuffer.remaining();
            c(remaining);
            byteBuffer.put(this.f5325c, this.f5323a, remaining);
            this.f5323a += remaining;
        }

        @Override // io.grpc.internal.x1
        public int b() {
            return this.f5324b - this.f5323a;
        }

        @Override // io.grpc.internal.x1
        /* renamed from: d */
        public c t(int i5) {
            c(i5);
            int i6 = this.f5323a;
            this.f5323a = i6 + i5;
            return new c(this.f5325c, i6, i5);
        }

        @Override // io.grpc.internal.x1
        public void d0(byte[] bArr, int i5, int i6) {
            System.arraycopy(this.f5325c, this.f5323a, bArr, i5, i6);
            this.f5323a += i6;
        }

        @Override // io.grpc.internal.c, io.grpc.internal.x1
        public void m() {
            this.f5326d = this.f5323a;
        }

        @Override // io.grpc.internal.c, io.grpc.internal.x1
        public boolean markSupported() {
            return true;
        }

        @Override // io.grpc.internal.x1
        public int readUnsignedByte() {
            c(1);
            byte[] bArr = this.f5325c;
            int i5 = this.f5323a;
            this.f5323a = i5 + 1;
            return bArr[i5] & 255;
        }

        @Override // io.grpc.internal.c, io.grpc.internal.x1
        public void reset() {
            int i5 = this.f5326d;
            if (i5 == -1) {
                throw new InvalidMarkException();
            }
            this.f5323a = i5;
        }

        @Override // io.grpc.internal.x1
        public void skipBytes(int i5) {
            c(i5);
            this.f5323a += i5;
        }
    }

    public static x1 a() {
        return f5321a;
    }

    public static x1 b(x1 x1Var) {
        return new a(x1Var);
    }

    public static InputStream c(x1 x1Var, boolean z4) {
        if (!z4) {
            x1Var = b(x1Var);
        }
        return new b(x1Var);
    }

    public static byte[] d(x1 x1Var) {
        z0.k.o(x1Var, "buffer");
        int b5 = x1Var.b();
        byte[] bArr = new byte[b5];
        x1Var.d0(bArr, 0, b5);
        return bArr;
    }

    public static String e(x1 x1Var, Charset charset) {
        z0.k.o(charset, "charset");
        return new String(d(x1Var), charset);
    }

    public static x1 f(byte[] bArr, int i5, int i6) {
        return new c(bArr, i5, i6);
    }
}
