package i3;

import i3.a;
import i3.r0;
/* loaded from: classes.dex */
public abstract class f0 {

    /* renamed from: a  reason: collision with root package name */
    public static final a.c<f0> f3412a = a.c.a("internal:io.grpc.config-selector");

    /* loaded from: classes.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private final j1 f3413a;

        /* renamed from: b  reason: collision with root package name */
        private final Object f3414b;

        /* renamed from: c  reason: collision with root package name */
        public h f3415c;

        /* loaded from: classes.dex */
        public static final class a {

            /* renamed from: a  reason: collision with root package name */
            private Object f3416a;

            /* renamed from: b  reason: collision with root package name */
            private h f3417b;

            private a() {
            }

            public b a() {
                z0.k.u(this.f3416a != null, "config is not set");
                return new b(j1.f3432f, this.f3416a, this.f3417b);
            }

            public a b(Object obj) {
                this.f3416a = z0.k.o(obj, "config");
                return this;
            }
        }

        private b(j1 j1Var, Object obj, h hVar) {
            this.f3413a = (j1) z0.k.o(j1Var, "status");
            this.f3414b = obj;
            this.f3415c = hVar;
        }

        public static a d() {
            return new a();
        }

        public Object a() {
            return this.f3414b;
        }

        public h b() {
            return this.f3415c;
        }

        public j1 c() {
            return this.f3413a;
        }
    }

    public abstract b a(r0.f fVar);
}
