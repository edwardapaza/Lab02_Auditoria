package io.flutter.plugin.platform;

import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.SurfaceTexture;
import android.os.Build;
import android.view.Surface;
import io.flutter.Log;
import io.flutter.view.TextureRegistry;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes.dex */
public class SurfaceTexturePlatformViewRenderTarget implements PlatformViewRenderTarget {
    private static final String TAG = "SurfaceTexturePlatformViewRenderTarget";
    private final TextureRegistry.OnFrameConsumedListener frameConsumedListener;
    private boolean shouldRecreateSurfaceForLowMemory;
    private Surface surface;
    private SurfaceTexture surfaceTexture;
    private final TextureRegistry.SurfaceTextureEntry surfaceTextureEntry;
    private final TextureRegistry.OnTrimMemoryListener trimMemoryListener;
    private final AtomicLong pendingFramesCount = new AtomicLong(0);
    private int bufferWidth = 0;
    private int bufferHeight = 0;

    private void onFrameProduced() {
        if (Build.VERSION.SDK_INT == 29) {
            this.pendingFramesCount.incrementAndGet();
        }
    }

    private void recreateSurfaceIfNeeded() {
        if (!this.shouldRecreateSurfaceForLowMemory) {
            return;
        }
        Surface surface = this.surface;
        if (surface != null) {
            surface.release();
            this.surface = null;
        }
        this.surface = createSurface();
        this.shouldRecreateSurfaceForLowMemory = false;
    }

    protected Surface createSurface() {
        return new Surface(this.surfaceTexture);
    }

    private void init() {
        int i;
        int i2 = this.bufferWidth;
        if (i2 > 0 && (i = this.bufferHeight) > 0) {
            this.surfaceTexture.setDefaultBufferSize(i2, i);
        }
        Surface surface = this.surface;
        if (surface != null) {
            surface.release();
            this.surface = null;
        }
        this.surface = createSurface();
        Canvas canvas = lockHardwareCanvas();
        try {
            canvas.drawColor(0, PorterDuff.Mode.CLEAR);
        } finally {
            unlockCanvasAndPost(canvas);
        }
    }

    public SurfaceTexturePlatformViewRenderTarget(TextureRegistry.SurfaceTextureEntry surfaceTextureEntry) {
        TextureRegistry.OnFrameConsumedListener onFrameConsumedListener = new TextureRegistry.OnFrameConsumedListener() { // from class: io.flutter.plugin.platform.SurfaceTexturePlatformViewRenderTarget.1
            @Override // io.flutter.view.TextureRegistry.OnFrameConsumedListener
            public void onFrameConsumed() {
                if (Build.VERSION.SDK_INT == 29) {
                    SurfaceTexturePlatformViewRenderTarget.this.pendingFramesCount.decrementAndGet();
                }
            }
        };
        this.frameConsumedListener = onFrameConsumedListener;
        this.shouldRecreateSurfaceForLowMemory = false;
        TextureRegistry.OnTrimMemoryListener onTrimMemoryListener = new TextureRegistry.OnTrimMemoryListener() { // from class: io.flutter.plugin.platform.SurfaceTexturePlatformViewRenderTarget.2
            @Override // io.flutter.view.TextureRegistry.OnTrimMemoryListener
            public void onTrimMemory(int level) {
                if (level == 80 && Build.VERSION.SDK_INT >= 29) {
                    SurfaceTexturePlatformViewRenderTarget.this.shouldRecreateSurfaceForLowMemory = true;
                }
            }
        };
        this.trimMemoryListener = onTrimMemoryListener;
        if (Build.VERSION.SDK_INT < 23) {
            throw new UnsupportedOperationException("Platform views cannot be displayed below API level 23You can prevent this issue by setting `minSdkVersion: 23` in build.gradle.");
        }
        this.surfaceTextureEntry = surfaceTextureEntry;
        this.surfaceTexture = surfaceTextureEntry.surfaceTexture();
        surfaceTextureEntry.setOnFrameConsumedListener(onFrameConsumedListener);
        surfaceTextureEntry.setOnTrimMemoryListener(onTrimMemoryListener);
        init();
    }

    @Override // io.flutter.plugin.platform.PlatformViewRenderTarget
    public Canvas lockHardwareCanvas() {
        recreateSurfaceIfNeeded();
        if (Build.VERSION.SDK_INT != 29 || this.pendingFramesCount.get() <= 0) {
            SurfaceTexture surfaceTexture = this.surfaceTexture;
            if (surfaceTexture == null || surfaceTexture.isReleased()) {
                Log.e(TAG, "Invalid RenderTarget: null or already released SurfaceTexture");
                return null;
            }
            onFrameProduced();
            return this.surface.lockHardwareCanvas();
        }
        return null;
    }

    @Override // io.flutter.plugin.platform.PlatformViewRenderTarget
    public void unlockCanvasAndPost(Canvas canvas) {
        this.surface.unlockCanvasAndPost(canvas);
    }

    @Override // io.flutter.plugin.platform.PlatformViewRenderTarget
    public void resize(int width, int height) {
        this.bufferWidth = width;
        this.bufferHeight = height;
        SurfaceTexture surfaceTexture = this.surfaceTexture;
        if (surfaceTexture != null) {
            surfaceTexture.setDefaultBufferSize(width, height);
        }
    }

    @Override // io.flutter.plugin.platform.PlatformViewRenderTarget
    public int getWidth() {
        return this.bufferWidth;
    }

    @Override // io.flutter.plugin.platform.PlatformViewRenderTarget
    public int getHeight() {
        return this.bufferHeight;
    }

    @Override // io.flutter.plugin.platform.PlatformViewRenderTarget
    public long getId() {
        return this.surfaceTextureEntry.id();
    }

    @Override // io.flutter.plugin.platform.PlatformViewRenderTarget
    public boolean isReleased() {
        return this.surfaceTexture == null;
    }

    @Override // io.flutter.plugin.platform.PlatformViewRenderTarget
    public void release() {
        this.surfaceTexture = null;
        Surface surface = this.surface;
        if (surface != null) {
            surface.release();
            this.surface = null;
        }
    }

    @Override // io.flutter.plugin.platform.PlatformViewRenderTarget
    public Surface getSurface() {
        recreateSurfaceIfNeeded();
        return this.surface;
    }
}
