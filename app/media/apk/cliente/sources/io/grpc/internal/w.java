package io.grpc.internal;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.InvalidMarkException;
import java.util.ArrayDeque;
import java.util.Deque;
/* loaded from: classes.dex */
public class w extends io.grpc.internal.c {

    /* renamed from: e  reason: collision with root package name */
    private static final f<Void> f5284e = new a();

    /* renamed from: f  reason: collision with root package name */
    private static final f<Void> f5285f = new b();

    /* renamed from: k  reason: collision with root package name */
    private static final f<byte[]> f5286k = new c();

    /* renamed from: l  reason: collision with root package name */
    private static final f<ByteBuffer> f5287l = new d();

    /* renamed from: m  reason: collision with root package name */
    private static final g<OutputStream> f5288m = new e();

    /* renamed from: a  reason: collision with root package name */
    private final Deque<x1> f5289a;

    /* renamed from: b  reason: collision with root package name */
    private Deque<x1> f5290b;

    /* renamed from: c  reason: collision with root package name */
    private int f5291c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f5292d;

    /* loaded from: classes.dex */
    class a implements f<Void> {
        a() {
        }

        @Override // io.grpc.internal.w.g
        /* renamed from: b */
        public int a(x1 x1Var, int i5, Void r32, int i6) {
            return x1Var.readUnsignedByte();
        }
    }

    /* loaded from: classes.dex */
    class b implements f<Void> {
        b() {
        }

        @Override // io.grpc.internal.w.g
        /* renamed from: b */
        public int a(x1 x1Var, int i5, Void r32, int i6) {
            x1Var.skipBytes(i5);
            return 0;
        }
    }

    /* loaded from: classes.dex */
    class c implements f<byte[]> {
        c() {
        }

        @Override // io.grpc.internal.w.g
        /* renamed from: b */
        public int a(x1 x1Var, int i5, byte[] bArr, int i6) {
            x1Var.d0(bArr, i6, i5);
            return i6 + i5;
        }
    }

    /* loaded from: classes.dex */
    class d implements f<ByteBuffer> {
        d() {
        }

        @Override // io.grpc.internal.w.g
        /* renamed from: b */
        public int a(x1 x1Var, int i5, ByteBuffer byteBuffer, int i6) {
            int limit = byteBuffer.limit();
            byteBuffer.limit(byteBuffer.position() + i5);
            x1Var.a0(byteBuffer);
            byteBuffer.limit(limit);
            return 0;
        }
    }

    /* loaded from: classes.dex */
    class e implements g<OutputStream> {
        e() {
        }

        @Override // io.grpc.internal.w.g
        /* renamed from: b */
        public int a(x1 x1Var, int i5, OutputStream outputStream, int i6) {
            x1Var.Q(outputStream, i5);
            return 0;
        }
    }

    /* loaded from: classes.dex */
    private interface f<T> extends g<T> {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public interface g<T> {
        int a(x1 x1Var, int i5, T t5, int i6);
    }

    public w() {
        this.f5289a = new ArrayDeque();
    }

    public w(int i5) {
        this.f5289a = new ArrayDeque(i5);
    }

    private void g() {
        if (!this.f5292d) {
            this.f5289a.remove().close();
            return;
        }
        this.f5290b.add(this.f5289a.remove());
        x1 peek = this.f5289a.peek();
        if (peek != null) {
            peek.m();
        }
    }

    private void h() {
        if (this.f5289a.peek().b() == 0) {
            g();
        }
    }

