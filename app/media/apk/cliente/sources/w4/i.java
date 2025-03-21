package w4;

import java.io.EOFException;
import java.nio.ByteBuffer;
/* loaded from: classes.dex */
final class i implements e {

    /* renamed from: a  reason: collision with root package name */
    public final c f8298a = new c();

    /* renamed from: b  reason: collision with root package name */
    public final n f8299b;

    /* renamed from: c  reason: collision with root package name */
    boolean f8300c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(n nVar) {
        if (nVar == null) {
            throw new NullPointerException("source == null");
        }
        this.f8299b = nVar;
    }

    @Override // w4.e
    public c B() {
        return this.f8298a;
    }

    @Override // w4.e
    public boolean C() {
        if (this.f8300c) {
            throw new IllegalStateException("closed");
        }
        return this.f8298a.C() && this.f8299b.s(this.f8298a, 8192L) == -1;
    }

    @Override // w4.e
    public byte[] G(long j5) {
        Y(j5);
        return this.f8298a.G(j5);
    }

    @Override // w4.e
    public void Y(long j5) {
        if (!c(j5)) {
            throw new EOFException();
        }
    }

    public boolean c(long j5) {
        c cVar;
        if (j5 < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + j5);
        } else if (this.f8300c) {
            throw new IllegalStateException("closed");
        } else {
            do {
                cVar = this.f8298a;
                if (cVar.f8282b >= j5) {
                    return true;
                }
            } while (this.f8299b.s(cVar, 8192L) != -1);
            return false;
        }
    }

    @Override // w4.n, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.f8300c) {
            return;
        }
        this.f8300c = true;
        this.f8299b.close();
        this.f8298a.d();
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.f8300c;
    }

    @Override // w4.e
    public f k(long j5) {
        Y(j5);
        return this.f8298a.k(j5);
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) {
        c cVar = this.f8298a;
        if (cVar.f8282b == 0 && this.f8299b.s(cVar, 8192L) == -1) {
            return -1;
        }
        return this.f8298a.read(byteBuffer);
    }

    @Override // w4.e
    public byte readByte() {
        Y(1L);
        return this.f8298a.readByte();
    }

    @Override // w4.e
    public int readInt() {
        Y(4L);
        return this.f8298a.readInt();
    }

    @Override // w4.e
    public short readShort() {
        Y(2L);
        return this.f8298a.readShort();
    }

    @Override // w4.n
    public long s(c cVar, long j5) {
        if (cVar != null) {
            if (j5 < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j5);
            } else if (this.f8300c) {
                throw new IllegalStateException("closed");
            } else {
                c cVar2 = this.f8298a;
                if (cVar2.f8282b == 0 && this.f8299b.s(cVar2, 8192L) == -1) {
                    return -1L;
                }
                return this.f8298a.s(cVar, Math.min(j5, this.f8298a.f8282b));
            }
        }
        throw new IllegalArgumentException("sink == null");
    }

    @Override // w4.e
    public void skip(long j5) {
        if (this.f8300c) {
            throw new IllegalStateException("closed");
        }
        while (j5 > 0) {
            c cVar = this.f8298a;
            if (cVar.f8282b == 0 && this.f8299b.s(cVar, 8192L) == -1) {
                throw new EOFException();
            }
            long min = Math.min(j5, this.f8298a.size());
            this.f8298a.skip(min);
            j5 -= min;
        }
    }

    public String toString() {
        return "buffer(" + this.f8299b + ")";
    }
}
