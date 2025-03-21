package k3;

import io.grpc.internal.u2;
/* loaded from: classes.dex */
class o implements u2 {

    /* renamed from: a  reason: collision with root package name */
    private final w4.c f5813a;

    /* renamed from: b  reason: collision with root package name */
    private int f5814b;

    /* renamed from: c  reason: collision with root package name */
    private int f5815c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(w4.c cVar, int i5) {
        this.f5813a = cVar;
        this.f5814b = i5;
    }

    @Override // io.grpc.internal.u2
    public int a() {
        return this.f5814b;
    }

    @Override // io.grpc.internal.u2
    public int b() {
        return this.f5815c;
    }

    @Override // io.grpc.internal.u2
    public void c(byte b5) {
        this.f5813a.writeByte(b5);
        this.f5814b--;
        this.f5815c++;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public w4.c d() {
        return this.f5813a;
    }

    @Override // io.grpc.internal.u2
    public void release() {
    }

    @Override // io.grpc.internal.u2
    public void write(byte[] bArr, int i5, int i6) {
        this.f5813a.S(bArr, i5, i6);
        this.f5814b -= i6;
        this.f5815c += i6;
    }
}
