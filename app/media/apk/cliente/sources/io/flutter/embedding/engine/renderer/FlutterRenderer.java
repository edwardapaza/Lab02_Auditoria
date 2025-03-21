package io.flutter.embedding.engine.renderer;

import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.media.Image;
import android.media.ImageReader;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.Surface;
import androidx.lifecycle.m;
import androidx.lifecycle.x;
import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.embedding.engine.renderer.FlutterRenderer;
import io.flutter.view.TextureRegistry;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes.dex */
public class FlutterRenderer implements TextureRegistry {

    /* renamed from: i  reason: collision with root package name */
    public static boolean f3856i = false;

    /* renamed from: j  reason: collision with root package name */
    public static boolean f3857j = false;

    /* renamed from: a  reason: collision with root package name */
    private final FlutterJNI f3858a;

    /* renamed from: c  reason: collision with root package name */
    private Surface f3860c;

    /* renamed from: h  reason: collision with root package name */
    private final io.flutter.embedding.engine.renderer.d f3865h;

    /* renamed from: b  reason: collision with root package name */
    private final AtomicLong f3859b = new AtomicLong(0);

    /* renamed from: d  reason: collision with root package name */
    private boolean f3861d = false;

    /* renamed from: e  reason: collision with root package name */
    private final Handler f3862e = new Handler();

    /* renamed from: f  reason: collision with root package name */
    private final Set<WeakReference<TextureRegistry.b>> f3863f = new HashSet();

