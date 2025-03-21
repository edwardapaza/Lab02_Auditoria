package o3;

import com.google.android.gms.common.api.a;
import com.google.protobuf.e0;
import com.google.protobuf.g1;
import com.google.protobuf.j;
import com.google.protobuf.q;
import com.google.protobuf.w0;
import i3.j1;
import i3.q0;
import i3.z0;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import z0.k;
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    static volatile q f6781a = q.b();

    /* loaded from: classes.dex */
    private static final class a<T extends w0> implements z0.c {

        /* renamed from: d  reason: collision with root package name */
        private static final ThreadLocal<Reference<byte[]>> f6782d = new ThreadLocal<>();

        /* renamed from: a  reason: collision with root package name */
        private final g1<T> f6783a;

        /* renamed from: b  reason: collision with root package name */
        private final T f6784b;

        /* renamed from: c  reason: collision with root package name */
        private final int f6785c;

        a(T t5, int i5) {
            this.f6784b = (T) k.o(t5, "defaultInstance cannot be null");
            this.f6783a = (g1<T>) t5.m();
            this.f6785c = i5;
        }

        private T d(j jVar) {
            T b5 = this.f6783a.b(jVar, b.f6781a);
            try {
                jVar.a(0);
                return b5;
            } catch (e0 e5) {
                e5.k(b5);
                throw e5;
            }
        }

        @Override // i3.z0.c
        /* renamed from: c */
        public T b(InputStream inputStream) {
            byte[] bArr;
            if ((inputStream instanceof o3.a) && ((o3.a) inputStream).g() == this.f6783a) {
                try {
                    return (T) ((o3.a) inputStream).d();
                } catch (IllegalStateException unused) {
                }
            }
            j jVar = null;
            try {
                if (inputStream instanceof q0) {
                    int available = inputStream.available();
                    if (available > 0 && available <= 4194304) {
                        ThreadLocal<Reference<byte[]>> threadLocal = f6782d;
                        Reference<byte[]> reference = threadLocal.get();
                        if (reference == null || (bArr = reference.get()) == null || bArr.length < available) {
                            bArr = new byte[available];
                            threadLocal.set(new WeakReference(bArr));
                        }
                        int i5 = available;
                        while (i5 > 0) {
                            int read = inputStream.read(bArr, available - i5, i5);
                            if (read == -1) {
                                break;
                            }
                            i5 -= read;
                        }
                        if (i5 != 0) {
                            throw new RuntimeException("size inaccurate: " + available + " != " + (available - i5));
                        }
                        jVar = j.k(bArr, 0, available);
                    } else if (available == 0) {
                        return this.f6784b;
                    }
                }
                if (jVar == null) {
                    jVar = j.f(inputStream);
                }
                jVar.H(a.e.API_PRIORITY_OTHER);
                int i6 = this.f6785c;
                if (i6 >= 0) {
                    jVar.G(i6);
                }
                try {
                    return d(jVar);
                } catch (e0 e5) {
                    throw j1.f3446t.q("Invalid protobuf byte sequence").p(e5).d();
                }
            } catch (IOException e6) {
                throw new RuntimeException(e6);
            }
        }

        @Override // i3.z0.c
        /* renamed from: e */
        public InputStream a(T t5) {
            return new o3.a(t5, this.f6783a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long a(InputStream inputStream, OutputStream outputStream) {
        k.o(inputStream, "inputStream cannot be null!");
        k.o(outputStream, "outputStream cannot be null!");
        byte[] bArr = new byte[8192];
        long j5 = 0;
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                return j5;
            }
            outputStream.write(bArr, 0, read);
            j5 += read;
        }
    }

    public static <T extends w0> z0.c<T> b(T t5) {
        return new a(t5, -1);
    }
}
