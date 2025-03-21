package io.flutter.view;

import android.graphics.SurfaceTexture;
import android.media.Image;
import android.view.Surface;
/* loaded from: classes.dex */
public interface TextureRegistry {

    /* loaded from: classes.dex */
    public interface ImageConsumer extends TextureEntry {
        Image acquireLatestImage();
    }

    /* loaded from: classes.dex */
    public interface ImageTextureEntry extends TextureEntry {
        @Override // io.flutter.view.TextureRegistry.TextureEntry
        long id();

        void pushImage(Image image);

        @Override // io.flutter.view.TextureRegistry.TextureEntry
        void release();
    }

    /* loaded from: classes.dex */
    public interface OnFrameConsumedListener {
        void onFrameConsumed();
    }

    /* loaded from: classes.dex */
    public interface OnTrimMemoryListener {
        void onTrimMemory(int i);
    }

    /* loaded from: classes.dex */
    public interface SurfaceProducer extends TextureEntry {
        int getHeight();

        Surface getSurface();

        int getWidth();

        @Override // io.flutter.view.TextureRegistry.TextureEntry
        long id();

        @Override // io.flutter.view.TextureRegistry.TextureEntry
        void release();

        void setSize(int i, int i2);
    }

    /* loaded from: classes.dex */
    public interface TextureEntry {
        long id();

        void release();
    }

    ImageTextureEntry createImageTexture();

    SurfaceProducer createSurfaceProducer();

    SurfaceTextureEntry createSurfaceTexture();

    void onTrimMemory(int i);

    SurfaceTextureEntry registerSurfaceTexture(SurfaceTexture surfaceTexture);

    /* renamed from: io.flutter.view.TextureRegistry$-CC  reason: invalid class name */
    /* loaded from: classes.dex */
    public final /* synthetic */ class CC {
        public static void $default$onTrimMemory(TextureRegistry _this, int level) {
        }
    }

    /* loaded from: classes.dex */
    public interface SurfaceTextureEntry extends TextureEntry {
        @Override // io.flutter.view.TextureRegistry.TextureEntry
        long id();

        @Override // io.flutter.view.TextureRegistry.TextureEntry
        void release();

        void setOnFrameConsumedListener(OnFrameConsumedListener onFrameConsumedListener);

        void setOnTrimMemoryListener(OnTrimMemoryListener onTrimMemoryListener);

        SurfaceTexture surfaceTexture();

        /* renamed from: io.flutter.view.TextureRegistry$SurfaceTextureEntry$-CC  reason: invalid class name */
        /* loaded from: classes.dex */
        public final /* synthetic */ class CC {
            public static void $default$setOnFrameConsumedListener(SurfaceTextureEntry _this, OnFrameConsumedListener listener) {
            }

            public static void $default$setOnTrimMemoryListener(SurfaceTextureEntry _this, OnTrimMemoryListener listener) {
            }
        }
    }
}