    /* renamed from: g  reason: collision with root package name */
    private final List<ImageReaderSurfaceProducer> f3864g = new ArrayList();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public final class ImageReaderSurfaceProducer implements TextureRegistry.SurfaceProducer, TextureRegistry.ImageConsumer, TextureRegistry.b {
        private static final boolean CLEANUP_ON_MEMORY_PRESSURE = true;
        private static final int MAX_IMAGES = 5;
        private static final String TAG = "ImageReaderSurfaceProducer";
        private static final boolean VERBOSE_LOGS = false;
        private static final boolean trimOnMemoryPressure = true;
        private final long id;
        private boolean released;
        private boolean ignoringFence = VERBOSE_LOGS;
        private int requestedWidth = 1;
        private int requestedHeight = 1;
        private boolean createNewReader = true;
        private long lastDequeueTime = 0;
        private long lastQueueTime = 0;
        private long lastScheduleTime = 0;
        private int numTrims = 0;
        private final Object lock = new Object();
        private final ArrayDeque<b> imageReaderQueue = new ArrayDeque<>();
        private final HashMap<ImageReader, b> perImageReaders = new HashMap<>();
        private a lastDequeuedImage = null;
        private b lastReaderDequeuedFrom = null;
        private TextureRegistry.SurfaceProducer.a callback = null;

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public class a {

            /* renamed from: a  reason: collision with root package name */
            public final Image f3866a;

            /* renamed from: b  reason: collision with root package name */
            public final long f3867b;

            public a(Image image, long j5) {
                this.f3866a = image;
                this.f3867b = j5;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public class b {

            /* renamed from: a  reason: collision with root package name */
            public final ImageReader f3869a;

            /* renamed from: b  reason: collision with root package name */
            private final ArrayDeque<a> f3870b = new ArrayDeque<>();

            /* renamed from: c  reason: collision with root package name */
            private boolean f3871c = ImageReaderSurfaceProducer.VERBOSE_LOGS;

            public b(ImageReader imageReader) {
                this.f3869a = imageReader;
                imageReader.setOnImageAvailableListener(new ImageReader.OnImageAvailableListener() { // from class: io.flutter.embedding.engine.renderer.a
                    @Override // android.media.ImageReader.OnImageAvailableListener
                    public final void onImageAvailable(ImageReader imageReader2) {
                        FlutterRenderer.ImageReaderSurfaceProducer.b.this.f(imageReader2);
                    }
                }, new Handler(Looper.getMainLooper()));
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void f(ImageReader imageReader) {
                Image image;
                try {
                    image = imageReader.acquireLatestImage();
                } catch (IllegalStateException e5) {
                    n2.b.b(ImageReaderSurfaceProducer.TAG, "onImageAvailable acquireLatestImage failed: " + e5);
                    image = null;
                }
                if (image == null) {
                    return;
                }
                if (ImageReaderSurfaceProducer.this.released || this.f3871c) {
                    image.close();
                } else {
                    ImageReaderSurfaceProducer.this.onImage(imageReader, image);
                }
            }

            boolean c() {
                if (!this.f3870b.isEmpty() || ImageReaderSurfaceProducer.this.lastReaderDequeuedFrom == this) {
                    return ImageReaderSurfaceProducer.VERBOSE_LOGS;
                }
                return true;
            }

            void d() {
                this.f3871c = true;
                this.f3869a.close();
                this.f3870b.clear();
            }

            a e() {
                if (this.f3870b.isEmpty()) {
                    return null;
                }
                return this.f3870b.removeFirst();
            }

            a g(Image image) {
                if (this.f3871c) {
                    return null;
                }
                a aVar = new a(image, System.nanoTime());
                this.f3870b.add(aVar);
                while (this.f3870b.size() > 2) {
                    this.f3870b.removeFirst().f3866a.close();
                }
                return aVar;
            }
        }

        ImageReaderSurfaceProducer(long j5) {
            this.id = j5;
        }

        private void cleanup() {
            synchronized (this.lock) {
                for (b bVar : this.perImageReaders.values()) {
                    if (this.lastReaderDequeuedFrom == bVar) {
                        this.lastReaderDequeuedFrom = null;
                    }
                    bVar.d();
                }
                this.perImageReaders.clear();
                a aVar = this.lastDequeuedImage;
                if (aVar != null) {
                    aVar.f3866a.close();
                    this.lastDequeuedImage = null;
                }
                b bVar2 = this.lastReaderDequeuedFrom;
                if (bVar2 != null) {
                    bVar2.d();
                    this.lastReaderDequeuedFrom = null;
                }
                this.imageReaderQueue.clear();
            }
        }

        private ImageReader createImageReader() {
            int i5 = Build.VERSION.SDK_INT;
            if (i5 >= 33) {
                return createImageReader33();
            }
            if (i5 >= 29) {
                return createImageReader29();
            }
            throw new UnsupportedOperationException("ImageReaderPlatformViewRenderTarget requires API version 29+");
        }

        private ImageReader createImageReader29() {
            ImageReader newInstance;
            newInstance = ImageReader.newInstance(this.requestedWidth, this.requestedHeight, 34, 5, 256L);
            return newInstance;
        }

        private ImageReader createImageReader33() {
            ImageReader.Builder builder = new ImageReader.Builder(this.requestedWidth, this.requestedHeight);
            builder.setMaxImages(5);
            builder.setImageFormat(34);
            builder.setUsage(256L);
            return builder.build();
        }

        private b getActiveReader() {
            synchronized (this.lock) {
                if (!this.createNewReader) {
                    return this.imageReaderQueue.peekLast();
                }
                this.createNewReader = VERBOSE_LOGS;
                return getOrCreatePerImageReader(createImageReader());
            }
        }

        private void maybeWaitOnFence(Image image) {
            if (image == null || this.ignoringFence) {
                return;
            }
            if (Build.VERSION.SDK_INT >= 33) {
                waitOnFence(image);
                return;
            }
            this.ignoringFence = true;
            n2.b.a(TAG, "ImageTextureEntry can't wait on the fence on Android < 33");
        }

        private void releaseInternal() {
            cleanup();
            this.released = true;
            FlutterRenderer.this.f3864g.remove(this);
        }

        private void waitOnFence(Image image) {
            try {
                image.getFence().awaitForever();
            } catch (IOException unused) {
            }
        }

        @Override // io.flutter.view.TextureRegistry.ImageConsumer
        public Image acquireLatestImage() {
            a dequeueImage = dequeueImage();
            if (dequeueImage == null) {
                return null;
            }
            maybeWaitOnFence(dequeueImage.f3866a);
            return dequeueImage.f3866a;
        }

        double deltaMillis(long j5) {
            return j5 / 1000000.0d;
        }

        a dequeueImage() {
            a aVar;
            synchronized (this.lock) {
                Iterator<b> it = this.imageReaderQueue.iterator();
                aVar = null;
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    b next = it.next();
                    a e5 = next.e();
                    if (e5 == null) {
                        aVar = e5;
                    } else {
                        a aVar2 = this.lastDequeuedImage;
                        if (aVar2 != null) {
                            aVar2.f3866a.close();
                        }
                        this.lastDequeuedImage = e5;
                        this.lastReaderDequeuedFrom = next;
                        aVar = e5;
                    }
                }
                pruneImageReaderQueue();
            }
            return aVar;
        }

        public void disableFenceForTest() {
            this.ignoringFence = true;
        }

        protected void finalize() {
            try {
                if (this.released) {
                    return;
                }
                releaseInternal();
                FlutterRenderer.this.f3862e.post(new g(this.id, FlutterRenderer.this.f3858a));
            } finally {
                super.finalize();
            }
        }

        @Override // io.flutter.view.TextureRegistry.SurfaceProducer
        public int getHeight() {
            return this.requestedHeight;
        }

        b getOrCreatePerImageReader(ImageReader imageReader) {
            b bVar = this.perImageReaders.get(imageReader);
            if (bVar == null) {
                b bVar2 = new b(imageReader);
                this.perImageReaders.put(imageReader, bVar2);
                this.imageReaderQueue.add(bVar2);
                return bVar2;
            }
            return bVar;
        }

        @Override // io.flutter.view.TextureRegistry.SurfaceProducer
        public Surface getSurface() {
            return getActiveReader().f3869a.getSurface();
        }

        @Override // io.flutter.view.TextureRegistry.SurfaceProducer
        public int getWidth() {
            return this.requestedWidth;
        }

        @Override // io.flutter.view.TextureRegistry.SurfaceProducer
        public long id() {
            return this.id;
        }

        public int numImageReaders() {
            int size;
            synchronized (this.lock) {
                size = this.imageReaderQueue.size();
            }
            return size;
        }

        public int numImages() {
            int i5;
            synchronized (this.lock) {
                Iterator<b> it = this.imageReaderQueue.iterator();
                i5 = 0;
                while (it.hasNext()) {
                    i5 += it.next().f3870b.size();
                }
            }
            return i5;
        }

        public int numTrims() {
            int i5;
            synchronized (this.lock) {
                i5 = this.numTrims;
            }
            return i5;
        }

        void onImage(ImageReader imageReader, Image image) {
            a g5;
            synchronized (this.lock) {
                g5 = getOrCreatePerImageReader(imageReader).g(image);
            }
            if (g5 == null) {
                return;
            }
            FlutterRenderer.this.w();
        }

        @Override // io.flutter.view.TextureRegistry.b
        public void onTrimMemory(int i5) {
            if (i5 < 40) {
                return;
            }
            synchronized (this.lock) {
                this.numTrims++;
            }
            cleanup();
            this.createNewReader = true;
            TextureRegistry.SurfaceProducer.a aVar = this.callback;
            if (aVar != null) {
                aVar.b();
            }
        }

        void pruneImageReaderQueue() {
            b peekFirst;
            while (this.imageReaderQueue.size() > 1 && (peekFirst = this.imageReaderQueue.peekFirst()) != null && peekFirst.c()) {
                this.imageReaderQueue.removeFirst();
                this.perImageReaders.remove(peekFirst.f3869a);
                peekFirst.d();
            }
        }

        @Override // io.flutter.view.TextureRegistry.SurfaceProducer
        public void release() {
            if (this.released) {
                return;
            }
            releaseInternal();
            FlutterRenderer.this.D(this.id);
        }

        @Override // io.flutter.view.TextureRegistry.SurfaceProducer
        public void scheduleFrame() {
            FlutterRenderer.this.w();
        }

        @Override // io.flutter.view.TextureRegistry.SurfaceProducer
        public void setCallback(TextureRegistry.SurfaceProducer.a aVar) {
            this.callback = aVar;
        }

        @Override // io.flutter.view.TextureRegistry.SurfaceProducer
        public void setSize(int i5, int i6) {
            int max = Math.max(1, i5);
            int max2 = Math.max(1, i6);
            if (this.requestedWidth == max && this.requestedHeight == max2) {
                return;
            }
            this.createNewReader = true;
            this.requestedHeight = max2;
            this.requestedWidth = max;
        }
    }

    /* loaded from: classes.dex */
    final class ImageTextureRegistryEntry implements TextureRegistry.ImageTextureEntry, TextureRegistry.ImageConsumer {
        private static final String TAG = "ImageTextureRegistryEntry";
        private final long id;
        private boolean ignoringFence = false;
        private Image image;
        private boolean released;

        ImageTextureRegistryEntry(long j5) {
            this.id = j5;
        }

        private void maybeWaitOnFence(Image image) {
            if (image == null || this.ignoringFence) {
                return;
            }
            if (Build.VERSION.SDK_INT >= 33) {
                waitOnFence(image);
                return;
            }
            this.ignoringFence = true;
            n2.b.a(TAG, "ImageTextureEntry can't wait on the fence on Android < 33");
        }

        private void waitOnFence(Image image) {
            try {
                image.getFence().awaitForever();
            } catch (IOException unused) {
            }
        }

        @Override // io.flutter.view.TextureRegistry.ImageConsumer
        public Image acquireLatestImage() {
            Image image;
            synchronized (this) {
                image = this.image;
                this.image = null;
            }
            maybeWaitOnFence(image);
            return image;
        }

        protected void finalize() {
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
                FlutterRenderer.this.f3862e.post(new g(this.id, FlutterRenderer.this.f3858a));
            } finally {
                super.finalize();
            }
        }

        @Override // io.flutter.view.TextureRegistry.ImageTextureEntry
        public long id() {
            return this.id;
        }

        @Override // io.flutter.view.TextureRegistry.ImageTextureEntry
        public void pushImage(Image image) {
            Image image2;
            if (this.released) {
                return;
            }
            synchronized (this) {
                image2 = this.image;
                this.image = image;
            }
            if (image2 != null) {
                n2.b.b(TAG, "Dropping PlatformView Frame");
                image2.close();
            }
            if (image != null) {
                FlutterRenderer.this.w();
            }
        }

        @Override // io.flutter.view.TextureRegistry.ImageTextureEntry
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
            FlutterRenderer.this.D(this.id);
        }
    }

