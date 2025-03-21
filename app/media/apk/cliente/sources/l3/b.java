package l3;

import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLSocket;
/* loaded from: classes.dex */
public final class b {

    /* renamed from: e  reason: collision with root package name */
    private static final l3.a[] f5964e;

    /* renamed from: f  reason: collision with root package name */
    public static final b f5965f;

    /* renamed from: g  reason: collision with root package name */
    public static final b f5966g;

    /* renamed from: h  reason: collision with root package name */
    public static final b f5967h;

    /* renamed from: a  reason: collision with root package name */
    final boolean f5968a;

    /* renamed from: b  reason: collision with root package name */
    private final String[] f5969b;

    /* renamed from: c  reason: collision with root package name */
    private final String[] f5970c;

    /* renamed from: d  reason: collision with root package name */
    final boolean f5971d;

    /* renamed from: l3.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0087b {

        /* renamed from: a  reason: collision with root package name */
        private boolean f5972a;

        /* renamed from: b  reason: collision with root package name */
        private String[] f5973b;

        /* renamed from: c  reason: collision with root package name */
        private String[] f5974c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f5975d;

        public C0087b(b bVar) {
            this.f5972a = bVar.f5968a;
            this.f5973b = bVar.f5969b;
            this.f5974c = bVar.f5970c;
            this.f5975d = bVar.f5971d;
        }

        public C0087b(boolean z4) {
            this.f5972a = z4;
        }

        public b e() {
            return new b(this);
        }

        public C0087b f(String... strArr) {
            if (this.f5972a) {
                if (strArr == null) {
                    this.f5973b = null;
                } else {
                    this.f5973b = (String[]) strArr.clone();
                }
                return this;
            }
            throw new IllegalStateException("no cipher suites for cleartext connections");
        }

        public C0087b g(l3.a... aVarArr) {
            if (this.f5972a) {
                String[] strArr = new String[aVarArr.length];
                for (int i5 = 0; i5 < aVarArr.length; i5++) {
                    strArr[i5] = aVarArr[i5].f5963a;
                }
                this.f5973b = strArr;
                return this;
            }
            throw new IllegalStateException("no cipher suites for cleartext connections");
        }

        public C0087b h(boolean z4) {
            if (this.f5972a) {
                this.f5975d = z4;
                return this;
            }
            throw new IllegalStateException("no TLS extensions for cleartext connections");
        }

        public C0087b i(String... strArr) {
            if (this.f5972a) {
                if (strArr == null) {
                    this.f5974c = null;
                } else {
                    this.f5974c = (String[]) strArr.clone();
                }
                return this;
            }
            throw new IllegalStateException("no TLS versions for cleartext connections");
        }

