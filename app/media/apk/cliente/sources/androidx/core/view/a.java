package androidx.core.view;

import android.graphics.Rect;
import android.os.Build;
import android.view.DisplayCutout;
import java.util.List;
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private final DisplayCutout f438a;

    /* renamed from: androidx.core.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    static class C0016a {
        static DisplayCutout a(Rect rect, List<Rect> list) {
            return new DisplayCutout(rect, list);
        }

        static List<Rect> b(DisplayCutout displayCutout) {
            return displayCutout.getBoundingRects();
        }

        static int c(DisplayCutout displayCutout) {
            return displayCutout.getSafeInsetBottom();
        }

        static int d(DisplayCutout displayCutout) {
            return displayCutout.getSafeInsetLeft();
        }

        static int e(DisplayCutout displayCutout) {
            return displayCutout.getSafeInsetRight();
        }

        static int f(DisplayCutout displayCutout) {
            return displayCutout.getSafeInsetTop();
        }
    }

    private a(DisplayCutout displayCutout) {
        this.f438a = displayCutout;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a e(DisplayCutout displayCutout) {
        if (displayCutout == null) {
            return null;
        }
        return new a(displayCutout);
    }

    public int a() {
        if (Build.VERSION.SDK_INT >= 28) {
            return C0016a.c(this.f438a);
        }
        return 0;
    }

    public int b() {
        if (Build.VERSION.SDK_INT >= 28) {
            return C0016a.d(this.f438a);
        }
        return 0;
    }

    public int c() {
        if (Build.VERSION.SDK_INT >= 28) {
            return C0016a.e(this.f438a);
        }
        return 0;
    }

    public int d() {
        if (Build.VERSION.SDK_INT >= 28) {
            return C0016a.f(this.f438a);
        }
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || a.class != obj.getClass()) {
            return false;
        }
        return k.c.a(this.f438a, ((a) obj).f438a);
    }

    public int hashCode() {
        DisplayCutout displayCutout = this.f438a;
        if (displayCutout == null) {
            return 0;
        }
        return displayCutout.hashCode();
    }

    public String toString() {
        return "DisplayCutoutCompat{" + this.f438a + "}";
    }
}