    /* loaded from: classes.dex */
    class a implements io.flutter.embedding.engine.renderer.d {
        a() {
        }

        @Override // io.flutter.embedding.engine.renderer.d
        public void c() {
            FlutterRenderer.this.f3861d = false;
        }

        @Override // io.flutter.embedding.engine.renderer.d
        public void f() {
            FlutterRenderer.this.f3861d = true;
        }
    }

    /* loaded from: classes.dex */
    class b implements androidx.lifecycle.d {
        b() {
        }

        @Override // androidx.lifecycle.d
        public void a(m mVar) {
            n2.b.f("FlutterRenderer", "onResume called; notifying SurfaceProducers");
            for (ImageReaderSurfaceProducer imageReaderSurfaceProducer : FlutterRenderer.this.f3864g) {
                if (imageReaderSurfaceProducer.callback != null) {
                    imageReaderSurfaceProducer.callback.a();
                }
            }
        }

        @Override // androidx.lifecycle.d
        public /* synthetic */ void b(m mVar) {
            androidx.lifecycle.c.b(this, mVar);
        }

        @Override // androidx.lifecycle.d
        public /* synthetic */ void c(m mVar) {
            androidx.lifecycle.c.a(this, mVar);
        }

        @Override // androidx.lifecycle.d
        public /* synthetic */ void e(m mVar) {
            androidx.lifecycle.c.c(this, mVar);
        }

