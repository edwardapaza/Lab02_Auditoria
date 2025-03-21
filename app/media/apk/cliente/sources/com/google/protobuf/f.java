package com.google.protobuf;

import com.google.protobuf.c2;
import com.google.protobuf.d0;
import com.google.protobuf.z;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class f {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f1925a;

        static {
            int[] iArr = new int[c2.b.values().length];
            f1925a = iArr;
            try {
                iArr[c2.b.f1875c.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1925a[c2.b.f1876d.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f1925a[c2.b.f1877e.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f1925a[c2.b.f1878f.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f1925a[c2.b.f1879k.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f1925a[c2.b.f1887s.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f1925a[c2.b.f1880l.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f1925a[c2.b.f1890v.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f1925a[c2.b.f1881m.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f1925a[c2.b.f1889u.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f1925a[c2.b.f1882n.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f1925a[c2.b.f1891w.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f1925a[c2.b.f1892x.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f1925a[c2.b.f1888t.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f1925a[c2.b.f1886r.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f1925a[c2.b.f1883o.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f1925a[c2.b.f1884p.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                f1925a[c2.b.f1885q.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public int f1926a;

        /* renamed from: b  reason: collision with root package name */
        public long f1927b;

        /* renamed from: c  reason: collision with root package name */
        public Object f1928c;

        /* renamed from: d  reason: collision with root package name */
        public final q f1929d;

        /* JADX INFO: Access modifiers changed from: package-private */
        public b(q qVar) {
            qVar.getClass();
            this.f1929d = qVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int A(int i5, byte[] bArr, int i6, int i7, d0.i<?> iVar, b bVar) {
        c0 c0Var = (c0) iVar;
        int I = I(bArr, i6, bVar);
        while (true) {
            c0Var.k(j.b(bVar.f1926a));
            if (I >= i7) {
                break;
            }
            int I2 = I(bArr, I, bVar);
            if (i5 != bVar.f1926a) {
                break;
            }
            I = I(bArr, I2, bVar);
        }
        return I;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int B(int i5, byte[] bArr, int i6, int i7, d0.i<?> iVar, b bVar) {
        n0 n0Var = (n0) iVar;
        int L = L(bArr, i6, bVar);
        while (true) {
            n0Var.l(j.c(bVar.f1927b));
            if (L >= i7) {
                break;
            }
            int I = I(bArr, L, bVar);
            if (i5 != bVar.f1926a) {
                break;
            }
            L = L(bArr, I, bVar);
        }
        return L;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int C(byte[] bArr, int i5, b bVar) {
        int I = I(bArr, i5, bVar);
        int i6 = bVar.f1926a;
        if (i6 >= 0) {
            if (i6 == 0) {
                bVar.f1928c = "";
                return I;
            }
            bVar.f1928c = new String(bArr, I, i6, d0.f1911b);
            return I + i6;
        }
        throw e0.g();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x001d  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x002e -> B:6:0x000c). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:8:0x0017 -> B:9:0x001b). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int D(int r4, byte[] r5, int r6, int r7, com.google.protobuf.d0.i<?> r8, com.google.protobuf.f.b r9) {
        /*
            int r6 = I(r5, r6, r9)
            int r0 = r9.f1926a
            if (r0 < 0) goto L3f
            java.lang.String r1 = ""
            if (r0 != 0) goto L10
        Lc:
            r8.add(r1)
            goto L1b
        L10:
            java.lang.String r2 = new java.lang.String
            java.nio.charset.Charset r3 = com.google.protobuf.d0.f1911b
            r2.<init>(r5, r6, r0, r3)
        L17:
            r8.add(r2)
            int r6 = r6 + r0
        L1b:
            if (r6 >= r7) goto L3e
            int r0 = I(r5, r6, r9)
            int r2 = r9.f1926a
            if (r4 == r2) goto L26
            goto L3e
        L26:
            int r6 = I(r5, r0, r9)
            int r0 = r9.f1926a
            if (r0 < 0) goto L39
            if (r0 != 0) goto L31
            goto Lc
        L31:
            java.lang.String r2 = new java.lang.String
            java.nio.charset.Charset r3 = com.google.protobuf.d0.f1911b
            r2.<init>(r5, r6, r0, r3)
            goto L17
        L39:
            com.google.protobuf.e0 r4 = com.google.protobuf.e0.g()
            throw r4
        L3e:
            return r6
        L3f:
            com.google.protobuf.e0 r4 = com.google.protobuf.e0.g()
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.f.D(int, byte[], int, int, com.google.protobuf.d0$i, com.google.protobuf.f$b):int");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0025  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x001f -> B:11:0x0023). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0036 -> B:6:0x000c). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int E(int r5, byte[] r6, int r7, int r8, com.google.protobuf.d0.i<?> r9, com.google.protobuf.f.b r10) {
        /*
            int r7 = I(r6, r7, r10)
            int r0 = r10.f1926a
            if (r0 < 0) goto L59
            java.lang.String r1 = ""
            if (r0 != 0) goto L10
        Lc:
            r9.add(r1)
            goto L23
        L10:
            int r2 = r7 + r0
            boolean r3 = com.google.protobuf.b2.t(r6, r7, r2)
            if (r3 == 0) goto L54
            java.lang.String r3 = new java.lang.String
            java.nio.charset.Charset r4 = com.google.protobuf.d0.f1911b
            r3.<init>(r6, r7, r0, r4)
        L1f:
            r9.add(r3)
            r7 = r2
        L23:
            if (r7 >= r8) goto L53
            int r0 = I(r6, r7, r10)
            int r2 = r10.f1926a
            if (r5 == r2) goto L2e
            goto L53
        L2e:
            int r7 = I(r6, r0, r10)
            int r0 = r10.f1926a
            if (r0 < 0) goto L4e
            if (r0 != 0) goto L39
            goto Lc
        L39:
            int r2 = r7 + r0
            boolean r3 = com.google.protobuf.b2.t(r6, r7, r2)
            if (r3 == 0) goto L49
            java.lang.String r3 = new java.lang.String
            java.nio.charset.Charset r4 = com.google.protobuf.d0.f1911b
            r3.<init>(r6, r7, r0, r4)
            goto L1f
        L49:
            com.google.protobuf.e0 r5 = com.google.protobuf.e0.d()
            throw r5
        L4e:
            com.google.protobuf.e0 r5 = com.google.protobuf.e0.g()
            throw r5
        L53:
            return r7
        L54:
            com.google.protobuf.e0 r5 = com.google.protobuf.e0.d()
            throw r5
        L59:
            com.google.protobuf.e0 r5 = com.google.protobuf.e0.g()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.f.E(int, byte[], int, int, com.google.protobuf.d0$i, com.google.protobuf.f$b):int");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int F(byte[] bArr, int i5, b bVar) {
        int I = I(bArr, i5, bVar);
        int i6 = bVar.f1926a;
        if (i6 >= 0) {
            if (i6 == 0) {
                bVar.f1928c = "";
                return I;
            }
            bVar.f1928c = b2.h(bArr, I, i6);
            return I + i6;
        }
        throw e0.g();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int G(int i5, byte[] bArr, int i6, int i7, x1 x1Var, b bVar) {
        if (c2.a(i5) != 0) {
            int b5 = c2.b(i5);
            if (b5 == 0) {
                int L = L(bArr, i6, bVar);
                x1Var.n(i5, Long.valueOf(bVar.f1927b));
                return L;
            } else if (b5 == 1) {
                x1Var.n(i5, Long.valueOf(j(bArr, i6)));
                return i6 + 8;
            } else if (b5 == 2) {
                int I = I(bArr, i6, bVar);
                int i8 = bVar.f1926a;
                if (i8 >= 0) {
                    if (i8 <= bArr.length - I) {
                        x1Var.n(i5, i8 == 0 ? i.f1961b : i.q(bArr, I, i8));
                        return I + i8;
                    }
                    throw e0.m();
                }
                throw e0.g();
            } else if (b5 != 3) {
                if (b5 == 5) {
                    x1Var.n(i5, Integer.valueOf(h(bArr, i6)));
                    return i6 + 4;
                }
                throw e0.c();
            } else {
                x1 k5 = x1.k();
                int i9 = (i5 & (-8)) | 4;
                int i10 = 0;
                while (true) {
                    if (i6 >= i7) {
                        break;
                    }
                    int I2 = I(bArr, i6, bVar);
                    int i11 = bVar.f1926a;
                    i10 = i11;
                    if (i11 == i9) {
                        i6 = I2;
                        break;
                    }
                    int G = G(i10, bArr, I2, i7, k5, bVar);
                    i10 = i11;
                    i6 = G;
                }
                if (i6 > i7 || i10 != i9) {
                    throw e0.h();
                }
                x1Var.n(i5, k5);
                return i6;
            }
        }
        throw e0.c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int H(int i5, byte[] bArr, int i6, b bVar) {
        int i7;
        int i8;
        int i9 = i5 & 127;
        int i10 = i6 + 1;
        byte b5 = bArr[i6];
        if (b5 < 0) {
            int i11 = i9 | ((b5 & Byte.MAX_VALUE) << 7);
            int i12 = i10 + 1;
            byte b6 = bArr[i10];
            if (b6 >= 0) {
                i7 = b6 << 14;
            } else {
                i9 = i11 | ((b6 & Byte.MAX_VALUE) << 14);
                i10 = i12 + 1;
                byte b7 = bArr[i12];
                if (b7 >= 0) {
                    i8 = b7 << 21;
                } else {
                    i11 = i9 | ((b7 & Byte.MAX_VALUE) << 21);
                    i12 = i10 + 1;
                    byte b8 = bArr[i10];
                    if (b8 >= 0) {
                        i7 = b8 << 28;
                    } else {
                        int i13 = i11 | ((b8 & Byte.MAX_VALUE) << 28);
                        while (true) {
                            int i14 = i12 + 1;
                            if (bArr[i12] >= 0) {
                                bVar.f1926a = i13;
                                return i14;
                            }
                            i12 = i14;
                        }
                    }
                }
            }
            bVar.f1926a = i11 | i7;
            return i12;
        }
        i8 = b5 << 7;
        bVar.f1926a = i9 | i8;
        return i10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int I(byte[] bArr, int i5, b bVar) {
        int i6 = i5 + 1;
        byte b5 = bArr[i5];
        if (b5 >= 0) {
            bVar.f1926a = b5;
            return i6;
        }
        return H(b5, bArr, i6, bVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int J(int i5, byte[] bArr, int i6, int i7, d0.i<?> iVar, b bVar) {
        c0 c0Var = (c0) iVar;
        int I = I(bArr, i6, bVar);
        while (true) {
            c0Var.k(bVar.f1926a);
            if (I >= i7) {
                break;
            }
            int I2 = I(bArr, I, bVar);
            if (i5 != bVar.f1926a) {
                break;
            }
            I = I(bArr, I2, bVar);
        }
        return I;
    }

    static int K(long j5, byte[] bArr, int i5, b bVar) {
        int i6 = i5 + 1;
        byte b5 = bArr[i5];
        long j6 = (j5 & 127) | ((b5 & Byte.MAX_VALUE) << 7);
        int i7 = 7;
        while (b5 < 0) {
            int i8 = i6 + 1;
            byte b6 = bArr[i6];
            i7 += 7;
            j6 |= (b6 & Byte.MAX_VALUE) << i7;
            i6 = i8;
            b5 = b6;
        }
        bVar.f1927b = j6;
        return i6;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int L(byte[] bArr, int i5, b bVar) {
        int i6 = i5 + 1;
        long j5 = bArr[i5];
        if (j5 >= 0) {
            bVar.f1927b = j5;
            return i6;
        }
        return K(j5, bArr, i6, bVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int M(int i5, byte[] bArr, int i6, int i7, d0.i<?> iVar, b bVar) {
        n0 n0Var = (n0) iVar;
        int L = L(bArr, i6, bVar);
        while (true) {
            n0Var.l(bVar.f1927b);
            if (L >= i7) {
                break;
            }
            int I = I(bArr, L, bVar);
            if (i5 != bVar.f1926a) {
                break;
            }
            L = L(bArr, I, bVar);
        }
        return L;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int N(Object obj, o1 o1Var, byte[] bArr, int i5, int i6, int i7, b bVar) {
        int h02 = ((z0) o1Var).h0(obj, bArr, i5, i6, i7, bVar);
        bVar.f1928c = obj;
        return h02;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int O(Object obj, o1 o1Var, byte[] bArr, int i5, int i6, b bVar) {
        int i7 = i5 + 1;
        int i8 = bArr[i5];
        if (i8 < 0) {
            i7 = H(i8, bArr, i7, bVar);
            i8 = bVar.f1926a;
        }
        int i9 = i7;
        if (i8 < 0 || i8 > i6 - i9) {
            throw e0.m();
        }
        int i10 = i8 + i9;
        o1Var.g(obj, bArr, i9, i10, bVar);
        bVar.f1928c = obj;
        return i10;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int P(int i5, byte[] bArr, int i6, int i7, b bVar) {
        if (c2.a(i5) != 0) {
            int b5 = c2.b(i5);
            if (b5 != 0) {
                if (b5 != 1) {
                    if (b5 != 2) {
                        if (b5 != 3) {
                            if (b5 == 5) {
                                return i6 + 4;
                            }
                            throw e0.c();
                        }
                        int i8 = (i5 & (-8)) | 4;
                        int i9 = 0;
                        while (i6 < i7) {
                            i6 = I(bArr, i6, bVar);
                            i9 = bVar.f1926a;
                            if (i9 == i8) {
                                break;
                            }
                            i6 = P(i9, bArr, i6, i7, bVar);
                        }
                        if (i6 > i7 || i9 != i8) {
                            throw e0.h();
                        }
                        return i6;
                    }
                    return I(bArr, i6, bVar) + bVar.f1926a;
                }
                return i6 + 8;
            }
            return L(bArr, i6, bVar);
        }
        throw e0.c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0021, code lost:
        r9 = L(r8, r0, r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0029, code lost:
        if (r12.f1927b == 0) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x002c, code lost:
        return r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:3:0x000e, code lost:
        if (r12.f1927b != 0) goto L3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x0010, code lost:
        r0 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x0012, code lost:
        r0 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0013, code lost:
        r11.l(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0016, code lost:
        if (r9 >= r10) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0018, code lost:
        r0 = I(r8, r9, r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x001e, code lost:
        if (r7 == r12.f1926a) goto L8;
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x0029 -> B:4:0x0010). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:5:0x0012 -> B:6:0x0013). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int a(int r7, byte[] r8, int r9, int r10, com.google.protobuf.d0.i<?> r11, com.google.protobuf.f.b r12) {
        /*
            com.google.protobuf.g r11 = (com.google.protobuf.g) r11
            int r9 = L(r8, r9, r12)
            long r0 = r12.f1927b
            r2 = 1
            r3 = 0
            r4 = 0
            int r6 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r6 == 0) goto L12
        L10:
            r0 = 1
            goto L13
        L12:
            r0 = 0
        L13:
            r11.l(r0)
            if (r9 >= r10) goto L2c
            int r0 = I(r8, r9, r12)
            int r1 = r12.f1926a
            if (r7 == r1) goto L21
            goto L2c
        L21:
            int r9 = L(r8, r0, r12)
            long r0 = r12.f1927b
            int r6 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r6 == 0) goto L12
            goto L10
        L2c:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.f.a(int, byte[], int, int, com.google.protobuf.d0$i, com.google.protobuf.f$b):int");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int b(byte[] bArr, int i5, b bVar) {
        int I = I(bArr, i5, bVar);
        int i6 = bVar.f1926a;
        if (i6 >= 0) {
            if (i6 <= bArr.length - I) {
                if (i6 == 0) {
                    bVar.f1928c = i.f1961b;
                    return I;
                }
                bVar.f1928c = i.q(bArr, I, i6);
                return I + i6;
            }
            throw e0.m();
        }
        throw e0.g();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:10:0x001e, code lost:
        r0 = I(r3, r4, r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0024, code lost:
        if (r2 == r7.f1926a) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0027, code lost:
        r4 = I(r3, r0, r7);
        r0 = r7.f1926a;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x002d, code lost:
        if (r0 < 0) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0031, code lost:
        if (r0 > (r3.length - r4)) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0033, code lost:
        if (r0 != 0) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x003a, code lost:
        throw com.google.protobuf.e0.m();
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x003f, code lost:
        throw com.google.protobuf.e0.g();
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0040, code lost:
        return r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x000c, code lost:
        if (r0 == 0) goto L6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x000e, code lost:
        r6.add(com.google.protobuf.i.f1961b);
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0014, code lost:
        r6.add(com.google.protobuf.i.q(r3, r4, r0));
        r4 = r4 + r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x001c, code lost:
        if (r4 >= r5) goto L20;
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0033 -> B:7:0x000e). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:8:0x0014 -> B:9:0x001c). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int c(int r2, byte[] r3, int r4, int r5, com.google.protobuf.d0.i<?> r6, com.google.protobuf.f.b r7) {
        /*
            int r4 = I(r3, r4, r7)
            int r0 = r7.f1926a
            if (r0 < 0) goto L46
            int r1 = r3.length
            int r1 = r1 - r4
            if (r0 > r1) goto L41
            if (r0 != 0) goto L14
        Le:
            com.google.protobuf.i r0 = com.google.protobuf.i.f1961b
            r6.add(r0)
            goto L1c
        L14:
            com.google.protobuf.i r1 = com.google.protobuf.i.q(r3, r4, r0)
            r6.add(r1)
            int r4 = r4 + r0
        L1c:
            if (r4 >= r5) goto L40
            int r0 = I(r3, r4, r7)
            int r1 = r7.f1926a
            if (r2 == r1) goto L27
            goto L40
        L27:
            int r4 = I(r3, r0, r7)
            int r0 = r7.f1926a
            if (r0 < 0) goto L3b
            int r1 = r3.length
            int r1 = r1 - r4
            if (r0 > r1) goto L36
            if (r0 != 0) goto L14
            goto Le
        L36:
            com.google.protobuf.e0 r2 = com.google.protobuf.e0.m()
            throw r2
        L3b:
            com.google.protobuf.e0 r2 = com.google.protobuf.e0.g()
            throw r2
        L40:
            return r4
        L41:
            com.google.protobuf.e0 r2 = com.google.protobuf.e0.m()
            throw r2
        L46:
            com.google.protobuf.e0 r2 = com.google.protobuf.e0.g()
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.f.c(int, byte[], int, int, com.google.protobuf.d0$i, com.google.protobuf.f$b):int");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static double d(byte[] bArr, int i5) {
        return Double.longBitsToDouble(j(bArr, i5));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int e(int i5, byte[] bArr, int i6, int i7, d0.i<?> iVar, b bVar) {
        n nVar = (n) iVar;
        nVar.k(d(bArr, i6));
        int i8 = i6 + 8;
        while (i8 < i7) {
            int I = I(bArr, i8, bVar);
            if (i5 != bVar.f1926a) {
                break;
            }
            nVar.k(d(bArr, I));
            i8 = I + 8;
        }
        return i8;
    }

    /* JADX WARN: Removed duplicated region for block: B:71:0x01ef  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x01f5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static int f(int r8, byte[] r9, int r10, int r11, com.google.protobuf.z.c<?, ?> r12, com.google.protobuf.z.e<?, ?> r13, com.google.protobuf.w1<com.google.protobuf.x1, com.google.protobuf.x1> r14, com.google.protobuf.f.b r15) {
        /*
            Method dump skipped, instructions count: 580
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.f.f(int, byte[], int, int, com.google.protobuf.z$c, com.google.protobuf.z$e, com.google.protobuf.w1, com.google.protobuf.f$b):int");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int g(int i5, byte[] bArr, int i6, int i7, Object obj, w0 w0Var, w1<x1, x1> w1Var, b bVar) {
        z.e a5 = bVar.f1929d.a(w0Var, i5 >>> 3);
        if (a5 == null) {
            return G(i5, bArr, i6, i7, z0.x(obj), bVar);
        }
        z.c cVar = (z.c) obj;
        cVar.d0();
        return f(i5, bArr, i6, i7, cVar, a5, w1Var, bVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int h(byte[] bArr, int i5) {
        return ((bArr[i5 + 3] & 255) << 24) | (bArr[i5] & 255) | ((bArr[i5 + 1] & 255) << 8) | ((bArr[i5 + 2] & 255) << 16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int i(int i5, byte[] bArr, int i6, int i7, d0.i<?> iVar, b bVar) {
        c0 c0Var = (c0) iVar;
        c0Var.k(h(bArr, i6));
        int i8 = i6 + 4;
        while (i8 < i7) {
            int I = I(bArr, i8, bVar);
            if (i5 != bVar.f1926a) {
                break;
            }
            c0Var.k(h(bArr, I));
            i8 = I + 4;
        }
        return i8;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long j(byte[] bArr, int i5) {
        return ((bArr[i5 + 7] & 255) << 56) | (bArr[i5] & 255) | ((bArr[i5 + 1] & 255) << 8) | ((bArr[i5 + 2] & 255) << 16) | ((bArr[i5 + 3] & 255) << 24) | ((bArr[i5 + 4] & 255) << 32) | ((bArr[i5 + 5] & 255) << 40) | ((bArr[i5 + 6] & 255) << 48);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int k(int i5, byte[] bArr, int i6, int i7, d0.i<?> iVar, b bVar) {
        n0 n0Var = (n0) iVar;
        n0Var.l(j(bArr, i6));
        int i8 = i6 + 8;
        while (i8 < i7) {
            int I = I(bArr, i8, bVar);
            if (i5 != bVar.f1926a) {
                break;
            }
            n0Var.l(j(bArr, I));
            i8 = I + 8;
        }
        return i8;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static float l(byte[] bArr, int i5) {
        return Float.intBitsToFloat(h(bArr, i5));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int m(int i5, byte[] bArr, int i6, int i7, d0.i<?> iVar, b bVar) {
        x xVar = (x) iVar;
        xVar.k(l(bArr, i6));
        int i8 = i6 + 4;
        while (i8 < i7) {
            int I = I(bArr, i8, bVar);
            if (i5 != bVar.f1926a) {
                break;
            }
            xVar.k(l(bArr, I));
            i8 = I + 4;
        }
        return i8;
    }

    static int n(o1 o1Var, byte[] bArr, int i5, int i6, int i7, b bVar) {
        Object i8 = o1Var.i();
        int N = N(i8, o1Var, bArr, i5, i6, i7, bVar);
        o1Var.c(i8);
        bVar.f1928c = i8;
        return N;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int o(o1 o1Var, int i5, byte[] bArr, int i6, int i7, d0.i<?> iVar, b bVar) {
        int i8 = (i5 & (-8)) | 4;
        int n5 = n(o1Var, bArr, i6, i7, i8, bVar);
        while (true) {
            iVar.add(bVar.f1928c);
            if (n5 >= i7) {
                break;
            }
            int I = I(bArr, n5, bVar);
            if (i5 != bVar.f1926a) {
                break;
            }
            n5 = n(o1Var, bArr, I, i7, i8, bVar);
        }
        return n5;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int p(o1 o1Var, byte[] bArr, int i5, int i6, b bVar) {
        Object i7 = o1Var.i();
        int O = O(i7, o1Var, bArr, i5, i6, bVar);
        o1Var.c(i7);
        bVar.f1928c = i7;
        return O;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int q(o1<?> o1Var, int i5, byte[] bArr, int i6, int i7, d0.i<?> iVar, b bVar) {
        int p5 = p(o1Var, bArr, i6, i7, bVar);
        while (true) {
            iVar.add(bVar.f1928c);
            if (p5 >= i7) {
                break;
            }
            int I = I(bArr, p5, bVar);
            if (i5 != bVar.f1926a) {
                break;
            }
            p5 = p(o1Var, bArr, I, i7, bVar);
        }
        return p5;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int r(byte[] bArr, int i5, d0.i<?> iVar, b bVar) {
        g gVar = (g) iVar;
        int I = I(bArr, i5, bVar);
        int i6 = bVar.f1926a + I;
        while (I < i6) {
            I = L(bArr, I, bVar);
            gVar.l(bVar.f1927b != 0);
        }
        if (I == i6) {
            return I;
        }
        throw e0.m();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int s(byte[] bArr, int i5, d0.i<?> iVar, b bVar) {
        n nVar = (n) iVar;
        int I = I(bArr, i5, bVar);
        int i6 = bVar.f1926a + I;
        while (I < i6) {
            nVar.k(d(bArr, I));
            I += 8;
        }
        if (I == i6) {
            return I;
        }
        throw e0.m();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int t(byte[] bArr, int i5, d0.i<?> iVar, b bVar) {
        c0 c0Var = (c0) iVar;
        int I = I(bArr, i5, bVar);
        int i6 = bVar.f1926a + I;
        while (I < i6) {
            c0Var.k(h(bArr, I));
            I += 4;
        }
        if (I == i6) {
            return I;
        }
        throw e0.m();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int u(byte[] bArr, int i5, d0.i<?> iVar, b bVar) {
        n0 n0Var = (n0) iVar;
        int I = I(bArr, i5, bVar);
        int i6 = bVar.f1926a + I;
        while (I < i6) {
            n0Var.l(j(bArr, I));
            I += 8;
        }
        if (I == i6) {
            return I;
        }
        throw e0.m();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int v(byte[] bArr, int i5, d0.i<?> iVar, b bVar) {
        x xVar = (x) iVar;
        int I = I(bArr, i5, bVar);
        int i6 = bVar.f1926a + I;
        while (I < i6) {
            xVar.k(l(bArr, I));
            I += 4;
        }
        if (I == i6) {
            return I;
        }
        throw e0.m();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int w(byte[] bArr, int i5, d0.i<?> iVar, b bVar) {
        c0 c0Var = (c0) iVar;
        int I = I(bArr, i5, bVar);
        int i6 = bVar.f1926a + I;
        while (I < i6) {
            I = I(bArr, I, bVar);
            c0Var.k(j.b(bVar.f1926a));
        }
        if (I == i6) {
            return I;
        }
        throw e0.m();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int x(byte[] bArr, int i5, d0.i<?> iVar, b bVar) {
        n0 n0Var = (n0) iVar;
        int I = I(bArr, i5, bVar);
        int i6 = bVar.f1926a + I;
        while (I < i6) {
            I = L(bArr, I, bVar);
            n0Var.l(j.c(bVar.f1927b));
        }
        if (I == i6) {
            return I;
        }
        throw e0.m();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int y(byte[] bArr, int i5, d0.i<?> iVar, b bVar) {
        c0 c0Var = (c0) iVar;
        int I = I(bArr, i5, bVar);
        int i6 = bVar.f1926a + I;
        while (I < i6) {
            I = I(bArr, I, bVar);
            c0Var.k(bVar.f1926a);
        }
        if (I == i6) {
            return I;
        }
        throw e0.m();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int z(byte[] bArr, int i5, d0.i<?> iVar, b bVar) {
        n0 n0Var = (n0) iVar;
        int I = I(bArr, i5, bVar);
        int i6 = bVar.f1926a + I;
        while (I < i6) {
            I = L(bArr, I, bVar);
            n0Var.l(bVar.f1927b);
        }
        if (I == i6) {
            return I;
        }
        throw e0.m();
    }
}
