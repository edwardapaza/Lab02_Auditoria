package io.flutter.view;

import android.app.Activity;
import android.content.ContentResolver;
import android.database.ContentObserver;
import android.graphics.Rect;
import android.net.Uri;
import android.opengl.Matrix;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.LocaleSpan;
import android.text.style.TtsSpan;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import io.flutter.view.h;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import y2.a;
/* loaded from: classes.dex */
public class h extends AccessibilityNodeProvider {

    /* renamed from: a  reason: collision with root package name */
    private final View f4196a;

    /* renamed from: b  reason: collision with root package name */
    private final y2.a f4197b;

    /* renamed from: c  reason: collision with root package name */
    private final AccessibilityManager f4198c;

    /* renamed from: d  reason: collision with root package name */
    private final AccessibilityViewEmbedder f4199d;

    /* renamed from: e  reason: collision with root package name */
    private final io.flutter.plugin.platform.q f4200e;

    /* renamed from: f  reason: collision with root package name */
    private final ContentResolver f4201f;

    /* renamed from: g  reason: collision with root package name */
    private final Map<Integer, l> f4202g;

    /* renamed from: h  reason: collision with root package name */
    private final Map<Integer, C0072h> f4203h;

    /* renamed from: i  reason: collision with root package name */
    private l f4204i;

    /* renamed from: j  reason: collision with root package name */
    private Integer f4205j;

    /* renamed from: k  reason: collision with root package name */
    private Integer f4206k;

    /* renamed from: l  reason: collision with root package name */
    private int f4207l;

    /* renamed from: m  reason: collision with root package name */
    private l f4208m;

    /* renamed from: n  reason: collision with root package name */
    private l f4209n;

    /* renamed from: o  reason: collision with root package name */
    private l f4210o;

    /* renamed from: p  reason: collision with root package name */
    private final List<Integer> f4211p;

    /* renamed from: q  reason: collision with root package name */
    private int f4212q;

    /* renamed from: r  reason: collision with root package name */
    private Integer f4213r;

    /* renamed from: s  reason: collision with root package name */
    private k f4214s;

    /* renamed from: t  reason: collision with root package name */
    private boolean f4215t;

    /* renamed from: u  reason: collision with root package name */
    private boolean f4216u;

    /* renamed from: v  reason: collision with root package name */
    private final a.b f4217v;

    /* renamed from: w  reason: collision with root package name */
    private final AccessibilityManager.AccessibilityStateChangeListener f4218w;

    /* renamed from: x  reason: collision with root package name */
    private final AccessibilityManager.TouchExplorationStateChangeListener f4219x;

    /* renamed from: y  reason: collision with root package name */
    private final ContentObserver f4220y;

    /* renamed from: z  reason: collision with root package name */
    private static final int f4195z = ((g.SCROLL_RIGHT.f4257a | g.SCROLL_LEFT.f4257a) | g.SCROLL_UP.f4257a) | g.SCROLL_DOWN.f4257a;
    private static final int A = ((((((((((i.HAS_CHECKED_STATE.f4284a | i.IS_CHECKED.f4284a) | i.IS_SELECTED.f4284a) | i.IS_TEXT_FIELD.f4284a) | i.IS_FOCUSED.f4284a) | i.HAS_ENABLED_STATE.f4284a) | i.IS_ENABLED.f4284a) | i.IS_IN_MUTUALLY_EXCLUSIVE_GROUP.f4284a) | i.HAS_TOGGLED_STATE.f4284a) | i.IS_TOGGLED.f4284a) | i.IS_FOCUSABLE.f4284a) | i.IS_SLIDER.f4284a;
    private static int B = 267386881;
    static int C = (g.DID_GAIN_ACCESSIBILITY_FOCUS.f4257a & g.DID_LOSE_ACCESSIBILITY_FOCUS.f4257a) & g.SHOW_ON_SCREEN.f4257a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements a.b {
        a() {
        }

        @Override // y2.a.b
        public void a(String str) {
            h.this.f4196a.announceForAccessibility(str);
        }

        @Override // io.flutter.embedding.engine.FlutterJNI.a
        public void b(ByteBuffer byteBuffer, String[] strArr, ByteBuffer[] byteBufferArr) {
            byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
            for (ByteBuffer byteBuffer2 : byteBufferArr) {
                byteBuffer2.order(ByteOrder.LITTLE_ENDIAN);
            }
            h.this.d0(byteBuffer, strArr, byteBufferArr);
        }

        @Override // io.flutter.embedding.engine.FlutterJNI.a
        public void c(ByteBuffer byteBuffer, String[] strArr) {
            byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
            h.this.c0(byteBuffer, strArr);
        }

        @Override // y2.a.b
        public void d(String str) {
            if (Build.VERSION.SDK_INT >= 28) {
                return;
            }
            AccessibilityEvent I = h.this.I(0, 32);
            I.getText().add(str);
            h.this.U(I);
        }

        @Override // y2.a.b
        public void e(int i5) {
            h.this.T(i5, 8);
        }

        @Override // y2.a.b
        public void f(int i5) {
            h.this.T(i5, 2);
        }

        @Override // y2.a.b
        public void g(int i5) {
            h.this.T(i5, 1);
        }
    }

    /* loaded from: classes.dex */
    class b implements AccessibilityManager.AccessibilityStateChangeListener {
        b() {
        }

        @Override // android.view.accessibility.AccessibilityManager.AccessibilityStateChangeListener
        public void onAccessibilityStateChanged(boolean z4) {
            if (h.this.f4216u) {
                return;
            }
            h hVar = h.this;
            if (z4) {
                hVar.f4197b.g(h.this.f4217v);
                h.this.f4197b.e();
            } else {
                hVar.Y(false);
                h.this.f4197b.g(null);
                h.this.f4197b.d();
            }
            if (h.this.f4214s != null) {
                h.this.f4214s.a(z4, h.this.f4198c.isTouchExplorationEnabled());
            }
        }
    }

    /* loaded from: classes.dex */
    class c extends ContentObserver {
        c(Handler handler) {
            super(handler);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z4) {
            onChange(z4, null);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z4, Uri uri) {
            if (h.this.f4216u) {
                return;
            }
            if (Settings.Global.getFloat(h.this.f4201f, "transition_animation_scale", 1.0f) == 0.0f) {
                h.f(h.this, f.DISABLE_ANIMATIONS.f4235a);
            } else {
                h.e(h.this, ~f.DISABLE_ANIMATIONS.f4235a);
            }
            h.this.V();
        }
    }

    /* loaded from: classes.dex */
    class d implements AccessibilityManager.TouchExplorationStateChangeListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AccessibilityManager f4224a;

        d(AccessibilityManager accessibilityManager) {
            this.f4224a = accessibilityManager;
        }

