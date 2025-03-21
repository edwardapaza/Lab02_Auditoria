package c0;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.inputmethodservice.InputMethodService;
import android.os.Build;
import android.util.Log;
import android.view.Display;
import android.view.DisplayCutout;
import android.view.WindowManager;
import androidx.core.view.c0;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import t3.p;
/* loaded from: classes.dex */
public final class n implements m {

    /* renamed from: b  reason: collision with root package name */
    public static final n f831b = new n();

    /* renamed from: c  reason: collision with root package name */
    private static final String f832c;

    /* renamed from: d  reason: collision with root package name */
    private static final ArrayList<Integer> f833d;

    static {
        ArrayList<Integer> d5;
        String simpleName = n.class.getSimpleName();
        e4.k.d(simpleName, "WindowMetricsCalculatorC…at::class.java.simpleName");
        f832c = simpleName;
        d5 = p.d(Integer.valueOf(c0.m.g()), Integer.valueOf(c0.m.f()), Integer.valueOf(c0.m.a()), Integer.valueOf(c0.m.c()), Integer.valueOf(c0.m.h()), Integer.valueOf(c0.m.e()), Integer.valueOf(c0.m.i()), Integer.valueOf(c0.m.b()));
        f833d = d5;
    }

    private n() {
    }

    private final DisplayCutout j(Display display) {
        try {
            Constructor<?> constructor = Class.forName("android.view.DisplayInfo").getConstructor(new Class[0]);
            constructor.setAccessible(true);
            Object newInstance = constructor.newInstance(new Object[0]);
            Method declaredMethod = display.getClass().getDeclaredMethod("getDisplayInfo", newInstance.getClass());
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(display, newInstance);
            Field declaredField = newInstance.getClass().getDeclaredField("displayCutout");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(newInstance);
            if (obj instanceof DisplayCutout) {
                return (DisplayCutout) obj;
            }
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchFieldException | NoSuchMethodException | InvocationTargetException e5) {
            Log.w(f832c, e5);
        }
        return null;
    }

    private final int k(Context context) {
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier("navigation_bar_height", "dimen", "android");
        if (identifier > 0) {
            return resources.getDimensionPixelSize(identifier);
        }
        return 0;
    }

    private final void m(Activity activity, Rect rect) {
        activity.getWindowManager().getDefaultDisplay().getRectSize(rect);
    }

    @Override // c0.m
    public k a(Activity activity) {
        e4.k.e(activity, "activity");
        return d(activity);
    }

    public k b(Activity activity) {
        c0 a5;
        e4.k.e(activity, "activity");
        int i5 = Build.VERSION.SDK_INT;
        Rect a6 = i5 >= 30 ? g0.f.f3054a.a(activity) : i5 >= 29 ? h(activity) : i5 >= 28 ? g(activity) : i5 >= 24 ? f(activity) : e(activity);
        if (i5 >= 30) {
            a5 = i(activity);
        } else {
            a5 = new c0.b().a();
            e4.k.d(a5, "{\n            WindowInse…ilder().build()\n        }");
        }
        return new k(new z.b(a6), a5);
    }

    public k c(Context context) {
        e4.k.e(context, "context");
        if (Build.VERSION.SDK_INT >= 30) {
            return g0.f.f3054a.c(context);
        }
        Context a5 = g0.c.f3053a.a(context);
        if (a5 instanceof Activity) {
            return b((Activity) context);
        }
        if (!(a5 instanceof InputMethodService)) {
            throw new IllegalArgumentException(context + " is not a UiContext");
        }
        Object systemService = context.getSystemService("window");
        e4.k.c(systemService, "null cannot be cast to non-null type android.view.WindowManager");
        Display defaultDisplay = ((WindowManager) systemService).getDefaultDisplay();
        e4.k.d(defaultDisplay, "wm.defaultDisplay");
        Point l5 = l(defaultDisplay);
        return new k(new Rect(0, 0, l5.x, l5.y), null, 2, null);
    }

    public k d(Context context) {
        Rect rect;
        c0 a5;
        e4.k.e(context, "context");
        int i5 = Build.VERSION.SDK_INT;
        if (i5 >= 30) {
            rect = g0.f.f3054a.d(context);
        } else {
            Object systemService = context.getSystemService("window");
            e4.k.c(systemService, "null cannot be cast to non-null type android.view.WindowManager");
            Display defaultDisplay = ((WindowManager) systemService).getDefaultDisplay();
            e4.k.d(defaultDisplay, "display");
            Point l5 = l(defaultDisplay);
            rect = new Rect(0, 0, l5.x, l5.y);
        }
        if (i5 >= 30) {
            a5 = i(context);
        } else {
            a5 = new c0.b().a();
            e4.k.d(a5, "{\n            WindowInse…ilder().build()\n        }");
        }
        return new k(new z.b(rect), a5);
    }

