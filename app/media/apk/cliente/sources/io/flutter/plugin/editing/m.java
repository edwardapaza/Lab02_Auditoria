package io.flutter.plugin.editing;

import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewStructure;
import android.view.autofill.AutofillId;
import android.view.autofill.AutofillManager;
import android.view.autofill.AutofillValue;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import io.flutter.embedding.android.b0;
import io.flutter.plugin.editing.e;
import io.flutter.plugin.platform.w;
import java.util.HashMap;
import y2.s;
/* loaded from: classes.dex */
public class m implements e.b {

    /* renamed from: a  reason: collision with root package name */
    private final View f3967a;

    /* renamed from: b  reason: collision with root package name */
    private final InputMethodManager f3968b;

    /* renamed from: c  reason: collision with root package name */
    private final AutofillManager f3969c;

    /* renamed from: d  reason: collision with root package name */
    private final s f3970d;

    /* renamed from: e  reason: collision with root package name */
    private c f3971e = new c(c.a.NO_TARGET, 0);

    /* renamed from: f  reason: collision with root package name */
    private s.b f3972f;

    /* renamed from: g  reason: collision with root package name */
    private SparseArray<s.b> f3973g;

    /* renamed from: h  reason: collision with root package name */
    private e f3974h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f3975i;

    /* renamed from: j  reason: collision with root package name */
    private InputConnection f3976j;

    /* renamed from: k  reason: collision with root package name */
    private w f3977k;

    /* renamed from: l  reason: collision with root package name */
    private Rect f3978l;

    /* renamed from: m  reason: collision with root package name */
    private ImeSyncDeferringInsetsCallback f3979m;

    /* renamed from: n  reason: collision with root package name */
    private s.e f3980n;

    /* renamed from: o  reason: collision with root package name */
    private boolean f3981o;

    /* loaded from: classes.dex */
    class a implements s.f {
        a() {
        }

        @Override // y2.s.f
        public void a() {
            m.this.l();
        }

        @Override // y2.s.f
        public void b() {
            m mVar = m.this;
            mVar.E(mVar.f3967a);
        }

        @Override // y2.s.f
        public void c(s.e eVar) {
            m mVar = m.this;
            mVar.D(mVar.f3967a, eVar);
        }

        @Override // y2.s.f
        public void d(int i5, s.b bVar) {
            m.this.C(i5, bVar);
        }

        @Override // y2.s.f
        public void e(String str, Bundle bundle) {
            m.this.A(str, bundle);
        }

        @Override // y2.s.f
        public void f(int i5, boolean z4) {
            m.this.B(i5, z4);
        }

        @Override // y2.s.f
        public void g(double d5, double d6, double[] dArr) {
            m.this.z(d5, d6, dArr);
        }

        @Override // y2.s.f
        public void h() {
            m.this.w();
        }

        @Override // y2.s.f
        public void i(boolean z4) {
            if (Build.VERSION.SDK_INT < 26 || m.this.f3969c == null) {
                return;
            }
            if (z4) {
                m.this.f3969c.commit();
            } else {
                m.this.f3969c.cancel();
            }
        }