        @Override // androidx.lifecycle.d
        public /* synthetic */ void f(m mVar) {
            androidx.lifecycle.c.d(this, mVar);
        }

        @Override // androidx.lifecycle.d
        public /* synthetic */ void g(m mVar) {
            androidx.lifecycle.c.e(this, mVar);
        }
    }

    /* loaded from: classes.dex */
    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        public final Rect f3875a;

        /* renamed from: b  reason: collision with root package name */
        public final e f3876b;

        /* renamed from: c  reason: collision with root package name */
        public final d f3877c;

        public c(Rect rect, e eVar) {
            this.f3875a = rect;
            this.f3876b = eVar;
            this.f3877c = d.UNKNOWN;
        }

        public c(Rect rect, e eVar, d dVar) {
            this.f3875a = rect;
            this.f3876b = eVar;
            this.f3877c = dVar;
        }
    }

    /* loaded from: classes.dex */
    public enum d {
        UNKNOWN(0),
        POSTURE_FLAT(1),
        POSTURE_HALF_OPENED(2);
        

        /* renamed from: a  reason: collision with root package name */
        public final int f3882a;

        d(int i5) {
            this.f3882a = i5;
        }
    }

    /* loaded from: classes.dex */
    public enum e {
        UNKNOWN(0),
        FOLD(1),
        HINGE(2),
        CUTOUT(3);
        

        /* renamed from: a  reason: collision with root package name */
        public final int f3888a;

        e(int i5) {
            this.f3888a = i5;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public final class f implements TextureRegistry.SurfaceTextureEntry, TextureRegistry.b {

        /* renamed from: a  reason: collision with root package name */
        private final long f3889a;

        /* renamed from: b  reason: collision with root package name */
        private final SurfaceTextureWrapper f3890b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f3891c;

        /* renamed from: d  reason: collision with root package name */
        private TextureRegistry.b f3892d;

        /* renamed from: e  reason: collision with root package name */
        private TextureRegistry.a f3893e;

        f(long j5, SurfaceTexture surfaceTexture) {
            this.f3889a = j5;
            this.f3890b = new SurfaceTextureWrapper(surfaceTexture, new Runnable() { // from class: io.flutter.embedding.engine.renderer.b
                @Override // java.lang.Runnable
                public final void run() {
                    FlutterRenderer.f.this.c();
                }
            });
            surfaceTexture().setOnFrameAvailableListener(new SurfaceTexture.OnFrameAvailableListener() { // from class: io.flutter.embedding.engine.renderer.c
                @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
                public final void onFrameAvailable(SurfaceTexture surfaceTexture2) {
                    FlutterRenderer.f.this.d(surfaceTexture2);
                }
            }, new Handler());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void c() {
            TextureRegistry.a aVar = this.f3893e;
            if (aVar != null) {
                aVar.a();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void d(SurfaceTexture surfaceTexture) {
            if (this.f3891c || !FlutterRenderer.this.f3858a.isAttached()) {
                return;
            }
            this.f3890b.markDirty();
            FlutterRenderer.this.w();
        }

        private void e() {
            FlutterRenderer.this.v(this);
        }

        public SurfaceTextureWrapper f() {
            return this.f3890b;
        }

        protected void finalize() {
            try {
                if (this.f3891c) {
                    return;
                }
                FlutterRenderer.this.f3862e.post(new g(this.f3889a, FlutterRenderer.this.f3858a));
            } finally {
                super.finalize();
            }
        }

        @Override // io.flutter.view.TextureRegistry.SurfaceTextureEntry
        public long id() {
            return this.f3889a;
        }

        @Override // io.flutter.view.TextureRegistry.b
        public void onTrimMemory(int i5) {
            TextureRegistry.b bVar = this.f3892d;
            if (bVar != null) {
                bVar.onTrimMemory(i5);
            }
        }

        @Override // io.flutter.view.TextureRegistry.SurfaceTextureEntry
        public void release() {
            if (this.f3891c) {
                return;
            }
            n2.b.f("FlutterRenderer", "Releasing a SurfaceTexture (" + this.f3889a + ").");
            this.f3890b.release();
            FlutterRenderer.this.D(this.f3889a);
            e();
            this.f3891c = true;
        }

        @Override // io.flutter.view.TextureRegistry.SurfaceTextureEntry
        public void setOnFrameConsumedListener(TextureRegistry.a aVar) {
            this.f3893e = aVar;
        }

        @Override // io.flutter.view.TextureRegistry.SurfaceTextureEntry
        public void setOnTrimMemoryListener(TextureRegistry.b bVar) {
            this.f3892d = bVar;
        }

        @Override // io.flutter.view.TextureRegistry.SurfaceTextureEntry
        public SurfaceTexture surfaceTexture() {
            return this.f3890b.surfaceTexture();
        }
    }

    /* loaded from: classes.dex */
    static final class g implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final long f3895a;

        /* renamed from: b  reason: collision with root package name */
        private final FlutterJNI f3896b;

        /* JADX INFO: Access modifiers changed from: package-private */
        public g(long j5, FlutterJNI flutterJNI) {
            this.f3895a = j5;
            this.f3896b = flutterJNI;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f3896b.isAttached()) {
                n2.b.f("FlutterRenderer", "Releasing a Texture (" + this.f3895a + ").");
                this.f3896b.unregisterTexture(this.f3895a);
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class h {

        /* renamed from: a  reason: collision with root package name */
        public float f3897a = 1.0f;

        /* renamed from: b  reason: collision with root package name */
        public int f3898b = 0;

        /* renamed from: c  reason: collision with root package name */
        public int f3899c = 0;

        /* renamed from: d  reason: collision with root package name */
        public int f3900d = 0;

        /* renamed from: e  reason: collision with root package name */
        public int f3901e = 0;

        /* renamed from: f  reason: collision with root package name */
        public int f3902f = 0;

        /* renamed from: g  reason: collision with root package name */
        public int f3903g = 0;

        /* renamed from: h  reason: collision with root package name */
        public int f3904h = 0;

        /* renamed from: i  reason: collision with root package name */
        public int f3905i = 0;

        /* renamed from: j  reason: collision with root package name */
        public int f3906j = 0;

        /* renamed from: k  reason: collision with root package name */
        public int f3907k = 0;

        /* renamed from: l  reason: collision with root package name */
        public int f3908l = 0;

        /* renamed from: m  reason: collision with root package name */
        public int f3909m = 0;

        /* renamed from: n  reason: collision with root package name */
        public int f3910n = 0;

        /* renamed from: o  reason: collision with root package name */
        public int f3911o = 0;

        /* renamed from: p  reason: collision with root package name */
        public int f3912p = -1;

        /* renamed from: q  reason: collision with root package name */
        public List<c> f3913q = new ArrayList();

        boolean a() {
            return this.f3898b > 0 && this.f3899c > 0 && this.f3897a > 0.0f;
        }
    }

    public FlutterRenderer(FlutterJNI flutterJNI) {
        a aVar = new a();
        this.f3865h = aVar;
        this.f3858a = flutterJNI;
        flutterJNI.addIsDisplayingFlutterUiListener(aVar);
        x.o().a().a(new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D(long j5) {
        this.f3858a.unregisterTexture(j5);
    }

    private void l() {
        Iterator<WeakReference<TextureRegistry.b>> it = this.f3863f.iterator();
        while (it.hasNext()) {
            if (it.next().get() == null) {
                it.remove();
            }
        }
    }

    private void q(long j5, TextureRegistry.ImageConsumer imageConsumer) {
        this.f3858a.registerImageTexture(j5, imageConsumer);
    }

    private TextureRegistry.SurfaceTextureEntry r(long j5, SurfaceTexture surfaceTexture) {
        surfaceTexture.detachFromGLContext();
        f fVar = new f(j5, surfaceTexture);
        n2.b.f("FlutterRenderer", "New SurfaceTexture ID: " + fVar.id());
        t(fVar.id(), fVar.f());
        k(fVar);
        return fVar;
    }

    private void t(long j5, SurfaceTextureWrapper surfaceTextureWrapper) {
        this.f3858a.registerTexture(j5, surfaceTextureWrapper);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w() {
        this.f3858a.scheduleFrame();
    }

    public void A() {
        if (this.f3860c != null) {
            this.f3858a.onSurfaceDestroyed();
            if (this.f3861d) {
                this.f3865h.c();
            }
            this.f3861d = false;
            this.f3860c = null;
        }
    }

    public void B(int i5, int i6) {
        this.f3858a.onSurfaceChanged(i5, i6);
    }

    public void C(Surface surface) {
        this.f3860c = surface;
        this.f3858a.onSurfaceWindowChanged(surface);
    }

    @Override // io.flutter.view.TextureRegistry
    public TextureRegistry.ImageTextureEntry a() {
        ImageTextureRegistryEntry imageTextureRegistryEntry = new ImageTextureRegistryEntry(this.f3859b.getAndIncrement());
        n2.b.f("FlutterRenderer", "New ImageTextureEntry ID: " + imageTextureRegistryEntry.id());
        q(imageTextureRegistryEntry.id(), imageTextureRegistryEntry);
        return imageTextureRegistryEntry;
    }

    @Override // io.flutter.view.TextureRegistry
    public TextureRegistry.SurfaceProducer b() {
        if (f3856i || Build.VERSION.SDK_INT < 29) {
            TextureRegistry.SurfaceTextureEntry c5 = c();
            io.flutter.embedding.engine.renderer.f fVar = new io.flutter.embedding.engine.renderer.f(c5.id(), this.f3862e, this.f3858a, c5);
            n2.b.f("FlutterRenderer", "New SurfaceTextureSurfaceProducer ID: " + c5.id());
            return fVar;
        }
        long andIncrement = this.f3859b.getAndIncrement();
        ImageReaderSurfaceProducer imageReaderSurfaceProducer = new ImageReaderSurfaceProducer(andIncrement);
        q(andIncrement, imageReaderSurfaceProducer);
        k(imageReaderSurfaceProducer);
        this.f3864g.add(imageReaderSurfaceProducer);
        n2.b.f("FlutterRenderer", "New ImageReaderSurfaceProducer ID: " + andIncrement);
        return imageReaderSurfaceProducer;
    }

    @Override // io.flutter.view.TextureRegistry
    public TextureRegistry.SurfaceTextureEntry c() {
        n2.b.f("FlutterRenderer", "Creating a SurfaceTexture.");
        return s(new SurfaceTexture(0));
    }

    public void j(io.flutter.embedding.engine.renderer.d dVar) {
        this.f3858a.addIsDisplayingFlutterUiListener(dVar);
        if (this.f3861d) {
            dVar.f();
        }
    }

    void k(TextureRegistry.b bVar) {
        l();
        this.f3863f.add(new WeakReference<>(bVar));
    }

    public void m(ByteBuffer byteBuffer, int i5) {
        this.f3858a.dispatchPointerDataPacket(byteBuffer, i5);
    }

    public boolean n() {
        return this.f3861d;
    }

    public boolean o() {
        return this.f3858a.getIsSoftwareRenderingEnabled();
    }

    public void p(int i5) {
        Iterator<WeakReference<TextureRegistry.b>> it = this.f3863f.iterator();
        while (it.hasNext()) {
            TextureRegistry.b bVar = it.next().get();
            if (bVar != null) {
                bVar.onTrimMemory(i5);
            } else {
                it.remove();
            }
        }
    }

    public TextureRegistry.SurfaceTextureEntry s(SurfaceTexture surfaceTexture) {
        return r(this.f3859b.getAndIncrement(), surfaceTexture);
    }

    public void u(io.flutter.embedding.engine.renderer.d dVar) {
        this.f3858a.removeIsDisplayingFlutterUiListener(dVar);
    }

    void v(TextureRegistry.b bVar) {
        for (WeakReference<TextureRegistry.b> weakReference : this.f3863f) {
            if (weakReference.get() == bVar) {
                this.f3863f.remove(weakReference);
                return;
            }
        }
    }

    public void x(boolean z4) {
        this.f3858a.setSemanticsEnabled(z4);
    }

    public void y(h hVar) {
        if (hVar.a()) {
            n2.b.f("FlutterRenderer", "Setting viewport metrics\nSize: " + hVar.f3898b + " x " + hVar.f3899c + "\nPadding - L: " + hVar.f3903g + ", T: " + hVar.f3900d + ", R: " + hVar.f3901e + ", B: " + hVar.f3902f + "\nInsets - L: " + hVar.f3907k + ", T: " + hVar.f3904h + ", R: " + hVar.f3905i + ", B: " + hVar.f3906j + "\nSystem Gesture Insets - L: " + hVar.f3911o + ", T: " + hVar.f3908l + ", R: " + hVar.f3909m + ", B: " + hVar.f3909m + "\nDisplay Features: " + hVar.f3913q.size());
            int[] iArr = new int[hVar.f3913q.size() * 4];
            int[] iArr2 = new int[hVar.f3913q.size()];
            int[] iArr3 = new int[hVar.f3913q.size()];
            for (int i5 = 0; i5 < hVar.f3913q.size(); i5++) {
                c cVar = hVar.f3913q.get(i5);
                int i6 = i5 * 4;
                Rect rect = cVar.f3875a;
                iArr[i6] = rect.left;
                iArr[i6 + 1] = rect.top;
                iArr[i6 + 2] = rect.right;
                iArr[i6 + 3] = rect.bottom;
                iArr2[i5] = cVar.f3876b.f3888a;
                iArr3[i5] = cVar.f3877c.f3882a;
            }
            this.f3858a.setViewportMetrics(hVar.f3897a, hVar.f3898b, hVar.f3899c, hVar.f3900d, hVar.f3901e, hVar.f3902f, hVar.f3903g, hVar.f3904h, hVar.f3905i, hVar.f3906j, hVar.f3907k, hVar.f3908l, hVar.f3909m, hVar.f3910n, hVar.f3911o, hVar.f3912p, iArr, iArr2, iArr3);
        }
    }

    public void z(Surface surface, boolean z4) {
        if (!z4) {
            A();
        }
        this.f3860c = surface;
        if (z4) {
            this.f3858a.onSurfaceWindowChanged(surface);
        } else {
            this.f3858a.onSurfaceCreated(surface);
        }
    }
}
