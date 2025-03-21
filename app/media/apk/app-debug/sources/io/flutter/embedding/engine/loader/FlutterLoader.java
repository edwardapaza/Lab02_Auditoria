package io.flutter.embedding.engine.loader;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.hardware.display.DisplayManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.WindowManager;
import com.google.firebase.messaging.Constants;
import io.flutter.FlutterInjector;
import io.flutter.Log;
import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.embedding.engine.loader.FlutterLoader;
import io.flutter.util.HandlerCompat;
import io.flutter.util.PathUtils;
import io.flutter.util.TraceSection;
import io.flutter.view.VsyncWaiter;
import java.io.File;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
/* loaded from: classes.dex */
public class FlutterLoader {
    static final String AOT_SHARED_LIBRARY_NAME = "aot-shared-library-name";
    static final String AOT_VMSERVICE_SHARED_LIBRARY_NAME = "aot-vmservice-shared-library-name";
    static final String AUTOMATICALLY_REGISTER_PLUGINS_KEY = "automatically-register-plugins";
    private static final String DEFAULT_KERNEL_BLOB = "kernel_blob.bin";
    private static final String DEFAULT_LIBRARY = "libflutter.so";
    private static final String ENABLE_IMPELLER_META_DATA_KEY = "io.flutter.embedding.android.EnableImpeller";
    private static final String ENABLE_VULKAN_VALIDATION_META_DATA_KEY = "io.flutter.embedding.android.EnableVulkanValidation";
    static final String FLUTTER_ASSETS_DIR_KEY = "flutter-assets-dir";
    private static final String IMPELLER_BACKEND_META_DATA_KEY = "io.flutter.embedding.android.ImpellerBackend";
    private static final String IMPELLER_OPENGL_GPU_TRACING_DATA_KEY = "io.flutter.embedding.android.EnableOpenGLGPUTracing";
    static final String ISOLATE_SNAPSHOT_DATA_KEY = "isolate-snapshot-data";
    private static final String LEAK_VM_META_DATA_KEY = "io.flutter.embedding.android.LeakVM";
    private static final String OLD_GEN_HEAP_SIZE_META_DATA_KEY = "io.flutter.embedding.android.OldGenHeapSize";
    static final String SNAPSHOT_ASSET_PATH_KEY = "snapshot-asset-path";
    private static final String TAG = "FlutterLoader";
    private static final String VMSERVICE_SNAPSHOT_LIBRARY = "libvmservice_snapshot.so";
    static final String VM_SNAPSHOT_DATA_KEY = "vm-snapshot-data";
    private static FlutterLoader instance;
    private ExecutorService executorService;
    private FlutterApplicationInfo flutterApplicationInfo;
    private FlutterJNI flutterJNI;
    Future<InitResult> initResultFuture;
    private long initStartTimestampMillis;
    private boolean initialized;
    private Settings settings;

    public FlutterLoader() {
        this(FlutterInjector.instance().getFlutterJNIFactory().provideFlutterJNI());
    }

    public FlutterLoader(FlutterJNI flutterJNI) {
        this(flutterJNI, FlutterInjector.instance().executorService());
    }

