package androidx.core.content.res;

import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import java.util.WeakHashMap;
/* loaded from: classes.dex */
public final class g {

    /* renamed from: a  reason: collision with root package name */
    private static final ThreadLocal<TypedValue> f385a = new ThreadLocal<>();

    /* renamed from: b  reason: collision with root package name */
    private static final WeakHashMap<c, SparseArray<b>> f386b = new WeakHashMap<>(0);

    /* renamed from: c  reason: collision with root package name */
    private static final Object f387c = new Object();

    /* loaded from: classes.dex */
    static class a {
        static int a(Resources resources, int i5, Resources.Theme theme) {
            int color;
            color = resources.getColor(i5, theme);
            return color;
        }

        static ColorStateList b(Resources resources, int i5, Resources.Theme theme) {
            ColorStateList colorStateList;
            colorStateList = resources.getColorStateList(i5, theme);
            return colorStateList;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        final ColorStateList f388a;

        /* renamed from: b  reason: collision with root package name */
        final Configuration f389b;

        /* renamed from: c  reason: collision with root package name */
        final int f390c;

        b(ColorStateList colorStateList, Configuration configuration, Resources.Theme theme) {
            this.f388a = colorStateList;
            this.f389b = configuration;
            this.f390c = theme == null ? 0 : theme.hashCode();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        final Resources f391a;

        /* renamed from: b  reason: collision with root package name */
        final Resources.Theme f392b;

        c(Resources resources, Resources.Theme theme) {
            this.f391a = resources;
            this.f392b = theme;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || c.class != obj.getClass()) {
                return false;
            }
            c cVar = (c) obj;
            return this.f391a.equals(cVar.f391a) && k.c.a(this.f392b, cVar.f392b);
        }

        public int hashCode() {
            return k.c.b(this.f391a, this.f392b);
        }
    }

    private static void a(c cVar, int i5, ColorStateList colorStateList, Resources.Theme theme) {
        synchronized (f387c) {
            WeakHashMap<c, SparseArray<b>> weakHashMap = f386b;
            SparseArray<b> sparseArray = weakHashMap.get(cVar);
            if (sparseArray == null) {
                sparseArray = new SparseArray<>();
                weakHashMap.put(cVar, sparseArray);
            }
            sparseArray.append(i5, new b(colorStateList, cVar.f391a.getConfiguration(), theme));
        }
    }

    private static ColorStateList b(c cVar, int i5) {
        b bVar;
        Resources.Theme theme;
        synchronized (f387c) {
            SparseArray<b> sparseArray = f386b.get(cVar);
            if (sparseArray != null && sparseArray.size() > 0 && (bVar = sparseArray.get(i5)) != null) {
                if (bVar.f389b.equals(cVar.f391a.getConfiguration()) && (((theme = cVar.f392b) == null && bVar.f390c == 0) || (theme != null && bVar.f390c == theme.hashCode()))) {
                    return bVar.f388a;
                }
                sparseArray.remove(i5);
            }
            return null;
        }
    }

    public static ColorStateList c(Resources resources, int i5, Resources.Theme theme) {
        c cVar = new c(resources, theme);
        ColorStateList b5 = b(cVar, i5);
        if (b5 != null) {
            return b5;
        }
        ColorStateList e5 = e(resources, i5, theme);
        if (e5 == null) {
            return Build.VERSION.SDK_INT >= 23 ? a.b(resources, i5, theme) : resources.getColorStateList(i5);
        }
        a(cVar, i5, e5, theme);
        return e5;
    }

    private static TypedValue d() {
        ThreadLocal<TypedValue> threadLocal = f385a;
        TypedValue typedValue = threadLocal.get();
        if (typedValue == null) {
            TypedValue typedValue2 = new TypedValue();
            threadLocal.set(typedValue2);
            return typedValue2;
        }
        return typedValue;
    }

    private static ColorStateList e(Resources resources, int i5, Resources.Theme theme) {
        if (f(resources, i5)) {
            return null;
        }
        try {
            return androidx.core.content.res.c.a(resources, resources.getXml(i5), theme);
        } catch (Exception e5) {
            Log.w("ResourcesCompat", "Failed to inflate ColorStateList, leaving it to the framework", e5);
            return null;
        }
    }

    private static boolean f(Resources resources, int i5) {
        TypedValue d5 = d();
        resources.getValue(i5, d5, true);
        int i6 = d5.type;
        return i6 >= 28 && i6 <= 31;
    }
}
