package androidx.core.app;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import androidx.core.view.b;
import androidx.lifecycle.i;
/* loaded from: classes.dex */
public class m extends Activity implements androidx.lifecycle.m, b.a {

    /* renamed from: a  reason: collision with root package name */
    private final androidx.collection.f<Class<Object>, Object> f266a = new androidx.collection.f<>();

    /* renamed from: b  reason: collision with root package name */
    private final androidx.lifecycle.n f267b = new androidx.lifecycle.n(this);

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0046, code lost:
        if (r4.equals("--list-dumpables") == false) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x004f, code lost:
        if (r4.equals("--dump-dumpable") == false) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0056, code lost:
        if (android.os.Build.VERSION.SDK_INT < 33) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0059, code lost:
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:?, code lost:
        return true;
     */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0012  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final boolean t(java.lang.String[] r4) {
        /*
            r3 = this;
            r0 = 1
            r1 = 0
            if (r4 == 0) goto Lf
            int r2 = r4.length
            if (r2 != 0) goto L9
            r2 = 1
            goto La
        L9:
            r2 = 0
        La:
            if (r2 == 0) goto Ld
            goto Lf
        Ld:
            r2 = 0
            goto L10
        Lf:
            r2 = 1
        L10:
            if (r2 != 0) goto L6d
            r4 = r4[r1]
            int r2 = r4.hashCode()
            switch(r2) {
                case -645125871: goto L5b;
                case 100470631: goto L49;
                case 472614934: goto L40;
                case 1159329357: goto L2e;
                case 1455016274: goto L1c;
                default: goto L1b;
            }
        L1b:
            goto L6d
        L1c:
            java.lang.String r2 = "--autofill"
            boolean r4 = r4.equals(r2)
            if (r4 != 0) goto L25
            goto L6d
        L25:
            int r4 = android.os.Build.VERSION.SDK_INT
            r2 = 26
            if (r4 < r2) goto L2c
            goto L2d
        L2c:
            r0 = 0
        L2d:
            return r0
        L2e:
            java.lang.String r2 = "--contentcapture"
            boolean r4 = r4.equals(r2)
            if (r4 != 0) goto L37
            goto L6d
        L37:
            int r4 = android.os.Build.VERSION.SDK_INT
            r2 = 29
            if (r4 < r2) goto L3e
            goto L3f
        L3e:
            r0 = 0
        L3f:
            return r0
        L40:
            java.lang.String r2 = "--list-dumpables"
            boolean r4 = r4.equals(r2)
            if (r4 != 0) goto L52
            goto L6d
        L49:
            java.lang.String r2 = "--dump-dumpable"
            boolean r4 = r4.equals(r2)
            if (r4 != 0) goto L52
            goto L6d
        L52:
            int r4 = android.os.Build.VERSION.SDK_INT
            r2 = 33
            if (r4 < r2) goto L59
            goto L5a
        L59:
            r0 = 0
        L5a:
            return r0
        L5b:
            java.lang.String r2 = "--translation"
            boolean r4 = r4.equals(r2)
            if (r4 != 0) goto L64
            goto L6d
        L64:
            int r4 = android.os.Build.VERSION.SDK_INT
            r2 = 31
            if (r4 < r2) goto L6b
            goto L6c
        L6b:
            r0 = 0
        L6c:
            return r0
        L6d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.app.m.t(java.lang.String[]):boolean");
    }

    public androidx.lifecycle.i a() {
        return this.f267b;
    }

    @Override // androidx.core.view.b.a
    public boolean d(KeyEvent keyEvent) {
        e4.k.e(keyEvent, "event");
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        e4.k.e(keyEvent, "event");
        View decorView = getWindow().getDecorView();
        e4.k.d(decorView, "window.decorView");
        if (androidx.core.view.b.d(decorView, keyEvent)) {
            return true;
        }
        return androidx.core.view.b.e(this, decorView, this, keyEvent);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        e4.k.e(keyEvent, "event");
        View decorView = getWindow().getDecorView();
        e4.k.d(decorView, "window.decorView");
        if (androidx.core.view.b.d(decorView, keyEvent)) {
            return true;
        }
        return super.dispatchKeyShortcutEvent(keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        androidx.lifecycle.z.f613b.c(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        e4.k.e(bundle, "outState");
        this.f267b.m(i.b.CREATED);
        super.onSaveInstanceState(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean s(String[] strArr) {
        return !t(strArr);
    }
}
