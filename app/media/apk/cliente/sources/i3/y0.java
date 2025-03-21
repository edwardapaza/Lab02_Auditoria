package i3;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Collections;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
/* loaded from: classes.dex */
public final class y0 {

    /* renamed from: c  reason: collision with root package name */
    private static final Logger f3586c = Logger.getLogger(y0.class.getName());

    /* renamed from: d  reason: collision with root package name */
    public static final e<byte[]> f3587d = new a();

    /* renamed from: e  reason: collision with root package name */
    public static final d<String> f3588e = new b();

    /* renamed from: f  reason: collision with root package name */
    static final b1.a f3589f = b1.a.a().k();

    /* renamed from: a  reason: collision with root package name */
    private Object[] f3590a;

    /* renamed from: b  reason: collision with root package name */
    private int f3591b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements e<byte[]> {
        a() {
        }
    }

    /* loaded from: classes.dex */
    class b implements d<String> {
        b() {
        }

        @Override // i3.y0.d
        /* renamed from: c */
        public String b(String str) {
            return str;
        }

        @Override // i3.y0.d
        /* renamed from: d */
        public String a(String str) {
            return str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c<T> extends g<T> {

        /* renamed from: f  reason: collision with root package name */
        private final d<T> f3592f;

        private c(String str, boolean z4, d<T> dVar) {
            super(str, z4, dVar, null);
            z0.k.k(!str.endsWith("-bin"), "ASCII header is named %s.  Only binary headers may end with %s", str, "-bin");
            this.f3592f = (d) z0.k.o(dVar, "marshaller");
        }

        /* synthetic */ c(String str, boolean z4, d dVar, a aVar) {
            this(str, z4, dVar);
        }

        @Override // i3.y0.g
        T h(byte[] bArr) {
            return this.f3592f.b(new String(bArr, z0.b.f8862a));
        }

        @Override // i3.y0.g
        byte[] j(T t5) {
            return ((String) z0.k.o(this.f3592f.a(t5), "null marshaller.toAsciiString()")).getBytes(z0.b.f8862a);
        }
    }

    /* loaded from: classes.dex */
    public interface d<T> {
        String a(T t5);

        T b(String str);
    }

    /* loaded from: classes.dex */
    public interface e<T> {
    }

    /* loaded from: classes.dex */
    public interface f<T> {
        InputStream a(T t5);

        T b(InputStream inputStream);
    }

    /* loaded from: classes.dex */
    public static abstract class g<T> {

        /* renamed from: e  reason: collision with root package name */
        private static final BitSet f3593e = b();

        /* renamed from: a  reason: collision with root package name */
        private final String f3594a;

        /* renamed from: b  reason: collision with root package name */
        private final String f3595b;

        /* renamed from: c  reason: collision with root package name */
        private final byte[] f3596c;

        /* renamed from: d  reason: collision with root package name */
        private final Object f3597d;

        private g(String str, boolean z4, Object obj) {
            String str2 = (String) z0.k.o(str, "name");
            this.f3594a = str2;
            String k5 = k(str2.toLowerCase(Locale.ROOT), z4);
            this.f3595b = k5;
            this.f3596c = k5.getBytes(z0.b.f8862a);
            this.f3597d = obj;
        }

        /* synthetic */ g(String str, boolean z4, Object obj, a aVar) {
            this(str, z4, obj);
        }

        private static BitSet b() {
            BitSet bitSet = new BitSet(127);
            bitSet.set(45);
            bitSet.set(95);
            bitSet.set(46);
            for (char c5 = '0'; c5 <= '9'; c5 = (char) (c5 + 1)) {
                bitSet.set(c5);
            }
            for (char c6 = 'a'; c6 <= 'z'; c6 = (char) (c6 + 1)) {
                bitSet.set(c6);
            }
            return bitSet;
        }

        public static <T> g<T> e(String str, d<T> dVar) {
            return f(str, false, dVar);
        }

        static <T> g<T> f(String str, boolean z4, d<T> dVar) {
            return new c(str, z4, dVar, null);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static <T> g<T> g(String str, boolean z4, j<T> jVar) {
            return new i(str, z4, jVar, null);
        }

        private static String k(String str, boolean z4) {
            z0.k.o(str, "name");
            z0.k.e(!str.isEmpty(), "token must have at least 1 tchar");
            if (str.equals("connection")) {
                y0.f3586c.log(Level.WARNING, "Metadata key is 'Connection', which should not be used. That is used by HTTP/1 for connection-specific headers which are not to be forwarded. There is probably an HTTP/1 conversion bug. Simply removing the Connection header is not enough; you should remove all headers it references as well. See RFC 7230 section 6.1", (Throwable) new RuntimeException("exception to show backtrace"));
            }
            for (int i5 = 0; i5 < str.length(); i5++) {
                char charAt = str.charAt(i5);
                if (!z4 || charAt != ':' || i5 != 0) {
                    z0.k.g(f3593e.get(charAt), "Invalid character '%s' in key name '%s'", charAt, str);
                }
            }
            return str;
        }

        byte[] a() {
            return this.f3596c;
        }

        final <M> M c(Class<M> cls) {
            if (cls.isInstance(this.f3597d)) {
                return cls.cast(this.f3597d);
            }
            return null;
        }

        public final String d() {
            return this.f3595b;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            return this.f3595b.equals(((g) obj).f3595b);
        }

        abstract T h(byte[] bArr);

        public final int hashCode() {
            return this.f3595b.hashCode();
        }

        boolean i() {
            return false;
        }

        abstract byte[] j(T t5);

        public String toString() {
            return "Key{name='" + this.f3595b + "'}";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class h<T> {

        /* renamed from: a  reason: collision with root package name */
        private final f<T> f3598a;

        /* renamed from: b  reason: collision with root package name */
        private final T f3599b;

        /* renamed from: c  reason: collision with root package name */
        private volatile byte[] f3600c;

        h(f<T> fVar, T t5) {
            this.f3598a = fVar;
            this.f3599b = t5;
        }

        static <T> h<T> a(g<T> gVar, T t5) {
            return new h<>((f) z0.k.n(b(gVar)), t5);
        }

        private static <T> f<T> b(g<T> gVar) {
            return (f) gVar.c(f.class);
        }

        byte[] c() {
            if (this.f3600c == null) {
                synchronized (this) {
                    if (this.f3600c == null) {
                        this.f3600c = y0.r(e());
                    }
                }
            }
            return this.f3600c;
        }

        <T2> T2 d(g<T2> gVar) {
            f b5;
            return (!gVar.i() || (b5 = b(gVar)) == null) ? gVar.h(c()) : (T2) b5.b(e());
        }

        InputStream e() {
            return (InputStream) z0.k.o(this.f3598a.a(this.f3599b), "null marshaller.toStream()");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class i<T> extends g<T> {

        /* renamed from: f  reason: collision with root package name */
        private final j<T> f3601f;

        private i(String str, boolean z4, j<T> jVar) {
            super(str, z4, jVar, null);
            z0.k.k(!str.endsWith("-bin"), "ASCII header is named %s.  Only binary headers may end with %s", str, "-bin");
            this.f3601f = (j) z0.k.o(jVar, "marshaller");
        }

        /* synthetic */ i(String str, boolean z4, j jVar, a aVar) {
            this(str, z4, jVar);
        }

        @Override // i3.y0.g
        T h(byte[] bArr) {
            return this.f3601f.b(bArr);
        }

        @Override // i3.y0.g
        byte[] j(T t5) {
            return (byte[]) z0.k.o(this.f3601f.a(t5), "null marshaller.toAsciiString()");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface j<T> {
        byte[] a(T t5);

        T b(byte[] bArr);
    }

    public y0() {
    }

    y0(int i5, Object[] objArr) {
        this.f3591b = i5;
        this.f3590a = objArr;
    }

    y0(int i5, byte[]... bArr) {
        this(i5, (Object[]) bArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public y0(byte[]... bArr) {
        this(bArr.length / 2, bArr);
    }

    private boolean c(byte[] bArr, byte[] bArr2) {
        return Arrays.equals(bArr, bArr2);
    }

    private int d() {
        Object[] objArr = this.f3590a;
        if (objArr != null) {
            return objArr.length;
        }
        return 0;
    }

    private void f(int i5) {
        Object[] objArr = new Object[i5];
        if (!i()) {
            System.arraycopy(this.f3590a, 0, objArr, 0, k());
        }
        this.f3590a = objArr;
    }

    private boolean i() {
        return this.f3591b == 0;
    }

    private int k() {
        return this.f3591b * 2;
    }

    private void l() {
        if (k() == 0 || k() == d()) {
            f(Math.max(k() * 2, 8));
        }
    }

    private void n(int i5, byte[] bArr) {
        this.f3590a[i5 * 2] = bArr;
    }

    private byte[] o(int i5) {
        return (byte[]) this.f3590a[i5 * 2];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte[] r(InputStream inputStream) {
        try {
            return b1.b.d(inputStream);
        } catch (IOException e5) {
            throw new RuntimeException("failure reading serialized stream", e5);
        }
    }

    private Object s(int i5) {
        return this.f3590a[(i5 * 2) + 1];
    }

    private void t(int i5, Object obj) {
        if (this.f3590a instanceof byte[][]) {
            f(d());
        }
        this.f3590a[(i5 * 2) + 1] = obj;
    }

    private void u(int i5, byte[] bArr) {
        this.f3590a[(i5 * 2) + 1] = bArr;
    }

    private byte[] v(int i5) {
        Object s5 = s(i5);
        return s5 instanceof byte[] ? (byte[]) s5 : ((h) s5).c();
    }

    private <T> T w(int i5, g<T> gVar) {
        Object s5 = s(i5);
        return s5 instanceof byte[] ? gVar.h((byte[]) s5) : (T) ((h) s5).d(gVar);
    }

    public <T> void e(g<T> gVar) {
        if (i()) {
            return;
        }
        int i5 = 0;
        for (int i6 = 0; i6 < this.f3591b; i6++) {
            if (!c(gVar.a(), o(i6))) {
                n(i5, o(i6));
                t(i5, s(i6));
                i5++;
            }
        }
        Arrays.fill(this.f3590a, i5 * 2, k(), (Object) null);
        this.f3591b = i5;
    }

    public <T> T g(g<T> gVar) {
        for (int i5 = this.f3591b - 1; i5 >= 0; i5--) {
            if (c(gVar.a(), o(i5))) {
                return (T) w(i5, gVar);
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int h() {
        return this.f3591b;
    }

    public Set<String> j() {
        if (i()) {
            return Collections.emptySet();
        }
        HashSet hashSet = new HashSet(this.f3591b);
        for (int i5 = 0; i5 < this.f3591b; i5++) {
            hashSet.add(new String(o(i5), 0));
        }
        return Collections.unmodifiableSet(hashSet);
    }

    public void m(y0 y0Var) {
        if (y0Var.i()) {
            return;
        }
        int d5 = d() - k();
        if (i() || d5 < y0Var.k()) {
            f(k() + y0Var.k());
        }
        System.arraycopy(y0Var.f3590a, 0, this.f3590a, k(), y0Var.k());
        this.f3591b += y0Var.f3591b;
    }

    public <T> void p(g<T> gVar, T t5) {
        z0.k.o(gVar, "key");
        z0.k.o(t5, "value");
        l();
        n(this.f3591b, gVar.a());
        if (gVar.i()) {
            t(this.f3591b, h.a(gVar, t5));
        } else {
            u(this.f3591b, gVar.j(t5));
        }
        this.f3591b++;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public byte[][] q() {
        byte[][] bArr = new byte[k()];
        Object[] objArr = this.f3590a;
        if (objArr instanceof byte[][]) {
            System.arraycopy(objArr, 0, bArr, 0, k());
        } else {
            for (int i5 = 0; i5 < this.f3591b; i5++) {
                int i6 = i5 * 2;
                bArr[i6] = o(i5);
                bArr[i6 + 1] = v(i5);
            }
        }
        return bArr;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Metadata(");
        for (int i5 = 0; i5 < this.f3591b; i5++) {
            if (i5 != 0) {
                sb.append(',');
            }
            byte[] o5 = o(i5);
            Charset charset = z0.b.f8862a;
            String str = new String(o5, charset);
            sb.append(str);
            sb.append('=');
            sb.append(str.endsWith("-bin") ? f3589f.e(v(i5)) : new String(v(i5), charset));
        }
        sb.append(')');
        return sb.toString();
    }
}
