package io.flutter.embedding.engine;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.ColorSpace;
import android.graphics.ImageDecoder;
import android.os.Build;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.util.Size;
import android.util.TypedValue;
import android.view.Surface;
import io.flutter.embedding.engine.a;
import io.flutter.embedding.engine.mutatorsstack.FlutterMutatorsStack;
import io.flutter.embedding.engine.renderer.SurfaceTextureWrapper;
import io.flutter.plugin.platform.w;
import io.flutter.view.FlutterCallbackInformation;
import io.flutter.view.TextureRegistry;
import io.flutter.view.h;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import z2.p;
/* loaded from: classes.dex */
public class FlutterJNI {
    private static final String TAG = "FlutterJNI";
    private static b asyncWaitForVsyncDelegate = null;
    private static float displayDensity = -1.0f;
    private static float displayHeight = -1.0f;
    private static float displayWidth = -1.0f;
    private static boolean initCalled = false;
    private static boolean loadLibraryCalled = false;
    private static boolean prefetchDefaultFontManagerCalled = false;
    private static float refreshRateFPS = 60.0f;
    private static String vmServiceUri;
    private a accessibilityDelegate;
    private p2.a deferredComponentManager;
    private a3.b localizationPlugin;
    private Long nativeShellHolderId;
    private o2.d platformMessageHandler;
    private w platformViewsController;
    private ReentrantReadWriteLock shellHolderLock = new ReentrantReadWriteLock();
    private final Set<a.b> engineLifecycleListeners = new CopyOnWriteArraySet();
    private final Set<io.flutter.embedding.engine.renderer.d> flutterUiDisplayListeners = new CopyOnWriteArraySet();
    private final Looper mainLooper = Looper.getMainLooper();

    /* loaded from: classes.dex */
    public interface a {
        void b(ByteBuffer byteBuffer, String[] strArr, ByteBuffer[] byteBufferArr);

        void c(ByteBuffer byteBuffer, String[] strArr);
    }

    /* loaded from: classes.dex */
    public interface b {
        void a(long j5);
    }

    /* loaded from: classes.dex */
    public static class c {
        public FlutterJNI a() {
            return new FlutterJNI();
        }
    }

    private static void asyncWaitForVsync(long j5) {
        b bVar = asyncWaitForVsyncDelegate;
        if (bVar == null) {
            throw new IllegalStateException("An AsyncWaitForVsyncDelegate must be registered with FlutterJNI before asyncWaitForVsync() is invoked.");
        }
        bVar.a(j5);
    }

    public static Bitmap decodeImage(ByteBuffer byteBuffer, final long j5) {
        if (Build.VERSION.SDK_INT >= 28) {
            try {
                return ImageDecoder.decodeBitmap(ImageDecoder.createSource(byteBuffer), new ImageDecoder.OnHeaderDecodedListener() { // from class: io.flutter.embedding.engine.f
                    public final void onHeaderDecoded(ImageDecoder imageDecoder, ImageDecoder.ImageInfo imageInfo, ImageDecoder.Source source) {
                        FlutterJNI.lambda$decodeImage$0(j5, imageDecoder, imageInfo, source);
                    }
                });
            } catch (IOException e5) {
                n2.b.c(TAG, "Failed to decode image", e5);
            }
        }
        return null;
    }

    private void ensureAttachedToNative() {
        if (this.nativeShellHolderId == null) {
            throw new RuntimeException("Cannot execute operation because FlutterJNI is not attached to native.");
        }
    }

    private void ensureNotAttachedToNative() {
        if (this.nativeShellHolderId != null) {
            throw new RuntimeException("Cannot execute operation because FlutterJNI is attached to native.");
        }
    }

    private void ensureRunningOnMainThread() {
        if (Looper.myLooper() == this.mainLooper) {
            return;
        }
        throw new RuntimeException("Methods marked with @UiThread must be executed on the main thread. Current thread: " + Thread.currentThread().getName());
    }

    @Deprecated
    public static String getObservatoryUri() {
        return vmServiceUri;
    }

    public static String getVMServiceUri() {
        return vmServiceUri;
    }