    private void i(x1 x1Var) {
        if (!(x1Var instanceof w)) {
            this.f5289a.add(x1Var);
            this.f5291c += x1Var.b();
            return;
        }
        w wVar = (w) x1Var;
        while (!wVar.f5289a.isEmpty()) {
            this.f5289a.add(wVar.f5289a.remove());
        }
        this.f5291c += wVar.f5291c;
        wVar.f5291c = 0;
        wVar.close();
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0034, code lost:
        if (r4 > 0) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0036, code lost:
        return r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x003e, code lost:
        throw new java.lang.AssertionError("Failed executing read operation");
     */
    /* JADX WARN: Code restructure failed: missing block: B:3:0x0009, code lost:
        if (r2.f5289a.isEmpty() == false) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x000c, code lost:
        if (r4 <= 0) goto L7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0014, code lost:
        if (r2.f5289a.isEmpty() != false) goto L7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0016, code lost:
        r0 = r2.f5289a.peek();
        r1 = java.lang.Math.min(r4, r0.b());
        r6 = r3.a(r0, r1, r5, r6);
        r4 = r4 - r1;
        r2.f5291c -= r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0030, code lost:
        h();
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:9:0x0030 -> B:5:0x000c). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private <T> int j(io.grpc.internal.w.g<T> r3, int r4, T r5, int r6) {
        /*
            r2 = this;
            r2.c(r4)
            java.util.Deque<io.grpc.internal.x1> r0 = r2.f5289a
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto Lc
            goto L30
        Lc:
            if (r4 <= 0) goto L34
            java.util.Deque<io.grpc.internal.x1> r0 = r2.f5289a
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L34
            java.util.Deque<io.grpc.internal.x1> r0 = r2.f5289a
            java.lang.Object r0 = r0.peek()
            io.grpc.internal.x1 r0 = (io.grpc.internal.x1) r0
            int r1 = r0.b()
            int r1 = java.lang.Math.min(r4, r1)
            int r6 = r3.a(r0, r1, r5, r6)
            int r4 = r4 - r1
            int r0 = r2.f5291c
            int r0 = r0 - r1
            r2.f5291c = r0
        L30:
            r2.h()
            goto Lc
        L34:
            if (r4 > 0) goto L37
            return r6
        L37:
            java.lang.AssertionError r3 = new java.lang.AssertionError
            java.lang.String r4 = "Failed executing read operation"
            r3.<init>(r4)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: io.grpc.internal.w.j(io.grpc.internal.w$g, int, java.lang.Object, int):int");
    }

    private <T> int l(f<T> fVar, int i5, T t5, int i6) {
        try {
            return j(fVar, i5, t5, i6);
        } catch (IOException e5) {
            throw new AssertionError(e5);
        }
    }

    @Override // io.grpc.internal.x1
    public void Q(OutputStream outputStream, int i5) {
        j(f5288m, i5, outputStream, 0);
    }

    @Override // io.grpc.internal.x1
    public void a0(ByteBuffer byteBuffer) {
        l(f5287l, byteBuffer.remaining(), byteBuffer, 0);
    }

    @Override // io.grpc.internal.x1
    public int b() {
        return this.f5291c;
    }

    @Override // io.grpc.internal.c, io.grpc.internal.x1, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        while (!this.f5289a.isEmpty()) {
            this.f5289a.remove().close();
        }
        if (this.f5290b != null) {
            while (!this.f5290b.isEmpty()) {
                this.f5290b.remove().close();
            }
        }
    }

    public void d(x1 x1Var) {
        boolean z4 = this.f5292d && this.f5289a.isEmpty();
        i(x1Var);
        if (z4) {
            this.f5289a.peek().m();
        }
    }

    @Override // io.grpc.internal.x1
    public void d0(byte[] bArr, int i5, int i6) {
        l(f5286k, i6, bArr, i5);
    }

    @Override // io.grpc.internal.c, io.grpc.internal.x1
    public void m() {
        if (this.f5290b == null) {
            this.f5290b = new ArrayDeque(Math.min(this.f5289a.size(), 16));
        }
        while (!this.f5290b.isEmpty()) {
            this.f5290b.remove().close();
        }
        this.f5292d = true;
        x1 peek = this.f5289a.peek();
        if (peek != null) {
            peek.m();
        }
    }

    @Override // io.grpc.internal.c, io.grpc.internal.x1
    public boolean markSupported() {
        for (x1 x1Var : this.f5289a) {
            if (!x1Var.markSupported()) {
                return false;
            }
        }
        return true;
    }

    @Override // io.grpc.internal.x1
    public int readUnsignedByte() {
        return l(f5284e, 1, null, 0);
    }

    @Override // io.grpc.internal.c, io.grpc.internal.x1
    public void reset() {
        if (!this.f5292d) {
            throw new InvalidMarkException();
        }
        x1 peek = this.f5289a.peek();
        if (peek != null) {
            int b5 = peek.b();
            peek.reset();
            this.f5291c += peek.b() - b5;
        }
        while (true) {
            x1 pollLast = this.f5290b.pollLast();
            if (pollLast == null) {
                return;
            }
            pollLast.reset();
            this.f5289a.addFirst(pollLast);
            this.f5291c += pollLast.b();
        }
    }

    @Override // io.grpc.internal.x1
    public void skipBytes(int i5) {
        l(f5285f, i5, null, 0);
    }

    @Override // io.grpc.internal.x1
    public x1 t(int i5) {
        x1 poll;
        int i6;
        x1 x1Var;
        if (i5 <= 0) {
            return y1.a();
        }
        c(i5);
        this.f5291c -= i5;
        w wVar = null;
        w wVar2 = null;
        while (true) {
            x1 peek = this.f5289a.peek();
            int b5 = peek.b();
            if (b5 > i5) {
                x1Var = peek.t(i5);
                i6 = 0;
            } else {
                if (this.f5292d) {
                    poll = peek.t(b5);
                    g();
                } else {
                    poll = this.f5289a.poll();
                }
                x1 x1Var2 = poll;
                i6 = i5 - b5;
                x1Var = x1Var2;
            }
            if (wVar == null) {
                wVar = x1Var;
            } else {
                if (wVar2 == null) {
                    wVar2 = new w(i6 != 0 ? Math.min(this.f5289a.size() + 2, 16) : 2);
                    wVar2.d(wVar);
                    wVar = wVar2;
                }
                wVar2.d(x1Var);
            }
            if (i6 <= 0) {
                return wVar;
            }
            i5 = i6;
        }
    }
}
