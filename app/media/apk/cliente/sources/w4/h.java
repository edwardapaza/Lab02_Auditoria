package w4;

import java.nio.ByteBuffer;
/* loaded from: classes.dex */
final class h implements d {

    /* renamed from: a  reason: collision with root package name */
    public final c f8295a = new c();

    /* renamed from: b  reason: collision with root package name */
    public final m f8296b;

    /* renamed from: c  reason: collision with root package name */
    boolean f8297c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(m mVar) {
        if (mVar == null) {
            throw new NullPointerException("sink == null");
        }
        this.f8296b = mVar;
    }

    @Override // w4.m
    public void Z(c cVar, long j5) {
        if (this.f8297c) {
            throw new IllegalStateException("closed");
        }
        this.f8295a.Z(cVar, j5);
        c();
    }

    @Override // w4.d
    public d b0(String str) {
        if (this.f8297c) {
            throw new IllegalStateException("closed");
        }
        this.f8295a.b0(str);
        return c();
    }

    public d c() {
        if (this.f8297c) {
            throw new IllegalStateException("closed");
        }
        long l5 = this.f8295a.l();
        if (l5 > 0) {
            this.f8296b.Z(this.f8295a, l5);
        }
        return this;
    }

    @Override // w4.m, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.f8297c) {
            return;
        }
        Throwable th = null;
        try {
            c cVar = this.f8295a;
            long j5 = cVar.f8282b;
            if (j5 > 0) {
                this.f8296b.Z(cVar, j5);
            }
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            this.f8296b.close();
        } catch (Throwable th3) {
            if (th == null) {
                th = th3;
            }
        }
        this.f8297c = true;
        if (th != null) {
            p.c(th);
        }
    }

    @Override // w4.d, w4.m, java.io.Flushable
    public void flush() {
        if (this.f8297c) {
            throw new IllegalStateException("closed");
        }
        c cVar = this.f8295a;
        long j5 = cVar.f8282b;
        if (j5 > 0) {
            this.f8296b.Z(cVar, j5);
        }
        this.f8296b.flush();
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.f8297c;
    }

    public String toString() {
        return "buffer(" + this.f8296b + ")";
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) {
        if (this.f8297c) {
            throw new IllegalStateException("closed");
        }
        int write = this.f8295a.write(byteBuffer);
        c();
        return write;
    }

    @Override // w4.d
    public d write(byte[] bArr) {
        if (this.f8297c) {
            throw new IllegalStateException("closed");
        }
        this.f8295a.write(bArr);
        return c();
    }

    @Override // w4.d
    public d writeByte(int i5) {
        if (this.f8297c) {
            throw new IllegalStateException("closed");
        }
        this.f8295a.writeByte(i5);
        return c();
    }

    @Override // w4.d
    public d writeInt(int i5) {
        if (this.f8297c) {
            throw new IllegalStateException("closed");
        }
        this.f8295a.writeInt(i5);
        return c();
    }

    @Override // w4.d
    public d writeShort(int i5) {
        if (this.f8297c) {
            throw new IllegalStateException("closed");
        }
        this.f8295a.writeShort(i5);
        return c();
    }
}
