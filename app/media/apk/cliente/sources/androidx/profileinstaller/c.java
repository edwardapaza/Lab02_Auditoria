package androidx.profileinstaller;

import android.content.res.AssetManager;
import android.os.Build;
import androidx.profileinstaller.i;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Executor;
/* loaded from: classes.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private final AssetManager f628a;

    /* renamed from: b  reason: collision with root package name */
    private final Executor f629b;

    /* renamed from: c  reason: collision with root package name */
    private final i.c f630c;

    /* renamed from: e  reason: collision with root package name */
    private final File f632e;

    /* renamed from: f  reason: collision with root package name */
    private final String f633f;

    /* renamed from: g  reason: collision with root package name */
    private final String f634g;

    /* renamed from: h  reason: collision with root package name */
    private final String f635h;

    /* renamed from: j  reason: collision with root package name */
    private d[] f637j;

    /* renamed from: k  reason: collision with root package name */
    private byte[] f638k;

    /* renamed from: i  reason: collision with root package name */
    private boolean f636i = false;

    /* renamed from: d  reason: collision with root package name */
    private final byte[] f631d = d();

    public c(AssetManager assetManager, Executor executor, i.c cVar, String str, String str2, String str3, File file) {
        this.f628a = assetManager;
        this.f629b = executor;
        this.f630c = cVar;
        this.f633f = str;
        this.f634g = str2;
        this.f635h = str3;
        this.f632e = file;
    }

    private c b(d[] dVarArr, byte[] bArr) {
        i.c cVar;
        int i5;
        InputStream h5;
        try {
            h5 = h(this.f628a, this.f635h);
        } catch (FileNotFoundException e5) {
            e = e5;
            cVar = this.f630c;
            i5 = 9;
            cVar.b(i5, e);
            return null;
        } catch (IOException e6) {
            e = e6;
            cVar = this.f630c;
            i5 = 7;
            cVar.b(i5, e);
            return null;
        } catch (IllegalStateException e7) {
            e = e7;
            this.f637j = null;
            cVar = this.f630c;
            i5 = 8;
            cVar.b(i5, e);
            return null;
        }
        if (h5 != null) {
            this.f637j = n.q(h5, n.o(h5, n.f666b), bArr, dVarArr);
            h5.close();
            return this;
        }
        if (h5 != null) {
            h5.close();
        }
        return null;
    }

    private void c() {
        if (!this.f636i) {
            throw new IllegalStateException("This device doesn't support aot. Did you call deviceSupportsAotProfile()?");
        }
    }

    private static byte[] d() {
        int i5 = Build.VERSION.SDK_INT;
        if (i5 < 24 || i5 > 34) {
            return null;
        }
        switch (i5) {
            case 24:
            case 25:
                return p.f681e;
            case 26:
                return p.f680d;
            case 27:
                return p.f679c;
            case 28:
            case 29:
            case 30:
                return p.f678b;
            case 31:
            case 32:
            case 33:
            case 34:
                return p.f677a;
            default:
                return null;
        }
    }

    private InputStream f(AssetManager assetManager) {
        i.c cVar;
        int i5;
        try {
            return h(assetManager, this.f634g);
        } catch (FileNotFoundException e5) {
            e = e5;
            cVar = this.f630c;
            i5 = 6;
            cVar.b(i5, e);
            return null;
        } catch (IOException e6) {
            e = e6;
            cVar = this.f630c;
            i5 = 7;
            cVar.b(i5, e);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g(int i5, Object obj) {
        this.f630c.b(i5, obj);
    }

    private InputStream h(AssetManager assetManager, String str) {
        try {
            return assetManager.openFd(str).createInputStream();
        } catch (FileNotFoundException e5) {
            String message = e5.getMessage();
            if (message == null || !message.contains("compressed")) {
                return null;
            }
            this.f630c.a(5, null);
            return null;
        }
    }

    private d[] j(InputStream inputStream) {
        try {
        } catch (IOException e5) {
            this.f630c.b(7, e5);
        }
        try {
            try {
                d[] w5 = n.w(inputStream, n.o(inputStream, n.f665a), this.f633f);
                try {
                    inputStream.close();
                    return w5;
                } catch (IOException e6) {
                    this.f630c.b(7, e6);
                    return w5;
                }
            } catch (Throwable th) {
                try {
                    inputStream.close();
                } catch (IOException e7) {
                    this.f630c.b(7, e7);
                }
                throw th;
            }
        } catch (IOException e8) {
            this.f630c.b(7, e8);
            inputStream.close();
            return null;
        } catch (IllegalStateException e9) {
            this.f630c.b(8, e9);
            inputStream.close();
            return null;
        }
    }

    private static boolean k() {
        int i5 = Build.VERSION.SDK_INT;
        if (i5 < 24 || i5 > 34) {
            return false;
        }
        if (i5 != 24 && i5 != 25) {
            switch (i5) {
                case 31:
                case 32:
                case 33:
                case 34:
                    break;
                default:
                    return false;
            }
        }
        return true;
    }

    private void l(final int i5, final Object obj) {
        this.f629b.execute(new Runnable() { // from class: androidx.profileinstaller.b
            @Override // java.lang.Runnable
            public final void run() {
                c.this.g(i5, obj);
            }
        });
    }

    public boolean e() {
        if (this.f631d == null) {
            l(3, Integer.valueOf(Build.VERSION.SDK_INT));
            return false;
        }
        if (!this.f632e.exists()) {
            try {
                this.f632e.createNewFile();
            } catch (IOException unused) {
                l(4, null);
                return false;
            }
        } else if (!this.f632e.canWrite()) {
            l(4, null);
            return false;
        }
        this.f636i = true;
        return true;
    }

    public c i() {
        c b5;
        c();
        if (this.f631d == null) {
            return this;
        }
        InputStream f5 = f(this.f628a);
        if (f5 != null) {
            this.f637j = j(f5);
        }
        d[] dVarArr = this.f637j;
        return (dVarArr == null || !k() || (b5 = b(dVarArr, this.f631d)) == null) ? this : b5;
    }

    public c m() {
        i.c cVar;
        int i5;
        ByteArrayOutputStream byteArrayOutputStream;
        d[] dVarArr = this.f637j;
        byte[] bArr = this.f631d;
        if (dVarArr != null && bArr != null) {
            c();
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    n.E(byteArrayOutputStream, bArr);
                } catch (Throwable th) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            } catch (IOException e5) {
                e = e5;
                cVar = this.f630c;
                i5 = 7;
                cVar.b(i5, e);
                this.f637j = null;
                return this;
            } catch (IllegalStateException e6) {
                e = e6;
                cVar = this.f630c;
                i5 = 8;
                cVar.b(i5, e);
                this.f637j = null;
                return this;
            }
            if (!n.B(byteArrayOutputStream, bArr, dVarArr)) {
                this.f630c.b(5, null);
                this.f637j = null;
                byteArrayOutputStream.close();
                return this;
            }
            this.f638k = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            this.f637j = null;
        }
        return this;
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [byte[], androidx.profileinstaller.d[]] */
    public boolean n() {
        byte[] bArr = this.f638k;
        if (bArr == null) {
            return false;
        }
        c();
        try {
            try {
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(this.f632e);
                    e.l(byteArrayInputStream, fileOutputStream);
                    l(1, null);
                    fileOutputStream.close();
                    byteArrayInputStream.close();
                    return true;
                } catch (Throwable th) {
                    try {
                        byteArrayInputStream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            } catch (FileNotFoundException e5) {
                l(6, e5);
                return false;
            } catch (IOException e6) {
                l(7, e6);
                return false;
            }
        } finally {
            this.f638k = null;
            this.f637j = null;
        }
    }
}
