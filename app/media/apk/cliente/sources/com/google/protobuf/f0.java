package com.google.protobuf;

import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f0 extends InputStream {

    /* renamed from: a  reason: collision with root package name */
    private Iterator<ByteBuffer> f1930a;

    /* renamed from: b  reason: collision with root package name */
    private ByteBuffer f1931b;

    /* renamed from: c  reason: collision with root package name */
    private int f1932c = 0;

    /* renamed from: d  reason: collision with root package name */
    private int f1933d;

    /* renamed from: e  reason: collision with root package name */
    private int f1934e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f1935f;

    /* renamed from: k  reason: collision with root package name */
    private byte[] f1936k;

    /* renamed from: l  reason: collision with root package name */
    private int f1937l;

    /* renamed from: m  reason: collision with root package name */
    private long f1938m;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f0(Iterable<ByteBuffer> iterable) {
        this.f1930a = iterable.iterator();
        for (ByteBuffer byteBuffer : iterable) {
            this.f1932c++;
        }
        this.f1933d = -1;
        if (c()) {
            return;
        }
        this.f1931b = d0.f1914e;
        this.f1933d = 0;
        this.f1934e = 0;
        this.f1938m = 0L;
    }

    private boolean c() {
        this.f1933d++;
        if (this.f1930a.hasNext()) {
            ByteBuffer next = this.f1930a.next();
            this.f1931b = next;
            this.f1934e = next.position();
            if (this.f1931b.hasArray()) {
                this.f1935f = true;
                this.f1936k = this.f1931b.array();
                this.f1937l = this.f1931b.arrayOffset();
            } else {
                this.f1935f = false;
                this.f1938m = a2.k(this.f1931b);
                this.f1936k = null;
            }
            return true;
        }
        return false;
    }

    private void d(int i5) {
        int i6 = this.f1934e + i5;
        this.f1934e = i6;
        if (i6 == this.f1931b.limit()) {
            c();
        }
    }

    @Override // java.io.InputStream
    public int read() {
        if (this.f1933d == this.f1932c) {
            return -1;
        }
        int w5 = (this.f1935f ? this.f1936k[this.f1934e + this.f1937l] : a2.w(this.f1934e + this.f1938m)) & 255;
        d(1);
        return w5;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i5, int i6) {
        if (this.f1933d == this.f1932c) {
            return -1;
        }
        int limit = this.f1931b.limit();
        int i7 = this.f1934e;
        int i8 = limit - i7;
        if (i6 > i8) {
            i6 = i8;
        }
        if (this.f1935f) {
            System.arraycopy(this.f1936k, i7 + this.f1937l, bArr, i5, i6);
        } else {
            int position = this.f1931b.position();
            g0.b(this.f1931b, this.f1934e);
            this.f1931b.get(bArr, i5, i6);
            g0.b(this.f1931b, position);
        }
        d(i6);
        return i6;
    }
}
