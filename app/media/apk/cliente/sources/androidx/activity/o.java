package androidx.activity;

import android.app.Activity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import androidx.lifecycle.i;
import java.lang.reflect.Field;
/* loaded from: classes.dex */
final class o implements androidx.lifecycle.k {

    /* renamed from: b  reason: collision with root package name */
    private static int f149b;

    /* renamed from: c  reason: collision with root package name */
    private static Field f150c;

    /* renamed from: d  reason: collision with root package name */
    private static Field f151d;

    /* renamed from: e  reason: collision with root package name */
    private static Field f152e;

    /* renamed from: a  reason: collision with root package name */
    private Activity f153a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(Activity activity) {
        this.f153a = activity;
    }

    private static void h() {
        try {
            f149b = 2;
            Field declaredField = InputMethodManager.class.getDeclaredField("mServedView");
            f151d = declaredField;
            declaredField.setAccessible(true);
            Field declaredField2 = InputMethodManager.class.getDeclaredField("mNextServedView");
            f152e = declaredField2;
            declaredField2.setAccessible(true);
            Field declaredField3 = InputMethodManager.class.getDeclaredField("mH");
            f150c = declaredField3;
            declaredField3.setAccessible(true);
            f149b = 1;
        } catch (NoSuchFieldException unused) {
        }
    }

    @Override // androidx.lifecycle.k
    public void d(androidx.lifecycle.m mVar, i.a aVar) {
        if (aVar != i.a.ON_DESTROY) {
            return;
        }
        if (f149b == 0) {
            h();
        }
        if (f149b == 1) {
            InputMethodManager inputMethodManager = (InputMethodManager) this.f153a.getSystemService("input_method");
            try {
                Object obj = f150c.get(inputMethodManager);
                if (obj == null) {
                    return;
                }
                synchronized (obj) {
                    try {
                        try {
                            View view = (View) f151d.get(inputMethodManager);
                            if (view == null) {
                                return;
                            }
                            if (view.isAttachedToWindow()) {
                                return;
                            }
                            try {
                                f152e.set(inputMethodManager, null);
                                inputMethodManager.isActive();
                            } catch (IllegalAccessException unused) {
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    } catch (ClassCastException unused2) {
                    } catch (IllegalAccessException unused3) {
                    }
                }
            } catch (IllegalAccessException unused4) {
            }
        }
    }
}
