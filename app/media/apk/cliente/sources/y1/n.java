package y1;

import android.util.Base64;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/* loaded from: classes.dex */
public final class n {

    /* renamed from: a  reason: collision with root package name */
    private final int f8445a;

    /* renamed from: b  reason: collision with root package name */
    private final com.google.protobuf.i f8446b;

    /* renamed from: c  reason: collision with root package name */
    private final int f8447c;

    /* renamed from: d  reason: collision with root package name */
    private final MessageDigest f8448d;

    /* loaded from: classes.dex */
    public static final class a extends Exception {
        public a(String str) {
            super(str);
        }
    }

    public n(com.google.protobuf.i iVar, int i5, int i6) {
        if (i5 < 0 || i5 >= 8) {
            throw new IllegalArgumentException("Invalid padding: " + i5);
        } else if (i6 < 0) {
            throw new IllegalArgumentException("Invalid hash count: " + i6);
        } else if (iVar.size() > 0 && i6 == 0) {
            throw new IllegalArgumentException("Invalid hash count: " + i6);
        } else if (iVar.size() == 0 && i5 != 0) {
            throw new IllegalArgumentException("Expected padding of 0 when bitmap length is 0, but got " + i5);
        } else {
            this.f8446b = iVar;
            this.f8447c = i6;
            this.f8445a = (iVar.size() * 8) - i5;
            this.f8448d = b();
        }
    }

    public static n a(com.google.protobuf.i iVar, int i5, int i6) {
        if (i5 < 0 || i5 >= 8) {
            throw new a("Invalid padding: " + i5);
        } else if (i6 < 0) {
            throw new a("Invalid hash count: " + i6);
        } else if (iVar.size() > 0 && i6 == 0) {
            throw new a("Invalid hash count: " + i6);
        } else if (iVar.size() != 0 || i5 == 0) {
            return new n(iVar, i5, i6);
        } else {
            throw new a("Expected padding of 0 when bitmap length is 0, but got " + i5);
        }
    }

    private static MessageDigest b() {
        try {
            return MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e5) {
            throw new RuntimeException("Missing MD5 MessageDigest provider: ", e5);
        }
    }

    private int d(long j5, long j6, int i5) {
        return (int) i(j5 + (j6 * i5), this.f8445a);
    }

    private static long e(byte[] bArr, int i5) {
        long j5 = 0;
        for (int i6 = 0; i6 < 8; i6++) {
            j5 |= (bArr[i5 + i6] & 255) << (i6 * 8);
        }
        return j5;
    }

    private boolean f(int i5) {
        return ((1 << (i5 % 8)) & this.f8446b.k(i5 / 8)) != 0;
    }

    private byte[] g(String str) {
        return this.f8448d.digest(str.getBytes(StandardCharsets.UTF_8));
    }

    private static long i(long j5, long j6) {
        long j7 = j5 - ((((j5 >>> 1) / j6) << 1) * j6);
        if (j7 < j6) {
            j6 = 0;
        }
        return j7 - j6;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int c() {
        return this.f8445a;
    }

    public boolean h(String str) {
        if (this.f8445a == 0) {
            return false;
        }
        byte[] g5 = g(str);
        if (g5.length != 16) {
            throw new RuntimeException("Invalid md5 hash array length: " + g5.length + " (expected 16)");
        }
        long e5 = e(g5, 0);
        long e6 = e(g5, 8);
        for (int i5 = 0; i5 < this.f8447c; i5++) {
            if (!f(d(e5, e6, i5))) {
                return false;
            }
        }
        return true;
    }

    public String toString() {
        return "BloomFilter{hashCount=" + this.f8447c + ", size=" + this.f8445a + ", bitmap=\"" + Base64.encodeToString(this.f8446b.G(), 2) + "\"}";
    }
}
