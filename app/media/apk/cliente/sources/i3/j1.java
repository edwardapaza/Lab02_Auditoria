package i3;

import i3.y0;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;
import z0.f;
/* loaded from: classes.dex */
public final class j1 {

    /* renamed from: d  reason: collision with root package name */
    private static final boolean f3430d = Boolean.parseBoolean(System.getProperty("io.grpc.Status.failOnEqualsForTest", "false"));

    /* renamed from: e  reason: collision with root package name */
    private static final List<j1> f3431e = f();

    /* renamed from: f  reason: collision with root package name */
    public static final j1 f3432f = b.OK.c();

    /* renamed from: g  reason: collision with root package name */
    public static final j1 f3433g = b.CANCELLED.c();

    /* renamed from: h  reason: collision with root package name */
    public static final j1 f3434h = b.UNKNOWN.c();

    /* renamed from: i  reason: collision with root package name */
    public static final j1 f3435i = b.INVALID_ARGUMENT.c();

    /* renamed from: j  reason: collision with root package name */
    public static final j1 f3436j = b.DEADLINE_EXCEEDED.c();

    /* renamed from: k  reason: collision with root package name */
    public static final j1 f3437k = b.NOT_FOUND.c();

    /* renamed from: l  reason: collision with root package name */
    public static final j1 f3438l = b.ALREADY_EXISTS.c();

    /* renamed from: m  reason: collision with root package name */
    public static final j1 f3439m = b.PERMISSION_DENIED.c();

    /* renamed from: n  reason: collision with root package name */
    public static final j1 f3440n = b.UNAUTHENTICATED.c();

    /* renamed from: o  reason: collision with root package name */
    public static final j1 f3441o = b.RESOURCE_EXHAUSTED.c();

    /* renamed from: p  reason: collision with root package name */
    public static final j1 f3442p = b.FAILED_PRECONDITION.c();

    /* renamed from: q  reason: collision with root package name */
    public static final j1 f3443q = b.ABORTED.c();

    /* renamed from: r  reason: collision with root package name */
    public static final j1 f3444r = b.OUT_OF_RANGE.c();

    /* renamed from: s  reason: collision with root package name */
    public static final j1 f3445s = b.UNIMPLEMENTED.c();

    /* renamed from: t  reason: collision with root package name */
    public static final j1 f3446t = b.INTERNAL.c();

    /* renamed from: u  reason: collision with root package name */
    public static final j1 f3447u = b.UNAVAILABLE.c();

    /* renamed from: v  reason: collision with root package name */
    public static final j1 f3448v = b.DATA_LOSS.c();

    /* renamed from: w  reason: collision with root package name */
    static final y0.g<j1> f3449w = y0.g.g("grpc-status", false, new c());

    /* renamed from: x  reason: collision with root package name */
    private static final y0.j<String> f3450x;

    /* renamed from: y  reason: collision with root package name */
    static final y0.g<String> f3451y;

    /* renamed from: a  reason: collision with root package name */
    private final b f3452a;

    /* renamed from: b  reason: collision with root package name */
    private final String f3453b;

    /* renamed from: c  reason: collision with root package name */
    private final Throwable f3454c;

    /* loaded from: classes.dex */
    public enum b {
        OK(0),
        CANCELLED(1),
        UNKNOWN(2),
        INVALID_ARGUMENT(3),
        DEADLINE_EXCEEDED(4),
        NOT_FOUND(5),
        ALREADY_EXISTS(6),
        PERMISSION_DENIED(7),
        RESOURCE_EXHAUSTED(8),
        FAILED_PRECONDITION(9),
        ABORTED(10),
        OUT_OF_RANGE(11),
        UNIMPLEMENTED(12),
        INTERNAL(13),
        UNAVAILABLE(14),
        DATA_LOSS(15),
        UNAUTHENTICATED(16);
        

        /* renamed from: a  reason: collision with root package name */
        private final int f3473a;

        /* renamed from: b  reason: collision with root package name */
        private final byte[] f3474b;

        b(int i5) {
            this.f3473a = i5;
            this.f3474b = Integer.toString(i5).getBytes(z0.b.f8862a);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public byte[] e() {
            return this.f3474b;
        }

        public j1 c() {
            return (j1) j1.f3431e.get(this.f3473a);
        }

        public int d() {
            return this.f3473a;
        }
    }

    /* loaded from: classes.dex */
    private static final class c implements y0.j<j1> {
        private c() {
        }

        @Override // i3.y0.j
        /* renamed from: c */
        public j1 b(byte[] bArr) {
            return j1.i(bArr);
        }

        @Override // i3.y0.j
        /* renamed from: d */
        public byte[] a(j1 j1Var) {
            return j1Var.m().e();
        }
    }

    /* loaded from: classes.dex */
    private static final class d implements y0.j<String> {

        /* renamed from: a  reason: collision with root package name */
        private static final byte[] f3475a = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70};

        private d() {
        }

        private static boolean c(byte b5) {
            return b5 < 32 || b5 >= 126 || b5 == 37;
        }

        private static String e(byte[] bArr) {
            ByteBuffer allocate = ByteBuffer.allocate(bArr.length);
            int i5 = 0;
            while (i5 < bArr.length) {
                if (bArr[i5] == 37 && i5 + 2 < bArr.length) {
                    try {
                        allocate.put((byte) Integer.parseInt(new String(bArr, i5 + 1, 2, z0.b.f8862a), 16));
                        i5 += 3;
                    } catch (NumberFormatException unused) {
                    }
                }
                allocate.put(bArr[i5]);
                i5++;
            }
            return new String(allocate.array(), 0, allocate.position(), z0.b.f8864c);
        }

