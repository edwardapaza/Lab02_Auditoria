package io.flutter.plugin.platform;

import android.media.Image;
import android.media.ImageReader;
import android.os.Build;
import android.os.Handler;
import android.view.Surface;
import io.flutter.view.TextureRegistry;
/* loaded from: classes.dex */
public class b implements n {

    /* renamed from: a  reason: collision with root package name */
    private TextureRegistry.ImageTextureEntry f4004a;

    /* renamed from: b  reason: collision with root package name */
    private ImageReader f4005b;

    /* renamed from: c  reason: collision with root package name */
    private int f4006c = 0;

    /* renamed from: d  reason: collision with root package name */
    private int f4007d = 0;

    /* renamed from: e  reason: collision with root package name */
    private final Handler f4008e = new Handler();

    /* renamed from: f  reason: collision with root package name */
    private final ImageReader.OnImageAvailableListener f4009f = new a();

    /* loaded from: classes.dex */
    class a implements ImageReader.OnImageAvailableListener {
        a() {
        }

        @Override // android.media.ImageReader.OnImageAvailableListener
        public void onImageAvailable(ImageReader imageReader) {
            Image image;
            try {
                image = imageReader.acquireLatestImage();
            } catch (IllegalStateException e5) {
                n2.b.b("ImageReaderPlatformViewRenderTarget", "onImageAvailable acquireLatestImage failed: " + e5.toString());
                image = null;
            }
            if (image == null) {
                return;
            }
            b.this.f4004a.pushImage(image);
        }
    }

    public b(TextureRegistry.ImageTextureEntry imageTextureEntry) {
        if (Build.VERSION.SDK_INT < 29) {
            throw new UnsupportedOperationException("ImageReaderPlatformViewRenderTarget requires API version 29+");
        }
        this.f4004a = imageTextureEntry;
    }

    private void c() {
        if (this.f4005b != null) {
            this.f4004a.pushImage(null);
            this.f4005b.close();
            this.f4005b = null;
        }
    }

    @Override // io.flutter.plugin.platform.n
    public void a(int i5, int i6) {
        if (this.f4005b != null && this.f4006c == i5 && this.f4007d == i6) {
            return;
        }
        c();
        this.f4006c = i5;
        this.f4007d = i6;
        this.f4005b = d();
    }

    protected ImageReader d() {
        int i5 = Build.VERSION.SDK_INT;
        if (i5 >= 33) {
            return f();
        }
        if (i5 >= 29) {
            return e();
        }
        throw new UnsupportedOperationException("ImageReaderPlatformViewRenderTarget requires API version 29+");
    }

    protected ImageReader e() {
        ImageReader newInstance;
        newInstance = ImageReader.newInstance(this.f4006c, this.f4007d, 34, 4, 256L);
        newInstance.setOnImageAvailableListener(this.f4009f, this.f4008e);
        return newInstance;
    }

    protected ImageReader f() {
        ImageReader.Builder builder = new ImageReader.Builder(this.f4006c, this.f4007d);
        builder.setMaxImages(4);
        builder.setImageFormat(34);
        builder.setUsage(256L);
        ImageReader build = builder.build();
        build.setOnImageAvailableListener(this.f4009f, this.f4008e);
        return build;
    }

    @Override // io.flutter.plugin.platform.n
    public int getHeight() {
        return this.f4007d;
    }

    @Override // io.flutter.plugin.platform.n
    public long getId() {
        return this.f4004a.id();
    }

    @Override // io.flutter.plugin.platform.n
    public Surface getSurface() {
        return this.f4005b.getSurface();
    }

    @Override // io.flutter.plugin.platform.n
    public int getWidth() {
        return this.f4006c;
    }

    @Override // io.flutter.plugin.platform.n
    public void release() {
        c();
        this.f4004a = null;
    }

    @Override // io.flutter.plugin.platform.n
    public /* synthetic */ void scheduleFrame() {
        m.a(this);
    }
}
