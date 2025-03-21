package io.flutter.embedding.engine.renderer;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.hardware.SyncFence;
import android.media.Image;
import android.media.ImageReader;
import android.os.Build;
import android.os.Handler;
import android.view.Surface;
import io.flutter.Log;
import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.view.TextureRegistry;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes.dex */
public class FlutterRenderer implements TextureRegistry {
    private static final String TAG = "FlutterRenderer";
    private final FlutterJNI flutterJNI;
    private final FlutterUiDisplayListener flutterUiDisplayListener;
    private Surface surface;
    private final AtomicLong nextTextureId = new AtomicLong(0);
    private boolean isDisplayingFlutterUi = false;
    private int isRenderingToImageViewCount = 0;
    private Handler handler = new Handler();
    private final Set<WeakReference<TextureRegistry.OnTrimMemoryListener>> onTrimMemoryListeners = new HashSet();

    public FlutterRenderer(FlutterJNI flutterJNI) {
        FlutterUiDisplayListener flutterUiDisplayListener = new FlutterUiDisplayListener() { // from class: io.flutter.embedding.engine.renderer.FlutterRenderer.1
            @Override // io.flutter.embedding.engine.renderer.FlutterUiDisplayListener
            public void onFlutterUiDisplayed() {
                FlutterRenderer.this.isDisplayingFlutterUi = true;
            }

            @Override // io.flutter.embedding.engine.renderer.FlutterUiDisplayListener
            public void onFlutterUiNoLongerDisplayed() {
                FlutterRenderer.this.isDisplayingFlutterUi = false;
            }
        };
        this.flutterUiDisplayListener = flutterUiDisplayListener;
        this.flutterJNI = flutterJNI;
        flutterJNI.addIsDisplayingFlutterUiListener(flutterUiDisplayListener);
    }

    public boolean isDisplayingFlutterUi() {
        return this.isDisplayingFlutterUi;
    }

    public void SetRenderingToImageView(boolean value) {
        if (value) {
            this.isRenderingToImageViewCount++;
        } else {
            this.isRenderingToImageViewCount--;
        }
        this.flutterJNI.SetIsRenderingToImageView(this.isRenderingToImageViewCount > 0);
    }

    public void addIsDisplayingFlutterUiListener(FlutterUiDisplayListener listener) {
        this.flutterJNI.addIsDisplayingFlutterUiListener(listener);
        if (this.isDisplayingFlutterUi) {
            listener.onFlutterUiDisplayed();
        }
    }

    public void removeIsDisplayingFlutterUiListener(FlutterUiDisplayListener listener) {
        this.flutterJNI.removeIsDisplayingFlutterUiListener(listener);
    }

    private void clearDeadListeners() {
        Iterator<WeakReference<TextureRegistry.OnTrimMemoryListener>> iterator = this.onTrimMemoryListeners.iterator();
        while (iterator.hasNext()) {
            WeakReference<TextureRegistry.OnTrimMemoryListener> listenerRef = iterator.next();
            TextureRegistry.OnTrimMemoryListener listener = listenerRef.get();
            if (listener == null) {
                iterator.remove();
            }
        }
    }

    void addOnTrimMemoryListener(TextureRegistry.OnTrimMemoryListener listener) {
        clearDeadListeners();
        this.onTrimMemoryListeners.add(new WeakReference<>(listener));
    }

    void removeOnTrimMemoryListener(TextureRegistry.OnTrimMemoryListener listener) {
        for (WeakReference<TextureRegistry.OnTrimMemoryListener> listenerRef : this.onTrimMemoryListeners) {
            if (listenerRef.get() == listener) {
                this.onTrimMemoryListeners.remove(listenerRef);
                return;
            }
        }
    }

    @Override // io.flutter.view.TextureRegistry
    public TextureRegistry.SurfaceProducer createSurfaceProducer() {
        ImageReaderSurfaceProducer entry = new ImageReaderSurfaceProducer(this.nextTextureId.getAndIncrement());
        Log.v(TAG, "New SurfaceProducer ID: " + entry.id());
        registerImageTexture(entry.id(), entry);
        return entry;
    }