        private static byte[] g(byte[] bArr, int i5) {
            byte[] bArr2 = new byte[((bArr.length - i5) * 3) + i5];
            if (i5 != 0) {
                System.arraycopy(bArr, 0, bArr2, 0, i5);
            }
            int i6 = i5;
            while (i5 < bArr.length) {
                byte b5 = bArr[i5];
                if (c(b5)) {
                    bArr2[i6] = 37;
                    byte[] bArr3 = f3475a;
                    bArr2[i6 + 1] = bArr3[(b5 >> 4) & 15];
                    bArr2[i6 + 2] = bArr3[b5 & 15];
                    i6 += 3;
                } else {
                    bArr2[i6] = b5;
                    i6++;
                }
                i5++;
            }
            return Arrays.copyOf(bArr2, i6);
        }

        @Override // i3.y0.j
        /* renamed from: d */
        public String b(byte[] bArr) {
            for (int i5 = 0; i5 < bArr.length; i5++) {
                byte b5 = bArr[i5];
                if (b5 < 32 || b5 >= 126 || (b5 == 37 && i5 + 2 < bArr.length)) {
                    return e(bArr);
                }
            }
            return new String(bArr, 0);
        }

        @Override // i3.y0.j
        /* renamed from: f */
        public byte[] a(String str) {
            byte[] bytes = str.getBytes(z0.b.f8864c);
            for (int i5 = 0; i5 < bytes.length; i5++) {
                if (c(bytes[i5])) {
                    return g(bytes, i5);
                }
            }
            return bytes;
        }
    }

    static {
        d dVar = new d();
        f3450x = dVar;
        f3451y = y0.g.g("grpc-message", false, dVar);
    }

    private j1(b bVar) {
        this(bVar, null, null);
    }

    private j1(b bVar, String str, Throwable th) {
        this.f3452a = (b) z0.k.o(bVar, "code");
        this.f3453b = str;
        this.f3454c = th;
    }

    private static List<j1> f() {
        b[] values;
        j1 j1Var;
        TreeMap treeMap = new TreeMap();
        for (b bVar : b.values()) {
            if (((j1) treeMap.put(Integer.valueOf(bVar.d()), new j1(bVar))) != null) {
                throw new IllegalStateException("Code value duplication between " + j1Var.m().name() + " & " + bVar.name());
            }
        }
        return Collections.unmodifiableList(new ArrayList(treeMap.values()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String g(j1 j1Var) {
        if (j1Var.f3453b == null) {
            return j1Var.f3452a.toString();
        }
        return j1Var.f3452a + ": " + j1Var.f3453b;
    }

    public static j1 h(int i5) {
        if (i5 >= 0) {
            List<j1> list = f3431e;
            if (i5 < list.size()) {
                return list.get(i5);
            }
        }
        j1 j1Var = f3434h;
        return j1Var.q("Unknown code " + i5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static j1 i(byte[] bArr) {
        return (bArr.length == 1 && bArr[0] == 48) ? f3432f : j(bArr);
    }

    private static j1 j(byte[] bArr) {
        int i5;
        byte b5;
        int length = bArr.length;
        char c5 = 1;
        if (length != 1) {
            i5 = (length == 2 && (b5 = bArr[0]) >= 48 && b5 <= 57) ? 0 + ((b5 - 48) * 10) : 0;
            j1 j1Var = f3434h;
            return j1Var.q("Unknown code " + new String(bArr, z0.b.f8862a));
        }
        c5 = 0;
        byte b6 = bArr[c5];
        if (b6 >= 48 && b6 <= 57) {
            int i6 = i5 + (b6 - 48);
            List<j1> list = f3431e;
            if (i6 < list.size()) {
                return list.get(i6);
            }
        }
        j1 j1Var2 = f3434h;
        return j1Var2.q("Unknown code " + new String(bArr, z0.b.f8862a));
    }

    public static j1 k(Throwable th) {
        for (Throwable th2 = (Throwable) z0.k.o(th, "t"); th2 != null; th2 = th2.getCause()) {
            if (th2 instanceof k1) {
                return ((k1) th2).a();
            }
            if (th2 instanceof l1) {
                return ((l1) th2).a();
            }
        }
        return f3434h.p(th);
    }

    public k1 c() {
        return new k1(this);
    }

    public l1 d() {
        return new l1(this);
    }

    public j1 e(String str) {
        if (str == null) {
            return this;
        }
        if (this.f3453b == null) {
            return new j1(this.f3452a, str, this.f3454c);
        }
        b bVar = this.f3452a;
        return new j1(bVar, this.f3453b + "\n" + str, this.f3454c);
    }

    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public int hashCode() {
        return super.hashCode();
    }

    public Throwable l() {
        return this.f3454c;
    }

    public b m() {
        return this.f3452a;
    }

    public String n() {
        return this.f3453b;
    }

    public boolean o() {
        return b.OK == this.f3452a;
    }

    public j1 p(Throwable th) {
        return z0.g.a(this.f3454c, th) ? this : new j1(this.f3452a, this.f3453b, th);
    }

    public j1 q(String str) {
        return z0.g.a(this.f3453b, str) ? this : new j1(this.f3452a, str, this.f3454c);
    }

    public String toString() {
        f.b d5 = z0.f.b(this).d("code", this.f3452a.name()).d("description", this.f3453b);
        Throwable th = this.f3454c;
        String str = th;
        if (th != null) {
            str = z0.p.e(th);
        }
        return d5.d("cause", str).toString();
    }
}
