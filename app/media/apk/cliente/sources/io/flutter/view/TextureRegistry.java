package io.flutter.view;

import android.graphics.SurfaceTexture;
import android.media.Image;
import android.view.Surface;
/* loaded from: classes.dex */
public interface TextureRegistry {

    /* loaded from: classes.dex */
    public interface GLTextureConsumer {
        SurfaceTexture getSurfaceTexture();
    }

    /* loaded from: classes.dex */
    public interface ImageConsumer {
        Image acquireLatestImage();
    }

    /* loaded from: classes.dex */
    public interface ImageTextureEntry {
        /* synthetic */ long id();

        void pushImage(Image image);

        /* synthetic */ void release();
    }

    /* loaded from: classes.dex */
    public interface SurfaceProducer {

        /* loaded from: classes.dex */
        public interface a {
            void a();

            void b();
        }

        int getHeight();

        Surface getSurface();

        int getWidth();

        /* synthetic */ long id();

        /* synthetic */ void release();

        void scheduleFrame();

        void setCallback(a aVar);

        void setSize(int i5, int i6);
    }

    /* loaded from: classes.dex */
    public interface SurfaceTextureEntry {
        /* synthetic */ long id();

        /* synthetic */ void release();

        void setOnFrameConsumedListener(a aVar);

        void setOnTrimMemoryListener(b bVar);

        SurfaceTexture surfaceTexture();
    }

    /* loaded from: classes.dex */
    public interface a {
        void a();
    }

    /* loaded from: classes.dex */
    public interface b {
        void onTrimMemory(int i5);
    }

    ImageTextureEntry a();

    SurfaceProducer b();

    SurfaceTextureEntry c();
}
