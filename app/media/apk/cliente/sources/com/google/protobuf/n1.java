package com.google.protobuf;

import com.google.android.gms.common.api.a;
import com.google.protobuf.i;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class n1 extends i {

    /* renamed from: n  reason: collision with root package name */
    static final int[] f2075n = {1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765, 10946, 17711, 28657, 46368, 75025, 121393, 196418, 317811, 514229, 832040, 1346269, 2178309, 3524578, 5702887, 9227465, 14930352, 24157817, 39088169, 63245986, 102334155, 165580141, 267914296, 433494437, 701408733, 1134903170, 1836311903, a.e.API_PRIORITY_OTHER};

    /* renamed from: e  reason: collision with root package name */
    private final int f2076e;

    /* renamed from: f  reason: collision with root package name */
    private final i f2077f;

    /* renamed from: k  reason: collision with root package name */
    private final i f2078k;

    /* renamed from: l  reason: collision with root package name */
    private final int f2079l;

    /* renamed from: m  reason: collision with root package name */
    private final int f2080m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends i.c {

        /* renamed from: a  reason: collision with root package name */
        final c f2081a;

        /* renamed from: b  reason: collision with root package name */
        i.g f2082b = c();

        a() {
            this.f2081a = new c(n1.this, null);
        }

        private i.g c() {
            if (this.f2081a.hasNext()) {
                return this.f2081a.next().iterator();
            }
            return null;
        }

        @Override // com.google.protobuf.i.g
        public byte a() {
            i.g gVar = this.f2082b;
            if (gVar != null) {
                byte a5 = gVar.a();
                if (!this.f2082b.hasNext()) {
                    this.f2082b = c();
                }
                return a5;
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f2082b != null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        private final ArrayDeque<i> f2084a;

        private b() {
            this.f2084a = new ArrayDeque<>();
        }

        /* synthetic */ b(a aVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public i b(i iVar, i iVar2) {
            c(iVar);
            c(iVar2);
            i pop = this.f2084a.pop();
            while (!this.f2084a.isEmpty()) {
                pop = new n1(this.f2084a.pop(), pop, null);
            }
            return pop;
        }

        private void c(i iVar) {
            if (iVar.w()) {
                e(iVar);
            } else if (iVar instanceof n1) {
                n1 n1Var = (n1) iVar;
                c(n1Var.f2077f);
                c(n1Var.f2078k);
            } else {
                throw new IllegalArgumentException("Has a new type of ByteString been created? Found " + iVar.getClass());
            }
        }

        private int d(int i5) {
            int binarySearch = Arrays.binarySearch(n1.f2075n, i5);
            return binarySearch < 0 ? (-(binarySearch + 1)) - 1 : binarySearch;
        }

        private void e(i iVar) {
            int d5 = d(iVar.size());
            int W = n1.W(d5 + 1);
            if (this.f2084a.isEmpty() || this.f2084a.peek().size() >= W) {
                this.f2084a.push(iVar);
                return;
            }
            int W2 = n1.W(d5);
            i pop = this.f2084a.pop();
            while (!this.f2084a.isEmpty() && this.f2084a.peek().size() < W2) {
                pop = new n1(this.f2084a.pop(), pop, null);
            }
            n1 n1Var = new n1(pop, iVar, null);
            while (!this.f2084a.isEmpty()) {
                if (this.f2084a.peek().size() >= n1.W(d(n1Var.size()) + 1)) {
                    break;
                }
                n1Var = new n1(this.f2084a.pop(), n1Var, null);
            }
            this.f2084a.push(n1Var);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class c implements Iterator<i.AbstractC0045i> {

        /* renamed from: a  reason: collision with root package name */
        private final ArrayDeque<n1> f2085a;

        /* renamed from: b  reason: collision with root package name */
        private i.AbstractC0045i f2086b;

        private c(i iVar) {
            i.AbstractC0045i abstractC0045i;
            if (iVar instanceof n1) {
                n1 n1Var = (n1) iVar;
                ArrayDeque<n1> arrayDeque = new ArrayDeque<>(n1Var.u());
                this.f2085a = arrayDeque;
                arrayDeque.push(n1Var);
                abstractC0045i = b(n1Var.f2077f);
            } else {
                this.f2085a = null;
                abstractC0045i = (i.AbstractC0045i) iVar;
            }
            this.f2086b = abstractC0045i;
        }

        /* synthetic */ c(i iVar, a aVar) {
            this(iVar);
        }

        private i.AbstractC0045i b(i iVar) {
            while (iVar instanceof n1) {
                n1 n1Var = (n1) iVar;
                this.f2085a.push(n1Var);
                iVar = n1Var.f2077f;
            }
            return (i.AbstractC0045i) iVar;
        }

        private i.AbstractC0045i c() {
            i.AbstractC0045i b5;
            do {
                ArrayDeque<n1> arrayDeque = this.f2085a;
                if (arrayDeque == null || arrayDeque.isEmpty()) {
                    return null;
                }
                b5 = b(this.f2085a.pop().f2078k);
            } while (b5.isEmpty());
            return b5;
        }

        @Override // java.util.Iterator
        /* renamed from: d */
        public i.AbstractC0045i next() {
            i.AbstractC0045i abstractC0045i = this.f2086b;
            if (abstractC0045i != null) {
                this.f2086b = c();
                return abstractC0045i;
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f2086b != null;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    private n1(i iVar, i iVar2) {
        this.f2077f = iVar;
        this.f2078k = iVar2;
        int size = iVar.size();
        this.f2079l = size;
        this.f2076e = size + iVar2.size();
        this.f2080m = Math.max(iVar.u(), iVar2.u()) + 1;
    }

    /* synthetic */ n1(i iVar, i iVar2, a aVar) {
        this(iVar, iVar2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static i T(i iVar, i iVar2) {
        if (iVar2.size() == 0) {
            return iVar;
        }
        if (iVar.size() == 0) {
            return iVar2;
        }
        int size = iVar.size() + iVar2.size();
        if (size < 128) {
            return U(iVar, iVar2);
        }
        if (iVar instanceof n1) {
            n1 n1Var = (n1) iVar;
            if (n1Var.f2078k.size() + iVar2.size() < 128) {
                return new n1(n1Var.f2077f, U(n1Var.f2078k, iVar2));
            } else if (n1Var.f2077f.u() > n1Var.f2078k.u() && n1Var.u() > iVar2.u()) {
                return new n1(n1Var.f2077f, new n1(n1Var.f2078k, iVar2));
            }
        }
        return size >= W(Math.max(iVar.u(), iVar2.u()) + 1) ? new n1(iVar, iVar2) : new b(null).b(iVar, iVar2);
    }

    private static i U(i iVar, i iVar2) {
        int size = iVar.size();
        int size2 = iVar2.size();
        byte[] bArr = new byte[size + size2];
        iVar.s(bArr, 0, 0, size);
        iVar2.s(bArr, 0, size, size2);
        return i.N(bArr);
    }

    private boolean V(i iVar) {
        c cVar = new c(this, null);
        i.AbstractC0045i next = cVar.next();
        c cVar2 = new c(iVar, null);
        i.AbstractC0045i next2 = cVar2.next();
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        while (true) {
            int size = next.size() - i5;
            int size2 = next2.size() - i6;
            int min = Math.min(size, size2);
            if (!(i5 == 0 ? next.Q(next2, i6, min) : next2.Q(next, i5, min))) {
                return false;
            }
            i7 += min;
            int i8 = this.f2076e;
            if (i7 >= i8) {
                if (i7 == i8) {
                    return true;
                }
                throw new IllegalStateException();
            }
            if (min == size) {
                i5 = 0;
                next = cVar.next();
            } else {
                i5 += min;
                next = next;
            }
            if (min == size2) {
                next2 = cVar2.next();
                i6 = 0;
            } else {
                i6 += min;
            }
        }
    }

    static int W(int i5) {
        int[] iArr = f2075n;
        return i5 >= iArr.length ? a.e.API_PRIORITY_OTHER : iArr[i5];
    }

    @Override // com.google.protobuf.i
    public j A() {
        return j.h(S(), true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.i
    public int B(int i5, int i6, int i7) {
        int i8 = i6 + i7;
        int i9 = this.f2079l;
        if (i8 <= i9) {
            return this.f2077f.B(i5, i6, i7);
        }
        if (i6 >= i9) {
            return this.f2078k.B(i5, i6 - i9, i7);
        }
        int i10 = i9 - i6;
        return this.f2078k.B(this.f2077f.B(i5, i6, i10), 0, i7 - i10);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.i
    public int C(int i5, int i6, int i7) {
        int i8 = i6 + i7;
        int i9 = this.f2079l;
        if (i8 <= i9) {
            return this.f2077f.C(i5, i6, i7);
        }
        if (i6 >= i9) {
            return this.f2078k.C(i5, i6 - i9, i7);
        }
        int i10 = i9 - i6;
        return this.f2078k.C(this.f2077f.C(i5, i6, i10), 0, i7 - i10);
    }

    @Override // com.google.protobuf.i
    public i F(int i5, int i6) {
        int m5 = i.m(i5, i6, this.f2076e);
        if (m5 == 0) {
            return i.f1961b;
        }
        if (m5 == this.f2076e) {
            return this;
        }
        int i7 = this.f2079l;
        return i6 <= i7 ? this.f2077f.F(i5, i6) : i5 >= i7 ? this.f2078k.F(i5 - i7, i6 - i7) : new n1(this.f2077f.E(i5), this.f2078k.F(0, i6 - this.f2079l));
    }

    @Override // com.google.protobuf.i
    protected String J(Charset charset) {
        return new String(G(), charset);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.i
    public void P(h hVar) {
        this.f2077f.P(hVar);
        this.f2078k.P(hVar);
    }

    public List<ByteBuffer> S() {
        ArrayList arrayList = new ArrayList();
        c cVar = new c(this, null);
        while (cVar.hasNext()) {
            arrayList.add(cVar.next().h());
        }
        return arrayList;
    }

    @Override // com.google.protobuf.i
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof i) {
            i iVar = (i) obj;
            if (this.f2076e != iVar.size()) {
                return false;
            }
            if (this.f2076e == 0) {
                return true;
            }
            int D = D();
            int D2 = iVar.D();
            if (D == 0 || D2 == 0 || D == D2) {
                return V(iVar);
            }
            return false;
        }
        return false;
    }

    @Override // com.google.protobuf.i
    public ByteBuffer h() {
        return ByteBuffer.wrap(G()).asReadOnlyBuffer();
    }

    @Override // com.google.protobuf.i
    public byte k(int i5) {
        i.l(i5, this.f2076e);
        return v(i5);
    }

    @Override // com.google.protobuf.i
    public int size() {
        return this.f2076e;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.i
    public void t(byte[] bArr, int i5, int i6, int i7) {
        i iVar;
        int i8 = i5 + i7;
        int i9 = this.f2079l;
        if (i8 <= i9) {
            iVar = this.f2077f;
        } else if (i5 < i9) {
            int i10 = i9 - i5;
            this.f2077f.t(bArr, i5, i6, i10);
            this.f2078k.t(bArr, 0, i6 + i10, i7 - i10);
            return;
        } else {
            iVar = this.f2078k;
            i5 -= i9;
        }
        iVar.t(bArr, i5, i6, i7);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.i
    public int u() {
        return this.f2080m;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.i
    public byte v(int i5) {
        int i6 = this.f2079l;
        return i5 < i6 ? this.f2077f.v(i5) : this.f2078k.v(i5 - i6);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.i
    public boolean w() {
        return this.f2076e >= W(this.f2080m);
    }

    @Override // com.google.protobuf.i
    public boolean x() {
        int C = this.f2077f.C(0, 0, this.f2079l);
        i iVar = this.f2078k;
        return iVar.C(C, 0, iVar.size()) == 0;
    }

    @Override // com.google.protobuf.i, java.lang.Iterable
    /* renamed from: y */
    public i.g iterator() {
        return new a();
    }
}
