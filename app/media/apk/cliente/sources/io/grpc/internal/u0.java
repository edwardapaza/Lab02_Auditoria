package io.grpc.internal;

import java.io.Closeable;
import java.util.zip.CRC32;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
import java.util.zip.ZipException;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u0 implements Closeable {

    /* renamed from: e  reason: collision with root package name */
    private int f5248e;

    /* renamed from: f  reason: collision with root package name */
    private int f5249f;

    /* renamed from: k  reason: collision with root package name */
    private Inflater f5250k;

    /* renamed from: n  reason: collision with root package name */
    private int f5253n;

    /* renamed from: o  reason: collision with root package name */
    private int f5254o;

    /* renamed from: p  reason: collision with root package name */
    private long f5255p;

    /* renamed from: a  reason: collision with root package name */
    private final w f5244a = new w();

    /* renamed from: b  reason: collision with root package name */
    private final CRC32 f5245b = new CRC32();

    /* renamed from: c  reason: collision with root package name */
    private final b f5246c = new b(this, null);

    /* renamed from: d  reason: collision with root package name */
    private final byte[] f5247d = new byte[512];

    /* renamed from: l  reason: collision with root package name */
    private c f5251l = c.HEADER;

    /* renamed from: m  reason: collision with root package name */
    private boolean f5252m = false;

    /* renamed from: q  reason: collision with root package name */
    private int f5256q = 0;

    /* renamed from: r  reason: collision with root package name */
    private int f5257r = 0;

    /* renamed from: s  reason: collision with root package name */
    private boolean f5258s = true;

    /* loaded from: classes.dex */
    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f5259a;

        static {
            int[] iArr = new int[c.values().length];
            f5259a = iArr;
            try {
                iArr[c.HEADER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f5259a[c.HEADER_EXTRA_LEN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f5259a[c.HEADER_EXTRA.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f5259a[c.HEADER_NAME.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f5259a[c.HEADER_COMMENT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f5259a[c.HEADER_CRC.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f5259a[c.INITIALIZE_INFLATER.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f5259a[c.INFLATING.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f5259a[c.INFLATER_NEEDS_INPUT.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f5259a[c.TRAILER.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b {
        private b() {
        }

        /* synthetic */ b(u0 u0Var, a aVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean g() {
            while (k() > 0) {
                if (h() == 0) {
                    return true;
                }
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int h() {
            int readUnsignedByte;
            if (u0.this.f5249f - u0.this.f5248e > 0) {
                readUnsignedByte = u0.this.f5247d[u0.this.f5248e] & 255;
                u0.g(u0.this, 1);
            } else {
                readUnsignedByte = u0.this.f5244a.readUnsignedByte();
            }
            u0.this.f5245b.update(readUnsignedByte);
            u0.l(u0.this, 1);
            return readUnsignedByte;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public long i() {
            return j() | (j() << 16);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int j() {
            return h() | (h() << 8);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int k() {
            return (u0.this.f5249f - u0.this.f5248e) + u0.this.f5244a.b();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void l(int i5) {
            int i6;
            int i7 = u0.this.f5249f - u0.this.f5248e;
            if (i7 > 0) {
                int min = Math.min(i7, i5);
                u0.this.f5245b.update(u0.this.f5247d, u0.this.f5248e, min);
                u0.g(u0.this, min);
                i6 = i5 - min;
            } else {
                i6 = i5;
            }
            if (i6 > 0) {
                byte[] bArr = new byte[512];
                int i8 = 0;
                while (i8 < i6) {
                    int min2 = Math.min(i6 - i8, 512);
                    u0.this.f5244a.d0(bArr, 0, min2);
                    u0.this.f5245b.update(bArr, 0, min2);
                    i8 += min2;
                }
            }
            u0.l(u0.this, i5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public enum c {
        HEADER,
        HEADER_EXTRA_LEN,
        HEADER_EXTRA,
        HEADER_NAME,
        HEADER_COMMENT,
        HEADER_CRC,
        INITIALIZE_INFLATER,
        INFLATING,
        INFLATER_NEEDS_INPUT,
        TRAILER
    }

    private boolean D() {
        if (this.f5246c.k() < 10) {
            return false;
        }
        if (this.f5246c.j() == 35615) {
            if (this.f5246c.h() == 8) {
                this.f5253n = this.f5246c.h();
                this.f5246c.l(6);
                this.f5251l = c.HEADER_EXTRA_LEN;
                return true;
            }
            throw new ZipException("Unsupported compression method");
        }
        throw new ZipException("Not in GZIP format");
    }

    private boolean I() {
        if ((this.f5253n & 16) == 16 && !this.f5246c.g()) {
            return false;
        }
        this.f5251l = c.HEADER_CRC;
        return true;
    }

    private boolean J() {
        if ((this.f5253n & 2) == 2) {
            if (this.f5246c.k() < 2) {
                return false;
            }
            if ((65535 & ((int) this.f5245b.getValue())) != this.f5246c.j()) {
                throw new ZipException("Corrupt GZIP header");
            }
        }
        this.f5251l = c.INITIALIZE_INFLATER;
        return true;
    }

    private boolean K() {
        int k5 = this.f5246c.k();
        int i5 = this.f5254o;
        if (k5 < i5) {
            return false;
        }
        this.f5246c.l(i5);
        this.f5251l = c.HEADER_NAME;
        return true;
    }

    private boolean L() {
        c cVar;
        if ((this.f5253n & 4) != 4) {
            cVar = c.HEADER_NAME;
        } else if (this.f5246c.k() < 2) {
            return false;
        } else {
            this.f5254o = this.f5246c.j();
            cVar = c.HEADER_EXTRA;
        }
        this.f5251l = cVar;
        return true;
    }

    private boolean M() {
        if ((this.f5253n & 8) == 8 && !this.f5246c.g()) {
            return false;
        }
        this.f5251l = c.HEADER_COMMENT;
        return true;
    }

    private boolean N() {
        if (this.f5250k != null && this.f5246c.k() <= 18) {
            this.f5250k.end();
            this.f5250k = null;
        }
        if (this.f5246c.k() < 8) {
            return false;
        }
        if (this.f5245b.getValue() == this.f5246c.i() && this.f5255p == this.f5246c.i()) {
            this.f5245b.reset();
            this.f5251l = c.HEADER;
            return true;
        }
        throw new ZipException("Corrupt GZIP trailer");
    }

    static /* synthetic */ int g(u0 u0Var, int i5) {
        int i6 = u0Var.f5248e + i5;
        u0Var.f5248e = i6;
        return i6;
    }

    static /* synthetic */ int l(u0 u0Var, int i5) {
        int i6 = u0Var.f5256q + i5;
        u0Var.f5256q = i6;
        return i6;
    }

    private boolean p() {
        z0.k.u(this.f5250k != null, "inflater is null");
        z0.k.u(this.f5248e == this.f5249f, "inflaterInput has unconsumed bytes");
        int min = Math.min(this.f5244a.b(), 512);
        if (min == 0) {
            return false;
        }
        this.f5248e = 0;
        this.f5249f = min;
        this.f5244a.d0(this.f5247d, 0, min);
        this.f5250k.setInput(this.f5247d, this.f5248e, min);
        this.f5251l = c.INFLATING;
        return true;
    }

    private int w(byte[] bArr, int i5, int i6) {
        c cVar;
        z0.k.u(this.f5250k != null, "inflater is null");
        try {
            int totalIn = this.f5250k.getTotalIn();
            int inflate = this.f5250k.inflate(bArr, i5, i6);
            int totalIn2 = this.f5250k.getTotalIn() - totalIn;
            this.f5256q += totalIn2;
            this.f5257r += totalIn2;
            this.f5248e += totalIn2;
            this.f5245b.update(bArr, i5, inflate);
            if (!this.f5250k.finished()) {
                if (this.f5250k.needsInput()) {
                    cVar = c.INFLATER_NEEDS_INPUT;
                }
                return inflate;
            }
            this.f5255p = this.f5250k.getBytesWritten() & 4294967295L;
            cVar = c.TRAILER;
            this.f5251l = cVar;
            return inflate;
        } catch (DataFormatException e5) {
            throw new DataFormatException("Inflater data format exception: " + e5.getMessage());
        }
    }

    private boolean z() {
        c cVar;
        Inflater inflater = this.f5250k;
        if (inflater == null) {
            this.f5250k = new Inflater(true);
        } else {
            inflater.reset();
        }
        this.f5245b.reset();
        int i5 = this.f5249f;
        int i6 = this.f5248e;
        int i7 = i5 - i6;
        if (i7 > 0) {
            this.f5250k.setInput(this.f5247d, i6, i7);
            cVar = c.INFLATING;
        } else {
            cVar = c.INFLATER_NEEDS_INPUT;
        }
        this.f5251l = cVar;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean A() {
        z0.k.u(!this.f5252m, "GzipInflatingBuffer is closed");
        return this.f5258s;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.f5252m) {
            return;
        }
        this.f5252m = true;
        this.f5244a.close();
        Inflater inflater = this.f5250k;
        if (inflater != null) {
            inflater.end();
            this.f5250k = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void n(x1 x1Var) {
        z0.k.u(!this.f5252m, "GzipInflatingBuffer is closed");
        this.f5244a.d(x1Var);
        this.f5258s = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int r() {
        int i5 = this.f5256q;
        this.f5256q = 0;
        return i5;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int u() {
        int i5 = this.f5257r;
        this.f5257r = 0;
        return i5;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean v() {
        z0.k.u(!this.f5252m, "GzipInflatingBuffer is closed");
        return (this.f5246c.k() == 0 && this.f5251l == c.HEADER) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int x(byte[] bArr, int i5, int i6) {
        boolean z4 = true;
        z0.k.u(!this.f5252m, "GzipInflatingBuffer is closed");
        boolean z5 = true;
        int i7 = 0;
        while (z5) {
            int i8 = i6 - i7;
            if (i8 <= 0) {
                if (z5 && (this.f5251l != c.HEADER || this.f5246c.k() >= 10)) {
                    z4 = false;
                }
                this.f5258s = z4;
                return i7;
            }
            switch (a.f5259a[this.f5251l.ordinal()]) {
                case 1:
                    z5 = D();
                    continue;
                case 2:
                    z5 = L();
                    continue;
                case 3:
                    z5 = K();
                    continue;
                case 4:
                    z5 = M();
                    continue;
                case 5:
                    z5 = I();
                    continue;
                case 6:
                    z5 = J();
                    continue;
                case 7:
                    z5 = z();
                    continue;
                case 8:
                    i7 += w(bArr, i5 + i7, i8);
                    if (this.f5251l == c.TRAILER) {
                        break;
                    } else {
                        z5 = true;
                        continue;
                    }
                case i2.d0.ARRAY_VALUE_FIELD_NUMBER /* 9 */:
                    z5 = p();
                    continue;
                case i2.d0.TIMESTAMP_VALUE_FIELD_NUMBER /* 10 */:
                    break;
                default:
                    throw new AssertionError("Invalid state: " + this.f5251l);
            }
            z5 = N();
        }
        if (z5) {
            z4 = false;
        }
        this.f5258s = z4;
        return i7;
    }
}
