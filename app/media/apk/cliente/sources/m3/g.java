package m3;

import com.google.android.gms.common.api.a;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import m3.b;
import m3.f;
import w4.n;
/* loaded from: classes.dex */
public final class g implements j {

    /* renamed from: a  reason: collision with root package name */
    private static final Logger f6143a = Logger.getLogger(b.class.getName());

    /* renamed from: b  reason: collision with root package name */
    private static final w4.f f6144b = w4.f.e("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class a implements n {

        /* renamed from: a  reason: collision with root package name */
        private final w4.e f6145a;

        /* renamed from: b  reason: collision with root package name */
        int f6146b;

        /* renamed from: c  reason: collision with root package name */
        byte f6147c;

        /* renamed from: d  reason: collision with root package name */
        int f6148d;

        /* renamed from: e  reason: collision with root package name */
        int f6149e;

        /* renamed from: f  reason: collision with root package name */
        short f6150f;

        public a(w4.e eVar) {
            this.f6145a = eVar;
        }

        private void c() {
            int i5 = this.f6148d;
            int m5 = g.m(this.f6145a);
            this.f6149e = m5;
            this.f6146b = m5;
            byte readByte = (byte) (this.f6145a.readByte() & 255);
            this.f6147c = (byte) (this.f6145a.readByte() & 255);
            if (g.f6143a.isLoggable(Level.FINE)) {
                g.f6143a.fine(b.b(true, this.f6148d, this.f6146b, readByte, this.f6147c));
            }
            int readInt = this.f6145a.readInt() & a.e.API_PRIORITY_OTHER;
            this.f6148d = readInt;
            if (readByte != 9) {
                throw g.k("%s != TYPE_CONTINUATION", Byte.valueOf(readByte));
            }
            if (readInt != i5) {
                throw g.k("TYPE_CONTINUATION streamId changed", new Object[0]);
            }
        }

        @Override // w4.n, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // w4.n
        public long s(w4.c cVar, long j5) {
            while (true) {
                int i5 = this.f6149e;
                if (i5 != 0) {
                    long s5 = this.f6145a.s(cVar, Math.min(j5, i5));
                    if (s5 == -1) {
                        return -1L;
                    }
                    this.f6149e -= (int) s5;
                    return s5;
                }
                this.f6145a.skip(this.f6150f);
                this.f6150f = (short) 0;
                if ((this.f6147c & 4) != 0) {
                    return -1L;
                }
                c();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private static final String[] f6151a = {"DATA", "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION"};

        /* renamed from: b  reason: collision with root package name */
        private static final String[] f6152b = new String[64];

        /* renamed from: c  reason: collision with root package name */
        private static final String[] f6153c = new String[256];

        static {
            String[] strArr;
            int i5 = 0;
            int i6 = 0;
            while (true) {
                String[] strArr2 = f6153c;
                if (i6 >= strArr2.length) {
                    break;
                }
                strArr2[i6] = String.format("%8s", Integer.toBinaryString(i6)).replace(' ', '0');
                i6++;
            }
            String[] strArr3 = f6152b;
            strArr3[0] = "";
            strArr3[1] = "END_STREAM";
            int[] iArr = {1};
            strArr3[8] = "PADDED";
            for (int i7 = 0; i7 < 1; i7++) {
                int i8 = iArr[i7];
                f6152b[i8 | 8] = strArr[i8] + "|PADDED";
            }
            String[] strArr4 = f6152b;
            strArr4[4] = "END_HEADERS";
            strArr4[32] = "PRIORITY";
            strArr4[36] = "END_HEADERS|PRIORITY";
            int[] iArr2 = {4, 32, 36};
            for (int i9 = 0; i9 < 3; i9++) {
                int i10 = iArr2[i9];
                for (int i11 = 0; i11 < 1; i11++) {
                    int i12 = iArr[i11];
                    String[] strArr5 = f6152b;
                    int i13 = i12 | i10;
                    strArr5[i13] = strArr5[i12] + '|' + strArr5[i10];
                    strArr5[i13 | 8] = strArr5[i12] + '|' + strArr5[i10] + "|PADDED";
                }
            }
            while (true) {
                String[] strArr6 = f6152b;
                if (i5 >= strArr6.length) {
                    return;
                }
                if (strArr6[i5] == null) {
                    strArr6[i5] = f6153c[i5];
                }
                i5++;
            }
        }

        b() {
        }

        static String a(byte b5, byte b6) {
            if (b6 == 0) {
                return "";
            }
            if (b5 != 2 && b5 != 3) {
                if (b5 == 4 || b5 == 6) {
                    return b6 == 1 ? "ACK" : f6153c[b6];
                } else if (b5 != 7 && b5 != 8) {
                    String[] strArr = f6152b;
                    String str = b6 < strArr.length ? strArr[b6] : f6153c[b6];
                    return (b5 != 5 || (b6 & 4) == 0) ? (b5 != 0 || (b6 & 32) == 0) ? str : str.replace("PRIORITY", "COMPRESSED") : str.replace("HEADERS", "PUSH_PROMISE");
                }
            }
            return f6153c[b6];
        }

        static String b(boolean z4, int i5, int i6, byte b5, byte b6) {
            String[] strArr = f6151a;
            String format = b5 < strArr.length ? strArr[b5] : String.format("0x%02x", Byte.valueOf(b5));
            String a5 = a(b5, b6);
            Locale locale = Locale.US;
            Object[] objArr = new Object[5];
            objArr[0] = z4 ? "<<" : ">>";
            objArr[1] = Integer.valueOf(i5);
            objArr[2] = Integer.valueOf(i6);
            objArr[3] = format;
            objArr[4] = a5;
            return String.format(locale, "%s 0x%08x %5d %-13s %s", objArr);
        }
    }

    /* loaded from: classes.dex */
    static final class c implements m3.b {

        /* renamed from: a  reason: collision with root package name */
        private final w4.e f6154a;

        /* renamed from: b  reason: collision with root package name */
        private final a f6155b;

        /* renamed from: c  reason: collision with root package name */
        private final boolean f6156c;

        /* renamed from: d  reason: collision with root package name */
        final f.a f6157d;

        c(w4.e eVar, int i5, boolean z4) {
            this.f6154a = eVar;
            this.f6156c = z4;
            a aVar = new a(eVar);
            this.f6155b = aVar;
            this.f6157d = new f.a(i5, aVar);
        }

        private void c(b.a aVar, int i5, byte b5, int i6) {
            boolean z4 = (b5 & 1) != 0;
            if ((b5 & 32) != 0) {
                throw g.k("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA", new Object[0]);
            }
            short readByte = (b5 & 8) != 0 ? (short) (this.f6154a.readByte() & 255) : (short) 0;
            aVar.k(z4, i6, this.f6154a, g.l(i5, b5, readByte));
            this.f6154a.skip(readByte);
        }

        private void d(b.a aVar, int i5, byte b5, int i6) {
            if (i5 < 8) {
                throw g.k("TYPE_GOAWAY length < 8: %s", Integer.valueOf(i5));
            }
            if (i6 != 0) {
                throw g.k("TYPE_GOAWAY streamId != 0", new Object[0]);
            }
            int readInt = this.f6154a.readInt();
            int readInt2 = this.f6154a.readInt();
            int i7 = i5 - 8;
            m3.a a5 = m3.a.a(readInt2);
            if (a5 == null) {
                throw g.k("TYPE_GOAWAY unexpected error code: %d", Integer.valueOf(readInt2));
            }
            w4.f fVar = w4.f.f8285e;
            if (i7 > 0) {
                fVar = this.f6154a.k(i7);
            }
            aVar.m(readInt, a5, fVar);
        }

        private List<m3.d> g(int i5, short s5, byte b5, int i6) {
            a aVar = this.f6155b;
            aVar.f6149e = i5;
            aVar.f6146b = i5;
            aVar.f6150f = s5;
            aVar.f6147c = b5;
            aVar.f6148d = i6;
            this.f6157d.l();
            return this.f6157d.e();
        }

        private void h(b.a aVar, int i5, byte b5, int i6) {
            if (i6 == 0) {
                throw g.k("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0", new Object[0]);
            }
            boolean z4 = (b5 & 1) != 0;
            short readByte = (b5 & 8) != 0 ? (short) (this.f6154a.readByte() & 255) : (short) 0;
            if ((b5 & 32) != 0) {
                j(aVar, i6);
                i5 -= 5;
            }
            aVar.l(false, z4, i6, -1, g(g.l(i5, b5, readByte), readByte, b5, i6), e.HTTP_20_HEADERS);
        }

        private void i(b.a aVar, int i5, byte b5, int i6) {
            if (i5 != 8) {
                throw g.k("TYPE_PING length != 8: %s", Integer.valueOf(i5));
            }
            if (i6 != 0) {
                throw g.k("TYPE_PING streamId != 0", new Object[0]);
            }
            aVar.e((b5 & 1) != 0, this.f6154a.readInt(), this.f6154a.readInt());
        }

        private void j(b.a aVar, int i5) {
            int readInt = this.f6154a.readInt();
            aVar.h(i5, readInt & a.e.API_PRIORITY_OTHER, (this.f6154a.readByte() & 255) + 1, (Integer.MIN_VALUE & readInt) != 0);
        }

        private void l(b.a aVar, int i5, byte b5, int i6) {
            if (i5 != 5) {
                throw g.k("TYPE_PRIORITY length: %d != 5", Integer.valueOf(i5));
            }
            if (i6 == 0) {
                throw g.k("TYPE_PRIORITY streamId == 0", new Object[0]);
            }
            j(aVar, i6);
        }

        private void n(b.a aVar, int i5, byte b5, int i6) {
            if (i6 == 0) {
                throw g.k("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0", new Object[0]);
            }
            short readByte = (b5 & 8) != 0 ? (short) (this.f6154a.readByte() & 255) : (short) 0;
            aVar.j(i6, this.f6154a.readInt() & a.e.API_PRIORITY_OTHER, g(g.l(i5 - 4, b5, readByte), readByte, b5, i6));
        }

        private void p(b.a aVar, int i5, byte b5, int i6) {
            if (i5 != 4) {
                throw g.k("TYPE_RST_STREAM length: %d != 4", Integer.valueOf(i5));
            }
            if (i6 == 0) {
                throw g.k("TYPE_RST_STREAM streamId == 0", new Object[0]);
            }
            int readInt = this.f6154a.readInt();
            m3.a a5 = m3.a.a(readInt);
            if (a5 == null) {
                throw g.k("TYPE_RST_STREAM unexpected error code: %d", Integer.valueOf(readInt));
            }
            aVar.a(i6, a5);
        }

        private void r(b.a aVar, int i5, byte b5, int i6) {
            if (i6 != 0) {
                throw g.k("TYPE_SETTINGS streamId != 0", new Object[0]);
            }
            if ((b5 & 1) != 0) {
                if (i5 != 0) {
                    throw g.k("FRAME_SIZE_ERROR ack frame should be empty!", new Object[0]);
                }
                aVar.g();
            } else if (i5 % 6 != 0) {
                throw g.k("TYPE_SETTINGS length %% 6 != 0: %s", Integer.valueOf(i5));
            } else {
                i iVar = new i();
                for (int i7 = 0; i7 < i5; i7 += 6) {
                    short readShort = this.f6154a.readShort();
                    int readInt = this.f6154a.readInt();
                    switch (readShort) {
                        case 1:
                        case 6:
                            break;
                        case 2:
                            if (readInt != 0 && readInt != 1) {
                                throw g.k("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1", new Object[0]);
                            }
                            break;
                        case 3:
                            readShort = 4;
                            break;
                        case 4:
                            readShort = 7;
                            if (readInt < 0) {
                                throw g.k("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1", new Object[0]);
                            }
                            break;
                        case 5:
                            if (readInt < 16384 || readInt > 16777215) {
                                throw g.k("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: %s", Integer.valueOf(readInt));
                            }
                            break;
                        default:
                    }
                    iVar.e(readShort, 0, readInt);
                }
                aVar.i(false, iVar);
                if (iVar.b() >= 0) {
                    this.f6157d.g(iVar.b());
                }
            }
        }

        private void u(b.a aVar, int i5, byte b5, int i6) {
            if (i5 != 4) {
                throw g.k("TYPE_WINDOW_UPDATE length !=4: %s", Integer.valueOf(i5));
            }
            long readInt = this.f6154a.readInt() & 2147483647L;
            if (readInt == 0) {
                throw g.k("windowSizeIncrement was 0", new Object[0]);
            }
            aVar.f(i6, readInt);
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.f6154a.close();
        }

        @Override // m3.b
        public boolean o(b.a aVar) {
            try {
                this.f6154a.Y(9L);
                int m5 = g.m(this.f6154a);
                if (m5 < 0 || m5 > 16384) {
                    throw g.k("FRAME_SIZE_ERROR: %s", Integer.valueOf(m5));
                }
                byte readByte = (byte) (this.f6154a.readByte() & 255);
                byte readByte2 = (byte) (this.f6154a.readByte() & 255);
                int readInt = this.f6154a.readInt() & a.e.API_PRIORITY_OTHER;
                if (g.f6143a.isLoggable(Level.FINE)) {
                    g.f6143a.fine(b.b(true, readInt, m5, readByte, readByte2));
                }
                switch (readByte) {
                    case 0:
                        c(aVar, m5, readByte2, readInt);
                        break;
                    case 1:
                        h(aVar, m5, readByte2, readInt);
                        break;
                    case 2:
                        l(aVar, m5, readByte2, readInt);
                        break;
                    case 3:
                        p(aVar, m5, readByte2, readInt);
                        break;
                    case 4:
                        r(aVar, m5, readByte2, readInt);
                        break;
                    case 5:
                        n(aVar, m5, readByte2, readInt);
                        break;
                    case 6:
                        i(aVar, m5, readByte2, readInt);
                        break;
                    case 7:
                        d(aVar, m5, readByte2, readInt);
                        break;
                    case 8:
                        u(aVar, m5, readByte2, readInt);
                        break;
                    default:
                        this.f6154a.skip(m5);
                        break;
                }
                return true;
            } catch (IOException unused) {
                return false;
            }
        }
    }

    /* loaded from: classes.dex */
    static final class d implements m3.c {

        /* renamed from: a  reason: collision with root package name */
        private final w4.d f6158a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean f6159b;

        /* renamed from: c  reason: collision with root package name */
        private final w4.c f6160c;

        /* renamed from: d  reason: collision with root package name */
        private final f.b f6161d;

        /* renamed from: e  reason: collision with root package name */
        private int f6162e;

        /* renamed from: f  reason: collision with root package name */
        private boolean f6163f;

        d(w4.d dVar, boolean z4) {
            this.f6158a = dVar;
            this.f6159b = z4;
            w4.c cVar = new w4.c();
            this.f6160c = cVar;
            this.f6161d = new f.b(cVar);
            this.f6162e = 16384;
        }

        private void h(int i5, long j5) {
            while (j5 > 0) {
                int min = (int) Math.min(this.f6162e, j5);
                long j6 = min;
                j5 -= j6;
                d(i5, min, (byte) 9, j5 == 0 ? (byte) 4 : (byte) 0);
                this.f6158a.Z(this.f6160c, j6);
            }
        }

        @Override // m3.c
        public synchronized void E() {
            if (this.f6163f) {
                throw new IOException("closed");
            }
            if (this.f6159b) {
                if (g.f6143a.isLoggable(Level.FINE)) {
                    g.f6143a.fine(String.format(">> CONNECTION %s", g.f6144b.k()));
                }
                this.f6158a.write(g.f6144b.t());
                this.f6158a.flush();
            }
        }

        @Override // m3.c
        public synchronized void F(i iVar) {
            if (this.f6163f) {
                throw new IOException("closed");
            }
            int i5 = 0;
            d(0, iVar.f() * 6, (byte) 4, (byte) 0);
            while (i5 < 10) {
                if (iVar.d(i5)) {
                    this.f6158a.writeShort(i5 == 4 ? 3 : i5 == 7 ? 4 : i5);
                    this.f6158a.writeInt(iVar.a(i5));
                }
                i5++;
            }
            this.f6158a.flush();
        }

        @Override // m3.c
        public synchronized void H(i iVar) {
            if (this.f6163f) {
                throw new IOException("closed");
            }
            this.f6162e = iVar.c(this.f6162e);
            d(0, 0, (byte) 4, (byte) 1);
            this.f6158a.flush();
        }

        @Override // m3.c
        public synchronized void T(int i5, m3.a aVar, byte[] bArr) {
            if (this.f6163f) {
                throw new IOException("closed");
            }
            if (aVar.f6104a == -1) {
                throw g.j("errorCode.httpCode == -1", new Object[0]);
            }
            d(0, bArr.length + 8, (byte) 7, (byte) 0);
            this.f6158a.writeInt(i5);
            this.f6158a.writeInt(aVar.f6104a);
            if (bArr.length > 0) {
                this.f6158a.write(bArr);
            }
            this.f6158a.flush();
        }

        @Override // m3.c
        public int V() {
            return this.f6162e;
        }

        @Override // m3.c
        public synchronized void W(boolean z4, boolean z5, int i5, int i6, List<m3.d> list) {
            try {
                if (z5) {
                    throw new UnsupportedOperationException();
                }
                if (this.f6163f) {
                    throw new IOException("closed");
                }
                g(z4, i5, list);
            } catch (Throwable th) {
                throw th;
            }
        }

        @Override // m3.c
        public synchronized void a(int i5, m3.a aVar) {
            if (this.f6163f) {
                throw new IOException("closed");
            }
            if (aVar.f6104a == -1) {
                throw new IllegalArgumentException();
            }
            d(i5, 4, (byte) 3, (byte) 0);
            this.f6158a.writeInt(aVar.f6104a);
            this.f6158a.flush();
        }

        void c(int i5, byte b5, w4.c cVar, int i6) {
            d(i5, i6, (byte) 0, b5);
            if (i6 > 0) {
                this.f6158a.Z(cVar, i6);
            }
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public synchronized void close() {
            this.f6163f = true;
            this.f6158a.close();
        }

        void d(int i5, int i6, byte b5, byte b6) {
            if (g.f6143a.isLoggable(Level.FINE)) {
                g.f6143a.fine(b.b(false, i5, i6, b5, b6));
            }
            int i7 = this.f6162e;
            if (i6 > i7) {
                throw g.j("FRAME_SIZE_ERROR length > %d: %d", Integer.valueOf(i7), Integer.valueOf(i6));
            }
            if ((Integer.MIN_VALUE & i5) != 0) {
                throw g.j("reserved bit set: %s", Integer.valueOf(i5));
            }
            g.n(this.f6158a, i6);
            this.f6158a.writeByte(b5 & 255);
            this.f6158a.writeByte(b6 & 255);
            this.f6158a.writeInt(i5 & a.e.API_PRIORITY_OTHER);
        }

        @Override // m3.c
        public synchronized void e(boolean z4, int i5, int i6) {
            if (this.f6163f) {
                throw new IOException("closed");
            }
            d(0, 8, (byte) 6, z4 ? (byte) 1 : (byte) 0);
            this.f6158a.writeInt(i5);
            this.f6158a.writeInt(i6);
            this.f6158a.flush();
        }

        @Override // m3.c
        public synchronized void f(int i5, long j5) {
            if (this.f6163f) {
                throw new IOException("closed");
            }
            if (j5 == 0 || j5 > 2147483647L) {
                throw g.j("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: %s", Long.valueOf(j5));
            }
            d(i5, 4, (byte) 8, (byte) 0);
            this.f6158a.writeInt((int) j5);
            this.f6158a.flush();
        }

        @Override // m3.c
        public synchronized void flush() {
            if (this.f6163f) {
                throw new IOException("closed");
            }
            this.f6158a.flush();
        }

        void g(boolean z4, int i5, List<m3.d> list) {
            if (this.f6163f) {
                throw new IOException("closed");
            }
            this.f6161d.e(list);
            long size = this.f6160c.size();
            int min = (int) Math.min(this.f6162e, size);
            long j5 = min;
            int i6 = (size > j5 ? 1 : (size == j5 ? 0 : -1));
            byte b5 = i6 == 0 ? (byte) 4 : (byte) 0;
            if (z4) {
                b5 = (byte) (b5 | 1);
            }
            d(i5, min, (byte) 1, b5);
            this.f6158a.Z(this.f6160c, j5);
            if (i6 > 0) {
                h(i5, size - j5);
            }
        }

        @Override // m3.c
        public synchronized void q(boolean z4, int i5, w4.c cVar, int i6) {
            if (this.f6163f) {
                throw new IOException("closed");
            }
            c(i5, z4 ? (byte) 1 : (byte) 0, cVar, i6);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static IllegalArgumentException j(String str, Object... objArr) {
        throw new IllegalArgumentException(String.format(Locale.US, str, objArr));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static IOException k(String str, Object... objArr) {
        throw new IOException(String.format(Locale.US, str, objArr));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int l(int i5, byte b5, short s5) {
        if ((b5 & 8) != 0) {
            i5--;
        }
        if (s5 <= i5) {
            return (short) (i5 - s5);
        }
        throw k("PROTOCOL_ERROR padding %s > remaining length %s", Short.valueOf(s5), Integer.valueOf(i5));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int m(w4.e eVar) {
        return (eVar.readByte() & 255) | ((eVar.readByte() & 255) << 16) | ((eVar.readByte() & 255) << 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void n(w4.d dVar, int i5) {
        dVar.writeByte((i5 >>> 16) & 255);
        dVar.writeByte((i5 >>> 8) & 255);
        dVar.writeByte(i5 & 255);
    }

    @Override // m3.j
    public m3.b a(w4.e eVar, boolean z4) {
        return new c(eVar, 4096, z4);
    }

    @Override // m3.j
    public m3.c b(w4.d dVar, boolean z4) {
        return new d(dVar, z4);
    }
}
