package o;

import android.view.View;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public final class u0 {

    /* renamed from: a  reason: collision with root package name */
    public static final u0 f6689a;

    /* renamed from: b  reason: collision with root package name */
    public static final w0 f6690b;

    /* renamed from: c  reason: collision with root package name */
    public static final w0 f6691c;

    static {
        u0 u0Var = new u0();
        f6689a = u0Var;
        f6690b = new v0();
        f6691c = u0Var.c();
    }

    private u0() {
    }

    public static final void a(s sVar, s sVar2, boolean z4, androidx.collection.a<String, View> aVar, boolean z5) {
        e4.k.e(sVar, "inFragment");
        e4.k.e(sVar2, "outFragment");
        e4.k.e(aVar, "sharedElements");
        androidx.core.app.c1 x4 = z4 ? sVar2.x() : sVar.x();
        if (x4 != null) {
            ArrayList arrayList = new ArrayList(aVar.size());
            for (Map.Entry<String, View> entry : aVar.entrySet()) {
                arrayList.add(entry.getValue());
            }
            ArrayList arrayList2 = new ArrayList(aVar.size());
            for (Map.Entry<String, View> entry2 : aVar.entrySet()) {
                arrayList2.add(entry2.getKey());
            }
            if (z5) {
                x4.c(arrayList2, arrayList, null);
            } else {
                x4.b(arrayList2, arrayList, null);
            }
        }
    }

    public static final String b(androidx.collection.a<String, String> aVar, String str) {
        Object r5;
        e4.k.e(aVar, "<this>");
        e4.k.e(str, "value");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, String> entry : aVar.entrySet()) {
            if (e4.k.a(entry.getValue(), str)) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        ArrayList arrayList = new ArrayList(linkedHashMap.size());
        for (Map.Entry entry2 : linkedHashMap.entrySet()) {
            arrayList.add((String) entry2.getKey());
        }
        r5 = t3.x.r(arrayList);
        return (String) r5;
    }

    private final w0 c() {
        try {
            Class<?> cls = Class.forName("androidx.transition.FragmentTransitionSupport");
            e4.k.c(cls, "null cannot be cast to non-null type java.lang.Class<androidx.fragment.app.FragmentTransitionImpl>");
            return (w0) cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }

    public static final void d(androidx.collection.a<String, String> aVar, androidx.collection.a<String, View> aVar2) {
        e4.k.e(aVar, "<this>");
        e4.k.e(aVar2, "namedViews");
        int size = aVar.size();
        while (true) {
            size--;
            if (-1 >= size) {
                return;
            }
            if (!aVar2.containsKey(aVar.l(size))) {
                aVar.j(size);
            }
        }
    }

    public static final void e(List<? extends View> list, int i5) {
        e4.k.e(list, "views");
        for (View view : list) {
            view.setVisibility(i5);
        }
    }
}