    public final Rect e(Activity activity) {
        int i5;
        e4.k.e(activity, "activity");
        Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
        e4.k.d(defaultDisplay, "defaultDisplay");
        Point l5 = l(defaultDisplay);
        Rect rect = new Rect();
        int i6 = l5.x;
        if (i6 == 0 || (i5 = l5.y) == 0) {
            defaultDisplay.getRectSize(rect);
        } else {
            rect.right = i6;
            rect.bottom = i5;
        }
        return rect;
    }

    public final Rect f(Activity activity) {
        e4.k.e(activity, "activity");
        Rect rect = new Rect();
        Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
        defaultDisplay.getRectSize(rect);
        if (!g0.b.f3052a.a(activity)) {
            e4.k.d(defaultDisplay, "defaultDisplay");
            Point l5 = l(defaultDisplay);
            int k5 = k(activity);
            int i5 = rect.bottom;
            if (i5 + k5 == l5.y) {
                rect.bottom = i5 + k5;
            } else {
                int i6 = rect.right;
                if (i6 + k5 == l5.x) {
                    rect.right = i6 + k5;
                }
            }
        }
        return rect;
    }

    public final Rect g(Activity activity) {
        DisplayCutout j5;
        Rect rect;
        e4.k.e(activity, "activity");
        Rect rect2 = new Rect();
        Configuration configuration = activity.getResources().getConfiguration();
        try {
            Field declaredField = Configuration.class.getDeclaredField("windowConfiguration");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(configuration);
            if (g0.b.f3052a.a(activity)) {
                Object invoke = obj.getClass().getDeclaredMethod("getBounds", new Class[0]).invoke(obj, new Object[0]);
                e4.k.c(invoke, "null cannot be cast to non-null type android.graphics.Rect");
                rect = (Rect) invoke;
            } else {
                Object invoke2 = obj.getClass().getDeclaredMethod("getAppBounds", new Class[0]).invoke(obj, new Object[0]);
                e4.k.c(invoke2, "null cannot be cast to non-null type android.graphics.Rect");
                rect = (Rect) invoke2;
            }
            rect2.set(rect);
        } catch (IllegalAccessException | NoSuchFieldException | NoSuchMethodException | InvocationTargetException e5) {
            Log.w(f832c, e5);
            m(activity, rect2);
        }
        Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
        Point point = new Point();
        g0.g gVar = g0.g.f3055a;
        e4.k.d(defaultDisplay, "currentDisplay");
        gVar.a(defaultDisplay, point);
        g0.b bVar = g0.b.f3052a;
        if (!bVar.a(activity)) {
            int k5 = k(activity);
            int i5 = rect2.bottom;
            if (i5 + k5 == point.y) {
                rect2.bottom = i5 + k5;
            } else {
                int i6 = rect2.right;
                if (i6 + k5 == point.x) {
                    rect2.right = i6 + k5;
                } else if (rect2.left == k5) {
                    rect2.left = 0;
                }
            }
        }
        if ((rect2.width() < point.x || rect2.height() < point.y) && !bVar.a(activity) && (j5 = j(defaultDisplay)) != null) {
            int i7 = rect2.left;
            g0.h hVar = g0.h.f3056a;
            if (i7 == hVar.b(j5)) {
                rect2.left = 0;
            }
            if (point.x - rect2.right == hVar.c(j5)) {
                rect2.right += hVar.c(j5);
            }
            if (rect2.top == hVar.d(j5)) {
                rect2.top = 0;
            }
            if (point.y - rect2.bottom == hVar.a(j5)) {
                rect2.bottom += hVar.a(j5);
            }
        }
        return rect2;
    }

    public final Rect h(Activity activity) {
        e4.k.e(activity, "activity");
        Configuration configuration = activity.getResources().getConfiguration();
        try {
            Field declaredField = Configuration.class.getDeclaredField("windowConfiguration");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(configuration);
            Object invoke = obj.getClass().getDeclaredMethod("getBounds", new Class[0]).invoke(obj, new Object[0]);
            e4.k.c(invoke, "null cannot be cast to non-null type android.graphics.Rect");
            return new Rect((Rect) invoke);
        } catch (IllegalAccessException | NoSuchFieldException | NoSuchMethodException | InvocationTargetException e5) {
            Log.w(f832c, e5);
            return g(activity);
        }
    }

    public final c0 i(Context context) {
        e4.k.e(context, "context");
        if (Build.VERSION.SDK_INT >= 30) {
            return g0.f.f3054a.b(context);
        }
        throw new Exception("Incompatible SDK version");
    }

    public final Point l(Display display) {
        e4.k.e(display, "display");
        Point point = new Point();
        g0.g.f3055a.a(display, point);
        return point;
    }
}