        @Override // android.view.accessibility.AccessibilityManager.TouchExplorationStateChangeListener
        public void onTouchExplorationStateChanged(boolean z4) {
            if (h.this.f4216u) {
                return;
            }
            if (!z4) {
                h.this.Y(false);
                h.this.N();
            }
            if (h.this.f4214s != null) {
                h.this.f4214s.a(this.f4224a.isEnabled(), z4);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static /* synthetic */ class e {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f4226a;

        static {
            int[] iArr = new int[o.values().length];
            f4226a = iArr;
            try {
                iArr[o.SPELLOUT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f4226a[o.LOCALE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public enum f {
        ACCESSIBLE_NAVIGATION(1),
        INVERT_COLORS(2),
        DISABLE_ANIMATIONS(4),
        BOLD_TEXT(8),
        REDUCE_MOTION(16),
        HIGH_CONTRAST(32),
        ON_OFF_SWITCH_LABELS(64);
        

        /* renamed from: a  reason: collision with root package name */
        final int f4235a;

        f(int i5) {
            this.f4235a = i5;
        }
    }

    /* loaded from: classes.dex */
    public enum g {
        TAP(1),
        LONG_PRESS(2),
        SCROLL_LEFT(4),
        SCROLL_RIGHT(8),
        SCROLL_UP(16),
        SCROLL_DOWN(32),
        INCREASE(64),
        DECREASE(128),
        SHOW_ON_SCREEN(256),
        MOVE_CURSOR_FORWARD_BY_CHARACTER(512),
        MOVE_CURSOR_BACKWARD_BY_CHARACTER(1024),
        SET_SELECTION(2048),
        COPY(4096),
        CUT(8192),
        PASTE(16384),
        DID_GAIN_ACCESSIBILITY_FOCUS(32768),
        DID_LOSE_ACCESSIBILITY_FOCUS(65536),
        CUSTOM_ACTION(131072),
        DISMISS(262144),
        MOVE_CURSOR_FORWARD_BY_WORD(524288),
        MOVE_CURSOR_BACKWARD_BY_WORD(1048576),
        SET_TEXT(2097152),
        FOCUS(4194304);
        

        /* renamed from: a  reason: collision with root package name */
        public final int f4257a;

        g(int i5) {
            this.f4257a = i5;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: io.flutter.view.h$h  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0072h {

        /* renamed from: a  reason: collision with root package name */
        private int f4258a = -1;

        /* renamed from: b  reason: collision with root package name */
        private int f4259b = -1;

        /* renamed from: c  reason: collision with root package name */
        private int f4260c = -1;

        /* renamed from: d  reason: collision with root package name */
        private String f4261d;

        /* renamed from: e  reason: collision with root package name */
        private String f4262e;

        C0072h() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public enum i {
        HAS_CHECKED_STATE(1),
        IS_CHECKED(2),
        IS_SELECTED(4),
        IS_BUTTON(8),
        IS_TEXT_FIELD(16),
        IS_FOCUSED(32),
        HAS_ENABLED_STATE(64),
        IS_ENABLED(128),
        IS_IN_MUTUALLY_EXCLUSIVE_GROUP(256),
        IS_HEADER(512),
        IS_OBSCURED(1024),
        SCOPES_ROUTE(2048),
        NAMES_ROUTE(4096),
        IS_HIDDEN(8192),
        IS_IMAGE(16384),
        IS_LIVE_REGION(32768),
        HAS_TOGGLED_STATE(65536),
        IS_TOGGLED(131072),
        HAS_IMPLICIT_SCROLLING(262144),
        IS_MULTILINE(524288),
        IS_READ_ONLY(1048576),
        IS_FOCUSABLE(2097152),
        IS_LINK(4194304),
        IS_SLIDER(8388608),
        IS_KEYBOARD_KEY(16777216),
        IS_CHECK_STATE_MIXED(33554432),
        HAS_EXPANDED_STATE(67108864),
        IS_EXPANDED(134217728);
        

        /* renamed from: a  reason: collision with root package name */
        final int f4284a;

        i(int i5) {
            this.f4284a = i5;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class j extends n {

        /* renamed from: d  reason: collision with root package name */
        String f4285d;

        private j() {
            super(null);
        }

        /* synthetic */ j(a aVar) {
            this();
        }
    }

    /* loaded from: classes.dex */
    public interface k {
        void a(boolean z4, boolean z5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class l {
        private p B;
        private int D;
        private int E;
        private int F;
        private int G;
        private float H;
        private float I;
        private float J;
        private String K;
        private String L;
        private float M;
        private float N;
        private float O;
        private float P;
        private float[] Q;
        private l R;
        private List<C0072h> U;
        private C0072h V;
        private C0072h W;
        private float[] Y;

        /* renamed from: a  reason: collision with root package name */
        final h f4286a;

        /* renamed from: a0  reason: collision with root package name */
        private float[] f4287a0;

        /* renamed from: b0  reason: collision with root package name */
        private Rect f4289b0;

        /* renamed from: c  reason: collision with root package name */
        private int f4290c;

        /* renamed from: d  reason: collision with root package name */
        private int f4291d;

        /* renamed from: e  reason: collision with root package name */
        private int f4292e;

        /* renamed from: f  reason: collision with root package name */
        private int f4293f;

        /* renamed from: g  reason: collision with root package name */
        private int f4294g;

        /* renamed from: h  reason: collision with root package name */
        private int f4295h;

        /* renamed from: i  reason: collision with root package name */
        private int f4296i;

        /* renamed from: j  reason: collision with root package name */
        private int f4297j;

        /* renamed from: k  reason: collision with root package name */
        private int f4298k;

        /* renamed from: l  reason: collision with root package name */
        private float f4299l;

        /* renamed from: m  reason: collision with root package name */
        private float f4300m;

        /* renamed from: n  reason: collision with root package name */
        private float f4301n;

        /* renamed from: o  reason: collision with root package name */
        private String f4302o;

        /* renamed from: p  reason: collision with root package name */
        private String f4303p;

        /* renamed from: q  reason: collision with root package name */
        private List<n> f4304q;

        /* renamed from: r  reason: collision with root package name */
        private String f4305r;

        /* renamed from: s  reason: collision with root package name */
        private List<n> f4306s;

        /* renamed from: t  reason: collision with root package name */
        private String f4307t;

        /* renamed from: u  reason: collision with root package name */
        private List<n> f4308u;

        /* renamed from: v  reason: collision with root package name */
        private String f4309v;

        /* renamed from: w  reason: collision with root package name */
        private List<n> f4310w;

        /* renamed from: x  reason: collision with root package name */
        private String f4311x;

        /* renamed from: y  reason: collision with root package name */
        private List<n> f4312y;

        /* renamed from: z  reason: collision with root package name */
        private String f4313z;

        /* renamed from: b  reason: collision with root package name */
        private int f4288b = -1;
        private int A = -1;
        private boolean C = false;
        private List<l> S = new ArrayList();
        private List<l> T = new ArrayList();
        private boolean X = true;
        private boolean Z = true;

        l(h hVar) {
            this.f4286a = hVar;
        }

        private float A0(float f5, float f6, float f7, float f8) {
            return Math.max(f5, Math.max(f6, Math.max(f7, f8)));
        }

        private float B0(float f5, float f6, float f7, float f8) {
            return Math.min(f5, Math.min(f6, Math.min(f7, f8)));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static boolean C0(l lVar, h3.d<l> dVar) {
            return (lVar == null || lVar.l0(dVar) == null) ? false : true;
        }

        private void D0(float[] fArr, float[] fArr2, float[] fArr3) {
            Matrix.multiplyMV(fArr, 0, fArr2, 0, fArr3, 0);
            float f5 = fArr[3];
            fArr[0] = fArr[0] / f5;
            fArr[1] = fArr[1] / f5;
            fArr[2] = fArr[2] / f5;
            fArr[3] = 0.0f;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void E0(float[] fArr, Set<l> set, boolean z4) {
            set.add(this);
            if (this.Z) {
                z4 = true;
            }
            if (z4) {
                if (this.f4287a0 == null) {
                    this.f4287a0 = new float[16];
                }
                if (this.Q == null) {
                    this.Q = new float[16];
                }
                Matrix.multiplyMM(this.f4287a0, 0, fArr, 0, this.Q, 0);
                float[] fArr2 = {this.M, this.N, 0.0f, 1.0f};
                float[] fArr3 = new float[4];
                float[] fArr4 = new float[4];
                float[] fArr5 = new float[4];
                float[] fArr6 = new float[4];
                D0(fArr3, this.f4287a0, fArr2);
                fArr2[0] = this.O;
                fArr2[1] = this.N;
                D0(fArr4, this.f4287a0, fArr2);
                fArr2[0] = this.O;
                fArr2[1] = this.P;
                D0(fArr5, this.f4287a0, fArr2);
                fArr2[0] = this.M;
                fArr2[1] = this.P;
                D0(fArr6, this.f4287a0, fArr2);
                if (this.f4289b0 == null) {
                    this.f4289b0 = new Rect();
                }
                this.f4289b0.set(Math.round(B0(fArr3[0], fArr4[0], fArr5[0], fArr6[0])), Math.round(B0(fArr3[1], fArr4[1], fArr5[1], fArr6[1])), Math.round(A0(fArr3[0], fArr4[0], fArr5[0], fArr6[0])), Math.round(A0(fArr3[1], fArr4[1], fArr5[1], fArr6[1])));
                this.Z = false;
            }
            int i5 = -1;
            for (l lVar : this.S) {
                lVar.A = i5;
                i5 = lVar.f4288b;
                lVar.E0(this.f4287a0, set, z4);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void F0(ByteBuffer byteBuffer, String[] strArr, ByteBuffer[] byteBufferArr) {
            this.C = true;
            this.K = this.f4305r;
            this.L = this.f4303p;
            this.D = this.f4290c;
            this.E = this.f4291d;
            this.F = this.f4294g;
            this.G = this.f4295h;
            this.H = this.f4299l;
            this.I = this.f4300m;
            this.J = this.f4301n;
            this.f4290c = byteBuffer.getInt();
            this.f4291d = byteBuffer.getInt();
            this.f4292e = byteBuffer.getInt();
            this.f4293f = byteBuffer.getInt();
            this.f4294g = byteBuffer.getInt();
            this.f4295h = byteBuffer.getInt();
            this.f4296i = byteBuffer.getInt();
            this.f4297j = byteBuffer.getInt();
            this.f4298k = byteBuffer.getInt();
            this.f4299l = byteBuffer.getFloat();
            this.f4300m = byteBuffer.getFloat();
            this.f4301n = byteBuffer.getFloat();
            int i5 = byteBuffer.getInt();
            this.f4302o = i5 == -1 ? null : strArr[i5];
            int i6 = byteBuffer.getInt();
            this.f4303p = i6 == -1 ? null : strArr[i6];
            this.f4304q = q0(byteBuffer, byteBufferArr);
            int i7 = byteBuffer.getInt();
            this.f4305r = i7 == -1 ? null : strArr[i7];
            this.f4306s = q0(byteBuffer, byteBufferArr);
            int i8 = byteBuffer.getInt();
            this.f4307t = i8 == -1 ? null : strArr[i8];
            this.f4308u = q0(byteBuffer, byteBufferArr);
            int i9 = byteBuffer.getInt();
            this.f4309v = i9 == -1 ? null : strArr[i9];
            this.f4310w = q0(byteBuffer, byteBufferArr);
            int i10 = byteBuffer.getInt();
            this.f4311x = i10 == -1 ? null : strArr[i10];
            this.f4312y = q0(byteBuffer, byteBufferArr);
            int i11 = byteBuffer.getInt();
            this.f4313z = i11 == -1 ? null : strArr[i11];
            this.B = p.c(byteBuffer.getInt());
            this.M = byteBuffer.getFloat();
            this.N = byteBuffer.getFloat();
            this.O = byteBuffer.getFloat();
            this.P = byteBuffer.getFloat();
            if (this.Q == null) {
                this.Q = new float[16];
            }
            for (int i12 = 0; i12 < 16; i12++) {
                this.Q[i12] = byteBuffer.getFloat();
            }
            this.X = true;
            this.Z = true;
            int i13 = byteBuffer.getInt();
            this.S.clear();
            this.T.clear();
            for (int i14 = 0; i14 < i13; i14++) {
                l z4 = this.f4286a.z(byteBuffer.getInt());
                z4.R = this;
                this.S.add(z4);
            }
            for (int i15 = 0; i15 < i13; i15++) {
                l z5 = this.f4286a.z(byteBuffer.getInt());
                z5.R = this;
                this.T.add(z5);
            }
            int i16 = byteBuffer.getInt();
            if (i16 == 0) {
                this.U = null;
                return;
            }
            List<C0072h> list = this.U;
            if (list == null) {
                this.U = new ArrayList(i16);
            } else {
                list.clear();
            }
            for (int i17 = 0; i17 < i16; i17++) {
                C0072h y4 = this.f4286a.y(byteBuffer.getInt());
                if (y4.f4260c == g.TAP.f4257a) {
                    this.V = y4;
                } else if (y4.f4260c == g.LONG_PRESS.f4257a) {
                    this.W = y4;
                } else {
                    this.U.add(y4);
                }
                this.U.add(y4);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void g0(List<l> list) {
            if (x0(i.SCOPES_ROUTE)) {
                list.add(this);
            }
            for (l lVar : this.S) {
                lVar.g0(list);
            }
        }

        private SpannableString h0(String str, List<n> list) {
            if (str == null) {
                return null;
            }
            SpannableString spannableString = new SpannableString(str);
            if (list != null) {
                for (n nVar : list) {
                    int i5 = e.f4226a[nVar.f4316c.ordinal()];
                    if (i5 == 1) {
                        spannableString.setSpan(new TtsSpan.Builder("android.type.verbatim").build(), nVar.f4314a, nVar.f4315b, 0);
                    } else if (i5 == 2) {
                        spannableString.setSpan(new LocaleSpan(Locale.forLanguageTag(((j) nVar).f4285d)), nVar.f4314a, nVar.f4315b, 0);
                    }
                }
            }
            return spannableString;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean i0() {
            String str;
            String str2 = this.f4303p;
            if (str2 == null && this.L == null) {
                return false;
            }
            return str2 == null || (str = this.L) == null || !str2.equals(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean j0() {
            return (Float.isNaN(this.f4299l) || Float.isNaN(this.H) || this.H == this.f4299l) ? false : true;
        }

        private void k0() {
            if (this.X) {
                this.X = false;
                if (this.Y == null) {
                    this.Y = new float[16];
                }
                if (Matrix.invertM(this.Y, 0, this.Q, 0)) {
                    return;
                }
                Arrays.fill(this.Y, 0.0f);
            }
        }

        private l l0(h3.d<l> dVar) {
            for (l lVar = this.R; lVar != null; lVar = lVar.R) {
                if (dVar.test(lVar)) {
                    return lVar;
                }
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Rect m0() {
            return this.f4289b0;
        }

        static /* synthetic */ int n(l lVar, int i5) {
            int i6 = lVar.f4295h + i5;
            lVar.f4295h = i6;
            return i6;
        }

        private CharSequence n0() {
            return h0(this.f4311x, this.f4312y);
        }

        static /* synthetic */ int o(l lVar, int i5) {
            int i6 = lVar.f4295h - i5;
            lVar.f4295h = i6;
            return i6;
        }

        private CharSequence o0() {
            return h0(this.f4303p, this.f4304q);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public String p0() {
            String str;
            if (!x0(i.NAMES_ROUTE) || (str = this.f4303p) == null || str.isEmpty()) {
                for (l lVar : this.S) {
                    String p02 = lVar.p0();
                    if (p02 != null && !p02.isEmpty()) {
                        return p02;
                    }
                }
                return null;
            }
            return this.f4303p;
        }

        private List<n> q0(ByteBuffer byteBuffer, ByteBuffer[] byteBufferArr) {
            int i5 = byteBuffer.getInt();
            if (i5 == -1) {
                return null;
            }
            ArrayList arrayList = new ArrayList(i5);
            for (int i6 = 0; i6 < i5; i6++) {
                int i7 = byteBuffer.getInt();
                int i8 = byteBuffer.getInt();
                o oVar = o.values()[byteBuffer.getInt()];
                int i9 = e.f4226a[oVar.ordinal()];
                if (i9 == 1) {
                    byteBuffer.getInt();
                    m mVar = new m(null);
                    mVar.f4314a = i7;
                    mVar.f4315b = i8;
                    mVar.f4316c = oVar;
                    arrayList.add(mVar);
                } else if (i9 == 2) {
                    ByteBuffer byteBuffer2 = byteBufferArr[byteBuffer.getInt()];
                    j jVar = new j(null);
                    jVar.f4314a = i7;
                    jVar.f4315b = i8;
                    jVar.f4316c = oVar;
                    jVar.f4285d = Charset.forName("UTF-8").decode(byteBuffer2).toString();
                    arrayList.add(jVar);
                }
            }
            return arrayList;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public CharSequence r0() {
            CharSequence[] charSequenceArr = {o0(), n0()};
            CharSequence charSequence = null;
            for (int i5 = 0; i5 < 2; i5++) {
                CharSequence charSequence2 = charSequenceArr[i5];
                if (charSequence2 != null && charSequence2.length() > 0) {
                    charSequence = (charSequence == null || charSequence.length() == 0) ? charSequence2 : TextUtils.concat(charSequence, ", ", charSequence2);
                }
            }
            return charSequence;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public CharSequence s0() {
            return h0(this.f4305r, this.f4306s);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public CharSequence t0() {
            CharSequence[] charSequenceArr = {s0(), o0(), n0()};
            CharSequence charSequence = null;
            for (int i5 = 0; i5 < 3; i5++) {
                CharSequence charSequence2 = charSequenceArr[i5];
                if (charSequence2 != null && charSequence2.length() > 0) {
                    charSequence = (charSequence == null || charSequence.length() == 0) ? charSequence2 : TextUtils.concat(charSequence, ", ", charSequence2);
                }
            }
            return charSequence;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean u0(g gVar) {
            return (gVar.f4257a & this.E) != 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean v0(i iVar) {
            return (iVar.f4284a & this.D) != 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean w0(g gVar) {
            return (gVar.f4257a & this.f4291d) != 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean x0(i iVar) {
            return (iVar.f4284a & this.f4290c) != 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public l y0(float[] fArr, boolean z4) {
            float f5 = fArr[3];
            boolean z5 = false;
            float f6 = fArr[0] / f5;
            float f7 = fArr[1] / f5;
            if (f6 < this.M || f6 >= this.O || f7 < this.N || f7 >= this.P) {
                return null;
            }
            float[] fArr2 = new float[4];
            for (l lVar : this.T) {
                if (!lVar.x0(i.IS_HIDDEN)) {
                    lVar.k0();
                    Matrix.multiplyMV(fArr2, 0, lVar.Y, 0, fArr, 0);
                    l y02 = lVar.y0(fArr2, z4);
                    if (y02 != null) {
                        return y02;
                    }
                }
            }
            if (z4 && this.f4296i != -1) {
                z5 = true;
            }
            if (z0() || z5) {
                return this;
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean z0() {
            String str;
            String str2;
            String str3;
            if (x0(i.SCOPES_ROUTE)) {
                return false;
            }
            return (!x0(i.IS_FOCUSABLE) && (this.f4291d & (~h.f4195z)) == 0 && (this.f4290c & h.A) == 0 && ((str = this.f4303p) == null || str.isEmpty()) && (((str2 = this.f4305r) == null || str2.isEmpty()) && ((str3 = this.f4311x) == null || str3.isEmpty()))) ? false : true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class m extends n {
        private m() {
            super(null);
        }

        /* synthetic */ m(a aVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class n {

        /* renamed from: a  reason: collision with root package name */
        int f4314a;

        /* renamed from: b  reason: collision with root package name */
        int f4315b;

        /* renamed from: c  reason: collision with root package name */
        o f4316c;

        private n() {
        }

        /* synthetic */ n(a aVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public enum o {
        SPELLOUT,
        LOCALE
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public enum p {
        UNKNOWN,
        LTR,
        RTL;

        public static p c(int i5) {
            return i5 != 1 ? i5 != 2 ? UNKNOWN : LTR : RTL;
        }
    }

    public h(View view, y2.a aVar, AccessibilityManager accessibilityManager, ContentResolver contentResolver, io.flutter.plugin.platform.q qVar) {
        this(view, aVar, accessibilityManager, contentResolver, new AccessibilityViewEmbedder(view, 65536), qVar);
    }

    public h(View view, y2.a aVar, AccessibilityManager accessibilityManager, ContentResolver contentResolver, AccessibilityViewEmbedder accessibilityViewEmbedder, io.flutter.plugin.platform.q qVar) {
        this.f4202g = new HashMap();
        this.f4203h = new HashMap();
        this.f4207l = 0;
        this.f4211p = new ArrayList();
        this.f4212q = 0;
        this.f4213r = 0;
        this.f4215t = false;
        this.f4216u = false;
        this.f4217v = new a();
        b bVar = new b();
        this.f4218w = bVar;
        c cVar = new c(new Handler());
        this.f4220y = cVar;
        this.f4196a = view;
        this.f4197b = aVar;
        this.f4198c = accessibilityManager;
        this.f4201f = contentResolver;
        this.f4199d = accessibilityViewEmbedder;
        this.f4200e = qVar;
        bVar.onAccessibilityStateChanged(accessibilityManager.isEnabled());
        accessibilityManager.addAccessibilityStateChangeListener(bVar);
        d dVar = new d(accessibilityManager);
        this.f4219x = dVar;
        dVar.onTouchExplorationStateChanged(accessibilityManager.isTouchExplorationEnabled());
        accessibilityManager.addTouchExplorationStateChangeListener(dVar);
        cVar.onChange(false);
        contentResolver.registerContentObserver(Settings.Global.getUriFor("transition_animation_scale"), false, cVar);
        if (Build.VERSION.SDK_INT >= 31) {
            Z();
        }
        qVar.a(this);
    }

    private l A() {
        return this.f4202g.get(0);
    }

    private void B(float f5, float f6, boolean z4) {
        l y02;
        if (this.f4202g.isEmpty() || (y02 = A().y0(new float[]{f5, f6, 0.0f, 1.0f}, z4)) == this.f4210o) {
            return;
        }
        if (y02 != null) {
            T(y02.f4288b, 128);
        }
        l lVar = this.f4210o;
        if (lVar != null) {
            T(lVar.f4288b, 256);
        }
        this.f4210o = y02;
    }

    private boolean D(l lVar) {
        if (lVar.x0(i.SCOPES_ROUTE)) {
            return false;
        }
        return (lVar.t0() == null && (lVar.f4291d & (~C)) == 0) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean F(l lVar, l lVar2) {
        return lVar2 == lVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean G(l lVar) {
        return lVar.x0(i.HAS_IMPLICIT_SCROLLING);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public AccessibilityEvent I(int i5, int i6) {
        AccessibilityEvent H = H(i6);
        H.setPackageName(this.f4196a.getContext().getPackageName());
        H.setSource(this.f4196a, i5);
        return H;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N() {
        l lVar = this.f4210o;
        if (lVar != null) {
            T(lVar.f4288b, 256);
            this.f4210o = null;
        }
    }

    private void O(l lVar) {
        String p02 = lVar.p0();
        if (p02 == null) {
            p02 = " ";
        }
        if (Build.VERSION.SDK_INT >= 28) {
            X(p02);
            return;
        }
        AccessibilityEvent I = I(lVar.f4288b, 32);
        I.getText().add(p02);
        U(I);
    }

    private boolean P(l lVar, int i5, Bundle bundle, boolean z4) {
        int i6 = bundle.getInt("ACTION_ARGUMENT_MOVEMENT_GRANULARITY_INT");
        boolean z5 = bundle.getBoolean("ACTION_ARGUMENT_EXTEND_SELECTION_BOOLEAN");
        int i7 = lVar.f4294g;
        int i8 = lVar.f4295h;
        R(lVar, i6, z4, z5);
        if (i7 != lVar.f4294g || i8 != lVar.f4295h) {
            String str = lVar.f4305r != null ? lVar.f4305r : "";
            AccessibilityEvent I = I(lVar.f4288b, 8192);
            I.getText().add(str);
            I.setFromIndex(lVar.f4294g);
            I.setToIndex(lVar.f4295h);
            I.setItemCount(str.length());
            U(I);
        }
        if (i6 == 1) {
            if (z4) {
                g gVar = g.MOVE_CURSOR_FORWARD_BY_CHARACTER;
                if (lVar.w0(gVar)) {
                    this.f4197b.c(i5, gVar, Boolean.valueOf(z5));
                    return true;
                }
            }
            if (z4) {
                return false;
            }
            g gVar2 = g.MOVE_CURSOR_BACKWARD_BY_CHARACTER;
            if (lVar.w0(gVar2)) {
                this.f4197b.c(i5, gVar2, Boolean.valueOf(z5));
                return true;
            }
            return false;
        } else if (i6 != 2) {
            return i6 == 4 || i6 == 8 || i6 == 16;
        } else {
            if (z4) {
                g gVar3 = g.MOVE_CURSOR_FORWARD_BY_WORD;
                if (lVar.w0(gVar3)) {
                    this.f4197b.c(i5, gVar3, Boolean.valueOf(z5));
                    return true;
                }
            }
            if (z4) {
                return false;
            }
            g gVar4 = g.MOVE_CURSOR_BACKWARD_BY_WORD;
            if (lVar.w0(gVar4)) {
                this.f4197b.c(i5, gVar4, Boolean.valueOf(z5));
                return true;
            }
            return false;
        }
    }

    private boolean Q(l lVar, int i5, Bundle bundle) {
        String string = (bundle == null || !bundle.containsKey("ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE")) ? "" : bundle.getString("ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE");
        this.f4197b.c(i5, g.SET_TEXT, string);
        lVar.f4305r = string;
        lVar.f4306s = null;
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0022, code lost:
        if (r6 != false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0024, code lost:
        r5 = r4.f4305r.length();
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x002c, code lost:
        r4.f4295h = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0031, code lost:
        r4.f4295h = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0060, code lost:
        if (r5.find() != false) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0062, code lost:
        io.flutter.view.h.l.n(r4, r5.start(1));
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x008d, code lost:
        if (r5.find() != false) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x008f, code lost:
        r5 = r5.start(1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00c1, code lost:
        if (r5.find() != false) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00e6, code lost:
        if (r5.find() != false) goto L35;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void R(io.flutter.view.h.l r4, int r5, boolean r6, boolean r7) {
        /*
            r3 = this;
            int r0 = io.flutter.view.h.l.l(r4)
            if (r0 < 0) goto L111
            int r0 = io.flutter.view.h.l.j(r4)
            if (r0 >= 0) goto Le
            goto L111
        Le:
            r0 = 1
            if (r5 == r0) goto Le9
            r1 = 2
            r2 = 0
            if (r5 == r1) goto L94
            r1 = 4
            if (r5 == r1) goto L36
            r0 = 8
            if (r5 == r0) goto L22
            r0 = 16
            if (r5 == r0) goto L22
            goto L108
        L22:
            if (r6 == 0) goto L31
        L24:
            java.lang.String r5 = io.flutter.view.h.l.r(r4)
            int r5 = r5.length()
        L2c:
            io.flutter.view.h.l.m(r4, r5)
            goto L108
        L31:
            io.flutter.view.h.l.m(r4, r2)
            goto L108
        L36:
            if (r6 == 0) goto L6b
            int r5 = io.flutter.view.h.l.l(r4)
            java.lang.String r1 = io.flutter.view.h.l.r(r4)
            int r1 = r1.length()
            if (r5 >= r1) goto L6b
            java.lang.String r5 = "(?!^)(\\n)"
            java.util.regex.Pattern r5 = java.util.regex.Pattern.compile(r5)
            java.lang.String r6 = io.flutter.view.h.l.r(r4)
            int r1 = io.flutter.view.h.l.l(r4)
            java.lang.String r6 = r6.substring(r1)
            java.util.regex.Matcher r5 = r5.matcher(r6)
            boolean r6 = r5.find()
            if (r6 == 0) goto L24
        L62:
            int r5 = r5.start(r0)
            io.flutter.view.h.l.n(r4, r5)
            goto L108
        L6b:
            if (r6 != 0) goto L108
            int r5 = io.flutter.view.h.l.l(r4)
            if (r5 <= 0) goto L108
            java.lang.String r5 = "(?s:.*)(\\n)"
            java.util.regex.Pattern r5 = java.util.regex.Pattern.compile(r5)
            java.lang.String r6 = io.flutter.view.h.l.r(r4)
            int r1 = io.flutter.view.h.l.l(r4)
            java.lang.String r6 = r6.substring(r2, r1)
            java.util.regex.Matcher r5 = r5.matcher(r6)
            boolean r6 = r5.find()
            if (r6 == 0) goto L31
        L8f:
            int r5 = r5.start(r0)
            goto L2c
        L94:
            if (r6 == 0) goto Lc4
            int r5 = io.flutter.view.h.l.l(r4)
            java.lang.String r1 = io.flutter.view.h.l.r(r4)
            int r1 = r1.length()
            if (r5 >= r1) goto Lc4
            java.lang.String r5 = "\\p{L}(\\b)"
            java.util.regex.Pattern r5 = java.util.regex.Pattern.compile(r5)
            java.lang.String r6 = io.flutter.view.h.l.r(r4)
            int r1 = io.flutter.view.h.l.l(r4)
            java.lang.String r6 = r6.substring(r1)
            java.util.regex.Matcher r5 = r5.matcher(r6)
            r5.find()
            boolean r6 = r5.find()
            if (r6 == 0) goto L24
            goto L62
        Lc4:
            if (r6 != 0) goto L108
            int r5 = io.flutter.view.h.l.l(r4)
            if (r5 <= 0) goto L108
            java.lang.String r5 = "(?s:.*)(\\b)\\p{L}"
            java.util.regex.Pattern r5 = java.util.regex.Pattern.compile(r5)
            java.lang.String r6 = io.flutter.view.h.l.r(r4)
            int r1 = io.flutter.view.h.l.l(r4)
            java.lang.String r6 = r6.substring(r2, r1)
            java.util.regex.Matcher r5 = r5.matcher(r6)
            boolean r6 = r5.find()
            if (r6 == 0) goto L108
            goto L8f
        Le9:
            if (r6 == 0) goto Lfd
            int r5 = io.flutter.view.h.l.l(r4)
            java.lang.String r1 = io.flutter.view.h.l.r(r4)
            int r1 = r1.length()
            if (r5 >= r1) goto Lfd
            io.flutter.view.h.l.n(r4, r0)
            goto L108
        Lfd:
            if (r6 != 0) goto L108
            int r5 = io.flutter.view.h.l.l(r4)
            if (r5 <= 0) goto L108
            io.flutter.view.h.l.o(r4, r0)
        L108:
            if (r7 != 0) goto L111
            int r5 = io.flutter.view.h.l.l(r4)
            io.flutter.view.h.l.k(r4, r5)
        L111:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flutter.view.h.R(io.flutter.view.h$l, int, boolean, boolean):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U(AccessibilityEvent accessibilityEvent) {
        if (this.f4198c.isEnabled()) {
            this.f4196a.getParent().requestSendAccessibilityEvent(this.f4196a, accessibilityEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V() {
        this.f4197b.f(this.f4207l);
    }

    private void W(int i5) {
        AccessibilityEvent I = I(i5, 2048);
        I.setContentChangeTypes(1);
        U(I);
    }

    private void X(String str) {
        this.f4196a.setAccessibilityPaneTitle(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y(boolean z4) {
        if (this.f4215t == z4) {
            return;
        }
        this.f4215t = z4;
        this.f4207l = z4 ? this.f4207l | f.ACCESSIBLE_NAVIGATION.f4235a : this.f4207l & (~f.ACCESSIBLE_NAVIGATION.f4235a);
        V();
    }

    private void Z() {
        View view = this.f4196a;
        if (view == null || view.getResources() == null) {
            return;
        }
        int i5 = this.f4196a.getResources().getConfiguration().fontWeightAdjustment;
        this.f4207l = i5 != Integer.MAX_VALUE && i5 >= 300 ? this.f4207l | f.BOLD_TEXT.f4235a : this.f4207l & (~f.BOLD_TEXT.f4235a);
        V();
    }

    private boolean b0(final l lVar) {
        return lVar.f4297j > 0 && (l.C0(this.f4204i, new h3.d() { // from class: io.flutter.view.f
            @Override // h3.d
            public final boolean test(Object obj) {
                boolean F;
                F = h.F(h.l.this, (h.l) obj);
                return F;
            }
        }) || !l.C0(this.f4204i, new h3.d() { // from class: io.flutter.view.g
            @Override // h3.d
            public final boolean test(Object obj) {
                boolean G;
                G = h.G((h.l) obj);
                return G;
            }
        }));
    }

    static /* synthetic */ int e(h hVar, int i5) {
        int i6 = i5 & hVar.f4207l;
        hVar.f4207l = i6;
        return i6;
    }

    private void e0(l lVar) {
        View c5;
        Integer num;
        lVar.R = null;
        if (lVar.f4296i != -1 && (num = this.f4205j) != null && this.f4199d.platformViewOfNode(num.intValue()) == this.f4200e.c(lVar.f4296i)) {
            T(this.f4205j.intValue(), 65536);
            this.f4205j = null;
        }
        if (lVar.f4296i != -1 && (c5 = this.f4200e.c(lVar.f4296i)) != null) {
            c5.setImportantForAccessibility(4);
        }
        l lVar2 = this.f4204i;
        if (lVar2 == lVar) {
            T(lVar2.f4288b, 65536);
            this.f4204i = null;
        }
        if (this.f4208m == lVar) {
            this.f4208m = null;
        }
        if (this.f4210o == lVar) {
            this.f4210o = null;
        }
    }

    static /* synthetic */ int f(h hVar, int i5) {
        int i6 = i5 | hVar.f4207l;
        hVar.f4207l = i6;
        return i6;
    }

    private AccessibilityEvent u(int i5, String str, String str2) {
        AccessibilityEvent I = I(i5, 16);
        I.setBeforeText(str);
        I.getText().add(str2);
        int i6 = 0;
        while (i6 < str.length() && i6 < str2.length() && str.charAt(i6) == str2.charAt(i6)) {
            i6++;
        }
        if (i6 < str.length() || i6 < str2.length()) {
            I.setFromIndex(i6);
            int length = str.length() - 1;
            int length2 = str2.length() - 1;
            while (length >= i6 && length2 >= i6 && str.charAt(length) == str2.charAt(length2)) {
                length--;
                length2--;
            }
            I.setRemovedCount((length - i6) + 1);
            I.setAddedCount((length2 - i6) + 1);
            return I;
        }
        return null;
    }

    private boolean v() {
        Activity e5 = h3.h.e(this.f4196a.getContext());
        if (e5 == null || e5.getWindow() == null) {
            return false;
        }
        int i5 = e5.getWindow().getAttributes().layoutInDisplayCutoutMode;
        return i5 == 2 || i5 == 0;
    }

    private Rect x(Rect rect) {
        Rect rect2 = new Rect(rect);
        int[] iArr = new int[2];
        this.f4196a.getLocationOnScreen(iArr);
        rect2.offset(iArr[0], iArr[1]);
        return rect2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public C0072h y(int i5) {
        C0072h c0072h = this.f4203h.get(Integer.valueOf(i5));
        if (c0072h == null) {
            C0072h c0072h2 = new C0072h();
            c0072h2.f4259b = i5;
            c0072h2.f4258a = B + i5;
            this.f4203h.put(Integer.valueOf(i5), c0072h2);
            return c0072h2;
        }
        return c0072h;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public l z(int i5) {
        l lVar = this.f4202g.get(Integer.valueOf(i5));
        if (lVar == null) {
            l lVar2 = new l(this);
            lVar2.f4288b = i5;
            this.f4202g.put(Integer.valueOf(i5), lVar2);
            return lVar2;
        }
        return lVar;
    }

    public boolean C() {
        return this.f4198c.isEnabled();
    }

    public boolean E() {
        return this.f4198c.isTouchExplorationEnabled();
    }

    public AccessibilityEvent H(int i5) {
        return AccessibilityEvent.obtain(i5);
    }

    public AccessibilityNodeInfo J(View view) {
        return AccessibilityNodeInfo.obtain(view);
    }

    public AccessibilityNodeInfo K(View view, int i5) {
        return AccessibilityNodeInfo.obtain(view, i5);
    }

    public boolean L(MotionEvent motionEvent) {
        return M(motionEvent, false);
    }

    public boolean M(MotionEvent motionEvent, boolean z4) {
        if (this.f4198c.isTouchExplorationEnabled() && !this.f4202g.isEmpty()) {
            l y02 = A().y0(new float[]{motionEvent.getX(), motionEvent.getY(), 0.0f, 1.0f}, z4);
            if (y02 != null && y02.f4296i != -1) {
                if (z4) {
                    return false;
                }
                return this.f4199d.onAccessibilityHoverEvent(y02.f4288b, motionEvent);
            }
            if (motionEvent.getAction() == 9 || motionEvent.getAction() == 7) {
                B(motionEvent.getX(), motionEvent.getY(), z4);
            } else if (motionEvent.getAction() != 10) {
                n2.b.a("flutter", "unexpected accessibility hover event: " + motionEvent);
                return false;
            } else {
                N();
            }
            return true;
        }
        return false;
    }

    public void S() {
        this.f4216u = true;
        this.f4200e.d();
        a0(null);
        this.f4198c.removeAccessibilityStateChangeListener(this.f4218w);
        this.f4198c.removeTouchExplorationStateChangeListener(this.f4219x);
        this.f4201f.unregisterContentObserver(this.f4220y);
        this.f4197b.g(null);
    }

    public void T(int i5, int i6) {
        if (this.f4198c.isEnabled()) {
            U(I(i5, i6));
        }
    }

    public void a0(k kVar) {
        this.f4214s = kVar;
    }

    void c0(ByteBuffer byteBuffer, String[] strArr) {
        while (byteBuffer.hasRemaining()) {
            C0072h y4 = y(byteBuffer.getInt());
            y4.f4260c = byteBuffer.getInt();
            int i5 = byteBuffer.getInt();
            String str = null;
            y4.f4261d = i5 == -1 ? null : strArr[i5];
            int i6 = byteBuffer.getInt();
            if (i6 != -1) {
                str = strArr[i6];
            }
            y4.f4262e = str;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:226:0x041f  */
    /* JADX WARN: Removed duplicated region for block: B:235:0x0440  */
    /* JADX WARN: Removed duplicated region for block: B:242:0x0473  */
    @Override // android.view.accessibility.AccessibilityNodeProvider
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.view.accessibility.AccessibilityNodeInfo createAccessibilityNodeInfo(int r14) {
        /*
            Method dump skipped, instructions count: 1197
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flutter.view.h.createAccessibilityNodeInfo(int):android.view.accessibility.AccessibilityNodeInfo");
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x0080, code lost:
        r4 = r8.f4196a.getRootWindowInsets();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    void d0(java.nio.ByteBuffer r9, java.lang.String[] r10, java.nio.ByteBuffer[] r11) {
        /*
            Method dump skipped, instructions count: 833
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flutter.view.h.d0(java.nio.ByteBuffer, java.lang.String[], java.nio.ByteBuffer[]):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0016, code lost:
        if (r2 != null) goto L11;
     */
    @Override // android.view.accessibility.AccessibilityNodeProvider
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.view.accessibility.AccessibilityNodeInfo findFocus(int r2) {
        /*
            r1 = this;
            r0 = 1
            if (r2 == r0) goto L7
            r0 = 2
            if (r2 == r0) goto L1d
            goto L27
        L7:
            io.flutter.view.h$l r2 = r1.f4208m
            if (r2 == 0) goto L14
        Lb:
            int r2 = io.flutter.view.h.l.a(r2)
        Lf:
            android.view.accessibility.AccessibilityNodeInfo r2 = r1.createAccessibilityNodeInfo(r2)
            return r2
        L14:
            java.lang.Integer r2 = r1.f4206k
            if (r2 == 0) goto L1d
        L18:
            int r2 = r2.intValue()
            goto Lf
        L1d:
            io.flutter.view.h$l r2 = r1.f4204i
            if (r2 == 0) goto L22
            goto Lb
        L22:
            java.lang.Integer r2 = r1.f4205j
            if (r2 == 0) goto L27
            goto L18
        L27:
            r2 = 0
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flutter.view.h.findFocus(int):android.view.accessibility.AccessibilityNodeInfo");
    }

    @Override // android.view.accessibility.AccessibilityNodeProvider
    public boolean performAction(int i5, int i6, Bundle bundle) {
        int i7;
        if (i5 >= 65536) {
            boolean performAction = this.f4199d.performAction(i5, i6, bundle);
            if (performAction && i6 == 128) {
                this.f4205j = null;
            }
            return performAction;
        }
        l lVar = this.f4202g.get(Integer.valueOf(i5));
        boolean z4 = false;
        if (lVar == null) {
            return false;
        }
        switch (i6) {
            case 16:
                this.f4197b.b(i5, g.TAP);
                return true;
            case 32:
                this.f4197b.b(i5, g.LONG_PRESS);
                return true;
            case 64:
                if (this.f4204i == null) {
                    this.f4196a.invalidate();
                }
                this.f4204i = lVar;
                this.f4197b.b(i5, g.DID_GAIN_ACCESSIBILITY_FOCUS);
                HashMap hashMap = new HashMap();
                hashMap.put("type", "didGainFocus");
                hashMap.put("nodeId", Integer.valueOf(lVar.f4288b));
                this.f4197b.f8594a.c(hashMap);
                T(i5, 32768);
                if (lVar.w0(g.INCREASE) || lVar.w0(g.DECREASE)) {
                    T(i5, 4);
                }
                return true;
            case 128:
                l lVar2 = this.f4204i;
                if (lVar2 != null && lVar2.f4288b == i5) {
                    this.f4204i = null;
                }
                Integer num = this.f4205j;
                if (num != null && num.intValue() == i5) {
                    this.f4205j = null;
                }
                this.f4197b.b(i5, g.DID_LOSE_ACCESSIBILITY_FOCUS);
                T(i5, 65536);
                return true;
            case 256:
                return P(lVar, i5, bundle, true);
            case 512:
                return P(lVar, i5, bundle, false);
            case 4096:
                g gVar = g.SCROLL_UP;
                if (!lVar.w0(gVar)) {
                    gVar = g.SCROLL_LEFT;
                    if (!lVar.w0(gVar)) {
                        gVar = g.INCREASE;
                        if (!lVar.w0(gVar)) {
                            return false;
                        }
                        lVar.f4305r = lVar.f4307t;
                        lVar.f4306s = lVar.f4308u;
                        T(i5, 4);
                    }
                }
                this.f4197b.b(i5, gVar);
                return true;
            case 8192:
                g gVar2 = g.SCROLL_DOWN;
                if (!lVar.w0(gVar2)) {
                    gVar2 = g.SCROLL_RIGHT;
                    if (!lVar.w0(gVar2)) {
                        gVar2 = g.DECREASE;
                        if (!lVar.w0(gVar2)) {
                            return false;
                        }
                        lVar.f4305r = lVar.f4309v;
                        lVar.f4306s = lVar.f4310w;
                        T(i5, 4);
                    }
                }
                this.f4197b.b(i5, gVar2);
                return true;
            case 16384:
                this.f4197b.b(i5, g.COPY);
                return true;
            case 32768:
                this.f4197b.b(i5, g.PASTE);
                return true;
            case 65536:
                this.f4197b.b(i5, g.CUT);
                return true;
            case 131072:
                HashMap hashMap2 = new HashMap();
                if (bundle != null && bundle.containsKey("ACTION_ARGUMENT_SELECTION_START_INT") && bundle.containsKey("ACTION_ARGUMENT_SELECTION_END_INT")) {
                    z4 = true;
                }
                if (z4) {
                    hashMap2.put("base", Integer.valueOf(bundle.getInt("ACTION_ARGUMENT_SELECTION_START_INT")));
                    i7 = bundle.getInt("ACTION_ARGUMENT_SELECTION_END_INT");
                } else {
                    hashMap2.put("base", Integer.valueOf(lVar.f4295h));
                    i7 = lVar.f4295h;
                }
                hashMap2.put("extent", Integer.valueOf(i7));
                this.f4197b.c(i5, g.SET_SELECTION, hashMap2);
                l lVar3 = this.f4202g.get(Integer.valueOf(i5));
                lVar3.f4294g = ((Integer) hashMap2.get("base")).intValue();
                lVar3.f4295h = ((Integer) hashMap2.get("extent")).intValue();
                return true;
            case 1048576:
                this.f4197b.b(i5, g.DISMISS);
                return true;
            case 2097152:
                return Q(lVar, i5, bundle);
            case 16908342:
                this.f4197b.b(i5, g.SHOW_ON_SCREEN);
                return true;
            default:
                C0072h c0072h = this.f4203h.get(Integer.valueOf(i6 - B));
                if (c0072h != null) {
                    this.f4197b.c(i5, g.CUSTOM_ACTION, Integer.valueOf(c0072h.f4259b));
                    return true;
                }
                return false;
        }
    }

    public boolean w(View view, View view2, AccessibilityEvent accessibilityEvent) {
        Integer recordFlutterId;
        if (this.f4199d.requestSendAccessibilityEvent(view, view2, accessibilityEvent) && (recordFlutterId = this.f4199d.getRecordFlutterId(view, accessibilityEvent)) != null) {
            int eventType = accessibilityEvent.getEventType();
            if (eventType == 8) {
                this.f4206k = recordFlutterId;
                this.f4208m = null;
                return true;
            } else if (eventType == 128) {
                this.f4210o = null;
                return true;
            } else if (eventType == 32768) {
                this.f4205j = recordFlutterId;
                this.f4204i = null;
                return true;
            } else if (eventType != 65536) {
                return true;
            } else {
                this.f4206k = null;
                this.f4205j = null;
                return true;
            }
        }
        return false;
    }
}
