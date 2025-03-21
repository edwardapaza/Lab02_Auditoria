package p;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.ViewGroup;
import e4.k;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import o.l0;
import o.s;
import p.d;
import t3.h0;
import t3.n0;
import t3.x;
/* loaded from: classes.dex */
public final class d {

    /* renamed from: a  reason: collision with root package name */
    public static final d f6855a = new d();

    /* renamed from: b  reason: collision with root package name */
    private static c f6856b = c.f6868e;

    /* loaded from: classes.dex */
    public enum a {
        PENALTY_LOG,
        PENALTY_DEATH,
        DETECT_FRAGMENT_REUSE,
        DETECT_FRAGMENT_TAG_USAGE,
        DETECT_WRONG_NESTED_HIERARCHY,
        DETECT_RETAIN_INSTANCE_USAGE,
        DETECT_SET_USER_VISIBLE_HINT,
        DETECT_TARGET_FRAGMENT_USAGE,
        DETECT_WRONG_FRAGMENT_CONTAINER
    }

    /* loaded from: classes.dex */
    public interface b {
        void a(h hVar);
    }

    /* loaded from: classes.dex */
    public static final class c {

        /* renamed from: d  reason: collision with root package name */
        public static final a f6867d = new a(null);

        /* renamed from: e  reason: collision with root package name */
        public static final c f6868e;

        /* renamed from: a  reason: collision with root package name */
        private final Set<a> f6869a;

        /* renamed from: b  reason: collision with root package name */
        private final b f6870b;

        /* renamed from: c  reason: collision with root package name */
        private final Map<String, Set<Class<? extends h>>> f6871c;

        /* loaded from: classes.dex */
        public static final class a {
            private a() {
            }

            public /* synthetic */ a(e4.g gVar) {
                this();
            }
        }

        static {
            Set b5;
            Map d5;
            b5 = n0.b();
            d5 = h0.d();
            f6868e = new c(b5, null, d5);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public c(Set<? extends a> set, b bVar, Map<String, ? extends Set<Class<? extends h>>> map) {
            k.e(set, "flags");
            k.e(map, "allowedViolations");
            this.f6869a = set;
            this.f6870b = bVar;
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry<String, ? extends Set<Class<? extends h>>> entry : map.entrySet()) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
            this.f6871c = linkedHashMap;
        }

        public final Set<a> a() {
            return this.f6869a;
        }

        public final b b() {
            return this.f6870b;
        }

        public final Map<String, Set<Class<? extends h>>> c() {
            return this.f6871c;
        }
    }

    private d() {
    }

    private final c c(s sVar) {
        while (sVar != null) {
            if (sVar.Z()) {
                l0 H = sVar.H();
                k.d(H, "declaringFragment.parentFragmentManager");
                if (H.B0() != null) {
                    c B0 = H.B0();
                    k.b(B0);
                    return B0;
                }
            }
            sVar = sVar.G();
        }
        return f6856b;
    }

    private final void d(final c cVar, final h hVar) {
        s a5 = hVar.a();
        final String name = a5.getClass().getName();
        if (cVar.a().contains(a.PENALTY_LOG)) {
            Log.d("FragmentStrictMode", "Policy violation in " + name, hVar);
        }
        if (cVar.b() != null) {
            m(a5, new Runnable() { // from class: p.b
                @Override // java.lang.Runnable
                public final void run() {
                    d.e(d.c.this, hVar);
                }
            });
        }
        if (cVar.a().contains(a.PENALTY_DEATH)) {
            m(a5, new Runnable() { // from class: p.c
                @Override // java.lang.Runnable
                public final void run() {
                    d.f(name, hVar);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(c cVar, h hVar) {
        k.e(cVar, "$policy");
        k.e(hVar, "$violation");
        cVar.b().a(hVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(String str, h hVar) {
        k.e(hVar, "$violation");
        Log.e("FragmentStrictMode", "Policy violation with PENALTY_DEATH in " + str, hVar);
        throw hVar;
    }

    private final void g(h hVar) {
        if (l0.I0(3)) {
            Log.d("FragmentManager", "StrictMode violation in " + hVar.a().getClass().getName(), hVar);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void h(s sVar, String str) {
        k.e(sVar, "fragment");
        k.e(str, "previousFragmentId");
        p.a aVar = new p.a(sVar, str);
        d dVar = f6855a;
        dVar.g(aVar);
        c c5 = dVar.c(sVar);
        if (c5.a().contains(a.DETECT_FRAGMENT_REUSE) && dVar.n(c5, sVar.getClass(), aVar.getClass())) {
            dVar.d(c5, aVar);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void i(s sVar, ViewGroup viewGroup) {
        k.e(sVar, "fragment");
        e eVar = new e(sVar, viewGroup);
        d dVar = f6855a;
        dVar.g(eVar);
        c c5 = dVar.c(sVar);
        if (c5.a().contains(a.DETECT_FRAGMENT_TAG_USAGE) && dVar.n(c5, sVar.getClass(), eVar.getClass())) {
            dVar.d(c5, eVar);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void j(s sVar) {
        k.e(sVar, "fragment");
        f fVar = new f(sVar);
        d dVar = f6855a;
        dVar.g(fVar);
        c c5 = dVar.c(sVar);
        if (c5.a().contains(a.DETECT_TARGET_FRAGMENT_USAGE) && dVar.n(c5, sVar.getClass(), fVar.getClass())) {
            dVar.d(c5, fVar);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void k(s sVar, ViewGroup viewGroup) {
        k.e(sVar, "fragment");
        k.e(viewGroup, "container");
        i iVar = new i(sVar, viewGroup);
        d dVar = f6855a;
        dVar.g(iVar);
        c c5 = dVar.c(sVar);
        if (c5.a().contains(a.DETECT_WRONG_FRAGMENT_CONTAINER) && dVar.n(c5, sVar.getClass(), iVar.getClass())) {
            dVar.d(c5, iVar);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void l(s sVar, s sVar2, int i5) {
        k.e(sVar, "fragment");
        k.e(sVar2, "expectedParentFragment");
        j jVar = new j(sVar, sVar2, i5);
        d dVar = f6855a;
        dVar.g(jVar);
        c c5 = dVar.c(sVar);
        if (c5.a().contains(a.DETECT_WRONG_NESTED_HIERARCHY) && dVar.n(c5, sVar.getClass(), jVar.getClass())) {
            dVar.d(c5, jVar);
        }
    }

    private final void m(s sVar, Runnable runnable) {
        if (sVar.Z()) {
            Handler w5 = sVar.H().v0().w();
            if (!k.a(w5.getLooper(), Looper.myLooper())) {
                w5.post(runnable);
                return;
            }
        }
        runnable.run();
    }

    private final boolean n(c cVar, Class<? extends s> cls, Class<? extends h> cls2) {
        boolean o5;
        Set<Class<? extends h>> set = cVar.c().get(cls.getName());
        if (set == null) {
            return true;
        }
        if (!k.a(cls2.getSuperclass(), h.class)) {
            o5 = x.o(set, cls2.getSuperclass());
            if (o5) {
                return false;
            }
        }
        return !set.contains(cls2);
    }
}
