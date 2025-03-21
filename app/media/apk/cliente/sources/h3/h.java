package h3;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.view.View;
import android.view.ViewGroup;
import c0.k;
import c0.l;
/* loaded from: classes.dex */
public final class h {

    /* loaded from: classes.dex */
    public interface a {
        void a(float f5, float f6, float f7);
    }

    /* loaded from: classes.dex */
    public interface b {
        boolean a(View view);
    }

    public static void c(Context context, a aVar) {
        Activity e5 = e(context);
        if (e5 != null) {
            k a5 = l.a().a(e5);
            aVar.a(a5.a().width(), a5.a().height(), context.getResources().getDisplayMetrics().density);
        }
    }

    public static boolean d(View view) {
        return i(view, new b() { // from class: h3.f
            @Override // h3.h.b
            public final boolean a(View view2) {
                boolean hasFocus;
                hasFocus = view2.hasFocus();
                return hasFocus;
            }
        });
    }

    public static Activity e(Context context) {
        if (context == null) {
            return null;
        }
        if (context instanceof Activity) {
            return (Activity) context;
        }
        if (context instanceof ContextWrapper) {
            return e(((ContextWrapper) context).getBaseContext());
        }
        return null;
    }

    public static boolean f(View view, final Class<? extends View>[] clsArr) {
        return i(view, new b() { // from class: h3.g
            @Override // h3.h.b
            public final boolean a(View view2) {
                boolean h5;
                h5 = h.h(clsArr, view2);
                return h5;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean h(Class[] clsArr, View view) {
        for (Class cls : clsArr) {
            if (cls.isInstance(view)) {
                return true;
            }
        }
        return false;
    }

    public static boolean i(View view, b bVar) {
        if (view == null) {
            return false;
        }
        if (bVar.a(view)) {
            return true;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i5 = 0; i5 < viewGroup.getChildCount(); i5++) {
                if (i(viewGroup.getChildAt(i5), bVar)) {
                    return true;
                }
            }
        }
        return false;
    }
}