        @Override // y2.s.f
        public void j() {
            if (m.this.f3971e.f3987a == c.a.PHYSICAL_DISPLAY_PLATFORM_VIEW) {
                m.this.x();
                return;
            }
            m mVar = m.this;
            mVar.r(mVar.f3967a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b implements d {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ boolean f3983a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ double[] f3984b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ double[] f3985c;

        b(boolean z4, double[] dArr, double[] dArr2) {
            this.f3983a = z4;
            this.f3984b = dArr;
            this.f3985c = dArr2;
        }

        @Override // io.flutter.plugin.editing.m.d
        public void a(double d5, double d6) {
            double d7 = 1.0d;
            if (!this.f3983a) {
                double[] dArr = this.f3984b;
                d7 = 1.0d / (((dArr[3] * d5) + (dArr[7] * d6)) + dArr[15]);
            }
            double[] dArr2 = this.f3984b;
            double d8 = ((dArr2[0] * d5) + (dArr2[4] * d6) + dArr2[12]) * d7;
            double d9 = ((dArr2[1] * d5) + (dArr2[5] * d6) + dArr2[13]) * d7;
            double[] dArr3 = this.f3985c;
            if (d8 < dArr3[0]) {
                dArr3[0] = d8;
            } else if (d8 > dArr3[1]) {
                dArr3[1] = d8;
            }
            if (d9 < dArr3[2]) {
                dArr3[2] = d9;
            } else if (d9 > dArr3[3]) {
                dArr3[3] = d9;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        a f3987a;

        /* renamed from: b  reason: collision with root package name */
        int f3988b;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public enum a {
            NO_TARGET,
            FRAMEWORK_CLIENT,
            VIRTUAL_DISPLAY_PLATFORM_VIEW,
            PHYSICAL_DISPLAY_PLATFORM_VIEW
        }

        public c(a aVar, int i5) {
            this.f3987a = aVar;
            this.f3988b = i5;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public interface d {
        void a(double d5, double d6);
    }

    public m(View view, s sVar, w wVar) {
        Object systemService;
        this.f3967a = view;
        AutofillManager autofillManager = null;
        this.f3974h = new e(null, view);
        this.f3968b = (InputMethodManager) view.getContext().getSystemService("input_method");
        int i5 = Build.VERSION.SDK_INT;
        if (i5 >= 26) {
            systemService = view.getContext().getSystemService(AutofillManager.class);
            autofillManager = (AutofillManager) systemService;
        }
        this.f3969c = autofillManager;
        if (i5 >= 30) {
            ImeSyncDeferringInsetsCallback imeSyncDeferringInsetsCallback = new ImeSyncDeferringInsetsCallback(view);
            this.f3979m = imeSyncDeferringInsetsCallback;
            imeSyncDeferringInsetsCallback.install();
        }
        this.f3970d = sVar;
        sVar.n(new a());
        sVar.k();
        this.f3977k = wVar;
        wVar.D(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B(int i5, boolean z4) {
        if (!z4) {
            this.f3971e = new c(c.a.PHYSICAL_DISPLAY_PLATFORM_VIEW, i5);
            this.f3976j = null;
            return;
        }
        this.f3967a.requestFocus();
        this.f3971e = new c(c.a.VIRTUAL_DISPLAY_PLATFORM_VIEW, i5);
        this.f3968b.restartInput(this.f3967a);
        this.f3975i = false;
    }

    private void G(s.b bVar) {
        if (Build.VERSION.SDK_INT < 26) {
            return;
        }
        if (bVar == null || bVar.f8777j == null) {
            this.f3973g = null;
            return;
        }
        s.b[] bVarArr = bVar.f8779l;
        SparseArray<s.b> sparseArray = new SparseArray<>();
        this.f3973g = sparseArray;
        if (bVarArr == null) {
            sparseArray.put(bVar.f8777j.f8780a.hashCode(), bVar);
            return;
        }
        for (s.b bVar2 : bVarArr) {
            s.b.a aVar = bVar2.f8777j;
            if (aVar != null) {
                this.f3973g.put(aVar.f8780a.hashCode(), bVar2);
                this.f3969c.notifyValueChanged(this.f3967a, aVar.f8780a.hashCode(), AutofillValue.forText(aVar.f8782c.f8793a));
            }
        }
    }

    private static boolean m(s.e eVar, s.e eVar2) {
        int i5 = eVar.f8797e - eVar.f8796d;
        if (i5 != eVar2.f8797e - eVar2.f8796d) {
            return true;
        }
        for (int i6 = 0; i6 < i5; i6++) {
            if (eVar.f8793a.charAt(eVar.f8796d + i6) != eVar2.f8793a.charAt(eVar2.f8796d + i6)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(View view) {
        x();
        this.f3968b.hideSoftInputFromWindow(view.getApplicationWindowToken(), 0);
    }

    private static int s(s.c cVar, boolean z4, boolean z5, boolean z6, boolean z7, s.d dVar) {
        s.g gVar = cVar.f8784a;
        if (gVar == s.g.DATETIME) {
            return 4;
        }
        if (gVar == s.g.NUMBER) {
            int i5 = cVar.f8785b ? 4098 : 2;
            return cVar.f8786c ? i5 | 8192 : i5;
        } else if (gVar == s.g.PHONE) {
            return 3;
        } else {
            if (gVar == s.g.NONE) {
                return 0;
            }
            int i6 = 1;
            if (gVar == s.g.MULTILINE) {
                i6 = 131073;
            } else if (gVar == s.g.EMAIL_ADDRESS) {
                i6 = 33;
            } else if (gVar == s.g.URL) {
                i6 = 17;
            } else if (gVar == s.g.VISIBLE_PASSWORD) {
                i6 = 145;
            } else if (gVar == s.g.NAME) {
                i6 = 97;
            } else if (gVar == s.g.POSTAL_ADDRESS) {
                i6 = 113;
            }
            if (z4) {
                i6 = i6 | 524288 | 128;
            } else {
                if (z5) {
                    i6 |= 32768;
                }
                if (!z6) {
                    i6 = i6 | 524288 | 144;
                }
            }
            return dVar == s.d.CHARACTERS ? i6 | 4096 : dVar == s.d.WORDS ? i6 | 8192 : dVar == s.d.SENTENCES ? i6 | 16384 : i6;
        }
    }

    private boolean u() {
        return this.f3973g != null;
    }

    private void v(String str) {
        if (Build.VERSION.SDK_INT < 26 || this.f3969c == null || !u()) {
            return;
        }
        this.f3969c.notifyValueChanged(this.f3967a, this.f3972f.f8777j.f8780a.hashCode(), AutofillValue.forText(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w() {
        if (Build.VERSION.SDK_INT < 26 || this.f3969c == null || !u()) {
            return;
        }
        String str = this.f3972f.f8777j.f8780a;
        int[] iArr = new int[2];
        this.f3967a.getLocationOnScreen(iArr);
        Rect rect = new Rect(this.f3978l);
        rect.offset(iArr[0], iArr[1]);
        this.f3969c.notifyViewEntered(this.f3967a, str.hashCode(), rect);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x() {
        s.b bVar;
        if (Build.VERSION.SDK_INT < 26 || this.f3969c == null || (bVar = this.f3972f) == null || bVar.f8777j == null || !u()) {
            return;
        }
        this.f3969c.notifyViewExited(this.f3967a, this.f3972f.f8777j.f8780a.hashCode());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(double d5, double d6, double[] dArr) {
        double[] dArr2 = new double[4];
        boolean z4 = dArr[3] == 0.0d && dArr[7] == 0.0d && dArr[15] == 1.0d;
        double d7 = dArr[12];
        double d8 = dArr[15];
        double d9 = d7 / d8;
        dArr2[1] = d9;
        dArr2[0] = d9;
        double d10 = dArr[13] / d8;
        dArr2[3] = d10;
        dArr2[2] = d10;
        b bVar = new b(z4, dArr, dArr2);
        bVar.a(d5, 0.0d);
        bVar.a(d5, d6);
        bVar.a(0.0d, d6);
        Float valueOf = Float.valueOf(this.f3967a.getContext().getResources().getDisplayMetrics().density);
        this.f3978l = new Rect((int) (dArr2[0] * valueOf.floatValue()), (int) (dArr2[2] * valueOf.floatValue()), (int) Math.ceil(dArr2[1] * valueOf.floatValue()), (int) Math.ceil(dArr2[3] * valueOf.floatValue()));
    }

    public void A(String str, Bundle bundle) {
        this.f3968b.sendAppPrivateCommand(this.f3967a, str, bundle);
    }

    void C(int i5, s.b bVar) {
        x();
        this.f3972f = bVar;
        this.f3971e = new c(c.a.FRAMEWORK_CLIENT, i5);
        this.f3974h.l(this);
        s.b.a aVar = bVar.f8777j;
        this.f3974h = new e(aVar != null ? aVar.f8782c : null, this.f3967a);
        G(bVar);
        this.f3975i = true;
        F();
        this.f3978l = null;
        this.f3974h.a(this);
    }

    void D(View view, s.e eVar) {
        s.e eVar2;
        if (!this.f3975i && (eVar2 = this.f3980n) != null && eVar2.b()) {
            boolean m5 = m(this.f3980n, eVar);
            this.f3975i = m5;
            if (m5) {
                n2.b.e("TextInputPlugin", "Composing region changed by the framework. Restarting the input method.");
            }
        }
        this.f3980n = eVar;
        this.f3974h.n(eVar);
        if (this.f3975i) {
            this.f3968b.restartInput(view);
            this.f3975i = false;
        }
    }

    void E(View view) {
        s.c cVar;
        s.b bVar = this.f3972f;
        if (bVar != null && (cVar = bVar.f8774g) != null && cVar.f8784a == s.g.NONE) {
            r(view);
            return;
        }
        view.requestFocus();
        this.f3968b.showSoftInput(view, 0);
    }

    public void F() {
        if (this.f3971e.f3987a == c.a.VIRTUAL_DISPLAY_PLATFORM_VIEW) {
            this.f3981o = false;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x004d, code lost:
        if (r7 == r1.f8797e) goto L26;
     */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00ac  */
    @Override // io.flutter.plugin.editing.e.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(boolean r9, boolean r10, boolean r11) {
        /*
            r8 = this;
            if (r9 == 0) goto Lb
            io.flutter.plugin.editing.e r9 = r8.f3974h
            java.lang.String r9 = r9.toString()
            r8.v(r9)
        Lb:
            io.flutter.plugin.editing.e r9 = r8.f3974h
            int r9 = r9.i()
            io.flutter.plugin.editing.e r10 = r8.f3974h
            int r10 = r10.h()
            io.flutter.plugin.editing.e r11 = r8.f3974h
            int r11 = r11.g()
            io.flutter.plugin.editing.e r0 = r8.f3974h
            int r7 = r0.f()
            io.flutter.plugin.editing.e r0 = r8.f3974h
            java.util.ArrayList r0 = r0.e()
            y2.s$e r1 = r8.f3980n
            if (r1 == 0) goto L52
            io.flutter.plugin.editing.e r1 = r8.f3974h
            java.lang.String r1 = r1.toString()
            y2.s$e r2 = r8.f3980n
            java.lang.String r2 = r2.f8793a
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L50
            y2.s$e r1 = r8.f3980n
            int r2 = r1.f8794b
            if (r9 != r2) goto L50
            int r2 = r1.f8795c
            if (r10 != r2) goto L50
            int r2 = r1.f8796d
            if (r11 != r2) goto L50
            int r1 = r1.f8797e
            if (r7 != r1) goto L50
            goto L52
        L50:
            r1 = 0
            goto L53
        L52:
            r1 = 1
        L53:
            if (r1 != 0) goto Lac
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "send EditingState to flutter: "
            r1.append(r2)
            io.flutter.plugin.editing.e r2 = r8.f3974h
            java.lang.String r2 = r2.toString()
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            java.lang.String r2 = "TextInputPlugin"
            n2.b.f(r2, r1)
            y2.s$b r1 = r8.f3972f
            boolean r1 = r1.f8772e
            if (r1 == 0) goto L86
            y2.s r1 = r8.f3970d
            io.flutter.plugin.editing.m$c r2 = r8.f3971e
            int r2 = r2.f3988b
            r1.q(r2, r0)
            io.flutter.plugin.editing.e r0 = r8.f3974h
            r0.c()
            goto L99
        L86:
            y2.s r0 = r8.f3970d
            io.flutter.plugin.editing.m$c r1 = r8.f3971e
            int r1 = r1.f3988b
            io.flutter.plugin.editing.e r2 = r8.f3974h
            java.lang.String r2 = r2.toString()
            r3 = r9
            r4 = r10
            r5 = r11
            r6 = r7
            r0.p(r1, r2, r3, r4, r5, r6)
        L99:
            y2.s$e r6 = new y2.s$e
            io.flutter.plugin.editing.e r0 = r8.f3974h
            java.lang.String r1 = r0.toString()
            r0 = r6
            r2 = r9
            r3 = r10
            r4 = r11
            r5 = r7
            r0.<init>(r1, r2, r3, r4, r5)
            r8.f3980n = r6
            goto Lb1
        Lac:
            io.flutter.plugin.editing.e r9 = r8.f3974h
            r9.c()
        Lb1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flutter.plugin.editing.m.a(boolean, boolean, boolean):void");
    }

    public void j(SparseArray<AutofillValue> sparseArray) {
        s.b bVar;
        s.b.a aVar;
        s.b.a aVar2;
        if (Build.VERSION.SDK_INT < 26 || (bVar = this.f3972f) == null || this.f3973g == null || (aVar = bVar.f8777j) == null) {
            return;
        }
        HashMap<String, s.e> hashMap = new HashMap<>();
        for (int i5 = 0; i5 < sparseArray.size(); i5++) {
            s.b bVar2 = this.f3973g.get(sparseArray.keyAt(i5));
            if (bVar2 != null && (aVar2 = bVar2.f8777j) != null) {
                String charSequence = sparseArray.valueAt(i5).getTextValue().toString();
                s.e eVar = new s.e(charSequence, charSequence.length(), charSequence.length(), -1, -1);
                if (aVar2.f8780a.equals(aVar.f8780a)) {
                    this.f3974h.n(eVar);
                } else {
                    hashMap.put(aVar2.f8780a, eVar);
                }
            }
        }
        this.f3970d.r(this.f3971e.f3988b, hashMap);
    }

    public void k(int i5) {
        c cVar = this.f3971e;
        c.a aVar = cVar.f3987a;
        if ((aVar == c.a.VIRTUAL_DISPLAY_PLATFORM_VIEW || aVar == c.a.PHYSICAL_DISPLAY_PLATFORM_VIEW) && cVar.f3988b == i5) {
            this.f3971e = new c(c.a.NO_TARGET, 0);
            x();
            this.f3968b.hideSoftInputFromWindow(this.f3967a.getApplicationWindowToken(), 0);
            this.f3968b.restartInput(this.f3967a);
            this.f3975i = false;
        }
    }

    void l() {
        if (this.f3971e.f3987a == c.a.VIRTUAL_DISPLAY_PLATFORM_VIEW) {
            return;
        }
        this.f3974h.l(this);
        x();
        this.f3972f = null;
        G(null);
        this.f3971e = new c(c.a.NO_TARGET, 0);
        F();
        this.f3978l = null;
        this.f3968b.restartInput(this.f3967a);
    }

    public InputConnection n(View view, b0 b0Var, EditorInfo editorInfo) {
        c cVar = this.f3971e;
        c.a aVar = cVar.f3987a;
        if (aVar == c.a.NO_TARGET) {
            this.f3976j = null;
            return null;
        } else if (aVar == c.a.PHYSICAL_DISPLAY_PLATFORM_VIEW) {
            return null;
        } else {
            if (aVar == c.a.VIRTUAL_DISPLAY_PLATFORM_VIEW) {
                if (this.f3981o) {
                    return this.f3976j;
                }
                InputConnection onCreateInputConnection = this.f3977k.c(cVar.f3988b).onCreateInputConnection(editorInfo);
                this.f3976j = onCreateInputConnection;
                return onCreateInputConnection;
            }
            s.b bVar = this.f3972f;
            int s5 = s(bVar.f8774g, bVar.f8768a, bVar.f8769b, bVar.f8770c, bVar.f8771d, bVar.f8773f);
            editorInfo.inputType = s5;
            editorInfo.imeOptions = 33554432;
            if (Build.VERSION.SDK_INT >= 26 && !this.f3972f.f8771d) {
                editorInfo.imeOptions = 33554432 | 16777216;
            }
            Integer num = this.f3972f.f8775h;
            int intValue = num == null ? (s5 & 131072) != 0 ? 1 : 6 : num.intValue();
            s.b bVar2 = this.f3972f;
            String str = bVar2.f8776i;
            if (str != null) {
                editorInfo.actionLabel = str;
                editorInfo.actionId = intValue;
            }
            editorInfo.imeOptions = intValue | editorInfo.imeOptions;
            String[] strArr = bVar2.f8778k;
            if (strArr != null) {
                m.a.a(editorInfo, strArr);
            }
            io.flutter.plugin.editing.d dVar = new io.flutter.plugin.editing.d(view, this.f3971e.f3988b, this.f3970d, b0Var, this.f3974h, editorInfo);
            editorInfo.initialSelStart = this.f3974h.i();
            editorInfo.initialSelEnd = this.f3974h.h();
            this.f3976j = dVar;
            return dVar;
        }
    }

    public void o() {
        this.f3977k.Q();
        this.f3970d.n(null);
        x();
        this.f3974h.l(this);
        ImeSyncDeferringInsetsCallback imeSyncDeferringInsetsCallback = this.f3979m;
        if (imeSyncDeferringInsetsCallback != null) {
            imeSyncDeferringInsetsCallback.remove();
        }
    }

    public InputMethodManager p() {
        return this.f3968b;
    }

    public boolean q(KeyEvent keyEvent) {
        InputConnection inputConnection;
        if (!p().isAcceptingText() || (inputConnection = this.f3976j) == null) {
            return false;
        }
        return inputConnection instanceof io.flutter.plugin.editing.d ? ((io.flutter.plugin.editing.d) inputConnection).f(keyEvent) : inputConnection.sendKeyEvent(keyEvent);
    }

    public void t() {
        if (this.f3971e.f3987a == c.a.VIRTUAL_DISPLAY_PLATFORM_VIEW) {
            this.f3981o = true;
        }
    }

    public void y(ViewStructure viewStructure, int i5) {
        AutofillId autofillId;
        Rect rect;
        if (Build.VERSION.SDK_INT < 26 || !u()) {
            return;
        }
        String str = this.f3972f.f8777j.f8780a;
        autofillId = viewStructure.getAutofillId();
        for (int i6 = 0; i6 < this.f3973g.size(); i6++) {
            int keyAt = this.f3973g.keyAt(i6);
            s.b.a aVar = this.f3973g.valueAt(i6).f8777j;
            if (aVar != null) {
                viewStructure.addChildCount(1);
                ViewStructure newChild = viewStructure.newChild(i6);
                newChild.setAutofillId(autofillId, keyAt);
                String[] strArr = aVar.f8781b;
                if (strArr.length > 0) {
                    newChild.setAutofillHints(strArr);
                }
                newChild.setAutofillType(1);
                newChild.setVisibility(0);
                String str2 = aVar.f8783d;
                if (str2 != null) {
                    newChild.setHint(str2);
                }
                if (str.hashCode() != keyAt || (rect = this.f3978l) == null) {
                    newChild.setDimens(0, 0, 0, 0, 1, 1);
                    newChild.setAutofillValue(AutofillValue.forText(aVar.f8782c.f8793a));
                } else {
                    newChild.setDimens(rect.left, rect.top, 0, 0, rect.width(), this.f3978l.height());
                    newChild.setAutofillValue(AutofillValue.forText(this.f3974h));
                }
            }
        }
    }
}
