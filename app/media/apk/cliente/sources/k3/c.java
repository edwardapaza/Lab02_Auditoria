package k3;

import java.util.List;
/* loaded from: classes.dex */
abstract class c implements m3.c {

    /* renamed from: a  reason: collision with root package name */
    private final m3.c f5672a;

    public c(m3.c cVar) {
        this.f5672a = (m3.c) z0.k.o(cVar, "delegate");
    }

    @Override // m3.c
    public void E() {
        this.f5672a.E();
    }

    @Override // m3.c
    public void F(m3.i iVar) {
        this.f5672a.F(iVar);
    }

    @Override // m3.c
    public void H(m3.i iVar) {
        this.f5672a.H(iVar);
    }

    @Override // m3.c
    public void T(int i5, m3.a aVar, byte[] bArr) {
        this.f5672a.T(i5, aVar, bArr);
    }

    @Override // m3.c
    public int V() {
        return this.f5672a.V();
    }

    @Override // m3.c
    public void W(boolean z4, boolean z5, int i5, int i6, List<m3.d> list) {
        this.f5672a.W(z4, z5, i5, i6, list);
    }

    @Override // m3.c
    public void a(int i5, m3.a aVar) {
        this.f5672a.a(i5, aVar);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f5672a.close();
    }

    @Override // m3.c
    public void e(boolean z4, int i5, int i6) {
        this.f5672a.e(z4, i5, i6);
    }

    @Override // m3.c
    public void f(int i5, long j5) {
        this.f5672a.f(i5, j5);
    }

    @Override // m3.c
    public void flush() {
        this.f5672a.flush();
    }

    @Override // m3.c
    public void q(boolean z4, int i5, w4.c cVar, int i6) {
        this.f5672a.q(z4, i5, cVar, i6);
    }
}
