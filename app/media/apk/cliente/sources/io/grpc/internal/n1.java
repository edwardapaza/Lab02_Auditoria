package io.grpc.internal;

import i3.l;
import io.grpc.internal.p2;
import java.io.Closeable;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;
import java.util.zip.DataFormatException;
/* loaded from: classes.dex */
public class n1 implements Closeable, a0 {

    /* renamed from: a  reason: collision with root package name */
    private b f5027a;

    /* renamed from: b  reason: collision with root package name */
    private int f5028b;

    /* renamed from: c  reason: collision with root package name */
    private final n2 f5029c;

    /* renamed from: d  reason: collision with root package name */
    private final t2 f5030d;

    /* renamed from: e  reason: collision with root package name */
    private i3.u f5031e;

    /* renamed from: f  reason: collision with root package name */
    private u0 f5032f;

    /* renamed from: k  reason: collision with root package name */
    private byte[] f5033k;

    /* renamed from: l  reason: collision with root package name */
    private int f5034l;

    /* renamed from: o  reason: collision with root package name */
    private boolean f5037o;

    /* renamed from: p  reason: collision with root package name */
    private w f5038p;

    /* renamed from: r  reason: collision with root package name */
    private long f5040r;

    /* renamed from: u  reason: collision with root package name */
    private int f5043u;

    /* renamed from: m  reason: collision with root package name */
    private e f5035m = e.HEADER;

    /* renamed from: n  reason: collision with root package name */
    private int f5036n = 5;

    /* renamed from: q  reason: collision with root package name */
    private w f5039q = new w();

    /* renamed from: s  reason: collision with root package name */
    private boolean f5041s = false;

    /* renamed from: t  reason: collision with root package name */
    private int f5042t = -1;

    /* renamed from: v  reason: collision with root package name */
    private boolean f5044v = false;

    /* renamed from: w  reason: collision with root package name */
    private volatile boolean f5045w = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f5046a;

