package androidx.core.graphics.drawable;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Shader;
import android.graphics.drawable.AdaptiveIconDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import androidx.versionedparcelable.CustomVersionedParcelable;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.Charset;
/* loaded from: classes.dex */
public class IconCompat extends CustomVersionedParcelable {

    /* renamed from: k  reason: collision with root package name */
    static final PorterDuff.Mode f410k = PorterDuff.Mode.SRC_IN;

    /* renamed from: a  reason: collision with root package name */
    public int f411a;

    /* renamed from: b  reason: collision with root package name */
    Object f412b;

    /* renamed from: c  reason: collision with root package name */
    public byte[] f413c;

    /* renamed from: d  reason: collision with root package name */
    public Parcelable f414d;

    /* renamed from: e  reason: collision with root package name */
    public int f415e;

    /* renamed from: f  reason: collision with root package name */
    public int f416f;

    /* renamed from: g  reason: collision with root package name */
    public ColorStateList f417g;

    /* renamed from: h  reason: collision with root package name */
    PorterDuff.Mode f418h;

    /* renamed from: i  reason: collision with root package name */
    public String f419i;

    /* renamed from: j  reason: collision with root package name */
    public String f420j;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {
        static IconCompat a(Object obj) {
            k.d.a(obj);
            int d5 = d(obj);
            if (d5 != 2) {
                if (d5 != 4) {
                    if (d5 != 6) {
                        IconCompat iconCompat = new IconCompat(-1);
                        iconCompat.f412b = obj;
                        return iconCompat;
                    }
                    return IconCompat.c(e(obj));
                }
                return IconCompat.e(e(obj));
            }
            return IconCompat.h(null, c(obj), b(obj));
        }

        static int b(Object obj) {
            if (Build.VERSION.SDK_INT >= 28) {
                return c.a(obj);
            }
            try {
                return ((Integer) obj.getClass().getMethod("getResId", new Class[0]).invoke(obj, new Object[0])).intValue();
            } catch (IllegalAccessException e5) {
                Log.e("IconCompat", "Unable to get icon resource", e5);
                return 0;
            } catch (NoSuchMethodException e6) {
                Log.e("IconCompat", "Unable to get icon resource", e6);
                return 0;
            } catch (InvocationTargetException e7) {
                Log.e("IconCompat", "Unable to get icon resource", e7);
                return 0;
            }
        }

        static String c(Object obj) {
            if (Build.VERSION.SDK_INT >= 28) {
                return c.b(obj);
            }
            try {
                return (String) obj.getClass().getMethod("getResPackage", new Class[0]).invoke(obj, new Object[0]);
            } catch (IllegalAccessException e5) {
                Log.e("IconCompat", "Unable to get icon package", e5);
                return null;
            } catch (NoSuchMethodException e6) {
                Log.e("IconCompat", "Unable to get icon package", e6);
                return null;
            } catch (InvocationTargetException e7) {
                Log.e("IconCompat", "Unable to get icon package", e7);
                return null;
            }
        }

        static int d(Object obj) {
            StringBuilder sb;
            if (Build.VERSION.SDK_INT >= 28) {
                return c.c(obj);
            }
            try {
                return ((Integer) obj.getClass().getMethod("getType", new Class[0]).invoke(obj, new Object[0])).intValue();
            } catch (IllegalAccessException e5) {
                e = e5;
                sb = new StringBuilder();
                sb.append("Unable to get icon type ");
                sb.append(obj);
                Log.e("IconCompat", sb.toString(), e);
                return -1;
            } catch (NoSuchMethodException e6) {
                e = e6;
                sb = new StringBuilder();
                sb.append("Unable to get icon type ");
                sb.append(obj);
                Log.e("IconCompat", sb.toString(), e);
                return -1;
            } catch (InvocationTargetException e7) {
                e = e7;
                sb = new StringBuilder();
                sb.append("Unable to get icon type ");
                sb.append(obj);
                Log.e("IconCompat", sb.toString(), e);
                return -1;
            }
        }

        static Uri e(Object obj) {
            if (Build.VERSION.SDK_INT >= 28) {
                return c.d(obj);
            }
            try {
                return (Uri) obj.getClass().getMethod("getUri", new Class[0]).invoke(obj, new Object[0]);
            } catch (IllegalAccessException e5) {
                Log.e("IconCompat", "Unable to get icon uri", e5);
                return null;
            } catch (NoSuchMethodException e6) {
                Log.e("IconCompat", "Unable to get icon uri", e6);
                return null;
            } catch (InvocationTargetException e7) {
                Log.e("IconCompat", "Unable to get icon uri", e7);
                return null;
            }
        }

        static Drawable f(Icon icon, Context context) {
            return icon.loadDrawable(context);
        }

        /* JADX WARN: Code restructure failed: missing block: B:13:0x002c, code lost:
            if (r0 >= 26) goto L23;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        static android.graphics.drawable.Icon g(androidx.core.graphics.drawable.IconCompat r4, android.content.Context r5) {
            /*
                int r0 = r4.f411a
                r1 = 0
                r2 = 26
                switch(r0) {
                    case -1: goto Lb5;
                    case 0: goto L8;
                    case 1: goto L9c;
                    case 2: goto L91;
                    case 3: goto L84;
                    case 4: goto L7b;
                    case 5: goto L65;
                    case 6: goto L10;
                    default: goto L8;
                }
            L8:
                java.lang.IllegalArgumentException r4 = new java.lang.IllegalArgumentException
                java.lang.String r5 = "Unknown type"
                r4.<init>(r5)
                throw r4
            L10:
                int r0 = android.os.Build.VERSION.SDK_INT
                r3 = 30
                if (r0 < r3) goto L20
                android.net.Uri r5 = r4.m()
                android.graphics.drawable.Icon r5 = androidx.core.graphics.drawable.IconCompat.d.a(r5)
                goto La4
            L20:
                if (r5 == 0) goto L4a
                java.io.InputStream r5 = r4.n(r5)
                if (r5 == 0) goto L2f
                android.graphics.Bitmap r5 = android.graphics.BitmapFactory.decodeStream(r5)
                if (r0 < r2) goto L76
                goto L6d
            L2f:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = "Cannot load adaptive icon from uri: "
                r0.append(r1)
                android.net.Uri r4 = r4.m()
                r0.append(r4)
                java.lang.String r4 = r0.toString()
                r5.<init>(r4)
                throw r5
            L4a:
                java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = "Context is required to resolve the file uri of the icon: "
                r0.append(r1)
                android.net.Uri r4 = r4.m()
                r0.append(r4)
                java.lang.String r4 = r0.toString()
                r5.<init>(r4)
                throw r5
            L65:
                int r5 = android.os.Build.VERSION.SDK_INT
                if (r5 < r2) goto L72
                java.lang.Object r5 = r4.f412b
                android.graphics.Bitmap r5 = (android.graphics.Bitmap) r5
            L6d:
                android.graphics.drawable.Icon r5 = androidx.core.graphics.drawable.IconCompat.b.b(r5)
                goto La4
            L72:
                java.lang.Object r5 = r4.f412b
                android.graphics.Bitmap r5 = (android.graphics.Bitmap) r5
            L76:
                android.graphics.Bitmap r5 = androidx.core.graphics.drawable.IconCompat.b(r5, r1)
                goto La0
            L7b:
                java.lang.Object r5 = r4.f412b
                java.lang.String r5 = (java.lang.String) r5
                android.graphics.drawable.Icon r5 = android.graphics.drawable.Icon.createWithContentUri(r5)
                goto La4
            L84:
                java.lang.Object r5 = r4.f412b
                byte[] r5 = (byte[]) r5
                int r0 = r4.f415e
                int r1 = r4.f416f
                android.graphics.drawable.Icon r5 = android.graphics.drawable.Icon.createWithData(r5, r0, r1)
                goto La4
            L91:
                java.lang.String r5 = r4.k()
                int r0 = r4.f415e
                android.graphics.drawable.Icon r5 = android.graphics.drawable.Icon.createWithResource(r5, r0)
                goto La4
            L9c:
                java.lang.Object r5 = r4.f412b
                android.graphics.Bitmap r5 = (android.graphics.Bitmap) r5
            La0:
                android.graphics.drawable.Icon r5 = android.graphics.drawable.Icon.createWithBitmap(r5)
            La4:
                android.content.res.ColorStateList r0 = r4.f417g
                if (r0 == 0) goto Lab
                r5.setTintList(r0)
            Lab:
                android.graphics.PorterDuff$Mode r4 = r4.f418h
                android.graphics.PorterDuff$Mode r0 = androidx.core.graphics.drawable.IconCompat.f410k
                if (r4 == r0) goto Lb4
                r5.setTintMode(r4)
            Lb4:
                return r5
            Lb5:
                java.lang.Object r4 = r4.f412b
                android.graphics.drawable.Icon r4 = (android.graphics.drawable.Icon) r4
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.core.graphics.drawable.IconCompat.a.g(androidx.core.graphics.drawable.IconCompat, android.content.Context):android.graphics.drawable.Icon");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class b {
        static Drawable a(Drawable drawable, Drawable drawable2) {
            return new AdaptiveIconDrawable(drawable, drawable2);
        }

        static Icon b(Bitmap bitmap) {
            Icon createWithAdaptiveBitmap;
            createWithAdaptiveBitmap = Icon.createWithAdaptiveBitmap(bitmap);
            return createWithAdaptiveBitmap;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class c {
        static int a(Object obj) {
            int resId;
            resId = ((Icon) obj).getResId();
            return resId;
        }

        static String b(Object obj) {
            String resPackage;
            resPackage = ((Icon) obj).getResPackage();
            return resPackage;
        }

        static int c(Object obj) {
            int type;
            type = ((Icon) obj).getType();
            return type;
        }

        static Uri d(Object obj) {
            Uri uri;
            uri = ((Icon) obj).getUri();
            return uri;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class d {
        static Icon a(Uri uri) {
            Icon createWithAdaptiveBitmapContentUri;
            createWithAdaptiveBitmapContentUri = Icon.createWithAdaptiveBitmapContentUri(uri);
            return createWithAdaptiveBitmapContentUri;
        }
    }

    public IconCompat() {
        this.f411a = -1;
        this.f413c = null;
        this.f414d = null;
        this.f415e = 0;
        this.f416f = 0;
        this.f417g = null;
        this.f418h = f410k;
        this.f419i = null;
    }

    IconCompat(int i5) {
        this.f413c = null;
        this.f414d = null;
        this.f415e = 0;
        this.f416f = 0;
        this.f417g = null;
        this.f418h = f410k;
        this.f419i = null;
        this.f411a = i5;
    }

    public static IconCompat a(Icon icon) {
        return a.a(icon);
    }

    static Bitmap b(Bitmap bitmap, boolean z4) {
        int min = (int) (Math.min(bitmap.getWidth(), bitmap.getHeight()) * 0.6666667f);
        Bitmap createBitmap = Bitmap.createBitmap(min, min, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint(3);
        float f5 = min;
        float f6 = 0.5f * f5;
        float f7 = 0.9166667f * f6;
        if (z4) {
            float f8 = 0.010416667f * f5;
            paint.setColor(0);
            paint.setShadowLayer(f8, 0.0f, f5 * 0.020833334f, 1023410176);
            canvas.drawCircle(f6, f6, f7, paint);
            paint.setShadowLayer(f8, 0.0f, 0.0f, 503316480);
            canvas.drawCircle(f6, f6, f7, paint);
            paint.clearShadowLayer();
        }
        paint.setColor(-16777216);
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        BitmapShader bitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
        Matrix matrix = new Matrix();
        matrix.setTranslate((-(bitmap.getWidth() - min)) / 2.0f, (-(bitmap.getHeight() - min)) / 2.0f);
        bitmapShader.setLocalMatrix(matrix);
        paint.setShader(bitmapShader);
        canvas.drawCircle(f6, f6, f7, paint);
        canvas.setBitmap(null);
        return createBitmap;
    }

    public static IconCompat c(Uri uri) {
        k.c.c(uri);
        return d(uri.toString());
    }

    public static IconCompat d(String str) {
        k.c.c(str);
        IconCompat iconCompat = new IconCompat(6);
        iconCompat.f412b = str;
        return iconCompat;
    }

    public static IconCompat e(Uri uri) {
        k.c.c(uri);
        return f(uri.toString());
    }

    public static IconCompat f(String str) {
        k.c.c(str);
        IconCompat iconCompat = new IconCompat(4);
        iconCompat.f412b = str;
        return iconCompat;
    }

    public static IconCompat g(Context context, int i5) {
        k.c.c(context);
        return h(context.getResources(), context.getPackageName(), i5);
    }

    public static IconCompat h(Resources resources, String str, int i5) {
        k.c.c(str);
        if (i5 != 0) {
            IconCompat iconCompat = new IconCompat(2);
            iconCompat.f415e = i5;
            if (resources != null) {
                try {
                    iconCompat.f412b = resources.getResourceName(i5);
                } catch (Resources.NotFoundException unused) {
                    throw new IllegalArgumentException("Icon resource cannot be found");
                }
            } else {
                iconCompat.f412b = str;
            }
            iconCompat.f420j = str;
            return iconCompat;
        }
        throw new IllegalArgumentException("Drawable resource ID must not be 0");
    }

    private static String t(int i5) {
        switch (i5) {
            case 1:
                return "BITMAP";
            case 2:
                return "RESOURCE";
            case 3:
                return "DATA";
            case 4:
                return "URI";
            case 5:
                return "BITMAP_MASKABLE";
            case 6:
                return "URI_MASKABLE";
            default:
                return "UNKNOWN";
        }
    }

    public Bitmap i() {
        int i5 = this.f411a;
        if (i5 == -1 && Build.VERSION.SDK_INT >= 23) {
            Object obj = this.f412b;
            if (obj instanceof Bitmap) {
                return (Bitmap) obj;
            }
            return null;
        } else if (i5 == 1) {
            return (Bitmap) this.f412b;
        } else {
            if (i5 == 5) {
                return b((Bitmap) this.f412b, true);
            }
            throw new IllegalStateException("called getBitmap() on " + this);
        }
    }

    public int j() {
        int i5 = this.f411a;
        if (i5 != -1 || Build.VERSION.SDK_INT < 23) {
            if (i5 == 2) {
                return this.f415e;
            }
            throw new IllegalStateException("called getResId() on " + this);
        }
        return a.b(this.f412b);
    }

    public String k() {
        int i5 = this.f411a;
        if (i5 != -1 || Build.VERSION.SDK_INT < 23) {
            if (i5 == 2) {
                String str = this.f420j;
                return (str == null || TextUtils.isEmpty(str)) ? ((String) this.f412b).split(":", -1)[0] : this.f420j;
            }
            throw new IllegalStateException("called getResPackage() on " + this);
        }
        return a.c(this.f412b);
    }

    public int l() {
        int i5 = this.f411a;
        return (i5 != -1 || Build.VERSION.SDK_INT < 23) ? i5 : a.d(this.f412b);
    }

    public Uri m() {
        int i5 = this.f411a;
        if (i5 != -1 || Build.VERSION.SDK_INT < 23) {
            if (i5 == 4 || i5 == 6) {
                return Uri.parse((String) this.f412b);
            }
            throw new IllegalStateException("called getUri() on " + this);
        }
        return a.e(this.f412b);
    }

    public InputStream n(Context context) {
        StringBuilder sb;
        String str;
        Uri m5 = m();
        String scheme = m5.getScheme();
        if ("content".equals(scheme) || "file".equals(scheme)) {
            try {
                return context.getContentResolver().openInputStream(m5);
            } catch (Exception e5) {
                e = e5;
                sb = new StringBuilder();
                str = "Unable to load image from URI: ";
            }
        } else {
            try {
                return new FileInputStream(new File((String) this.f412b));
            } catch (FileNotFoundException e6) {
                e = e6;
                sb = new StringBuilder();
                str = "Unable to load image from path: ";
            }
        }
        sb.append(str);
        sb.append(m5);
        Log.w("IconCompat", sb.toString(), e);
        return null;
    }

    public void o() {
        Parcelable parcelable;
        this.f418h = PorterDuff.Mode.valueOf(this.f419i);
        switch (this.f411a) {
            case -1:
                parcelable = this.f414d;
                if (parcelable == null) {
                    throw new IllegalArgumentException("Invalid icon");
                }
                break;
            case 0:
            default:
                return;
            case 1:
            case 5:
                parcelable = this.f414d;
                if (parcelable == null) {
                    byte[] bArr = this.f413c;
                    this.f412b = bArr;
                    this.f411a = 3;
                    this.f415e = 0;
                    this.f416f = bArr.length;
                    return;
                }
                break;
            case 2:
            case 4:
            case 6:
                String str = new String(this.f413c, Charset.forName("UTF-16"));
                this.f412b = str;
                if (this.f411a == 2 && this.f420j == null) {
                    this.f420j = str.split(":", -1)[0];
                    return;
                }
                return;
            case 3:
                this.f412b = this.f413c;
                return;
        }
        this.f412b = parcelable;
    }

    public void p(boolean z4) {
        this.f419i = this.f418h.name();
        switch (this.f411a) {
            case -1:
                if (z4) {
                    throw new IllegalArgumentException("Can't serialize Icon created with IconCompat#createFromIcon");
                }
                break;
            case 0:
            default:
                return;
            case 1:
            case 5:
                if (z4) {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    ((Bitmap) this.f412b).compress(Bitmap.CompressFormat.PNG, 90, byteArrayOutputStream);
                    this.f413c = byteArrayOutputStream.toByteArray();
                    return;
                }
                break;
            case 2:
                this.f413c = ((String) this.f412b).getBytes(Charset.forName("UTF-16"));
                return;
            case 3:
                this.f413c = (byte[]) this.f412b;
                return;
            case 4:
            case 6:
                this.f413c = this.f412b.toString().getBytes(Charset.forName("UTF-16"));
                return;
        }
        this.f414d = (Parcelable) this.f412b;
    }

    public Bundle q() {
        Parcelable parcelable;
        Bundle bundle = new Bundle();
        switch (this.f411a) {
            case -1:
                parcelable = (Parcelable) this.f412b;
                bundle.putParcelable("obj", parcelable);
                break;
            case 0:
            default:
                throw new IllegalArgumentException("Invalid icon");
            case 1:
            case 5:
                parcelable = (Bitmap) this.f412b;
                bundle.putParcelable("obj", parcelable);
                break;
            case 2:
            case 4:
            case 6:
                bundle.putString("obj", (String) this.f412b);
                break;
            case 3:
                bundle.putByteArray("obj", (byte[]) this.f412b);
                break;
        }
        bundle.putInt("type", this.f411a);
        bundle.putInt("int1", this.f415e);
        bundle.putInt("int2", this.f416f);
        bundle.putString("string1", this.f420j);
        ColorStateList colorStateList = this.f417g;
        if (colorStateList != null) {
            bundle.putParcelable("tint_list", colorStateList);
        }
        PorterDuff.Mode mode = this.f418h;
        if (mode != f410k) {
            bundle.putString("tint_mode", mode.name());
        }
        return bundle;
    }

    @Deprecated
    public Icon r() {
        return s(null);
    }

    public Icon s(Context context) {
        if (Build.VERSION.SDK_INT >= 23) {
            return a.g(this, context);
        }
        throw new UnsupportedOperationException("This method is only supported on API level 23+");
    }

    public String toString() {
        int height;
        if (this.f411a == -1) {
            return String.valueOf(this.f412b);
        }
        StringBuilder sb = new StringBuilder("Icon(typ=");
        sb.append(t(this.f411a));
        switch (this.f411a) {
            case 1:
            case 5:
                sb.append(" size=");
                sb.append(((Bitmap) this.f412b).getWidth());
                sb.append("x");
                height = ((Bitmap) this.f412b).getHeight();
                sb.append(height);
                break;
            case 2:
                sb.append(" pkg=");
                sb.append(this.f420j);
                sb.append(" id=");
                sb.append(String.format("0x%08x", Integer.valueOf(j())));
                break;
            case 3:
                sb.append(" len=");
                sb.append(this.f415e);
                if (this.f416f != 0) {
                    sb.append(" off=");
                    height = this.f416f;
                    sb.append(height);
                    break;
                }
                break;
            case 4:
            case 6:
                sb.append(" uri=");
                sb.append(this.f412b);
                break;
        }
        if (this.f417g != null) {
            sb.append(" tint=");
            sb.append(this.f417g);
        }
        if (this.f418h != f410k) {
            sb.append(" mode=");
            sb.append(this.f418h);
        }
        sb.append(")");
        return sb.toString();
    }
}
