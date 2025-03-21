package io.flutter.plugin.platform;

import android.graphics.SurfaceTexture;
import android.os.Build;
import android.view.Surface;
import io.flutter.view.TextureRegistry;
/* loaded from: classes.dex */
public class f0 implements n {

    /* renamed from: a  reason: collision with root package name */
    private final TextureRegistry.SurfaceTextureEntry f4015a;

    /* renamed from: b  reason: collision with root package name */
    private SurfaceTexture f4016b;

    /* renamed from: c  reason: collision with root package name */
    private Surface f4017c;

    /* renamed from: d  reason: collision with root package name */
    private int f4018d = 0;

    /* renamed from: e  reason: collision with root package name */
    private int f4019e = 0;

    /* renamed from: f  reason: collision with root package name */
    private boolean f4020f = false;

    /* renamed from: g  reason: collision with root package name */
    private final TextureRegistry.b f4021g;

    /* loaded from: classes.dex */
    class a implements TextureRegistry.b {
        a() {
        }

        @Override // io.flutter.view.TextureRegistry.b
        public void onTrimMemory(int i5) {
            if (i5 != 80 || Build.VERSION.SDK_INT < 29) {
                return;
            }
            f0.this.f4020f = true;
        }
    }

    public f0(TextureRegistry.SurfaceTextureEntry surfaceTextureEntry) {
        a aVar = new a();
        this.f4021g = aVar;
        if (Build.VERSION.SDK_INT < 23) {
            throw new UnsupportedOperationException("Platform views cannot be displayed below API level 23You can prevent this issue by setting `minSdkVersion: 23` in build.gradle.");
        }
        this.f4015a = surfaceTextureEntry;
        this.f4016b = surfaceTextureEntry.surfaceTexture();
        surfaceTextureEntry.setOnTrimMemoryListener(aVar);
    }

    private void d() {
        Surface surface = this.f4017c;
        if (surface == null || this.f4020f) {
            if (surface != null) {
                surface.release();
                this.f4017c = null;
            }
            this.f4017c = c();
            this.f4020f = false;
        }
    }

    @Override // io.flutter.plugin.platform.n
    public void a(int i5, int i6) {
        this.f4018d = i5;
        this.f4019e = i6;
        SurfaceTexture surfaceTexture = this.f4016b;
        if (surfaceTexture != null) {
            surfaceTexture.setDefaultBufferSize(i5, i6);
        }
    }

    protected Surface c() {
        return new Surface(this.f4016b);
    }

    @Override // io.flutter.plugin.platform.n
    public int getHeight() {
        return this.f4019e;
    }

    @Override // io.flutter.plugin.platform.n
    public long getId() {
        return this.f4015a.id();
    }

    @Override // io.flutter.plugin.platform.n
    public Surface getSurface() {
        boolean isReleased;
        d();
        SurfaceTexture surfaceTexture = this.f4016b;
        if (surfaceTexture != null) {
            isReleased = surfaceTexture.isReleased();
            if (isReleased) {
                return null;
            }
            return this.f4017c;
        }
        return null;
    }

    @Override // io.flutter.plugin.platform.n
    public int getWidth() {
        return this.f4018d;
    }

    @Override // io.flutter.plugin.platform.n
    public void release() {
        this.f4016b = null;
        Surface surface = this.f4017c;
        if (surface != null) {
            surface.release();
            this.f4017c = null;
        }
    }

    @Override // io.flutter.plugin.platform.n
    public /* synthetic */ void scheduleFrame() {
        m.a(this);
    }
}
