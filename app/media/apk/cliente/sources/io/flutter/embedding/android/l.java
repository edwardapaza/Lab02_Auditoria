package io.flutter.embedding.android;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorSpace;
import android.graphics.Paint;
import android.hardware.HardwareBuffer;
import android.media.Image;
import android.media.ImageReader;
import android.os.Build;
import android.view.Surface;
import android.view.View;
import io.flutter.embedding.engine.renderer.FlutterRenderer;
import java.nio.ByteBuffer;
import java.util.Locale;
/* loaded from: classes.dex */
public class l extends View implements io.flutter.embedding.engine.renderer.e {

    /* renamed from: a  reason: collision with root package name */
    private ImageReader f3696a;

    /* renamed from: b  reason: collision with root package name */
    private Image f3697b;

    /* renamed from: c  reason: collision with root package name */
    private Bitmap f3698c;

    /* renamed from: d  reason: collision with root package name */
    private FlutterRenderer f3699d;

    /* renamed from: e  reason: collision with root package name */
    private b f3700e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f3701f;

    /* loaded from: classes.dex */
    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f3702a;

        static {
            int[] iArr = new int[b.values().length];
            f3702a = iArr;
            try {
                iArr[b.background.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3702a[b.overlay.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* loaded from: classes.dex */
    public enum b {
        background,
        overlay
    }

    public l(Context context, int i5, int i6, b bVar) {
        this(context, h(i5, i6), bVar);
    }

    l(Context context, ImageReader imageReader, b bVar) {
        super(context, null);
        this.f3701f = false;
        this.f3696a = imageReader;
        this.f3700e = bVar;
        i();
    }

    private void f() {
        Image image = this.f3697b;
        if (image != null) {
            image.close();
            this.f3697b = null;
        }
    }

    private static ImageReader h(int i5, int i6) {
        int i7;
        int i8;
        ImageReader newInstance;
        if (i5 <= 0) {
            j("ImageReader width must be greater than 0, but given width=%d, set width=1", Integer.valueOf(i5));
            i7 = 1;
        } else {
            i7 = i5;
        }
        if (i6 <= 0) {
            j("ImageReader height must be greater than 0, but given height=%d, set height=1", Integer.valueOf(i6));
            i8 = 1;
        } else {
            i8 = i6;
        }
        if (Build.VERSION.SDK_INT >= 29) {
            newInstance = ImageReader.newInstance(i7, i8, 1, 3, 768L);
            return newInstance;
        }
        return ImageReader.newInstance(i7, i8, 1, 3);
    }

    private void i() {
        setAlpha(0.0f);
    }

    private static void j(String str, Object... objArr) {
        n2.b.g("FlutterImageView", String.format(Locale.US, str, objArr));
    }

    private void l() {
        HardwareBuffer hardwareBuffer;
        Bitmap wrapHardwareBuffer;
        if (Build.VERSION.SDK_INT >= 29) {
            hardwareBuffer = this.f3697b.getHardwareBuffer();
            wrapHardwareBuffer = Bitmap.wrapHardwareBuffer(hardwareBuffer, ColorSpace.get(ColorSpace.Named.SRGB));
            this.f3698c = wrapHardwareBuffer;
            hardwareBuffer.close();
            return;
        }
        Image.Plane[] planes = this.f3697b.getPlanes();
        if (planes.length != 1) {
            return;
        }
        Image.Plane plane = planes[0];
        int rowStride = plane.getRowStride() / plane.getPixelStride();
        int height = this.f3697b.getHeight();
        Bitmap bitmap = this.f3698c;
        if (bitmap == null || bitmap.getWidth() != rowStride || this.f3698c.getHeight() != height) {
            this.f3698c = Bitmap.createBitmap(rowStride, height, Bitmap.Config.ARGB_8888);
        }
        ByteBuffer buffer = plane.getBuffer();
        buffer.rewind();
        this.f3698c.copyPixelsFromBuffer(buffer);
    }

    @Override // io.flutter.embedding.engine.renderer.e
    public void a() {
        if (this.f3701f) {
            setAlpha(0.0f);
            e();
            this.f3698c = null;
            f();
            invalidate();
            this.f3701f = false;
        }
    }

    @Override // io.flutter.embedding.engine.renderer.e
    public void b() {
    }

    @Override // io.flutter.embedding.engine.renderer.e
    public void c(FlutterRenderer flutterRenderer) {
        if (a.f3702a[this.f3700e.ordinal()] == 1) {
            flutterRenderer.C(this.f3696a.getSurface());
        }
        setAlpha(1.0f);
        this.f3699d = flutterRenderer;
        this.f3701f = true;
    }

    @Override // io.flutter.embedding.engine.renderer.e
    public void d() {
    }

    public boolean e() {
        if (this.f3701f) {
            Image acquireLatestImage = this.f3696a.acquireLatestImage();
            if (acquireLatestImage != null) {
                f();
                this.f3697b = acquireLatestImage;
                invalidate();
            }
            return acquireLatestImage != null;
        }
        return false;
    }

    public void g() {
        this.f3696a.close();
    }

    @Override // io.flutter.embedding.engine.renderer.e
    public FlutterRenderer getAttachedRenderer() {
        return this.f3699d;
    }

    public ImageReader getImageReader() {
        return this.f3696a;
    }

    public Surface getSurface() {
        return this.f3696a.getSurface();
    }

    public void k(int i5, int i6) {
        if (this.f3699d == null) {
            return;
        }
        if (i5 == this.f3696a.getWidth() && i6 == this.f3696a.getHeight()) {
            return;
        }
        f();
        g();
        this.f3696a = h(i5, i6);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f3697b != null) {
            l();
        }
        Bitmap bitmap = this.f3698c;
        if (bitmap != null) {
            canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i5, int i6, int i7, int i8) {
        if (!(i5 == this.f3696a.getWidth() && i6 == this.f3696a.getHeight()) && this.f3700e == b.background && this.f3701f) {
            k(i5, i6);
            this.f3699d.C(this.f3696a.getSurface());
        }
    }
}
