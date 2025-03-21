package io.flutter.plugin.platform;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.ClipData;
import android.content.ClipDescription;
import android.content.ClipboardManager;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.view.View;
import android.view.Window;
import androidx.core.view.j0;
import io.flutter.plugin.platform.g;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import y2.k;
/* loaded from: classes.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    private final Activity f4023a;

    /* renamed from: b  reason: collision with root package name */
    private final y2.k f4024b;

    /* renamed from: c  reason: collision with root package name */
    private final d f4025c;

    /* renamed from: d  reason: collision with root package name */
    private k.j f4026d;

    /* renamed from: e  reason: collision with root package name */
    private int f4027e;

    /* renamed from: f  reason: collision with root package name */
    final k.h f4028f;

    /* loaded from: classes.dex */
    class a implements k.h {
        a() {
        }

        @Override // y2.k.h
        public void a(k.i iVar) {
            g.this.s(iVar);
        }

        @Override // y2.k.h
        public void b() {
            g.this.t();
        }

        @Override // y2.k.h
        public void c(k.c cVar) {
            g.this.x(cVar);
        }

        @Override // y2.k.h
        public void d(List<k.l> list) {
            g.this.A(list);
        }

        @Override // y2.k.h
        public void e() {
            g.this.y();
        }

        @Override // y2.k.h
        public void f() {
            g.this.u();
        }

        @Override // y2.k.h
        public void g(boolean z4) {
            g.this.w(z4);
        }

        @Override // y2.k.h
        public void h(String str) {
            g.this.v(str);
        }

        @Override // y2.k.h
        public CharSequence i(k.e eVar) {
            return g.this.r(eVar);
        }

        @Override // y2.k.h
        public void j(k.j jVar) {
            g.this.C(jVar);
        }

        @Override // y2.k.h
        public void k(k.EnumC0132k enumC0132k) {
            g.this.z(enumC0132k);
        }

        @Override // y2.k.h
        public void l(int i5) {
            g.this.B(i5);
        }

        @Override // y2.k.h
        public void m(k.g gVar) {
            g.this.F(gVar);
        }

        @Override // y2.k.h
        public void n(String str) {
            g.this.D(str);
        }

        @Override // y2.k.h
        public boolean o() {
            return g.this.p();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b implements View.OnSystemUiVisibilityChangeListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ View f4030a;

        b(View view) {
            this.f4030a = view;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(int i5) {
            y2.k kVar;
            boolean z4;
            if ((i5 & 4) == 0) {
                kVar = g.this.f4024b;
                z4 = true;
            } else {
                kVar = g.this.f4024b;
                z4 = false;
            }
            kVar.m(z4);
        }

        @Override // android.view.View.OnSystemUiVisibilityChangeListener
        public void onSystemUiVisibilityChange(final int i5) {
            this.f4030a.post(new Runnable() { // from class: io.flutter.plugin.platform.h
                @Override // java.lang.Runnable
                public final void run() {
                    g.b.this.b(i5);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static /* synthetic */ class c {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f4032a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f4033b;

        /* renamed from: c  reason: collision with root package name */
        static final /* synthetic */ int[] f4034c;

        static {
            int[] iArr = new int[k.d.values().length];
            f4034c = iArr;
            try {
                iArr[k.d.DARK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f4034c[k.d.LIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[k.l.values().length];
            f4033b = iArr2;
            try {
                iArr2[k.l.TOP_OVERLAYS.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f4033b[k.l.BOTTOM_OVERLAYS.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr3 = new int[k.g.values().length];
            f4032a = iArr3;
            try {
                iArr3[k.g.STANDARD.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f4032a[k.g.LIGHT_IMPACT.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f4032a[k.g.MEDIUM_IMPACT.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f4032a[k.g.HEAVY_IMPACT.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f4032a[k.g.SELECTION_CLICK.ordinal()] = 5;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    /* loaded from: classes.dex */
    public interface d {
        boolean b();

        void g(boolean z4);
    }

    public g(Activity activity, y2.k kVar, d dVar) {
        a aVar = new a();
        this.f4028f = aVar;
        this.f4023a = activity;
        this.f4024b = kVar;
        kVar.l(aVar);
        this.f4025c = dVar;
        this.f4027e = 1280;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A(List<k.l> list) {
        int i5 = list.size() == 0 ? 5894 : 1798;
        for (int i6 = 0; i6 < list.size(); i6++) {
            int i7 = c.f4033b[list.get(i6).ordinal()];
            if (i7 == 1) {
                i5 &= -5;
            } else if (i7 == 2) {
                i5 = i5 & (-513) & (-3);
            }
        }
        this.f4027e = i5;
        E();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B(int i5) {
        this.f4023a.setRequestedOrientation(i5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C(k.j jVar) {
        Window window = this.f4023a.getWindow();
        j0 j0Var = new j0(window, window.getDecorView());
        int i5 = Build.VERSION.SDK_INT;
        if (i5 < 30) {
            window.addFlags(Integer.MIN_VALUE);
            window.clearFlags(201326592);
        }
        if (i5 >= 23) {
            k.d dVar = jVar.f8672b;
            if (dVar != null) {
                int i6 = c.f4034c[dVar.ordinal()];
                if (i6 == 1) {
                    j0Var.b(true);
                } else if (i6 == 2) {
                    j0Var.b(false);
                }
            }
            Integer num = jVar.f8671a;
            if (num != null) {
                window.setStatusBarColor(num.intValue());
            }
        }
        Boolean bool = jVar.f8673c;
        if (bool != null && i5 >= 29) {
            window.setStatusBarContrastEnforced(bool.booleanValue());
        }
        if (i5 >= 26) {
            k.d dVar2 = jVar.f8675e;
            if (dVar2 != null) {
                int i7 = c.f4034c[dVar2.ordinal()];
                if (i7 == 1) {
                    j0Var.a(true);
                } else if (i7 == 2) {
                    j0Var.a(false);
                }
            }
            Integer num2 = jVar.f8674d;
            if (num2 != null) {
                window.setNavigationBarColor(num2.intValue());
            }
        }
        Integer num3 = jVar.f8676f;
        if (num3 != null && i5 >= 28) {
            window.setNavigationBarDividerColor(num3.intValue());
        }
        Boolean bool2 = jVar.f8677g;
        if (bool2 != null && i5 >= 29) {
            window.setNavigationBarContrastEnforced(bool2.booleanValue());
        }
        this.f4026d = jVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D(String str) {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.SEND");
        intent.setType("text/plain");
        intent.putExtra("android.intent.extra.TEXT", str);
        this.f4023a.startActivity(Intent.createChooser(intent, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean p() {
        ClipDescription primaryClipDescription;
        ClipboardManager clipboardManager = (ClipboardManager) this.f4023a.getSystemService("clipboard");
        if (clipboardManager.hasPrimaryClip() && (primaryClipDescription = clipboardManager.getPrimaryClipDescription()) != null) {
            return primaryClipDescription.hasMimeType("text/*");
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public CharSequence r(k.e eVar) {
        ClipboardManager clipboardManager = (ClipboardManager) this.f4023a.getSystemService("clipboard");
        CharSequence charSequence = null;
        if (!clipboardManager.hasPrimaryClip()) {
            return null;
        }
        try {
            try {
                ClipData primaryClip = clipboardManager.getPrimaryClip();
                if (primaryClip == null) {
                    return null;
                }
                if (eVar != null && eVar != k.e.PLAIN_TEXT) {
                    return null;
                }
                ClipData.Item itemAt = primaryClip.getItemAt(0);
                CharSequence text = itemAt.getText();
                if (text == null) {
                    try {
                        Uri uri = itemAt.getUri();
                        if (uri == null) {
                            n2.b.g("PlatformPlugin", "Clipboard item contained no textual content nor a URI to retrieve it from.");
                            return null;
                        }
                        String scheme = uri.getScheme();
                        if (!scheme.equals("content")) {
                            n2.b.g("PlatformPlugin", "Clipboard item contains a Uri with scheme '" + scheme + "'that is unhandled.");
                            return null;
                        }
                        AssetFileDescriptor openTypedAssetFileDescriptor = this.f4023a.getContentResolver().openTypedAssetFileDescriptor(uri, "text/*", null);
                        text = itemAt.coerceToText(this.f4023a);
                        if (openTypedAssetFileDescriptor != null) {
                            openTypedAssetFileDescriptor.close();
                        }
                    } catch (IOException e5) {
                        e = e5;
                        charSequence = text;
                        n2.b.h("PlatformPlugin", "Failed to close AssetFileDescriptor while trying to read text from URI.", e);
                        return charSequence;
                    }
                }
                return text;
            } catch (IOException e6) {
                e = e6;
            }
        } catch (FileNotFoundException unused) {
            n2.b.g("PlatformPlugin", "Clipboard text was unable to be received from content URI.");
            return null;
        } catch (SecurityException e7) {
            n2.b.h("PlatformPlugin", "Attempted to get clipboard data that requires additional permission(s).\nSee the exception details for which permission(s) are required, and consider adding them to your Android Manifest as described in:\nhttps://developer.android.com/guide/topics/permissions/overview", e7);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(k.i iVar) {
        if (iVar == k.i.CLICK) {
            this.f4023a.getWindow().getDecorView().playSoundEffect(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t() {
        d dVar = this.f4025c;
        if (dVar == null || !dVar.b()) {
            Activity activity = this.f4023a;
            if (activity instanceof androidx.activity.s) {
                ((androidx.activity.s) activity).j().k();
            } else {
                activity.finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u() {
        E();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(String str) {
        ((ClipboardManager) this.f4023a.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("text label?", str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(boolean z4) {
        d dVar = this.f4025c;
        if (dVar != null) {
            dVar.g(z4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x(k.c cVar) {
        if (Build.VERSION.SDK_INT < 28) {
            this.f4023a.setTaskDescription(new ActivityManager.TaskDescription(cVar.f8646b, (Bitmap) null, cVar.f8645a));
            return;
        }
        this.f4023a.setTaskDescription(new ActivityManager.TaskDescription(cVar.f8646b, 0, cVar.f8645a));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y() {
        View decorView = this.f4023a.getWindow().getDecorView();
        decorView.setOnSystemUiVisibilityChangeListener(new b(decorView));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(k.EnumC0132k enumC0132k) {
        int i5;
        if (enumC0132k == k.EnumC0132k.LEAN_BACK) {
            i5 = 1798;
        } else if (enumC0132k == k.EnumC0132k.IMMERSIVE) {
            i5 = 3846;
        } else if (enumC0132k == k.EnumC0132k.IMMERSIVE_STICKY) {
            i5 = 5894;
        } else if (enumC0132k != k.EnumC0132k.EDGE_TO_EDGE || Build.VERSION.SDK_INT < 29) {
            return;
        } else {
            i5 = 1792;
        }
        this.f4027e = i5;
        E();
    }

    public void E() {
        this.f4023a.getWindow().getDecorView().setSystemUiVisibility(this.f4027e);
        k.j jVar = this.f4026d;
        if (jVar != null) {
            C(jVar);
        }
    }

    void F(k.g gVar) {
        int i5;
        View decorView = this.f4023a.getWindow().getDecorView();
        int i6 = c.f4032a[gVar.ordinal()];
        int i7 = 1;
        if (i6 != 1) {
            if (i6 != 2) {
                i7 = 3;
                if (i6 != 3) {
                    i7 = 4;
                    if (i6 != 4) {
                        if (i6 != 5) {
                            return;
                        }
                    } else if (Build.VERSION.SDK_INT < 23) {
                        return;
                    } else {
                        i5 = 6;
                    }
                }
            }
            decorView.performHapticFeedback(i7);
            return;
        }
        i5 = 0;
        decorView.performHapticFeedback(i5);
    }

    public void q() {
        this.f4024b.l(null);
    }
}
