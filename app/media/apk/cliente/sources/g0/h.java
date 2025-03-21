package g0;

import android.view.DisplayCutout;
import e4.k;
/* loaded from: classes.dex */
public final class h {

    /* renamed from: a  reason: collision with root package name */
    public static final h f3056a = new h();

    private h() {
    }

    public final int a(DisplayCutout displayCutout) {
        k.e(displayCutout, "displayCutout");
        return displayCutout.getSafeInsetBottom();
    }

    public final int b(DisplayCutout displayCutout) {
        k.e(displayCutout, "displayCutout");
        return displayCutout.getSafeInsetLeft();
    }

    public final int c(DisplayCutout displayCutout) {
        k.e(displayCutout, "displayCutout");
        return displayCutout.getSafeInsetRight();
    }

    public final int d(DisplayCutout displayCutout) {
        k.e(displayCutout, "displayCutout");
        return displayCutout.getSafeInsetTop();
    }
}
