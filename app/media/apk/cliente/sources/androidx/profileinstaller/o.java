package androidx.profileinstaller;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Objects;
/* loaded from: classes.dex */
public final class o {

    /* renamed from: a  reason: collision with root package name */
    private static final androidx.concurrent.futures.c<c> f667a = androidx.concurrent.futures.c.y();

    /* renamed from: b  reason: collision with root package name */
    private static final Object f668b = new Object();

    /* renamed from: c  reason: collision with root package name */
    private static c f669c = null;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        static PackageInfo a(PackageManager packageManager, Context context) {
            return packageManager.getPackageInfo(context.getPackageName(), PackageManager.PackageInfoFlags.of(0L));
        }
    }

    /* loaded from: classes.dex */
    static class b {

        /* renamed from: a  reason: collision with root package name */
        final int f670a;

        /* renamed from: b  reason: collision with root package name */
        final int f671b;

        /* renamed from: c  reason: collision with root package name */
        final long f672c;

        /* renamed from: d  reason: collision with root package name */
        final long f673d;

        b(int i5, int i6, long j5, long j6) {
            this.f670a = i5;
            this.f671b = i6;
            this.f672c = j5;
            this.f673d = j6;
        }

        static b a(File file) {
            DataInputStream dataInputStream = new DataInputStream(new FileInputStream(file));
            try {
                b bVar = new b(dataInputStream.readInt(), dataInputStream.readInt(), dataInputStream.readLong(), dataInputStream.readLong());
                dataInputStream.close();
                return bVar;
            } catch (Throwable th) {
                try {
                    dataInputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }

        void b(File file) {
            file.delete();
            DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(file));
            try {
                dataOutputStream.writeInt(this.f670a);
                dataOutputStream.writeInt(this.f671b);
                dataOutputStream.writeLong(this.f672c);
                dataOutputStream.writeLong(this.f673d);
                dataOutputStream.close();
            } catch (Throwable th) {
                try {
                    dataOutputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || !(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return this.f671b == bVar.f671b && this.f672c == bVar.f672c && this.f670a == bVar.f670a && this.f673d == bVar.f673d;
        }

        public int hashCode() {
            return Objects.hash(Integer.valueOf(this.f671b), Long.valueOf(this.f672c), Integer.valueOf(this.f670a), Long.valueOf(this.f673d));
        }
    }

    /* loaded from: classes.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        final int f674a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean f675b;

        /* renamed from: c  reason: collision with root package name */
        private final boolean f676c;

        c(int i5, boolean z4, boolean z5) {
            this.f674a = i5;
            this.f676c = z5;
            this.f675b = z4;
        }
    }

    private static long a(Context context) {
        PackageManager packageManager = context.getApplicationContext().getPackageManager();
        return (Build.VERSION.SDK_INT >= 33 ? a.a(packageManager, context) : packageManager.getPackageInfo(context.getPackageName(), 0)).lastUpdateTime;
    }

    private static c b(int i5, boolean z4, boolean z5) {
        c cVar = new c(i5, z4, z5);
        f669c = cVar;
        f667a.u(cVar);
        return f669c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Can't wrap try/catch for region: R(20:14|(1:77)(1:18)|19|(1:76)(1:23)|24|25|26|(2:62|63)|28|(8:35|(1:39)|(1:46)|47|(2:54|55)|51|52|53)|(1:61)|(1:39)|(3:41|44|46)|47|(1:49)|54|55|51|52|53) */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x009d, code lost:
        r3 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x00cc, code lost:
        r3 = 196608;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static androidx.profileinstaller.o.c c(android.content.Context r18, boolean r19) {
        /*
            Method dump skipped, instructions count: 231
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.profileinstaller.o.c(android.content.Context, boolean):androidx.profileinstaller.o$c");
    }
}