    @Override // io.flutter.view.TextureRegistry
    public TextureRegistry.SurfaceTextureEntry createSurfaceTexture() {
        Log.v(TAG, "Creating a SurfaceTexture.");
        SurfaceTexture surfaceTexture = new SurfaceTexture(0);
        return registerSurfaceTexture(surfaceTexture);
    }

    @Override // io.flutter.view.TextureRegistry
    public TextureRegistry.SurfaceTextureEntry registerSurfaceTexture(SurfaceTexture surfaceTexture) {
        surfaceTexture.detachFromGLContext();
        SurfaceTextureRegistryEntry entry = new SurfaceTextureRegistryEntry(this.nextTextureId.getAndIncrement(), surfaceTexture);
        Log.v(TAG, "New SurfaceTexture ID: " + entry.id());
        registerTexture(entry.id(), entry.textureWrapper());
        addOnTrimMemoryListener(entry);
        return entry;
    }

    @Override // io.flutter.view.TextureRegistry
    public TextureRegistry.ImageTextureEntry createImageTexture() {
        ImageTextureRegistryEntry entry = new ImageTextureRegistryEntry(this.nextTextureId.getAndIncrement());
        Log.v(TAG, "New ImageTextureEntry ID: " + entry.id());
        registerImageTexture(entry.id(), entry);
        return entry;
    }