    private void handlePlatformMessageResponse(int i5, ByteBuffer byteBuffer) {
        o2.d dVar = this.platformMessageHandler;
        if (dVar != null) {
            dVar.d(i5, byteBuffer);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$decodeImage$0(long j5, ImageDecoder imageDecoder, ImageDecoder.ImageInfo imageInfo, ImageDecoder.Source source) {
        imageDecoder.setTargetColorSpace(ColorSpace.get(ColorSpace.Named.SRGB));
        imageDecoder.setAllocator(1);
        Size size = imageInfo.getSize();
        nativeImageHeaderCallback(j5, size.getWidth(), size.getHeight());
    }

    private native long nativeAttach(FlutterJNI flutterJNI);

    private native void nativeCleanupMessageData(long j5);

    private native void nativeDeferredComponentInstallFailure(int i5, String str, boolean z4);

    private native void nativeDestroy(long j5);

    private native void nativeDispatchEmptyPlatformMessage(long j5, String str, int i5);

    private native void nativeDispatchPlatformMessage(long j5, String str, ByteBuffer byteBuffer, int i5, int i6);

    private native void nativeDispatchPointerDataPacket(long j5, ByteBuffer byteBuffer, int i5);

    private native void nativeDispatchSemanticsAction(long j5, int i5, int i6, ByteBuffer byteBuffer, int i7);

    private native boolean nativeFlutterTextUtilsIsEmoji(int i5);

    private native boolean nativeFlutterTextUtilsIsEmojiModifier(int i5);

    private native boolean nativeFlutterTextUtilsIsEmojiModifierBase(int i5);

    private native boolean nativeFlutterTextUtilsIsRegionalIndicator(int i5);

    private native boolean nativeFlutterTextUtilsIsVariationSelector(int i5);

    private native Bitmap nativeGetBitmap(long j5);

    private native boolean nativeGetIsSoftwareRenderingEnabled();

    public static native void nativeImageHeaderCallback(long j5, int i5, int i6);

    private static native void nativeInit(Context context, String[] strArr, String str, String str2, String str3, long j5);

    private native void nativeInvokePlatformMessageEmptyResponseCallback(long j5, int i5);

    private native void nativeInvokePlatformMessageResponseCallback(long j5, int i5, ByteBuffer byteBuffer, int i6);

    private native void nativeLoadDartDeferredLibrary(long j5, int i5, String[] strArr);

    @Deprecated
    public static native FlutterCallbackInformation nativeLookupCallbackInformation(long j5);

    private native void nativeMarkTextureFrameAvailable(long j5, long j6);

    private native void nativeNotifyLowMemoryWarning(long j5);

    private native void nativeOnVsync(long j5, long j6, long j7);

    private static native void nativePrefetchDefaultFontManager();

    private native void nativeRegisterImageTexture(long j5, long j6, WeakReference<TextureRegistry.ImageConsumer> weakReference);

    private native void nativeRegisterTexture(long j5, long j6, WeakReference<SurfaceTextureWrapper> weakReference);

    private native void nativeRunBundleAndSnapshotFromLibrary(long j5, String str, String str2, String str3, AssetManager assetManager, List<String> list);

    private native void nativeScheduleFrame(long j5);

    private native void nativeSetAccessibilityFeatures(long j5, int i5);

    private native void nativeSetSemanticsEnabled(long j5, boolean z4);

    private native void nativeSetViewportMetrics(long j5, float f5, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, int i19, int[] iArr, int[] iArr2, int[] iArr3);

    private native FlutterJNI nativeSpawn(long j5, String str, String str2, String str3, List<String> list);

    private native void nativeSurfaceChanged(long j5, int i5, int i6);

    private native void nativeSurfaceCreated(long j5, Surface surface);

    private native void nativeSurfaceDestroyed(long j5);

    private native void nativeSurfaceWindowChanged(long j5, Surface surface);

    private native void nativeUnregisterTexture(long j5, long j6);

    private native void nativeUpdateDisplayMetrics(long j5);

    private native void nativeUpdateJavaAssetManager(long j5, AssetManager assetManager, String str);

    private native void nativeUpdateRefreshRate(float f5);

    private void onPreEngineRestart() {
        for (a.b bVar : this.engineLifecycleListeners) {
            bVar.b();
        }
    }

    private void updateCustomAccessibilityActions(ByteBuffer byteBuffer, String[] strArr) {
        ensureRunningOnMainThread();
        a aVar = this.accessibilityDelegate;
        if (aVar != null) {
            aVar.c(byteBuffer, strArr);
        }
    }

    private void updateSemantics(ByteBuffer byteBuffer, String[] strArr, ByteBuffer[] byteBufferArr) {
        ensureRunningOnMainThread();
        a aVar = this.accessibilityDelegate;
        if (aVar != null) {
            aVar.b(byteBuffer, strArr, byteBufferArr);
        }
    }

    public void addEngineLifecycleListener(a.b bVar) {
        ensureRunningOnMainThread();
        this.engineLifecycleListeners.add(bVar);
    }

    public void addIsDisplayingFlutterUiListener(io.flutter.embedding.engine.renderer.d dVar) {
        ensureRunningOnMainThread();
        this.flutterUiDisplayListeners.add(dVar);
    }

    public void attachToNative() {
        ensureRunningOnMainThread();
        ensureNotAttachedToNative();
        this.shellHolderLock.writeLock().lock();
        try {
            this.nativeShellHolderId = Long.valueOf(performNativeAttach(this));
        } finally {
            this.shellHolderLock.writeLock().unlock();
        }
    }

    public void cleanupMessageData(long j5) {
        nativeCleanupMessageData(j5);
    }

    public String[] computePlatformResolvedLocale(String[] strArr) {
        if (this.localizationPlugin == null) {
            return new String[0];
        }
        ArrayList arrayList = new ArrayList();
        for (int i5 = 0; i5 < strArr.length; i5 += 3) {
            String str = strArr[i5 + 0];
            String str2 = strArr[i5 + 1];
            String str3 = strArr[i5 + 2];
            Locale.Builder builder = new Locale.Builder();
            if (!str.isEmpty()) {
                builder.setLanguage(str);
            }
            if (!str2.isEmpty()) {
                builder.setRegion(str2);
            }
            if (!str3.isEmpty()) {
                builder.setScript(str3);
            }
            arrayList.add(builder.build());
        }
        Locale c5 = this.localizationPlugin.c(arrayList);
        return c5 == null ? new String[0] : new String[]{c5.getLanguage(), c5.getCountry(), c5.getScript()};
    }

    public FlutterOverlaySurface createOverlaySurface() {
        ensureRunningOnMainThread();
        w wVar = this.platformViewsController;
        if (wVar != null) {
            return wVar.K();
        }
        throw new RuntimeException("platformViewsController must be set before attempting to position an overlay surface");
    }

    public void deferredComponentInstallFailure(int i5, String str, boolean z4) {
        ensureRunningOnMainThread();
        nativeDeferredComponentInstallFailure(i5, str, z4);
    }

    public void destroyOverlaySurfaces() {
        ensureRunningOnMainThread();
        w wVar = this.platformViewsController;
        if (wVar == null) {
            throw new RuntimeException("platformViewsController must be set before attempting to destroy an overlay surface");
        }
        wVar.N();
    }

    public void detachFromNativeAndReleaseResources() {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        this.shellHolderLock.writeLock().lock();
        try {
            nativeDestroy(this.nativeShellHolderId.longValue());
            this.nativeShellHolderId = null;
        } finally {
            this.shellHolderLock.writeLock().unlock();
        }
    }

    public void dispatchEmptyPlatformMessage(String str, int i5) {
        ensureRunningOnMainThread();
        if (isAttached()) {
            nativeDispatchEmptyPlatformMessage(this.nativeShellHolderId.longValue(), str, i5);
            return;
        }
        n2.b.g(TAG, "Tried to send a platform message to Flutter, but FlutterJNI was detached from native C++. Could not send. Channel: " + str + ". Response ID: " + i5);
    }

    public void dispatchPlatformMessage(String str, ByteBuffer byteBuffer, int i5, int i6) {
        ensureRunningOnMainThread();
        if (isAttached()) {
            nativeDispatchPlatformMessage(this.nativeShellHolderId.longValue(), str, byteBuffer, i5, i6);
            return;
        }
        n2.b.g(TAG, "Tried to send a platform message to Flutter, but FlutterJNI was detached from native C++. Could not send. Channel: " + str + ". Response ID: " + i6);
    }

    public void dispatchPointerDataPacket(ByteBuffer byteBuffer, int i5) {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeDispatchPointerDataPacket(this.nativeShellHolderId.longValue(), byteBuffer, i5);
    }

    public void dispatchSemanticsAction(int i5, int i6, ByteBuffer byteBuffer, int i7) {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeDispatchSemanticsAction(this.nativeShellHolderId.longValue(), i5, i6, byteBuffer, i7);
    }

    public void dispatchSemanticsAction(int i5, h.g gVar) {
        dispatchSemanticsAction(i5, gVar, null);
    }

    public void dispatchSemanticsAction(int i5, h.g gVar, Object obj) {
        ByteBuffer byteBuffer;
        int i6;
        ensureAttachedToNative();
        if (obj != null) {
            byteBuffer = p.f9015a.a(obj);
            i6 = byteBuffer.position();
        } else {
            byteBuffer = null;
            i6 = 0;
        }
        dispatchSemanticsAction(i5, gVar.f4257a, byteBuffer, i6);
    }

    public Bitmap getBitmap() {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        return nativeGetBitmap(this.nativeShellHolderId.longValue());
    }

    public boolean getIsSoftwareRenderingEnabled() {
        return nativeGetIsSoftwareRenderingEnabled();
    }

    public float getScaledFontSize(float f5, int i5) {
        DisplayMetrics b5 = y2.p.b(i5);
        if (b5 == null) {
            n2.b.b(TAG, "getScaledFontSize called with configurationId " + String.valueOf(i5) + ", which can't be found.");
            return -1.0f;
        }
        return TypedValue.applyDimension(2, f5, b5) / b5.density;
    }

    public void handlePlatformMessage(String str, ByteBuffer byteBuffer, int i5, long j5) {
        o2.d dVar = this.platformMessageHandler;
        if (dVar != null) {
            dVar.f(str, byteBuffer, i5, j5);
        } else {
            nativeCleanupMessageData(j5);
        }
    }

    public void init(Context context, String[] strArr, String str, String str2, String str3, long j5) {
        if (initCalled) {
            n2.b.g(TAG, "FlutterJNI.init called more than once");
        }
        nativeInit(context, strArr, str, str2, str3, j5);
        initCalled = true;
    }

    public void invokePlatformMessageEmptyResponseCallback(int i5) {
        this.shellHolderLock.readLock().lock();
        try {
            if (isAttached()) {
                nativeInvokePlatformMessageEmptyResponseCallback(this.nativeShellHolderId.longValue(), i5);
            } else {
                n2.b.g(TAG, "Tried to send a platform message response, but FlutterJNI was detached from native C++. Could not send. Response ID: " + i5);
            }
        } finally {
            this.shellHolderLock.readLock().unlock();
        }
    }

    public void invokePlatformMessageResponseCallback(int i5, ByteBuffer byteBuffer, int i6) {
        if (!byteBuffer.isDirect()) {
            throw new IllegalArgumentException("Expected a direct ByteBuffer.");
        }
        this.shellHolderLock.readLock().lock();
        try {
            if (isAttached()) {
                nativeInvokePlatformMessageResponseCallback(this.nativeShellHolderId.longValue(), i5, byteBuffer, i6);
            } else {
                n2.b.g(TAG, "Tried to send a platform message response, but FlutterJNI was detached from native C++. Could not send. Response ID: " + i5);
            }
        } finally {
            this.shellHolderLock.readLock().unlock();
        }
    }

    public boolean isAttached() {
        return this.nativeShellHolderId != null;
    }

    public boolean isCodePointEmoji(int i5) {
        return nativeFlutterTextUtilsIsEmoji(i5);
    }

    public boolean isCodePointEmojiModifier(int i5) {
        return nativeFlutterTextUtilsIsEmojiModifier(i5);
    }

    public boolean isCodePointEmojiModifierBase(int i5) {
        return nativeFlutterTextUtilsIsEmojiModifierBase(i5);
    }

    public boolean isCodePointRegionalIndicator(int i5) {
        return nativeFlutterTextUtilsIsRegionalIndicator(i5);
    }

    public boolean isCodePointVariantSelector(int i5) {
        return nativeFlutterTextUtilsIsVariationSelector(i5);
    }

    public void loadDartDeferredLibrary(int i5, String[] strArr) {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeLoadDartDeferredLibrary(this.nativeShellHolderId.longValue(), i5, strArr);
    }

    public void loadLibrary() {
        if (loadLibraryCalled) {
            n2.b.g(TAG, "FlutterJNI.loadLibrary called more than once");
        }
        System.loadLibrary("flutter");
        loadLibraryCalled = true;
    }

    public void markTextureFrameAvailable(long j5) {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeMarkTextureFrameAvailable(this.nativeShellHolderId.longValue(), j5);
    }

    public void notifyLowMemoryWarning() {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeNotifyLowMemoryWarning(this.nativeShellHolderId.longValue());
    }

    public void onBeginFrame() {
        ensureRunningOnMainThread();
        w wVar = this.platformViewsController;
        if (wVar == null) {
            throw new RuntimeException("platformViewsController must be set before attempting to begin the frame");
        }
        wVar.h0();
    }

    public void onDisplayOverlaySurface(int i5, int i6, int i7, int i8, int i9) {
        ensureRunningOnMainThread();
        w wVar = this.platformViewsController;
        if (wVar == null) {
            throw new RuntimeException("platformViewsController must be set before attempting to position an overlay surface");
        }
        wVar.j0(i5, i6, i7, i8, i9);
    }

    public void onDisplayPlatformView(int i5, int i6, int i7, int i8, int i9, int i10, int i11, FlutterMutatorsStack flutterMutatorsStack) {
        ensureRunningOnMainThread();
        w wVar = this.platformViewsController;
        if (wVar == null) {
            throw new RuntimeException("platformViewsController must be set before attempting to position a platform view");
        }
        wVar.k0(i5, i6, i7, i8, i9, i10, i11, flutterMutatorsStack);
    }

    public void onEndFrame() {
        ensureRunningOnMainThread();
        w wVar = this.platformViewsController;
        if (wVar == null) {
            throw new RuntimeException("platformViewsController must be set before attempting to end the frame");
        }
        wVar.l0();
    }

    public void onFirstFrame() {
        ensureRunningOnMainThread();
        for (io.flutter.embedding.engine.renderer.d dVar : this.flutterUiDisplayListeners) {
            dVar.f();
        }
    }

    void onRenderingStopped() {
        ensureRunningOnMainThread();
        for (io.flutter.embedding.engine.renderer.d dVar : this.flutterUiDisplayListeners) {
            dVar.c();
        }
    }

    public void onSurfaceChanged(int i5, int i6) {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeSurfaceChanged(this.nativeShellHolderId.longValue(), i5, i6);
    }

    public void onSurfaceCreated(Surface surface) {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeSurfaceCreated(this.nativeShellHolderId.longValue(), surface);
    }

    public void onSurfaceDestroyed() {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        onRenderingStopped();
        nativeSurfaceDestroyed(this.nativeShellHolderId.longValue());
    }

    public void onSurfaceWindowChanged(Surface surface) {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeSurfaceWindowChanged(this.nativeShellHolderId.longValue(), surface);
    }

    public void onVsync(long j5, long j6, long j7) {
        nativeOnVsync(j5, j6, j7);
    }

    public long performNativeAttach(FlutterJNI flutterJNI) {
        return nativeAttach(flutterJNI);
    }

    public void prefetchDefaultFontManager() {
        if (prefetchDefaultFontManagerCalled) {
            n2.b.g(TAG, "FlutterJNI.prefetchDefaultFontManager called more than once");
        }
        nativePrefetchDefaultFontManager();
        prefetchDefaultFontManagerCalled = true;
    }

    public void registerImageTexture(long j5, TextureRegistry.ImageConsumer imageConsumer) {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeRegisterImageTexture(this.nativeShellHolderId.longValue(), j5, new WeakReference<>(imageConsumer));
    }

    public void registerTexture(long j5, SurfaceTextureWrapper surfaceTextureWrapper) {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeRegisterTexture(this.nativeShellHolderId.longValue(), j5, new WeakReference<>(surfaceTextureWrapper));
    }

    public void removeEngineLifecycleListener(a.b bVar) {
        ensureRunningOnMainThread();
        this.engineLifecycleListeners.remove(bVar);
    }

    public void removeIsDisplayingFlutterUiListener(io.flutter.embedding.engine.renderer.d dVar) {
        ensureRunningOnMainThread();
        this.flutterUiDisplayListeners.remove(dVar);
    }

    public void requestDartDeferredLibrary(int i5) {
        p2.a aVar = this.deferredComponentManager;
        if (aVar != null) {
            aVar.d(i5, null);
        } else {
            n2.b.b(TAG, "No DeferredComponentManager found. Android setup must be completed before using split AOT deferred components.");
        }
    }

    public void runBundleAndSnapshotFromLibrary(String str, String str2, String str3, AssetManager assetManager, List<String> list) {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeRunBundleAndSnapshotFromLibrary(this.nativeShellHolderId.longValue(), str, str2, str3, assetManager, list);
    }

    public void scheduleFrame() {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeScheduleFrame(this.nativeShellHolderId.longValue());
    }

    public void setAccessibilityDelegate(a aVar) {
        ensureRunningOnMainThread();
        this.accessibilityDelegate = aVar;
    }

    public void setAccessibilityFeatures(int i5) {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeSetAccessibilityFeatures(this.nativeShellHolderId.longValue(), i5);
    }

    public void setAsyncWaitForVsyncDelegate(b bVar) {
        asyncWaitForVsyncDelegate = bVar;
    }

    public void setDeferredComponentManager(p2.a aVar) {
        ensureRunningOnMainThread();
        this.deferredComponentManager = aVar;
        if (aVar != null) {
            aVar.c(this);
        }
    }

    public void setLocalizationPlugin(a3.b bVar) {
        ensureRunningOnMainThread();
        this.localizationPlugin = bVar;
    }

    public void setPlatformMessageHandler(o2.d dVar) {
        ensureRunningOnMainThread();
        this.platformMessageHandler = dVar;
    }

    public void setPlatformViewsController(w wVar) {
        ensureRunningOnMainThread();
        this.platformViewsController = wVar;
    }

    public void setRefreshRateFPS(float f5) {
        refreshRateFPS = f5;
        updateRefreshRate();
    }

    public void setSemanticsEnabled(boolean z4) {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeSetSemanticsEnabled(this.nativeShellHolderId.longValue(), z4);
    }

    public void setViewportMetrics(float f5, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, int i19, int[] iArr, int[] iArr2, int[] iArr3) {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeSetViewportMetrics(this.nativeShellHolderId.longValue(), f5, i5, i6, i7, i8, i9, i10, i11, i12, i13, i14, i15, i16, i17, i18, i19, iArr, iArr2, iArr3);
    }

    public FlutterJNI spawn(String str, String str2, String str3, List<String> list) {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        FlutterJNI nativeSpawn = nativeSpawn(this.nativeShellHolderId.longValue(), str, str2, str3, list);
        Long l5 = nativeSpawn.nativeShellHolderId;
        h3.c.a((l5 == null || l5.longValue() == 0) ? false : true, "Failed to spawn new JNI connected shell from existing shell.");
        return nativeSpawn;
    }

    public void unregisterTexture(long j5) {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeUnregisterTexture(this.nativeShellHolderId.longValue(), j5);
    }

    public void updateDisplayMetrics(int i5, float f5, float f6, float f7) {
        displayWidth = f5;
        displayHeight = f6;
        displayDensity = f7;
        if (loadLibraryCalled) {
            nativeUpdateDisplayMetrics(this.nativeShellHolderId.longValue());
        }
    }

    public void updateJavaAssetManager(AssetManager assetManager, String str) {
        ensureRunningOnMainThread();
        ensureAttachedToNative();
        nativeUpdateJavaAssetManager(this.nativeShellHolderId.longValue(), assetManager, str);
    }

    public void updateRefreshRate() {
        if (loadLibraryCalled) {
            nativeUpdateRefreshRate(refreshRateFPS);
        }
    }
}
