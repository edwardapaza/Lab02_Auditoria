package k3;

import io.grpc.internal.x1;
import java.io.EOFException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
/* loaded from: classes.dex */
class l extends io.grpc.internal.c {

    /* renamed from: a  reason: collision with root package name */
    private final w4.c f5811a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(w4.c cVar) {
        this.f5811a = cVar;
    }

    private void d() {
    }

    @Override // io.grpc.internal.x1
    public void Q(OutputStream outputStream, int i5) {
        this.f5811a.f0(outputStream, i5);
    }

    @Override // io.grpc.internal.x1
    public void a0(ByteBuffer byteBuffer) {
        throw new UnsupportedOperationException();
    }

    @Override // io.grpc.internal.x1
    public int b() {
        return (int) this.f5811a.size();
    }

    @Override // io.grpc.internal.c, io.grpc.internal.x1, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f5811a.d();
    }

    @Override // io.grpc.internal.x1
    public void d0(byte[] bArr, int i5, int i6) {
        while (i6 > 0) {
            int read = this.f5811a.read(bArr, i5, i6);
            if (read == -1) {
                throw new IndexOutOfBoundsException("EOF trying to read " + i6 + " bytes");
            }
            i6 -= read;
            i5 += read;
        }
    }

    @Override // io.grpc.internal.x1
    public int readUnsignedByte() {
        try {
            d();
            return this.f5811a.readByte() & 255;
        } catch (EOFException e5) {
            throw new IndexOutOfBoundsException(e5.getMessage());
        }
    }

    @Override // io.grpc.internal.x1
    public void skipBytes(int i5) {
        try {
            this.f5811a.skip(i5);
        } catch (EOFException e5) {
            throw new IndexOutOfBoundsException(e5.getMessage());
        }
    }

    @Override // io.grpc.internal.x1
    public x1 t(int i5) {
        w4.c cVar = new w4.c();
        cVar.Z(this.f5811a, i5);
        return new l(cVar);
    }
}
