package m4;

import v3.g;
/* loaded from: classes.dex */
public final class f0 {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class a extends e4.l implements d4.p<v3.g, g.b, v3.g> {

        /* renamed from: a  reason: collision with root package name */
        public static final a f6225a = new a();

        a() {
            super(2);
        }

        @Override // d4.p
        /* renamed from: a */
        public final v3.g invoke(v3.g gVar, g.b bVar) {
            return bVar instanceof e0 ? gVar.J(((e0) bVar).r()) : gVar.J(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class b extends e4.l implements d4.p<v3.g, g.b, v3.g> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ e4.r<v3.g> f6226a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ boolean f6227b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(e4.r<v3.g> rVar, boolean z4) {
            super(2);
            this.f6226a = rVar;
            this.f6227b = z4;
        }

        /* JADX WARN: Type inference failed for: r2v2, types: [v3.g, T] */
        @Override // d4.p
        /* renamed from: a */
        public final v3.g invoke(v3.g gVar, g.b bVar) {
            if (bVar instanceof e0) {
                g.b d5 = this.f6226a.f2939a.d(bVar.getKey());
                if (d5 != null) {
                    e4.r<v3.g> rVar = this.f6226a;
                    rVar.f2939a = rVar.f2939a.c0(bVar.getKey());
                    return gVar.J(((e0) bVar).K(d5));
                }
                e0 e0Var = (e0) bVar;
                if (this.f6227b) {
                    e0Var = e0Var.r();
                }
                return gVar.J(e0Var);
            }
            return gVar.J(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class c extends e4.l implements d4.p<Boolean, g.b, Boolean> {

        /* renamed from: a  reason: collision with root package name */
        public static final c f6228a = new c();

        c() {
            super(2);
        }

        public final Boolean a(boolean z4, g.b bVar) {
            return Boolean.valueOf(z4 || (bVar instanceof e0));
        }

        @Override // d4.p
        public /* bridge */ /* synthetic */ Boolean invoke(Boolean bool, g.b bVar) {
            return a(bool.booleanValue(), bVar);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v4, types: [T, java.lang.Object] */
    private static final v3.g a(v3.g gVar, v3.g gVar2, boolean z4) {
        boolean c5 = c(gVar);
        boolean c6 = c(gVar2);
        if (c5 || c6) {
            e4.r rVar = new e4.r();
            rVar.f2939a = gVar2;
            v3.h hVar = v3.h.f8175a;
            v3.g gVar3 = (v3.g) gVar.e0(hVar, new b(rVar, z4));
            if (c6) {
                rVar.f2939a = ((v3.g) rVar.f2939a).e0(hVar, a.f6225a);
            }
            return gVar3.J((v3.g) rVar.f2939a);
        }
        return gVar.J(gVar2);
    }

    public static final String b(v3.g gVar) {
        return null;
    }

    private static final boolean c(v3.g gVar) {
        return ((Boolean) gVar.e0(Boolean.FALSE, c.f6228a)).booleanValue();
    }

    public static final v3.g d(j0 j0Var, v3.g gVar) {
        v3.g a5 = a(j0Var.b(), gVar, true);
        return (a5 == z0.a() || a5.d(v3.e.f8172j) != null) ? a5 : a5.J(z0.a());
    }

    public static final v3.g e(v3.g gVar, v3.g gVar2) {
        return !c(gVar2) ? gVar.J(gVar2) : a(gVar, gVar2, false);
    }

    public static final z2<?> f(kotlin.coroutines.jvm.internal.e eVar) {
        while (!(eVar instanceof v0) && (eVar = eVar.getCallerFrame()) != null) {
            if (eVar instanceof z2) {
                return (z2) eVar;
            }
        }
        return null;
    }

    public static final z2<?> g(v3.d<?> dVar, v3.g gVar, Object obj) {
        if (dVar instanceof kotlin.coroutines.jvm.internal.e) {
            if (gVar.d(a3.f6180a) != null) {
                z2<?> f5 = f((kotlin.coroutines.jvm.internal.e) dVar);
                if (f5 != null) {
                    f5.Y0(gVar, obj);
                }
                return f5;
            }
            return null;
        }
        return null;
    }
}