        static {
            int[] iArr = new int[e.values().length];
            f5046a = iArr;
            try {
                iArr[e.HEADER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f5046a[e.BODY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        void a(p2.a aVar);

        void b(Throwable th);

        void e(boolean z4);

        void f(int i5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c implements p2.a {

        /* renamed from: a  reason: collision with root package name */
        private InputStream f5047a;

        private c(InputStream inputStream) {
            this.f5047a = inputStream;
        }

        /* synthetic */ c(InputStream inputStream, a aVar) {
            this(inputStream);
        }

        @Override // io.grpc.internal.p2.a
        public InputStream next() {
            InputStream inputStream = this.f5047a;
            this.f5047a = null;
            return inputStream;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class d extends FilterInputStream {

        /* renamed from: a  reason: collision with root package name */
        private final int f5048a;

        /* renamed from: b  reason: collision with root package name */
        private final n2 f5049b;

        /* renamed from: c  reason: collision with root package name */
        private long f5050c;

        /* renamed from: d  reason: collision with root package name */
        private long f5051d;

        /* renamed from: e  reason: collision with root package name */
        private long f5052e;

        d(InputStream inputStream, int i5, n2 n2Var) {
            super(inputStream);
            this.f5052e = -1L;
            this.f5048a = i5;
            this.f5049b = n2Var;
        }

        private void c() {
            long j5 = this.f5051d;
            long j6 = this.f5050c;
            if (j5 > j6) {
                this.f5049b.f(j5 - j6);
                this.f5050c = this.f5051d;
            }
        }

        private void d() {
            if (this.f5051d <= this.f5048a) {
                return;
            }
            i3.j1 j1Var = i3.j1.f3441o;
            throw j1Var.q("Decompressed gRPC message exceeds maximum size " + this.f5048a).d();
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public synchronized void mark(int i5) {
            ((FilterInputStream) this).in.mark(i5);
            this.f5052e = this.f5051d;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read() {
            int read = ((FilterInputStream) this).in.read();
            if (read != -1) {
                this.f5051d++;
            }
            d();
            c();
            return read;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read(byte[] bArr, int i5, int i6) {
            int read = ((FilterInputStream) this).in.read(bArr, i5, i6);
            if (read != -1) {
                this.f5051d += read;
            }
            d();
            c();
            return read;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public synchronized void reset() {
            if (!((FilterInputStream) this).in.markSupported()) {
                throw new IOException("Mark not supported");
            }
            if (this.f5052e == -1) {
                throw new IOException("Mark not set");
            }
            ((FilterInputStream) this).in.reset();
            this.f5051d = this.f5052e;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public long skip(long j5) {
            long skip = ((FilterInputStream) this).in.skip(j5);
            this.f5051d += skip;
            d();
            c();
            return skip;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public enum e {
        HEADER,
        BODY
    }

    public n1(b bVar, i3.u uVar, int i5, n2 n2Var, t2 t2Var) {
        this.f5027a = (b) z0.k.o(bVar, "sink");
        this.f5031e = (i3.u) z0.k.o(uVar, "decompressor");
        this.f5028b = i5;
        this.f5029c = (n2) z0.k.o(n2Var, "statsTraceCtx");
        this.f5030d = (t2) z0.k.o(t2Var, "transportTracer");
    }

    private void j() {
        if (this.f5041s) {
            return;
        }
        this.f5041s = true;
        while (true) {
            try {
                if (this.f5045w || this.f5040r <= 0 || !w()) {
                    break;
                }
                int i5 = a.f5046a[this.f5035m.ordinal()];
                if (i5 == 1) {
                    v();
                } else if (i5 != 2) {
                    throw new AssertionError("Invalid state: " + this.f5035m);
                } else {
                    u();
                    this.f5040r--;
                }
            } finally {
                this.f5041s = false;
            }
        }
        if (this.f5045w) {
            close();
            return;
        }
        if (this.f5044v && r()) {
            close();
        }
    }

    private InputStream l() {
        i3.u uVar = this.f5031e;
        if (uVar != l.b.f3486a) {
            try {
                return new d(uVar.b(y1.c(this.f5038p, true)), this.f5028b, this.f5029c);
            } catch (IOException e5) {
                throw new RuntimeException(e5);
            }
        }
        throw i3.j1.f3446t.q("Can't decode compressed gRPC message as compression not configured").d();
    }

    private InputStream n() {
        this.f5029c.f(this.f5038p.b());
        return y1.c(this.f5038p, true);
    }

    private boolean p() {
        return isClosed() || this.f5044v;
    }

    private boolean r() {
        u0 u0Var = this.f5032f;
        return u0Var != null ? u0Var.A() : this.f5039q.b() == 0;
    }

    private void u() {
        this.f5029c.e(this.f5042t, this.f5043u, -1L);
        this.f5043u = 0;
        InputStream l5 = this.f5037o ? l() : n();
        this.f5038p = null;
        this.f5027a.a(new c(l5, null));
        this.f5035m = e.HEADER;
        this.f5036n = 5;
    }

    private void v() {
        int readUnsignedByte = this.f5038p.readUnsignedByte();
        if ((readUnsignedByte & 254) != 0) {
            throw i3.j1.f3446t.q("gRPC frame header malformed: reserved bits not zero").d();
        }
        this.f5037o = (readUnsignedByte & 1) != 0;
        int readInt = this.f5038p.readInt();
        this.f5036n = readInt;
        if (readInt < 0 || readInt > this.f5028b) {
            throw i3.j1.f3441o.q(String.format(Locale.US, "gRPC message exceeds maximum size %d: %d", Integer.valueOf(this.f5028b), Integer.valueOf(this.f5036n))).d();
        }
        int i5 = this.f5042t + 1;
        this.f5042t = i5;
        this.f5029c.d(i5);
        this.f5030d.d();
        this.f5035m = e.BODY;
    }

    private boolean w() {
        int i5;
        int i6 = 0;
        try {
            if (this.f5038p == null) {
                this.f5038p = new w();
            }
            int i7 = 0;
            i5 = 0;
            while (true) {
                try {
                    int b5 = this.f5036n - this.f5038p.b();
                    if (b5 <= 0) {
                        if (i7 > 0) {
                            this.f5027a.f(i7);
                            if (this.f5035m == e.BODY) {
                                if (this.f5032f != null) {
                                    this.f5029c.g(i5);
                                    this.f5043u += i5;
                                } else {
                                    this.f5029c.g(i7);
                                    this.f5043u += i7;
                                }
                            }
                        }
                        return true;
                    } else if (this.f5032f != null) {
                        try {
                            byte[] bArr = this.f5033k;
                            if (bArr == null || this.f5034l == bArr.length) {
                                this.f5033k = new byte[Math.min(b5, 2097152)];
                                this.f5034l = 0;
                            }
                            int x4 = this.f5032f.x(this.f5033k, this.f5034l, Math.min(b5, this.f5033k.length - this.f5034l));
                            i7 += this.f5032f.r();
                            i5 += this.f5032f.u();
                            if (x4 == 0) {
                                if (i7 > 0) {
                                    this.f5027a.f(i7);
                                    if (this.f5035m == e.BODY) {
                                        if (this.f5032f != null) {
                                            this.f5029c.g(i5);
                                            this.f5043u += i5;
                                        } else {
                                            this.f5029c.g(i7);
                                            this.f5043u += i7;
                                        }
                                    }
                                }
                                return false;
                            }
                            this.f5038p.d(y1.f(this.f5033k, this.f5034l, x4));
                            this.f5034l += x4;
                        } catch (IOException e5) {
                            throw new RuntimeException(e5);
                        } catch (DataFormatException e6) {
                            throw new RuntimeException(e6);
                        }
                    } else if (this.f5039q.b() == 0) {
                        if (i7 > 0) {
                            this.f5027a.f(i7);
                            if (this.f5035m == e.BODY) {
                                if (this.f5032f != null) {
                                    this.f5029c.g(i5);
                                    this.f5043u += i5;
                                } else {
                                    this.f5029c.g(i7);
                                    this.f5043u += i7;
                                }
                            }
                        }
                        return false;
                    } else {
                        int min = Math.min(b5, this.f5039q.b());
                        i7 += min;
                        this.f5038p.d(this.f5039q.t(min));
                    }
                } catch (Throwable th) {
                    int i8 = i7;
                    th = th;
                    i6 = i8;
                    if (i6 > 0) {
                        this.f5027a.f(i6);
                        if (this.f5035m == e.BODY) {
                            if (this.f5032f != null) {
                                this.f5029c.g(i5);
                                this.f5043u += i5;
                            } else {
                                this.f5029c.g(i6);
                                this.f5043u += i6;
                            }
                        }
                    }
                    throw th;
                }
            }
        } catch (Throwable th2) {
            th = th2;
            i5 = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void A() {
        this.f5045w = true;
    }

    @Override // io.grpc.internal.a0
    public void c(int i5) {
        z0.k.e(i5 > 0, "numMessages must be > 0");
        if (isClosed()) {
            return;
        }
        this.f5040r += i5;
        j();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable, io.grpc.internal.a0
    public void close() {
        if (isClosed()) {
            return;
        }
        w wVar = this.f5038p;
        boolean z4 = true;
        boolean z5 = wVar != null && wVar.b() > 0;
        try {
            u0 u0Var = this.f5032f;
            if (u0Var != null) {
                if (!z5 && !u0Var.v()) {
                    z4 = false;
                }
                this.f5032f.close();
                z5 = z4;
            }
            w wVar2 = this.f5039q;
            if (wVar2 != null) {
                wVar2.close();
            }
            w wVar3 = this.f5038p;
            if (wVar3 != null) {
                wVar3.close();
            }
            this.f5032f = null;
            this.f5039q = null;
            this.f5038p = null;
            this.f5027a.e(z5);
        } catch (Throwable th) {
            this.f5032f = null;
            this.f5039q = null;
            this.f5038p = null;
            throw th;
        }
    }

    @Override // io.grpc.internal.a0
    public void d(int i5) {
        this.f5028b = i5;
    }

    @Override // io.grpc.internal.a0
    public void g(i3.u uVar) {
        z0.k.u(this.f5032f == null, "Already set full stream decompressor");
        this.f5031e = (i3.u) z0.k.o(uVar, "Can't pass an empty decompressor");
    }

    @Override // io.grpc.internal.a0
    public void h() {
        if (isClosed()) {
            return;
        }
        if (r()) {
            close();
        } else {
            this.f5044v = true;
        }
    }

    @Override // io.grpc.internal.a0
    public void i(x1 x1Var) {
        z0.k.o(x1Var, "data");
        boolean z4 = true;
        try {
            if (!p()) {
                u0 u0Var = this.f5032f;
                if (u0Var != null) {
                    u0Var.n(x1Var);
                } else {
                    this.f5039q.d(x1Var);
                }
                z4 = false;
                j();
            }
        } finally {
            if (z4) {
                x1Var.close();
            }
        }
    }

    public boolean isClosed() {
        return this.f5039q == null && this.f5032f == null;
    }

    public void x(u0 u0Var) {
        z0.k.u(this.f5031e == l.b.f3486a, "per-message decompressor already set");
        z0.k.u(this.f5032f == null, "full stream decompressor already set");
        this.f5032f = (u0) z0.k.o(u0Var, "Can't pass a null full stream decompressor");
        this.f5039q = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void z(b bVar) {
        this.f5027a = bVar;
    }
}
