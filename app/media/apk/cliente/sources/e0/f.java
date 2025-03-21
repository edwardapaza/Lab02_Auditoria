package e0;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import androidx.window.extensions.layout.FoldingFeature;
import androidx.window.extensions.layout.WindowLayoutInfo;
import c0.c;
import c0.d;
import c0.j;
import c0.k;
import c0.n;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public final class f {

    /* renamed from: a  reason: collision with root package name */
    public static final f f2647a = new f();

    private f() {
    }

    private final boolean d(k kVar, z.b bVar) {
        Rect a5 = kVar.a();
        if (bVar.e()) {
            return false;
        }
        if (bVar.d() == a5.width() || bVar.a() == a5.height()) {
            if (bVar.d() >= a5.width() || bVar.a() >= a5.height()) {
                return (bVar.d() == a5.width() && bVar.a() == a5.height()) ? false : true;
            }
            return false;
        }
        return false;
    }

    public final c0.c a(k kVar, FoldingFeature foldingFeature) {
        d.b a5;
        c.b bVar;
        e4.k.e(kVar, "windowMetrics");
        e4.k.e(foldingFeature, "oemFeature");
        int type = foldingFeature.getType();
        if (type == 1) {
            a5 = d.b.f797b.a();
        } else if (type != 2) {
            return null;
        } else {
            a5 = d.b.f797b.b();
        }
        int state = foldingFeature.getState();
        if (state == 1) {
            bVar = c.b.f790c;
        } else if (state != 2) {
            return null;
        } else {
            bVar = c.b.f791d;
        }
        Rect bounds = foldingFeature.getBounds();
        e4.k.d(bounds, "oemFeature.bounds");
        if (d(kVar, new z.b(bounds))) {
            Rect bounds2 = foldingFeature.getBounds();
            e4.k.d(bounds2, "oemFeature.bounds");
            return new c0.d(new z.b(bounds2), a5, bVar);
        }
        return null;
    }

    public final j b(Context context, WindowLayoutInfo windowLayoutInfo) {
        k b5;
        e4.k.e(context, "context");
        e4.k.e(windowLayoutInfo, "info");
        int i5 = Build.VERSION.SDK_INT;
        if (i5 >= 30) {
            b5 = n.f831b.c(context);
        } else if (i5 < 29 || !(context instanceof Activity)) {
            throw new UnsupportedOperationException("Display Features are only supported after Q. Display features for non-Activity contexts are not expected to be reported on devices running Q.");
        } else {
            b5 = n.f831b.b((Activity) context);
        }
        return c(b5, windowLayoutInfo);
    }

    public final j c(k kVar, WindowLayoutInfo windowLayoutInfo) {
        c0.c cVar;
        e4.k.e(kVar, "windowMetrics");
        e4.k.e(windowLayoutInfo, "info");
        List<FoldingFeature> displayFeatures = windowLayoutInfo.getDisplayFeatures();
        e4.k.d(displayFeatures, "info.displayFeatures");
        ArrayList arrayList = new ArrayList();
        for (FoldingFeature foldingFeature : displayFeatures) {
            if (foldingFeature instanceof FoldingFeature) {
                f fVar = f2647a;
                e4.k.d(foldingFeature, "feature");
                cVar = fVar.a(kVar, foldingFeature);
            } else {
                cVar = null;
            }
            if (cVar != null) {
                arrayList.add(cVar);
            }
        }
        return new j(arrayList);
    }
}
