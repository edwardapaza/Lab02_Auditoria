package com.google.protobuf;

import com.google.android.gms.common.api.a;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public abstract class j {

    /* renamed from: f  reason: collision with root package name */
    private static volatile int f1979f = 100;

    /* renamed from: a  reason: collision with root package name */
    int f1980a;

    /* renamed from: b  reason: collision with root package name */
    int f1981b;

    /* renamed from: c  reason: collision with root package name */
    int f1982c;

    /* renamed from: d  reason: collision with root package name */
    k f1983d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f1984e;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class b extends j {

        /* renamed from: g  reason: collision with root package name */
        private final byte[] f1985g;

        /* renamed from: h  reason: collision with root package name */
        private final boolean f1986h;

        /* renamed from: i  reason: collision with root package name */
        private int f1987i;

        /* renamed from: j  reason: collision with root package name */
        private int f1988j;

        /* renamed from: k  reason: collision with root package name */
        private int f1989k;

        /* renamed from: l  reason: collision with root package name */
        private int f1990l;

        /* renamed from: m  reason: collision with root package name */
        private int f1991m;

        /* renamed from: n  reason: collision with root package name */
        private boolean f1992n;

        /* renamed from: o  reason: collision with root package name */
        private int f1993o;

        private b(byte[] bArr, int i5, int i6, boolean z4) {
            super();
            this.f1993o = a.e.API_PRIORITY_OTHER;
            this.f1985g = bArr;
            this.f1987i = i6 + i5;
            this.f1989k = i5;
            this.f1990l = i5;
            this.f1986h = z4;
        }

        private void Q() {
            int i5 = this.f1987i + this.f1988j;
            this.f1987i = i5;
            int i6 = i5 - this.f1990l;
            int i7 = this.f1993o;
            if (i6 <= i7) {
                this.f1988j = 0;
                return;
            }
            int i8 = i6 - i7;
            this.f1988j = i8;
            this.f1987i = i5 - i8;
        }

        private void T() {
            if (this.f1987i - this.f1989k >= 10) {
                U();
            } else {
                V();
            }
        }

        private void U() {
            for (int i5 = 0; i5 < 10; i5++) {
                byte[] bArr = this.f1985g;
                int i6 = this.f1989k;
                this.f1989k = i6 + 1;
                if (bArr[i6] >= 0) {
                    return;
                }
            }
            throw e0.f();
        }

        private void V() {
            for (int i5 = 0; i5 < 10; i5++) {
                if (J() >= 0) {
                    return;
                }
            }
            throw e0.f();
        }

        @Override // com.google.protobuf.j
        public long A() {
            return j.c(O());
        }

        @Override // com.google.protobuf.j
        public String B() {
            int N = N();
            if (N > 0) {
                int i5 = this.f1987i;
                int i6 = this.f1989k;
                if (N <= i5 - i6) {
                    String str = new String(this.f1985g, i6, N, d0.f1911b);
                    this.f1989k += N;
                    return str;
                }
            }
            if (N == 0) {
                return "";
            }
            if (N < 0) {
                throw e0.g();
            }
            throw e0.m();
        }

        @Override // com.google.protobuf.j
        public String C() {
            int N = N();
            if (N > 0) {
                int i5 = this.f1987i;
                int i6 = this.f1989k;
                if (N <= i5 - i6) {
                    String h5 = b2.h(this.f1985g, i6, N);
                    this.f1989k += N;
                    return h5;
                }
            }
            if (N == 0) {
                return "";
            }
            if (N <= 0) {
                throw e0.g();
            }
            throw e0.m();
        }

        @Override // com.google.protobuf.j
        public int D() {
            if (e()) {
                this.f1991m = 0;
                return 0;
            }
            int N = N();
            this.f1991m = N;
            if (c2.a(N) != 0) {
                return this.f1991m;
            }
            throw e0.c();
        }

        @Override // com.google.protobuf.j
        public int E() {
            return N();
        }

        @Override // com.google.protobuf.j
        public long F() {
            return O();
        }

        @Override // com.google.protobuf.j
        public boolean I(int i5) {
            int b5 = c2.b(i5);
            if (b5 == 0) {
                T();
                return true;
            } else if (b5 == 1) {
                S(8);
                return true;
            } else if (b5 == 2) {
                S(N());
                return true;
            } else if (b5 == 3) {
                R();
                a(c2.c(c2.a(i5), 4));
                return true;
            } else if (b5 != 4) {
                if (b5 == 5) {
                    S(4);
                    return true;
                }
                throw e0.e();
            } else {
                return false;
            }
        }

        public byte J() {
            int i5 = this.f1989k;
            if (i5 != this.f1987i) {
                byte[] bArr = this.f1985g;
                this.f1989k = i5 + 1;
                return bArr[i5];
            }
            throw e0.m();
        }

        public byte[] K(int i5) {
            if (i5 > 0) {
                int i6 = this.f1987i;
                int i7 = this.f1989k;
                if (i5 <= i6 - i7) {
                    int i8 = i5 + i7;
                    this.f1989k = i8;
                    return Arrays.copyOfRange(this.f1985g, i7, i8);
                }
            }
            if (i5 <= 0) {
                if (i5 == 0) {
                    return d0.f1913d;
                }
                throw e0.g();
            }
            throw e0.m();
        }

        public int L() {
            int i5 = this.f1989k;
            if (this.f1987i - i5 >= 4) {
                byte[] bArr = this.f1985g;
                this.f1989k = i5 + 4;
                return ((bArr[i5 + 3] & 255) << 24) | (bArr[i5] & 255) | ((bArr[i5 + 1] & 255) << 8) | ((bArr[i5 + 2] & 255) << 16);
            }
            throw e0.m();
        }

        public long M() {
            int i5 = this.f1989k;
            if (this.f1987i - i5 >= 8) {
                byte[] bArr = this.f1985g;
                this.f1989k = i5 + 8;
                return ((bArr[i5 + 7] & 255) << 56) | (bArr[i5] & 255) | ((bArr[i5 + 1] & 255) << 8) | ((bArr[i5 + 2] & 255) << 16) | ((bArr[i5 + 3] & 255) << 24) | ((bArr[i5 + 4] & 255) << 32) | ((bArr[i5 + 5] & 255) << 40) | ((bArr[i5 + 6] & 255) << 48);
            }
            throw e0.m();
        }

        /* JADX WARN: Code restructure failed: missing block: B:33:0x0068, code lost:
            if (r2[r3] < 0) goto L34;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public int N() {
            /*
                r5 = this;
                int r0 = r5.f1989k
                int r1 = r5.f1987i
                if (r1 != r0) goto L7
                goto L6a
            L7:
                byte[] r2 = r5.f1985g
                int r3 = r0 + 1
                r0 = r2[r0]
                if (r0 < 0) goto L12
                r5.f1989k = r3
                return r0
            L12:
                int r1 = r1 - r3
                r4 = 9
                if (r1 >= r4) goto L18
                goto L6a
            L18:
                int r1 = r3 + 1
                r3 = r2[r3]
                int r3 = r3 << 7
                r0 = r0 ^ r3
                if (r0 >= 0) goto L24
                r0 = r0 ^ (-128(0xffffffffffffff80, float:NaN))
                goto L70
            L24:
                int r3 = r1 + 1
                r1 = r2[r1]
                int r1 = r1 << 14
                r0 = r0 ^ r1
                if (r0 < 0) goto L31
                r0 = r0 ^ 16256(0x3f80, float:2.278E-41)
            L2f:
                r1 = r3
                goto L70
            L31:
                int r1 = r3 + 1
                r3 = r2[r3]
                int r3 = r3 << 21
                r0 = r0 ^ r3
                if (r0 >= 0) goto L3f
                r2 = -2080896(0xffffffffffe03f80, float:NaN)
                r0 = r0 ^ r2
                goto L70
            L3f:
                int r3 = r1 + 1
                r1 = r2[r1]
                int r4 = r1 << 28
                r0 = r0 ^ r4
                r4 = 266354560(0xfe03f80, float:2.2112565E-29)
                r0 = r0 ^ r4
                if (r1 >= 0) goto L2f
                int r1 = r3 + 1
                r3 = r2[r3]
                if (r3 >= 0) goto L70
                int r3 = r1 + 1
                r1 = r2[r1]
                if (r1 >= 0) goto L2f
                int r1 = r3 + 1
                r3 = r2[r3]
                if (r3 >= 0) goto L70
                int r3 = r1 + 1
                r1 = r2[r1]
                if (r1 >= 0) goto L2f
                int r1 = r3 + 1
                r2 = r2[r3]
                if (r2 >= 0) goto L70
            L6a:
                long r0 = r5.P()
                int r1 = (int) r0
                return r1
            L70:
                r5.f1989k = r1
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.j.b.N():int");
        }

        /* JADX WARN: Code restructure failed: missing block: B:39:0x00b4, code lost:
            if (r2[r0] < 0) goto L42;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public long O() {
            /*
                Method dump skipped, instructions count: 192
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.j.b.O():long");
        }

        long P() {
            long j5 = 0;
            for (int i5 = 0; i5 < 64; i5 += 7) {
                byte J = J();
                j5 |= (J & Byte.MAX_VALUE) << i5;
                if ((J & 128) == 0) {
                    return j5;
                }
            }
            throw e0.f();
        }

        public void R() {
            int D;
            do {
                D = D();
                if (D == 0) {
                    return;
                }
            } while (I(D));
        }

        public void S(int i5) {
            if (i5 >= 0) {
                int i6 = this.f1987i;
                int i7 = this.f1989k;
                if (i5 <= i6 - i7) {
                    this.f1989k = i7 + i5;
                    return;
                }
            }
            if (i5 >= 0) {
                throw e0.m();
            }
            throw e0.g();
        }

        @Override // com.google.protobuf.j
        public void a(int i5) {
            if (this.f1991m != i5) {
                throw e0.b();
            }
        }

        @Override // com.google.protobuf.j
        public int d() {
            return this.f1989k - this.f1990l;
        }

        @Override // com.google.protobuf.j
        public boolean e() {
            return this.f1989k == this.f1987i;
        }

        @Override // com.google.protobuf.j
        public void m(int i5) {
            this.f1993o = i5;
            Q();
        }

        @Override // com.google.protobuf.j
        public int n(int i5) {
            if (i5 >= 0) {
                int d5 = i5 + d();
                if (d5 >= 0) {
                    int i6 = this.f1993o;
                    if (d5 <= i6) {
                        this.f1993o = d5;
                        Q();
                        return i6;
                    }
                    throw e0.m();
                }
                throw e0.h();
            }
            throw e0.g();
        }

        @Override // com.google.protobuf.j
        public boolean o() {
            return O() != 0;
        }

        @Override // com.google.protobuf.j
        public i p() {
            int N = N();
            if (N > 0) {
                int i5 = this.f1987i;
                int i6 = this.f1989k;
                if (N <= i5 - i6) {
                    i O = (this.f1986h && this.f1992n) ? i.O(this.f1985g, i6, N) : i.q(this.f1985g, i6, N);
                    this.f1989k += N;
                    return O;
                }
            }
            return N == 0 ? i.f1961b : i.N(K(N));
        }

        @Override // com.google.protobuf.j
        public double q() {
            return Double.longBitsToDouble(M());
        }

        @Override // com.google.protobuf.j
        public int r() {
            return N();
        }

        @Override // com.google.protobuf.j
        public int s() {
            return L();
        }

        @Override // com.google.protobuf.j
        public long t() {
            return M();
        }

        @Override // com.google.protobuf.j
        public float u() {
            return Float.intBitsToFloat(L());
        }

        @Override // com.google.protobuf.j
        public int v() {
            return N();
        }

        @Override // com.google.protobuf.j
        public long w() {
            return O();
        }

        @Override // com.google.protobuf.j
        public int x() {
            return L();
        }

        @Override // com.google.protobuf.j
        public long y() {
            return M();
        }

        @Override // com.google.protobuf.j
        public int z() {
            return j.b(N());
        }
    }

    /* loaded from: classes.dex */
    private static final class c extends j {

        /* renamed from: g  reason: collision with root package name */
        private final Iterable<ByteBuffer> f1994g;

        /* renamed from: h  reason: collision with root package name */
        private final Iterator<ByteBuffer> f1995h;

        /* renamed from: i  reason: collision with root package name */
        private ByteBuffer f1996i;

        /* renamed from: j  reason: collision with root package name */
        private final boolean f1997j;

        /* renamed from: k  reason: collision with root package name */
        private boolean f1998k;

        /* renamed from: l  reason: collision with root package name */
        private int f1999l;

        /* renamed from: m  reason: collision with root package name */
        private int f2000m;

        /* renamed from: n  reason: collision with root package name */
        private int f2001n;

        /* renamed from: o  reason: collision with root package name */
        private int f2002o;

        /* renamed from: p  reason: collision with root package name */
        private int f2003p;

        /* renamed from: q  reason: collision with root package name */
        private int f2004q;

        /* renamed from: r  reason: collision with root package name */
        private long f2005r;

        /* renamed from: s  reason: collision with root package name */
        private long f2006s;

        /* renamed from: t  reason: collision with root package name */
        private long f2007t;

        /* renamed from: u  reason: collision with root package name */
        private long f2008u;

        private c(Iterable<ByteBuffer> iterable, int i5, boolean z4) {
            super();
            this.f2001n = a.e.API_PRIORITY_OTHER;
            this.f1999l = i5;
            this.f1994g = iterable;
            this.f1995h = iterable.iterator();
            this.f1997j = z4;
            this.f2003p = 0;
            this.f2004q = 0;
            if (i5 != 0) {
                Y();
                return;
            }
            this.f1996i = d0.f1914e;
            this.f2005r = 0L;
            this.f2006s = 0L;
            this.f2008u = 0L;
            this.f2007t = 0L;
        }

        private long J() {
            return this.f2008u - this.f2005r;
        }

        private void K() {
            if (!this.f1995h.hasNext()) {
                throw e0.m();
            }
            Y();
        }

        private void M(byte[] bArr, int i5, int i6) {
            if (i6 < 0 || i6 > T()) {
                if (i6 > 0) {
                    throw e0.m();
                }
                if (i6 != 0) {
                    throw e0.g();
                }
                return;
            }
            int i7 = i6;
            while (i7 > 0) {
                if (J() == 0) {
                    K();
                }
                int min = Math.min(i7, (int) J());
                long j5 = min;
                a2.p(this.f2005r, bArr, (i6 - i7) + i5, j5);
                i7 -= min;
                this.f2005r += j5;
            }
        }

        private void S() {
            int i5 = this.f1999l + this.f2000m;
            this.f1999l = i5;
            int i6 = i5 - this.f2004q;
            int i7 = this.f2001n;
            if (i6 <= i7) {
                this.f2000m = 0;
                return;
            }
            int i8 = i6 - i7;
            this.f2000m = i8;
            this.f1999l = i5 - i8;
        }

        private int T() {
            return (int) (((this.f1999l - this.f2003p) - this.f2005r) + this.f2006s);
        }

        private void W() {
            for (int i5 = 0; i5 < 10; i5++) {
                if (L() >= 0) {
                    return;
                }
            }
            throw e0.f();
        }

        private ByteBuffer X(int i5, int i6) {
            int position = this.f1996i.position();
            int limit = this.f1996i.limit();
            ByteBuffer byteBuffer = this.f1996i;
            try {
                try {
                    byteBuffer.position(i5);
                    byteBuffer.limit(i6);
                    return this.f1996i.slice();
                } catch (IllegalArgumentException unused) {
                    throw e0.m();
                }
            } finally {
                byteBuffer.position(position);
                byteBuffer.limit(limit);
            }
        }

        private void Y() {
            ByteBuffer next = this.f1995h.next();
            this.f1996i = next;
            this.f2003p += (int) (this.f2005r - this.f2006s);
            long position = next.position();
            this.f2005r = position;
            this.f2006s = position;
            this.f2008u = this.f1996i.limit();
            long k5 = a2.k(this.f1996i);
            this.f2007t = k5;
            this.f2005r += k5;
            this.f2006s += k5;
            this.f2008u += k5;
        }

        @Override // com.google.protobuf.j
        public long A() {
            return j.c(Q());
        }

        @Override // com.google.protobuf.j
        public String B() {
            int P = P();
            if (P > 0) {
                long j5 = P;
                long j6 = this.f2008u;
                long j7 = this.f2005r;
                if (j5 <= j6 - j7) {
                    byte[] bArr = new byte[P];
                    a2.p(j7, bArr, 0L, j5);
                    String str = new String(bArr, d0.f1911b);
                    this.f2005r += j5;
                    return str;
                }
            }
            if (P > 0 && P <= T()) {
                byte[] bArr2 = new byte[P];
                M(bArr2, 0, P);
                return new String(bArr2, d0.f1911b);
            } else if (P == 0) {
                return "";
            } else {
                if (P < 0) {
                    throw e0.g();
                }
                throw e0.m();
            }
        }

        @Override // com.google.protobuf.j
        public String C() {
            int P = P();
            if (P > 0) {
                long j5 = P;
                long j6 = this.f2008u;
                long j7 = this.f2005r;
                if (j5 <= j6 - j7) {
                    String g5 = b2.g(this.f1996i, (int) (j7 - this.f2006s), P);
                    this.f2005r += j5;
                    return g5;
                }
            }
            if (P >= 0 && P <= T()) {
                byte[] bArr = new byte[P];
                M(bArr, 0, P);
                return b2.h(bArr, 0, P);
            } else if (P == 0) {
                return "";
            } else {
                if (P <= 0) {
                    throw e0.g();
                }
                throw e0.m();
            }
        }

        @Override // com.google.protobuf.j
        public int D() {
            if (e()) {
                this.f2002o = 0;
                return 0;
            }
            int P = P();
            this.f2002o = P;
            if (c2.a(P) != 0) {
                return this.f2002o;
            }
            throw e0.c();
        }

        @Override // com.google.protobuf.j
        public int E() {
            return P();
        }

        @Override // com.google.protobuf.j
        public long F() {
            return Q();
        }

        @Override // com.google.protobuf.j
        public boolean I(int i5) {
            int b5 = c2.b(i5);
            if (b5 == 0) {
                W();
                return true;
            } else if (b5 == 1) {
                V(8);
                return true;
            } else if (b5 == 2) {
                V(P());
                return true;
            } else if (b5 == 3) {
                U();
                a(c2.c(c2.a(i5), 4));
                return true;
            } else if (b5 != 4) {
                if (b5 == 5) {
                    V(4);
                    return true;
                }
                throw e0.e();
            } else {
                return false;
            }
        }

        public byte L() {
            if (J() == 0) {
                K();
            }
            long j5 = this.f2005r;
            this.f2005r = 1 + j5;
            return a2.w(j5);
        }

        public int N() {
            if (J() >= 4) {
                long j5 = this.f2005r;
                this.f2005r = 4 + j5;
                return ((a2.w(j5 + 3) & 255) << 24) | (a2.w(j5) & 255) | ((a2.w(1 + j5) & 255) << 8) | ((a2.w(2 + j5) & 255) << 16);
            }
            return (L() & 255) | ((L() & 255) << 8) | ((L() & 255) << 16) | ((L() & 255) << 24);
        }

        public long O() {
            if (J() >= 8) {
                long j5 = this.f2005r;
                this.f2005r = 8 + j5;
                return ((a2.w(j5 + 7) & 255) << 56) | (a2.w(j5) & 255) | ((a2.w(1 + j5) & 255) << 8) | ((a2.w(2 + j5) & 255) << 16) | ((a2.w(3 + j5) & 255) << 24) | ((a2.w(4 + j5) & 255) << 32) | ((a2.w(5 + j5) & 255) << 40) | ((a2.w(6 + j5) & 255) << 48);
            }
            return (L() & 255) | ((L() & 255) << 8) | ((L() & 255) << 16) | ((L() & 255) << 24) | ((L() & 255) << 32) | ((L() & 255) << 40) | ((L() & 255) << 48) | ((L() & 255) << 56);
        }

        /* JADX WARN: Code restructure failed: missing block: B:33:0x0088, code lost:
            if (com.google.protobuf.a2.w(r4) < 0) goto L34;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public int P() {
            /*
                r10 = this;
                long r0 = r10.f2005r
                long r2 = r10.f2008u
                int r4 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
                if (r4 != 0) goto La
                goto L8a
            La:
                r2 = 1
                long r4 = r0 + r2
                byte r0 = com.google.protobuf.a2.w(r0)
                if (r0 < 0) goto L1a
                long r4 = r10.f2005r
                long r4 = r4 + r2
                r10.f2005r = r4
                return r0
            L1a:
                long r6 = r10.f2008u
                long r8 = r10.f2005r
                long r6 = r6 - r8
                r8 = 10
                int r1 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
                if (r1 >= 0) goto L26
                goto L8a
            L26:
                long r6 = r4 + r2
                byte r1 = com.google.protobuf.a2.w(r4)
                int r1 = r1 << 7
                r0 = r0 ^ r1
                if (r0 >= 0) goto L34
                r0 = r0 ^ (-128(0xffffffffffffff80, float:NaN))
                goto L90
            L34:
                long r4 = r6 + r2
                byte r1 = com.google.protobuf.a2.w(r6)
                int r1 = r1 << 14
                r0 = r0 ^ r1
                if (r0 < 0) goto L43
                r0 = r0 ^ 16256(0x3f80, float:2.278E-41)
            L41:
                r6 = r4
                goto L90
            L43:
                long r6 = r4 + r2
                byte r1 = com.google.protobuf.a2.w(r4)
                int r1 = r1 << 21
                r0 = r0 ^ r1
                if (r0 >= 0) goto L53
                r1 = -2080896(0xffffffffffe03f80, float:NaN)
                r0 = r0 ^ r1
                goto L90
            L53:
                long r4 = r6 + r2
                byte r1 = com.google.protobuf.a2.w(r6)
                int r6 = r1 << 28
                r0 = r0 ^ r6
                r6 = 266354560(0xfe03f80, float:2.2112565E-29)
                r0 = r0 ^ r6
                if (r1 >= 0) goto L41
                long r6 = r4 + r2
                byte r1 = com.google.protobuf.a2.w(r4)
                if (r1 >= 0) goto L90
                long r4 = r6 + r2
                byte r1 = com.google.protobuf.a2.w(r6)
                if (r1 >= 0) goto L41
                long r6 = r4 + r2
                byte r1 = com.google.protobuf.a2.w(r4)
                if (r1 >= 0) goto L90
                long r4 = r6 + r2
                byte r1 = com.google.protobuf.a2.w(r6)
                if (r1 >= 0) goto L41
                long r6 = r4 + r2
                byte r1 = com.google.protobuf.a2.w(r4)
                if (r1 >= 0) goto L90
            L8a:
                long r0 = r10.R()
                int r1 = (int) r0
                return r1
            L90:
                r10.f2005r = r6
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.j.c.P():int");
        }

        public long Q() {
            long w5;
            long j5;
            long j6;
            int i5;
            long j7 = this.f2005r;
            if (this.f2008u != j7) {
                long j8 = j7 + 1;
                byte w6 = a2.w(j7);
                if (w6 >= 0) {
                    this.f2005r++;
                    return w6;
                } else if (this.f2008u - this.f2005r >= 10) {
                    long j9 = j8 + 1;
                    int w7 = w6 ^ (a2.w(j8) << 7);
                    if (w7 >= 0) {
                        long j10 = j9 + 1;
                        int w8 = w7 ^ (a2.w(j9) << 14);
                        if (w8 >= 0) {
                            w5 = w8 ^ 16256;
                        } else {
                            j9 = j10 + 1;
                            int w9 = w8 ^ (a2.w(j10) << 21);
                            if (w9 < 0) {
                                i5 = w9 ^ (-2080896);
                            } else {
                                j10 = j9 + 1;
                                long w10 = w9 ^ (a2.w(j9) << 28);
                                if (w10 < 0) {
                                    long j11 = j10 + 1;
                                    long w11 = w10 ^ (a2.w(j10) << 35);
                                    if (w11 < 0) {
                                        j5 = -34093383808L;
                                    } else {
                                        j10 = j11 + 1;
                                        w10 = w11 ^ (a2.w(j11) << 42);
                                        if (w10 >= 0) {
                                            j6 = 4363953127296L;
                                        } else {
                                            j11 = j10 + 1;
                                            w11 = w10 ^ (a2.w(j10) << 49);
                                            if (w11 < 0) {
                                                j5 = -558586000294016L;
                                            } else {
                                                j10 = j11 + 1;
                                                w5 = (w11 ^ (a2.w(j11) << 56)) ^ 71499008037633920L;
                                                if (w5 < 0) {
                                                    long j12 = 1 + j10;
                                                    if (a2.w(j10) >= 0) {
                                                        j9 = j12;
                                                        this.f2005r = j9;
                                                        return w5;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    w5 = w11 ^ j5;
                                    j9 = j11;
                                    this.f2005r = j9;
                                    return w5;
                                }
                                j6 = 266354560;
                                w5 = w10 ^ j6;
                            }
                        }
                        j9 = j10;
                        this.f2005r = j9;
                        return w5;
                    }
                    i5 = w7 ^ (-128);
                    w5 = i5;
                    this.f2005r = j9;
                    return w5;
                }
            }
            return R();
        }

        long R() {
            long j5 = 0;
            for (int i5 = 0; i5 < 64; i5 += 7) {
                byte L = L();
                j5 |= (L & Byte.MAX_VALUE) << i5;
                if ((L & 128) == 0) {
                    return j5;
                }
            }
            throw e0.f();
        }

        public void U() {
            int D;
            do {
                D = D();
                if (D == 0) {
                    return;
                }
            } while (I(D));
        }

        public void V(int i5) {
            if (i5 < 0 || i5 > ((this.f1999l - this.f2003p) - this.f2005r) + this.f2006s) {
                if (i5 >= 0) {
                    throw e0.m();
                }
                throw e0.g();
            }
            while (i5 > 0) {
                if (J() == 0) {
                    K();
                }
                int min = Math.min(i5, (int) J());
                i5 -= min;
                this.f2005r += min;
            }
        }

        @Override // com.google.protobuf.j
        public void a(int i5) {
            if (this.f2002o != i5) {
                throw e0.b();
            }
        }

        @Override // com.google.protobuf.j
        public int d() {
            return (int) (((this.f2003p - this.f2004q) + this.f2005r) - this.f2006s);
        }

        @Override // com.google.protobuf.j
        public boolean e() {
            return (((long) this.f2003p) + this.f2005r) - this.f2006s == ((long) this.f1999l);
        }

        @Override // com.google.protobuf.j
        public void m(int i5) {
            this.f2001n = i5;
            S();
        }

        @Override // com.google.protobuf.j
        public int n(int i5) {
            if (i5 >= 0) {
                int d5 = i5 + d();
                int i6 = this.f2001n;
                if (d5 <= i6) {
                    this.f2001n = d5;
                    S();
                    return i6;
                }
                throw e0.m();
            }
            throw e0.g();
        }

        @Override // com.google.protobuf.j
        public boolean o() {
            return Q() != 0;
        }

        @Override // com.google.protobuf.j
        public i p() {
            int P = P();
            if (P > 0) {
                long j5 = P;
                long j6 = this.f2008u;
                long j7 = this.f2005r;
                if (j5 <= j6 - j7) {
                    if (this.f1997j && this.f1998k) {
                        int i5 = (int) (j7 - this.f2007t);
                        i M = i.M(X(i5, P + i5));
                        this.f2005r += j5;
                        return M;
                    }
                    byte[] bArr = new byte[P];
                    a2.p(j7, bArr, 0L, j5);
                    this.f2005r += j5;
                    return i.N(bArr);
                }
            }
            if (P <= 0 || P > T()) {
                if (P == 0) {
                    return i.f1961b;
                }
                if (P < 0) {
                    throw e0.g();
                }
                throw e0.m();
            } else if (!this.f1997j || !this.f1998k) {
                byte[] bArr2 = new byte[P];
                M(bArr2, 0, P);
                return i.N(bArr2);
            } else {
                ArrayList arrayList = new ArrayList();
                while (P > 0) {
                    if (J() == 0) {
                        K();
                    }
                    int min = Math.min(P, (int) J());
                    int i6 = (int) (this.f2005r - this.f2007t);
                    arrayList.add(i.M(X(i6, i6 + min)));
                    P -= min;
                    this.f2005r += min;
                }
                return i.o(arrayList);
            }
        }

        @Override // com.google.protobuf.j
        public double q() {
            return Double.longBitsToDouble(O());
        }

        @Override // com.google.protobuf.j
        public int r() {
            return P();
        }

        @Override // com.google.protobuf.j
        public int s() {
            return N();
        }

        @Override // com.google.protobuf.j
        public long t() {
            return O();
        }

        @Override // com.google.protobuf.j
        public float u() {
            return Float.intBitsToFloat(N());
        }

        @Override // com.google.protobuf.j
        public int v() {
            return P();
        }

        @Override // com.google.protobuf.j
        public long w() {
            return Q();
        }

        @Override // com.google.protobuf.j
        public int x() {
            return N();
        }

        @Override // com.google.protobuf.j
        public long y() {
            return O();
        }

        @Override // com.google.protobuf.j
        public int z() {
            return j.b(P());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class d extends j {

        /* renamed from: g  reason: collision with root package name */
        private final InputStream f2009g;

        /* renamed from: h  reason: collision with root package name */
        private final byte[] f2010h;

        /* renamed from: i  reason: collision with root package name */
        private int f2011i;

        /* renamed from: j  reason: collision with root package name */
        private int f2012j;

        /* renamed from: k  reason: collision with root package name */
        private int f2013k;

        /* renamed from: l  reason: collision with root package name */
        private int f2014l;

        /* renamed from: m  reason: collision with root package name */
        private int f2015m;

        /* renamed from: n  reason: collision with root package name */
        private int f2016n;

        /* renamed from: o  reason: collision with root package name */
        private a f2017o;

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public interface a {
            void a();
        }

        private d(InputStream inputStream, int i5) {
            super();
            this.f2016n = a.e.API_PRIORITY_OTHER;
            this.f2017o = null;
            d0.b(inputStream, "input");
            this.f2009g = inputStream;
            this.f2010h = new byte[i5];
            this.f2011i = 0;
            this.f2013k = 0;
            this.f2015m = 0;
        }

        private static int J(InputStream inputStream) {
            try {
                return inputStream.available();
            } catch (e0 e5) {
                e5.j();
                throw e5;
            }
        }

        private static int K(InputStream inputStream, byte[] bArr, int i5, int i6) {
            try {
                return inputStream.read(bArr, i5, i6);
            } catch (e0 e5) {
                e5.j();
                throw e5;
            }
        }

        private i L(int i5) {
            byte[] O = O(i5);
            if (O != null) {
                return i.p(O);
            }
            int i6 = this.f2013k;
            int i7 = this.f2011i;
            int i8 = i7 - i6;
            this.f2015m += i7;
            this.f2013k = 0;
            this.f2011i = 0;
            List<byte[]> P = P(i5 - i8);
            byte[] bArr = new byte[i5];
            System.arraycopy(this.f2010h, i6, bArr, 0, i8);
            for (byte[] bArr2 : P) {
                System.arraycopy(bArr2, 0, bArr, i8, bArr2.length);
                i8 += bArr2.length;
            }
            return i.N(bArr);
        }

        private byte[] N(int i5, boolean z4) {
            byte[] O = O(i5);
            if (O != null) {
                return z4 ? (byte[]) O.clone() : O;
            }
            int i6 = this.f2013k;
            int i7 = this.f2011i;
            int i8 = i7 - i6;
            this.f2015m += i7;
            this.f2013k = 0;
            this.f2011i = 0;
            List<byte[]> P = P(i5 - i8);
            byte[] bArr = new byte[i5];
            System.arraycopy(this.f2010h, i6, bArr, 0, i8);
            for (byte[] bArr2 : P) {
                System.arraycopy(bArr2, 0, bArr, i8, bArr2.length);
                i8 += bArr2.length;
            }
            return bArr;
        }

        private byte[] O(int i5) {
            if (i5 == 0) {
                return d0.f1913d;
            }
            if (i5 >= 0) {
                int i6 = this.f2015m;
                int i7 = this.f2013k;
                int i8 = i6 + i7 + i5;
                if (i8 - this.f1982c <= 0) {
                    int i9 = this.f2016n;
                    if (i8 > i9) {
                        Z((i9 - i6) - i7);
                        throw e0.m();
                    }
                    int i10 = this.f2011i - i7;
                    int i11 = i5 - i10;
                    if (i11 < 4096 || i11 <= J(this.f2009g)) {
                        byte[] bArr = new byte[i5];
                        System.arraycopy(this.f2010h, this.f2013k, bArr, 0, i10);
                        this.f2015m += this.f2011i;
                        this.f2013k = 0;
                        this.f2011i = 0;
                        while (i10 < i5) {
                            int K = K(this.f2009g, bArr, i10, i5 - i10);
                            if (K == -1) {
                                throw e0.m();
                            }
                            this.f2015m += K;
                            i10 += K;
                        }
                        return bArr;
                    }
                    return null;
                }
                throw e0.l();
            }
            throw e0.g();
        }

        private List<byte[]> P(int i5) {
            ArrayList arrayList = new ArrayList();
            while (i5 > 0) {
                int min = Math.min(i5, 4096);
                byte[] bArr = new byte[min];
                int i6 = 0;
                while (i6 < min) {
                    int read = this.f2009g.read(bArr, i6, min - i6);
                    if (read == -1) {
                        throw e0.m();
                    }
                    this.f2015m += read;
                    i6 += read;
                }
                i5 -= min;
                arrayList.add(bArr);
            }
            return arrayList;
        }

        private void V() {
            int i5 = this.f2011i + this.f2012j;
            this.f2011i = i5;
            int i6 = this.f2015m + i5;
            int i7 = this.f2016n;
            if (i6 <= i7) {
                this.f2012j = 0;
                return;
            }
            int i8 = i6 - i7;
            this.f2012j = i8;
            this.f2011i = i5 - i8;
        }

        private void W(int i5) {
            if (e0(i5)) {
                return;
            }
            if (i5 <= (this.f1982c - this.f2015m) - this.f2013k) {
                throw e0.m();
            }
            throw e0.l();
        }

        private static long X(InputStream inputStream, long j5) {
            try {
                return inputStream.skip(j5);
            } catch (e0 e5) {
                e5.j();
                throw e5;
            }
        }

        private void a0(int i5) {
            if (i5 < 0) {
                throw e0.g();
            }
            int i6 = this.f2015m;
            int i7 = this.f2013k;
            int i8 = i6 + i7 + i5;
            int i9 = this.f2016n;
            if (i8 > i9) {
                Z((i9 - i6) - i7);
                throw e0.m();
            }
            int i10 = 0;
            if (this.f2017o == null) {
                this.f2015m = i6 + i7;
                this.f2011i = 0;
                this.f2013k = 0;
                i10 = this.f2011i - i7;
                while (i10 < i5) {
                    try {
                        long j5 = i5 - i10;
                        long X = X(this.f2009g, j5);
                        int i11 = (X > 0L ? 1 : (X == 0L ? 0 : -1));
                        if (i11 < 0 || X > j5) {
                            throw new IllegalStateException(this.f2009g.getClass() + "#skip returned invalid result: " + X + "\nThe InputStream implementation is buggy.");
                        } else if (i11 == 0) {
                            break;
                        } else {
                            i10 += (int) X;
                        }
                    } finally {
                        this.f2015m += i10;
                        V();
                    }
                }
            }
            if (i10 >= i5) {
                return;
            }
            int i12 = this.f2011i;
            int i13 = i12 - this.f2013k;
            this.f2013k = i12;
            while (true) {
                W(1);
                int i14 = i5 - i13;
                int i15 = this.f2011i;
                if (i14 <= i15) {
                    this.f2013k = i14;
                    return;
                } else {
                    i13 += i15;
                    this.f2013k = i15;
                }
            }
        }

        private void b0() {
            if (this.f2011i - this.f2013k >= 10) {
                c0();
            } else {
                d0();
            }
        }

        private void c0() {
            for (int i5 = 0; i5 < 10; i5++) {
                byte[] bArr = this.f2010h;
                int i6 = this.f2013k;
                this.f2013k = i6 + 1;
                if (bArr[i6] >= 0) {
                    return;
                }
            }
            throw e0.f();
        }

        private void d0() {
            for (int i5 = 0; i5 < 10; i5++) {
                if (M() >= 0) {
                    return;
                }
            }
            throw e0.f();
        }

        private boolean e0(int i5) {
            int i6 = this.f2013k;
            if (i6 + i5 <= this.f2011i) {
                throw new IllegalStateException("refillBuffer() called when " + i5 + " bytes were already available in buffer");
            }
            int i7 = this.f1982c;
            int i8 = this.f2015m;
            if (i5 <= (i7 - i8) - i6 && i8 + i6 + i5 <= this.f2016n) {
                a aVar = this.f2017o;
                if (aVar != null) {
                    aVar.a();
                }
                int i9 = this.f2013k;
                if (i9 > 0) {
                    int i10 = this.f2011i;
                    if (i10 > i9) {
                        byte[] bArr = this.f2010h;
                        System.arraycopy(bArr, i9, bArr, 0, i10 - i9);
                    }
                    this.f2015m += i9;
                    this.f2011i -= i9;
                    this.f2013k = 0;
                }
                InputStream inputStream = this.f2009g;
                byte[] bArr2 = this.f2010h;
                int i11 = this.f2011i;
                int K = K(inputStream, bArr2, i11, Math.min(bArr2.length - i11, (this.f1982c - this.f2015m) - i11));
                if (K == 0 || K < -1 || K > this.f2010h.length) {
                    throw new IllegalStateException(this.f2009g.getClass() + "#read(byte[]) returned invalid result: " + K + "\nThe InputStream implementation is buggy.");
                } else if (K > 0) {
                    this.f2011i += K;
                    V();
                    if (this.f2011i >= i5) {
                        return true;
                    }
                    return e0(i5);
                } else {
                    return false;
                }
            }
            return false;
        }

        @Override // com.google.protobuf.j
        public long A() {
            return j.c(T());
        }

        @Override // com.google.protobuf.j
        public String B() {
            int S = S();
            if (S > 0) {
                int i5 = this.f2011i;
                int i6 = this.f2013k;
                if (S <= i5 - i6) {
                    String str = new String(this.f2010h, i6, S, d0.f1911b);
                    this.f2013k += S;
                    return str;
                }
            }
            if (S == 0) {
                return "";
            }
            if (S <= this.f2011i) {
                W(S);
                String str2 = new String(this.f2010h, this.f2013k, S, d0.f1911b);
                this.f2013k += S;
                return str2;
            }
            return new String(N(S, false), d0.f1911b);
        }

        @Override // com.google.protobuf.j
        public String C() {
            byte[] N;
            int S = S();
            int i5 = this.f2013k;
            int i6 = this.f2011i;
            if (S <= i6 - i5 && S > 0) {
                N = this.f2010h;
                this.f2013k = i5 + S;
            } else if (S == 0) {
                return "";
            } else {
                if (S <= i6) {
                    W(S);
                    N = this.f2010h;
                    this.f2013k = S + 0;
                } else {
                    N = N(S, false);
                }
                i5 = 0;
            }
            return b2.h(N, i5, S);
        }

        @Override // com.google.protobuf.j
        public int D() {
            if (e()) {
                this.f2014l = 0;
                return 0;
            }
            int S = S();
            this.f2014l = S;
            if (c2.a(S) != 0) {
                return this.f2014l;
            }
            throw e0.c();
        }

        @Override // com.google.protobuf.j
        public int E() {
            return S();
        }

        @Override // com.google.protobuf.j
        public long F() {
            return T();
        }

        @Override // com.google.protobuf.j
        public boolean I(int i5) {
            int b5 = c2.b(i5);
            if (b5 == 0) {
                b0();
                return true;
            } else if (b5 == 1) {
                Z(8);
                return true;
            } else if (b5 == 2) {
                Z(S());
                return true;
            } else if (b5 == 3) {
                Y();
                a(c2.c(c2.a(i5), 4));
                return true;
            } else if (b5 != 4) {
                if (b5 == 5) {
                    Z(4);
                    return true;
                }
                throw e0.e();
            } else {
                return false;
            }
        }

        public byte M() {
            if (this.f2013k == this.f2011i) {
                W(1);
            }
            byte[] bArr = this.f2010h;
            int i5 = this.f2013k;
            this.f2013k = i5 + 1;
            return bArr[i5];
        }

        public int Q() {
            int i5 = this.f2013k;
            if (this.f2011i - i5 < 4) {
                W(4);
                i5 = this.f2013k;
            }
            byte[] bArr = this.f2010h;
            this.f2013k = i5 + 4;
            return ((bArr[i5 + 3] & 255) << 24) | (bArr[i5] & 255) | ((bArr[i5 + 1] & 255) << 8) | ((bArr[i5 + 2] & 255) << 16);
        }

        public long R() {
            int i5 = this.f2013k;
            if (this.f2011i - i5 < 8) {
                W(8);
                i5 = this.f2013k;
            }
            byte[] bArr = this.f2010h;
            this.f2013k = i5 + 8;
            return ((bArr[i5 + 7] & 255) << 56) | (bArr[i5] & 255) | ((bArr[i5 + 1] & 255) << 8) | ((bArr[i5 + 2] & 255) << 16) | ((bArr[i5 + 3] & 255) << 24) | ((bArr[i5 + 4] & 255) << 32) | ((bArr[i5 + 5] & 255) << 40) | ((bArr[i5 + 6] & 255) << 48);
        }

        /* JADX WARN: Code restructure failed: missing block: B:33:0x0068, code lost:
            if (r2[r3] < 0) goto L34;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public int S() {
            /*
                r5 = this;
                int r0 = r5.f2013k
                int r1 = r5.f2011i
                if (r1 != r0) goto L7
                goto L6a
            L7:
                byte[] r2 = r5.f2010h
                int r3 = r0 + 1
                r0 = r2[r0]
                if (r0 < 0) goto L12
                r5.f2013k = r3
                return r0
            L12:
                int r1 = r1 - r3
                r4 = 9
                if (r1 >= r4) goto L18
                goto L6a
            L18:
                int r1 = r3 + 1
                r3 = r2[r3]
                int r3 = r3 << 7
                r0 = r0 ^ r3
                if (r0 >= 0) goto L24
                r0 = r0 ^ (-128(0xffffffffffffff80, float:NaN))
                goto L70
            L24:
                int r3 = r1 + 1
                r1 = r2[r1]
                int r1 = r1 << 14
                r0 = r0 ^ r1
                if (r0 < 0) goto L31
                r0 = r0 ^ 16256(0x3f80, float:2.278E-41)
            L2f:
                r1 = r3
                goto L70
            L31:
                int r1 = r3 + 1
                r3 = r2[r3]
                int r3 = r3 << 21
                r0 = r0 ^ r3
                if (r0 >= 0) goto L3f
                r2 = -2080896(0xffffffffffe03f80, float:NaN)
                r0 = r0 ^ r2
                goto L70
            L3f:
                int r3 = r1 + 1
                r1 = r2[r1]
                int r4 = r1 << 28
                r0 = r0 ^ r4
                r4 = 266354560(0xfe03f80, float:2.2112565E-29)
                r0 = r0 ^ r4
                if (r1 >= 0) goto L2f
                int r1 = r3 + 1
                r3 = r2[r3]
                if (r3 >= 0) goto L70
                int r3 = r1 + 1
                r1 = r2[r1]
                if (r1 >= 0) goto L2f
                int r1 = r3 + 1
                r3 = r2[r3]
                if (r3 >= 0) goto L70
                int r3 = r1 + 1
                r1 = r2[r1]
                if (r1 >= 0) goto L2f
                int r1 = r3 + 1
                r2 = r2[r3]
                if (r2 >= 0) goto L70
            L6a:
                long r0 = r5.U()
                int r1 = (int) r0
                return r1
            L70:
                r5.f2013k = r1
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.j.d.S():int");
        }

        /* JADX WARN: Code restructure failed: missing block: B:39:0x00b4, code lost:
            if (r2[r0] < 0) goto L42;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public long T() {
            /*
                Method dump skipped, instructions count: 192
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.j.d.T():long");
        }

        long U() {
            long j5 = 0;
            for (int i5 = 0; i5 < 64; i5 += 7) {
                byte M = M();
                j5 |= (M & Byte.MAX_VALUE) << i5;
                if ((M & 128) == 0) {
                    return j5;
                }
            }
            throw e0.f();
        }

        public void Y() {
            int D;
            do {
                D = D();
                if (D == 0) {
                    return;
                }
            } while (I(D));
        }

        public void Z(int i5) {
            int i6 = this.f2011i;
            int i7 = this.f2013k;
            if (i5 > i6 - i7 || i5 < 0) {
                a0(i5);
            } else {
                this.f2013k = i7 + i5;
            }
        }

        @Override // com.google.protobuf.j
        public void a(int i5) {
            if (this.f2014l != i5) {
                throw e0.b();
            }
        }

        @Override // com.google.protobuf.j
        public int d() {
            return this.f2015m + this.f2013k;
        }

        @Override // com.google.protobuf.j
        public boolean e() {
            return this.f2013k == this.f2011i && !e0(1);
        }

        @Override // com.google.protobuf.j
        public void m(int i5) {
            this.f2016n = i5;
            V();
        }

        @Override // com.google.protobuf.j
        public int n(int i5) {
            if (i5 >= 0) {
                int i6 = i5 + this.f2015m + this.f2013k;
                int i7 = this.f2016n;
                if (i6 <= i7) {
                    this.f2016n = i6;
                    V();
                    return i7;
                }
                throw e0.m();
            }
            throw e0.g();
        }

        @Override // com.google.protobuf.j
        public boolean o() {
            return T() != 0;
        }

        @Override // com.google.protobuf.j
        public i p() {
            int S = S();
            int i5 = this.f2011i;
            int i6 = this.f2013k;
            if (S > i5 - i6 || S <= 0) {
                return S == 0 ? i.f1961b : L(S);
            }
            i q5 = i.q(this.f2010h, i6, S);
            this.f2013k += S;
            return q5;
        }

        @Override // com.google.protobuf.j
        public double q() {
            return Double.longBitsToDouble(R());
        }

        @Override // com.google.protobuf.j
        public int r() {
            return S();
        }

        @Override // com.google.protobuf.j
        public int s() {
            return Q();
        }

        @Override // com.google.protobuf.j
        public long t() {
            return R();
        }

        @Override // com.google.protobuf.j
        public float u() {
            return Float.intBitsToFloat(Q());
        }

        @Override // com.google.protobuf.j
        public int v() {
            return S();
        }

        @Override // com.google.protobuf.j
        public long w() {
            return T();
        }

        @Override // com.google.protobuf.j
        public int x() {
            return Q();
        }

        @Override // com.google.protobuf.j
        public long y() {
            return R();
        }

        @Override // com.google.protobuf.j
        public int z() {
            return j.b(S());
        }
    }

    /* loaded from: classes.dex */
    private static final class e extends j {

        /* renamed from: g  reason: collision with root package name */
        private final ByteBuffer f2018g;

        /* renamed from: h  reason: collision with root package name */
        private final boolean f2019h;

        /* renamed from: i  reason: collision with root package name */
        private final long f2020i;

        /* renamed from: j  reason: collision with root package name */
        private long f2021j;

        /* renamed from: k  reason: collision with root package name */
        private long f2022k;

        /* renamed from: l  reason: collision with root package name */
        private long f2023l;

        /* renamed from: m  reason: collision with root package name */
        private int f2024m;

        /* renamed from: n  reason: collision with root package name */
        private int f2025n;

        /* renamed from: o  reason: collision with root package name */
        private boolean f2026o;

        /* renamed from: p  reason: collision with root package name */
        private int f2027p;

        private e(ByteBuffer byteBuffer, boolean z4) {
            super();
            this.f2027p = a.e.API_PRIORITY_OTHER;
            this.f2018g = byteBuffer;
            long k5 = a2.k(byteBuffer);
            this.f2020i = k5;
            this.f2021j = byteBuffer.limit() + k5;
            long position = k5 + byteBuffer.position();
            this.f2022k = position;
            this.f2023l = position;
            this.f2019h = z4;
        }

        private int J(long j5) {
            return (int) (j5 - this.f2020i);
        }

        static boolean K() {
            return a2.J();
        }

        private void R() {
            long j5 = this.f2021j + this.f2024m;
            this.f2021j = j5;
            int i5 = (int) (j5 - this.f2023l);
            int i6 = this.f2027p;
            if (i5 <= i6) {
                this.f2024m = 0;
                return;
            }
            int i7 = i5 - i6;
            this.f2024m = i7;
            this.f2021j = j5 - i7;
        }

        private int S() {
            return (int) (this.f2021j - this.f2022k);
        }

        private void V() {
            if (S() >= 10) {
                W();
            } else {
                X();
            }
        }

        private void W() {
            for (int i5 = 0; i5 < 10; i5++) {
                long j5 = this.f2022k;
                this.f2022k = 1 + j5;
                if (a2.w(j5) >= 0) {
                    return;
                }
            }
            throw e0.f();
        }

        private void X() {
            for (int i5 = 0; i5 < 10; i5++) {
                if (L() >= 0) {
                    return;
                }
            }
            throw e0.f();
        }

        private ByteBuffer Y(long j5, long j6) {
            int position = this.f2018g.position();
            int limit = this.f2018g.limit();
            ByteBuffer byteBuffer = this.f2018g;
            try {
                try {
                    byteBuffer.position(J(j5));
                    byteBuffer.limit(J(j6));
                    return this.f2018g.slice();
                } catch (IllegalArgumentException e5) {
                    e0 m5 = e0.m();
                    m5.initCause(e5);
                    throw m5;
                }
            } finally {
                byteBuffer.position(position);
                byteBuffer.limit(limit);
            }
        }

        @Override // com.google.protobuf.j
        public long A() {
            return j.c(P());
        }

        @Override // com.google.protobuf.j
        public String B() {
            int O = O();
            if (O <= 0 || O > S()) {
                if (O == 0) {
                    return "";
                }
                if (O < 0) {
                    throw e0.g();
                }
                throw e0.m();
            }
            byte[] bArr = new byte[O];
            long j5 = O;
            a2.p(this.f2022k, bArr, 0L, j5);
            String str = new String(bArr, d0.f1911b);
            this.f2022k += j5;
            return str;
        }

        @Override // com.google.protobuf.j
        public String C() {
            int O = O();
            if (O > 0 && O <= S()) {
                String g5 = b2.g(this.f2018g, J(this.f2022k), O);
                this.f2022k += O;
                return g5;
            } else if (O == 0) {
                return "";
            } else {
                if (O <= 0) {
                    throw e0.g();
                }
                throw e0.m();
            }
        }

        @Override // com.google.protobuf.j
        public int D() {
            if (e()) {
                this.f2025n = 0;
                return 0;
            }
            int O = O();
            this.f2025n = O;
            if (c2.a(O) != 0) {
                return this.f2025n;
            }
            throw e0.c();
        }

        @Override // com.google.protobuf.j
        public int E() {
            return O();
        }

        @Override // com.google.protobuf.j
        public long F() {
            return P();
        }

        @Override // com.google.protobuf.j
        public boolean I(int i5) {
            int b5 = c2.b(i5);
            if (b5 == 0) {
                V();
                return true;
            } else if (b5 == 1) {
                U(8);
                return true;
            } else if (b5 == 2) {
                U(O());
                return true;
            } else if (b5 == 3) {
                T();
                a(c2.c(c2.a(i5), 4));
                return true;
            } else if (b5 != 4) {
                if (b5 == 5) {
                    U(4);
                    return true;
                }
                throw e0.e();
            } else {
                return false;
            }
        }

        public byte L() {
            long j5 = this.f2022k;
            if (j5 != this.f2021j) {
                this.f2022k = 1 + j5;
                return a2.w(j5);
            }
            throw e0.m();
        }

        public int M() {
            long j5 = this.f2022k;
            if (this.f2021j - j5 >= 4) {
                this.f2022k = 4 + j5;
                return ((a2.w(j5 + 3) & 255) << 24) | (a2.w(j5) & 255) | ((a2.w(1 + j5) & 255) << 8) | ((a2.w(2 + j5) & 255) << 16);
            }
            throw e0.m();
        }

        public long N() {
            long j5 = this.f2022k;
            if (this.f2021j - j5 >= 8) {
                this.f2022k = 8 + j5;
                return ((a2.w(j5 + 7) & 255) << 56) | (a2.w(j5) & 255) | ((a2.w(1 + j5) & 255) << 8) | ((a2.w(2 + j5) & 255) << 16) | ((a2.w(3 + j5) & 255) << 24) | ((a2.w(4 + j5) & 255) << 32) | ((a2.w(5 + j5) & 255) << 40) | ((a2.w(6 + j5) & 255) << 48);
            }
            throw e0.m();
        }

        /* JADX WARN: Code restructure failed: missing block: B:33:0x0083, code lost:
            if (com.google.protobuf.a2.w(r4) < 0) goto L34;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public int O() {
            /*
                r10 = this;
                long r0 = r10.f2022k
                long r2 = r10.f2021j
                int r4 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
                if (r4 != 0) goto La
                goto L85
            La:
                r2 = 1
                long r4 = r0 + r2
                byte r0 = com.google.protobuf.a2.w(r0)
                if (r0 < 0) goto L17
                r10.f2022k = r4
                return r0
            L17:
                long r6 = r10.f2021j
                long r6 = r6 - r4
                r8 = 9
                int r1 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
                if (r1 >= 0) goto L21
                goto L85
            L21:
                long r6 = r4 + r2
                byte r1 = com.google.protobuf.a2.w(r4)
                int r1 = r1 << 7
                r0 = r0 ^ r1
                if (r0 >= 0) goto L2f
                r0 = r0 ^ (-128(0xffffffffffffff80, float:NaN))
                goto L8b
            L2f:
                long r4 = r6 + r2
                byte r1 = com.google.protobuf.a2.w(r6)
                int r1 = r1 << 14
                r0 = r0 ^ r1
                if (r0 < 0) goto L3e
                r0 = r0 ^ 16256(0x3f80, float:2.278E-41)
            L3c:
                r6 = r4
                goto L8b
            L3e:
                long r6 = r4 + r2
                byte r1 = com.google.protobuf.a2.w(r4)
                int r1 = r1 << 21
                r0 = r0 ^ r1
                if (r0 >= 0) goto L4e
                r1 = -2080896(0xffffffffffe03f80, float:NaN)
                r0 = r0 ^ r1
                goto L8b
            L4e:
                long r4 = r6 + r2
                byte r1 = com.google.protobuf.a2.w(r6)
                int r6 = r1 << 28
                r0 = r0 ^ r6
                r6 = 266354560(0xfe03f80, float:2.2112565E-29)
                r0 = r0 ^ r6
                if (r1 >= 0) goto L3c
                long r6 = r4 + r2
                byte r1 = com.google.protobuf.a2.w(r4)
                if (r1 >= 0) goto L8b
                long r4 = r6 + r2
                byte r1 = com.google.protobuf.a2.w(r6)
                if (r1 >= 0) goto L3c
                long r6 = r4 + r2
                byte r1 = com.google.protobuf.a2.w(r4)
                if (r1 >= 0) goto L8b
                long r4 = r6 + r2
                byte r1 = com.google.protobuf.a2.w(r6)
                if (r1 >= 0) goto L3c
                long r6 = r4 + r2
                byte r1 = com.google.protobuf.a2.w(r4)
                if (r1 >= 0) goto L8b
            L85:
                long r0 = r10.Q()
                int r1 = (int) r0
                return r1
            L8b:
                r10.f2022k = r6
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.j.e.O():int");
        }

        public long P() {
            long w5;
            long j5;
            long j6;
            int i5;
            long j7 = this.f2022k;
            if (this.f2021j != j7) {
                long j8 = j7 + 1;
                byte w6 = a2.w(j7);
                if (w6 >= 0) {
                    this.f2022k = j8;
                    return w6;
                } else if (this.f2021j - j8 >= 9) {
                    long j9 = j8 + 1;
                    int w7 = w6 ^ (a2.w(j8) << 7);
                    if (w7 >= 0) {
                        long j10 = j9 + 1;
                        int w8 = w7 ^ (a2.w(j9) << 14);
                        if (w8 >= 0) {
                            w5 = w8 ^ 16256;
                        } else {
                            j9 = j10 + 1;
                            int w9 = w8 ^ (a2.w(j10) << 21);
                            if (w9 < 0) {
                                i5 = w9 ^ (-2080896);
                            } else {
                                j10 = j9 + 1;
                                long w10 = w9 ^ (a2.w(j9) << 28);
                                if (w10 < 0) {
                                    long j11 = j10 + 1;
                                    long w11 = w10 ^ (a2.w(j10) << 35);
                                    if (w11 < 0) {
                                        j5 = -34093383808L;
                                    } else {
                                        j10 = j11 + 1;
                                        w10 = w11 ^ (a2.w(j11) << 42);
                                        if (w10 >= 0) {
                                            j6 = 4363953127296L;
                                        } else {
                                            j11 = j10 + 1;
                                            w11 = w10 ^ (a2.w(j10) << 49);
                                            if (w11 < 0) {
                                                j5 = -558586000294016L;
                                            } else {
                                                j10 = j11 + 1;
                                                w5 = (w11 ^ (a2.w(j11) << 56)) ^ 71499008037633920L;
                                                if (w5 < 0) {
                                                    long j12 = 1 + j10;
                                                    if (a2.w(j10) >= 0) {
                                                        j9 = j12;
                                                        this.f2022k = j9;
                                                        return w5;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    w5 = w11 ^ j5;
                                    j9 = j11;
                                    this.f2022k = j9;
                                    return w5;
                                }
                                j6 = 266354560;
                                w5 = w10 ^ j6;
                            }
                        }
                        j9 = j10;
                        this.f2022k = j9;
                        return w5;
                    }
                    i5 = w7 ^ (-128);
                    w5 = i5;
                    this.f2022k = j9;
                    return w5;
                }
            }
            return Q();
        }

        long Q() {
            long j5 = 0;
            for (int i5 = 0; i5 < 64; i5 += 7) {
                byte L = L();
                j5 |= (L & Byte.MAX_VALUE) << i5;
                if ((L & 128) == 0) {
                    return j5;
                }
            }
            throw e0.f();
        }

        public void T() {
            int D;
            do {
                D = D();
                if (D == 0) {
                    return;
                }
            } while (I(D));
        }

        public void U(int i5) {
            if (i5 >= 0 && i5 <= S()) {
                this.f2022k += i5;
            } else if (i5 >= 0) {
                throw e0.m();
            } else {
                throw e0.g();
            }
        }

        @Override // com.google.protobuf.j
        public void a(int i5) {
            if (this.f2025n != i5) {
                throw e0.b();
            }
        }

        @Override // com.google.protobuf.j
        public int d() {
            return (int) (this.f2022k - this.f2023l);
        }

        @Override // com.google.protobuf.j
        public boolean e() {
            return this.f2022k == this.f2021j;
        }

        @Override // com.google.protobuf.j
        public void m(int i5) {
            this.f2027p = i5;
            R();
        }

        @Override // com.google.protobuf.j
        public int n(int i5) {
            if (i5 >= 0) {
                int d5 = i5 + d();
                int i6 = this.f2027p;
                if (d5 <= i6) {
                    this.f2027p = d5;
                    R();
                    return i6;
                }
                throw e0.m();
            }
            throw e0.g();
        }

        @Override // com.google.protobuf.j
        public boolean o() {
            return P() != 0;
        }

        @Override // com.google.protobuf.j
        public i p() {
            int O = O();
            if (O <= 0 || O > S()) {
                if (O == 0) {
                    return i.f1961b;
                }
                if (O < 0) {
                    throw e0.g();
                }
                throw e0.m();
            } else if (this.f2019h && this.f2026o) {
                long j5 = this.f2022k;
                long j6 = O;
                ByteBuffer Y = Y(j5, j5 + j6);
                this.f2022k += j6;
                return i.M(Y);
            } else {
                byte[] bArr = new byte[O];
                long j7 = O;
                a2.p(this.f2022k, bArr, 0L, j7);
                this.f2022k += j7;
                return i.N(bArr);
            }
        }

        @Override // com.google.protobuf.j
        public double q() {
            return Double.longBitsToDouble(N());
        }

        @Override // com.google.protobuf.j
        public int r() {
            return O();
        }

        @Override // com.google.protobuf.j
        public int s() {
            return M();
        }

        @Override // com.google.protobuf.j
        public long t() {
            return N();
        }

        @Override // com.google.protobuf.j
        public float u() {
            return Float.intBitsToFloat(M());
        }

        @Override // com.google.protobuf.j
        public int v() {
            return O();
        }

        @Override // com.google.protobuf.j
        public long w() {
            return P();
        }

        @Override // com.google.protobuf.j
        public int x() {
            return M();
        }

        @Override // com.google.protobuf.j
        public long y() {
            return N();
        }

        @Override // com.google.protobuf.j
        public int z() {
            return j.b(O());
        }
    }

    private j() {
        this.f1981b = f1979f;
        this.f1982c = a.e.API_PRIORITY_OTHER;
        this.f1984e = false;
    }

    public static int b(int i5) {
        return (-(i5 & 1)) ^ (i5 >>> 1);
    }

    public static long c(long j5) {
        return (-(j5 & 1)) ^ (j5 >>> 1);
    }

    public static j f(InputStream inputStream) {
        return g(inputStream, 4096);
    }

    public static j g(InputStream inputStream, int i5) {
        if (i5 > 0) {
            return inputStream == null ? j(d0.f1913d) : new d(inputStream, i5);
        }
        throw new IllegalArgumentException("bufferSize must be > 0");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static j h(Iterable<ByteBuffer> iterable, boolean z4) {
        boolean z5 = false;
        int i5 = 0;
        for (ByteBuffer byteBuffer : iterable) {
            i5 += byteBuffer.remaining();
            z5 = byteBuffer.hasArray() ? z5 | true : byteBuffer.isDirect() ? z5 | true : z5 | true;
        }
        return z5 ? new c(iterable, i5, z4) : f(new f0(iterable));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static j i(ByteBuffer byteBuffer, boolean z4) {
        if (byteBuffer.hasArray()) {
            return l(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining(), z4);
        }
        if (byteBuffer.isDirect() && e.K()) {
            return new e(byteBuffer, z4);
        }
        int remaining = byteBuffer.remaining();
        byte[] bArr = new byte[remaining];
        byteBuffer.duplicate().get(bArr);
        return l(bArr, 0, remaining, true);
    }

    public static j j(byte[] bArr) {
        return k(bArr, 0, bArr.length);
    }

    public static j k(byte[] bArr, int i5, int i6) {
        return l(bArr, i5, i6, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static j l(byte[] bArr, int i5, int i6, boolean z4) {
        b bVar = new b(bArr, i5, i6, z4);
        try {
            bVar.n(i6);
            return bVar;
        } catch (e0 e5) {
            throw new IllegalArgumentException(e5);
        }
    }

    public abstract long A();

    public abstract String B();

    public abstract String C();

    public abstract int D();

    public abstract int E();

    public abstract long F();

    public final int G(int i5) {
        if (i5 >= 0) {
            int i6 = this.f1981b;
            this.f1981b = i5;
            return i6;
        }
        throw new IllegalArgumentException("Recursion limit cannot be negative: " + i5);
    }

    public final int H(int i5) {
        if (i5 >= 0) {
            int i6 = this.f1982c;
            this.f1982c = i5;
            return i6;
        }
        throw new IllegalArgumentException("Size limit cannot be negative: " + i5);
    }

    public abstract boolean I(int i5);

    public abstract void a(int i5);

    public abstract int d();

    public abstract boolean e();

    public abstract void m(int i5);

    public abstract int n(int i5);

    public abstract boolean o();

    public abstract i p();

    public abstract double q();

    public abstract int r();

    public abstract int s();

    public abstract long t();

    public abstract float u();

    public abstract int v();

    public abstract long w();

    public abstract int x();

    public abstract long y();

    public abstract int z();
}
