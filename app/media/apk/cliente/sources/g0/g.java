package g0;

import android.graphics.Point;
import android.view.Display;
import e4.k;
/* loaded from: classes.dex */
public final class g {

    /* renamed from: a  reason: collision with root package name */
    public static final g f3055a = new g();

    private g() {
    }

    public final void a(Display display, Point point) {
        k.e(display, "display");
        k.e(point, "point");
        display.getRealSize(point);
    }
}
