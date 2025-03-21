package io.grpc.internal;

import java.io.Closeable;
import java.io.OutputStream;
import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public interface x1 extends Closeable {
    void Q(OutputStream outputStream, int i5);

    void a0(ByteBuffer byteBuffer);

    int b();

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    void d0(byte[] bArr, int i5, int i6);

    void m();

    boolean markSupported();

    int readUnsignedByte();

    void reset();

    void skipBytes(int i5);

    x1 t(int i5);
}