        public C0087b j(k... kVarArr) {
            if (this.f5972a) {
                if (kVarArr.length != 0) {
                    String[] strArr = new String[kVarArr.length];
                    for (int i5 = 0; i5 < kVarArr.length; i5++) {
                        strArr[i5] = kVarArr[i5].f6030a;
                    }
                    this.f5974c = strArr;
                    return this;
                }
                throw new IllegalArgumentException("At least one TlsVersion is required");
            }
            throw new IllegalStateException("no TLS versions for cleartext connections");
        }
    }

    static {
        l3.a[] aVarArr = {l3.a.TLS_AES_128_GCM_SHA256, l3.a.TLS_AES_256_GCM_SHA384, l3.a.TLS_CHACHA20_POLY1305_SHA256, l3.a.TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256, l3.a.TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256, l3.a.TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384, l3.a.TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384, l3.a.TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256, l3.a.TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256, l3.a.TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA, l3.a.TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA, l3.a.TLS_RSA_WITH_AES_128_GCM_SHA256, l3.a.TLS_RSA_WITH_AES_256_GCM_SHA384, l3.a.TLS_RSA_WITH_AES_128_CBC_SHA, l3.a.TLS_RSA_WITH_AES_256_CBC_SHA, l3.a.TLS_RSA_WITH_3DES_EDE_CBC_SHA};
        f5964e = aVarArr;
        C0087b g5 = new C0087b(true).g(aVarArr);
        k kVar = k.TLS_1_3;
        k kVar2 = k.TLS_1_2;
        b e5 = g5.j(kVar, kVar2).h(true).e();
        f5965f = e5;
        f5966g = new C0087b(e5).j(kVar, kVar2, k.TLS_1_1, k.TLS_1_0).h(true).e();
        f5967h = new C0087b(false).e();
    }

    private b(C0087b c0087b) {
        this.f5968a = c0087b.f5972a;
        this.f5969b = c0087b.f5973b;
        this.f5970c = c0087b.f5974c;
        this.f5971d = c0087b.f5975d;
    }

    private b e(SSLSocket sSLSocket, boolean z4) {
        String[] strArr;
        if (this.f5969b != null) {
            strArr = (String[]) l.c(String.class, this.f5969b, sSLSocket.getEnabledCipherSuites());
        } else {
            strArr = null;
        }
        if (z4 && Arrays.asList(sSLSocket.getSupportedCipherSuites()).contains("TLS_FALLBACK_SCSV")) {
            if (strArr == null) {
                strArr = sSLSocket.getEnabledCipherSuites();
            }
            int length = strArr.length + 1;
            String[] strArr2 = new String[length];
            System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
            strArr2[length - 1] = "TLS_FALLBACK_SCSV";
            strArr = strArr2;
        }
        String[] enabledProtocols = sSLSocket.getEnabledProtocols();
        return new C0087b(this).f(strArr).i((String[]) l.c(String.class, this.f5970c, enabledProtocols)).e();
    }

    public void c(SSLSocket sSLSocket, boolean z4) {
        b e5 = e(sSLSocket, z4);
        sSLSocket.setEnabledProtocols(e5.f5970c);
        String[] strArr = e5.f5969b;
        if (strArr != null) {
            sSLSocket.setEnabledCipherSuites(strArr);
        }
    }

    public List<l3.a> d() {
        String[] strArr = this.f5969b;
        if (strArr == null) {
            return null;
        }
        l3.a[] aVarArr = new l3.a[strArr.length];
        int i5 = 0;
        while (true) {
            String[] strArr2 = this.f5969b;
            if (i5 >= strArr2.length) {
                return l.a(aVarArr);
            }
            aVarArr[i5] = l3.a.a(strArr2[i5]);
            i5++;
        }
    }

    public boolean equals(Object obj) {
        if (obj instanceof b) {
            if (obj == this) {
                return true;
            }
            b bVar = (b) obj;
            boolean z4 = this.f5968a;
            if (z4 != bVar.f5968a) {
                return false;
            }
            return !z4 || (Arrays.equals(this.f5969b, bVar.f5969b) && Arrays.equals(this.f5970c, bVar.f5970c) && this.f5971d == bVar.f5971d);
        }
        return false;
    }

    public boolean f() {
        return this.f5971d;
    }

    public List<k> g() {
        k[] kVarArr = new k[this.f5970c.length];
        int i5 = 0;
        while (true) {
            String[] strArr = this.f5970c;
            if (i5 >= strArr.length) {
                return l.a(kVarArr);
            }
            kVarArr[i5] = k.a(strArr[i5]);
            i5++;
        }
    }

    public int hashCode() {
        if (this.f5968a) {
            return ((((527 + Arrays.hashCode(this.f5969b)) * 31) + Arrays.hashCode(this.f5970c)) * 31) + (!this.f5971d ? 1 : 0);
        }
        return 17;
    }

    public String toString() {
        if (this.f5968a) {
            List<l3.a> d5 = d();
            String obj = d5 == null ? "[use default]" : d5.toString();
            return "ConnectionSpec(cipherSuites=" + obj + ", tlsVersions=" + g() + ", supportsTlsExtensions=" + this.f5971d + ")";
        }
        return "ConnectionSpec()";
    }
}
