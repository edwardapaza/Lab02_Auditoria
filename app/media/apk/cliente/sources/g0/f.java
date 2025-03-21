package g0;

import android.content.Context;
import android.graphics.Rect;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.WindowMetrics;
import androidx.core.view.c0;
import e4.k;
/* loaded from: classes.dex */
public final class f {

    /* renamed from: a  reason: collision with root package name */
    public static final f f3054a = new f();

    private f() {
    }

    public final Rect a(Context context) {
        Object systemService;
        WindowMetrics currentWindowMetrics;
        k.e(context, "context");
        systemService = context.getSystemService(WindowManager.class);
        currentWindowMetrics = ((WindowManager) systemService).getCurrentWindowMetrics();
        Rect bounds = currentWindowMetrics.getBounds();
        k.d(bounds, "wm.currentWindowMetrics.bounds");
        return bounds;
    }

    public final c0 b(Context context) {
        Object systemService;
        WindowMetrics currentWindowMetrics;
        k.e(context, "context");
        systemService = context.getSystemService(WindowManager.class);
        currentWindowMetrics = ((WindowManager) systemService).getCurrentWindowMetrics();
        WindowInsets windowInsets = currentWindowMetrics.getWindowInsets();
        k.d(windowInsets, "context.getSystemService…indowMetrics.windowInsets");
        c0 n5 = c0.n(windowInsets);
        k.d(n5, "toWindowInsetsCompat(platformInsets)");
        return n5;
    }

    public final c0.k c(Context context) {
        Object systemService;
        WindowMetrics currentWindowMetrics;
        WindowMetrics currentWindowMetrics2;
        k.e(context, "context");
        systemService = context.getSystemService(WindowManager.class);
        WindowManager windowManager = (WindowManager) systemService;
        currentWindowMetrics = windowManager.getCurrentWindowMetrics();
        c0 n5 = c0.n(currentWindowMetrics.getWindowInsets());
        k.d(n5, "toWindowInsetsCompat(wm.…ndowMetrics.windowInsets)");
        currentWindowMetrics2 = windowManager.getCurrentWindowMetrics();
        Rect bounds = currentWindowMetrics2.getBounds();
        k.d(bounds, "wm.currentWindowMetrics.bounds");
        return new c0.k(bounds, n5);
    }

    public final Rect d(Context context) {
        Object systemService;
        WindowMetrics maximumWindowMetrics;
        k.e(context, "context");
        systemService = context.getSystemService(WindowManager.class);
        maximumWindowMetrics = ((WindowManager) systemService).getMaximumWindowMetrics();
        Rect bounds = maximumWindowMetrics.getBounds();
        k.d(bounds, "wm.maximumWindowMetrics.bounds");
        return bounds;
    }
}
