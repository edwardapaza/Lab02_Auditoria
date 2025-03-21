package com.google.protobuf;

import com.google.protobuf.i;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class e1 extends i.AbstractC0045i {

    /* renamed from: e  reason: collision with root package name */
    private final ByteBuffer f1924e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e1(ByteBuffer byteBuffer) {
        d0.b(byteBuffer, "buffer");
        this.f1924e = byteBuffer.slice().order(ByteOrder.nativeOrder());
    }

    private ByteBuffer R(int i5, int i6) {
        if (i5 < this.f1924e.position() || i6 > this.f1924e.limit() || i5 > i6) {
            throw new IllegalArgumentException(String.format("Invalid indices [%d, %d]", Integer.valueOf(i5), Integer.valueOf(i6)));
        }
        ByteBuffer slice = this.f1924e.slice();
        g0.b(slice, i5 - this.f1924e.position());
        g0.a(slice, i6 - this.f1924e.position());
        return slice;
    }

    @Override // com.google.protobuf.i
    public j A() {
        return j.i(this.f1924e, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.i
    public int B(int i5, int i6, int i7) {
        for (int i8 = i6; i8 < i6 + i7; i8++) {
            i5 = (i5 * 31) + this.f1924e.get(i8);
        }
        return i5;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.i
    public int C(int i5, int i6, int i7) {
        return b2.u(i5, this.f1924e, i6, i7 + i6);
    }

    @Override // com.google.protobuf.i
    public i F(int i5, int i6) {
        try {
            return new e1(R(i5, i6));
        } catch (ArrayIndexOutOfBoundsException e5) {
            throw e5;
        } catch (IndexOutOfBoundsException e6) {
            throw new ArrayIndexOutOfBoundsException(e6.getMessage());
        }
    }

    @Override // com.google.protobuf.i
    protected String J(Charset charset) {
        byte[] G;
        int i5;
        int length;
        if (this.f1924e.hasArray()) {
            G = this.f1924e.array();
            i5 = this.f1924e.arrayOffset() + this.f1924e.position();
            length = this.f1924e.remaining();
        } else {
            G = G();
            i5 = 0;
            length = G.length;
        }
        return new String(G, i5, length, charset);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.i
    public void P(h hVar) {
        hVar.a(this.f1924e.slice());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.i.AbstractC0045i
    public boolean Q(i iVar, int i5, int i6) {
        return F(0, i6).equals(iVar.F(i5, i6 + i5));
    }

    @Override // com.google.protobuf.i
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof i) {
            i iVar = (i) obj;
            if (size() != iVar.size()) {
                return false;
            }
            if (size() == 0) {
                return true;
            }
            return obj instanceof e1 ? this.f1924e.equals(((e1) obj).f1924e) : obj instanceof n1 ? obj.equals(this) : this.f1924e.equals(iVar.h());
        }
        return false;
    }

    @Override // com.google.protobuf.i
    public ByteBuffer h() {
        return this.f1924e.asReadOnlyBuffer();
    }

    @Override // com.google.protobuf.i
    public byte k(int i5) {
        try {
            return this.f1924e.get(i5);
        } catch (ArrayIndexOutOfBoundsException e5) {
            throw e5;
        } catch (IndexOutOfBoundsException e6) {
            throw new ArrayIndexOutOfBoundsException(e6.getMessage());
        }
    }

    @Override // com.google.protobuf.i
    public int size() {
        return this.f1924e.remaining();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.i
    public void t(byte[] bArr, int i5, int i6, int i7) {
        ByteBuffer slice = this.f1924e.slice();
        g0.b(slice, i5);
        slice.get(bArr, i6, i7);
    }

    @Override // com.google.protobuf.i
    public byte v(int i5) {
        return k(i5);
    }

    @Override // com.google.protobuf.i
    public boolean x() {
        return b2.r(this.f1924e);
    }
}