    @Override // io.flutter.view.TextureRegistry
    public void onTrimMemory(int level) {
        Iterator<WeakReference<TextureRegistry.OnTrimMemoryListener>> iterator = this.onTrimMemoryListeners.iterator();
        while (iterator.hasNext()) {
            WeakReference<TextureRegistry.OnTrimMemoryListener> listenerRef = iterator.next();
            TextureRegistry.OnTrimMemoryListener listener = listenerRef.get();
            if (listener != null) {
                listener.onTrimMemory(level);
            } else {
                iterator.remove();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public final class SurfaceTextureRegistryEntry implements TextureRegistry.SurfaceTextureEntry, TextureRegistry.OnTrimMemoryListener {
        private TextureRegistry.OnFrameConsumedListener frameConsumedListener;
        private final long id;
        private final Runnable onFrameConsumed;
        private SurfaceTexture.OnFrameAvailableListener onFrameListener;
        private boolean released;
        private final SurfaceTextureWrapper textureWrapper;
        private TextureRegistry.OnTrimMemoryListener trimMemoryListener;

        SurfaceTextureRegistryEntry(long id, SurfaceTexture surfaceTexture) {
            Runnable runnable = new Runnable() { // from class: io.flutter.embedding.engine.renderer.FlutterRenderer.SurfaceTextureRegistryEntry.1
                @Override // java.lang.Runnable
                public void run() {
                    if (SurfaceTextureRegistryEntry.this.frameConsumedListener != null) {
                        SurfaceTextureRegistryEntry.this.frameConsumedListener.onFrameConsumed();
                    }
                }
            };
            this.onFrameConsumed = runnable;
            this.onFrameListener = new SurfaceTexture.OnFrameAvailableListener() { // from class: io.flutter.embedding.engine.renderer.FlutterRenderer.SurfaceTextureRegistryEntry.2
                @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
                public void onFrameAvailable(SurfaceTexture texture) {
                    if (!SurfaceTextureRegistryEntry.this.released && FlutterRenderer.this.flutterJNI.isAttached()) {
                        FlutterRenderer.this.markTextureFrameAvailable(SurfaceTextureRegistryEntry.this.id);
                    }
                }
            };
            this.id = id;
            this.textureWrapper = new SurfaceTextureWrapper(surfaceTexture, runnable);
            if (Build.VERSION.SDK_INT >= 21) {
                surfaceTexture().setOnFrameAvailableListener(this.onFrameListener, new Handler());
            } else {
                surfaceTexture().setOnFrameAvailableListener(this.onFrameListener);
            }
        }

        @Override // io.flutter.view.TextureRegistry.OnTrimMemoryListener
        public void onTrimMemory(int level) {
            TextureRegistry.OnTrimMemoryListener onTrimMemoryListener = this.trimMemoryListener;
            if (onTrimMemoryListener != null) {
                onTrimMemoryListener.onTrimMemory(level);
            }
        }

        private void removeListener() {
            FlutterRenderer.this.removeOnTrimMemoryListener(this);
        }

        public SurfaceTextureWrapper textureWrapper() {
            return this.textureWrapper;
        }

        @Override // io.flutter.view.TextureRegistry.SurfaceTextureEntry
        public SurfaceTexture surfaceTexture() {
            return this.textureWrapper.surfaceTexture();
        }

        @Override // io.flutter.view.TextureRegistry.SurfaceTextureEntry, io.flutter.view.TextureRegistry.TextureEntry
        public long id() {
            return this.id;
        }

        @Override // io.flutter.view.TextureRegistry.SurfaceTextureEntry, io.flutter.view.TextureRegistry.TextureEntry
        public void release() {
            if (this.released) {
                return;
            }
            Log.v(FlutterRenderer.TAG, "Releasing a SurfaceTexture (" + this.id + ").");
            this.textureWrapper.release();
            FlutterRenderer.this.unregisterTexture(this.id);
            removeListener();
            this.released = true;
        }

        protected void finalize() throws Throwable {
            try {
                if (!this.released) {
                    FlutterRenderer.this.handler.post(new TextureFinalizerRunnable(this.id, FlutterRenderer.this.flutterJNI));
                }
            } finally {
                super.finalize();
            }
        }

        @Override // io.flutter.view.TextureRegistry.SurfaceTextureEntry
        public void setOnFrameConsumedListener(TextureRegistry.OnFrameConsumedListener listener) {
            this.frameConsumedListener = listener;
        }

        @Override // io.flutter.view.TextureRegistry.SurfaceTextureEntry
        public void setOnTrimMemoryListener(TextureRegistry.OnTrimMemoryListener listener) {
            this.trimMemoryListener = listener;
        }
    }

    /* loaded from: classes.dex */
    static final class TextureFinalizerRunnable implements Runnable {
        private final FlutterJNI flutterJNI;
        private final long id;

        TextureFinalizerRunnable(long id, FlutterJNI flutterJNI) {
            this.id = id;
            this.flutterJNI = flutterJNI;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.flutterJNI.isAttached()) {
                return;
            }
            Log.v(FlutterRenderer.TAG, "Releasing a Texture (" + this.id + ").");
            this.flutterJNI.unregisterTexture(this.id);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public final class ImageReaderSurfaceProducer implements TextureRegistry.SurfaceProducer, TextureRegistry.ImageConsumer {
        private static final int MAX_IMAGES = 4;
        private static final String TAG = "ImageReaderSurfaceProducer";
        private ImageReader activeReader;
        private final long id;
        private PerImage lastConsumedImage;
        private PerImage lastProducedImage;
        private boolean released;
        private boolean ignoringFence = false;
        private int requestedWidth = 0;
        private int requestedHeight = 0;
        private final Set<ImageReader> readersToClose = new HashSet();
        private final Handler onImageAvailableHandler = new Handler();
        private final ImageReader.OnImageAvailableListener onImageAvailableListener = new ImageReader.OnImageAvailableListener() { // from class: io.flutter.embedding.engine.renderer.FlutterRenderer.ImageReaderSurfaceProducer.1
            @Override // android.media.ImageReader.OnImageAvailableListener
            public void onImageAvailable(ImageReader reader) {
                Image image = null;
                try {
                    image = reader.acquireLatestImage();
                } catch (IllegalStateException e) {
                    Log.e(ImageReaderSurfaceProducer.TAG, "onImageAvailable acquireLatestImage failed: " + e.toString());
                }
                if (image == null) {
                    return;
                }
                ImageReaderSurfaceProducer imageReaderSurfaceProducer = ImageReaderSurfaceProducer.this;
                imageReaderSurfaceProducer.onImage(new PerImage(reader, image));
            }
        };

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public class PerImage {
            public final Image image;
            public final ImageReader reader;

            public PerImage(ImageReader reader, Image image) {
                this.reader = reader;
                this.image = image;
            }

            public void close() {
                this.image.close();
                ImageReaderSurfaceProducer.this.maybeCloseReader(this.reader);
            }
        }

        ImageReaderSurfaceProducer(long id) {
            this.id = id;
        }

        @Override // io.flutter.view.TextureRegistry.SurfaceProducer, io.flutter.view.TextureRegistry.TextureEntry
        public long id() {
            return this.id;
        }

        private void releaseInternal() {
            this.released = true;
            PerImage perImage = this.lastProducedImage;
            if (perImage != null) {
                perImage.close();
                this.lastProducedImage = null;
            }
            PerImage perImage2 = this.lastConsumedImage;
            if (perImage2 != null) {
                perImage2.close();
                this.lastConsumedImage = null;
            }
            for (ImageReader reader : this.readersToClose) {
                reader.close();
            }
            this.readersToClose.clear();
            ImageReader imageReader = this.activeReader;
            if (imageReader != null) {
                imageReader.close();
                this.activeReader = null;
            }
        }

        @Override // io.flutter.view.TextureRegistry.SurfaceProducer, io.flutter.view.TextureRegistry.TextureEntry
        public void release() {
            if (this.released) {
                return;
            }
            releaseInternal();
            FlutterRenderer.this.unregisterTexture(this.id);
        }

        @Override // io.flutter.view.TextureRegistry.SurfaceProducer
        public void setSize(int width, int height) {
            if (this.requestedWidth == width && this.requestedHeight == height) {
                return;
            }
            this.requestedHeight = height;
            this.requestedWidth = width;
            synchronized (this) {
                ImageReader imageReader = this.activeReader;
                if (imageReader != null) {
                    this.readersToClose.add(imageReader);
                    this.activeReader = null;
                }
            }
        }

        @Override // io.flutter.view.TextureRegistry.SurfaceProducer
        public int getWidth() {
            return this.requestedWidth;
        }

        @Override // io.flutter.view.TextureRegistry.SurfaceProducer
        public int getHeight() {
            return this.requestedHeight;
        }

        @Override // io.flutter.view.TextureRegistry.SurfaceProducer
        public Surface getSurface() {
            maybeCreateReader();
            return this.activeReader.getSurface();
        }

        @Override // io.flutter.view.TextureRegistry.ImageConsumer
        public Image acquireLatestImage() {
            PerImage r;
            PerImage toClose;
            synchronized (this) {
                r = this.lastProducedImage;
                this.lastProducedImage = null;
                toClose = this.lastConsumedImage;
                this.lastConsumedImage = r;
            }
            if (toClose != null) {
                toClose.close();
            }
            if (r == null) {
                return null;
            }
            maybeWaitOnFence(r.image);
            return r.image;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void maybeCloseReader(ImageReader reader) {
            synchronized (this) {
                if (this.readersToClose.contains(reader)) {
                    PerImage perImage = this.lastConsumedImage;
                    if (perImage == null || perImage.reader != reader) {
                        PerImage perImage2 = this.lastProducedImage;
                        if (perImage2 == null || perImage2.reader != reader) {
                            this.readersToClose.remove(reader);
                            reader.close();
                        }
                    }
                }
            }
        }

        private void maybeCreateReader() {
            synchronized (this) {
                if (this.activeReader != null) {
                    return;
                }
                this.activeReader = createImageReader();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void onImage(PerImage image) {
            if (this.released) {
                return;
            }
            synchronized (this) {
                if (this.readersToClose.contains(image.reader)) {
                    Log.i(TAG, "Skipped frame because resize is in flight.");
                    image.close();
                    return;
                }
                PerImage toClose = this.lastProducedImage;
                this.lastProducedImage = image;
                if (toClose != null) {
                    Log.i(TAG, "Dropping rendered frame that was not acquired in time.");
                    toClose.close();
                }
                if (image != null) {
                    FlutterRenderer.this.markTextureFrameAvailable(this.id);
                }
            }
        }

        private void waitOnFence(Image image) {
            try {
                SyncFence fence = image.getFence();
                boolean signaled = fence.awaitForever();
                if (!signaled) {
                    Log.e(TAG, "acquireLatestImage image's fence was never signalled.");
                }
            } catch (IOException e) {
            }
        }

        private void maybeWaitOnFence(Image image) {
            if (image == null || this.ignoringFence) {
                return;
            }
            if (Build.VERSION.SDK_INT >= 33) {
                waitOnFence(image);
            } else if (!this.ignoringFence) {
                this.ignoringFence = true;
                Log.w(TAG, "ImageTextureEntry can't wait on the fence on Android < 33");
            }
        }

        protected void finalize() throws Throwable {
            try {
                if (this.released) {
                    return;
                }
                releaseInternal();
                FlutterRenderer.this.handler.post(new TextureFinalizerRunnable(this.id, FlutterRenderer.this.flutterJNI));
            } finally {
                super.finalize();
            }
        }

        private ImageReader createImageReader33() {
            ImageReader.Builder builder = new ImageReader.Builder(this.requestedWidth, this.requestedHeight);
            builder.setMaxImages(4);
            builder.setImageFormat(34);
            builder.setUsage(256L);
            ImageReader reader = builder.build();
            reader.setOnImageAvailableListener(this.onImageAvailableListener, this.onImageAvailableHandler);
            return reader;
        }

        private ImageReader createImageReader29() {
            ImageReader reader = ImageReader.newInstance(this.requestedWidth, this.requestedHeight, 34, 4, 256L);
            reader.setOnImageAvailableListener(this.onImageAvailableListener, this.onImageAvailableHandler);
            return reader;
        }

        private ImageReader createImageReader() {
            if (Build.VERSION.SDK_INT >= 33) {
                return createImageReader33();
            }
            if (Build.VERSION.SDK_INT >= 29) {
                return createImageReader29();
            }
            throw new UnsupportedOperationException("ImageReaderPlatformViewRenderTarget requires API version 29+");
        }

        public void disableFenceForTest() {
            this.ignoringFence = true;
        }

        public int readersToCloseSize() {
            return this.readersToClose.size();
        }
    }

    /* loaded from: classes.dex */
    final class ImageTextureRegistryEntry implements TextureRegistry.ImageTextureEntry, TextureRegistry.ImageConsumer {
        private static final String TAG = "ImageTextureRegistryEntry";
        private final long id;
        private boolean ignoringFence = false;
        private Image image;
        private boolean released;

        ImageTextureRegistryEntry(long id) {
            this.id = id;
        }

        @Override // io.flutter.view.TextureRegistry.ImageTextureEntry, io.flutter.view.TextureRegistry.TextureEntry
        public long id() {
            return this.id;
        }

        @Override // io.flutter.view.TextureRegistry.ImageTextureEntry, io.flutter.view.TextureRegistry.TextureEntry
        public void release() {
            if (this.released) {
                return;
            }
            this.released = true;
            Image image = this.image;
            if (image != null) {
                image.close();
                this.image = null;
            }
            FlutterRenderer.this.unregisterTexture(this.id);
        }

        @Override // io.flutter.view.TextureRegistry.ImageTextureEntry
        public void pushImage(Image image) {
            Image toClose;
            if (this.released) {
                return;
            }
            synchronized (this) {
                toClose = this.image;
                this.image = image;
            }
            if (toClose != null) {
                Log.e(TAG, "Dropping PlatformView Frame");
                toClose.close();
            }
            if (image != null) {
                FlutterRenderer.this.markTextureFrameAvailable(this.id);
            }
        }

        private void waitOnFence(Image image) {
            try {
                SyncFence fence = image.getFence();
                boolean signaled = fence.awaitForever();
                if (!signaled) {
                    Log.e(TAG, "acquireLatestImage image's fence was never signalled.");
                }
            } catch (IOException e) {
            }
        }

        private void maybeWaitOnFence(Image image) {
            if (image == null || this.ignoringFence) {
                return;
            }
            if (Build.VERSION.SDK_INT >= 33) {
                waitOnFence(image);
            } else if (!this.ignoringFence) {
                this.ignoringFence = true;
                Log.w(TAG, "ImageTextureEntry can't wait on the fence on Android < 33");
            }
        }

        @Override // io.flutter.view.TextureRegistry.ImageConsumer
        public Image acquireLatestImage() {
            Image r;
            synchronized (this) {
                r = this.image;
                this.image = null;
            }
            maybeWaitOnFence(r);
            return r;
        }

        protected void finalize() throws Throwable {
            try {
                if (this.released) {
                    return;
                }
                Image image = this.image;
                if (image != null) {
                    image.close();
                    this.image = null;
                }
                this.released = true;
                FlutterRenderer.this.handler.post(new TextureFinalizerRunnable(this.id, FlutterRenderer.this.flutterJNI));
            } finally {
                super.finalize();
            }
        }
    }

    public void startRenderingToSurface(Surface surface, boolean onlySwap) {
        if (!onlySwap) {
            stopRenderingToSurface();
        }
        this.surface = surface;
        if (onlySwap) {
            this.flutterJNI.onSurfaceWindowChanged(surface);
        } else {
            this.flutterJNI.onSurfaceCreated(surface);
        }
    }

    public void swapSurface(Surface surface) {
        this.surface = surface;
        this.flutterJNI.onSurfaceWindowChanged(surface);
    }

    public void surfaceChanged(int width, int height) {
        this.flutterJNI.onSurfaceChanged(width, height);
    }

    public void stopRenderingToSurface() {
        if (this.surface != null) {
            this.flutterJNI.onSurfaceDestroyed();
            if (this.isDisplayingFlutterUi) {
                this.flutterUiDisplayListener.onFlutterUiNoLongerDisplayed();
            }
            this.isDisplayingFlutterUi = false;
            this.surface = null;
        }
    }

    public void setViewportMetrics(ViewportMetrics viewportMetrics) {
        if (!viewportMetrics.validate()) {
            return;
        }
        Log.v(TAG, "Setting viewport metrics\nSize: " + viewportMetrics.width + " x " + viewportMetrics.height + "\nPadding - L: " + viewportMetrics.viewPaddingLeft + ", T: " + viewportMetrics.viewPaddingTop + ", R: " + viewportMetrics.viewPaddingRight + ", B: " + viewportMetrics.viewPaddingBottom + "\nInsets - L: " + viewportMetrics.viewInsetLeft + ", T: " + viewportMetrics.viewInsetTop + ", R: " + viewportMetrics.viewInsetRight + ", B: " + viewportMetrics.viewInsetBottom + "\nSystem Gesture Insets - L: " + viewportMetrics.systemGestureInsetLeft + ", T: " + viewportMetrics.systemGestureInsetTop + ", R: " + viewportMetrics.systemGestureInsetRight + ", B: " + viewportMetrics.systemGestureInsetRight + "\nDisplay Features: " + viewportMetrics.displayFeatures.size());
        int[] displayFeaturesBounds = new int[viewportMetrics.displayFeatures.size() * 4];
        int[] displayFeaturesType = new int[viewportMetrics.displayFeatures.size()];
        int[] displayFeaturesState = new int[viewportMetrics.displayFeatures.size()];
        for (int i = 0; i < viewportMetrics.displayFeatures.size(); i++) {
            DisplayFeature displayFeature = viewportMetrics.displayFeatures.get(i);
            displayFeaturesBounds[i * 4] = displayFeature.bounds.left;
            displayFeaturesBounds[(i * 4) + 1] = displayFeature.bounds.top;
            displayFeaturesBounds[(i * 4) + 2] = displayFeature.bounds.right;
            displayFeaturesBounds[(i * 4) + 3] = displayFeature.bounds.bottom;
            displayFeaturesType[i] = displayFeature.type.encodedValue;
            displayFeaturesState[i] = displayFeature.state.encodedValue;
        }
        this.flutterJNI.setViewportMetrics(viewportMetrics.devicePixelRatio, viewportMetrics.width, viewportMetrics.height, viewportMetrics.viewPaddingTop, viewportMetrics.viewPaddingRight, viewportMetrics.viewPaddingBottom, viewportMetrics.viewPaddingLeft, viewportMetrics.viewInsetTop, viewportMetrics.viewInsetRight, viewportMetrics.viewInsetBottom, viewportMetrics.viewInsetLeft, viewportMetrics.systemGestureInsetTop, viewportMetrics.systemGestureInsetRight, viewportMetrics.systemGestureInsetBottom, viewportMetrics.systemGestureInsetLeft, viewportMetrics.physicalTouchSlop, displayFeaturesBounds, displayFeaturesType, displayFeaturesState);
    }

    public Bitmap getBitmap() {
        return this.flutterJNI.getBitmap();
    }

    public void dispatchPointerDataPacket(ByteBuffer buffer, int position) {
        this.flutterJNI.dispatchPointerDataPacket(buffer, position);
    }

    private void registerTexture(long textureId, SurfaceTextureWrapper textureWrapper) {
        this.flutterJNI.registerTexture(textureId, textureWrapper);
    }

    private void registerImageTexture(long textureId, TextureRegistry.ImageConsumer imageTexture) {
        this.flutterJNI.registerImageTexture(textureId, imageTexture);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void markTextureFrameAvailable(long textureId) {
        this.flutterJNI.markTextureFrameAvailable(textureId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void unregisterTexture(long textureId) {
        this.flutterJNI.unregisterTexture(textureId);
    }

    public boolean isSoftwareRenderingEnabled() {
        return this.flutterJNI.getIsSoftwareRenderingEnabled();
    }

    public void setAccessibilityFeatures(int flags) {
        this.flutterJNI.setAccessibilityFeatures(flags);
    }

    public void setSemanticsEnabled(boolean enabled) {
        this.flutterJNI.setSemanticsEnabled(enabled);
    }

    public void dispatchSemanticsAction(int nodeId, int action, ByteBuffer args, int argsPosition) {
        this.flutterJNI.dispatchSemanticsAction(nodeId, action, args, argsPosition);
    }

    /* loaded from: classes.dex */
    public static final class ViewportMetrics {
        public static final int unsetValue = -1;
        public float devicePixelRatio = 1.0f;
        public int width = 0;
        public int height = 0;
        public int viewPaddingTop = 0;
        public int viewPaddingRight = 0;
        public int viewPaddingBottom = 0;
        public int viewPaddingLeft = 0;
        public int viewInsetTop = 0;
        public int viewInsetRight = 0;
        public int viewInsetBottom = 0;
        public int viewInsetLeft = 0;
        public int systemGestureInsetTop = 0;
        public int systemGestureInsetRight = 0;
        public int systemGestureInsetBottom = 0;
        public int systemGestureInsetLeft = 0;
        public int physicalTouchSlop = -1;
        public List<DisplayFeature> displayFeatures = new ArrayList();

        boolean validate() {
            return this.width > 0 && this.height > 0 && this.devicePixelRatio > 0.0f;
        }
    }

    /* loaded from: classes.dex */
    public static final class DisplayFeature {
        public final Rect bounds;
        public final DisplayFeatureState state;
        public final DisplayFeatureType type;

        public DisplayFeature(Rect bounds, DisplayFeatureType type, DisplayFeatureState state) {
            this.bounds = bounds;
            this.type = type;
            this.state = state;
        }

        public DisplayFeature(Rect bounds, DisplayFeatureType type) {
            this.bounds = bounds;
            this.type = type;
            this.state = DisplayFeatureState.UNKNOWN;
        }
    }

    /* loaded from: classes.dex */
    public enum DisplayFeatureType {
        UNKNOWN(0),
        FOLD(1),
        HINGE(2),
        CUTOUT(3);
        
        public final int encodedValue;

        DisplayFeatureType(int encodedValue) {
            this.encodedValue = encodedValue;
        }
    }

    /* loaded from: classes.dex */
    public enum DisplayFeatureState {
        UNKNOWN(0),
        POSTURE_FLAT(1),
        POSTURE_HALF_OPENED(2);
        
        public final int encodedValue;

        DisplayFeatureState(int encodedValue) {
            this.encodedValue = encodedValue;
        }
    }
}
