package com.google.firebase.ktx;

import com.google.firebase.components.ComponentRegistrar;
import e4.k;
import java.util.List;
import java.util.concurrent.Executor;
import k1.e;
import k1.f0;
import k1.h;
import k1.r;
import m4.g0;
import m4.n1;
import t3.p;
/* loaded from: classes.dex */
public final class FirebaseCommonKtxRegistrar implements ComponentRegistrar {

    /* loaded from: classes.dex */
    public static final class a<T> implements h {

        /* renamed from: a  reason: collision with root package name */
        public static final a<T> f1829a = new a<>();

        @Override // k1.h
        /* renamed from: b */
        public final g0 a(e eVar) {
            Object e5 = eVar.e(f0.a(g1.a.class, Executor.class));
            k.d(e5, "c.get(Qualified.qualifie…a, Executor::class.java))");
            return n1.a((Executor) e5);
        }
    }

    /* loaded from: classes.dex */
    public static final class b<T> implements h {

        /* renamed from: a  reason: collision with root package name */
        public static final b<T> f1830a = new b<>();

        @Override // k1.h
        /* renamed from: b */
        public final g0 a(e eVar) {
            Object e5 = eVar.e(f0.a(g1.c.class, Executor.class));
            k.d(e5, "c.get(Qualified.qualifie…a, Executor::class.java))");
            return n1.a((Executor) e5);
        }
    }

    /* loaded from: classes.dex */
    public static final class c<T> implements h {

        /* renamed from: a  reason: collision with root package name */
        public static final c<T> f1831a = new c<>();

        @Override // k1.h
        /* renamed from: b */
        public final g0 a(e eVar) {
            Object e5 = eVar.e(f0.a(g1.b.class, Executor.class));
            k.d(e5, "c.get(Qualified.qualifie…a, Executor::class.java))");
            return n1.a((Executor) e5);
        }
    }

    /* loaded from: classes.dex */
    public static final class d<T> implements h {

        /* renamed from: a  reason: collision with root package name */
        public static final d<T> f1832a = new d<>();

        @Override // k1.h
        /* renamed from: b */
        public final g0 a(e eVar) {
            Object e5 = eVar.e(f0.a(g1.d.class, Executor.class));
            k.d(e5, "c.get(Qualified.qualifie…a, Executor::class.java))");
            return n1.a((Executor) e5);
        }
    }

    @Override // com.google.firebase.components.ComponentRegistrar
    public List<k1.c<?>> getComponents() {
        List<k1.c<?>> h5;
        k1.c c5 = k1.c.e(f0.a(g1.a.class, g0.class)).b(r.k(f0.a(g1.a.class, Executor.class))).d(a.f1829a).c();
        k.d(c5, "builder(Qualified.qualif…cher()\n    }\n    .build()");
        k1.c c6 = k1.c.e(f0.a(g1.c.class, g0.class)).b(r.k(f0.a(g1.c.class, Executor.class))).d(b.f1830a).c();
        k.d(c6, "builder(Qualified.qualif…cher()\n    }\n    .build()");
        k1.c c7 = k1.c.e(f0.a(g1.b.class, g0.class)).b(r.k(f0.a(g1.b.class, Executor.class))).d(c.f1831a).c();
        k.d(c7, "builder(Qualified.qualif…cher()\n    }\n    .build()");
        k1.c c8 = k1.c.e(f0.a(g1.d.class, g0.class)).b(r.k(f0.a(g1.d.class, Executor.class))).d(d.f1832a).c();
        k.d(c8, "builder(Qualified.qualif…cher()\n    }\n    .build()");
        h5 = p.h(c5, c6, c7, c8);
        return h5;
    }
}
