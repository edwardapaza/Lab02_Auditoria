package k3;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import k3.j;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class b implements m3.c {

    /* renamed from: d  reason: collision with root package name */
    private static final Logger f5668d = Logger.getLogger(i.class.getName());

    /* renamed from: a  reason: collision with root package name */
    private final a f5669a;

    /* renamed from: b  reason: collision with root package name */
    private final m3.c f5670b;

    /* renamed from: c  reason: collision with root package name */
    private final j f5671c = new j(Level.FINE, i.class);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface a {
        void d(Throwable th);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, m3.c cVar) {
        this.f5669a = (a) z0.k.o(aVar, "transportExceptionHandler");
        this.f5670b = (m3.c) z0.k.o(cVar, "frameWriter");
    }

    static Level c(Throwable th) {
        return th.getClass().equals(IOException.class) ? Level.FINE : Level.INFO;
    }

    @Override // m3.c
    public void E() {
        try {
            this.f5670b.E();
        } catch (IOException e5) {
            this.f5669a.d(e5);
        }
    }

    @Override // m3.c
    public void F(m3.i iVar) {
        this.f5671c.i(j.a.OUTBOUND, iVar);
        try {
            this.f5670b.F(iVar);
        } catch (IOException e5) {
            this.f5669a.d(e5);
        }
    }

    @Override // m3.c
    public void H(m3.i iVar) {
        this.f5671c.j(j.a.OUTBOUND);
        try {
            this.f5670b.H(iVar);
        } catch (IOException e5) {
            this.f5669a.d(e5);
        }
    }

    @Override // m3.c
    public void T(int i5, m3.a aVar, byte[] bArr) {
        this.f5671c.c(j.a.OUTBOUND, i5, aVar, w4.f.m(bArr));
        try {
            this.f5670b.T(i5, aVar, bArr);
            this.f5670b.flush();
        } catch (IOException e5) {
            this.f5669a.d(e5);
        }
    }

    @Override // m3.c
    public int V() {
        return this.f5670b.V();
    }

    @Override // m3.c
    public void W(boolean z4, boolean z5, int i5, int i6, List<m3.d> list) {
        try {
            this.f5670b.W(z4, z5, i5, i6, list);
        } catch (IOException e5) {
            this.f5669a.d(e5);
        }
    }

    @Override // m3.c
    public void a(int i5, m3.a aVar) {
        this.f5671c.h(j.a.OUTBOUND, i5, aVar);
        try {
            this.f5670b.a(i5, aVar);
        } catch (IOException e5) {
            this.f5669a.d(e5);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        try {
            this.f5670b.close();
        } catch (IOException e5) {
            f5668d.log(c(e5), "Failed closing connection", (Throwable) e5);
        }
    }

    @Override // m3.c
    public void e(boolean z4, int i5, int i6) {
        j jVar = this.f5671c;
        j.a aVar = j.a.OUTBOUND;
        long j5 = (4294967295L & i6) | (i5 << 32);
        if (z4) {
            jVar.f(aVar, j5);
        } else {
            jVar.e(aVar, j5);
        }
        try {
            this.f5670b.e(z4, i5, i6);
        } catch (IOException e5) {
            this.f5669a.d(e5);
        }
    }

    @Override // m3.c
    public void f(int i5, long j5) {
        this.f5671c.k(j.a.OUTBOUND, i5, j5);
        try {
            this.f5670b.f(i5, j5);
        } catch (IOException e5) {
            this.f5669a.d(e5);
        }
    }

    @Override // m3.c
    public void flush() {
        try {
            this.f5670b.flush();
        } catch (IOException e5) {
            this.f5669a.d(e5);
        }
    }

    @Override // m3.c
    public void q(boolean z4, int i5, w4.c cVar, int i6) {
        this.f5671c.b(j.a.OUTBOUND, i5, cVar.c(), i6, z4);
        try {
            this.f5670b.q(z4, i5, cVar, i6);
        } catch (IOException e5) {
            this.f5669a.d(e5);
        }
    }
}