    public FlutterLoader(FlutterJNI flutterJNI, ExecutorService executorService) {
        this.initialized = false;
        this.flutterJNI = flutterJNI;
        this.executorService = executorService;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class InitResult {
        final String appStoragePath;
        final String dataDirPath;
        final String engineCachesPath;

        /* synthetic */ InitResult(String x0, String x1, String x2, AnonymousClass1 x3) {
            this(x0, x1, x2);
        }

        private InitResult(String appStoragePath, String engineCachesPath, String dataDirPath) {
            this.appStoragePath = appStoragePath;
            this.engineCachesPath = engineCachesPath;
            this.dataDirPath = dataDirPath;
        }
    }

    public void startInitialization(Context applicationContext) {
        startInitialization(applicationContext, new Settings());
    }

    public void startInitialization(Context applicationContext, Settings settings) {
        VsyncWaiter waiter;
        if (this.settings != null) {
            return;
        }
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new IllegalStateException("startInitialization must be called on the main thread");
        }
        TraceSection e = TraceSection.scoped("FlutterLoader#startInitialization");
        try {
            Context appContext = applicationContext.getApplicationContext();
            this.settings = settings;
            this.initStartTimestampMillis = SystemClock.uptimeMillis();
            this.flutterApplicationInfo = ApplicationInfoLoader.load(appContext);
            if (Build.VERSION.SDK_INT >= 17) {
                DisplayManager dm = (DisplayManager) appContext.getSystemService(Constants.ScionAnalytics.MessageType.DISPLAY_NOTIFICATION);
                waiter = VsyncWaiter.getInstance(dm, this.flutterJNI);
            } else {
                float fps = ((WindowManager) appContext.getSystemService("window")).getDefaultDisplay().getRefreshRate();
                waiter = VsyncWaiter.getInstance(fps, this.flutterJNI);
            }
            waiter.init();
            this.initResultFuture = this.executorService.submit(new AnonymousClass1(appContext));
            if (e != null) {
                e.close();
            }
        } catch (Throwable th) {
            if (e != null) {
                try {
                    e.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: io.flutter.embedding.engine.loader.FlutterLoader$1  reason: invalid class name */
    /* loaded from: classes.dex */
    public class AnonymousClass1 implements Callable<InitResult> {
        final /* synthetic */ Context val$appContext;

        AnonymousClass1(Context context) {
            this.val$appContext = context;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public InitResult call() {
            TraceSection e = TraceSection.scoped("FlutterLoader initTask");
            try {
                ResourceExtractor resourceExtractor = FlutterLoader.this.initResources(this.val$appContext);
                FlutterLoader.this.flutterJNI.loadLibrary();
                FlutterLoader.this.flutterJNI.updateRefreshRate();
                FlutterLoader.this.executorService.execute(new Runnable() { // from class: io.flutter.embedding.engine.loader.FlutterLoader$1$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        FlutterLoader.AnonymousClass1.this.m135lambda$call$0$ioflutterembeddingengineloaderFlutterLoader$1();
                    }
                });
                if (resourceExtractor != null) {
                    resourceExtractor.waitForCompletion();
                }
                InitResult initResult = new InitResult(PathUtils.getFilesDir(this.val$appContext), PathUtils.getCacheDirectory(this.val$appContext), PathUtils.getDataDirectory(this.val$appContext), null);
                if (e != null) {
                    e.close();
                }
                return initResult;
            } catch (Throwable th) {
                if (e != null) {
                    try {
                        e.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: lambda$call$0$io-flutter-embedding-engine-loader-FlutterLoader$1  reason: not valid java name */
        public /* synthetic */ void m135lambda$call$0$ioflutterembeddingengineloaderFlutterLoader$1() {
            FlutterLoader.this.flutterJNI.prefetchDefaultFontManager();
        }
    }

    private static boolean areValidationLayersOnByDefault() {
        if (Build.VERSION.SDK_INT >= 26) {
            return Build.SUPPORTED_ABIS[0].equals("arm64-v8a");
        }
        return false;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:29:0x0178
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:81)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:47)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:39)
        */
    public void ensureInitializationComplete(android.content.Context r23, java.lang.String[] r24) {
        /*
            Method dump skipped, instructions count: 663
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flutter.embedding.engine.loader.FlutterLoader.ensureInitializationComplete(android.content.Context, java.lang.String[]):void");
    }

    private static boolean isLeakVM(Bundle metaData) {
        if (metaData == null) {
            return true;
        }
        return metaData.getBoolean(LEAK_VM_META_DATA_KEY, true);
    }

    public void ensureInitializationCompleteAsync(final Context applicationContext, final String[] args, final Handler callbackHandler, final Runnable callback) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new IllegalStateException("ensureInitializationComplete must be called on the main thread");
        }
        if (this.settings == null) {
            throw new IllegalStateException("ensureInitializationComplete must be called after startInitialization");
        }
        if (this.initialized) {
            callbackHandler.post(callback);
        } else {
            this.executorService.execute(new Runnable() { // from class: io.flutter.embedding.engine.loader.FlutterLoader$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    FlutterLoader.this.m134xa15f5dc1(applicationContext, args, callbackHandler, callback);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$ensureInitializationCompleteAsync$1$io-flutter-embedding-engine-loader-FlutterLoader  reason: not valid java name */
    public /* synthetic */ void m134xa15f5dc1(final Context applicationContext, final String[] args, final Handler callbackHandler, final Runnable callback) {
        try {
            this.initResultFuture.get();
            HandlerCompat.createAsyncHandler(Looper.getMainLooper()).post(new Runnable() { // from class: io.flutter.embedding.engine.loader.FlutterLoader$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    FlutterLoader.this.m133xafb5b7a2(applicationContext, args, callbackHandler, callback);
                }
            });
        } catch (Exception e) {
            Log.e(TAG, "Flutter initialization failed.", e);
            throw new RuntimeException(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$ensureInitializationCompleteAsync$0$io-flutter-embedding-engine-loader-FlutterLoader  reason: not valid java name */
    public /* synthetic */ void m133xafb5b7a2(Context applicationContext, String[] args, Handler callbackHandler, Runnable callback) {
        ensureInitializationComplete(applicationContext.getApplicationContext(), args);
        callbackHandler.post(callback);
    }

    public boolean initialized() {
        return this.initialized;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ResourceExtractor initResources(Context applicationContext) {
        String dataDirPath = PathUtils.getDataDirectory(applicationContext);
        String packageName = applicationContext.getPackageName();
        PackageManager packageManager = applicationContext.getPackageManager();
        AssetManager assetManager = applicationContext.getResources().getAssets();
        ResourceExtractor resourceExtractor = new ResourceExtractor(dataDirPath, packageName, packageManager, assetManager);
        resourceExtractor.addResource(fullAssetPathFrom(this.flutterApplicationInfo.vmSnapshotData)).addResource(fullAssetPathFrom(this.flutterApplicationInfo.isolateSnapshotData)).addResource(fullAssetPathFrom(DEFAULT_KERNEL_BLOB));
        resourceExtractor.start();
        return resourceExtractor;
    }

    public String findAppBundlePath() {
        return this.flutterApplicationInfo.flutterAssetsDir;
    }

    public String getLookupKeyForAsset(String asset) {
        return fullAssetPathFrom(asset);
    }

    public String getLookupKeyForAsset(String asset, String packageName) {
        return getLookupKeyForAsset("packages" + File.separator + packageName + File.separator + asset);
    }

    public boolean automaticallyRegisterPlugins() {
        return this.flutterApplicationInfo.automaticallyRegisterPlugins;
    }

    private String fullAssetPathFrom(String filePath) {
        return this.flutterApplicationInfo.flutterAssetsDir + File.separator + filePath;
    }

    /* loaded from: classes.dex */
    public static class Settings {
        private String logTag;

        public String getLogTag() {
            return this.logTag;
        }

        public void setLogTag(String tag) {
            this.logTag = tag;
        }
    }
}
