package i3;

import i3.c;
/* loaded from: classes.dex */
public abstract class k extends m1 {

    /* renamed from: a  reason: collision with root package name */
    public static final c.C0069c<Boolean> f3476a = c.C0069c.c("io.grpc.ClientStreamTracer.NAME_RESOLUTION_DELAYED", Boolean.FALSE);

    /* loaded from: classes.dex */
    public static abstract class a {
        public k a(b bVar, y0 y0Var) {
            throw new UnsupportedOperationException("Not implemented");
        }
    }

    /* loaded from: classes.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private final c f3477a;

        /* renamed from: b  reason: collision with root package name */
        private final int f3478b;

        /* renamed from: c  reason: collision with root package name */
        private final boolean f3479c;

        /* loaded from: classes.dex */
        public static final class a {

            /* renamed from: a  reason: collision with root package name */
            private c f3480a = c.f3343k;

            /* renamed from: b  reason: collision with root package name */
            private int f3481b;

            /* renamed from: c  reason: collision with root package name */
            private boolean f3482c;

            a() {
            }

            public b a() {
                return new b(this.f3480a, this.f3481b, this.f3482c);
            }

            public a b(c cVar) {
                this.f3480a = (c) z0.k.o(cVar, "callOptions cannot be null");
                return this;
            }

            public a c(boolean z4) {
                this.f3482c = z4;
                return this;
            }

            public a d(int i5) {
                this.f3481b = i5;
                return this;
            }
        }

        b(c cVar, int i5, boolean z4) {
            this.f3477a = (c) z0.k.o(cVar, "callOptions");
            this.f3478b = i5;
            this.f3479c = z4;
        }

        public static a a() {
            return new a();
        }

        public String toString() {
            return z0.f.b(this).d("callOptions", this.f3477a).b("previousAttempts", this.f3478b).e("isTransparentRetry", this.f3479c).toString();
        }
    }

    public void j() {
    }

    public void k() {
    }

    public void l(y0 y0Var) {
    }

    public void m() {
    }

    public void n(i3.a aVar, y0 y0Var) {
    }
}
