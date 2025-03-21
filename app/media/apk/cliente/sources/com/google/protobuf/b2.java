package com.google.protobuf;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Arrays;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class b2 {

    /* renamed from: a  reason: collision with root package name */
    private static final b f1866a;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        /* JADX INFO: Access modifiers changed from: private */
        public static void h(byte b5, byte b6, byte b7, byte b8, char[] cArr, int i5) {
            if (m(b6) || (((b5 << 28) + (b6 + 112)) >> 30) != 0 || m(b7) || m(b8)) {
                throw e0.d();
            }
            int r5 = ((b5 & 7) << 18) | (r(b6) << 12) | (r(b7) << 6) | r(b8);
            cArr[i5] = l(r5);
            cArr[i5 + 1] = q(r5);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void i(byte b5, char[] cArr, int i5) {
            cArr[i5] = (char) b5;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void j(byte b5, byte b6, byte b7, char[] cArr, int i5) {
            if (m(b6) || ((b5 == -32 && b6 < -96) || ((b5 == -19 && b6 >= -96) || m(b7)))) {
                throw e0.d();
            }
            cArr[i5] = (char) (((b5 & 15) << 12) | (r(b6) << 6) | r(b7));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void k(byte b5, byte b6, char[] cArr, int i5) {
            if (b5 < -62 || m(b6)) {
                throw e0.d();
            }
            cArr[i5] = (char) (((b5 & 31) << 6) | r(b6));
        }

        private static char l(int i5) {
            return (char) ((i5 >>> 10) + 55232);
        }

        private static boolean m(byte b5) {
            return b5 > -65;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static boolean n(byte b5) {
            return b5 >= 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static boolean o(byte b5) {
            return b5 < -16;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static boolean p(byte b5) {
            return b5 < -32;
        }

        private static char q(int i5) {
            return (char) ((i5 & 1023) + 56320);
        }

        private static int r(byte b5) {
            return b5 & 63;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static abstract class b {
        b() {
        }

        private static int j(ByteBuffer byteBuffer, int i5, int i6) {
            int l5 = i5 + b2.l(byteBuffer, i5, i6);
            while (l5 < i6) {
                int i7 = l5 + 1;
                byte b5 = byteBuffer.get(l5);
                if (b5 < 0) {
                    if (b5 >= -32) {
                        if (b5 < -16) {
                            if (i7 < i6 - 1) {
                                int i8 = i7 + 1;
                                byte b6 = byteBuffer.get(i7);
                                if (b6 > -65 || ((b5 == -32 && b6 < -96) || ((b5 == -19 && b6 >= -96) || byteBuffer.get(i8) > -65))) {
                                    return -1;
                                }
                                l5 = i8 + 1;
                            }
                        } else if (i7 < i6 - 2) {
                            int i9 = i7 + 1;
                            byte b7 = byteBuffer.get(i7);
                            if (b7 <= -65 && (((b5 << 28) + (b7 + 112)) >> 30) == 0) {
                                int i10 = i9 + 1;
                                if (byteBuffer.get(i9) <= -65) {
                                    i7 = i10 + 1;
                                    if (byteBuffer.get(i10) > -65) {
                                    }
                                }
                            }
                            return -1;
                        }
                        return b2.p(byteBuffer, b5, i7, i6 - i7);
                    } else if (i7 >= i6) {
                        return b5;
                    } else {
                        if (b5 < -62 || byteBuffer.get(i7) > -65) {
                            return -1;
                        }
                        i7++;
                    }
                }
                l5 = i7;
            }
            return 0;
        }

        final String a(ByteBuffer byteBuffer, int i5, int i6) {
            if (byteBuffer.hasArray()) {
                return b(byteBuffer.array(), byteBuffer.arrayOffset() + i5, i6);
            }
            return byteBuffer.isDirect() ? d(byteBuffer, i5, i6) : c(byteBuffer, i5, i6);
        }

        abstract String b(byte[] bArr, int i5, int i6);

        final String c(ByteBuffer byteBuffer, int i5, int i6) {
            if ((i5 | i6 | ((byteBuffer.limit() - i5) - i6)) >= 0) {
                int i7 = i5 + i6;
                char[] cArr = new char[i6];
                int i8 = 0;
                while (i5 < i7) {
                    byte b5 = byteBuffer.get(i5);
                    if (!a.n(b5)) {
                        break;
                    }
                    i5++;
                    a.i(b5, cArr, i8);
                    i8++;
                }
                int i9 = i8;
                while (i5 < i7) {
                    int i10 = i5 + 1;
                    byte b6 = byteBuffer.get(i5);
                    if (a.n(b6)) {
                        int i11 = i9 + 1;
                        a.i(b6, cArr, i9);
                        while (i10 < i7) {
                            byte b7 = byteBuffer.get(i10);
                            if (!a.n(b7)) {
                                break;
                            }
                            i10++;
                            a.i(b7, cArr, i11);
                            i11++;
                        }
                        i5 = i10;
                        i9 = i11;
                    } else if (a.p(b6)) {
                        if (i10 >= i7) {
                            throw e0.d();
                        }
                        a.k(b6, byteBuffer.get(i10), cArr, i9);
                        i5 = i10 + 1;
                        i9++;
                    } else if (a.o(b6)) {
                        if (i10 >= i7 - 1) {
                            throw e0.d();
                        }
                        int i12 = i10 + 1;
                        a.j(b6, byteBuffer.get(i10), byteBuffer.get(i12), cArr, i9);
                        i5 = i12 + 1;
                        i9++;
                    } else if (i10 >= i7 - 2) {
                        throw e0.d();
                    } else {
                        int i13 = i10 + 1;
                        byte b8 = byteBuffer.get(i10);
                        int i14 = i13 + 1;
                        a.h(b6, b8, byteBuffer.get(i13), byteBuffer.get(i14), cArr, i9);
                        i5 = i14 + 1;
                        i9 = i9 + 1 + 1;
                    }
                }
                return new String(cArr, 0, i9);
            }
            throw new ArrayIndexOutOfBoundsException(String.format("buffer limit=%d, index=%d, limit=%d", Integer.valueOf(byteBuffer.limit()), Integer.valueOf(i5), Integer.valueOf(i6)));
        }

        abstract String d(ByteBuffer byteBuffer, int i5, int i6);

        abstract int e(CharSequence charSequence, byte[] bArr, int i5, int i6);

        final boolean f(ByteBuffer byteBuffer, int i5, int i6) {
            return h(0, byteBuffer, i5, i6) == 0;
        }

        final boolean g(byte[] bArr, int i5, int i6) {
            return i(0, bArr, i5, i6) == 0;
        }

        final int h(int i5, ByteBuffer byteBuffer, int i6, int i7) {
            if (!byteBuffer.hasArray()) {
                return byteBuffer.isDirect() ? l(i5, byteBuffer, i6, i7) : k(i5, byteBuffer, i6, i7);
            }
            int arrayOffset = byteBuffer.arrayOffset();
            return i(i5, byteBuffer.array(), i6 + arrayOffset, arrayOffset + i7);
        }

        abstract int i(int i5, byte[] bArr, int i6, int i7);

        /* JADX WARN: Code restructure failed: missing block: B:10:0x0017, code lost:
            if (r8.get(r9) > (-65)) goto L12;
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x004c, code lost:
            if (r8.get(r9) > (-65)) goto L31;
         */
        /* JADX WARN: Code restructure failed: missing block: B:52:0x008b, code lost:
            if (r8.get(r9) > (-65)) goto L51;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        final int k(int r7, java.nio.ByteBuffer r8, int r9, int r10) {
            /*
                r6 = this;
                if (r7 == 0) goto L8e
                if (r9 < r10) goto L5
                return r7
            L5:
                byte r0 = (byte) r7
                r1 = -32
                r2 = -1
                r3 = -65
                if (r0 >= r1) goto L1e
                r7 = -62
                if (r0 < r7) goto L1d
                int r7 = r9 + 1
                byte r9 = r8.get(r9)
                if (r9 <= r3) goto L1a
                goto L1d
            L1a:
                r9 = r7
                goto L8e
            L1d:
                return r2
            L1e:
                r4 = -16
                if (r0 >= r4) goto L4f
                int r7 = r7 >> 8
                int r7 = ~r7
                byte r7 = (byte) r7
                if (r7 != 0) goto L38
                int r7 = r9 + 1
                byte r9 = r8.get(r9)
                if (r7 < r10) goto L35
                int r7 = com.google.protobuf.b2.a(r0, r9)
                return r7
            L35:
                r5 = r9
                r9 = r7
                r7 = r5
            L38:
                if (r7 > r3) goto L4e
                r4 = -96
                if (r0 != r1) goto L40
                if (r7 < r4) goto L4e
            L40:
                r1 = -19
                if (r0 != r1) goto L46
                if (r7 >= r4) goto L4e
            L46:
                int r7 = r9 + 1
                byte r9 = r8.get(r9)
                if (r9 <= r3) goto L1a
            L4e:
                return r2
            L4f:
                int r1 = r7 >> 8
                int r1 = ~r1
                byte r1 = (byte) r1
                r4 = 0
                if (r1 != 0) goto L65
                int r7 = r9 + 1
                byte r1 = r8.get(r9)
                if (r7 < r10) goto L63
                int r7 = com.google.protobuf.b2.a(r0, r1)
                return r7
            L63:
                r9 = r7
                goto L68
            L65:
                int r7 = r7 >> 16
                byte r4 = (byte) r7
            L68:
                if (r4 != 0) goto L78
                int r7 = r9 + 1
                byte r4 = r8.get(r9)
                if (r7 < r10) goto L77
                int r7 = com.google.protobuf.b2.b(r0, r1, r4)
                return r7
            L77:
                r9 = r7
            L78:
                if (r1 > r3) goto L8d
                int r7 = r0 << 28
                int r1 = r1 + 112
                int r7 = r7 + r1
                int r7 = r7 >> 30
                if (r7 != 0) goto L8d
                if (r4 > r3) goto L8d
                int r7 = r9 + 1
                byte r9 = r8.get(r9)
                if (r9 <= r3) goto L1a
            L8d:
                return r2
            L8e:
                int r7 = j(r8, r9, r10)
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.b2.b.k(int, java.nio.ByteBuffer, int, int):int");
        }

        abstract int l(int i5, ByteBuffer byteBuffer, int i6, int i7);
    }

    /* loaded from: classes.dex */
    static final class c extends b {
        c() {
        }

        private static int m(byte[] bArr, int i5, int i6) {
            while (i5 < i6 && bArr[i5] >= 0) {
                i5++;
            }
            if (i5 >= i6) {
                return 0;
            }
            return n(bArr, i5, i6);
        }

        private static int n(byte[] bArr, int i5, int i6) {
            while (i5 < i6) {
                int i7 = i5 + 1;
                byte b5 = bArr[i5];
                if (b5 < 0) {
                    if (b5 < -32) {
                        if (i7 >= i6) {
                            return b5;
                        }
                        if (b5 >= -62) {
                            i5 = i7 + 1;
                            if (bArr[i7] > -65) {
                            }
                        }
                        return -1;
                    } else if (b5 >= -16) {
                        if (i7 >= i6 - 2) {
                            return b2.q(bArr, i7, i6);
                        }
                        int i8 = i7 + 1;
                        byte b6 = bArr[i7];
                        if (b6 <= -65 && (((b5 << 28) + (b6 + 112)) >> 30) == 0) {
                            int i9 = i8 + 1;
                            if (bArr[i8] <= -65) {
                                i7 = i9 + 1;
                                if (bArr[i9] > -65) {
                                }
                            }
                        }
                        return -1;
                    } else if (i7 >= i6 - 1) {
                        return b2.q(bArr, i7, i6);
                    } else {
                        int i10 = i7 + 1;
                        byte b7 = bArr[i7];
                        if (b7 <= -65 && ((b5 != -32 || b7 >= -96) && (b5 != -19 || b7 < -96))) {
                            i5 = i10 + 1;
                            if (bArr[i10] > -65) {
                            }
                        }
                        return -1;
                    }
                }
                i5 = i7;
            }
            return 0;
        }

        @Override // com.google.protobuf.b2.b
        String b(byte[] bArr, int i5, int i6) {
            if ((i5 | i6 | ((bArr.length - i5) - i6)) >= 0) {
                int i7 = i5 + i6;
                char[] cArr = new char[i6];
                int i8 = 0;
                while (i5 < i7) {
                    byte b5 = bArr[i5];
                    if (!a.n(b5)) {
                        break;
                    }
                    i5++;
                    a.i(b5, cArr, i8);
                    i8++;
                }
                int i9 = i8;
                while (i5 < i7) {
                    int i10 = i5 + 1;
                    byte b6 = bArr[i5];
                    if (a.n(b6)) {
                        int i11 = i9 + 1;
                        a.i(b6, cArr, i9);
                        while (i10 < i7) {
                            byte b7 = bArr[i10];
                            if (!a.n(b7)) {
                                break;
                            }
                            i10++;
                            a.i(b7, cArr, i11);
                            i11++;
                        }
                        i5 = i10;
                        i9 = i11;
                    } else if (a.p(b6)) {
                        if (i10 >= i7) {
                            throw e0.d();
                        }
                        a.k(b6, bArr[i10], cArr, i9);
                        i5 = i10 + 1;
                        i9++;
                    } else if (a.o(b6)) {
                        if (i10 >= i7 - 1) {
                            throw e0.d();
                        }
                        int i12 = i10 + 1;
                        a.j(b6, bArr[i10], bArr[i12], cArr, i9);
                        i5 = i12 + 1;
                        i9++;
                    } else if (i10 >= i7 - 2) {
                        throw e0.d();
                    } else {
                        int i13 = i10 + 1;
                        byte b8 = bArr[i10];
                        int i14 = i13 + 1;
                        a.h(b6, b8, bArr[i13], bArr[i14], cArr, i9);
                        i5 = i14 + 1;
                        i9 = i9 + 1 + 1;
                    }
                }
                return new String(cArr, 0, i9);
            }
            throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", Integer.valueOf(bArr.length), Integer.valueOf(i5), Integer.valueOf(i6)));
        }

        @Override // com.google.protobuf.b2.b
        String d(ByteBuffer byteBuffer, int i5, int i6) {
            return c(byteBuffer, i5, i6);
        }

        /* JADX WARN: Code restructure failed: missing block: B:12:0x001d, code lost:
            return r10 + r0;
         */
        @Override // com.google.protobuf.b2.b
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        int e(java.lang.CharSequence r8, byte[] r9, int r10, int r11) {
            /*
                Method dump skipped, instructions count: 254
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.b2.c.e(java.lang.CharSequence, byte[], int, int):int");
        }

        /* JADX WARN: Code restructure failed: missing block: B:10:0x0015, code lost:
            if (r8[r9] > (-65)) goto L12;
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x0046, code lost:
            if (r8[r9] > (-65)) goto L31;
         */
        /* JADX WARN: Code restructure failed: missing block: B:52:0x007f, code lost:
            if (r8[r9] > (-65)) goto L51;
         */
        @Override // com.google.protobuf.b2.b
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        int i(int r7, byte[] r8, int r9, int r10) {
            /*
                r6 = this;
                if (r7 == 0) goto L82
                if (r9 < r10) goto L5
                return r7
            L5:
                byte r0 = (byte) r7
                r1 = -32
                r2 = -1
                r3 = -65
                if (r0 >= r1) goto L1c
                r7 = -62
                if (r0 < r7) goto L1b
                int r7 = r9 + 1
                r9 = r8[r9]
                if (r9 <= r3) goto L18
                goto L1b
            L18:
                r9 = r7
                goto L82
            L1b:
                return r2
            L1c:
                r4 = -16
                if (r0 >= r4) goto L49
                int r7 = r7 >> 8
                int r7 = ~r7
                byte r7 = (byte) r7
                if (r7 != 0) goto L34
                int r7 = r9 + 1
                r9 = r8[r9]
                if (r7 < r10) goto L31
                int r7 = com.google.protobuf.b2.a(r0, r9)
                return r7
            L31:
                r5 = r9
                r9 = r7
                r7 = r5
            L34:
                if (r7 > r3) goto L48
                r4 = -96
                if (r0 != r1) goto L3c
                if (r7 < r4) goto L48
            L3c:
                r1 = -19
                if (r0 != r1) goto L42
                if (r7 >= r4) goto L48
            L42:
                int r7 = r9 + 1
                r9 = r8[r9]
                if (r9 <= r3) goto L18
            L48:
                return r2
            L49:
                int r1 = r7 >> 8
                int r1 = ~r1
                byte r1 = (byte) r1
                r4 = 0
                if (r1 != 0) goto L5d
                int r7 = r9 + 1
                r1 = r8[r9]
                if (r7 < r10) goto L5b
                int r7 = com.google.protobuf.b2.a(r0, r1)
                return r7
            L5b:
                r9 = r7
                goto L60
            L5d:
                int r7 = r7 >> 16
                byte r4 = (byte) r7
            L60:
                if (r4 != 0) goto L6e
                int r7 = r9 + 1
                r4 = r8[r9]
                if (r7 < r10) goto L6d
                int r7 = com.google.protobuf.b2.b(r0, r1, r4)
                return r7
            L6d:
                r9 = r7
            L6e:
                if (r1 > r3) goto L81
                int r7 = r0 << 28
                int r1 = r1 + 112
                int r7 = r7 + r1
                int r7 = r7 >> 30
                if (r7 != 0) goto L81
                if (r4 > r3) goto L81
                int r7 = r9 + 1
                r9 = r8[r9]
                if (r9 <= r3) goto L18
            L81:
                return r2
            L82:
                int r7 = m(r8, r9, r10)
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.b2.c.i(int, byte[], int, int):int");
        }

        @Override // com.google.protobuf.b2.b
        int l(int i5, ByteBuffer byteBuffer, int i6, int i7) {
            return k(i5, byteBuffer, i6, i7);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class d extends IllegalArgumentException {
        d(int i5, int i6) {
            super("Unpaired surrogate at index " + i5 + " of " + i6);
        }
    }

    /* loaded from: classes.dex */
    static final class e extends b {
        e() {
        }

        static boolean m() {
            return a2.I() && a2.J();
        }

        /* JADX WARN: Code restructure failed: missing block: B:22:0x0039, code lost:
            return -1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:52:0x008e, code lost:
            return -1;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private static int n(long r8, int r10) {
            /*
                int r0 = p(r8, r10)
                long r1 = (long) r0
                long r8 = r8 + r1
                int r10 = r10 - r0
            L7:
                r0 = 0
                r1 = 0
            L9:
                r2 = 1
                if (r10 <= 0) goto L1a
                long r4 = r8 + r2
                byte r1 = com.google.protobuf.a2.w(r8)
                if (r1 < 0) goto L19
                int r10 = r10 + (-1)
                r8 = r4
                goto L9
            L19:
                r8 = r4
            L1a:
                if (r10 != 0) goto L1d
                return r0
            L1d:
                int r10 = r10 + (-1)
                r0 = -32
                r4 = -65
                r5 = -1
                if (r1 >= r0) goto L3a
                if (r10 != 0) goto L29
                return r1
            L29:
                int r10 = r10 + (-1)
                r0 = -62
                if (r1 < r0) goto L39
                long r2 = r2 + r8
                byte r8 = com.google.protobuf.a2.w(r8)
                if (r8 <= r4) goto L37
                goto L39
            L37:
                r8 = r2
                goto L7
            L39:
                return r5
            L3a:
                r6 = -16
                if (r1 >= r6) goto L64
                r6 = 2
                if (r10 >= r6) goto L46
                int r8 = r(r8, r1, r10)
                return r8
            L46:
                int r10 = r10 + (-2)
                long r6 = r8 + r2
                byte r8 = com.google.protobuf.a2.w(r8)
                if (r8 > r4) goto L63
                r9 = -96
                if (r1 != r0) goto L56
                if (r8 < r9) goto L63
            L56:
                r0 = -19
                if (r1 != r0) goto L5c
                if (r8 >= r9) goto L63
            L5c:
                long r2 = r2 + r6
                byte r8 = com.google.protobuf.a2.w(r6)
                if (r8 <= r4) goto L37
            L63:
                return r5
            L64:
                r0 = 3
                if (r10 >= r0) goto L6c
                int r8 = r(r8, r1, r10)
                return r8
            L6c:
                int r10 = r10 + (-3)
                long r6 = r8 + r2
                byte r8 = com.google.protobuf.a2.w(r8)
                if (r8 > r4) goto L8e
                int r9 = r1 << 28
                int r8 = r8 + 112
                int r9 = r9 + r8
                int r8 = r9 >> 30
                if (r8 != 0) goto L8e
                long r8 = r6 + r2
                byte r0 = com.google.protobuf.a2.w(r6)
                if (r0 > r4) goto L8e
                long r2 = r2 + r8
                byte r8 = com.google.protobuf.a2.w(r8)
                if (r8 <= r4) goto L37
            L8e:
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.b2.e.n(long, int):int");
        }

        /* JADX WARN: Code restructure failed: missing block: B:22:0x0039, code lost:
            return -1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:52:0x008e, code lost:
            return -1;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private static int o(byte[] r8, long r9, int r11) {
            /*
                int r0 = q(r8, r9, r11)
                int r11 = r11 - r0
                long r0 = (long) r0
                long r9 = r9 + r0
            L7:
                r0 = 0
                r1 = 0
            L9:
                r2 = 1
                if (r11 <= 0) goto L1a
                long r4 = r9 + r2
                byte r1 = com.google.protobuf.a2.x(r8, r9)
                if (r1 < 0) goto L19
                int r11 = r11 + (-1)
                r9 = r4
                goto L9
            L19:
                r9 = r4
            L1a:
                if (r11 != 0) goto L1d
                return r0
            L1d:
                int r11 = r11 + (-1)
                r0 = -32
                r4 = -65
                r5 = -1
                if (r1 >= r0) goto L3a
                if (r11 != 0) goto L29
                return r1
            L29:
                int r11 = r11 + (-1)
                r0 = -62
                if (r1 < r0) goto L39
                long r2 = r2 + r9
                byte r9 = com.google.protobuf.a2.x(r8, r9)
                if (r9 <= r4) goto L37
                goto L39
            L37:
                r9 = r2
                goto L7
            L39:
                return r5
            L3a:
                r6 = -16
                if (r1 >= r6) goto L64
                r6 = 2
                if (r11 >= r6) goto L46
                int r8 = s(r8, r1, r9, r11)
                return r8
            L46:
                int r11 = r11 + (-2)
                long r6 = r9 + r2
                byte r9 = com.google.protobuf.a2.x(r8, r9)
                if (r9 > r4) goto L63
                r10 = -96
                if (r1 != r0) goto L56
                if (r9 < r10) goto L63
            L56:
                r0 = -19
                if (r1 != r0) goto L5c
                if (r9 >= r10) goto L63
            L5c:
                long r2 = r2 + r6
                byte r9 = com.google.protobuf.a2.x(r8, r6)
                if (r9 <= r4) goto L37
            L63:
                return r5
            L64:
                r0 = 3
                if (r11 >= r0) goto L6c
                int r8 = s(r8, r1, r9, r11)
                return r8
            L6c:
                int r11 = r11 + (-3)
                long r6 = r9 + r2
                byte r9 = com.google.protobuf.a2.x(r8, r9)
                if (r9 > r4) goto L8e
                int r10 = r1 << 28
                int r9 = r9 + 112
                int r10 = r10 + r9
                int r9 = r10 >> 30
                if (r9 != 0) goto L8e
                long r9 = r6 + r2
                byte r0 = com.google.protobuf.a2.x(r8, r6)
                if (r0 > r4) goto L8e
                long r2 = r2 + r9
                byte r9 = com.google.protobuf.a2.x(r8, r9)
                if (r9 <= r4) goto L37
            L8e:
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.b2.e.o(byte[], long, int):int");
        }

        private static int p(long j5, int i5) {
            if (i5 < 16) {
                return 0;
            }
            int i6 = (int) ((-j5) & 7);
            int i7 = i6;
            while (i7 > 0) {
                long j6 = 1 + j5;
                if (a2.w(j5) < 0) {
                    return i6 - i7;
                }
                i7--;
                j5 = j6;
            }
            int i8 = i5 - i6;
            while (i8 >= 8 && (a2.D(j5) & (-9187201950435737472L)) == 0) {
                j5 += 8;
                i8 -= 8;
            }
            return i5 - i8;
        }

        private static int q(byte[] bArr, long j5, int i5) {
            int i6 = 0;
            if (i5 < 16) {
                return 0;
            }
            int i7 = 8 - (((int) j5) & 7);
            while (i6 < i7) {
                long j6 = 1 + j5;
                if (a2.x(bArr, j5) < 0) {
                    return i6;
                }
                i6++;
                j5 = j6;
            }
            while (true) {
                int i8 = i6 + 8;
                if (i8 > i5 || (a2.E(bArr, a2.f1847h + j5) & (-9187201950435737472L)) != 0) {
                    break;
                }
                j5 += 8;
                i6 = i8;
            }
            while (i6 < i5) {
                long j7 = j5 + 1;
                if (a2.x(bArr, j5) < 0) {
                    return i6;
                }
                i6++;
                j5 = j7;
            }
            return i5;
        }

        private static int r(long j5, int i5, int i6) {
            if (i6 != 0) {
                if (i6 != 1) {
                    if (i6 == 2) {
                        return b2.o(i5, a2.w(j5), a2.w(j5 + 1));
                    }
                    throw new AssertionError();
                }
                return b2.n(i5, a2.w(j5));
            }
            return b2.m(i5);
        }

        private static int s(byte[] bArr, int i5, long j5, int i6) {
            if (i6 != 0) {
                if (i6 != 1) {
                    if (i6 == 2) {
                        return b2.o(i5, a2.x(bArr, j5), a2.x(bArr, j5 + 1));
                    }
                    throw new AssertionError();
                }
                return b2.n(i5, a2.x(bArr, j5));
            }
            return b2.m(i5);
        }

        @Override // com.google.protobuf.b2.b
        String b(byte[] bArr, int i5, int i6) {
            Charset charset = d0.f1911b;
            String str = new String(bArr, i5, i6, charset);
            if (str.contains("�") && !Arrays.equals(str.getBytes(charset), Arrays.copyOfRange(bArr, i5, i6 + i5))) {
                throw e0.d();
            }
            return str;
        }

        @Override // com.google.protobuf.b2.b
        String d(ByteBuffer byteBuffer, int i5, int i6) {
            if ((i5 | i6 | ((byteBuffer.limit() - i5) - i6)) >= 0) {
                long k5 = a2.k(byteBuffer) + i5;
                long j5 = i6 + k5;
                char[] cArr = new char[i6];
                int i7 = 0;
                while (k5 < j5) {
                    byte w5 = a2.w(k5);
                    if (!a.n(w5)) {
                        break;
                    }
                    k5++;
                    a.i(w5, cArr, i7);
                    i7++;
                }
                while (true) {
                    int i8 = i7;
                    while (k5 < j5) {
                        long j6 = k5 + 1;
                        byte w6 = a2.w(k5);
                        if (a.n(w6)) {
                            int i9 = i8 + 1;
                            a.i(w6, cArr, i8);
                            while (j6 < j5) {
                                byte w7 = a2.w(j6);
                                if (!a.n(w7)) {
                                    break;
                                }
                                j6++;
                                a.i(w7, cArr, i9);
                                i9++;
                            }
                            i8 = i9;
                            k5 = j6;
                        } else if (a.p(w6)) {
                            if (j6 >= j5) {
                                throw e0.d();
                            }
                            k5 = j6 + 1;
                            a.k(w6, a2.w(j6), cArr, i8);
                            i8++;
                        } else if (a.o(w6)) {
                            if (j6 >= j5 - 1) {
                                throw e0.d();
                            }
                            long j7 = j6 + 1;
                            a.j(w6, a2.w(j6), a2.w(j7), cArr, i8);
                            i8++;
                            k5 = j7 + 1;
                        } else if (j6 >= j5 - 2) {
                            throw e0.d();
                        } else {
                            long j8 = j6 + 1;
                            byte w8 = a2.w(j6);
                            long j9 = j8 + 1;
                            byte w9 = a2.w(j8);
                            k5 = j9 + 1;
                            a.h(w6, w8, w9, a2.w(j9), cArr, i8);
                            i7 = i8 + 1 + 1;
                        }
                    }
                    return new String(cArr, 0, i8);
                }
            }
            throw new ArrayIndexOutOfBoundsException(String.format("buffer limit=%d, index=%d, limit=%d", Integer.valueOf(byteBuffer.limit()), Integer.valueOf(i5), Integer.valueOf(i6)));
        }

        @Override // com.google.protobuf.b2.b
        int e(CharSequence charSequence, byte[] bArr, int i5, int i6) {
            char c5;
            long j5;
            long j6;
            long j7;
            int i7;
            char charAt;
            long j8 = i5;
            long j9 = i6 + j8;
            int length = charSequence.length();
            if (length > i6 || bArr.length - i6 < i5) {
                throw new ArrayIndexOutOfBoundsException("Failed writing " + charSequence.charAt(length - 1) + " at index " + (i5 + i6));
            }
            int i8 = 0;
            while (true) {
                c5 = 128;
                j5 = 1;
                if (i8 >= length || (charAt = charSequence.charAt(i8)) >= 128) {
                    break;
                }
                a2.O(bArr, j8, (byte) charAt);
                i8++;
                j8 = 1 + j8;
            }
            if (i8 == length) {
                return (int) j8;
            }
            while (i8 < length) {
                char charAt2 = charSequence.charAt(i8);
                if (charAt2 >= c5 || j8 >= j9) {
                    if (charAt2 < 2048 && j8 <= j9 - 2) {
                        long j10 = j8 + j5;
                        a2.O(bArr, j8, (byte) ((charAt2 >>> 6) | 960));
                        a2.O(bArr, j10, (byte) ((charAt2 & '?') | 128));
                        j6 = j10 + j5;
                        j7 = j5;
                    } else if ((charAt2 >= 55296 && 57343 >= charAt2) || j8 > j9 - 3) {
                        if (j8 > j9 - 4) {
                            if (55296 > charAt2 || charAt2 > 57343 || ((i7 = i8 + 1) != length && Character.isSurrogatePair(charAt2, charSequence.charAt(i7)))) {
                                throw new ArrayIndexOutOfBoundsException("Failed writing " + charAt2 + " at index " + j8);
                            }
                            throw new d(i8, length);
                        }
                        int i9 = i8 + 1;
                        if (i9 != length) {
                            char charAt3 = charSequence.charAt(i9);
                            if (Character.isSurrogatePair(charAt2, charAt3)) {
                                int codePoint = Character.toCodePoint(charAt2, charAt3);
                                long j11 = j8 + 1;
                                a2.O(bArr, j8, (byte) ((codePoint >>> 18) | 240));
                                long j12 = j11 + 1;
                                a2.O(bArr, j11, (byte) (((codePoint >>> 12) & 63) | 128));
                                long j13 = j12 + 1;
                                a2.O(bArr, j12, (byte) (((codePoint >>> 6) & 63) | 128));
                                j7 = 1;
                                j6 = j13 + 1;
                                a2.O(bArr, j13, (byte) ((codePoint & 63) | 128));
                                i8 = i9;
                            } else {
                                i8 = i9;
                            }
                        }
                        throw new d(i8 - 1, length);
                    } else {
                        long j14 = j8 + j5;
                        a2.O(bArr, j8, (byte) ((charAt2 >>> '\f') | 480));
                        long j15 = j14 + j5;
                        a2.O(bArr, j14, (byte) (((charAt2 >>> 6) & 63) | 128));
                        a2.O(bArr, j15, (byte) ((charAt2 & '?') | 128));
                        j6 = j15 + 1;
                        j7 = 1;
                    }
                    i8++;
                    c5 = 128;
                    long j16 = j7;
                    j8 = j6;
                    j5 = j16;
                } else {
                    long j17 = j8 + j5;
                    a2.O(bArr, j8, (byte) charAt2);
                    j7 = j5;
                    j6 = j17;
                }
                i8++;
                c5 = 128;
                long j162 = j7;
                j8 = j6;
                j5 = j162;
            }
            return (int) j8;
        }

        /* JADX WARN: Code restructure failed: missing block: B:35:0x0059, code lost:
            if (com.google.protobuf.a2.x(r13, r2) > (-65)) goto L36;
         */
        /* JADX WARN: Code restructure failed: missing block: B:58:0x009e, code lost:
            if (com.google.protobuf.a2.x(r13, r2) > (-65)) goto L56;
         */
        @Override // com.google.protobuf.b2.b
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        int i(int r12, byte[] r13, int r14, int r15) {
            /*
                Method dump skipped, instructions count: 204
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.b2.e.i(int, byte[], int, int):int");
        }

        /* JADX WARN: Code restructure failed: missing block: B:35:0x0063, code lost:
            if (com.google.protobuf.a2.w(r2) > (-65)) goto L36;
         */
        /* JADX WARN: Code restructure failed: missing block: B:58:0x00a8, code lost:
            if (com.google.protobuf.a2.w(r2) > (-65)) goto L56;
         */
        @Override // com.google.protobuf.b2.b
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        int l(int r11, java.nio.ByteBuffer r12, int r13, int r14) {
            /*
                Method dump skipped, instructions count: 217
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.protobuf.b2.e.l(int, java.nio.ByteBuffer, int, int):int");
        }
    }

    static {
        f1866a = (!e.m() || com.google.protobuf.d.c()) ? new c() : new e();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String g(ByteBuffer byteBuffer, int i5, int i6) {
        return f1866a.a(byteBuffer, i5, i6);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String h(byte[] bArr, int i5, int i6) {
        return f1866a.b(bArr, i5, i6);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int i(CharSequence charSequence, byte[] bArr, int i5, int i6) {
        return f1866a.e(charSequence, bArr, i5, i6);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int j(CharSequence charSequence) {
        int length = charSequence.length();
        int i5 = 0;
        while (i5 < length && charSequence.charAt(i5) < 128) {
            i5++;
        }
        int i6 = length;
        while (true) {
            if (i5 < length) {
                char charAt = charSequence.charAt(i5);
                if (charAt >= 2048) {
                    i6 += k(charSequence, i5);
                    break;
                }
                i6 += (127 - charAt) >>> 31;
                i5++;
            } else {
                break;
            }
        }
        if (i6 >= length) {
            return i6;
        }
        throw new IllegalArgumentException("UTF-8 length does not fit in int: " + (i6 + 4294967296L));
    }

    private static int k(CharSequence charSequence, int i5) {
        int length = charSequence.length();
        int i6 = 0;
        while (i5 < length) {
            char charAt = charSequence.charAt(i5);
            if (charAt < 2048) {
                i6 += (127 - charAt) >>> 31;
            } else {
                i6 += 2;
                if (55296 <= charAt && charAt <= 57343) {
                    if (Character.codePointAt(charSequence, i5) < 65536) {
                        throw new d(i5, length);
                    }
                    i5++;
                }
            }
            i5++;
        }
        return i6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int l(ByteBuffer byteBuffer, int i5, int i6) {
        int i7 = i6 - 7;
        int i8 = i5;
        while (i8 < i7 && (byteBuffer.getLong(i8) & (-9187201950435737472L)) == 0) {
            i8 += 8;
        }
        return i8 - i5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int m(int i5) {
        if (i5 > -12) {
            return -1;
        }
        return i5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int n(int i5, int i6) {
        if (i5 > -12 || i6 > -65) {
            return -1;
        }
        return i5 ^ (i6 << 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int o(int i5, int i6, int i7) {
        if (i5 > -12 || i6 > -65 || i7 > -65) {
            return -1;
        }
        return (i5 ^ (i6 << 8)) ^ (i7 << 16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int p(ByteBuffer byteBuffer, int i5, int i6, int i7) {
        if (i7 != 0) {
            if (i7 != 1) {
                if (i7 == 2) {
                    return o(i5, byteBuffer.get(i6), byteBuffer.get(i6 + 1));
                }
                throw new AssertionError();
            }
            return n(i5, byteBuffer.get(i6));
        }
        return m(i5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int q(byte[] bArr, int i5, int i6) {
        byte b5 = bArr[i5 - 1];
        int i7 = i6 - i5;
        if (i7 != 0) {
            if (i7 != 1) {
                if (i7 == 2) {
                    return o(b5, bArr[i5], bArr[i5 + 1]);
                }
                throw new AssertionError();
            }
            return n(b5, bArr[i5]);
        }
        return m(b5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean r(ByteBuffer byteBuffer) {
        return f1866a.f(byteBuffer, byteBuffer.position(), byteBuffer.remaining());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean s(byte[] bArr) {
        return f1866a.g(bArr, 0, bArr.length);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean t(byte[] bArr, int i5, int i6) {
        return f1866a.g(bArr, i5, i6);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int u(int i5, ByteBuffer byteBuffer, int i6, int i7) {
        return f1866a.h(i5, byteBuffer, i6, i7);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int v(int i5, byte[] bArr, int i6, int i7) {
        return f1866a.i(i5, bArr, i6, i7);
    }
}
