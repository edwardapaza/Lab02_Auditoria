package io.flutter.plugin.platform;

import android.graphics.Canvas;
import android.media.Image;
import android.media.ImageReader;
import android.os.Build;
import android.os.Handler;
import android.view.Surface;
import io.flutter.Log;
import io.flutter.view.TextureRegistry;
/* loaded from: classes.dex */
public class ImageReaderPlatformViewRenderTarget implements PlatformViewRenderTarget {
    private static final int MAX_IMAGES = 4;
    private static final String TAG = "ImageReaderPlatformViewRenderTarget";
    private ImageReader reader;
    private TextureRegistry.ImageTextureEntry textureEntry;
    private int bufferWidth = 0;
    private int bufferHeight = 0;
    private final Handler onImageAvailableHandler = new Handler();
    private final ImageReader.OnImageAvailableListener onImageAvailableListener = new ImageReader.OnImageAvailableListener() { // from class: io.flutter.plugin.platform.ImageReaderPlatformViewRenderTarget.1
        @Override // android.media.ImageReader.OnImageAvailableListener
        public void onImageAvailable(ImageReader reader) {
            Image image = null;
            try {
                image = reader.acquireLatestImage();
            } catch (IllegalStateException e) {
                Log.e(ImageReaderPlatformViewRenderTarget.TAG, "onImageAvailable acquireLatestImage failed: " + e.toString());
            }
            if (image != null) {
                ImageReaderPlatformViewRenderTarget.this.textureEntry.pushImage(image);
            }
        }
    };

    private void closeReader() {
        if (this.reader != null) {
            this.textureEntry.pushImage(null);
            this.reader.close();
            this.reader = null;
        }
    }

    protected ImageReader createImageReader33() {
        ImageReader.Builder builder = new ImageReader.Builder(this.bufferWidth, this.bufferHeight);
        builder.setMaxImages(4);
        builder.setImageFormat(34);
        builder.setUsage(256L);
        ImageReader reader = builder.build();
        reader.setOnImageAvailableListener(this.onImageAvailableListener, this.onImageAvailableHandler);
        return reader;
    }

    protected ImageReader createImageReader29() {
        ImageReader reader = ImageReader.newInstance(this.bufferWidth, this.bufferHeight, 34, 4, 256L);
        reader.setOnImageAvailableListener(this.onImageAvailableListener, this.onImageAvailableHandler);
        return reader;
    }

    protected ImageReader createImageReader() {
        if (Build.VERSION.SDK_INT >= 33) {
            return createImageReader33();
        }
        if (Build.VERSION.SDK_INT >= 29) {
            return createImageReader29();
        }
        throw new UnsupportedOperationException("ImageReaderPlatformViewRenderTarget requires API version 29+");
    }

    public ImageReaderPlatformViewRenderTarget(TextureRegistry.ImageTextureEntry textureEntry) {
        if (Build.VERSION.SDK_INT < 29) {
            throw new UnsupportedOperationException("ImageReaderPlatformViewRenderTarget requires API version 29+");
        }
        this.textureEntry = textureEntry;
    }

    @Override // io.flutter.plugin.platform.PlatformViewRenderTarget
    public void resize(int width, int height) {
        if (this.reader != null && this.bufferWidth == width && this.bufferHeight == height) {
            return;
        }
        closeReader();
        this.bufferWidth = width;
        this.bufferHeight = height;
        this.reader = createImageReader();
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
    public Canvas lockHardwareCanvas() {
        return getSurface().lockHardwareCanvas();
    }

    @Override // io.flutter.plugin.platform.PlatformViewRenderTarget
    public void unlockCanvasAndPost(Canvas canvas) {
        getSurface().unlockCanvasAndPost(canvas);
    }

    @Override // io.flutter.plugin.platform.PlatformViewRenderTarget
    public long getId() {
        return this.textureEntry.id();
    }

    @Override // io.flutter.plugin.platform.PlatformViewRenderTarget
    public void release() {
        closeReader();
        this.textureEntry = null;
    }

    @Override // io.flutter.plugin.platform.PlatformViewRenderTarget
    public boolean isReleased() {
        return this.textureEntry == null;
    }

    @Override // io.flutter.plugin.platform.PlatformViewRenderTarget
    public Surface getSurface() {
        return this.reader.getSurface();
    }
}
