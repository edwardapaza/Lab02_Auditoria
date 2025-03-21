package io.grpc.internal;
/* loaded from: classes.dex */
public abstract class c implements x1 {
    /* JADX INFO: Access modifiers changed from: protected */
    public final void c(int i5) {
        if (b() < i5) {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override // io.grpc.internal.x1, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // io.grpc.internal.x1
    public void m() {
    }

    @Override // io.grpc.internal.x1
    public boolean markSupported() {
        return false;
    }

    public final int readInt() {
        c(4);
        return (readUnsignedByte() << 24) | (readUnsignedByte() << 16) | (readUnsignedByte() << 8) | readUnsignedByte();
    }

    @Override // io.grpc.internal.x1
    public void reset() {
        throw new UnsupportedOperationException();
    }
}
