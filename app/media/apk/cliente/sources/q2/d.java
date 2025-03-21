package q2;

import android.app.ActivityManager;
import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.Bundle;
import android.os.Looper;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.view.t;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import q2.d;
/* loaded from: classes.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private boolean f6965a;

    /* renamed from: b  reason: collision with root package name */
    private c f6966b;

    /* renamed from: c  reason: collision with root package name */
    private long f6967c;

    /* renamed from: d  reason: collision with root package name */
    private q2.b f6968d;

    /* renamed from: e  reason: collision with root package name */
    private FlutterJNI f6969e;

    /* renamed from: f  reason: collision with root package name */
    private ExecutorService f6970f;

    /* renamed from: g  reason: collision with root package name */
    Future<b> f6971g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements Callable<b> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f6972a;

        a(Context context) {
            this.f6972a = context;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void c() {
            d.this.f6969e.prefetchDefaultFontManager();
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: b */
        public b call() {
            h3.e j5 = h3.e.j("FlutterLoader initTask");
            try {
                d.a(d.this, this.f6972a);
                try {
                    d.this.f6969e.loadLibrary();
                    d.this.f6969e.updateRefreshRate();
                    d.this.f6970f.execute(new Runnable() { // from class: q2.c
                        @Override // java.lang.Runnable
                        public final void run() {
                            d.a.this.c();
                        }
                    });
                    b bVar = new b(h3.b.d(this.f6972a), h3.b.a(this.f6972a), h3.b.c(this.f6972a), null);
                    if (j5 != null) {
                        j5.close();
                    }
                    return bVar;
                } catch (UnsatisfiedLinkError e5) {
                    if (!e5.toString().contains("couldn't find \"libflutter.so\"") && !e5.toString().contains("dlopen failed: library \"libflutter.so\" not found")) {
                        throw e5;
                    }
                    String property = System.getProperty("os.arch");
                    File file = new File(d.this.f6968d.f6962f);
                    String[] list = file.list();
                    throw new UnsupportedOperationException("Could not load libflutter.so this is possibly because the application is running on an architecture that Flutter Android does not support (e.g. x86) see https://docs.flutter.dev/deployment/android#what-are-the-supported-target-architectures for more detail.\nApp is using cpu architecture: " + property + ", and the native libraries directory (with path " + file.getAbsolutePath() + ") contains the following files: " + Arrays.toString(list), e5);
                }
            } catch (Throwable th) {
                if (j5 != null) {
                    try {
                        j5.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        final String f6974a;

        /* renamed from: b  reason: collision with root package name */
        final String f6975b;

        /* renamed from: c  reason: collision with root package name */
        final String f6976c;

        private b(String str, String str2, String str3) {
            this.f6974a = str;
            this.f6975b = str2;
            this.f6976c = str3;
        }

        /* synthetic */ b(String str, String str2, String str3, a aVar) {
            this(str, str2, str3);
        }
    }

    /* loaded from: classes.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        private String f6977a;

        public String a() {
            return this.f6977a;
        }
    }

    public d() {
        this(n2.a.e().d().a());
    }

    public d(FlutterJNI flutterJNI) {
        this(flutterJNI, n2.a.e().b());
    }

    public d(FlutterJNI flutterJNI, ExecutorService executorService) {
        this.f6965a = false;
        this.f6969e = flutterJNI;
        this.f6970f = executorService;
    }

    static /* synthetic */ e a(d dVar, Context context) {
        dVar.h(context);
        return null;
    }

    private e h(Context context) {
        return null;
    }

    private static boolean j(Bundle bundle) {
        if (bundle == null) {
            return true;
        }
        return bundle.getBoolean("io.flutter.embedding.android.LeakVM", true);
    }

    public boolean e() {
        return this.f6968d.f6963g;
    }

    public void f(Context context, String[] strArr) {
        if (this.f6965a) {
            return;
        }
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new IllegalStateException("ensureInitializationComplete must be called on the main thread");
        }
        if (this.f6966b == null) {
            throw new IllegalStateException("ensureInitializationComplete must be called after startInitialization");
        }
        try {
            h3.e j5 = h3.e.j("FlutterLoader#ensureInitializationComplete");
            b bVar = this.f6971g.get();
            ArrayList arrayList = new ArrayList();
            arrayList.add("--icu-symbol-prefix=_binary_icudtl_dat");
            StringBuilder sb = new StringBuilder();
            sb.append("--icu-native-lib-path=");
            sb.append(this.f6968d.f6962f);
            String str = File.separator;
            sb.append(str);
            sb.append("libflutter.so");
            arrayList.add(sb.toString());
            if (strArr != null) {
                Collections.addAll(arrayList, strArr);
            }
            arrayList.add("--aot-shared-library-name=" + this.f6968d.f6957a);
            arrayList.add("--aot-shared-library-name=" + this.f6968d.f6962f + str + this.f6968d.f6957a);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("--cache-dir-path=");
            sb2.append(bVar.f6975b);
            arrayList.add(sb2.toString());
            if (this.f6968d.f6961e != null) {
                arrayList.add("--domain-network-policy=" + this.f6968d.f6961e);
            }
            if (this.f6966b.a() != null) {
                arrayList.add("--log-tag=" + this.f6966b.a());
            }
            Bundle bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
            int i5 = bundle != null ? bundle.getInt("io.flutter.embedding.android.OldGenHeapSize") : 0;
            if (i5 == 0) {
                ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
                ((ActivityManager) context.getSystemService("activity")).getMemoryInfo(memoryInfo);
                i5 = (int) ((memoryInfo.totalMem / 1000000.0d) / 2.0d);
            }
            arrayList.add("--old-gen-heap-size=" + i5);
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            arrayList.add("--resource-cache-max-bytes-threshold=" + (displayMetrics.widthPixels * displayMetrics.heightPixels * 12 * 4));
            arrayList.add("--prefetched-default-font-manager");
            if (bundle != null) {
                if (bundle.getBoolean("io.flutter.embedding.android.EnableImpeller", false)) {
                    arrayList.add("--enable-impeller");
                }
                if (bundle.getBoolean("io.flutter.embedding.android.EnableVulkanValidation", false)) {
                    arrayList.add("--enable-vulkan-validation");
                }
                if (bundle.getBoolean("io.flutter.embedding.android.EnableOpenGLGPUTracing", false)) {
                    arrayList.add("--enable-opengl-gpu-tracing");
                }
                if (bundle.getBoolean("io.flutter.embedding.android.EnableVulkanGPUTracing", false)) {
                    arrayList.add("--enable-vulkan-gpu-tracing");
                }
                String string = bundle.getString("io.flutter.embedding.android.ImpellerBackend");
                if (string != null) {
                    arrayList.add("--impeller-backend=" + string);
                }
            }
            String str2 = j(bundle) ? "true" : "false";
            arrayList.add("--leak-vm=" + str2);
            this.f6969e.init(context, (String[]) arrayList.toArray(new String[0]), null, bVar.f6974a, bVar.f6975b, SystemClock.uptimeMillis() - this.f6967c);
            this.f6965a = true;
            if (j5 != null) {
                j5.close();
            }
        } catch (Exception e5) {
            n2.b.c("FlutterLoader", "Flutter initialization failed.", e5);
            throw new RuntimeException(e5);
        }
    }

    public String g() {
        return this.f6968d.f6960d;
    }

    public boolean i() {
        return this.f6965a;
    }

    public void k(Context context) {
        l(context, new c());
    }

    public void l(Context context, c cVar) {
        if (this.f6966b != null) {
            return;
        }
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new IllegalStateException("startInitialization must be called on the main thread");
        }
        h3.e j5 = h3.e.j("FlutterLoader#startInitialization");
        try {
            Context applicationContext = context.getApplicationContext();
            this.f6966b = cVar;
            this.f6967c = SystemClock.uptimeMillis();
            this.f6968d = q2.a.e(applicationContext);
            t.f((DisplayManager) applicationContext.getSystemService("display"), this.f6969e).g();
            this.f6971g = this.f6970f.submit(new a(applicationContext));
            if (j5 != null) {
                j5.close();
            }
        } catch (Throwable th) {
            if (j5 != null) {
                try {
                    j5.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }
}
