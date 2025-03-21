package i3;

import i3.g;
import java.util.List;
/* loaded from: classes.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    private static final g<Object, Object> f3423a = new a();

    /* loaded from: classes.dex */
    class a extends g<Object, Object> {
        a() {
        }

        @Override // i3.g
        public void a(String str, Throwable th) {
        }

        @Override // i3.g
        public void b() {
        }

        @Override // i3.g
        public void c(int i5) {
        }

        @Override // i3.g
        public void d(Object obj) {
        }

        @Override // i3.g
        public void e(g.a<Object> aVar, y0 y0Var) {
        }
    }

    /* loaded from: classes.dex */
    private static class b extends d {

        /* renamed from: a  reason: collision with root package name */
        private final d f3424a;

        /* renamed from: b  reason: collision with root package name */
        private final h f3425b;

        private b(d dVar, h hVar) {
            this.f3424a = dVar;
            this.f3425b = (h) z0.k.o(hVar, "interceptor");
        }

        /* synthetic */ b(d dVar, h hVar, i iVar) {
            this(dVar, hVar);
        }

        @Override // i3.d
        public String a() {
            return this.f3424a.a();
        }

        @Override // i3.d
        public <ReqT, RespT> g<ReqT, RespT> d(z0<ReqT, RespT> z0Var, c cVar) {
            return this.f3425b.a(z0Var, cVar, this.f3424a);
        }
    }

    public static d a(d dVar, List<? extends h> list) {
        z0.k.o(dVar, "channel");
        for (h hVar : list) {
            dVar = new b(dVar, hVar, null);
        }
        return dVar;
    }
}
