package io.grpc.internal;

import i3.l;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
/* loaded from: classes.dex */
public class o1 implements r0 {

    /* renamed from: a  reason: collision with root package name */
    private final d f5066a;

    /* renamed from: c  reason: collision with root package name */
    private u2 f5068c;

    /* renamed from: h  reason: collision with root package name */
    private final v2 f5073h;

    /* renamed from: i  reason: collision with root package name */
    private final n2 f5074i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f5075j;

    /* renamed from: k  reason: collision with root package name */
    private int f5076k;

    /* renamed from: m  reason: collision with root package name */
    private long f5078m;

    /* renamed from: b  reason: collision with root package name */
    private int f5067b = -1;

    /* renamed from: d  reason: collision with root package name */
    private i3.n f5069d = l.b.f3486a;

    /* renamed from: e  reason: collision with root package name */
    private boolean f5070e = true;

    /* renamed from: f  reason: collision with root package name */
    private final c f5071f = new c();

    /* renamed from: g  reason: collision with root package name */
    private final ByteBuffer f5072g = ByteBuffer.allocate(5);

    /* renamed from: l  reason: collision with root package name */
    private int f5077l = -1;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public final class b extends OutputStream {

        /* renamed from: a  reason: collision with root package name */
        private final List<u2> f5079a;

        /* renamed from: b  reason: collision with root package name */
        private u2 f5080b;

        private b() {
            this.f5079a = new ArrayList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int b() {
            int i5 = 0;
            for (u2 u2Var : this.f5079a) {
                i5 += u2Var.b();
            }
            return i5;
        }

        @Override // java.io.OutputStream
        public void write(int i5) {
            u2 u2Var = this.f5080b;
            if (u2Var == null || u2Var.a() <= 0) {
                write(new byte[]{(byte) i5}, 0, 1);
            } else {
                this.f5080b.c((byte) i5);
            }
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i5, int i6) {
            if (this.f5080b == null) {
                u2 a5 = o1.this.f5073h.a(i6);
                this.f5080b = a5;
                this.f5079a.add(a5);
            }
            while (i6 > 0) {
                int min = Math.min(i6, this.f5080b.a());
                if (min == 0) {
                    u2 a6 = o1.this.f5073h.a(Math.max(i6, this.f5080b.b() * 2));
                    this.f5080b = a6;
                    this.f5079a.add(a6);
                } else {
                    this.f5080b.write(bArr, i5, min);
                    i5 += min;
                    i6 -= min;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class c extends OutputStream {
        private c() {
        }

        @Override // java.io.OutputStream
        public void write(int i5) {
            write(new byte[]{(byte) i5}, 0, 1);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i5, int i6) {
            o1.this.n(bArr, i5, i6);
        }
    }

    /* loaded from: classes.dex */
    public interface d {
        void o(u2 u2Var, boolean z4, boolean z5, int i5);
    }

    public o1(d dVar, v2 v2Var, n2 n2Var) {
        this.f5066a = (d) z0.k.o(dVar, "sink");
        this.f5073h = (v2) z0.k.o(v2Var, "bufferAllocator");
        this.f5074i = (n2) z0.k.o(n2Var, "statsTraceCtx");
    }

    private void f(boolean z4, boolean z5) {
        u2 u2Var = this.f5068c;
        this.f5068c = null;
        this.f5066a.o(u2Var, z4, z5, this.f5076k);
        this.f5076k = 0;
    }

    private int g(InputStream inputStream) {
        if ((inputStream instanceof i3.q0) || (inputStream instanceof ByteArrayInputStream)) {
            return inputStream.available();
        }
        return -1;
    }

    private void h() {
        u2 u2Var = this.f5068c;
        if (u2Var != null) {
            u2Var.release();
            this.f5068c = null;
        }
    }

    private void j() {
        if (isClosed()) {
            throw new IllegalStateException("Framer already closed");
        }
    }

    private void k(b bVar, boolean z4) {
        int b5 = bVar.b();
        this.f5072g.clear();
        this.f5072g.put(z4 ? (byte) 1 : (byte) 0).putInt(b5);
        u2 a5 = this.f5073h.a(5);
        a5.write(this.f5072g.array(), 0, this.f5072g.position());
        if (b5 == 0) {
            this.f5068c = a5;
            return;
        }
        this.f5066a.o(a5, false, false, this.f5076k - 1);
        this.f5076k = 1;
        List list = bVar.f5079a;
        for (int i5 = 0; i5 < list.size() - 1; i5++) {
            this.f5066a.o((u2) list.get(i5), false, false, 0);
        }
        this.f5068c = (u2) list.get(list.size() - 1);
        this.f5078m = b5;
    }

    private int l(InputStream inputStream, int i5) {
        b bVar = new b();
        OutputStream c5 = this.f5069d.c(bVar);
        try {
            int o5 = o(inputStream, c5);
            c5.close();
            int i6 = this.f5067b;
            if (i6 < 0 || o5 <= i6) {
                k(bVar, true);
                return o5;
            }
            throw i3.j1.f3441o.q(String.format(Locale.US, "message too large %d > %d", Integer.valueOf(o5), Integer.valueOf(this.f5067b))).d();
        } catch (Throwable th) {
            c5.close();
            throw th;
        }
    }

    private int m(InputStream inputStream, int i5) {
        int i6 = this.f5067b;
        if (i6 < 0 || i5 <= i6) {
            this.f5072g.clear();
            this.f5072g.put((byte) 0).putInt(i5);
            if (this.f5068c == null) {
                this.f5068c = this.f5073h.a(this.f5072g.position() + i5);
            }
            n(this.f5072g.array(), 0, this.f5072g.position());
            return o(inputStream, this.f5071f);
        }
        throw i3.j1.f3441o.q(String.format(Locale.US, "message too large %d > %d", Integer.valueOf(i5), Integer.valueOf(this.f5067b))).d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(byte[] bArr, int i5, int i6) {
        while (i6 > 0) {
            u2 u2Var = this.f5068c;
            if (u2Var != null && u2Var.a() == 0) {
                f(false, false);
            }
            if (this.f5068c == null) {
                this.f5068c = this.f5073h.a(i6);
            }
            int min = Math.min(i6, this.f5068c.a());
            this.f5068c.write(bArr, i5, min);
            i5 += min;
            i6 -= min;
        }
    }

    private static int o(InputStream inputStream, OutputStream outputStream) {
        if (inputStream instanceof i3.w) {
            return ((i3.w) inputStream).c(outputStream);
        }
        long b5 = b1.b.b(inputStream, outputStream);
        z0.k.i(b5 <= 2147483647L, "Message size overflow: %s", b5);
        return (int) b5;
    }

    private int p(InputStream inputStream, int i5) {
        if (i5 != -1) {
            this.f5078m = i5;
            return m(inputStream, i5);
        }
        b bVar = new b();
        int o5 = o(inputStream, bVar);
        int i6 = this.f5067b;
        if (i6 < 0 || o5 <= i6) {
            k(bVar, false);
            return o5;
        }
        throw i3.j1.f3441o.q(String.format(Locale.US, "message too large %d > %d", Integer.valueOf(o5), Integer.valueOf(this.f5067b))).d();
    }

    @Override // io.grpc.internal.r0
    public void c(InputStream inputStream) {
        j();
        this.f5076k++;
        int i5 = this.f5077l + 1;
        this.f5077l = i5;
        this.f5078m = 0L;
        this.f5074i.i(i5);
        boolean z4 = this.f5070e && this.f5069d != l.b.f3486a;
        try {
            int g5 = g(inputStream);
            int p5 = (g5 == 0 || !z4) ? p(inputStream, g5) : l(inputStream, g5);
            if (g5 != -1 && p5 != g5) {
                throw i3.j1.f3446t.q(String.format("Message length inaccurate %s != %s", Integer.valueOf(p5), Integer.valueOf(g5))).d();
            }
            long j5 = p5;
            this.f5074i.k(j5);
            this.f5074i.l(this.f5078m);
            this.f5074i.j(this.f5077l, this.f5078m, j5);
        } catch (IOException e5) {
            throw i3.j1.f3446t.q("Failed to frame message").p(e5).d();
        } catch (RuntimeException e6) {
            throw i3.j1.f3446t.q("Failed to frame message").p(e6).d();
        }
    }

    @Override // io.grpc.internal.r0
    public void close() {
        if (isClosed()) {
            return;
        }
        this.f5075j = true;
        u2 u2Var = this.f5068c;
        if (u2Var != null && u2Var.b() == 0) {
            h();
        }
        f(true, true);
    }

    @Override // io.grpc.internal.r0
    public void e(int i5) {
        z0.k.u(this.f5067b == -1, "max size already set");
        this.f5067b = i5;
    }

    @Override // io.grpc.internal.r0
    public void flush() {
        u2 u2Var = this.f5068c;
        if (u2Var == null || u2Var.b() <= 0) {
            return;
        }
        f(false, true);
    }

    @Override // io.grpc.internal.r0
    /* renamed from: i */
    public o1 b(i3.n nVar) {
        this.f5069d = (i3.n) z0.k.o(nVar, "Can't pass an empty compressor");
        return this;
    }

    @Override // io.grpc.internal.r0
    public boolean isClosed() {
        return this.f5075j;
    }
}
