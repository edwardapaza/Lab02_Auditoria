package io.grpc.internal;

import java.io.OutputStream;
import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public abstract class q0 implements x1 {

    /* renamed from: a  reason: collision with root package name */
    private final x1 f5107a;

    /* JADX INFO: Access modifiers changed from: protected */
    public q0(x1 x1Var) {
        this.f5107a = (x1) z0.k.o(x1Var, "buf");
    }

    @Override // io.grpc.internal.x1
    public void Q(OutputStream outputStream, int i5) {
        this.f5107a.Q(outputStream, i5);
    }

    @Override // io.grpc.internal.x1
    public void a0(ByteBuffer byteBuffer) {
        this.f5107a.a0(byteBuffer);
    }

    @Override // io.grpc.internal.x1
    public int b() {
        return this.f5107a.b();
    }

    @Override // io.grpc.internal.x1
    public void d0(byte[] bArr, int i5, int i6) {
        this.f5107a.d0(bArr, i5, i6);
    }

    @Override // io.grpc.internal.x1
    public void m() {
        this.f5107a.m();
    }

    @Override // io.grpc.internal.x1
    public boolean markSupported() {
        return this.f5107a.markSupported();
    }

    @Override // io.grpc.internal.x1
    public int readUnsignedByte() {
        return this.f5107a.readUnsignedByte();
    }

    @Override // io.grpc.internal.x1
    public void reset() {
        this.f5107a.reset();
    }

    @Override // io.grpc.internal.x1
    public void skipBytes(int i5) {
        this.f5107a.skipBytes(i5);
    }

    @Override // io.grpc.internal.x1
    public x1 t(int i5) {
        return this.f5107a.t(i5);
    }

    public String toString() {
        return z0.f.b(this).d("delegate", this.f5107a).toString();
    }
}
