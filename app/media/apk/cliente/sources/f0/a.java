package f0;

import android.graphics.Rect;
import androidx.window.sidecar.SidecarDeviceState;
import androidx.window.sidecar.SidecarDisplayFeature;
import androidx.window.sidecar.SidecarWindowLayoutInfo;
import c0.c;
import c0.d;
import e4.g;
import e4.k;
import e4.l;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import t3.p;
import z.h;
import z.j;
/* loaded from: classes.dex */
public final class a {

    /* renamed from: b  reason: collision with root package name */
    public static final C0051a f2956b = new C0051a(null);

    /* renamed from: c  reason: collision with root package name */
    private static final String f2957c = a.class.getSimpleName();

    /* renamed from: a  reason: collision with root package name */
    private final j f2958a;

    /* renamed from: f0.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0051a {
        private C0051a() {
        }

        public /* synthetic */ C0051a(g gVar) {
            this();
        }

        public final int a(SidecarDeviceState sidecarDeviceState) {
            k.e(sidecarDeviceState, "sidecarDeviceState");
            try {
                return sidecarDeviceState.posture;
            } catch (NoSuchFieldError unused) {
                try {
                    Object invoke = SidecarDeviceState.class.getMethod("getPosture", new Class[0]).invoke(sidecarDeviceState, new Object[0]);
                    k.c(invoke, "null cannot be cast to non-null type kotlin.Int");
                    return ((Integer) invoke).intValue();
                } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused2) {
                    return 0;
                }
            }
        }

        public final int b(SidecarDeviceState sidecarDeviceState) {
            k.e(sidecarDeviceState, "sidecarDeviceState");
            int a5 = a(sidecarDeviceState);
            if (a5 < 0 || a5 > 4) {
                return 0;
            }
            return a5;
        }

        public final List<SidecarDisplayFeature> c(SidecarWindowLayoutInfo sidecarWindowLayoutInfo) {
            List<SidecarDisplayFeature> f5;
            List<SidecarDisplayFeature> f6;
            k.e(sidecarWindowLayoutInfo, "info");
            try {
                try {
                    List<SidecarDisplayFeature> list = sidecarWindowLayoutInfo.displayFeatures;
                    if (list == null) {
                        f6 = p.f();
                        return f6;
                    }
                    return list;
                } catch (NoSuchFieldError unused) {
                    Object invoke = SidecarWindowLayoutInfo.class.getMethod("getDisplayFeatures", new Class[0]).invoke(sidecarWindowLayoutInfo, new Object[0]);
                    k.c(invoke, "null cannot be cast to non-null type kotlin.collections.List<androidx.window.sidecar.SidecarDisplayFeature>");
                    return (List) invoke;
                }
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused2) {
                f5 = p.f();
                return f5;
            }
        }

        public final void d(SidecarDeviceState sidecarDeviceState, int i5) {
            k.e(sidecarDeviceState, "sidecarDeviceState");
            try {
                try {
                    sidecarDeviceState.posture = i5;
                } catch (NoSuchFieldError unused) {
                    SidecarDeviceState.class.getMethod("setPosture", Integer.TYPE).invoke(sidecarDeviceState, Integer.valueOf(i5));
                }
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused2) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class b extends l implements d4.l<SidecarDisplayFeature, Boolean> {

        /* renamed from: a  reason: collision with root package name */
        public static final b f2959a = new b();

        b() {
            super(1);
        }

        @Override // d4.l
        /* renamed from: a */
        public final Boolean invoke(SidecarDisplayFeature sidecarDisplayFeature) {
            k.e(sidecarDisplayFeature, "$this$require");
            boolean z4 = true;
            if (sidecarDisplayFeature.getType() != 1 && sidecarDisplayFeature.getType() != 2) {
                z4 = false;
            }
            return Boolean.valueOf(z4);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class c extends l implements d4.l<SidecarDisplayFeature, Boolean> {

        /* renamed from: a  reason: collision with root package name */
        public static final c f2960a = new c();

        c() {
            super(1);
        }

        @Override // d4.l
        /* renamed from: a */
        public final Boolean invoke(SidecarDisplayFeature sidecarDisplayFeature) {
            k.e(sidecarDisplayFeature, "$this$require");
            return Boolean.valueOf((sidecarDisplayFeature.getRect().width() == 0 && sidecarDisplayFeature.getRect().height() == 0) ? false : true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class d extends l implements d4.l<SidecarDisplayFeature, Boolean> {

        /* renamed from: a  reason: collision with root package name */
        public static final d f2961a = new d();

        d() {
            super(1);
        }

        @Override // d4.l
        /* renamed from: a */
        public final Boolean invoke(SidecarDisplayFeature sidecarDisplayFeature) {
            k.e(sidecarDisplayFeature, "$this$require");
            boolean z4 = true;
            if (sidecarDisplayFeature.getType() == 1 && sidecarDisplayFeature.getRect().width() != 0 && sidecarDisplayFeature.getRect().height() != 0) {
                z4 = false;
            }
            return Boolean.valueOf(z4);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class e extends l implements d4.l<SidecarDisplayFeature, Boolean> {

        /* renamed from: a  reason: collision with root package name */
        public static final e f2962a = new e();

        e() {
            super(1);
        }

        @Override // d4.l
        /* renamed from: a */
        public final Boolean invoke(SidecarDisplayFeature sidecarDisplayFeature) {
            k.e(sidecarDisplayFeature, "$this$require");
            return Boolean.valueOf(sidecarDisplayFeature.getRect().left == 0 || sidecarDisplayFeature.getRect().top == 0);
        }
    }

    public a() {
        this(null, 1, null);
    }

    public a(j jVar) {
        k.e(jVar, "verificationMode");
        this.f2958a = jVar;
    }

    public /* synthetic */ a(j jVar, int i5, g gVar) {
        this((i5 & 1) != 0 ? j.QUIET : jVar);
    }

    private final boolean b(SidecarDisplayFeature sidecarDisplayFeature, SidecarDisplayFeature sidecarDisplayFeature2) {
        if (k.a(sidecarDisplayFeature, sidecarDisplayFeature2)) {
            return true;
        }
        if (sidecarDisplayFeature == null || sidecarDisplayFeature2 == null || sidecarDisplayFeature.getType() != sidecarDisplayFeature2.getType()) {
            return false;
        }
        return k.a(sidecarDisplayFeature.getRect(), sidecarDisplayFeature2.getRect());
    }

    private final boolean c(List<SidecarDisplayFeature> list, List<SidecarDisplayFeature> list2) {
        if (list == list2) {
            return true;
        }
        if (list == null || list2 == null || list.size() != list2.size()) {
            return false;
        }
        int size = list.size();
        for (int i5 = 0; i5 < size; i5++) {
            if (!b(list.get(i5), list2.get(i5))) {
                return false;
            }
        }
        return true;
    }

    public final boolean a(SidecarDeviceState sidecarDeviceState, SidecarDeviceState sidecarDeviceState2) {
        if (k.a(sidecarDeviceState, sidecarDeviceState2)) {
            return true;
        }
        if (sidecarDeviceState == null || sidecarDeviceState2 == null) {
            return false;
        }
        C0051a c0051a = f2956b;
        return c0051a.b(sidecarDeviceState) == c0051a.b(sidecarDeviceState2);
    }

    public final boolean d(SidecarWindowLayoutInfo sidecarWindowLayoutInfo, SidecarWindowLayoutInfo sidecarWindowLayoutInfo2) {
        if (k.a(sidecarWindowLayoutInfo, sidecarWindowLayoutInfo2)) {
            return true;
        }
        if (sidecarWindowLayoutInfo == null || sidecarWindowLayoutInfo2 == null) {
            return false;
        }
        C0051a c0051a = f2956b;
        return c(c0051a.c(sidecarWindowLayoutInfo), c0051a.c(sidecarWindowLayoutInfo2));
    }

    public final c0.j e(SidecarWindowLayoutInfo sidecarWindowLayoutInfo, SidecarDeviceState sidecarDeviceState) {
        List f5;
        k.e(sidecarDeviceState, "state");
        if (sidecarWindowLayoutInfo == null) {
            f5 = p.f();
            return new c0.j(f5);
        }
        SidecarDeviceState sidecarDeviceState2 = new SidecarDeviceState();
        C0051a c0051a = f2956b;
        c0051a.d(sidecarDeviceState2, c0051a.b(sidecarDeviceState));
        return new c0.j(f(c0051a.c(sidecarWindowLayoutInfo), sidecarDeviceState2));
    }

    public final List<c0.a> f(List<SidecarDisplayFeature> list, SidecarDeviceState sidecarDeviceState) {
        k.e(list, "sidecarDisplayFeatures");
        k.e(sidecarDeviceState, "deviceState");
        ArrayList arrayList = new ArrayList();
        for (SidecarDisplayFeature sidecarDisplayFeature : list) {
            c0.a g5 = g(sidecarDisplayFeature, sidecarDeviceState);
            if (g5 != null) {
                arrayList.add(g5);
            }
        }
        return arrayList;
    }

    public final c0.a g(SidecarDisplayFeature sidecarDisplayFeature, SidecarDeviceState sidecarDeviceState) {
        d.b a5;
        c.b bVar;
        k.e(sidecarDisplayFeature, "feature");
        k.e(sidecarDeviceState, "deviceState");
        h.a aVar = h.f8837a;
        String str = f2957c;
        k.d(str, "TAG");
        SidecarDisplayFeature sidecarDisplayFeature2 = (SidecarDisplayFeature) h.a.b(aVar, sidecarDisplayFeature, str, this.f2958a, null, 4, null).c("Type must be either TYPE_FOLD or TYPE_HINGE", b.f2959a).c("Feature bounds must not be 0", c.f2960a).c("TYPE_FOLD must have 0 area", d.f2961a).c("Feature be pinned to either left or top", e.f2962a).a();
        if (sidecarDisplayFeature2 == null) {
            return null;
        }
        int type = sidecarDisplayFeature2.getType();
        if (type == 1) {
            a5 = d.b.f797b.a();
        } else if (type != 2) {
            return null;
        } else {
            a5 = d.b.f797b.b();
        }
        int b5 = f2956b.b(sidecarDeviceState);
        if (b5 == 0 || b5 == 1) {
            return null;
        }
        if (b5 == 2) {
            bVar = c.b.f791d;
        } else if (b5 != 3 && b5 == 4) {
            return null;
        } else {
            bVar = c.b.f790c;
        }
        Rect rect = sidecarDisplayFeature.getRect();
        k.d(rect, "feature.rect");
        return new c0.d(new z.b(rect), a5, bVar);
    }
}
